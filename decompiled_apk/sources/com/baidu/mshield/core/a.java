package com.baidu.mshield.core;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.x0.EngineImpl;
import java.util.HashMap;
import java.util.Timer;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f6374a = new HashMap<>();
    public static volatile boolean b;

    public static void a(Context context) {
        try {
            com.baidu.mshield.b.c.a.b("canRunPlugin=" + c(context));
            if (c(context)) {
                b(context);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void b(Context context) {
        com.baidu.mshield.c cVar = new com.baidu.mshield.c(context);
        cVar.a("4.2.2", cVar.a("4.2.2") + 1);
        EngineImpl.getInstance(context).init(0, true);
        new Timer().schedule(new b(cVar), 30000L);
    }

    public static boolean c(Context context) {
        try {
            com.baidu.mshield.c cVar = new com.baidu.mshield.c(context);
            if (!cVar.a()) {
                return false;
            }
            if (cVar.a("4.2.2") >= cVar.b()) {
                EngineImpl.getInstance(context).sendWMCrashLog(5);
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return true;
        }
    }

    public static String d(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            String s = a2.s();
            if (!TextUtils.isEmpty(s)) {
                return s;
            }
            String t = a2.t();
            if (!TextUtils.isEmpty(t)) {
                return t;
            }
            String a3 = com.baidu.mshield.utility.c.a(context);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split("\\|");
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    byte[] re = F.getInstance().re(split[1].getBytes(), split[0].getBytes());
                    if (re != null) {
                        String str = split[0] + com.baidu.mshield.utility.a.a(re);
                        a2.i(str);
                        return str;
                    }
                    return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                }
                return a3;
            }
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
    }

    public static void a(Context context, String str, String str2, HashMap<String, String> hashMap, int... iArr) {
        try {
            d(context);
            com.baidu.mshield.utility.c.a(context);
            g.a(hashMap);
            EngineImpl.getInstance(context).setSecurityVerifyInfo(str, str2, hashMap);
            EngineImpl.getInstance(context).gpol();
            a(context);
            if (hashMap != null) {
                HashMap<String, String> hashMap2 = f6374a;
                synchronized (hashMap2) {
                    hashMap2.putAll(hashMap);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void b(boolean z) {
        try {
            com.baidu.sec.privacy.a.b.a(z);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static String a(Context context, String str, int i, String str2) {
        if (i != 0) {
            try {
                if (c(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        EngineImpl.getInstance(context).ice(str, i);
                    } else {
                        EngineImpl.getInstance(context).ice(str, i, str2);
                    }
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return d(context);
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            try {
                if (hashMap.size() == 0) {
                    return;
                }
                synchronized (f6374a) {
                    try {
                        for (String str : hashMap.keySet()) {
                            f6374a.put(str, hashMap.get(str));
                        }
                        g.b(hashMap);
                        EngineImpl.getInstance(context).ud(hashMap);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                com.baidu.mshield.utility.a.a(th2);
            }
        }
    }

    public static String a(String str) {
        try {
            HashMap<String, String> hashMap = f6374a;
            if (hashMap.size() <= 0) {
                return "";
            }
            synchronized (hashMap) {
                try {
                    if (!hashMap.containsKey(str)) {
                        return "";
                    }
                    return hashMap.get(str);
                } finally {
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }
}
