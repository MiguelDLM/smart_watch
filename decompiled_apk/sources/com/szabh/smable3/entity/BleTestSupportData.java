package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleFactoryTest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleFactoryTest.kt\ncom/szabh/smable3/entity/BleTestSupportData\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,342:1\n222#2,4:343\n222#2,4:347\n222#2,4:351\n222#2,4:355\n*S KotlinDebug\n*F\n+ 1 BleFactoryTest.kt\ncom/szabh/smable3/entity/BleTestSupportData\n*L\n237#1:343,4\n238#1:347,4\n240#1:351,4\n244#1:355,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleTestSupportData extends BleReadable {
    private int mBatteryPower;
    private int mBioDiffValue;
    private int mBioMaxValue;

    @OOXIXo
    private String mBleName;

    @OOXIXo
    private String mFirmwareFlag;

    @OOXIXo
    private String mFirmwareVersion;
    private int mFlash;
    private int mGoMoreInfo;

    @oOoXoXO
    private BleGsensorData mGsensor;

    @OOXIXo
    private BleHardwareInfo mHardwareInfo;
    private int mHardwareInfoLength;
    private int mRSSI;
    private int mSupportBIO;
    private int mSupportBIOCheck;
    private int mSupportGeoSensor;
    private int mSupportKeyCount;
    private int mSupportMIC;
    private int mSupportSD;
    private int mSupportSpeaker;
    private int mSupportTuya;

    @OOXIXo
    private String mUIVersion;
    private int mVoltage;

    public BleTestSupportData() {
        this(0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, null, 0, 0, 0, null, 0, 0, 0, 0, 4194303, null);
    }

    public final int component1() {
        return this.mSupportKeyCount;
    }

    @OOXIXo
    public final String component10() {
        return this.mFirmwareFlag;
    }

    @OOXIXo
    public final String component11() {
        return this.mFirmwareVersion;
    }

    @OOXIXo
    public final String component12() {
        return this.mUIVersion;
    }

    public final int component13() {
        return this.mBatteryPower;
    }

    @oOoXoXO
    public final BleGsensorData component14() {
        return this.mGsensor;
    }

    public final int component15() {
        return this.mFlash;
    }

    public final int component16() {
        return this.mRSSI;
    }

    public final int component17() {
        return this.mHardwareInfoLength;
    }

    @OOXIXo
    public final BleHardwareInfo component18() {
        return this.mHardwareInfo;
    }

    public final int component19() {
        return this.mGoMoreInfo;
    }

    public final int component2() {
        return this.mSupportMIC;
    }

    public final int component20() {
        return this.mVoltage;
    }

    public final int component21() {
        return this.mBioMaxValue;
    }

    public final int component22() {
        return this.mBioDiffValue;
    }

    public final int component3() {
        return this.mSupportSpeaker;
    }

    public final int component4() {
        return this.mSupportBIO;
    }

    public final int component5() {
        return this.mSupportBIOCheck;
    }

    public final int component6() {
        return this.mSupportSD;
    }

    public final int component7() {
        return this.mSupportGeoSensor;
    }

    public final int component8() {
        return this.mSupportTuya;
    }

    @OOXIXo
    public final String component9() {
        return this.mBleName;
    }

    @OOXIXo
    public final BleTestSupportData copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag, @OOXIXo String mFirmwareVersion, @OOXIXo String mUIVersion, int i9, @oOoXoXO BleGsensorData bleGsensorData, int i10, int i11, int i12, @OOXIXo BleHardwareInfo mHardwareInfo, int i13, int i14, int i15, int i16) {
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mUIVersion, "mUIVersion");
        IIX0o.x0xO0oo(mHardwareInfo, "mHardwareInfo");
        return new BleTestSupportData(i, i2, i3, i4, i5, i6, i7, i8, mBleName, mFirmwareFlag, mFirmwareVersion, mUIVersion, i9, bleGsensorData, i10, i11, i12, mHardwareInfo, i13, i14, i15, i16);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mSupportKeyCount = readInt8();
        this.mSupportMIC = readInt8();
        this.mSupportSpeaker = readInt8();
        this.mSupportBIO = readInt8();
        this.mSupportBIOCheck = readInt8();
        this.mSupportSD = readInt8();
        this.mSupportGeoSensor = readInt8();
        this.mSupportTuya = readInt8();
        this.mBleName = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mFirmwareFlag = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        BleReadable bleReadable = (BleReadable) BleVersion.class.newInstance();
        bleReadable.setMBytes(readBytes(3));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mFirmwareVersion = ((BleVersion) bleReadable).getMVersion();
        BleReadable bleReadable2 = (BleReadable) BleVersion.class.newInstance();
        bleReadable2.setMBytes(readBytes(3));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mUIVersion = ((BleVersion) bleReadable2).getMVersion();
        this.mBatteryPower = readInt8();
        BleReadable bleReadable3 = (BleReadable) BleGsensorData.class.newInstance();
        bleReadable3.setMBytes(readBytes(7));
        bleReadable3.decode();
        IIX0o.ooOOo0oXI(bleReadable3);
        this.mGsensor = (BleGsensorData) bleReadable3;
        this.mFlash = readInt8();
        this.mRSSI = readInt8();
        char readUInt16$default = BleReadable.readUInt16$default(this, null, 1, null);
        this.mHardwareInfoLength = readUInt16$default;
        BleReadable bleReadable4 = (BleReadable) BleHardwareInfo.class.newInstance();
        bleReadable4.setMBytes(readBytes(readUInt16$default));
        bleReadable4.decode();
        IIX0o.ooOOo0oXI(bleReadable4);
        this.mHardwareInfo = (BleHardwareInfo) bleReadable4;
        this.mGoMoreInfo = readInt8();
        this.mVoltage = BleReadable.readUInt16$default(this, null, 1, null);
        this.mBioMaxValue = BleReadable.readUInt16$default(this, null, 1, null);
        this.mBioDiffValue = BleReadable.readUInt16$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleTestSupportData)) {
            return false;
        }
        BleTestSupportData bleTestSupportData = (BleTestSupportData) obj;
        return this.mSupportKeyCount == bleTestSupportData.mSupportKeyCount && this.mSupportMIC == bleTestSupportData.mSupportMIC && this.mSupportSpeaker == bleTestSupportData.mSupportSpeaker && this.mSupportBIO == bleTestSupportData.mSupportBIO && this.mSupportBIOCheck == bleTestSupportData.mSupportBIOCheck && this.mSupportSD == bleTestSupportData.mSupportSD && this.mSupportGeoSensor == bleTestSupportData.mSupportGeoSensor && this.mSupportTuya == bleTestSupportData.mSupportTuya && IIX0o.Oxx0IOOO(this.mBleName, bleTestSupportData.mBleName) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, bleTestSupportData.mFirmwareFlag) && IIX0o.Oxx0IOOO(this.mFirmwareVersion, bleTestSupportData.mFirmwareVersion) && IIX0o.Oxx0IOOO(this.mUIVersion, bleTestSupportData.mUIVersion) && this.mBatteryPower == bleTestSupportData.mBatteryPower && IIX0o.Oxx0IOOO(this.mGsensor, bleTestSupportData.mGsensor) && this.mFlash == bleTestSupportData.mFlash && this.mRSSI == bleTestSupportData.mRSSI && this.mHardwareInfoLength == bleTestSupportData.mHardwareInfoLength && IIX0o.Oxx0IOOO(this.mHardwareInfo, bleTestSupportData.mHardwareInfo) && this.mGoMoreInfo == bleTestSupportData.mGoMoreInfo && this.mVoltage == bleTestSupportData.mVoltage && this.mBioMaxValue == bleTestSupportData.mBioMaxValue && this.mBioDiffValue == bleTestSupportData.mBioDiffValue;
    }

    public final int getMBatteryPower() {
        return this.mBatteryPower;
    }

    public final int getMBioDiffValue() {
        return this.mBioDiffValue;
    }

    public final int getMBioMaxValue() {
        return this.mBioMaxValue;
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

    public final int getMFlash() {
        return this.mFlash;
    }

    public final int getMGoMoreInfo() {
        return this.mGoMoreInfo;
    }

    @oOoXoXO
    public final BleGsensorData getMGsensor() {
        return this.mGsensor;
    }

    @OOXIXo
    public final BleHardwareInfo getMHardwareInfo() {
        return this.mHardwareInfo;
    }

    public final int getMHardwareInfoLength() {
        return this.mHardwareInfoLength;
    }

    public final int getMRSSI() {
        return this.mRSSI;
    }

    public final int getMSupportBIO() {
        return this.mSupportBIO;
    }

    public final int getMSupportBIOCheck() {
        return this.mSupportBIOCheck;
    }

    public final int getMSupportGeoSensor() {
        return this.mSupportGeoSensor;
    }

    public final int getMSupportKeyCount() {
        return this.mSupportKeyCount;
    }

    public final int getMSupportMIC() {
        return this.mSupportMIC;
    }

    public final int getMSupportSD() {
        return this.mSupportSD;
    }

    public final int getMSupportSpeaker() {
        return this.mSupportSpeaker;
    }

    public final int getMSupportTuya() {
        return this.mSupportTuya;
    }

    @OOXIXo
    public final String getMUIVersion() {
        return this.mUIVersion;
    }

    public final int getMVoltage() {
        return this.mVoltage;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((this.mSupportKeyCount * 31) + this.mSupportMIC) * 31) + this.mSupportSpeaker) * 31) + this.mSupportBIO) * 31) + this.mSupportBIOCheck) * 31) + this.mSupportSD) * 31) + this.mSupportGeoSensor) * 31) + this.mSupportTuya) * 31) + this.mBleName.hashCode()) * 31) + this.mFirmwareFlag.hashCode()) * 31) + this.mFirmwareVersion.hashCode()) * 31) + this.mUIVersion.hashCode()) * 31) + this.mBatteryPower) * 31;
        BleGsensorData bleGsensorData = this.mGsensor;
        return ((((((((((((((((hashCode + (bleGsensorData == null ? 0 : bleGsensorData.hashCode())) * 31) + this.mFlash) * 31) + this.mRSSI) * 31) + this.mHardwareInfoLength) * 31) + this.mHardwareInfo.hashCode()) * 31) + this.mGoMoreInfo) * 31) + this.mVoltage) * 31) + this.mBioMaxValue) * 31) + this.mBioDiffValue;
    }

    public final void setMBatteryPower(int i) {
        this.mBatteryPower = i;
    }

    public final void setMBioDiffValue(int i) {
        this.mBioDiffValue = i;
    }

    public final void setMBioMaxValue(int i) {
        this.mBioMaxValue = i;
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

    public final void setMFlash(int i) {
        this.mFlash = i;
    }

    public final void setMGoMoreInfo(int i) {
        this.mGoMoreInfo = i;
    }

    public final void setMGsensor(@oOoXoXO BleGsensorData bleGsensorData) {
        this.mGsensor = bleGsensorData;
    }

    public final void setMHardwareInfo(@OOXIXo BleHardwareInfo bleHardwareInfo) {
        IIX0o.x0xO0oo(bleHardwareInfo, "<set-?>");
        this.mHardwareInfo = bleHardwareInfo;
    }

    public final void setMHardwareInfoLength(int i) {
        this.mHardwareInfoLength = i;
    }

    public final void setMRSSI(int i) {
        this.mRSSI = i;
    }

    public final void setMSupportBIO(int i) {
        this.mSupportBIO = i;
    }

    public final void setMSupportBIOCheck(int i) {
        this.mSupportBIOCheck = i;
    }

    public final void setMSupportGeoSensor(int i) {
        this.mSupportGeoSensor = i;
    }

    public final void setMSupportKeyCount(int i) {
        this.mSupportKeyCount = i;
    }

    public final void setMSupportMIC(int i) {
        this.mSupportMIC = i;
    }

    public final void setMSupportSD(int i) {
        this.mSupportSD = i;
    }

    public final void setMSupportSpeaker(int i) {
        this.mSupportSpeaker = i;
    }

    public final void setMSupportTuya(int i) {
        this.mSupportTuya = i;
    }

    public final void setMUIVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mUIVersion = str;
    }

    public final void setMVoltage(int i) {
        this.mVoltage = i;
    }

    @OOXIXo
    public String toString() {
        return "BleTestSupportData(mSupportKeyCount=" + this.mSupportKeyCount + ", mSupportMIC=" + this.mSupportMIC + ", mSupportSpeaker=" + this.mSupportSpeaker + ", mSupportBIO=" + this.mSupportBIO + ", mSupportBIOCheck=" + this.mSupportBIOCheck + ", mSupportSD=" + this.mSupportSD + ", mSupportGeoSensor=" + this.mSupportGeoSensor + ", mSupportTuya=" + this.mSupportTuya + ", mBleName='" + this.mBleName + "', mFirmwareFlag='" + this.mFirmwareFlag + "', mFirmwareVersion='" + this.mFirmwareVersion + "', mUIVersion='" + this.mUIVersion + "', mBatteryPower=" + this.mBatteryPower + ", GSensor --> " + this.mGsensor + ", mFlash=" + this.mFlash + ", mRSSI=" + this.mRSSI + ", mHardwareInfoLength=" + this.mHardwareInfoLength + ", mHardwareInfo=" + this.mHardwareInfo + ", mGoMoreInfo=" + this.mGoMoreInfo + ", mVoltage=" + this.mVoltage + ", mBioMaxValue=" + this.mBioMaxValue + ", mBioDiffValue=" + this.mBioDiffValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BleTestSupportData(int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, com.szabh.smable3.entity.BleGsensorData r37, int r38, int r39, int r40, com.szabh.smable3.entity.BleHardwareInfo r41, int r42, int r43, int r44, int r45, int r46, kotlin.jvm.internal.IIXOooo r47) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleTestSupportData.<init>(int, int, int, int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.szabh.smable3.entity.BleGsensorData, int, int, int, com.szabh.smable3.entity.BleHardwareInfo, int, int, int, int, int, kotlin.jvm.internal.IIXOooo):void");
    }

    public BleTestSupportData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag, @OOXIXo String mFirmwareVersion, @OOXIXo String mUIVersion, int i9, @oOoXoXO BleGsensorData bleGsensorData, int i10, int i11, int i12, @OOXIXo BleHardwareInfo mHardwareInfo, int i13, int i14, int i15, int i16) {
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mFirmwareVersion, "mFirmwareVersion");
        IIX0o.x0xO0oo(mUIVersion, "mUIVersion");
        IIX0o.x0xO0oo(mHardwareInfo, "mHardwareInfo");
        this.mSupportKeyCount = i;
        this.mSupportMIC = i2;
        this.mSupportSpeaker = i3;
        this.mSupportBIO = i4;
        this.mSupportBIOCheck = i5;
        this.mSupportSD = i6;
        this.mSupportGeoSensor = i7;
        this.mSupportTuya = i8;
        this.mBleName = mBleName;
        this.mFirmwareFlag = mFirmwareFlag;
        this.mFirmwareVersion = mFirmwareVersion;
        this.mUIVersion = mUIVersion;
        this.mBatteryPower = i9;
        this.mGsensor = bleGsensorData;
        this.mFlash = i10;
        this.mRSSI = i11;
        this.mHardwareInfoLength = i12;
        this.mHardwareInfo = mHardwareInfo;
        this.mGoMoreInfo = i13;
        this.mVoltage = i14;
        this.mBioMaxValue = i15;
        this.mBioDiffValue = i16;
    }
}
