package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class k implements com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.util.a f8564a;
    private int b;
    private int c = 30000;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.ui.util.a {
        public a(k kVar, long j) {
            super(j);
        }

        @Override // com.baidu.navisdk.ui.util.a
        public void onFinish() {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    private void d() {
        com.baidu.navisdk.ui.util.a aVar = this.f8564a;
        if (aVar != null) {
            aVar.cancel();
            this.f8564a = null;
        }
        a aVar2 = new a(this, this.c);
        this.f8564a = aVar2;
        aVar2.start();
    }

    private void e(@Nullable Bundle bundle) {
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null) {
            s.j().e("RGChargeStationListComponent").a(4002).a(bundle).a();
        }
    }

    private void f(@Nullable Bundle bundle) {
        com.baidu.navisdk.poisearch.model.b.m().b((GeoPoint) null);
        com.baidu.navisdk.poisearch.model.b.m().a((com.baidu.navisdk.model.datastruct.chargestation.b) null);
        x.b().B0();
        BNMapController.getDynamicOverlay().cancelZoom(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
    }

    private void g(@Nullable Bundle bundle) {
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null) {
            s.j().e("RGParkingLotListComponent").a(2).a(bundle).a();
        }
    }

    private void h(@NonNull Bundle bundle) {
        Serializable serializable = bundle.getSerializable("service_area_info");
        if (!(serializable instanceof com.baidu.navisdk.module.pronavi.model.d)) {
            return;
        }
        com.baidu.navisdk.module.pronavi.model.d dVar = (com.baidu.navisdk.module.pronavi.model.d) serializable;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "ROUTE_AROUND_NE_CS_BUBBLE --> info = " + dVar);
        }
        if (!TextUtils.isEmpty(dVar.h()) && dVar.j() != null) {
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.mName = dVar.h();
            aVar.mGeoPoint = dVar.j();
            aVar.mUID = dVar.i();
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.d(aVar)) {
                if (gVar.d()) {
                    gVar.e("RGDynamicLayerStateController", "handleBkgClick return isViaPoint");
                    return;
                }
                return;
            }
            com.baidu.navisdk.poisearch.model.b.m().b(aVar.mGeoPoint);
            com.baidu.navisdk.poisearch.model.b.m().a(dVar);
            GeoPoint j = dVar.j();
            Bundle c = com.baidu.navisdk.util.common.o.c(j.getLongitudeE6(), j.getLatitudeE6());
            com.baidu.navisdk.model.datastruct.b a2 = new com.baidu.navisdk.model.datastruct.b().b(1528).a(new com.baidu.nplatform.comapi.basestruct.c(c.getInt("MCx"), c.getInt("MCy")));
            a2.a(dVar.i());
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            x.b().c(this.b, false);
            BNMapController.getDynamicOverlay().setDataSet(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
            BNMapController.getDynamicOverlay().showAll(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA);
            BNMapController.getDynamicOverlay().zoomBySid(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA, 1, new String[]{dVar.i()}, new int[]{1});
            BNMapController.getInstance().resetRouteDetailIndex();
        }
    }

    private void i(@NonNull Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "showChargeStationListView: " + bundle);
        }
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null) {
            s.j().e("RGChargeStationListComponent").a(4001).a(bundle).a();
        }
    }

    private void j(@NonNull Bundle bundle) {
        Serializable serializable = bundle.getSerializable("charge_station_info");
        if (!(serializable instanceof com.baidu.navisdk.model.datastruct.chargestation.b)) {
            return;
        }
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) serializable;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "ROUTE_AROUND_NE_CS_BUBBLE --> info = " + bVar);
        }
        if (!TextUtils.isEmpty(bVar.j()) && bVar.g() != null) {
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.mName = bVar.j();
            aVar.mGeoPoint = bVar.g();
            aVar.mUID = bVar.p();
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.d(aVar)) {
                if (gVar.d()) {
                    gVar.e("RGDynamicLayerStateController", "handleBkgClick return isViaPoint");
                }
            } else {
                com.baidu.navisdk.poisearch.model.b.m().b(aVar.mGeoPoint);
                com.baidu.navisdk.poisearch.model.b.m().a(bVar);
                x.b().b(this.b, false);
                BNMapController.getDynamicOverlay().zoomBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, 3, new String[]{bVar.p()}, new int[]{1});
                BNMapController.getInstance().resetRouteDetailIndex();
            }
        }
    }

    private void k(@NonNull Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "showParkRecListView: " + bundle);
        }
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null) {
            s.j().e("RGParkingLotListComponent").a(1).a(bundle).a();
        }
    }

    public void a(@Nullable Bundle bundle) {
        b();
        int i = bundle == null ? this.b : bundle.getInt("key_type_show_views", this.b);
        this.b = i;
        if (i == 3 || i == 4) {
            f(bundle);
        } else if (i == 5) {
            d(bundle);
        } else if (i == 6) {
            e(bundle);
        } else if (i == 7) {
            g(bundle);
        }
        this.b = 0;
    }

    public void b(Bundle bundle) {
        int i = this.b;
        if (i == 3 || i == 4) {
            c();
        }
    }

    public void c(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.c = bundle.getInt("key_auto_exit_time", 30000);
        int i = bundle.getInt("key_type_show_views", 0);
        this.b = i;
        if (i == 3 || i == 4) {
            d();
            j(bundle);
        } else if (i == 5) {
            d();
            h(bundle);
        } else if (i == 6) {
            i(bundle);
        } else {
            if (i != 7) {
                return;
            }
            k(bundle);
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        this.b = 0;
    }

    private void b() {
        com.baidu.navisdk.ui.util.a aVar = this.f8564a;
        if (aVar != null) {
            aVar.cancel();
            this.f8564a = null;
        }
    }

    private void d(@Nullable Bundle bundle) {
        com.baidu.navisdk.poisearch.model.b.m().b((GeoPoint) null);
        com.baidu.navisdk.poisearch.model.b.m().a((com.baidu.navisdk.module.pronavi.model.d) null);
        x.b().C0();
        BNMapController.getDynamicOverlay().cancelZoom(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA);
        BNMapController.getDynamicOverlay().clear(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA);
    }

    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "singleTabMap --> type = " + i + ", event = " + i2);
        }
        int i3 = this.b;
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    private void c() {
        com.baidu.navisdk.model.datastruct.chargestation.b c = com.baidu.navisdk.poisearch.model.b.m().c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "onConfigurationChangedWhenNePointShow --> info = " + c);
        }
        if (c == null || TextUtils.isEmpty(c.j()) || c.g() == null) {
            return;
        }
        BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, c.p());
        BNMapController.getDynamicOverlay().zoomBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, 3, new String[]{c.p()}, new int[]{1});
        BNMapController.getInstance().resetRouteDetailIndex();
    }

    public boolean a(int i, int i2, String str, @NonNull MapItem mapItem) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "singleTabMap --> key = " + i + ", id = " + i2 + ", sid = " + str + ", mapItem = " + mapItem);
        }
        int i3 = this.b;
        if (i3 != 3 && i3 != 4 && i3 != 5) {
            return false;
        }
        d();
        return false;
    }

    public void a() {
        int i = this.b;
        if (i == 6 || i == 7) {
            return;
        }
        d();
    }

    public void a(com.baidu.navisdk.model.datastruct.chargestation.b bVar) {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        boolean z = (s == null || (a2 = s.j().e("RGChargeStationListComponent").a(4003).a()) == null || !a2.b("resultA")) ? false : true;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicLayerStateController", "handlerClickNeAroundChargeStationBubble: " + bVar + ", isShowList:" + z);
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid", bVar.p());
        bundle.putInt("key_type_show_views", 6);
        bundle.putInt("src", 1);
        if (z) {
            c(bundle);
        } else {
            boolean b = com.baidu.navisdk.ui.routeguide.utils.b.b("chargeStation", false);
            if (gVar.d()) {
                gVar.e("RGDynamicLayerStateController", "handleOnClick : exitHDNavi:" + b);
            }
            if (!b && com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            if (RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.BrowseMap)) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.11.9", "1", "1", "0");
    }

    public void a(String str) {
        com.baidu.navisdk.apicenter.h a2;
        if (i.g().c(1013)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDynamicLayerStateController", "handlerClickParkingRecBubble: is show dest recommend card, return!");
                return;
            }
            return;
        }
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        boolean z = (s == null || (a2 = s.j().e("RGParkingLotListComponent").a(3).a()) == null || !a2.b("resultA")) ? false : true;
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGDynamicLayerStateController", "handlerClickParkingRecBubble: " + str + ", isShowList:" + z);
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        bundle.putBoolean("show_by_click", true);
        bundle.putInt("key_type_show_views", 7);
        if (z) {
            c(bundle);
        } else {
            boolean b = com.baidu.navisdk.ui.routeguide.utils.b.b("parkingRec", false);
            if (gVar2.d()) {
                gVar2.e("RGDynamicLayerStateController", "handleOnClick : exitHDNavi:" + b);
            }
            if (!b && com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            if (RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.BrowseMap)) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1465");
    }

    public boolean a(int i) {
        return this.b == i;
    }
}
