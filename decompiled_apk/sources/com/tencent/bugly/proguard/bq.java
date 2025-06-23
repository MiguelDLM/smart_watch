package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bq extends m {
    static byte[] y;
    static Map<String, String> z;

    /* renamed from: a, reason: collision with root package name */
    public int f26602a = 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public int g = 0;
    public byte[] h = null;
    public String i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";

    static {
        y = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26602a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        lVar.a(this.d, 3);
        String str = this.e;
        if (str != null) {
            lVar.a(str, 4);
        }
        lVar.a(this.f, 5);
        lVar.a(this.g, 6);
        lVar.a(this.h, 7);
        String str2 = this.i;
        if (str2 != null) {
            lVar.a(str2, 8);
        }
        String str3 = this.j;
        if (str3 != null) {
            lVar.a(str3, 9);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            lVar.a((Map) map, 10);
        }
        String str4 = this.l;
        if (str4 != null) {
            lVar.a(str4, 11);
        }
        lVar.a(this.m, 12);
        String str5 = this.n;
        if (str5 != null) {
            lVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            lVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            lVar.a(str7, 15);
        }
        lVar.a(this.q, 16);
        String str8 = this.r;
        if (str8 != null) {
            lVar.a(str8, 17);
        }
        String str9 = this.s;
        if (str9 != null) {
            lVar.a(str9, 18);
        }
        String str10 = this.t;
        if (str10 != null) {
            lVar.a(str10, 19);
        }
        String str11 = this.u;
        if (str11 != null) {
            lVar.a(str11, 20);
        }
        String str12 = this.v;
        if (str12 != null) {
            lVar.a(str12, 21);
        }
        String str13 = this.w;
        if (str13 != null) {
            lVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            lVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26602a = kVar.a(this.f26602a, 0, true);
        this.b = kVar.b(1, true);
        this.c = kVar.b(2, true);
        this.d = kVar.b(3, true);
        this.e = kVar.b(4, false);
        this.f = kVar.b(5, true);
        this.g = kVar.a(this.g, 6, true);
        this.h = kVar.c(7, true);
        this.i = kVar.b(8, false);
        this.j = kVar.b(9, false);
        this.k = (Map) kVar.a((k) z, 10, false);
        this.l = kVar.b(11, false);
        this.m = kVar.a(this.m, 12, false);
        this.n = kVar.b(13, false);
        this.o = kVar.b(14, false);
        this.p = kVar.b(15, false);
        this.q = kVar.a(this.q, 16, false);
        this.r = kVar.b(17, false);
        this.s = kVar.b(18, false);
        this.t = kVar.b(19, false);
        this.u = kVar.b(20, false);
        this.v = kVar.b(21, false);
        this.w = kVar.b(22, false);
        this.x = kVar.b(23, false);
    }
}
