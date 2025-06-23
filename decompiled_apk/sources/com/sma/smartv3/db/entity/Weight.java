package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.blankj.utilcode.util.TimeUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.C;
import com.sma.smartv3.util.xoIox;
import java.io.Serializable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@TypeConverters({ListDoubleConverter.class})
@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class Weight implements Serializable {

    @ColumnInfo
    private double mAgeOfBody;

    @OOXIXo
    @ColumnInfo
    private List<Double> mAgeOfBodyRange;

    @ColumnInfo
    private double mBmi;

    @OOXIXo
    @ColumnInfo
    private List<Double> mBmiRange;

    @OOXIXo
    @ColumnInfo
    private List<Double> mBmiWHORange;

    @ColumnInfo
    private double mBmr;

    @OOXIXo
    @ColumnInfo
    private List<Double> mBmrRange;

    @ColumnInfo
    private double mBodyShape;

    @ColumnInfo
    private double mDesirableWeight;

    @ColumnInfo
    private double mFatFreeBodyWeight;

    @ColumnInfo
    private double mFatToControl;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private double mIdealWeight;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsMeasure;

    @ColumnInfo
    private int mIsSync;

    @ColumnInfo
    private double mLevelOfVisceralFat;

    @OOXIXo
    @ColumnInfo
    private List<Double> mLevelOfVisceralFatRange;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private double mMuscleToControl;

    @ColumnInfo
    private double mRatioOfFat;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfFatRange;

    @ColumnInfo
    private double mRatioOfMuscle;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfMuscleRange;

    @ColumnInfo
    private double mRatioOfProtein;

    @ColumnInfo
    private int mRatioOfProteinLevel;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfProteinRange;

    @ColumnInfo
    private double mRatioOfSkeletalMuscle;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfSkeletalMuscleRange;

    @ColumnInfo
    private double mRatioOfSubcutaneousFat;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfSubcutaneousFatRange;

    @ColumnInfo
    private double mRatioOfWater;

    @ColumnInfo
    private int mRatioOfWaterLevel;

    @OOXIXo
    @ColumnInfo
    private List<Double> mRatioOfWaterRange;

    @ColumnInfo
    private double mScore;

    @ColumnInfo
    private double mStateOfNutrition;

    @ColumnInfo
    private long mTime;

    @ColumnInfo
    private float mWeight;

    @ColumnInfo
    private double mWeightOfBone;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfBoneRange;

    @ColumnInfo
    private double mWeightOfFat;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfFatRange;

    @ColumnInfo
    private double mWeightOfMuscle;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfMuscleRange;

    @ColumnInfo
    private double mWeightOfProtein;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfProteinRange;

    @ColumnInfo
    private double mWeightOfSkeletalMuscle;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfSkeletalMuscleRange;

    @ColumnInfo
    private double mWeightOfWater;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightOfWaterRange;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightRange;

    @ColumnInfo
    private double mWeightToControl;

    @OOXIXo
    @ColumnInfo
    private List<Double> mWeightWHORange;

    public Weight() {
        this(0, 0L, null, 0.0f, 0, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -1, 2097151, null);
    }

    public static /* synthetic */ Weight copy$default(Weight weight, int i, long j, String str, float f, int i2, int i3, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, List list, List list2, List list3, double d10, List list4, double d11, double d12, double d13, double d14, double d15, List list5, double d16, List list6, double d17, List list7, List list8, double d18, List list9, double d19, List list10, List list11, double d20, double d21, List list12, List list13, List list14, double d22, List list15, double d23, List list16, double d24, List list17, List list18, double d25, List list19, int i4, int i5, int i6, int i7, int i8, Object obj) {
        int i9 = (i7 & 1) != 0 ? weight.mId : i;
        long j2 = (i7 & 2) != 0 ? weight.mTime : j;
        String str2 = (i7 & 4) != 0 ? weight.mLocalTime : str;
        float f2 = (i7 & 8) != 0 ? weight.mWeight : f;
        int i10 = (i7 & 16) != 0 ? weight.mIsSync : i2;
        int i11 = (i7 & 32) != 0 ? weight.mIsMeasure : i3;
        double d26 = (i7 & 64) != 0 ? weight.mBmi : d;
        double d27 = (i7 & 128) != 0 ? weight.mRatioOfFat : d2;
        double d28 = (i7 & 256) != 0 ? weight.mWeightOfMuscle : d3;
        double d29 = (i7 & 512) != 0 ? weight.mWeightOfFat : d4;
        double d30 = (i7 & 1024) != 0 ? weight.mRatioOfProtein : d5;
        double d31 = (i7 & 2048) != 0 ? weight.mRatioOfWater : d6;
        double d32 = (i7 & 4096) != 0 ? weight.mStateOfNutrition : d7;
        double d33 = (i7 & 8192) != 0 ? weight.mIdealWeight : d8;
        double d34 = (i7 & 16384) != 0 ? weight.mAgeOfBody : d9;
        List list20 = (i7 & 32768) != 0 ? weight.mAgeOfBodyRange : list;
        List list21 = (i7 & 65536) != 0 ? weight.mBmiRange : list2;
        List list22 = list20;
        List list23 = (i7 & 131072) != 0 ? weight.mBmiWHORange : list3;
        double d35 = (i7 & 262144) != 0 ? weight.mBmr : d10;
        List list24 = (i7 & 524288) != 0 ? weight.mBmrRange : list4;
        double d36 = d27;
        double d37 = (i7 & 1048576) != 0 ? weight.mBodyShape : d11;
        double d38 = (i7 & 2097152) != 0 ? weight.mDesirableWeight : d12;
        double d39 = (i7 & 4194304) != 0 ? weight.mFatFreeBodyWeight : d13;
        double d40 = (i7 & 8388608) != 0 ? weight.mFatToControl : d14;
        double d41 = (i7 & 16777216) != 0 ? weight.mLevelOfVisceralFat : d15;
        List list25 = (i7 & 33554432) != 0 ? weight.mLevelOfVisceralFatRange : list5;
        double d42 = d41;
        double d43 = (i7 & 67108864) != 0 ? weight.mMuscleToControl : d16;
        List list26 = (i7 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? weight.mRatioOfFatRange : list6;
        double d44 = (268435456 & i7) != 0 ? weight.mRatioOfMuscle : d17;
        List list27 = (i7 & 536870912) != 0 ? weight.mRatioOfMuscleRange : list7;
        List list28 = (1073741824 & i7) != 0 ? weight.mRatioOfProteinRange : list8;
        double d45 = (i7 & Integer.MIN_VALUE) != 0 ? weight.mRatioOfSkeletalMuscle : d18;
        List list29 = (i8 & 1) != 0 ? weight.mRatioOfSkeletalMuscleRange : list9;
        double d46 = d45;
        double d47 = (i8 & 2) != 0 ? weight.mRatioOfSubcutaneousFat : d19;
        List list30 = (i8 & 4) != 0 ? weight.mRatioOfSubcutaneousFatRange : list10;
        List list31 = (i8 & 8) != 0 ? weight.mRatioOfWaterRange : list11;
        double d48 = (i8 & 16) != 0 ? weight.mScore : d20;
        double d49 = (i8 & 32) != 0 ? weight.mWeightOfBone : d21;
        List list32 = (i8 & 64) != 0 ? weight.mWeightOfBoneRange : list12;
        return weight.copy(i9, j2, str2, f2, i10, i11, d26, d36, d28, d29, d30, d31, d32, d33, d34, list22, list21, list23, d35, list24, d37, d38, d39, d40, d42, list25, d43, list26, d44, list27, list28, d46, list29, d47, list30, list31, d48, d49, list32, (i8 & 128) != 0 ? weight.mWeightOfFatRange : list13, (i8 & 256) != 0 ? weight.mWeightOfMuscleRange : list14, (i8 & 512) != 0 ? weight.mWeightOfProtein : d22, (i8 & 1024) != 0 ? weight.mWeightOfProteinRange : list15, (i8 & 2048) != 0 ? weight.mWeightOfSkeletalMuscle : d23, (i8 & 4096) != 0 ? weight.mWeightOfSkeletalMuscleRange : list16, (i8 & 8192) != 0 ? weight.mWeightOfWater : d24, (i8 & 16384) != 0 ? weight.mWeightOfWaterRange : list17, (i8 & 32768) != 0 ? weight.mWeightRange : list18, (i8 & 65536) != 0 ? weight.mWeightToControl : d25, (i8 & 131072) != 0 ? weight.mWeightWHORange : list19, (i8 & 262144) != 0 ? weight.mIsDelete : i4, (i8 & 524288) != 0 ? weight.mRatioOfProteinLevel : i5, (i8 & 1048576) != 0 ? weight.mRatioOfWaterLevel : i6);
    }

    public final int component1() {
        return this.mId;
    }

    public final double component10() {
        return this.mWeightOfFat;
    }

    public final double component11() {
        return this.mRatioOfProtein;
    }

    public final double component12() {
        return this.mRatioOfWater;
    }

    public final double component13() {
        return this.mStateOfNutrition;
    }

    public final double component14() {
        return this.mIdealWeight;
    }

    public final double component15() {
        return this.mAgeOfBody;
    }

    @OOXIXo
    public final List<Double> component16() {
        return this.mAgeOfBodyRange;
    }

    @OOXIXo
    public final List<Double> component17() {
        return this.mBmiRange;
    }

    @OOXIXo
    public final List<Double> component18() {
        return this.mBmiWHORange;
    }

    public final double component19() {
        return this.mBmr;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final List<Double> component20() {
        return this.mBmrRange;
    }

    public final double component21() {
        return this.mBodyShape;
    }

    public final double component22() {
        return this.mDesirableWeight;
    }

    public final double component23() {
        return this.mFatFreeBodyWeight;
    }

    public final double component24() {
        return this.mFatToControl;
    }

    public final double component25() {
        return this.mLevelOfVisceralFat;
    }

    @OOXIXo
    public final List<Double> component26() {
        return this.mLevelOfVisceralFatRange;
    }

    public final double component27() {
        return this.mMuscleToControl;
    }

    @OOXIXo
    public final List<Double> component28() {
        return this.mRatioOfFatRange;
    }

    public final double component29() {
        return this.mRatioOfMuscle;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    @OOXIXo
    public final List<Double> component30() {
        return this.mRatioOfMuscleRange;
    }

    @OOXIXo
    public final List<Double> component31() {
        return this.mRatioOfProteinRange;
    }

    public final double component32() {
        return this.mRatioOfSkeletalMuscle;
    }

    @OOXIXo
    public final List<Double> component33() {
        return this.mRatioOfSkeletalMuscleRange;
    }

    public final double component34() {
        return this.mRatioOfSubcutaneousFat;
    }

    @OOXIXo
    public final List<Double> component35() {
        return this.mRatioOfSubcutaneousFatRange;
    }

    @OOXIXo
    public final List<Double> component36() {
        return this.mRatioOfWaterRange;
    }

    public final double component37() {
        return this.mScore;
    }

    public final double component38() {
        return this.mWeightOfBone;
    }

    @OOXIXo
    public final List<Double> component39() {
        return this.mWeightOfBoneRange;
    }

    public final float component4() {
        return this.mWeight;
    }

    @OOXIXo
    public final List<Double> component40() {
        return this.mWeightOfFatRange;
    }

    @OOXIXo
    public final List<Double> component41() {
        return this.mWeightOfMuscleRange;
    }

    public final double component42() {
        return this.mWeightOfProtein;
    }

    @OOXIXo
    public final List<Double> component43() {
        return this.mWeightOfProteinRange;
    }

    public final double component44() {
        return this.mWeightOfSkeletalMuscle;
    }

    @OOXIXo
    public final List<Double> component45() {
        return this.mWeightOfSkeletalMuscleRange;
    }

    public final double component46() {
        return this.mWeightOfWater;
    }

    @OOXIXo
    public final List<Double> component47() {
        return this.mWeightOfWaterRange;
    }

    @OOXIXo
    public final List<Double> component48() {
        return this.mWeightRange;
    }

    public final double component49() {
        return this.mWeightToControl;
    }

    public final int component5() {
        return this.mIsSync;
    }

    @OOXIXo
    public final List<Double> component50() {
        return this.mWeightWHORange;
    }

    public final int component51() {
        return this.mIsDelete;
    }

    public final int component52() {
        return this.mRatioOfProteinLevel;
    }

    public final int component53() {
        return this.mRatioOfWaterLevel;
    }

    public final int component6() {
        return this.mIsMeasure;
    }

    public final double component7() {
        return this.mBmi;
    }

    public final double component8() {
        return this.mRatioOfFat;
    }

    public final double component9() {
        return this.mWeightOfMuscle;
    }

    @OOXIXo
    public final Weight copy(int i, long j, @OOXIXo String mLocalTime, float f, int i2, int i3, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, @OOXIXo List<Double> mAgeOfBodyRange, @OOXIXo List<Double> mBmiRange, @OOXIXo List<Double> mBmiWHORange, double d10, @OOXIXo List<Double> mBmrRange, double d11, double d12, double d13, double d14, double d15, @OOXIXo List<Double> mLevelOfVisceralFatRange, double d16, @OOXIXo List<Double> mRatioOfFatRange, double d17, @OOXIXo List<Double> mRatioOfMuscleRange, @OOXIXo List<Double> mRatioOfProteinRange, double d18, @OOXIXo List<Double> mRatioOfSkeletalMuscleRange, double d19, @OOXIXo List<Double> mRatioOfSubcutaneousFatRange, @OOXIXo List<Double> mRatioOfWaterRange, double d20, double d21, @OOXIXo List<Double> mWeightOfBoneRange, @OOXIXo List<Double> mWeightOfFatRange, @OOXIXo List<Double> mWeightOfMuscleRange, double d22, @OOXIXo List<Double> mWeightOfProteinRange, double d23, @OOXIXo List<Double> mWeightOfSkeletalMuscleRange, double d24, @OOXIXo List<Double> mWeightOfWaterRange, @OOXIXo List<Double> mWeightRange, double d25, @OOXIXo List<Double> mWeightWHORange, int i4, int i5, int i6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mAgeOfBodyRange, "mAgeOfBodyRange");
        IIX0o.x0xO0oo(mBmiRange, "mBmiRange");
        IIX0o.x0xO0oo(mBmiWHORange, "mBmiWHORange");
        IIX0o.x0xO0oo(mBmrRange, "mBmrRange");
        IIX0o.x0xO0oo(mLevelOfVisceralFatRange, "mLevelOfVisceralFatRange");
        IIX0o.x0xO0oo(mRatioOfFatRange, "mRatioOfFatRange");
        IIX0o.x0xO0oo(mRatioOfMuscleRange, "mRatioOfMuscleRange");
        IIX0o.x0xO0oo(mRatioOfProteinRange, "mRatioOfProteinRange");
        IIX0o.x0xO0oo(mRatioOfSkeletalMuscleRange, "mRatioOfSkeletalMuscleRange");
        IIX0o.x0xO0oo(mRatioOfSubcutaneousFatRange, "mRatioOfSubcutaneousFatRange");
        IIX0o.x0xO0oo(mRatioOfWaterRange, "mRatioOfWaterRange");
        IIX0o.x0xO0oo(mWeightOfBoneRange, "mWeightOfBoneRange");
        IIX0o.x0xO0oo(mWeightOfFatRange, "mWeightOfFatRange");
        IIX0o.x0xO0oo(mWeightOfMuscleRange, "mWeightOfMuscleRange");
        IIX0o.x0xO0oo(mWeightOfProteinRange, "mWeightOfProteinRange");
        IIX0o.x0xO0oo(mWeightOfSkeletalMuscleRange, "mWeightOfSkeletalMuscleRange");
        IIX0o.x0xO0oo(mWeightOfWaterRange, "mWeightOfWaterRange");
        IIX0o.x0xO0oo(mWeightRange, "mWeightRange");
        IIX0o.x0xO0oo(mWeightWHORange, "mWeightWHORange");
        return new Weight(i, j, mLocalTime, f, i2, i3, d, d2, d3, d4, d5, d6, d7, d8, d9, mAgeOfBodyRange, mBmiRange, mBmiWHORange, d10, mBmrRange, d11, d12, d13, d14, d15, mLevelOfVisceralFatRange, d16, mRatioOfFatRange, d17, mRatioOfMuscleRange, mRatioOfProteinRange, d18, mRatioOfSkeletalMuscleRange, d19, mRatioOfSubcutaneousFatRange, mRatioOfWaterRange, d20, d21, mWeightOfBoneRange, mWeightOfFatRange, mWeightOfMuscleRange, d22, mWeightOfProteinRange, d23, mWeightOfSkeletalMuscleRange, d24, mWeightOfWaterRange, mWeightRange, d25, mWeightWHORange, i4, i5, i6);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Weight)) {
            return false;
        }
        Weight weight = (Weight) obj;
        return this.mId == weight.mId && this.mTime == weight.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, weight.mLocalTime) && Float.compare(this.mWeight, weight.mWeight) == 0 && this.mIsSync == weight.mIsSync && this.mIsMeasure == weight.mIsMeasure && Double.compare(this.mBmi, weight.mBmi) == 0 && Double.compare(this.mRatioOfFat, weight.mRatioOfFat) == 0 && Double.compare(this.mWeightOfMuscle, weight.mWeightOfMuscle) == 0 && Double.compare(this.mWeightOfFat, weight.mWeightOfFat) == 0 && Double.compare(this.mRatioOfProtein, weight.mRatioOfProtein) == 0 && Double.compare(this.mRatioOfWater, weight.mRatioOfWater) == 0 && Double.compare(this.mStateOfNutrition, weight.mStateOfNutrition) == 0 && Double.compare(this.mIdealWeight, weight.mIdealWeight) == 0 && Double.compare(this.mAgeOfBody, weight.mAgeOfBody) == 0 && IIX0o.Oxx0IOOO(this.mAgeOfBodyRange, weight.mAgeOfBodyRange) && IIX0o.Oxx0IOOO(this.mBmiRange, weight.mBmiRange) && IIX0o.Oxx0IOOO(this.mBmiWHORange, weight.mBmiWHORange) && Double.compare(this.mBmr, weight.mBmr) == 0 && IIX0o.Oxx0IOOO(this.mBmrRange, weight.mBmrRange) && Double.compare(this.mBodyShape, weight.mBodyShape) == 0 && Double.compare(this.mDesirableWeight, weight.mDesirableWeight) == 0 && Double.compare(this.mFatFreeBodyWeight, weight.mFatFreeBodyWeight) == 0 && Double.compare(this.mFatToControl, weight.mFatToControl) == 0 && Double.compare(this.mLevelOfVisceralFat, weight.mLevelOfVisceralFat) == 0 && IIX0o.Oxx0IOOO(this.mLevelOfVisceralFatRange, weight.mLevelOfVisceralFatRange) && Double.compare(this.mMuscleToControl, weight.mMuscleToControl) == 0 && IIX0o.Oxx0IOOO(this.mRatioOfFatRange, weight.mRatioOfFatRange) && Double.compare(this.mRatioOfMuscle, weight.mRatioOfMuscle) == 0 && IIX0o.Oxx0IOOO(this.mRatioOfMuscleRange, weight.mRatioOfMuscleRange) && IIX0o.Oxx0IOOO(this.mRatioOfProteinRange, weight.mRatioOfProteinRange) && Double.compare(this.mRatioOfSkeletalMuscle, weight.mRatioOfSkeletalMuscle) == 0 && IIX0o.Oxx0IOOO(this.mRatioOfSkeletalMuscleRange, weight.mRatioOfSkeletalMuscleRange) && Double.compare(this.mRatioOfSubcutaneousFat, weight.mRatioOfSubcutaneousFat) == 0 && IIX0o.Oxx0IOOO(this.mRatioOfSubcutaneousFatRange, weight.mRatioOfSubcutaneousFatRange) && IIX0o.Oxx0IOOO(this.mRatioOfWaterRange, weight.mRatioOfWaterRange) && Double.compare(this.mScore, weight.mScore) == 0 && Double.compare(this.mWeightOfBone, weight.mWeightOfBone) == 0 && IIX0o.Oxx0IOOO(this.mWeightOfBoneRange, weight.mWeightOfBoneRange) && IIX0o.Oxx0IOOO(this.mWeightOfFatRange, weight.mWeightOfFatRange) && IIX0o.Oxx0IOOO(this.mWeightOfMuscleRange, weight.mWeightOfMuscleRange) && Double.compare(this.mWeightOfProtein, weight.mWeightOfProtein) == 0 && IIX0o.Oxx0IOOO(this.mWeightOfProteinRange, weight.mWeightOfProteinRange) && Double.compare(this.mWeightOfSkeletalMuscle, weight.mWeightOfSkeletalMuscle) == 0 && IIX0o.Oxx0IOOO(this.mWeightOfSkeletalMuscleRange, weight.mWeightOfSkeletalMuscleRange) && Double.compare(this.mWeightOfWater, weight.mWeightOfWater) == 0 && IIX0o.Oxx0IOOO(this.mWeightOfWaterRange, weight.mWeightOfWaterRange) && IIX0o.Oxx0IOOO(this.mWeightRange, weight.mWeightRange) && Double.compare(this.mWeightToControl, weight.mWeightToControl) == 0 && IIX0o.Oxx0IOOO(this.mWeightWHORange, weight.mWeightWHORange) && this.mIsDelete == weight.mIsDelete && this.mRatioOfProteinLevel == weight.mRatioOfProteinLevel && this.mRatioOfWaterLevel == weight.mRatioOfWaterLevel;
    }

    public final double getMAgeOfBody() {
        return this.mAgeOfBody;
    }

    @OOXIXo
    public final List<Double> getMAgeOfBodyRange() {
        return this.mAgeOfBodyRange;
    }

    public final double getMBmi() {
        return this.mBmi;
    }

    @OOXIXo
    public final List<Double> getMBmiRange() {
        return this.mBmiRange;
    }

    @OOXIXo
    public final List<Double> getMBmiWHORange() {
        return this.mBmiWHORange;
    }

    public final double getMBmr() {
        return this.mBmr;
    }

    @OOXIXo
    public final List<Double> getMBmrRange() {
        return this.mBmrRange;
    }

    public final double getMBodyShape() {
        return this.mBodyShape;
    }

    public final double getMDesirableWeight() {
        return this.mDesirableWeight;
    }

    public final double getMFatFreeBodyWeight() {
        return this.mFatFreeBodyWeight;
    }

    public final double getMFatToControl() {
        return this.mFatToControl;
    }

    public final int getMId() {
        return this.mId;
    }

    public final double getMIdealWeight() {
        return this.mIdealWeight;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsMeasure() {
        return this.mIsMeasure;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    public final double getMLevelOfVisceralFat() {
        return this.mLevelOfVisceralFat;
    }

    @OOXIXo
    public final List<Double> getMLevelOfVisceralFatRange() {
        return this.mLevelOfVisceralFatRange;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final double getMMuscleToControl() {
        return this.mMuscleToControl;
    }

    public final double getMRatioOfFat() {
        return this.mRatioOfFat;
    }

    @OOXIXo
    public final List<Double> getMRatioOfFatRange() {
        return this.mRatioOfFatRange;
    }

    public final double getMRatioOfMuscle() {
        return this.mRatioOfMuscle;
    }

    @OOXIXo
    public final List<Double> getMRatioOfMuscleRange() {
        return this.mRatioOfMuscleRange;
    }

    public final double getMRatioOfProtein() {
        return this.mRatioOfProtein;
    }

    public final int getMRatioOfProteinLevel() {
        return this.mRatioOfProteinLevel;
    }

    @OOXIXo
    public final List<Double> getMRatioOfProteinRange() {
        return this.mRatioOfProteinRange;
    }

    public final double getMRatioOfSkeletalMuscle() {
        return this.mRatioOfSkeletalMuscle;
    }

    @OOXIXo
    public final List<Double> getMRatioOfSkeletalMuscleRange() {
        return this.mRatioOfSkeletalMuscleRange;
    }

    public final double getMRatioOfSubcutaneousFat() {
        return this.mRatioOfSubcutaneousFat;
    }

    @OOXIXo
    public final List<Double> getMRatioOfSubcutaneousFatRange() {
        return this.mRatioOfSubcutaneousFatRange;
    }

    public final double getMRatioOfWater() {
        return this.mRatioOfWater;
    }

    public final int getMRatioOfWaterLevel() {
        return this.mRatioOfWaterLevel;
    }

    @OOXIXo
    public final List<Double> getMRatioOfWaterRange() {
        return this.mRatioOfWaterRange;
    }

    public final double getMScore() {
        return this.mScore;
    }

    public final double getMStateOfNutrition() {
        return this.mStateOfNutrition;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final float getMWeight() {
        return this.mWeight;
    }

    public final double getMWeightOfBone() {
        return this.mWeightOfBone;
    }

    @OOXIXo
    public final List<Double> getMWeightOfBoneRange() {
        return this.mWeightOfBoneRange;
    }

    public final double getMWeightOfFat() {
        return this.mWeightOfFat;
    }

    @OOXIXo
    public final List<Double> getMWeightOfFatRange() {
        return this.mWeightOfFatRange;
    }

    public final double getMWeightOfMuscle() {
        return this.mWeightOfMuscle;
    }

    @OOXIXo
    public final List<Double> getMWeightOfMuscleRange() {
        return this.mWeightOfMuscleRange;
    }

    public final double getMWeightOfProtein() {
        return this.mWeightOfProtein;
    }

    @OOXIXo
    public final List<Double> getMWeightOfProteinRange() {
        return this.mWeightOfProteinRange;
    }

    public final double getMWeightOfSkeletalMuscle() {
        return this.mWeightOfSkeletalMuscle;
    }

    @OOXIXo
    public final List<Double> getMWeightOfSkeletalMuscleRange() {
        return this.mWeightOfSkeletalMuscleRange;
    }

    public final double getMWeightOfWater() {
        return this.mWeightOfWater;
    }

    @OOXIXo
    public final List<Double> getMWeightOfWaterRange() {
        return this.mWeightOfWaterRange;
    }

    @OOXIXo
    public final List<Double> getMWeightRange() {
        return this.mWeightRange;
    }

    public final double getMWeightToControl() {
        return this.mWeightToControl;
    }

    @OOXIXo
    public final List<Double> getMWeightWHORange() {
        return this.mWeightWHORange;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + Float.floatToIntBits(this.mWeight)) * 31) + this.mIsSync) * 31) + this.mIsMeasure) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mBmi)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfFat)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfMuscle)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfFat)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfProtein)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfWater)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mStateOfNutrition)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mIdealWeight)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mAgeOfBody)) * 31) + this.mAgeOfBodyRange.hashCode()) * 31) + this.mBmiRange.hashCode()) * 31) + this.mBmiWHORange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mBmr)) * 31) + this.mBmrRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mBodyShape)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mDesirableWeight)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mFatFreeBodyWeight)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mFatToControl)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mLevelOfVisceralFat)) * 31) + this.mLevelOfVisceralFatRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mMuscleToControl)) * 31) + this.mRatioOfFatRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfMuscle)) * 31) + this.mRatioOfMuscleRange.hashCode()) * 31) + this.mRatioOfProteinRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfSkeletalMuscle)) * 31) + this.mRatioOfSkeletalMuscleRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mRatioOfSubcutaneousFat)) * 31) + this.mRatioOfSubcutaneousFatRange.hashCode()) * 31) + this.mRatioOfWaterRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mScore)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfBone)) * 31) + this.mWeightOfBoneRange.hashCode()) * 31) + this.mWeightOfFatRange.hashCode()) * 31) + this.mWeightOfMuscleRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfProtein)) * 31) + this.mWeightOfProteinRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfSkeletalMuscle)) * 31) + this.mWeightOfSkeletalMuscleRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightOfWater)) * 31) + this.mWeightOfWaterRange.hashCode()) * 31) + this.mWeightRange.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mWeightToControl)) * 31) + this.mWeightWHORange.hashCode()) * 31) + this.mIsDelete) * 31) + this.mRatioOfProteinLevel) * 31) + this.mRatioOfWaterLevel;
    }

    public final void setBodyFatScale(@OOXIXo oxxXoxO.oIX0oI bodyFatScale) {
        IIX0o.x0xO0oo(bodyFatScale, "bodyFatScale");
        long currentTimeMillis = System.currentTimeMillis();
        this.mTime = currentTimeMillis;
        String millis2String = TimeUtils.millis2String(currentTimeMillis, xoIox.I0Io());
        IIX0o.oO(millis2String, "millis2String(...)");
        this.mLocalTime = millis2String;
        this.mWeight = (float) bodyFatScale.Oxx0IOOO().IoIOOxIIo();
        this.mIsMeasure = 1;
        this.mBmi = bodyFatScale.Oxx0IOOO().Xo0();
        this.mRatioOfFat = bodyFatScale.Oxx0IOOO().IIxOXoOo0();
        this.mWeightOfMuscle = bodyFatScale.Oxx0IOOO().OIOoIIOIx();
        this.mWeightOfFat = bodyFatScale.Oxx0IOOO().XIXIxO();
        this.mRatioOfProtein = bodyFatScale.Oxx0IOOO().xX0IIXIx0();
        this.mRatioOfWater = bodyFatScale.Oxx0IOOO().IIX0();
        this.mStateOfNutrition = bodyFatScale.Oxx0IOOO().xx0X0();
        this.mIdealWeight = bodyFatScale.Oxx0IOOO().Ioxxx();
        this.mAgeOfBody = bodyFatScale.Oxx0IOOO().I0X0x0oIo();
        this.mAgeOfBodyRange = bodyFatScale.Oxx0IOOO().oX();
        this.mBmiRange = bodyFatScale.Oxx0IOOO().XoI0Ixx0();
        this.mBmiWHORange = bodyFatScale.Oxx0IOOO().O0Xx();
        this.mBmr = bodyFatScale.Oxx0IOOO().I0oOIX();
        this.mBmrRange = bodyFatScale.Oxx0IOOO().xoxXI();
        this.mBodyShape = bodyFatScale.Oxx0IOOO().OO();
        this.mDesirableWeight = bodyFatScale.Oxx0IOOO().IoOoo();
        this.mFatFreeBodyWeight = bodyFatScale.Oxx0IOOO().x0xO();
        this.mFatToControl = bodyFatScale.Oxx0IOOO().OO0x0xX();
        this.mLevelOfVisceralFat = bodyFatScale.Oxx0IOOO().xxIO();
        this.mLevelOfVisceralFatRange = bodyFatScale.Oxx0IOOO().XX0xXo();
        this.mMuscleToControl = bodyFatScale.Oxx0IOOO().o0xxxXXxX();
        this.mRatioOfFatRange = bodyFatScale.Oxx0IOOO().I0();
        this.mRatioOfMuscle = bodyFatScale.Oxx0IOOO().xoO0xx0();
        this.mRatioOfMuscleRange = bodyFatScale.Oxx0IOOO().OX00O0xII();
        this.mRatioOfProteinRange = bodyFatScale.Oxx0IOOO().xOOOX();
        this.mRatioOfSkeletalMuscle = bodyFatScale.Oxx0IOOO().XIXIX();
        this.mRatioOfSkeletalMuscleRange = bodyFatScale.Oxx0IOOO().oXIO0o0XI();
        this.mRatioOfSubcutaneousFat = bodyFatScale.Oxx0IOOO().oOo();
        this.mRatioOfSubcutaneousFatRange = bodyFatScale.Oxx0IOOO().O0X();
        this.mRatioOfWaterRange = bodyFatScale.Oxx0IOOO().xOoOIoI();
        this.mScore = bodyFatScale.Oxx0IOOO().Ox0O();
        this.mWeightOfBone = bodyFatScale.Oxx0IOOO().oxIIX0o();
        this.mWeightOfBoneRange = bodyFatScale.Oxx0IOOO().o0oIxOo();
        this.mWeightOfFatRange = bodyFatScale.Oxx0IOOO().OoO();
        this.mWeightOfMuscleRange = bodyFatScale.Oxx0IOOO().x0OIX00oO();
        this.mWeightOfProtein = bodyFatScale.Oxx0IOOO().XXoOx0();
        this.mWeightOfProteinRange = bodyFatScale.Oxx0IOOO().IxIX0I();
        this.mWeightOfSkeletalMuscle = bodyFatScale.Oxx0IOOO().oOoIIO0();
        this.mWeightOfSkeletalMuscleRange = bodyFatScale.Oxx0IOOO().IXO();
        this.mWeightOfWater = bodyFatScale.Oxx0IOOO().oI();
        this.mWeightOfWaterRange = bodyFatScale.Oxx0IOOO().Ix00oIoI();
        this.mWeightRange = bodyFatScale.Oxx0IOOO().O0IxXx();
        this.mWeightToControl = bodyFatScale.Oxx0IOOO().IoXIXo();
        this.mWeightWHORange = bodyFatScale.Oxx0IOOO().xxOXOOoIX();
    }

    public final void setMAgeOfBody(double d) {
        this.mAgeOfBody = d;
    }

    public final void setMAgeOfBodyRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mAgeOfBodyRange = list;
    }

    public final void setMBmi(double d) {
        this.mBmi = d;
    }

    public final void setMBmiRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBmiRange = list;
    }

    public final void setMBmiWHORange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBmiWHORange = list;
    }

    public final void setMBmr(double d) {
        this.mBmr = d;
    }

    public final void setMBmrRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBmrRange = list;
    }

    public final void setMBodyShape(double d) {
        this.mBodyShape = d;
    }

    public final void setMDesirableWeight(double d) {
        this.mDesirableWeight = d;
    }

    public final void setMFatFreeBodyWeight(double d) {
        this.mFatFreeBodyWeight = d;
    }

    public final void setMFatToControl(double d) {
        this.mFatToControl = d;
    }

    public final void setMIdealWeight(double d) {
        this.mIdealWeight = d;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsMeasure(int i) {
        this.mIsMeasure = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLevelOfVisceralFat(double d) {
        this.mLevelOfVisceralFat = d;
    }

    public final void setMLevelOfVisceralFatRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mLevelOfVisceralFatRange = list;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMMuscleToControl(double d) {
        this.mMuscleToControl = d;
    }

    public final void setMRatioOfFat(double d) {
        this.mRatioOfFat = d;
    }

    public final void setMRatioOfFatRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfFatRange = list;
    }

    public final void setMRatioOfMuscle(double d) {
        this.mRatioOfMuscle = d;
    }

    public final void setMRatioOfMuscleRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfMuscleRange = list;
    }

    public final void setMRatioOfProtein(double d) {
        this.mRatioOfProtein = d;
    }

    public final void setMRatioOfProteinLevel(int i) {
        this.mRatioOfProteinLevel = i;
    }

    public final void setMRatioOfProteinRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfProteinRange = list;
    }

    public final void setMRatioOfSkeletalMuscle(double d) {
        this.mRatioOfSkeletalMuscle = d;
    }

    public final void setMRatioOfSkeletalMuscleRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfSkeletalMuscleRange = list;
    }

    public final void setMRatioOfSubcutaneousFat(double d) {
        this.mRatioOfSubcutaneousFat = d;
    }

    public final void setMRatioOfSubcutaneousFatRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfSubcutaneousFatRange = list;
    }

    public final void setMRatioOfWater(double d) {
        this.mRatioOfWater = d;
    }

    public final void setMRatioOfWaterLevel(int i) {
        this.mRatioOfWaterLevel = i;
    }

    public final void setMRatioOfWaterRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRatioOfWaterRange = list;
    }

    public final void setMScore(double d) {
        this.mScore = d;
    }

    public final void setMStateOfNutrition(double d) {
        this.mStateOfNutrition = d;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMWeight(float f) {
        this.mWeight = f;
    }

    public final void setMWeightOfBone(double d) {
        this.mWeightOfBone = d;
    }

    public final void setMWeightOfBoneRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfBoneRange = list;
    }

    public final void setMWeightOfFat(double d) {
        this.mWeightOfFat = d;
    }

    public final void setMWeightOfFatRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfFatRange = list;
    }

    public final void setMWeightOfMuscle(double d) {
        this.mWeightOfMuscle = d;
    }

    public final void setMWeightOfMuscleRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfMuscleRange = list;
    }

    public final void setMWeightOfProtein(double d) {
        this.mWeightOfProtein = d;
    }

    public final void setMWeightOfProteinRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfProteinRange = list;
    }

    public final void setMWeightOfSkeletalMuscle(double d) {
        this.mWeightOfSkeletalMuscle = d;
    }

    public final void setMWeightOfSkeletalMuscleRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfSkeletalMuscleRange = list;
    }

    public final void setMWeightOfWater(double d) {
        this.mWeightOfWater = d;
    }

    public final void setMWeightOfWaterRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightOfWaterRange = list;
    }

    public final void setMWeightRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightRange = list;
    }

    public final void setMWeightToControl(double d) {
        this.mWeightToControl = d;
    }

    public final void setMWeightWHORange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mWeightWHORange = list;
    }

    @OOXIXo
    public String toString() {
        return "Weight(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mWeight=" + this.mWeight + ", mIsSync=" + this.mIsSync + ", mIsMeasure=" + this.mIsMeasure + ", mBmi=" + this.mBmi + ", mRatioOfFat=" + this.mRatioOfFat + ", mWeightOfMuscle=" + this.mWeightOfMuscle + ", mWeightOfFat=" + this.mWeightOfFat + ", mRatioOfProtein=" + this.mRatioOfProtein + ", mRatioOfWater=" + this.mRatioOfWater + ", mStateOfNutrition=" + this.mStateOfNutrition + ", mIdealWeight=" + this.mIdealWeight + ", mAgeOfBody=" + this.mAgeOfBody + ", mAgeOfBodyRange=" + this.mAgeOfBodyRange + ", mBmiRange=" + this.mBmiRange + ", mBmiWHORange=" + this.mBmiWHORange + ", mBmr=" + this.mBmr + ", mBmrRange=" + this.mBmrRange + ", mBodyShape=" + this.mBodyShape + ", mDesirableWeight=" + this.mDesirableWeight + ", mFatFreeBodyWeight=" + this.mFatFreeBodyWeight + ", mFatToControl=" + this.mFatToControl + ", mLevelOfVisceralFat=" + this.mLevelOfVisceralFat + ", mLevelOfVisceralFatRange=" + this.mLevelOfVisceralFatRange + ", mMuscleToControl=" + this.mMuscleToControl + ", mRatioOfFatRange=" + this.mRatioOfFatRange + ", mRatioOfMuscle=" + this.mRatioOfMuscle + ", mRatioOfMuscleRange=" + this.mRatioOfMuscleRange + ", mRatioOfProteinRange=" + this.mRatioOfProteinRange + ", mRatioOfSkeletalMuscle=" + this.mRatioOfSkeletalMuscle + ", mRatioOfSkeletalMuscleRange=" + this.mRatioOfSkeletalMuscleRange + ", mRatioOfSubcutaneousFat=" + this.mRatioOfSubcutaneousFat + ", mRatioOfSubcutaneousFatRange=" + this.mRatioOfSubcutaneousFatRange + ", mRatioOfWaterRange=" + this.mRatioOfWaterRange + ", mScore=" + this.mScore + ", mWeightOfBone=" + this.mWeightOfBone + ", mWeightOfBoneRange=" + this.mWeightOfBoneRange + ", mWeightOfFatRange=" + this.mWeightOfFatRange + ", mWeightOfMuscleRange=" + this.mWeightOfMuscleRange + ", mWeightOfProtein=" + this.mWeightOfProtein + ", mWeightOfProteinRange=" + this.mWeightOfProteinRange + ", mWeightOfSkeletalMuscle=" + this.mWeightOfSkeletalMuscle + ", mWeightOfSkeletalMuscleRange=" + this.mWeightOfSkeletalMuscleRange + ", mWeightOfWater=" + this.mWeightOfWater + ", mWeightOfWaterRange=" + this.mWeightOfWaterRange + ", mWeightRange=" + this.mWeightRange + ", mWeightToControl=" + this.mWeightToControl + ", mWeightWHORange=" + this.mWeightWHORange + ", mIsDelete=" + this.mIsDelete + ", mRatioOfProteinLevel=" + this.mRatioOfProteinLevel + ", mRatioOfWaterLevel=" + this.mRatioOfWaterLevel + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Weight(int i, long j, @OOXIXo String mLocalTime, float f, int i2, int i3, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, @OOXIXo List<Double> mAgeOfBodyRange, @OOXIXo List<Double> mBmiRange, @OOXIXo List<Double> mBmiWHORange, double d10, @OOXIXo List<Double> mBmrRange, double d11, double d12, double d13, double d14, double d15, @OOXIXo List<Double> mLevelOfVisceralFatRange, double d16, @OOXIXo List<Double> mRatioOfFatRange, double d17, @OOXIXo List<Double> mRatioOfMuscleRange, @OOXIXo List<Double> mRatioOfProteinRange, double d18, @OOXIXo List<Double> mRatioOfSkeletalMuscleRange, double d19, @OOXIXo List<Double> mRatioOfSubcutaneousFatRange, @OOXIXo List<Double> mRatioOfWaterRange, double d20, double d21, @OOXIXo List<Double> mWeightOfBoneRange, @OOXIXo List<Double> mWeightOfFatRange, @OOXIXo List<Double> mWeightOfMuscleRange, double d22, @OOXIXo List<Double> mWeightOfProteinRange, double d23, @OOXIXo List<Double> mWeightOfSkeletalMuscleRange, double d24, @OOXIXo List<Double> mWeightOfWaterRange, @OOXIXo List<Double> mWeightRange, double d25, @OOXIXo List<Double> mWeightWHORange, int i4, int i5, int i6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mAgeOfBodyRange, "mAgeOfBodyRange");
        IIX0o.x0xO0oo(mBmiRange, "mBmiRange");
        IIX0o.x0xO0oo(mBmiWHORange, "mBmiWHORange");
        IIX0o.x0xO0oo(mBmrRange, "mBmrRange");
        IIX0o.x0xO0oo(mLevelOfVisceralFatRange, "mLevelOfVisceralFatRange");
        IIX0o.x0xO0oo(mRatioOfFatRange, "mRatioOfFatRange");
        IIX0o.x0xO0oo(mRatioOfMuscleRange, "mRatioOfMuscleRange");
        IIX0o.x0xO0oo(mRatioOfProteinRange, "mRatioOfProteinRange");
        IIX0o.x0xO0oo(mRatioOfSkeletalMuscleRange, "mRatioOfSkeletalMuscleRange");
        IIX0o.x0xO0oo(mRatioOfSubcutaneousFatRange, "mRatioOfSubcutaneousFatRange");
        IIX0o.x0xO0oo(mRatioOfWaterRange, "mRatioOfWaterRange");
        IIX0o.x0xO0oo(mWeightOfBoneRange, "mWeightOfBoneRange");
        IIX0o.x0xO0oo(mWeightOfFatRange, "mWeightOfFatRange");
        IIX0o.x0xO0oo(mWeightOfMuscleRange, "mWeightOfMuscleRange");
        IIX0o.x0xO0oo(mWeightOfProteinRange, "mWeightOfProteinRange");
        IIX0o.x0xO0oo(mWeightOfSkeletalMuscleRange, "mWeightOfSkeletalMuscleRange");
        IIX0o.x0xO0oo(mWeightOfWaterRange, "mWeightOfWaterRange");
        IIX0o.x0xO0oo(mWeightRange, "mWeightRange");
        IIX0o.x0xO0oo(mWeightWHORange, "mWeightWHORange");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mWeight = f;
        this.mIsSync = i2;
        this.mIsMeasure = i3;
        this.mBmi = d;
        this.mRatioOfFat = d2;
        this.mWeightOfMuscle = d3;
        this.mWeightOfFat = d4;
        this.mRatioOfProtein = d5;
        this.mRatioOfWater = d6;
        this.mStateOfNutrition = d7;
        this.mIdealWeight = d8;
        this.mAgeOfBody = d9;
        this.mAgeOfBodyRange = mAgeOfBodyRange;
        this.mBmiRange = mBmiRange;
        this.mBmiWHORange = mBmiWHORange;
        this.mBmr = d10;
        this.mBmrRange = mBmrRange;
        this.mBodyShape = d11;
        this.mDesirableWeight = d12;
        this.mFatFreeBodyWeight = d13;
        this.mFatToControl = d14;
        this.mLevelOfVisceralFat = d15;
        this.mLevelOfVisceralFatRange = mLevelOfVisceralFatRange;
        this.mMuscleToControl = d16;
        this.mRatioOfFatRange = mRatioOfFatRange;
        this.mRatioOfMuscle = d17;
        this.mRatioOfMuscleRange = mRatioOfMuscleRange;
        this.mRatioOfProteinRange = mRatioOfProteinRange;
        this.mRatioOfSkeletalMuscle = d18;
        this.mRatioOfSkeletalMuscleRange = mRatioOfSkeletalMuscleRange;
        this.mRatioOfSubcutaneousFat = d19;
        this.mRatioOfSubcutaneousFatRange = mRatioOfSubcutaneousFatRange;
        this.mRatioOfWaterRange = mRatioOfWaterRange;
        this.mScore = d20;
        this.mWeightOfBone = d21;
        this.mWeightOfBoneRange = mWeightOfBoneRange;
        this.mWeightOfFatRange = mWeightOfFatRange;
        this.mWeightOfMuscleRange = mWeightOfMuscleRange;
        this.mWeightOfProtein = d22;
        this.mWeightOfProteinRange = mWeightOfProteinRange;
        this.mWeightOfSkeletalMuscle = d23;
        this.mWeightOfSkeletalMuscleRange = mWeightOfSkeletalMuscleRange;
        this.mWeightOfWater = d24;
        this.mWeightOfWaterRange = mWeightOfWaterRange;
        this.mWeightRange = mWeightRange;
        this.mWeightToControl = d25;
        this.mWeightWHORange = mWeightWHORange;
        this.mIsDelete = i4;
        this.mRatioOfProteinLevel = i5;
        this.mRatioOfWaterLevel = i6;
    }

    public /* synthetic */ Weight(int i, long j, String str, float f, int i2, int i3, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, List list, List list2, List list3, double d10, List list4, double d11, double d12, double d13, double d14, double d15, List list5, double d16, List list6, double d17, List list7, List list8, double d18, List list9, double d19, List list10, List list11, double d20, double d21, List list12, List list13, List list14, double d22, List list15, double d23, List list16, double d24, List list17, List list18, double d25, List list19, int i4, int i5, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0L : j, (i7 & 4) != 0 ? "" : str, (i7 & 8) != 0 ? 0.0f : f, (i7 & 16) != 0 ? 0 : i2, (i7 & 32) != 0 ? 0 : i3, (i7 & 64) != 0 ? XIXIX.OOXIXo.f3760XO : d, (i7 & 128) != 0 ? XIXIX.OOXIXo.f3760XO : d2, (i7 & 256) != 0 ? XIXIX.OOXIXo.f3760XO : d3, (i7 & 512) != 0 ? XIXIX.OOXIXo.f3760XO : d4, (i7 & 1024) != 0 ? XIXIX.OOXIXo.f3760XO : d5, (i7 & 2048) != 0 ? XIXIX.OOXIXo.f3760XO : d6, (i7 & 4096) != 0 ? XIXIX.OOXIXo.f3760XO : d7, (i7 & 8192) != 0 ? XIXIX.OOXIXo.f3760XO : d8, (i7 & 16384) != 0 ? XIXIX.OOXIXo.f3760XO : d9, (i7 & 32768) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i7 & 65536) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list2, (i7 & 131072) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list3, (i7 & 262144) != 0 ? XIXIX.OOXIXo.f3760XO : d10, (i7 & 524288) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list4, (i7 & 1048576) != 0 ? XIXIX.OOXIXo.f3760XO : d11, (i7 & 2097152) != 0 ? XIXIX.OOXIXo.f3760XO : d12, (i7 & 4194304) != 0 ? XIXIX.OOXIXo.f3760XO : d13, (i7 & 8388608) != 0 ? XIXIX.OOXIXo.f3760XO : d14, (i7 & 16777216) != 0 ? XIXIX.OOXIXo.f3760XO : d15, (i7 & 33554432) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list5, (i7 & 67108864) != 0 ? XIXIX.OOXIXo.f3760XO : d16, (i7 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list6, (i7 & 268435456) != 0 ? XIXIX.OOXIXo.f3760XO : d17, (i7 & 536870912) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list7, (i7 & 1073741824) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list8, (i7 & Integer.MIN_VALUE) != 0 ? XIXIX.OOXIXo.f3760XO : d18, (i8 & 1) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list9, (i8 & 2) != 0 ? XIXIX.OOXIXo.f3760XO : d19, (i8 & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list10, (i8 & 8) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list11, (i8 & 16) != 0 ? XIXIX.OOXIXo.f3760XO : d20, (i8 & 32) != 0 ? XIXIX.OOXIXo.f3760XO : d21, (i8 & 64) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list12, (i8 & 128) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list13, (i8 & 256) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list14, (i8 & 512) != 0 ? XIXIX.OOXIXo.f3760XO : d22, (i8 & 1024) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list15, (i8 & 2048) != 0 ? XIXIX.OOXIXo.f3760XO : d23, (i8 & 4096) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list16, (i8 & 8192) != 0 ? XIXIX.OOXIXo.f3760XO : d24, (i8 & 16384) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list17, (i8 & 32768) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list18, (i8 & 65536) != 0 ? XIXIX.OOXIXo.f3760XO : d25, (i8 & 131072) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list19, (i8 & 262144) != 0 ? 0 : i4, (i8 & 524288) != 0 ? 0 : i5, (i8 & 1048576) != 0 ? 0 : i6);
    }
}
