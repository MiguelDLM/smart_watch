package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.utils.aq;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aCW;
    private final com.kwad.sdk.core.videocache.b.b aCX;
    private OkHttpClient aDB = new OkHttpClient();
    private n aDu;
    private InputStream aDw;

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aCW = (com.kwad.sdk.core.videocache.d.c) aq.checkNotNull(cVar);
        this.aCX = (com.kwad.sdk.core.videocache.b.b) aq.checkNotNull(bVar);
        n eT = cVar.eT(str);
        this.aDu = eT == null ? new n(str, O0Xx.f12378xXxxox0I, l.eR(str)) : eT;
    }

    private void Hh() {
        Response response = null;
        try {
            try {
                response = du(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aDu.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response != null && response.isSuccessful()) {
                n nVar = new n(this.aDu.url, c(response), response.header("Content-Type"));
                this.aDu = nVar;
                this.aCW.a(nVar.url, nVar);
                com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aDu);
                if (response.body() == null) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
                return;
            }
            throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
            throw th;
        }
    }

    private void Hj() {
        n eT;
        com.kwad.sdk.core.videocache.d.c cVar = this.aCW;
        if (cVar != null && (cVar instanceof com.kwad.sdk.core.videocache.d.b) && (eT = cVar.eT(getUrl())) != null && !TextUtils.isEmpty(eT.aDL) && eT.aDK != O0Xx.f12378xXxxox0I) {
            this.aDu = eT;
        }
    }

    private long a(Response response, long j) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        if (code == 200) {
            return contentLength;
        }
        if (code == 206) {
            return contentLength + j;
        }
        return this.aDu.aDK;
    }

    private static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response d(long j, int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aDB.newBuilder();
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aDB = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader("Range", "bytes=" + j + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
            execute = this.aDB.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
    }

    private Response du(int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(10000L, timeUnit);
        newBuilder.readTimeout(10000L, timeUnit);
        newBuilder.writeTimeout(10000L, timeUnit);
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aDB = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aDB.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
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
            Response d = d(j, -1);
            String mediaType = d.body().contentType().toString();
            long a2 = a(d, j);
            this.aDw = new BufferedInputStream(d.body().byteStream(), 1024);
            n nVar = new n(this.aDu.url, a2, mediaType);
            this.aDu = nVar;
            this.aCW.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aDw);
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

    public j(j jVar) {
        this.aDu = jVar.aDu;
        this.aCW = jVar.aCW;
        this.aCX = jVar.aCX;
    }
}
