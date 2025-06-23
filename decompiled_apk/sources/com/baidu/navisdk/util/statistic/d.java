package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;

/* loaded from: classes8.dex */
public class d extends com.baidu.navisdk.comapi.statistics.f {
    private static d p;
    public String j;
    public long k;
    public long l;
    public long m;
    public int n;
    public long o;

    public d(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.k = -1L;
        this.l = -1L;
        this.m = 0L;
        this.n = 0;
        this.o = -1L;
        l();
    }

    public static synchronized d n() {
        d dVar;
        synchronized (d.class) {
            try {
                if (p == null) {
                    p = new d(com.baidu.navisdk.comapi.statistics.b.f());
                }
                dVar = p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private void o() {
        Long l = 0L;
        if (this.l > 0) {
            l = Long.valueOf((SystemClock.elapsedRealtime() - this.l) / 1000);
        }
        b("real_time", l.toString());
        b("real_dis", Long.toString(this.m));
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        long j = this.l;
        if (j > 0) {
            this.o = (j - this.k) / 1000;
        }
        b("st_route", this.j);
        o();
        b("loc_time", Long.toString(this.o));
        if (this.l > 0) {
            b("lost_times", Integer.toString(this.n));
        }
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50004";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-CruiseStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.j = "1";
        this.k = -1L;
        this.l = -1L;
        this.o = -1L;
        this.m = 0L;
        this.n = 0;
    }
}
