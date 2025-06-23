package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BlePackageStatus extends BleReadable {

    @OOXIXo
    private byte[] mData;
    private int mFontPackageStatus;
    private int mLanguagePackageStatus;
    private int mUIPackageStatus;

    public BlePackageStatus() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ BlePackageStatus copy$default(BlePackageStatus blePackageStatus, int i, int i2, int i3, byte[] bArr, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = blePackageStatus.mFontPackageStatus;
        }
        if ((i4 & 2) != 0) {
            i2 = blePackageStatus.mUIPackageStatus;
        }
        if ((i4 & 4) != 0) {
            i3 = blePackageStatus.mLanguagePackageStatus;
        }
        if ((i4 & 8) != 0) {
            bArr = blePackageStatus.mData;
        }
        return blePackageStatus.copy(i, i2, i3, bArr);
    }

    public final int component1() {
        return this.mFontPackageStatus;
    }

    public final int component2() {
        return this.mUIPackageStatus;
    }

    public final int component3() {
        return this.mLanguagePackageStatus;
    }

    @OOXIXo
    public final byte[] component4() {
        return this.mData;
    }

    @OOXIXo
    public final BlePackageStatus copy(int i, int i2, int i3, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        return new BlePackageStatus(i, i2, i3, mData);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mFontPackageStatus = readInt8();
        this.mUIPackageStatus = readInt8();
        this.mLanguagePackageStatus = readInt8();
        readInt8();
        BleReadable.readInt32$default(this, null, 1, null);
        byte[] mBytes = getMBytes();
        IIX0o.ooOOo0oXI(mBytes);
        if (mBytes.length > 8) {
            byte[] mBytes2 = getMBytes();
            IIX0o.ooOOo0oXI(mBytes2);
            this.mData = readBytes(mBytes2.length - 8);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlePackageStatus)) {
            return false;
        }
        BlePackageStatus blePackageStatus = (BlePackageStatus) obj;
        return this.mFontPackageStatus == blePackageStatus.mFontPackageStatus && this.mUIPackageStatus == blePackageStatus.mUIPackageStatus && this.mLanguagePackageStatus == blePackageStatus.mLanguagePackageStatus && IIX0o.Oxx0IOOO(this.mData, blePackageStatus.mData);
    }

    @OOXIXo
    public final byte[] getMData() {
        return this.mData;
    }

    public final int getMFontPackageStatus() {
        return this.mFontPackageStatus;
    }

    public final int getMLanguagePackageStatus() {
        return this.mLanguagePackageStatus;
    }

    public final int getMUIPackageStatus() {
        return this.mUIPackageStatus;
    }

    public int hashCode() {
        return (((((this.mFontPackageStatus * 31) + this.mUIPackageStatus) * 31) + this.mLanguagePackageStatus) * 31) + Arrays.hashCode(this.mData);
    }

    public final void setMData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mData = bArr;
    }

    public final void setMFontPackageStatus(int i) {
        this.mFontPackageStatus = i;
    }

    public final void setMLanguagePackageStatus(int i) {
        this.mLanguagePackageStatus = i;
    }

    public final void setMUIPackageStatus(int i) {
        this.mUIPackageStatus = i;
    }

    @OOXIXo
    public String toString() {
        return "BlePackageStatus(mFontPackageStatus=" + this.mFontPackageStatus + ", mUIPackageStatus=" + this.mUIPackageStatus + ", mLanguagePackageStatus=" + this.mLanguagePackageStatus + ", mData=" + ByteArrayExtKt.getMHexString(this.mData) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BlePackageStatus(int i, int i2, int i3, byte[] bArr, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? new byte[0] : bArr);
    }

    public BlePackageStatus(int i, int i2, int i3, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.mFontPackageStatus = i;
        this.mUIPackageStatus = i2;
        this.mLanguagePackageStatus = i3;
        this.mData = mData;
    }
}
