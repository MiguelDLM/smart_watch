package com.baidu.navcore.http;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.g;
import com.baidu.platform.comjni.engine.NAEngine;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f6455a = new byte[0];
    private com.baidu.navcore.http.client.c b;
    private com.baidu.navcore.http.client.b c;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f6456a = new c();
    }

    public static c a() {
        return a.f6456a;
    }

    private void b() {
        synchronized (this.f6455a) {
            try {
                if (g.b()) {
                    if (this.c == null) {
                        this.c = new com.baidu.navcore.http.client.b();
                    }
                } else if (this.b == null) {
                    this.b = new com.baidu.navcore.http.client.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(boolean z, String str, HashMap<String, String> hashMap, com.baidu.navcore.http.handler.a aVar) {
        if (z) {
            g.a();
        }
        b();
        a(str);
        if (!g.b()) {
            this.b.a(str, new d(hashMap), aVar);
        } else {
            this.c.a(str, new d(hashMap), aVar);
        }
    }

    public void a(boolean z, String str, HashMap<String, String> hashMap, HashMap<String, File> hashMap2, com.baidu.navcore.http.handler.a aVar) {
        d dVar = new d(hashMap);
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            for (Map.Entry<String, File> entry : hashMap2.entrySet()) {
                try {
                    dVar.a(entry.getKey(), entry.getValue());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        a(z, str, dVar, aVar);
    }

    public void a(boolean z, String str, d dVar, com.baidu.navcore.http.handler.a aVar) {
        if (z) {
            g.a();
        }
        b();
        a(str);
        if (!g.b()) {
            this.b.b(str, dVar, aVar);
        } else {
            this.c.b(str, dVar, aVar);
        }
    }

    private void a(String str) {
        String ip;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavHttpManager", "getCS() u=" + str + ", s=" + com.baidu.navcore.a.d().a());
        }
        if (com.baidu.navcore.a.d().a() == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavHttpManager", "getCS() return null");
                return;
            }
            return;
        }
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        CookieStore cookieStore = cookieManager.getCookieStore();
        HttpCookie httpCookie = new HttpCookie("BDUSS", com.baidu.navcore.a.d().a());
        httpCookie.setDomain(".baidu.com");
        httpCookie.setPath("/");
        httpCookie.setVersion(0);
        cookieStore.add(null, httpCookie);
        if (str == null || str.length() <= 0 || (ip = NAEngine.getIP(URI.create(str).getHost())) == null || ip.length() <= 0) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavHttpManager", "getCS() i=" + ip);
        }
        HttpCookie httpCookie2 = new HttpCookie("BDUSS", com.baidu.navcore.a.d().a());
        httpCookie2.setDomain(ip);
        httpCookie2.setPath("/");
        httpCookie2.setVersion(0);
        cookieStore.add(null, httpCookie2);
    }
}
