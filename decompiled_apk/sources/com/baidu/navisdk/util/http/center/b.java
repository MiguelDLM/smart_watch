package com.baidu.navisdk.util.http.center;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class b implements j {
    public static final String b = "b";
    private static b c;
    private static final Object d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private j f9299a = null;

    private b() {
    }

    public static void a(j jVar) {
        if (c == null) {
            synchronized (d) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        if (jVar != null) {
            c.b(jVar);
            LogUtil.e(b, "use the outer http cetner.");
        } else {
            c.b(h.a());
            LogUtil.e(b, "use the inner http cetner.");
        }
    }

    private void b(j jVar) {
        if (jVar == null) {
            LogUtil.e(b, "setHttpCenter() http center is null !!!");
        } else if (this.f9299a != null) {
            LogUtil.e(b, "setHttpCenter() return for cur http center is not null !!!");
        } else {
            this.f9299a = jVar;
        }
    }

    @Override // com.baidu.navisdk.util.http.center.j
    public void b(String str, HashMap<String, String> hashMap, k kVar, e eVar) {
        j jVar = this.f9299a;
        if (jVar != null) {
            jVar.b(str, hashMap, kVar, eVar);
        } else {
            LogUtil.e(b, "post() the http center is null.");
        }
    }

    public static j a() {
        if (c == null) {
            synchronized (d) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    @Override // com.baidu.navisdk.util.http.center.j
    public void a(String str, HashMap<String, String> hashMap, k kVar, e eVar) {
        j jVar = this.f9299a;
        if (jVar != null) {
            jVar.a(str, hashMap, kVar, eVar);
        } else {
            LogUtil.e(b, "get() the http center is null.");
        }
    }
}
