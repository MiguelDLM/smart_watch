package com.baidu.navisdk;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.statistic.LightNaviStatItem;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;

/* loaded from: classes7.dex */
public class s extends n.b {
    private static s b;

    private s() {
    }

    public static void c() {
        if (b == null) {
            synchronized (s.class) {
                try {
                    if (b == null) {
                        b = new s();
                    }
                    com.baidu.navisdk.util.common.n.d().a(b);
                } finally {
                }
            }
        }
    }

    @Override // com.baidu.navisdk.util.common.n.b
    public void a() {
        a(100);
        a(101);
        a(200);
        a(201);
        a(30);
        a(31);
        a(250);
        a(203);
        a(202);
    }

    @Override // com.baidu.navisdk.util.common.n.b
    public String b() {
        return "RouteGuideAsyncEventManager";
    }

    @Override // com.baidu.navisdk.util.common.n.b
    public void a(Message message) {
        int i = message.what;
        if (i == 30) {
            com.baidu.navisdk.util.statistic.c.d().c();
            return;
        }
        if (i == 31) {
            com.baidu.navisdk.util.statistic.c.d().a();
            return;
        }
        if (i == 100) {
            ProNaviStatItem.O().K();
            com.baidu.navisdk.module.abtest.model.k.x().d(com.baidu.navisdk.module.vehiclemanager.b.i().b());
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            if (fVar != null) {
                com.baidu.navisdk.module.abtest.model.k.x().a(fVar.g());
            }
            Bundle B = com.baidu.navisdk.framework.b.B();
            if (B != null) {
                ProNaviStatItem.O().b(B.getString("hp_mode", null));
                return;
            }
            return;
        }
        if (i == 101) {
            com.baidu.navisdk.util.statistic.m.d().a(com.baidu.navisdk.framework.a.c().a());
            com.baidu.navisdk.util.statistic.e.n().b(1);
            com.baidu.navisdk.module.abtest.model.k.x().b(1);
            com.baidu.navisdk.module.abtest.model.i.w().b(1);
            return;
        }
        if (i != 250) {
            switch (i) {
                case 200:
                    LightNaviStatItem.s().p();
                    Bundle B2 = com.baidu.navisdk.framework.b.B();
                    if (B2 != null) {
                        LightNaviStatItem.s().b(B2.getString("hp_mode", null));
                        return;
                    }
                    return;
                case 201:
                    LightNaviStatItem.s().k();
                    return;
                case 202:
                    com.baidu.navisdk.util.statistic.b.o().n();
                    return;
                case 203:
                    com.baidu.navisdk.util.statistic.b.o().k();
                    return;
                default:
                    return;
            }
        }
        ProNaviStatItem.O().k();
    }
}
