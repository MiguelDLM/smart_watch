package com.baidu.navisdk.model.datastruct;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public String f6945a;
    public String b;
    public int c;
    public long d;
    public long e;
    public int f;
    public String g;
    public String i;
    public String j;
    public String k;
    public int h = -1;
    public int l = 0;

    private w() {
    }

    public static w a(String str) {
        w wVar = new w();
        wVar.f6945a = str;
        return wVar;
    }

    public Bundle b() {
        if (!a()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("pass_id", this.f6945a);
        bundle.putInt("pass_rule_flag", this.l);
        long j = this.d;
        if (j != 0 && this.e != 0) {
            bundle.putLong("register_date", j);
            bundle.putLong("expire_date", this.e);
        }
        int i = this.h;
        if (i != -1) {
            bundle.putInt("city_id", i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundle.putString("info_ids", this.j);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("pass_title", this.g);
        }
        return bundle;
    }

    public String toString() {
        return "VehiclePassportInfo{id='" + this.f6945a + "', plate='" + this.b + "', vehicleType=" + this.c + ", registerDate=" + this.d + ", expireDate=" + this.e + ", status=" + this.f + ", passportTitle='" + this.g + "', cityId=" + this.h + ", cityName='" + this.i + "', infoIds='" + this.j + "', limitRule='" + this.k + "'}";
    }

    public static w a(String str, JSONArray jSONArray) {
        ArrayList<w> a2 = a(jSONArray);
        for (int i = 0; i < a2.size(); i++) {
            if (a2.get(i).f6945a.equals(str)) {
                return a2.get(i);
            }
        }
        return new w();
    }

    public static ArrayList<w> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList<>();
        }
        ArrayList<w> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static w a(JSONObject jSONObject) {
        w wVar = new w();
        if (jSONObject != null) {
            wVar.f6945a = jSONObject.optString("pass_id", "");
            wVar.b = jSONObject.optString("plate", "");
            wVar.c = jSONObject.optInt("vehicle_type", 1);
            wVar.d = jSONObject.optLong("register_date", 0L);
            wVar.e = jSONObject.optLong("expire_date", 0L);
            wVar.f = jSONObject.optInt("status", 0);
            wVar.g = jSONObject.optString("pass_title", "");
            wVar.h = jSONObject.optInt("city_id", -1);
            wVar.i = jSONObject.optString("city_name", "");
            wVar.j = jSONObject.optString("info_ids", "");
            wVar.k = jSONObject.optString("limit_rule", "");
        }
        return wVar;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6945a);
    }
}
