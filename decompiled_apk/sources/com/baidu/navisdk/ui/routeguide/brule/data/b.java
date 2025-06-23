package com.baidu.navisdk.ui.routeguide.brule.data;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.behavrules.data.c;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.module.pronavi.model.d;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.module.routepreference.i;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class b implements c {
    private int b() {
        Bundle k = a0.I().k();
        return (int) (((k == null || !k.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) ? 0 : k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) + BNRouteGuider.getInstance().getCurrentRouteDrvieDistance());
    }

    private String c(String str) {
        d a2;
        if (!TextUtils.isEmpty(str) && str.startsWith(NotificationCompat.CATEGORY_SERVICE)) {
            String[] split = str.split("\\|");
            if (split.length >= 3 && TextUtils.equals(split[1], "cur")) {
                return a(com.baidu.navisdk.ui.routeguide.b.V().m().a(), split[2]);
            }
            if (split.length >= 4 && TextUtils.equals(split[1], "next") && (a2 = a(split[2], 1)) != null) {
                return a(a2, split[3]);
            }
        }
        return null;
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a() {
        return "nav_car";
    }

    public String a(int i) {
        if (i == 1) {
            return "petrol_station";
        }
        if (i == 2) {
            return "charge_station";
        }
        if (i == 4) {
            return "gas";
        }
        if (i == 8) {
            return "park";
        }
        if (i == 16) {
            return "garage";
        }
        if (i == 32) {
            return "dining";
        }
        if (i == 64) {
            return "toilet";
        }
        if (i == 128) {
            return "shop";
        }
        if (i != 256) {
            return null;
        }
        return "recreation";
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(str, "total_distance")) {
            return String.valueOf(b());
        }
        if (str.startsWith("approach_num")) {
            return b(str);
        }
        if (str.startsWith(NotificationCompat.CATEGORY_SERVICE)) {
            return c(str);
        }
        if (TextUtils.equals(str, "is_enlarge_status")) {
            return String.valueOf(x.b().b2());
        }
        if (TextUtils.equals(str, "is_hd_status")) {
            com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
            if (s == null) {
                return "false";
            }
            if (!s.A() && !s.D()) {
                r3 = false;
            }
            return String.valueOf(r3);
        }
        if (TextUtils.equals(str, "support_new_btn")) {
            return !com.baidu.navisdk.module.newguide.a.e().d() ? "false" : String.valueOf(com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true));
        }
        if (TextUtils.equals(str, "cur_route_plan_pref")) {
            return String.valueOf(com.baidu.navisdk.module.routepreference.c.f(com.baidu.navisdk.module.vehiclemanager.b.i().b()));
        }
        if (TextUtils.equals(str, "cur_route_plan_pref_name")) {
            return String.valueOf(i.j().b());
        }
        if (TextUtils.equals(str, "route_has_toll_station")) {
            return String.valueOf(b("toll", 0) != null);
        }
        if (TextUtils.equals(str, "is_over_speed")) {
            return String.valueOf(g.o().j());
        }
        if (!TextUtils.equals(str, "jamming_road_dist")) {
            return null;
        }
        com.baidu.navisdk.logicframe.b h = com.baidu.navisdk.ui.routeguide.b.V().h();
        if (h == null) {
            return "0";
        }
        h a2 = h.j().e("BNRoadConditionService").a(4).a();
        return String.valueOf(a2 != null ? a2.c("resultA") : 0);
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("approach_num")) {
            String[] split = str.split("\\|");
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> b = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b();
            if (split.length == 1) {
                return String.valueOf(b.size());
            }
            if (split.length == 2 && TextUtils.equals(split[1], "charge")) {
                n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
                return (c == null || c.r()) ? "1" : "0";
            }
        }
        return null;
    }

    private d b(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(str, "toll")) {
            i2 = 1;
        } else if (TextUtils.equals(str, "entry")) {
            i2 = 2;
        } else if (TextUtils.equals(str, "exit")) {
            i2 = 3;
        } else if (TextUtils.equals(str, "normal_service")) {
            i2 = 4;
        } else if (TextUtils.equals(str, "fast_way_exit")) {
            i2 = 5;
        } else if (TextUtils.equals(str, "charge_station")) {
            i2 = 6;
        } else if (TextUtils.equals(str, "charge_service")) {
            i2 = 7;
        } else {
            if (!TextUtils.equals(str, "direction")) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                if (gVar.d()) {
                    gVar.e("BNRGBRuleDataCenter", "findServiceAreaBean() error, key = " + str + " target = " + i);
                }
                return null;
            }
            i2 = 1000;
        }
        n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c == null) {
            return null;
        }
        List<d> a2 = c.a(true);
        for (int i3 = 0; i3 < a2.size(); i3++) {
            d dVar = a2.get(i3);
            if (dVar.p() == i2) {
                return dVar;
            }
        }
        return null;
    }

    private d a(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(str, "toilet")) {
            i2 = 64;
        } else if (TextUtils.equals(str, "charge_station")) {
            i2 = 2;
        } else if (TextUtils.equals(str, "dining")) {
            i2 = 32;
        } else if (TextUtils.equals(str, "petrol_station")) {
            i2 = 1;
        } else if (TextUtils.equals(str, "recreation")) {
            i2 = 256;
        } else {
            if (!TextUtils.equals(str, "default")) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                if (gVar.d()) {
                    gVar.e("BNRGBRuleDataCenter", "findServiceAreaBean() error, key = " + str + " target = " + i);
                }
                return null;
            }
            i2 = 0;
        }
        n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c == null) {
            return null;
        }
        List<d> a2 = c.a(true);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < a2.size(); i3++) {
            d dVar = a2.get(i3);
            if (dVar.p() == 4 || dVar.p() == 7) {
                arrayList.add(dVar);
            }
        }
        while (i < arrayList.size()) {
            d dVar2 = (d) arrayList.get(i);
            if (i2 == 0 || dVar2.o().contains(Integer.valueOf(i2))) {
                return dVar2;
            }
            i++;
        }
        return null;
    }

    private String a(d dVar, String str) {
        if (dVar == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -987720135:
                if (str.equals("distanceform")) {
                    c = 0;
                    break;
                }
                break;
            case 106911:
                if (str.equals("lat")) {
                    c = 1;
                    break;
                }
                break;
            case 107301:
                if (str.equals("lng")) {
                    c = 2;
                    break;
                }
                break;
            case 115792:
                if (str.equals("uid")) {
                    c = 3;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 4;
                    break;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
                    c = 5;
                    break;
                }
                break;
            case 110844025:
                if (str.equals("types")) {
                    c = 6;
                    break;
                }
                break;
            case 288459765:
                if (str.equals(xOxOoo.f15470o00)) {
                    c = 7;
                    break;
                }
                break;
            case 537652868:
                if (str.equals("typesname")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return dVar.m() + dVar.n();
            case 1:
                return String.valueOf(dVar.j().getLatitudeE6());
            case 2:
                return String.valueOf(dVar.j().getLongitudeE6());
            case 3:
                return "";
            case 4:
                return dVar.h();
            case 5:
                return String.valueOf(dVar.p());
            case 6:
                List<Integer> o = dVar.o();
                StringBuilder sb = new StringBuilder();
                if (o != null) {
                    Iterator<Integer> it = o.iterator();
                    while (it.hasNext()) {
                        sb.append(a(it.next().intValue()));
                        sb.append(",");
                    }
                }
                return sb.toString();
            case 7:
                return String.valueOf(dVar.k());
            case '\b':
                List<Integer> o2 = dVar.o();
                StringBuilder sb2 = new StringBuilder();
                if (o2 != null) {
                    Iterator<Integer> it2 = o2.iterator();
                    while (it2.hasNext()) {
                        sb2.append(d.g(it2.next().intValue()));
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            default:
                return null;
        }
    }
}
