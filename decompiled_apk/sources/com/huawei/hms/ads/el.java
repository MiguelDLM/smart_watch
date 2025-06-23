package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class el {
    private static final byte[] I = new byte[0];
    private static el V;
    private final Map<String, Class<? extends ad>> B;
    private final Map<String, ad> Z = new HashMap();

    private el() {
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        hashMap.put(aj.B, eo.class);
    }

    public ad Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ad adVar = this.Z.get(str);
            if (adVar == null) {
                fb.Code("JsbPlacementManger", "create command " + str);
                Class<? extends ad> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        adVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fb.I("JsbPlacementManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fb.I("JsbPlacementManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (adVar == null) {
                        sb = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, adVar);
                    }
                }
                sb.append(str2);
                sb.append(str);
                sb2 = sb.toString();
            }
            return adVar;
        }
        sb2 = "get cmd, method is empty";
        fb.I("JsbPlacementManger", sb2);
        return null;
    }

    public static el Code() {
        el elVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new el();
                }
                elVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return elVar;
    }
}
