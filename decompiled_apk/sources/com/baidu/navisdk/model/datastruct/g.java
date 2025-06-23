package com.baidu.navisdk.model.datastruct;

import android.os.Bundle;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class g implements Cloneable {
    public float c;
    public float e;
    public float f;
    public int g;
    public double h;

    @Deprecated
    public int i;
    public long j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;
    public String p;
    public String q;
    public Bundle r;

    /* renamed from: a, reason: collision with root package name */
    public double f6926a = -1.0d;
    public double b = -1.0d;
    public float d = -1.0f;

    public String a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, this.b);
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, this.f6926a);
            jSONObject2.put("radius", this.f);
            jSONObject2.put("direction", this.e);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            jSONObject2.put("iconarrownorid", 28);
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("iconarrowfocid", 29);
            jSONArray.put(jSONObject2);
            if (z) {
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, this.b);
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, this.f6926a);
                jSONObject3.put("radius", 0);
                jSONObject3.put("direction", 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public boolean b() {
        if (this.b != -1.0d && this.f6926a != -1.0d) {
            return true;
        }
        return false;
    }

    public GeoPoint c() {
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLongitudeE6((int) (this.b * 100000.0d));
        geoPoint.setLatitudeE6((int) (this.f6926a * 100000.0d));
        return geoPoint;
    }

    public String toString() {
        return "LocData{latitude=" + this.f6926a + ", longitude=" + this.b + ", speed=" + this.c + ", bias=" + this.d + ", direction=" + this.e + ", accuracy=" + this.f + ", satellitesNum=" + this.g + ", altitude=" + this.h + ", type=" + this.i + ", time=" + this.j + ", locType=" + this.k + ", indoorState=" + this.l + ", networkLocType='" + this.m + "', roadLoc='" + this.n + "', gpsType=" + this.o + ", floorId='" + this.p + "', buildingId='" + this.q + "', extraInfo=" + this.r + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public g m84clone() {
        g gVar = new g();
        synchronized (this) {
            gVar.f = this.f;
            gVar.d = this.d;
            gVar.e = this.e;
            gVar.f6926a = this.f6926a;
            gVar.b = this.b;
            gVar.g = this.g;
            gVar.c = this.c;
            gVar.h = this.h;
            gVar.i = this.i;
            gVar.j = this.j;
            gVar.k = this.k;
            gVar.l = this.l;
            gVar.m = this.m;
            gVar.n = this.n;
            gVar.o = this.o;
            gVar.r = this.r;
        }
        return gVar;
    }

    public String a() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("low_acc_lat_wgs84") && this.r.containsKey("low_acc_lon_wgs84")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("normalGPSLongtitude", this.r.getDouble("low_acc_lon_wgs84"));
                jSONObject.put("normalGPSLatitude", this.r.getDouble("low_acc_lat_wgs84"));
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.c()) {
                    gVar.c("LocData", "getJsonData() error = " + e);
                }
            }
        }
        return null;
    }
}
