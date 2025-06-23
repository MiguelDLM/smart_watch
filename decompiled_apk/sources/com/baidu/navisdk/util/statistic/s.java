package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.i0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes8.dex */
public class s extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static s p;
    private int j;
    private Bundle k;
    public int l;
    int m;
    public int n;
    public int o;

    private s(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.j = -1;
        this.k = new Bundle();
        this.m = 4;
        this.n = 0;
        this.o = 0;
    }

    public static synchronized s n() {
        s sVar;
        synchronized (s.class) {
            try {
                if (p == null) {
                    p = new s(com.baidu.navisdk.comapi.statistics.b.f());
                }
                sVar = p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        try {
            b("rou_ret", Integer.toString(this.l));
            this.k.putInt("rou_ret", this.l);
            b("rou_way", String.valueOf(this.m));
            this.k.putInt("rou_way", this.m);
            com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
            i0.a().a(this.l);
            super.b(i);
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
            if (gVar.c()) {
                gVar.c(e.toString());
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String c() {
        return d() + "_light";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50002";
    }

    public void e(int i) {
        synchronized (this) {
            this.j = i;
            b("rou_ret", HelpFormatter.DEFAULT_OPT_PREFIX + Integer.toString(this.j));
            this.k.putInt("rou_ret", -this.j);
            i0.a().a(-this.j);
        }
        b("rou_way", String.valueOf(this.m));
        this.k.putString("rou_way", String.valueOf(this.m));
        b("rou_entry", Integer.toString(this.n));
        this.k.putInt("rou_entry", this.n);
        b("nt", Integer.toString(this.o));
        this.k.putInt("nt", this.o);
        com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
        super.k();
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-RoutePlanIPOStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.l = 0;
        this.m = 3;
        synchronized (this) {
            this.j = -1;
        }
        this.k.clear();
        LogUtil.e("Statistics-RoutePlanIPOStatItem", "stat test route plan response time onCreateView");
    }

    public void d(int i) {
        this.m = i;
    }
}
