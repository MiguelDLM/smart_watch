package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: classes11.dex */
final class t {
    private static final char[] aom = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static String getFileMD5(File file) {
        Throwable th;
        ?? r7;
        Exception e;
        DigestInputStream digestInputStream;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
                try {
                    byte[] bArr = new byte[1024];
                    for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                    }
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (byte b : digest) {
                        int i = b & 255;
                        if (i < 16) {
                            sb.append("0");
                        }
                        sb.append(Integer.toHexString(i));
                    }
                    String sb2 = sb.toString();
                    b(digestInputStream);
                    return sb2;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    b(digestInputStream);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                r7 = file;
                b(r7);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r7 = 0;
            b(r7);
            throw th;
        }
    }
}
