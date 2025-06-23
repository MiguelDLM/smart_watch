package com.ss.android.socialbase.appdownloader.f;

import OI0.oxoX;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.x;
import com.ss.android.socialbase.appdownloader.g;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import oOoIIO0.oIX0oI;

/* loaded from: classes13.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f26191a = null;
    public static String b = "";
    public static String c = null;
    private static String d = "";
    private static String e;
    private static String f;
    private static String g;
    private static Boolean h;

    public static boolean a() {
        return a("EMUI") || a("MAGICUI");
    }

    public static boolean b() {
        return a("MAGICUI");
    }

    public static boolean c() {
        return a("MIUI");
    }

    public static boolean d() {
        return a(oIX0oI.f32059ooOOo0oXI);
    }

    public static boolean e() {
        r();
        return a(f26191a);
    }

    public static boolean f() {
        return a("FLYME");
    }

    public static boolean g() {
        return a("SAMSUNG");
    }

    public static String h() {
        if (e == null) {
            a("");
        }
        return e;
    }

    public static String i() {
        if (f == null) {
            a("");
        }
        return f;
    }

    public static String j() {
        if (c == null) {
            a("");
        }
        return c;
    }

    @NonNull
    public static String k() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    @NonNull
    public static String l() {
        String str = Build.DISPLAY;
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static boolean m() {
        s();
        return "V10".equals(g);
    }

    public static boolean n() {
        s();
        return "V11".equals(g);
    }

    public static boolean o() {
        s();
        return "V12".equals(g);
    }

    public static boolean p() {
        if (h == null) {
            h = Boolean.valueOf(d.g().equals("harmony"));
        }
        return h.booleanValue();
    }

    public static boolean q() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    private static void r() {
        if (TextUtils.isEmpty(f26191a)) {
            com.ss.android.socialbase.downloader.downloader.c.G();
            f26191a = com.ss.android.socialbase.downloader.constants.e.b;
            d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.c + "rom";
            b = "com." + com.ss.android.socialbase.downloader.constants.e.c + ".market";
        }
    }

    private static void s() {
        if (g == null) {
            try {
                g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = g;
            if (str == null) {
                str = "";
            }
            g = str;
        }
    }

    public static boolean a(String str) {
        r();
        String str2 = e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f = d2;
        if (!TextUtils.isEmpty(d2)) {
            e = "MIUI";
            c = "com.xiaomi.market";
            g = f;
        } else {
            String d3 = d(oxoX.f1509II0XooXoX);
            f = d3;
            if (!TextUtils.isEmpty(d3)) {
                String str3 = q() ? "MAGICUI" : "EMUI";
                e = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    c = "com.hihonor.appmarket";
                } else {
                    c = x.Y;
                }
            } else {
                String d4 = d("ro.build.version.magic");
                f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    e = "MAGICUI";
                    c = "com.hihonor.appmarket";
                } else {
                    String d5 = d(d);
                    f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        e = f26191a;
                        if (g.a(b) > -1) {
                            c = b;
                        } else {
                            c = "com.heytap.market";
                        }
                    } else {
                        String d6 = d("ro.vivo.os.version");
                        f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            e = oIX0oI.f32059ooOOo0oXI;
                            c = "com.bbk.appstore";
                        } else {
                            String d7 = d("ro.smartisan.version");
                            f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                e = "SMARTISAN";
                                c = "com.smartisanos.appstore";
                            } else {
                                String d8 = d("ro.gn.sv.version");
                                f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    e = "QIONEE";
                                    c = "com.gionee.aora.market";
                                } else {
                                    String d9 = d("ro.lenovo.lvp.version");
                                    f = d9;
                                    if (!TextUtils.isEmpty(d9)) {
                                        e = "LENOVO";
                                        c = "com.lenovo.leos.appstore";
                                    } else if (k().toUpperCase().contains("SAMSUNG")) {
                                        e = "SAMSUNG";
                                        c = "com.sec.android.app.samsungapps";
                                    } else if (k().toUpperCase().contains("ZTE")) {
                                        e = "ZTE";
                                        c = "zte.com.market";
                                    } else if (k().toUpperCase().contains("NUBIA")) {
                                        e = "NUBIA";
                                        c = "cn.nubia.neostore";
                                    } else if (l().toUpperCase().contains("FLYME")) {
                                        e = "FLYME";
                                        c = "com.meizu.mstore";
                                        f = l();
                                    } else if (k().toUpperCase().contains("ONEPLUS")) {
                                        e = "ONEPLUS";
                                        f = d("ro.rom.version");
                                        if (g.a(b) > -1) {
                                            c = b;
                                        } else {
                                            c = "com.heytap.market";
                                        }
                                    } else {
                                        e = k().toUpperCase();
                                        c = "";
                                        f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            com.ss.android.socialbase.downloader.i.f.a(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            com.ss.android.socialbase.downloader.i.f.a(bufferedReader);
            return null;
        }
    }

    public static String c(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return c(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return b(str);
            }
        }
        return b(str);
    }
}
