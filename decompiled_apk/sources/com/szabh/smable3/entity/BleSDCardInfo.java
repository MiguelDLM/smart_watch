package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSDCardInfo extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mClustSize;
    private int mFreeSize;
    private int mTotalSize;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSDCardInfo() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleSDCardInfo copy$default(BleSDCardInfo bleSDCardInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleSDCardInfo.mTotalSize;
        }
        if ((i4 & 2) != 0) {
            i2 = bleSDCardInfo.mFreeSize;
        }
        if ((i4 & 4) != 0) {
            i3 = bleSDCardInfo.mClustSize;
        }
        return bleSDCardInfo.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTotalSize;
    }

    public final int component2() {
        return this.mFreeSize;
    }

    public final int component3() {
        return this.mClustSize;
    }

    @OOXIXo
    public final BleSDCardInfo copy(int i, int i2, int i3) {
        return new BleSDCardInfo(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTotalSize = (int) BleReadable.readUInt32$default(this, null, 1, null);
        this.mFreeSize = (int) BleReadable.readUInt32$default(this, null, 1, null);
        this.mClustSize = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSDCardInfo)) {
            return false;
        }
        BleSDCardInfo bleSDCardInfo = (BleSDCardInfo) obj;
        return this.mTotalSize == bleSDCardInfo.mTotalSize && this.mFreeSize == bleSDCardInfo.mFreeSize && this.mClustSize == bleSDCardInfo.mClustSize;
    }

    public final int getMClustSize() {
        return this.mClustSize;
    }

    public final int getMFreeSize() {
        return this.mFreeSize;
    }

    public final int getMTotalSize() {
        return this.mTotalSize;
    }

    public int hashCode() {
        return (((this.mTotalSize * 31) + this.mFreeSize) * 31) + this.mClustSize;
    }

    public final void setMClustSize(int i) {
        this.mClustSize = i;
    }

    public final void setMFreeSize(int i) {
        this.mFreeSize = i;
    }

    public final void setMTotalSize(int i) {
        this.mTotalSize = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSDCardInfo(mTotalSize=" + this.mTotalSize + ", mFreeSize=" + this.mFreeSize + ", mClustSize=" + this.mClustSize + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSDCardInfo(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleSDCardInfo(int i, int i2, int i3) {
        this.mTotalSize = i;
        this.mFreeSize = i2;
        this.mClustSize = i3;
    }
}
