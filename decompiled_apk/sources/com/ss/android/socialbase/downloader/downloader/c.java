package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class c {
    private static volatile q A;
    private static volatile com.ss.android.socialbase.downloader.d.b B;
    private static volatile aa C;
    private static volatile com.ss.android.socialbase.downloader.network.f G;
    private static volatile com.ss.android.socialbase.downloader.network.f H;
    private static volatile u I;
    private static int L;
    private static final int M;
    private static final int N;
    private static final int O;
    private static final int P;
    private static int Q;
    private static boolean R;
    private static final List<com.ss.android.socialbase.downloader.depend.k> S;
    private static final List<ab> T;
    private static int U;
    private static boolean V;
    private static boolean W;
    private static r X;
    private static com.ss.android.socialbase.downloader.d.c Y;
    private static volatile boolean Z;

    /* renamed from: a, reason: collision with root package name */
    private static volatile Context f26270a;
    private static volatile j b;
    private static volatile k c;
    private static volatile h d;
    private static volatile af e;
    private static volatile com.ss.android.socialbase.downloader.impls.a f;
    private static volatile o g;
    private static volatile o h;
    private static volatile a i;
    private static volatile IDownloadHttpService j;
    private static volatile com.ss.android.socialbase.downloader.network.h k;
    private static volatile IDownloadHttpService l;
    private static volatile com.ss.android.socialbase.downloader.network.h m;
    private static volatile l n;
    private static volatile ExecutorService o;
    private static volatile ExecutorService p;
    private static volatile ExecutorService q;
    private static volatile ExecutorService r;
    private static volatile ExecutorService s;
    private static volatile ExecutorService t;
    private static volatile ExecutorService u;
    private static volatile ExecutorService v;
    private static volatile ScheduledExecutorService w;
    private static volatile g x;
    private static volatile DownloadReceiver y;
    private static volatile s z;
    private static volatile List<ak> D = new ArrayList();
    private static volatile boolean E = false;
    private static volatile OkHttpClient F = null;
    private static final List<com.ss.android.socialbase.downloader.depend.m> J = new ArrayList();
    private static boolean K = false;

    /* loaded from: classes13.dex */
    public interface a {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public interface InterfaceC1072a {
            void a();
        }

        o a();

        t a(InterfaceC1072a interfaceC1072a);

        m b();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        M = availableProcessors;
        N = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        O = availableProcessors;
        P = availableProcessors;
        Q = 8192;
        S = new ArrayList();
        T = new ArrayList();
        V = true;
        W = false;
        Z = false;
    }

    private c() {
    }

    public static o A() {
        if (h == null) {
            synchronized (c.class) {
                try {
                    if (h == null) {
                        h = i.a();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public static List<com.ss.android.socialbase.downloader.depend.m> B() {
        return J;
    }

    public static k C() {
        if (c == null) {
            synchronized (c.class) {
                try {
                    if (c == null) {
                        c = new com.ss.android.socialbase.downloader.impls.i();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static com.ss.android.socialbase.downloader.impls.a D() {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new com.ss.android.socialbase.downloader.impls.e();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public static int E() {
        return U;
    }

    @NonNull
    public static JSONObject F() {
        if (C != null && C.a() != null) {
            return C.a();
        }
        return com.ss.android.socialbase.downloader.constants.e.i;
    }

    public static void G() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.c)) {
            com.ss.android.socialbase.downloader.constants.e.c = "oppo";
            com.ss.android.socialbase.downloader.constants.e.b = com.ss.android.socialbase.downloader.constants.e.c.toUpperCase();
        }
    }

    public static boolean H() {
        return V;
    }

    public static synchronized int I() {
        int i2;
        synchronized (c.class) {
            i2 = Q;
        }
        return i2;
    }

    public static h J() {
        if (d == null) {
            synchronized (c.class) {
                try {
                    if (d == null) {
                        d = new com.ss.android.socialbase.downloader.impls.c();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public static af K() {
        return e;
    }

    public static g L() {
        if (x == null) {
            synchronized (c.class) {
                try {
                    if (x == null) {
                        x = new com.ss.android.socialbase.downloader.impls.b();
                    }
                } finally {
                }
            }
        }
        return x;
    }

    public static s M() {
        if (z == null) {
            synchronized (c.class) {
                try {
                    if (z == null) {
                        z = new com.ss.android.socialbase.downloader.impls.j();
                    }
                } finally {
                }
            }
        }
        return z;
    }

    public static u N() {
        if (I == null) {
            synchronized (c.class) {
                try {
                    if (I == null) {
                        I = new u.a();
                    }
                } finally {
                }
            }
        }
        return I;
    }

    public static synchronized Context O() {
        Context context;
        synchronized (c.class) {
            context = f26270a;
        }
        return context;
    }

    public static synchronized boolean P() {
        boolean z2;
        synchronized (c.class) {
            z2 = R;
        }
        return z2;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.d.c Q() {
        if (Y == null) {
            Y = new com.ss.android.socialbase.downloader.d.c() { // from class: com.ss.android.socialbase.downloader.downloader.c.3
                @Override // com.ss.android.socialbase.downloader.d.c
                public void a(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.c
                public void b(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return Y;
    }

    public static r R() {
        return X;
    }

    public static boolean S() {
        return Z;
    }

    public static boolean T() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        if (i != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        com.ss.android.socialbase.downloader.c.a.a("wjd", sb.toString());
        if (i == null) {
            return false;
        }
        return true;
    }

    public static a U() {
        return i;
    }

    private static void V() {
        if (y == null) {
            y = new DownloadReceiver();
        }
        if (K) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f26270a.registerReceiver(y, intentFilter);
            K = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(r rVar) {
    }

    public static synchronized void b(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            c(downloaderBuilder);
        }
    }

    private static void c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                a(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                a(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                a(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                a(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                a(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                b(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                a(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                a(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                a(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                c(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                e(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                g(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                h(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                a(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                b(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                a(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                A = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                Q = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                a(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                E = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                U = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                a(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                G = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                I = downloaderBuilder.getTTNetHandler();
                if (I.a()) {
                    a(I.b());
                    a(I.c());
                } else {
                    a(h());
                    a(i());
                }
            }
            b(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                a(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static IDownloadHttpService d() {
        return j;
    }

    public static List<ak> e() {
        List<ak> list;
        synchronized (D) {
            list = D;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.h f() {
        return k;
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        return B;
    }

    public static IDownloadHttpService h() {
        if (l == null) {
            synchronized (c.class) {
                try {
                    if (l == null) {
                        l = new com.ss.android.socialbase.downloader.impls.g();
                    }
                } finally {
                }
            }
        }
        return l;
    }

    public static com.ss.android.socialbase.downloader.network.h i() {
        if (m == null) {
            synchronized (c.class) {
                try {
                    if (m == null) {
                        m = new com.ss.android.socialbase.downloader.impls.f();
                    }
                } finally {
                }
            }
        }
        return m;
    }

    public static boolean j() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", W ? 1 : 0) > 0) {
            return true;
        }
        return false;
    }

    public static synchronized q k() {
        q qVar;
        synchronized (c.class) {
            qVar = A;
        }
        return qVar;
    }

    public static ExecutorService l() {
        if (o == null) {
            synchronized (c.class) {
                try {
                    if (o == null) {
                        int i2 = M;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        o = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return o;
    }

    public static ExecutorService m() {
        if (p != null) {
            return p;
        }
        return l();
    }

    public static ExecutorService n() {
        if (r != null) {
            return r;
        }
        return p();
    }

    public static ExecutorService o() {
        if (s != null) {
            return s;
        }
        return p();
    }

    public static ExecutorService p() {
        if (q == null) {
            synchronized (c.class) {
                try {
                    if (q == null) {
                        int i2 = O;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        q = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return q;
    }

    public static ExecutorService q() {
        if (u == null) {
            synchronized (c.class) {
                try {
                    if (u == null) {
                        int i2 = N;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        u = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public static ExecutorService r() {
        if (t == null) {
            synchronized (c.class) {
                try {
                    if (t == null) {
                        int i2 = P;
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        t = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return t;
    }

    public static OkHttpClient s() {
        if (F == null) {
            synchronized (c.class) {
                try {
                    if (F == null) {
                        F = u().build();
                    }
                } finally {
                }
            }
        }
        return F;
    }

    public static ScheduledExecutorService t() {
        if (w == null) {
            synchronized (c.class) {
                try {
                    if (w == null) {
                        w = new ScheduledThreadPoolExecutor(1, new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-Schedule", true));
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public static OkHttpClient.Builder u() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (v != null) {
            builder.dispatcher(new Dispatcher(v));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.f v() {
        return G;
    }

    public static com.ss.android.socialbase.downloader.network.f w() {
        if (H == null) {
            synchronized (c.class) {
                try {
                    if (H == null) {
                        H = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
                            @Override // com.ss.android.socialbase.downloader.network.f
                            public List<InetAddress> a(String str) throws UnknownHostException {
                                return Dns.SYSTEM.lookup(str);
                            }
                        };
                    }
                } finally {
                }
            }
        }
        return H;
    }

    public static synchronized l x() {
        l lVar;
        synchronized (c.class) {
            lVar = n;
        }
        return lVar;
    }

    public static j y() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new com.ss.android.socialbase.downloader.impls.d();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static o z() {
        if (g == null) {
            synchronized (c.class) {
                try {
                    if (g == null) {
                        g = new com.ss.android.socialbase.downloader.impls.h();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            if (Z) {
                com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = E;
            c(downloaderBuilder);
            if (b == null) {
                b = new com.ss.android.socialbase.downloader.impls.d();
            }
            if (g == null) {
                g = new com.ss.android.socialbase.downloader.impls.h();
            }
            if (h == null && i != null) {
                h = i.a();
            }
            if (c == null) {
                c = new com.ss.android.socialbase.downloader.impls.i();
            }
            if (f == null) {
                f = new com.ss.android.socialbase.downloader.impls.e();
            }
            if (d == null) {
                d = new com.ss.android.socialbase.downloader.impls.c();
            }
            if (x == null) {
                x = new com.ss.android.socialbase.downloader.impls.b();
            }
            if (z == null) {
                z = new com.ss.android.socialbase.downloader.impls.j();
            }
            int i2 = L;
            if (i2 <= 0 || i2 > M) {
                L = M;
            }
            V();
            if (E && !z2 && !com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).e();
            } else if (com.ss.android.socialbase.downloader.i.f.d()) {
                ExecutorService m2 = m();
                if (m2 != null) {
                    m2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context O2 = c.O();
                            if (O2 != null) {
                                com.ss.android.socialbase.downloader.i.f.d(O2);
                            }
                        }
                    });
                }
            } else {
                Context O2 = O();
                if (O2 != null) {
                    com.ss.android.socialbase.downloader.i.f.d(O2);
                }
            }
            G();
            Z = true;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (E) {
                return;
            }
            E = true;
            try {
                Intent intent = new Intent(O(), (Class<?>) DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                O().startService(intent);
                if (!com.ss.android.socialbase.downloader.i.f.c()) {
                    com.ss.android.socialbase.downloader.impls.l.a(true).e();
                }
            } catch (Throwable th) {
                E = false;
                th.printStackTrace();
            }
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = S;
        synchronized (list) {
            if (kVar != null) {
                try {
                    if (list.contains(kVar)) {
                        list.remove(kVar);
                    }
                } finally {
                }
            }
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        List<ab> list = T;
        synchronized (list) {
            try {
                for (ab abVar : list) {
                    if (abVar != null) {
                        abVar.b(downloadTask, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.ss.android.socialbase.downloader.network.g b(java.lang.String r10, java.util.List<com.ss.android.socialbase.downloader.model.c> r11, int r12, boolean r13, com.ss.android.socialbase.downloader.model.DownloadInfo r14) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = 1
            if (r12 != r0) goto L8
            com.ss.android.socialbase.downloader.network.h r0 = f()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.h r0 = i()
        Lc:
            if (r0 == 0) goto L4a
            r8 = 0
            r1 = 0
            if (r13 == 0) goto L1d
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L1a
            goto L1d
        L18:
            r0 = move-exception
            goto L37
        L1a:
            r0 = move-exception
            r4 = r0
            goto L34
        L1d:
            com.ss.android.socialbase.downloader.network.g r0 = r0.a(r10, r11)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L1a
            if (r13 == 0) goto L33
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            java.lang.String r6 = "head"
            r9 = 0
            r1 = r0
            r2 = r10
            r3 = r9
            r7 = r12
            r9 = r14
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L33:
            return r0
        L34:
            throw r4     // Catch: java.lang.Throwable -> L35
        L35:
            r0 = move-exception
            r8 = r4
        L37:
            if (r13 == 0) goto L49
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            java.lang.String r6 = "head"
            r1 = 0
            r9 = 0
            r2 = r10
            r3 = r9
            r7 = r12
            r9 = r14
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L49:
            throw r0
        L4a:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.b(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.g");
    }

    public static void b(ExecutorService executorService) {
        if (executorService != null) {
            v = executorService;
        }
    }

    public static void b(Runnable runnable) {
        b(runnable, false);
    }

    public static void b(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            m().execute(runnable);
        }
    }

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                if (K && y != null && f26270a != null) {
                    f26270a.unregisterReceiver(y);
                    K = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void b(int i2) {
        if (i2 > 0) {
            L = i2;
        }
    }

    private static void b(boolean z2) {
        V = z2;
    }

    public static void a(ak akVar) {
        if (akVar == null) {
            return;
        }
        synchronized (D) {
            D.add(akVar);
        }
    }

    public static void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = S;
        synchronized (list) {
            if (kVar != null) {
                try {
                    if (!list.contains(kVar)) {
                        list.add(kVar);
                    }
                } finally {
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = S;
        synchronized (list) {
            try {
                for (com.ss.android.socialbase.downloader.depend.k kVar : list) {
                    if (kVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                            kVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                            kVar.b();
                        }
                    }
                }
                if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                    S.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized boolean c() {
        boolean z2;
        synchronized (c.class) {
            z2 = E;
        }
        return z2;
    }

    public static void a(DownloadTask downloadTask, int i2) {
        List<ab> list = T;
        synchronized (list) {
            try {
                for (ab abVar : list) {
                    if (abVar != null) {
                        abVar.a(downloadTask, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    public static void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            r().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.i a2;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] a3 = a(i4);
        Exception exc = null;
        for (int i5 : a3) {
            try {
                a2 = a(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(e2) && com.ss.android.socialbase.downloader.i.f.c(list2)) {
                    com.ss.android.socialbase.downloader.c.a.a("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (a2 != null) {
                return a2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.ss.android.socialbase.downloader.network.i a(int r10, java.lang.String r11, java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.model.c> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.model.DownloadInfo r16) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r14
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = d()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = h()
        Ld:
            if (r0 == 0) goto L58
            r8 = 0
            r1 = 0
            if (r15 == 0) goto L18
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1f
        L18:
            r3 = r10
            r4 = r11
            r5 = r13
            goto L23
        L1c:
            r0 = move-exception
            r4 = r11
            goto L43
        L1f:
            r0 = move-exception
            r4 = r11
        L21:
            r3 = r0
            goto L40
        L23:
            com.ss.android.socialbase.downloader.network.i r0 = r0.downloadWithConnection(r10, r11, r13)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            if (r15 == 0) goto L3b
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            java.lang.String r9 = "get"
            r1 = r0
            r2 = r11
            r3 = r12
            r4 = r5
            r6 = r9
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L3b:
            return r0
        L3c:
            r0 = move-exception
            goto L43
        L3e:
            r0 = move-exception
            goto L21
        L40:
            throw r3     // Catch: java.lang.Throwable -> L41
        L41:
            r0 = move-exception
            r8 = r3
        L43:
            if (r15 == 0) goto L57
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            java.lang.String r9 = "get"
            r1 = 0
            r2 = r11
            r3 = r12
            r4 = r5
            r6 = r9
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L57:
            throw r0
        L58:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.a(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.i");
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.g b2;
        Exception e2 = null;
        for (int i3 : a(i2)) {
            try {
                b2 = b(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (b2 != null) {
                return b2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static int[] a(int i2) {
        if (i2 == 1) {
            return new int[]{0};
        }
        if (i2 == 2) {
            return new int[]{1};
        }
        if (i2 != 3) {
            return new int[]{1, 0};
        }
        return new int[]{0, 1};
    }

    public static synchronized void a(l lVar) {
        synchronized (c.class) {
            if (lVar != null) {
                n = lVar;
                if (b instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) b).h();
                }
            }
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    private static void a(List<com.ss.android.socialbase.downloader.depend.m> list) {
        List<com.ss.android.socialbase.downloader.depend.m> list2 = J;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void a(boolean z2) {
        W = z2;
    }

    public static void a(Runnable runnable) {
        a(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            l().execute(runnable);
        }
    }

    public static Future a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return t().schedule(runnable, j2, timeUnit);
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            j = iDownloadHttpService;
        }
        R = j != null;
    }

    public static void a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar != null) {
            k = hVar;
        }
    }

    private static void a(j jVar) {
        if (jVar != null) {
            b = jVar;
        }
    }

    private static void a(k kVar) {
        if (kVar != null) {
            c = kVar;
        }
    }

    private static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            B = bVar;
        }
    }

    public static void a(aa aaVar) {
        C = aaVar;
        com.ss.android.socialbase.downloader.g.a.a();
    }

    private static void a(h hVar) {
        if (hVar != null) {
            d = hVar;
        }
    }

    public static void a(af afVar) {
        if (afVar != null) {
            e = afVar;
        }
    }

    private static void a(g gVar) {
        if (gVar != null) {
            x = gVar;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (f26270a == null) {
                    f26270a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.a().a(f26270a);
                }
            }
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return a(taskKey, downloadInfo.getSavePath());
    }

    public static int a(String str, String str2) {
        k C2 = C();
        if (C2 == null) {
            return 0;
        }
        return C2.a(str, str2);
    }

    public static void a(com.ss.android.socialbase.downloader.d.c cVar) {
        Y = cVar;
    }

    public static void a(a aVar) {
        com.ss.android.socialbase.downloader.c.a.a("wjd", "setIndependentServiceCreator::creator=" + aVar);
        i = aVar;
    }
}
