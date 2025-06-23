package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class FavoriteManager {

    /* renamed from: a, reason: collision with root package name */
    private static FavoriteManager f5779a;
    private static com.baidu.mapsdkplatform.comapi.favrite.a b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (f5779a == null) {
            f5779a = new FavoriteManager();
        }
        return f5779a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return 0;
        }
        if (favoritePoiInfo != null && favoritePoiInfo.c != null) {
            String str = favoritePoiInfo.b;
            if (str != null && !str.equals("")) {
                FavSyncPoi a2 = a.a(favoritePoiInfo);
                int a3 = b.a(a2.b, a2);
                if (a3 == 1) {
                    favoritePoiInfo.f5780a = a2.f6164a;
                    favoritePoiInfo.g = Long.parseLong(a2.h);
                }
                return a3;
            }
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        }
        Log.e("baidumapsdk", "object or pt can not be null!");
        return 0;
    }

    public boolean clearAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        return aVar.c();
    }

    public boolean deleteFavPoi(String str) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str == null || str.equals("")) {
            return false;
        }
        return b.a(str);
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar != null) {
            aVar.b();
            b = null;
            BMapManager.destroy();
            i.b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray optJSONArray;
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String f = aVar.f();
        if (f != null && !f.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject.optInt("favpoinum") != 0 && (optJSONArray = jSONObject.optJSONArray("favcontents")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            arrayList.add(a.a(jSONObject2));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi b2;
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        if (str == null || str.equals("") || (b2 = b.b(str)) == null) {
            return null;
        }
        return a.a(b2);
    }

    public void init() {
        if (b == null) {
            i.a();
            BMapManager.init();
            b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str != null && !str.equals("") && favoritePoiInfo != null) {
            if (favoritePoiInfo.c == null) {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return false;
            }
            String str2 = favoritePoiInfo.b;
            if (str2 != null && !str2.equals("")) {
                favoritePoiInfo.f5780a = str;
                return b.b(str, a.a(favoritePoiInfo));
            }
            Log.e("baidumapsdk", "poiName can not be null or empty!");
        }
        return false;
    }
}
