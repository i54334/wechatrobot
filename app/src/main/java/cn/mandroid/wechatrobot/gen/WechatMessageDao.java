package cn.mandroid.wechatrobot.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.mandroid.wechatrobot.model.entity.dao.WechatMessage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WECHAT_MESSAGE".
*/
public class WechatMessageDao extends AbstractDao<WechatMessage, String> {

    public static final String TABLENAME = "WECHAT_MESSAGE";

    /**
     * Properties of entity WechatMessage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property MsgId = new Property(0, String.class, "MsgId", true, "MSG_ID");
        public final static Property Uin = new Property(1, long.class, "uin", false, "UIN");
        public final static Property IsFromMine = new Property(2, boolean.class, "isFromMine", false, "IS_FROM_MINE");
        public final static Property FromUserName = new Property(3, String.class, "FromUserName", false, "FROM_USER_NAME");
        public final static Property ToUserName = new Property(4, String.class, "ToUserName", false, "TO_USER_NAME");
        public final static Property MsgType = new Property(5, long.class, "MsgType", false, "MSG_TYPE");
        public final static Property Content = new Property(6, String.class, "Content", false, "CONTENT");
        public final static Property Status = new Property(7, long.class, "Status", false, "STATUS");
        public final static Property ImgStatus = new Property(8, long.class, "ImgStatus", false, "IMG_STATUS");
        public final static Property CreateTime = new Property(9, long.class, "CreateTime", false, "CREATE_TIME");
        public final static Property VoiceLength = new Property(10, long.class, "VoiceLength", false, "VOICE_LENGTH");
        public final static Property PlayLength = new Property(11, long.class, "PlayLength", false, "PLAY_LENGTH");
        public final static Property FileName = new Property(12, String.class, "FileName", false, "FILE_NAME");
        public final static Property FileSize = new Property(13, String.class, "FileSize", false, "FILE_SIZE");
        public final static Property MediaId = new Property(14, String.class, "MediaId", false, "MEDIA_ID");
        public final static Property Url = new Property(15, String.class, "Url", false, "URL");
        public final static Property AppMsgType = new Property(16, long.class, "AppMsgType", false, "APP_MSG_TYPE");
        public final static Property StatusNotifyCode = new Property(17, long.class, "StatusNotifyCode", false, "STATUS_NOTIFY_CODE");
        public final static Property StatusNotifyUserName = new Property(18, String.class, "StatusNotifyUserName", false, "STATUS_NOTIFY_USER_NAME");
        public final static Property ForwardFlag = new Property(19, long.class, "ForwardFlag", false, "FORWARD_FLAG");
        public final static Property HasProductId = new Property(20, long.class, "HasProductId", false, "HAS_PRODUCT_ID");
        public final static Property Ticket = new Property(21, String.class, "Ticket", false, "TICKET");
        public final static Property ImgHeight = new Property(22, long.class, "ImgHeight", false, "IMG_HEIGHT");
        public final static Property ImgWidth = new Property(23, long.class, "ImgWidth", false, "IMG_WIDTH");
        public final static Property SubMsgType = new Property(24, long.class, "SubMsgType", false, "SUB_MSG_TYPE");
        public final static Property NewMsgId = new Property(25, long.class, "NewMsgId", false, "NEW_MSG_ID");
    }


    public WechatMessageDao(DaoConfig config) {
        super(config);
    }
    
    public WechatMessageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WECHAT_MESSAGE\" (" + //
                "\"MSG_ID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: MsgId
                "\"UIN\" INTEGER NOT NULL ," + // 1: uin
                "\"IS_FROM_MINE\" INTEGER NOT NULL ," + // 2: isFromMine
                "\"FROM_USER_NAME\" TEXT," + // 3: FromUserName
                "\"TO_USER_NAME\" TEXT," + // 4: ToUserName
                "\"MSG_TYPE\" INTEGER NOT NULL ," + // 5: MsgType
                "\"CONTENT\" TEXT," + // 6: Content
                "\"STATUS\" INTEGER NOT NULL ," + // 7: Status
                "\"IMG_STATUS\" INTEGER NOT NULL ," + // 8: ImgStatus
                "\"CREATE_TIME\" INTEGER NOT NULL ," + // 9: CreateTime
                "\"VOICE_LENGTH\" INTEGER NOT NULL ," + // 10: VoiceLength
                "\"PLAY_LENGTH\" INTEGER NOT NULL ," + // 11: PlayLength
                "\"FILE_NAME\" TEXT," + // 12: FileName
                "\"FILE_SIZE\" TEXT," + // 13: FileSize
                "\"MEDIA_ID\" TEXT," + // 14: MediaId
                "\"URL\" TEXT," + // 15: Url
                "\"APP_MSG_TYPE\" INTEGER NOT NULL ," + // 16: AppMsgType
                "\"STATUS_NOTIFY_CODE\" INTEGER NOT NULL ," + // 17: StatusNotifyCode
                "\"STATUS_NOTIFY_USER_NAME\" TEXT," + // 18: StatusNotifyUserName
                "\"FORWARD_FLAG\" INTEGER NOT NULL ," + // 19: ForwardFlag
                "\"HAS_PRODUCT_ID\" INTEGER NOT NULL ," + // 20: HasProductId
                "\"TICKET\" TEXT," + // 21: Ticket
                "\"IMG_HEIGHT\" INTEGER NOT NULL ," + // 22: ImgHeight
                "\"IMG_WIDTH\" INTEGER NOT NULL ," + // 23: ImgWidth
                "\"SUB_MSG_TYPE\" INTEGER NOT NULL ," + // 24: SubMsgType
                "\"NEW_MSG_ID\" INTEGER NOT NULL );"); // 25: NewMsgId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_WECHAT_MESSAGE_CREATE_TIME ON WECHAT_MESSAGE" +
                " (\"CREATE_TIME\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WECHAT_MESSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, WechatMessage entity) {
        stmt.clearBindings();
 
        String MsgId = entity.getMsgId();
        if (MsgId != null) {
            stmt.bindString(1, MsgId);
        }
        stmt.bindLong(2, entity.getUin());
        stmt.bindLong(3, entity.getIsFromMine() ? 1L: 0L);
 
        String FromUserName = entity.getFromUserName();
        if (FromUserName != null) {
            stmt.bindString(4, FromUserName);
        }
 
        String ToUserName = entity.getToUserName();
        if (ToUserName != null) {
            stmt.bindString(5, ToUserName);
        }
        stmt.bindLong(6, entity.getMsgType());
 
        String Content = entity.getContent();
        if (Content != null) {
            stmt.bindString(7, Content);
        }
        stmt.bindLong(8, entity.getStatus());
        stmt.bindLong(9, entity.getImgStatus());
        stmt.bindLong(10, entity.getCreateTime());
        stmt.bindLong(11, entity.getVoiceLength());
        stmt.bindLong(12, entity.getPlayLength());
 
        String FileName = entity.getFileName();
        if (FileName != null) {
            stmt.bindString(13, FileName);
        }
 
        String FileSize = entity.getFileSize();
        if (FileSize != null) {
            stmt.bindString(14, FileSize);
        }
 
        String MediaId = entity.getMediaId();
        if (MediaId != null) {
            stmt.bindString(15, MediaId);
        }
 
        String Url = entity.getUrl();
        if (Url != null) {
            stmt.bindString(16, Url);
        }
        stmt.bindLong(17, entity.getAppMsgType());
        stmt.bindLong(18, entity.getStatusNotifyCode());
 
        String StatusNotifyUserName = entity.getStatusNotifyUserName();
        if (StatusNotifyUserName != null) {
            stmt.bindString(19, StatusNotifyUserName);
        }
        stmt.bindLong(20, entity.getForwardFlag());
        stmt.bindLong(21, entity.getHasProductId());
 
        String Ticket = entity.getTicket();
        if (Ticket != null) {
            stmt.bindString(22, Ticket);
        }
        stmt.bindLong(23, entity.getImgHeight());
        stmt.bindLong(24, entity.getImgWidth());
        stmt.bindLong(25, entity.getSubMsgType());
        stmt.bindLong(26, entity.getNewMsgId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, WechatMessage entity) {
        stmt.clearBindings();
 
        String MsgId = entity.getMsgId();
        if (MsgId != null) {
            stmt.bindString(1, MsgId);
        }
        stmt.bindLong(2, entity.getUin());
        stmt.bindLong(3, entity.getIsFromMine() ? 1L: 0L);
 
        String FromUserName = entity.getFromUserName();
        if (FromUserName != null) {
            stmt.bindString(4, FromUserName);
        }
 
        String ToUserName = entity.getToUserName();
        if (ToUserName != null) {
            stmt.bindString(5, ToUserName);
        }
        stmt.bindLong(6, entity.getMsgType());
 
        String Content = entity.getContent();
        if (Content != null) {
            stmt.bindString(7, Content);
        }
        stmt.bindLong(8, entity.getStatus());
        stmt.bindLong(9, entity.getImgStatus());
        stmt.bindLong(10, entity.getCreateTime());
        stmt.bindLong(11, entity.getVoiceLength());
        stmt.bindLong(12, entity.getPlayLength());
 
        String FileName = entity.getFileName();
        if (FileName != null) {
            stmt.bindString(13, FileName);
        }
 
        String FileSize = entity.getFileSize();
        if (FileSize != null) {
            stmt.bindString(14, FileSize);
        }
 
        String MediaId = entity.getMediaId();
        if (MediaId != null) {
            stmt.bindString(15, MediaId);
        }
 
        String Url = entity.getUrl();
        if (Url != null) {
            stmt.bindString(16, Url);
        }
        stmt.bindLong(17, entity.getAppMsgType());
        stmt.bindLong(18, entity.getStatusNotifyCode());
 
        String StatusNotifyUserName = entity.getStatusNotifyUserName();
        if (StatusNotifyUserName != null) {
            stmt.bindString(19, StatusNotifyUserName);
        }
        stmt.bindLong(20, entity.getForwardFlag());
        stmt.bindLong(21, entity.getHasProductId());
 
        String Ticket = entity.getTicket();
        if (Ticket != null) {
            stmt.bindString(22, Ticket);
        }
        stmt.bindLong(23, entity.getImgHeight());
        stmt.bindLong(24, entity.getImgWidth());
        stmt.bindLong(25, entity.getSubMsgType());
        stmt.bindLong(26, entity.getNewMsgId());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public WechatMessage readEntity(Cursor cursor, int offset) {
        WechatMessage entity = new WechatMessage( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // MsgId
            cursor.getLong(offset + 1), // uin
            cursor.getShort(offset + 2) != 0, // isFromMine
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // FromUserName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // ToUserName
            cursor.getLong(offset + 5), // MsgType
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Content
            cursor.getLong(offset + 7), // Status
            cursor.getLong(offset + 8), // ImgStatus
            cursor.getLong(offset + 9), // CreateTime
            cursor.getLong(offset + 10), // VoiceLength
            cursor.getLong(offset + 11), // PlayLength
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // FileName
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // FileSize
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // MediaId
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // Url
            cursor.getLong(offset + 16), // AppMsgType
            cursor.getLong(offset + 17), // StatusNotifyCode
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // StatusNotifyUserName
            cursor.getLong(offset + 19), // ForwardFlag
            cursor.getLong(offset + 20), // HasProductId
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // Ticket
            cursor.getLong(offset + 22), // ImgHeight
            cursor.getLong(offset + 23), // ImgWidth
            cursor.getLong(offset + 24), // SubMsgType
            cursor.getLong(offset + 25) // NewMsgId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, WechatMessage entity, int offset) {
        entity.setMsgId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUin(cursor.getLong(offset + 1));
        entity.setIsFromMine(cursor.getShort(offset + 2) != 0);
        entity.setFromUserName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setToUserName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMsgType(cursor.getLong(offset + 5));
        entity.setContent(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setStatus(cursor.getLong(offset + 7));
        entity.setImgStatus(cursor.getLong(offset + 8));
        entity.setCreateTime(cursor.getLong(offset + 9));
        entity.setVoiceLength(cursor.getLong(offset + 10));
        entity.setPlayLength(cursor.getLong(offset + 11));
        entity.setFileName(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setFileSize(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setMediaId(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setUrl(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setAppMsgType(cursor.getLong(offset + 16));
        entity.setStatusNotifyCode(cursor.getLong(offset + 17));
        entity.setStatusNotifyUserName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setForwardFlag(cursor.getLong(offset + 19));
        entity.setHasProductId(cursor.getLong(offset + 20));
        entity.setTicket(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setImgHeight(cursor.getLong(offset + 22));
        entity.setImgWidth(cursor.getLong(offset + 23));
        entity.setSubMsgType(cursor.getLong(offset + 24));
        entity.setNewMsgId(cursor.getLong(offset + 25));
     }
    
    @Override
    protected final String updateKeyAfterInsert(WechatMessage entity, long rowId) {
        return entity.getMsgId();
    }
    
    @Override
    public String getKey(WechatMessage entity) {
        if(entity != null) {
            return entity.getMsgId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(WechatMessage entity) {
        return entity.getMsgId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
