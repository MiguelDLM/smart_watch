package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleWorkout;
import com.szabh.smable3.entity.BleWorkout2;
import com.szabh.smable3.entity.BleWorkout3;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

@TypeConverters({WorkoutConverter.class})
@Entity
/* loaded from: classes12.dex */
public final class Workout implements Serializable {

    @ColumnInfo
    private int mAGpsType;

    @ColumnInfo
    private float mAerobic;

    @ColumnInfo
    private int mAirPressure;

    @ColumnInfo
    private int mAlgorithmMarking;

    @ColumnInfo
    private int mAltitude;

    @ColumnInfo
    private int mAltitudePathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mAltitudePathPoints;

    @ColumnInfo
    private int mAltitudePathSampleInterval;

    @ColumnInfo
    private float mAnaerobic;

    @ColumnInfo
    private int mAvgBpm;

    @ColumnInfo
    private float mAvgSpeed;

    @ColumnInfo
    private int mAvgStress;

    @OOXIXo
    @ColumnInfo
    private String mBleName;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private int[] mBpmZoneCount;

    @ColumnInfo
    private int mCadence;

    @ColumnInfo
    private int mCadencePathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mCadencePathPoints;

    @ColumnInfo
    private int mCadencePathSampleInterval;

    @ColumnInfo
    private int mCalorie;

    @ColumnInfo
    private int mCnt;

    @ColumnInfo
    private int mDistance;

    @ColumnInfo
    private int mDuration;

    @ColumnInfo
    private long mEnd;

    @ColumnInfo
    private int mFeel;

    @OOXIXo
    @ColumnInfo
    private String mFirmwareFlag;

    @ColumnInfo
    private int mHrPathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mHrPathPoints;

    @ColumnInfo
    private int mHrPathSampleInterval;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsSync;

    @ColumnInfo
    private int mLactateThresholdHr;

    @ColumnInfo
    private int mLactateThresholdPace;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private int mMaxAltitude;

    @ColumnInfo
    private int mMaxBpm;

    @ColumnInfo
    private int mMaxCadence;

    @ColumnInfo
    private int mMaxPace;

    @ColumnInfo
    private int mMaxSpeed;

    @ColumnInfo
    private int mMaxSpm;

    @ColumnInfo
    private int mMaxStress;

    @ColumnInfo
    private int mMaxVO2;

    @ColumnInfo
    private int mMetTotal;

    @ColumnInfo
    private int mMinAltitude;

    @ColumnInfo
    private int mMinBpm;

    @ColumnInfo
    private int mMinPace;

    @ColumnInfo
    private int mMinSpeed;

    @ColumnInfo
    private int mMinSpm;

    @ColumnInfo
    private int mMinStress;

    @ColumnInfo
    private int mMode;

    @ColumnInfo
    private int mPace;

    @ColumnInfo
    private int mPacePathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mPacePathPoints;

    @ColumnInfo
    private int mPacePathSampleInterval;

    @ColumnInfo
    private int mPathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<float[]> mPathPoints;

    @ColumnInfo
    private int mPathSampleInterval;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private int[] mPersonalZone;

    @OOXIXo
    @ColumnInfo
    private String mPlatform;

    @OOXIXo
    @ColumnInfo
    private String mPrototype;

    @ColumnInfo
    private int mRecoveryTime;

    @ColumnInfo
    private int mRestDuration;

    @ColumnInfo
    private int mSource;

    @ColumnInfo
    private int mSpeed;

    @ColumnInfo
    private int mSpeedPathCount;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mSpeedPathPoints;

    @ColumnInfo
    private int mSpeedPathSampleInterval;

    @ColumnInfo
    private int mSpm;

    @ColumnInfo
    private int mStamina;

    @ColumnInfo
    private long mStart;

    @ColumnInfo
    private int mStep;

    @ColumnInfo
    private int mTrainingLoad;

    @ColumnInfo
    private int mType;

