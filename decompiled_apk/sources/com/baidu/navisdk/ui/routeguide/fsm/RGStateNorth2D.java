package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.pronavi.carlogooffset.i.a;
import com.baidu.navisdk.pronavi.data.model.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.nplatform.comapi.map.l;
import kotlin.Pair;

/* loaded from: classes8.dex */
public class RGStateNorth2D extends RGGlassState {
    private static final String TAG = "RGStateNorth2D";

    public static void setXYOffset(b bVar, boolean z) {
        a aVar;
        if (bVar == null) {
            return;
        }
        com.baidu.navisdk.pronavi.carlogooffset.i.b f = com.baidu.navisdk.ui.routeguide.utils.b.f();
        Pair<Long, Long> pair = null;
        if (f != null) {
            aVar = f.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "strategy setXYOffset: " + aVar.a());
            }
            pair = aVar.a(h.f7469a, 2, null);
        }
        if (pair != null) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(TAG, "strategy setXYOffset: " + pair);
            }
            bVar.i = pair.getFirst().longValue();
            bVar.j = pair.getSecond().longValue();
            return;
        }
        int i = h.f7469a;
        if (1 == i) {
            bVar.i = 0L;
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                if (z) {
                    bVar.j = -((com.baidu.navisdk.pronavi.util.a.h.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u)) / 5);
                } else {
                    bVar.j = -(ScreenUtil.getInstance().dip2px(20) - (ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u) / 2));
                }
            } else if (z) {
                bVar.j = -(com.baidu.navisdk.pronavi.util.a.h.d() / 5);
            } else {
                bVar.j = -ScreenUtil.getInstance().dip2px(20);
            }
        } else if (2 == i) {
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                if (z) {
                    bVar.i = (com.baidu.navisdk.pronavi.util.a.h.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) / 4;
                } else {
                    bVar.i = (x.b().V() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) / 2;
                }
            } else if (z) {
                bVar.i = com.baidu.navisdk.pronavi.util.a.h.d() / 4;
            } else {
                bVar.i = x.b().V() / 2;
            }
            bVar.j = 0L;
        }
        k k = c.p().k();
        if (k != null && k.b(false) != null && k.b(false).length == 2) {
            long[] b = k.b(false);
            bVar.i = b[0];
            bVar.j = b[1];
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter() {
        super.enter();
        if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
            h.b = true;
        } else {
            h.b = false;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        super.excute(bundle);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "excute by reflection - enterParams = " + bundle.toString());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        if (!com.baidu.navisdk.ui.routeguide.model.g.h().e()) {
            BNRouteGuider.getInstance().SetFullViewState(false);
            com.baidu.navisdk.framework.message.a.a().d(new l(false));
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().D()) {
            BNMapController.getDynamicOverlay().showAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        e eVar;
        boolean z;
        com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        com.baidu.navisdk.ui.routeguide.model.g.h().g();
        if (i.f().d) {
            i.f().d = false;
            BNRouteGuider.getInstance().SetFullViewState(false);
        }
        GeoPoint a2 = com.baidu.navisdk.util.logic.h.a();
        if (a2 == null || (!a2.isValid() && com.baidu.navisdk.util.logic.g.j().f())) {
            a2 = com.baidu.navisdk.util.logic.g.j().c();
        }
        b bVar = null;
        BNMapController.getInstance().sendCommandToMapEngine(4, null);
        Bundle bundle = this.enterParams;
        if (bundle == null || !bundle.getBoolean("not_set_mapstate", false)) {
            bVar = com.baidu.navisdk.ui.routeguide.control.b.k().c();
        }
        if (bVar != null && a2 != null) {
            bVar.b = 1.0f;
            bVar.c = 0;
            if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState()) && com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                z = true;
            } else {
                z = false;
            }
            setXYOffset(bVar, z);
            Bundle b = o.b(a2.getLongitudeE6() / 100000.0d, a2.getLatitudeE6() / 100000.0d);
            bVar.d = b.getInt("MCx");
            bVar.e = b.getInt("MCy");
            bVar.f9474a = -1.0f;
            b.C0522b c0522b = bVar.g;
            c0522b.f9476a = 0;
            c0522b.c = 0;
            c0522b.d = 0;
            c0522b.b = 0;
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                BNMapController.getInstance().setMapStatus(bVar, j.b.eAnimationArc, 0, true);
            } else {
                BNMapController.getInstance().setMapStatus(bVar, j.b.eAnimationArc, 1000, true);
            }
        } else {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "st = " + bVar + ", carPt = " + a2);
            }
        }
        BNRouteGuider.getInstance().setBrowseStatus(false);
        com.baidu.navisdk.pronavi.ui.base.b uiContext = getUiContext();
        if (uiContext != null && (eVar = (e) uiContext.b(e.class)) != null) {
            eVar.a().setValue(RGFSMTable.FsmState.North2D);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        BNRouteGuider.getInstance().setRotateMode(1);
        com.baidu.navisdk.ui.routeguide.control.l.l().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGGlassState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        ProNaviStatItem.O().I();
        if (!i.f().b) {
            x.b().k(false);
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().b(2);
        com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        if (!RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice) && !RouteGuideFSM.getInstance().isBrowseState() && !com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a();
            x.b().I().b(true);
            x.b().Y2();
            x.b().I().o();
        }
        x.b().c();
        x.b().h(RGFSMTable.FsmState.North2D);
        x.b().I().c(false);
        t.s().f();
        com.baidu.navisdk.framework.interfaces.locationshare.a j = c.p().j();
        if (j != null) {
            j.j();
        }
        k k = c.p().k();
        if (k != null) {
            k.r0();
        }
    }
}
