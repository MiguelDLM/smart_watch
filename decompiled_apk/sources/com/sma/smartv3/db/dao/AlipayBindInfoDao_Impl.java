package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class AlipayBindInfoDao_Impl implements AlipayBindInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AlipayBindInfo> __insertionAdapterOfAlipayBindInfo;
    private final EntityDeletionOrUpdateAdapter<AlipayBindInfo> __updateAdapterOfAlipayBindInfo;

    public AlipayBindInfoDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAlipayBindInfo = new EntityInsertionAdapter<AlipayBindInfo>(__db) { // from class: com.sma.smartv3.db.dao.AlipayBindInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `AlipayBindInfo` (`mId`,`mTime`,`mLocalTime`,`mBleName`,`mFirmwareFlag`,`mMacAddress`,`mFirmwareVersion`,`mAppVersion`,`mResult`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final AlipayBindInfo entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                if (entity.getMBleName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMBleName());
                }
                if (entity.getMFirmwareFlag() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getMFirmwareFlag());
                }
                if (entity.getMMacAddress() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMMacAddress());
                }
                if (entity.getMFirmwareVersion() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMFirmwareVersion());
                }
                if (entity.getMAppVersion() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getMAppVersion());
                }
                statement.bindLong(9, entity.getMResult());
                statement.bindLong(10, entity.getMIsSync());
            }
        };
        this.__updateAdapterOfAlipayBindInfo = new EntityDeletionOrUpdateAdapter<AlipayBindInfo>(__db) { // from class: com.sma.smartv3.db.dao.AlipayBindInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `AlipayBindInfo` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mBleName` = ?,`mFirmwareFlag` = ?,`mMacAddress` = ?,`mFirmwareVersion` = ?,`mAppVersion` = ?,`mResult` = ?,`mIsSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final AlipayBindInfo entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                if (entity.getMBleName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMBleName());
                }
                if (entity.getMFirmwareFlag() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getMFirmwareFlag());
                }
                if (entity.getMMacAddress() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMMacAddress());
                }
                if (entity.getMFirmwareVersion() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMFirmwareVersion());
                }
                if (entity.getMAppVersion() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getMAppVersion());
                }
                statement.bindLong(9, entity.getMResult());
                statement.bindLong(10, entity.getMIsSync());
                statement.bindLong(11, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.AlipayBindInfoDao
    public List<AlipayBindInfo> getListASC() {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AlipayBindInfo WHERE  mIsSync = 0  AND mTime > 0 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mMacAddress");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareVersion");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAppVersion");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mResult");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow5);
                }
                if (query.isNull(columnIndexOrThrow6)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow8);
                }
                arrayList.add(new AlipayBindInfo(i, j, string, string2, string3, string4, string5, string6, query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.AlipayBindInfoDao
    public long[] insert(final List<AlipayBindInfo> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfAlipayBindInfo.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.AlipayBindInfoDao
    public int update(final List<AlipayBindInfo> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfAlipayBindInfo.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
