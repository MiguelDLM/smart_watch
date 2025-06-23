package com.baidu.navisdk.module.motorbike.view.support.module.routeprefer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.drivinghabit.c;
import com.baidu.navisdk.module.routepreference.i;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.module.routepreference.views.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.b;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a extends d {
    public a(Context context, ViewGroup viewGroup, View view, ViewGroup viewGroup2, com.baidu.navisdk.module.routepreference.interfaces.a aVar, int i) {
        super(context, viewGroup, view, viewGroup2, aVar, i);
    }

    private void h(int i) {
        if (!A()) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorRoutePreferPanel", "calcClickNoDefaultPrefer 1: " + com.baidu.navisdk.module.motorbike.preferences.a.u0().W() + ", " + com.baidu.navisdk.module.motorbike.preferences.a.u0().C() + ", clickPrefer:" + i);
        }
        if (com.baidu.navisdk.module.motorbike.preferences.a.u0().C() == -1) {
            return;
        }
        if (com.baidu.navisdk.module.motorbike.preferences.a.u0().W()) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().p(0);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorRoutePreferPanel", "calcClickNoDefaultPrefer 2: " + l());
        }
        int l = l();
        if ((i & l) == l) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().p(0);
        } else {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().p(1);
        }
    }

    public boolean A() {
        throw null;
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        throw null;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean a() {
        throw null;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public int b() {
        return R.layout.nsdk_layout_route_sort_main_view;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void c(int i) {
        int i2;
        boolean z;
        int k = k();
        if ((k & 32) != 0) {
            i2 = i | 32;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if (i2 != k) {
            z = true;
        } else {
            z = false;
        }
        d(i2);
        if (B() || com.baidu.navisdk.module.motorbike.preferences.a.u0().W()) {
            z2 = true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorRoutePreferPanel", "handlerOnClickPrefer-> clickedPrefer=" + i + ", isRememberPrefer=" + z2 + ", isForceRememberPrefer=" + B());
        }
        if (C() && z2) {
            e(i2);
            com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
            if (aVar != null) {
                aVar.a(z, i);
            }
            b.r().a("2.i.3", i + "", null, null);
        } else {
            com.baidu.navisdk.module.routepreference.interfaces.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.b(z, i);
            }
            b.r().a("2.i.1", i + "", "" + this.k, null);
        }
        if (!z2 && C()) {
            h(i);
        }
        if (this.p && (i & 4) == 4) {
            b.r().b("2.i.1.4");
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void d(int i) {
        com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean e() {
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean f() {
        return false;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean g() {
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int j() {
        return 3;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int k() {
        return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int l() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().c();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public ArrayList<c> m() {
        return null;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int n() {
        return 0;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public ArrayList<j> o() {
        return i.j().c();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public String p() {
        return null;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void s() {
        boolean f0 = com.baidu.navisdk.module.motorbike.preferences.a.u0().f0();
        this.p = f0;
        if (f0) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().w(false);
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean t() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().W();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean u() {
        return i.j().e();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean v() {
        if (com.baidu.navisdk.module.motorbike.preferences.a.u0().W() || !a()) {
            return false;
        }
        int C = com.baidu.navisdk.module.motorbike.preferences.a.u0().C();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorRoutePreferPanel", "isShowRememberPreferBubble showRememberPreferBubble: " + C);
        }
        if (C == -1 || C < 1) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void a(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().h(z);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void e(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().c(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void f(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().p(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void g(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().r(i);
    }
}
