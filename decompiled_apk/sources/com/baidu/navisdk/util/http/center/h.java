package com.baidu.navisdk.util.http.center;

import java.util.HashMap;

/* loaded from: classes8.dex */
public class h implements j {

    /* renamed from: a, reason: collision with root package name */
    private static j f9301a;
    private static final Object b = new Object();

    private h() {
    }

    public static j a() {
        if (f9301a == null) {
            synchronized (b) {
                try {
                    if (f9301a == null) {
                        f9301a = new h();
                    }
                } finally {
                }
            }
        }
        return f9301a;
    }

    @Override // com.baidu.navisdk.util.http.center.j
    public void b(String str, HashMap<String, String> hashMap, k kVar, e eVar) {
        if (eVar == null) {
            new e();
        }
    }

    @Override // com.baidu.navisdk.util.http.center.j
    public void a(String str, HashMap<String, String> hashMap, k kVar, e eVar) {
        if (eVar == null) {
            new e();
        }
    }
}
