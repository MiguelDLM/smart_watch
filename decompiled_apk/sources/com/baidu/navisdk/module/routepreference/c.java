package com.baidu.navisdk.module.routepreference;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class c {
    public static boolean a(int i, int i2) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().c(i2);
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().c(i2);
        }
        return d.j().c(i2);
    }

    public static void b(int i, int i2) {
        if (i == 2) {
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().e(i2);
        } else if (i == 3) {
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().e(i2);
        } else {
            d.j().e(i2);
        }
    }

    public static void c(int i, int i2) {
        if (i == 2) {
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f(i2);
        } else if (i == 3) {
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().f(i2);
        } else {
            d.j().f(i2);
        }
    }

    public static a d(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPreferControllerUtil", "getPreferenceController vehicle: " + i);
        }
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j();
        }
        return d.j();
    }

    public static int e(int i) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().f();
        }
        return d.j().f();
    }

    public static int f(int i) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().g();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().g();
        }
        return d.j().g();
    }

    public static int g(int i) {
        int i2 = (i & 1) != 0 ? 1 : 0;
        if ((i & 256) != 0) {
            i2++;
        }
        if ((i & 8) != 0) {
            i2++;
        }
        if ((i & 16) != 0) {
            i2++;
        }
        if ((i & 4) != 0) {
            i2++;
        }
        return (i & 512) != 0 ? i2 + 1 : i2;
    }

    public static boolean h(int i) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().h();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().h();
        }
        return d.j().h();
    }

    public static void i(int i) {
        if (i == 2) {
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().i();
        } else if (i == 3) {
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().i();
        } else {
            d.j().i();
        }
    }

    public static void a(int i, boolean z) {
        if (i == 2) {
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(z);
        } else if (i == 3) {
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().b(z);
        } else {
            d.j().b(z);
        }
    }

    public static int b(int i) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().c();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().c();
        }
        return d.j().c();
    }

    public static String c(int i) {
        if (i == 2) {
            return com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().e();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().e();
        }
        return d.j().e();
    }

    public static int a(int i) {
        return BNRoutePlaner.getInstance().a(i);
    }
}
