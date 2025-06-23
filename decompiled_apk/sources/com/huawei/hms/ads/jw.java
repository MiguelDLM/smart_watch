package com.huawei.hms.ads;

import android.app.Activity;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class jw {
    private static final String Code = "ShareManager";
    private static final Map<String, jr> I = new HashMap(5);
    private static final int V = 5;
    private static final Map<String, Class<? extends jr>> Z;

    static {
        HashMap hashMap = new HashMap();
        Z = hashMap;
        hashMap.put(ju.B, js.class);
        hashMap.put(ju.V, kb.class);
        hashMap.put("QQ", jt.class);
        hashMap.put(ju.I, ka.class);
        hashMap.put(ju.Z, jz.class);
    }

    public static void Code(String str, Activity activity, jv jvVar, jx jxVar) {
        fb.Code(Code, "shareAd : %s", str);
        try {
            Map<String, jr> map = I;
            jr V2 = !map.containsKey(str) ? V(str) : map.get(str);
            if (V2 != null) {
                V2.Code(activity, jvVar, jxVar);
            }
        } catch (Throwable unused) {
            fb.I(Code, "Share throws exception");
        }
    }

    @Nullable
    private static jr V(String str) {
        Class<? extends jr> cls = Z.get(str);
        if (cls == null) {
            fb.Code(Code, "There is no matching type for %s", str);
            return null;
        }
        jr newInstance = cls.newInstance();
        I.put(str, newInstance);
        return newInstance;
    }

    public static boolean Code(String str) {
        try {
            Class<? extends jr> cls = Z.get(str);
            if (cls != null) {
                return cls.newInstance().Code();
            }
            fb.Code(Code, "There is no matching type for %s", str);
            return false;
        } catch (Throwable unused) {
            fb.I(Code, "Share throws exception");
            return false;
        }
    }
}
