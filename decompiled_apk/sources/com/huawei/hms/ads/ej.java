package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class ej {
    private static final byte[] I = new byte[0];
    private static ej V;
    private final Map<String, Class<? extends ad>> B;
    private final Map<String, ad> Z = new HashMap();

    private ej() {
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        hashMap.put(aj.Z, em.class);
        hashMap.put(aj.k, er.class);
    }

    public ad Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ad adVar = this.Z.get(str);
            if (adVar == null) {
                fb.Code("JsbInterstitialManger", "create command %s", str);
                Class<? extends ad> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        adVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fb.I("JsbInterstitialManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fb.I("JsbInterstitialManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
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
        fb.I("JsbInterstitialManger", sb2);
        return null;
    }

    public static ej Code() {
        ej ejVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new ej();
                }
                ejVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ejVar;
    }
}
