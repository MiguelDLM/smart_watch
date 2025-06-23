package com.baidu.mapsdkplatform.comapi.commonutils.a;

import com.baidu.mapsdkplatform.comapi.commonutils.a.c;
import java.io.File;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f6152a;
    private File b;
    private com.baidu.mapsdkplatform.comapi.commonutils.a.a c;
    private c.b d;
    private volatile boolean e = false;

    /* loaded from: classes7.dex */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public b(String str, File file, com.baidu.mapsdkplatform.comapi.commonutils.a.a aVar, c.b bVar) {
        this.f6152a = str;
        this.b = file;
        this.c = aVar;
        this.d = bVar;
    }

    public boolean a() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #5 {IOException -> 0x00cb, blocks: (B:43:0x00c7, B:36:0x00cf), top: B:42:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r3 = r6.f6152a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            boolean r3 = com.baidu.mapapi.http.HttpClient.isHttpsEnable     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            if (r3 == 0) goto L23
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            com.baidu.mapsdkplatform.comapi.commonutils.a.b$a r3 = new com.baidu.mapsdkplatform.comapi.commonutils.a.b$a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r3.<init>()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r2.setHostnameVerifier(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            goto L29
        L1c:
            r0 = move-exception
            r3 = r1
            goto Lc5
        L20:
            r3 = r1
            goto Lae
        L23:
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
        L29:
            java.lang.String r3 = "GET"
            r2.setRequestMethod(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r3 = 10000(0x2710, float:1.4013E-41)
            r2.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r2.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r3 = "Range"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r4.<init>()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r5 = "bytes="
            r4.append(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            com.baidu.mapsdkplatform.comapi.commonutils.a.a r5 = r6.c     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            int r5 = r5.a()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r4.append(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r5 = "-"
            r4.append(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            com.baidu.mapsdkplatform.comapi.commonutils.a.a r5 = r6.c     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r4.append(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            r2.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "Keep-Alive"
            r2.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.io.File r4 = r6.b     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            java.lang.String r5 = "rw"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L20
            com.baidu.mapsdkplatform.comapi.commonutils.a.a r4 = r6.c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            int r4 = r4.a()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            r3.seek(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            int r4 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L86
            r5 = 206(0xce, float:2.89E-43)
            if (r4 != r5) goto L9b
        L86:
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
        L8e:
            int r2 = r1.read(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            r5 = -1
            if (r2 == r5) goto L9b
            r3.write(r4, r0, r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            goto L8e
        L99:
            r0 = move-exception
            goto Lc5
        L9b:
            r2 = 1
            r6.e = r2     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> Lae
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.io.IOException -> La4
            goto La6
        La4:
            r0 = move-exception
            goto Laa
        La6:
            r3.close()     // Catch: java.io.IOException -> La4
            goto Lbf
        Laa:
            r0.printStackTrace()
            goto Lbf
        Lae:
            r6.e = r0     // Catch: java.lang.Throwable -> L99
            com.baidu.mapsdkplatform.comapi.commonutils.a.c$b r0 = r6.d     // Catch: java.lang.Throwable -> L99
            r0.b(r6)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto Lba
            r1.close()     // Catch: java.io.IOException -> La4
        Lba:
            if (r3 == 0) goto Lbf
            r3.close()     // Catch: java.io.IOException -> La4
        Lbf:
            com.baidu.mapsdkplatform.comapi.commonutils.a.c$b r0 = r6.d
            r0.a(r6)
            return
        Lc5:
            if (r1 == 0) goto Lcd
            r1.close()     // Catch: java.io.IOException -> Lcb
            goto Lcd
        Lcb:
            r1 = move-exception
            goto Ld3
        Lcd:
            if (r3 == 0) goto Ld6
            r3.close()     // Catch: java.io.IOException -> Lcb
            goto Ld6
        Ld3:
            r1.printStackTrace()
        Ld6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.a.b.run():void");
    }
}
