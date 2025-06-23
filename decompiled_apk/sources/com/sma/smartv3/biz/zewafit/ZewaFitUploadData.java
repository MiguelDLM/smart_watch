package com.sma.smartv3.biz.zewafit;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ZewaFitUploadData {

    @OOXIXo
    private String b;

    @OOXIXo
    private String di;

    @OOXIXo
    private String dm;

    @OOXIXo
    private String mAwakeSleepTime;

    @OOXIXo
    private String mCalorie;

    @OOXIXo
    private String mDate;

    @OOXIXo
    private String mDeepSleepTime;

    @OOXIXo
    private String mDistance;

    @OOXIXo
    private String mLatestBloodOxygen;

    @OOXIXo
    private String mLatestHeartRate;

    @OOXIXo
    private String mLatestHrv;

    @OOXIXo
    private String mLatestStress;

    @OOXIXo
    private String mLatestTemperature;

    @OOXIXo
    private String mLightSleepTime;

    @OOXIXo
    private String mMaxBloodOxygen;

    @OOXIXo
    private String mMaxHeartRate;

    @OOXIXo
    private String mMaxHrv;

    @OOXIXo
    private String mMaxStress;

    @OOXIXo
    private String mMaxTemperature;

    @OOXIXo
    private String mMinBloodOxygen;

    @OOXIXo
    private String mMinHeartRate;

    @OOXIXo
    private String mMinHrv;

    @OOXIXo
    private String mMinStress;

    @OOXIXo
    private String mMinTemperature;

    @OOXIXo
    private String mStep;

    @OOXIXo
    private String mTime;

    public ZewaFitUploadData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
    }

    @OOXIXo
    public final String component1() {
        return this.b;
    }

    @OOXIXo
    public final String component10() {
        return this.mLatestHeartRate;
    }

    @OOXIXo
    public final String component11() {
        return this.mMinHeartRate;
    }

    @OOXIXo
    public final String component12() {
        return this.mDeepSleepTime;
    }

    @OOXIXo
    public final String component13() {
        return this.mLightSleepTime;
    }

    @OOXIXo
    public final String component14() {
        return this.mAwakeSleepTime;
    }

    @OOXIXo
    public final String component15() {
        return this.mMaxTemperature;
    }

    @OOXIXo
    public final String component16() {
        return this.mLatestTemperature;
    }

    @OOXIXo
    public final String component17() {
        return this.mMinTemperature;
    }

    @OOXIXo
    public final String component18() {
        return this.mMaxBloodOxygen;
    }

    @OOXIXo
    public final String component19() {
        return this.mLatestBloodOxygen;
    }

    @OOXIXo
    public final String component2() {
        return this.dm;
    }

    @OOXIXo
    public final String component20() {
        return this.mMinBloodOxygen;
    }

    @OOXIXo
    public final String component21() {
        return this.mMaxHrv;
    }

    @OOXIXo
    public final String component22() {
        return this.mLatestHrv;
    }

    @OOXIXo
    public final String component23() {
        return this.mMinHrv;
    }

    @OOXIXo
    public final String component24() {
        return this.mMaxStress;
    }

    @OOXIXo
    public final String component25() {
        return this.mLatestStress;
    }

    @OOXIXo
    public final String component26() {
        return this.mMinStress;
    }

    @OOXIXo
    public final String component3() {
        return this.di;
    }

    @OOXIXo
    public final String component4() {
        return this.mTime;
    }

    @OOXIXo
    public final String component5() {
        return this.mDate;
    }

    @OOXIXo
    public final String component6() {
        return this.mStep;
    }

    @OOXIXo
    public final String component7() {
        return this.mCalorie;
    }

    @OOXIXo
    public final String component8() {
        return this.mDistance;
    }

    @OOXIXo
    public final String component9() {
        return this.mMaxHeartRate;
    }

    @OOXIXo
    public final ZewaFitUploadData copy(@OOXIXo String b, @OOXIXo String dm, @OOXIXo String di, @OOXIXo String mTime, @OOXIXo String mDate, @OOXIXo String mStep, @OOXIXo String mCalorie, @OOXIXo String mDistance, @OOXIXo String mMaxHeartRate, @OOXIXo String mLatestHeartRate, @OOXIXo String mMinHeartRate, @OOXIXo String mDeepSleepTime, @OOXIXo String mLightSleepTime, @OOXIXo String mAwakeSleepTime, @OOXIXo String mMaxTemperature, @OOXIXo String mLatestTemperature, @OOXIXo String mMinTemperature, @OOXIXo String mMaxBloodOxygen, @OOXIXo String mLatestBloodOxygen, @OOXIXo String mMinBloodOxygen, @OOXIXo String mMaxHrv, @OOXIXo String mLatestHrv, @OOXIXo String mMinHrv, @OOXIXo String mMaxStress, @OOXIXo String mLatestStress, @OOXIXo String mMinStress) {
        IIX0o.x0xO0oo(b, "b");
        IIX0o.x0xO0oo(dm, "dm");
        IIX0o.x0xO0oo(di, "di");
        IIX0o.x0xO0oo(mTime, "mTime");
        IIX0o.x0xO0oo(mDate, "mDate");
        IIX0o.x0xO0oo(mStep, "mStep");
        IIX0o.x0xO0oo(mCalorie, "mCalorie");
        IIX0o.x0xO0oo(mDistance, "mDistance");
        IIX0o.x0xO0oo(mMaxHeartRate, "mMaxHeartRate");
        IIX0o.x0xO0oo(mLatestHeartRate, "mLatestHeartRate");
        IIX0o.x0xO0oo(mMinHeartRate, "mMinHeartRate");
        IIX0o.x0xO0oo(mDeepSleepTime, "mDeepSleepTime");
        IIX0o.x0xO0oo(mLightSleepTime, "mLightSleepTime");
        IIX0o.x0xO0oo(mAwakeSleepTime, "mAwakeSleepTime");
        IIX0o.x0xO0oo(mMaxTemperature, "mMaxTemperature");
        IIX0o.x0xO0oo(mLatestTemperature, "mLatestTemperature");
        IIX0o.x0xO0oo(mMinTemperature, "mMinTemperature");
        IIX0o.x0xO0oo(mMaxBloodOxygen, "mMaxBloodOxygen");
        IIX0o.x0xO0oo(mLatestBloodOxygen, "mLatestBloodOxygen");
        IIX0o.x0xO0oo(mMinBloodOxygen, "mMinBloodOxygen");
        IIX0o.x0xO0oo(mMaxHrv, "mMaxHrv");
        IIX0o.x0xO0oo(mLatestHrv, "mLatestHrv");
        IIX0o.x0xO0oo(mMinHrv, "mMinHrv");
        IIX0o.x0xO0oo(mMaxStress, "mMaxStress");
        IIX0o.x0xO0oo(mLatestStress, "mLatestStress");
        IIX0o.x0xO0oo(mMinStress, "mMinStress");
        return new ZewaFitUploadData(b, dm, di, mTime, mDate, mStep, mCalorie, mDistance, mMaxHeartRate, mLatestHeartRate, mMinHeartRate, mDeepSleepTime, mLightSleepTime, mAwakeSleepTime, mMaxTemperature, mLatestTemperature, mMinTemperature, mMaxBloodOxygen, mLatestBloodOxygen, mMinBloodOxygen, mMaxHrv, mLatestHrv, mMinHrv, mMaxStress, mLatestStress, mMinStress);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZewaFitUploadData)) {
            return false;
        }
        ZewaFitUploadData zewaFitUploadData = (ZewaFitUploadData) obj;
        return IIX0o.Oxx0IOOO(this.b, zewaFitUploadData.b) && IIX0o.Oxx0IOOO(this.dm, zewaFitUploadData.dm) && IIX0o.Oxx0IOOO(this.di, zewaFitUploadData.di) && IIX0o.Oxx0IOOO(this.mTime, zewaFitUploadData.mTime) && IIX0o.Oxx0IOOO(this.mDate, zewaFitUploadData.mDate) && IIX0o.Oxx0IOOO(this.mStep, zewaFitUploadData.mStep) && IIX0o.Oxx0IOOO(this.mCalorie, zewaFitUploadData.mCalorie) && IIX0o.Oxx0IOOO(this.mDistance, zewaFitUploadData.mDistance) && IIX0o.Oxx0IOOO(this.mMaxHeartRate, zewaFitUploadData.mMaxHeartRate) && IIX0o.Oxx0IOOO(this.mLatestHeartRate, zewaFitUploadData.mLatestHeartRate) && IIX0o.Oxx0IOOO(this.mMinHeartRate, zewaFitUploadData.mMinHeartRate) && IIX0o.Oxx0IOOO(this.mDeepSleepTime, zewaFitUploadData.mDeepSleepTime) && IIX0o.Oxx0IOOO(this.mLightSleepTime, zewaFitUploadData.mLightSleepTime) && IIX0o.Oxx0IOOO(this.mAwakeSleepTime, zewaFitUploadData.mAwakeSleepTime) && IIX0o.Oxx0IOOO(this.mMaxTemperature, zewaFitUploadData.mMaxTemperature) && IIX0o.Oxx0IOOO(this.mLatestTemperature, zewaFitUploadData.mLatestTemperature) && IIX0o.Oxx0IOOO(this.mMinTemperature, zewaFitUploadData.mMinTemperature) && IIX0o.Oxx0IOOO(this.mMaxBloodOxygen, zewaFitUploadData.mMaxBloodOxygen) && IIX0o.Oxx0IOOO(this.mLatestBloodOxygen, zewaFitUploadData.mLatestBloodOxygen) && IIX0o.Oxx0IOOO(this.mMinBloodOxygen, zewaFitUploadData.mMinBloodOxygen) && IIX0o.Oxx0IOOO(this.mMaxHrv, zewaFitUploadData.mMaxHrv) && IIX0o.Oxx0IOOO(this.mLatestHrv, zewaFitUploadData.mLatestHrv) && IIX0o.Oxx0IOOO(this.mMinHrv, zewaFitUploadData.mMinHrv) && IIX0o.Oxx0IOOO(this.mMaxStress, zewaFitUploadData.mMaxStress) && IIX0o.Oxx0IOOO(this.mLatestStress, zewaFitUploadData.mLatestStress) && IIX0o.Oxx0IOOO(this.mMinStress, zewaFitUploadData.mMinStress);
    }

    @OOXIXo
    public final String getB() {
        return this.b;
    }

    @OOXIXo
    public final String getDi() {
        return this.di;
    }

    @OOXIXo
    public final String getDm() {
        return this.dm;
    }

    @OOXIXo
    public final String getMAwakeSleepTime() {
        return this.mAwakeSleepTime;
    }

    @OOXIXo
    public final String getMCalorie() {
        return this.mCalorie;
    }

    @OOXIXo
    public final String getMDate() {
        return this.mDate;
    }

    @OOXIXo
    public final String getMDeepSleepTime() {
        return this.mDeepSleepTime;
    }

    @OOXIXo
    public final String getMDistance() {
        return this.mDistance;
    }

    @OOXIXo
    public final String getMLatestBloodOxygen() {
        return this.mLatestBloodOxygen;
    }

    @OOXIXo
    public final String getMLatestHeartRate() {
        return this.mLatestHeartRate;
    }

    @OOXIXo
    public final String getMLatestHrv() {
        return this.mLatestHrv;
    }

    @OOXIXo
    public final String getMLatestStress() {
        return this.mLatestStress;
    }

    @OOXIXo
    public final String getMLatestTemperature() {
        return this.mLatestTemperature;
    }

    @OOXIXo
    public final String getMLightSleepTime() {
        return this.mLightSleepTime;
    }

    @OOXIXo
    public final String getMMaxBloodOxygen() {
        return this.mMaxBloodOxygen;
    }

    @OOXIXo
    public final String getMMaxHeartRate() {
        return this.mMaxHeartRate;
    }

    @OOXIXo
    public final String getMMaxHrv() {
        return this.mMaxHrv;
    }

    @OOXIXo
    public final String getMMaxStress() {
        return this.mMaxStress;
    }

    @OOXIXo
    public final String getMMaxTemperature() {
        return this.mMaxTemperature;
    }

    @OOXIXo
    public final String getMMinBloodOxygen() {
        return this.mMinBloodOxygen;
    }

    @OOXIXo
    public final String getMMinHeartRate() {
        return this.mMinHeartRate;
    }

    @OOXIXo
    public final String getMMinHrv() {
        return this.mMinHrv;
    }

    @OOXIXo
    public final String getMMinStress() {
        return this.mMinStress;
    }

    @OOXIXo
    public final String getMMinTemperature() {
        return this.mMinTemperature;
    }

    @OOXIXo
    public final String getMStep() {
        return this.mStep;
    }

    @OOXIXo
    public final String getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((this.b.hashCode() * 31) + this.dm.hashCode()) * 31) + this.di.hashCode()) * 31) + this.mTime.hashCode()) * 31) + this.mDate.hashCode()) * 31) + this.mStep.hashCode()) * 31) + this.mCalorie.hashCode()) * 31) + this.mDistance.hashCode()) * 31) + this.mMaxHeartRate.hashCode()) * 31) + this.mLatestHeartRate.hashCode()) * 31) + this.mMinHeartRate.hashCode()) * 31) + this.mDeepSleepTime.hashCode()) * 31) + this.mLightSleepTime.hashCode()) * 31) + this.mAwakeSleepTime.hashCode()) * 31) + this.mMaxTemperature.hashCode()) * 31) + this.mLatestTemperature.hashCode()) * 31) + this.mMinTemperature.hashCode()) * 31) + this.mMaxBloodOxygen.hashCode()) * 31) + this.mLatestBloodOxygen.hashCode()) * 31) + this.mMinBloodOxygen.hashCode()) * 31) + this.mMaxHrv.hashCode()) * 31) + this.mLatestHrv.hashCode()) * 31) + this.mMinHrv.hashCode()) * 31) + this.mMaxStress.hashCode()) * 31) + this.mLatestStress.hashCode()) * 31) + this.mMinStress.hashCode();
    }

    public final void setB(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.b = str;
    }

    public final void setDi(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.di = str;
    }

    public final void setDm(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dm = str;
    }

    public final void setMAwakeSleepTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAwakeSleepTime = str;
    }

    public final void setMCalorie(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mCalorie = str;
    }

    public final void setMDate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mDate = str;
    }

    public final void setMDeepSleepTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mDeepSleepTime = str;
    }

    public final void setMDistance(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mDistance = str;
    }

    public final void setMLatestBloodOxygen(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLatestBloodOxygen = str;
    }

    public final void setMLatestHeartRate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLatestHeartRate = str;
    }

    public final void setMLatestHrv(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLatestHrv = str;
    }

    public final void setMLatestStress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLatestStress = str;
    }

    public final void setMLatestTemperature(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLatestTemperature = str;
    }

    public final void setMLightSleepTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLightSleepTime = str;
    }

    public final void setMMaxBloodOxygen(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMaxBloodOxygen = str;
    }

    public final void setMMaxHeartRate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMaxHeartRate = str;
    }

    public final void setMMaxHrv(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMaxHrv = str;
    }

    public final void setMMaxStress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMaxStress = str;
    }

    public final void setMMaxTemperature(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMaxTemperature = str;
    }

    public final void setMMinBloodOxygen(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMinBloodOxygen = str;
    }

    public final void setMMinHeartRate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMinHeartRate = str;
    }

    public final void setMMinHrv(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMinHrv = str;
    }

    public final void setMMinStress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMinStress = str;
    }

    public final void setMMinTemperature(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMinTemperature = str;
    }

    public final void setMStep(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mStep = str;
    }

    public final void setMTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTime = str;
    }

    @OOXIXo
    public String toString() {
        return "ZewaFitUploadData(b=" + this.b + ", dm=" + this.dm + ", di=" + this.di + ", mTime=" + this.mTime + ", mDate=" + this.mDate + ", mStep=" + this.mStep + ", mCalorie=" + this.mCalorie + ", mDistance=" + this.mDistance + ", mMaxHeartRate=" + this.mMaxHeartRate + ", mLatestHeartRate=" + this.mLatestHeartRate + ", mMinHeartRate=" + this.mMinHeartRate + ", mDeepSleepTime=" + this.mDeepSleepTime + ", mLightSleepTime=" + this.mLightSleepTime + ", mAwakeSleepTime=" + this.mAwakeSleepTime + ", mMaxTemperature=" + this.mMaxTemperature + ", mLatestTemperature=" + this.mLatestTemperature + ", mMinTemperature=" + this.mMinTemperature + ", mMaxBloodOxygen=" + this.mMaxBloodOxygen + ", mLatestBloodOxygen=" + this.mLatestBloodOxygen + ", mMinBloodOxygen=" + this.mMinBloodOxygen + ", mMaxHrv=" + this.mMaxHrv + ", mLatestHrv=" + this.mLatestHrv + ", mMinHrv=" + this.mMinHrv + ", mMaxStress=" + this.mMaxStress + ", mLatestStress=" + this.mLatestStress + ", mMinStress=" + this.mMinStress + HexStringBuilder.COMMENT_END_CHAR;
    }

    public ZewaFitUploadData(@OOXIXo String b, @OOXIXo String dm, @OOXIXo String di, @OOXIXo String mTime, @OOXIXo String mDate, @OOXIXo String mStep, @OOXIXo String mCalorie, @OOXIXo String mDistance, @OOXIXo String mMaxHeartRate, @OOXIXo String mLatestHeartRate, @OOXIXo String mMinHeartRate, @OOXIXo String mDeepSleepTime, @OOXIXo String mLightSleepTime, @OOXIXo String mAwakeSleepTime, @OOXIXo String mMaxTemperature, @OOXIXo String mLatestTemperature, @OOXIXo String mMinTemperature, @OOXIXo String mMaxBloodOxygen, @OOXIXo String mLatestBloodOxygen, @OOXIXo String mMinBloodOxygen, @OOXIXo String mMaxHrv, @OOXIXo String mLatestHrv, @OOXIXo String mMinHrv, @OOXIXo String mMaxStress, @OOXIXo String mLatestStress, @OOXIXo String mMinStress) {
        IIX0o.x0xO0oo(b, "b");
        IIX0o.x0xO0oo(dm, "dm");
        IIX0o.x0xO0oo(di, "di");
        IIX0o.x0xO0oo(mTime, "mTime");
        IIX0o.x0xO0oo(mDate, "mDate");
        IIX0o.x0xO0oo(mStep, "mStep");
        IIX0o.x0xO0oo(mCalorie, "mCalorie");
        IIX0o.x0xO0oo(mDistance, "mDistance");
        IIX0o.x0xO0oo(mMaxHeartRate, "mMaxHeartRate");
        IIX0o.x0xO0oo(mLatestHeartRate, "mLatestHeartRate");
        IIX0o.x0xO0oo(mMinHeartRate, "mMinHeartRate");
        IIX0o.x0xO0oo(mDeepSleepTime, "mDeepSleepTime");
        IIX0o.x0xO0oo(mLightSleepTime, "mLightSleepTime");
        IIX0o.x0xO0oo(mAwakeSleepTime, "mAwakeSleepTime");
        IIX0o.x0xO0oo(mMaxTemperature, "mMaxTemperature");
        IIX0o.x0xO0oo(mLatestTemperature, "mLatestTemperature");
        IIX0o.x0xO0oo(mMinTemperature, "mMinTemperature");
        IIX0o.x0xO0oo(mMaxBloodOxygen, "mMaxBloodOxygen");
        IIX0o.x0xO0oo(mLatestBloodOxygen, "mLatestBloodOxygen");
        IIX0o.x0xO0oo(mMinBloodOxygen, "mMinBloodOxygen");
        IIX0o.x0xO0oo(mMaxHrv, "mMaxHrv");
        IIX0o.x0xO0oo(mLatestHrv, "mLatestHrv");
        IIX0o.x0xO0oo(mMinHrv, "mMinHrv");
        IIX0o.x0xO0oo(mMaxStress, "mMaxStress");
        IIX0o.x0xO0oo(mLatestStress, "mLatestStress");
        IIX0o.x0xO0oo(mMinStress, "mMinStress");
        this.b = b;
        this.dm = dm;
        this.di = di;
        this.mTime = mTime;
        this.mDate = mDate;
        this.mStep = mStep;
        this.mCalorie = mCalorie;
        this.mDistance = mDistance;
        this.mMaxHeartRate = mMaxHeartRate;
        this.mLatestHeartRate = mLatestHeartRate;
        this.mMinHeartRate = mMinHeartRate;
        this.mDeepSleepTime = mDeepSleepTime;
        this.mLightSleepTime = mLightSleepTime;
        this.mAwakeSleepTime = mAwakeSleepTime;
        this.mMaxTemperature = mMaxTemperature;
        this.mLatestTemperature = mLatestTemperature;
        this.mMinTemperature = mMinTemperature;
        this.mMaxBloodOxygen = mMaxBloodOxygen;
        this.mLatestBloodOxygen = mLatestBloodOxygen;
        this.mMinBloodOxygen = mMinBloodOxygen;
        this.mMaxHrv = mMaxHrv;
        this.mLatestHrv = mLatestHrv;
        this.mMinHrv = mMinHrv;
        this.mMaxStress = mMaxStress;
        this.mLatestStress = mLatestStress;
        this.mMinStress = mMinStress;
    }

    public /* synthetic */ ZewaFitUploadData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? "0" : str6, (i & 64) != 0 ? "0" : str7, (i & 128) != 0 ? "0" : str8, (i & 256) != 0 ? "0" : str9, (i & 512) != 0 ? "0" : str10, (i & 1024) != 0 ? "0" : str11, (i & 2048) != 0 ? "0" : str12, (i & 4096) != 0 ? "0" : str13, (i & 8192) != 0 ? "0" : str14, (i & 16384) != 0 ? "0" : str15, (i & 32768) != 0 ? "0" : str16, (i & 65536) != 0 ? "0" : str17, (i & 131072) != 0 ? "0" : str18, (i & 262144) != 0 ? "0" : str19, (i & 524288) != 0 ? "0" : str20, (i & 1048576) != 0 ? "0" : str21, (i & 2097152) != 0 ? "0" : str22, (i & 4194304) != 0 ? "0" : str23, (i & 8388608) != 0 ? "0" : str24, (i & 16777216) != 0 ? "0" : str25, (i & 33554432) != 0 ? "0" : str26);
    }
}
