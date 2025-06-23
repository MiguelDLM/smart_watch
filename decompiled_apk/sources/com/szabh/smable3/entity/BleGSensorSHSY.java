package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGSensorSHSY extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int mActivityMode;
    private int mSleepParticularCase;
    private int mStep;
    private long mTime;
    private short mX;
    private short mY;
    private short mZ;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGSensorSHSY() {
        this(0L, (short) 0, (short) 0, (short) 0, 0, 0, 0, 127, null);
    }

    public final long component1() {
        return this.mTime;
    }

    public final short component2() {
        return this.mX;
    }

    public final short component3() {
        return this.mY;
    }

    public final short component4() {
        return this.mZ;
    }

    public final int component5() {
        return this.mActivityMode;
    }

    public final int component6() {
        return this.mSleepParticularCase;
    }

    public final int component7() {
        return this.mStep;
    }

    @OOXIXo
    public final BleGSensorSHSY copy(long j, short s, short s2, short s3, int i, int i2, int i3) {
        return new BleGSensorSHSY(j, s, s2, s3, i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mX = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mY = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mZ = readInt16(LITTLE_ENDIAN);
        this.mActivityMode = readInt8();
        this.mSleepParticularCase = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStep = readInt32(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGSensorSHSY)) {
            return false;
        }
        BleGSensorSHSY bleGSensorSHSY = (BleGSensorSHSY) obj;
        return this.mTime == bleGSensorSHSY.mTime && this.mX == bleGSensorSHSY.mX && this.mY == bleGSensorSHSY.mY && this.mZ == bleGSensorSHSY.mZ && this.mActivityMode == bleGSensorSHSY.mActivityMode && this.mSleepParticularCase == bleGSensorSHSY.mSleepParticularCase && this.mStep == bleGSensorSHSY.mStep;
    }

    public final int getMActivityMode() {
        return this.mActivityMode;
    }

    public final int getMSleepParticularCase() {
        return this.mSleepParticularCase;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final short getMX() {
        return this.mX;
    }

    public final short getMY() {
        return this.mY;
    }

    public final short getMZ() {
        return this.mZ;
    }

    public int hashCode() {
        return (((((((((((oIX0oI.oIX0oI(this.mTime) * 31) + this.mX) * 31) + this.mY) * 31) + this.mZ) * 31) + this.mActivityMode) * 31) + this.mSleepParticularCase) * 31) + this.mStep;
    }

    public final void setMActivityMode(int i) {
        this.mActivityMode = i;
    }

    public final void setMSleepParticularCase(int i) {
        this.mSleepParticularCase = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMX(short s) {
        this.mX = s;
    }

    public final void setMY(short s) {
        this.mY = s;
    }

    public final void setMZ(short s) {
        this.mZ = s;
    }

    @OOXIXo
    public String toString() {
        return "BleGSensorSHSY(mTime=" + this.mTime + ", mX=" + ((int) this.mX) + ", mY=" + ((int) this.mY) + ", mZ=" + ((int) this.mZ) + ", mActivityMode=" + this.mActivityMode + ", mSleepParticularCase=" + this.mSleepParticularCase + ", mStep=" + this.mStep + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGSensorSHSY(long j, short s, short s2, short s3, int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? (short) 0 : s, (i4 & 4) != 0 ? (short) 0 : s2, (i4 & 8) != 0 ? (short) 0 : s3, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) == 0 ? i3 : 0);
    }

    public BleGSensorSHSY(long j, short s, short s2, short s3, int i, int i2, int i3) {
        this.mTime = j;
        this.mX = s;
        this.mY = s2;
        this.mZ = s3;
        this.mActivityMode = i;
        this.mSleepParticularCase = i2;
        this.mStep = i3;
    }
}
