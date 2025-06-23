package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.aq;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aCW;
    private final com.kwad.sdk.core.videocache.b.b aCX;
    private n aDu;
    private HttpURLConnection aDv;
    private InputStream aDw;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aCW = (com.kwad.sdk.core.videocache.d.c) aq.checkNotNull(cVar);
        this.aCX = (com.kwad.sdk.core.videocache.b.b) aq.checkNotNull(bVar);
        n eT = cVar.eT(str);
        this.aDu = eT == null ? new n(str, O0Xx.f12378xXxxox0I, l.eR(str)) : eT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void Hh() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.e.c.d("HttpUrlSource", "Read content info from " + this.aDu.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(0L, 10000);
                try {
                    long d = d(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    n nVar = new n(this.aDu.url, d, contentType);
                    this.aDu = nVar;
                    this.aCW.a(nVar.url, nVar);
                    com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aDu);
                    r0 = httpURLConnection;
                } catch (IOException unused) {
                    com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aDu.url);
                    r0 = httpURLConnection;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.a(r0);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r0);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r0);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.a(r0);
    }

    private void Hj() {
        n eT;
        com.kwad.sdk.core.videocache.d.c cVar = this.aCW;
        if (cVar != null && (cVar instanceof com.kwad.sdk.core.videocache.d.b) && (eT = cVar.eT(getUrl())) != null && !TextUtils.isEmpty(eT.aDL) && eT.aDK != O0Xx.f12378xXxxox0I) {
            this.aDu = eT;
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long d = d(httpURLConnection);
        return i == 200 ? d : i == 206 ? d + j : this.aDu.aDK;
    }

    private HttpURLConnection c(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.aDu.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.e.c.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
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
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Hi() {
        try {
            if (TextUtils.isEmpty(this.aDu.aDL)) {
                Hj();
            }
            if (TextUtils.isEmpty(this.aDu.aDL)) {
                Hh();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aDu.aDL;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aA(long j) {
        try {
            HttpURLConnection c = c(j, -1);
            this.aDv = c;
            String contentType = c.getContentType();
            this.aDw = new BufferedInputStream(this.aDv.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aDv;
            n nVar = new n(this.aDu.url, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.aDu = nVar;
            this.aCW.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.aDu.url + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aDv;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aDu.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        try {
            if (this.aDu.aDK == O0Xx.f12378xXxxox0I) {
                Hj();
            }
            if (this.aDu.aDK == O0Xx.f12378xXxxox0I) {
                Hh();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aDu.aDK;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aDw;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, 1024);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.aDu.url + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.aDu.url, e2);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.aDu.url + ": connection is absent!");
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aDu + ooOOo0oXI.f33074oOoXoXO;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aCX.Hq().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public h(h hVar) {
        this.aDu = hVar.aDu;
        this.aCW = hVar.aCW;
        this.aCX = hVar.aCX;
    }
}