    public Workout() {
        this(0, 0L, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, -1, -1, 511, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mStep;
    }

    public final int component11() {
        return this.mDistance;
    }

    public final int component12() {
        return this.mCalorie;
    }

    public final int component13() {
        return this.mSpeed;
    }

    public final int component14() {
        return this.mPace;
    }

    public final int component15() {
        return this.mAvgBpm;
    }

    public final int component16() {
        return this.mMaxBpm;
    }

    public final int component17() {
        return this.mMinBpm;
    }

    public final int component18() {
        return this.mMaxSpm;
    }

    public final int component19() {
        return this.mMinSpm;
    }

    public final long component2() {
        return this.mStart;
    }

    public final int component20() {
        return this.mMaxPace;
    }

    public final int component21() {
        return this.mMinPace;
    }

    public final int component22() {
        return this.mMaxAltitude;
    }

    public final int component23() {
        return this.mMinAltitude;
    }

    public final int component24() {
        return this.mMinStress;
    }

    public final int component25() {
        return this.mMaxStress;
    }

    public final int component26() {
        return this.mAvgStress;
    }

    public final int component27() {
        return this.mSource;
    }

    public final int component28() {
        return this.mIsSync;
    }

    public final int component29() {
        return this.mIsDelete;
    }

    public final long component3() {
        return this.mEnd;
    }

    public final int component30() {
        return this.mFeel;
    }

    @OOXIXo
    public final String component31() {
        return this.mPrototype;
    }

    @OOXIXo
    public final String component32() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String component33() {
        return this.mBleName;
    }

    @OOXIXo
    public final String component34() {
        return this.mPlatform;
    }

    public final int component35() {
        return this.mMaxSpeed;
    }

    public final int component36() {
        return this.mMinSpeed;
    }

    public final int component37() {
        return this.mRestDuration;
    }

    public final int component38() {
        return this.mAGpsType;
    }

    public final int component39() {
        return this.mType;
    }

    @OOXIXo
    public final String component4() {
        return this.mLocalTime;
    }

    public final int component40() {
        return this.mMetTotal;
    }

    public final float component41() {
        return this.mAerobic;
    }

    public final float component42() {
        return this.mAnaerobic;
    }

    public final int component43() {
        return this.mStamina;
    }

    public final float component44() {
        return this.mAvgSpeed;
    }

    public final int component45() {
        return this.mCadence;
    }

    public final int component46() {
        return this.mMaxCadence;
    }

    public final int component47() {
        return this.mCnt;
    }

    @oOoXoXO
    public final int[] component48() {
        return this.mBpmZoneCount;
    }

    @oOoXoXO
    public final int[] component49() {
        return this.mPersonalZone;
    }

    public final int component5() {
        return this.mDuration;
    }

    public final int component50() {
        return this.mLactateThresholdPace;
    }

    public final int component51() {
        return this.mRecoveryTime;
    }

    public final int component52() {
        return this.mTrainingLoad;
    }

    public final int component53() {
        return this.mMaxVO2;
    }

    public final int component54() {
        return this.mLactateThresholdHr;
    }

    public final int component55() {
        return this.mAlgorithmMarking;
    }

    public final int component56() {
        return this.mPathCount;
    }

    public final int component57() {
        return this.mPathSampleInterval;
    }

    @oOoXoXO
    public final List<float[]> component58() {
        return this.mPathPoints;
    }

    public final int component59() {
        return this.mHrPathCount;
    }

    public final int component6() {
        return this.mAltitude;
    }

    public final int component60() {
        return this.mHrPathSampleInterval;
    }

    @oOoXoXO
    public final List<Integer> component61() {
        return this.mHrPathPoints;
    }

    public final int component62() {
        return this.mPacePathCount;
    }

    public final int component63() {
        return this.mPacePathSampleInterval;
    }

    @oOoXoXO
    public final List<Integer> component64() {
        return this.mPacePathPoints;
    }

    public final int component65() {
        return this.mSpeedPathCount;
    }

    public final int component66() {
        return this.mSpeedPathSampleInterval;
    }

    @oOoXoXO
    public final List<Integer> component67() {
        return this.mSpeedPathPoints;
    }

    public final int component68() {
        return this.mCadencePathCount;
    }

    public final int component69() {
        return this.mCadencePathSampleInterval;
    }

    public final int component7() {
        return this.mAirPressure;
    }

    @oOoXoXO
    public final List<Integer> component70() {
        return this.mCadencePathPoints;
    }

    public final int component71() {
        return this.mAltitudePathCount;
    }

    public final int component72() {
        return this.mAltitudePathSampleInterval;
    }

    @oOoXoXO
    public final List<Integer> component73() {
        return this.mAltitudePathPoints;
    }

    public final int component8() {
        return this.mSpm;
    }

    public final int component9() {
        return this.mMode;
    }

    @OOXIXo
    public final Workout copy(int i, long j, long j2, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, @OOXIXo String mBleName, @OOXIXo String mPlatform, int i28, int i29, int i30, int i31, int i32, int i33, float f, float f2, int i34, float f3, int i35, int i36, int i37, @oOoXoXO int[] iArr, @oOoXoXO int[] iArr2, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, @oOoXoXO List<float[]> list, int i46, int i47, @oOoXoXO List<Integer> list2, int i48, int i49, @oOoXoXO List<Integer> list3, int i50, int i51, @oOoXoXO List<Integer> list4, int i52, int i53, @oOoXoXO List<Integer> list5, int i54, int i55, @oOoXoXO List<Integer> list6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        return new Workout(i, j, j2, mLocalTime, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, mPrototype, mFirmwareFlag, mBleName, mPlatform, i28, i29, i30, i31, i32, i33, f, f2, i34, f3, i35, i36, i37, iArr, iArr2, i38, i39, i40, i41, i42, i43, i44, i45, list, i46, i47, list2, i48, i49, list3, i50, i51, list4, i52, i53, list5, i54, i55, list6);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Workout)) {
            return false;
        }
        Workout workout = (Workout) obj;
        return this.mId == workout.mId && this.mStart == workout.mStart && this.mEnd == workout.mEnd && IIX0o.Oxx0IOOO(this.mLocalTime, workout.mLocalTime) && this.mDuration == workout.mDuration && this.mAltitude == workout.mAltitude && this.mAirPressure == workout.mAirPressure && this.mSpm == workout.mSpm && this.mMode == workout.mMode && this.mStep == workout.mStep && this.mDistance == workout.mDistance && this.mCalorie == workout.mCalorie && this.mSpeed == workout.mSpeed && this.mPace == workout.mPace && this.mAvgBpm == workout.mAvgBpm && this.mMaxBpm == workout.mMaxBpm && this.mMinBpm == workout.mMinBpm && this.mMaxSpm == workout.mMaxSpm && this.mMinSpm == workout.mMinSpm && this.mMaxPace == workout.mMaxPace && this.mMinPace == workout.mMinPace && this.mMaxAltitude == workout.mMaxAltitude && this.mMinAltitude == workout.mMinAltitude && this.mMinStress == workout.mMinStress && this.mMaxStress == workout.mMaxStress && this.mAvgStress == workout.mAvgStress && this.mSource == workout.mSource && this.mIsSync == workout.mIsSync && this.mIsDelete == workout.mIsDelete && this.mFeel == workout.mFeel && IIX0o.Oxx0IOOO(this.mPrototype, workout.mPrototype) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, workout.mFirmwareFlag) && IIX0o.Oxx0IOOO(this.mBleName, workout.mBleName) && IIX0o.Oxx0IOOO(this.mPlatform, workout.mPlatform) && this.mMaxSpeed == workout.mMaxSpeed && this.mMinSpeed == workout.mMinSpeed && this.mRestDuration == workout.mRestDuration && this.mAGpsType == workout.mAGpsType && this.mType == workout.mType && this.mMetTotal == workout.mMetTotal && Float.compare(this.mAerobic, workout.mAerobic) == 0 && Float.compare(this.mAnaerobic, workout.mAnaerobic) == 0 && this.mStamina == workout.mStamina && Float.compare(this.mAvgSpeed, workout.mAvgSpeed) == 0 && this.mCadence == workout.mCadence && this.mMaxCadence == workout.mMaxCadence && this.mCnt == workout.mCnt && IIX0o.Oxx0IOOO(this.mBpmZoneCount, workout.mBpmZoneCount) && IIX0o.Oxx0IOOO(this.mPersonalZone, workout.mPersonalZone) && this.mLactateThresholdPace == workout.mLactateThresholdPace && this.mRecoveryTime == workout.mRecoveryTime && this.mTrainingLoad == workout.mTrainingLoad && this.mMaxVO2 == workout.mMaxVO2 && this.mLactateThresholdHr == workout.mLactateThresholdHr && this.mAlgorithmMarking == workout.mAlgorithmMarking && this.mPathCount == workout.mPathCount && this.mPathSampleInterval == workout.mPathSampleInterval && IIX0o.Oxx0IOOO(this.mPathPoints, workout.mPathPoints) && this.mHrPathCount == workout.mHrPathCount && this.mHrPathSampleInterval == workout.mHrPathSampleInterval && IIX0o.Oxx0IOOO(this.mHrPathPoints, workout.mHrPathPoints) && this.mPacePathCount == workout.mPacePathCount && this.mPacePathSampleInterval == workout.mPacePathSampleInterval && IIX0o.Oxx0IOOO(this.mPacePathPoints, workout.mPacePathPoints) && this.mSpeedPathCount == workout.mSpeedPathCount && this.mSpeedPathSampleInterval == workout.mSpeedPathSampleInterval && IIX0o.Oxx0IOOO(this.mSpeedPathPoints, workout.mSpeedPathPoints) && this.mCadencePathCount == workout.mCadencePathCount && this.mCadencePathSampleInterval == workout.mCadencePathSampleInterval && IIX0o.Oxx0IOOO(this.mCadencePathPoints, workout.mCadencePathPoints) && this.mAltitudePathCount == workout.mAltitudePathCount && this.mAltitudePathSampleInterval == workout.mAltitudePathSampleInterval && IIX0o.Oxx0IOOO(this.mAltitudePathPoints, workout.mAltitudePathPoints);
    }

    public final int getMAGpsType() {
        return this.mAGpsType;
    }

    public final float getMAerobic() {
        return this.mAerobic;
    }

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAlgorithmMarking() {
        return this.mAlgorithmMarking;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMAltitudePathCount() {
        return this.mAltitudePathCount;
    }

    @oOoXoXO
    public final List<Integer> getMAltitudePathPoints() {
        return this.mAltitudePathPoints;
    }

    public final int getMAltitudePathSampleInterval() {
        return this.mAltitudePathSampleInterval;
    }

    public final float getMAnaerobic() {
        return this.mAnaerobic;
    }

    public final int getMAvgBpm() {
        return this.mAvgBpm;
    }

    public final float getMAvgSpeed() {
        return this.mAvgSpeed;
    }

    public final int getMAvgStress() {
        return this.mAvgStress;
    }

    @OOXIXo
    public final String getMBleName() {
        return this.mBleName;
    }

    @oOoXoXO
    public final int[] getMBpmZoneCount() {
        return this.mBpmZoneCount;
    }

    public final int getMCadence() {
        return this.mCadence;
    }

    public final int getMCadencePathCount() {
        return this.mCadencePathCount;
    }

    @oOoXoXO
    public final List<Integer> getMCadencePathPoints() {
        return this.mCadencePathPoints;
    }

    public final int getMCadencePathSampleInterval() {
        return this.mCadencePathSampleInterval;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMCnt() {
        return this.mCnt;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final int getMDuration() {
        return this.mDuration;
    }

    public final long getMEnd() {
        return this.mEnd;
    }

    public final int getMFeel() {
        return this.mFeel;
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        return this.mFirmwareFlag;
    }

    public final int getMHrPathCount() {
        return this.mHrPathCount;
    }

    @oOoXoXO
    public final List<Integer> getMHrPathPoints() {
        return this.mHrPathPoints;
    }

    public final int getMHrPathSampleInterval() {
        return this.mHrPathSampleInterval;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    public final int getMLactateThresholdHr() {
        return this.mLactateThresholdHr;
    }

    public final int getMLactateThresholdPace() {
        return this.mLactateThresholdPace;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final int getMMaxAltitude() {
        return this.mMaxAltitude;
    }

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMaxCadence() {
        return this.mMaxCadence;
    }

    public final int getMMaxPace() {
        return this.mMaxPace;
    }

    public final int getMMaxSpeed() {
        return this.mMaxSpeed;
    }

    public final int getMMaxSpm() {
        return this.mMaxSpm;
    }

    public final int getMMaxStress() {
        return this.mMaxStress;
    }

    public final int getMMaxVO2() {
        return this.mMaxVO2;
    }

    public final int getMMetTotal() {
        return this.mMetTotal;
    }

    public final int getMMinAltitude() {
        return this.mMinAltitude;
    }

    public final int getMMinBpm() {
        return this.mMinBpm;
    }

    public final int getMMinPace() {
        return this.mMinPace;
    }

    public final int getMMinSpeed() {
        return this.mMinSpeed;
    }

    public final int getMMinSpm() {
        return this.mMinSpm;
    }

    public final int getMMinStress() {
        return this.mMinStress;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    public final int getMPacePathCount() {
        return this.mPacePathCount;
    }

    @oOoXoXO
    public final List<Integer> getMPacePathPoints() {
        return this.mPacePathPoints;
    }

    public final int getMPacePathSampleInterval() {
        return this.mPacePathSampleInterval;
    }

    public final int getMPathCount() {
        return this.mPathCount;
    }

    @oOoXoXO
    public final List<float[]> getMPathPoints() {
        return this.mPathPoints;
    }

    public final int getMPathSampleInterval() {
        return this.mPathSampleInterval;
    }

    @oOoXoXO
    public final int[] getMPersonalZone() {
        return this.mPersonalZone;
    }

    @OOXIXo
    public final String getMPlatform() {
        return this.mPlatform;
    }

    @OOXIXo
    public final String getMPrototype() {
        return this.mPrototype;
    }

    public final int getMRecoveryTime() {
        return this.mRecoveryTime;
    }

    public final int getMRestDuration() {
        return this.mRestDuration;
    }

    public final int getMSource() {
        return this.mSource;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMSpeedPathCount() {
        return this.mSpeedPathCount;
    }

    @oOoXoXO
    public final List<Integer> getMSpeedPathPoints() {
        return this.mSpeedPathPoints;
    }

    public final int getMSpeedPathSampleInterval() {
        return this.mSpeedPathSampleInterval;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    public final int getMStamina() {
        return this.mStamina;
    }

    public final long getMStart() {
        return this.mStart;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final int getMTrainingLoad() {
        return this.mTrainingLoad;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int oIX0oI2 = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mStart)) * 31) + oIX0oI.oIX0oI(this.mEnd)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mDuration) * 31) + this.mAltitude) * 31) + this.mAirPressure) * 31) + this.mSpm) * 31) + this.mMode) * 31) + this.mStep) * 31) + this.mDistance) * 31) + this.mCalorie) * 31) + this.mSpeed) * 31) + this.mPace) * 31) + this.mAvgBpm) * 31) + this.mMaxBpm) * 31) + this.mMinBpm) * 31) + this.mMaxSpm) * 31) + this.mMinSpm) * 31) + this.mMaxPace) * 31) + this.mMinPace) * 31) + this.mMaxAltitude) * 31) + this.mMinAltitude) * 31) + this.mMinStress) * 31) + this.mMaxStress) * 31) + this.mAvgStress) * 31) + this.mSource) * 31) + this.mIsSync) * 31) + this.mIsDelete) * 31) + this.mFeel) * 31) + this.mPrototype.hashCode()) * 31) + this.mFirmwareFlag.hashCode()) * 31) + this.mBleName.hashCode()) * 31) + this.mPlatform.hashCode()) * 31) + this.mMaxSpeed) * 31) + this.mMinSpeed) * 31) + this.mRestDuration) * 31) + this.mAGpsType) * 31) + this.mType) * 31) + this.mMetTotal) * 31) + Float.floatToIntBits(this.mAerobic)) * 31) + Float.floatToIntBits(this.mAnaerobic)) * 31) + this.mStamina) * 31) + Float.floatToIntBits(this.mAvgSpeed)) * 31) + this.mCadence) * 31) + this.mMaxCadence) * 31) + this.mCnt) * 31;
        int[] iArr = this.mBpmZoneCount;
        int i = 0;
        if (iArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(iArr);
        }
        int i2 = (oIX0oI2 + hashCode) * 31;
        int[] iArr2 = this.mPersonalZone;
        if (iArr2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(iArr2);
        }
        int i3 = (((((((((((((((((i2 + hashCode2) * 31) + this.mLactateThresholdPace) * 31) + this.mRecoveryTime) * 31) + this.mTrainingLoad) * 31) + this.mMaxVO2) * 31) + this.mLactateThresholdHr) * 31) + this.mAlgorithmMarking) * 31) + this.mPathCount) * 31) + this.mPathSampleInterval) * 31;
        List<float[]> list = this.mPathPoints;
        if (list == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = list.hashCode();
        }
        int i4 = (((((i3 + hashCode3) * 31) + this.mHrPathCount) * 31) + this.mHrPathSampleInterval) * 31;
        List<Integer> list2 = this.mHrPathPoints;
        if (list2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list2.hashCode();
        }
        int i5 = (((((i4 + hashCode4) * 31) + this.mPacePathCount) * 31) + this.mPacePathSampleInterval) * 31;
        List<Integer> list3 = this.mPacePathPoints;
        if (list3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = list3.hashCode();
        }
        int i6 = (((((i5 + hashCode5) * 31) + this.mSpeedPathCount) * 31) + this.mSpeedPathSampleInterval) * 31;
        List<Integer> list4 = this.mSpeedPathPoints;
        if (list4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = list4.hashCode();
        }
        int i7 = (((((i6 + hashCode6) * 31) + this.mCadencePathCount) * 31) + this.mCadencePathSampleInterval) * 31;
        List<Integer> list5 = this.mCadencePathPoints;
        if (list5 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = list5.hashCode();
        }
        int i8 = (((((i7 + hashCode7) * 31) + this.mAltitudePathCount) * 31) + this.mAltitudePathSampleInterval) * 31;
        List<Integer> list6 = this.mAltitudePathPoints;
        if (list6 != null) {
            i = list6.hashCode();
        }
        return i8 + i;
    }

    public final void setMAGpsType(int i) {
        this.mAGpsType = i;
    }

    public final void setMAerobic(float f) {
        this.mAerobic = f;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAlgorithmMarking(int i) {
        this.mAlgorithmMarking = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMAltitudePathCount(int i) {
        this.mAltitudePathCount = i;
    }

    public final void setMAltitudePathPoints(@oOoXoXO List<Integer> list) {
        this.mAltitudePathPoints = list;
    }

    public final void setMAltitudePathSampleInterval(int i) {
        this.mAltitudePathSampleInterval = i;
    }

    public final void setMAnaerobic(float f) {
        this.mAnaerobic = f;
    }

    public final void setMAvgBpm(int i) {
        this.mAvgBpm = i;
    }

    public final void setMAvgSpeed(float f) {
        this.mAvgSpeed = f;
    }

    public final void setMAvgStress(int i) {
        this.mAvgStress = i;
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    public final void setMBpmZoneCount(@oOoXoXO int[] iArr) {
        this.mBpmZoneCount = iArr;
    }

    public final void setMCadence(int i) {
        this.mCadence = i;
    }

    public final void setMCadencePathCount(int i) {
        this.mCadencePathCount = i;
    }

    public final void setMCadencePathPoints(@oOoXoXO List<Integer> list) {
        this.mCadencePathPoints = list;
    }

    public final void setMCadencePathSampleInterval(int i) {
        this.mCadencePathSampleInterval = i;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMCnt(int i) {
        this.mCnt = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMDuration(int i) {
        this.mDuration = i;
    }

    public final void setMEnd(long j) {
        this.mEnd = j;
    }

    public final void setMFeel(int i) {
        this.mFeel = i;
    }

    public final void setMFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareFlag = str;
    }

    public final void setMHrPathCount(int i) {
        this.mHrPathCount = i;
    }

    public final void setMHrPathPoints(@oOoXoXO List<Integer> list) {
        this.mHrPathPoints = list;
    }

    public final void setMHrPathSampleInterval(int i) {
        this.mHrPathSampleInterval = i;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLactateThresholdHr(int i) {
        this.mLactateThresholdHr = i;
    }

    public final void setMLactateThresholdPace(int i) {
        this.mLactateThresholdPace = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMMaxAltitude(int i) {
        this.mMaxAltitude = i;
    }

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMaxCadence(int i) {
        this.mMaxCadence = i;
    }

    public final void setMMaxPace(int i) {
        this.mMaxPace = i;
    }

    public final void setMMaxSpeed(int i) {
        this.mMaxSpeed = i;
    }

    public final void setMMaxSpm(int i) {
        this.mMaxSpm = i;
    }

    public final void setMMaxStress(int i) {
        this.mMaxStress = i;
    }

    public final void setMMaxVO2(int i) {
        this.mMaxVO2 = i;
    }

    public final void setMMetTotal(int i) {
        this.mMetTotal = i;
    }

    public final void setMMinAltitude(int i) {
        this.mMinAltitude = i;
    }

    public final void setMMinBpm(int i) {
        this.mMinBpm = i;
    }

    public final void setMMinPace(int i) {
        this.mMinPace = i;
    }

    public final void setMMinSpeed(int i) {
        this.mMinSpeed = i;
    }

    public final void setMMinSpm(int i) {
        this.mMinSpm = i;
    }

    public final void setMMinStress(int i) {
        this.mMinStress = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMPacePathCount(int i) {
        this.mPacePathCount = i;
    }

    public final void setMPacePathPoints(@oOoXoXO List<Integer> list) {
        this.mPacePathPoints = list;
    }

    public final void setMPacePathSampleInterval(int i) {
        this.mPacePathSampleInterval = i;
    }

    public final void setMPathCount(int i) {
        this.mPathCount = i;
    }

    public final void setMPathPoints(@oOoXoXO List<float[]> list) {
        this.mPathPoints = list;
    }

    public final void setMPathSampleInterval(int i) {
        this.mPathSampleInterval = i;
    }

    public final void setMPersonalZone(@oOoXoXO int[] iArr) {
        this.mPersonalZone = iArr;
    }

    public final void setMPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPlatform = str;
    }

    public final void setMPrototype(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPrototype = str;
    }

    public final void setMRecoveryTime(int i) {
        this.mRecoveryTime = i;
    }

    public final void setMRestDuration(int i) {
        this.mRestDuration = i;
    }

    public final void setMSource(int i) {
        this.mSource = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMSpeedPathCount(int i) {
        this.mSpeedPathCount = i;
    }

    public final void setMSpeedPathPoints(@oOoXoXO List<Integer> list) {
        this.mSpeedPathPoints = list;
    }

    public final void setMSpeedPathSampleInterval(int i) {
        this.mSpeedPathSampleInterval = i;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMStamina(int i) {
        this.mStamina = i;
    }

    public final void setMStart(long j) {
        this.mStart = j;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMTrainingLoad(int i) {
        this.mTrainingLoad = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "Workout(mId=" + this.mId + ", mStart=" + this.mStart + ", mEnd=" + this.mEnd + ", mLocalTime=" + this.mLocalTime + ", mDuration=" + this.mDuration + ", mAltitude=" + this.mAltitude + ", mAirPressure=" + this.mAirPressure + ", mSpm=" + this.mSpm + ", mMode=" + this.mMode + ", mStep=" + this.mStep + ", mDistance=" + this.mDistance + ", mCalorie=" + this.mCalorie + ", mSpeed=" + this.mSpeed + ", mPace=" + this.mPace + ", mAvgBpm=" + this.mAvgBpm + ", mMaxBpm=" + this.mMaxBpm + ", mMinBpm=" + this.mMinBpm + ", mMaxSpm=" + this.mMaxSpm + ", mMinSpm=" + this.mMinSpm + ", mMaxPace=" + this.mMaxPace + ", mMinPace=" + this.mMinPace + ", mMaxAltitude=" + this.mMaxAltitude + ", mMinAltitude=" + this.mMinAltitude + ", mMinStress=" + this.mMinStress + ", mMaxStress=" + this.mMaxStress + ", mAvgStress=" + this.mAvgStress + ", mSource=" + this.mSource + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + ", mFeel=" + this.mFeel + ", mPrototype=" + this.mPrototype + ", mFirmwareFlag=" + this.mFirmwareFlag + ", mBleName=" + this.mBleName + ", mPlatform=" + this.mPlatform + ", mMaxSpeed=" + this.mMaxSpeed + ", mMinSpeed=" + this.mMinSpeed + ", mRestDuration=" + this.mRestDuration + ", mAGpsType=" + this.mAGpsType + ", mType=" + this.mType + ", mMetTotal=" + this.mMetTotal + ", mAerobic=" + this.mAerobic + ", mAnaerobic=" + this.mAnaerobic + ", mStamina=" + this.mStamina + ", mAvgSpeed=" + this.mAvgSpeed + ", mCadence=" + this.mCadence + ", mMaxCadence=" + this.mMaxCadence + ", mCnt=" + this.mCnt + ", mBpmZoneCount=" + Arrays.toString(this.mBpmZoneCount) + ", mPersonalZone=" + Arrays.toString(this.mPersonalZone) + ", mLactateThresholdPace=" + this.mLactateThresholdPace + ", mRecoveryTime=" + this.mRecoveryTime + ", mTrainingLoad=" + this.mTrainingLoad + ", mMaxVO2=" + this.mMaxVO2 + ", mLactateThresholdHr=" + this.mLactateThresholdHr + ", mAlgorithmMarking=" + this.mAlgorithmMarking + ", mPathCount=" + this.mPathCount + ", mPathSampleInterval=" + this.mPathSampleInterval + ", mPathPoints=" + this.mPathPoints + ", mHrPathCount=" + this.mHrPathCount + ", mHrPathSampleInterval=" + this.mHrPathSampleInterval + ", mHrPathPoints=" + this.mHrPathPoints + ", mPacePathCount=" + this.mPacePathCount + ", mPacePathSampleInterval=" + this.mPacePathSampleInterval + ", mPacePathPoints=" + this.mPacePathPoints + ", mSpeedPathCount=" + this.mSpeedPathCount + ", mSpeedPathSampleInterval=" + this.mSpeedPathSampleInterval + ", mSpeedPathPoints=" + this.mSpeedPathPoints + ", mCadencePathCount=" + this.mCadencePathCount + ", mCadencePathSampleInterval=" + this.mCadencePathSampleInterval + ", mCadencePathPoints=" + this.mCadencePathPoints + ", mAltitudePathCount=" + this.mAltitudePathCount + ", mAltitudePathSampleInterval=" + this.mAltitudePathSampleInterval + ", mAltitudePathPoints=" + this.mAltitudePathPoints + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Workout(int i, long j, long j2, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, @OOXIXo String mBleName, @OOXIXo String mPlatform, int i28, int i29, int i30, int i31, int i32, int i33, float f, float f2, int i34, float f3, int i35, int i36, int i37, @oOoXoXO int[] iArr, @oOoXoXO int[] iArr2, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, @oOoXoXO List<float[]> list, int i46, int i47, @oOoXoXO List<Integer> list2, int i48, int i49, @oOoXoXO List<Integer> list3, int i50, int i51, @oOoXoXO List<Integer> list4, int i52, int i53, @oOoXoXO List<Integer> list5, int i54, int i55, @oOoXoXO List<Integer> list6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        this.mId = i;
        this.mStart = j;
        this.mEnd = j2;
        this.mLocalTime = mLocalTime;
        this.mDuration = i2;
        this.mAltitude = i3;
        this.mAirPressure = i4;
        this.mSpm = i5;
        this.mMode = i6;
        this.mStep = i7;
        this.mDistance = i8;
        this.mCalorie = i9;
        this.mSpeed = i10;
        this.mPace = i11;
        this.mAvgBpm = i12;
        this.mMaxBpm = i13;
        this.mMinBpm = i14;
        this.mMaxSpm = i15;
        this.mMinSpm = i16;
        this.mMaxPace = i17;
        this.mMinPace = i18;
        this.mMaxAltitude = i19;
        this.mMinAltitude = i20;
        this.mMinStress = i21;
        this.mMaxStress = i22;
        this.mAvgStress = i23;
        this.mSource = i24;
        this.mIsSync = i25;
        this.mIsDelete = i26;
        this.mFeel = i27;
        this.mPrototype = mPrototype;
        this.mFirmwareFlag = mFirmwareFlag;
        this.mBleName = mBleName;
        this.mPlatform = mPlatform;
        this.mMaxSpeed = i28;
        this.mMinSpeed = i29;
        this.mRestDuration = i30;
        this.mAGpsType = i31;
        this.mType = i32;
        this.mMetTotal = i33;
        this.mAerobic = f;
        this.mAnaerobic = f2;
        this.mStamina = i34;
        this.mAvgSpeed = f3;
        this.mCadence = i35;
        this.mMaxCadence = i36;
        this.mCnt = i37;
        this.mBpmZoneCount = iArr;
        this.mPersonalZone = iArr2;
        this.mLactateThresholdPace = i38;
        this.mRecoveryTime = i39;
        this.mTrainingLoad = i40;
        this.mMaxVO2 = i41;
        this.mLactateThresholdHr = i42;
        this.mAlgorithmMarking = i43;
        this.mPathCount = i44;
        this.mPathSampleInterval = i45;
        this.mPathPoints = list;
        this.mHrPathCount = i46;
        this.mHrPathSampleInterval = i47;
        this.mHrPathPoints = list2;
        this.mPacePathCount = i48;
        this.mPacePathSampleInterval = i49;
        this.mPacePathPoints = list3;
        this.mSpeedPathCount = i50;
        this.mSpeedPathSampleInterval = i51;
        this.mSpeedPathPoints = list4;
        this.mCadencePathCount = i52;
        this.mCadencePathSampleInterval = i53;
        this.mCadencePathPoints = list5;
        this.mAltitudePathCount = i54;
        this.mAltitudePathSampleInterval = i55;
        this.mAltitudePathPoints = list6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Workout(int r75, long r76, long r78, java.lang.String r80, int r81, int r82, int r83, int r84, int r85, int r86, int r87, int r88, int r89, int r90, int r91, int r92, int r93, int r94, int r95, int r96, int r97, int r98, int r99, int r100, int r101, int r102, int r103, int r104, int r105, int r106, java.lang.String r107, java.lang.String r108, java.lang.String r109, java.lang.String r110, int r111, int r112, int r113, int r114, int r115, int r116, float r117, float r118, int r119, float r120, int r121, int r122, int r123, int[] r124, int[] r125, int r126, int r127, int r128, int r129, int r130, int r131, int r132, int r133, java.util.List r134, int r135, int r136, java.util.List r137, int r138, int r139, java.util.List r140, int r141, int r142, java.util.List r143, int r144, int r145, java.util.List r146, int r147, int r148, java.util.List r149, int r150, int r151, int r152, kotlin.jvm.internal.IIXOooo r153) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.db.entity.Workout.<init>(int, long, long, java.lang.String, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int, int, float, float, int, float, int, int, int, int[], int[], int, int, int, int, int, int, int, int, java.util.List, int, int, java.util.List, int, int, java.util.List, int, int, java.util.List, int, int, java.util.List, int, int, java.util.List, int, int, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Workout(@OOXIXo BleWorkout bleWorkout, long j) {
        this(0, ((bleWorkout.getMStart() + BleConstsKt.DATA_EPOCH) * 1000) - j, ((bleWorkout.getMEnd() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleWorkout.getMDuration(), bleWorkout.getMAltitude(), bleWorkout.getMAirPressure(), bleWorkout.getMSpm(), bleWorkout.getMMode(), bleWorkout.getMStep(), bleWorkout.getMDistance(), bleWorkout.getMCalorie(), bleWorkout.getMSpeed(), bleWorkout.getMPace(), bleWorkout.getMAvgBpm(), bleWorkout.getMMaxBpm(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, -65527, -1, 511, null);
        IIX0o.x0xO0oo(bleWorkout, "bleWorkout");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Workout(@OOXIXo BleWorkout2 bleWorkout, long j) {
        this(0, ((bleWorkout.getMStart() + BleConstsKt.DATA_EPOCH) * 1000) - j, ((bleWorkout.getMEnd() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleWorkout.getMDuration(), bleWorkout.getMAltitude(), bleWorkout.getMAirPressure(), bleWorkout.getMSpm(), bleWorkout.getMMode(), bleWorkout.getMStep(), bleWorkout.getMDistance(), bleWorkout.getMCalorie(), bleWorkout.getMSpeed(), bleWorkout.getMPace(), bleWorkout.getMAvgBpm(), bleWorkout.getMMaxBpm(), bleWorkout.getMMinBpm(), bleWorkout.getMMaxSpm(), bleWorkout.getMMinSpm(), bleWorkout.getMMaxPace(), bleWorkout.getMMinPace(), bleWorkout.getMMaxAltitude(), bleWorkout.getMMinAltitude(), bleWorkout.getMMinStress(), bleWorkout.getMMaxStress(), bleWorkout.getMAvgStress(), 0, 0, 0, 0, null, null, null, null, bleWorkout.getMMaxSpeed(), bleWorkout.getMMinSpeed(), bleWorkout.getMRestDuration(), 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, -67108855, -29, 511, null);
        IIX0o.x0xO0oo(bleWorkout, "bleWorkout");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Workout(@OOXIXo BleWorkout3 bleWorkout, long j) {
        this(0, ((bleWorkout.getMStart() + BleConstsKt.DATA_EPOCH) * 1000) - j, ((bleWorkout.getMEnd() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleWorkout.getMDuration(), bleWorkout.getMAltitude(), bleWorkout.getMAirPressure(), bleWorkout.getMSpm(), bleWorkout.getMMode(), bleWorkout.getMStep(), bleWorkout.getMDistance(), bleWorkout.getMCalorie(), bleWorkout.getMSpeed(), bleWorkout.getMPace(), bleWorkout.getMAvgBpm(), bleWorkout.getMMaxBpm(), bleWorkout.getMMinBpm(), bleWorkout.getMMaxSpm(), bleWorkout.getMMinSpm(), bleWorkout.getMMaxPace(), bleWorkout.getMMinPace(), bleWorkout.getMMaxAltitude(), bleWorkout.getMMinAltitude(), bleWorkout.getMMinStress(), bleWorkout.getMMaxStress(), bleWorkout.getMAvgStress(), 0, 0, 0, 0, null, null, null, null, bleWorkout.getMMaxSpeed(), bleWorkout.getMMinSpeed(), 0, 0, 1, bleWorkout.getMMetTotal(), bleWorkout.getMAerobic(), bleWorkout.getMAnaerobic(), bleWorkout.getMStamina(), bleWorkout.getMAvgSpeed(), bleWorkout.getMCadence(), bleWorkout.getMMaxCadence(), bleWorkout.getMCnt(), bleWorkout.getMBpmZoneCount(), bleWorkout.getMPersonalZone(), bleWorkout.getMLactateThresholdPace(), bleWorkout.getMRecoveryTime(), bleWorkout.getMTrainingLoad(), bleWorkout.getMMaxVO2(), bleWorkout.getMLactateThresholdHr(), bleWorkout.getMAlgorithmMarking(), bleWorkout.getMPathCount(), bleWorkout.getMPathSampleInterval(), bleWorkout.getMPathPoints(), bleWorkout.getMHrPathCount(), bleWorkout.getMHrPathSampleInterval(), bleWorkout.getMHrPathPoints(), bleWorkout.getMPacePathCount(), bleWorkout.getMPacePathSampleInterval(), bleWorkout.getMPacePathPoints(), bleWorkout.getMSpeedPathCount(), bleWorkout.getMSpeedPathSampleInterval(), bleWorkout.getMSpeedPathPoints(), bleWorkout.getMCadencePathCount(), bleWorkout.getMCadencePathSampleInterval(), bleWorkout.getMCadencePathPoints(), bleWorkout.getMAltitudePathCount(), bleWorkout.getMAltitudePathSampleInterval(), bleWorkout.getMAltitudePathPoints(), -67108855, 51, 0, null);
        IIX0o.x0xO0oo(bleWorkout, "bleWorkout");
    }
}
