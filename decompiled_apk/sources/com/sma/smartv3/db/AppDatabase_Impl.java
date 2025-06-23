package com.sma.smartv3.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.facebook.appevents.AppEventsConstants;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.dao.AIRecordsDao_Impl;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.ActivityDao_Impl;
import com.sma.smartv3.db.dao.AlipayBindInfoDao;
import com.sma.smartv3.db.dao.AlipayBindInfoDao_Impl;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.dao.BloodGlucose2Dao_Impl;
import com.sma.smartv3.db.dao.BloodGlucoseDao;
import com.sma.smartv3.db.dao.BloodGlucoseDao_Impl;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.dao.BloodOxygenDao_Impl;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.dao.BloodPressureDao_Impl;
import com.sma.smartv3.db.dao.DailyPowerDao;
import com.sma.smartv3.db.dao.DailyPowerDao_Impl;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.dao.ElectrocardiogramDao_Impl;
import com.sma.smartv3.db.dao.HanBaoVibrationDao;
import com.sma.smartv3.db.dao.HanBaoVibrationDao_Impl;
import com.sma.smartv3.db.dao.HealthyReportDao;
import com.sma.smartv3.db.dao.HealthyReportDao_Impl;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.HeartRateDao_Impl;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.dao.HrvDao_Impl;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.LocationDao_Impl;
import com.sma.smartv3.db.dao.MatchRecordDao;
import com.sma.smartv3.db.dao.MatchRecordDao_Impl;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.dao.PressureDao_Impl;
import com.sma.smartv3.db.dao.ScheduleDao;
import com.sma.smartv3.db.dao.ScheduleDao_Impl;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.dao.SleepDao_Impl;
import com.sma.smartv3.db.dao.SportDataDao;
import com.sma.smartv3.db.dao.SportDataDao_Impl;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.dao.TemperatureDao_Impl;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.dao.WeightDao_Impl;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.dao.WorkoutDao_Impl;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.dao.WorkoutIndexDao_Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes12.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile AIRecordsDao _aIRecordsDao;
    private volatile ActivityDao _activityDao;
    private volatile AlipayBindInfoDao _alipayBindInfoDao;
    private volatile BloodGlucose2Dao _bloodGlucose2Dao;
    private volatile BloodGlucoseDao _bloodGlucoseDao;
    private volatile BloodOxygenDao _bloodOxygenDao;
    private volatile BloodPressureDao _bloodPressureDao;
    private volatile DailyPowerDao _dailyPowerDao;
    private volatile ElectrocardiogramDao _electrocardiogramDao;
    private volatile HanBaoVibrationDao _hanBaoVibrationDao;
    private volatile HealthyReportDao _healthyReportDao;
    private volatile HeartRateDao _heartRateDao;
    private volatile HrvDao _hrvDao;
    private volatile LocationDao _locationDao;
    private volatile MatchRecordDao _matchRecordDao;
    private volatile PressureDao _pressureDao;
    private volatile ScheduleDao _scheduleDao;
    private volatile SleepDao _sleepDao;
    private volatile SportDataDao _sportDataDao;
    private volatile TemperatureDao _temperatureDao;
    private volatile WeightDao _weightDao;
    private volatile WorkoutDao _workoutDao;
    private volatile WorkoutIndexDao _workoutIndexDao;

    @Override // com.sma.smartv3.db.AppDatabase
    public ActivityDao activityDao() {
        ActivityDao activityDao;
        if (this._activityDao != null) {
            return this._activityDao;
        }
        synchronized (this) {
            try {
                if (this._activityDao == null) {
                    this._activityDao = new ActivityDao_Impl(this);
                }
                activityDao = this._activityDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public AIRecordsDao aiRecordsDao() {
        AIRecordsDao aIRecordsDao;
        if (this._aIRecordsDao != null) {
            return this._aIRecordsDao;
        }
        synchronized (this) {
            try {
                if (this._aIRecordsDao == null) {
                    this._aIRecordsDao = new AIRecordsDao_Impl(this);
                }
                aIRecordsDao = this._aIRecordsDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aIRecordsDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public AlipayBindInfoDao alipayBindInfoDao() {
        AlipayBindInfoDao alipayBindInfoDao;
        if (this._alipayBindInfoDao != null) {
            return this._alipayBindInfoDao;
        }
        synchronized (this) {
            try {
                if (this._alipayBindInfoDao == null) {
                    this._alipayBindInfoDao = new AlipayBindInfoDao_Impl(this);
                }
                alipayBindInfoDao = this._alipayBindInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return alipayBindInfoDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public BloodGlucose2Dao bloodGlucose2Dao() {
        BloodGlucose2Dao bloodGlucose2Dao;
        if (this._bloodGlucose2Dao != null) {
            return this._bloodGlucose2Dao;
        }
        synchronized (this) {
            try {
                if (this._bloodGlucose2Dao == null) {
                    this._bloodGlucose2Dao = new BloodGlucose2Dao_Impl(this);
                }
                bloodGlucose2Dao = this._bloodGlucose2Dao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bloodGlucose2Dao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public BloodGlucoseDao bloodGlucoseDao() {
        BloodGlucoseDao bloodGlucoseDao;
        if (this._bloodGlucoseDao != null) {
            return this._bloodGlucoseDao;
        }
        synchronized (this) {
            try {
                if (this._bloodGlucoseDao == null) {
                    this._bloodGlucoseDao = new BloodGlucoseDao_Impl(this);
                }
                bloodGlucoseDao = this._bloodGlucoseDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bloodGlucoseDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public BloodOxygenDao bloodOxygenDao() {
        BloodOxygenDao bloodOxygenDao;
        if (this._bloodOxygenDao != null) {
            return this._bloodOxygenDao;
        }
        synchronized (this) {
            try {
                if (this._bloodOxygenDao == null) {
                    this._bloodOxygenDao = new BloodOxygenDao_Impl(this);
                }
                bloodOxygenDao = this._bloodOxygenDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bloodOxygenDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public BloodPressureDao bloodPressureDao() {
        BloodPressureDao bloodPressureDao;
        if (this._bloodPressureDao != null) {
            return this._bloodPressureDao;
        }
        synchronized (this) {
            try {
                if (this._bloodPressureDao == null) {
                    this._bloodPressureDao = new BloodPressureDao_Impl(this);
                }
                bloodPressureDao = this._bloodPressureDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bloodPressureDao;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `Activity`");
            writableDatabase.execSQL("DELETE FROM `AIRecords`");
            writableDatabase.execSQL("DELETE FROM `HeartRate`");
            writableDatabase.execSQL("DELETE FROM `BloodPressure`");
            writableDatabase.execSQL("DELETE FROM `Sleep`");
            writableDatabase.execSQL("DELETE FROM `Workout`");
            writableDatabase.execSQL("DELETE FROM `Location`");
            writableDatabase.execSQL("DELETE FROM `Weight`");
            writableDatabase.execSQL("DELETE FROM `Temperature`");
            writableDatabase.execSQL("DELETE FROM `Schedule`");
            writableDatabase.execSQL("DELETE FROM `WorkoutIndex`");
            writableDatabase.execSQL("DELETE FROM `BloodOxygen`");
            writableDatabase.execSQL("DELETE FROM `Hrv`");
            writableDatabase.execSQL("DELETE FROM `Pressure`");
            writableDatabase.execSQL("DELETE FROM `MatchLog`");
            writableDatabase.execSQL("DELETE FROM `MatchPeriod`");
            writableDatabase.execSQL("DELETE FROM `MatchRecord`");
            writableDatabase.execSQL("DELETE FROM `SportData`");
            writableDatabase.execSQL("DELETE FROM `BloodGlucose`");
            writableDatabase.execSQL("DELETE FROM `AlipayBindInfo`");
            writableDatabase.execSQL("DELETE FROM `Electrocardiogram`");
            writableDatabase.execSQL("DELETE FROM `BloodGlucose2`");
            writableDatabase.execSQL("DELETE FROM `HanBaoVibration`");
            writableDatabase.execSQL("DELETE FROM `HealthyReport`");
            writableDatabase.execSQL("DELETE FROM `DailyPower`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Activity", "AIRecords", "HeartRate", "BloodPressure", "Sleep", "Workout", "Location", JNISearchConst.JNI_WEIGHT, "Temperature", AppEventsConstants.EVENT_NAME_SCHEDULE, "WorkoutIndex", "BloodOxygen", "Hrv", "Pressure", "MatchLog", "MatchPeriod", "MatchRecord", "SportData", "BloodGlucose", "AlipayBindInfo", "Electrocardiogram", "BloodGlucose2", "HanBaoVibration", "HealthyReport", "DailyPower");
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(41) { // from class: com.sma.smartv3.db.AppDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `Activity` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mMode` INTEGER NOT NULL, `mState` INTEGER NOT NULL, `mStep` INTEGER NOT NULL, `mCalorie` INTEGER NOT NULL, `mDistance` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Activity_mTime` ON `Activity` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `AIRecords` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mAIFuncType` INTEGER NOT NULL, `mType` INTEGER NOT NULL, `mContent` TEXT NOT NULL, `mExtraInfo` TEXT NOT NULL, `mStatus` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL, `mAITitle` TEXT NOT NULL, `mTranslateLanguage` TEXT NOT NULL, `mTranslateToLanguage` TEXT NOT NULL, `mLocation` TEXT NOT NULL, `mAudioPath` TEXT NOT NULL, `mAudioDuration` INTEGER NOT NULL, `ttsVoiceName` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `HeartRate` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mBpm` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_HeartRate_mTime` ON `HeartRate` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BloodPressure` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mSystolic` INTEGER NOT NULL, `mDiastolic` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BloodPressure_mTime` ON `BloodPressure` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Sleep` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mMode` INTEGER NOT NULL, `mSoft` INTEGER NOT NULL, `mStrong` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mAlgorithmType` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Sleep_mTime` ON `Sleep` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Workout` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mStart` INTEGER NOT NULL, `mEnd` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mDuration` INTEGER NOT NULL, `mAltitude` INTEGER NOT NULL, `mAirPressure` INTEGER NOT NULL, `mSpm` INTEGER NOT NULL, `mMode` INTEGER NOT NULL, `mStep` INTEGER NOT NULL, `mDistance` INTEGER NOT NULL, `mCalorie` INTEGER NOT NULL, `mSpeed` INTEGER NOT NULL, `mPace` INTEGER NOT NULL, `mAvgBpm` INTEGER NOT NULL, `mMaxBpm` INTEGER NOT NULL, `mMinBpm` INTEGER NOT NULL, `mMaxSpm` INTEGER NOT NULL, `mMinSpm` INTEGER NOT NULL, `mMaxPace` INTEGER NOT NULL, `mMinPace` INTEGER NOT NULL, `mMaxAltitude` INTEGER NOT NULL, `mMinAltitude` INTEGER NOT NULL, `mMinStress` INTEGER NOT NULL, `mMaxStress` INTEGER NOT NULL, `mAvgStress` INTEGER NOT NULL, `mSource` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL, `mFeel` INTEGER NOT NULL, `mPrototype` TEXT NOT NULL, `mFirmwareFlag` TEXT NOT NULL, `mBleName` TEXT NOT NULL, `mPlatform` TEXT NOT NULL, `mMaxSpeed` INTEGER NOT NULL, `mMinSpeed` INTEGER NOT NULL, `mRestDuration` INTEGER NOT NULL, `mAGpsType` INTEGER NOT NULL, `mType` INTEGER NOT NULL, `mMetTotal` INTEGER NOT NULL, `mAerobic` REAL NOT NULL, `mAnaerobic` REAL NOT NULL, `mStamina` INTEGER NOT NULL, `mAvgSpeed` REAL NOT NULL, `mCadence` INTEGER NOT NULL, `mMaxCadence` INTEGER NOT NULL, `mCnt` INTEGER NOT NULL, `mBpmZoneCount` TEXT DEFAULT '', `mPersonalZone` TEXT DEFAULT '', `mLactateThresholdPace` INTEGER NOT NULL, `mRecoveryTime` INTEGER NOT NULL, `mTrainingLoad` INTEGER NOT NULL, `mMaxVO2` INTEGER NOT NULL, `mLactateThresholdHr` INTEGER NOT NULL, `mAlgorithmMarking` INTEGER NOT NULL, `mPathCount` INTEGER NOT NULL, `mPathSampleInterval` INTEGER NOT NULL, `mPathPoints` TEXT DEFAULT '', `mHrPathCount` INTEGER NOT NULL, `mHrPathSampleInterval` INTEGER NOT NULL, `mHrPathPoints` TEXT DEFAULT '', `mPacePathCount` INTEGER NOT NULL, `mPacePathSampleInterval` INTEGER NOT NULL, `mPacePathPoints` TEXT DEFAULT '', `mSpeedPathCount` INTEGER NOT NULL, `mSpeedPathSampleInterval` INTEGER NOT NULL, `mSpeedPathPoints` TEXT DEFAULT '', `mCadencePathCount` INTEGER NOT NULL, `mCadencePathSampleInterval` INTEGER NOT NULL, `mCadencePathPoints` TEXT DEFAULT '', `mAltitudePathCount` INTEGER NOT NULL, `mAltitudePathSampleInterval` INTEGER NOT NULL, `mAltitudePathPoints` TEXT DEFAULT '')");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Location` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mActivityMode` INTEGER NOT NULL, `mAltitude` INTEGER NOT NULL, `mLongitude` REAL NOT NULL, `mLatitude` REAL NOT NULL, `mSource` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsBaiDuSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Location_mTime` ON `Location` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Weight` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mWeight` REAL NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsMeasure` INTEGER NOT NULL, `mBmi` REAL NOT NULL, `mRatioOfFat` REAL NOT NULL, `mWeightOfMuscle` REAL NOT NULL, `mWeightOfFat` REAL NOT NULL, `mRatioOfProtein` REAL NOT NULL, `mRatioOfWater` REAL NOT NULL, `mStateOfNutrition` REAL NOT NULL, `mIdealWeight` REAL NOT NULL, `mAgeOfBody` REAL NOT NULL, `mAgeOfBodyRange` TEXT NOT NULL, `mBmiRange` TEXT NOT NULL, `mBmiWHORange` TEXT NOT NULL, `mBmr` REAL NOT NULL, `mBmrRange` TEXT NOT NULL, `mBodyShape` REAL NOT NULL, `mDesirableWeight` REAL NOT NULL, `mFatFreeBodyWeight` REAL NOT NULL, `mFatToControl` REAL NOT NULL, `mLevelOfVisceralFat` REAL NOT NULL, `mLevelOfVisceralFatRange` TEXT NOT NULL, `mMuscleToControl` REAL NOT NULL, `mRatioOfFatRange` TEXT NOT NULL, `mRatioOfMuscle` REAL NOT NULL, `mRatioOfMuscleRange` TEXT NOT NULL, `mRatioOfProteinRange` TEXT NOT NULL, `mRatioOfSkeletalMuscle` REAL NOT NULL, `mRatioOfSkeletalMuscleRange` TEXT NOT NULL, `mRatioOfSubcutaneousFat` REAL NOT NULL, `mRatioOfSubcutaneousFatRange` TEXT NOT NULL, `mRatioOfWaterRange` TEXT NOT NULL, `mScore` REAL NOT NULL, `mWeightOfBone` REAL NOT NULL, `mWeightOfBoneRange` TEXT NOT NULL, `mWeightOfFatRange` TEXT NOT NULL, `mWeightOfMuscleRange` TEXT NOT NULL, `mWeightOfProtein` REAL NOT NULL, `mWeightOfProteinRange` TEXT NOT NULL, `mWeightOfSkeletalMuscle` REAL NOT NULL, `mWeightOfSkeletalMuscleRange` TEXT NOT NULL, `mWeightOfWater` REAL NOT NULL, `mWeightOfWaterRange` TEXT NOT NULL, `mWeightRange` TEXT NOT NULL, `mWeightToControl` REAL NOT NULL, `mWeightWHORange` TEXT NOT NULL, `mIsDelete` INTEGER NOT NULL, `mRatioOfProteinLevel` INTEGER NOT NULL, `mRatioOfWaterLevel` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Weight_mTime` ON `Weight` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Temperature` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mTemperature` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Temperature_mTime` ON `Temperature` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Schedule` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mScheduleId` INTEGER NOT NULL, `mYear` INTEGER NOT NULL, `mMonth` INTEGER NOT NULL, `mDay` INTEGER NOT NULL, `mHour` INTEGER NOT NULL, `mMinute` INTEGER NOT NULL, `mAdvance` INTEGER NOT NULL, `mTitle` TEXT NOT NULL, `mContent` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `WorkoutIndex` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mFrom` INTEGER NOT NULL, `mEndTime` INTEGER NOT NULL, `mMode` INTEGER NOT NULL, `mSyncStatus` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_WorkoutIndex_mEndTime` ON `WorkoutIndex` (`mEndTime`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkoutIndex_mSyncStatus` ON `WorkoutIndex` (`mSyncStatus`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BloodOxygen` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BloodOxygen_mTime` ON `BloodOxygen` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Hrv` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mAvgValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Hrv_mTime` ON `Hrv` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Pressure` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Pressure_mTime` ON `Pressure` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `MatchLog` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mMatchRecordId` INTEGER NOT NULL, `mTime` INTEGER NOT NULL, `mPeriodTime` INTEGER NOT NULL, `mPeriodNumber` INTEGER NOT NULL, `mType` INTEGER NOT NULL, `mCount` INTEGER NOT NULL, `mCancelType` INTEGER NOT NULL, `mTeam` INTEGER NOT NULL, `mPlayer` INTEGER NOT NULL, `mOtherType` INTEGER NOT NULL, `mStopWatchTotal` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `MatchPeriod` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mMatchRecordId` INTEGER NOT NULL, `mDuration` INTEGER NOT NULL, `mDistance` INTEGER NOT NULL, `mStep` INTEGER NOT NULL, `mCalorie` INTEGER NOT NULL, `mSpeed` INTEGER NOT NULL, `mAvgBpm` INTEGER NOT NULL, `mMaxBpm` INTEGER NOT NULL, `mMaxSpeed` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `MatchRecord` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mStart` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mType` INTEGER NOT NULL, `mPeriodListSize` INTEGER NOT NULL, `mLogListSize` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL, `mSource` INTEGER NOT NULL, `mIsStopWatchData` INTEGER NOT NULL, `mStopWatchList` TEXT DEFAULT '', `mTeamInfo` TEXT DEFAULT '', `mWeather` TEXT DEFAULT '', `mHomeTeamScore` INTEGER NOT NULL, `mGuestTeamScore` INTEGER NOT NULL, `mMode` INTEGER NOT NULL, `mMinBpm` INTEGER NOT NULL, `mAirPressure` INTEGER NOT NULL, `mPace` INTEGER NOT NULL, `mMaxPace` INTEGER NOT NULL, `mMinPace` INTEGER NOT NULL, `mSpm` INTEGER NOT NULL, `mMaxSpm` INTEGER NOT NULL, `mMinSpm` INTEGER NOT NULL, `mAltitude` INTEGER NOT NULL, `mMaxAltitude` INTEGER NOT NULL, `mMinAltitude` INTEGER NOT NULL, `p_mId` INTEGER NOT NULL, `p_mMatchRecordId` INTEGER NOT NULL, `p_mDuration` INTEGER NOT NULL, `p_mDistance` INTEGER NOT NULL, `p_mStep` INTEGER NOT NULL, `p_mCalorie` INTEGER NOT NULL, `p_mSpeed` INTEGER NOT NULL, `p_mAvgBpm` INTEGER NOT NULL, `p_mMaxBpm` INTEGER NOT NULL, `p_mMaxSpeed` INTEGER NOT NULL, `p_mIsSync` INTEGER NOT NULL, `p_mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MatchRecord_mStart` ON `MatchRecord` (`mStart`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `SportData` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mStep` INTEGER NOT NULL, `mDistance` INTEGER NOT NULL, `mCalorie` INTEGER NOT NULL, `mDuration` INTEGER NOT NULL, `mSpm` INTEGER NOT NULL, `mAltitude` INTEGER NOT NULL, `mAirPressure` INTEGER NOT NULL, `mPace` INTEGER NOT NULL, `mSpeed` INTEGER NOT NULL, `mMode` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BloodGlucose` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BloodGlucose_mTime` ON `BloodGlucose` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `AlipayBindInfo` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mBleName` TEXT NOT NULL, `mFirmwareFlag` TEXT NOT NULL, `mMacAddress` TEXT NOT NULL, `mFirmwareVersion` TEXT NOT NULL, `mAppVersion` TEXT NOT NULL, `mResult` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_AlipayBindInfo_mTime` ON `AlipayBindInfo` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Electrocardiogram` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Electrocardiogram_mTime` ON `Electrocardiogram` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BloodGlucose2` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mMeasurementId` TEXT NOT NULL, `mUserId` TEXT NOT NULL, `mStartTime` TEXT NOT NULL, `mEndTime` TEXT NOT NULL, `mModelNo` TEXT NOT NULL, `mLowerBound` REAL NOT NULL, `mUpperBound` REAL NOT NULL, `mFasting` INTEGER NOT NULL, `mWithin2hrsMeal` INTEGER NOT NULL, `mCompletedProgress` INTEGER NOT NULL, `mCurrentLevel` INTEGER NOT NULL, `mRiskCode` TEXT NOT NULL, `mInsights` TEXT NOT NULL, `mTips` TEXT NOT NULL, `mLocaleInsights` TEXT NOT NULL, `mLocaleTips` TEXT NOT NULL, `mIsSync` INTEGER NOT NULL, `mIsDelete` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BloodGlucose2_mMeasurementId` ON `BloodGlucose2` (`mMeasurementId`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `HanBaoVibration` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mVibration` INTEGER NOT NULL, `mBOValue` INTEGER NOT NULL, `mIsSnore` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_HanBaoVibration_mTime` ON `HanBaoVibration` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `HealthyReport` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mUserGender` INTEGER NOT NULL, `mUserWeight` REAL NOT NULL, `mUserHeight` REAL NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mAbnormalNumber` INTEGER NOT NULL, `mHeartRateTime` INTEGER NOT NULL, `mHeartRateValue` INTEGER NOT NULL, `mHeartRateAIRecords` TEXT NOT NULL, `mBloodPressureTime` INTEGER NOT NULL, `mSystolicValue` INTEGER NOT NULL, `mDiastolicValue` INTEGER NOT NULL, `mBloodPressureAIRecords` TEXT NOT NULL, `mBloodOxygenTime` INTEGER NOT NULL, `mBloodOxygenValue` INTEGER NOT NULL, `mBloodOxygenAIRecords` TEXT NOT NULL, `mSleepTime` INTEGER NOT NULL, `mSleepDeepLengthTime` REAL NOT NULL, `mSleepPiecemealTime` REAL NOT NULL, `mSleepAIRecords` TEXT NOT NULL, `mPressureTime` INTEGER NOT NULL, `mPressureValue` INTEGER NOT NULL, `mPressureAIRecords` TEXT NOT NULL, `mBloodGlucose2Time` INTEGER NOT NULL, `mBloodGlucose2Value` REAL NOT NULL, `mBloodGlucose2AIRecords` TEXT NOT NULL, `mWeightTime` INTEGER NOT NULL, `mWeightValue` REAL NOT NULL, `mWeightAIRecords` TEXT NOT NULL, `mWeekSportsTime` INTEGER NOT NULL, `mWeekSportsNumber` INTEGER NOT NULL, `mWeekSportsAllTime` INTEGER NOT NULL, `mWeekSportsAIRecords` TEXT NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_HealthyReport_mTime` ON `HealthyReport` (`mTime`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `DailyPower` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mTime` INTEGER NOT NULL, `mLocalTime` TEXT NOT NULL, `mValue` INTEGER NOT NULL, `mIsSync` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_DailyPower_mTime` ON `DailyPower` (`mTime`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '221d5bc67648ba48ba91e15a5ba5c4c9')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `Activity`");
                db.execSQL("DROP TABLE IF EXISTS `AIRecords`");
                db.execSQL("DROP TABLE IF EXISTS `HeartRate`");
                db.execSQL("DROP TABLE IF EXISTS `BloodPressure`");
                db.execSQL("DROP TABLE IF EXISTS `Sleep`");
                db.execSQL("DROP TABLE IF EXISTS `Workout`");
                db.execSQL("DROP TABLE IF EXISTS `Location`");
                db.execSQL("DROP TABLE IF EXISTS `Weight`");
                db.execSQL("DROP TABLE IF EXISTS `Temperature`");
                db.execSQL("DROP TABLE IF EXISTS `Schedule`");
                db.execSQL("DROP TABLE IF EXISTS `WorkoutIndex`");
                db.execSQL("DROP TABLE IF EXISTS `BloodOxygen`");
                db.execSQL("DROP TABLE IF EXISTS `Hrv`");
                db.execSQL("DROP TABLE IF EXISTS `Pressure`");
                db.execSQL("DROP TABLE IF EXISTS `MatchLog`");
                db.execSQL("DROP TABLE IF EXISTS `MatchPeriod`");
                db.execSQL("DROP TABLE IF EXISTS `MatchRecord`");
                db.execSQL("DROP TABLE IF EXISTS `SportData`");
                db.execSQL("DROP TABLE IF EXISTS `BloodGlucose`");
                db.execSQL("DROP TABLE IF EXISTS `AlipayBindInfo`");
                db.execSQL("DROP TABLE IF EXISTS `Electrocardiogram`");
                db.execSQL("DROP TABLE IF EXISTS `BloodGlucose2`");
                db.execSQL("DROP TABLE IF EXISTS `HanBaoVibration`");
                db.execSQL("DROP TABLE IF EXISTS `HealthyReport`");
                db.execSQL("DROP TABLE IF EXISTS `DailyPower`");
                List list = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(@NonNull final SupportSQLiteDatabase db) {
                List list = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(@NonNull final SupportSQLiteDatabase db) {
                ((RoomDatabase) AppDatabase_Impl.this).mDatabase = db;
                AppDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            @NonNull
            public RoomOpenHelper.ValidationResult onValidateSchema(@NonNull final SupportSQLiteDatabase db) {
                HashMap hashMap = new HashMap(10);
                hashMap.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap.put("mState", new TableInfo.Column("mState", "INTEGER", true, 0, null, 1));
                hashMap.put("mStep", new TableInfo.Column("mStep", "INTEGER", true, 0, null, 1));
                hashMap.put("mCalorie", new TableInfo.Column("mCalorie", "INTEGER", true, 0, null, 1));
                hashMap.put("mDistance", new TableInfo.Column("mDistance", "INTEGER", true, 0, null, 1));
                hashMap.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_Activity_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("Activity", hashMap, hashSet, hashSet2);
                TableInfo read = TableInfo.read(db, "Activity");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "Activity(com.sma.smartv3.db.entity.Activity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(17);
                hashMap2.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap2.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap2.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap2.put("mAIFuncType", new TableInfo.Column("mAIFuncType", "INTEGER", true, 0, null, 1));
                hashMap2.put("mType", new TableInfo.Column("mType", "INTEGER", true, 0, null, 1));
                hashMap2.put("mContent", new TableInfo.Column("mContent", "TEXT", true, 0, null, 1));
                hashMap2.put("mExtraInfo", new TableInfo.Column("mExtraInfo", "TEXT", true, 0, null, 1));
                hashMap2.put("mStatus", new TableInfo.Column("mStatus", "INTEGER", true, 0, null, 1));
                hashMap2.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap2.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                hashMap2.put("mAITitle", new TableInfo.Column("mAITitle", "TEXT", true, 0, null, 1));
                hashMap2.put("mTranslateLanguage", new TableInfo.Column("mTranslateLanguage", "TEXT", true, 0, null, 1));
                hashMap2.put("mTranslateToLanguage", new TableInfo.Column("mTranslateToLanguage", "TEXT", true, 0, null, 1));
                hashMap2.put("mLocation", new TableInfo.Column("mLocation", "TEXT", true, 0, null, 1));
                hashMap2.put("mAudioPath", new TableInfo.Column("mAudioPath", "TEXT", true, 0, null, 1));
                hashMap2.put("mAudioDuration", new TableInfo.Column("mAudioDuration", "INTEGER", true, 0, null, 1));
                hashMap2.put("ttsVoiceName", new TableInfo.Column("ttsVoiceName", "TEXT", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("AIRecords", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(db, "AIRecords");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "AIRecords(com.sma.smartv3.db.entity.AIRecords).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(5);
                hashMap3.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap3.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap3.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap3.put("mBpm", new TableInfo.Column("mBpm", "INTEGER", true, 0, null, 1));
                hashMap3.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_HeartRate_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo3 = new TableInfo("HeartRate", hashMap3, hashSet3, hashSet4);
                TableInfo read3 = TableInfo.read(db, "HeartRate");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "HeartRate(com.sma.smartv3.db.entity.HeartRate).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(6);
                hashMap4.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap4.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap4.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap4.put("mSystolic", new TableInfo.Column("mSystolic", "INTEGER", true, 0, null, 1));
                hashMap4.put("mDiastolic", new TableInfo.Column("mDiastolic", "INTEGER", true, 0, null, 1));
                hashMap4.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_BloodPressure_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo4 = new TableInfo("BloodPressure", hashMap4, hashSet5, hashSet6);
                TableInfo read4 = TableInfo.read(db, "BloodPressure");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "BloodPressure(com.sma.smartv3.db.entity.BloodPressure).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(8);
                hashMap5.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap5.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap5.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap5.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap5.put("mSoft", new TableInfo.Column("mSoft", "INTEGER", true, 0, null, 1));
                hashMap5.put("mStrong", new TableInfo.Column("mStrong", "INTEGER", true, 0, null, 1));
                hashMap5.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap5.put("mAlgorithmType", new TableInfo.Column("mAlgorithmType", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_Sleep_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo5 = new TableInfo("Sleep", hashMap5, hashSet7, hashSet8);
                TableInfo read5 = TableInfo.read(db, "Sleep");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "Sleep(com.sma.smartv3.db.entity.Sleep).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(73);
                hashMap6.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap6.put("mStart", new TableInfo.Column("mStart", "INTEGER", true, 0, null, 1));
                hashMap6.put("mEnd", new TableInfo.Column("mEnd", "INTEGER", true, 0, null, 1));
                hashMap6.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap6.put("mDuration", new TableInfo.Column("mDuration", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAltitude", new TableInfo.Column("mAltitude", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAirPressure", new TableInfo.Column("mAirPressure", "INTEGER", true, 0, null, 1));
                hashMap6.put("mSpm", new TableInfo.Column("mSpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap6.put("mStep", new TableInfo.Column("mStep", "INTEGER", true, 0, null, 1));
                hashMap6.put("mDistance", new TableInfo.Column("mDistance", "INTEGER", true, 0, null, 1));
                hashMap6.put("mCalorie", new TableInfo.Column("mCalorie", "INTEGER", true, 0, null, 1));
                hashMap6.put("mSpeed", new TableInfo.Column("mSpeed", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPace", new TableInfo.Column("mPace", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAvgBpm", new TableInfo.Column("mAvgBpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxBpm", new TableInfo.Column("mMaxBpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinBpm", new TableInfo.Column("mMinBpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxSpm", new TableInfo.Column("mMaxSpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinSpm", new TableInfo.Column("mMinSpm", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxPace", new TableInfo.Column("mMaxPace", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinPace", new TableInfo.Column("mMinPace", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxAltitude", new TableInfo.Column("mMaxAltitude", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinAltitude", new TableInfo.Column("mMinAltitude", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinStress", new TableInfo.Column("mMinStress", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxStress", new TableInfo.Column("mMaxStress", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAvgStress", new TableInfo.Column("mAvgStress", "INTEGER", true, 0, null, 1));
                hashMap6.put("mSource", new TableInfo.Column("mSource", "INTEGER", true, 0, null, 1));
                hashMap6.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap6.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                hashMap6.put("mFeel", new TableInfo.Column("mFeel", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPrototype", new TableInfo.Column("mPrototype", "TEXT", true, 0, null, 1));
                hashMap6.put("mFirmwareFlag", new TableInfo.Column("mFirmwareFlag", "TEXT", true, 0, null, 1));
                hashMap6.put("mBleName", new TableInfo.Column("mBleName", "TEXT", true, 0, null, 1));
                hashMap6.put("mPlatform", new TableInfo.Column("mPlatform", "TEXT", true, 0, null, 1));
                hashMap6.put("mMaxSpeed", new TableInfo.Column("mMaxSpeed", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMinSpeed", new TableInfo.Column("mMinSpeed", "INTEGER", true, 0, null, 1));
                hashMap6.put("mRestDuration", new TableInfo.Column("mRestDuration", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAGpsType", new TableInfo.Column("mAGpsType", "INTEGER", true, 0, null, 1));
                hashMap6.put("mType", new TableInfo.Column("mType", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMetTotal", new TableInfo.Column("mMetTotal", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAerobic", new TableInfo.Column("mAerobic", "REAL", true, 0, null, 1));
                hashMap6.put("mAnaerobic", new TableInfo.Column("mAnaerobic", "REAL", true, 0, null, 1));
                hashMap6.put("mStamina", new TableInfo.Column("mStamina", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAvgSpeed", new TableInfo.Column("mAvgSpeed", "REAL", true, 0, null, 1));
                hashMap6.put("mCadence", new TableInfo.Column("mCadence", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxCadence", new TableInfo.Column("mMaxCadence", "INTEGER", true, 0, null, 1));
                hashMap6.put("mCnt", new TableInfo.Column("mCnt", "INTEGER", true, 0, null, 1));
                hashMap6.put("mBpmZoneCount", new TableInfo.Column("mBpmZoneCount", "TEXT", false, 0, "''", 1));
                hashMap6.put("mPersonalZone", new TableInfo.Column("mPersonalZone", "TEXT", false, 0, "''", 1));
                hashMap6.put("mLactateThresholdPace", new TableInfo.Column("mLactateThresholdPace", "INTEGER", true, 0, null, 1));
                hashMap6.put("mRecoveryTime", new TableInfo.Column("mRecoveryTime", "INTEGER", true, 0, null, 1));
                hashMap6.put("mTrainingLoad", new TableInfo.Column("mTrainingLoad", "INTEGER", true, 0, null, 1));
                hashMap6.put("mMaxVO2", new TableInfo.Column("mMaxVO2", "INTEGER", true, 0, null, 1));
                hashMap6.put("mLactateThresholdHr", new TableInfo.Column("mLactateThresholdHr", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAlgorithmMarking", new TableInfo.Column("mAlgorithmMarking", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPathCount", new TableInfo.Column("mPathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPathSampleInterval", new TableInfo.Column("mPathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPathPoints", new TableInfo.Column("mPathPoints", "TEXT", false, 0, "''", 1));
                hashMap6.put("mHrPathCount", new TableInfo.Column("mHrPathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mHrPathSampleInterval", new TableInfo.Column("mHrPathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mHrPathPoints", new TableInfo.Column("mHrPathPoints", "TEXT", false, 0, "''", 1));
                hashMap6.put("mPacePathCount", new TableInfo.Column("mPacePathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPacePathSampleInterval", new TableInfo.Column("mPacePathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mPacePathPoints", new TableInfo.Column("mPacePathPoints", "TEXT", false, 0, "''", 1));
                hashMap6.put("mSpeedPathCount", new TableInfo.Column("mSpeedPathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mSpeedPathSampleInterval", new TableInfo.Column("mSpeedPathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mSpeedPathPoints", new TableInfo.Column("mSpeedPathPoints", "TEXT", false, 0, "''", 1));
                hashMap6.put("mCadencePathCount", new TableInfo.Column("mCadencePathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mCadencePathSampleInterval", new TableInfo.Column("mCadencePathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mCadencePathPoints", new TableInfo.Column("mCadencePathPoints", "TEXT", false, 0, "''", 1));
                hashMap6.put("mAltitudePathCount", new TableInfo.Column("mAltitudePathCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAltitudePathSampleInterval", new TableInfo.Column("mAltitudePathSampleInterval", "INTEGER", true, 0, null, 1));
                hashMap6.put("mAltitudePathPoints", new TableInfo.Column("mAltitudePathPoints", "TEXT", false, 0, "''", 1));
                TableInfo tableInfo6 = new TableInfo("Workout", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(db, "Workout");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "Workout(com.sma.smartv3.db.entity.Workout).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(10);
                hashMap7.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap7.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap7.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap7.put("mActivityMode", new TableInfo.Column("mActivityMode", "INTEGER", true, 0, null, 1));
                hashMap7.put("mAltitude", new TableInfo.Column("mAltitude", "INTEGER", true, 0, null, 1));
                hashMap7.put("mLongitude", new TableInfo.Column("mLongitude", "REAL", true, 0, null, 1));
                hashMap7.put("mLatitude", new TableInfo.Column("mLatitude", "REAL", true, 0, null, 1));
                hashMap7.put("mSource", new TableInfo.Column("mSource", "INTEGER", true, 0, null, 1));
                hashMap7.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap7.put("mIsBaiDuSync", new TableInfo.Column("mIsBaiDuSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet9 = new HashSet(0);
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_Location_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo7 = new TableInfo("Location", hashMap7, hashSet9, hashSet10);
                TableInfo read7 = TableInfo.read(db, "Location");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "Location(com.sma.smartv3.db.entity.Location).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(53);
                hashMap8.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap8.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap8.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeight", new TableInfo.Column("mWeight", "REAL", true, 0, null, 1));
                hashMap8.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap8.put("mIsMeasure", new TableInfo.Column("mIsMeasure", "INTEGER", true, 0, null, 1));
                hashMap8.put("mBmi", new TableInfo.Column("mBmi", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfFat", new TableInfo.Column("mRatioOfFat", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfMuscle", new TableInfo.Column("mWeightOfMuscle", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfFat", new TableInfo.Column("mWeightOfFat", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfProtein", new TableInfo.Column("mRatioOfProtein", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfWater", new TableInfo.Column("mRatioOfWater", "REAL", true, 0, null, 1));
                hashMap8.put("mStateOfNutrition", new TableInfo.Column("mStateOfNutrition", "REAL", true, 0, null, 1));
                hashMap8.put("mIdealWeight", new TableInfo.Column("mIdealWeight", "REAL", true, 0, null, 1));
                hashMap8.put("mAgeOfBody", new TableInfo.Column("mAgeOfBody", "REAL", true, 0, null, 1));
                hashMap8.put("mAgeOfBodyRange", new TableInfo.Column("mAgeOfBodyRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mBmiRange", new TableInfo.Column("mBmiRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mBmiWHORange", new TableInfo.Column("mBmiWHORange", "TEXT", true, 0, null, 1));
                hashMap8.put("mBmr", new TableInfo.Column("mBmr", "REAL", true, 0, null, 1));
                hashMap8.put("mBmrRange", new TableInfo.Column("mBmrRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mBodyShape", new TableInfo.Column("mBodyShape", "REAL", true, 0, null, 1));
                hashMap8.put("mDesirableWeight", new TableInfo.Column("mDesirableWeight", "REAL", true, 0, null, 1));
                hashMap8.put("mFatFreeBodyWeight", new TableInfo.Column("mFatFreeBodyWeight", "REAL", true, 0, null, 1));
                hashMap8.put("mFatToControl", new TableInfo.Column("mFatToControl", "REAL", true, 0, null, 1));
                hashMap8.put("mLevelOfVisceralFat", new TableInfo.Column("mLevelOfVisceralFat", "REAL", true, 0, null, 1));
                hashMap8.put("mLevelOfVisceralFatRange", new TableInfo.Column("mLevelOfVisceralFatRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mMuscleToControl", new TableInfo.Column("mMuscleToControl", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfFatRange", new TableInfo.Column("mRatioOfFatRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mRatioOfMuscle", new TableInfo.Column("mRatioOfMuscle", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfMuscleRange", new TableInfo.Column("mRatioOfMuscleRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mRatioOfProteinRange", new TableInfo.Column("mRatioOfProteinRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mRatioOfSkeletalMuscle", new TableInfo.Column("mRatioOfSkeletalMuscle", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfSkeletalMuscleRange", new TableInfo.Column("mRatioOfSkeletalMuscleRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mRatioOfSubcutaneousFat", new TableInfo.Column("mRatioOfSubcutaneousFat", "REAL", true, 0, null, 1));
                hashMap8.put("mRatioOfSubcutaneousFatRange", new TableInfo.Column("mRatioOfSubcutaneousFatRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mRatioOfWaterRange", new TableInfo.Column("mRatioOfWaterRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mScore", new TableInfo.Column("mScore", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfBone", new TableInfo.Column("mWeightOfBone", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfBoneRange", new TableInfo.Column("mWeightOfBoneRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightOfFatRange", new TableInfo.Column("mWeightOfFatRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightOfMuscleRange", new TableInfo.Column("mWeightOfMuscleRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightOfProtein", new TableInfo.Column("mWeightOfProtein", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfProteinRange", new TableInfo.Column("mWeightOfProteinRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightOfSkeletalMuscle", new TableInfo.Column("mWeightOfSkeletalMuscle", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfSkeletalMuscleRange", new TableInfo.Column("mWeightOfSkeletalMuscleRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightOfWater", new TableInfo.Column("mWeightOfWater", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightOfWaterRange", new TableInfo.Column("mWeightOfWaterRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightRange", new TableInfo.Column("mWeightRange", "TEXT", true, 0, null, 1));
                hashMap8.put("mWeightToControl", new TableInfo.Column("mWeightToControl", "REAL", true, 0, null, 1));
                hashMap8.put("mWeightWHORange", new TableInfo.Column("mWeightWHORange", "TEXT", true, 0, null, 1));
                hashMap8.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                hashMap8.put("mRatioOfProteinLevel", new TableInfo.Column("mRatioOfProteinLevel", "INTEGER", true, 0, null, 1));
                hashMap8.put("mRatioOfWaterLevel", new TableInfo.Column("mRatioOfWaterLevel", "INTEGER", true, 0, null, 1));
                HashSet hashSet11 = new HashSet(0);
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_Weight_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo8 = new TableInfo(JNISearchConst.JNI_WEIGHT, hashMap8, hashSet11, hashSet12);
                TableInfo read8 = TableInfo.read(db, JNISearchConst.JNI_WEIGHT);
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "Weight(com.sma.smartv3.db.entity.Weight).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(5);
                hashMap9.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap9.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap9.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap9.put("mTemperature", new TableInfo.Column("mTemperature", "INTEGER", true, 0, null, 1));
                hashMap9.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet13 = new HashSet(0);
                HashSet hashSet14 = new HashSet(1);
                hashSet14.add(new TableInfo.Index("index_Temperature_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo9 = new TableInfo("Temperature", hashMap9, hashSet13, hashSet14);
                TableInfo read9 = TableInfo.read(db, "Temperature");
                if (!tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "Temperature(com.sma.smartv3.db.entity.Temperature).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
                }
                HashMap hashMap10 = new HashMap(10);
                hashMap10.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap10.put("mScheduleId", new TableInfo.Column("mScheduleId", "INTEGER", true, 0, null, 1));
                hashMap10.put("mYear", new TableInfo.Column("mYear", "INTEGER", true, 0, null, 1));
                hashMap10.put("mMonth", new TableInfo.Column("mMonth", "INTEGER", true, 0, null, 1));
                hashMap10.put("mDay", new TableInfo.Column("mDay", "INTEGER", true, 0, null, 1));
                hashMap10.put("mHour", new TableInfo.Column("mHour", "INTEGER", true, 0, null, 1));
                hashMap10.put("mMinute", new TableInfo.Column("mMinute", "INTEGER", true, 0, null, 1));
                hashMap10.put("mAdvance", new TableInfo.Column("mAdvance", "INTEGER", true, 0, null, 1));
                hashMap10.put("mTitle", new TableInfo.Column("mTitle", "TEXT", true, 0, null, 1));
                hashMap10.put("mContent", new TableInfo.Column("mContent", "TEXT", true, 0, null, 1));
                TableInfo tableInfo10 = new TableInfo(AppEventsConstants.EVENT_NAME_SCHEDULE, hashMap10, new HashSet(0), new HashSet(0));
                TableInfo read10 = TableInfo.read(db, AppEventsConstants.EVENT_NAME_SCHEDULE);
                if (!tableInfo10.equals(read10)) {
                    return new RoomOpenHelper.ValidationResult(false, "Schedule(com.sma.smartv3.db.entity.Schedule).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
                }
                HashMap hashMap11 = new HashMap(5);
                hashMap11.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap11.put("mFrom", new TableInfo.Column("mFrom", "INTEGER", true, 0, null, 1));
                hashMap11.put("mEndTime", new TableInfo.Column("mEndTime", "INTEGER", true, 0, null, 1));
                hashMap11.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap11.put("mSyncStatus", new TableInfo.Column("mSyncStatus", "INTEGER", true, 0, null, 1));
                HashSet hashSet15 = new HashSet(0);
                HashSet hashSet16 = new HashSet(2);
                hashSet16.add(new TableInfo.Index("index_WorkoutIndex_mEndTime", true, Arrays.asList("mEndTime"), Arrays.asList("ASC")));
                hashSet16.add(new TableInfo.Index("index_WorkoutIndex_mSyncStatus", false, Arrays.asList("mSyncStatus"), Arrays.asList("ASC")));
                TableInfo tableInfo11 = new TableInfo("WorkoutIndex", hashMap11, hashSet15, hashSet16);
                TableInfo read11 = TableInfo.read(db, "WorkoutIndex");
                if (!tableInfo11.equals(read11)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkoutIndex(com.sma.smartv3.db.entity.WorkoutIndex).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
                }
                HashMap hashMap12 = new HashMap(5);
                hashMap12.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap12.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap12.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap12.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap12.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet17 = new HashSet(0);
                HashSet hashSet18 = new HashSet(1);
                hashSet18.add(new TableInfo.Index("index_BloodOxygen_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo12 = new TableInfo("BloodOxygen", hashMap12, hashSet17, hashSet18);
                TableInfo read12 = TableInfo.read(db, "BloodOxygen");
                if (!tableInfo12.equals(read12)) {
                    return new RoomOpenHelper.ValidationResult(false, "BloodOxygen(com.sma.smartv3.db.entity.BloodOxygen).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
                }
                HashMap hashMap13 = new HashMap(6);
                hashMap13.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap13.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap13.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap13.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap13.put("mAvgValue", new TableInfo.Column("mAvgValue", "INTEGER", true, 0, null, 1));
                hashMap13.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet19 = new HashSet(0);
                HashSet hashSet20 = new HashSet(1);
                hashSet20.add(new TableInfo.Index("index_Hrv_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo13 = new TableInfo("Hrv", hashMap13, hashSet19, hashSet20);
                TableInfo read13 = TableInfo.read(db, "Hrv");
                if (!tableInfo13.equals(read13)) {
                    return new RoomOpenHelper.ValidationResult(false, "Hrv(com.sma.smartv3.db.entity.Hrv).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
                }
                HashMap hashMap14 = new HashMap(5);
                hashMap14.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap14.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap14.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap14.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap14.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet21 = new HashSet(0);
                HashSet hashSet22 = new HashSet(1);
                hashSet22.add(new TableInfo.Index("index_Pressure_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo14 = new TableInfo("Pressure", hashMap14, hashSet21, hashSet22);
                TableInfo read14 = TableInfo.read(db, "Pressure");
                if (!tableInfo14.equals(read14)) {
                    return new RoomOpenHelper.ValidationResult(false, "Pressure(com.sma.smartv3.db.entity.Pressure).\n Expected:\n" + tableInfo14 + "\n Found:\n" + read14);
                }
                HashMap hashMap15 = new HashMap(14);
                hashMap15.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap15.put("mMatchRecordId", new TableInfo.Column("mMatchRecordId", "INTEGER", true, 0, null, 1));
                hashMap15.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap15.put("mPeriodTime", new TableInfo.Column("mPeriodTime", "INTEGER", true, 0, null, 1));
                hashMap15.put("mPeriodNumber", new TableInfo.Column("mPeriodNumber", "INTEGER", true, 0, null, 1));
                hashMap15.put("mType", new TableInfo.Column("mType", "INTEGER", true, 0, null, 1));
                hashMap15.put("mCount", new TableInfo.Column("mCount", "INTEGER", true, 0, null, 1));
                hashMap15.put("mCancelType", new TableInfo.Column("mCancelType", "INTEGER", true, 0, null, 1));
                hashMap15.put("mTeam", new TableInfo.Column("mTeam", "INTEGER", true, 0, null, 1));
                hashMap15.put("mPlayer", new TableInfo.Column("mPlayer", "INTEGER", true, 0, null, 1));
                hashMap15.put("mOtherType", new TableInfo.Column("mOtherType", "INTEGER", true, 0, null, 1));
                hashMap15.put("mStopWatchTotal", new TableInfo.Column("mStopWatchTotal", "INTEGER", true, 0, null, 1));
                hashMap15.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap15.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("MatchLog", hashMap15, new HashSet(0), new HashSet(0));
                TableInfo read15 = TableInfo.read(db, "MatchLog");
                if (!tableInfo15.equals(read15)) {
                    return new RoomOpenHelper.ValidationResult(false, "MatchLog(com.sma.smartv3.db.entity.MatchLog).\n Expected:\n" + tableInfo15 + "\n Found:\n" + read15);
                }
                HashMap hashMap16 = new HashMap(12);
                hashMap16.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap16.put("mMatchRecordId", new TableInfo.Column("mMatchRecordId", "INTEGER", true, 0, null, 1));
                hashMap16.put("mDuration", new TableInfo.Column("mDuration", "INTEGER", true, 0, null, 1));
                hashMap16.put("mDistance", new TableInfo.Column("mDistance", "INTEGER", true, 0, null, 1));
                hashMap16.put("mStep", new TableInfo.Column("mStep", "INTEGER", true, 0, null, 1));
                hashMap16.put("mCalorie", new TableInfo.Column("mCalorie", "INTEGER", true, 0, null, 1));
                hashMap16.put("mSpeed", new TableInfo.Column("mSpeed", "INTEGER", true, 0, null, 1));
                hashMap16.put("mAvgBpm", new TableInfo.Column("mAvgBpm", "INTEGER", true, 0, null, 1));
                hashMap16.put("mMaxBpm", new TableInfo.Column("mMaxBpm", "INTEGER", true, 0, null, 1));
                hashMap16.put("mMaxSpeed", new TableInfo.Column("mMaxSpeed", "INTEGER", true, 0, null, 1));
                hashMap16.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap16.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo16 = new TableInfo("MatchPeriod", hashMap16, new HashSet(0), new HashSet(0));
                TableInfo read16 = TableInfo.read(db, "MatchPeriod");
                if (!tableInfo16.equals(read16)) {
                    return new RoomOpenHelper.ValidationResult(false, "MatchPeriod(com.sma.smartv3.db.entity.MatchPeriod).\n Expected:\n" + tableInfo16 + "\n Found:\n" + read16);
                }
                HashMap hashMap17 = new HashMap(39);
                hashMap17.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap17.put("mStart", new TableInfo.Column("mStart", "INTEGER", true, 0, null, 1));
                hashMap17.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap17.put("mType", new TableInfo.Column("mType", "INTEGER", true, 0, null, 1));
                hashMap17.put("mPeriodListSize", new TableInfo.Column("mPeriodListSize", "INTEGER", true, 0, null, 1));
                hashMap17.put("mLogListSize", new TableInfo.Column("mLogListSize", "INTEGER", true, 0, null, 1));
                hashMap17.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap17.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                hashMap17.put("mSource", new TableInfo.Column("mSource", "INTEGER", true, 0, null, 1));
                hashMap17.put("mIsStopWatchData", new TableInfo.Column("mIsStopWatchData", "INTEGER", true, 0, null, 1));
                hashMap17.put("mStopWatchList", new TableInfo.Column("mStopWatchList", "TEXT", false, 0, "''", 1));
                hashMap17.put("mTeamInfo", new TableInfo.Column("mTeamInfo", "TEXT", false, 0, "''", 1));
                hashMap17.put("mWeather", new TableInfo.Column("mWeather", "TEXT", false, 0, "''", 1));
                hashMap17.put("mHomeTeamScore", new TableInfo.Column("mHomeTeamScore", "INTEGER", true, 0, null, 1));
                hashMap17.put("mGuestTeamScore", new TableInfo.Column("mGuestTeamScore", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMinBpm", new TableInfo.Column("mMinBpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("mAirPressure", new TableInfo.Column("mAirPressure", "INTEGER", true, 0, null, 1));
                hashMap17.put("mPace", new TableInfo.Column("mPace", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMaxPace", new TableInfo.Column("mMaxPace", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMinPace", new TableInfo.Column("mMinPace", "INTEGER", true, 0, null, 1));
                hashMap17.put("mSpm", new TableInfo.Column("mSpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMaxSpm", new TableInfo.Column("mMaxSpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMinSpm", new TableInfo.Column("mMinSpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("mAltitude", new TableInfo.Column("mAltitude", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMaxAltitude", new TableInfo.Column("mMaxAltitude", "INTEGER", true, 0, null, 1));
                hashMap17.put("mMinAltitude", new TableInfo.Column("mMinAltitude", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mId", new TableInfo.Column("p_mId", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mMatchRecordId", new TableInfo.Column("p_mMatchRecordId", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mDuration", new TableInfo.Column("p_mDuration", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mDistance", new TableInfo.Column("p_mDistance", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mStep", new TableInfo.Column("p_mStep", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mCalorie", new TableInfo.Column("p_mCalorie", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mSpeed", new TableInfo.Column("p_mSpeed", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mAvgBpm", new TableInfo.Column("p_mAvgBpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mMaxBpm", new TableInfo.Column("p_mMaxBpm", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mMaxSpeed", new TableInfo.Column("p_mMaxSpeed", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mIsSync", new TableInfo.Column("p_mIsSync", "INTEGER", true, 0, null, 1));
                hashMap17.put("p_mIsDelete", new TableInfo.Column("p_mIsDelete", "INTEGER", true, 0, null, 1));
                HashSet hashSet23 = new HashSet(0);
                HashSet hashSet24 = new HashSet(1);
                hashSet24.add(new TableInfo.Index("index_MatchRecord_mStart", true, Arrays.asList("mStart"), Arrays.asList("ASC")));
                TableInfo tableInfo17 = new TableInfo("MatchRecord", hashMap17, hashSet23, hashSet24);
                TableInfo read17 = TableInfo.read(db, "MatchRecord");
                if (!tableInfo17.equals(read17)) {
                    return new RoomOpenHelper.ValidationResult(false, "MatchRecord(com.sma.smartv3.db.entity.MatchRecord).\n Expected:\n" + tableInfo17 + "\n Found:\n" + read17);
                }
                HashMap hashMap18 = new HashMap(15);
                hashMap18.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap18.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap18.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap18.put("mStep", new TableInfo.Column("mStep", "INTEGER", true, 0, null, 1));
                hashMap18.put("mDistance", new TableInfo.Column("mDistance", "INTEGER", true, 0, null, 1));
                hashMap18.put("mCalorie", new TableInfo.Column("mCalorie", "INTEGER", true, 0, null, 1));
                hashMap18.put("mDuration", new TableInfo.Column("mDuration", "INTEGER", true, 0, null, 1));
                hashMap18.put("mSpm", new TableInfo.Column("mSpm", "INTEGER", true, 0, null, 1));
                hashMap18.put("mAltitude", new TableInfo.Column("mAltitude", "INTEGER", true, 0, null, 1));
                hashMap18.put("mAirPressure", new TableInfo.Column("mAirPressure", "INTEGER", true, 0, null, 1));
                hashMap18.put("mPace", new TableInfo.Column("mPace", "INTEGER", true, 0, null, 1));
                hashMap18.put("mSpeed", new TableInfo.Column("mSpeed", "INTEGER", true, 0, null, 1));
                hashMap18.put("mMode", new TableInfo.Column("mMode", "INTEGER", true, 0, null, 1));
                hashMap18.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap18.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo18 = new TableInfo("SportData", hashMap18, new HashSet(0), new HashSet(0));
                TableInfo read18 = TableInfo.read(db, "SportData");
                if (!tableInfo18.equals(read18)) {
                    return new RoomOpenHelper.ValidationResult(false, "SportData(com.sma.smartv3.db.entity.SportData).\n Expected:\n" + tableInfo18 + "\n Found:\n" + read18);
                }
                HashMap hashMap19 = new HashMap(5);
                hashMap19.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap19.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap19.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap19.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap19.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet25 = new HashSet(0);
                HashSet hashSet26 = new HashSet(1);
                hashSet26.add(new TableInfo.Index("index_BloodGlucose_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo19 = new TableInfo("BloodGlucose", hashMap19, hashSet25, hashSet26);
                TableInfo read19 = TableInfo.read(db, "BloodGlucose");
                if (!tableInfo19.equals(read19)) {
                    return new RoomOpenHelper.ValidationResult(false, "BloodGlucose(com.sma.smartv3.db.entity.BloodGlucose).\n Expected:\n" + tableInfo19 + "\n Found:\n" + read19);
                }
                HashMap hashMap20 = new HashMap(10);
                hashMap20.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap20.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap20.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap20.put("mBleName", new TableInfo.Column("mBleName", "TEXT", true, 0, null, 1));
                hashMap20.put("mFirmwareFlag", new TableInfo.Column("mFirmwareFlag", "TEXT", true, 0, null, 1));
                hashMap20.put("mMacAddress", new TableInfo.Column("mMacAddress", "TEXT", true, 0, null, 1));
                hashMap20.put("mFirmwareVersion", new TableInfo.Column("mFirmwareVersion", "TEXT", true, 0, null, 1));
                hashMap20.put("mAppVersion", new TableInfo.Column("mAppVersion", "TEXT", true, 0, null, 1));
                hashMap20.put("mResult", new TableInfo.Column("mResult", "INTEGER", true, 0, null, 1));
                hashMap20.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet27 = new HashSet(0);
                HashSet hashSet28 = new HashSet(1);
                hashSet28.add(new TableInfo.Index("index_AlipayBindInfo_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo20 = new TableInfo("AlipayBindInfo", hashMap20, hashSet27, hashSet28);
                TableInfo read20 = TableInfo.read(db, "AlipayBindInfo");
                if (!tableInfo20.equals(read20)) {
                    return new RoomOpenHelper.ValidationResult(false, "AlipayBindInfo(com.sma.smartv3.db.entity.AlipayBindInfo).\n Expected:\n" + tableInfo20 + "\n Found:\n" + read20);
                }
                HashMap hashMap21 = new HashMap(5);
                hashMap21.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap21.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap21.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap21.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap21.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet29 = new HashSet(0);
                HashSet hashSet30 = new HashSet(1);
                hashSet30.add(new TableInfo.Index("index_Electrocardiogram_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo21 = new TableInfo("Electrocardiogram", hashMap21, hashSet29, hashSet30);
                TableInfo read21 = TableInfo.read(db, "Electrocardiogram");
                if (!tableInfo21.equals(read21)) {
                    return new RoomOpenHelper.ValidationResult(false, "Electrocardiogram(com.sma.smartv3.db.entity.Electrocardiogram).\n Expected:\n" + tableInfo21 + "\n Found:\n" + read21);
                }
                HashMap hashMap22 = new HashMap(20);
                hashMap22.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap22.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap22.put("mMeasurementId", new TableInfo.Column("mMeasurementId", "TEXT", true, 0, null, 1));
                hashMap22.put("mUserId", new TableInfo.Column("mUserId", "TEXT", true, 0, null, 1));
                hashMap22.put("mStartTime", new TableInfo.Column("mStartTime", "TEXT", true, 0, null, 1));
                hashMap22.put("mEndTime", new TableInfo.Column("mEndTime", "TEXT", true, 0, null, 1));
                hashMap22.put("mModelNo", new TableInfo.Column("mModelNo", "TEXT", true, 0, null, 1));
                hashMap22.put("mLowerBound", new TableInfo.Column("mLowerBound", "REAL", true, 0, null, 1));
                hashMap22.put("mUpperBound", new TableInfo.Column("mUpperBound", "REAL", true, 0, null, 1));
                hashMap22.put("mFasting", new TableInfo.Column("mFasting", "INTEGER", true, 0, null, 1));
                hashMap22.put("mWithin2hrsMeal", new TableInfo.Column("mWithin2hrsMeal", "INTEGER", true, 0, null, 1));
                hashMap22.put("mCompletedProgress", new TableInfo.Column("mCompletedProgress", "INTEGER", true, 0, null, 1));
                hashMap22.put("mCurrentLevel", new TableInfo.Column("mCurrentLevel", "INTEGER", true, 0, null, 1));
                hashMap22.put("mRiskCode", new TableInfo.Column("mRiskCode", "TEXT", true, 0, null, 1));
                hashMap22.put("mInsights", new TableInfo.Column("mInsights", "TEXT", true, 0, null, 1));
                hashMap22.put("mTips", new TableInfo.Column("mTips", "TEXT", true, 0, null, 1));
                hashMap22.put("mLocaleInsights", new TableInfo.Column("mLocaleInsights", "TEXT", true, 0, null, 1));
                hashMap22.put("mLocaleTips", new TableInfo.Column("mLocaleTips", "TEXT", true, 0, null, 1));
                hashMap22.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                hashMap22.put("mIsDelete", new TableInfo.Column("mIsDelete", "INTEGER", true, 0, null, 1));
                HashSet hashSet31 = new HashSet(0);
                HashSet hashSet32 = new HashSet(1);
                hashSet32.add(new TableInfo.Index("index_BloodGlucose2_mMeasurementId", true, Arrays.asList("mMeasurementId"), Arrays.asList("ASC")));
                TableInfo tableInfo22 = new TableInfo("BloodGlucose2", hashMap22, hashSet31, hashSet32);
                TableInfo read22 = TableInfo.read(db, "BloodGlucose2");
                if (!tableInfo22.equals(read22)) {
                    return new RoomOpenHelper.ValidationResult(false, "BloodGlucose2(com.sma.smartv3.db.entity.BloodGlucose2).\n Expected:\n" + tableInfo22 + "\n Found:\n" + read22);
                }
                HashMap hashMap23 = new HashMap(7);
                hashMap23.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap23.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap23.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap23.put("mVibration", new TableInfo.Column("mVibration", "INTEGER", true, 0, null, 1));
                hashMap23.put("mBOValue", new TableInfo.Column("mBOValue", "INTEGER", true, 0, null, 1));
                hashMap23.put("mIsSnore", new TableInfo.Column("mIsSnore", "INTEGER", true, 0, null, 1));
                hashMap23.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet33 = new HashSet(0);
                HashSet hashSet34 = new HashSet(1);
                hashSet34.add(new TableInfo.Index("index_HanBaoVibration_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo23 = new TableInfo("HanBaoVibration", hashMap23, hashSet33, hashSet34);
                TableInfo read23 = TableInfo.read(db, "HanBaoVibration");
                if (!tableInfo23.equals(read23)) {
                    return new RoomOpenHelper.ValidationResult(false, "HanBaoVibration(com.sma.smartv3.db.entity.HanBaoVibration).\n Expected:\n" + tableInfo23 + "\n Found:\n" + read23);
                }
                HashMap hashMap24 = new HashMap(35);
                hashMap24.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap24.put("mUserGender", new TableInfo.Column("mUserGender", "INTEGER", true, 0, null, 1));
                hashMap24.put("mUserWeight", new TableInfo.Column("mUserWeight", "REAL", true, 0, null, 1));
                hashMap24.put("mUserHeight", new TableInfo.Column("mUserHeight", "REAL", true, 0, null, 1));
                hashMap24.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap24.put("mAbnormalNumber", new TableInfo.Column("mAbnormalNumber", "INTEGER", true, 0, null, 1));
                hashMap24.put("mHeartRateTime", new TableInfo.Column("mHeartRateTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mHeartRateValue", new TableInfo.Column("mHeartRateValue", "INTEGER", true, 0, null, 1));
                hashMap24.put("mHeartRateAIRecords", new TableInfo.Column("mHeartRateAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mBloodPressureTime", new TableInfo.Column("mBloodPressureTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mSystolicValue", new TableInfo.Column("mSystolicValue", "INTEGER", true, 0, null, 1));
                hashMap24.put("mDiastolicValue", new TableInfo.Column("mDiastolicValue", "INTEGER", true, 0, null, 1));
                hashMap24.put("mBloodPressureAIRecords", new TableInfo.Column("mBloodPressureAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mBloodOxygenTime", new TableInfo.Column("mBloodOxygenTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mBloodOxygenValue", new TableInfo.Column("mBloodOxygenValue", "INTEGER", true, 0, null, 1));
                hashMap24.put("mBloodOxygenAIRecords", new TableInfo.Column("mBloodOxygenAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mSleepTime", new TableInfo.Column("mSleepTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mSleepDeepLengthTime", new TableInfo.Column("mSleepDeepLengthTime", "REAL", true, 0, null, 1));
                hashMap24.put("mSleepPiecemealTime", new TableInfo.Column("mSleepPiecemealTime", "REAL", true, 0, null, 1));
                hashMap24.put("mSleepAIRecords", new TableInfo.Column("mSleepAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mPressureTime", new TableInfo.Column("mPressureTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mPressureValue", new TableInfo.Column("mPressureValue", "INTEGER", true, 0, null, 1));
                hashMap24.put("mPressureAIRecords", new TableInfo.Column("mPressureAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mBloodGlucose2Time", new TableInfo.Column("mBloodGlucose2Time", "INTEGER", true, 0, null, 1));
                hashMap24.put("mBloodGlucose2Value", new TableInfo.Column("mBloodGlucose2Value", "REAL", true, 0, null, 1));
                hashMap24.put("mBloodGlucose2AIRecords", new TableInfo.Column("mBloodGlucose2AIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mWeightTime", new TableInfo.Column("mWeightTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mWeightValue", new TableInfo.Column("mWeightValue", "REAL", true, 0, null, 1));
                hashMap24.put("mWeightAIRecords", new TableInfo.Column("mWeightAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mWeekSportsTime", new TableInfo.Column("mWeekSportsTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mWeekSportsNumber", new TableInfo.Column("mWeekSportsNumber", "INTEGER", true, 0, null, 1));
                hashMap24.put("mWeekSportsAllTime", new TableInfo.Column("mWeekSportsAllTime", "INTEGER", true, 0, null, 1));
                hashMap24.put("mWeekSportsAIRecords", new TableInfo.Column("mWeekSportsAIRecords", "TEXT", true, 0, null, 1));
                hashMap24.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet35 = new HashSet(0);
                HashSet hashSet36 = new HashSet(1);
                hashSet36.add(new TableInfo.Index("index_HealthyReport_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo24 = new TableInfo("HealthyReport", hashMap24, hashSet35, hashSet36);
                TableInfo read24 = TableInfo.read(db, "HealthyReport");
                if (!tableInfo24.equals(read24)) {
                    return new RoomOpenHelper.ValidationResult(false, "HealthyReport(com.sma.smartv3.db.entity.HealthyReport).\n Expected:\n" + tableInfo24 + "\n Found:\n" + read24);
                }
                HashMap hashMap25 = new HashMap(5);
                hashMap25.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1, null, 1));
                hashMap25.put("mTime", new TableInfo.Column("mTime", "INTEGER", true, 0, null, 1));
                hashMap25.put("mLocalTime", new TableInfo.Column("mLocalTime", "TEXT", true, 0, null, 1));
                hashMap25.put("mValue", new TableInfo.Column("mValue", "INTEGER", true, 0, null, 1));
                hashMap25.put("mIsSync", new TableInfo.Column("mIsSync", "INTEGER", true, 0, null, 1));
                HashSet hashSet37 = new HashSet(0);
                HashSet hashSet38 = new HashSet(1);
                hashSet38.add(new TableInfo.Index("index_DailyPower_mTime", true, Arrays.asList("mTime"), Arrays.asList("ASC")));
                TableInfo tableInfo25 = new TableInfo("DailyPower", hashMap25, hashSet37, hashSet38);
                TableInfo read25 = TableInfo.read(db, "DailyPower");
                if (!tableInfo25.equals(read25)) {
                    return new RoomOpenHelper.ValidationResult(false, "DailyPower(com.sma.smartv3.db.entity.DailyPower).\n Expected:\n" + tableInfo25 + "\n Found:\n" + read25);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "221d5bc67648ba48ba91e15a5ba5c4c9", "cf1fcc657560902e5ab9b9821e07bfcf")).build());
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public DailyPowerDao dailyPowerDao() {
        DailyPowerDao dailyPowerDao;
        if (this._dailyPowerDao != null) {
            return this._dailyPowerDao;
        }
        synchronized (this) {
            try {
                if (this._dailyPowerDao == null) {
                    this._dailyPowerDao = new DailyPowerDao_Impl(this);
                }
                dailyPowerDao = this._dailyPowerDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dailyPowerDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public ElectrocardiogramDao electrocardiogramDao() {
        ElectrocardiogramDao electrocardiogramDao;
        if (this._electrocardiogramDao != null) {
            return this._electrocardiogramDao;
        }
        synchronized (this) {
            try {
                if (this._electrocardiogramDao == null) {
                    this._electrocardiogramDao = new ElectrocardiogramDao_Impl(this);
                }
                electrocardiogramDao = this._electrocardiogramDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return electrocardiogramDao;
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public List<Migration> getAutoMigrations(@NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(ActivityDao.class, ActivityDao_Impl.getRequiredConverters());
        hashMap.put(AIRecordsDao.class, AIRecordsDao_Impl.getRequiredConverters());
        hashMap.put(HeartRateDao.class, HeartRateDao_Impl.getRequiredConverters());
        hashMap.put(BloodPressureDao.class, BloodPressureDao_Impl.getRequiredConverters());
        hashMap.put(SleepDao.class, SleepDao_Impl.getRequiredConverters());
        hashMap.put(WorkoutDao.class, WorkoutDao_Impl.getRequiredConverters());
        hashMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
        hashMap.put(WeightDao.class, WeightDao_Impl.getRequiredConverters());
        hashMap.put(TemperatureDao.class, TemperatureDao_Impl.getRequiredConverters());
        hashMap.put(ScheduleDao.class, ScheduleDao_Impl.getRequiredConverters());
        hashMap.put(WorkoutIndexDao.class, WorkoutIndexDao_Impl.getRequiredConverters());
        hashMap.put(BloodOxygenDao.class, BloodOxygenDao_Impl.getRequiredConverters());
        hashMap.put(HrvDao.class, HrvDao_Impl.getRequiredConverters());
        hashMap.put(PressureDao.class, PressureDao_Impl.getRequiredConverters());
        hashMap.put(MatchRecordDao.class, MatchRecordDao_Impl.getRequiredConverters());
        hashMap.put(SportDataDao.class, SportDataDao_Impl.getRequiredConverters());
        hashMap.put(BloodGlucoseDao.class, BloodGlucoseDao_Impl.getRequiredConverters());
        hashMap.put(AlipayBindInfoDao.class, AlipayBindInfoDao_Impl.getRequiredConverters());
        hashMap.put(ElectrocardiogramDao.class, ElectrocardiogramDao_Impl.getRequiredConverters());
        hashMap.put(BloodGlucose2Dao.class, BloodGlucose2Dao_Impl.getRequiredConverters());
        hashMap.put(HanBaoVibrationDao.class, HanBaoVibrationDao_Impl.getRequiredConverters());
        hashMap.put(HealthyReportDao.class, HealthyReportDao_Impl.getRequiredConverters());
        hashMap.put(DailyPowerDao.class, DailyPowerDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public HanBaoVibrationDao hanBaoVibrationDao() {
        HanBaoVibrationDao hanBaoVibrationDao;
        if (this._hanBaoVibrationDao != null) {
            return this._hanBaoVibrationDao;
        }
        synchronized (this) {
            try {
                if (this._hanBaoVibrationDao == null) {
                    this._hanBaoVibrationDao = new HanBaoVibrationDao_Impl(this);
                }
                hanBaoVibrationDao = this._hanBaoVibrationDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hanBaoVibrationDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public HealthyReportDao healthyReportDao() {
        HealthyReportDao healthyReportDao;
        if (this._healthyReportDao != null) {
            return this._healthyReportDao;
        }
        synchronized (this) {
            try {
                if (this._healthyReportDao == null) {
                    this._healthyReportDao = new HealthyReportDao_Impl(this);
                }
                healthyReportDao = this._healthyReportDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return healthyReportDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public HeartRateDao heartRateDao() {
        HeartRateDao heartRateDao;
        if (this._heartRateDao != null) {
            return this._heartRateDao;
        }
        synchronized (this) {
            try {
                if (this._heartRateDao == null) {
                    this._heartRateDao = new HeartRateDao_Impl(this);
                }
                heartRateDao = this._heartRateDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return heartRateDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public HrvDao hrvDao() {
        HrvDao hrvDao;
        if (this._hrvDao != null) {
            return this._hrvDao;
        }
        synchronized (this) {
            try {
                if (this._hrvDao == null) {
                    this._hrvDao = new HrvDao_Impl(this);
                }
                hrvDao = this._hrvDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hrvDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public LocationDao locationDao() {
        LocationDao locationDao;
        if (this._locationDao != null) {
            return this._locationDao;
        }
        synchronized (this) {
            try {
                if (this._locationDao == null) {
                    this._locationDao = new LocationDao_Impl(this);
                }
                locationDao = this._locationDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return locationDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public MatchRecordDao matchRecordDao() {
        MatchRecordDao matchRecordDao;
        if (this._matchRecordDao != null) {
            return this._matchRecordDao;
        }
        synchronized (this) {
            try {
                if (this._matchRecordDao == null) {
                    this._matchRecordDao = new MatchRecordDao_Impl(this);
                }
                matchRecordDao = this._matchRecordDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return matchRecordDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public PressureDao pressureDao() {
        PressureDao pressureDao;
        if (this._pressureDao != null) {
            return this._pressureDao;
        }
        synchronized (this) {
            try {
                if (this._pressureDao == null) {
                    this._pressureDao = new PressureDao_Impl(this);
                }
                pressureDao = this._pressureDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pressureDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public ScheduleDao scheduleDao() {
        ScheduleDao scheduleDao;
        if (this._scheduleDao != null) {
            return this._scheduleDao;
        }
        synchronized (this) {
            try {
                if (this._scheduleDao == null) {
                    this._scheduleDao = new ScheduleDao_Impl(this);
                }
                scheduleDao = this._scheduleDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduleDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public SleepDao sleepDao() {
        SleepDao sleepDao;
        if (this._sleepDao != null) {
            return this._sleepDao;
        }
        synchronized (this) {
            try {
                if (this._sleepDao == null) {
                    this._sleepDao = new SleepDao_Impl(this);
                }
                sleepDao = this._sleepDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sleepDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public SportDataDao sportDataDao() {
        SportDataDao sportDataDao;
        if (this._sportDataDao != null) {
            return this._sportDataDao;
        }
        synchronized (this) {
            try {
                if (this._sportDataDao == null) {
                    this._sportDataDao = new SportDataDao_Impl(this);
                }
                sportDataDao = this._sportDataDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sportDataDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public TemperatureDao temperatureDao() {
        TemperatureDao temperatureDao;
        if (this._temperatureDao != null) {
            return this._temperatureDao;
        }
        synchronized (this) {
            try {
                if (this._temperatureDao == null) {
                    this._temperatureDao = new TemperatureDao_Impl(this);
                }
                temperatureDao = this._temperatureDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return temperatureDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public WeightDao weightDao() {
        WeightDao weightDao;
        if (this._weightDao != null) {
            return this._weightDao;
        }
        synchronized (this) {
            try {
                if (this._weightDao == null) {
                    this._weightDao = new WeightDao_Impl(this);
                }
                weightDao = this._weightDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return weightDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public WorkoutDao workoutDao() {
        WorkoutDao workoutDao;
        if (this._workoutDao != null) {
            return this._workoutDao;
        }
        synchronized (this) {
            try {
                if (this._workoutDao == null) {
                    this._workoutDao = new WorkoutDao_Impl(this);
                }
                workoutDao = this._workoutDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workoutDao;
    }

    @Override // com.sma.smartv3.db.AppDatabase
    public WorkoutIndexDao workoutIndexDao() {
        WorkoutIndexDao workoutIndexDao;
        if (this._workoutIndexDao != null) {
            return this._workoutIndexDao;
        }
        synchronized (this) {
            try {
                if (this._workoutIndexDao == null) {
                    this._workoutIndexDao = new WorkoutIndexDao_Impl(this);
                }
                workoutIndexDao = this._workoutIndexDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workoutIndexDao;
    }
}
