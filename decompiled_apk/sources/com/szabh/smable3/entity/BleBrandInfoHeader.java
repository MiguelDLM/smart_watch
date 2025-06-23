package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public final class BleBrandInfoHeader extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 32;
    private int mCRC;
    private long mFileSize;

    @OOXIXo
    private String mFileTypeFlag;
    private int mItemCount;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBrandInfoHeader() {
        this(null, 0, 0L, 0, 15, null);
    }

    public static /* synthetic */ BleBrandInfoHeader copy$default(BleBrandInfoHeader bleBrandInfoHeader, String str, int i, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bleBrandInfoHeader.mFileTypeFlag;
        }
        if ((i3 & 2) != 0) {
            i = bleBrandInfoHeader.mItemCount;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            j = bleBrandInfoHeader.mFileSize;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = bleBrandInfoHeader.mCRC;
        }
        return bleBrandInfoHeader.copy(str, i4, j2, i2);
    }

    @OOXIXo
    public final String component1() {
        return this.mFileTypeFlag;
    }

    public final int component2() {
        return this.mItemCount;
    }

    public final long component3() {
        return this.mFileSize;
    }

    public final int component4() {
        return this.mCRC;
    }

    @OOXIXo
    public final BleBrandInfoHeader copy(@OOXIXo String mFileTypeFlag, int i, long j, int i2) {
        IIX0o.x0xO0oo(mFileTypeFlag, "mFileTypeFlag");
        return new BleBrandInfoHeader(mFileTypeFlag, i, j, i2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeStringWithFix(this.mFileTypeFlag, 2, oxoX.f29584XO);
        writeInt8(this.mItemCount);
        writeInt8(0);
        BleWritable.writeUInt32$default(this, this.mFileSize, null, 2, null);
        BleWritable.writeInt16$default(this, this.mCRC, null, 2, null);
        BleWritable.writeBytes$default(this, new byte[22], null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBrandInfoHeader)) {
            return false;
        }
        BleBrandInfoHeader bleBrandInfoHeader = (BleBrandInfoHeader) obj;
        return IIX0o.Oxx0IOOO(this.mFileTypeFlag, bleBrandInfoHeader.mFileTypeFlag) && this.mItemCount == bleBrandInfoHeader.mItemCount && this.mFileSize == bleBrandInfoHeader.mFileSize && this.mCRC == bleBrandInfoHeader.mCRC;
    }

    public final int getMCRC() {
        return this.mCRC;
    }

    public final long getMFileSize() {
        return this.mFileSize;
    }

    @OOXIXo
    public final String getMFileTypeFlag() {
        return this.mFileTypeFlag;
    }

    public final int getMItemCount() {
        return this.mItemCount;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 32;
    }

    public int hashCode() {
        return (((((this.mFileTypeFlag.hashCode() * 31) + this.mItemCount) * 31) + oIX0oI.oIX0oI(this.mFileSize)) * 31) + this.mCRC;
    }

    public final void setMCRC(int i) {
        this.mCRC = i;
    }

    public final void setMFileSize(long j) {
        this.mFileSize = j;
    }

    public final void setMFileTypeFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFileTypeFlag = str;
    }

    public final void setMItemCount(int i) {
        this.mItemCount = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBrandInfoHeader(mFileTypeFlag=" + this.mFileTypeFlag + ", mItemCount=" + this.mItemCount + ", mFileSize=" + this.mFileSize + ", mCRC=" + this.mCRC + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBrandInfoHeader(String str, int i, long j, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "BR" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0L : j, (i3 & 8) == 0 ? i2 : 0);
    }

    public BleBrandInfoHeader(@OOXIXo String mFileTypeFlag, int i, long j, int i2) {
        IIX0o.x0xO0oo(mFileTypeFlag, "mFileTypeFlag");
        this.mFileTypeFlag = mFileTypeFlag;
        this.mItemCount = i;
        this.mFileSize = j;
        this.mCRC = i2;
    }
}
