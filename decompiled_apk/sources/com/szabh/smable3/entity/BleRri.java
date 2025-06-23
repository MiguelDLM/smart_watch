package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleRri extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mRRI;
    private int mRRI2;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleRri() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleRri copy$default(BleRri bleRri, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleRri.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleRri.mRRI;
        }
        if ((i4 & 4) != 0) {
            i3 = bleRri.mRRI2;
        }
        return bleRri.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mRRI;
    }

    public final int component3() {
        return this.mRRI2;
    }

    @OOXIXo
    public final BleRri copy(int i, int i2, int i3) {
        return new BleRri(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mRRI = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mRRI2 = readInt16(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleRri)) {
            return false;
        }
        BleRri bleRri = (BleRri) obj;
        return this.mTime == bleRri.mTime && this.mRRI == bleRri.mRRI && this.mRRI2 == bleRri.mRRI2;
    }

    public final int getMRRI() {
        return this.mRRI;
    }

    public final int getMRRI2() {
        return this.mRRI2;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((this.mTime * 31) + this.mRRI) * 31) + this.mRRI2;
    }

    public final void setMRRI(int i) {
        this.mRRI = i;
    }

    public final void setMRRI2(int i) {
        this.mRRI2 = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleRri(mTime=" + this.mTime + ", mRRI=" + this.mRRI + ", mRRI2=" + this.mRRI2 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleRri(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleRri(int i, int i2, int i3) {
        this.mTime = i;
        this.mRRI = i2;
        this.mRRI2 = i3;
    }
}
