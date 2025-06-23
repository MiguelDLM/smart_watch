package com.baidu.navisdk.module.newguide.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.newguide.settings.b f7235a = null;
    private com.baidu.navisdk.ui.routeguide.toolbox.view.a b = null;
    private com.baidu.navisdk.ui.routeguide.widget.g c = null;

    /* loaded from: classes7.dex */
    public class a implements a.o {
        public a(c cVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.module.a.h().l = true;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.o {
        public b(c cVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.module.a.h().l = true;
        }
    }

    private boolean X() {
        return com.baidu.navisdk.module.newguide.a.e().d();
    }

    private void Y() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.i();
            this.f7235a = null;
        }
    }

    private void Z() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.i();
            this.c = null;
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.z0();
            this.b = null;
        }
    }

    public boolean A() {
        return true;
    }

    public void B() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a((View) null, 7);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.E0();
        }
    }

    public boolean C() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null && bVar.I0()) {
            return true;
        }
        return false;
    }

    public void D() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void E() {
        Z();
        Y();
    }

    public void F() {
        if (this.c != null && u()) {
            this.c.onResume();
        }
    }

    public void G() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.k0();
        }
    }

    public void H() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    public void I() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.h();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void J() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.B0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.P0();
        }
    }

    public void K() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().i();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.M0();
        }
    }

    public void L() {
        com.baidu.navisdk.module.pronavi.model.i.f().b = true;
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().m();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.B(true);
        }
    }

    public void M() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().g();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.K0();
            this.f7235a.u0();
        }
    }

    public void N() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showSafetyShareLoading: ");
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a("分享请求中...", new a(this));
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.a("分享请求中...", new b(this));
        }
    }

    public void O() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().k();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.N0();
        }
    }

    public void P() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.A0();
        }
    }

    public void Q() {
        com.baidu.navisdk.ui.routeguide.toolbox.present.b p0;
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null && (p0 = aVar.p0()) != null) {
            p0.n();
        }
    }

    public void R() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.F0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.S0();
        }
    }

    public void S() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            com.baidu.navisdk.ui.routeguide.toolbox.present.b p0 = aVar.p0();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGBottomSettingPageMana", "updateRemainTrafficLights present: " + p0);
            }
            if (p0 != null) {
                p0.o();
            }
        }
    }

    public void T() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.G0();
        }
    }

    public void U() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().q();
        }
    }

    public void V() {
        com.baidu.navisdk.ui.routeguide.toolbox.present.b p0;
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null && (p0 = aVar.p0()) != null) {
            p0.j();
        }
    }

    public void W() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().p();
        }
    }

    public void a(ViewGroup viewGroup, int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.b(viewGroup, i);
        }
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.a(viewGroup, i);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar == null || !bVar.a()) {
            return;
        }
        this.f7235a.a(viewGroup, i);
    }

    public void b(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.w(i);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.w(i);
        }
    }

    public void c(boolean z) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().d();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.B(false);
        }
    }

    public void d() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.f0();
        }
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.f0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.f0();
        }
    }

    public com.baidu.navisdk.module.newguide.subviews.b e() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            return bVar.p0();
        }
        return null;
    }

    public View f() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            return bVar.q0();
        }
        return null;
    }

    public void g(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "updateStyle: " + z);
        }
        com.baidu.navisdk.ui.routeguide.widget.g gVar2 = this.c;
        if (gVar2 != null) {
            gVar2.a(z);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.a(z);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public int h() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            return aVar.q0();
        }
        return 0;
    }

    public void i() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.z0();
        }
    }

    public boolean j() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar == null || aVar.q0() != 0) {
            return false;
        }
        this.b.w(0);
        return true;
    }

    public void k() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.s0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.x0();
        }
    }

    public void l() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.c();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.y(true);
        }
    }

    public void m() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "hideReRoutePlanView: ");
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().c();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.w0();
        }
    }

    public void n() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "hideRouteSearchLoading: ");
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().c();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.w0();
        }
    }

    public void o() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().c();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.w0();
        }
    }

    public void p() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.O0();
        }
    }

    public void q() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.t0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.t0();
        }
    }

    public void r() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.u0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.A0();
        }
    }

    public void s() {
        LogUtil.e("RGBottomSettingPageMana", "hideWaitCalLoading");
        if (a0.I().D()) {
            LogUtil.e("RGBottomSettingPageMana", "hideWaitCalLoading return isYawing");
            return;
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().h();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.L0();
        }
    }

    public void t() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().b(true);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.A(true);
        }
    }

    public boolean u() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar;
        if (X() || (gVar = this.c) == null || !gVar.a()) {
            return false;
        }
        return true;
    }

    public boolean v() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null && aVar.p0() != null) {
            return this.b.p0().f();
        }
        return false;
    }

    public boolean w() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null && bVar.B0()) {
            return true;
        }
        return false;
    }

    public boolean x() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            return aVar.y0();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            return bVar.C0();
        }
        return false;
    }

    public boolean y() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null && bVar.D0()) {
            return true;
        }
        return false;
    }

    public boolean z() {
        if (X()) {
            return w();
        }
        return v();
    }

    public void e(boolean z) {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.A(z);
        }
    }

    public void f(boolean z) {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.C(z);
        }
    }

    public void b(String str, a.o oVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showReRoutePlanLoading: " + str);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a(str, oVar);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.a(str, oVar);
        }
    }

    public void c(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().b(i);
        }
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            gVar.a(i, i2, intent);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.a(i, i2, intent);
        }
    }

    public boolean c(String str, a.o oVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showRefreshRoadProgress: " + str);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a(str, oVar);
            return true;
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar == null) {
            return false;
        }
        bVar.a(str, oVar);
        return true;
    }

    public void d(String str, a.o oVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showRouteSearchLoading: " + str);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a(str, oVar);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.a(str, oVar);
        }
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.b g() {
        return this.f7235a;
    }

    public void b(boolean z) {
        if (this.b != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGBottomSettingPageMana", "executeExpandToolBoxWithAnim isExpand - " + z);
            }
            if (z) {
                this.b.E0();
            } else {
                this.b.D0();
            }
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            if (z) {
                bVar.R0();
            } else {
                bVar.Q0();
            }
        }
    }

    public void a(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a(i);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.v(i);
        }
    }

    public void c() {
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.y(false);
        }
    }

    public void d(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "onNetworkStatueChange: " + z);
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.z(z);
        }
    }

    public void a(boolean z) {
        if (this.b != null && v()) {
            this.b.p0().b();
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar != null) {
            bVar.y(z);
        }
    }

    public boolean b() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar == null || !(gVar instanceof com.baidu.navisdk.ui.routeguide.truck.setting.a)) {
            return false;
        }
        return ((com.baidu.navisdk.ui.routeguide.truck.setting.a) gVar).B0();
    }

    public boolean a(String str, a.o oVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showOfflineToOnlineProgress: " + str);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.b;
        if (aVar != null) {
            aVar.p0().a(str, oVar);
            return false;
        }
        com.baidu.navisdk.module.newguide.settings.b bVar = this.f7235a;
        if (bVar == null) {
            return false;
        }
        bVar.a(str, oVar);
        return true;
    }

    public void a(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (X()) {
            Z();
            if (this.f7235a == null) {
                this.f7235a = new com.baidu.navisdk.module.newguide.settings.b(context, bVar, viewGroup, aVar);
            }
            this.f7235a.y();
            return;
        }
        Y();
        if (this.b == null) {
            com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar2 = new com.baidu.navisdk.ui.routeguide.toolbox.view.a(context, viewGroup);
            this.b = aVar2;
            aVar2.a(aVar);
            this.b.H0();
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar3 = this.b;
        if (aVar3 != null) {
            aVar3.C0();
        }
    }

    public void a(String str) {
        com.baidu.navisdk.module.newguide.settings.b bVar;
        com.baidu.navisdk.module.newguide.settings.b bVar2 = this.f7235a;
        if (bVar2 != null) {
            bVar2.J0();
        }
        if (!"car_owner_plate_setting".equals(str) || (bVar = this.f7235a) == null) {
            return;
        }
        bVar.r0();
    }

    public boolean a() {
        com.baidu.navisdk.ui.routeguide.widget.g gVar = this.c;
        if (gVar != null) {
            return gVar.y0();
        }
        return false;
    }

    public void a(Activity activity, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomSettingPageMana", "showMenuMoreView: " + i);
        }
        if (viewGroup == null) {
            gVar.a("Common: ", "showMenuMoreView mRootViewGroup is null");
            return;
        }
        if (X()) {
            if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
                com.baidu.navisdk.ui.routeguide.b.V().j().b().f();
            }
            if (this.f7235a == null) {
                this.f7235a = new com.baidu.navisdk.module.newguide.settings.b(activity, bVar, viewGroup, aVar);
            }
            this.f7235a.a(p.SPECIFIC, true);
            return;
        }
        com.baidu.navisdk.ui.routeguide.widget.g a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a(activity, viewGroup, aVar, this.c);
        this.c = a2;
        if (a2 != null) {
            a2.y();
        }
    }
}
