package com.baidu.navisdk.ui.routeguide.fsm;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.pronavi.carlogooffset.i.a;
import com.baidu.navisdk.pronavi.data.model.e;
import com.baidu.navisdk.ui.routeguide.c;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.nplatform.comapi.map.l;
import kotlin.Pair;

/* loaded from: classes8.dex */
public class RGStateCar3D extends RGGlassState {
    private static final String TAG = "RGStateCar3D";

    public static void setXYOffset(b bVar) {
        a aVar;
        boolean z;
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
            pair = aVar.a(h.f7469a, 1, null);
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
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e(TAG, "setXYOffset: " + h.f7469a);
        }
        int i = h.f7469a;
        if (1 == i) {
            if (!j.d() && (c.g().b() != 0 || c.g().d() != 0)) {
                bVar.i = c.g().b();
                bVar.j = c.g().d();
            } else if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                bVar.i = 0L;
                bVar.j = -(((com.baidu.navisdk.pronavi.util.a.h.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u)) / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_172dp));
            } else {
                bVar.i = 0L;
                if (com.baidu.navisdk.ui.routeguide.utils.b.b(1).f6817a == 0) {
                    bVar.j = -((com.baidu.navisdk.pronavi.util.a.h.d() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_172dp));
                } else {
                    bVar.j = -(((com.baidu.navisdk.pronavi.util.a.h.d() - r0.b) / 4) + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp));
                }
            }
        } else if (2 == i) {
            if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState()) && i.s().k()) {
                z = true;
            } else {
                z = false;
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                if (z) {
                    bVar.i = (com.baidu.navisdk.pronavi.util.a.h.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) / 4;
                } else {
                    bVar.i = (x.b().V() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) / 2;
                }
            } else if (z) {
                bVar.i = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.c() / 4;
            } else {
                bVar.i = x.b().V() / 2;
            }
            bVar.j = -((com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_map_status_y_offset));
        }
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && k.b(true) != null && k.b(true).length == 2) {
            long[] b = k.b(true);
            bVar.i = b[0];
            bVar.j = b[1];
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        super.enter(bundle);
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
        BNMapController.getInstance().setMap2DLook(false);
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
        com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        com.baidu.navisdk.ui.routeguide.control.b.k().a(true);
        com.baidu.navisdk.ui.routeguide.model.g.h().g();
        if (com.baidu.navisdk.module.pronavi.model.i.f().d) {
            com.baidu.navisdk.module.pronavi.model.i.f().d = false;
            BNRouteGuider.getInstance().SetFullViewState(false);
        }
        b bVar = null;
        BNMapController.getInstance().sendCommandToMapEngine(4, null);
        Bundle bundle = this.enterParams;
        if (bundle == null || !bundle.getBoolean("not_set_mapstate", false)) {
            bVar = com.baidu.navisdk.ui.routeguide.control.b.k().c();
        }
        if (bVar != null) {
            setXYOffset(bVar);
            float GetCarRotateAngle = (float) BNRouteGuider.getInstance().GetCarRotateAngle();
            bVar.b = GetCarRotateAngle;
            if (GetCarRotateAngle < 0.01f && GetCarRotateAngle >= 0.0f) {
                bVar.b = 0.01f;
            }
            bVar.c = -45;
            if (com.baidu.navisdk.ui.routeguide.b.V().q() == 3) {
                bVar.c = 0;
                BNMapController.getInstance().setMap2DLook(true);
            }
            Bundle bundle2 = new Bundle();
            boolean vehicleInfo = BNRouteGuider.getInstance().getVehicleInfo(bundle2);
            double d = bundle2.getDouble("vehicle_stPosX");
            double d2 = bundle2.getDouble("vehicle_stPosY");
            if (vehicleInfo && d != OOXIXo.f3760XO && d2 != OOXIXo.f3760XO) {
                Bundle b = o.b(d, d2);
                bVar.d = b.getDouble("MCx_D");
                bVar.e = b.getDouble("MCy_D");
            } else {
                GeoPoint a2 = com.baidu.navisdk.util.logic.h.a();
                if (a2 == null || (!a2.isValid() && com.baidu.navisdk.util.logic.g.j().f())) {
                    a2 = com.baidu.navisdk.util.logic.g.j().c();
                }
                if (a2 != null) {
                    Bundle b2 = o.b(a2.getLongitudeE6() / 100000.0d, a2.getLatitudeE6() / 100000.0d);
                    bVar.d = b2.getDouble("MCx_D");
                    bVar.e = b2.getDouble("MCy_D");
                }
            }
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
        }
        BNRouteGuider.getInstance().setBrowseStatus(false);
        com.baidu.navisdk.pronavi.ui.base.b uiContext = getUiContext();
        if (uiContext != null && (eVar = (e) uiContext.b(e.class)) != null) {
            eVar.a().setValue(RGFSMTable.FsmState.Car3D);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        BNRouteGuider.getInstance().setRotateMode(0);
        com.baidu.navisdk.ui.routeguide.control.l.l().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGGlassState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        if (!com.baidu.navisdk.module.pronavi.model.i.f().b) {
            x.b().k(false);
            if (!x.b().D2()) {
                BNMapController.getInstance().recoveryHighLightRoute();
            }
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().b(1);
        com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        if (!RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice) && !RouteGuideFSM.getInstance().isBrowseState() && !i.s().k()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a();
            x.b().I().b(true);
            x.b().Y2();
            x.b().I().o();
        }
        x.b().c();
        ProNaviStatItem.O().F();
        x.b().h(RGFSMTable.FsmState.Car3D);
        if (a0.I().D()) {
            x.b().D0();
            x.b().U0();
            x.b().M0();
            x.b().Y0();
        }
        x.b().I().c(false);
        t.s().f();
        com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
        if (j != null) {
            j.j();
        }
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.r0();
        }
    }
}
