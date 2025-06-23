package com.baidu.navisdk.module.trucknavi.logic.plate;

import XIXIX.OOXIXo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.module.routepreference.b implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7582a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public String j;
    public int k;
    public float l;
    private float m;
    private float n;
    private int o;
    public int p;
    public String q;
    public String r;
    public int s;

    /* loaded from: classes7.dex */
    public class a implements Parcelable.Creator<d> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d() {
        this.f7582a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = "0";
        this.k = 0;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = "0";
        this.r = "";
        this.s = -1;
    }

    public void a(int i) {
        this.o = i;
    }

    public float b() {
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("TruckPlateModel", "getTempTall --> tempWeight = " + this.n + ", weight = " + this.e);
        }
        float f = this.n;
        if (f <= 0.0f) {
            return this.e;
        }
        return f;
    }

    public int c() {
        return this.o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (getPlate() == null ? dVar.getPlate() != null : !getPlate().equals(dVar.getPlate())) {
            return false;
        }
        if (this.d == dVar.d && this.f7582a == dVar.f7582a && this.h == dVar.h && this.g == dVar.g && this.f == dVar.f && this.e == dVar.e && this.l == dVar.l && this.j.equals(dVar.j) && this.i == dVar.i && this.k == dVar.k && this.c == dVar.c && this.p == dVar.p && this.s == dVar.s && this.q.equals(dVar.q) && !isPassportChanged(this.r, dVar.r) && this.b == dVar.b) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public Bundle[] getPassportIds() {
        return parsePassportIds(this.r);
    }

    public String getVehicleInfoJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VehicleConstant.PlateBundleKey.PLATE, getPlate());
            jSONObject.put(VehicleConstant.PlateBundleKey.PLATE_COLOR, this.d);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_TYPE, this.f7582a);
            jSONObject.put(VehicleConstant.PlateBundleKey.AXLE_NUMBER, this.k);
            jSONObject.put(VehicleConstant.PlateBundleKey.AXLE_WEIGHT, this.i);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_TALL, this.h);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_WIDTH, this.g);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_HEIGHT, this.f);
            jSONObject.put(VehicleConstant.PlateBundleKey.TOTAL_WEIGHT, this.e);
            jSONObject.put(VehicleConstant.PlateBundleKey.LOAD_WEIGHT, this.l);
            jSONObject.put(VehicleConstant.PlateBundleKey.OIL_COST, this.j);
            jSONObject.put(VehicleConstant.PlateBundleKey.POWER_TYPE, this.c);
            jSONObject.put(VehicleConstant.PlateBundleKey.EMIS_LIMIT, this.b);
            jSONObject.put("isTrailer", this.p);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_EXT, this.q);
            jSONObject.put("pass_ids", this.r);
            jSONObject.put("isEtc", this.s);
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("TruckPlateModel", e);
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public int hashCode() {
        int i;
        if (getPlate() != null) {
            i = getPlate().hashCode();
        } else {
            i = 0;
        }
        return (((i * 31) + this.d) * 31) + this.f7582a;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public String toString() {
        return "TruckPlateModel{plate='" + getPlate() + ", plateType=" + this.d + ", truckType=" + this.f7582a + ", axlesNumber=" + this.k + ", loadWeight=" + this.l + ", weight=" + this.e + ", height=" + this.f + ", width=" + this.g + ", tall=" + this.h + ", tempTall=" + this.m + ", axlesWeight=" + this.i + ", oilCost=" + this.j + ", emisLimit=" + this.b + ", powerType=" + this.c + ", isEtc=" + this.s + ", trunkExt=" + this.q + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7582a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeInt(this.s);
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        setPlateInfo(dVar.getPlate());
        this.b = dVar.b;
        this.d = dVar.d;
        this.f7582a = dVar.f7582a;
        this.k = dVar.k;
        this.h = dVar.h;
        this.g = dVar.g;
        this.e = dVar.e;
        this.f = dVar.f;
        this.l = dVar.l;
        this.i = dVar.i;
        this.j = dVar.j;
        this.c = dVar.c;
        this.p = dVar.p;
        this.q = dVar.q;
        this.r = dVar.r;
        this.s = dVar.s;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckPlateModel", "copy: " + this);
        }
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public d m96clone() {
        return new d(this);
    }

    public d(Bundle bundle) {
        this.f7582a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = "0";
        this.k = 0;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = "0";
        this.r = "";
        this.s = -1;
        a(bundle);
    }

    public void a(Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckPlateModel", "parseBundle: " + bundle);
        }
        if (bundle == null || !bundle.containsKey(VehicleConstant.PlateBundleKey.PLATE)) {
            return;
        }
        setPlateInfo(bundle.getString(VehicleConstant.PlateBundleKey.PLATE, ""));
        this.d = bundle.getInt(VehicleConstant.PlateBundleKey.PLATE_COLOR, 0);
        this.f7582a = bundle.getInt(VehicleConstant.PlateBundleKey.TRUCK_TYPE, 0);
        this.k = bundle.getInt(VehicleConstant.PlateBundleKey.AXLE_NUMBER, 0);
        this.i = bundle.getFloat(VehicleConstant.PlateBundleKey.AXLE_WEIGHT, 0.0f);
        this.h = bundle.getFloat(VehicleConstant.PlateBundleKey.TRUCK_TALL, 0.0f);
        this.g = bundle.getFloat(VehicleConstant.PlateBundleKey.TRUCK_WIDTH, 0.0f);
        this.f = bundle.getFloat(VehicleConstant.PlateBundleKey.TRUCK_HEIGHT, 0.0f);
        this.e = bundle.getFloat(VehicleConstant.PlateBundleKey.TOTAL_WEIGHT, 0.0f);
        this.l = bundle.getFloat(VehicleConstant.PlateBundleKey.LOAD_WEIGHT, 0.0f);
        this.j = bundle.getInt(VehicleConstant.PlateBundleKey.OIL_COST, 0) + "";
        this.c = bundle.getInt(VehicleConstant.PlateBundleKey.POWER_TYPE, 0);
        this.b = bundle.getInt(VehicleConstant.PlateBundleKey.EMIS_LIMIT, 0);
        this.p = bundle.getInt("isTrailer", 0);
        this.q = bundle.getString(VehicleConstant.PlateBundleKey.TRUCK_EXT, "0");
        this.r = bundle.getString("pass_ids", "");
        this.s = bundle.getInt("isEtc", -1);
    }

    public d(d dVar) {
        this.f7582a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = "0";
        this.k = 0;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = "0";
        this.r = "";
        this.s = -1;
        if (dVar == null) {
            return;
        }
        setPlateInfo(dVar.getPlate());
        this.d = dVar.d;
        this.f7582a = dVar.f7582a;
        this.k = dVar.k;
        this.h = dVar.h;
        this.g = dVar.g;
        this.e = dVar.e;
        this.f = dVar.f;
        this.l = dVar.l;
        this.b = dVar.b;
        this.i = dVar.i;
        this.j = dVar.j;
        this.c = dVar.c;
        this.p = dVar.p;
        this.q = dVar.q;
        this.r = dVar.r;
        this.s = dVar.s;
    }

    public float a() {
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("TruckPlateModel", "getTempTall --> tempTall = " + this.m + ", tall = " + this.h);
        }
        float f = this.m;
        return f <= 0.0f ? this.h : f;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            setPlateInfo(jSONObject.optString(VehicleConstant.PlateBundleKey.PLATE, ""));
            this.d = jSONObject.optInt(VehicleConstant.PlateBundleKey.PLATE_COLOR, 0);
            this.f7582a = jSONObject.optInt(VehicleConstant.PlateBundleKey.TRUCK_TYPE, 0);
            this.k = jSONObject.optInt(VehicleConstant.PlateBundleKey.AXLE_NUMBER, 0);
            this.i = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.AXLE_WEIGHT, OOXIXo.f3760XO);
            this.h = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.TRUCK_TALL, OOXIXo.f3760XO);
            this.g = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.TRUCK_WIDTH, OOXIXo.f3760XO);
            this.f = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.TRUCK_HEIGHT, OOXIXo.f3760XO);
            this.e = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.TOTAL_WEIGHT, OOXIXo.f3760XO);
            this.l = (float) jSONObject.optDouble(VehicleConstant.PlateBundleKey.LOAD_WEIGHT, OOXIXo.f3760XO);
            this.j = jSONObject.optInt(VehicleConstant.PlateBundleKey.OIL_COST, 0) + "";
            this.c = jSONObject.optInt(VehicleConstant.PlateBundleKey.POWER_TYPE, 0);
            this.b = jSONObject.optInt(VehicleConstant.PlateBundleKey.EMIS_LIMIT, 0);
            this.p = jSONObject.optInt("isTrailer", 0);
            this.q = jSONObject.optString(VehicleConstant.PlateBundleKey.TRUCK_EXT, "0");
            this.r = jSONObject.optString("pass_ids", "");
            this.s = jSONObject.optInt("isEtc", -1);
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("TruckPlateModel", e);
                e.printStackTrace();
            }
        }
    }

    public d(Parcel parcel) {
        this.f7582a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = "0";
        this.k = 0;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = "0";
        this.r = "";
        this.s = -1;
        this.f7582a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readFloat();
        this.f = parcel.readFloat();
        this.g = parcel.readFloat();
        this.h = parcel.readFloat();
        this.i = parcel.readFloat();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readInt();
    }
}
