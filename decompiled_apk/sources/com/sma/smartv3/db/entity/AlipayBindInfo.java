package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleAlipayBindInfo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class AlipayBindInfo {

    @OOXIXo
    @ColumnInfo
    private String mAppVersion;

    @OOXIXo
    @ColumnInfo
    private String mBleName;

    @OOXIXo
    @ColumnInfo
    private String mFirmwareFlag;

    @OOXIXo
    @ColumnInfo
    private String mFirmwareVersion;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @OOXIXo
    @ColumnInfo
    private String mMacAddress;

    @ColumnInfo
    private int mResult;

    @ColumnInfo
    private long mTime;

    public AlipayBindInfo() {
        this(0, 0L, null, null, null, null, null, null, 0, 0, 1023, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mIsSync;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    @OOXIXo
    public final String component4() {
        return this.mBleName;
    }

    @OOXIXo
    public final String component5() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String component6() {
        return this.mMacAddress;
    }

    @OOXIXo
    public final String component7() {
        return this.mFirmwareVersion;
    }

    @OOXIXo
    public final String component8() {
        return this.mAppVersion;
    }

    public final int component9() {
        return this.mResult;
    }

    @OOXIXo
    public final AlipayBindInfo copy(int i, long j, @OOXIXo String mLocalTime, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag, @OOXIXo String mMacAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mAppVersion, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mMacAddress, "mMacAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mAppVersion, "mAppVersion");
        return new AlipayBindInfo(i, j, mLocalTime, mBleName, mFirmwareFlag, mMacAddress, mFirmwareVersion, mAppVersion, i2, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlipayBindInfo)) {
            return false;
        }
        AlipayBindInfo alipayBindInfo = (AlipayBindInfo) obj;
        return this.mId == alipayBindInfo.mId && this.mTime == alipayBindInfo.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, alipayBindInfo.mLocalTime) && IIX0o.Oxx0IOOO(this.mBleName, alipayBindInfo.mBleName) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, alipayBindInfo.mFirmwareFlag) && IIX0o.Oxx0IOOO(this.mMacAddress, alipayBindInfo.mMacAddress) && IIX0o.Oxx0IOOO(this.mFirmwareVersion, alipayBindInfo.mFirmwareVersion) && IIX0o.Oxx0IOOO(this.mAppVersion, alipayBindInfo.mAppVersion) && this.mResult == alipayBindInfo.mResult && this.mIsSync == alipayBindInfo.mIsSync;
    }

    @OOXIXo
    public final String getMAppVersion() {
        return this.mAppVersion;
    }

    @OOXIXo
    public final String getMBleName() {
        return this.mBleName;
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String getMFirmwareVersion() {
        return this.mFirmwareVersion;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    @OOXIXo
    public final String getMMacAddress() {
        return this.mMacAddress;
    }

    public final int getMResult() {
        return this.mResult;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mBleName.hashCode()) * 31) + this.mFirmwareFlag.hashCode()) * 31) + this.mMacAddress.hashCode()) * 31) + this.mFirmwareVersion.hashCode()) * 31) + this.mAppVersion.hashCode()) * 31) + this.mResult) * 31) + this.mIsSync;
    }

    public final void setMAppVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAppVersion = str;
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    public final void setMFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareFlag = str;
    }

    public final void setMFirmwareVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareVersion = str;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMMacAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mMacAddress = str;
    }

    public final void setMResult(int i) {
        this.mResult = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "AlipayBindInfo(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mBleName=" + this.mBleName + ", mFirmwareFlag=" + this.mFirmwareFlag + ", mMacAddress=" + this.mMacAddress + ", mFirmwareVersion=" + this.mFirmwareVersion + ", mAppVersion=" + this.mAppVersion + ", mResult=" + this.mResult + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AlipayBindInfo(int i, long j, @OOXIXo String mLocalTime, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag, @OOXIXo String mMacAddress, @OOXIXo String mFirmwareVersion, @OOXIXo String mAppVersion, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mMacAddress, "mMacAddress");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mAppVersion, "mAppVersion");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mBleName = mBleName;
        this.mFirmwareFlag = mFirmwareFlag;
        this.mMacAddress = mMacAddress;
        this.mFirmwareVersion = mFirmwareVersion;
        this.mAppVersion = mAppVersion;
        this.mResult = i2;
        this.mIsSync = i3;
    }

    public /* synthetic */ AlipayBindInfo(int i, long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? "" : str5, (i4 & 128) == 0 ? str6 : "", (i4 & 256) != 0 ? 0 : i2, (i4 & 512) == 0 ? i3 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlipayBindInfo(@OOXIXo BleAlipayBindInfo alipayBindInfo, long j) {
        this(0, ((alipayBindInfo.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, null, null, null, null, null, alipayBindInfo.getMResult(), 0, 765, null);
        IIX0o.x0xO0oo(alipayBindInfo, "alipayBindInfo");
    }
}
