package com.kuaishou.weapon.p0;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes11.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18320a = "AES/CBC/NoPadding";
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    private static final String d = "AES/CBC/PKCS5Padding";
    private static final String e = "AES";
    private static final String f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), e);
        Cipher cipher = Cipher.getInstance(d);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), e);
        Cipher cipher = Cipher.getInstance(d);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        if (r8 == null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = -1
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> La3
            r1.<init>(r9)     // Catch: java.lang.Throwable -> La3
            int r9 = r1.length()     // Catch: java.lang.Throwable -> La3
            r2 = 0
            r3 = 16
            if (r9 >= r3) goto L2a
            int r9 = r1.length()     // Catch: java.lang.Throwable -> La3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r4.<init>(r1)     // Catch: java.lang.Throwable -> La3
            r1 = 0
        L19:
            int r5 = 16 - r9
            if (r1 >= r5) goto L25
            java.lang.String r5 = "0"
            r4.append(r5)     // Catch: java.lang.Throwable -> La3
            int r1 = r1 + 1
            goto L19
        L25:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> La3
            goto L34
        L2a:
            int r9 = r1.length()     // Catch: java.lang.Throwable -> La3
            if (r9 <= r3) goto L34
            java.lang.String r1 = r1.substring(r2, r3)     // Catch: java.lang.Throwable -> La3
        L34:
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8e
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8b
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L8b
            javax.crypto.spec.SecretKeySpec r8 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L5a
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "AES"
            r8.<init>(r1, r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L5a
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L5a
            r6 = 0
        L53:
            if (r6 >= r3) goto L5c
            r5[r6] = r2     // Catch: java.lang.Throwable -> L5a
            int r6 = r6 + 1
            goto L53
        L5a:
            goto L89
        L5c:
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L5a
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L5a
            r5 = 2
            r1.init(r5, r8, r3)     // Catch: java.lang.Throwable -> L5a
            javax.crypto.CipherInputStream r8 = new javax.crypto.CipherInputStream     // Catch: java.lang.Throwable -> L5a
            r8.<init>(r4, r1)     // Catch: java.lang.Throwable -> L5a
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch: java.lang.Throwable -> L78
        L6e:
            int r1 = r8.read(r9)     // Catch: java.lang.Throwable -> L78
            if (r1 == r0) goto L7a
            r7.write(r9, r2, r1)     // Catch: java.lang.Throwable -> L78
            goto L6e
        L78:
            goto L87
        L7a:
            r8.close()     // Catch: java.lang.Throwable -> L78
            r7.close()     // Catch: java.io.IOException -> L80 java.lang.Throwable -> La3
        L80:
            r4.close()     // Catch: java.io.IOException -> L83 java.lang.Throwable -> La3
        L83:
            r8.close()     // Catch: java.io.IOException -> La2 java.lang.Throwable -> La3
            goto La2
        L87:
            r9 = r7
            goto L91
        L89:
            r8 = r9
            goto L87
        L8b:
            r8 = r9
            goto L91
        L8e:
            r8 = r9
            r4 = r8
        L91:
            if (r9 == 0) goto L98
            r9.close()     // Catch: java.io.IOException -> L97 java.lang.Throwable -> La3
            goto L98
        L97:
        L98:
            if (r4 == 0) goto L9f
            r4.close()     // Catch: java.io.IOException -> L9e java.lang.Throwable -> La3
            goto L9f
        L9e:
        L9f:
            if (r8 == 0) goto La2
            goto L83
        La2:
            return r2
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.b.c(java.lang.String, java.lang.String, byte[]):int");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, e);
            Cipher cipher = Cipher.getInstance(d);
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
            return null;
        }
    }
}
