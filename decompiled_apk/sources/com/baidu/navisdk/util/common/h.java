package com.baidu.navisdk.util.common;

/* loaded from: classes8.dex */
public class h {
    public static boolean a(int i) {
        return i == 3 || i == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 4;
    }

    public static boolean c(int i) {
        return i == 1 || i == 2;
    }

    public static boolean d(int i) {
        return i == 3 || i == 4;
    }

    public static int a() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null) {
            if (!LogUtil.LOGGABLE) {
                return 0;
            }
            LogUtil.e("BNRoutePlanUtil", "getTotalDistance rpModel is null");
            return 0;
        }
        return fVar.p();
    }

    public static int b() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null) {
            if (!LogUtil.LOGGABLE) {
                return 0;
            }
            LogUtil.e("BNRoutePlanUtil", "getTotalTime rpModel is null");
            return 0;
        }
        return fVar.q();
    }
}
