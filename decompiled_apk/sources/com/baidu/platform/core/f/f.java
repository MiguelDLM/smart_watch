package com.baidu.platform.core.f;

import XIXIX.OOXIXo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.garmin.fit.xOxOoo;
import com.huawei.openalliance.ad.constant.aw;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f extends com.baidu.platform.base.d {
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return indoorRouteResult;
                    }
                    if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            indoorRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            indoorRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            indoorRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                        return indoorRouteResult;
                    }
                }
                if (!a(str, indoorRouteResult)) {
                    indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return indoorRouteResult;
            } catch (Exception unused) {
                indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return indoorRouteResult;
            }
        }
        indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return indoorRouteResult;
    }

    private boolean a(String str, IndoorRouteResult indoorRouteResult) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str2;
        String str3;
        String str4;
        String str5;
        IndoorRouteResult indoorRouteResult2 = indoorRouteResult;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject3 = new JSONObject(str).optJSONObject("indoor_navi");
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("option")) == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("error");
            if (optInt != 0) {
                if (optInt == 6) {
                    indoorRouteResult2.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING;
                    return true;
                }
                if (optInt != 7) {
                    return false;
                }
                indoorRouteResult2.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;
                return true;
            }
            JSONArray optJSONArray = optJSONObject3.optJSONArray("routes");
            if (optJSONArray == null || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("legs");
            if (optJSONArray2 == null) {
                return false;
            }
            int i = 0;
            while (i < optJSONArray2.length()) {
                IndoorRouteLine indoorRouteLine = new IndoorRouteLine();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i);
                if (optJSONObject4 == null) {
                    jSONArray = optJSONArray2;
                } else {
                    String str6 = xOxOoo.f15470o00;
                    indoorRouteLine.setDistance(optJSONObject4.optInt(xOxOoo.f15470o00));
                    String str7 = "duration";
                    indoorRouteLine.setDuration(optJSONObject4.optInt("duration"));
                    String str8 = "sstart_location";
                    indoorRouteLine.setStarting(RouteNode.location(a(optJSONObject4, "sstart_location")));
                    String str9 = "send_location";
                    indoorRouteLine.setTerminal(RouteNode.location(a(optJSONObject4, "send_location")));
                    JSONArray optJSONArray3 = optJSONObject4.optJSONArray("steps");
                    if (optJSONArray3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray3.length()) {
                            IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                            JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i2);
                            if (optJSONObject5 != null) {
                                indoorRouteStep.setDistance(optJSONObject5.optInt(str6));
                                indoorRouteStep.setDuration(optJSONObject5.optInt(str7));
                                indoorRouteStep.setBuildingId(optJSONObject5.optString("buildingid"));
                                indoorRouteStep.setFloorId(optJSONObject5.optString("floorid"));
                                indoorRouteStep.setEntrace(RouteNode.location(a(optJSONObject5, str8)));
                                indoorRouteStep.setExit(RouteNode.location(a(optJSONObject5, str9)));
                                JSONArray optJSONArray4 = optJSONObject5.optJSONArray("spath");
                                if (optJSONArray4 != null) {
                                    jSONArray2 = optJSONArray2;
                                    ArrayList arrayList3 = new ArrayList();
                                    double d = OOXIXo.f3760XO;
                                    jSONArray3 = optJSONArray3;
                                    str2 = str6;
                                    double d2 = 0.0d;
                                    int i3 = 5;
                                    while (i3 < optJSONArray4.length()) {
                                        double optDouble = d + optJSONArray4.optDouble(i3 + 1);
                                        String str10 = str8;
                                        double optDouble2 = d2 + optJSONArray4.optDouble(i3);
                                        JSONArray jSONArray4 = optJSONArray4;
                                        GeoPoint geoPoint = new GeoPoint(0, 0);
                                        geoPoint.setLatitudeE6((int) optDouble);
                                        geoPoint.setLongitudeE6((int) optDouble2);
                                        LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                                        arrayList3.add(Double.valueOf(mc2ll.latitude));
                                        arrayList3.add(Double.valueOf(mc2ll.longitude));
                                        i3 += 2;
                                        optJSONArray4 = jSONArray4;
                                        d = optDouble;
                                        str7 = str7;
                                        d2 = optDouble2;
                                        str8 = str10;
                                        str9 = str9;
                                    }
                                    str3 = str7;
                                    str4 = str8;
                                    str5 = str9;
                                    indoorRouteStep.setPath(arrayList3);
                                    indoorRouteStep.setInstructions(optJSONObject5.optString("instructions"));
                                    JSONArray optJSONArray5 = optJSONObject5.optJSONArray("pois");
                                    if (optJSONArray5 != null) {
                                        ArrayList arrayList4 = new ArrayList();
                                        for (int i4 = 0; i4 < optJSONArray5.length(); i4++) {
                                            JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i4);
                                            if (optJSONObject6 != null) {
                                                IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                                indoorStepNode.setDetail(optJSONObject6.optString(aw.as));
                                                indoorStepNode.setName(optJSONObject6.optString("name"));
                                                indoorStepNode.setType(optJSONObject6.optInt("type"));
                                                indoorStepNode.setLocation(a(optJSONObject6, "location"));
                                                arrayList4.add(indoorStepNode);
                                            }
                                        }
                                        indoorRouteStep.setStepNodes(arrayList4);
                                    }
                                    arrayList2.add(indoorRouteStep);
                                    i2++;
                                    optJSONArray2 = jSONArray2;
                                    optJSONArray3 = jSONArray3;
                                    str6 = str2;
                                    str8 = str4;
                                    str9 = str5;
                                    str7 = str3;
                                }
                            }
                            jSONArray2 = optJSONArray2;
                            jSONArray3 = optJSONArray3;
                            str2 = str6;
                            str3 = str7;
                            str4 = str8;
                            str5 = str9;
                            i2++;
                            optJSONArray2 = jSONArray2;
                            optJSONArray3 = jSONArray3;
                            str6 = str2;
                            str8 = str4;
                            str9 = str5;
                            str7 = str3;
                        }
                        jSONArray = optJSONArray2;
                        if (arrayList2.size() > 0) {
                            indoorRouteLine.setSteps(arrayList2);
                        }
                    } else {
                        jSONArray = optJSONArray2;
                    }
                    arrayList.add(indoorRouteLine);
                }
                i++;
                indoorRouteResult2 = indoorRouteResult;
                optJSONArray2 = jSONArray;
            }
            indoorRouteResult2.setRouteLines(arrayList);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private LatLng a(JSONObject jSONObject, String str) {
        if (jSONObject.optJSONArray(str) == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(0, 0);
        geoPoint.setLatitudeE6((int) r4.optDouble(1));
        geoPoint.setLongitudeE6((int) r4.optDouble(0));
        return CoordUtil.mc2ll(geoPoint);
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
    }
}
