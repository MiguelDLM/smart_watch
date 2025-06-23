package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.entity.Sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class SleepDao_Impl implements SleepDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Sleep> __insertionAdapterOfSleep;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSleeps;
    private final EntityDeletionOrUpdateAdapter<Sleep> __updateAdapterOfSleep;

    public SleepDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSleep = new EntityInsertionAdapter<Sleep>(__db) { // from class: com.sma.smartv3.db.dao.SleepDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Sleep` (`mId`,`mTime`,`mLocalTime`,`mMode`,`mSoft`,`mStrong`,`mIsSync`,`mAlgorithmType`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Sleep entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMSoft());
                statement.bindLong(6, entity.getMStrong());
                statement.bindLong(7, entity.getMIsSync());
                statement.bindLong(8, entity.getMAlgorithmType());
            }
        };
        this.__updateAdapterOfSleep = new EntityDeletionOrUpdateAdapter<Sleep>(__db) { // from class: com.sma.smartv3.db.dao.SleepDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Sleep` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mMode` = ?,`mSoft` = ?,`mStrong` = ?,`mIsSync` = ?,`mAlgorithmType` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Sleep entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMSoft());
                statement.bindLong(6, entity.getMStrong());
                statement.bindLong(7, entity.getMIsSync());
                statement.bindLong(8, entity.getMAlgorithmType());
                statement.bindLong(9, entity.getMId());
            }
        };
        this.__preparedStmtOfDeleteSleeps = new SharedSQLiteStatement(__db) { // from class: com.sma.smartv3.db.dao.SleepDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM Sleep WHERE mTime >= ? AND mTime < ?";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public void deleteSleeps(final long start, final long end) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteSleeps.acquire();
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteSleeps.release(acquire);
        }
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public List<Sleep> getListASC() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Sleep WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mSoft");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStrong");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmType");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Sleep(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public List<Sleep> getSleeps(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Sleep WHERE mTime >= ? AND mTime < ? ORDER BY mTime ASC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mSoft");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStrong");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmType");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Sleep(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public List<Sleep> getTestSleeps(final long start, final long end) {
        return SleepDao.DefaultImpls.getTestSleeps(this, start, end);
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public long[] insert(final List<Sleep> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfSleep.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.SleepDao
    public int update(final List<Sleep> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfSleep.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
