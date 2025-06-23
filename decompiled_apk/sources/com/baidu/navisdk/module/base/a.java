package com.baidu.navisdk.module.base;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f7039a = 0;
    private static volatile boolean b = false;

    public static void a(int i) {
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("NotifyGuideStatus", "notifyEndGuide: " + i + ",sVerifyStartEnd:" + f7039a + "," + b);
        }
        if (b) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("1.o", "1", i + "");
            BNRouteGuider.getInstance().notifyEndRouteGuide();
            b = false;
            if (gVar.b()) {
                int i2 = f7039a - 1;
                f7039a = i2;
                if (i2 != 0 && gVar.c()) {
                    gVar.a("notifyEndGuide: exception:" + f7039a, new Exception());
                }
            }
        }
    }

    public static void b(int i) {
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("NotifyGuideStatus", "notifyStartGuide: " + i + ",sVerifyStartEnd:" + f7039a + "," + b);
        }
        if (b) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("1.o", "0", i + "");
        BNRouteGuider.getInstance().notifyStartRouteGuide();
        b = true;
        if (gVar.b()) {
            int i2 = f7039a + 1;
            f7039a = i2;
            if (i2 != 1 && gVar.c()) {
                gVar.a("notifyStartGuide: exception:" + f7039a, new Exception());
            }
        }
    }
}
