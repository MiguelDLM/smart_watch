package com.baidu.navisdk.pronavi.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7960a;
    private static boolean b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static boolean g;

    @OOXIXo
    public static final a h = new a();

    static {
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
        e = screenUtil.getWidthPixels();
        ScreenUtil screenUtil2 = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil2, "ScreenUtil.getInstance()");
        f = screenUtil2.getHeightPixels();
    }

    private a() {
    }

    private final boolean a(int i) {
        return i == 1 || i == 7 || i == 12;
    }

    public final int b(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return ScreenUtil.getInstance().getDefaultWidth(context);
    }

    public final int c() {
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
        return screenUtil.getAbsoluteHeight();
    }

    public final int d() {
        if (d == c) {
            ScreenUtil screenUtil = ScreenUtil.getInstance();
            IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
            return screenUtil.getHeightPixels();
        }
        ScreenUtil screenUtil2 = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil2, "ScreenUtil.getInstance()");
        return screenUtil2.getWidthPixels();
    }

    public final int e() {
        if (d == c) {
            ScreenUtil screenUtil = ScreenUtil.getInstance();
            IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
            return screenUtil.getWidthPixels();
        }
        ScreenUtil screenUtil2 = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil2, "ScreenUtil.getInstance()");
        return screenUtil2.getHeightPixels();
    }

    public final int f() {
        return d;
    }

    public final boolean g() {
        if (g && b != f7960a) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        return g;
    }

    public final boolean i() {
        return b;
    }

    public final void j() {
    }

    private final boolean a(Configuration configuration) {
        int i;
        int i2 = configuration.screenHeightDp;
        if (i2 == 0 || (i = configuration.screenWidthDp) == 0) {
            return false;
        }
        float f2 = i;
        float f3 = i2;
        float f4 = ((f2 * 1.0f) / f3) * 1.0f;
        float f5 = ((f3 * 1.0f) / f2) * 1.0f;
        float a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("wide_screen_scale", 0.8f);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("isWideScreen = ");
            sb.append(f4 >= a2 && f5 >= a2);
            sb.append(" screenWidthDp = ");
            sb.append(configuration.screenWidthDp);
            sb.append(" screenHeightDp = ");
            sb.append(configuration.screenHeightDp);
            sb.append(" portScale = ");
            sb.append(f4);
            sb.append(" landScale = ");
            sb.append(f5);
            gVar.e("RGScreenConfigUtil", sb.toString());
        }
        return f4 >= a2 && f5 >= a2;
    }

    public final int b() {
        if (d == c) {
            return e;
        }
        return f;
    }

    public final int c(@oOoXoXO Context context) {
        return ScreenUtil.getInstance().getStatusBarHeightFullScreen(context);
    }

    private final int d(Context context) {
        Display defaultDisplay;
        Object systemService = context != null ? context.getSystemService("window") : null;
        WindowManager windowManager = (WindowManager) (systemService instanceof WindowManager ? systemService : null);
        int rotation = (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) ? -1 : defaultDisplay.getRotation();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenConfigUtil", "getRotation: " + rotation);
        }
        return rotation;
    }

    @OOXIXo
    public final Configuration a(@OOXIXo Configuration configuration, @oOoXoXO Activity activity) {
        IIX0o.x0xO0oo(configuration, "configuration");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenConfigUtil", "transformConfigurationIfNeed: " + configuration + ", " + com.baidu.navisdk.framework.b.t());
        }
        if (!com.baidu.navisdk.module.cloudconfig.a.b().a("is_open_wide_screen", true)) {
            if (gVar.d()) {
                gVar.e("RGScreenConfigUtil", "close wide screen adaption");
            }
            int i = configuration.orientation;
            c = i;
            d = i;
            b = false;
            f7960a = false;
            g = false;
            return configuration;
        }
        f7960a = b;
        boolean a2 = a(configuration);
        b = a2;
        if (a2) {
            g = true;
            d(activity != null ? activity.getApplicationContext() : null);
        }
        int i2 = configuration.orientation;
        c = i2;
        boolean z = b;
        int i3 = z ? 2 : i2;
        d = i3;
        if (z && i2 != i3) {
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("transformConfigurationIfNeed requestedOrientation: ");
                sb.append(activity != null ? Integer.valueOf(activity.getRequestedOrientation()) : null);
                gVar.e("RGScreenConfigUtil", sb.toString());
            }
            a(activity, c);
        }
        if (gVar.d()) {
            gVar.e("RGScreenConfigUtil", "transformConfigurationIfNeed: sys:" + c + ", ui:" + d);
        }
        if (configuration.orientation == d) {
            return configuration;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.orientation = d;
        return configuration2;
    }

    public final int a(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return ScreenUtil.getInstance().getDefaultHeight(context);
    }

    public final int a() {
        if (d == c) {
            return f;
        }
        return e;
    }

    public final boolean a(int i, int i2) {
        if (i == 0 || i2 == 0 || (i == e && f == i2)) {
            return false;
        }
        e = i;
        f = i2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenConfigUtil", "updateRootViewSize: " + e + ':' + f);
        }
        return true;
    }

    private final void a(Activity activity, int i) {
        if (activity != null && a(activity.getRequestedOrientation())) {
            Resources resources = activity.getResources();
            IIX0o.oO(resources, "activity.resources");
            int i2 = resources.getDisplayMetrics().heightPixels;
            Resources resources2 = activity.getResources();
            IIX0o.oO(resources2, "activity.resources");
            int i3 = resources2.getDisplayMetrics().widthPixels;
            if (i == 2) {
                if (i3 < i2) {
                    c = 1;
                }
            } else if (i2 < i3) {
                c = 2;
            }
        }
    }

    public final int a(@oOoXoXO Activity activity) {
        return ScreenUtil.getInstance().getStatusBarHeight(activity);
    }
}
