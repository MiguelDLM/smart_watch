package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.util.common.a0;

/* loaded from: classes8.dex */
public class f extends com.baidu.navisdk.comapi.statistics.f {
    private static f j;

    public f(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
    }

    public static f n() {
        if (j == null) {
            j = new f(com.baidu.navisdk.comapi.statistics.b.f());
        }
        return j;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        b("event_id", "8");
        b("brand", a0.b());
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "60001";
    }

    public void e(int i) {
        b("framework_num", i + "");
    }

    public void f(int i) {
        b("indoor", i + "");
    }

    public void g(int i) {
        b("link_level", i + "");
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-GPSWeakStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public int i() {
        return 3;
    }

    public void d(int i) {
        b("area", i + "");
    }

    public void h(int i) {
        b("loc_num", i + "");
    }

    public void i(int i) {
        b("u_satellite", i + "");
    }
}
