package com.baidu.navisdk.cruise.control;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.base.c;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f6765a;
    private boolean b;
    private com.baidu.navisdk.cruise.listeners.a c;
    private final BNMapObserver d = new C0189a();

    /* renamed from: com.baidu.navisdk.cruise.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0189a implements BNMapObserver {
        public C0189a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(c cVar, int i, int i2, Object obj) {
            g gVar = g.CRUISE;
            if (gVar.d()) {
                gVar.e("CruiseMapController", "update: " + i + ", event:" + i2);
            }
            if (1 == i && (i2 == 257 || i2 == 274)) {
                if (i2 == 274) {
                    a.this.l();
                }
                if (gVar.d()) {
                    if (i2 == 257) {
                        gVar.e("CruiseMapController", "update event_map_animation_finished");
                    } else {
                        gVar.e("CruiseMapController", "update EVENT_MAP_ZOOM_UPDATE");
                    }
                }
                if (a.this.c != null) {
                    a.this.c.b(i2);
                }
                a.this.e();
            }
            if (2 == i && a.this.c != null) {
                a.this.c.a(i2);
            }
        }
    }

    public a(Context context) {
        this.b = false;
        this.f6765a = context;
        this.b = false;
    }

    private void f() {
        com.baidu.navisdk.poisearch.c.a();
        com.baidu.navisdk.poisearch.c.b();
    }

    private float g() {
        double GetCarRotateAngle;
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getVehicleInfo(bundle);
        if (bundle.containsKey("vehicle_angle")) {
            GetCarRotateAngle = bundle.getDouble("vehicle_angle");
        } else {
            GetCarRotateAngle = BNRouteGuider.getInstance().GetCarRotateAngle();
        }
        return (float) GetCarRotateAngle;
    }

    private com.baidu.navisdk.model.datastruct.g h() {
        if (this.b) {
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (BNRouteGuider.getInstance().getCarPoint(iArr, iArr2) && iArr[0] != 0 && iArr2[0] != 0) {
                g gVar = g.CRUISE;
                if (gVar.d()) {
                    gVar.e("CruiseMapController", "getCarPointLocation: Engine value is valid");
                }
                com.baidu.navisdk.model.datastruct.g gVar2 = new com.baidu.navisdk.model.datastruct.g();
                gVar2.b = iArr[0] / 100000.0d;
                gVar2.f6926a = iArr2[0] / 100000.0d;
                return gVar2;
            }
        }
        g gVar3 = g.CRUISE;
        if (gVar3.d()) {
            gVar3.e("CruiseMapController", "getCarPointLocation: Engine value is invalid, engineStarted " + this.b);
        }
        return com.baidu.navisdk.model.a.g().f();
    }

    private void i() {
        boolean z;
        if (com.baidu.navisdk.cruise.prefer.a.g().a() == 2) {
            z = true;
        } else {
            z = false;
        }
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "initMapStatus: isNorth2D " + z);
        }
        if (z) {
            a();
        } else {
            a(h(), false);
        }
    }

    private int j() {
        int b = com.baidu.navisdk.cruise.prefer.a.g().b();
        if (b < 15) {
            return 15;
        }
        if (b > 21) {
            return 18;
        }
        return b;
    }

    private void k() {
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "setMapInitScaleLevel");
        }
        b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus == null) {
            if (gVar.c()) {
                gVar.c("CruiseMapController", "setMapInitScaleLevel fail mapStatus is null");
                return;
            }
            return;
        }
        int j = j();
        mapStatus.f9474a = j;
        mapStatus.b = 0.0f;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "onCreateView map level " + j);
        }
        BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationNone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int zoomLevel = BNMapController.getInstance().getZoomLevel();
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "save MapScaleLevel = " + zoomLevel);
        }
        if (zoomLevel < 15) {
            zoomLevel = 15;
        } else if (zoomLevel > 21) {
            zoomLevel = 18;
        }
        com.baidu.navisdk.cruise.prefer.a.g().a(zoomLevel);
    }

    public void c() {
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "initMapView");
        }
        BNMapController.getInstance().deleteAllObserver();
        com.baidu.nplatform.comapi.map.a.c().a(this.d);
        f();
        BNMapController.getInstance().setDrawHouse(false);
        BNMapController.getInstance().setNightMode(false);
        BNRouteGuider.getInstance().SetFullViewState(false);
        k();
        boolean f = com.baidu.navisdk.cruise.prefer.a.g().f();
        if (gVar.d()) {
            gVar.e("CruiseMapController", "initMapView mIsItsOpen: " + f);
        }
        b(f);
    }

    public void d() {
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "restoreMapView: ");
        }
        l();
        BNRouteGuider.getInstance().setBrowseStatus(true);
        com.baidu.nplatform.comapi.map.a.c().b(this.d);
        BNMapController.getInstance().setDrawHouse(true);
        BNMapController.getInstance().setNightMode(true ^ com.baidu.navisdk.ui.util.b.c());
        if (com.baidu.navisdk.j.d()) {
            NavMapManager.getInstance().syncMapTraffic();
        }
    }

    public void e() {
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().UpdataBaseLayers();
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b() {
        BNRouteGuider.getInstance().SetFullViewState(false);
        BNMapController.getInstance().enableTouchEventLookover(true);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        i();
    }

    private void a(com.baidu.navisdk.model.datastruct.g gVar, boolean z) {
        g gVar2 = g.CRUISE;
        if (gVar2.d()) {
            gVar2.e("CruiseMapController", "changeToCar3DView with locData, anim " + z);
        }
        a(gVar, false, z);
        BNRouteGuider.getInstance().setRotateMode(0);
    }

    public void b(boolean z) {
        if (z) {
            BNMapController.getInstance().switchITSMode(true);
            BNMapController.getInstance().showTrafficMap(true);
        } else {
            BNMapController.getInstance().showTrafficMap(false);
        }
    }

    public void a() {
        g gVar = g.CRUISE;
        if (gVar.d()) {
            gVar.e("CruiseMapController", "changeToNorth2DView");
        }
        a(h(), true, true);
        BNRouteGuider.getInstance().setRotateMode(1);
    }

    private void a(com.baidu.navisdk.model.datastruct.g gVar, boolean z, boolean z2) {
        b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            mapStatus.b = z ? 0.0f : g();
            mapStatus.c = z ? 0 : -45;
            mapStatus.j = a(this.f6765a.getResources().getConfiguration().orientation == 1, z);
            mapStatus.i = 0L;
            g gVar2 = g.CRUISE;
            if (gVar2.d()) {
                gVar2.e("CruiseMapController", "setMapStatus: north2D " + z + ", anim " + z2 + ", " + gVar);
            }
            if (gVar != null && gVar.b()) {
                Bundle b = o.b(gVar.b, gVar.f6926a);
                int i = b.getInt("MCx");
                int i2 = b.getInt("MCy");
                mapStatus.d = i;
                mapStatus.e = i2;
            }
            j.b bVar = z2 ? j.b.eAnimationAll : j.b.eAnimationNone;
            mapStatus.f9474a = -1.0f;
            BNMapController.getInstance().setMapStatus(mapStatus, bVar);
        }
    }

    private long a(boolean z, boolean z2) {
        long j;
        int widthPixels;
        int dimensionPixelSize;
        if (z2) {
            j = 0;
        } else {
            if (z) {
                widthPixels = ScreenUtil.getInstance().getHeightPixels();
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_panel_height);
            } else {
                widthPixels = ScreenUtil.getInstance().getWidthPixels();
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_panel_height) * 3;
            }
            j = (-(widthPixels - dimensionPixelSize)) / 4;
        }
        g gVar = g.CRUISE;
        if (gVar.b()) {
            gVar.b("CruiseMapController", "getMapYOffset: isPortrait " + z + ", is2DNorth " + z2 + ", Y offset " + j);
        }
        return j;
    }
}
