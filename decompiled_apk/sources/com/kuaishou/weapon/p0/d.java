package com.kuaishou.weapon.p0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes11.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18376a = 2048;
    public static final String b = ".gz";

    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] bArr3 = null;
        byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    a(byteArrayInputStream, byteArrayOutputStream2);
                    bArr3 = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArrayInputStream.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused2) {
                        return bArr3;
                    }
                } catch (Throwable unused3) {
                    byte[] bArr4 = bArr3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    bArr2 = bArr4;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return bArr2;
                }
            } catch (Throwable unused6) {
                bArr2 = null;
            }
        } catch (Throwable unused7) {
            bArr2 = null;
            byteArrayInputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] b(byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L27
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L27
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L25
            r2.<init>()     // Catch: java.lang.Throwable -> L25
            b(r1, r2)     // Catch: java.lang.Throwable -> L22
            byte[] r3 = r2.toByteArray()     // Catch: java.lang.Throwable -> L22
            r2.flush()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Throwable -> L22
            r1.close()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Exception -> L1e
        L1e:
            r1.close()     // Catch: java.lang.Exception -> L33
            goto L33
        L22:
            r0 = r2
            goto L29
        L25:
            goto L29
        L27:
            r1 = r0
        L29:
            if (r0 == 0) goto L30
            r0.close()     // Catch: java.lang.Exception -> L2f
            goto L30
        L2f:
        L30:
            if (r1 == 0) goto L33
            goto L1e
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.d.b(byte[]):byte[]");
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    gZIPInputStream.close();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Exception unused3) {
            gZIPInputStream2 = gZIPInputStream;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (Exception unused4) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable unused) {
            gZIPOutputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                    return;
                }
            }
        } catch (Throwable unused2) {
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (Exception unused3) {
                }
            }
        }
    }
}
