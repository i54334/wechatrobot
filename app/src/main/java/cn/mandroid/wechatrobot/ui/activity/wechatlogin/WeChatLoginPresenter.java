package cn.mandroid.wechatrobot.ui.activity.wechatlogin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

import cn.mandroid.wechatrobot.model.common.Injection;
import cn.mandroid.wechatrobot.model.entity.dao.WechatAuthenticationBean;
import cn.mandroid.wechatrobot.model.repository.IWechatAuthenticationCloudSource;
import cn.mandroid.wechatrobot.model.repository.WechatAuthenticationRepository;
import cn.mandroid.wechatrobot.ui.activity.common.BasePresenter;

/**
 * Created by wrBug on 2017/1/1.
 */

public class WeChatLoginPresenter extends BasePresenter<WechatLoginContract.View> implements WechatLoginContract.Presenter {
    WechatAuthenticationRepository mWechatAuthenticationRepository;
    WechatAuthenticationBean mWechatAuthenticationBean;

    public WeChatLoginPresenter(WechatLoginContract.View view) {
        super(view);
        mWechatAuthenticationRepository = Injection.getWechatAuthenticationRepository();
        mWechatAuthenticationBean = new WechatAuthenticationBean();
    }

    @Override
    public void getUUID() {
        mView.setActionBarSubTitle("初始化中");
        mWechatAuthenticationRepository.getUUID(new IWechatAuthenticationCloudSource.GetUUIDCallback() {
            @Override
            public void onSuccess(String uuid) {
                getQrCode(uuid);
                getShortUrl(uuid);
                checkIsScanQrcode(uuid);
            }

            @Override
            public void onError() {
                mView.showLog("错误");
            }
        });
    }

    private void checkIsScanQrcode(final String uuid) {
        mWechatAuthenticationRepository.checkIsScanQrcode(uuid, new IWechatAuthenticationCloudSource.WaitForLoginCallback() {
            @Override
            public void onSuccess(String redirectUrl, String baseUrl) {
                mView.setActionBarSubTitle("扫码成功，请点击登录");
                checkIsClickLoginButton(uuid);
            }

            @Override
            public void onError() {
                mView.setActionBarSubTitle("登录失败");
            }
        });
    }


    private void checkIsClickLoginButton(String uuid) {
        mWechatAuthenticationRepository.checkIsClickLoginButton(uuid, new IWechatAuthenticationCloudSource.WaitForLoginCallback() {
            @Override
            public void onSuccess(String redirectUrl, String baseUrl) {
                mWechatAuthenticationBean.setRedirectUrl(redirectUrl);
                mWechatAuthenticationBean.setBaseUrl(baseUrl);
                mView.setActionBarSubTitle("正在登录");
                wechatLogin(redirectUrl);
            }

            @Override
            public void onError() {
                mView.setActionBarSubTitle("登录失败");
            }
        });
    }

    private void wechatLogin(String redirectUrl) {
        mWechatAuthenticationRepository.wechatLogin(redirectUrl, new IWechatAuthenticationCloudSource.WechatLoginCallback() {
            @Override
            public void onSuccess(String skey, String sid, String uin, String passTicket) {
                mWechatAuthenticationBean.setSkey(skey);
                mWechatAuthenticationBean.setSid(sid);
                mWechatAuthenticationBean.setUin(uin);
                mWechatAuthenticationBean.setPassTicket(passTicket);
                mView.setActionBarSubTitle("登录成功，正在获取用户信息");
            }

            @Override
            public void onError() {
                mView.setActionBarSubTitle("登录失败");
            }
        });
    }

    private void getShortUrl(String uuid) {
        mWechatAuthenticationRepository.getShortUrl(uuid, new IWechatAuthenticationCloudSource.GetShortUrlCallback() {
            @Override
            public void onSuccess(String url) {
                mView.setPcOpenNotice(url);
            }
        });
    }

    private void getQrCode(String uuid) {
        mView.setActionBarSubTitle("获取二维码");
        mWechatAuthenticationRepository.getQrcode(uuid, new IWechatAuthenticationCloudSource.GetQrcodeCallback() {
            @Override
            public void onSuccess(File file) {
                Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                mView.setQrcodeImage(bitmap);
                mView.setActionBarSubTitle("等待扫描");
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void start() {

    }
}
