package com.kwad.sdk.api.loader;

import com.huawei.openalliance.ad.utils.bc;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.sifli.siflidfu.constants.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes11.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(java.lang.String r6, java.io.File r7) {
        /*
            r0 = 0
            boolean r1 = r7.exists()     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto Lf
            com.kwad.sdk.api.loader.i.j(r7)     // Catch: java.lang.Throwable -> Lb
            goto Lf
        Lb:
            r6 = move-exception
            r7 = r0
        Ld:
            r1 = r7
            goto L4b
        Lf:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb
            r2 = 0
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> Lb
            java.net.HttpURLConnection r6 = cl(r6)     // Catch: java.lang.Throwable -> L47
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L41
            java.io.InputStream r3 = r6.getInputStream()     // Catch: java.lang.Throwable -> L41
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L41
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L31
        L26:
            int r3 = r7.read(r0)     // Catch: java.lang.Throwable -> L31
            r4 = -1
            if (r3 == r4) goto L37
            r1.write(r0, r2, r3)     // Catch: java.lang.Throwable -> L31
            goto L26
        L31:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r0
        L35:
            r0 = r5
            goto L4b
        L37:
            closeQuietly(r1)
            closeQuietly(r7)
            r6.disconnect()
            return
        L41:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r0
            goto L35
        L47:
            r6 = move-exception
            r7 = r0
            r0 = r1
            goto Ld
        L4b:
            closeQuietly(r0)
            closeQuietly(r7)
            if (r1 == 0) goto L56
            r1.disconnect()
        L56:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.j.c(java.lang.String, java.io.File):void");
    }

    private static HttpURLConnection cl(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", bc.Code);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(Timeout.SIFLI_DFU_FILE_COMMAND_TIMEOUT);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
