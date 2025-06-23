package com.bestmafen.baseble.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public class BleByteArray {

    @OOXIXo
    private transient ByteOrder mByteOrder;

    @oOoXoXO
    private transient byte[] mBytes;

    @OOXIXo
    private final transient int[] mPositions;

    /* JADX WARN: Multi-variable type inference failed */
    public BleByteArray() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int bitsLeft() {
        byte[] bArr = this.mBytes;
        if (bArr == null) {
            return 0;
        }
        IIX0o.ooOOo0oXI(bArr);
        return (bArr.length * 8) - bitsOffset();
    }

    public final int bitsOffset() {
        int[] iArr = this.mPositions;
        return (iArr[0] * 8) + iArr[1];
    }

    @OOXIXo
    public final ByteOrder getMByteOrder() {
        return this.mByteOrder;
    }

    @oOoXoXO
    public final byte[] getMBytes() {
        return this.mBytes;
    }

    @OOXIXo
    public final int[] getMPositions() {
        return this.mPositions;
    }

    public final boolean outOfRange(int i) {
        int bitsOffset;
        if (this.mBytes == null || (bitsOffset = bitsOffset() + i) < 0) {
            return true;
        }
        byte[] bArr = this.mBytes;
        IIX0o.ooOOo0oXI(bArr);
        if (bitsOffset > bArr.length * 8) {
            return true;
        }
        return false;
    }

    public final void resetOffset() {
        Arrays.fill(this.mPositions, 0);
    }

    public final void setMByteOrder(@OOXIXo ByteOrder byteOrder) {
        IIX0o.x0xO0oo(byteOrder, "<set-?>");
        this.mByteOrder = byteOrder;
    }

    public final void setMBytes(@oOoXoXO byte[] bArr) {
        this.mBytes = bArr;
    }

    public final void skip(int i) {
        int bitsOffset = bitsOffset() + i;
        if (bitsOffset < 0) {
            bitsOffset = 0;
        }
        int[] iArr = this.mPositions;
        iArr[0] = bitsOffset / 8;
        iArr[1] = bitsOffset % 8;
    }

    public BleByteArray(@oOoXoXO byte[] bArr, @OOXIXo ByteOrder mByteOrder) {
        IIX0o.x0xO0oo(mByteOrder, "mByteOrder");
        this.mBytes = bArr;
        this.mByteOrder = mByteOrder;
        this.mPositions = new int[2];
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BleByteArray(byte[] r1, java.nio.ByteOrder r2, int r3, kotlin.jvm.internal.IIXOooo r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L5
            r1 = 0
        L5:
            r3 = r3 & 2
            if (r3 == 0) goto L10
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            java.lang.String r3 = "BIG_ENDIAN"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
        L10:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bestmafen.baseble.data.BleByteArray.<init>(byte[], java.nio.ByteOrder, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
