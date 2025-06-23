package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLactateThreshold extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int mAvgPower;
    private int mMaxPower;
    private int mMode;
    private int mPace;
    private int mPower;
    private int mSpeed;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleLactateThreshold() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BleLactateThreshold copy$default(BleLactateThreshold bleLactateThreshold, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = bleLactateThreshold.mMode;
        }
        if ((i7 & 2) != 0) {
            i2 = bleLactateThreshold.mPace;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = bleLactateThreshold.mPower;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = bleLactateThreshold.mAvgPower;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = bleLactateThreshold.mMaxPower;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = bleLactateThreshold.mSpeed;
        }
        return bleLactateThreshold.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.mMode;
    }

    public final int component2() {
        return this.mPace;
    }

    public final int component3() {
        return this.mPower;
    }

    public final int component4() {
        return this.mAvgPower;
    }

    public final int component5() {
        return this.mMaxPower;
    }

    public final int component6() {
        return this.mSpeed;
    }

    @OOXIXo
    public final BleLactateThreshold copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new BleLactateThreshold(i, i2, i3, i4, i5, i6);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mMode = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPace = readInt32(LITTLE_ENDIAN);
        this.mPower = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mAvgPower = readInt32(LITTLE_ENDIAN);
        this.mMaxPower = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mSpeed = readInt32(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLactateThreshold)) {
            return false;
        }
        BleLactateThreshold bleLactateThreshold = (BleLactateThreshold) obj;
        return this.mMode == bleLactateThreshold.mMode && this.mPace == bleLactateThreshold.mPace && this.mPower == bleLactateThreshold.mPower && this.mAvgPower == bleLactateThreshold.mAvgPower && this.mMaxPower == bleLactateThreshold.mMaxPower && this.mSpeed == bleLactateThreshold.mSpeed;
    }

    public final int getMAvgPower() {
        return this.mAvgPower;
    }

    public final int getMMaxPower() {
        return this.mMaxPower;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    public final int getMPower() {
        return this.mPower;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public int hashCode() {
        return (((((((((this.mMode * 31) + this.mPace) * 31) + this.mPower) * 31) + this.mAvgPower) * 31) + this.mMaxPower) * 31) + this.mSpeed;
    }

    public final void setMAvgPower(int i) {
        this.mAvgPower = i;
    }

    public final void setMMaxPower(int i) {
        this.mMaxPower = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMPower(int i) {
        this.mPower = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    @OOXIXo
    public String toString() {
        return "BleLactateThreshold(mMode=" + this.mMode + ", mPace=" + this.mPace + ", mPower=" + this.mPower + ", mAvgPower=" + this.mAvgPower + ", mMaxPower=" + this.mMaxPower + ", mSpeed=" + this.mSpeed + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLactateThreshold(int i, int i2, int i3, int i4, int i5, int i6, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6);
    }

    public BleLactateThreshold(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = i;
        this.mPace = i2;
        this.mPower = i3;
        this.mAvgPower = i4;
        this.mMaxPower = i5;
        this.mSpeed = i6;
    }
}
