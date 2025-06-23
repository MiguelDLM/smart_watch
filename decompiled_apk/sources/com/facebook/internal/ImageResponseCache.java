package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ImageResponseCache {

    @OXOo.OOXIXo
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();

    @OXOo.OOXIXo
    private static final String TAG;
    private static FileLruCache imageCache;

    /* loaded from: classes8.dex */
    public static final class BufferedHttpInputStream extends BufferedInputStream {

        @OXOo.OOXIXo
        private HttpURLConnection connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(@OXOo.oOoXoXO InputStream inputStream, @OXOo.OOXIXo HttpURLConnection connection) {
            super(inputStream, 8192);
            IIX0o.x0xO0oo(connection, "connection");
            this.connection = connection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(this.connection);
        }

        @OXOo.OOXIXo
        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(@OXOo.OOXIXo HttpURLConnection httpURLConnection) {
            IIX0o.x0xO0oo(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }
    }

    static {
        String simpleName = ImageResponseCache.class.getSimpleName();
        IIX0o.oO(simpleName, "ImageResponseCache::class.java.simpleName");
        TAG = simpleName;
    }

    private ImageResponseCache() {
    }

    @XO0OX.x0XOIxOo
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, IIX0o.XIxXXX0x0("clearCache failed ", e.getMessage()));
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            try {
                if (imageCache == null) {
                    imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
                }
                fileLruCache = imageCache;
                if (fileLruCache == null) {
                    IIX0o.XOxIOxOx("imageCache");
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileLruCache;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final InputStream getCachedImageStream(@OXOo.oOoXoXO Uri uri) {
        if (uri == null || !INSTANCE.isCDNURL(uri)) {
            return null;
        }
        try {
            FileLruCache cache = getCache();
            String uri2 = uri.toString();
            IIX0o.oO(uri2, "uri.toString()");
            return FileLruCache.get$default(cache, uri2, null, 2, null);
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final InputStream interceptAndCacheImageStream(@OXOo.OOXIXo HttpURLConnection connection) throws IOException {
        IIX0o.x0xO0oo(connection, "connection");
        if (connection.getResponseCode() == 200) {
            Uri parse = Uri.parse(connection.getURL().toString());
            InputStream inputStream = connection.getInputStream();
            try {
                if (INSTANCE.isCDNURL(parse)) {
                    FileLruCache cache = getCache();
                    String uri = parse.toString();
                    IIX0o.oO(uri, "uri.toString()");
                    return cache.interceptAndPut(uri, new BufferedHttpInputStream(inputStream, connection));
                }
                return inputStream;
            } catch (IOException unused) {
                return inputStream;
            }
        }
        return null;
    }

    private final boolean isCDNURL(Uri uri) {
        String host;
        if (uri == null || (host = uri.getHost()) == null || (!IIX0o.Oxx0IOOO(host, "fbcdn.net") && !kotlin.text.OxI.XO0o(host, ".fbcdn.net", false, 2, null) && (!kotlin.text.OxI.IOOoXo0Ix(host, "fbcdn", false, 2, null) || !kotlin.text.OxI.XO0o(host, ".akamaihd.net", false, 2, null)))) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public final String getTAG() {
        return TAG;
    }
}
