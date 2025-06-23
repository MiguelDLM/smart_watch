package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWatchFaceIndex extends BleWritable {
    public static final int BLE_WATCHFACE_TYPE_BUILTIN = 0;
    public static final int BLE_WATCHFACE_TYPE_CLOUDY = 1;
    public static final int BLE_WATCHFACE_TYPE_CUSTOM = 2;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private int mIndex;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleWatchFaceIndex() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleWatchFaceIndex.<init>():void");
    }

    public static /* synthetic */ BleWatchFaceIndex copy$default(BleWatchFaceIndex bleWatchFaceIndex, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleWatchFaceIndex.mType;
        }
        if ((i3 & 2) != 0) {
            i2 = bleWatchFaceIndex.mIndex;
        }
        return bleWatchFaceIndex.copy(i, i2);
    }

    public final int component1() {
        return this.mType;
    }

    public final int component2() {
        return this.mIndex;
    }

    @OOXIXo
    public final BleWatchFaceIndex copy(int i, int i2) {
        return new BleWatchFaceIndex(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readUInt8();
        this.mIndex = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        writeInt8(this.mIndex);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleWatchFaceIndex)) {
            return false;
        }
        BleWatchFaceIndex bleWatchFaceIndex = (BleWatchFaceIndex) obj;
        return this.mType == bleWatchFaceIndex.mType && this.mIndex == bleWatchFaceIndex.mIndex;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + this.mIndex;
    }

    public final void setMIndex(int i) {
        this.mIndex = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleWatchFaceIndex(mType=" + this.mType + ", mIndex=" + this.mIndex + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWatchFaceIndex(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleWatchFaceIndex(int i, int i2) {
        this.mType = i;
        this.mIndex = i2;
    }
}
