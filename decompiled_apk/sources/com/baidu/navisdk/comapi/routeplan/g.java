package com.baidu.navisdk.comapi.routeplan;

import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class g {
    private static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "未知车辆" : "货车" : "摩托车" : "小轿车";
    }

    public static void a(int i, int i2) {
        if (i != 1 && i != 2 && i != 3) {
            LogUtil.printException("BNTripModeManager", new Throwable(String.format(Locale.getDefault(), "setTripMode() vehicle value(%d) exception, source(%d)", Integer.valueOf(i), Integer.valueOf(i2))));
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNTripModeManager", "setTripMode vehicle:" + a(i) + ", source:" + com.baidu.navisdk.module.vehiclemanager.a.a(i2));
        }
        boolean tripMode = JNIGuidanceControl.getInstance().setTripMode(i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.d()) {
            gVar.e("BNTripModeManager", "setTripMode result: " + tripMode);
        }
    }
}
