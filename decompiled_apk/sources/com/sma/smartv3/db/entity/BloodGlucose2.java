package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mMeasurementId"})})
/* loaded from: classes12.dex */
public final class BloodGlucose2 {

    @ColumnInfo
    private int mCompletedProgress;

    @ColumnInfo
    private final int mCurrentLevel;

    @OOXIXo
    @ColumnInfo
    private String mEndTime;

    @ColumnInfo
    private int mFasting;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @OOXIXo
    @ColumnInfo
    private final String mInsights;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private final String mLocaleInsights;

    @OOXIXo
    @ColumnInfo
    private final String mLocaleTips;

    @ColumnInfo
    private double mLowerBound;

    @OOXIXo
    @ColumnInfo
    private String mMeasurementId;

    @OOXIXo
    @ColumnInfo
    private String mModelNo;

    @OOXIXo
    @ColumnInfo
    private final String mRiskCode;

    @OOXIXo
    @ColumnInfo
    private String mStartTime;

    @ColumnInfo
    private long mTime;

    @OOXIXo
    @ColumnInfo
    private final String mTips;

    @ColumnInfo
    private double mUpperBound;

    @OOXIXo
    @ColumnInfo
    private String mUserId;

    @ColumnInfo
    private int mWithin2hrsMeal;

