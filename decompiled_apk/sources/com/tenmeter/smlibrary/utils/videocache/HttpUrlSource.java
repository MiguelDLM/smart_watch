package com.tenmeter.smlibrary.utils.videocache;

import android.text.TextUtils;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.tenmeter.smlibrary.utils.KLog;
import com.tenmeter.smlibrary.utils.videocache.headers.EmptyHeadersInjector;
import com.tenmeter.smlibrary.utils.videocache.headers.HeaderInjector;
import com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage;
import com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes13.dex */
public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fetchContentInfo() throws com.tenmeter.smlibrary.utils.videocache.ProxyCacheException {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read content info from "
            r0.append(r1)
            com.tenmeter.smlibrary.utils.videocache.SourceInfo r1 = r7.sourceInfo
            java.lang.String r1 = r1.url
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tenmeter.smlibrary.utils.KLog.d(r0)
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r7.openConnection(r0, r2)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            long r1 = r7.getContentLength(r0)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r4 = r0.getContentType()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.videocache.SourceInfo r5 = new com.tenmeter.smlibrary.utils.videocache.SourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.videocache.SourceInfo r6 = r7.sourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r6 = r6.url     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r5.<init>(r6, r1, r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r7.sourceInfo = r5     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.videocache.sourcestorage.SourceInfoStorage r1 = r7.sourceInfoStorage     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r2 = r5.url     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r1.put(r2, r5)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r1.<init>()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r2 = "Source info fetched: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.videocache.SourceInfo r2 = r7.sourceInfo     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r1.append(r2)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.KLog.d(r1)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.tenmeter.smlibrary.utils.videocache.ProxyCacheUtils.close(r3)
        L58:
            r0.disconnect()
            goto L83
        L5c:
            r1 = move-exception
            goto L84
        L5e:
            r1 = move-exception
            goto L65
        L60:
            r1 = move-exception
            r0 = r3
            goto L84
        L63:
            r1 = move-exception
            r0 = r3
        L65:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r2.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = "Error fetching info from "
            r2.append(r4)     // Catch: java.lang.Throwable -> L5c
            com.tenmeter.smlibrary.utils.videocache.SourceInfo r4 = r7.sourceInfo     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r4.url     // Catch: java.lang.Throwable -> L5c
            r2.append(r4)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5c
            com.tenmeter.smlibrary.utils.KLog.e(r2, r1)     // Catch: java.lang.Throwable -> L5c
            com.tenmeter.smlibrary.utils.videocache.ProxyCacheUtils.close(r3)
            if (r0 == 0) goto L83
            goto L58
        L83:
            return
        L84:
            com.tenmeter.smlibrary.utils.videocache.ProxyCacheUtils.close(r3)
            if (r0 == 0) goto L8c
            r0.disconnect()
        L8c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection openConnection(long j, int i) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.sourceInfo.url;
        int i2 = 0;
        do {
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
            KLog.d(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            injectCustomHeaders(httpURLConnection, str2);
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
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long contentLength = getContentLength(httpURLConnection);
        if (i != 200) {
            if (i == 206) {
                return contentLength + j;
            }
            return this.sourceInfo.length;
        }
        return contentLength;
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Source
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                KLog.e("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String getMime() throws ProxyCacheException {
        try {
            if (TextUtils.isEmpty(this.sourceInfo.mime)) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Source
    public synchronized long length() throws ProxyCacheException {
        try {
            if (this.sourceInfo.length == O0Xx.f12378xXxxox0I) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.sourceInfo.length;
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Source
    public void open(long j) throws ProxyCacheException {
        try {
            HttpURLConnection openConnection = openConnection(j, -1);
            this.connection = openConnection;
            String contentType = openConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e);
        }
    }

    @Override // com.tenmeter.smlibrary.utils.videocache.Source
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e2);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + ooOOo0oXI.f33074oOoXoXO;
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
        SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new SourceInfo(str, O0Xx.f12378xXxxox0I, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }
}
