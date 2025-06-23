package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileCache;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    private String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean isUseCache(GetRequest getRequest) throws ProxyCacheException {
        boolean z;
        long length = this.source.length();
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        long available = this.cache.available();
        if (!z || !getRequest.partial || ((float) getRequest.rangeOffset) <= ((float) available) + (((float) length) * 0.2f)) {
            return true;
        }
        return false;
    }

    private String newResponseHeaders(GetRequest getRequest) throws IOException, ProxyCacheException {
        long j;
        boolean z;
        long j2;
        boolean z2;
        String str;
        String str2;
        String str3;
        String mime = this.source.getMime();
        boolean isEmpty = TextUtils.isEmpty(mime);
        if (this.cache.isCompleted()) {
            j = this.cache.available();
        } else {
            j = this.source.length();
        }
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = getRequest.partial;
        if (z3) {
            j2 = j - getRequest.rangeOffset;
        } else {
            j2 = j;
        }
        if (!z || !z3) {
            z2 = false;
        } else {
            z2 = true;
        }
        StringBuilder sb = new StringBuilder();
        if (getRequest.partial) {
            str = "HTTP/1.1 206 PARTIAL CONTENT\n";
        } else {
            str = "HTTP/1.1 200 OK\n";
        }
        sb.append(str);
        sb.append("Accept-Ranges: bytes\n");
        String str4 = "";
        if (z) {
            str2 = format("Content-Length: %d\n", Long.valueOf(j2));
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (z2) {
            str3 = format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.rangeOffset), Long.valueOf(j - 1), Long.valueOf(j));
        } else {
            str3 = str4;
        }
        sb.append(str3);
        if (!isEmpty) {
            str4 = format("Content-Type: %s\n", mime);
        }
        sb.append(str4);
        sb.append("\n");
        return sb.toString();
    }

    private void responseWithCache(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        Log.e("开始读取缓存数据", "缓存数据读取");
        byte[] bArr = new byte[8192];
        while (true) {
            int read = read(bArr, j, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void responseWithoutCache(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.source);
        try {
            httpUrlSource.open((long) ((int) j));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = httpUrlSource.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    httpUrlSource.close();
                    return;
                }
            }
        } catch (Throwable th) {
            httpUrlSource.close();
            throw th;
        }
    }

    public void onCachePercentsAvailableChanged(int i) {
        CacheListener cacheListener = this.listener;
        if (cacheListener != null) {
            cacheListener.onCacheAvailable(this.cache.file, this.source.getUrl(), i);
        }
    }

    public void processRequest(GetRequest getRequest, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes(StandardCharsets.UTF_8));
        long j = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j);
        } else {
            responseWithoutCache(bufferedOutputStream, j);
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listener = cacheListener;
    }
}
