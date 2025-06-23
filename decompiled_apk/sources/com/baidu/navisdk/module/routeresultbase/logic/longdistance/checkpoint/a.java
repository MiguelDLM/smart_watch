package com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint;

import com.baidu.nplatform.comapi.basestruct.c;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.routeresultbase.logic.longdistance.a {

    /* renamed from: a, reason: collision with root package name */
    public String f7512a = null;
    public int b = 0;
    public int c = 0;
    public c d = null;
    public boolean e = true;

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.a aVar) {
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            this.f7512a = aVar2.f7512a;
            this.b = aVar2.b;
            this.c = aVar2.c;
            if (aVar2.d != null) {
                this.d = new c(r0.c(), aVar2.d.d());
            }
        }
    }

    public String toString() {
        return String.format("%s,%d,%d,%b", this.f7512a, Integer.valueOf(this.b), Integer.valueOf(this.c), Boolean.valueOf(this.e));
    }
}
