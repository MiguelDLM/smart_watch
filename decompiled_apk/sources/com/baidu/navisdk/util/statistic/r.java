package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;

/* loaded from: classes8.dex */
public class r extends com.baidu.navisdk.comapi.statistics.f {
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static r f9381a = new r(com.baidu.navisdk.comapi.statistics.b.f());
    }

    public r(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.n = -1L;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
    }

    public static r s() {
        return a.f9381a;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public synchronized void b(int i) {
        long j;
        try {
            if (this.p) {
                return;
            }
            b("sdk_time", Long.toString(this.k));
            long j2 = this.m;
            if (j2 > 0) {
                j = j2 - this.l;
            } else {
                j = -1;
            }
            b("loc_time", Long.toString(j));
            b("eng_time", Long.toString(this.o));
            super.b(i);
            this.p = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50015";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-RespTimeStatItem";
    }

    public void n() {
        this.k += SystemClock.elapsedRealtime() - this.j;
        this.q = true;
        if (this.r && this.s) {
            k();
        }
    }

    public void o() {
        this.s = true;
        if (this.n <= -1) {
            this.o = -1L;
        } else {
            this.o = SystemClock.elapsedRealtime() - this.n;
        }
        if (this.q && this.r && this.s) {
            k();
        }
    }

    public void p() {
        this.l = SystemClock.elapsedRealtime();
    }

    public void q() {
        this.n = SystemClock.elapsedRealtime();
    }

    public void r() {
        this.j = SystemClock.elapsedRealtime();
    }
}
