package com.baidu.navisdk.ui.routeguide.heatmonitor;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private f f8617a;
    private e b;

    public b() {
        e();
        d();
        a();
    }

    private void d() {
        String a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("heat_monitor_heat_level_data", "");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.d()) {
            gVar.e("RGHMDataRepository", "updateHeatLevelModel(), jsonStr = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            this.b = e.a(a2);
        } else {
            this.b = e.b();
        }
    }

    private void e() {
        f g = g();
        f f = f();
        if (f != null) {
            g = f;
        }
        this.f8617a = g;
    }

    private f f() {
        Bundle e;
        com.baidu.navisdk.framework.interfaces.a a2 = com.baidu.navisdk.framework.interfaces.c.p().a();
        if (a2 != null && (e = a2.e(13)) != null && e.containsKey("strContentJson")) {
            String string = e.getString("strContentJson", "");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMDataRepository", "updateModelFromABTest(), json = " + string);
            }
            if (!TextUtils.isEmpty(string)) {
                f a3 = f.a(string);
                if (a3 != null) {
                    a3.a(a.ABTEST);
                }
                return a3;
            }
            return null;
        }
        return null;
    }

    private f g() {
        String a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("heat_monitor_data", "");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.d()) {
            gVar.e("RGHMDataRepository", "updateModelFromClound(), jsonStr = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        f a3 = f.a(a2);
        if (a3 != null) {
            a3.a(a.CLOUND);
        }
        return a3;
    }

    public boolean a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.d()) {
            gVar.e("RGHMDataRepository", "check(), mModel = " + this.f8617a + " mHeatLevelModel = " + this.b);
        }
        if (this.f8617a != null && this.b != null) {
            return true;
        }
        return false;
    }

    public e b() {
        return this.b;
    }

    public f c() {
        return this.f8617a;
    }
}
