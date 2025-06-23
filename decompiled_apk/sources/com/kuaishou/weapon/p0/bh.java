package com.kuaishou.weapon.p0;

import XXO0.oIX0oI;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class bh {

    /* renamed from: a, reason: collision with root package name */
    private static String f18328a;
    private static String b;

    public static String a() {
        return null;
    }

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().IR());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().IR());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().IW());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().getIccId());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().IS());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static boolean g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            StringBuilder sb = new StringBuilder();
            Iterator<InputMethodInfo> it = inputMethodList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getId());
                sb.append(com.huawei.openalliance.ad.constant.x.aL);
            }
            if (TextUtils.isEmpty(sb)) {
                return bi.c;
            }
            String sb2 = sb.toString();
            return sb2.endsWith(com.huawei.openalliance.ad.constant.x.aL) ? sb2.substring(0, sb2.length() - 1) : sb2;
        } catch (Exception unused) {
            return bi.d;
        }
    }

    public static String j(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (string == null) {
                string = "null";
            }
            String str = "1=" + string + com.huawei.openalliance.ad.constant.x.aL;
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                str = str + "2=";
                int i = -1;
                for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                    String packageName = inputMethodInfo.getPackageName();
                    if (packageName == null) {
                        packageName = "null";
                    }
                    String settingsActivity = inputMethodInfo.getSettingsActivity();
                    if (settingsActivity == null) {
                        settingsActivity = "null";
                    }
                    if (packageManager != null) {
                        try {
                            if (!packageName.equals("null") && !settingsActivity.equals("null") && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                                i = activityInfo.launchMode;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = str + packageName + HelpFormatter.DEFAULT_OPT_PREFIX + settingsActivity + HelpFormatter.DEFAULT_OPT_PREFIX + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i)) + com.huawei.openalliance.ad.constant.x.aL;
                }
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return bi.e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? bi.c : string;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String l(android.content.Context r5) {
        /*
            java.lang.String r0 = "accessibility"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r5 = (android.view.accessibility.AccessibilityManager) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            java.util.List r5 = r5.getInstalledAccessibilityServiceList()     // Catch: java.lang.Exception -> L43
            if (r5 == 0) goto L44
            int r1 = r5.size()     // Catch: java.lang.Exception -> L43
            if (r1 <= 0) goto L44
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Exception -> L43
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L41
        L21:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Exception -> L41
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = a(r2)     // Catch: java.lang.Exception -> L41
            int r3 = r1.indexOf(r2)     // Catch: java.lang.Exception -> L41
            r4 = -1
            if (r3 != r4) goto L21
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            goto L21
        L41:
            goto L45
        L43:
        L44:
            r1 = r0
        L45:
            if (r1 != 0) goto L48
            return r0
        L48:
            int r5 = r1.length()
            if (r5 <= 0) goto L57
            int r5 = r1.length()
            int r5 = r5 + (-1)
            r1.deleteCharAt(r5)
        L57:
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bh.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb2 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String a2 = a(it.next());
                        if (sb.indexOf(a2) == -1) {
                            sb.append(a2);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused) {
                    sb2 = sb;
                    sb = sb2;
                    return sb.toString();
                }
            }
        } catch (Exception unused2) {
        }
        if (sb == null) {
            return null;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String n(Context context) {
        return bi.d;
    }

    public static String o(Context context) {
        return bi.c;
    }

    public static String p(Context context) {
        return bi.f18330a;
    }

    public static String q(Context context) {
        try {
            if (TextUtils.isEmpty(f18328a)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                f18328a = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return f18328a;
    }

    public static String r(Context context) {
        return b;
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    public static int t(Context context) {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().IX());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                return Integer.parseInt(c);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    public static int u(Context context) {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().IY());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                return Integer.parseInt(c);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String v(Context context) {
        return bi.c;
    }

    public static String w(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String x(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i = 0; i < 27; i++) {
                if (packageManager.hasSystemFeature(strArr[i])) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String y(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject z = z(context);
            if (z != null && (keys = z.keys()) != null) {
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = z.getString(next);
                    sb.append(str);
                    str = com.huawei.openalliance.ad.constant.x.aL;
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static JSONObject z(Context context) {
        String encode;
        String encode2;
        String encode3;
        String encode4;
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String m = m();
            String str2 = WeaponHI.sChannel;
            String l = l();
            String k = k();
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                encode = "";
            } else {
                encode = URLEncoder.encode(str, "UTF-8");
            }
            jSONObject.put(com.huawei.openalliance.ad.constant.aw.r, encode);
            if (TextUtils.isEmpty(m)) {
                encode2 = "";
            } else {
                encode2 = URLEncoder.encode(m, "UTF-8");
            }
            jSONObject.put("platform", encode2);
            if (TextUtils.isEmpty(str2)) {
                encode3 = "";
            } else {
                encode3 = URLEncoder.encode(str2, "UTF-8");
            }
            jSONObject.put("channel", encode3);
            try {
                if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                    if (TextUtils.isEmpty(l)) {
                        encode4 = "";
                    } else {
                        encode4 = URLEncoder.encode(l, "UTF-8");
                    }
                    jSONObject.put("mod", encode4);
                    if (!TextUtils.isEmpty(k)) {
                        str3 = URLEncoder.encode(k, "UTF-8");
                    }
                    jSONObject.put("sysver", str3);
                } else {
                    jSONObject.put("mod", "");
                    jSONObject.put("sysver", "");
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.e.b.Jd().getIp());
        } catch (Throwable unused) {
            return bi.c;
        }
    }

    public static String h() {
        try {
            return c(com.kwad.sdk.e.b.Jd().IT());
        } catch (Throwable unused) {
            return bi.c;
        }
    }

    public static String b(Context context, int i) {
        try {
            if (i == 1) {
                return c(com.kwad.sdk.e.b.Jd().IU());
            }
            return c(com.kwad.sdk.e.b.Jd().IR());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static double c() {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().getLocation());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                return new JSONObject(c).getDouble("longitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    public static String d() {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().IZ());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(c);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return c;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String e() {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().Jb());
            if (!TextUtils.isEmpty(c)) {
                c.startsWith("RISK");
            }
            return c;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static JSONArray f() {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().Ja());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(c);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Jd().IR());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static String a(Context context, int i) {
        try {
            if (i == 1) {
                return c(com.kwad.sdk.e.b.Jd().IU());
            }
            return c(com.kwad.sdk.e.b.Jd().IR());
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String c(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errorCode");
            if (i == 0) {
                str2 = jSONObject.getString("value");
                return str2;
            }
            if (i == 3) {
                return bi.c;
            }
            if (i == 1) {
                return bi.f18330a;
            }
            return bi.d;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String k() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method b2 = b(cls, str, clsArr);
            try {
                b2.setAccessible(true);
                return b2;
            } catch (Throwable unused) {
                return b2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static double b() {
        try {
            String c = c(com.kwad.sdk.e.b.Jd().getLocation());
            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                return new JSONObject(c).getDouble("latitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int lastIndexOf = id.lastIndexOf("/");
        return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
    }

    public static String i() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + HelpFormatter.DEFAULT_OPT_PREFIX + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        return Build.MANUFACTURER + oIX0oI.I0Io.f4096II0xO0 + Build.MODEL + oIX0oI.I0Io.f4095I0Io;
    }

    public static void a(final Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(df.br, 1) == 0) {
            return;
        }
        try {
            JSONObject a2 = new cm(str, ck.l).a(context);
            if (map == null || map.size() <= 0) {
                a2.put("module_section", new JSONObject());
            } else {
                a2.put("module_section", new JSONObject(map));
            }
            final String jSONObject = a2.toString();
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bh.1
                @Override // java.lang.Runnable
                public final void run() {
                    cp.a(context, jSONObject);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static String m() {
        return "ANDROID_PHONE";
    }

    public static String j() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + HelpFormatter.DEFAULT_OPT_PREFIX + locale.getCountry();
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
