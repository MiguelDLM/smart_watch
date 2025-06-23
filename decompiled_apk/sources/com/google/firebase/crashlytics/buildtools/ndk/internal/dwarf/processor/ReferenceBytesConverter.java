package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes10.dex */
public class ReferenceBytesConverter {
    private final ByteOrder byteOrder;

    public ReferenceBytesConverter(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    private static long referenceBytesAsLong(byte[] bArr, ByteOrder byteOrder) {
        int i;
        int length = bArr.length;
        byte[] bArr2 = new byte[8];
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i = 8 - length;
        } else {
            i = 0;
        }
        System.arraycopy(bArr, 0, bArr2, i, length);
        return ByteBuffer.wrap(bArr2).order(byteOrder).getLong();
    }

    public long asLongValue(byte[] bArr) {
        return referenceBytesAsLong(bArr, this.byteOrder);
    }
}
