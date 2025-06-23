package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public final class BleBrandInfoImage extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int hasAlpha;
    private long mAddress;
    private int mCompression;
    private int mHeight;
    private long mId;
    private int mPixelFormat;
    private int mWidth;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBrandInfoImage() {
        this(0L, 0L, 0, 0, 0, 0, 0, 127, null);
    }

    public final long component1() {
        return this.mId;
    }

    public final long component2() {
        return this.mAddress;
    }

    public final int component3() {
        return this.mWidth;
    }

    public final int component4() {
        return this.mHeight;
    }

    public final int component5() {
        return this.hasAlpha;
    }

    public final int component6() {
        return this.mCompression;
    }

    public final int component7() {
        return this.mPixelFormat;
    }

    @OOXIXo
    public final BleBrandInfoImage copy(long j, long j2, int i, int i2, int i3, int i4, int i5) {
        return new BleBrandInfoImage(j, j2, i, i2, i3, i4, i5);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        long j = this.mId;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeUInt32(j, LITTLE_ENDIAN);
        long j2 = this.mAddress;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeUInt32(j2, LITTLE_ENDIAN);
        int i = this.mWidth;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        int i2 = this.mHeight;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        writeIntN(0, 2);
        writeIntN(this.hasAlpha, 1);
        writeIntN(this.mPixelFormat, 2);
        writeIntN(this.mCompression, 3);
        BleWritable.writeInt24$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBrandInfoImage)) {
            return false;
        }
        BleBrandInfoImage bleBrandInfoImage = (BleBrandInfoImage) obj;
        return this.mId == bleBrandInfoImage.mId && this.mAddress == bleBrandInfoImage.mAddress && this.mWidth == bleBrandInfoImage.mWidth && this.mHeight == bleBrandInfoImage.mHeight && this.hasAlpha == bleBrandInfoImage.hasAlpha && this.mCompression == bleBrandInfoImage.mCompression && this.mPixelFormat == bleBrandInfoImage.mPixelFormat;
    }

    public final int getHasAlpha() {
        return this.hasAlpha;
    }

    public final long getMAddress() {
        return this.mAddress;
    }

    public final int getMCompression() {
        return this.mCompression;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final long getMId() {
        return this.mId;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public final int getMPixelFormat() {
        return this.mPixelFormat;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return (((((((((((oIX0oI.oIX0oI(this.mId) * 31) + oIX0oI.oIX0oI(this.mAddress)) * 31) + this.mWidth) * 31) + this.mHeight) * 31) + this.hasAlpha) * 31) + this.mCompression) * 31) + this.mPixelFormat;
    }

    public final void setHasAlpha(int i) {
        this.hasAlpha = i;
    }

    public final void setMAddress(long j) {
        this.mAddress = j;
    }

    public final void setMCompression(int i) {
        this.mCompression = i;
    }

    public final void setMHeight(int i) {
        this.mHeight = i;
    }

    public final void setMId(long j) {
        this.mId = j;
    }

    public final void setMPixelFormat(int i) {
        this.mPixelFormat = i;
    }

    public final void setMWidth(int i) {
        this.mWidth = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBrandInfoImage(mId=" + this.mId + ", mAddress=" + this.mAddress + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", hasAlpha=" + this.hasAlpha + ", mCompression=" + this.mCompression + ", mPixelFormat=" + this.mPixelFormat + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBrandInfoImage(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0L : j, (i6 & 2) == 0 ? j2 : 0L, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? 0 : i2, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) != 0 ? 0 : i4, (i6 & 64) == 0 ? i5 : 0);
    }

    public BleBrandInfoImage(long j, long j2, int i, int i2, int i3, int i4, int i5) {
        this.mId = j;
        this.mAddress = j2;
        this.mWidth = i;
        this.mHeight = i2;
        this.hasAlpha = i3;
        this.mCompression = i4;
        this.mPixelFormat = i5;
    }
}
