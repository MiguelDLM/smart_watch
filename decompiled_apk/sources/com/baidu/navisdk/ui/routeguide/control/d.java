package com.baidu.navisdk.ui.routeguide.control;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8535a;
    private static boolean b;
    private static volatile boolean c;

    @oOoXoXO
    private static com.baidu.navisdk.module.park.a d;

    @OOXIXo
    public static final d e = new d();

    private d() {
    }

    private final com.baidu.navisdk.module.park.a i() {
        String str;
        com.baidu.navisdk.module.park.a c2 = com.baidu.navisdk.module.park.a.c(com.baidu.navisdk.framework.b.q());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSaveParkData-->saveParkListData:");
            if (c2 != null) {
                str = c2.toString();
            } else {
                str = null;
            }
            sb.append(str);
            gVar.e("RGAceParkController", sb.toString());
        }
        return c2;
    }

    private final void j() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "hideRecommendPoi---");
        }
        BNMapController.getDynamicOverlay().hideAll(900);
    }

    private final boolean k() {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        int q = V.q();
        com.baidu.navisdk.framework.interfaces.t i = com.baidu.navisdk.module.vehiclemanager.b.i();
        IIX0o.oO(i, "BNVehicleManager.getInstance()");
        boolean f = i.f();
        com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V2, "BNavigator.getInstance()");
        boolean A = V2.A();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "sceneType -> " + q + ", isCar = " + f + ", isFromCarLink = " + A);
        }
        if (f && q != 3 && !A) {
            return true;
        }
        return false;
    }

    public final void a(boolean z) {
        b = z;
    }

    public final boolean b() {
        return c;
    }

    @oOoXoXO
    public final RoutePlanNode c() {
        RoutePlanNode routePlanNode;
        String str;
        String str2;
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.logicframe.b h = V.h();
        if (h != null && (h instanceof com.baidu.navisdk.pronavi.logic.base.a)) {
            routePlanNode = ((com.baidu.navisdk.pronavi.logic.base.a) h).k();
        } else {
            routePlanNode = null;
        }
        com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V2, "BNavigator.getInstance()");
        com.baidu.navisdk.module.pronavi.model.f n = V2.n();
        IIX0o.oO(n, "BNavigator.getInstance().navigatorModel");
        RoutePlanNode a2 = n.a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "getOriginalEndNode-->destMainNode = " + routePlanNode + ", lastTimeCalcEndNode = " + a2);
        }
        if (routePlanNode != null) {
            str = routePlanNode.getUID();
        } else {
            str = null;
        }
        if (a2 != null) {
            str2 = a2.getUID();
        } else {
            str2 = null;
        }
        if (!TextUtils.equals(str, str2)) {
            return null;
        }
        return a2;
    }

    public final boolean d() {
        return f8535a;
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "onEnterCarParkGuide---");
        }
        f8535a = true;
        c = false;
        BNMapController.getInstance().setACEParkViewMode(1);
        com.baidu.baidunavis.maplayer.e.k().b(true);
    }

    public final void f() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "onEnterIntelligentDest---");
        }
        c = true;
        j();
        BNMapController.getInstance().setACEParkViewMode(0);
        BNMapController.getInstance().setMap2DLook(true);
        com.baidu.baidunavis.maplayer.e.k().b(true);
    }

    public final void g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "onExitCarParkGuide---");
        }
        f8535a = false;
        b = false;
        d = null;
        c = false;
        BNMapController.getInstance().setACEParkViewMode(0);
        com.baidu.baidunavis.maplayer.e.k().b(false);
        BNMapController.getInstance().showLayer(8, true);
    }

    public final void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAceParkController", "onQuitNavi---");
        }
        f8535a = false;
        b = false;
        d = null;
        c = false;
        BNMapController.getInstance().setACEParkViewMode(0);
        com.baidu.baidunavis.maplayer.e.k().b(true);
    }

    public final void a(@oOoXoXO com.baidu.navisdk.module.park.a aVar) {
        d = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(@OXOo.oOoXoXO com.baidu.navisdk.module.park.a r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.control.d.b(com.baidu.navisdk.module.park.a):void");
    }

    public final boolean a() {
        if (!k()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGAceParkController", "canShowDestRecommendCard: isSupportedCarType is false");
            }
            return false;
        }
        RoutePlanNode c2 = c();
        boolean e0 = com.baidu.navisdk.framework.b.e0();
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("canShowDestRecommendCard: isAcePark = ");
            sb.append(f8535a);
            sb.append(" , ");
            sb.append("hasStallRecord = ");
            sb.append(b);
            sb.append(" , endNode = ");
            sb.append(c2 != null ? c2.toString() : null);
            sb.append(", userIsLogin = ");
            sb.append(e0);
            gVar2.e("RGAceParkController", sb.toString());
        }
        if (!f8535a || (c2 == null && !(b && e0))) {
            return false;
        }
        b(null);
        return true;
    }
}
