package com.baidu.navisdk.ugc.report.data.datarepository;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.garmin.fit.OxXXx0X;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static SparseIntArray f8247a;
    private static SparseIntArray b;
    private static SparseIntArray c;
    private static SparseIntArray d;
    private static Map<Integer, String> e;

    @DrawableRes
    public static int a(int i) {
        if (f8247a == null) {
            a();
        }
        return f8247a.get(i);
    }

    @DrawableRes
    public static int b(int i) {
        if (b == null) {
            b();
        }
        return b.get(i);
    }

    @DrawableRes
    public static int c(int i) {
        if (d == null) {
            c();
        }
        return d.get(i);
    }

    @DrawableRes
    public static int d(int i) {
        if (c == null) {
            d();
        }
        return c.get(i);
    }

    public static String e(int i) {
        if (e == null) {
            e();
        }
        return e.get(Integer.valueOf(i));
    }

    public static e f(int i) {
        b bVar;
        ArrayList<b> e2 = d.i().e();
        int i2 = 0;
        while (true) {
            if (i2 >= e2.size()) {
                i2 = -1;
                bVar = null;
                break;
            }
            if (e2.get(i2).b == i) {
                bVar = e2.get(i2);
                break;
            }
            i2++;
        }
        if (bVar == null) {
            return null;
        }
        return new e(d.i().f(), e2, bVar, i2);
    }

    public static e g() {
        return new e(d.i().f(), d.i().e(), null, -1);
    }

    public static e h(int i) {
        b bVar;
        ArrayList<b> f = d.i().f();
        if (f.isEmpty()) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 < f.size()) {
                bVar = f.get(i2);
                if (bVar != null && bVar.b == i) {
                    break;
                }
                i2++;
            } else {
                bVar = null;
                break;
            }
        }
        if (bVar == null) {
            return null;
        }
        return new e(d.i().f(), bVar, i2);
    }

    public static e g(int i) {
        b bVar;
        ArrayList<b> g = d.i().g();
        if (g.isEmpty()) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= g.size()) {
                bVar = null;
                break;
            }
            bVar = g.get(i2);
            if (bVar != null && bVar.b == i) {
                break;
            }
            i2++;
        }
        if (bVar == null) {
            return null;
        }
        return new e(d.i().g(), bVar, i2);
    }

    private static void a() {
        SparseIntArray sparseIntArray = new SparseIntArray(64);
        f8247a = sparseIntArray;
        sparseIntArray.put(4096, R.drawable.nsdk_ugc_upload);
        f8247a.put(4102, R.drawable.nsdk_rg_ic_ugc_report_innavi);
        SparseIntArray sparseIntArray2 = f8247a;
        int i = R.drawable.nsdk_ugc_report_camera_icon;
        sparseIntArray2.put(4098, i);
        f8247a.put(4099, i);
        f8247a.put(4100, R.drawable.nsdk_ugc_report_map_point_icon);
        f8247a.put(40, R.drawable.nsdk_type_default_new_road);
        f8247a.put(2, R.drawable.nsdk_type_default_trafic_rule);
        f8247a.put(3, R.drawable.nsdk_type_default_electron_eye);
        SparseIntArray sparseIntArray3 = f8247a;
        int i2 = R.drawable.nsdk_type_default_trafic_jam;
        sparseIntArray3.put(4, i2);
        SparseIntArray sparseIntArray4 = f8247a;
        int i3 = R.drawable.nsdk_type_default_trafic_accident;
        sparseIntArray4.put(5, i3);
        SparseIntArray sparseIntArray5 = f8247a;
        int i4 = R.drawable.nsdk_type_default_road_build;
        sparseIntArray5.put(6, i4);
        SparseIntArray sparseIntArray6 = f8247a;
        int i5 = R.drawable.nsdk_type_default_road_closed;
        sparseIntArray6.put(7, i5);
        SparseIntArray sparseIntArray7 = f8247a;
        int i6 = R.drawable.nsdk_type_default_ponding;
        sparseIntArray7.put(51, i6);
        SparseIntArray sparseIntArray8 = f8247a;
        int i7 = R.drawable.nsdk_type_default_snows;
        sparseIntArray8.put(53, i7);
        SparseIntArray sparseIntArray9 = f8247a;
        int i8 = R.drawable.nsdk_type_default_freeze;
        sparseIntArray9.put(54, i8);
        SparseIntArray sparseIntArray10 = f8247a;
        int i9 = R.drawable.nsdk_type_default_fog;
        sparseIntArray10.put(55, i9);
        f8247a.put(61445, i3);
        f8247a.put(61444, i2);
        SparseIntArray sparseIntArray11 = f8247a;
        int i10 = R.drawable.nsdk_type_default_road_police;
        sparseIntArray11.put(61449, i10);
        SparseIntArray sparseIntArray12 = f8247a;
        int i11 = R.drawable.nsdk_type_default_dangerous;
        sparseIntArray12.put(61450, i11);
        f8247a.put(61446, i4);
        f8247a.put(61447, i5);
        f8247a.put(61491, i6);
        f8247a.put(61493, i7);
        f8247a.put(61494, i8);
        f8247a.put(61495, i9);
        f8247a.put(8, R.drawable.nsdk_ugc_default_traffic_regulate);
        f8247a.put(9, i10);
        f8247a.put(10, i11);
        f8247a.put(15, R.drawable.nsdk_type_default_limited_speed);
        f8247a.put(57345, R.drawable.nsdk_ugc_map_main_new_position);
        f8247a.put(57346, R.drawable.nsdk_ugc_map_main_err_position);
        f8247a.put(57347, R.drawable.nsdk_ugc_map_main_check);
        f8247a.put(57351, R.drawable.nsdk_ugc_map_main_store_identification);
        f8247a.put(57353, R.drawable.nsdk_ugc_map_main_road_nonexist);
        SparseIntArray sparseIntArray13 = f8247a;
        int i12 = R.drawable.nsdk_ugc_map_main_add_road;
        sparseIntArray13.put(57352, i12);
        f8247a.put(57354, R.drawable.nsdk_ugc_map_main_road_name);
        f8247a.put(57355, R.drawable.nsdk_ugc_map_main_traffic_signs_error);
        f8247a.put(57356, R.drawable.nsdk_ugc_map_main_speed_limit);
        f8247a.put(57357, R.drawable.nsdk_ugc_map_main_other_road_problem);
        f8247a.put(57350, R.drawable.nsdk_ugc_map_main_bus_error);
        f8247a.put(57348, i12);
        f8247a.put(57349, R.drawable.nsdk_ugc_map_main_road_error_report);
        f8247a.put(3104, R.drawable.nsdk_truck_ugc_icon_stealing_oil);
        f8247a.put(3105, R.drawable.nsdk_truck_ugc_icon_break_rules);
        f8247a.put(3106, R.drawable.nsdk_truck_ugc_icon_discount_oil);
        f8247a.put(3108, R.drawable.nsdk_truck_ugc_icon_repair_maintain);
        f8247a.put(OxXXx0X.f13062Oox, R.drawable.nsdk_truck_ugc_icon_add_water_air);
        f8247a.put(OxXXx0X.f13184oXIoIo, R.drawable.nsdk_truck_ugc_icon_rush_through);
        f8247a.put(3114, R.drawable.nsdk_truck_ugc_icon_food);
        f8247a.put(3115, R.drawable.nsdk_truck_ugc_icon_entertainment);
    }

    public static void b() {
        SparseIntArray sparseIntArray = new SparseIntArray(8);
        b = sparseIntArray;
        sparseIntArray.put(2, R.drawable.nsdk_ugc_report_navi_mayi_ic_forbidden);
        b.put(13, R.drawable.nsdk_route_report_icon_parent_4);
        b.put(40, R.drawable.nsdk_ugc_map_main_road_nonexist);
        b.put(15, R.drawable.nsdk_ugc_map_main_speed_limit);
        b.put(47, R.drawable.nsdk_ugc_report_navi_mayi_chedaoxinxi);
        b.put(12, R.drawable.nsdk_route_report_icon_parent_2);
        b.put(48, R.drawable.nsdk_ugc_report_navi_mayi_ic_lukou);
        b.put(45, R.drawable.nsdk_ugc_map_main_other_road_problem);
    }

    public static void c() {
        SparseIntArray sparseIntArray = new SparseIntArray(8);
        d = sparseIntArray;
        sparseIntArray.put(2, R.drawable.nsdk_type_default_first_jinxing);
        d.put(40, R.drawable.nsdk_type_default_new_road);
        d.put(15, R.drawable.nsdk_type_default_limited_speed);
        d.put(47, R.drawable.nsdk_type_default_daoxiang);
        d.put(48, R.drawable.nsdk_type_default_datu);
        d.put(45, R.drawable.nsdk_type_default_qita);
        d.put(12, R.drawable.nsdk_type_playerr);
    }

    public static void d() {
        SparseIntArray sparseIntArray = new SparseIntArray(32);
        c = sparseIntArray;
        sparseIntArray.put(2, R.drawable.nsdk_ugc_report_navi_mayi_ic_forbidden);
        c.put(13, R.drawable.nsdk_route_report_icon_parent_4);
        c.put(15, R.drawable.nsdk_ugc_map_main_speed_limit);
        c.put(47, R.drawable.nsdk_ugc_report_navi_mayi_chedaoxinxi);
        c.put(12, R.drawable.nsdk_route_report_icon_parent_2);
        c.put(48, R.drawable.nsdk_ugc_report_navi_mayi_ic_lukou);
        c.put(45, R.drawable.nsdk_ugc_map_main_other_road_problem);
        c.put(4, R.drawable.nsdk_type_default_trafic_jam);
        c.put(5, R.drawable.nsdk_type_default_trafic_accident);
        c.put(6, R.drawable.nsdk_type_default_road_build);
        c.put(7, R.drawable.nsdk_type_default_road_closed);
        c.put(8, R.drawable.nsdk_ugc_default_traffic_regulate_color);
        c.put(9, R.drawable.nsdk_type_default_road_police_color);
        c.put(10, R.drawable.nsdk_type_default_dangerous);
        c.put(51, R.drawable.nsdk_type_default_ponding);
        c.put(53, R.drawable.nsdk_type_default_snows);
        c.put(54, R.drawable.nsdk_type_default_freeze);
        c.put(55, R.drawable.nsdk_type_default_fog);
        c.put(3104, R.drawable.nsdk_truck_ugc_icon_stealing_oil);
        c.put(3105, R.drawable.nsdk_truck_ugc_icon_break_rules);
        c.put(3106, R.drawable.nsdk_truck_ugc_icon_discount_oil);
        c.put(3108, R.drawable.nsdk_truck_ugc_icon_repair_maintain);
        c.put(OxXXx0X.f13062Oox, R.drawable.nsdk_truck_ugc_icon_add_water_air);
        c.put(OxXXx0X.f13184oXIoIo, R.drawable.nsdk_truck_ugc_icon_rush_through);
        c.put(3114, R.drawable.nsdk_truck_ugc_icon_food);
        c.put(3115, R.drawable.nsdk_truck_ugc_icon_entertainment);
    }

    private static void e() {
        e = new HashMap();
        ArrayList<b> f = d.i().f();
        if (f != null) {
            for (int i = 0; i < f.size(); i++) {
                if (f.get(i) != null && f.get(i).c != null) {
                    e.put(Integer.valueOf(f.get(i).b), f.get(i).c);
                }
            }
        }
        ArrayList<b> d2 = d.i().d();
        if (d2 != null) {
            for (int i2 = 0; i2 < d2.size(); i2++) {
                if (d2.get(i2) != null && d2.get(i2).c != null) {
                    e.put(Integer.valueOf(d2.get(i2).b + 61440), d2.get(i2).c);
                }
            }
        }
        if (d.i().a() != null && !TextUtils.isEmpty(d.i().a().f8249a)) {
            e.put(4096, d.i().a().f8249a);
        }
        if (TextUtils.isEmpty(d.i().c())) {
            return;
        }
        e.put(4102, d.i().c());
    }

    public static e f() {
        return new e(d.i().g(), null, -1);
    }

    public static int a(int i, boolean z) {
        if (i != 10) {
            switch (i) {
                case 4:
                    return R.drawable.nsdk_type_default_trafic_jam;
                case 5:
                    return R.drawable.nsdk_type_default_trafic_accident;
                case 6:
                    return R.drawable.nsdk_type_default_road_build;
                case 7:
                    return R.drawable.nsdk_type_default_road_closed;
                case 8:
                    if (z) {
                        return R.drawable.nsdk_ugc_interaction_big_guanzhi;
                    }
                    return R.drawable.nsdk_ugc_interaction_small_guanzhi;
                default:
                    switch (i) {
                        case 51:
                            return R.drawable.nsdk_type_default_ponding;
                        case 52:
                            if (z) {
                                return R.drawable.nsdk_ugc_interaction_big_gonggao;
                            }
                            return R.drawable.nsdk_ugc_interaction_small_gonggao;
                        case 53:
                        case 54:
                            return R.drawable.nsdk_type_default_snows;
                        case 55:
                            return R.drawable.nsdk_type_default_fog;
                        default:
                            if (z) {
                                return R.drawable.nsdk_ugc_interaction_big_gonggao;
                            }
                            return R.drawable.nsdk_ugc_interaction_small_gonggao;
                    }
            }
        }
        return R.drawable.nsdk_type_default_dangerous;
    }
}
