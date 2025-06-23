package com.sma.smartv3.db;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MyDb {

    @OOXIXo
    public static final MyDb INSTANCE = new MyDb();
    public static AppDatabase mDatabase;

    private MyDb() {
    }

    @OOXIXo
    public final AppDatabase getMDatabase() {
        AppDatabase appDatabase = mDatabase;
        if (appDatabase != null) {
            return appDatabase;
        }
        IIX0o.XOxIOxOx("mDatabase");
        return null;
    }

    public final void init(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        setMDatabase((AppDatabase) Room.databaseBuilder(context, AppDatabase.class, "db[" + context.getPackageName() + ']').addMigrations(new Migration() { // from class: com.sma.smartv3.db.MyDb$init$1
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Location ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$2
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Location ADD COLUMN mIsBaiDuSync INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Activity ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE BloodPressure ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE HeartRate ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Sleep ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mIsSync INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$3
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE Workout(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mStart INTEGER NOT NULL,mEnd INTEGER NOT NULL,mLocalTime Text NOT NULL,mDuration INTEGER NOT NULL,mAltitude INTEGER NOT NULL,mAirPressure INTEGER NOT NULL,mSpm INTEGER NOT NULL,mMode INTEGER NOT NULL,mStep INTEGER NOT NULL,mDistance INTEGER NOT NULL,mCalorie INTEGER NOT NULL,mSpeed INTEGER NOT NULL,mPace INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$4
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Location ADD COLUMN mSource INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$5
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE Temperature(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mTemperature REAL NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Temperature_mTime ON Temperature(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$6
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("DROP TABLE Temperature");
                database.execSQL("CREATE TABLE Temperature(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mTemperature INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Temperature_mTime ON Temperature(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$7
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE WorkoutIndex(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mFrom INTEGER NOT NULL,mEndTime INTEGER NOT NULL,mMode INTEGER NOT NULL,mSyncStatus INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_WorkoutIndex_mEndTime ON WorkoutIndex(mEndTime)");
                database.execSQL("CREATE  INDEX index_WorkoutIndex_mSyncStatus ON WorkoutIndex(mSyncStatus)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$8
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE BloodOxygen(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_BloodOxygen_mTime ON BloodOxygen(mTime)");
                database.execSQL("CREATE TABLE Hrv(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Hrv_mTime ON Hrv(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$9
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("DROP TABLE Hrv");
                database.execSQL("CREATE TABLE Hrv(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mAvgValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Hrv_mTime ON Hrv(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$10
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Activity ADD COLUMN mIsDelete INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mIsDelete INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$11
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mIsMeasure INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBmi REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfFat REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfMuscle REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfFat REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfProtein REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfProteinLevel INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfWater REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfWaterLevel INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mStateOfNutrition REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mIdealWeight REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mAgeOfBody REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mIsDelete INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$12
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Sleep ADD COLUMN mAlgorithmType INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$13
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mAgeOfBodyRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBmiRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBmiWHORange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBmr REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBmrRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mBodyShape REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mDesirableWeight REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mFatFreeBodyWeight REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mFatToControl REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mLevelOfVisceralFat REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mLevelOfVisceralFatRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mMuscleToControl REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfFatRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfMuscle REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfMuscleRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfProteinRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfSkeletalMuscle REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfSkeletalMuscleRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfSubcutaneousFat REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfSubcutaneousFatRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mRatioOfWaterRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mScore REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfBone REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfBoneRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfFatRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfMuscleRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfProtein REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfProteinRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfSkeletalMuscle REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfSkeletalMuscleRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfWater REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightOfWaterRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightRange Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightToControl REAL NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Weight ADD COLUMN mWeightWHORange Text NOT NULL DEFAULT ''");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$14
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE Pressure(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Pressure_mTime ON Pressure(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$15
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAvgBpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxBpm INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$16
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinBpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxSpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinSpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxPace INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinPace INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$17
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE MatchLog(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mMatchRecordId INTEGER NOT NULL,mTime INTEGER NOT NULL,mPeriodTime INTEGER NOT NULL,mPeriodNumber INTEGER NOT NULL,mType INTEGER NOT NULL,mCount INTEGER NOT NULL,mCancelType INTEGER NOT NULL,mIsSync INTEGER NOT NULL,mIsDelete INTEGER NOT NULL)");
                database.execSQL("CREATE TABLE MatchPeriod(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mMatchRecordId INTEGER NOT NULL,mDuration INTEGER NOT NULL,mDistance INTEGER NOT NULL,mStep INTEGER NOT NULL,mCalorie INTEGER NOT NULL,mSpeed INTEGER NOT NULL,mAvgBpm INTEGER NOT NULL,mMaxBpm INTEGER NOT NULL,mIsSync INTEGER NOT NULL,mIsDelete INTEGER NOT NULL)");
                database.execSQL("CREATE TABLE MatchRecord(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mStart INTEGER NOT NULL,mLocalTime Text NOT NULL,mType INTEGER NOT NULL,mPeriodListSize INTEGER NOT NULL,mLogListSize INTEGER NOT NULL,mIsSync INTEGER NOT NULL,mIsDelete INTEGER NOT NULL,p_mId INTEGER NOT NULL,p_mMatchRecordId INTEGER NOT NULL,p_mDuration INTEGER NOT NULL,p_mDistance INTEGER NOT NULL,p_mStep INTEGER NOT NULL,p_mCalorie INTEGER NOT NULL,p_mSpeed INTEGER NOT NULL,p_mAvgBpm INTEGER NOT NULL,p_mMaxBpm INTEGER NOT NULL,p_mIsSync INTEGER NOT NULL,p_mIsDelete INTEGER NOT NULL)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$18
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mSource INTEGER NOT NULL DEFAULT 0");
                database.execSQL("CREATE TABLE SportData(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mStep INTEGER NOT NULL,mDistance INTEGER NOT NULL,mCalorie INTEGER NOT NULL,mDuration INTEGER NOT NULL,mSpm INTEGER NOT NULL,mAltitude INTEGER NOT NULL,mAirPressure INTEGER NOT NULL,mPace INTEGER NOT NULL,mSpeed INTEGER NOT NULL,mMode INTEGER NOT NULL,mIsSync INTEGER NOT NULL,mIsDelete INTEGER NOT NULL)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$19
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE BloodGlucose(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_BloodGlucose_mTime ON BloodGlucose(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$20
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxAltitude INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinAltitude INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$21
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE MatchLog ADD COLUMN mTeam INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchLog ADD COLUMN mPlayer INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchLog ADD COLUMN mOtherType INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchPeriod ADD COLUMN mMaxSpeed INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN p_mMaxSpeed INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mIsStopWatchData INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mSource INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mStopWatchList Text DEFAULT ''");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mTeamInfo Text DEFAULT ''");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mWeather Text DEFAULT ''");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mHomeTeamScore INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mGuestTeamScore INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$22
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE MatchLog ADD COLUMN mStopWatchTotal INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$23
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMode INTEGER NOT NULL DEFAULT 0");
                database.execSQL("CREATE UNIQUE INDEX index_MatchRecord_mStart ON MatchRecord(mStart)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$24
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinStress INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxStress INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAvgStress INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$25
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE AlipayBindInfo(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mBleName Text NOT NULL,mFirmwareFlag Text NOT NULL,mMacAddress Text NOT NULL,mFirmwareVersion Text NOT NULL,mAppVersion Text NOT NULL,mResult INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_AlipayBindInfo_mTime ON AlipayBindInfo(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$26
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMinBpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mAirPressure INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mPace INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMaxPace INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMinPace INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mSpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMaxSpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMinSpm INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mAltitude INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMaxAltitude INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE MatchRecord ADD COLUMN mMinAltitude INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$27
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mFeel INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPrototype Text NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mFirmwareFlag Text NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mBleName Text NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$28
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE AIRecords(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mAIFuncType INTEGER NOT NULL,mType INTEGER NOT NULL,mContent Text NOT NULL,mExtraInfo Text NOT NULL,mStatus INTEGER NOT NULL,mIsDelete INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$29
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE Electrocardiogram(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_Electrocardiogram_mTime ON Electrocardiogram(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$30
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxSpeed INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMinSpeed INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$31
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mRestDuration INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$32
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE BloodGlucose2(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mMeasurementId Text NOT NULL,mUserId Text NOT NULL,mStartTime Text NOT NULL,mEndTime Text NOT NULL,mModelNo Text NOT NULL,mLowerBound REAL NOT NULL DEFAULT 0,mUpperBound REAL NOT NULL DEFAULT 0,mFasting INTEGER NOT NULL,mWithin2hrsMeal INTEGER NOT NULL,mCompletedProgress INTEGER NOT NULL,mCurrentLevel INTEGER NOT NULL,mRiskCode Text NOT NULL,mInsights Text NOT NULL,mTips Text NOT NULL,mLocaleInsights Text NOT NULL,mLocaleTips Text NOT NULL,mIsSync INTEGER NOT NULL,mIsDelete INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_BloodGlucose2_mMeasurementId ON BloodGlucose2(mMeasurementId)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$33
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mType INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMetTotal INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAerobic FLOAT NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAnaerobic FLOAT NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mStamina INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAvgSpeed FLOAT NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mCadence INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxCadence INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mCnt INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mBpmZoneCount Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPersonalZone Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mLactateThresholdPace INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mRecoveryTime INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mTrainingLoad INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mMaxVO2 INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mLactateThresholdHr INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAlgorithmMarking INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mPathPoints Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mHrPathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mHrPathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mHrPathPoints Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPacePathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPacePathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mPacePathPoints Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mSpeedPathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mSpeedPathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mSpeedPathPoints Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mCadencePathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mCadencePathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mCadencePathPoints Text DEFAULT ''");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAltitudePathCount INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAltitudePathSampleInterval INTEGER NOT NULL DEFAULT 0");
                database.execSQL("ALTER TABLE workout ADD COLUMN mAltitudePathPoints Text DEFAULT ''");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$34
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mAITitle Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mTranslateLanguage Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mTranslateToLanguage Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mLocation Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mAudioPath Text NOT NULL DEFAULT ''");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN mAudioDuration INTEGER NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$35
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE HanBaoVibration(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mVibration INTEGER NOT NULL,mBOValue INTEGER NOT NULL,mIsSnore INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_HanBaoVibration_mTime ON HanBaoVibration(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$36
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE HealthyReport(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mUserGender INTEGER NOT NULL,mUserWeight FLOAT NOT NULL,mUserHeight FLOAT NOT NULL,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mAbnormalNumber INTEGER NOT NULL,mHeartRateTime INTEGER NOT NULL,mHeartRateValue INTEGER NOT NULL,mHeartRateAIRecords Text NOT NULL,mBloodPressureTime INTEGER NOT NULL,mSystolicValue INTEGER NOT NULL,mDiastolicValue INTEGER NOT NULL,mBloodPressureAIRecords Text NOT NULL,mBloodOxygenTime INTEGER NOT NULL,mBloodOxygenValue INTEGER NOT NULL,mBloodOxygenAIRecords Text NOT NULL,mSleepTime INTEGER NOT NULL,mSleepDeepLengthTime FLOAT NOT NULL,mSleepPiecemealTime FLOAT NOT NULL,mSleepAIRecords Text NOT NULL,mPressureTime INTEGER NOT NULL,mPressureValue INTEGER NOT NULL,mPressureAIRecords Text NOT NULL,mBloodGlucose2Time INTEGER NOT NULL,mBloodGlucose2Value FLOAT NOT NULL,mBloodGlucose2AIRecords Text NOT NULL,mWeightTime INTEGER NOT NULL,mWeightValue FLOAT NOT NULL,mWeightAIRecords Text NOT NULL,mWeekSportsTime INTEGER NOT NULL,mWeekSportsNumber INTEGER NOT NULL,mWeekSportsAllTime INTEGER NOT NULL,mWeekSportsAIRecords Text NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_HealthyReport_mTime ON HealthyReport(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$37
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mPlatform Text NOT NULL DEFAULT 0");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$38
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE Workout ADD COLUMN mAGpsType INTEGER NOT NULL DEFAULT 99");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$39
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("CREATE TABLE DailyPower(mId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mTime INTEGER NOT NULL,mLocalTime Text NOT NULL,mValue INTEGER NOT NULL,mIsSync INTEGER NOT NULL)");
                database.execSQL("CREATE UNIQUE INDEX index_DailyPower_mTime ON DailyPower(mTime)");
            }
        }, new Migration() { // from class: com.sma.smartv3.db.MyDb$init$40
            @Override // androidx.room.migration.Migration
            public void migrate(@OOXIXo SupportSQLiteDatabase database) {
                IIX0o.x0xO0oo(database, "database");
                database.execSQL("ALTER TABLE AIRecords ADD COLUMN ttsVoiceName Text NOT NULL DEFAULT ''");
            }
        }).allowMainThreadQueries().build());
    }

    public final void setMDatabase(@OOXIXo AppDatabase appDatabase) {
        IIX0o.x0xO0oo(appDatabase, "<set-?>");
        mDatabase = appDatabase;
    }
}
