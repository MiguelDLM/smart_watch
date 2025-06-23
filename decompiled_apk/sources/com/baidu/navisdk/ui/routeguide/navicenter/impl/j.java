package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class j implements com.baidu.navisdk.ui.routeguide.subview.a {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<BNavigatorLogic> f9077a;

    public j(BNavigatorLogic bNavigatorLogic) {
        this.f9077a = new WeakReference<>(bNavigatorLogic);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void a() {
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("1.a");
        this.f9077a.get().G().p();
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_zoom_out"));
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public boolean b(boolean z) {
        if (com.baidu.navisdk.ui.util.g.a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "onFullViewAction ForbidDaulClickUtils.isFastDoubleClick()");
            }
            return false;
        }
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        this.f9077a.get().p0();
        this.f9077a.get().G().c(z);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void c(int i) {
        com.baidu.navisdk.ui.routeguide.b.V().y();
        if (x.b().L2()) {
            x.b().o3();
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u", "2", null, null);
            x.b().z(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void d(boolean z) {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        if (z) {
            BNRouteGuider.getInstance().pauseRouteGuide();
        } else {
            BNRouteGuider.getInstance().resumeRouteGuide();
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().b(!z);
        x.b().Q(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public boolean e() {
        a0.G = 3;
        int d = com.baidu.navisdk.ui.routeguide.b.V().d().d();
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("RouteGuide", "onPlateLimitChangeReCalcRoute() --> reCalcRoute():" + d);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(d), "1", null);
        l.l().i();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public boolean f() {
        return x.b().d3();
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void g() {
        LogUtil.e("RouteGuide", "onCancelLoading");
        com.baidu.navisdk.cmdrequest.b.a().a(1);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void h() {
        boolean z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onJudgePreferWithMenuHide -> ");
        }
        if (this.f9077a.get() != null && this.f9077a.get().I() == 3) {
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f()) {
                if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
                    z = com.baidu.navisdk.ui.routeguide.b.V().j().m().a();
                } else {
                    z = false;
                }
                if (z) {
                    l.l().a(0, 1003);
                    return;
                } else {
                    l.l().i();
                    return;
                }
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e()) {
            a0.G = 3;
        }
        int d = com.baidu.navisdk.ui.routeguide.b.V().d().d();
        if (com.baidu.navisdk.ui.routeguide.b.V().d().a(d) || com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e()) {
            LogUtil.e("RouteGuide", "onJudgePreferWithMenuHide() --> reCalcRoute()");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(d), "1", null);
            l.l().i();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void i() {
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference != null && weakReference.get() != null && this.f9077a.get().y() != null) {
            this.f9077a.get().e(false);
            this.f9077a.get().y().e();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void j() {
        if (x.b().q2()) {
            if (!x.b().T2()) {
                return;
            }
            x.b().Z0();
            x.b().I().r();
            WeakReference<BNavigatorLogic> weakReference = this.f9077a;
            if (weakReference != null && weakReference.get() != null) {
                this.f9077a.get().b(1);
                return;
            }
            return;
        }
        x.b().y(1);
        WeakReference<BNavigatorLogic> weakReference2 = this.f9077a;
        if (weakReference2 != null && weakReference2.get() != null && this.f9077a.get().y() != null) {
            this.f9077a.get().y().c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void k() {
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference != null && weakReference.get() != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("1.9");
            this.f9077a.get().G().o();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_zoom_in"));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void l() {
        WeakReference<BNavigatorLogic> weakReference;
        if (!com.baidu.navisdk.ui.util.g.a() && (weakReference = this.f9077a) != null && weakReference.get() != null) {
            this.f9077a.get().k();
            this.f9077a.get().z().g();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void m() {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("1.5", "2", null, null);
        com.baidu.navisdk.ui.routeguide.b.V().I();
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public boolean n() {
        return x.b().e3();
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public boolean o() {
        com.baidu.navisdk.module.routepreference.g a2 = com.baidu.navisdk.module.routeresult.logic.plate.a.b().a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onPlateLimitChangeReCalcRoute: " + a2);
        }
        if (a2 == null || TextUtils.isEmpty(a2.getPlateNumber(0))) {
            return false;
        }
        a0.G = 3;
        int d = com.baidu.navisdk.ui.routeguide.b.V().d().d();
        if (gVar.d()) {
            LogUtil.e("RouteGuide", "onPlateLimitChangeReCalcRoute() --> reCalcRoute():" + d);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(d), "1", null);
        l.l().i();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void p() {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "网络连接不可用");
            return;
        }
        if (BNRoutePlaner.getInstance().B()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航路线偏好不可用");
        } else if (x.b().w2()) {
            x.b().u1();
        } else {
            x.b().x4();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void t() {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.L();
        }
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference != null && weakReference.get() != null) {
            this.f9077a.get().z().c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void a(boolean z) {
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f9077a.get().z().d();
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void c(boolean z) {
        WeakReference<BNavigatorLogic> weakReference = this.f9077a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (z) {
            this.f9077a.get().z().a(true);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_open_roadcondition"));
        } else {
            this.f9077a.get().z().a(false);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_close_roadcondition"));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void d() {
        r.i().b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void a(int i, int i2, int i3, Object obj) {
        WeakReference<BNavigatorLogic> weakReference;
        WeakReference<BNavigatorLogic> weakReference2;
        if (2 == i) {
            if (i3 == 0) {
                if (1 == i2) {
                    x.b().I3();
                    return;
                } else {
                    if (i2 == 0) {
                        x.b().F0();
                        return;
                    }
                    return;
                }
            }
            if (1 == i2) {
                WeakReference<BNavigatorLogic> weakReference3 = this.f9077a;
                if (weakReference3 == null || weakReference3.get() == null || this.f9077a.get().v() == null) {
                    return;
                }
                this.f9077a.get().v().a(101, 4, ((Integer) obj).intValue(), this);
                return;
            }
            if (i2 != 0 || (weakReference2 = this.f9077a) == null || weakReference2.get() == null || this.f9077a.get().v() == null) {
                return;
            }
            this.f9077a.get().v().a(101, 5, ((Integer) obj).intValue(), this);
            return;
        }
        if (3 == i) {
            WeakReference<BNavigatorLogic> weakReference4 = this.f9077a;
            if (weakReference4 == null || weakReference4.get() == null) {
                return;
            }
            this.f9077a.get().p0();
            this.f9077a.get().G().a(i3 != 100, obj instanceof Bundle ? (Bundle) obj : null);
            return;
        }
        if (5 == i) {
            if (i2 == 0) {
                com.baidu.navisdk.framework.b.a(3, (Object) 0);
                return;
            }
            if (1 == i2) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
                BNRouteGuider.getInstance().calcOtherRoute(2, 1);
                return;
            }
            if (2 == i2) {
                a(false);
                com.baidu.navisdk.framework.b.a(5, (Object) 0);
                return;
            } else {
                if (3 == i2) {
                    WeakReference<BNavigatorLogic> weakReference5 = this.f9077a;
                    if (weakReference5 != null && weakReference5.get() != null) {
                        this.f9077a.get().e(false);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "7");
                    com.baidu.navisdk.framework.b.a(18, bundle);
                    return;
                }
                return;
            }
        }
        if (6 == i) {
            if (i2 != 0 || (weakReference = this.f9077a) == null || weakReference.get() == null) {
                return;
            }
            this.f9077a.get().z().a(i3);
            return;
        }
        if (9 != i) {
            if (10 == i) {
                com.baidu.navisdk.comapi.commontool.c.c().a((RoutePlanNode) obj);
                return;
            }
            return;
        }
        int a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a();
        if (com.baidu.navisdk.ui.routeguide.b.V().d().a(a2)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(a2), "1", null);
            l.l().i();
            return;
        }
        HashMap hashMap = (HashMap) obj;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (hashMap.size() == 1) {
            for (Map.Entry entry : hashMap.entrySet()) {
                arrayList.add(entry.getKey());
                if (entry.getValue() != null && ((ArrayList) entry.getValue()).size() != 0) {
                    arrayList2 = (ArrayList) entry.getValue();
                }
            }
        }
        r.i().a((ArrayList<String>) arrayList, (ArrayList<String>) arrayList2, 20, 0);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void b() {
        r.i().e();
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void c() {
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        LogUtil.e("RouteGuide", "onMultiRouteSwitchAction");
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.5", "", null, null);
        BNRoutePlaner.getInstance().n(com.baidu.navisdk.module.pronavi.model.i.f().e);
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().clearLayer(23);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void a(int i) {
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(i == 1 ? "asr_e_c_main_route" : i == 2 ? "asr_e_c_slave_route" : i == 4 ? "asr_e_c_viaduck_route" : i == 8 ? "asr_e_c_ground_route" : null));
        BNRouteGuider.getInstance().onlineChangeRoute(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.subview.a
    public void a(View view, int i) {
        com.baidu.navisdk.ui.routeguide.model.g.h().a(i);
        if (i == 0) {
            ((TextView) view).setText("高速");
        } else if (i == 1) {
            ((TextView) view).setText("中速");
        } else {
            if (i != 2) {
                return;
            }
            ((TextView) view).setText("低速");
        }
    }
}
