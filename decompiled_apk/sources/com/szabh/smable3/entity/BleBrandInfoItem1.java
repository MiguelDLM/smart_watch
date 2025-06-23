package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* JADX INFO: Access modifiers changed from: package-private */
@XX({"SMAP\nBleBrandInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleBrandInfo.kt\ncom/szabh/smable3/entity/BleBrandInfoItem1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,251:1\n13309#2,2:252\n13309#2,2:254\n13309#2,2:256\n*S KotlinDebug\n*F\n+ 1 BleBrandInfo.kt\ncom/szabh/smable3/entity/BleBrandInfoItem1\n*L\n77#1:252,2\n91#1:254,2\n94#1:256,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleBrandInfoItem1 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_HEADER_LENGTH = 32;
    private int mAnchor;
    private int mCount;

    @OOXIXo
    private byte[][] mImageBuffers;

    @OOXIXo
    private BleBrandInfoImage[] mImageInfos;
    private int mPlayInterval;
    private int mX;
    private int mY;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBrandInfoItem1() {
        this(0, 0, 0, 0, 0, null, null, 127, null);
    }

    public static /* synthetic */ BleBrandInfoItem1 copy$default(BleBrandInfoItem1 bleBrandInfoItem1, int i, int i2, int i3, int i4, int i5, BleBrandInfoImage[] bleBrandInfoImageArr, byte[][] bArr, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleBrandInfoItem1.mX;
        }
        if ((i6 & 2) != 0) {
            i2 = bleBrandInfoItem1.mY;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = bleBrandInfoItem1.mAnchor;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = bleBrandInfoItem1.mCount;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = bleBrandInfoItem1.mPlayInterval;
        }
        int i10 = i5;
        if ((i6 & 32) != 0) {
            bleBrandInfoImageArr = bleBrandInfoItem1.mImageInfos;
        }
        BleBrandInfoImage[] bleBrandInfoImageArr2 = bleBrandInfoImageArr;
        if ((i6 & 64) != 0) {
            bArr = bleBrandInfoItem1.mImageBuffers;
        }
        return bleBrandInfoItem1.copy(i, i7, i8, i9, i10, bleBrandInfoImageArr2, bArr);
    }

    private final int getImageBufferSize() {
        int i = 0;
        for (byte[] bArr : this.mImageBuffers) {
            i += bArr.length;
        }
        return i;
    }

    public final int component1() {
        return this.mX;
    }

    public final int component2() {
        return this.mY;
    }

    public final int component3() {
        return this.mAnchor;
    }

    public final int component4() {
        return this.mCount;
    }

    public final int component5() {
        return this.mPlayInterval;
    }

    @OOXIXo
    public final BleBrandInfoImage[] component6() {
        return this.mImageInfos;
    }

    @OOXIXo
    public final byte[][] component7() {
        return this.mImageBuffers;
    }

    @OOXIXo
    public final BleBrandInfoItem1 copy(int i, int i2, int i3, int i4, int i5, @OOXIXo BleBrandInfoImage[] mImageInfos, @OOXIXo byte[][] mImageBuffers) {
        IIX0o.x0xO0oo(mImageInfos, "mImageInfos");
        IIX0o.x0xO0oo(mImageBuffers, "mImageBuffers");
        return new BleBrandInfoItem1(i, i2, i3, i4, i5, mImageInfos, mImageBuffers);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        int i = this.mX;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i, LITTLE_ENDIAN);
        int i2 = this.mY;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i2, LITTLE_ENDIAN);
        writeInt8(this.mAnchor);
        writeInt8(this.mCount);
        int i3 = this.mPlayInterval;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i3, LITTLE_ENDIAN);
        BleWritable.writeBytes$default(this, new byte[20], null, 2, null);
        for (BleBrandInfoImage bleBrandInfoImage : this.mImageInfos) {
            writeObject(bleBrandInfoImage);
        }
        for (byte[] bArr : this.mImageBuffers) {
            BleWritable.writeBytes$default(this, bArr, null, 2, null);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBrandInfoItem1)) {
            return false;
        }
        BleBrandInfoItem1 bleBrandInfoItem1 = (BleBrandInfoItem1) obj;
        return this.mX == bleBrandInfoItem1.mX && this.mY == bleBrandInfoItem1.mY && this.mAnchor == bleBrandInfoItem1.mAnchor && this.mCount == bleBrandInfoItem1.mCount && this.mPlayInterval == bleBrandInfoItem1.mPlayInterval && IIX0o.Oxx0IOOO(this.mImageInfos, bleBrandInfoItem1.mImageInfos) && IIX0o.Oxx0IOOO(this.mImageBuffers, bleBrandInfoItem1.mImageBuffers);
    }

    public final int getMAnchor() {
        return this.mAnchor;
    }

    public final int getMCount() {
        return this.mCount;
    }

    @OOXIXo
    public final byte[][] getMImageBuffers() {
        return this.mImageBuffers;
    }

    @OOXIXo
    public final BleBrandInfoImage[] getMImageInfos() {
        return this.mImageInfos;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return (this.mImageInfos.length * 16) + 32 + getImageBufferSize();
    }

    public final int getMPlayInterval() {
        return this.mPlayInterval;
    }

    public final int getMX() {
        return this.mX;
    }

    public final int getMY() {
        return this.mY;
    }

    public int hashCode() {
        return (((((((((((this.mX * 31) + this.mY) * 31) + this.mAnchor) * 31) + this.mCount) * 31) + this.mPlayInterval) * 31) + Arrays.hashCode(this.mImageInfos)) * 31) + Arrays.hashCode(this.mImageBuffers);
    }

    public final void setMAnchor(int i) {
        this.mAnchor = i;
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMImageBuffers(@OOXIXo byte[][] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mImageBuffers = bArr;
    }

    public final void setMImageInfos(@OOXIXo BleBrandInfoImage[] bleBrandInfoImageArr) {
        IIX0o.x0xO0oo(bleBrandInfoImageArr, "<set-?>");
        this.mImageInfos = bleBrandInfoImageArr;
    }

    public final void setMPlayInterval(int i) {
        this.mPlayInterval = i;
    }

    public final void setMX(int i) {
        this.mX = i;
    }

    public final void setMY(int i) {
        this.mY = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBrandInfoItem1(mX=" + this.mX + ", mY=" + this.mY + ", mAnchor=" + this.mAnchor + ", mCount=" + this.mCount + ", mPlayInterval=" + this.mPlayInterval + ", mImageInfos=" + Arrays.toString(this.mImageInfos) + ", mImageBuffers=" + Arrays.toString(this.mImageBuffers) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBrandInfoItem1(int i, int i2, int i3, int i4, int i5, BleBrandInfoImage[] bleBrandInfoImageArr, byte[][] bArr, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? new BleBrandInfoImage[0] : bleBrandInfoImageArr, (i6 & 64) != 0 ? new byte[0] : bArr);
    }

    public BleBrandInfoItem1(int i, int i2, int i3, int i4, int i5, @OOXIXo BleBrandInfoImage[] mImageInfos, @OOXIXo byte[][] mImageBuffers) {
        IIX0o.x0xO0oo(mImageInfos, "mImageInfos");
        IIX0o.x0xO0oo(mImageBuffers, "mImageBuffers");
        this.mX = i;
        this.mY = i2;
        this.mAnchor = i3;
        this.mCount = i4;
        this.mPlayInterval = i5;
        this.mImageInfos = mImageInfos;
        this.mImageBuffers = mImageBuffers;
    }
}
