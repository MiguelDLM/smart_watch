package com.baidu.navisdk.asr.sceneguide;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class c {
    private static c b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f6563a = new HashMap<>();

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public void a(String str, a aVar) {
        this.f6563a.put(str, aVar);
    }

    public a a(String str) {
        return this.f6563a.get(str);
    }
}
