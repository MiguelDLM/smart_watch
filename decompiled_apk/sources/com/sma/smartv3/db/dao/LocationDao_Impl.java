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
import com.sma.smartv3.db.entity.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class LocationDao_Impl implements LocationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;
    private final EntityDeletionOrUpdateAdapter<Location> __updateAdapterOfLocation;

    public LocationDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(__db) { // from class: com.sma.smartv3.db.dao.LocationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Location` (`mId`,`mTime`,`mLocalTime`,`mActivityMode`,`mAltitude`,`mLongitude`,`mLatitude`,`mSource`,`mIsSync`,`mIsBaiDuSync`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Location entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMActivityMode());
                statement.bindLong(5, entity.getMAltitude());
                statement.bindDouble(6, entity.getMLongitude());
                statement.bindDouble(7, entity.getMLatitude());
                statement.bindLong(8, entity.getMSource());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsBaiDuSync());
            }
        };
        this.__updateAdapterOfLocation = new EntityDeletionOrUpdateAdapter<Location>(__db) { // from class: com.sma.smartv3.db.dao.LocationDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Location` SET `mId` = ?,`mTime` = ?,`mLocalTime` = ?,`mActivityMode` = ?,`mAltitude` = ?,`mLongitude` = ?,`mLatitude` = ?,`mSource` = ?,`mIsSync` = ?,`mIsBaiDuSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Location entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMActivityMode());
                statement.bindLong(5, entity.getMAltitude());
                statement.bindDouble(6, entity.getMLongitude());
                statement.bindDouble(7, entity.getMLatitude());
                statement.bindLong(8, entity.getMSource());
                statement.bindLong(9, entity.getMIsSync());
                statement.bindLong(10, entity.getMIsBaiDuSync());
                statement.bindLong(11, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public List<Location> getListASC() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Location WHERE  mIsSync = 0 AND mTime > 0 ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mActivityMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLongitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mLatitude");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsBaiDuSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Location(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getFloat(columnIndexOrThrow6), query.getFloat(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public List<Location> getLocation(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Location WHERE mTime >= ? AND mTime <= ? ORDER BY mTime ASC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mActivityMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLongitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mLatitude");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsBaiDuSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Location(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getFloat(columnIndexOrThrow6), query.getFloat(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public List<Location> getLocationDESC(final long start, final long end) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Location WHERE mTime >= ? AND mTime <= ? ORDER BY mTime DESC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mActivityMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLongitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mLatitude");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsBaiDuSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Location(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getFloat(columnIndexOrThrow6), query.getFloat(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public List<Location> getNoBaiDuSyncList() {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Location WHERE mIsBaiDuSync = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mActivityMode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLongitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mLatitude");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mIsBaiDuSync");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(new Location(i, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getFloat(columnIndexOrThrow6), query.getFloat(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public long[] insert(final List<Location> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfLocation.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.LocationDao
    public int update(final List<Location> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfLocation.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
