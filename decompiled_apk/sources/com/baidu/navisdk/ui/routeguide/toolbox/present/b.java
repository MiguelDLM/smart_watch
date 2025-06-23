package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.view.View;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.abtest.model.i;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.toolbox.e;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.toolbox.view.a f9115a;
    private com.baidu.navisdk.ui.routeguide.subview.a b;
    private a.o c;
    private e d;

    public b(com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar) {
        this.f9115a = aVar;
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    public void b(int i) {
        LogUtil.e("RGToolBoxPresent", "updateToolBoxItemState index :" + i);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void c() {
        this.f9115a.r0();
        this.c = null;
    }

    public void d() {
        this.f9115a.E(false);
    }

    public void e() {
        LogUtil.e("RGToolBoxPresent", "initViewStatus");
        e eVar = this.d;
        if (eVar != null) {
            eVar.d();
        }
        j();
        if (BNCommSettingManager.getInstance().isMoreBtnNeedNewTag()) {
            this.f9115a.v(0);
        }
    }

    public boolean f() {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.f9115a;
        if (aVar != null && aVar.x0()) {
            return true;
        }
        return false;
    }

    public void g() {
        this.f9115a.h("正在计算路线");
    }

    public void h() {
        this.f9115a.s0();
    }

    public void i() {
        this.f9115a.g("正在算路，请稍等");
    }

    public void j() {
        String str;
        String str2;
        String str3;
        com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        if (b != null) {
            str = b.c();
            str3 = b.d();
            str2 = b.e();
        } else {
            str = "";
            str2 = "";
            str3 = str2;
        }
        this.f9115a.a(str3, str2);
        this.f9115a.i(str);
    }

    public void k() {
        this.f9115a.g("您已偏离路线");
    }

    public void l() {
        if (this.f9115a.w0()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.j", "2", null, null);
        }
        com.baidu.navisdk.ui.routeguide.b.V().w();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
    }

    public void m() {
        this.f9115a.E(true);
    }

    public void n() {
        e eVar = this.d;
        if (eVar != null) {
            eVar.a();
        }
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.f9115a;
        if (aVar != null) {
            aVar.v(0);
        }
    }

    public void o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGToolBoxPresent", "updateTrafficCount: " + this.f9115a);
        }
        if (this.f9115a != null) {
            com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
            if (b != null) {
                this.f9115a.d(b.f(), b.i());
            } else {
                this.f9115a.d(0, 0);
            }
        }
    }

    public void p() {
        com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        if (b != null && b.j()) {
            this.f9115a.j(b.g() + " " + b.h());
        }
    }

    public void q() {
        LogUtil.e("RGToolBoxPresent", "updateViewStatus");
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.b = aVar;
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public void b(boolean z) {
        this.f9115a.s0();
    }

    public void a(View view, int i) {
        LogUtil.e("RGToolBoxPresent", "RGToolBoxPresent onClick key :" + i);
        e eVar = this.d;
        if (eVar == null || !eVar.a(view, i)) {
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            switch (i) {
                case 9:
                    if (this.b != null) {
                        if (k != null) {
                            k.w0();
                        }
                        if (BNSettingManager.isQuitNaviEnable()) {
                            this.b.m();
                            com.baidu.navisdk.module.abtest.model.k.x().t();
                            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", "1", null);
                            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_quit_navi"));
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (k != null) {
                        k.t();
                    }
                    if (this.f9115a.x0()) {
                        this.f9115a.n0();
                        return;
                    }
                    LogUtil.e("RGToolBoxPresent", "RGToolboxConstant.ViewIndex.OPEN_CLOSE_VIEW - open bottomBar");
                    this.f9115a.A0();
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.j", "1", null, null);
                    return;
                case 11:
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.6");
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGToolBoxPresent", "RGToolboxConstant.ViewIndex.CONTINUE_NAV, mSubViewListener= " + this.b);
                    }
                    if (this.b != null) {
                        if (k != null) {
                            k.A();
                        }
                        this.b.a(3, 0, 0, null);
                    }
                    b();
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_continue_navi"));
                    return;
                case 12:
                    com.baidu.navisdk.ui.routeguide.subview.a aVar = this.b;
                    if (aVar != null) {
                        aVar.a(3, 0, 0, null);
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.5", null, null, "");
                        if (i.w().o() == 1 || i.w().o() == 2) {
                            i.w().s();
                        }
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_multi_route_continue"));
                        return;
                    }
                    return;
                case 13:
                    com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.c();
                        if (i.w().o() == 1 || i.w().o() == 2) {
                            i.w().v();
                            return;
                        }
                        return;
                    }
                    return;
                case 14:
                    a.o oVar = this.c;
                    if (oVar != null) {
                        oVar.a();
                        this.c = null;
                    }
                    com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar3 = this.f9115a;
                    if (aVar3 != null) {
                        aVar3.r0();
                        return;
                    }
                    return;
                case 15:
                    com.baidu.navisdk.ui.routeguide.subview.a aVar4 = this.b;
                    if (aVar4 != null) {
                        aVar4.d();
                    }
                    this.f9115a.D(true);
                    return;
                case 16:
                    boolean p = a0.I().p();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGToolBoxPresent VIA_ETA", "onClick TIME_AND_DIST_LY -> hasViaEtaDetails = " + p);
                    }
                    if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d0() == 1) {
                        if (f()) {
                            b();
                            return;
                        }
                        LogUtil.e("RGToolBoxPresent", "RGToolboxConstant.ViewIndex.TIME_AND_DIST_LY - open bottomBar");
                        this.f9115a.A0();
                        if (k != null) {
                            k.a0();
                        }
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.j", "1", null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        a(true);
    }

    public void a(int i) {
        if (i == 0) {
            this.f9115a.C(false);
            this.f9115a.x(i);
        } else {
            if (i != 1) {
                return;
            }
            if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                this.f9115a.B(com.baidu.navisdk.poisearch.model.a.k().g() > 0);
                this.f9115a.C(true);
            } else {
                this.f9115a.C(false);
                this.f9115a.x(i);
            }
        }
    }

    public void a(boolean z) {
        com.baidu.navisdk.ui.routeguide.toolbox.view.a aVar = this.f9115a;
        if (aVar != null) {
            if (z) {
                aVar.n0();
            } else {
                aVar.o0();
            }
        }
    }

    public void a(String str, a.o oVar) {
        this.f9115a.f(str);
        this.c = oVar;
    }

    public void a() {
        BNCommSettingManager.getInstance().setMoreBtnNeedNewTag(false);
    }
}
