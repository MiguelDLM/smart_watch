package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bv extends m implements Cloneable {
    static ArrayList<bu> f;
    static Map<String, String> g;

    /* renamed from: a, reason: collision with root package name */
    public byte f26607a = 0;
    public String b = "";
    public String c = "";
    public ArrayList<bu> d = null;
    public Map<String, String> e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26607a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26607a = kVar.a(this.f26607a, 0, true);
        this.b = kVar.b(1, false);
        this.c = kVar.b(2, false);
        if (f == null) {
            f = new ArrayList<>();
            f.add(new bu());
        }
        this.d = (ArrayList) kVar.a((k) f, 3, false);
        if (g == null) {
            HashMap hashMap = new HashMap();
            g = hashMap;
            hashMap.put("", "");
        }
        this.e = (Map) kVar.a((k) g, 4, false);
    }
}
