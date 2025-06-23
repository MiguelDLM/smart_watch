package com.alibaba.sdk.android.oss.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
    private static final int BUFFER_SIZE = 4096;

    public static byte[] readStreamAsBytesArray(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                safeClose((OutputStream) byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readStreamAsString(java.io.InputStream r5, java.lang.String r6) throws java.io.IOException {
        /*
            if (r5 != 0) goto L_0x0005
            java.lang.String r5 = ""
            return r5
        L_0x0005:
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            r1 = 4096(0x1000, float:5.74E-42)
            char[] r1 = new char[r1]
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0035 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0035 }
            r3.<init>(r4)     // Catch:{ all -> 0x0035 }
        L_0x0019:
            int r6 = r3.read(r1)     // Catch:{ all -> 0x0024 }
            if (r6 <= 0) goto L_0x0027
            r2 = 0
            r0.write(r1, r2, r6)     // Catch:{ all -> 0x0024 }
            goto L_0x0019
        L_0x0024:
            r6 = move-exception
            r2 = r3
            goto L_0x0036
        L_0x0027:
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0024 }
            safeClose((java.io.InputStream) r5)
            r3.close()
            r0.close()
            return r6
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            safeClose((java.io.InputStream) r5)
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            r0.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.IOUtils.readStreamAsString(java.io.InputStream, java.lang.String):java.lang.String");
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] readStreamAsBytesArray(InputStream inputStream, int i) throws IOException {
        int read;
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            long j2 = (long) i;
            if (j >= j2 || (read = inputStream.read(bArr, 0, Math.min(2048, (int) (j2 - j)))) <= -1) {
                byteArrayOutputStream.flush();
                safeClose((OutputStream) byteArrayOutputStream);
            } else {
                byteArrayOutputStream.write(bArr, 0, read);
                j += (long) read;
            }
        }
        byteArrayOutputStream.flush();
        safeClose((OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
