package com.huawei.openalliance.ad.utils;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.cy;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes10.dex */
public abstract class w {
    private static final byte[] B = new byte[0];
    public static final int Code = 33;
    private static final String I = "HiAdTools";
    public static final int V = 2;
    private static String Z;

    public static String B() {
        return UUID.randomUUID().toString();
    }

    public static boolean C() {
        return ar.B(com.huawei.openalliance.ad.constant.x.bG) && ar.Code(com.huawei.openalliance.ad.constant.x.bG, com.huawei.openalliance.ad.constant.x.bH, null);
    }

    public static int Code(Context context, float f) {
        if (context == null || f <= 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean D(Context context) {
        if (context == null) {
            return false;
        }
        Integer b = b(context);
        if (b != null && b.intValue() >= 30456100) {
            return true;
        }
        fb.V(I, "hms version is too low to support sdkType.");
        return false;
    }

    public static boolean F(Context context) {
        if (context == null) {
            return false;
        }
        Integer b = b(context);
        fb.V(I, "isKitSupportAGDSService, verCode: %s", b);
        if (b != null && b.intValue() >= 30469200) {
            return true;
        }
        fb.V(I, "hms version is too low to support open AGDS service.");
        return false;
    }

    public static int I(Context context, float f) {
        if (context == null || f <= 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean L(Context context) {
        if (context == null) {
            return false;
        }
        Integer b = b(context);
        if (b != null && b.intValue() >= 30462300) {
            return true;
        }
        fb.V(I, "hms version is too low to support query by type.");
        return false;
    }

    private static boolean S() {
        return true;
    }

    public static int V(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int Z(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return 0;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Integer b = b(context);
        if (b != null && b.intValue() >= 30457100) {
            return true;
        }
        fb.V(I, "hms version is too low to support v3.");
        return false;
    }

    public static Integer b(Context context) {
        Integer Code2 = ak.Code(context, g.I(context.getApplicationContext()), "ppskit_ver_code");
        if (fb.Code()) {
            fb.Code(I, "ppsKitVerCode:%s", Code2);
        }
        return Code2;
    }

    public static Integer c(Context context) {
        Integer Code2 = ak.Code(context, context.getApplicationContext().getPackageName(), "hw_ads_sdk_type");
        if (fb.Code()) {
            fb.Code(I, "sdkType:%s", Code2);
        }
        return Code2;
    }

    public static float d(Context context) {
        Configuration configuration;
        if (context == null) {
            return -1.0f;
        }
        float k = k(context);
        if (k > 0.0f) {
            return k;
        }
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return -1.0f;
        }
        return configuration.fontScale;
    }

    public static boolean e(Context context) {
        return d(context) >= 1.75f;
    }

    public static boolean f(Context context) {
        return d(context) >= 1.3f;
    }

    public static int g(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            fb.I(I, "getStatusBarHeight err: %s", th.getClass().getSimpleName());
            return 0;
        }
    }

    public static boolean h(Context context) {
        return d.I(context) >= 600;
    }

    public static String i(Context context) {
        String Z2 = Z(context);
        if (g.Code(Z2)) {
            return "com.huawei.permission.app.DOWNLOAD";
        }
        if (ay.Code(Z2)) {
            return com.huawei.openalliance.ad.constant.x.dz;
        }
        return Z2 + com.huawei.openalliance.ad.constant.x.dz;
    }

    private static boolean j(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.huawei.openalliance.ad.constant.x.as);
        String str = "ads-base";
        sb.append("ads-base");
        String Code2 = bc.Code(context, sb.toString());
        if (TextUtils.isEmpty(Code2)) {
            str = "ads-base-inner";
            Code2 = bc.Code(context, com.huawei.openalliance.ad.constant.x.as + str);
        }
        if (!TextUtils.isEmpty(Code2)) {
            Code2 = Code2.replaceAll(str + ":", "");
        }
        if (TextUtils.equals(Code2, "13.4.72.300")) {
            return true;
        }
        if (TextUtils.isEmpty(Code2)) {
            Log.w(I, "unknown base sdk version");
            return true;
        }
        Log.e(I, "current sdk module version 13.4.72.300 is not compatible with base sdk version(" + Code2 + "), please update to base version " + Code2);
        return false;
    }

    private static float k(Context context) {
        try {
            return Settings.System.getFloat(context.getContentResolver(), "font_scale", -1.0f);
        } catch (Throwable th) {
            fb.I(I, "get font err: %s", th.getClass().getSimpleName());
            return -1.0f;
        }
    }

    public static boolean B(Context context) {
        return TextUtils.equals(g.I(context), Z(context));
    }

    public static boolean C(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Object systemService = context.getSystemService("uimode");
        return (systemService instanceof UiModeManager) && ((UiModeManager) systemService).getNightMode() == 2;
    }

    public static long Code() {
        return System.currentTimeMillis();
    }

    private static String I(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable unused) {
            fb.I(I, "decode failed");
            return "";
        }
    }

    public static boolean S(Context context) {
        if (context == null) {
            return false;
        }
        Integer b = b(context);
        if (b != null && b.intValue() >= 30445100) {
            return true;
        }
        fb.V(I, "hms version is too low to support switch next install way.");
        return false;
    }

    public static long V() {
        long maxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        if (fb.Code()) {
            fb.Code(I, "unUsedMemory is: %s", String.valueOf(maxMemory));
        }
        return maxMemory;
    }

    public static String Z() {
        String str;
        synchronized (B) {
            str = Z;
        }
        return str;
    }

    private static boolean B(Context context, String str) {
        if (context == null) {
            fb.I(I, "processWhyEvent context is null, return");
            return false;
        }
        String str2 = com.huawei.openalliance.ad.constant.x.ao;
        if (com.huawei.openalliance.ad.constant.x.ao.equalsIgnoreCase(str) && !B(context)) {
            str = com.huawei.openalliance.ad.constant.x.ap + context.getPackageName();
        }
        if (!ay.Code(str)) {
            fb.Code(I, "processWhyEvent url = %s", bh.Code(str));
            return ay.B(str) ? Code(context, str) : Z(context, str);
        }
        if (!B(context)) {
            str2 = com.huawei.openalliance.ad.constant.x.ap + context.getPackageName();
        }
        fb.Code(I, "processWhyEvent cloud download url is empty, use default!");
        return Z(context, str2);
    }

    public static long Code(long j) {
        return (System.currentTimeMillis() - SystemClock.uptimeMillis()) + j;
    }

    public static boolean I() {
        try {
            Class.forName(com.huawei.openalliance.ad.constant.x.aH);
            return true;
        } catch (Throwable unused) {
            fb.I(I, "inner pps core service not available");
            return false;
        }
    }

    public static void V(String str) {
        synchronized (B) {
            Z = str;
        }
    }

    public static String Z(Context context) {
        String Z2 = Z();
        fb.V(I, "current connected service pkg: " + Z2);
        if (!TextUtils.isEmpty(Z2)) {
            return Z2;
        }
        int t = ed.Code(context).t();
        if (((t != 0 && t != 2) || !V(context)) && I()) {
            return context.getPackageName();
        }
        return g.I(context);
    }

    @SuppressLint({"WrongConstant"})
    public static Intent Code(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, 2);
        return registerReceiver;
    }

