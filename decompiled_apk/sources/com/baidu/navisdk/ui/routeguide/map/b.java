package com.baidu.navisdk.ui.routeguide.map;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.ui.routeguide.control.k;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.d;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.routeguide.navicenter.c;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.MapItem;

/* loaded from: classes8.dex */
public class b implements BNDynamicOverlay.OnClickListener {
    public b(BNavigatorLogic bNavigatorLogic) {
    }

    @Override // com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay.OnClickListener
    public void onClicked(int i, int i2, String str, @NonNull MapItem mapItem) {
        boolean z;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicOverlayClickListener", "onClickDynamicOverlay --> key = " + i + ", id = " + i2 + ", sid = " + str);
        }
        c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        k g = j != null ? j.g() : null;
        boolean z2 = true;
        if (!RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.DynamicLayer)) {
            z = false;
        } else if (g != null && g.a(i, i2, str, mapItem)) {
            return;
        } else {
            z = true;
        }
        if (i == 974) {
            if (gVar.d()) {
                gVar.e("RGDynamicOverlayClickListener", "DEST_REC_LAYER --> sid = " + str);
            }
            if (!com.baidu.navisdk.poisearch.model.a.k().h() && !TextUtils.isEmpty(str)) {
                if (g == null || (!g.a(0) && !g.a(7))) {
                    z2 = false;
                }
                if (!z || g == null || z2) {
                    if (g != null) {
                        g.a(str);
                        return;
                    }
                    return;
                } else {
                    if (gVar.d()) {
                        gVar.e("RGDynamicOverlayClickListener", "ROUTE_AROUND_NE_CS_BUBBLE TYPE_SHOW_CAR_SUBSCRIBE_ADD_VIA_POINT_VIEW");
                        return;
                    }
                    return;
                }
            }
            if (gVar.d()) {
                gVar.e("RGDynamicOverlayClickListener", "DEST_REC_LAYER: isRouteSearchMode");
                return;
            }
            return;
        }
        if (i != 994) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RGDynamicOverlayClickListener", "ROUTE_AROUND_NE_CS_BUBBLE --> sid = " + str);
        }
        if (!com.baidu.navisdk.poisearch.model.a.k().h() && !TextUtils.isEmpty(str)) {
            if (z && g != null && g.a(5)) {
                if (gVar.d()) {
                    gVar.e("RGDynamicOverlayClickListener", "ROUTE_AROUND_NE_CS_BUBBLE TYPE_SHOW_CAR_SUBSCRIBE_ADD_VIA_POINT_VIEW");
                    return;
                }
                return;
            }
            com.baidu.navisdk.model.datastruct.chargestation.b c = d.c(str);
            if (gVar.d()) {
                gVar.e("RGDynamicOverlayClickListener", "ROUTE_AROUND_NE_CS_BUBBLE --> info = " + c);
            }
            if (c == null || TextUtils.isEmpty(c.j()) || c.g() == null) {
                return;
            }
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.mName = c.j();
            aVar.mGeoPoint = c.g();
            aVar.mUID = c.p();
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.d(aVar)) {
                if (gVar.d()) {
                    gVar.e("RGDynamicOverlayClickListener", "handleBkgClick return isViaPoint");
                    return;
                }
                return;
            } else {
                if (g != null) {
                    g.a(c);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.3.1", "2", null, null);
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.1");
                return;
            }
        }
        if (gVar.d()) {
            gVar.e("RGDynamicOverlayClickListener", "ROUTE_AROUND_NE_CS_BUBBLE: isRouteSearchMode");
        }
    }
}
