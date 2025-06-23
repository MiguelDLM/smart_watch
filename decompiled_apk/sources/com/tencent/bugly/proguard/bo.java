package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bo extends m {
    static ArrayList<bn> A;
    static Map<String, String> B;
    static Map<String, String> C;
    static Map<String, String> v;
    static bm w;
    static bl x;
    static ArrayList<bl> y;
    static ArrayList<bl> z;

    /* renamed from: a, reason: collision with root package name */
    public String f26600a = "";
    public long b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public Map<String, String> h = null;
    public String i = "";
    public bm j = null;
    public int k = 0;
    public String l = "";
    public String m = "";
    public bl n = null;
    public ArrayList<bl> o = null;
    public ArrayList<bl> p = null;
    public ArrayList<bn> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    public String t = "";
    public boolean u = true;

    static {
        HashMap hashMap = new HashMap();
        v = hashMap;
        hashMap.put("", "");
        w = new bm();
        x = new bl();
        y = new ArrayList<>();
        y.add(new bl());
        z = new ArrayList<>();
        z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26600a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        String str = this.d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.k, 10);
        String str6 = this.l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26600a = kVar.b(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.b(2, true);
        this.d = kVar.b(3, false);
        this.e = kVar.b(4, false);
        this.f = kVar.b(5, false);
        this.g = kVar.b(6, false);
        this.h = (Map) kVar.a((k) v, 7, false);
        this.i = kVar.b(8, false);
        this.j = (bm) kVar.a((m) w, 9, false);
        this.k = kVar.a(this.k, 10, false);
        this.l = kVar.b(11, false);
        this.m = kVar.b(12, false);
        this.n = (bl) kVar.a((m) x, 13, false);
        this.o = (ArrayList) kVar.a((k) y, 14, false);
        this.p = (ArrayList) kVar.a((k) z, 15, false);
        this.q = (ArrayList) kVar.a((k) A, 16, false);
        this.r = (Map) kVar.a((k) B, 17, false);
        this.s = (Map) kVar.a((k) C, 18, false);
        this.t = kVar.b(19, false);
        this.u = kVar.a(20, false);
    }
}
