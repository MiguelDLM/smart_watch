package com.baidu.mshield.x6.b;

import android.os.Build;
import android.view.InputDevice;
import com.baidu.mshield.x6.e.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {
    public static boolean a() {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            f.a(th);
            return false;
        }
    }

    public static String b() {
        int i;
        try {
            int[] deviceIds = InputDevice.getDeviceIds();
            JSONArray jSONArray = new JSONArray();
            for (int i2 : deviceIds) {
                InputDevice device = InputDevice.getDevice(i2);
                if (device != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", device.getName());
                    jSONObject.put("1", device.isVirtual() ? 1 : 0);
                    jSONObject.put("2", device.getVendorId());
                    jSONObject.put("3", device.getSources());
                    String inputDevice = device.toString();
                    if (inputDevice.indexOf("Location: built-in") > 0) {
                        i = 1;
                    } else if (inputDevice.indexOf("Location: external") > 0) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("4", i);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString().replace("   ", "");
        } catch (Exception e) {
            f.a(e);
            return "";
        }
    }
}
