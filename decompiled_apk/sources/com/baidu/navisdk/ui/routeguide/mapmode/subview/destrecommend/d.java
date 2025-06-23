package com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.interfaces.walk.a;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.control.i;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.f0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.logic.h;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.UIMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class d implements e {
    private static final BNDynamicOverlay j = BNMapController.getDynamicOverlay();

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c f8749a;
    private final f b;
    private c.a e;
    private int f;
    private int c = -1;
    private int d = -1;
    private final com.baidu.navisdk.util.worker.lite.b g = new a("drc_cl");
    com.baidu.navisdk.comapi.routeplan.v2.a h = new b();
    private final BNDynamicOverlay.OnClickListener i = new C0456d();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            d.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.comapi.routeplan.v2.a {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.lite.b {
            public a(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                d.this.b.b();
                BNMapController.getInstance().showLayer(8, false);
            }
        }

        public b() {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public String getName() {
            return null;
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar, Bundle bundle) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 || i == 4) {
                        g gVar = g.ROUTE_GUIDE;
                        if (gVar.d()) {
                            gVar.e("DestRecommend", "calc car failed");
                        }
                        if (d.this.c == -1) {
                            if (gVar.d()) {
                                gVar.e("DestRecommend", "calc route id -1");
                                return;
                            }
                            return;
                        } else {
                            d.this.b.b();
                            d.this.b.b(UIMsg.UI_TIP_DEFAULT_SERVER_ERROR);
                            BNMapController.getInstance().resetRouteDetailIndex(false);
                            BNRoutePlaner.getInstance().b(d.this.h);
                            d.this.c = -1;
                            return;
                        }
                    }
                    return;
                }
                g gVar2 = g.ROUTE_GUIDE;
                if (gVar2.d()) {
                    gVar2.e("DestRecommend", "calc car success");
                }
                if (d.this.c == -1) {
                    if (gVar2.d()) {
                        gVar2.e("DestRecommend", "calc route id -1");
                        return;
                    }
                    return;
                }
                BNMapController.getInstance().setPreFinishStatus(false);
                BNMapController.getInstance().resetRouteDetailIndex(false);
                BNMapController.getInstance().setRouteDetailIndex(-1);
                d.j.focusIds(BNDynamicOverlay.Key.DEST_RECOMMEND_POI, d.this.e.f8747a);
                d dVar2 = d.this;
                dVar2.a(1, dVar2.e.d, d.this.e.c, d.this.h());
                BNRoutePlaner.getInstance().b(d.this.h);
                com.baidu.navisdk.util.worker.lite.a.c(new a("dt_rp_scu"));
                d.this.c = -1;
                return;
            }
            d.this.b.a();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.InterfaceC0200a {
        public c(d dVar) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0456d implements BNDynamicOverlay.OnClickListener {
        public C0456d() {
        }

        @Override // com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay.OnClickListener
        public void onClicked(int i, int i2, String str, @NonNull MapItem mapItem) {
            if (i == 10023) {
                d.this.e();
            } else if (i == 10022) {
                d.this.b(i2);
            }
            d.this.a();
        }
    }

    public d(f fVar, com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar) {
        this.b = fVar;
        this.f8749a = cVar;
    }

    private com.baidu.nplatform.comapi.basestruct.c g() {
        GeoPoint b2 = h.b();
        Bundle c2 = o.c(b2.getLongitudeE6(), b2.getLatitudeE6());
        return new com.baidu.nplatform.comapi.basestruct.c(c2.getInt("MCx"), c2.getInt("MCy"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        int remainDist = BNRouteGuider.getInstance().getRemainDist();
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("DestRecommend", "total dist:" + remainDist);
        }
        return "驾车" + l0.b(remainDist, l0.a.ZH);
    }

    private void i() {
        j();
        TTSPlayerControl.stopVoiceTTSOutput();
        BNMapController.getInstance().resetRouteDetailIndex();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_EXIT_ARRIVE_DEST);
        i.g().b(1008);
        x.b().l3();
        BNMapController.getInstance().showLayer(8, true);
        f0.d().a(502);
        f0.d().b(502);
    }

    private void j() {
        if (2 != com.baidu.navisdk.module.pronavi.a.j) {
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), System.currentTimeMillis() / 1000);
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.comapi.commontool.c.c);
        }
    }

    private void k() {
        com.baidu.navisdk.framework.b.b();
        BNMapController.getInstance().setPreFinishStatus(true);
        BNMapController.getInstance().clearLayer(8);
        BNMapController.getInstance().showLayer(8, false);
        BNRouteGuider.getInstance().removeRoute(0);
    }

    public void e() {
        c.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar = this.f8749a;
        if (aVar == cVar.e) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.a", this.f8749a.b, this.e.b);
        } else {
            c.b bVar = cVar.c.get(this.f);
            if (bVar != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.a", bVar.f8748a, this.e.b);
            }
        }
        c.a aVar2 = this.e;
        int i = aVar2.h;
        if (i == 0) {
            e(aVar2);
        } else if (i == 1) {
            i();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void onDestroy() {
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("DestRecommend", "onDestroy");
        }
        com.baidu.navisdk.framework.b.b();
        BNRoutePlaner.getInstance().b(this.h);
        BNDynamicOverlay bNDynamicOverlay = j;
        bNDynamicOverlay.removeClickedListener(this.i);
        bNDynamicOverlay.clear(BNDynamicOverlay.Key.DEST_RECOMMEND_POI);
        bNDynamicOverlay.clear(BNDynamicOverlay.Key.DEST_RECOMMEND_NAVI_TIP);
        BNMapController.getInstance().setRedLineRender(BNCommSettingManager.getInstance().getShowCarLogoToEnd());
        a();
    }

    private void b(c.a aVar) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar = this.f8749a;
        c.a aVar2 = cVar.e;
        if (aVar == aVar2) {
            d(aVar2);
        } else {
            c.b bVar = cVar.c.get(this.f);
            a(bVar.d);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.9", bVar.f8748a, aVar.b);
        }
        k();
        if (aVar == null) {
            return;
        }
        d();
        int i = aVar.h;
        if (i == 0) {
            c(aVar);
        } else if (i == 1) {
            a(aVar);
        }
        this.e = aVar;
        j.clear(BNDynamicOverlay.Key.DEST_RECOMMEND_NAVI_TIP);
    }

    private void c(c.a aVar) {
        this.b.a();
        int a2 = com.baidu.navisdk.framework.b.a(aVar.d, aVar.b, aVar.e, new c(this));
        this.d = a2;
        if (a2 == -1) {
            this.b.b(UIMsg.UI_TIP_DEFAULT_SERVER_ERROR);
            this.b.b();
        }
    }

    private void d(c.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        a(arrayList);
    }

    private c.a a(long j2) {
        List<c.a> list;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar = this.f8749a;
        if (cVar == null) {
            return null;
        }
        c.a aVar = cVar.e;
        if (aVar != null && aVar.f8747a == j2) {
            return aVar;
        }
        List<c.b> list2 = cVar.c;
        if (list2 == null) {
            return null;
        }
        Iterator<c.b> it = list2.iterator();
        while (it.hasNext() && (list = it.next().d) != null) {
            for (c.a aVar2 : list) {
                if (aVar2.f8747a == j2) {
                    return aVar2;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void d() {
        int i = this.d;
        if (i != -1) {
            com.baidu.navisdk.framework.b.b(i);
            this.d = -1;
        }
        if (this.c != -1) {
            BNRoutePlaner.getInstance().o();
            this.c = -1;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void c() {
        com.baidu.navisdk.ui.routeguide.b.V().I();
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.2.b");
    }

    private void e(c.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("x", aVar.d.c());
        bundle.putInt("y", aVar.d.d());
        bundle.putString("uid", aVar.b);
        bundle.putString("name", aVar.e);
        com.baidu.navisdk.ui.routeguide.b.V().a(2, false, bundle);
    }

    private void a(List<c.a> list) {
        j.clear(BNDynamicOverlay.Key.DEST_RECOMMEND_POI);
        ArrayList arrayList = new ArrayList();
        for (c.a aVar : list) {
            arrayList.add(new com.baidu.navisdk.model.datastruct.b().a(aVar.f8747a).b(aVar.g).a(aVar.e).a(aVar.d));
        }
        arrayList.add(new com.baidu.navisdk.model.datastruct.b().b(0).a(g()));
        BNDynamicOverlay bNDynamicOverlay = j;
        bNDynamicOverlay.setDataSet(BNDynamicOverlay.Key.DEST_RECOMMEND_POI, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
        bNDynamicOverlay.showAll(BNDynamicOverlay.Key.DEST_RECOMMEND_POI);
        bNDynamicOverlay.zoomAll(BNDynamicOverlay.Key.DEST_RECOMMEND_POI);
    }

    public void b(int i) {
        b(a(i));
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void b() {
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("DestRecommend", "model :" + this.f8749a);
        }
        this.b.a(this.f8749a.b);
        this.b.a(this.f8749a.c);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar = this.f8749a;
        if (cVar.d == 0) {
            a(0);
        } else if (cVar.e != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.y.2.8", this.f8749a.b);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar2 = this.f8749a;
            r.a("3.y.2.9", cVar2.b, cVar2.e.b);
            b(this.f8749a.e);
        }
        j.addClickedListener(this.i);
        BNMapController.getInstance().setRedLineRender(false);
        RoutePlanNode g = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        if (g != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.7", this.f8749a.d + "", this.f8749a.f8746a, g.getUID());
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.g, 20000L);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void a(int i) {
        c.b bVar;
        List<c.a> list;
        List<c.b> list2 = this.f8749a.c;
        if (list2 == null || list2.size() == 0 || (bVar = this.f8749a.c.get(i)) == null || (list = bVar.d) == null || list.size() == 0) {
            return;
        }
        this.f = i;
        b(bVar.d.get(0));
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.y.2.8", bVar.f8748a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.nplatform.comapi.basestruct.c cVar, String... strArr) {
        int i2 = i == 1 ? 1143 : 1141;
        if (strArr != null && strArr.length > 0 && strArr[0] == null) {
            strArr[0] = "";
        }
        com.baidu.navisdk.model.datastruct.b a2 = new com.baidu.navisdk.model.datastruct.b().a(cVar).b(i2).a(strArr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        BNDynamicOverlay bNDynamicOverlay = j;
        bNDynamicOverlay.setDataSet(BNDynamicOverlay.Key.DEST_RECOMMEND_NAVI_TIP, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
        bNDynamicOverlay.showAll(BNDynamicOverlay.Key.DEST_RECOMMEND_NAVI_TIP);
    }

    private void a(c.a aVar) {
        BNRoutePlaner.getInstance().a(this.h, true);
        com.baidu.navisdk.ui.routeguide.b.V().b(false);
        a0.I().t = false;
        Bundle b2 = o.b(aVar.d.c(), aVar.d.d());
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLongitudeE6(b2.getInt("LLx"));
        geoPoint.setLatitudeE6(b2.getInt("LLy"));
        l.l().a(aVar.e, geoPoint, aVar.b);
        this.c = BNRoutePlaner.getInstance().v();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e
    public void a() {
        com.baidu.navisdk.util.worker.lite.a.a(this.g);
    }
}
