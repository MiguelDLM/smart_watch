package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.a.a;

/* loaded from: classes11.dex */
public class e implements a.InterfaceC1053a {

    /* renamed from: a, reason: collision with root package name */
    private long f26072a;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static e f26074a = new e();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1053a
    public void b() {
        this.f26072a = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1053a
    public void c() {
    }

    private e() {
        this.f26072a = 0L;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static e a() {
        return a.f26074a;
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        a(dVar, k.j().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }

    public void a(final d dVar, final long j) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.a.a.a().c() && System.currentTimeMillis() - e.this.f26072a > j) {
                    dVar.a(false);
                } else {
                    dVar.a(true);
                }
            }
        }, j);
    }

    public void a(d dVar) {
        a(dVar, 5000L);
    }
}
