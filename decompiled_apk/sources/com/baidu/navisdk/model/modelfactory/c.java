package com.baidu.navisdk.model.modelfactory;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f6949a = new HashMap();
    private static volatile c b = null;

    public c() {
        f6949a.clear();
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    private void c(String str) {
        f6949a.put(str, d(str));
    }

    private a d(String str) {
        if ("OfflineDataModel".equals(str)) {
            return new d();
        }
        if ("PoiSearchModel".equals(str)) {
            return new e();
        }
        if ("RoutePlanModel".equals(str)) {
            return new f();
        }
        return null;
    }

    public void b(String str) {
        Map<String, a> map = f6949a;
        if (map != null && map.get(str) != null) {
            f6949a.remove(str);
        }
    }

    public a a(String str) {
        if (f6949a == null) {
            f6949a = new HashMap();
        }
        a aVar = f6949a.get(str);
        if (aVar != null) {
            return aVar;
        }
        c(str);
        return f6949a.get(str);
    }
}
