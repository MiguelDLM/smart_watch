package com.baidu.navisdk.module.routepreference;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class h {
    public String e;

    /* renamed from: a, reason: collision with root package name */
    public int f7484a = 300;
    public int b = 20;
    public int c = 90;
    public ArrayList<Integer> d = new ArrayList<>();
    public int f = 0;
    public String g = "";

    public static String a(h hVar) {
        if (hVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mileage", hVar.f7484a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("start", hVar.b / 100.0f);
            jSONObject2.put("end", hVar.c / 100.0f);
            jSONObject.put("charge", jSONObject2);
            jSONObject.put("pile", new JSONArray((Collection) hVar.d));
            String str = hVar.e;
            if (str != null) {
                jSONObject.put("brand_pile", str);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static String b(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject a2 = com.baidu.navisdk.module.userclassification.f.a().a("new_eng_car_plate_info");
        if (a2 == null || (optJSONObject = a2.optJSONObject(str)) == null) {
            return null;
        }
        String optString = optJSONObject.optString("brand_pile");
        String optString2 = optJSONObject.optString("brand_std");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        if (str2 != null && TextUtils.isEmpty(str2)) {
            return "";
        }
        return optString2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f7484a != hVar.f7484a || this.b != hVar.b || this.c != hVar.c || this.f != hVar.f) {
            return false;
        }
        ArrayList<Integer> arrayList = this.d;
        if (arrayList == null ? hVar.d != null : !arrayList.equals(hVar.d)) {
            return false;
        }
        String str = this.e;
        if (str == null ? hVar.e != null : !str.equals(hVar.e)) {
            return false;
        }
        String str2 = this.g;
        if (str2 != null) {
            return str2.equals(hVar.g);
        }
        if (hVar.g == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = ((((this.f7484a * 31) + this.b) * 31) + this.c) * 31;
        ArrayList<Integer> arrayList = this.d;
        int i4 = 0;
        if (arrayList != null) {
            i = arrayList.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i3 + i) * 31;
        String str = this.e;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (((i5 + i2) * 31) + this.f) * 31;
        String str2 = this.g;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return "ChargingPrefer{mileage=" + this.f7484a + ", chargeStart=" + this.b + ", chargeEnd=" + this.c + ", pileList=" + this.d + ", brandPile='" + this.e + "', pilePrefers=" + this.f + ", pileBrandPrefers='" + this.g + "'}";
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h m95clone() {
        h hVar = new h();
        hVar.f7484a = this.f7484a;
        hVar.b = this.b;
        hVar.c = this.c;
        hVar.f = this.f;
        hVar.g = this.g;
        hVar.d.addAll(this.d);
        hVar.e = this.e;
        return hVar;
    }

    public static h a(String str, String str2) {
        h hVar = new h();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            hVar.f7484a = jSONObject.optInt("mileage", 300);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("charge"));
            String optString = jSONObject2.optString("start");
            if (!TextUtils.isEmpty(optString)) {
                hVar.b = (int) (Float.parseFloat(optString) * 100.0f);
            }
            String optString2 = jSONObject2.optString("end");
            if (!TextUtils.isEmpty(optString2)) {
                hVar.c = (int) (Float.parseFloat(optString2) * 100.0f);
            }
            String optString3 = jSONObject.optString("pile");
            hVar.e = b(str, jSONObject.has("brand_pile") ? jSONObject.optString("brand_pile", "") : null);
            JSONArray jSONArray = new JSONArray(optString3);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    Integer num = (Integer) jSONArray.opt(i);
                    int intValue = num.intValue();
                    hVar.d.add(num);
                    if (intValue == 5) {
                        hVar.g = "国家电网";
                    } else {
                        hVar.f += 1 << intValue;
                    }
                }
            }
            if (TextUtils.isEmpty(hVar.g)) {
                if (!TextUtils.isEmpty(hVar.e)) {
                    hVar.g = hVar.e;
                }
            } else if (!TextUtils.isEmpty(hVar.e)) {
                hVar.g += "|" + hVar.e;
            }
        } catch (JSONException unused) {
        }
        return hVar;
    }
}
