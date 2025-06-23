package com.baidu.navisdk.module.dynamicui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes7.dex */
public class b {
    private static b b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.baidu.navisdk.module.dynamicui.i.a> f7155a = new HashMap();

    public b() {
        new HashSet();
    }

    public static b b() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public Map<String, com.baidu.navisdk.module.dynamicui.i.a> a() {
        return this.f7155a;
    }
}
