package com.baidu.mshield.b.f;

import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes7.dex */
public class b {
    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        com.baidu.mshield.b.c.a.a(th);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return new Certificate[0];
                    } catch (Throwable th2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th2;
                    }
                }
            } while (bufferedInputStream2.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream2.close();
            } catch (IOException unused3) {
            }
            return certificates;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static PublicKey a(Signature signature) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            try {
                PublicKey publicKey = certificateFactory.generateCertificate(byteArrayInputStream).getPublicKey();
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused) {
                }
                return publicKey;
            } catch (Throwable th) {
                th = th;
                try {
                    com.baidu.mshield.b.c.a.a(th);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005b, code lost:
    
        if (r3.length == r4.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005e, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.PublicKey a(java.lang.String r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L87
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L87
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L87
            java.util.Enumeration r10 = r2.entries()     // Catch: java.lang.Throwable -> L61
            r3 = r1
        L16:
            boolean r4 = r10.hasMoreElements()     // Catch: java.lang.Throwable -> L61
            r5 = 0
            if (r4 == 0) goto L74
            java.lang.Object r4 = r10.nextElement()     // Catch: java.lang.Throwable -> L61
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch: java.lang.Throwable -> L61
            boolean r6 = r4.isDirectory()     // Catch: java.lang.Throwable -> L61
            if (r6 == 0) goto L2a
            goto L16
        L2a:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L61
            java.lang.String r7 = "META-INF/"
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L61
            if (r6 == 0) goto L37
            goto L16
        L37:
            java.security.cert.Certificate[] r4 = a(r2, r4, r0)     // Catch: java.lang.Throwable -> L61
            if (r4 == 0) goto L6d
            int r6 = r4.length     // Catch: java.lang.Throwable -> L61
            if (r6 != 0) goto L41
            goto L6d
        L41:
            if (r3 != 0) goto L45
            r3 = r4
            goto L16
        L45:
            r6 = 0
        L46:
            int r7 = r3.length     // Catch: java.lang.Throwable -> L61
            if (r6 >= r7) goto L16
            r7 = 0
        L4a:
            int r8 = r4.length     // Catch: java.lang.Throwable -> L61
            if (r7 >= r8) goto L66
            r8 = r3[r6]     // Catch: java.lang.Throwable -> L61
            if (r8 == 0) goto L63
            r9 = r4[r7]     // Catch: java.lang.Throwable -> L61
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Throwable -> L61
            if (r8 == 0) goto L63
            int r7 = r3.length     // Catch: java.lang.Throwable -> L61
            int r8 = r4.length     // Catch: java.lang.Throwable -> L61
            if (r7 == r8) goto L5e
            goto L66
        L5e:
            int r6 = r6 + 1
            goto L46
        L61:
            goto L89
        L63:
            int r7 = r7 + 1
            goto L4a
        L66:
            r2.close()     // Catch: java.lang.Throwable -> L61
            r2.close()     // Catch: java.io.IOException -> L6c
        L6c:
            return r1
        L6d:
            r2.close()     // Catch: java.lang.Throwable -> L61
            r2.close()     // Catch: java.io.IOException -> L73
        L73:
            return r1
        L74:
            if (r3 == 0) goto L83
            int r10 = r3.length     // Catch: java.lang.Throwable -> L61
            if (r10 <= 0) goto L83
            r10 = r3[r5]     // Catch: java.lang.Throwable -> L61
            java.security.PublicKey r10 = r10.getPublicKey()     // Catch: java.lang.Throwable -> L61
            r2.close()     // Catch: java.io.IOException -> L82
        L82:
            return r10
        L83:
            r2.close()     // Catch: java.io.IOException -> L86
        L86:
            return r1
        L87:
            r2 = r1
        L89:
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.io.IOException -> L8e
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.b.f.b.a(java.lang.String):java.security.PublicKey");
    }
}
