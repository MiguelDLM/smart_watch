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
import com.sma.smartv3.db.entity.Hrv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class HrvDao_Impl implements HrvDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Hrv> __insertionAdapterOfHrv;
    private final EntityDeletionOrUpdateAdapter<Hrv> __updateAdapterOfHrv;

    public HrvDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHrv = new EntityInsertionAdapter<Hrv>(__db) { // from class: com.sma.smartv3.db.dao.HrvDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Hrv` (`mId`,`mTime`,`mLocalTime`,`mValue`,`mAvgValue`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Hrv entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMValue());
                statement.bindLong(5, entity.getMAvgValue());
                statement.bindLong(6, entity.getMIsSync());
            }
        };
        this.__updateAdapterOfHrv = new EntityDeletionOrUpdateAdapter<Hrv>(__db) { // from class: com.sma.smartv3.db.dao.HrvDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Hrv` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mValue` = ?,`mAvgValue` = ?,`mIsSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Hrv entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMValue());
                statement.bindLong(5, entity.getMAvgValue());
                statement.bindLong(6, entity.getMIsSync());
                statement.bindLong(7, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.HrvDao
    public List<Hrv> getHrv(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Hrv WHERE mTime >= ? AND mTime < ? AND mValue >= 50 AND mValue<= 150", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mValue");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAvgValue");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Hrv(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HrvDao
    public List<Hrv> getLastData() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Hrv WHERE mTime > 0 AND mValue >= 50 AND mValue<= 150 ORDER BY mTime DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mValue");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAvgValue");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Hrv(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HrvDao
    public List<Hrv> getListASC() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Hrv WHERE  mIsSync = 0  AND mTime > 0 AND mValue >= 50 AND mValue<= 150 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mValue");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAvgValue");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Hrv(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HrvDao
    public long[] insert(final List<Hrv> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfHrv.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.HrvDao
    public int update(final List<Hrv> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfHrv.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
