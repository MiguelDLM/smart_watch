package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleIPCStoresInfo extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mFreeSize;
    private int mPhotoSize;
    private int mTotalSize;
    private int mVideoSize;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleIPCStoresInfo() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleIPCStoresInfo copy$default(BleIPCStoresInfo bleIPCStoresInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleIPCStoresInfo.mPhotoSize;
        }
        if ((i5 & 2) != 0) {
            i2 = bleIPCStoresInfo.mVideoSize;
        }
        if ((i5 & 4) != 0) {
            i3 = bleIPCStoresInfo.mTotalSize;
        }
        if ((i5 & 8) != 0) {
            i4 = bleIPCStoresInfo.mFreeSize;
        }
        return bleIPCStoresInfo.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mPhotoSize;
    }

    public final int component2() {
        return this.mVideoSize;
    }

    public final int component3() {
        return this.mTotalSize;
    }

    public final int component4() {
        return this.mFreeSize;
    }

    @OOXIXo
    public final BleIPCStoresInfo copy(int i, int i2, int i3, int i4) {
        return new BleIPCStoresInfo(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPhotoSize = readUInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mVideoSize = readUInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTotalSize = (int) readUInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mFreeSize = (int) readUInt32(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleIPCStoresInfo)) {
            return false;
        }
        BleIPCStoresInfo bleIPCStoresInfo = (BleIPCStoresInfo) obj;
        return this.mPhotoSize == bleIPCStoresInfo.mPhotoSize && this.mVideoSize == bleIPCStoresInfo.mVideoSize && this.mTotalSize == bleIPCStoresInfo.mTotalSize && this.mFreeSize == bleIPCStoresInfo.mFreeSize;
    }

    public final int getMFreeSize() {
        return this.mFreeSize;
    }

    public final int getMPhotoSize() {
        return this.mPhotoSize;
    }

    public final int getMTotalSize() {
        return this.mTotalSize;
    }

    public final int getMVideoSize() {
        return this.mVideoSize;
    }

    public int hashCode() {
        return (((((this.mPhotoSize * 31) + this.mVideoSize) * 31) + this.mTotalSize) * 31) + this.mFreeSize;
    }

    public final void setMFreeSize(int i) {
        this.mFreeSize = i;
    }

    public final void setMPhotoSize(int i) {
        this.mPhotoSize = i;
    }

    public final void setMTotalSize(int i) {
        this.mTotalSize = i;
    }

    public final void setMVideoSize(int i) {
        this.mVideoSize = i;
    }

    @OOXIXo
    public String toString() {
        return "BleIPCStoresInfo(mPhotoSize=" + this.mPhotoSize + ", mVideoSize=" + this.mVideoSize + ", mTotalSize=" + this.mTotalSize + ", mFreeSize=" + this.mFreeSize + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleIPCStoresInfo(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleIPCStoresInfo(int i, int i2, int i3, int i4) {
        this.mPhotoSize = i;
        this.mVideoSize = i2;
        this.mTotalSize = i3;
        this.mFreeSize = i4;
    }
}
