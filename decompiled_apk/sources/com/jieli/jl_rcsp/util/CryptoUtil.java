package com.jieli.jl_rcsp.util;

/* loaded from: classes10.dex */
public class CryptoUtil {
    static {
        System.loadLibrary("jl_crc");
    }

    public static short CRC16(byte[] bArr, short s) {
        if (bArr == null) {
            return (short) 0;
        }
        return crc16(bArr, s);
    }

    private static native short crc16(byte[] bArr, short s);
}
