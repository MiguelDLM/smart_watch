package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleThirdPartyData extends BleWritable {
    public static final int ALIPAY_TYPE = 1;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private byte[] mData;
    private int mIndex;
    private int mSize;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleThirdPartyData() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ BleThirdPartyData copy$default(BleThirdPartyData bleThirdPartyData, int i, int i2, int i3, byte[] bArr, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleThirdPartyData.mType;
        }
        if ((i4 & 2) != 0) {
            i2 = bleThirdPartyData.mSize;
        }
        if ((i4 & 4) != 0) {
            i3 = bleThirdPartyData.mIndex;
        }
        if ((i4 & 8) != 0) {
            bArr = bleThirdPartyData.mData;
        }
        return bleThirdPartyData.copy(i, i2, i3, bArr);
    }

    public final int component1() {
        return this.mType;
    }

    public final int component2() {
        return this.mSize;
    }

    public final int component3() {
        return this.mIndex;
    }

    @OOXIXo
    public final byte[] component4() {
        return this.mData;
    }

    @OOXIXo
    public final BleThirdPartyData copy(int i, int i2, int i3, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        return new BleThirdPartyData(i, i2, i3, mData);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
        this.mSize = BleReadable.readInt32$default(this, null, 1, null);
        this.mIndex = BleReadable.readInt32$default(this, null, 1, null);
        byte[] mBytes = getMBytes();
        IIX0o.ooOOo0oXI(mBytes);
        if (mBytes.length > 9) {
            byte[] mBytes2 = getMBytes();
            IIX0o.ooOOo0oXI(mBytes2);
            this.mData = readBytes(mBytes2.length - 9);
        }
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        BleWritable.writeInt32$default(this, this.mSize, null, 2, null);
        BleWritable.writeInt32$default(this, this.mIndex, null, 2, null);
        BleWritable.writeBytes$default(this, this.mData, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleThirdPartyData)) {
            return false;
        }
        BleThirdPartyData bleThirdPartyData = (BleThirdPartyData) obj;
        return this.mType == bleThirdPartyData.mType && this.mSize == bleThirdPartyData.mSize && this.mIndex == bleThirdPartyData.mIndex && IIX0o.Oxx0IOOO(this.mData, bleThirdPartyData.mData);
    }

    @OOXIXo
    public final byte[] getMData() {
        return this.mData;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mData.length + 9;
    }

    public final int getMSize() {
        return this.mSize;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((this.mType * 31) + this.mSize) * 31) + this.mIndex) * 31) + Arrays.hashCode(this.mData);
    }

    public final void setMData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mData = bArr;
    }

    public final void setMIndex(int i) {
        this.mIndex = i;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleThirdPartyData(mType=" + this.mType + ", mSize=" + this.mSize + ", mIndex=" + this.mIndex + ", mPacket=" + this.mData.length + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleThirdPartyData(int i, int i2, int i3, byte[] bArr, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? new byte[0] : bArr);
    }

    public BleThirdPartyData(int i, int i2, int i3, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.mType = i;
        this.mSize = i2;
        this.mIndex = i3;
        this.mData = mData;
    }
}
