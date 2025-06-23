package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleNaviImage extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_HEADER_LENGTH = 64;

    @OOXIXo
    private byte[] mImageBuffers;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleNaviImage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleNaviImage copy$default(BleNaviImage bleNaviImage, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = bleNaviImage.mImageBuffers;
        }
        return bleNaviImage.copy(bArr);
    }

    @OOXIXo
    public final byte[] component1() {
        return this.mImageBuffers;
    }

    @OOXIXo
    public final BleNaviImage copy(@OOXIXo byte[] mImageBuffers) {
        IIX0o.x0xO0oo(mImageBuffers, "mImageBuffers");
        return new BleNaviImage(mImageBuffers);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeBytes$default(this, new byte[64], null, 2, null);
        BleWritable.writeBytes$default(this, this.mImageBuffers, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleNaviImage) && IIX0o.Oxx0IOOO(this.mImageBuffers, ((BleNaviImage) obj).mImageBuffers);
    }

    @OOXIXo
    public final byte[] getMImageBuffers() {
        return this.mImageBuffers;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mImageBuffers.length + 64;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mImageBuffers);
    }

    public final void setMImageBuffers(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mImageBuffers = bArr;
    }

    @OOXIXo
    public String toString() {
        return "BleNaviImage(mImageBuffers=" + Arrays.toString(this.mImageBuffers) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleNaviImage(byte[] bArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new byte[0] : bArr);
    }

    public BleNaviImage(@OOXIXo byte[] mImageBuffers) {
        IIX0o.x0xO0oo(mImageBuffers, "mImageBuffers");
        this.mImageBuffers = mImageBuffers;
    }
}
