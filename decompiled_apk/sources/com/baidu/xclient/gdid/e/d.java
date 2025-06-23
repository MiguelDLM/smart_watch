package com.baidu.xclient.gdid.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sec.privacy.d.h;
import com.tencent.connect.common.II0xO0;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f10232a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static long b = 3600000;

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1", c(context));
            jSONObject2.put("2", com.baidu.xclient.gdid.c.a().a(context));
            jSONObject2.put("3", b(context));
            jSONObject2.put("4", com.baidu.mshield.b.b.a.a(context));
            jSONObject2.put("5", str);
            jSONObject2.put("6", System.currentTimeMillis());
            jSONObject2.put("7", "");
            jSONObject2.put("8", com.baidu.xclient.gdid.c.c);
            jSONObject2.put("9", com.baidu.xclient.gdid.g.b);
            jSONObject2.put("10", com.baidu.xclient.gdid.g.c);
            jSONObject2.put("11", "");
            jSONObject2.put(II0xO0.f26834o0IXXIx, "");
            jSONObject2.put(II0xO0.f26825XoIxOXIXo, 1);
            jSONObject2.put(II0xO0.f26773OO0, com.baidu.xclient.gdid.c.a().c("ws"));
            jSONObject2.put("20", com.baidu.mshield.b.b.a.b(context));
            jSONObject2.put("21", com.baidu.mshield.b.b.a.c(context));
            jSONObject2.put(II0xO0.f26892xOOxIO, "");
            jSONObject2.put(II0xO0.f26768O0xxXxI, "");
            jSONObject2.put("30", "");
            jSONObject2.put("module_section", jSONArray);
            return jSONObject2;
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static String b() {
        try {
            return h.a("ro.build.fingerprint", "");
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static int c() {
        try {
            File file = new File("/sys/devices/system/cpu");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles(new e());
                if (listFiles == null) {
                    return 0;
                }
                return listFiles.length;
            }
            return -1;
        } catch (Throwable th) {
            a(th);
            return -1;
        }
    }

    public static Pair<String, String> d(Context context) {
        Pair<String, String> f = com.baidu.sec.privacy.c.a.a(context).f();
        return f == null ? new Pair<>("", "") : f;
    }

    public static void a(Throwable th) {
    }

    public static String b(Context context) {
        String str = "";
        try {
            PackageInfo a2 = com.baidu.mshield.b.e.c.a(context, com.baidu.xclient.gdid.c.a().a(context), 0);
            String str2 = a2 != null ? a2.versionName : "";
            try {
                return TextUtils.isEmpty(str2) ? "" : str2;
            } catch (Throwable th) {
                str = str2;
                th = th;
                a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(Context context) {
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo a2 = com.baidu.mshield.b.e.b.a(context);
            if (a2 == null) {
                return false;
            }
            return a2.isConnected();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static byte[] a() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f10232a.toCharArray();
            for (int i = 0; i < 16; i++) {
                int nextInt = new Random().nextInt(62);
                if (nextInt >= 0 && nextInt < charArray.length) {
                    cArr[i] = charArray[nextInt];
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return new String(cArr).getBytes();
    }
}
