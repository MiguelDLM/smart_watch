package com.baidu.platform.domain;

import com.baidu.mapapi.http.HttpClient;

/* loaded from: classes8.dex */
public class d {
    public static c a() {
        if (HttpClient.isHttpsEnable) {
            return new b();
        }
        return new a();
    }
}
