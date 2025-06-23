package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;

/* loaded from: classes8.dex */
public class g {
    private static g h = null;
    public static boolean i = false;
    public static boolean j = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8944a = false;
    public boolean b = true;
    private boolean c = true;
    private String d = RouteGuideParams.NavState.NAV_STATE_NAVING;
    private int e = 1;
    private boolean f = false;
    public int g = -1;

    public static g h() {
        if (h == null) {
            h = new g();
        }
        return h;
    }

    public boolean a() {
        return this.f8944a;
    }

    public void b(int i2) {
    }

    public void c(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGControlPanelModel", "updateFullviewState: " + z);
        }
        if (z) {
            ProNaviStatItem.O().G();
        } else {
            ProNaviStatItem.O().D();
        }
        this.f8944a = z;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.f;
    }

    public void f() {
        LogUtil.e("RGControlPanelModel", "reset");
        this.c = true;
        this.e = 1;
        g();
        this.d = RouteGuideParams.NavState.NAV_STATE_NAVING;
    }

    public void g() {
        this.g = -1;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public String b() {
        return this.d;
    }

    public void a(int i2) {
        BNRouteGuider.getInstance().setRouteDemoSpeed(i2);
        this.e = i2;
    }

    public int c() {
        return this.e;
    }
}
