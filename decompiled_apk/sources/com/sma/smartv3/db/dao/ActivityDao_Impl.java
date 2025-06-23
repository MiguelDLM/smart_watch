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
import com.sma.smartv3.db.entity.Activity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class ActivityDao_Impl implements ActivityDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Activity> __insertionAdapterOfActivity;
    private final EntityDeletionOrUpdateAdapter<Activity> __updateAdapterOfActivity;

    public ActivityDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfActivity = new EntityInsertionAdapter<Activity>(__db) { // from class: com.sma.smartv3.db.dao.ActivityDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Activity` (`mId`,`mTime`,`mLocalTime`,`mMode`,`mState`,`mStep`,`mCalorie`,`mDistance`,`mIsSync`,`mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Activity entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMState());
                statement.bindLong(6, entity.getMStep());
                statement.bindLong(7, entity.getMCalorie());
                statement.bindLong(8, entity.getMDistance());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsDelete());
            }
        };
        this.__updateAdapterOfActivity = new EntityDeletionOrUpdateAdapter<Activity>(__db) { // from class: com.sma.smartv3.db.dao.ActivityDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Activity` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mMode` = ?,`mState` = ?,`mStep` = ?,`mCalorie` = ?,`mDistance` = ?,`mIsSync` = ?,`mIsDelete` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Activity entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMMode());
                statement.bindLong(5, entity.getMState());
                statement.bindLong(6, entity.getMStep());
                statement.bindLong(7, entity.getMCalorie());
                statement.bindLong(8, entity.getMDistance());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsDelete());
                statement.bindLong(11, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public Activity getActivity(long j, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime >= ? AND mTime < ? AND mStep >= 0 AND mCalorie > 0 AND mStep < 1000000 ORDER BY mTime DESC LIMIT 1", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        this.__db.assertNotSuspendingTransaction();
        Activity activity = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            if (query.moveToFirst()) {
                int i = query.getInt(columnIndexOrThrow);
                long j3 = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                activity = new Activity(i, j3, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10));
            }
            return activity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public Activity getBeginItem(long j, long j2, int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime >= ? AND mTime < ? AND mMode = ? AND mState = 0 ORDER BY mTime DESC LIMIT 1", 3);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        acquire.bindLong(3, i);
        this.__db.assertNotSuspendingTransaction();
        Activity activity = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            if (query.moveToFirst()) {
                int i2 = query.getInt(columnIndexOrThrow);
                long j3 = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                activity = new Activity(i2, j3, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10));
            }
            return activity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public Activity getEndItem(long j, int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime = ? AND mMode = ? AND mState = 4", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, i);
        this.__db.assertNotSuspendingTransaction();
        Activity activity = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            if (query.moveToFirst()) {
                int i2 = query.getInt(columnIndexOrThrow);
                long j2 = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                activity = new Activity(i2, j2, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10));
            }
            return activity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public List<Activity> getListASC(final long start, final long end) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime >= ? AND mTime < ? AND mCalorie >= 0 AND mStep <1000000 AND mDistance > 0 ORDER BY mTime ASC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new Activity(query.getInt(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public List<Activity> getListDESC(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime >= ? AND mTime <= ?  AND mMode >= 7 AND mIsDelete !=1 ORDER BY mTime DESC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Activity(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public List<Activity> getStateActivityList(final int state, final int startIndex, final int endIndex) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Activity WHERE mState = ? AND mMode >= 7 AND mIsDelete !=1 ORDER BY mTime DESC LIMIT ?, ?", 3);
        acquire.bindLong(1, state);
        acquire.bindLong(2, startIndex);
        acquire.bindLong(3, endIndex);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Activity(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public List<Activity> getWorkoutListDESC(final long start, final long end, final int mode) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM activity WHERE mTime >= ? AND mTime <= ? AND mMode = ? ORDER BY mTime DESC", 3);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        acquire.bindLong(3, mode);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Activity(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public long[] insert(final List<Activity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfActivity.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public int update(final List<Activity> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfActivity.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.ActivityDao
    public List<Activity> getListASC() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Activity WHERE  mIsSync = 0 AND mTime > 0  ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new Activity(query.getInt(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
