package com.tenmeter.smlibrary.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: classes13.dex */
public class MD5 {
    public static String getMD5(byte[] bArr) {
        try {
            return HexDump.toHex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0021: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:34), block:B:24:0x0021 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getStreamMD5(java.lang.String r5) {
        /*
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
        L15:
            int r5 = r3.read(r0)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            if (r5 <= 0) goto L25
            r4 = 0
            r2.update(r0, r4, r5)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            goto L15
        L20:
            r5 = move-exception
            r1 = r3
            goto L46
        L23:
            r5 = move-exception
            goto L3d
        L25:
            r3.close()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            byte[] r5 = r2.digest()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            java.lang.String r1 = com.tenmeter.smlibrary.utils.HexDump.toHex(r5)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            r3.close()     // Catch: java.lang.Exception -> L34
            goto L45
        L34:
            r5 = move-exception
            r5.printStackTrace()
            goto L45
        L39:
            r5 = move-exception
            goto L46
        L3b:
            r5 = move-exception
            r3 = r1
        L3d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L45
            r3.close()     // Catch: java.lang.Exception -> L34
        L45:
            return r1
        L46:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r0 = move-exception
            r0.printStackTrace()
        L50:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.MD5.getStreamMD5(java.lang.String):java.lang.String");
    }

    public static String getStringMD5(String str) {
        if (str != null && str.trim().length() >= 1) {
            try {
                return getMD5(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return null;
    }
}
