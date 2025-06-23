package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector;
import com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.commons.text.ooOOo0oXI;

public class HttpUrlSource implements Source {
    private static final Logger LOG = LoggerFactory.getLogger("HttpUrlSource");
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchContentInfo() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        /*
            r8 = this;
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r0 = LOG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r2 = r8.sourceInfo
            java.lang.String r2 = r2.url
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.debug(r1)
            r1 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r1 = r8.openConnection(r1, r3)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            long r2 = r8.getContentLength(r1)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r5 = r1.getContentType()     // Catch:{ IOException -> 0x0068 }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ IOException -> 0x0068 }
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r6 = new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo     // Catch:{ IOException -> 0x0068 }
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r7 = r8.sourceInfo     // Catch:{ IOException -> 0x0068 }
            java.lang.String r7 = r7.url     // Catch:{ IOException -> 0x0068 }
            r6.<init>(r7, r2, r5)     // Catch:{ IOException -> 0x0068 }
            r8.sourceInfo = r6     // Catch:{ IOException -> 0x0068 }
            com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage r2 = r8.sourceInfoStorage     // Catch:{ IOException -> 0x0068 }
            java.lang.String r3 = r6.url     // Catch:{ IOException -> 0x0068 }
            r2.put(r3, r6)     // Catch:{ IOException -> 0x0068 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0068 }
            r2.<init>()     // Catch:{ IOException -> 0x0068 }
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch:{ IOException -> 0x0068 }
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r3 = r8.sourceInfo     // Catch:{ IOException -> 0x0068 }
            r2.append(r3)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0068 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ IOException -> 0x0068 }
            r0.debug(r2)     // Catch:{ IOException -> 0x0068 }
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r4)
        L_0x0062:
            r1.disconnect()
            goto L_0x008f
        L_0x0066:
            r0 = move-exception
            goto L_0x0090
        L_0x0068:
            r0 = move-exception
            goto L_0x006f
        L_0x006a:
            r0 = move-exception
            r1 = r4
            goto L_0x0090
        L_0x006d:
            r0 = move-exception
            r1 = r4
        L_0x006f:
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r2 = LOG     // Catch:{ all -> 0x0066 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r3.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = "Error fetching info from "
            r3.append(r5)     // Catch:{ all -> 0x0066 }
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r5 = r8.sourceInfo     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = r5.url     // Catch:{ all -> 0x0066 }
            r3.append(r5)     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0066 }
            r2.error(r3, r0)     // Catch:{ all -> 0x0066 }
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r4)
            if (r1 == 0) goto L_0x008f
            goto L_0x0062
        L_0x008f:
            return
        L_0x0090:
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r4)
            if (r1 == 0) goto L_0x0098
            r1.disconnect()
        L_0x0098:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry next : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    private HttpURLConnection openConnection(long j, int i) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.sourceInfo.url;
        int i2 = 0;
        do {
            Logger logger = LOG;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            logger.debug(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            injectCustomHeaders(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
                z = true;
            } else {
                z = false;
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
        if (i == 200) {
            return contentLength;
        }
        if (i == 206) {
            return contentLength + j;
        }
        return this.sourceInfo.length;
    }

    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (ArrayIndexOutOfBoundsException e2) {
                LOG.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e2);
            }
        }
    }

    public synchronized String getMime() throws ProxyCacheException {
        try {
            if (TextUtils.isEmpty(this.sourceInfo.mime)) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    public synchronized long length() throws ProxyCacheException {
        try {
            if (this.sourceInfo.length == O0Xx.f30774xXxxox0I) {
                fetchContentInfo();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.sourceInfo.length;
    }

    public void open(long j) throws ProxyCacheException {
        try {
            HttpURLConnection openConnection = openConnection(j, -1);
            this.connection = openConnection;
            String contentType = openConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo2 = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo2;
            this.sourceInfoStorage.put(sourceInfo2.url, sourceInfo2);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e);
        }
    }

    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                return inputStream2.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e2);
            }
        } else {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + ooOOo0oXI.f22054oOoXoXO;
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage2) {
        this(str, sourceInfoStorage2, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage2, HeaderInjector headerInjector2) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage2);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector2);
        SourceInfo sourceInfo2 = sourceInfoStorage2.get(str);
        this.sourceInfo = sourceInfo2 == null ? new SourceInfo(str, O0Xx.f30774xXxxox0I, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo2;
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }
}
