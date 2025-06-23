package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.platform.comapi.basestruct.Point;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class a {
    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.c == null || (str = favoritePoiInfo.b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.b = favoritePoiInfo.b;
        LatLng latLng = favoritePoiInfo.c;
        favSyncPoi.c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.d = favoritePoiInfo.d;
        favSyncPoi.e = favoritePoiInfo.e;
        favSyncPoi.f = favoritePoiInfo.f;
        favSyncPoi.i = false;
        return favSyncPoi;
    }

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        if (favSyncPoi == null || favSyncPoi.c == null || favSyncPoi.b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f5780a = favSyncPoi.f6164a;
        favoritePoiInfo.b = favSyncPoi.b;
        Point point = favSyncPoi.c;
        favoritePoiInfo.c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.e = favSyncPoi.e;
        favoritePoiInfo.f = favSyncPoi.f;
        favoritePoiInfo.d = favSyncPoi.d;
        favoritePoiInfo.g = Long.parseLong(favSyncPoi.h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        if (jSONObject.optJSONObject("pt") != null) {
            favoritePoiInfo.c = new LatLng(r1.optInt("y") / 1000000.0d, r1.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.b = jSONObject.optString("uspoiname");
        favoritePoiInfo.g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.d = jSONObject.optString("addr");
        favoritePoiInfo.f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.e = jSONObject.optString("ncityid");
        favoritePoiInfo.f5780a = jSONObject.optString("key");
        return favoritePoiInfo;
    }
}
