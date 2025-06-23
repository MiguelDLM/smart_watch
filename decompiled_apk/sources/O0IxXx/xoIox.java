package O0IxXx;

import android.text.TextUtils;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.octopus.ad.internal.b.l;
import com.octopus.ad.internal.b.p;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes11.dex */
public class xoIox implements x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public IXxxXO f1249I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final XO f1250II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public InputStream f1251X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xxOXOOoIX.I0Io f1252oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public HttpURLConnection f1253oxoX;

    public xoIox(String str) {
        this(str, xxOXOOoIX.oxoX.oIX0oI());
    }

    public final HttpURLConnection I0Io(long j, int i) throws IOException, p {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f1249I0Io.f1223oIX0oI;
        int i2 = 0;
        do {
            String str3 = com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(str3, sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            oxoX(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 301 && responseCode != 302 && responseCode != 303) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new p("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    public final long II0xO0(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long oIX0oI2 = oIX0oI(httpURLConnection);
        if (i != 200) {
            if (i == 206) {
                return oIX0oI2 + j;
            }
            return this.f1249I0Io.f1222II0xO0;
        }
        return oIX0oI2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Oxx0IOOO() throws com.octopus.ad.internal.b.p {
        /*
            r7 = this;
            java.lang.String r0 = com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            O0IxXx.IXxxXO r2 = r7.f1249I0Io
            java.lang.String r2 = r2.f1223oIX0oI
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(r0, r1)
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r7.I0Io(r0, r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            long r1 = r7.oIX0oI(r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r4 = r0.getContentType()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            O0IxXx.IXxxXO r5 = new O0IxXx.IXxxXO     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            O0IxXx.IXxxXO r6 = r7.f1249I0Io     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r6 = r6.f1223oIX0oI     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r5.<init>(r6, r1, r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r7.f1249I0Io = r5     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            xxOXOOoIX.I0Io r1 = r7.f1252oIX0oI     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r2 = r5.f1223oIX0oI     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r1.oIX0oI(r2, r5)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r1 = com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r4 = "Source info fetched: "
            r2.append(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            O0IxXx.IXxxXO r4 = r7.f1249I0Io     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r2.append(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(r1, r2)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            O0IxXx.oO.I0Io(r3)
        L5c:
            r0.disconnect()
            goto L90
        L60:
            r1 = move-exception
            goto L91
        L62:
            r1 = move-exception
            goto L69
        L64:
            r1 = move-exception
            r0 = r3
            goto L91
        L67:
            r1 = move-exception
            r0 = r3
        L69:
            java.lang.String r2 = com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "Error fetching info from "
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            O0IxXx.IXxxXO r5 = r7.f1249I0Io     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r5.f1223oIX0oI     // Catch: java.lang.Throwable -> L60
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L60
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(r2, r1)     // Catch: java.lang.Throwable -> L60
            O0IxXx.oO.I0Io(r3)
            if (r0 == 0) goto L90
            goto L5c
        L90:
            return
        L91:
            O0IxXx.oO.I0Io(r3)
            if (r0 == 0) goto L99
            r0.disconnect()
        L99:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O0IxXx.xoIox.Oxx0IOOO():void");
    }

    public synchronized String X0o0xo() throws p {
        try {
            if (TextUtils.isEmpty(this.f1249I0Io.f1221I0Io)) {
                Oxx0IOOO();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1249I0Io.f1221I0Io;
    }

    public String XO() {
        return this.f1249I0Io.f1223oIX0oI;
    }

    @Override // O0IxXx.x0xO0oo
    public synchronized long a() throws p {
        try {
            if (this.f1249I0Io.f1222II0xO0 == O0Xx.f12378xXxxox0I) {
                Oxx0IOOO();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1249I0Io.f1222II0xO0;
    }

    @Override // O0IxXx.x0xO0oo
    public void b() throws p {
        HttpURLConnection httpURLConnection = this.f1253oxoX;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18693Oxx0xo, "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(" + e.getMessage());
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
        }
    }

    public final long oIX0oI(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    public final void oxoX(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f1250II0xO0.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f1249I0Io + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
    }

    public xoIox(String str, xxOXOOoIX.I0Io i0Io) {
        this(str, i0Io, new oxoX());
    }

    public xoIox(String str, xxOXOOoIX.I0Io i0Io, XO xo2) {
        this.f1252oIX0oI = (xxOXOOoIX.I0Io) ooOOo0oXI.oIX0oI(i0Io);
        this.f1250II0xO0 = (XO) ooOOo0oXI.oIX0oI(xo2);
        IXxxXO a2 = i0Io.a(str);
        this.f1249I0Io = a2 == null ? new IXxxXO(str, O0Xx.f12378xXxxox0I, oO.oIX0oI(str)) : a2;
    }

    @Override // O0IxXx.x0xO0oo
    public void a(long j) throws p {
        try {
            HttpURLConnection I0Io2 = I0Io(j, -1);
            this.f1253oxoX = I0Io2;
            String contentType = I0Io2.getContentType();
            this.f1251X0o0xo = new BufferedInputStream(this.f1253oxoX.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f1253oxoX;
            IXxxXO iXxxXO = new IXxxXO(this.f1249I0Io.f1223oIX0oI, II0xO0(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.f1249I0Io = iXxxXO;
            this.f1252oIX0oI.oIX0oI(iXxxXO.f1223oIX0oI, iXxxXO);
        } catch (IOException e) {
            throw new p("Error opening connection for " + this.f1249I0Io.f1223oIX0oI + " with offset " + j, e);
        }
    }

    public xoIox(xoIox xoiox) {
        this.f1249I0Io = xoiox.f1249I0Io;
        this.f1252oIX0oI = xoiox.f1252oIX0oI;
        this.f1250II0xO0 = xoiox.f1250II0xO0;
    }

    @Override // O0IxXx.x0xO0oo
    public int a(byte[] bArr) throws p {
        InputStream inputStream = this.f1251X0o0xo;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new l("Reading source " + this.f1249I0Io.f1223oIX0oI + " is interrupted", e);
            } catch (IOException e2) {
                throw new p("Error reading data from " + this.f1249I0Io.f1223oIX0oI, e2);
            }
        }
        throw new p("Error reading data from " + this.f1249I0Io.f1223oIX0oI + ": connection is absent!");
    }
}
