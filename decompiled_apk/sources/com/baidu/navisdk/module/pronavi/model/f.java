package com.baidu.navisdk.module.pronavi.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f7466a = 1;
    private int b = 0;
    private boolean c = false;
    private int d = -1;
    private int e = 1;
    private int f = 1;
    private boolean g = false;
    private boolean h = false;
    private boolean i = true;
    private boolean j = true;
    private String k = null;
    public int l = 0;
    private int m = 0;
    private RoutePlanNode n = null;
    private RoutePlanNode o = null;

    public void a(Bundle bundle) {
        this.j = bundle.getBoolean(BNaviCommonParams.ProGuideKey.IS_SUPPORT_FULL_SCREEN, true);
        this.f7466a = bundle.getInt("page_from_vehicle", 1);
        this.b = bundle.getInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE, 0);
        this.c = bundle.getBoolean("page_from_car_link", false);
        this.d = bundle.getInt("car_link_type", 0);
        if (bundle.getBoolean("page_from_hicar", false)) {
            this.c = true;
            this.d = 1;
        }
        int i = bundle.getInt("page_from_scene", 1);
        if (this.c) {
            this.e = 2;
            this.j = false;
        } else {
            this.e = i;
        }
        int i2 = this.e;
        this.f = i2;
        if (i2 == 4 || i2 == 5) {
            this.e = 3;
        }
        if (this.b == 1) {
            this.f = 7;
            this.e = 7;
        }
        this.h = bundle.getString("src_open_api") != null && bundle.getString("src_open_api").equals("huawei.hagservice.onestepreturn");
        String string = bundle.getString("pronav_from_page");
        if ("from_light_navi".equals(string) || "from_moss".equals(string)) {
            this.i = false;
        }
        com.baidu.navisdk.module.pronavi.a.g = (RoutePlanNode) bundle.getSerializable("end_node");
        com.baidu.navisdk.module.pronavi.a.f7452a = bundle.getInt("routeguide_view_mode");
        com.baidu.navisdk.module.pronavi.a.b = bundle.getInt("calroute_done");
        com.baidu.navisdk.module.pronavi.a.c = bundle.getInt("start_x");
        com.baidu.navisdk.module.pronavi.a.d = bundle.getInt("start_y");
        com.baidu.navisdk.module.pronavi.a.e = bundle.getInt("end_x");
        com.baidu.navisdk.module.pronavi.a.f = bundle.getInt("end_y");
        com.baidu.navisdk.module.pronavi.a.h = bundle.getString("start_name");
        com.baidu.navisdk.module.pronavi.a.i = bundle.getString("end_name");
        com.baidu.navisdk.module.pronavi.a.j = bundle.getInt("locate_mode");
        com.baidu.navisdk.module.pronavi.a.p = bundle.getInt("from_page_type", 0);
        com.baidu.navisdk.module.pronavi.a.q = bundle.getBoolean("is_poi_from_baidu_map", false);
        com.baidu.navisdk.module.pronavi.a.r = bundle.getString("source_page", "");
        com.baidu.navisdk.module.pronavi.a.s = bundle.getBoolean("forbids_configuration_change", false);
        if (bundle.containsKey("show_fullview")) {
            com.baidu.navisdk.module.pronavi.a.n = bundle.getBoolean("show_fullview");
        } else {
            com.baidu.navisdk.module.pronavi.a.n = true;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("pRGLocateMode = " + com.baidu.navisdk.module.pronavi.a.j + ", pRGShowFullview=" + com.baidu.navisdk.module.pronavi.a.n + ", BNavConfig.pPageFrom= " + com.baidu.navisdk.module.pronavi.a.p);
        }
        if (com.baidu.navisdk.module.pronavi.a.p == 6) {
            com.baidu.navisdk.framework.c.b().a(14, 12);
        }
        if (bundle.containsKey("menu_type")) {
            com.baidu.navisdk.module.pronavi.a.k = bundle.getInt("menu_type");
        }
        if (bundle.containsKey("net_refresh")) {
            com.baidu.navisdk.module.pronavi.a.l = bundle.getBoolean("net_refresh");
        }
        if (bundle.containsKey("road_condition")) {
            com.baidu.navisdk.module.pronavi.a.m = bundle.getBoolean("road_condition");
        }
        if (bundle.containsKey("selected_route_mrsl")) {
            com.baidu.navisdk.module.pronavi.a.o = bundle.getString("selected_route_mrsl");
        } else {
            com.baidu.navisdk.module.pronavi.a.o = null;
        }
        com.baidu.navisdk.module.pronavi.a.v = BNRoutePlaner.getInstance().d() == 39;
        if (gVar.d()) {
            gVar.e("pRGMenuType = " + com.baidu.navisdk.module.pronavi.a.k + ", isVTN=" + com.baidu.navisdk.module.pronavi.a.v);
        }
        this.k = bundle.getString("oa_ext", null);
        int i3 = bundle.getInt("pro_navi_model", 0);
        this.l = i3;
        this.m = i3;
        if (bundle.containsKey("b4nav_last_time_calc_dest_uid")) {
            String string2 = bundle.getString("b4nav_last_time_calc_dest_uid");
            if (!TextUtils.isEmpty(string2)) {
                RoutePlanNode routePlanNode = new RoutePlanNode();
                this.n = routePlanNode;
                routePlanNode.setUID(string2);
                this.n.setGeoPoint(new GeoPoint(bundle.getInt("b4nav_last_time_calc_dest_point_x"), bundle.getInt("b4nav_last_time_calc_dest_point_y")));
                this.n.setName(bundle.getString("b4nav_last_time_calc_dest_name"));
            }
        }
        if (bundle.containsKey("b4nav_latest_calc_dest_uid")) {
            String string3 = bundle.getString("b4nav_latest_calc_dest_uid");
            if (TextUtils.isEmpty(string3)) {
                return;
            }
            RoutePlanNode routePlanNode2 = new RoutePlanNode();
            this.o = routePlanNode2;
            routePlanNode2.setUID(string3);
            this.o.setGeoPoint(new GeoPoint(bundle.getInt("b4nav_latest_calc_dest_point_x"), bundle.getInt("b4nav_latest_calc_dest_point_y")));
            this.o.setName(bundle.getString("b4nav_latest_calc_dest_name"));
        }
    }

    public RoutePlanNode b() {
        return this.o;
    }

    public String c() {
        return this.k;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f7466a;
    }

    public boolean h() {
        if (this.m == 1) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.c;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        if (this.c && this.d == 1) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return this.i;
    }

    public boolean m() {
        if (this.b == 1) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.g;
    }

    public boolean o() {
        if (this.e == 3) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.j;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public RoutePlanNode a() {
        return this.n;
    }
}
