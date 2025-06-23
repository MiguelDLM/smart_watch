package com.baidu.navisdk.poisearch;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.z;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b {
    public static boolean a(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i, Handler handler, int i2) {
        t tVar;
        com.baidu.navisdk.poisearch.model.a.k().d(i2);
        if (arrayList != null && arrayList.size() != 0 && !TextUtils.isEmpty(arrayList.get(0))) {
            String[] strArr = {arrayList.get(0)};
            if (!z.b(context)) {
                LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: Error --> Network Error");
                return false;
            }
            if (b()) {
                LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: Error --> Offline poi search");
                return false;
            }
            com.baidu.navisdk.poisearch.model.a.k().c = true;
            com.baidu.navisdk.poisearch.model.a.k().a(arrayList.get(0));
            ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).d().clear();
            if (TextUtils.equals(arrayList.get(0), "其它")) {
                String str = arrayList.get(0);
                if (arrayList2 != null) {
                    str = arrayList2.get(0);
                }
                String str2 = str;
                com.baidu.navisdk.poisearch.model.a.k().b((String) null);
                LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: --> type: " + str2);
                tVar = new t(str2, null, 1, 1000, i, 1);
            } else if (arrayList2 != null && arrayList2.size() != 0 && !TextUtils.isEmpty(arrayList2.get(0))) {
                LogUtil.e("BNPoiSearchProxy", "subkey = " + arrayList2.get(0));
                com.baidu.navisdk.poisearch.model.a.k().b(arrayList2.get(0));
                String[] strArr2 = {arrayList2.get(0)};
                LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: --> type: " + strArr[0] + ", subType: " + strArr2[0] + ", poiCount: " + i + ", handler: " + handler);
                tVar = new t(strArr[0], strArr2[0], 0, 1000, i, 1);
            } else {
                com.baidu.navisdk.poisearch.model.a.k().b((String) null);
                LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: --> type: " + strArr[0] + ", subType: null, poiCount: " + i + ", handler: " + handler);
                tVar = new t(strArr[0], null, 0, 1000, i, 1);
            }
            return c.a(tVar, 30000, handler);
        }
        LogUtil.e("BNPoiSearchProxy", "asyncRouteSearchPoiByType: Error --> Illegal Params");
        return false;
    }

    public static boolean b() {
        return BNRoutePlaner.getInstance().B();
    }

    public static void c() {
        LogUtil.e("BNPoiSearchProxy", "resetRouteSearchFromNavi");
        try {
            a();
            com.baidu.navisdk.poisearch.model.b.m().d(false);
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            com.baidu.navisdk.poisearch.model.a.k().c = false;
            com.baidu.navisdk.poisearch.model.a.k().j = null;
            com.baidu.navisdk.poisearch.model.a.k().a((com.baidu.navisdk.poisearch.view.interfaces.a) null);
            com.baidu.navisdk.poisearch.model.a.k().a("");
            com.baidu.navisdk.poisearch.model.a.k().b("");
            com.baidu.navisdk.poisearch.model.a.k().a(false);
            com.baidu.navisdk.poisearch.model.a.k().e(-1);
            c.b();
            c.a();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().clearLayer(4);
            BNMapController.getInstance().showLayer(4, false);
            BNMapController.getInstance().setRouteSearchStatus(false);
            BNMapController.getInstance().sendCommandToMapEngine(6, null);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNPoiSearchProxy", "resetRouteSearch --> e = " + e);
            }
        }
    }

    public static void a(List<s> list, int i, int i2) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("BNPoiSearchProxy", "updatePoiBkgLayer --> type = " + i + ", source = " + i2);
            gVar.a("BNPoiSearchProxy", "updatePoiBkgLayer", "searchPois", list);
        }
        BNMapController.getInstance().updateLayer(3);
        if (list == null) {
            LogUtil.e("BNPoiSearchProxy", "updatePoiBkgLayer: --> Params Error");
            return;
        }
        c.a();
        c.a(list, i, i2, -1);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().showLayer(4, true);
        BNMapController.getInstance().sendCommandToMapEngine(5, null);
    }

    public static Rect a(List<s> list) {
        GeoPoint geoPoint;
        LogUtil.e("BNPoiSearchProxy", "updateMapView searchPois size :" + list.size());
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        for (s sVar : list) {
            if (sVar != null && (geoPoint = sVar.k) != null && !a(geoPoint)) {
                if (i > sVar.k.getLongitudeE6()) {
                    i = sVar.k.getLongitudeE6();
                }
                if (i4 < sVar.k.getLongitudeE6()) {
                    i4 = sVar.k.getLongitudeE6();
                }
                if (i3 < sVar.k.getLatitudeE6()) {
                    i3 = sVar.k.getLatitudeE6();
                }
                if (i2 > sVar.k.getLatitudeE6()) {
                    i2 = sVar.k.getLatitudeE6();
                }
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPoiSearchProxy", "updateMapView --> left = " + i + ", top = " + i3 + ", right = " + i4 + ", bottom = " + i2);
        }
        Bundle c = o.c(i4, i2);
        Bundle c2 = o.c(i, i3);
        return new Rect(c2.getInt("MCx"), c2.getInt("MCy"), c.getInt("MCx"), c.getInt("MCy"));
    }

    private static boolean a(GeoPoint geoPoint) {
        return !geoPoint.isValid() || (geoPoint.getLongitudeE6() == 0 && geoPoint.getLatitudeE6() == 0);
    }

    public static void a(String str, List<s> list) {
        if (LogUtil.LOGGABLE) {
            if (list == null) {
                LogUtil.e("BNPoiSearchProxy", str + " --> searchPoiList is null!!!");
                return;
            }
            StringBuilder sb = new StringBuilder(str + " --> searchPoiList is ");
            for (s sVar : list) {
                sb.append("\n        ");
                sb.append(sVar);
            }
            LogUtil.e("BNPoiSearchProxy", sb.toString());
        }
    }

    public static void a(MapItem mapItem, d dVar) {
        String str;
        if (mapItem != null && (str = mapItem.mUid) != null && dVar != null) {
            a(str, mapItem.mBundleParams, dVar);
            return;
        }
        LogUtil.e("BNPoiSearchProxy", "handleBkgClick: Error --> mapItem: " + mapItem + ", poiClickListener: " + dVar);
    }

    public static void a(String str, Bundle bundle, d dVar) {
        t tVar;
        ArrayList<s> g;
        s sVar;
        GeoPoint geoPoint;
        if (str != null && dVar != null) {
            int a2 = c.a(str);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNPoiSearchProxy", "handleBkgClick --> click poiIndex = " + a2 + ", last poiIndex = " + com.baidu.navisdk.poisearch.model.a.k().e());
            }
            if (a2 >= 0) {
                boolean z = false;
                if (com.baidu.navisdk.poisearch.model.a.k().e() > -1) {
                    if (com.baidu.navisdk.poisearch.model.a.k().e() == a2) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BNPoiSearchProxy", "handleBkgClick --> click same index poi, return!!!");
                            return;
                        }
                        return;
                    } else {
                        BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
                        BNMapController.getInstance().updateLayer(4);
                        com.baidu.navisdk.poisearch.model.a.k().j();
                    }
                }
                List<t> d = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).d();
                if (d == null || d.size() < 1 || (tVar = d.get(0)) == null || (g = tVar.g()) == null || a2 < 0 || a2 >= g.size() || (geoPoint = (sVar = g.get(a2)).k) == null || !geoPoint.isValid()) {
                    return;
                }
                if (TextUtils.isEmpty(sVar.g)) {
                    LogUtil.e("BNPoiSearchProxy", "handleBkgClick: return --> searchPoi mAddress is null");
                    return;
                }
                sVar.v = (bundle == null || !bundle.containsKey(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE)) ? 0 : bundle.getInt(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE);
                if (bundle != null && bundle.containsKey(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL)) {
                    z = bundle.getBoolean(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL);
                }
                sVar.w = z;
                BNMapController.getInstance().focusItem(4, a2, true);
                com.baidu.navisdk.poisearch.model.a.k().c(a2);
                dVar.a(a2, sVar, true);
                return;
            }
            return;
        }
        LogUtil.e("BNPoiSearchProxy", "handleBkgClick: Error --> uid: " + str + ", extraData: " + bundle + ", poiClickListener: " + dVar);
    }

    public static void a() {
        LogUtil.e("BNPoiSearchProxy", "clearBkgFocusState: getLastBkgItemId --> " + com.baidu.navisdk.poisearch.model.a.k().e());
        if (com.baidu.navisdk.poisearch.model.a.k().e() > -1) {
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            BNMapController.getInstance().updateLayer(4);
            com.baidu.navisdk.poisearch.model.a.k().j();
        }
    }
}
