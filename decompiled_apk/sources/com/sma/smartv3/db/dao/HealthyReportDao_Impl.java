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
import com.sma.smartv3.db.entity.HealthyReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class HealthyReportDao_Impl implements HealthyReportDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<HealthyReport> __insertionAdapterOfHealthyReport;
    private final EntityInsertionAdapter<HealthyReport> __insertionAdapterOfHealthyReport_1;
    private final EntityDeletionOrUpdateAdapter<HealthyReport> __updateAdapterOfHealthyReport;

    public HealthyReportDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHealthyReport = new EntityInsertionAdapter<HealthyReport>(__db) { // from class: com.sma.smartv3.db.dao.HealthyReportDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `HealthyReport` (`mId`,`mUserGender`,`mUserWeight`,`mUserHeight`,`mTime`,`mLocalTime`,`mAbnormalNumber`,`mHeartRateTime`,`mHeartRateValue`,`mHeartRateAIRecords`,`mBloodPressureTime`,`mSystolicValue`,`mDiastolicValue`,`mBloodPressureAIRecords`,`mBloodOxygenTime`,`mBloodOxygenValue`,`mBloodOxygenAIRecords`,`mSleepTime`,`mSleepDeepLengthTime`,`mSleepPiecemealTime`,`mSleepAIRecords`,`mPressureTime`,`mPressureValue`,`mPressureAIRecords`,`mBloodGlucose2Time`,`mBloodGlucose2Value`,`mBloodGlucose2AIRecords`,`mWeightTime`,`mWeightValue`,`mWeightAIRecords`,`mWeekSportsTime`,`mWeekSportsNumber`,`mWeekSportsAllTime`,`mWeekSportsAIRecords`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HealthyReport entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMUserGender());
                statement.bindDouble(3, entity.getMUserWeight());
                statement.bindDouble(4, entity.getMUserHeight());
                statement.bindLong(5, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMLocalTime());
                }
                statement.bindLong(7, entity.getMAbnormalNumber());
                statement.bindLong(8, entity.getMHeartRateTime());
                statement.bindLong(9, entity.getMHeartRateValue());
                if (entity.getMHeartRateAIRecords() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMHeartRateAIRecords());
                }
                statement.bindLong(11, entity.getMBloodPressureTime());
                statement.bindLong(12, entity.getMSystolicValue());
                statement.bindLong(13, entity.getMDiastolicValue());
                if (entity.getMBloodPressureAIRecords() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMBloodPressureAIRecords());
                }
                statement.bindLong(15, entity.getMBloodOxygenTime());
                statement.bindLong(16, entity.getMBloodOxygenValue());
                if (entity.getMBloodOxygenAIRecords() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMBloodOxygenAIRecords());
                }
                statement.bindLong(18, entity.getMSleepTime());
                statement.bindDouble(19, entity.getMSleepDeepLengthTime());
                statement.bindDouble(20, entity.getMSleepPiecemealTime());
                if (entity.getMSleepAIRecords() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getMSleepAIRecords());
                }
                statement.bindLong(22, entity.getMPressureTime());
                statement.bindLong(23, entity.getMPressureValue());
                if (entity.getMPressureAIRecords() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getMPressureAIRecords());
                }
                statement.bindLong(25, entity.getMBloodGlucose2Time());
                statement.bindDouble(26, entity.getMBloodGlucose2Value());
                if (entity.getMBloodGlucose2AIRecords() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getMBloodGlucose2AIRecords());
                }
                statement.bindLong(28, entity.getMWeightTime());
                statement.bindDouble(29, entity.getMWeightValue());
                if (entity.getMWeightAIRecords() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getMWeightAIRecords());
                }
                statement.bindLong(31, entity.getMWeekSportsTime());
                statement.bindLong(32, entity.getMWeekSportsNumber());
                statement.bindLong(33, entity.getMWeekSportsAllTime());
                if (entity.getMWeekSportsAIRecords() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getMWeekSportsAIRecords());
                }
                statement.bindLong(35, entity.getMIsSync());
            }
        };
        this.__insertionAdapterOfHealthyReport_1 = new EntityInsertionAdapter<HealthyReport>(__db) { // from class: com.sma.smartv3.db.dao.HealthyReportDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR ABORT INTO `HealthyReport` (`mId`,`mUserGender`,`mUserWeight`,`mUserHeight`,`mTime`,`mLocalTime`,`mAbnormalNumber`,`mHeartRateTime`,`mHeartRateValue`,`mHeartRateAIRecords`,`mBloodPressureTime`,`mSystolicValue`,`mDiastolicValue`,`mBloodPressureAIRecords`,`mBloodOxygenTime`,`mBloodOxygenValue`,`mBloodOxygenAIRecords`,`mSleepTime`,`mSleepDeepLengthTime`,`mSleepPiecemealTime`,`mSleepAIRecords`,`mPressureTime`,`mPressureValue`,`mPressureAIRecords`,`mBloodGlucose2Time`,`mBloodGlucose2Value`,`mBloodGlucose2AIRecords`,`mWeightTime`,`mWeightValue`,`mWeightAIRecords`,`mWeekSportsTime`,`mWeekSportsNumber`,`mWeekSportsAllTime`,`mWeekSportsAIRecords`,`mIsSync`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HealthyReport entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMUserGender());
                statement.bindDouble(3, entity.getMUserWeight());
                statement.bindDouble(4, entity.getMUserHeight());
                statement.bindLong(5, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMLocalTime());
                }
                statement.bindLong(7, entity.getMAbnormalNumber());
                statement.bindLong(8, entity.getMHeartRateTime());
                statement.bindLong(9, entity.getMHeartRateValue());
                if (entity.getMHeartRateAIRecords() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMHeartRateAIRecords());
                }
                statement.bindLong(11, entity.getMBloodPressureTime());
                statement.bindLong(12, entity.getMSystolicValue());
                statement.bindLong(13, entity.getMDiastolicValue());
                if (entity.getMBloodPressureAIRecords() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMBloodPressureAIRecords());
                }
                statement.bindLong(15, entity.getMBloodOxygenTime());
                statement.bindLong(16, entity.getMBloodOxygenValue());
                if (entity.getMBloodOxygenAIRecords() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMBloodOxygenAIRecords());
                }
                statement.bindLong(18, entity.getMSleepTime());
                statement.bindDouble(19, entity.getMSleepDeepLengthTime());
                statement.bindDouble(20, entity.getMSleepPiecemealTime());
                if (entity.getMSleepAIRecords() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getMSleepAIRecords());
                }
                statement.bindLong(22, entity.getMPressureTime());
                statement.bindLong(23, entity.getMPressureValue());
                if (entity.getMPressureAIRecords() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getMPressureAIRecords());
                }
                statement.bindLong(25, entity.getMBloodGlucose2Time());
                statement.bindDouble(26, entity.getMBloodGlucose2Value());
                if (entity.getMBloodGlucose2AIRecords() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getMBloodGlucose2AIRecords());
                }
                statement.bindLong(28, entity.getMWeightTime());
                statement.bindDouble(29, entity.getMWeightValue());
                if (entity.getMWeightAIRecords() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getMWeightAIRecords());
                }
                statement.bindLong(31, entity.getMWeekSportsTime());
                statement.bindLong(32, entity.getMWeekSportsNumber());
                statement.bindLong(33, entity.getMWeekSportsAllTime());
                if (entity.getMWeekSportsAIRecords() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getMWeekSportsAIRecords());
                }
                statement.bindLong(35, entity.getMIsSync());
            }
        };
        this.__updateAdapterOfHealthyReport = new EntityDeletionOrUpdateAdapter<HealthyReport>(__db) { // from class: com.sma.smartv3.db.dao.HealthyReportDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `HealthyReport` SET `mId` = ?,`mUserGender` = ?,`mUserWeight` = ?,`mUserHeight` = ?,`mTime` = ?,`mLocalTime` = ?,`mAbnormalNumber` = ?,`mHeartRateTime` = ?,`mHeartRateValue` = ?,`mHeartRateAIRecords` = ?,`mBloodPressureTime` = ?,`mSystolicValue` = ?,`mDiastolicValue` = ?,`mBloodPressureAIRecords` = ?,`mBloodOxygenTime` = ?,`mBloodOxygenValue` = ?,`mBloodOxygenAIRecords` = ?,`mSleepTime` = ?,`mSleepDeepLengthTime` = ?,`mSleepPiecemealTime` = ?,`mSleepAIRecords` = ?,`mPressureTime` = ?,`mPressureValue` = ?,`mPressureAIRecords` = ?,`mBloodGlucose2Time` = ?,`mBloodGlucose2Value` = ?,`mBloodGlucose2AIRecords` = ?,`mWeightTime` = ?,`mWeightValue` = ?,`mWeightAIRecords` = ?,`mWeekSportsTime` = ?,`mWeekSportsNumber` = ?,`mWeekSportsAllTime` = ?,`mWeekSportsAIRecords` = ?,`mIsSync` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final HealthyReport entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMUserGender());
                statement.bindDouble(3, entity.getMUserWeight());
                statement.bindDouble(4, entity.getMUserHeight());
                statement.bindLong(5, entity.getMTime());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMLocalTime());
                }
                statement.bindLong(7, entity.getMAbnormalNumber());
                statement.bindLong(8, entity.getMHeartRateTime());
                statement.bindLong(9, entity.getMHeartRateValue());
                if (entity.getMHeartRateAIRecords() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMHeartRateAIRecords());
                }
                statement.bindLong(11, entity.getMBloodPressureTime());
                statement.bindLong(12, entity.getMSystolicValue());
                statement.bindLong(13, entity.getMDiastolicValue());
                if (entity.getMBloodPressureAIRecords() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMBloodPressureAIRecords());
                }
                statement.bindLong(15, entity.getMBloodOxygenTime());
                statement.bindLong(16, entity.getMBloodOxygenValue());
                if (entity.getMBloodOxygenAIRecords() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMBloodOxygenAIRecords());
                }
                statement.bindLong(18, entity.getMSleepTime());
                statement.bindDouble(19, entity.getMSleepDeepLengthTime());
                statement.bindDouble(20, entity.getMSleepPiecemealTime());
                if (entity.getMSleepAIRecords() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getMSleepAIRecords());
                }
                statement.bindLong(22, entity.getMPressureTime());
                statement.bindLong(23, entity.getMPressureValue());
                if (entity.getMPressureAIRecords() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getMPressureAIRecords());
                }
                statement.bindLong(25, entity.getMBloodGlucose2Time());
                statement.bindDouble(26, entity.getMBloodGlucose2Value());
                if (entity.getMBloodGlucose2AIRecords() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getMBloodGlucose2AIRecords());
                }
                statement.bindLong(28, entity.getMWeightTime());
                statement.bindDouble(29, entity.getMWeightValue());
                if (entity.getMWeightAIRecords() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getMWeightAIRecords());
                }
                statement.bindLong(31, entity.getMWeekSportsTime());
                statement.bindLong(32, entity.getMWeekSportsNumber());
                statement.bindLong(33, entity.getMWeekSportsAllTime());
                if (entity.getMWeekSportsAIRecords() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getMWeekSportsAIRecords());
                }
                statement.bindLong(35, entity.getMIsSync());
                statement.bindLong(36, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.HealthyReportDao
    public HealthyReport getHealthyReport(final long id) {
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
        HealthyReport healthyReport;
        String string;
        String string2;
        String string3;
        int i;
        String string4;
        int i2;
        String string5;
        int i3;
        String string6;
        int i4;
        String string7;
        int i5;
        String string8;
        int i6;
        String string9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM healthyReport WHERE  mId = ?", 1);
        acquire.bindLong(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mUserGender");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mUserWeight");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserHeight");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAbnormalNumber");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateValue");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateAIRecords");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mBloodPressureTime");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mSystolicValue");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mDiastolicValue");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mBloodPressureAIRecords");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenValue");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenAIRecords");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mSleepTime");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mSleepDeepLengthTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mSleepPiecemealTime");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mSleepAIRecords");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mPressureTime");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mPressureValue");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mPressureAIRecords");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2Time");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2Value");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2AIRecords");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mWeightTime");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mWeightValue");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mWeightAIRecords");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsTime");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsNumber");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsAllTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsAIRecords");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            if (query.moveToFirst()) {
                int i7 = query.getInt(columnIndexOrThrow);
                int i8 = query.getInt(columnIndexOrThrow2);
                float f = query.getFloat(columnIndexOrThrow3);
                float f2 = query.getFloat(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow6);
                }
                int i9 = query.getInt(columnIndexOrThrow7);
                long j2 = query.getLong(columnIndexOrThrow8);
                int i10 = query.getInt(columnIndexOrThrow9);
                if (query.isNull(columnIndexOrThrow10)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow10);
                }
                long j3 = query.getLong(columnIndexOrThrow11);
                int i11 = query.getInt(columnIndexOrThrow12);
                int i12 = query.getInt(columnIndexOrThrow13);
                if (query.isNull(columnIndexOrThrow14)) {
                    i = columnIndexOrThrow15;
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow14);
                    i = columnIndexOrThrow15;
                }
                long j4 = query.getLong(i);
                int i13 = query.getInt(columnIndexOrThrow16);
                if (query.isNull(columnIndexOrThrow17)) {
                    i2 = columnIndexOrThrow18;
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow17);
                    i2 = columnIndexOrThrow18;
                }
                long j5 = query.getLong(i2);
                float f3 = query.getFloat(columnIndexOrThrow19);
                float f4 = query.getFloat(columnIndexOrThrow20);
                if (query.isNull(columnIndexOrThrow21)) {
                    i3 = columnIndexOrThrow22;
                    string5 = null;
                } else {
                    string5 = query.getString(columnIndexOrThrow21);
                    i3 = columnIndexOrThrow22;
                }
                long j6 = query.getLong(i3);
                int i14 = query.getInt(columnIndexOrThrow23);
                if (query.isNull(columnIndexOrThrow24)) {
                    i4 = columnIndexOrThrow25;
                    string6 = null;
                } else {
                    string6 = query.getString(columnIndexOrThrow24);
                    i4 = columnIndexOrThrow25;
                }
                long j7 = query.getLong(i4);
                float f5 = query.getFloat(columnIndexOrThrow26);
                if (query.isNull(columnIndexOrThrow27)) {
                    i5 = columnIndexOrThrow28;
                    string7 = null;
                } else {
                    string7 = query.getString(columnIndexOrThrow27);
                    i5 = columnIndexOrThrow28;
                }
                long j8 = query.getLong(i5);
                float f6 = query.getFloat(columnIndexOrThrow29);
                if (query.isNull(columnIndexOrThrow30)) {
                    i6 = columnIndexOrThrow31;
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow30);
                    i6 = columnIndexOrThrow31;
                }
                long j9 = query.getLong(i6);
                int i15 = query.getInt(columnIndexOrThrow32);
                int i16 = query.getInt(columnIndexOrThrow33);
                if (query.isNull(columnIndexOrThrow34)) {
                    string9 = null;
                } else {
                    string9 = query.getString(columnIndexOrThrow34);
                }
                healthyReport = new HealthyReport(i7, i8, f, f2, j, string, i9, j2, i10, string2, j3, i11, i12, string3, j4, i13, string4, j5, f3, f4, string5, j6, i14, string6, j7, f5, string7, j8, f6, string8, j9, i15, i16, string9, query.getInt(columnIndexOrThrow35));
            } else {
                healthyReport = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return healthyReport;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.sma.smartv3.db.dao.HealthyReportDao
    public List<HealthyReport> getListASC() {
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
        String string2;
        String string3;
        String string4;
        int i;
        String string5;
        int i2;
        String string6;
        int i3;
        String string7;
        int i4;
        String string8;
        int i5;
        String string9;
        int i6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM healthyReport WHERE  mTime > 0  ORDER BY mTime ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mUserGender");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mUserWeight");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mUserHeight");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mTime");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAbnormalNumber");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateTime");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateValue");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mHeartRateAIRecords");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mBloodPressureTime");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mSystolicValue");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mDiastolicValue");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mBloodPressureAIRecords");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenTime");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenValue");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mBloodOxygenAIRecords");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mSleepTime");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mSleepDeepLengthTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mSleepPiecemealTime");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mSleepAIRecords");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mPressureTime");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mPressureValue");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mPressureAIRecords");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2Time");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2Value");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mBloodGlucose2AIRecords");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mWeightTime");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mWeightValue");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mWeightAIRecords");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsTime");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsNumber");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsAllTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mWeekSportsAIRecords");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i8 = query.getInt(columnIndexOrThrow);
                int i9 = query.getInt(columnIndexOrThrow2);
                float f = query.getFloat(columnIndexOrThrow3);
                float f2 = query.getFloat(columnIndexOrThrow4);
                long j = query.getLong(columnIndexOrThrow5);
                if (query.isNull(columnIndexOrThrow6)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow6);
                }
                int i10 = query.getInt(columnIndexOrThrow7);
                long j2 = query.getLong(columnIndexOrThrow8);
                int i11 = query.getInt(columnIndexOrThrow9);
                if (query.isNull(columnIndexOrThrow10)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow10);
                }
                long j3 = query.getLong(columnIndexOrThrow11);
                int i12 = query.getInt(columnIndexOrThrow12);
                int i13 = query.getInt(columnIndexOrThrow13);
                int i14 = i7;
                if (query.isNull(i14)) {
                    string3 = null;
                } else {
                    string3 = query.getString(i14);
                }
                int i15 = columnIndexOrThrow15;
                int i16 = columnIndexOrThrow;
                long j4 = query.getLong(i15);
                int i17 = columnIndexOrThrow16;
                int i18 = query.getInt(i17);
                columnIndexOrThrow16 = i17;
                int i19 = columnIndexOrThrow17;
                if (query.isNull(i19)) {
                    columnIndexOrThrow17 = i19;
                    i = columnIndexOrThrow18;
                    string4 = null;
                } else {
                    string4 = query.getString(i19);
                    columnIndexOrThrow17 = i19;
                    i = columnIndexOrThrow18;
                }
                long j5 = query.getLong(i);
                columnIndexOrThrow18 = i;
                int i20 = columnIndexOrThrow19;
                float f3 = query.getFloat(i20);
                columnIndexOrThrow19 = i20;
                int i21 = columnIndexOrThrow20;
                float f4 = query.getFloat(i21);
                columnIndexOrThrow20 = i21;
                int i22 = columnIndexOrThrow21;
                if (query.isNull(i22)) {
                    columnIndexOrThrow21 = i22;
                    i2 = columnIndexOrThrow22;
                    string5 = null;
                } else {
                    string5 = query.getString(i22);
                    columnIndexOrThrow21 = i22;
                    i2 = columnIndexOrThrow22;
                }
                long j6 = query.getLong(i2);
                columnIndexOrThrow22 = i2;
                int i23 = columnIndexOrThrow23;
                int i24 = query.getInt(i23);
                columnIndexOrThrow23 = i23;
                int i25 = columnIndexOrThrow24;
                if (query.isNull(i25)) {
                    columnIndexOrThrow24 = i25;
                    i3 = columnIndexOrThrow25;
                    string6 = null;
                } else {
                    string6 = query.getString(i25);
                    columnIndexOrThrow24 = i25;
                    i3 = columnIndexOrThrow25;
                }
                long j7 = query.getLong(i3);
                columnIndexOrThrow25 = i3;
                int i26 = columnIndexOrThrow26;
                float f5 = query.getFloat(i26);
                columnIndexOrThrow26 = i26;
                int i27 = columnIndexOrThrow27;
                if (query.isNull(i27)) {
                    columnIndexOrThrow27 = i27;
                    i4 = columnIndexOrThrow28;
                    string7 = null;
                } else {
                    string7 = query.getString(i27);
                    columnIndexOrThrow27 = i27;
                    i4 = columnIndexOrThrow28;
                }
                long j8 = query.getLong(i4);
                columnIndexOrThrow28 = i4;
                int i28 = columnIndexOrThrow29;
                float f6 = query.getFloat(i28);
                columnIndexOrThrow29 = i28;
                int i29 = columnIndexOrThrow30;
                if (query.isNull(i29)) {
                    columnIndexOrThrow30 = i29;
                    i5 = columnIndexOrThrow31;
                    string8 = null;
                } else {
                    string8 = query.getString(i29);
                    columnIndexOrThrow30 = i29;
                    i5 = columnIndexOrThrow31;
                }
                long j9 = query.getLong(i5);
                columnIndexOrThrow31 = i5;
                int i30 = columnIndexOrThrow32;
                int i31 = query.getInt(i30);
                columnIndexOrThrow32 = i30;
                int i32 = columnIndexOrThrow33;
                int i33 = query.getInt(i32);
                columnIndexOrThrow33 = i32;
                int i34 = columnIndexOrThrow34;
                if (query.isNull(i34)) {
                    columnIndexOrThrow34 = i34;
                    i6 = columnIndexOrThrow35;
                    string9 = null;
                } else {
                    string9 = query.getString(i34);
                    columnIndexOrThrow34 = i34;
                    i6 = columnIndexOrThrow35;
                }
                columnIndexOrThrow35 = i6;
                arrayList.add(new HealthyReport(i8, i9, f, f2, j, string, i10, j2, i11, string2, j3, i12, i13, string3, j4, i18, string4, j5, f3, f4, string5, j6, i24, string6, j7, f5, string7, j8, f6, string8, j9, i31, i33, string9, query.getInt(i6)));
                columnIndexOrThrow = i16;
                columnIndexOrThrow15 = i15;
                i7 = i14;
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

    @Override // com.sma.smartv3.db.dao.HealthyReportDao
    public long[] insert(final List<HealthyReport> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfHealthyReport.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.HealthyReportDao
    public int update(final List<HealthyReport> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfHealthyReport.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.HealthyReportDao
    public long insert(final HealthyReport mHealthyReport) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfHealthyReport_1.insertAndReturnId(mHealthyReport);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }
}
