package com.baidu.navisdk.yellowbannerui;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.yellowtipdata.model.data.g;
import java.util.List;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9435a = "b";

    public static boolean a(g gVar, boolean z) {
        boolean z2 = false;
        if (gVar == null) {
            return false;
        }
        String str = f9435a;
        LogUtil.e(str, "isQuickCloseCategory --> data.tipType=" + gVar.i());
        if (gVar.i() == 4 && a(z) && !BNRoutePlaner.getInstance().y()) {
            z2 = true;
        }
        LogUtil.e(str, "isQuickCloseCategory --> result=" + z2);
        return z2;
    }

    private static boolean b(boolean z) {
        boolean z2 = !z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f9435a, "isStartEndInSameCity --> isStartEndInSameCity =" + z2);
        }
        return z2;
    }

    public static boolean a(boolean z) {
        return !a() && b(z);
    }

    public static boolean a(g gVar, boolean z, boolean z2) {
        if (gVar != null && gVar.i() == 4) {
            int b = com.baidu.navisdk.module.vehiclemanager.b.i().b();
            boolean z3 = b == 3;
            boolean z4 = b == 2;
            if (a(gVar, z2) && z && !z3 && !z4) {
                gVar.p(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_yaw_quick_close_main_tilte));
                gVar.m(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_yaw_quick_close_sub_tilte));
                gVar.a(new com.baidu.navisdk.yellowtipdata.model.data.a(5, "quickClose", "关闭"));
                gVar.o("异地车牌开启中");
                gVar.i("点击右侧关闭异地车牌,重新规划路线.");
                gVar.a(0);
                gVar.d((List<String>) null);
                gVar.b(new com.baidu.navisdk.yellowtipdata.model.data.a(5, "quickClose", "关闭"));
                gVar.c((com.baidu.navisdk.yellowtipdata.model.data.a) null);
                return true;
            }
        }
        return false;
    }

    public static boolean a() {
        boolean z = !com.baidu.navisdk.framework.b.W();
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f9435a, "curCityIsHomeCity --> curCityIsHomeCity = " + z);
        }
        return z;
    }
}
