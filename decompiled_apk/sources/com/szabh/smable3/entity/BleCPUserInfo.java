package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCPUserInfo extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int FEMALE = 0;
    public static final int ITEM_LENGTH = 24;
    public static final int MALE = 1;
    private int isCP;
    private int mAge;
    private int mBloodOxygen;
    private int mBloodOxygenSwitch;
    private int mCalorie;
    private int mDateTogether;
    private int mDistance;
    private int mDistanceSwitch;
    private int mGender;
    private int mHeartRate;
    private int mHeartRateSwitch;
    private int mPressure;
    private int mPressureSwitch;
    private int mStep;
    private int mStepSwitch;
    private int mTemperature;
    private int mTemperatureSwitch;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleCPUserInfo() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 131071, null);
    }

    public final int component1() {
        return this.isCP;
    }

    public final int component10() {
        return this.mCalorie;
    }

    public final int component11() {
        return this.mHeartRate;
    }

    public final int component12() {
        return this.mBloodOxygen;
    }

    public final int component13() {
        return this.mPressure;
    }

    public final int component14() {
        return this.mDateTogether;
    }

    public final int component15() {
        return this.mDistance;
    }

    public final int component16() {
        return this.mStep;
    }

    public final int component17() {
        return this.mTemperature;
    }

    public final int component2() {
        return this.mGender;
    }

    public final int component3() {
        return this.mAge;
    }

    public final int component4() {
        return this.mStepSwitch;
    }

    public final int component5() {
        return this.mHeartRateSwitch;
    }

    public final int component6() {
        return this.mTemperatureSwitch;
    }

    public final int component7() {
        return this.mBloodOxygenSwitch;
    }

    public final int component8() {
        return this.mPressureSwitch;
    }

    public final int component9() {
        return this.mDistanceSwitch;
    }

    @OOXIXo
    public final BleCPUserInfo copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return new BleCPUserInfo(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.isCP = readUInt8();
        this.mGender = readUInt8();
        this.mAge = readUInt8();
        this.mStepSwitch = readIntN(1);
        this.mHeartRateSwitch = readIntN(1);
        this.mTemperatureSwitch = readIntN(1);
        this.mBloodOxygenSwitch = readIntN(1);
        this.mPressureSwitch = readIntN(1);
        this.mDistanceSwitch = readIntN(1);
        readIntN(2);
        this.mCalorie = readUInt8();
        this.mHeartRate = readUInt8();
        this.mBloodOxygen = readUInt8();
        this.mPressure = readUInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDateTogether = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDistance = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStep = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTemperature = readInt16(LITTLE_ENDIAN);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.isCP);
        writeInt8(this.mGender);
        writeInt8(this.mAge);
        writeIntN(this.mStepSwitch, 1);
        writeIntN(this.mHeartRateSwitch, 1);
        writeIntN(this.mTemperatureSwitch, 1);
        writeIntN(this.mBloodOxygenSwitch, 1);
        writeIntN(this.mPressureSwitch, 1);
        writeIntN(this.mDistanceSwitch, 1);
        writeIntN(0, 2);
        writeInt8(this.mCalorie);
        writeInt8(this.mHeartRate);
        writeInt8(this.mBloodOxygen);
        writeInt8(this.mPressure);
        int i = this.mDateTogether;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i, LITTLE_ENDIAN);
        int i2 = this.mDistance;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i2, LITTLE_ENDIAN);
        int i3 = this.mStep;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i3, LITTLE_ENDIAN);
        int i4 = this.mTemperature;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i4, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCPUserInfo)) {
            return false;
        }
        BleCPUserInfo bleCPUserInfo = (BleCPUserInfo) obj;
        return this.isCP == bleCPUserInfo.isCP && this.mGender == bleCPUserInfo.mGender && this.mAge == bleCPUserInfo.mAge && this.mStepSwitch == bleCPUserInfo.mStepSwitch && this.mHeartRateSwitch == bleCPUserInfo.mHeartRateSwitch && this.mTemperatureSwitch == bleCPUserInfo.mTemperatureSwitch && this.mBloodOxygenSwitch == bleCPUserInfo.mBloodOxygenSwitch && this.mPressureSwitch == bleCPUserInfo.mPressureSwitch && this.mDistanceSwitch == bleCPUserInfo.mDistanceSwitch && this.mCalorie == bleCPUserInfo.mCalorie && this.mHeartRate == bleCPUserInfo.mHeartRate && this.mBloodOxygen == bleCPUserInfo.mBloodOxygen && this.mPressure == bleCPUserInfo.mPressure && this.mDateTogether == bleCPUserInfo.mDateTogether && this.mDistance == bleCPUserInfo.mDistance && this.mStep == bleCPUserInfo.mStep && this.mTemperature == bleCPUserInfo.mTemperature;
    }

    public final int getMAge() {
        return this.mAge;
    }

    public final int getMBloodOxygen() {
        return this.mBloodOxygen;
    }

    public final int getMBloodOxygenSwitch() {
        return this.mBloodOxygenSwitch;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMDateTogether() {
        return this.mDateTogether;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final int getMDistanceSwitch() {
        return this.mDistanceSwitch;
    }

    public final int getMGender() {
        return this.mGender;
    }

    public final int getMHeartRate() {
        return this.mHeartRate;
    }

    public final int getMHeartRateSwitch() {
        return this.mHeartRateSwitch;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 24;
    }

    public final int getMPressure() {
        return this.mPressure;
    }

    public final int getMPressureSwitch() {
        return this.mPressureSwitch;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final int getMStepSwitch() {
        return this.mStepSwitch;
    }

    public final int getMTemperature() {
        return this.mTemperature;
    }

    public final int getMTemperatureSwitch() {
        return this.mTemperatureSwitch;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.isCP * 31) + this.mGender) * 31) + this.mAge) * 31) + this.mStepSwitch) * 31) + this.mHeartRateSwitch) * 31) + this.mTemperatureSwitch) * 31) + this.mBloodOxygenSwitch) * 31) + this.mPressureSwitch) * 31) + this.mDistanceSwitch) * 31) + this.mCalorie) * 31) + this.mHeartRate) * 31) + this.mBloodOxygen) * 31) + this.mPressure) * 31) + this.mDateTogether) * 31) + this.mDistance) * 31) + this.mStep) * 31) + this.mTemperature;
    }

    public final int isCP() {
        return this.isCP;
    }

    public final void setCP(int i) {
        this.isCP = i;
    }

    public final void setMAge(int i) {
        this.mAge = i;
    }

    public final void setMBloodOxygen(int i) {
        this.mBloodOxygen = i;
    }

    public final void setMBloodOxygenSwitch(int i) {
        this.mBloodOxygenSwitch = i;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMDateTogether(int i) {
        this.mDateTogether = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMDistanceSwitch(int i) {
        this.mDistanceSwitch = i;
    }

    public final void setMGender(int i) {
        this.mGender = i;
    }

    public final void setMHeartRate(int i) {
        this.mHeartRate = i;
    }

    public final void setMHeartRateSwitch(int i) {
        this.mHeartRateSwitch = i;
    }

    public final void setMPressure(int i) {
        this.mPressure = i;
    }

    public final void setMPressureSwitch(int i) {
        this.mPressureSwitch = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMStepSwitch(int i) {
        this.mStepSwitch = i;
    }

    public final void setMTemperature(int i) {
        this.mTemperature = i;
    }

    public final void setMTemperatureSwitch(int i) {
        this.mTemperatureSwitch = i;
    }

    @OOXIXo
    public String toString() {
        return "BleCPUserInfo(isCP=" + this.isCP + ", mGender=" + this.mGender + ", mAge=" + this.mAge + ", mStepSwitch=" + this.mStepSwitch + ", mHeartRateSwitch=" + this.mHeartRateSwitch + ", mTemperatureSwitch=" + this.mTemperatureSwitch + ", mBloodOxygenSwitch=" + this.mBloodOxygenSwitch + ", mPressureSwitch=" + this.mPressureSwitch + ", mDistanceSwitch=" + this.mDistanceSwitch + ", mCalorie=" + this.mCalorie + ", mHeartRate=" + this.mHeartRate + ", mBloodOxygen=" + this.mBloodOxygen + ", mPressure=" + this.mPressure + ", mDateTogether=" + this.mDateTogether + ", mDistance=" + this.mDistance + ", mStep=" + this.mStep + ", mTemperature=" + this.mTemperature + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCPUserInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, IIXOooo iIXOooo) {
        this((i18 & 1) != 0 ? 0 : i, (i18 & 2) != 0 ? 0 : i2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i4, (i18 & 16) != 0 ? 0 : i5, (i18 & 32) != 0 ? 0 : i6, (i18 & 64) != 0 ? 0 : i7, (i18 & 128) != 0 ? 0 : i8, (i18 & 256) != 0 ? 0 : i9, (i18 & 512) != 0 ? 0 : i10, (i18 & 1024) != 0 ? 0 : i11, (i18 & 2048) != 0 ? 0 : i12, (i18 & 4096) != 0 ? 0 : i13, (i18 & 8192) != 0 ? 0 : i14, (i18 & 16384) != 0 ? 0 : i15, (i18 & 32768) != 0 ? 0 : i16, (i18 & 65536) != 0 ? 0 : i17);
    }

    public BleCPUserInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.isCP = i;
        this.mGender = i2;
        this.mAge = i3;
        this.mStepSwitch = i4;
        this.mHeartRateSwitch = i5;
        this.mTemperatureSwitch = i6;
        this.mBloodOxygenSwitch = i7;
        this.mPressureSwitch = i8;
        this.mDistanceSwitch = i9;
        this.mCalorie = i10;
        this.mHeartRate = i11;
        this.mBloodOxygen = i12;
        this.mPressure = i13;
        this.mDateTogether = i14;
        this.mDistance = i15;
        this.mStep = i16;
        this.mTemperature = i17;
    }
}
