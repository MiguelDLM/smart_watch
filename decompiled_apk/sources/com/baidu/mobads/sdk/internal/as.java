package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class as extends RouteInfo {

    /* renamed from: a, reason: collision with root package name */
    private w f6233a;

    public as(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(x.au + getPath()).getDeclaredMethod("getRoutesMap", null);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, null);
            if (hashMap != null && hashMap.size() > 0 && (routeInfo = (RouteInfo) hashMap.get(getPath())) != null) {
                this.f6233a = (w) routeInfo.getDestination().getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.f6233a;
    }
}
