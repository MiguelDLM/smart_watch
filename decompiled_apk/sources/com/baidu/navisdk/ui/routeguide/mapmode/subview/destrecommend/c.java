package com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    String f8746a;
    String b;
    List<b> c;
    int d;
    a e;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f8747a;
        String b;
        String c;
        com.baidu.nplatform.comapi.basestruct.c d;
        String e;
        String f;
        int g;
        int h;

        public String toString() {
            return "Poi{id=" + this.f8747a + ", uid='" + this.b + "', bubbleTag='" + this.c + "', point=" + this.d + ", name='" + this.e + "', tag='" + this.f + "', patternId=" + this.g + ", calcType=" + this.h + '}';
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f8748a;
        String b;
        int c;
        List<a> d;

        public String toString() {
            return "Tab{title='" + this.f8748a + "', iconUrl='" + this.b + "', calcType=" + this.c + ", poiList=" + this.d + '}';
        }
    }

    public static c a(Bundle bundle) {
        c cVar = new c();
        cVar.b = bundle.getString("title");
        cVar.d = bundle.getInt("scene");
        bundle.getString("voice");
        if (cVar.d != 0) {
            RoutePlanNode g = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
            if (g == null) {
                return cVar;
            }
            a aVar = new a();
            cVar.e = aVar;
            aVar.g = 0;
            aVar.f8747a = new Random().nextInt();
            GeoPoint geoPoint = g.getGeoPoint();
            Bundle c = o.c(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
            cVar.e.d = new com.baidu.nplatform.comapi.basestruct.c(c.getInt("MCx"), c.getInt("MCy"));
            cVar.e.b = g.getUID();
            cVar.e.e = g.getName();
            cVar.e.h = 0;
        }
        cVar.f8746a = bundle.getString("tag");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("tabs");
        if (parcelableArrayList != null) {
            cVar.c = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                Bundle bundle2 = (Bundle) it.next();
                b bVar = new b();
                bVar.f8748a = bundle2.getString("title");
                bVar.b = bundle2.getString("icon_url");
                bVar.c = bundle2.getInt("calc_type");
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList("poi_list");
                if (parcelableArrayList2 != null) {
                    bVar.d = new ArrayList();
                    Iterator it2 = parcelableArrayList2.iterator();
                    while (it2.hasNext()) {
                        Bundle bundle3 = (Bundle) it2.next();
                        a aVar2 = new a();
                        aVar2.d = new com.baidu.nplatform.comapi.basestruct.c(bundle3.getInt("view_x"), bundle3.getInt("view_y"));
                        aVar2.h = bVar.c;
                        aVar2.g = bundle3.getInt("pattern_id");
                        aVar2.b = bundle3.getString("uid");
                        aVar2.c = bundle3.getString("bubble_tag");
                        aVar2.f = bundle3.getString("tag");
                        aVar2.f8747a = Math.abs(new Random().nextInt());
                        aVar2.e = bundle3.getString("name");
                        bVar.d.add(aVar2);
                    }
                }
                if (TextUtils.equals(bVar.f8748a, IBNRouteResultManager.NearbySearchKeyword.Park) && !BNCommSettingManager.getInstance().getPrefParkSearch()) {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("DestRecommend", "isCanShowDestPark false Park switch off");
                    }
                } else {
                    cVar.c.add(bVar);
                }
            }
        }
        return cVar;
    }

    public String toString() {
        return "DestRecommendModel{tag='" + this.f8746a + "', title='" + this.b + "', tabList=" + this.c + ", scene=" + this.d + ", mainPoi=" + this.e + '}';
    }

    public boolean a() {
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        if (this.d != 0) {
            return this.e != null;
        }
        List<b> list = this.c;
        return (list == null || list.size() == 0) ? false : true;
    }
}
