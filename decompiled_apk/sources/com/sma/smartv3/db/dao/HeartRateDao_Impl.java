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
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.entity.HeartRate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class HeartRateDao_Impl implements HeartRateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<HeartRate> __insertionAdapterOfHeartRate;
    private final EntityDeletionOrUpdateAdapter<HeartRate> __updateAdapterOfHeartRate;

    public HeartRateDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHeartRate = new EntityInsertionAdapter<HeartRate>(__db) { // from class: com.sma.smartv3.db.dao.HeartRateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `HeartRate` (`mId`,`mTime`,`mLocalTime`,`mBpm`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HeartRate entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMBpm());
                statement.bindLong(5, entity.getMIsSync());
            }
        };
        this.__updateAdapterOfHeartRate = new EntityDeletionOrUpdateAdapter<HeartRate>(__db) { // from class: com.sma.smartv3.db.dao.HeartRateDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `HeartRate` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mBpm` = ?,`mIsSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HeartRate entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMBpm());
                statement.bindLong(5, entity.getMIsSync());
                statement.bindLong(6, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public List<HeartRate> getHeartRates(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM HeartRate WHERE mTime >= ? AND mTime < ? AND mBpm >= 50 AND mBpm<= 220", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mBpm");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new HeartRate(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public HeartRate getLastHeartRate() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM HeartRate WHERE mBpm >= 50 AND mBpm<= 220 ORDER BY mTime DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        HeartRate heartRate = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mBpm");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            if (query.moveToFirst()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                heartRate = new HeartRate(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5));
            }
            return heartRate;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public List<HeartRate> getListASC() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM HeartRate WHERE  mIsSync = 0  AND mTime > 0 AND mBpm >= 50 AND mBpm<= 220 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mBpm");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new HeartRate(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public List<HeartRate> getTestHeartRates(final long start, final long end) {
        return HeartRateDao.DefaultImpls.getTestHeartRates(this, start, end);
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public long[] insert(final List<HeartRate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfHeartRate.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.HeartRateDao
    public int update(final List<HeartRate> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfHeartRate.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