    public static boolean I(Context context) {
        if (I()) {
            return true;
        }
        int I2 = g.I(context, g.I(context));
        fb.V(I, "isSupportSetAppInfo hms ver: " + I2);
        if (I2 >= 40004300) {
            return true;
        }
        fb.V(I, "hms is not installed or hms version is too low, version is: " + I2);
        return false;
    }

    public static boolean V(Context context) {
        int I2 = g.I(context, g.I(context));
        fb.V(I, "isSupportHmsAdsService hms ver: " + I2);
        if (I2 >= 40000300) {
            return true;
        }
        fb.V(I, "hms is not installed or hms version is too low, version is: " + I2);
        return false;
    }

    private static boolean Z(Context context, String str) {
        String str2;
        if (ay.Code(str)) {
            str2 = "openLinkByDeepLink deepLinkUrl is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setPackage(B(context) ? g.I(context) : context.getPackageName());
                intent.setData(Uri.parse(str));
                intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkByDeepLink " + th.getClass().getSimpleName();
            }
        }
        fb.I(I, str2);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    public static Intent Code(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent registerReceiver;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
        registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, str, handler, 2);
        return registerReceiver;
    }

    private static boolean I(Context context, AdContentData adContentData) {
        if (ck.Code(context).V()) {
            fb.I(I, "china rom should not call gotoWhyThisAdPage method");
            return false;
        }
        String ad = adContentData.ad();
        if (TextUtils.isEmpty(ad)) {
            ad = adContentData.ac();
        }
        return B(context, I(ad));
    }

    private static boolean V(Context context, AdContentData adContentData) {
        String aP = adContentData.aP();
        if (!ay.B(aP)) {
            fb.I(I, "url is invalid");
            return false;
        }
        Boolean isOpenWebPageByBrowser = HiAd.getInstance(context).isOpenWebPageByBrowser();
        if (isOpenWebPageByBrowser != null && isOpenWebPageByBrowser.booleanValue()) {
            fb.Code(I, "try open in browser");
            if (I(context, aP)) {
                fb.Code(I, "open in browser success");
                return true;
            }
        }
        return cj.Code(context, aP);
    }

    public static SimpleDateFormat Code(String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH);
        } catch (Throwable unused) {
            return new SimpleDateFormat(str);
        }
    }

    private static boolean I(Context context, String str) {
        String str2;
        if (context == null || !ay.B(str)) {
            str2 = "param is error, return";
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                if (ad.Code(packageManager.queryIntentActivities(intent, 65536))) {
                    fb.I(I, "No any browser installed");
                    return false;
                }
                intent.setFlags(268468224);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkInBrowser " + th.getClass().getSimpleName();
            }
        }
        fb.I(I, str2);
        return false;
    }

    public static boolean V(Context context, String str) {
        return cy.Code(context, str, g.Z(context, str));
    }

    public static boolean Code(Context context) {
        return S() && j(context);
    }

    public static boolean Code(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (resolveContentProvider == null) {
            fb.Z(I, "Invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        fb.V(I, "Target provider service's package name is : " + str);
        if (str == null) {
            return false;
        }
        boolean z = packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
        if (!z) {
            String Z2 = g.Z(context, str);
            boolean isEmpty = TextUtils.isEmpty(Z2);
            fb.V(I, "is sign empty: %s", Boolean.valueOf(isEmpty));
            if (!isEmpty) {
                return cy.Code(context, str, Z2);
            }
        }
        return z;
    }

    public static boolean Code(Context context, AdContentData adContentData) {
        if (context == null || adContentData == null) {
            return false;
        }
        return Code(adContentData) ? V(context, adContentData) : I(context, adContentData);
    }

    public static boolean Code(Context context, String str) {
        String str2;
        if (ay.Code(str)) {
            str2 = "openLinkInBrowser url is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268468224);
                intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkInBrowser " + th.getClass().getSimpleName();
            }
        }
        fb.I(I, str2);
        return false;
    }

    public static boolean Code(AdContentData adContentData) {
        return (adContentData == null || !adContentData.aQ() || ay.Code(adContentData.aP())) ? false : true;
    }

    public static boolean Code(boolean z, String str) {
        fb.V(I, "dsa switch on:%s, url:%s", Boolean.valueOf(z), bh.Code(str));
        return z && !ay.Code(str);
    }

    public static boolean Code(boolean z, boolean z2, String str) {
        return z && z2 && !ay.Code(str);
    }

    public static boolean Code(int[] iArr, int i) {
        return iArr != null && iArr.length == i;
    }
}
