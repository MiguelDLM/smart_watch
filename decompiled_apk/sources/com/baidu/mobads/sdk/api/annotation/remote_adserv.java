package com.baidu.mobads.sdk.api.annotation;

import com.baidu.mobads.sdk.api.AdservRemoteLoaderImpl;
import com.baidu.mobads.sdk.api.RouteInfo;
import com.baidu.mobads.sdk.internal.c;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class remote_adserv {
    public static HashMap<String, RouteInfo> getRoutesMap() {
        HashMap<String, RouteInfo> hashMap = new HashMap<>();
        hashMap.put(c.a.f6266a, RouteInfo.build(AdservRemoteLoaderImpl.class, c.a.f6266a));
        return hashMap;
    }
}
