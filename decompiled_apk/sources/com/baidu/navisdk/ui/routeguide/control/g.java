package com.baidu.navisdk.ui.routeguide.control;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.k1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.v0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class g implements com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.model.b f8542a;
    private boolean b;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.framework.interfaces.y {
        public a(g gVar) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.y
        public View[] B() {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.k kVar;
            if (i.g().c(1001)) {
                kVar = i.g().a(1001);
            } else if (i.g().c(1002)) {
                kVar = i.g().a(1002);
            } else if (i.g().c(1004)) {
                kVar = i.g().a(1004);
            } else if (i.g().c(1005)) {
                kVar = i.g().a(1005);
            } else {
                kVar = null;
            }
            if (kVar == null || kVar.e() == null || !kVar.e().isShown()) {
                return null;
            }
            return new View[]{kVar.e()};
        }
    }

    public g() {
        new com.baidu.navisdk.util.worker.loop.a("RGArriveRemindController");
        this.b = false;
        this.f8542a = new com.baidu.navisdk.ui.routeguide.model.b();
    }

    private boolean i() {
        if (RouteGuideFSM.getInstance().isBrowseState()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "allowViaCardDisplay -> isBrowseState,return false!");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGArriveRemindController - DestRemind", "allowViaCardDisplay -> isRoused,return false!");
            }
            return false;
        }
        if (x.b().S1()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGArriveRemindController - DestRemind", "allowViaCardDisplay -> ugc visible ,return false!");
            }
            return false;
        }
        if (x.b().i2()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGArriveRemindController - DestRemind", "allowViaCardDisplay -> isHighwaySubscriptViewVisibilty ,return false!");
            }
            return false;
        }
        return true;
    }

    private void j() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "handleUIForCard ->");
        }
        s.T().a(false, false, false);
        x.b().u1();
        x.b().o3();
        x.b().a1();
        x.b().t1();
        x.b().a(false);
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            com.baidu.navisdk.ui.routeguide.b.V().w();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        }
    }

    private Bitmap k() {
        Bitmap bitmap;
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getDestStreetViewInfo(bundle);
        if (!bundle.isEmpty()) {
            byte[] byteArray = bundle.getByteArray(RouteGuideParams.RGKey.ExpandMap.ImageBytes);
            if (byteArray != null && byteArray.length > 0) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArriveRemindController - DestRemind", "obtainStreetImage Image Buf is not Null!");
                }
                try {
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                } catch (OutOfMemoryError e) {
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGArriveRemindController - DestRemind", "obtainStreetImage Image crash : " + e);
                    }
                }
                a().a(bitmap);
                return bitmap;
            }
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGArriveRemindController - DestRemind", "obtainStreetImage Image Buf is Null!");
            }
        } else {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGArriveRemindController - DestRemind", "obtainStreetImage return !! data == null!");
            }
        }
        bitmap = null;
        a().a(bitmap);
        return bitmap;
    }

    public com.baidu.navisdk.ui.routeguide.model.b a() {
        return this.f8542a;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void c() {
        i.g().b(1006);
    }

    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "hideArriveServiceAreaCard-> ");
        }
        i.g().b(1004);
    }

    public void e() {
        i.g().b(1001);
    }

    public void f() {
        e();
        d();
        c();
    }

    public boolean g() {
        return this.b;
    }

    public void h() {
        k1 k1Var = new k1();
        f();
        i.g().a(k1Var);
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        com.baidu.navisdk.ui.routeguide.model.b bVar = this.f8542a;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void a(int i) {
        a(i, 0);
    }

    public com.baidu.navisdk.framework.interfaces.y b() {
        return new a(this);
    }

    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "handleArriveViaReminderMsg--> index = " + i);
        }
        if (!i()) {
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "handleArriveViaReminderMsg--> allowViaCardDisplay=false, return !");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetViaPoint(i, bundle)) {
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "handleArriveViaReminderMsg: index --> " + i + ", bundle: " + bundle);
            }
            GeoPoint geoPoint = new GeoPoint((int) (bundle.getDouble("x") * 100000.0d), (int) (bundle.getDouble("y") * 100000.0d));
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            if (bVar.c(geoPoint)) {
                a().g();
                com.baidu.navisdk.module.nearbysearch.model.a b = bVar.b(geoPoint);
                if (b != null) {
                    b.setPoiType(i2);
                    a(b);
                }
                com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null) {
                    k.f(i);
                    return;
                }
                return;
            }
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "handleArriveViaReminderMsg: isViaNode --> false");
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "handleArriveViaReminderMsg: Error --> GetViaPoint returns false");
        }
    }

    public void a(RoutePlanNode routePlanNode) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "showArriveViaReminderCard--> RoutePlanNode = " + routePlanNode.toString());
        }
        if (routePlanNode != null) {
            if (BNSettingManager.isShowRemindDialog()) {
                j();
                i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.h(routePlanNode));
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.1", "", null, null);
        }
    }

    public void a(boolean z, RoutePlanNode routePlanNode) {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "DestRemind showArriveDestReminderCard -> hasDestPark = " + z + ", routePlanNode = " + routePlanNode);
        }
        if (routePlanNode != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.f fVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.f(z, routePlanNode);
            f();
            i.g().a(fVar);
            boolean z2 = a().e() != null;
            if (!z && !z2) {
                str = "1";
            } else if (z && !z2) {
                str = "2";
            } else if (z || !z2) {
                str = (z && z2) ? "4" : "";
            } else {
                str = "3";
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", str, null, null);
        }
    }

    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveRemindController - DestRemind", "DestRemind handleCardDisplay -> hasDestPark= " + z);
        }
        Bitmap k = k();
        if (!z && this.f8542a.c() <= 50 && k == null) {
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "DestRemind 车点与终点距离<=50米，且没有停车场和目的地街景图,直接退出导航!");
            }
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        RoutePlanNode g = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        if (g == null) {
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "DestRemind 算路节点为null直接退出导航!");
            }
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        a(z, g);
    }

    public boolean a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showArriveServiceAreaCard-> data: ");
            sb.append(dVar == null ? "null" : dVar.toString());
            gVar.e("RGArriveRemindController - DestRemind", sb.toString());
        }
        if (!i()) {
            if (gVar.d()) {
                gVar.e("RGArriveRemindController - DestRemind", "showArriveServiceAreaCard--> allowViaCardDisplay=false, return !");
            }
            return false;
        }
        if (dVar == null) {
            return false;
        }
        f();
        j();
        i.g().a(new v0(dVar));
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.3", null, null, null);
        return true;
    }
}
