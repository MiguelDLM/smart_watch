package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cv {

    /* renamed from: a, reason: collision with root package name */
    public static String f18367a = "appkey";
    public static String b = "secretkey";
    public static String c = "pver";
    public static String d = "sdkver";
    public static String e = "ksid";
    public static String f = "timestamp";
    public static String g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.6");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.f18411a, bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String b2 = h.a(context, "re_po_rt").b(df.i, bq.e);
                if (TextUtils.isEmpty(b2)) {
                    b2 = bq.e;
                }
                jSONObject.put("pver", b2);
            } catch (Exception unused) {
                jSONObject.put("pver", bq.e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bq.g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.6");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f);
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f18367a, str);
            hashMap.put(b, str2);
            hashMap.put(f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map d2 = d(context);
        if (d2 == null || d2.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d2.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f18367a));
            sb.append(map.get(b));
            sb.append(map.get(f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(t.f18411a, bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(df.g, bq.e));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bq.g);
        } catch (Exception unused) {
        }
    }
}
