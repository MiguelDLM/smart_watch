package com.baidu.platform.core.f;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class k extends com.baidu.platform.base.d {
    SuggestAddrInfo b = null;
    protected boolean c;

    private boolean b(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject == null || optJSONObject.optInt("type") != 23 || optJSONObject.optInt("error") != 0) {
                    return false;
                }
                SuggestAddrInfo a2 = a(jSONObject);
                this.b = a2;
                return a2 != null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        TransitRouteResult transitRouteResult;
        SearchType a2 = a();
        if (b(str)) {
            this.c = true;
        } else {
            this.c = false;
        }
        int i = l.f10003a[a2.ordinal()];
        if (i == 1) {
            TransitRouteResult transitRouteResult2 = new TransitRouteResult();
            if (!this.c) {
                ((m) this).a(str, transitRouteResult2);
                transitRouteResult = transitRouteResult2;
            } else {
                transitRouteResult2.setSuggestAddrInfo(this.b);
                transitRouteResult2.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = transitRouteResult2;
            }
        } else if (i == 2) {
            DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
            if (!this.c) {
                ((c) this).a(str, drivingRouteResult);
                transitRouteResult = drivingRouteResult;
            } else {
                drivingRouteResult.setSuggestAddrInfo(this.b);
                drivingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = drivingRouteResult;
            }
        } else {
            if (i != 3) {
                return null;
            }
            WalkingRouteResult walkingRouteResult = new WalkingRouteResult();
            if (!this.c) {
                ((o) this).a(str, walkingRouteResult);
                transitRouteResult = walkingRouteResult;
            } else {
                walkingRouteResult.setSuggestAddrInfo(this.b);
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = walkingRouteResult;
            }
        }
        return transitRouteResult;
    }

    private List<List<PoiInfo>> b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<PoiInfo> a2 = a(((JSONObject) optJSONArray.opt(i)).optJSONArray("way_ponits"), "");
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private SuggestAddrInfo a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("option");
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
        if (optJSONObject2 != null && optJSONObject3 != null) {
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("start_city");
            String optString = optJSONObject4 != null ? optJSONObject4.optString("cname") : null;
            JSONArray optJSONArray = optJSONObject2.optJSONArray("end_city");
            String optString2 = (optJSONArray == null || (jSONObject2 = (JSONObject) optJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("city_list");
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("prio_flag");
            if (optJSONArray2 != null && optJSONArray3 != null) {
                int length = optJSONArray2.length();
                boolean[] zArr = new boolean[length];
                boolean[] zArr2 = new boolean[length];
                for (int i = 0; i < length; i++) {
                    int parseInt = Integer.parseInt(optJSONArray2.optString(i));
                    int parseInt2 = Integer.parseInt(optJSONArray3.optString(i));
                    boolean z = true;
                    zArr[i] = parseInt == 1;
                    if (parseInt2 != 1) {
                        z = false;
                    }
                    zArr2[i] = z;
                }
                SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr2[i2]) {
                        if (zArr[i2]) {
                            if (i2 == 0) {
                                suggestAddrInfo.setSuggestStartCity(a(optJSONObject3.optJSONArray("start")));
                            } else if (i2 == length - 1 && i2 > 0) {
                                suggestAddrInfo.setSuggestEndCity(a(optJSONObject3.optJSONArray("end")));
                            } else {
                                suggestAddrInfo.setSuggestWpCity(a(optJSONObject3, "multi_waypoints"));
                            }
                        } else if (i2 == 0) {
                            suggestAddrInfo.setSuggestStartNode(a(optJSONObject3.optJSONArray("start"), optString));
                        } else if (i2 == length - 1 && i2 > 0) {
                            suggestAddrInfo.setSuggestEndNode(a(optJSONObject3.optJSONArray("end"), optString2));
                        } else {
                            suggestAddrInfo.setSuggestWpNode(b(optJSONObject3, "multi_waypoints"));
                        }
                    }
                }
                return suggestAddrInfo;
            }
        }
        return null;
    }

    private List<CityInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    private List<PoiInfo> a(JSONArray jSONArray, String str) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.address = jSONObject.optString("addr");
                poiInfo.uid = jSONObject.optString("uid");
                poiInfo.name = jSONObject.optString("name");
                poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                poiInfo.city = str;
                arrayList.add(poiInfo);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private List<List<CityInfo>> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<CityInfo> a2 = a((JSONArray) optJSONArray.opt(i));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        int i = l.f10003a[a().ordinal()];
        if (i == 1) {
            onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
        } else if (i == 2) {
            onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
        } else {
            if (i != 3) {
                return;
            }
            onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
        }
    }
}
