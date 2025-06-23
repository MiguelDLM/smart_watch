package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleQrcode extends BleWritable {

    @OOXIXo
    private byte[] mData;
    private int mType;
    private int mWidth;

    public BleQrcode() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ BleQrcode copy$default(BleQrcode bleQrcode, int i, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleQrcode.mWidth;
        }
        if ((i3 & 2) != 0) {
            i2 = bleQrcode.mType;
        }
        if ((i3 & 4) != 0) {
            bArr = bleQrcode.mData;
        }
        return bleQrcode.copy(i, i2, bArr);
    }

    public final int component1() {
        return this.mWidth;
    }

    public final int component2() {
        return this.mType;
    }

    @OOXIXo
    public final byte[] component3() {
        return this.mData;
    }

    @OOXIXo
    public final BleQrcode copy(int i, int i2, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        return new BleQrcode(i, i2, mData);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mWidth);
        writeInt8(this.mType);
        BleWritable.writeBytes$default(this, this.mData, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleQrcode)) {
            return false;
        }
        BleQrcode bleQrcode = (BleQrcode) obj;
        return this.mWidth == bleQrcode.mWidth && this.mType == bleQrcode.mType && IIX0o.Oxx0IOOO(this.mData, bleQrcode.mData);
    }

    @OOXIXo
    public final byte[] getMData() {
        return this.mData;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mData.length + 2;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return (((this.mWidth * 31) + this.mType) * 31) + Arrays.hashCode(this.mData);
    }

    public final void setMData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mData = bArr;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMWidth(int i) {
        this.mWidth = i;
    }

    @OOXIXo
    public String toString() {
        return "BleQrcode(mWidth=" + this.mWidth + ", mType=" + this.mType + ", mData=" + this.mData.length + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleQrcode(int i, int i2, byte[] bArr, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new byte[0] : bArr);
    }

    public BleQrcode(int i, int i2, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.mWidth = i;
        this.mType = i2;
        this.mData = mData;
    }
}
