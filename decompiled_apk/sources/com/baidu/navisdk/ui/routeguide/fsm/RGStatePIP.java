package com.baidu.navisdk.ui.routeguide.fsm;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.ui.routeguide.model.g;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.nplatform.comapi.map.l;

/* loaded from: classes8.dex */
public class RGStatePIP extends RGBaseState {
    private static final String TAG = "RGStatePIP";

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        super.excute(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        BNMapController.getInstance().setMap2DLook(false);
        BNMapController.getInstance().setCompassVisible(BNCommSettingManager.getInstance().isShowCarDirCompass());
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        if (!g.h().e()) {
            BNRouteGuider.getInstance().SetFullViewState(false);
            a.a().d(new l(false));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        BNMapController.getInstance().setCompassVisible(false);
        g.h().c(false);
        g.h().g();
        BNRouteGuider.getInstance().SetFullViewState(false);
        b bVar = null;
        BNMapController.getInstance().sendCommandToMapEngine(4, null);
        Bundle bundle = this.enterParams;
        if (bundle == null || !bundle.getBoolean("not_set_mapstate", false)) {
            bVar = com.baidu.navisdk.ui.routeguide.control.b.k().c();
        }
        if (bVar != null) {
            int i = h.f7469a;
            if (1 == i) {
                bVar.i = 0L;
                bVar.j = -ScreenUtil.getInstance().dip2px(10);
            } else if (2 == i) {
                bVar.i = 0L;
                bVar.j = 0L;
            }
            float GetCarRotateAngle = (float) BNRouteGuider.getInstance().GetCarRotateAngle();
            bVar.b = GetCarRotateAngle;
            if (GetCarRotateAngle < 0.01f && GetCarRotateAngle >= 0.0f) {
                bVar.b = 0.01f;
            }
            bVar.c = 0;
            BNMapController.getInstance().setMap2DLook(true);
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
            bVar.f9474a = 17.0f;
            b.C0522b c0522b = bVar.g;
            c0522b.f9476a = 0;
            c0522b.c = 0;
            c0522b.d = 0;
            c0522b.b = 0;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "setMapStatus -> " + bVar.toString());
            }
            BNMapController.getInstance().setMapStatus(bVar, j.b.eAnimationArc, 0, true);
        }
        BNRouteGuider.getInstance().setBrowseStatus(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        BNRouteGuider.getInstance().setRotateMode(0);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
    }
}
