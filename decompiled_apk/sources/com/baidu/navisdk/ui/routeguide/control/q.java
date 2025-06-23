package com.baidu.navisdk.ui.routeguide.control;

import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8578a;

    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final q f8579a = new q();
    }

    public static q c() {
        return b.f8579a;
    }

    private int d() {
        return x.b().V();
    }

    public void a(ArrayList<GeoPoint> arrayList, Rect rect, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapController", "updateMapView searchPois size :" + arrayList.size());
        }
        int size = arrayList.size();
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            GeoPoint geoPoint = arrayList.get(i5);
            if (geoPoint != null) {
                if (i > geoPoint.getLongitudeE6()) {
                    i = geoPoint.getLongitudeE6();
                }
                if (i3 < geoPoint.getLongitudeE6()) {
                    i3 = geoPoint.getLongitudeE6();
                }
                if (i4 < geoPoint.getLatitudeE6()) {
                    i4 = geoPoint.getLatitudeE6();
                }
                if (i2 > geoPoint.getLatitudeE6()) {
                    i2 = geoPoint.getLatitudeE6();
                }
            }
        }
        Bundle c = com.baidu.navisdk.util.common.o.c(i3, i2);
        Bundle c2 = com.baidu.navisdk.util.common.o.c(i, i4);
        int i6 = c.getInt("MCx");
        int i7 = c.getInt("MCy");
        int i8 = c2.getInt("MCx");
        int i9 = c2.getInt("MCy");
        Bundle bundle = new Bundle();
        bundle.putLong("left", i8);
        bundle.putLong("right", i6);
        bundle.putLong("top", i9);
        bundle.putLong("bottom", i7);
        a(new Rect(i8, i9, i6, i7), rect, z, j.b.eAnimationNone, -1);
    }

    public void b() {
        int d;
        int i;
        int i2;
        int i3;
        com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
        if (mapController == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.utils.a aVar = com.baidu.navisdk.ui.routeguide.utils.a.f9151a;
        int e = aVar.e();
        int d2 = aVar.d();
        com.baidu.navisdk.pronavi.mapshow.i.b m = com.baidu.navisdk.ui.routeguide.utils.b.m();
        com.baidu.navisdk.pronavi.mapshow.i.a a2 = m != null ? m.a(e, d2) : null;
        if (a2 != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMapController", "setMapShowScreenRect: " + a2.a());
            }
            mapController.a(a2.a(com.baidu.navisdk.module.pronavi.model.h.f7469a, com.baidu.navisdk.ui.routeguide.b.V().b()));
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().B()) {
            BNMapController.getInstance().setMapShowScreenRect(0, 0, BNMapController.getInstance().getScreenWidth(), BNMapController.getInstance().getScreenHeight() - ScreenUtil.getInstance().dip2px(45));
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMapController", "setMapShowScreenRect origin: " + e + "," + d2);
        }
        boolean z = com.baidu.navisdk.ui.routeguide.model.i.s().k() && this.f8578a;
        int e2 = com.baidu.navisdk.ui.util.b.e(R.dimen.nsdk_rg_toolbox_margin_left);
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_panel_height);
        if (1 == com.baidu.navisdk.module.pronavi.model.h.f7469a) {
            int dip2px = com.baidu.navisdk.ui.routeguide.b.V().E() ? d2 - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u) : d2;
            if (z) {
                i = dip2px / 2;
            } else {
                if (x.b().f2()) {
                    i = com.baidu.navisdk.module.newguide.a.e().c();
                } else if (x.b().N2()) {
                    i = com.baidu.navisdk.module.newguide.a.e().c();
                } else if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    i = 0;
                } else if (com.baidu.navisdk.ui.routeguide.model.m.y().u() && x.b().h2()) {
                    i = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_mini_height);
                } else {
                    i = com.baidu.navisdk.module.newguide.a.e().c();
                }
                if (com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
                    i += ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
                }
                if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                    i -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
                }
                if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                    i += ScreenUtil.getInstance().dip2px(60);
                }
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                d2 -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
            }
            int dip2px2 = RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) ? d2 - ScreenUtil.getInstance().dip2px(200) : (d2 - dimensionPixelSize) - e2;
            if (!com.baidu.navisdk.j.d()) {
                int[] professionalNaviRouteMargin = BNSettingManager.getProfessionalNaviRouteMargin();
                if (gVar2.d()) {
                    gVar2.e("RGStateFullView", "left = " + professionalNaviRouteMargin[0] + ", top = " + professionalNaviRouteMargin[1] + ", right = " + professionalNaviRouteMargin[2] + ", bottom = " + professionalNaviRouteMargin[3]);
                }
                r6 = professionalNaviRouteMargin[0];
                int i4 = professionalNaviRouteMargin[1];
                e = com.baidu.navisdk.pronavi.util.a.h.e() - professionalNaviRouteMargin[2];
                if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                    i3 = professionalNaviRouteMargin[3] + ScreenUtil.getInstance().dip2px(60);
                } else {
                    i3 = professionalNaviRouteMargin[3];
                }
                dip2px2 = dip2px - i3;
                i = i4;
            }
            i2 = dip2px2 - b(true);
        } else {
            if (com.baidu.navisdk.module.newguide.a.e().d()) {
                dimensionPixelSize = 0;
            }
            int dip2px3 = com.baidu.navisdk.ui.routeguide.b.V().E() ? d2 - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t) : d2;
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                if (z) {
                    d = (dip2px3 - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) / 2;
                } else {
                    d = d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
                }
                d2 -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
            } else if (z) {
                d = dip2px3 / 2;
            } else {
                d = d();
            }
            int b2 = d2 - b(false);
            int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
                d += statusBarHeight;
            }
            i = com.baidu.navisdk.ui.routeguide.b.V().r().g() ? statusBarHeight : 0;
            r6 = d;
            int dip2px4 = RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) ? e - ScreenUtil.getInstance().dip2px(200) : (e - dimensionPixelSize) - e2;
            e = b2;
            i2 = dip2px4;
        }
        if (gVar2.d()) {
            gVar2.e("RGMapController", "setMapShowScreenRect left:" + r6 + " top:" + i + " right" + e + "bottom:" + i2);
        }
        Rect rect = new Rect(r6, i, e, i2);
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && k.c0() != null) {
            rect = k.c0();
        }
        mapController.a(rect);
    }

    private q() {
        this.f8578a = true;
    }

    public void a(Rect rect, Rect rect2, boolean z, j.b bVar, int i) {
        a(rect, rect2, z, bVar, i, false);
    }

    public void a(Rect rect, Rect rect2, boolean z, j.b bVar, int i, boolean z2) {
        int i2;
        int i3;
        if (!com.baidu.navisdk.ui.routeguide.b.V().E()) {
            com.baidu.navisdk.framework.interfaces.pronavi.hd.f b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(1);
            if (b2.b()) {
                i3 = z ? b2.d : b2.e;
            } else {
                i2 = 0;
                BNMapController.getInstance().updateMapViewByBound(rect, rect2, z, bVar, i, i2, z2);
            }
        } else if (z) {
            i3 = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
        } else {
            i3 = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
        }
        i2 = i3;
        BNMapController.getInstance().updateMapViewByBound(rect, rect2, z, bVar, i, i2, z2);
    }

    public void a() {
        this.f8578a = true;
    }

    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e("RGMapController", "setBoundByEnlarge = " + z);
        }
        this.f8578a = z;
    }

    private int b(boolean z) {
        int i;
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(1);
        if (b2.f6817a == 2) {
            i = z ? b2.d : b2.e;
        } else {
            i = 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapController", "getHDMapHeight: " + z + ",curHDState: , size:" + i);
        }
        return i;
    }
}
