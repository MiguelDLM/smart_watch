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
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes12.dex */
public final class WorkoutDao_Impl implements WorkoutDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Workout> __insertionAdapterOfWorkout;
    private final EntityDeletionOrUpdateAdapter<Workout> __updateAdapterOfWorkout;
    private final WorkoutConverter __workoutConverter = new WorkoutConverter();

    public WorkoutDao_Impl(@NonNull final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkout = new EntityInsertionAdapter<Workout>(__db) { // from class: com.sma.smartv3.db.dao.WorkoutDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR ABORT INTO `Workout` (`mId`,`mStart`,`mEnd`,`mLocalTime`,`mDuration`,`mAltitude`,`mAirPressure`,`mSpm`,`mMode`,`mStep`,`mDistance`,`mCalorie`,`mSpeed`,`mPace`,`mAvgBpm`,`mMaxBpm`,`mMinBpm`,`mMaxSpm`,`mMinSpm`,`mMaxPace`,`mMinPace`,`mMaxAltitude`,`mMinAltitude`,`mMinStress`,`mMaxStress`,`mAvgStress`,`mSource`,`mIsSync`,`mIsDelete`,`mFeel`,`mPrototype`,`mFirmwareFlag`,`mBleName`,`mPlatform`,`mMaxSpeed`,`mMinSpeed`,`mRestDuration`,`mAGpsType`,`mType`,`mMetTotal`,`mAerobic`,`mAnaerobic`,`mStamina`,`mAvgSpeed`,`mCadence`,`mMaxCadence`,`mCnt`,`mBpmZoneCount`,`mPersonalZone`,`mLactateThresholdPace`,`mRecoveryTime`,`mTrainingLoad`,`mMaxVO2`,`mLactateThresholdHr`,`mAlgorithmMarking`,`mPathCount`,`mPathSampleInterval`,`mPathPoints`,`mHrPathCount`,`mHrPathSampleInterval`,`mHrPathPoints`,`mPacePathCount`,`mPacePathSampleInterval`,`mPacePathPoints`,`mSpeedPathCount`,`mSpeedPathSampleInterval`,`mSpeedPathPoints`,`mCadencePathCount`,`mCadencePathSampleInterval`,`mCadencePathPoints`,`mAltitudePathCount`,`mAltitudePathSampleInterval`,`mAltitudePathPoints`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Workout entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMStart());
                statement.bindLong(3, entity.getMEnd());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMLocalTime());
                }
                statement.bindLong(5, entity.getMDuration());
                statement.bindLong(6, entity.getMAltitude());
                statement.bindLong(7, entity.getMAirPressure());
                statement.bindLong(8, entity.getMSpm());
                statement.bindLong(9, entity.getMMode());
                statement.bindLong(10, entity.getMStep());
                statement.bindLong(11, entity.getMDistance());
                statement.bindLong(12, entity.getMCalorie());
                statement.bindLong(13, entity.getMSpeed());
                statement.bindLong(14, entity.getMPace());
                statement.bindLong(15, entity.getMAvgBpm());
                statement.bindLong(16, entity.getMMaxBpm());
                statement.bindLong(17, entity.getMMinBpm());
                statement.bindLong(18, entity.getMMaxSpm());
                statement.bindLong(19, entity.getMMinSpm());
                statement.bindLong(20, entity.getMMaxPace());
                statement.bindLong(21, entity.getMMinPace());
                statement.bindLong(22, entity.getMMaxAltitude());
                statement.bindLong(23, entity.getMMinAltitude());
                statement.bindLong(24, entity.getMMinStress());
                statement.bindLong(25, entity.getMMaxStress());
                statement.bindLong(26, entity.getMAvgStress());
                statement.bindLong(27, entity.getMSource());
                statement.bindLong(28, entity.getMIsSync());
                statement.bindLong(29, entity.getMIsDelete());
                statement.bindLong(30, entity.getMFeel());
                if (entity.getMPrototype() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getMPrototype());
                }
                if (entity.getMFirmwareFlag() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getMFirmwareFlag());
                }
                if (entity.getMBleName() == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, entity.getMBleName());
                }
                if (entity.getMPlatform() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getMPlatform());
                }
                statement.bindLong(35, entity.getMMaxSpeed());
                statement.bindLong(36, entity.getMMinSpeed());
                statement.bindLong(37, entity.getMRestDuration());
                statement.bindLong(38, entity.getMAGpsType());
                statement.bindLong(39, entity.getMType());
                statement.bindLong(40, entity.getMMetTotal());
                statement.bindDouble(41, entity.getMAerobic());
                statement.bindDouble(42, entity.getMAnaerobic());
                statement.bindLong(43, entity.getMStamina());
                statement.bindDouble(44, entity.getMAvgSpeed());
                statement.bindLong(45, entity.getMCadence());
                statement.bindLong(46, entity.getMMaxCadence());
                statement.bindLong(47, entity.getMCnt());
                String fromIntArray = WorkoutDao_Impl.this.__workoutConverter.fromIntArray(entity.getMBpmZoneCount());
                if (fromIntArray == null) {
                    statement.bindNull(48);
                } else {
                    statement.bindString(48, fromIntArray);
                }
                String fromIntArray2 = WorkoutDao_Impl.this.__workoutConverter.fromIntArray(entity.getMPersonalZone());
                if (fromIntArray2 == null) {
                    statement.bindNull(49);
                } else {
                    statement.bindString(49, fromIntArray2);
                }
                statement.bindLong(50, entity.getMLactateThresholdPace());
                statement.bindLong(51, entity.getMRecoveryTime());
                statement.bindLong(52, entity.getMTrainingLoad());
                statement.bindLong(53, entity.getMMaxVO2());
                statement.bindLong(54, entity.getMLactateThresholdHr());
                statement.bindLong(55, entity.getMAlgorithmMarking());
                statement.bindLong(56, entity.getMPathCount());
                statement.bindLong(57, entity.getMPathSampleInterval());
                String floatArrayListToString = WorkoutDao_Impl.this.__workoutConverter.floatArrayListToString(entity.getMPathPoints());
                if (floatArrayListToString == null) {
                    statement.bindNull(58);
                } else {
                    statement.bindString(58, floatArrayListToString);
                }
                statement.bindLong(59, entity.getMHrPathCount());
                statement.bindLong(60, entity.getMHrPathSampleInterval());
                String stopWatchListToString = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMHrPathPoints());
                if (stopWatchListToString == null) {
                    statement.bindNull(61);
                } else {
                    statement.bindString(61, stopWatchListToString);
                }
                statement.bindLong(62, entity.getMPacePathCount());
                statement.bindLong(63, entity.getMPacePathSampleInterval());
                String stopWatchListToString2 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMPacePathPoints());
                if (stopWatchListToString2 == null) {
                    statement.bindNull(64);
                } else {
                    statement.bindString(64, stopWatchListToString2);
                }
                statement.bindLong(65, entity.getMSpeedPathCount());
                statement.bindLong(66, entity.getMSpeedPathSampleInterval());
                String stopWatchListToString3 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMSpeedPathPoints());
                if (stopWatchListToString3 == null) {
                    statement.bindNull(67);
                } else {
                    statement.bindString(67, stopWatchListToString3);
                }
                statement.bindLong(68, entity.getMCadencePathCount());
                statement.bindLong(69, entity.getMCadencePathSampleInterval());
                String stopWatchListToString4 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMCadencePathPoints());
                if (stopWatchListToString4 == null) {
                    statement.bindNull(70);
                } else {
                    statement.bindString(70, stopWatchListToString4);
                }
                statement.bindLong(71, entity.getMAltitudePathCount());
                statement.bindLong(72, entity.getMAltitudePathSampleInterval());
                String stopWatchListToString5 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMAltitudePathPoints());
                if (stopWatchListToString5 == null) {
                    statement.bindNull(73);
                } else {
                    statement.bindString(73, stopWatchListToString5);
                }
            }
        };
        this.__updateAdapterOfWorkout = new EntityDeletionOrUpdateAdapter<Workout>(__db) { // from class: com.sma.smartv3.db.dao.WorkoutDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `Workout` SET `mId` = ?,`mStart` = ?,`mEnd` = ?,`mLocalTime` = ?,`mDuration` = ?,`mAltitude` = ?,`mAirPressure` = ?,`mSpm` = ?,`mMode` = ?,`mStep` = ?,`mDistance` = ?,`mCalorie` = ?,`mSpeed` = ?,`mPace` = ?,`mAvgBpm` = ?,`mMaxBpm` = ?,`mMinBpm` = ?,`mMaxSpm` = ?,`mMinSpm` = ?,`mMaxPace` = ?,`mMinPace` = ?,`mMaxAltitude` = ?,`mMinAltitude` = ?,`mMinStress` = ?,`mMaxStress` = ?,`mAvgStress` = ?,`mSource` = ?,`mIsSync` = ?,`mIsDelete` = ?,`mFeel` = ?,`mPrototype` = ?,`mFirmwareFlag` = ?,`mBleName` = ?,`mPlatform` = ?,`mMaxSpeed` = ?,`mMinSpeed` = ?,`mRestDuration` = ?,`mAGpsType` = ?,`mType` = ?,`mMetTotal` = ?,`mAerobic` = ?,`mAnaerobic` = ?,`mStamina` = ?,`mAvgSpeed` = ?,`mCadence` = ?,`mMaxCadence` = ?,`mCnt` = ?,`mBpmZoneCount` = ?,`mPersonalZone` = ?,`mLactateThresholdPace` = ?,`mRecoveryTime` = ?,`mTrainingLoad` = ?,`mMaxVO2` = ?,`mLactateThresholdHr` = ?,`mAlgorithmMarking` = ?,`mPathCount` = ?,`mPathSampleInterval` = ?,`mPathPoints` = ?,`mHrPathCount` = ?,`mHrPathSampleInterval` = ?,`mHrPathPoints` = ?,`mPacePathCount` = ?,`mPacePathSampleInterval` = ?,`mPacePathPoints` = ?,`mSpeedPathCount` = ?,`mSpeedPathSampleInterval` = ?,`mSpeedPathPoints` = ?,`mCadencePathCount` = ?,`mCadencePathSampleInterval` = ?,`mCadencePathPoints` = ?,`mAltitudePathCount` = ?,`mAltitudePathSampleInterval` = ?,`mAltitudePathPoints` = ? WHERE `mId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(@NonNull final SupportSQLiteStatement statement, @NonNull final Workout entity) {
                statement.bindLong(1, entity.getMId());
                statement.bindLong(2, entity.getMStart());
                statement.bindLong(3, entity.getMEnd());
                if (entity.getMLocalTime() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMLocalTime());
                }
                statement.bindLong(5, entity.getMDuration());
                statement.bindLong(6, entity.getMAltitude());
                statement.bindLong(7, entity.getMAirPressure());
                statement.bindLong(8, entity.getMSpm());
                statement.bindLong(9, entity.getMMode());
                statement.bindLong(10, entity.getMStep());
                statement.bindLong(11, entity.getMDistance());
                statement.bindLong(12, entity.getMCalorie());
                statement.bindLong(13, entity.getMSpeed());
                statement.bindLong(14, entity.getMPace());
                statement.bindLong(15, entity.getMAvgBpm());
                statement.bindLong(16, entity.getMMaxBpm());
                statement.bindLong(17, entity.getMMinBpm());
                statement.bindLong(18, entity.getMMaxSpm());
                statement.bindLong(19, entity.getMMinSpm());
                statement.bindLong(20, entity.getMMaxPace());
                statement.bindLong(21, entity.getMMinPace());
                statement.bindLong(22, entity.getMMaxAltitude());
                statement.bindLong(23, entity.getMMinAltitude());
                statement.bindLong(24, entity.getMMinStress());
                statement.bindLong(25, entity.getMMaxStress());
                statement.bindLong(26, entity.getMAvgStress());
                statement.bindLong(27, entity.getMSource());
                statement.bindLong(28, entity.getMIsSync());
                statement.bindLong(29, entity.getMIsDelete());
                statement.bindLong(30, entity.getMFeel());
                if (entity.getMPrototype() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getMPrototype());
                }
                if (entity.getMFirmwareFlag() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getMFirmwareFlag());
                }
                if (entity.getMBleName() == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, entity.getMBleName());
                }
                if (entity.getMPlatform() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getMPlatform());
                }
                statement.bindLong(35, entity.getMMaxSpeed());
                statement.bindLong(36, entity.getMMinSpeed());
                statement.bindLong(37, entity.getMRestDuration());
                statement.bindLong(38, entity.getMAGpsType());
                statement.bindLong(39, entity.getMType());
                statement.bindLong(40, entity.getMMetTotal());
                statement.bindDouble(41, entity.getMAerobic());
                statement.bindDouble(42, entity.getMAnaerobic());
                statement.bindLong(43, entity.getMStamina());
                statement.bindDouble(44, entity.getMAvgSpeed());
                statement.bindLong(45, entity.getMCadence());
                statement.bindLong(46, entity.getMMaxCadence());
                statement.bindLong(47, entity.getMCnt());
                String fromIntArray = WorkoutDao_Impl.this.__workoutConverter.fromIntArray(entity.getMBpmZoneCount());
                if (fromIntArray == null) {
                    statement.bindNull(48);
                } else {
                    statement.bindString(48, fromIntArray);
                }
                String fromIntArray2 = WorkoutDao_Impl.this.__workoutConverter.fromIntArray(entity.getMPersonalZone());
                if (fromIntArray2 == null) {
                    statement.bindNull(49);
                } else {
                    statement.bindString(49, fromIntArray2);
                }
                statement.bindLong(50, entity.getMLactateThresholdPace());
                statement.bindLong(51, entity.getMRecoveryTime());
                statement.bindLong(52, entity.getMTrainingLoad());
                statement.bindLong(53, entity.getMMaxVO2());
                statement.bindLong(54, entity.getMLactateThresholdHr());
                statement.bindLong(55, entity.getMAlgorithmMarking());
                statement.bindLong(56, entity.getMPathCount());
                statement.bindLong(57, entity.getMPathSampleInterval());
                String floatArrayListToString = WorkoutDao_Impl.this.__workoutConverter.floatArrayListToString(entity.getMPathPoints());
                if (floatArrayListToString == null) {
                    statement.bindNull(58);
                } else {
                    statement.bindString(58, floatArrayListToString);
                }
                statement.bindLong(59, entity.getMHrPathCount());
                statement.bindLong(60, entity.getMHrPathSampleInterval());
                String stopWatchListToString = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMHrPathPoints());
                if (stopWatchListToString == null) {
                    statement.bindNull(61);
                } else {
                    statement.bindString(61, stopWatchListToString);
                }
                statement.bindLong(62, entity.getMPacePathCount());
                statement.bindLong(63, entity.getMPacePathSampleInterval());
                String stopWatchListToString2 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMPacePathPoints());
                if (stopWatchListToString2 == null) {
                    statement.bindNull(64);
                } else {
                    statement.bindString(64, stopWatchListToString2);
                }
                statement.bindLong(65, entity.getMSpeedPathCount());
                statement.bindLong(66, entity.getMSpeedPathSampleInterval());
                String stopWatchListToString3 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMSpeedPathPoints());
                if (stopWatchListToString3 == null) {
                    statement.bindNull(67);
                } else {
                    statement.bindString(67, stopWatchListToString3);
                }
                statement.bindLong(68, entity.getMCadencePathCount());
                statement.bindLong(69, entity.getMCadencePathSampleInterval());
                String stopWatchListToString4 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMCadencePathPoints());
                if (stopWatchListToString4 == null) {
                    statement.bindNull(70);
                } else {
                    statement.bindString(70, stopWatchListToString4);
                }
                statement.bindLong(71, entity.getMAltitudePathCount());
                statement.bindLong(72, entity.getMAltitudePathSampleInterval());
                String stopWatchListToString5 = WorkoutDao_Impl.this.__workoutConverter.stopWatchListToString(entity.getMAltitudePathPoints());
                if (stopWatchListToString5 == null) {
                    statement.bindNull(73);
                } else {
                    statement.bindString(73, stopWatchListToString5);
                }
                statement.bindLong(74, entity.getMId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public Workout getFitnessWorkout(final long endTime, final int mode) {
        RoomSQLiteQuery roomSQLiteQuery;
        Workout workout;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mEnd = ? AND mMode = ? LIMIT 1", 2);
        acquire.bindLong(1, endTime);
        acquire.bindLong(2, mode);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    if (query.moveToFirst()) {
                        int i5 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i6 = query.getInt(columnIndexOrThrow5);
                        int i7 = query.getInt(columnIndexOrThrow6);
                        int i8 = query.getInt(columnIndexOrThrow7);
                        int i9 = query.getInt(columnIndexOrThrow8);
                        int i10 = query.getInt(columnIndexOrThrow9);
                        int i11 = query.getInt(columnIndexOrThrow10);
                        int i12 = query.getInt(columnIndexOrThrow11);
                        int i13 = query.getInt(columnIndexOrThrow12);
                        int i14 = query.getInt(columnIndexOrThrow13);
                        int i15 = query.getInt(columnIndexOrThrow14);
                        int i16 = query.getInt(columnIndexOrThrow15);
                        int i17 = query.getInt(columnIndexOrThrow16);
                        int i18 = query.getInt(columnIndexOrThrow17);
                        int i19 = query.getInt(columnIndexOrThrow18);
                        int i20 = query.getInt(columnIndexOrThrow19);
                        int i21 = query.getInt(columnIndexOrThrow20);
                        int i22 = query.getInt(columnIndexOrThrow21);
                        int i23 = query.getInt(columnIndexOrThrow22);
                        int i24 = query.getInt(columnIndexOrThrow23);
                        int i25 = query.getInt(columnIndexOrThrow24);
                        int i26 = query.getInt(columnIndexOrThrow25);
                        int i27 = query.getInt(columnIndexOrThrow26);
                        int i28 = query.getInt(columnIndexOrThrow27);
                        int i29 = query.getInt(columnIndexOrThrow28);
                        int i30 = query.getInt(columnIndexOrThrow29);
                        int i31 = query.getInt(columnIndexOrThrow30);
                        if (query.isNull(columnIndexOrThrow31)) {
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(columnIndexOrThrow31);
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            i4 = columnIndexOrThrow35;
                        }
                        int i32 = query.getInt(i4);
                        int i33 = query.getInt(columnIndexOrThrow36);
                        int i34 = query.getInt(columnIndexOrThrow37);
                        int i35 = query.getInt(columnIndexOrThrow38);
                        int i36 = query.getInt(columnIndexOrThrow39);
                        int i37 = query.getInt(columnIndexOrThrow40);
                        float f = query.getFloat(columnIndexOrThrow41);
                        float f2 = query.getFloat(columnIndexOrThrow42);
                        int i38 = query.getInt(columnIndexOrThrow43);
                        float f3 = query.getFloat(columnIndexOrThrow44);
                        int i39 = query.getInt(columnIndexOrThrow45);
                        int i40 = query.getInt(columnIndexOrThrow46);
                        int i41 = query.getInt(columnIndexOrThrow47);
                        if (query.isNull(columnIndexOrThrow48)) {
                            string6 = null;
                        } else {
                            string6 = query.getString(columnIndexOrThrow48);
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            if (query.isNull(columnIndexOrThrow49)) {
                                string7 = null;
                            } else {
                                string7 = query.getString(columnIndexOrThrow49);
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i42 = query.getInt(columnIndexOrThrow50);
                            int i43 = query.getInt(columnIndexOrThrow51);
                            int i44 = query.getInt(columnIndexOrThrow52);
                            int i45 = query.getInt(columnIndexOrThrow53);
                            int i46 = query.getInt(columnIndexOrThrow54);
                            int i47 = query.getInt(columnIndexOrThrow55);
                            int i48 = query.getInt(columnIndexOrThrow56);
                            int i49 = query.getInt(columnIndexOrThrow57);
                            if (query.isNull(columnIndexOrThrow58)) {
                                string8 = null;
                            } else {
                                string8 = query.getString(columnIndexOrThrow58);
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i50 = query.getInt(columnIndexOrThrow59);
                            int i51 = query.getInt(columnIndexOrThrow60);
                            if (query.isNull(columnIndexOrThrow61)) {
                                string9 = null;
                            } else {
                                string9 = query.getString(columnIndexOrThrow61);
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i52 = query.getInt(columnIndexOrThrow62);
                            int i53 = query.getInt(columnIndexOrThrow63);
                            if (query.isNull(columnIndexOrThrow64)) {
                                string10 = null;
                            } else {
                                string10 = query.getString(columnIndexOrThrow64);
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i54 = query.getInt(columnIndexOrThrow65);
                            int i55 = query.getInt(columnIndexOrThrow66);
                            if (query.isNull(columnIndexOrThrow67)) {
                                string11 = null;
                            } else {
                                string11 = query.getString(columnIndexOrThrow67);
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i56 = query.getInt(columnIndexOrThrow68);
                            int i57 = query.getInt(columnIndexOrThrow69);
                            if (query.isNull(columnIndexOrThrow70)) {
                                string12 = null;
                            } else {
                                string12 = query.getString(columnIndexOrThrow70);
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i58 = query.getInt(columnIndexOrThrow71);
                            int i59 = query.getInt(columnIndexOrThrow72);
                            if (query.isNull(columnIndexOrThrow73)) {
                                string13 = null;
                            } else {
                                string13 = query.getString(columnIndexOrThrow73);
                            }
                            workout = new Workout(i5, j, j2, string, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, string2, string3, string4, string5, i32, i33, i34, i35, i36, i37, f, f2, i38, f3, i39, i40, i41, intArray, intArray2, i42, i43, i44, i45, i46, i47, i48, i49, floatArrayToWatchList, i50, i51, stringToStopWatchList, i52, i53, stringToStopWatchList2, i54, i55, stringToStopWatchList3, i56, i57, stringToStopWatchList4, i58, i59, this.__workoutConverter.stringToStopWatchList(string13));
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        workout = null;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return workout;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getList() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        int i5;
        int i6;
        String string6;
        int i7;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE  mStart > 0 ORDER BY mStart ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string6 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string6 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string7 = null;
                            } else {
                                string7 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string8 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string8 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string9 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string9 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string10 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string10 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string11 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string11 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string12 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string12 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string13 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string13 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string2, string3, string4, string5, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string13)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListASC() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        int i5;
        int i6;
        String string6;
        int i7;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE  mIsSync = 0 AND mStart > 0 ORDER BY mStart ASC LIMIT 150", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string6 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string6 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string7 = null;
                            } else {
                                string7 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string8 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string8 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string9 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string9 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string10 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string10 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string11 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string11 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string12 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string12 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string13 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string13 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string2, string3, string4, string5, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string13)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListByMode(final int mode, final int source) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        int i5;
        int i6;
        String string6;
        int i7;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mMode = ? AND mIsDelete != 1 AND mSource = ?", 2);
        acquire.bindLong(1, mode);
        acquire.bindLong(2, source);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string6 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string6 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string7 = null;
                            } else {
                                string7 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string8 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string8 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string9 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string9 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string10 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string10 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string11 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string11 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string12 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string12 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string13 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string13 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string2, string3, string4, string5, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string13)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListDESC(final int startIndex, final int endIndex, final int filterMode) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        int i2;
        String string3;
        int i3;
        String string4;
        int i4;
        int i5;
        int i6;
        String string5;
        int i7;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mStart > 0 AND mMode != 0 AND mMode != ? AND mIsDelete != 1 ORDER BY mStart DESC LIMIT ?, ?", 3);
        acquire.bindLong(1, filterMode);
        acquire.bindLong(2, startIndex);
        acquire.bindLong(3, endIndex);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        String string13 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string = null;
                        } else {
                            string = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string2 = null;
                        } else {
                            string2 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string3 = null;
                        } else {
                            string3 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string4 = null;
                        } else {
                            string4 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string5 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string5 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string5);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string6 = null;
                            } else {
                                string6 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string6);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string7 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string7 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string7);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string8 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string8 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string8);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string9 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string9 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string9);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string10 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string10 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string11 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string11 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string12 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string12 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string13, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string, string2, string3, string4, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string12)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListDESCByMode(final int startIndex, final int endIndex, final int mode) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        int i5;
        int i6;
        String string6;
        int i7;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mStart > 0 AND mMode = ? AND mIsDelete != 1 ORDER BY mStart DESC LIMIT ?, ?", 3);
        acquire.bindLong(1, mode);
        acquire.bindLong(2, startIndex);
        acquire.bindLong(3, endIndex);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string6 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string6 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string7 = null;
                            } else {
                                string7 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string8 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string8 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string9 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string9 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string10 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string10 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string11 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string11 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string12 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string12 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string13 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string13 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string2, string3, string4, string5, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string13)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListModeDESC(final long startTime, final long endTime, final int filterMode) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        int i5;
        int i6;
        String string6;
        int i7;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mStart >= ? AND mEnd <= ?  AND mMode == ? AND mIsDelete !=1 ORDER BY mStart DESC", 3);
        acquire.bindLong(1, startTime);
        acquire.bindLong(2, endTime);
        acquire.bindLong(3, filterMode);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string6 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string6 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string7 = null;
                            } else {
                                string7 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string8 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string8 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string9 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string9 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string10 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string10 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string11 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string11 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string12 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string12 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string13 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string13 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string2, string3, string4, string5, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string13)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public Workout getWorkout(final long startTime, final long endTime) {
        RoomSQLiteQuery roomSQLiteQuery;
        Workout workout;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mStart = ? AND mEnd = ?", 2);
        acquire.bindLong(1, startTime);
        acquire.bindLong(2, endTime);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    if (query.moveToFirst()) {
                        int i5 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i6 = query.getInt(columnIndexOrThrow5);
                        int i7 = query.getInt(columnIndexOrThrow6);
                        int i8 = query.getInt(columnIndexOrThrow7);
                        int i9 = query.getInt(columnIndexOrThrow8);
                        int i10 = query.getInt(columnIndexOrThrow9);
                        int i11 = query.getInt(columnIndexOrThrow10);
                        int i12 = query.getInt(columnIndexOrThrow11);
                        int i13 = query.getInt(columnIndexOrThrow12);
                        int i14 = query.getInt(columnIndexOrThrow13);
                        int i15 = query.getInt(columnIndexOrThrow14);
                        int i16 = query.getInt(columnIndexOrThrow15);
                        int i17 = query.getInt(columnIndexOrThrow16);
                        int i18 = query.getInt(columnIndexOrThrow17);
                        int i19 = query.getInt(columnIndexOrThrow18);
                        int i20 = query.getInt(columnIndexOrThrow19);
                        int i21 = query.getInt(columnIndexOrThrow20);
                        int i22 = query.getInt(columnIndexOrThrow21);
                        int i23 = query.getInt(columnIndexOrThrow22);
                        int i24 = query.getInt(columnIndexOrThrow23);
                        int i25 = query.getInt(columnIndexOrThrow24);
                        int i26 = query.getInt(columnIndexOrThrow25);
                        int i27 = query.getInt(columnIndexOrThrow26);
                        int i28 = query.getInt(columnIndexOrThrow27);
                        int i29 = query.getInt(columnIndexOrThrow28);
                        int i30 = query.getInt(columnIndexOrThrow29);
                        int i31 = query.getInt(columnIndexOrThrow30);
                        if (query.isNull(columnIndexOrThrow31)) {
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(columnIndexOrThrow31);
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            i4 = columnIndexOrThrow35;
                        }
                        int i32 = query.getInt(i4);
                        int i33 = query.getInt(columnIndexOrThrow36);
                        int i34 = query.getInt(columnIndexOrThrow37);
                        int i35 = query.getInt(columnIndexOrThrow38);
                        int i36 = query.getInt(columnIndexOrThrow39);
                        int i37 = query.getInt(columnIndexOrThrow40);
                        float f = query.getFloat(columnIndexOrThrow41);
                        float f2 = query.getFloat(columnIndexOrThrow42);
                        int i38 = query.getInt(columnIndexOrThrow43);
                        float f3 = query.getFloat(columnIndexOrThrow44);
                        int i39 = query.getInt(columnIndexOrThrow45);
                        int i40 = query.getInt(columnIndexOrThrow46);
                        int i41 = query.getInt(columnIndexOrThrow47);
                        if (query.isNull(columnIndexOrThrow48)) {
                            string6 = null;
                        } else {
                            string6 = query.getString(columnIndexOrThrow48);
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            if (query.isNull(columnIndexOrThrow49)) {
                                string7 = null;
                            } else {
                                string7 = query.getString(columnIndexOrThrow49);
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i42 = query.getInt(columnIndexOrThrow50);
                            int i43 = query.getInt(columnIndexOrThrow51);
                            int i44 = query.getInt(columnIndexOrThrow52);
                            int i45 = query.getInt(columnIndexOrThrow53);
                            int i46 = query.getInt(columnIndexOrThrow54);
                            int i47 = query.getInt(columnIndexOrThrow55);
                            int i48 = query.getInt(columnIndexOrThrow56);
                            int i49 = query.getInt(columnIndexOrThrow57);
                            if (query.isNull(columnIndexOrThrow58)) {
                                string8 = null;
                            } else {
                                string8 = query.getString(columnIndexOrThrow58);
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i50 = query.getInt(columnIndexOrThrow59);
                            int i51 = query.getInt(columnIndexOrThrow60);
                            if (query.isNull(columnIndexOrThrow61)) {
                                string9 = null;
                            } else {
                                string9 = query.getString(columnIndexOrThrow61);
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i52 = query.getInt(columnIndexOrThrow62);
                            int i53 = query.getInt(columnIndexOrThrow63);
                            if (query.isNull(columnIndexOrThrow64)) {
                                string10 = null;
                            } else {
                                string10 = query.getString(columnIndexOrThrow64);
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i54 = query.getInt(columnIndexOrThrow65);
                            int i55 = query.getInt(columnIndexOrThrow66);
                            if (query.isNull(columnIndexOrThrow67)) {
                                string11 = null;
                            } else {
                                string11 = query.getString(columnIndexOrThrow67);
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i56 = query.getInt(columnIndexOrThrow68);
                            int i57 = query.getInt(columnIndexOrThrow69);
                            if (query.isNull(columnIndexOrThrow70)) {
                                string12 = null;
                            } else {
                                string12 = query.getString(columnIndexOrThrow70);
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i58 = query.getInt(columnIndexOrThrow71);
                            int i59 = query.getInt(columnIndexOrThrow72);
                            if (query.isNull(columnIndexOrThrow73)) {
                                string13 = null;
                            } else {
                                string13 = query.getString(columnIndexOrThrow73);
                            }
                            workout = new Workout(i5, j, j2, string, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, string2, string3, string4, string5, i32, i33, i34, i35, i36, i37, f, f2, i38, f3, i39, i40, i41, intArray, intArray2, i42, i43, i44, i45, i46, i47, i48, i49, floatArrayToWatchList, i50, i51, stringToStopWatchList, i52, i53, stringToStopWatchList2, i54, i55, stringToStopWatchList3, i56, i57, stringToStopWatchList4, i58, i59, this.__workoutConverter.stringToStopWatchList(string13));
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        workout = null;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return workout;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public Workout getWorkoutById(final int id) {
        RoomSQLiteQuery roomSQLiteQuery;
        Workout workout;
        String string;
        String string2;
        int i;
        String string3;
        int i2;
        String string4;
        int i3;
        String string5;
        int i4;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mId = ?", 1);
        acquire.bindLong(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    if (query.moveToFirst()) {
                        int i5 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        int i6 = query.getInt(columnIndexOrThrow5);
                        int i7 = query.getInt(columnIndexOrThrow6);
                        int i8 = query.getInt(columnIndexOrThrow7);
                        int i9 = query.getInt(columnIndexOrThrow8);
                        int i10 = query.getInt(columnIndexOrThrow9);
                        int i11 = query.getInt(columnIndexOrThrow10);
                        int i12 = query.getInt(columnIndexOrThrow11);
                        int i13 = query.getInt(columnIndexOrThrow12);
                        int i14 = query.getInt(columnIndexOrThrow13);
                        int i15 = query.getInt(columnIndexOrThrow14);
                        int i16 = query.getInt(columnIndexOrThrow15);
                        int i17 = query.getInt(columnIndexOrThrow16);
                        int i18 = query.getInt(columnIndexOrThrow17);
                        int i19 = query.getInt(columnIndexOrThrow18);
                        int i20 = query.getInt(columnIndexOrThrow19);
                        int i21 = query.getInt(columnIndexOrThrow20);
                        int i22 = query.getInt(columnIndexOrThrow21);
                        int i23 = query.getInt(columnIndexOrThrow22);
                        int i24 = query.getInt(columnIndexOrThrow23);
                        int i25 = query.getInt(columnIndexOrThrow24);
                        int i26 = query.getInt(columnIndexOrThrow25);
                        int i27 = query.getInt(columnIndexOrThrow26);
                        int i28 = query.getInt(columnIndexOrThrow27);
                        int i29 = query.getInt(columnIndexOrThrow28);
                        int i30 = query.getInt(columnIndexOrThrow29);
                        int i31 = query.getInt(columnIndexOrThrow30);
                        if (query.isNull(columnIndexOrThrow31)) {
                            i = columnIndexOrThrow32;
                            string2 = null;
                        } else {
                            string2 = query.getString(columnIndexOrThrow31);
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            i2 = columnIndexOrThrow33;
                            string3 = null;
                        } else {
                            string3 = query.getString(i);
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            i3 = columnIndexOrThrow34;
                            string4 = null;
                        } else {
                            string4 = query.getString(i2);
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            i4 = columnIndexOrThrow35;
                            string5 = null;
                        } else {
                            string5 = query.getString(i3);
                            i4 = columnIndexOrThrow35;
                        }
                        int i32 = query.getInt(i4);
                        int i33 = query.getInt(columnIndexOrThrow36);
                        int i34 = query.getInt(columnIndexOrThrow37);
                        int i35 = query.getInt(columnIndexOrThrow38);
                        int i36 = query.getInt(columnIndexOrThrow39);
                        int i37 = query.getInt(columnIndexOrThrow40);
                        float f = query.getFloat(columnIndexOrThrow41);
                        float f2 = query.getFloat(columnIndexOrThrow42);
                        int i38 = query.getInt(columnIndexOrThrow43);
                        float f3 = query.getFloat(columnIndexOrThrow44);
                        int i39 = query.getInt(columnIndexOrThrow45);
                        int i40 = query.getInt(columnIndexOrThrow46);
                        int i41 = query.getInt(columnIndexOrThrow47);
                        if (query.isNull(columnIndexOrThrow48)) {
                            string6 = null;
                        } else {
                            string6 = query.getString(columnIndexOrThrow48);
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string6);
                            if (query.isNull(columnIndexOrThrow49)) {
                                string7 = null;
                            } else {
                                string7 = query.getString(columnIndexOrThrow49);
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string7);
                            int i42 = query.getInt(columnIndexOrThrow50);
                            int i43 = query.getInt(columnIndexOrThrow51);
                            int i44 = query.getInt(columnIndexOrThrow52);
                            int i45 = query.getInt(columnIndexOrThrow53);
                            int i46 = query.getInt(columnIndexOrThrow54);
                            int i47 = query.getInt(columnIndexOrThrow55);
                            int i48 = query.getInt(columnIndexOrThrow56);
                            int i49 = query.getInt(columnIndexOrThrow57);
                            if (query.isNull(columnIndexOrThrow58)) {
                                string8 = null;
                            } else {
                                string8 = query.getString(columnIndexOrThrow58);
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string8);
                            int i50 = query.getInt(columnIndexOrThrow59);
                            int i51 = query.getInt(columnIndexOrThrow60);
                            if (query.isNull(columnIndexOrThrow61)) {
                                string9 = null;
                            } else {
                                string9 = query.getString(columnIndexOrThrow61);
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string9);
                            int i52 = query.getInt(columnIndexOrThrow62);
                            int i53 = query.getInt(columnIndexOrThrow63);
                            if (query.isNull(columnIndexOrThrow64)) {
                                string10 = null;
                            } else {
                                string10 = query.getString(columnIndexOrThrow64);
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i54 = query.getInt(columnIndexOrThrow65);
                            int i55 = query.getInt(columnIndexOrThrow66);
                            if (query.isNull(columnIndexOrThrow67)) {
                                string11 = null;
                            } else {
                                string11 = query.getString(columnIndexOrThrow67);
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i56 = query.getInt(columnIndexOrThrow68);
                            int i57 = query.getInt(columnIndexOrThrow69);
                            if (query.isNull(columnIndexOrThrow70)) {
                                string12 = null;
                            } else {
                                string12 = query.getString(columnIndexOrThrow70);
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string12);
                            int i58 = query.getInt(columnIndexOrThrow71);
                            int i59 = query.getInt(columnIndexOrThrow72);
                            if (query.isNull(columnIndexOrThrow73)) {
                                string13 = null;
                            } else {
                                string13 = query.getString(columnIndexOrThrow73);
                            }
                            workout = new Workout(i5, j, j2, string, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, string2, string3, string4, string5, i32, i33, i34, i35, i36, i37, f, f2, i38, f3, i39, i40, i41, intArray, intArray2, i42, i43, i44, i45, i46, i47, i48, i49, floatArrayToWatchList, i50, i51, stringToStopWatchList, i52, i53, stringToStopWatchList2, i54, i55, stringToStopWatchList3, i56, i57, stringToStopWatchList4, i58, i59, this.__workoutConverter.stringToStopWatchList(string13));
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        workout = null;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return workout;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public long[] insert(final List<Workout> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfWorkout.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public int update(final List<Workout> lists) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfWorkout.handleMultiple(lists);
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public int update(final Workout workout) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handle = this.__updateAdapterOfWorkout.handle(workout);
            this.__db.setTransactionSuccessful();
            return handle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.sma.smartv3.db.dao.WorkoutDao
    public List<Workout> getListDESC(final long startTime, final long endTime, final int filterMode) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        int i2;
        String string3;
        int i3;
        String string4;
        int i4;
        int i5;
        int i6;
        String string5;
        int i7;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Workout WHERE mStart >= ? AND mEnd <= ?  AND mMode != ? AND mIsDelete !=1 ORDER BY mStart DESC", 3);
        acquire.bindLong(1, startTime);
        acquire.bindLong(2, endTime);
        acquire.bindLong(3, filterMode);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "mId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mStart");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mEnd");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mLocalTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mDuration");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mAltitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mAirPressure");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "mSpm");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "mMode");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "mStep");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "mDistance");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mCalorie");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "mSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "mPace");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mAvgBpm");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "mMaxBpm");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mMinBpm");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpm");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpm");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "mMaxPace");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "mMinPace");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mMaxAltitude");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "mMinAltitude");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mMinStress");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mMaxStress");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mAvgStress");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mSource");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "mIsSync");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "mIsDelete");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "mFeel");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "mPrototype");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "mFirmwareFlag");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "mBleName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "mPlatform");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "mMaxSpeed");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "mMinSpeed");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "mRestDuration");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "mAGpsType");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "mType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "mMetTotal");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "mAerobic");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "mAnaerobic");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "mStamina");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "mAvgSpeed");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "mCadence");
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "mMaxCadence");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "mCnt");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "mBpmZoneCount");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "mPersonalZone");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdPace");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "mRecoveryTime");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "mTrainingLoad");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "mMaxVO2");
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "mLactateThresholdHr");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "mAlgorithmMarking");
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "mPathCount");
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "mPathSampleInterval");
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "mPathPoints");
                    int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathCount");
                    int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathSampleInterval");
                    int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "mHrPathPoints");
                    int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathCount");
                    int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathSampleInterval");
                    int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "mPacePathPoints");
                    int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathCount");
                    int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathSampleInterval");
                    int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "mSpeedPathPoints");
                    int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathCount");
                    int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathSampleInterval");
                    int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "mCadencePathPoints");
                    int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathCount");
                    int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathSampleInterval");
                    int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "mAltitudePathPoints");
                    int i8 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i9 = query.getInt(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        String string13 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        int i10 = query.getInt(columnIndexOrThrow5);
                        int i11 = query.getInt(columnIndexOrThrow6);
                        int i12 = query.getInt(columnIndexOrThrow7);
                        int i13 = query.getInt(columnIndexOrThrow8);
                        int i14 = query.getInt(columnIndexOrThrow9);
                        int i15 = query.getInt(columnIndexOrThrow10);
                        int i16 = query.getInt(columnIndexOrThrow11);
                        int i17 = query.getInt(columnIndexOrThrow12);
                        int i18 = query.getInt(columnIndexOrThrow13);
                        int i19 = i8;
                        int i20 = query.getInt(i19);
                        int i21 = columnIndexOrThrow;
                        int i22 = columnIndexOrThrow15;
                        int i23 = query.getInt(i22);
                        columnIndexOrThrow15 = i22;
                        int i24 = columnIndexOrThrow16;
                        int i25 = query.getInt(i24);
                        columnIndexOrThrow16 = i24;
                        int i26 = columnIndexOrThrow17;
                        int i27 = query.getInt(i26);
                        columnIndexOrThrow17 = i26;
                        int i28 = columnIndexOrThrow18;
                        int i29 = query.getInt(i28);
                        columnIndexOrThrow18 = i28;
                        int i30 = columnIndexOrThrow19;
                        int i31 = query.getInt(i30);
                        columnIndexOrThrow19 = i30;
                        int i32 = columnIndexOrThrow20;
                        int i33 = query.getInt(i32);
                        columnIndexOrThrow20 = i32;
                        int i34 = columnIndexOrThrow21;
                        int i35 = query.getInt(i34);
                        columnIndexOrThrow21 = i34;
                        int i36 = columnIndexOrThrow22;
                        int i37 = query.getInt(i36);
                        columnIndexOrThrow22 = i36;
                        int i38 = columnIndexOrThrow23;
                        int i39 = query.getInt(i38);
                        columnIndexOrThrow23 = i38;
                        int i40 = columnIndexOrThrow24;
                        int i41 = query.getInt(i40);
                        columnIndexOrThrow24 = i40;
                        int i42 = columnIndexOrThrow25;
                        int i43 = query.getInt(i42);
                        columnIndexOrThrow25 = i42;
                        int i44 = columnIndexOrThrow26;
                        int i45 = query.getInt(i44);
                        columnIndexOrThrow26 = i44;
                        int i46 = columnIndexOrThrow27;
                        int i47 = query.getInt(i46);
                        columnIndexOrThrow27 = i46;
                        int i48 = columnIndexOrThrow28;
                        int i49 = query.getInt(i48);
                        columnIndexOrThrow28 = i48;
                        int i50 = columnIndexOrThrow29;
                        int i51 = query.getInt(i50);
                        columnIndexOrThrow29 = i50;
                        int i52 = columnIndexOrThrow30;
                        int i53 = query.getInt(i52);
                        columnIndexOrThrow30 = i52;
                        int i54 = columnIndexOrThrow31;
                        if (query.isNull(i54)) {
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                            string = null;
                        } else {
                            string = query.getString(i54);
                            columnIndexOrThrow31 = i54;
                            i = columnIndexOrThrow32;
                        }
                        if (query.isNull(i)) {
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                            string2 = null;
                        } else {
                            string2 = query.getString(i);
                            columnIndexOrThrow32 = i;
                            i2 = columnIndexOrThrow33;
                        }
                        if (query.isNull(i2)) {
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                            string3 = null;
                        } else {
                            string3 = query.getString(i2);
                            columnIndexOrThrow33 = i2;
                            i3 = columnIndexOrThrow34;
                        }
                        if (query.isNull(i3)) {
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                            string4 = null;
                        } else {
                            string4 = query.getString(i3);
                            columnIndexOrThrow34 = i3;
                            i4 = columnIndexOrThrow35;
                        }
                        int i55 = query.getInt(i4);
                        columnIndexOrThrow35 = i4;
                        int i56 = columnIndexOrThrow36;
                        int i57 = query.getInt(i56);
                        columnIndexOrThrow36 = i56;
                        int i58 = columnIndexOrThrow37;
                        int i59 = query.getInt(i58);
                        columnIndexOrThrow37 = i58;
                        int i60 = columnIndexOrThrow38;
                        int i61 = query.getInt(i60);
                        columnIndexOrThrow38 = i60;
                        int i62 = columnIndexOrThrow39;
                        int i63 = query.getInt(i62);
                        columnIndexOrThrow39 = i62;
                        int i64 = columnIndexOrThrow40;
                        int i65 = query.getInt(i64);
                        columnIndexOrThrow40 = i64;
                        int i66 = columnIndexOrThrow41;
                        float f = query.getFloat(i66);
                        columnIndexOrThrow41 = i66;
                        int i67 = columnIndexOrThrow42;
                        float f2 = query.getFloat(i67);
                        columnIndexOrThrow42 = i67;
                        int i68 = columnIndexOrThrow43;
                        int i69 = query.getInt(i68);
                        columnIndexOrThrow43 = i68;
                        int i70 = columnIndexOrThrow44;
                        float f3 = query.getFloat(i70);
                        columnIndexOrThrow44 = i70;
                        int i71 = columnIndexOrThrow45;
                        int i72 = query.getInt(i71);
                        columnIndexOrThrow45 = i71;
                        int i73 = columnIndexOrThrow46;
                        int i74 = query.getInt(i73);
                        columnIndexOrThrow46 = i73;
                        int i75 = columnIndexOrThrow47;
                        int i76 = query.getInt(i75);
                        columnIndexOrThrow47 = i75;
                        int i77 = columnIndexOrThrow48;
                        if (query.isNull(i77)) {
                            i5 = i77;
                            i7 = i19;
                            i6 = columnIndexOrThrow13;
                            string5 = null;
                        } else {
                            i5 = i77;
                            i6 = columnIndexOrThrow13;
                            string5 = query.getString(i77);
                            i7 = i19;
                        }
                        try {
                            int[] intArray = this.__workoutConverter.toIntArray(string5);
                            int i78 = columnIndexOrThrow49;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow49 = i78;
                                string6 = null;
                            } else {
                                string6 = query.getString(i78);
                                columnIndexOrThrow49 = i78;
                            }
                            int[] intArray2 = this.__workoutConverter.toIntArray(string6);
                            int i79 = columnIndexOrThrow50;
                            int i80 = query.getInt(i79);
                            int i81 = columnIndexOrThrow51;
                            int i82 = query.getInt(i81);
                            columnIndexOrThrow50 = i79;
                            int i83 = columnIndexOrThrow52;
                            int i84 = query.getInt(i83);
                            columnIndexOrThrow52 = i83;
                            int i85 = columnIndexOrThrow53;
                            int i86 = query.getInt(i85);
                            columnIndexOrThrow53 = i85;
                            int i87 = columnIndexOrThrow54;
                            int i88 = query.getInt(i87);
                            columnIndexOrThrow54 = i87;
                            int i89 = columnIndexOrThrow55;
                            int i90 = query.getInt(i89);
                            columnIndexOrThrow55 = i89;
                            int i91 = columnIndexOrThrow56;
                            int i92 = query.getInt(i91);
                            columnIndexOrThrow56 = i91;
                            int i93 = columnIndexOrThrow57;
                            int i94 = query.getInt(i93);
                            columnIndexOrThrow57 = i93;
                            int i95 = columnIndexOrThrow58;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow58 = i95;
                                columnIndexOrThrow51 = i81;
                                string7 = null;
                            } else {
                                columnIndexOrThrow58 = i95;
                                string7 = query.getString(i95);
                                columnIndexOrThrow51 = i81;
                            }
                            List<float[]> floatArrayToWatchList = this.__workoutConverter.floatArrayToWatchList(string7);
                            int i96 = columnIndexOrThrow59;
                            int i97 = query.getInt(i96);
                            int i98 = columnIndexOrThrow60;
                            int i99 = query.getInt(i98);
                            columnIndexOrThrow59 = i96;
                            int i100 = columnIndexOrThrow61;
                            if (query.isNull(i100)) {
                                columnIndexOrThrow61 = i100;
                                columnIndexOrThrow60 = i98;
                                string8 = null;
                            } else {
                                columnIndexOrThrow61 = i100;
                                string8 = query.getString(i100);
                                columnIndexOrThrow60 = i98;
                            }
                            List<Integer> stringToStopWatchList = this.__workoutConverter.stringToStopWatchList(string8);
                            int i101 = columnIndexOrThrow62;
                            int i102 = query.getInt(i101);
                            int i103 = columnIndexOrThrow63;
                            int i104 = query.getInt(i103);
                            columnIndexOrThrow62 = i101;
                            int i105 = columnIndexOrThrow64;
                            if (query.isNull(i105)) {
                                columnIndexOrThrow64 = i105;
                                columnIndexOrThrow63 = i103;
                                string9 = null;
                            } else {
                                columnIndexOrThrow64 = i105;
                                string9 = query.getString(i105);
                                columnIndexOrThrow63 = i103;
                            }
                            List<Integer> stringToStopWatchList2 = this.__workoutConverter.stringToStopWatchList(string9);
                            int i106 = columnIndexOrThrow65;
                            int i107 = query.getInt(i106);
                            int i108 = columnIndexOrThrow66;
                            int i109 = query.getInt(i108);
                            columnIndexOrThrow65 = i106;
                            int i110 = columnIndexOrThrow67;
                            if (query.isNull(i110)) {
                                columnIndexOrThrow67 = i110;
                                columnIndexOrThrow66 = i108;
                                string10 = null;
                            } else {
                                columnIndexOrThrow67 = i110;
                                string10 = query.getString(i110);
                                columnIndexOrThrow66 = i108;
                            }
                            List<Integer> stringToStopWatchList3 = this.__workoutConverter.stringToStopWatchList(string10);
                            int i111 = columnIndexOrThrow68;
                            int i112 = query.getInt(i111);
                            int i113 = columnIndexOrThrow69;
                            int i114 = query.getInt(i113);
                            columnIndexOrThrow68 = i111;
                            int i115 = columnIndexOrThrow70;
                            if (query.isNull(i115)) {
                                columnIndexOrThrow70 = i115;
                                columnIndexOrThrow69 = i113;
                                string11 = null;
                            } else {
                                columnIndexOrThrow70 = i115;
                                string11 = query.getString(i115);
                                columnIndexOrThrow69 = i113;
                            }
                            List<Integer> stringToStopWatchList4 = this.__workoutConverter.stringToStopWatchList(string11);
                            int i116 = columnIndexOrThrow71;
                            int i117 = query.getInt(i116);
                            int i118 = columnIndexOrThrow72;
                            int i119 = query.getInt(i118);
                            columnIndexOrThrow71 = i116;
                            int i120 = columnIndexOrThrow73;
                            if (query.isNull(i120)) {
                                columnIndexOrThrow73 = i120;
                                columnIndexOrThrow72 = i118;
                                string12 = null;
                            } else {
                                columnIndexOrThrow73 = i120;
                                string12 = query.getString(i120);
                                columnIndexOrThrow72 = i118;
                            }
                            arrayList.add(new Workout(i9, j, j2, string13, i10, i11, i12, i13, i14, i15, i16, i17, i18, i20, i23, i25, i27, i29, i31, i33, i35, i37, i39, i41, i43, i45, i47, i49, i51, i53, string, string2, string3, string4, i55, i57, i59, i61, i63, i65, f, f2, i69, f3, i72, i74, i76, intArray, intArray2, i80, i82, i84, i86, i88, i90, i92, i94, floatArrayToWatchList, i97, i99, stringToStopWatchList, i102, i104, stringToStopWatchList2, i107, i109, stringToStopWatchList3, i112, i114, stringToStopWatchList4, i117, i119, this.__workoutConverter.stringToStopWatchList(string12)));
                            columnIndexOrThrow = i21;
                            columnIndexOrThrow13 = i6;
                            i8 = i7;
                            columnIndexOrThrow48 = i5;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }
}
