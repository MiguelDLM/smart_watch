package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: classes13.dex */
public class e {
    private static String b = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private long D;
    private final DownloadInfo c;
    private final String d;
    private final com.ss.android.socialbase.downloader.model.b e;
    private final com.ss.android.socialbase.downloader.network.i f;
    private j g;
    private com.ss.android.socialbase.downloader.impls.k h;
    private t i;
    private com.ss.android.socialbase.downloader.model.e j;
    private BaseException k;
    private volatile boolean l;
    private volatile boolean m;
    private final com.ss.android.socialbase.downloader.h.f n;
    private long o;
    private long p;
    private volatile long q;
    private volatile long r;
    private final boolean s;
    private final com.ss.android.socialbase.downloader.g.a t;
    private final com.ss.android.socialbase.downloader.a.a u;
    private final boolean v;
    private final long w;
    private final long x;
    private final boolean y;
    private boolean z;

    /* renamed from: a, reason: collision with root package name */
    boolean f26273a = false;
    private volatile long E = 0;
    private volatile long F = 0;

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        boolean z;
        this.c = downloadInfo;
        this.d = str;
        j y = c.y();
        this.g = y;
        if (y instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) y;
            this.h = dVar.a();
            this.i = dVar.f();
        }
        this.f = iVar;
        this.e = bVar;
        this.n = fVar;
        long n = bVar.n();
        this.o = n;
        this.p = n;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = a2;
        if (a2.a("sync_strategy", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.v = z;
        if (z) {
            long a3 = a2.a("sync_interval_ms_fg", 5000);
            long a4 = a2.a("sync_interval_ms_bg", 1000);
            this.w = Math.max(a3, 500L);
            this.x = Math.max(a4, 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = a2.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean f() {
        if (!this.l && !this.m) {
            return false;
        }
        return true;
    }

    private void g() {
        ExecutorService l;
        if (this.f != null && (l = c.l()) != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.f.d();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void h() {
        long j;
        if (this.y) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        try {
            this.j.a();
            boolean z = true;
            this.c.updateRealDownloadTime(true);
            if (this.c.getChunkCount() <= 1) {
                z = false;
            }
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (z) {
                a(this.i);
                if (a2 != null) {
                    a2.c(this.c);
                } else {
                    this.i.a(this.c.getId(), this.c.getCurBytes());
                }
            } else if (a2 != null) {
                a2.c(this.c);
            } else {
                this.i.a(this.e.k(), this.o);
            }
            this.E = this.o;
        } catch (Exception unused) {
        }
        if (this.y) {
            this.C += System.nanoTime() - j;
        }
    }

    public void c() {
        if (this.m) {
            return;
        }
        synchronized (this.n) {
            this.m = true;
        }
        g();
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x02fe A[Catch: all -> 0x0306, TRY_ENTER, TryCatch #18 {all -> 0x0306, blocks: (B:145:0x02fe, B:146:0x0309, B:182:0x0383, B:184:0x0389, B:186:0x038c, B:220:0x044d, B:221:0x044f, B:236:0x0450, B:238:0x0470, B:271:0x04c5, B:273:0x04cb, B:274:0x04ce, B:275:0x04d0), top: B:8:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0383 A[Catch: all -> 0x0306, TRY_ENTER, TryCatch #18 {all -> 0x0306, blocks: (B:145:0x02fe, B:146:0x0309, B:182:0x0383, B:184:0x0389, B:186:0x038c, B:220:0x044d, B:221:0x044f, B:236:0x0450, B:238:0x0470, B:271:0x04c5, B:273:0x04cb, B:274:0x04ce, B:275:0x04d0), top: B:8:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04cb A[Catch: all -> 0x0306, TryCatch #18 {all -> 0x0306, blocks: (B:145:0x02fe, B:146:0x0309, B:182:0x0383, B:184:0x0389, B:186:0x038c, B:220:0x044d, B:221:0x044f, B:236:0x0450, B:238:0x0470, B:271:0x04c5, B:273:0x04cb, B:274:0x04ce, B:275:0x04d0), top: B:8:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.e.d():void");
    }

    public long e() {
        return this.E;
    }

    public long a() {
        return this.o;
    }

    public void b() {
        if (this.l) {
            return;
        }
        this.l = true;
        g();
    }

    public void a(long j, long j2, long j3) {
        this.o = j;
        this.p = j;
        this.q = j2;
        this.r = j3;
    }

    public void a(long j, long j2) {
        this.q = j;
        this.r = j2;
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int I = c.I();
        if (this.t.a("rw_concurrent", 0) == 1 && this.c.getChunkCount() == 1 && this.c.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, I, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, I);
        this.z = false;
        return cVar;
    }

    private void a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.F;
        if (this.v) {
            if (j > (this.u.b() ? this.w : this.x)) {
                h();
                this.F = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.o - this.E;
        if (z || b(j2, j)) {
            h();
            this.F = uptimeMillis;
        }
    }

    private void a(j jVar) {
        m mVar;
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (jVar == null) {
            return;
        }
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z) {
            mVar = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (mVar == null) {
                return;
            }
        } else {
            mVar = null;
        }
        m mVar2 = mVar;
        if (this.e.d()) {
            bVar = this.e.e();
        } else {
            bVar = this.e;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.o);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
            }
            if (bVar2.h()) {
                if (bVar2.i()) {
                    long j = bVar2.j();
                    if (j > this.o) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.k(), bVar2.b(), j);
                            return;
                        } else {
                            jVar.a(bVar2.k(), bVar2.b(), j);
                            return;
                        }
                    }
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.k(), bVar2.b(), this.o);
                    return;
                } else {
                    jVar.a(bVar2.k(), bVar2.b(), this.o);
                    return;
                }
            }
            return;
        }
        if (this.e.d()) {
            if (z && mVar2 != null) {
                mVar2.a(this.e.k(), this.e.s(), this.o);
            } else {
                jVar.a(this.e.k(), this.e.s(), this.o);
            }
        }
    }
}
