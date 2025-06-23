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
public final class BlePpgSHSY extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mPGG;
    private long mPGGRaw;
    private long mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BlePpgSHSY() {
        this(0L, 0L, 0, 7, null);
    }

    public static /* synthetic */ BlePpgSHSY copy$default(BlePpgSHSY blePpgSHSY, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = blePpgSHSY.mTime;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = blePpgSHSY.mPGGRaw;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = blePpgSHSY.mPGG;
        }
        return blePpgSHSY.copy(j3, j4, i);
    }

    public final long component1() {
        return this.mTime;
    }

    public final long component2() {
        return this.mPGGRaw;
    }

    public final int component3() {
        return this.mPGG;
    }

    @OOXIXo
    public final BlePpgSHSY copy(long j, long j2, int i) {
        return new BlePpgSHSY(j, j2, i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPGGRaw = readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPGG = readInt32(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlePpgSHSY)) {
            return false;
        }
        BlePpgSHSY blePpgSHSY = (BlePpgSHSY) obj;
        return this.mTime == blePpgSHSY.mTime && this.mPGGRaw == blePpgSHSY.mPGGRaw && this.mPGG == blePpgSHSY.mPGG;
    }

    public final int getMPGG() {
        return this.mPGG;
    }

    public final long getMPGGRaw() {
        return this.mPGGRaw;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((oIX0oI.oIX0oI(this.mTime) * 31) + oIX0oI.oIX0oI(this.mPGGRaw)) * 31) + this.mPGG;
    }

    public final void setMPGG(int i) {
        this.mPGG = i;
    }

    public final void setMPGGRaw(long j) {
        this.mPGGRaw = j;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "BlePpgSHSY(mTime=" + this.mTime + ", mPGGRaw=" + this.mPGGRaw + ", mPGG=" + this.mPGG + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BlePpgSHSY(long j, long j2, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) == 0 ? j2 : 0L, (i2 & 4) != 0 ? 0 : i);
    }

    public BlePpgSHSY(long j, long j2, int i) {
        this.mTime = j;
        this.mPGGRaw = j2;
        this.mPGG = i;
    }
}
