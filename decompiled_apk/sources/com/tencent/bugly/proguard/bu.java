package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bu extends m {
    static Map<String, String> i;

    /* renamed from: a, reason: collision with root package name */
    public long f26606a = 0;
    public byte b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public Map<String, String> f = null;
    public String g = "";
    public boolean h = true;

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26606a, 0);
        lVar.a(this.b, 1);
        String str = this.c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26606a = kVar.a(this.f26606a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.b(2, false);
        this.d = kVar.b(3, false);
        this.e = kVar.b(4, false);
        this.f = (Map) kVar.a((k) i, 5, false);
        this.g = kVar.b(6, false);
        this.h = kVar.a(7, false);
    }
}
