package com.baidu.mapapi.navi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class NaviParaOption {

    /* renamed from: a, reason: collision with root package name */
    LatLng f5925a;
    String b;
    LatLng c;
    String d;
    WayPoint e;
    NaviRoutePolicy f = NaviRoutePolicy.DEFAULT;

    /* loaded from: classes7.dex */
    public enum NaviRoutePolicy {
        BLK,
        TIME,
        DIS,
        FEE,
        HIGHWAY,
        DEFAULT
    }

    public NaviParaOption endName(String str) {
        this.d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public String getEndName() {
        return this.d;
    }

    public LatLng getEndPoint() {
        return this.c;
    }

    public String getNaviRoutePolicy() {
        int i = a.f5929a[this.f.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return "DEFAULT";
                        }
                        return "HIGHWAY";
                    }
                    return "FEE";
                }
                return "DIS";
            }
            return "TIME";
        }
        return "BLK";
    }

    public String getStartName() {
        return this.b;
    }

    public LatLng getStartPoint() {
        return this.f5925a;
    }

    public JSONArray getWayPoint() {
        WayPoint wayPoint = this.e;
        JSONArray jSONArray = null;
        if (wayPoint == null) {
            return null;
        }
        List<WayPointInfo> viaPoints = wayPoint.getViaPoints();
        if (viaPoints != null && viaPoints.size() != 0) {
            jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < viaPoints.size(); i++) {
                WayPointInfo wayPointInfo = viaPoints.get(i);
                if (wayPointInfo != null) {
                    try {
                        if (!TextUtils.isEmpty(wayPointInfo.getWayPointName())) {
                            jSONObject.put("name", wayPointInfo.getWayPointName());
                        }
                        LatLng latLng = wayPointInfo.getLatLng();
                        if (latLng != null) {
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.gcjToBaidu(latLng);
                            }
                            jSONObject.put("lng", latLng.longitude);
                            jSONObject.put("lat", latLng.latitude);
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy naviRoutePolicy) {
        this.f = naviRoutePolicy;
        return this;
    }

    public NaviParaOption setWayPoint(WayPoint wayPoint) {
        if (wayPoint == null) {
            return null;
        }
        this.e = wayPoint;
        return this;
    }

    public NaviParaOption startName(String str) {
        this.b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f5925a = latLng;
        return this;
    }
}
