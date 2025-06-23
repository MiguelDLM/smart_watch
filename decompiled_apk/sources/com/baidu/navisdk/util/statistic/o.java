package com.baidu.navisdk.util.statistic;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class o extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static final String n = "o";
    private static o o;
    private String j;
    private boolean k;
    private long l;
    private Bundle m;

    private o(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.m = new Bundle();
    }

    public static synchronized o n() {
        o oVar;
        synchronized (o.class) {
            try {
                if (o == null) {
                    o = new o(com.baidu.navisdk.comapi.statistics.b.f());
                }
                oVar = o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    public void a(long j) {
        this.l = j;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void c(boolean z) {
        this.k = z;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50001";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return n;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        b("sea_type", this.j);
        this.m.putString("sea_type", this.j);
        b("re_time", Long.toString(this.l));
        this.m.putLong("re_time", this.l);
        b("sea_ret", this.k ? "1" : "0");
        this.m.putInt("sea_ret", this.k ? 1 : 0);
        com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
        super.b(i);
    }

    public void d(int i) {
        if (i == 1) {
            this.j = "1";
            return;
        }
        if (i == 2) {
            this.j = "2";
        } else if (i == 3) {
            this.j = "3";
        } else {
            if (i != 4) {
                return;
            }
            this.j = "4";
        }
    }

    public void b(String str) {
        this.j = str;
    }
}
