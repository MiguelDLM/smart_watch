package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.u;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.nplatform.comapi.MapItem;

/* loaded from: classes8.dex */
public class v implements com.baidu.navisdk.module.pronavi.abs.b, com.baidu.navisdk.framework.interfaces.pronavi.k {

    /* renamed from: a, reason: collision with root package name */
    private u f8604a;
    private u.c b;
    private com.baidu.navisdk.module.pronavi.model.c c;
    private com.baidu.navisdk.pronavi.ui.base.b d = com.baidu.navisdk.ui.routeguide.b.V().s();

    /* loaded from: classes8.dex */
    public class a implements u.c {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.control.u.c
        public void a() {
            x.b().I().b(false);
            x.b().c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.control.u.c
        public void b() {
            x.b().I().b(true);
            x.b().Y2();
        }

        @Override // com.baidu.navisdk.ui.routeguide.control.u.c
        public void c() {
            v.this.c();
        }
    }

    private void e() {
        if (this.b != null) {
            return;
        }
        this.b = new a();
    }

    private boolean f() {
        if (!BNSettingManager.isRoadConditionAllowClick()) {
            return false;
        }
        if (com.baidu.navisdk.util.common.x.s()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionControl", "isAllowShowPanel: isMockGuide");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGRoadConditionControl", "isAllowShowPanel:isIndoorParkState ");
            }
            return false;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x() && !a0.I().t) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGRoadConditionControl", "isAllowShowPanel hasCalcRouteOk -- > false ,  cannot updateData!");
            }
            return false;
        }
        if (a0.I().D() && !a0.I().r()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGRoadConditionControl", "isAllowShowPanel Yawing now! cannot updateData!");
            }
            return false;
        }
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGRoadConditionControl", "isAllowShowPanel: EnlargeRoadmap");
            }
            return false;
        }
        if (x.b().C2()) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar6.d()) {
                gVar6.e("RGRoadConditionControl", "isAllowShowPanel: isShowEnlargeRoadMap");
            }
            return false;
        }
        return true;
    }

    private boolean g() {
        return com.baidu.navisdk.ui.routeguide.utils.b.y();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public boolean a(com.baidu.navisdk.module.pronavi.model.c cVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionControl", "handleClickJamIcon: " + cVar);
        }
        if (cVar != null && cVar.c()) {
            if (!f()) {
                if (gVar.d()) {
                    gVar.e("RGRoadConditionControl", "handleClickJamIcon not allow show panel");
                }
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.16.4", "1");
                return false;
            }
            if (cVar.n) {
                boolean b = b(cVar);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.16.2", "0", String.valueOf(cVar.c), String.valueOf(cVar.b));
                return b;
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                return false;
            }
            boolean c = c(cVar);
            this.c = cVar;
            return c;
        }
        if (gVar.c()) {
            gVar.c("RGRoadConditionControl", "handleClickJamIcon: jamModel == null");
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.16.4", "0");
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public void b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionControl", "hideAvoidJamPanel: ");
        }
        u uVar = this.f8604a;
        if (uVar != null) {
            uVar.a();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionControl", "resetBigLabel: " + BNavigatorLogic.z0);
        }
        this.c = null;
        if (BNavigatorLogic.z0 && g()) {
            ((com.baidu.navisdk.pronavi.data.vm.h) this.d.c(com.baidu.navisdk.pronavi.data.vm.h.class)).i();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionControl", "showBigLabel: " + BNavigatorLogic.z0 + ", " + this.c);
        }
        if (BNavigatorLogic.z0 && this.c != null && g()) {
            ((com.baidu.navisdk.pronavi.data.vm.h) this.d.c(com.baidu.navisdk.pronavi.data.vm.h.class)).a(this.c);
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    private boolean b(com.baidu.navisdk.module.pronavi.model.c cVar) {
        if (x.b().O2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (!gVar.d()) {
                return false;
            }
            gVar.e("RGRoadConditionControl", "clickAvoidJam isVdrGuide()");
            return false;
        }
        if (this.f8604a == null) {
            this.f8604a = new u();
        }
        e();
        this.f8604a.a(this.b);
        return this.f8604a.a(cVar);
    }

    private boolean c(com.baidu.navisdk.module.pronavi.model.c cVar) {
        s.T().o();
        Bundle bundle = new Bundle();
        bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, cVar.b);
        bundle.putInt("onroute", 1);
        bundle.putInt("source", 16);
        bundle.putInt(MapItem.KEY_JAM_INDEX, cVar.h);
        bundle.putInt("jamVersion", cVar.i);
        bundle.putString("routeMD5", cVar.j);
        bundle.putInt("page", 1);
        bundle.putInt("ridx", 0);
        bundle.putBoolean("isZoomBaseMap", false);
        bundle.putBoolean("isHighlightedState", false);
        com.baidu.navisdk.ui.routeguide.b.V().a(cVar.f7463a, true, bundle);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.16.3", String.valueOf(cVar.c), String.valueOf(cVar.b));
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionControl", "handleAvoidJamRouteDisappear: " + i);
        }
        u uVar = this.f8604a;
        if (uVar != null) {
            uVar.a(i);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.k
    public boolean a() {
        u uVar = this.f8604a;
        return uVar != null && uVar.b();
    }
}
