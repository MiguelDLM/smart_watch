package com.baidu.navisdk.module.pronavi.model;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public c f7462a;
    public int b;
    public String c;
    public String d;

    public b(c cVar) {
        c cVar2 = new c();
        this.f7462a = cVar2;
        cVar2.a(cVar);
    }

    public boolean a() {
        if (this.b >= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "BNRoadConditionAvoidJamModel{jamModel=" + this.f7462a + ", auxRouteIdx=" + this.b + ", panelTitle='" + this.c + "', panelSubContent='" + this.d + "'}";
    }
}
