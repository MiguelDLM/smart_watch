package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class d implements n {
    private static boolean b = true;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.util.worker.f f9068a = new a("enterFullViewState3s", null);

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (!BNavigatorLogic.z0) {
                return null;
            }
            d.this.l();
            return null;
        }
    }

    public d(BNavigatorLogic bNavigatorLogic) {
        new WeakReference(bNavigatorLogic);
    }

    private void q() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.f9068a, true);
    }

    private void r() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c;
        if (com.baidu.navisdk.ui.routeguide.utils.b.A() && (j = com.baidu.navisdk.ui.routeguide.b.V().j()) != null && (c = j.c(false)) != null) {
            c.c();
        }
    }

    public boolean a(long j) {
        if (j > 0) {
            c(false);
            com.baidu.navisdk.util.worker.c.a().a(this.f9068a, new com.baidu.navisdk.util.worker.e(2, 0), j);
        } else {
            c(true);
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void b(boolean z) {
        if (!com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b() || z) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a(false);
        x.b().C3();
    }

    public void c(boolean z) {
        if (z) {
            RouteGuideFSM.getInstance().setFullViewByUser(z);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_FULL_VIEW);
        x.b().i5();
    }

    public void d(boolean z) {
        b = z;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void e() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().y4();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void f() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h5();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public boolean g() {
        return b;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void h() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().x1();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public ViewGroup i() {
        return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b0();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void j() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().m();
    }

    public boolean k() {
        a(0L);
        return true;
    }

    public boolean l() {
        Bundle bundle;
        if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            bundle = new Bundle();
            bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_NEED_EXECUTE_GLASS_FMS, false);
        } else {
            bundle = null;
        }
        return a(true, bundle);
    }

    public boolean m() {
        RouteGuideFSM.getInstance().setFullViewByUser(false);
        l();
        return true;
    }

    public void n() {
        LogUtil.e("BNProNaviUIAction", "recoverNaviState -> isSetFullViewByUser= " + RouteGuideFSM.getInstance().isSetFullViewByUser());
        LogUtil.printCallStack();
        if (RouteGuideFSM.getInstance().isSetFullViewByUser()) {
            k();
        } else {
            l();
        }
    }

    public boolean o() {
        if (com.baidu.navisdk.ui.routeguide.control.b.k().f() >= 21) {
            return false;
        }
        BNMapController.getInstance().setDragMapStatus(true);
        com.baidu.navisdk.ui.routeguide.control.b.k().g();
        x.b().a(0L);
        BNMapController.getInstance().getMapController().d(true);
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void onDestroy() {
        q();
    }

    public boolean p() {
        if (com.baidu.navisdk.ui.routeguide.control.b.k().f() <= 4) {
            return false;
        }
        BNMapController.getInstance().setDragMapStatus(true);
        com.baidu.navisdk.ui.routeguide.control.b.k().h();
        x.b().a(0L);
        BNMapController.getInstance().getMapController().d(true);
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public boolean d() {
        return x.b().X1();
    }

    public boolean a(boolean z, Bundle bundle) {
        com.baidu.navisdk.module.pronavi.model.i.f().b = false;
        q();
        r();
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNProNaviUIAction", "enterNaviState-> RGFSMTable.FsmEvent.ENTRY_INDOOR_PARK");
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_INDOOR_PARK);
            return true;
        }
        if (!RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.BrowseMap) && !RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.IndoorParkBrowse)) {
            if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.NearbySearch)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNProNaviUIAction", "enterNaviState-> getTopState() == RGFSMTable.FsmState.NearbySearch");
                }
                r.i().d();
                return true;
            }
            if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNProNaviUIAction", "enterNaviState-> getTopState() == RGFSMTable.FsmState.DynamicLayer");
                }
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                return true;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNProNaviUIAction", "enterNaviState->:" + z);
            }
            if (!z) {
                return true;
            }
            RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getLastestMap2DOr3DStateFromLocal(), bundle);
            return true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNProNaviUIAction", "enterNaviState-> getTopState() == BrowseMap");
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT, bundle);
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public boolean b() {
        return x.b().B2();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void c() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().z4();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public boolean a(int i, boolean z) {
        return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(i, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void a(int i, int i2, String str) {
        s.T().a(i, i2, str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public boolean a() {
        return x.b().I().e();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.n
    public void a(boolean z) {
        x.b().U(z);
    }
}
