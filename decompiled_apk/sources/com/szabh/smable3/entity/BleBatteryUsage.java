package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleBatteryUsage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleBatteryUsage.kt\ncom/szabh/smable3/entity/BleBatteryUsage\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,66:1\n222#2,4:67\n222#2,4:71\n222#2,4:75\n*S KotlinDebug\n*F\n+ 1 BleBatteryUsage.kt\ncom/szabh/smable3/entity/BleBatteryUsage\n*L\n57#1:67,4\n58#1:71,4\n59#1:75,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleBatteryUsage extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 52;
    private int mIdleTime;

    @OOXIXo
    private BleVoltageRecord mLastBoot;

    @OOXIXo
    private BleVoltageRecord mLastShutdown;

    @OOXIXo
    private BleVoltageRecord mLastVoltage;
    private int mLcdTime;
    private int mSpkTime;
    private int mSportTime;
    private int mTalkTime;
    private int mTotalTime;
    private int mVibratorTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBatteryUsage() {
        this(0, 0, 0, 0, 0, 0, 0, null, null, null, 1023, null);
    }

    public final int component1() {
        return this.mTotalTime;
    }

    @OOXIXo
    public final BleVoltageRecord component10() {
        return this.mLastVoltage;
    }

    public final int component2() {
        return this.mLcdTime;
    }

    public final int component3() {
        return this.mTalkTime;
    }

    public final int component4() {
        return this.mSpkTime;
    }

    public final int component5() {
        return this.mSportTime;
    }

    public final int component6() {
        return this.mVibratorTime;
    }

    public final int component7() {
        return this.mIdleTime;
    }

    @OOXIXo
    public final BleVoltageRecord component8() {
        return this.mLastBoot;
    }

    @OOXIXo
    public final BleVoltageRecord component9() {
        return this.mLastShutdown;
    }

    @OOXIXo
    public final BleBatteryUsage copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo BleVoltageRecord mLastBoot, @OOXIXo BleVoltageRecord mLastShutdown, @OOXIXo BleVoltageRecord mLastVoltage) {
        IIX0o.x0xO0oo(mLastBoot, "mLastBoot");
        IIX0o.x0xO0oo(mLastShutdown, "mLastShutdown");
        IIX0o.x0xO0oo(mLastVoltage, "mLastVoltage");
        return new BleBatteryUsage(i, i2, i3, i4, i5, i6, i7, mLastBoot, mLastShutdown, mLastVoltage);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTotalTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLcdTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTalkTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mSpkTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mSportTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mVibratorTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mIdleTime = readInt32(LITTLE_ENDIAN);
        BleReadable bleReadable = (BleReadable) BleVoltageRecord.class.newInstance();
        bleReadable.setMBytes(readBytes(8));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mLastBoot = (BleVoltageRecord) bleReadable;
        BleReadable bleReadable2 = (BleReadable) BleVoltageRecord.class.newInstance();
        bleReadable2.setMBytes(readBytes(8));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mLastShutdown = (BleVoltageRecord) bleReadable2;
        BleReadable bleReadable3 = (BleReadable) BleVoltageRecord.class.newInstance();
        bleReadable3.setMBytes(readBytes(8));
        bleReadable3.decode();
        IIX0o.ooOOo0oXI(bleReadable3);
        this.mLastVoltage = (BleVoltageRecord) bleReadable3;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBatteryUsage)) {
            return false;
        }
        BleBatteryUsage bleBatteryUsage = (BleBatteryUsage) obj;
        return this.mTotalTime == bleBatteryUsage.mTotalTime && this.mLcdTime == bleBatteryUsage.mLcdTime && this.mTalkTime == bleBatteryUsage.mTalkTime && this.mSpkTime == bleBatteryUsage.mSpkTime && this.mSportTime == bleBatteryUsage.mSportTime && this.mVibratorTime == bleBatteryUsage.mVibratorTime && this.mIdleTime == bleBatteryUsage.mIdleTime && IIX0o.Oxx0IOOO(this.mLastBoot, bleBatteryUsage.mLastBoot) && IIX0o.Oxx0IOOO(this.mLastShutdown, bleBatteryUsage.mLastShutdown) && IIX0o.Oxx0IOOO(this.mLastVoltage, bleBatteryUsage.mLastVoltage);
    }

    public final int getMIdleTime() {
        return this.mIdleTime;
    }

    @OOXIXo
    public final BleVoltageRecord getMLastBoot() {
        return this.mLastBoot;
    }

    @OOXIXo
    public final BleVoltageRecord getMLastShutdown() {
        return this.mLastShutdown;
    }

    @OOXIXo
    public final BleVoltageRecord getMLastVoltage() {
        return this.mLastVoltage;
    }

    public final int getMLcdTime() {
        return this.mLcdTime;
    }

    public final int getMSpkTime() {
        return this.mSpkTime;
    }

    public final int getMSportTime() {
        return this.mSportTime;
    }

    public final int getMTalkTime() {
        return this.mTalkTime;
    }

    public final int getMTotalTime() {
        return this.mTotalTime;
    }

    public final int getMVibratorTime() {
        return this.mVibratorTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.mTotalTime * 31) + this.mLcdTime) * 31) + this.mTalkTime) * 31) + this.mSpkTime) * 31) + this.mSportTime) * 31) + this.mVibratorTime) * 31) + this.mIdleTime) * 31) + this.mLastBoot.hashCode()) * 31) + this.mLastShutdown.hashCode()) * 31) + this.mLastVoltage.hashCode();
    }

    public final void setMIdleTime(int i) {
        this.mIdleTime = i;
    }

    public final void setMLastBoot(@OOXIXo BleVoltageRecord bleVoltageRecord) {
        IIX0o.x0xO0oo(bleVoltageRecord, "<set-?>");
        this.mLastBoot = bleVoltageRecord;
    }

    public final void setMLastShutdown(@OOXIXo BleVoltageRecord bleVoltageRecord) {
        IIX0o.x0xO0oo(bleVoltageRecord, "<set-?>");
        this.mLastShutdown = bleVoltageRecord;
    }

    public final void setMLastVoltage(@OOXIXo BleVoltageRecord bleVoltageRecord) {
        IIX0o.x0xO0oo(bleVoltageRecord, "<set-?>");
        this.mLastVoltage = bleVoltageRecord;
    }

    public final void setMLcdTime(int i) {
        this.mLcdTime = i;
    }

    public final void setMSpkTime(int i) {
        this.mSpkTime = i;
    }

    public final void setMSportTime(int i) {
        this.mSportTime = i;
    }

    public final void setMTalkTime(int i) {
        this.mTalkTime = i;
    }

    public final void setMTotalTime(int i) {
        this.mTotalTime = i;
    }

    public final void setMVibratorTime(int i) {
        this.mVibratorTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBatteryUsage(mTotalTime=" + this.mTotalTime + ", mLcdTime=" + this.mLcdTime + ", mTalkTime=" + this.mTalkTime + ", mSpkTime=" + this.mSpkTime + ", mSportTime=" + this.mSportTime + ", mVibratorTime=" + this.mVibratorTime + ", mIdleTime=" + this.mIdleTime + ", mLastBoot=" + this.mLastBoot + ", mLastShutdown=" + this.mLastShutdown + ", mLastVoltage=" + this.mLastVoltage + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBatteryUsage(int i, int i2, int i3, int i4, int i5, int i6, int i7, BleVoltageRecord bleVoltageRecord, BleVoltageRecord bleVoltageRecord2, BleVoltageRecord bleVoltageRecord3, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) == 0 ? i7 : 0, (i8 & 128) != 0 ? new BleVoltageRecord(0, 0, 0, 0, 0, 0, 0, 127, null) : bleVoltageRecord, (i8 & 256) != 0 ? new BleVoltageRecord(0, 0, 0, 0, 0, 0, 0, 127, null) : bleVoltageRecord2, (i8 & 512) != 0 ? new BleVoltageRecord(0, 0, 0, 0, 0, 0, 0, 127, null) : bleVoltageRecord3);
    }

    public BleBatteryUsage(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo BleVoltageRecord mLastBoot, @OOXIXo BleVoltageRecord mLastShutdown, @OOXIXo BleVoltageRecord mLastVoltage) {
        IIX0o.x0xO0oo(mLastBoot, "mLastBoot");
        IIX0o.x0xO0oo(mLastShutdown, "mLastShutdown");
        IIX0o.x0xO0oo(mLastVoltage, "mLastVoltage");
        this.mTotalTime = i;
        this.mLcdTime = i2;
        this.mTalkTime = i3;
        this.mSpkTime = i4;
        this.mSportTime = i5;
        this.mVibratorTime = i6;
        this.mIdleTime = i7;
        this.mLastBoot = mLastBoot;
        this.mLastShutdown = mLastShutdown;
        this.mLastVoltage = mLastVoltage;
    }
}
