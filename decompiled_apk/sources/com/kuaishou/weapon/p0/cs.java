package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private ct f18364a = new ct();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            ct ctVar = new ct();
            int a2 = ctVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a2 > 0) {
                jSONObject.put("0", a2);
            }
            int a3 = ctVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a3 > 0) {
                jSONObject.put("1", a3);
            }
            int a4 = ctVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a4 > 0) {
                jSONObject.put("2", a4);
            }
            int a5 = ctVar.a(Location.class, "getLatitude", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("3", a5);
            }
            int a6 = ctVar.a(Location.class, "getLongitude", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("4", a6);
            }
            int a7 = ctVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("6", a7);
            }
            int a8 = ctVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("7", a8);
            }
            int a9 = ctVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("8", a9);
            }
            int a10 = ctVar.a(JSONObject.class, "toString", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("9", a10);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int a2 = this.f18364a.a();
            if (a2 <= 0) {
                return null;
            }
            int a3 = this.f18364a.a(a2, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a3 > 0) {
                jSONObject.put("0", a3);
            }
            int a4 = this.f18364a.a(a2, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a4 > 0) {
                jSONObject.put("1", a4);
            }
            int a5 = this.f18364a.a(a2, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("2", a5);
            }
            int a6 = this.f18364a.a(a2, Location.class, "getLatitude", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("3", a6);
            }
            int a7 = this.f18364a.a(a2, Location.class, "getLongitude", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("4", a7);
            }
            int a8 = this.f18364a.a(a2, WifiInfo.class, "getMacAddress", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("6", a8);
            }
            int a9 = this.f18364a.a(a2, WifiInfo.class, "getBSSID", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("7", a9);
            }
            int a10 = this.f18364a.a(a2, WifiInfo.class, "getRssi", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("8", a10);
            }
            int a11 = this.f18364a.a(a2, JSONObject.class, "toString", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("9", a11);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
