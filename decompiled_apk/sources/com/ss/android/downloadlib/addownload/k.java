package com.ss.android.downloadlib.addownload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final JSONObject f26054a = new JSONObject();
    private static Context b;
    private static com.ss.android.download.api.config.g c;
    private static com.ss.android.download.api.config.c d;
    private static com.ss.android.download.api.config.l e;
    private static com.ss.android.download.api.config.h f;
    private static com.ss.android.download.api.config.i g;
    private static com.ss.android.download.api.config.j h;
    private static com.ss.android.download.api.model.a i;
    private static com.ss.android.download.api.config.b j;
    private static com.ss.android.socialbase.appdownloader.c.h k;
    private static com.ss.android.download.api.config.d l;
    private static com.ss.android.download.api.config.e m;
    private static o n;
    private static com.ss.android.download.api.config.k o;
    private static u p;
    private static com.ss.android.download.api.config.n q;
    private static com.ss.android.download.api.config.m r;
    private static p s;
    private static com.ss.android.download.api.b.a t;
    private static q u;
    private static s v;

    public static void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.c c() {
        if (d == null) {
            d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.k.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return d;
    }

    @NonNull
    public static com.ss.android.download.api.config.l d() {
        if (e == null) {
            e = new com.ss.android.download.api.a.a();
        }
        return e;
    }

    public static com.ss.android.download.api.config.h e() {
        return f;
    }

    @NonNull
    public static com.ss.android.download.api.config.i f() {
        if (g == null) {
            g = new com.ss.android.download.api.a.b();
        }
        return g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h g() {
        if (k == null) {
            k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.k.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return k;
    }

    public static o h() {
        return n;
    }

    @NonNull
    public static p i() {
        if (s == null) {
            s = new p() { // from class: com.ss.android.downloadlib.addownload.k.3
                @Override // com.ss.android.download.api.config.p
                public void a(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return s;
    }

    @NonNull
    public static JSONObject j() {
        com.ss.android.download.api.config.j jVar = h;
        if (jVar != null && jVar.a() != null) {
            return h.a();
        }
        return f26054a;
    }

    @NonNull
    public static com.ss.android.download.api.model.a k() {
        if (i == null) {
            i = new a.C1034a().a();
        }
        return i;
    }

    public static com.ss.android.download.api.config.m l() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b m() {
        return j;
    }

    @Nullable
    public static com.ss.android.download.api.config.n n() {
        return q;
    }

    public static String o() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.d p() {
        return l;
    }

    public static com.ss.android.download.api.config.e q() {
        return m;
    }

    public static com.ss.android.download.api.config.k r() {
        return o;
    }

    @NonNull
    public static q s() {
        return u;
    }

    public static u t() {
        return p;
    }

    @NonNull
    public static com.ss.android.download.api.b.a u() {
        if (t == null) {
            t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.k.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    @NonNull
    public static s v() {
        if (v == null) {
            v = new s() { // from class: com.ss.android.downloadlib.addownload.k.5
                @Override // com.ss.android.download.api.config.s
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return v;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 > 29) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        return a().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String w() {
        /*
            android.content.Context r0 = a()     // Catch: java.lang.Throwable -> L52
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> L52
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Throwable -> L52
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L52
            r2 = 29
            if (r1 < r2) goto L29
            if (r0 != r2) goto L18
            boolean r1 = com.bumptech.glide.load.model.stream.oIX0oI.oIX0oI()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L1a
        L18:
            if (r0 <= r2) goto L29
        L1a:
            android.content.Context r0 = a()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L52
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L52
            return r0
        L29:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            org.json.JSONObject r1 = j()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "default_save_dir_name"
            java.lang.String r3 = "ByteDownload"
            java.lang.String r1 = r1.optString(r2, r3)     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            return r0
        L52:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.k.w():java.lang.String");
    }

    public static boolean x() {
        if (c != null && f != null && h != null && j != null && u != null) {
            return true;
        }
        return false;
    }

    public static com.ss.android.download.api.config.g b() {
        return c;
    }

    public static Context a() {
        Context context = b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        c = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.l lVar) {
        e = lVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        g = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.j jVar) {
        h = jVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        j = bVar;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(q qVar) {
        u = qVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }
}
