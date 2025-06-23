package com.bluetrum.fota.utils;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;

/* loaded from: classes8.dex */
public final class HexUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 3];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2 + 2] = TokenParser.SP;
        }
        return new String(cArr);
    }
}
