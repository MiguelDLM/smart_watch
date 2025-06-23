package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class ek {
    private static final byte[] I = new byte[0];
    private static ek V;
    private final Map<String, Class<? extends ad>> B;
    private final Map<String, ad> Z = new HashMap();

    private ek() {
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        hashMap.put(aj.V, en.class);
        hashMap.put(aj.F, eh.class);
        hashMap.put(aj.J, ei.class);
    }

    public ad Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ad adVar = this.Z.get(str);
            if (adVar == null) {
                fb.Code("JsbNativeManger", "create command %s", str);
                Class<? extends ad> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        adVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fb.I("JsbNativeManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fb.I("JsbNativeManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
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
        fb.I("JsbNativeManger", sb2);
        return null;
    }

    public static ek Code() {
        ek ekVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new ek();
                }
                ekVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ekVar;
    }
}
