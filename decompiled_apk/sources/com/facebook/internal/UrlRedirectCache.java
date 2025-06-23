package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

/* loaded from: classes8.dex */
public final class UrlRedirectCache {

    @OXOo.OOXIXo
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();

    @OXOo.OOXIXo
    private static final String redirectContentTag;

    @OXOo.OOXIXo
    private static final String tag;

    @OXOo.oOoXoXO
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String xoXoI2 = IO.oxoX(UrlRedirectCache.class).xoXoI();
        if (xoXoI2 == null) {
            xoXoI2 = "UrlRedirectCache";
        }
        tag = xoXoI2;
        redirectContentTag = IIX0o.XIxXXX0x0(xoXoI2, "_Redirect");
    }

    private UrlRedirectCache() {
    }

    @XO0OX.x0XOIxOo
    public static final void cacheUriRedirect(@OXOo.oOoXoXO Uri uri, @OXOo.oOoXoXO Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                try {
                    FileLruCache cache = getCache();
                    String uri3 = uri.toString();
                    IIX0o.oO(uri3, "fromUri.toString()");
                    outputStream = cache.openPutStream(uri3, redirectContentTag);
                    String uri4 = uri2.toString();
                    IIX0o.oO(uri4, "toUri.toString()");
                    byte[] bytes = uri4.getBytes(kotlin.text.oxoX.f29581II0xO0);
                    IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes);
                } catch (IOException e) {
                    Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, IIX0o.XIxXXX0x0("IOException when accessing cache: ", e.getMessage()));
                }
            } finally {
                Utility utility = Utility.INSTANCE;
                Utility.closeQuietly(outputStream);
            }
        }
    }

    @XO0OX.x0XOIxOo
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, tag, IIX0o.XIxXXX0x0("clearCache failed ", e.getMessage()));
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            try {
                fileLruCache = urlRedirectFileLruCache;
                if (fileLruCache == null) {
                    fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
                }
                urlRedirectFileLruCache = fileLruCache;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r10) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r5 = r6;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        com.facebook.internal.Logger.Companion.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        return null;
     */
    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri getRedirectedUri(@OXOo.oOoXoXO android.net.Uri r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.String r10 = r10.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.IIX0o.oO(r10, r1)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r1.add(r10)
            com.facebook.internal.FileLruCache r2 = getCache()     // Catch: java.lang.Throwable -> L9d java.io.IOException -> L9f
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L9d java.io.IOException -> L9f
            java.io.InputStream r3 = r2.get(r10, r3)     // Catch: java.lang.Throwable -> L9d java.io.IOException -> L9f
            r4 = 0
            r5 = r0
            r6 = 0
        L23:
            if (r3 == 0) goto L8b
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
            r3 = 128(0x80, float:1.8E-43)
            char[] r5 = new char[r3]     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r7.<init>()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
        L37:
            if (r8 <= 0) goto L48
            r7.append(r5, r4, r8)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            goto L37
        L41:
            r10 = move-exception
            r0 = r6
            goto Lb7
        L45:
            r10 = move-exception
            r5 = r6
            goto La1
        L48:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            com.facebook.internal.Utility.closeQuietly(r6)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r3 = r7.toString()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r5 = "urlBuilder.toString()"
            kotlin.jvm.internal.IIX0o.oO(r3, r5)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            boolean r5 = r1.contains(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r7 = 1
            if (r5 == 0) goto L77
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r10)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            if (r1 == 0) goto L67
            r5 = r6
            r6 = 1
            goto L8b
        L67:
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r2 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r3 = "A loop detected in UrlRedirectCache"
            r4 = 6
            r10.log(r1, r4, r2, r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            com.facebook.internal.Utility.closeQuietly(r6)
            return r0
        L77:
            r1.add(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r10 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.InputStream r10 = r2.get(r3, r10)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r5 = r6
            r6 = 1
            r9 = r3
            r3 = r10
            r10 = r9
            goto L23
        L86:
            r10 = move-exception
            r0 = r5
            goto Lb7
        L89:
            r10 = move-exception
            goto La1
        L8b:
            if (r6 == 0) goto L97
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r5)
            return r10
        L97:
            com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r5)
            goto Lb6
        L9d:
            r10 = move-exception
            goto Lb7
        L9f:
            r10 = move-exception
            r5 = r0
        La1:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion     // Catch: java.lang.Throwable -> L86
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "IOException when accessing cache: "
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L86
            java.lang.String r10 = kotlin.jvm.internal.IIX0o.XIxXXX0x0(r4, r10)     // Catch: java.lang.Throwable -> L86
            r4 = 4
            r1.log(r2, r4, r3, r10)     // Catch: java.lang.Throwable -> L86
            goto L97
        Lb6:
            return r0
        Lb7:
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }
}
