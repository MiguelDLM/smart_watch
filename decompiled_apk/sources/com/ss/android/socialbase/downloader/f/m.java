package com.ss.android.socialbase.downloader.f;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class m implements Runnable {
    private Thread A;
    private volatile boolean B;
    private int C;
    private int D;
    private int E;
    private long F;
    private int G;
    private boolean H;
    private BaseException I;
    private boolean J;
    private boolean K;
    private com.ss.android.socialbase.downloader.i.e L;

    /* renamed from: a, reason: collision with root package name */
    volatile i f26297a;
    q b;
    final int c;
    volatile long d;
    volatile long e;
    volatile long f;
    volatile long g;
    String h;
    String i;
    String j;
    private final f k;
    private final c l;
    private final DownloadInfo m;
    private final com.ss.android.socialbase.downloader.g.a n;
    private com.ss.android.socialbase.downloader.network.i o;
    private com.ss.android.socialbase.downloader.model.d p;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long v;
    private Future w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile boolean z;
    private final List<i> q = new ArrayList();
    private volatile long u = -1;

    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i) {
        this.m = downloadInfo;
        this.k = kVar;
        this.l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.b = qVar;
        this.c = i;
    }

    private boolean a(i iVar) throws BaseException {
        k();
        while (true) {
            try {
                try {
                    b(iVar);
                    d(iVar);
                    i();
                    return true;
                } catch (j e) {
                    this.I = e;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        i();
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !a(iVar, e)) {
                            i();
                            return false;
                        }
                    }
                    i();
                } catch (Throwable th3) {
                    i();
                    throw th3;
                }
            }
        }
    }

    private void b(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        c(iVar);
        this.k.a(this, iVar, this.b, this.p);
        this.b.c();
    }

    private void c(i iVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.i a2;
        try {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.e = 0L;
                    this.d = currentTimeMillis;
                    this.r = iVar.e();
                    this.t = iVar.f();
                    if (this.t > 0 && this.r > this.t) {
                        throw new j(6, "createConn, " + iVar);
                    }
                    this.L = new com.ss.android.socialbase.downloader.i.e();
                    List<com.ss.android.socialbase.downloader.model.c> a3 = com.ss.android.socialbase.downloader.i.f.a(this.m.getExtraHeaders(), this.m.geteTag(), this.r, this.t);
                    a3.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                    a3.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.c)));
                    com.ss.android.socialbase.downloader.i.f.a(a3, this.m);
                    com.ss.android.socialbase.downloader.i.f.b(a3, this.m);
                    str = this.b.f26299a;
                    if (this.H && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                        str = str.replaceFirst("https", "http");
                    }
                    str2 = this.b.b;
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.c);
                    this.h = str;
                    this.i = str2;
                    a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), str, str2, a3, 0, currentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.m);
                } catch (BaseException e) {
                    throw e;
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
            }
            if (a2 != null) {
                this.o = a2;
                this.p = new com.ss.android.socialbase.downloader.model.d(str, a2);
                if (!this.x) {
                    if (a2 instanceof com.ss.android.socialbase.downloader.network.a) {
                        this.j = ((com.ss.android.socialbase.downloader.network.a) a2).e();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.j + ", threadIndex = " + this.c);
                    this.e = System.currentTimeMillis();
                    return;
                }
                throw new p("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } catch (Throwable th2) {
            this.e = System.currentTimeMillis();
            throw th2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:206:0x0159
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03ec  */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.ss.android.socialbase.downloader.f.i r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.d(com.ss.android.socialbase.downloader.f.i):void");
    }

    private void i() {
        this.F = this.d;
        this.d = -1L;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar = this.o;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.c);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.H = false;
        l();
    }

    private void l() {
        int backUpUrlRetryCount;
        if (this.b.d) {
            backUpUrlRetryCount = this.m.getRetryCount();
        } else {
            backUpUrlRetryCount = this.m.getBackUpUrlRetryCount();
        }
        this.D = backUpUrlRetryCount;
        this.E = 0;
    }

    private long m() {
        long j = this.s;
        this.s = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public void e() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.c);
        synchronized (this) {
            this.x = true;
            this.B = true;
        }
        j();
        Future future = this.w;
        if (future != null) {
            this.w = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    public boolean g() {
        return this.J;
    }

    public long h() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        i a2;
        f fVar2;
        f fVar3;
        Process.setThreadPriority(10);
        try {
            try {
                this.A = Thread.currentThread();
                this.k.a(this);
                this.b.a(this);
                while (true) {
                    a2 = this.k.a(this, this.b);
                    if (a2 == null) {
                        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "no more segment, thread_index = " + this.c);
                        break;
                    }
                    this.f26297a = a2;
                    try {
                        try {
                        } catch (Throwable th) {
                            this.f26297a = null;
                            this.k.a(this, a2);
                            throw th;
                        }
                    } catch (j e) {
                        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "run: SegmentApplyException, e = " + e);
                        int i = this.C;
                        if (i >= 50) {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "segment apply failed " + this.C + "times, thread_index = " + this.c);
                            this.f26297a = null;
                            fVar2 = this.k;
                            break;
                        }
                        this.C = i + 1;
                        this.f26297a = null;
                        fVar3 = this.k;
                    }
                    if (a(a2)) {
                        this.q.add(a2);
                        this.f26297a = null;
                        fVar3 = this.k;
                        fVar3.a(this, a2);
                    } else {
                        if (!this.x) {
                            com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download segment failed, segment = " + a2 + ", thread_index = " + this.c + ", failedException = " + this.I);
                            break;
                        }
                        break;
                    }
                }
                this.f26297a = null;
                fVar2 = this.k;
                fVar2.a(this, a2);
                this.b.b(this);
                fVar = this.k;
            } catch (Throwable unused) {
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                this.b.b(this);
                fVar = this.k;
            } catch (Throwable th3) {
                try {
                    this.b.b(this);
                    this.k.b(this);
                } catch (Throwable unused2) {
                }
                this.A = null;
                throw th3;
            }
        }
        fVar.b(this);
        this.A = null;
    }

    public long b() {
        long c;
        synchronized (this.k) {
            c = this.v + c();
        }
        return c;
    }

    public void b(boolean z) {
        this.J = z;
    }

    public void b(long j) {
        long j2 = this.u;
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (j2 < 0 || eVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.c);
        eVar.a(j2, j);
    }

    public boolean a(q qVar) {
        int i = this.G;
        if (i >= 30) {
            return false;
        }
        this.G = i + 1;
        q qVar2 = this.b;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.b = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
        this.I = baseException;
        this.b.b();
        this.k.a(this, this.b, iVar, baseException, this.E, this.D);
        int i = this.E;
        if (i < this.D) {
            this.E = i + 1;
            return true;
        }
        if (a(baseException)) {
            return true;
        }
        this.k.a(this, this.b, iVar, baseException);
        return false;
    }

    public long c() {
        synchronized (this.k) {
            try {
                long j = this.u;
                long j2 = this.r;
                if (j2 < 0 || j <= j2) {
                    return 0L;
                }
                return j - j2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean a(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.i.f.c(baseException)) {
            return false;
        }
        String str = this.b.f26299a;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.m.isNeedHttpsToHttpRetry() || this.H) {
            return false;
        }
        this.H = true;
        l();
        return true;
    }

    public void c(boolean z) {
        this.K = z;
    }

    private a a(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        a b = cVar.b();
        try {
            i = inputStream.read(b.f26287a);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                b.c = i;
                if (i == -1) {
                    cVar.a(b);
                }
                return b;
            }
            throw new BaseException(1073, "probe");
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                cVar.a(b);
            }
            throw th;
        }
    }

    public boolean a(long j) {
        long j2 = this.t;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.s = j;
        this.B = true;
        return true;
    }

    public void a() {
        q qVar = this.b;
        try {
            synchronized (this.k) {
                try {
                    long c = c();
                    if (c > 0) {
                        this.v += c;
                        qVar.a(c);
                    }
                    this.u = -1L;
                } finally {
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.c);
        synchronized (this) {
            this.z = z;
            this.y = true;
            this.B = true;
        }
        j();
        Thread thread = this.A;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.c);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Future future) {
        this.w = future;
    }

    public long a(long j, long j2) {
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (eVar == null) {
            return -1L;
        }
        return eVar.b(j, j2);
    }

    public long d() {
        return this.u;
    }
}
