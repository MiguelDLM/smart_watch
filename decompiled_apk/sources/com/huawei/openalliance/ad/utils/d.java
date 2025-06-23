package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.hihonor.android.os.Build;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes10.dex */
public abstract class d {
    private static final int B = 81;
    private static final int C = 90;
    private static final int Code = 32;
    private static final int D = 655;
    private static final int F = 720;
    private static final int I = 68;
    private static final int L = 632;
    private static final int S = 400;
    private static final int V = 50;
    private static final int Z = 60;

    /* renamed from: a, reason: collision with root package name */
    private static final int f17410a = 526;
    private static final int b = 432;
    private static final int c = 320;
    private static final int d = 468;
    private static final int e = 728;
    private static final float f = 0.15f;
    private static final float g = 0.12362637f;
    private static final float h = 0.12820514f;
    private static final float i = 0.15625f;
    private static final String j = "ex_splash_func_status";
    private static final String k = "ex_splash_list";
    private static final String l = "ex_splash_block_list";
    private static final String m = "d";

    public static int B(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        return Code2 > V2 ? Code2 : V2;
    }

    public static int C(Context context, int i2) {
        return i2 == 0 ? Z(context) : B(context);
    }

    public static int Code(int i2, int i3) {
        float f2;
        float f3;
        int i4;
        int min = Math.min(90, Math.round(i3 * 0.15f));
        if (i2 > 432) {
            if (i2 <= 526) {
                i4 = 68;
            } else if (i2 <= L) {
                f2 = i2;
                f3 = h;
            } else if (i2 <= D) {
                i4 = 81;
            } else {
                f2 = i2;
                f3 = g;
            }
            return Math.max(Math.min(i4, min), 50);
        }
        f2 = i2;
        f3 = i;
        i4 = Math.round(f2 * f3);
        return Math.max(Math.min(i4, min), 50);
    }

    public static int D(Context context) {
        if (context == null) {
            return 0;
        }
        if (C(context).density == 0.0f) {
            return 0;
        }
        int I2 = w.I(context, r1.widthPixels);
        int Z2 = Z(context, 0);
        if (I2 == 0 || Z2 == 0) {
            return 0;
        }
        return Code(I2, Z2);
    }

    public static int F(Context context) {
        if (context == null) {
            return 0;
        }
        return w.V(context, D(context));
    }

    public static int I(Context context) {
        if (context == null) {
            return 0;
        }
        return w.I(context, Z(context));
    }

