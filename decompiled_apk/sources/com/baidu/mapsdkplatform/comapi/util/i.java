package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.google.android.exoplayer2.C;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class i {
    private static String E = null;

    /* renamed from: a, reason: collision with root package name */
    public static Context f6209a = null;
    public static String c = null;
    private static final String d = "i";
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    private static String s;
    private static String x;
    private static String y;
    private static com.baidu.mapsdkplatform.comjni.util.a e = new com.baidu.mapsdkplatform.comjni.util.a();
    private static String f = com.huawei.hms.ads.dynamic.a.t;
    private static String t = "baidu";
    private static String u = "";
    private static String v = "";
    private static String w = "";
    private static String z = "-1";
    private static String A = "-1";
    public static float b = 1.0f;
    private static String B = "";
    private static Map<String, String> C = new HashMap();
    private static String D = "";
    private static boolean F = false;
    private static boolean G = false;

    public static void a(boolean z2) {
        if (G == z2) {
            return;
        }
        G = z2;
        Context context = f6209a;
        if (context == null) {
            return;
        }
        MH.setAgreePolicy(context, z2);
        if (!F && z2) {
            u();
            F = true;
        }
        i();
    }

    public static void b(boolean z2) {
        Context context = f6209a;
        if (context == null) {
            return;
        }
        MH.setAppStatus(context, z2);
    }

    public static void c(Context context) {
        f6209a = context;
        if (context.getFilesDir() != null) {
            x = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            y = context.getCacheDir().getAbsolutePath();
        }
        MH.setAgreePolicy(f6209a, G);
        if (com.baidu.mapsdkplatform.comapi.b.c()) {
            i = "Android" + Build.VERSION.SDK;
            j = Build.VERSION.RELEASE;
            h = Build.MODEL;
            k = String.valueOf(Build.VERSION.SDK_INT);
            if (!F) {
                u();
                F = true;
            }
        } else {
            i = "Android";
            j = "";
            h = "";
            k = "";
        }
        g = context.getPackageName();
        d(context);
        e(context);
        t();
        C.put("zid", v());
        C.put("resid", AppMD5.encodeUrlParamsValue(f));
        C.put("channel", AppMD5.encodeUrlParamsValue(p()));
        C.put("mb", AppMD5.encodeUrlParamsValue(j()));
        C.put("sv", AppMD5.encodeUrlParamsValue(l()));
        C.put(oO.f31192XO, AppMD5.encodeUrlParamsValue(n()));
        C.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(o()), Integer.valueOf(o()))));
        if (!TextUtils.isEmpty(B)) {
            C.put("cuid", AppMD5.encodeUrlParamsValue(B));
        }
        Context context2 = f6209a;
        if (context2 != null) {
            C.put(t.r, AppMD5.encodeUrlParamsValue(context2.getPackageName()));
        }
        C.put(TanxAdType.SPLASH_STRING, AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(k()), Integer.valueOf(m()))));
        com.baidu.mapsdkplatform.comjni.util.a aVar = e;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void d(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String apiVersion = VersionInfo.getApiVersion();
            l = apiVersion;
            if (apiVersion != null && !apiVersion.equals("")) {
                l = l.replace('_', '.');
            }
            m = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            l = "1.0.0";
            m = 1;
        }
    }

    private static void e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            n = defaultDisplay.getWidth();
            o = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        b = displayMetrics.density;
        p = (int) displayMetrics.xdpi;
        q = (int) displayMetrics.ydpi;
        int i2 = displayMetrics.densityDpi;
        r = i2;
        if (i2 == 0) {
            r = 160;
        }
    }

    public static String f() {
        if (C == null) {
            return null;
        }
        if (TextUtils.isEmpty(B)) {
            C.put("cuid", AppMD5.encodeUrlParamsValue(s()));
        }
        C.put("zid", v());
        long time = new Date().getTime() + (r0.getSeconds() * 1000);
        C.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf((time / 1000) + ((time % 1000) / 1000.0d)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : C.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void g() {
        com.baidu.mapsdkplatform.comjni.util.a aVar = e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static String h() {
        return s;
    }

    public static void i() {
        C.put(TKDownloadReason.KSAD_TK_NET, AppMD5.encodeUrlParamsValue(h()));
        C.put("appid", AppMD5.encodeUrlParamsValue(z));
        C.put("bduid", "");
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        if (com.baidu.mapsdkplatform.comapi.b.c()) {
            i = "Android" + Build.VERSION.SDK;
            j = Build.VERSION.RELEASE;
            h = Build.MODEL;
            k = String.valueOf(Build.VERSION.SDK_INT);
        } else {
            i = "Android";
            j = "";
            h = "";
            k = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("arv", j);
        hashMap.put("arl", k);
        hashMap.put("mod", h);
        hashMap.put("ws", s);
        if (F) {
            a((HashMap<String, String>) hashMap);
        }
        jsonBuilder.putStringValue(IAdInterListener.AdProdType.PRODUCT_CPU, u);
        jsonBuilder.putStringValue("resid", f);
        jsonBuilder.putStringValue("channel", t);
        jsonBuilder.putStringValue("glr", v);
        jsonBuilder.putStringValue("glv", w);
        jsonBuilder.putStringValue("mb", j());
        jsonBuilder.putStringValue("sv", l());
        jsonBuilder.putStringValue(oO.f31192XO, n());
        jsonBuilder.key("dpi_x").value(o());
        jsonBuilder.key("dpi_y").value(o());
        jsonBuilder.putStringValue(TKDownloadReason.KSAD_TK_NET, s);
        jsonBuilder.putStringValue("cuid", B);
        Context context = f6209a;
        if (context != null) {
            jsonBuilder.putStringValue(t.r, context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(k());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.putStringValue("appid", z);
        jsonBuilder.putStringValue("duid", A);
        jsonBuilder.putStringValue("zid", v());
        if (!TextUtils.isEmpty(c)) {
            jsonBuilder.putStringValue("token", c);
        }
        jsonBuilder.endObject();
        SysUpdateObservable.getInstance().updatePhoneInfo(jsonBuilder.getJson());
    }

    public static String j() {
        return h;
    }

    public static int k() {
        return n;
    }

    public static String l() {
        return l;
    }

    public static int m() {
        return o;
    }

    public static String n() {
        return i;
    }

    public static int o() {
        return r;
    }

    public static String p() {
        return t;
    }

    public static String q() {
        return g;
    }

    public static String r() {
        return x;
    }

    public static String s() {
        String str;
        try {
            str = LBSAuthManager.getInstance(f6209a).getCUID();
            if (!TextUtils.isEmpty(str) && !str.equals(B)) {
                B = str;
                if (C != null) {
                    C.put("cuid", AppMD5.encodeUrlParamsValue(s()));
                }
                SysUpdateObservable.getInstance().updateCuid(B);
                HashMap hashMap = new HashMap();
                hashMap.put("cuid", B);
                MH.ud(f6209a, hashMap);
            }
        } catch (Exception unused) {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static void t() {
        s = "0";
    }

    private static boolean u() {
        if (f6209a == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.arrayValue();
        byte[] a2 = a(f6209a);
        if (a2 != null) {
            for (byte b2 : a2) {
                jsonBuilder.value((int) b2);
            }
        }
        jsonBuilder.endArrayValue();
        hashMap.put("cuid", B);
        hashMap.put("p", f6209a.getPackageName());
        hashMap.put("s", jsonBuilder.getJson());
        hashMap.put("arv", j);
        hashMap.put("arl", k);
        hashMap.put("mod", h);
        hashMap.put("ws", s);
        if (com.baidu.mapsdkplatform.comapi.b.b() != null) {
            hashMap.put(EngineImpl.KEY_OAID, com.baidu.mapsdkplatform.comapi.b.b().getOAID());
        }
        MH.init(f6209a, hashMap);
        return true;
    }

    private static String v() {
        String gzfi;
        Context context = f6209a;
        if (context == null || (gzfi = MH.gzfi(context, null, 3041, null, null)) == null || gzfi.length() <= 0) {
            return "";
        }
        if (!gzfi.equals(E)) {
            E = gzfi;
            SysUpdateObservable.getInstance().updateZid(E);
        }
        return gzfi;
    }

    public static String b() {
        return c;
    }

    public static void b(Context context) {
        f6209a = context;
    }

    public static void a() {
        c = null;
    }

    public static String d() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue(IAdInterListener.AdProdType.PRODUCT_CPU, u);
        jsonBuilder.putStringValue("resid", f);
        jsonBuilder.putStringValue("channel", t);
        jsonBuilder.putStringValue("glr", v);
        jsonBuilder.putStringValue("glv", w);
        jsonBuilder.putStringValue("mb", j());
        jsonBuilder.putStringValue("sv", l());
        jsonBuilder.putStringValue(oO.f31192XO, n());
        jsonBuilder.key("dpi_x").value(o());
        jsonBuilder.key("dpi_y").value(o());
        jsonBuilder.putStringValue(TKDownloadReason.KSAD_TK_NET, s);
        jsonBuilder.putStringValue("cuid", B);
        jsonBuilder.putStringValue("zid", v());
        if (f6209a == null) {
            f6209a = JNIInitializer.getCachedContext();
        }
        Context context = f6209a;
        if (context != null) {
            jsonBuilder.putStringValue(t.r, context.getPackageName());
        }
        jsonBuilder.key("screen_x").value(k());
        jsonBuilder.key("screen_y").value(m());
        jsonBuilder.endObject();
        String json = jsonBuilder.getJson();
        D = json;
        return json;
    }

    public static byte[] a(Context context) {
        Signature[] signatureArr;
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        SigningInfo signingInfo2;
        SigningInfo signingInfo3;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                if (hasMultipleSigners) {
                    signingInfo3 = context.getPackageManager().getPackageInfo(context.getPackageName(), C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo3.getApkContentsSigners();
                } else {
                    signingInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo2.getSigningCertificateHistory();
                }
            } else {
                signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static String e() {
        return D;
    }

    private static boolean a(HashMap<String, String> hashMap) {
        Context context = f6209a;
        if (context == null) {
            return false;
        }
        MH.ud(context, hashMap);
        return true;
    }

    public static void a(String str) {
        s = str;
        i();
    }

    public static void a(String str, String str2) {
        z = str2;
        A = str;
        i();
    }

    public static void c() {
        g();
    }
}
