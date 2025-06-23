package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bt extends m implements Cloneable {
    static bs m = new bs();
    static Map<String, String> n = null;
    static final /* synthetic */ boolean o = true;

    /* renamed from: a, reason: collision with root package name */
    public boolean f26605a = true;
    public boolean b = true;
    public boolean c = true;
    public String d = "";
    public String e = "";
    public bs f = null;
    public Map<String, String> g = null;
    public long h = 0;
    public String i = "";
    public String j = "";
    public int k = 0;
    public int l = 0;

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26605a, 0);
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
        bs bsVar = this.f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.h, 7);
        String str3 = this.i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.k, 10);
        lVar.a(this.l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        if (!n.a(this.f26605a, btVar.f26605a) || !n.a(this.b, btVar.b) || !n.a(this.c, btVar.c) || !n.a(this.d, btVar.d) || !n.a(this.e, btVar.e) || !n.a(this.f, btVar.f) || !n.a(this.g, btVar.g) || !n.a(this.h, btVar.h) || !n.a(this.i, btVar.i) || !n.a(this.j, btVar.j) || !n.a(this.k, btVar.k) || !n.a(this.l, btVar.l)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26605a = kVar.a(0, true);
        this.b = kVar.a(1, true);
        this.c = kVar.a(2, true);
        this.d = kVar.b(3, false);
        this.e = kVar.b(4, false);
        this.f = (bs) kVar.a((m) m, 5, false);
        this.g = (Map) kVar.a((k) n, 6, false);
        this.h = kVar.a(this.h, 7, false);
        this.i = kVar.b(8, false);
        this.j = kVar.b(9, false);
        this.k = kVar.a(this.k, 10, false);
        this.l = kVar.a(this.l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
        i iVar = new i(sb, i);
        iVar.a(this.f26605a, "enable");
        iVar.a(this.b, "enableUserInfo");
        iVar.a(this.c, "enableQuery");
        iVar.a(this.d, "url");
        iVar.a(this.e, "expUrl");
        iVar.a((m) this.f, "security");
        iVar.a((Map) this.g, "valueMap");
        iVar.a(this.h, "strategylastUpdateTime");
        iVar.a(this.i, "httpsUrl");
        iVar.a(this.j, "httpsExpUrl");
        iVar.a(this.k, "eventRecordCount");
        iVar.a(this.l, "eventTimeInterval");
    }
}
