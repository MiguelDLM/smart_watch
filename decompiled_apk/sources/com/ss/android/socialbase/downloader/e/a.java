package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: classes13.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f26279a;
    private final int b;
    private final int c;
    private com.ss.android.socialbase.downloader.f.a f;
    private com.ss.android.socialbase.downloader.f.a g;
    private com.ss.android.socialbase.downloader.f.a h;
    private com.ss.android.socialbase.downloader.f.a i;
    private com.ss.android.socialbase.downloader.f.a j;
    private com.ss.android.socialbase.downloader.f.a k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile Throwable n;
    private volatile Future o;
    private int p;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.e.a.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a d;
            Process.setThreadPriority(10);
            do {
                try {
                    d = a.this.d();
                    d.c = a.this.f26279a.read(d.f26287a);
                    a.this.c(d);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            f.a(a.this.f26279a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            f.a(a.this.f26279a);
                            throw th2;
                        }
                    }
                }
            } while (d.c != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            f.a(a.this.f26279a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f26279a = inputStream;
        this.b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        int i;
        com.ss.android.socialbase.downloader.f.a aVar = this.h;
        if (aVar != null) {
            if (!this.l) {
                this.h = aVar.d;
                aVar.d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.d) {
            try {
                if (!this.l) {
                    com.ss.android.socialbase.downloader.f.a aVar2 = this.f;
                    if (aVar2 == null && (i = this.p) < this.c) {
                        this.p = i + 1;
                        return new com.ss.android.socialbase.downloader.f.a(this.b);
                    }
                    while (aVar2 == null) {
                        this.d.wait();
                        if (!this.l) {
                            aVar2 = this.f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.h = aVar2.d;
                    this.g = null;
                    this.f = null;
                    aVar2.d = null;
                    return aVar2;
                }
                throw new p("");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
    
        if (r4.m == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r4.e.wait();
        r2 = r4.i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        r4.k = r2.d;
        r4.j = null;
        r4.i = null;
        r2.d = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.f.a e() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        /*
            r4 = this;
            com.ss.android.socialbase.downloader.f.a r0 = r4.k
            r1 = 0
            if (r0 == 0) goto Lc
            com.ss.android.socialbase.downloader.f.a r2 = r0.d
            r4.k = r2
            r0.d = r1
            return r0
        Lc:
            java.lang.Object r0 = r4.e
            monitor-enter(r0)
            com.ss.android.socialbase.downloader.f.a r2 = r4.i     // Catch: java.lang.Throwable -> L1b
            if (r2 != 0) goto L26
        L13:
            boolean r2 = r4.m     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L1d
            r4.f()     // Catch: java.lang.Throwable -> L1b
            goto L1d
        L1b:
            r1 = move-exception
            goto L32
        L1d:
            java.lang.Object r2 = r4.e     // Catch: java.lang.Throwable -> L1b
            r2.wait()     // Catch: java.lang.Throwable -> L1b
            com.ss.android.socialbase.downloader.f.a r2 = r4.i     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L13
        L26:
            com.ss.android.socialbase.downloader.f.a r3 = r2.d     // Catch: java.lang.Throwable -> L1b
            r4.k = r3     // Catch: java.lang.Throwable -> L1b
            r4.j = r1     // Catch: java.lang.Throwable -> L1b
            r4.i = r1     // Catch: java.lang.Throwable -> L1b
            r2.d = r1     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            return r2
        L32:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.e.a.e():com.ss.android.socialbase.downloader.f.a");
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
            }
            f.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private void c() throws Throwable {
        this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.d) {
            this.l = true;
            this.d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.e) {
            try {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.j;
                if (aVar2 == null) {
                    this.j = aVar;
                    this.i = aVar;
                    this.e.notify();
                } else {
                    aVar2.d = aVar;
                    this.j = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.d) {
            try {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.g;
                if (aVar2 == null) {
                    this.g = aVar;
                    this.f = aVar;
                    this.d.notify();
                } else {
                    aVar2.d = aVar;
                    this.g = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
