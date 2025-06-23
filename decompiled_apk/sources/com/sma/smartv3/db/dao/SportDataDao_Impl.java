package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.entity.SportData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class SportDataDao_Impl implements SportDataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SportData> __insertionAdapterOfSportData;

    public SportDataDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSportData = new EntityInsertionAdapter<SportData>(__db) { // from class: com.sma.smartv3.db.dao.SportDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR ABORT INTO `SportData` (`mId`,`mTime`,`mLocalTime`,`mStep`,`mDistance`,`mCalorie`,`mDuration`,`mSpm`,`mAltitude`,`mAirPressure`,`mPace`,`mSpeed`,`mMode`,`mIsSync`,`mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final SportData entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMLocalTime());
                }
                statement.bindLong(4, entity.getMStep());
                statement.bindLong(5, entity.getMDistance());
                statement.bindLong(6, entity.getMCalorie());
                statement.bindLong(7, entity.getMDuration());
                statement.bindLong(8, entity.getMSpm());
                statement.bindLong(9, entity.getMAltitude());
                statement.bindLong(10, entity.getMAirPressure());
                statement.bindLong(11, entity.getMPace());
                statement.bindLong(12, entity.getMSpeed());
                statement.bindLong(13, entity.getMMode());
                statement.bindLong(14, entity.getMIsSync());
                statement.bindLong(15, entity.getMIsDelete());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.SportDataDao
    public List<SportData> getSportDataASC(final long startTime, final long endTime) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SportData WHERE mTime >= ? AND mTime <= ? ORDER BY mTime ASC", 2);
        acquire.bindLong(1, startTime);
        acquire.bindLong(2, endTime);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i2 = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow3);
                }
                int i3 = i;
                int i4 = columnIndexOrThrow;
                int i5 = columnIndexOrThrow15;
                columnIndexOrThrow15 = i5;
                arrayList.add(new SportData(i2, j, string, query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10), query.getInt(columnIndexOrThrow11), query.getInt(columnIndexOrThrow12), query.getInt(columnIndexOrThrow13), query.getInt(i3), query.getInt(i5)));
                columnIndexOrThrow = i4;
                i = i3;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.sma.smartv3.db.dao.SportDataDao
    public long[] insert(final List<SportData> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfSportData.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }
}