    public static boolean L(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), l);
                    if ((!TextUtils.isEmpty(string) && Arrays.asList(string.split(com.huawei.openalliance.ad.constant.x.aL)).contains(packageName)) || Settings.Global.getInt(context.getContentResolver(), j, 0) == 0) {
                        return false;
                    }
                    String string2 = Settings.Global.getString(context.getContentResolver(), k);
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    return Arrays.asList(string2.split(com.huawei.openalliance.ad.constant.x.aL)).contains(packageName);
                } catch (Throwable th) {
                    fb.I(m, "exception happen: " + th.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public static int S(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.heightPixels;
        float f3 = displayMetrics.density;
        int i2 = (int) (f2 / f3);
        return (int) ((i2 > 720 ? 90 : i2 > 400 ? 50 : 32) * f3);
    }

    public static int V(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).widthPixels;
    }

    public static int Z(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        return Code2 > V2 ? V2 : Code2;
    }

    public static float a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        } catch (RuntimeException | Exception unused) {
            fb.I(m, "getDensity fail");
            return 0.0f;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "secure_gesture_navigation", 0);
        } catch (Throwable th) {
            fb.I(m, "exception happen: " + th.getClass().getSimpleName());
            return 0;
        }
    }

    public static String c(Context context) {
        aq Code2 = aq.Code(context);
        Code(Code2, context.getApplicationContext());
        return Code2.I();
    }

    public static Integer d(Context context) {
        Integer b2 = aq.Code(context).b();
        return b2 == null ? e(context) : b2;
    }

    public static Integer e(final Context context) {
        final Integer c2 = w.c(context);
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.2
            @Override // java.lang.Runnable
            public void run() {
                aq.Code(context).Code(c2);
            }
        });
        return c2;
    }

    public static int B(Context context, int i2) {
        return i2 == 0 ? B(context) : Z(context);
    }

    public static DisplayMetrics C(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return displayMetrics;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int Code(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).heightPixels;
    }

    public static int I(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, C(context));
    }

    public static boolean S(Context context, int i2) {
        if (i2 != 1) {
            fb.Code(m, "ad type %s not support kit preload", Integer.valueOf(i2));
            return false;
        }
        if (!n.B(context) && !n.C(context)) {
            fb.Code(m, "kit preload only support phone or pad");
            return false;
        }
        if (!ck.B(context)) {
            fb.Code(m, "kit preload only support inner device");
            return false;
        }
        if (n.I()) {
            fb.Code(m, "kit preload not support eink");
            return false;
        }
        if (g.Code(context)) {
            return true;
        }
        fb.Code(m, "hms not installed");
        return false;
    }

    public static int V(Context context, int i2) {
        int I2 = w.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return w.V(context, I2 <= 432 ? 320 : I2 <= L ? d : 728);
    }

    public static int Z(Context context, int i2) {
        Configuration configuration;
        if (context == null) {
            return 0;
        }
        DisplayMetrics C2 = C(context);
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return Math.round(Code(C2, configuration, i2, bc.I(context)) / C2.density);
    }

    public static int Code(Context context, int i2) {
        int I2 = w.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return w.V(context, I2 <= 432 ? 50 : I2 <= L ? 60 : 90);
    }

    public static boolean I() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            Log.e(m, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }

    public static String V() {
        return Locale.getDefault().getLanguage() + HelpFormatter.DEFAULT_OPT_PREFIX + Locale.getDefault().getCountry();
    }

    private static int Code(DisplayMetrics displayMetrics, Configuration configuration, int i2, int i3) {
        if (i2 == 0) {
            i2 = configuration.orientation;
        }
        int i4 = displayMetrics.heightPixels;
        int i5 = displayMetrics.widthPixels;
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        return i2 == 1 ? i6 - i3 : i4;
    }

    public static String Code() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r6.equals("3") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String Code(java.lang.String r6) {
        /*
            java.lang.String r0 = com.huawei.openalliance.ad.utils.d.m
            java.lang.String r1 = "convert content down method to downloadSource: %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r6
            com.huawei.hms.ads.fb.Code(r0, r1, r3)
            boolean r0 = com.huawei.openalliance.ad.utils.ay.Code(r6)
            java.lang.String r1 = "0"
            if (r0 == 0) goto L16
            return r1
        L16:
            int r0 = r6.hashCode()
            java.lang.String r3 = "2"
            r5 = 2
            switch(r0) {
                case 50: goto L3e;
                case 51: goto L35;
                case 52: goto L2b;
                case 53: goto L21;
                default: goto L20;
            }
        L20:
            goto L46
        L21:
            java.lang.String r0 = "5"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L46
            r4 = 2
            goto L47
        L2b:
            java.lang.String r0 = "4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L46
            r4 = 1
            goto L47
        L35:
            java.lang.String r0 = "3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L46
            goto L47
        L3e:
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L46
            r4 = 3
            goto L47
        L46:
            r4 = -1
        L47:
            if (r4 == 0) goto L4f
            if (r4 == r2) goto L4e
            if (r4 == r5) goto L4e
            return r1
        L4e:
            return r3
        L4f:
            java.lang.String r6 = "1"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.d.Code(java.lang.String):java.lang.String");
    }

    private static void Code(final aq aqVar, final Context context) {
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.p, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.d.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            fb.V(d.m, "requestUuid failed");
                        } else {
                            fb.V(d.m, "requestUuid success");
                            aqVar.Code(callResult.getData());
                        }
                    }
                }, String.class);
            }
        });
    }

    public static boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return false;
        }
        return w.Code(context, dVar.n());
    }
}
