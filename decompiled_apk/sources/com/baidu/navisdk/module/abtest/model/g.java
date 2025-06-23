package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.kuaishou.weapon.p0.t;

/* loaded from: classes7.dex */
public class g extends j {
    public g(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        Bundle e;
        if (aVar != null && (e = aVar.e(13)) != null && e.containsKey("plan")) {
            a(e);
        }
    }

    public static g s() {
        com.baidu.navisdk.framework.interfaces.a a2 = com.baidu.navisdk.framework.interfaces.c.p().a();
        if (a2 == null) {
            return null;
        }
        return (g) a2.g(13);
    }

    public void a(long j) {
        a("real_dis", Long.valueOf(j));
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    public void d(int i) {
        a("hhl", Integer.valueOf(i));
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "ABHeatMonitorData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 13;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void r() {
        super.r();
        com.baidu.navisdk.module.statistics.abtest.a aVar = this.j;
        if (aVar != null) {
            a(aVar.e(13));
        }
    }

    public void a(float f) {
        a("bph", Float.valueOf(f));
    }

    public void b(long j) {
        a("real_time", Long.valueOf(j));
    }

    public void a(int i, long j) {
        a(String.format("l%dt", Integer.valueOf(i)), Long.valueOf(j));
    }

    public void b(boolean z) {
        a(t.x, Boolean.valueOf(z));
    }

    public void b(int i, long j) {
        a(String.format("l%dcpu", Integer.valueOf(i)), Long.valueOf(j));
    }

    public void a(int i, float f) {
        a(String.format("l%dtp", Integer.valueOf(i)), Float.valueOf(f));
    }

    public void b(String str) {
        d("dynamic", str);
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        super.b(i);
    }
}
