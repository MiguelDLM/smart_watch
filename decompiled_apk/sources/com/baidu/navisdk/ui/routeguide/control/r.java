package com.baidu.navisdk.ui.routeguide.control;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.p0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.poisearch.a f8580a = new com.baidu.navisdk.poisearch.a();
    private final Handler b = new a("mSearchHandler");
    private final p0.b c = new b();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1005) {
                r.this.a(message);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements p0.b {
        public b() {
        }

        @Override // com.baidu.navisdk.util.common.p0.b
        public void onTick(int i) {
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "tick: " + i);
            }
            if (i == 0) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.SEARCH;
                if (gVar.d()) {
                    gVar.e("RGNearbySearchController", "onTick: end --> isNaviBegin: " + com.baidu.navisdk.util.common.x.t() + ", isRouteSearchMode: " + com.baidu.navisdk.poisearch.model.a.k().h());
                }
                if (com.baidu.navisdk.util.common.x.t() && com.baidu.navisdk.poisearch.model.a.k().h()) {
                    r.this.b();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final r f8583a = new r();
    }

    private void b(com.baidu.navisdk.model.datastruct.t tVar, boolean z) {
        LogUtil.e("RGNearbySearchController", "route nearby search fail");
        if (tVar != null) {
            int n = tVar.n();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.3", "" + n, null, "" + (com.baidu.navisdk.poisearch.model.a.k().f() + 1));
        }
        BNMapController.getInstance().setRouteSearchStatus(false);
        com.baidu.navisdk.poisearch.model.a.k().e(-1);
        String string = JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_fail);
        if (com.baidu.navisdk.module.asr.busi.e.a() != null) {
            com.baidu.navisdk.module.asr.busi.e.a().a((List<com.baidu.navisdk.model.datastruct.s>) null, tVar, false);
        }
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && k.m0() != null) {
            k.m0().onSearchFailed();
        }
        if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
            d();
        }
        if (z) {
            return;
        }
        s.T().a(string, false);
    }

    private void c(com.baidu.navisdk.model.datastruct.t tVar, boolean z) {
        String string;
        LogUtil.e("RGNearbySearchController", "route nearby search no result");
        if (tVar != null) {
            tVar.d();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", "1", "0", "" + (com.baidu.navisdk.poisearch.model.a.k().f() + 1));
            if (!z) {
                com.baidu.navisdk.poisearch.model.a.k().a(true);
                com.baidu.navisdk.poisearch.model.a.k().e(0);
                com.baidu.navisdk.poisearch.model.a.k().j = tVar;
                if (com.baidu.navisdk.poisearch.e.g(tVar.j())) {
                    LogUtil.e("RGNearbySearchController", "handleNoResultPoi--> save nearby search key to phone: key = " + com.baidu.navisdk.poisearch.model.a.k().b() + ", subkey = " + com.baidu.navisdk.poisearch.model.a.k().d());
                    e0.a(com.baidu.navisdk.framework.a.c().a()).b(com.baidu.navisdk.poisearch.model.a.k().b(), TextUtils.isEmpty(com.baidu.navisdk.poisearch.model.a.k().d()) ? "" : com.baidu.navisdk.poisearch.model.a.k().d());
                }
            }
            BNMapController.getInstance().setRouteSearchStatus(false);
            if (TextUtils.isEmpty(tVar.q())) {
                string = JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_no_result);
            } else if (com.baidu.navisdk.poisearch.e.f(tVar.j())) {
                string = JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_no_brand_result);
            } else {
                string = JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_no_result);
            }
            if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                com.baidu.navisdk.poisearch.model.a.k().a(false);
                if (com.baidu.navisdk.module.asr.busi.e.a() != null) {
                    com.baidu.navisdk.module.asr.busi.e.a().a((List<com.baidu.navisdk.model.datastruct.s>) null, tVar, false);
                }
            } else {
                c();
            }
            if (!z) {
                g();
            }
            if (!z) {
                s.T().a(string, false);
            }
        }
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k == null || k.m0() == null) {
            return;
        }
        k.m0().a(null);
    }

    private boolean d(com.baidu.navisdk.model.datastruct.t tVar, boolean z) {
        LogUtil.e("RGNearbySearchController", "route nearby search other result");
        if (tVar != null) {
            ArrayList<com.baidu.navisdk.model.datastruct.s> g = tVar.g();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGNearbySearchController", "handleOtherResultPoi --> poiList.size = " + g.size());
                com.baidu.navisdk.poisearch.b.a("handleOtherResultPoi", g);
            }
            if (g != null && g.size() > 0 && com.baidu.navisdk.poisearch.model.a.k().f() != 1) {
                com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(g.size() == 1 ? 1 : 2);
                r.a("3.5.3.2", "2", sb.toString(), "" + (com.baidu.navisdk.poisearch.model.a.k().f() + 1));
            }
        }
        return true;
    }

    public static r i() {
        return c.f8583a;
    }

    public void e() {
        if (!com.baidu.navisdk.util.common.z.b(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_net_error));
        } else if (com.baidu.navisdk.poisearch.b.b()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_offline_route_error));
        } else {
            com.baidu.navisdk.ui.routeguide.b.V().d().c(com.baidu.navisdk.ui.routeguide.b.V().d().a());
            x.b().w4();
        }
    }

    public void f() {
        x.b().g1();
        x.b().O4();
        com.baidu.navisdk.poisearch.b.c();
    }

    public void g() {
        if (com.baidu.navisdk.ui.routeguide.b.W() && com.baidu.navisdk.poisearch.model.a.k().h() && !com.baidu.navisdk.poisearch.model.b.m().j() && !com.baidu.navisdk.poisearch.model.b.m().h() && !com.baidu.navisdk.poisearch.model.b.m().i() && !com.baidu.navisdk.poisearch.model.b.m().g()) {
            this.f8580a.a(this.c);
        }
    }

    public void h() {
        com.baidu.navisdk.model.datastruct.t tVar = com.baidu.navisdk.poisearch.model.a.k().j;
        if (tVar == null) {
            return;
        }
        int e = com.baidu.navisdk.poisearch.e.e(tVar.j());
        int f = com.baidu.navisdk.poisearch.model.a.k().f();
        boolean z = true;
        if (tVar.d() != 1) {
            z = false;
        }
        a(tVar.g(), e, f, z);
    }

    private boolean a(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i, Handler handler, int i2) {
        f();
        x.b().r(false);
        boolean a2 = com.baidu.navisdk.poisearch.b.a(context, arrayList, arrayList2, i, handler, i2);
        if (a2) {
            return a2;
        }
        LogUtil.e("RGNearbySearchController", "asyncRouteSearchPoiByType: Error");
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.3", "0", null, "" + (i2 + 1));
        if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
            d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.navisdk.model.datastruct.s> a(Message message) {
        x.b().s1();
        if (!com.baidu.navisdk.poisearch.model.a.k().c) {
            LogUtil.e("RGNearbySearchController", "handleRouteSearch has been cancel");
            if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            }
            return null;
        }
        com.baidu.navisdk.poisearch.model.a.k().c = false;
        com.baidu.navisdk.cmdrequest.j jVar = (com.baidu.navisdk.cmdrequest.j) message.obj;
        if (message.arg1 != 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.3", "0", null, "" + (com.baidu.navisdk.poisearch.model.a.k().f() + 1));
            s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_fail), false);
            if (com.baidu.navisdk.module.asr.busi.e.a() != null) {
                com.baidu.navisdk.module.asr.busi.e.a().a((List<com.baidu.navisdk.model.datastruct.s>) null, (com.baidu.navisdk.model.datastruct.t) null, false);
            }
            LogUtil.e("RGNearbySearchController", "route search pager fail");
            return null;
        }
        return a((com.baidu.navisdk.model.datastruct.t) jVar.b, false);
    }

    public void d() {
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.i0();
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        } else {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NEARBY_SEARCH);
        }
    }

    public void b() {
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.f");
        com.baidu.navisdk.ui.routeguide.b.V().y();
        f();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().c();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().l(true);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().o1();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().g1();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q1();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B0();
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && k.m0() != null) {
            k.m0().onSearchExit();
        }
        d();
    }

    public List<com.baidu.navisdk.model.datastruct.s> a(com.baidu.navisdk.model.datastruct.t tVar, boolean z) {
        LogUtil.e("RGNearbySearchController", "showRouteSearchPoiList: --> isByOrientationChange" + z);
        if (x.b().W1()) {
            return null;
        }
        if (com.baidu.navisdk.poisearch.model.a.k().f() == 1 && !com.baidu.navisdk.ui.routeguide.asr.c.n().i() && !com.baidu.navisdk.asr.d.B().n()) {
            LogUtil.e("XDVoice", "show route search by voice, not roused, return");
            return null;
        }
        if (tVar != null && 6 == tVar.o()) {
            int m = tVar.m();
            int n = tVar.n();
            int d = tVar.d();
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("RGNearbySearchController", "showRouteSearchPoiList: --> result: " + m + ", status: " + n + ", enType: " + d);
            }
            if (m != 0) {
                if (n == 11) {
                    c(tVar, z);
                } else {
                    b(tVar, z);
                }
                return null;
            }
            boolean d2 = d == 1 ? d(tVar, z) : false;
            ArrayList<com.baidu.navisdk.model.datastruct.s> g = tVar.g();
            if (g != null && g.size() > 0) {
                return a(tVar, z, d2);
            }
            b(tVar, z);
        } else {
            b(tVar, z);
        }
        return null;
    }

    public void c() {
        if (!RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
            LogUtil.e("RGNearbySearchController", "entry nearby search state with result");
            if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_NEARBY_SEARCH);
            return;
        }
        LogUtil.e("RGNearbySearchController", "is already in nearby search state");
        x.b().u(1);
        x.b().c4();
    }

    private List<com.baidu.navisdk.model.datastruct.s> a(com.baidu.navisdk.model.datastruct.t tVar, boolean z, boolean z2) {
        LogUtil.e("RGNearbySearchController", "route nearby search success");
        ArrayList<com.baidu.navisdk.model.datastruct.s> g = tVar.g();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGNearbySearchController", "handleSuccessPoi --> poiList.size = " + g.size());
            com.baidu.navisdk.poisearch.b.a("handleSuccessPoi", g);
        }
        if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
            int i = 0;
            while (i < g.size()) {
                if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.c(g.get(i).k) || i > 2) {
                    g.remove(i);
                    i--;
                }
                i++;
            }
            com.baidu.navisdk.module.asr.i.a("route search. handleSuccessPoi ---> list:" + g.size());
            if (g.isEmpty()) {
                com.baidu.navisdk.module.asr.i.a("route search. --> no result");
                c(tVar, z);
                return null;
            }
        }
        int e = com.baidu.navisdk.poisearch.e.e(tVar.j());
        if (!z) {
            com.baidu.navisdk.poisearch.model.a.k().a(true);
            com.baidu.navisdk.poisearch.model.a.k().e(g.size());
            com.baidu.navisdk.poisearch.model.a.k().j = tVar;
            if (com.baidu.navisdk.poisearch.e.g(tVar.j())) {
                LogUtil.e("RGNearbySearchController", "handleNoResultPoi--> save nearby search key to phone: key = " + com.baidu.navisdk.poisearch.model.a.k().b() + ", subkey = " + com.baidu.navisdk.poisearch.model.a.k().d());
                e0.a(com.baidu.navisdk.framework.a.c().a()).b(com.baidu.navisdk.poisearch.model.a.k().b(), TextUtils.isEmpty(com.baidu.navisdk.poisearch.model.a.k().d()) ? "" : com.baidu.navisdk.poisearch.model.a.k().d());
            }
        }
        BNMapController.getInstance().setRouteSearchStatus(true);
        if (!z && com.baidu.navisdk.poisearch.model.a.k().f() == 1 && com.baidu.navisdk.module.asr.busi.e.a() != null) {
            com.baidu.navisdk.module.asr.busi.e.a().b(g, tVar, z2);
        }
        c();
        if (!z2) {
            if (com.baidu.navisdk.poisearch.model.a.k().f() != 1) {
                com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(g.size() == 1 ? 1 : 2);
                r.a("3.5.3.2", "1", sb.toString(), "" + (com.baidu.navisdk.poisearch.model.a.k().f() + 1));
            }
        } else {
            String str = JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_other_results) + tVar.j();
            if (!z && com.baidu.navisdk.poisearch.model.a.k().f() != 1) {
                s.T().a(str, false);
            }
        }
        a(g, e, com.baidu.navisdk.poisearch.model.a.k().f(), z2);
        x.b().i5();
        if (!z) {
            g();
        }
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && k.m0() != null) {
            k.m0().a(g);
        }
        return g;
    }

    public void a() {
        this.f8580a.a();
    }

    public boolean a(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i) {
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(arrayList.get(0))) {
            return false;
        }
        if (arrayList2 == null || arrayList2.size() == 0 || TextUtils.isEmpty(arrayList2.get(0))) {
            arrayList2 = new ArrayList<>();
            arrayList2.add(e0.a(com.baidu.navisdk.framework.a.c().a()).a(arrayList.get(0), ""));
        }
        if (arrayList.size() != 0 && !TextUtils.isEmpty(arrayList.get(0))) {
            String h = com.baidu.navisdk.poisearch.e.h(arrayList2.get(0));
            arrayList2.clear();
            arrayList2.add(h);
            if (arrayList2.size() != 0 && !TextUtils.isEmpty(arrayList2.get(0))) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.7", com.baidu.navisdk.poisearch.e.a(arrayList2.get(0)), "1", "2");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3", com.baidu.navisdk.poisearch.e.c(arrayList.get(0)), null, "2");
            }
        }
        return a(arrayList, arrayList2, i, 1);
    }

    public boolean a(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i, int i2) {
        if (arrayList != null && arrayList.size() != 0) {
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410308", "410308");
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410309", arrayList.get(0));
            boolean a2 = a(com.baidu.navisdk.framework.a.c().a(), arrayList, arrayList2, i, this.b, i2);
            if (a2) {
                x.b().v4();
            } else {
                x.b().t1();
                s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_nearby_search_net_error), false);
            }
            return a2;
        }
        LogUtil.e("RGNearbySearchController", "key word is null");
        return false;
    }

    private void a(ArrayList<com.baidu.navisdk.model.datastruct.s> arrayList, int i, int i2, boolean z) {
        float c2;
        int dip2px;
        boolean s2 = x.b().s2();
        Rect rect = new Rect();
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int d = aVar.d();
        int e = aVar.e();
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(1);
        if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
            if (s2) {
                dip2px = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
            } else {
                dip2px = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
            }
            d -= dip2px;
        }
        if (b2.b()) {
            d -= s2 ? b2.d : b2.e;
        }
        if (s2) {
            rect.left = 0;
            if (i2 == 1) {
                c2 = JarUtils.getResources().getDisplayMetrics().density * 210.0f;
            } else {
                c2 = b2.b() ? 0.0f : com.baidu.navisdk.module.newguide.a.e().c();
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                c2 -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
            }
            rect.top = (d - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b())) - ((int) (c2 + 0.5f));
            rect.right = e;
            rect.bottom = (int) (JarUtils.getResources().getDimension(R.dimen.nsdk_rg_cp_bottom_height) + 0.5f);
        } else {
            int V = x.b().V();
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                V -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
            }
            rect.left = V;
            com.baidu.navisdk.ui.routeguide.utils.a aVar2 = com.baidu.navisdk.ui.routeguide.utils.a.f9151a;
            rect.top = aVar2.a() - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            int c3 = aVar2.c();
            if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                c3 -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
            }
            if (b2.b()) {
                c3 -= b2.e;
            }
            rect.right = c3;
            rect.bottom = (int) JarUtils.getResources().getDimension(R.dimen.nsdk_rg_cp_bottom_height);
        }
        com.baidu.navisdk.poisearch.b.a(arrayList, i, i2);
        a(arrayList, i2, s2, rect, z);
    }

    private void a(List<com.baidu.navisdk.model.datastruct.s> list, int i, boolean z, Rect rect, boolean z2) {
        Rect a2;
        RoutePlanNode g;
        if (i == 1) {
            Bundle bundle = new Bundle();
            int[] iArr = new int[list.size() * 2];
            int i2 = 0;
            for (com.baidu.navisdk.model.datastruct.s sVar : list) {
                iArr[i2] = sVar.k.getLongitudeE6();
                iArr[i2 + 1] = sVar.k.getLatitudeE6();
                i2 += 2;
            }
            bundle.putIntArray("geoList", iArr);
            BNRouteGuider.getInstance().getRouteInfoInUniform(13, bundle);
            a2 = new Rect();
            a2.left = (int) bundle.getDouble("bound_left");
            a2.right = (int) bundle.getDouble("bound_right");
            a2.top = (int) bundle.getDouble("bound_top");
            a2.bottom = (int) bundle.getDouble("bound_bottom");
        } else {
            ArrayList arrayList = new ArrayList(list);
            if (!z2) {
                GeoPoint a3 = com.baidu.navisdk.util.logic.h.a();
                if (a3 != null && a3.isValid()) {
                    com.baidu.navisdk.model.datastruct.s sVar2 = new com.baidu.navisdk.model.datastruct.s();
                    sVar2.k = a3;
                    arrayList.add(sVar2);
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGNearbySearchController", "updatePoiBkgLayer --> carPt = " + a3);
                }
                com.baidu.navisdk.model.datastruct.s sVar3 = new com.baidu.navisdk.model.datastruct.s();
                com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                if (fVar != null && (g = fVar.g()) != null) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGNearbySearchController", "updatePoiBkgLayer --> endPoint = " + g.getGeoPoint());
                    }
                    sVar3.k = g.getGeoPoint();
                    arrayList.add(sVar3);
                }
            }
            a2 = com.baidu.navisdk.poisearch.b.a(arrayList);
        }
        q.c().a(a2, rect, z, j.b.eAnimationViewall, 1000, true);
    }
}
