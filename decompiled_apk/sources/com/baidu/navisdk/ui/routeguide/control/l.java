package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class l {
    private static volatile l h;

    /* renamed from: a, reason: collision with root package name */
    private RoutePlanNode f8565a = null;
    private RoutePlanNode b = null;
    private int c = 0;
    private String d = null;
    private String e = null;
    private a f = null;
    private RoutePlanNode g = null;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public static l l() {
        if (h == null) {
            synchronized (l.class) {
                try {
                    if (h == null) {
                        h = new l();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    private com.baidu.navisdk.comapi.routeplan.v2.b m() {
        com.baidu.navisdk.comapi.routeplan.v2.b bVar = new com.baidu.navisdk.comapi.routeplan.v2.b();
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        GeoPoint b = com.baidu.navisdk.util.logic.h.b();
        if (b == null || !b.isValid()) {
            if (com.baidu.navisdk.j.d()) {
                return null;
            }
            bVar.f6726a = fVar.o();
        }
        if (b != null) {
            bVar.f6726a = new RoutePlanNode(b, 3, "我的位置", null);
        }
        RoutePlanNode routePlanNode = bVar.f6726a;
        if (routePlanNode == null) {
            return null;
        }
        routePlanNode.mNodeType = 3;
        if (bVar.c == null) {
            bVar.c = new ArrayList();
        }
        com.baidu.navisdk.module.nearbysearch.model.b bVar2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
        if (bVar2.e() != null) {
            bVar.c.addAll(bVar2.e());
        }
        RoutePlanNode g = fVar.g();
        bVar.b = g;
        if (g == null) {
            com.baidu.navisdk.util.common.g.ROUTE_PLAN.a("Common: ", "getNormalRPRequest return endNode is null");
            return null;
        }
        g.mNodeType = 1;
        bVar.f = 2;
        bVar.g = 0;
        bVar.p = null;
        return bVar;
    }

    public void a() {
    }

    public void b() {
    }

    public RoutePlanNode c() {
        return this.g;
    }

    public RoutePlanNode d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public RoutePlanNode f() {
        return this.f8565a;
    }

    public String g() {
        return this.e;
    }

    public int h() {
        return this.c;
    }

    public boolean i() {
        return a(0);
    }

    public boolean j() {
        LogUtil.e("RouteGuide", "removeAllViaPtToCalRoute()");
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            LogUtil.e("RouteGuide", "removeAllViaPtToCalRoute() -->requestV2 is null");
            return false;
        }
        m.c = null;
        Bundle bundle = new Bundle();
        m.r = bundle;
        bundle.putBoolean("force_clear_last_route_plan_node", false);
        BNRoutePlaner.getInstance().h(3);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    public void k() {
        this.f8565a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
    }

    public boolean a(List<RoutePlanNode> list) {
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            return false;
        }
        m.c.addAll(list);
        if (com.baidu.navisdk.j.d()) {
            int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
            if (m.c.size() > n) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().c(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                return false;
            }
        } else if (m.c.size() > BNSettingManager.getViaPointCount()) {
            if (com.baidu.navisdk.util.common.g.c0) {
                com.baidu.navisdk.util.common.g.OPEN_SDK.f("RouteGuide", "showPickPoint --> " + BNSettingManager.getViaPointCount());
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addViaPtToCalcRoute() --> viaNodes.size() = ");
        List<RoutePlanNode> list2 = m.c;
        sb.append(list2 != null ? list2.size() : 0);
        LogUtil.e("RouteGuide", sb.toString());
        LogUtil.e("RouteGuide", "addViaPtToCalcRoute() --> requestV2 = " + m);
        BNRoutePlaner.getInstance().h(1);
        BNRoutePlaner.getInstance().a(m);
        return true;
    }

    public boolean b(List<String> list) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "removeViaPtToCalcRouteByIndex ");
        }
        if (list == null) {
            return false;
        }
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "removeViaPtToCalc RouterequestV2 is null!!!");
            }
            return false;
        }
        List<RoutePlanNode> list2 = m.c;
        if (list2 != null && list2.size() > 0) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "removeViaPtToCalcRoute: before remove via, request is " + m);
            }
            if (list.size() == m.c.size()) {
                m.c.clear();
            } else {
                for (int size = list.size() - 1; size >= 0; size--) {
                    int parseInt = Integer.parseInt(list.get(size)) - 1;
                    if (parseInt >= 0 && parseInt < m.c.size()) {
                        m.c.remove(parseInt);
                    }
                }
            }
        }
        Bundle bundle = new Bundle();
        m.r = bundle;
        bundle.putBoolean("force_clear_last_route_plan_node", false);
        BNRoutePlaner.getInstance().h(3);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    public boolean a(GeoPoint geoPoint, String str, String str2) {
        return a(geoPoint, str, -1, str2);
    }

    public boolean a(GeoPoint geoPoint, String str, String str2, int i) {
        return a(geoPoint, str, -1, str2, i, 1, 1, null, false);
    }

    public boolean a(GeoPoint geoPoint, String str, String str2, int i, Bundle bundle) {
        return a(geoPoint, str, -1, str2, i, 1, 1, bundle, false);
    }

    public boolean a(GeoPoint geoPoint, String str, String str2, int i, int i2, int i3) {
        return a(geoPoint, str, -1, str2, i, i2, i3, null, false);
    }

    public boolean a(GeoPoint geoPoint, String str, int i, String str2) {
        return a(geoPoint, str, i, str2, 0, 1, 1, null, false);
    }

    public boolean a(GeoPoint geoPoint, String str, int i, String str2, boolean z) {
        return a(geoPoint, str, i, str2, 0, 1, 1, null, z);
    }

    public boolean a(GeoPoint geoPoint, String str, int i, String str2, int i2, int i3, int i4, Bundle bundle, boolean z) {
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            return false;
        }
        if (i > 0) {
            m.f = i;
        }
        RoutePlanNode routePlanNode = new RoutePlanNode(geoPoint, i4, null, null);
        routePlanNode.mName = str;
        routePlanNode.mNodeType = i3;
        routePlanNode.mIconType = i2;
        routePlanNode.setUID(str2);
        if (!com.baidu.navisdk.j.d() && z) {
            m.c.add(routePlanNode);
        } else {
            m.c.add(0, routePlanNode);
        }
        Bundle bundle2 = new Bundle();
        m.r = bundle2;
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m.r.putBoolean("force_clear_last_route_plan_node", false);
        StringBuilder sb = new StringBuilder();
        sb.append("addViaPtToCalcRoute() --> viaNodes.size() = ");
        List<RoutePlanNode> list = m.c;
        sb.append(list != null ? list.size() : 0);
        LogUtil.e("RouteGuide", sb.toString());
        LogUtil.e("RouteGuide", "addViaPtToCalcRoute() --> requestV2 = " + m);
        BNRoutePlaner.getInstance().h(1);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    public boolean a(GeoPoint geoPoint) {
        return a(geoPoint, -1);
    }

    public boolean a(GeoPoint geoPoint, int i) {
        return a(geoPoint, i, (String) null);
    }

    public boolean a(GeoPoint geoPoint, int i, String str) {
        com.baidu.navisdk.module.nearbysearch.model.a aVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "removeViaPtToCalcRoute --> geoPoint = " + geoPoint + "uid:" + str);
        }
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "removeViaPtToCalc RouterequestV2 is null!!!");
            }
            return false;
        }
        if (i > 0) {
            m.f = i;
        }
        List<RoutePlanNode> list = m.c;
        if (list != null && list.size() > 0) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "removeViaPtToCalcRoute: before remove via, request is " + m);
            }
            if (!TextUtils.isEmpty(str)) {
                aVar = new com.baidu.navisdk.module.nearbysearch.model.a(geoPoint, str);
            } else {
                aVar = new com.baidu.navisdk.module.nearbysearch.model.a(geoPoint);
            }
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            com.baidu.navisdk.module.nearbysearch.model.a c = bVar.c(aVar);
            if (gVar.d()) {
                gVar.e("RouteGuide", "removeViaPtToCalcRoute:before remove via, node is " + c);
            }
            if (c != null) {
                m.c.remove(c);
                bVar.e(new com.baidu.navisdk.module.nearbysearch.model.a(c));
            }
        }
        Bundle bundle = new Bundle();
        m.r = bundle;
        bundle.putBoolean("force_clear_last_route_plan_node", false);
        BNRoutePlaner.getInstance().h(3);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    public boolean a(com.baidu.navisdk.module.nearbysearch.model.a aVar, com.baidu.navisdk.module.nearbysearch.model.a aVar2, int i) {
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            LogUtil.e("RouteGuide", "modifyViaPtToCalcRoute --> requestV2 is null!!!");
            return false;
        }
        if (i > 0) {
            m.f = i;
        }
        List<RoutePlanNode> list = m.c;
        if (list != null && list.size() > 0) {
            LogUtil.e("RouteGuide", "modifyViaPtToCalcRoute --> before modify via, request is " + m);
            int indexOf = m.c.indexOf(aVar);
            LogUtil.e("RouteGuide", "modifyViaPtToCalcRoute --> before modify via, index is " + indexOf);
            if (indexOf >= 0) {
                m.c.add(indexOf, aVar2);
                m.c.remove(aVar);
            }
        }
        Bundle bundle = new Bundle();
        m.r = bundle;
        bundle.putBoolean("force_clear_last_route_plan_node", false);
        BNRoutePlaner.getInstance().h(2);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    public boolean a(String str, GeoPoint geoPoint, String str2) {
        return a(str, geoPoint, str2, 2);
    }

    public boolean a(String str, GeoPoint geoPoint, String str2, boolean z) {
        RoutePlanNode routePlanNode = new RoutePlanNode();
        routePlanNode.setName(str);
        routePlanNode.setGeoPoint(geoPoint);
        routePlanNode.setUID(str2);
        return a(routePlanNode, 2, -1, 0, z, (Bundle) null);
    }

    public boolean a(String str, GeoPoint geoPoint, String str2, int i) {
        RoutePlanNode routePlanNode = new RoutePlanNode();
        routePlanNode.setName(str);
        routePlanNode.setGeoPoint(geoPoint);
        routePlanNode.setUID(str2);
        return a(routePlanNode, i, -1);
    }

    public boolean a(@NonNull RoutePlanNode routePlanNode) {
        return a(routePlanNode, 2, -1);
    }

    public boolean a(@NonNull RoutePlanNode routePlanNode, int i, Bundle bundle) {
        return a(routePlanNode, 2, -1, i, false, bundle);
    }

    public boolean a(@NonNull RoutePlanNode routePlanNode, int i, int i2) {
        return a(routePlanNode, i, i2, 0);
    }

    public boolean a(@NonNull RoutePlanNode routePlanNode, int i, int i2, int i3) {
        return a(routePlanNode, i, i2, i3, false, (Bundle) null);
    }

    public boolean a(@NonNull RoutePlanNode routePlanNode, int i, int i2, int i3, boolean z, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "changeDestNode --> destNode = " + routePlanNode);
        }
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "changeDestNode --> requestV2 is null!!!");
            }
            return false;
        }
        if (routePlanNode.getGeoPoint() != null && routePlanNode.getGeoPoint().isValid() && (routePlanNode.getGeoPoint().getLongitudeE6() != 0 || routePlanNode.getGeoPoint().getLatitudeE6() != 0)) {
            routePlanNode.setFrom(1);
            routePlanNode.setNodeType(1);
        } else {
            routePlanNode.setFrom(2);
            routePlanNode.setNodeType(2);
        }
        this.c = i3;
        this.e = BNRoutePlaner.getInstance().x();
        this.d = null;
        if (i3 == 1) {
            this.f8565a = m.b;
        } else if (i3 != 2) {
            this.b = routePlanNode;
        } else {
            this.f8565a = m.b;
            if (bundle != null) {
                this.d = bundle.getString("park_uid", null);
            }
        }
        this.g = routePlanNode;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
        if (i > 0) {
            m.f = i;
        }
        if (i2 != -1) {
            m.i = i2;
        }
        if (z) {
            m.c = null;
        }
        m.b = routePlanNode;
        if (bundle == null) {
            bundle = new Bundle();
        }
        m.r = bundle;
        bundle.putBoolean("force_clear_last_route_plan_node", false);
        BNRoutePlaner bNRoutePlaner = BNRoutePlaner.getInstance();
        RoutePlanNode routePlanNode2 = m.b;
        bNRoutePlaner.u = routePlanNode2;
        BNSettingManager.setEndNode(routePlanNode2);
        LogUtil.e("RouteGuide", "setEndNodeToCalcRoute endNode " + BNRoutePlaner.getInstance().u.toString());
        if (BNRoutePlaner.getInstance().s() != 4) {
            BNRoutePlaner.getInstance().o(1);
            BNRoutePlaner.getInstance().h(0);
        } else {
            BNRoutePlaner.getInstance().o(4);
            BNRoutePlaner.getInstance().h(2);
        }
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        return true;
    }

    private boolean a(int i) {
        return a(0, 2);
    }

    public boolean a(int i, int i2) {
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            return false;
        }
        m.g = i;
        m.f = i2;
        com.baidu.navisdk.ui.routeguide.b.V().S();
        BNRoutePlaner.getInstance().h(1);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        if (i == 0) {
            com.baidu.navisdk.ui.routeguide.b.V().d().c(com.baidu.navisdk.ui.routeguide.b.V().d().a());
        }
        s.T().a(false, false, false);
        return true;
    }

    public boolean a(boolean z) {
        com.baidu.navisdk.comapi.routeplan.v2.b m = m();
        if (m == null) {
            return false;
        }
        if (z) {
            m.f = 57;
            m.i = 1;
        }
        com.baidu.navisdk.ui.routeguide.b.V().S();
        BNRoutePlaner.getInstance().h(1);
        com.baidu.navisdk.ui.routeguide.b.V().a(m, true);
        s.T().a(false, false, false);
        return true;
    }

    public void a(a aVar) {
        this.f = aVar;
    }
}
