package com.baidu.ar;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class dy {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0164 A[Catch: IOException -> 0x0160, TRY_LEAVE, TryCatch #7 {IOException -> 0x0160, blocks: (B:37:0x015c, B:30:0x0164), top: B:36:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.ar.eb i(byte[] r7) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.dy.i(byte[]):com.baidu.ar.eb");
    }

    public static byte[] j(byte[] bArr) {
        return bArr != null ? Arrays.copyOfRange(bArr, 44, bArr.length) : new byte[0];
    }

    private static short k(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    private static int l(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
}