    public BloodGlucose2() {
        this(0, 0L, null, null, null, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, 0, 0, 0, null, null, null, null, null, 0, 0, ErrorCode.ERR_UNKNOWN, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mFasting;
    }

    public final int component11() {
        return this.mWithin2hrsMeal;
    }

    public final int component12() {
        return this.mCompletedProgress;
    }

    public final int component13() {
        return this.mCurrentLevel;
    }

    @OOXIXo
    public final String component14() {
        return this.mRiskCode;
    }

    @OOXIXo
    public final String component15() {
        return this.mInsights;
    }

    @OOXIXo
    public final String component16() {
        return this.mTips;
    }

    @OOXIXo
    public final String component17() {
        return this.mLocaleInsights;
    }

    @OOXIXo
    public final String component18() {
        return this.mLocaleTips;
    }

    public final int component19() {
        return this.mIsSync;
    }

    public final long component2() {
        return this.mTime;
    }

    public final int component20() {
        return this.mIsDelete;
    }

    @OOXIXo
    public final String component3() {
        return this.mMeasurementId;
    }

    @OOXIXo
    public final String component4() {
        return this.mUserId;
    }

    @OOXIXo
    public final String component5() {
        return this.mStartTime;
    }

    @OOXIXo
    public final String component6() {
        return this.mEndTime;
    }

    @OOXIXo
    public final String component7() {
        return this.mModelNo;
    }

    public final double component8() {
        return this.mLowerBound;
    }

    public final double component9() {
        return this.mUpperBound;
    }

    @OOXIXo
    public final BloodGlucose2 copy(int i, long j, @OOXIXo String mMeasurementId, @OOXIXo String mUserId, @OOXIXo String mStartTime, @OOXIXo String mEndTime, @OOXIXo String mModelNo, double d, double d2, int i2, int i3, int i4, int i5, @OOXIXo String mRiskCode, @OOXIXo String mInsights, @OOXIXo String mTips, @OOXIXo String mLocaleInsights, @OOXIXo String mLocaleTips, int i6, int i7) {
        IIX0o.x0xO0oo(mMeasurementId, "mMeasurementId");
        IIX0o.x0xO0oo(mUserId, "mUserId");
        IIX0o.x0xO0oo(mStartTime, "mStartTime");
        IIX0o.x0xO0oo(mEndTime, "mEndTime");
        IIX0o.x0xO0oo(mModelNo, "mModelNo");
        IIX0o.x0xO0oo(mRiskCode, "mRiskCode");
        IIX0o.x0xO0oo(mInsights, "mInsights");
        IIX0o.x0xO0oo(mTips, "mTips");
        IIX0o.x0xO0oo(mLocaleInsights, "mLocaleInsights");
        IIX0o.x0xO0oo(mLocaleTips, "mLocaleTips");
        return new BloodGlucose2(i, j, mMeasurementId, mUserId, mStartTime, mEndTime, mModelNo, d, d2, i2, i3, i4, i5, mRiskCode, mInsights, mTips, mLocaleInsights, mLocaleTips, i6, i7);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BloodGlucose2)) {
            return false;
        }
        BloodGlucose2 bloodGlucose2 = (BloodGlucose2) obj;
        return this.mId == bloodGlucose2.mId && this.mTime == bloodGlucose2.mTime && IIX0o.Oxx0IOOO(this.mMeasurementId, bloodGlucose2.mMeasurementId) && IIX0o.Oxx0IOOO(this.mUserId, bloodGlucose2.mUserId) && IIX0o.Oxx0IOOO(this.mStartTime, bloodGlucose2.mStartTime) && IIX0o.Oxx0IOOO(this.mEndTime, bloodGlucose2.mEndTime) && IIX0o.Oxx0IOOO(this.mModelNo, bloodGlucose2.mModelNo) && Double.compare(this.mLowerBound, bloodGlucose2.mLowerBound) == 0 && Double.compare(this.mUpperBound, bloodGlucose2.mUpperBound) == 0 && this.mFasting == bloodGlucose2.mFasting && this.mWithin2hrsMeal == bloodGlucose2.mWithin2hrsMeal && this.mCompletedProgress == bloodGlucose2.mCompletedProgress && this.mCurrentLevel == bloodGlucose2.mCurrentLevel && IIX0o.Oxx0IOOO(this.mRiskCode, bloodGlucose2.mRiskCode) && IIX0o.Oxx0IOOO(this.mInsights, bloodGlucose2.mInsights) && IIX0o.Oxx0IOOO(this.mTips, bloodGlucose2.mTips) && IIX0o.Oxx0IOOO(this.mLocaleInsights, bloodGlucose2.mLocaleInsights) && IIX0o.Oxx0IOOO(this.mLocaleTips, bloodGlucose2.mLocaleTips) && this.mIsSync == bloodGlucose2.mIsSync && this.mIsDelete == bloodGlucose2.mIsDelete;
    }

    public final int getMCompletedProgress() {
        return this.mCompletedProgress;
    }

    public final int getMCurrentLevel() {
        return this.mCurrentLevel;
    }

    @OOXIXo
    public final String getMEndTime() {
        return this.mEndTime;
    }

    public final int getMFasting() {
        return this.mFasting;
    }

    public final int getMId() {
        return this.mId;
    }

    @OOXIXo
    public final String getMInsights() {
        return this.mInsights;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocaleInsights() {
        return this.mLocaleInsights;
    }

    @OOXIXo
    public final String getMLocaleTips() {
        return this.mLocaleTips;
    }

    public final double getMLowerBound() {
        return this.mLowerBound;
    }

    @OOXIXo
    public final String getMMeasurementId() {
        return this.mMeasurementId;
    }

    @OOXIXo
    public final String getMModelNo() {
        return this.mModelNo;
    }

    @OOXIXo
    public final String getMRiskCode() {
        return this.mRiskCode;
    }

    @OOXIXo
    public final String getMStartTime() {
        return this.mStartTime;
    }

    public final long getMTime() {
        return this.mTime;
    }

    @OOXIXo
    public final String getMTips() {
        return this.mTips;
    }

    public final double getMUpperBound() {
        return this.mUpperBound;
    }

    @OOXIXo
    public final String getMUserId() {
        return this.mUserId;
    }

    public final int getMWithin2hrsMeal() {
        return this.mWithin2hrsMeal;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mMeasurementId.hashCode()) * 31) + this.mUserId.hashCode()) * 31) + this.mStartTime.hashCode()) * 31) + this.mEndTime.hashCode()) * 31) + this.mModelNo.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mLowerBound)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.mUpperBound)) * 31) + this.mFasting) * 31) + this.mWithin2hrsMeal) * 31) + this.mCompletedProgress) * 31) + this.mCurrentLevel) * 31) + this.mRiskCode.hashCode()) * 31) + this.mInsights.hashCode()) * 31) + this.mTips.hashCode()) * 31) + this.mLocaleInsights.hashCode()) * 31) + this.mLocaleTips.hashCode()) * 31) + this.mIsSync) * 31) + this.mIsDelete;
    }

    public final void setMCompletedProgress(int i) {
        this.mCompletedProgress = i;
    }

    public final void setMEndTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mEndTime = str;
    }

    public final void setMFasting(int i) {
        this.mFasting = i;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLowerBound(double d) {
        this.mLowerBound = d;
    }

    public final void setMMeasurementId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMeasurementId = str;
    }

    public final void setMModelNo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mModelNo = str;
    }

    public final void setMStartTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mStartTime = str;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMUpperBound(double d) {
        this.mUpperBound = d;
    }

    public final void setMUserId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mUserId = str;
    }

    public final void setMWithin2hrsMeal(int i) {
        this.mWithin2hrsMeal = i;
    }

    @OOXIXo
    public String toString() {
        return "BloodGlucose2(mId=" + this.mId + ", mTime=" + this.mTime + ", mMeasurementId=" + this.mMeasurementId + ", mUserId=" + this.mUserId + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mModelNo=" + this.mModelNo + ", mLowerBound=" + this.mLowerBound + ", mUpperBound=" + this.mUpperBound + ", mFasting=" + this.mFasting + ", mWithin2hrsMeal=" + this.mWithin2hrsMeal + ", mCompletedProgress=" + this.mCompletedProgress + ", mCurrentLevel=" + this.mCurrentLevel + ", mRiskCode=" + this.mRiskCode + ", mInsights=" + this.mInsights + ", mTips=" + this.mTips + ", mLocaleInsights=" + this.mLocaleInsights + ", mLocaleTips=" + this.mLocaleTips + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BloodGlucose2(int i, long j, @OOXIXo String mMeasurementId, @OOXIXo String mUserId, @OOXIXo String mStartTime, @OOXIXo String mEndTime, @OOXIXo String mModelNo, double d, double d2, int i2, int i3, int i4, int i5, @OOXIXo String mRiskCode, @OOXIXo String mInsights, @OOXIXo String mTips, @OOXIXo String mLocaleInsights, @OOXIXo String mLocaleTips, int i6, int i7) {
        IIX0o.x0xO0oo(mMeasurementId, "mMeasurementId");
        IIX0o.x0xO0oo(mUserId, "mUserId");
        IIX0o.x0xO0oo(mStartTime, "mStartTime");
        IIX0o.x0xO0oo(mEndTime, "mEndTime");
        IIX0o.x0xO0oo(mModelNo, "mModelNo");
        IIX0o.x0xO0oo(mRiskCode, "mRiskCode");
        IIX0o.x0xO0oo(mInsights, "mInsights");
        IIX0o.x0xO0oo(mTips, "mTips");
        IIX0o.x0xO0oo(mLocaleInsights, "mLocaleInsights");
        IIX0o.x0xO0oo(mLocaleTips, "mLocaleTips");
        this.mId = i;
        this.mTime = j;
        this.mMeasurementId = mMeasurementId;
        this.mUserId = mUserId;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mModelNo = mModelNo;
        this.mLowerBound = d;
        this.mUpperBound = d2;
        this.mFasting = i2;
        this.mWithin2hrsMeal = i3;
        this.mCompletedProgress = i4;
        this.mCurrentLevel = i5;
        this.mRiskCode = mRiskCode;
        this.mInsights = mInsights;
        this.mTips = mTips;
        this.mLocaleInsights = mLocaleInsights;
        this.mLocaleTips = mLocaleTips;
        this.mIsSync = i6;
        this.mIsDelete = i7;
    }

    public /* synthetic */ BloodGlucose2(int i, long j, String str, String str2, String str3, String str4, String str5, double d, double d2, int i2, int i3, int i4, int i5, String str6, String str7, String str8, String str9, String str10, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0L : j, (i8 & 4) != 0 ? "" : str, (i8 & 8) != 0 ? "" : str2, (i8 & 16) != 0 ? "" : str3, (i8 & 32) != 0 ? "" : str4, (i8 & 64) != 0 ? "" : str5, (i8 & 128) != 0 ? 0.0d : d, (i8 & 256) == 0 ? d2 : XIXIX.OOXIXo.f3760XO, (i8 & 512) != 0 ? 0 : i2, (i8 & 1024) != 0 ? 0 : i3, (i8 & 2048) != 0 ? 0 : i4, (i8 & 4096) != 0 ? 0 : i5, (i8 & 8192) != 0 ? "" : str6, (i8 & 16384) != 0 ? "" : str7, (i8 & 32768) != 0 ? "" : str8, (i8 & 65536) != 0 ? "" : str9, (i8 & 131072) != 0 ? "" : str10, (i8 & 262144) != 0 ? 0 : i6, (i8 & 524288) != 0 ? 0 : i7);
    }
}
