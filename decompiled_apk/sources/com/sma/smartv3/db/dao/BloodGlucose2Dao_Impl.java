package com.sma.smartv3.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.entity.BloodGlucose2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class BloodGlucose2Dao_Impl implements BloodGlucose2Dao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<BloodGlucose2> __insertionAdapterOfBloodGlucose2;

    public BloodGlucose2Dao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBloodGlucose2 = new EntityInsertionAdapter<BloodGlucose2>(__db) { // from class: com.sma.smartv3.db.dao.BloodGlucose2Dao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `BloodGlucose2` (`mId`,`mTime`,`mMeasurementId`,`mUserId`,`mStartTime`,`mEndTime`,`mModelNo`,`mLowerBound`,`mUpperBound`,`mFasting`,`mWithin2hrsMeal`,`mCompletedProgress`,`mCurrentLevel`,`mRiskCode`,`mInsights`,`mTips`,`mLocaleInsights`,`mLocaleTips`,`mIsSync`,`mIsDelete`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final BloodGlucose2 entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMTime());
                if (entity.getMMeasurementId() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMMeasurementId());
                }
                if (entity.getMUserId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMUserId());
                }
                if (entity.getMStartTime() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getMStartTime());
                }
                if (entity.getMEndTime() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMEndTime());
                }
                if (entity.getMModelNo() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMModelNo());
                }
                statement.bindDouble(8, entity.getMLowerBound());
                statement.bindDouble(9, entity.getMUpperBound());
                statement.bindLong(10, entity.getMFasting());
                statement.bindLong(11, entity.getMWithin2hrsMeal());
                statement.bindLong(12, entity.getMCompletedProgress());
                statement.bindLong(13, entity.getMCurrentLevel());
                if (entity.getMRiskCode() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMRiskCode());
                }
                if (entity.getMInsights() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getMInsights());
                }
                if (entity.getMTips() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getMTips());
                }
                if (entity.getMLocaleInsights() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMLocaleInsights());
                }
                if (entity.getMLocaleTips() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getMLocaleTips());
                }
                statement.bindLong(19, entity.getMIsSync());
                statement.bindLong(20, entity.getMIsDelete());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getList() {
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BloodGlucose2 ORDER BY mTime ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mMeasurementId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mStartTime");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mEndTime");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mModelNo");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mLowerBound");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mUpperBound");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mFasting");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mWithin2hrsMeal");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCompletedProgress");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mCurrentLevel");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mRiskCode");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mInsights");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mTips");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleInsights");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleTips");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i2 = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                String string3 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                String string4 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                String string5 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                double d = query.getDouble(columnIndexOrThrow8);
                double d2 = query.getDouble(columnIndexOrThrow9);
                int i3 = query.getInt(columnIndexOrThrow10);
                int i4 = query.getInt(columnIndexOrThrow11);
                int i5 = query.getInt(columnIndexOrThrow12);
                int i6 = query.getInt(columnIndexOrThrow13);
                int i7 = i;
                String string6 = query.isNull(i7) ? null : query.getString(i7);
                int i8 = columnIndexOrThrow15;
                int i9 = columnIndexOrThrow;
                String string7 = query.isNull(i8) ? null : query.getString(i8);
                int i10 = columnIndexOrThrow16;
                String string8 = query.isNull(i10) ? null : query.getString(i10);
                int i11 = columnIndexOrThrow17;
                String string9 = query.isNull(i11) ? null : query.getString(i11);
                int i12 = columnIndexOrThrow18;
                String string10 = query.isNull(i12) ? null : query.getString(i12);
                int i13 = columnIndexOrThrow19;
                int i14 = columnIndexOrThrow20;
                columnIndexOrThrow20 = i14;
                arrayList.add(new BloodGlucose2(i2, j, string, string2, string3, string4, string5, d, d2, i3, i4, i5, i6, string6, string7, string8, string9, string10, query.getInt(i13), query.getInt(i14)));
                columnIndexOrThrow = i9;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow17 = i11;
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow19 = i13;
                i = i7;
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

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getListDESC() {
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BloodGlucose2 ORDER BY mTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mMeasurementId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mStartTime");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mEndTime");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mModelNo");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mLowerBound");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mUpperBound");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mFasting");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mWithin2hrsMeal");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCompletedProgress");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mCurrentLevel");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mRiskCode");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mInsights");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mTips");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleInsights");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleTips");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i2 = query.getInt(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                String string3 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                String string4 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                String string5 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                double d = query.getDouble(columnIndexOrThrow8);
                double d2 = query.getDouble(columnIndexOrThrow9);
                int i3 = query.getInt(columnIndexOrThrow10);
                int i4 = query.getInt(columnIndexOrThrow11);
                int i5 = query.getInt(columnIndexOrThrow12);
                int i6 = query.getInt(columnIndexOrThrow13);
                int i7 = i;
                String string6 = query.isNull(i7) ? null : query.getString(i7);
                int i8 = columnIndexOrThrow15;
                int i9 = columnIndexOrThrow;
                String string7 = query.isNull(i8) ? null : query.getString(i8);
                int i10 = columnIndexOrThrow16;
                String string8 = query.isNull(i10) ? null : query.getString(i10);
                int i11 = columnIndexOrThrow17;
                String string9 = query.isNull(i11) ? null : query.getString(i11);
                int i12 = columnIndexOrThrow18;
                String string10 = query.isNull(i12) ? null : query.getString(i12);
                int i13 = columnIndexOrThrow19;
                int i14 = columnIndexOrThrow20;
                columnIndexOrThrow20 = i14;
                arrayList.add(new BloodGlucose2(i2, j, string, string2, string3, string4, string5, d, d2, i3, i4, i5, i6, string6, string7, string8, string9, string10, query.getInt(i13), query.getInt(i14)));
                columnIndexOrThrow = i9;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow17 = i11;
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow19 = i13;
                i = i7;
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

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getListForDay() {
        return BloodGlucose2Dao.DefaultImpls.getListForDay(this);
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getTodayList() {
        return BloodGlucose2Dao.DefaultImpls.getTodayList(this);
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public long[] insert(final List<BloodGlucose2> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfBloodGlucose2.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getListForDay(final long start, final long end) {
        return BloodGlucose2Dao.DefaultImpls.getListForDay(this, start, end);
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getList(final long start, final long end) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        int i2;
        String str;
        String string3;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BloodGlucose2 WHERE mTime >= ? AND mTime < ? ORDER BY mTime ASC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mMeasurementId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mStartTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mEndTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mModelNo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mLowerBound");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mUpperBound");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mFasting");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mWithin2hrsMeal");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCompletedProgress");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mCurrentLevel");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mRiskCode");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mInsights");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mTips");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleInsights");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleTips");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i5 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                    double d = query.getDouble(columnIndexOrThrow8);
                    double d2 = query.getDouble(columnIndexOrThrow9);
                    int i6 = query.getInt(columnIndexOrThrow10);
                    int i7 = query.getInt(columnIndexOrThrow11);
                    int i8 = query.getInt(columnIndexOrThrow12);
                    int i9 = query.getInt(columnIndexOrThrow13);
                    int i10 = i4;
                    String string9 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    if (query.isNull(i12)) {
                        i = i12;
                        string = null;
                    } else {
                        string = query.getString(i12);
                        i = i12;
                    }
                    int i13 = columnIndexOrThrow16;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow16 = i13;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i13;
                        string2 = query.getString(i13);
                    }
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow17 = i14;
                        i2 = columnIndexOrThrow18;
                        str = null;
                    } else {
                        String string10 = query.getString(i14);
                        columnIndexOrThrow17 = i14;
                        i2 = columnIndexOrThrow18;
                        str = string10;
                    }
                    if (query.isNull(i2)) {
                        columnIndexOrThrow18 = i2;
                        i3 = columnIndexOrThrow19;
                        string3 = null;
                    } else {
                        string3 = query.getString(i2);
                        columnIndexOrThrow18 = i2;
                        i3 = columnIndexOrThrow19;
                    }
                    int i15 = query.getInt(i3);
                    columnIndexOrThrow19 = i3;
                    int i16 = columnIndexOrThrow20;
                    columnIndexOrThrow20 = i16;
                    arrayList.add(new BloodGlucose2(i5, j, string4, string5, string6, string7, string8, d, d2, i6, i7, i8, i9, string9, string, string2, str, string3, i15, query.getInt(i16)));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i;
                    i4 = i10;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.BloodGlucose2Dao
    public List<BloodGlucose2> getListDESC(final long start, final long end) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        int i2;
        String str;
        String string3;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BloodGlucose2 WHERE mTime >= ? AND mTime < ? ORDER BY mTime DESC", 2);
        acquire.bindLong(1, start);
        acquire.bindLong(2, end);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mMeasurementId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mStartTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mEndTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mModelNo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mLowerBound");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mUpperBound");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mFasting");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mWithin2hrsMeal");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCompletedProgress");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mCurrentLevel");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mRiskCode");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mInsights");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mTips");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleInsights");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mLocaleTips");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i5 = query.getInt(columnIndexOrThrow);
                    long j = query.getLong(columnIndexOrThrow2);
                    String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    String string8 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                    double d = query.getDouble(columnIndexOrThrow8);
                    double d2 = query.getDouble(columnIndexOrThrow9);
                    int i6 = query.getInt(columnIndexOrThrow10);
                    int i7 = query.getInt(columnIndexOrThrow11);
                    int i8 = query.getInt(columnIndexOrThrow12);
                    int i9 = query.getInt(columnIndexOrThrow13);
                    int i10 = i4;
                    String string9 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    if (query.isNull(i12)) {
                        i = i12;
                        string = null;
                    } else {
                        string = query.getString(i12);
                        i = i12;
                    }
                    int i13 = columnIndexOrThrow16;
                    if (query.isNull(i13)) {
                        columnIndexOrThrow16 = i13;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i13;
                        string2 = query.getString(i13);
                    }
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        columnIndexOrThrow17 = i14;
                        i2 = columnIndexOrThrow18;
                        str = null;
                    } else {
                        String string10 = query.getString(i14);
                        columnIndexOrThrow17 = i14;
                        i2 = columnIndexOrThrow18;
                        str = string10;
                    }
                    if (query.isNull(i2)) {
                        columnIndexOrThrow18 = i2;
                        i3 = columnIndexOrThrow19;
                        string3 = null;
                    } else {
                        string3 = query.getString(i2);
                        columnIndexOrThrow18 = i2;
                        i3 = columnIndexOrThrow19;
                    }
                    int i15 = query.getInt(i3);
                    columnIndexOrThrow19 = i3;
                    int i16 = columnIndexOrThrow20;
                    columnIndexOrThrow20 = i16;
                    arrayList.add(new BloodGlucose2(i5, j, string4, string5, string6, string7, string8, d, d2, i6, i7, i8, i9, string9, string, string2, str, string3, i15, query.getInt(i16)));
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow15 = i;
                    i4 = i10;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }
}
