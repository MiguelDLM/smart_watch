package com.huawei.openalliance.ad.utils;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.cl;
import com.huawei.hms.ads.cw;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fw;
import java.util.Locale;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public abstract class bc {
    private static final int B = 33;
    public static final String Code = "zh-CN";
    private static final String I = "display_notch_status";
    private static final String V = "bc";
    private static final int Z = 0;

    public static boolean B() {
        String Code2 = Code("ro.product.locale.region");
        if (!TextUtils.isEmpty(Code2)) {
            return "cn".equalsIgnoreCase(Code2);
        }
        String Code3 = Code("ro.product.locale");
        if (!TextUtils.isEmpty(Code3)) {
            return Code3.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String Z2 = Z();
        if (TextUtils.isEmpty(Z2)) {
            return false;
        }
        return "cn".equalsIgnoreCase(Z2);
    }

    public static int C(Context context) {
        int S = S(context);
        if (S > 0) {
            return S / 2;
        }
        return 36;
    }

    private static int Code(int i) {
        return (i == 1 || i == 2) ? 9 : 1;
    }

    public static boolean D(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean F(Context context) {
        try {
            return cl.Code(context).Code();
        } catch (Throwable th) {
            fb.I(V, "isInMultiWindowMode " + th.getClass().getSimpleName());
            return false;
        }
    }

    public static int I(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0 && j(context) && k(context)) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int L(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 1;
        }
        return configuration.orientation;
    }

    public static int S(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int V(int i) {
        return (i == 2 || i == 3) ? 8 : 0;
    }

    public static int Z(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean a(Context context) {
        boolean canRequestPackageInstalls;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
                return canRequestPackageInstalls;
            }
        } catch (Throwable th) {
            fb.I(V, "canInstallPackage exception %s", th.getClass().getSimpleName());
        }
        return true;
    }

    public static int b(Context context) {
        String str;
        String str2;
        if (!ck.Code(context).S()) {
            return 0;
        }
        try {
            return 1 - Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state");
        } catch (Settings.SettingNotFoundException unused) {
            str = V;
            str2 = "get pureModeState error, setting not found.";
            fb.Z(str, str2);
            return 0;
        } catch (Throwable unused2) {
            str = V;
            str2 = "get pureModeState error.";
            fb.Z(str, str2);
            return 0;
        }
    }

    public static int c(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return 1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            fb.Z(V, "Failed to get display orientation info.");
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        }
        int abs = Math.abs(windowManager.getDefaultDisplay().getWidth());
        int abs2 = Math.abs(windowManager.getDefaultDisplay().getHeight());
        int rotation = defaultDisplay.getRotation();
        return abs < abs2 ? Code(rotation) : V(rotation);
    }

    public static boolean d(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            return ap.Code(context, com.huawei.openalliance.ad.constant.x.cC);
        }
        return true;
    }

    public static int e(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            fb.I(V, "getMultiWindowDragBarHeight " + th.getClass().getSimpleName());
            return 0;
        }
    }

    public static boolean f(Context context) {
        return Build.VERSION.SDK_INT == 28 && h(context);
    }

    public static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static boolean h(Context context) {
        return context != null && com.huawei.openalliance.ad.constant.x.ds.equalsIgnoreCase(i(context));
    }

    public static String i(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int color = context.getResources().getColor(R.color.hiad_dark_mode_tag_color);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(xoXoI.f2670oxoX);
            String hexString = Integer.toHexString(Color.alpha(color));
            String hexString2 = Integer.toHexString(Color.red(color));
            String hexString3 = Integer.toHexString(Color.green(color));
            String hexString4 = Integer.toHexString(Color.blue(color));
            String V2 = V(hexString);
            String V3 = V(hexString2);
            String V4 = V(hexString3);
            String V5 = V(hexString4);
            stringBuffer.append(V2);
            stringBuffer.append(V3);
            stringBuffer.append(V4);
            stringBuffer.append(V5);
            fb.Code(V, " color=" + stringBuffer.toString());
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Exception e) {
            fb.V(V, "catch theme color exception:" + e.getClass().getName());
            return null;
        }
    }

    private static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b = d.b(context);
            fb.Code(V, "isGesture: %s", Integer.valueOf(b));
            if (b == 0) {
                return true;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code2 = Code("qemu.hw.mainkeys");
            if (!"1".equals(Code2)) {
                if ("0".equals(Code2)) {
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean k(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x003c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean B(android.content.Context r4) {
        /*
            r0 = 0
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> Lc android.provider.Settings.SettingNotFoundException -> Le
            java.lang.String r1 = "display_notch_status"
            int r4 = android.provider.Settings.Secure.getInt(r4, r1)     // Catch: java.lang.Throwable -> Lc android.provider.Settings.SettingNotFoundException -> Le
            goto L3a
        Lc:
            r4 = move-exception
            goto L10
        Le:
            r4 = move-exception
            goto L2f
        L10:
            java.lang.String r1 = com.huawei.openalliance.ad.utils.bc.V
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isNotchEnable Throwable:"
        L19:
            r2.append(r3)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.huawei.hms.ads.fb.V(r1, r4)
            goto L39
        L2f:
            java.lang.String r1 = com.huawei.openalliance.ad.utils.bc.V
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isNotchEnable error:"
            goto L19
        L39:
            r4 = 0
        L3a:
            if (r4 != 0) goto L3d
            r0 = 1
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.bc.B(android.content.Context):boolean");
    }

    public static boolean C() {
        return I() && !com.huawei.openalliance.ad.constant.x.cL.equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    public static int Code(boolean z) {
        return z ? R.drawable.hiad_video_mute : R.drawable.hiad_video_unmute;
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean I() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    private static String V(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() != 1) {
            return str;
        }
        return "0" + str;
    }

    public static String Z() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static int[] B(View view) {
        return !I(view) ? new int[0] : new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static String Code(Context context, String str) {
        PackageManager packageManager;
        String str2;
        StringBuilder sb;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(str);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str2 = V;
            sb = new StringBuilder();
            sb.append("getMetaDataInfo ");
            sb.append(e.getClass().getSimpleName());
            fb.I(str2, sb.toString());
            return "";
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb = new StringBuilder();
            sb.append("getMetaDataInfo ");
            sb.append(e.getClass().getSimpleName());
            fb.I(str2, sb.toString());
            return "";
        }
        return "";
    }

    public static boolean I(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static int[] Z(View view) {
        if (!I(view)) {
            return new int[0];
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    public static String Code(View view) {
        int[] V2 = V(view);
        return String.format("%s,%s", Integer.valueOf(V2[0]), Integer.valueOf(V2[1]));
    }

    public static boolean V(Context context) {
        KeyguardManager keyguardManager;
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static String Code(fw fwVar) {
        int[] V2 = V(fwVar);
        return String.format("%s,%s", Integer.valueOf(V2[0]), Integer.valueOf(V2[1]));
    }

    public static int[] V(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static String Code(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d.I() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (RuntimeException e) {
            e = e;
            str2 = V;
            sb = new StringBuilder();
            str3 = "getSystemProperties RuntimeException:";
            sb.append(str3);
            sb.append(e.getClass().getSimpleName());
            fb.I(str2, sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb = new StringBuilder();
            str3 = "getSystemProperties Exception:";
            sb.append(str3);
            sb.append(e.getClass().getSimpleName());
            fb.I(str2, sb.toString());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] V(fw fwVar) {
        return V(fwVar instanceof View ? (View) fwVar : null);
    }

    public static void Code(Activity activity, Context context) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (context == null || activity == null) {
            fb.I(V, "para is null");
            return;
        }
        Activity g = g(context);
        if (g == null) {
            fb.I(V, "parent activity is null");
            return;
        }
        Window window = g.getWindow();
        Window window2 = activity.getWindow();
        if (window == null || window2 == null) {
            fb.I(V, "window is null");
            return;
        }
        WindowManager.LayoutParams attributes = window2.getAttributes();
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        attributes.flags = attributes2.flags | 67108864;
        if (i2 >= 28) {
            i = attributes2.layoutInDisplayCutoutMode;
            attributes.layoutInDisplayCutoutMode = i;
        }
        window2.setAttributes(attributes);
        window2.setNavigationBarColor(window.getNavigationBarColor());
        View decorView = window.getDecorView();
        View decorView2 = window2.getDecorView();
        if (decorView == null || decorView2 == null) {
            fb.I(V, "decorView is null");
        } else {
            decorView2.setSystemUiVisibility(decorView.getSystemUiVisibility());
        }
    }

    public static void Code(Activity activity, final com.huawei.openalliance.ad.views.i iVar) {
        if (activity == null || !ck.B(activity)) {
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            fb.I(V, "get safe padding, window is null");
            return;
        }
        try {
            final cw Code2 = cl.Code(activity);
            Code2.Code(window.getAttributes());
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.bc.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    com.huawei.openalliance.ad.views.i iVar2;
                    try {
                        Rect Code3 = cw.this.Code(windowInsets);
                        if (fb.Code()) {
                            fb.Code(bc.V, "got safe padding: %s", Integer.valueOf(Code3 == null ? 0 : Code3.right));
                        }
                        if (Code3 != null && (iVar2 = iVar) != null) {
                            iVar2.Code(Code3.right);
                        }
                    } catch (NoSuchMethodError unused) {
                        fb.I(bc.V, "getRingScreenSafePadding NoSuchMethodError getDisplaySideRegion");
                    } catch (Throwable th) {
                        fb.I(bc.V, "getRingScreenSafePadding error:" + th.getClass().getSimpleName());
                    }
                    return windowInsets;
                }
            });
        } catch (Throwable th) {
            fb.I(V, "getSafePadding ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
            context.startActivity(intent);
        } catch (Throwable unused) {
            fb.I(V, "start activity error");
        }
    }

    public static void Code(final View view, Activity activity) {
        String str;
        String str2;
        if (activity == null) {
            str = V;
            str2 = "has no activity";
        } else if (!ck.B(activity)) {
            str = V;
            str2 = "not huawei phone";
        } else if (view == null) {
            str = V;
            str2 = "has no rootview";
        } else if (Code(activity)) {
            str = V;
            str2 = "freedom window";
        } else {
            Window window = activity.getWindow();
            if (window != null) {
                try {
                    final cw Code2 = cl.Code(activity);
                    Code2.Code(window.getAttributes());
                    window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.bc.1
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                            View view3;
                            try {
                                Rect Code3 = cw.this.Code(windowInsets);
                                if (Code3 != null && (view3 = view) != null) {
                                    view3.setPadding(Code3.left, 0, Code3.right, 0);
                                }
                            } catch (NoSuchMethodError unused) {
                                fb.I(bc.V, "initOnApplyWindowInsets NoSuchMethodError getDisplaySideRegion");
                            } catch (Throwable th) {
                                fb.I(bc.V, "initOnApplyWindowInsets error:" + th.getClass().getSimpleName());
                            }
                            return windowInsets;
                        }
                    });
                    return;
                } catch (NoSuchMethodError unused) {
                    fb.I(V, "adaptRingScreen NoSuchMethodError setDisplaySideMode");
                    return;
                } catch (Throwable th) {
                    fb.I(V, "adaptRingScreen error:" + th.getClass().getSimpleName());
                    return;
                }
            }
            str = V;
            str2 = "has no window";
        }
        fb.I(str, str2);
    }

    public static void Code(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setScaleX(I() ? -1.0f : 1.0f);
    }

    public static boolean Code() {
        return true;
    }

    public static boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        return cl.Code(activity.getApplicationContext()).Code(activity);
    }

    public static boolean Code(Context context) {
        PowerManager powerManager;
        if (context != null && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
            try {
                return powerManager.isInteractive();
            } catch (Exception unused) {
                fb.I(V, "isScreenInteractive has exception");
                return true;
            }
        }
        return true;
    }
}
