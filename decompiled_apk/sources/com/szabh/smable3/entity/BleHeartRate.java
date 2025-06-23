package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHeartRate extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mBpm;
    private int mTime;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleHeartRate() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleHeartRate copy$default(BleHeartRate bleHeartRate, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleHeartRate.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleHeartRate.mBpm;
        }
        if ((i4 & 4) != 0) {
            i3 = bleHeartRate.mType;
        }
        return bleHeartRate.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mBpm;
    }

    public final int component3() {
        return this.mType;
    }

    @OOXIXo
    public final BleHeartRate copy(int i, int i2, int i3) {
        return new BleHeartRate(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mBpm = readUInt8();
        this.mType = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleHeartRate)) {
            return false;
        }
        BleHeartRate bleHeartRate = (BleHeartRate) obj;
        return this.mTime == bleHeartRate.mTime && this.mBpm == bleHeartRate.mBpm && this.mType == bleHeartRate.mType;
    }

    public final int getMBpm() {
        return this.mBpm;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((this.mTime * 31) + this.mBpm) * 31) + this.mType;
    }

    public final void setMBpm(int i) {
        this.mBpm = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleHeartRate(mTime=" + this.mTime + ", mBpm=" + this.mBpm + ", mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHeartRate(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleHeartRate(int i, int i2, int i3) {
        this.mTime = i;
        this.mBpm = i2;
        this.mType = i3;
    }
}
