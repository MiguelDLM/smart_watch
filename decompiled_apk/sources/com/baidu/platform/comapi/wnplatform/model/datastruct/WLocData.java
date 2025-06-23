package com.baidu.platform.comapi.wnplatform.model.datastruct;

import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class WLocData implements Cloneable {
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkLocation = 161;

    /* renamed from: a, reason: collision with root package name */
    private int f9938a;
    public float accuracy;
    public String addr;
    public double altitude;
    private String b;
    public String city;
    public String cityCode;
    public int coordType;
    public float direction;
    public String district;
    public int indoorState;
    public int isIbeacon;
    public boolean isIndoorMode;
    public String networkLocType;
    public String province;
    public int satellitesNum;
    public float speed;
    public int type;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    public String buildingId = "";
    public String floorId = "";

    public int getLocType() {
        if (this.isIndoorMode) {
            return 2;
        }
        return 1;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BigDecimal bigDecimal = new BigDecimal(this.longitude);
            RoundingMode roundingMode = RoundingMode.UP;
            jSONObject.put("lng", bigDecimal.setScale(5, roundingMode));
            jSONObject.put("lat", new BigDecimal(this.latitude).setScale(5, roundingMode));
            jSONObject.put(RouteGuideParams.RGKey.AssistInfo.Speed, new BigDecimal(this.speed).setScale(2, roundingMode));
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_DIR, new BigDecimal(this.direction).setScale(2, roundingMode));
            jSONObject.put("acc", new BigDecimal(this.accuracy).setScale(2, roundingMode));
            jSONObject.put("alt", new BigDecimal(this.altitude).setScale(1, roundingMode));
            jSONObject.put("bui", this.buildingId);
            jSONObject.put("floor", this.floorId);
            jSONObject.put("locType", getLocType());
            jSONObject.put("timestamp", this.f9938a);
            jSONObject.put("tag", this.b);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WLocData m98clone() {
        WLocData wLocData = new WLocData();
        synchronized (this) {
            try {
                wLocData.accuracy = this.accuracy;
                wLocData.direction = this.direction;
                wLocData.latitude = this.latitude;
                wLocData.longitude = this.longitude;
                wLocData.satellitesNum = this.satellitesNum;
                wLocData.speed = this.speed;
                wLocData.altitude = this.altitude;
                wLocData.coordType = this.coordType;
                wLocData.buildingId = this.buildingId;
                String str = this.floorId;
                if (str != null && !str.isEmpty()) {
                    wLocData.floorId = this.floorId.toUpperCase();
                } else {
                    wLocData.floorId = this.floorId;
                }
                wLocData.networkLocType = this.networkLocType;
                wLocData.isIbeacon = this.isIbeacon;
                wLocData.isIndoorMode = this.isIndoorMode;
                wLocData.indoorState = this.indoorState;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wLocData;
    }
}
