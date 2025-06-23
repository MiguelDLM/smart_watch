package com.baidu.navisdk.ui.routeguide.brule;

import com.baidu.navisdk.behavrules.c;
import com.baidu.navisdk.module.asr.e;
import com.baidu.navisdk.module.brule.business.b;
import com.baidu.navisdk.ui.routeguide.brule.matchpage.d;

/* loaded from: classes8.dex */
public class a {
    private static a b;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.brule.event.a f8507a = new com.baidu.navisdk.ui.routeguide.brule.event.a();

    /* renamed from: com.baidu.navisdk.ui.routeguide.brule.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0429a implements b.InterfaceC0227b {
        public C0429a(a aVar) {
        }
    }

    public static a d() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            r5 = this;
            com.baidu.navisdk.framework.a r0 = com.baidu.navisdk.framework.a.c()
            android.content.Context r0 = r0.a()
            com.baidu.navisdk.behavrules.sp.b r0 = com.baidu.navisdk.behavrules.sp.b.a(r0)
            r0.b()
            com.baidu.navisdk.module.brule.a r0 = com.baidu.navisdk.module.brule.a.l()
            long r1 = java.lang.System.currentTimeMillis()
            r0.a(r1)
            com.baidu.navisdk.module.brule.business.util.a r0 = com.baidu.navisdk.module.brule.business.util.a.c()
            r0.a()
            com.baidu.navisdk.comapi.routeplan.BNRoutePlaner r0 = com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.getInstance()
            com.baidu.navisdk.ui.routeguide.brule.event.a r1 = r5.f8507a
            r2 = 1
            r0.a(r1, r2)
            com.baidu.navisdk.ui.routeguide.brule.event.a r0 = r5.f8507a
            com.baidu.navisdk.model.datastruct.RoutePlanNode r0 = r0.a()
            if (r0 != 0) goto L38
            com.baidu.navisdk.ui.routeguide.brule.event.a r0 = r5.f8507a
            r0.b()
        L38:
            com.baidu.navisdk.module.brule.a r0 = com.baidu.navisdk.module.brule.a.l()
            r0.h()
            com.baidu.navisdk.behavrules.c r0 = com.baidu.navisdk.behavrules.c.c()
            r1 = 0
            r0.a(r1)
            com.baidu.navisdk.behavrules.c r0 = com.baidu.navisdk.behavrules.c.c()
            r3 = 2
            r0.a(r3)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.baidu.navisdk.module.brule.a r3 = com.baidu.navisdk.module.brule.a.l()
            int r3 = r3.d()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "comefrom"
            r0.putString(r4, r3)
            com.baidu.navisdk.module.asr.e r3 = com.baidu.navisdk.module.asr.e.INSTANCE
            java.lang.String r4 = "inNavi"
            r3.a(r4, r0)
            com.baidu.navisdk.asr.d r0 = com.baidu.navisdk.asr.d.B()
            java.lang.String r0 = r0.g()
            java.lang.String r3 = ""
            if (r0 == 0) goto L84
            java.lang.String r4 = "%"
            java.lang.String[] r0 = r0.split(r4)
            int r4 = r0.length
            if (r4 < r2) goto L84
            r0 = r0[r1]
            goto L85
        L84:
            r0 = r3
        L85:
            com.baidu.navisdk.util.statistic.userop.b r1 = com.baidu.navisdk.util.statistic.userop.b.r()
            java.lang.String r2 = "3.1.3"
            r1.a(r2, r0, r3, r3)
            com.baidu.navisdk.behavrules.c r0 = com.baidu.navisdk.behavrules.c.c()
            java.util.List r0 = r0.a()
            if (r0 == 0) goto Lb0
            java.util.Iterator r0 = r0.iterator()
        L9c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb0
            java.lang.Object r1 = r0.next()
            com.baidu.navisdk.behavrules.scene.b r1 = (com.baidu.navisdk.behavrules.scene.b) r1
            com.baidu.navisdk.behavrules.a r1 = r1.a()
            r5.a(r1)
            goto L9c
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.brule.a.a():void");
    }

    public void b() {
        com.baidu.navisdk.module.brule.a.l().k();
        com.baidu.navisdk.module.brule.business.util.a.c().b();
        c.c().a(Integer.MIN_VALUE);
        e.INSTANCE.a("outNavi", null);
    }

    public void c() {
        com.baidu.navisdk.behavrules.a a2 = com.baidu.navisdk.module.brule.b.a();
        a(a2);
        b.b().a(new C0429a(this));
        b.b().a(a2);
    }

    private void a(com.baidu.navisdk.behavrules.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.matchpage.b());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.matchpage.a());
        aVar.a(new d());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.matchpage.c());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.data.a());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.data.b());
        aVar.a(new com.baidu.navisdk.asr.sceneguide.b());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.action.b());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.action.c());
        aVar.a(new com.baidu.navisdk.ui.routeguide.brule.action.a());
    }
}
