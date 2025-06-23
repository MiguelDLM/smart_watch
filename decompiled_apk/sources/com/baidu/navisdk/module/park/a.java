package com.baidu.navisdk.module.park;

import XIXIX.OOXIXo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.location.LocationConst;
import com.baidu.mapframework.location.LocationChangeListener;
import com.baidu.mapframework.location.LocationManager;
import com.baidu.navisdk.util.common.g;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a implements Serializable {
    private Bitmap h;

    /* renamed from: a, reason: collision with root package name */
    private String f7375a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = -1;
    private String f = "";
    private int g = 0;
    private String i = "";
    private String j = "";
    private double k = OOXIXo.f3760XO;
    private double l = OOXIXo.f3760XO;
    private double m = OOXIXo.f3760XO;
    private double n = OOXIXo.f3760XO;
    private String o = "";
    private String p = "";

    public String a() {
        return this.f;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.f7375a;
    }

    public String e() {
        return this.i;
    }

    public Bitmap f() {
        return this.h;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.o;
    }

    public double i() {
        return this.l;
    }

    public double j() {
        return this.n;
    }

    public double k() {
        return this.k;
    }

    public double l() {
        return this.m;
    }

    public String m() {
        return this.j;
    }

    public boolean n() {
        if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.f7375a)) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "BNRouteSaveParkData{\n\t indoorParkingLotUid='" + this.f7375a + "'\n\t indoorParkUid='" + this.b + "'\n\t indoorArea='" + this.c + "'\n\t indoorParkingLotNum='" + this.d + "'\n\t indoorUserStatus=" + this.e + "\n\t indoorLocName='" + this.f + "'\n\t indoorLocType=" + this.g + "\n\t saveParkBitMap=" + this.h + "\n\t photoPicPath='" + this.i + "'\n\t saveParkTimeStr='" + this.j + "'\n\t saveParkLng=" + this.k + "\n\t saveParkLat=" + this.l + "\n\t saveParkLngBd09Mc=" + this.m + "\n\t saveParkLatBd09Mc=" + this.n + "\n\t saveParkFloor='" + this.o + "'\n\t saveParkBuildingId='" + this.p + "'}";
    }

    public static a c(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f7375a = jSONObject.optString(LocationConst.PoiDataConst.KEY_INDOOR_PARKING_LOT_UID, "");
            aVar.b = jSONObject.optString(LocationConst.PoiDataConst.KEY_INDOOR_PARK_UID, "");
            aVar.c = jSONObject.optString(LocationConst.PoiDataConst.KEY_INDOOR_AREA, "");
            aVar.d = jSONObject.optString(LocationConst.PoiDataConst.KEY_INDOOR_PARKING_LOT_NUM, "");
            aVar.f = jSONObject.optString(LocationConst.PoiDataConst.KEY_INDOOR_LOC_NAME, "");
            aVar.e = jSONObject.optInt(LocationConst.PoiDataConst.KEY_INDOOR_USER_STATUS, 0);
            aVar.g = jSONObject.optInt(LocationConst.PoiDataConst.KEY_INDOOR_LOC_TYPE, 0);
            aVar.o = jSONObject.optString("floor", "");
            aVar.p = jSONObject.optString("building_id", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LocationManager.LocData curLocation = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09LL);
        LocationManager.LocData curLocation2 = LocationManager.getInstance().getCurLocation((LocationChangeListener.CoordType) null);
        aVar.l = curLocation.latitude;
        aVar.k = curLocation.longitude;
        aVar.n = curLocation2.latitude;
        aVar.m = curLocation2.longitude;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRouteSaveParkData", "parseSaveParkData: saveParkData = " + aVar);
        }
        return aVar;
    }

    public void a(Bitmap bitmap) {
        this.h = bitmap;
    }

    public void b(String str) {
        this.j = str;
    }

    public void a(String str) {
        this.i = str;
    }
}
