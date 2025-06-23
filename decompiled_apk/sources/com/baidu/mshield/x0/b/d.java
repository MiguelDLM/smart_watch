package com.baidu.mshield.x0.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x6.e.k;
import com.google.firebase.crashlytics.buildtools.api.net.proxy.Constants;
import com.kuaishou.weapon.p0.bi;
import com.tencent.connect.common.II0xO0;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f6405a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String[] b = {"L3N5c3RlbS94YmluL3N1", "L3N5c3RlbS9iaW4vc3U", "L3N5c3RlbS94YmluLy5zdQ==", "L3N5c3RlbS9iaW4vLnN1", "L3N5c3RlbS9iaW4vLnN1dg==", "L3N5c3RlbS94YmluLy5zdXY=", "L3N5c3RlbS94YmluL2Jkc3U=", "L3N5c3RlbS9iaW4vYmRzdQ==", "L3N5c3RlbS94YmluL2F1", "L3N5c3RlbS9iaW4vYXU=", "L3N5c3RlbS94YmluL2t1LnN1ZA==", "L3N5c3RlbS9iaW4va3Uuc3Vk", "L3N5c3RlbS9iaW4vLnJncw==", "L3N5c3RlbS94YmluLy5yZ3M=", "L3NiaW4vc3U="};
    public static boolean c = false;

    public static String a(Context context) {
        try {
            return new String(com.baidu.mshield.b.f.d.b(Base64.decode(com.baidu.mshield.x0.d.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0055 -> B:19:0x0058). Please report as a decompilation issue!!! */
    public static String b() {
        InputStreamReader inputStreamReader;
        Throwable th;
        LineNumberReader lineNumberReader;
        String str = "";
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.security_patch").getInputStream());
                try {
                    lineNumberReader = new LineNumberReader(inputStreamReader);
                    String str2 = "";
                    while (str2 != null) {
                        try {
                            str2 = lineNumberReader.readLine();
                            if (str2 != null) {
                                str = str2.trim();
                                break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                a(th);
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th3) {
                                        a(th3);
                                    }
                                }
                                if (lineNumberReader != null) {
                                    lineNumberReader.close();
                                }
                                return str;
                            } finally {
                            }
                        }
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th4) {
                        a(th4);
                    }
                    lineNumberReader.close();
                } catch (Throwable th5) {
                    lineNumberReader = null;
                    th = th5;
                }
            } catch (IOException e) {
                a(e);
            }
        } catch (Throwable th6) {
            inputStreamReader = null;
            th = th6;
            lineNumberReader = null;
        }
        return str;
    }

    public static String c(Context context) {
        try {
            String str = EngineImpl.sAppkey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String d(Context context) {
        try {
            String str = EngineImpl.sSecKey;
            return str != null ? str : "";
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String e(Context context) {
        return "4.2.2";
    }

    public static String f(Context context) {
        try {
            return Long.toString(com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).firstInstallTime);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void g(Context context) {
        String c2;
        PackageInfo a2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        com.baidu.mshield.b.c.a.b("setAliveDate begin");
        int i = 0;
        try {
            a2 = com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 16384);
            int i2 = a2.applicationInfo.flags;
            if ((i2 & 1) == 1 || (i2 & 128) == 128) {
                i = 1;
            }
        } catch (Throwable th) {
            a(th);
        }
        try {
            com.baidu.mshield.b.f.e.a(new File(a2.applicationInfo.sourceDir));
        } catch (Throwable unused) {
            try {
                jSONObject2.put("0", "0");
                jSONObject2.put("15", Integer.toString(i));
                jSONObject2.put(II0xO0.f26773OO0, f(context));
                jSONObject2.put("16", b());
                jSONObject2.put(II0xO0.f26886xIXX, "");
                jSONObject2.put("18", h(context));
                jSONObject2.put(II0xO0.f26837o0oxo0oI, i(context));
                jSONObject2.put("990", com.baidu.xclient.gdid.a.b(context));
                jSONObject2.put("989", e(context));
                jSONObject2.put("993", g.b(context));
                jSONObject2.put("995", i.a(context));
                if (a(context, "plc31", true)) {
                    jSONObject2.put("997", j(context));
                }
                jSONObject2.put("998", g.a(context));
                if (TextUtils.isEmpty(com.baidu.mshield.utility.c.c(context))) {
                    c2 = com.baidu.mshield.utility.c.d(context);
                } else {
                    c2 = com.baidu.mshield.utility.c.c(context);
                }
                jSONObject2.put("999", c2);
                jSONObject2.put("981", new com.baidu.mshield.x0.j.c(context).c());
                jSONObject.put("0", new JSONObject().put("1001003", jSONObject2));
                com.baidu.mshield.b.c.a.b("setAliveDate begin to report" + jSONObject.toString());
                a(context, jSONObject.toString());
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    public static String h(Context context) {
        return com.baidu.mshield.b.a.d.c(context);
    }

    public static int i(Context context) {
        try {
            return com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static String j(Context context) {
        try {
            return com.baidu.xclient.gdid.a.a(context);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void k(Context context) {
        try {
            synchronized (d.class) {
                try {
                    if (c) {
                        return;
                    }
                    com.baidu.mshield.x0.b.a.d.a().a(new e(context));
                } finally {
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void l(Context context) {
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
            List<com.baidu.mshield.x0.j.b> c2 = aVar.c();
            if (c2 == null) {
                return;
            }
            com.baidu.mshield.b.c.a.b("re_con==" + c2.size());
            for (com.baidu.mshield.x0.j.b bVar : c2) {
                if (a(context, aVar.d(), bVar.b)) {
                    a(context, bVar);
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void m(Context context) {
        com.baidu.mshield.x0.c.a.a().a(new f(context));
    }

    public static boolean n(Context context) {
        try {
            if (com.baidu.mshield.b.e.a.b(context, "adb_enabled") <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static JSONObject o(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 0;
            int i2 = 0;
            for (String str : b) {
                if (new File(new String(Base64.decode(str, 0))).exists()) {
                    jSONObject.put(Integer.toString(i2), "1");
                } else {
                    jSONObject.put(Integer.toString(i2), "0");
                }
                i2++;
            }
            try {
                File file = new File(new String(Base64.decode("L3NiaW5fb3JpZw==", 0)));
                if (file.exists() && file.isDirectory()) {
                    jSONObject.put(Integer.toString(i2), "0");
                    String[] list = file.list();
                    int length = list.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str2 = list[i];
                        com.baidu.mshield.b.c.a.b(str2 + " exits!!");
                        if (str2.startsWith(bi.y)) {
                            jSONObject.put(Integer.toString(i2), "1");
                            break;
                        }
                        i++;
                    }
                } else {
                    jSONObject.put(Integer.toString(i2), "0");
                }
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static String p(Context context) {
        try {
            File file = new File(context.getFilesDir(), com.baidu.mshield.x0.d.f6411a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String e() {
        String property = System.getProperty(Constants.HTTP_PROXY_HOST_PROP);
        return TextUtils.isEmpty(property) ? "" : property;
    }

    public static String c() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String d() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static byte[] a() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f6405a.toCharArray();
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

    public static void c(Context context, String str) {
        try {
            Report.getInstance(context).sr(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String f() {
        try {
            return new String(com.baidu.mshield.b.f.d.b(Base64.decode(h.b, 2), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String a(long j, String str) {
        if (j >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j));
                }
            } catch (Throwable th) {
                a(th);
            }
        }
        return "";
    }

    public static void a(Context context, String str) {
        try {
            Report.getInstance(context).w(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static void b(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.sAppkey;
            cVar.c = 0;
            String str3 = com.baidu.mshield.x0.d.d;
            String str4 = EngineImpl.sLoadVersion;
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("1", cVar.f6404a);
                jSONObject2.put("2", cVar.b);
                jSONObject2.put("3", String.valueOf(c(context)));
                jSONObject2.put("4", cVar.c);
                jSONObject2.put("5", cVar.d);
                jSONObject2.put("6", cVar.e);
                jSONObject2.put("7", cVar.f);
                jSONObject2.put("8", com.baidu.mshield.x0.d.d);
                jSONObject2.put("9", EngineImpl.sLoadVersion);
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONArray);
                c(context, jSONObject.toString());
            } catch (Throwable th) {
                a(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            Report.getInstance(context).i(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str, String str2, long j) {
        try {
            return com.baidu.mshield.b.f.e.a(str + j + str2);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            String a2 = new com.baidu.mshield.x0.j.a(context).a(str);
            if (!TextUtils.isEmpty(a2)) {
                return new JSONObject(a2).optInt("1") == 1;
            }
        } catch (Throwable th) {
            a(th);
        }
        return z;
    }

    public static boolean a(Context context, String str, boolean z, com.baidu.mshield.x0.j.a aVar) {
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.j.a(context);
            } catch (Throwable th) {
                a(th);
            }
        }
        String a2 = aVar.a(str);
        if (!TextUtils.isEmpty(a2)) {
            return new JSONObject(a2).optInt("1") == 1;
        }
        return z;
    }

    public static void a(Context context, String str, c cVar, com.baidu.mshield.x0.j.a aVar) {
        if (cVar == null) {
            return;
        }
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.j.a(context);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        String a2 = aVar.a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(a2);
        cVar.e = jSONObject.optInt("2");
        cVar.d = jSONObject.optInt("3");
        cVar.f = jSONObject.optInt("4");
    }

    public static boolean b(Context context) {
        try {
            if (!k.a(context, new String[]{com.kuaishou.weapon.p0.g.b})) {
                return true;
            }
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

    public static void a(Context context, JSONArray jSONArray, String str) {
        try {
            c cVar = new c();
            String str2 = EngineImpl.sAppkey;
            cVar.c = 0;
            String str3 = com.baidu.mshield.x0.d.d;
            String str4 = EngineImpl.sLoadVersion;
            a(context, cVar, jSONArray, str, true);
        } catch (Throwable th) {
            a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(android.content.Context r11, com.baidu.mshield.x0.j.b r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.b.d.b(android.content.Context, com.baidu.mshield.x0.j.b, java.lang.String):org.json.JSONObject");
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str) {
        a(context, cVar, jSONArray, str, true);
    }

    public static void a(Context context, c cVar, JSONArray jSONArray, String str, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0 || cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                jSONObject3.put("991", j(context));
                jSONObject3.put("995", i.a(context));
                jSONObject3.put("998", g.a(context));
                jSONObject3.put("989", e(context));
            }
            jSONObject2.put("0", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("1", cVar.f6404a);
            jSONObject2.put("2", cVar.b);
            jSONObject2.put("3", String.valueOf(c(context)));
            jSONObject2.put("4", cVar.c);
            jSONObject2.put("5", cVar.d);
            jSONObject2.put("6", cVar.e);
            jSONObject2.put("7", cVar.f);
            jSONObject2.put("8", com.baidu.mshield.x0.d.d);
            jSONObject2.put("9", EngineImpl.sLoadVersion);
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONArray);
            b(context, jSONObject.toString());
        } catch (Throwable th) {
            a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r12, java.lang.String r13, org.json.JSONArray r14) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = " "
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La9
            java.lang.String r5 = c(r12)     // Catch: java.lang.Throwable -> La9
            java.lang.String r6 = com.baidu.mshield.x0.d.d     // Catch: java.lang.Throwable -> La9
            java.lang.String r7 = com.baidu.mshield.x0.EngineImpl.sLoadVersion     // Catch: java.lang.Throwable -> La9
            r8 = 0
            java.lang.String r9 = r12.getPackageName()     // Catch: java.lang.Throwable -> L33
            android.content.pm.PackageInfo r9 = com.baidu.mshield.b.e.c.a(r12, r9, r8)     // Catch: java.lang.Throwable -> L33
            java.lang.String r9 = r9.versionName     // Catch: java.lang.Throwable -> L33
            android.content.pm.ApplicationInfo r10 = r12.getApplicationInfo()     // Catch: java.lang.Throwable -> L31
            android.content.pm.PackageManager r11 = r12.getPackageManager()     // Catch: java.lang.Throwable -> L31
            java.lang.CharSequence r10 = r10.loadLabel(r11)     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r10.toString()     // Catch: java.lang.Throwable -> L31
            goto L38
        L31:
            r10 = move-exception
            goto L35
        L33:
            r10 = move-exception
            r9 = r0
        L35:
            a(r10)     // Catch: java.lang.Throwable -> La9
        L38:
            java.lang.String r10 = "1"
            r2.put(r10, r0)     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = "2"
            com.baidu.mshield.x0.EngineImpl r10 = com.baidu.mshield.x0.EngineImpl.getInstance(r12)     // Catch: java.lang.Throwable -> La9
            java.lang.String r11 = "p"
            java.lang.String r10 = r10.getPropertyByType(r11)     // Catch: java.lang.Throwable -> La9
            r2.put(r0, r10)     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = "3"
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = "4"
            java.lang.String r9 = com.baidu.mshield.utility.c.a(r12)     // Catch: java.lang.Throwable -> La9
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = "5"
            r2.put(r0, r13)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "6"
            r2.put(r13, r3)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "7"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "8"
            r2.put(r13, r5)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "9"
            r2.put(r13, r6)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "10"
            r2.put(r13, r7)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "11"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "12"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "13"
            r2.put(r13, r1)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "14"
            com.baidu.mshield.x0.EngineImpl r0 = com.baidu.mshield.x0.EngineImpl.getInstance(r12)     // Catch: java.lang.Throwable -> La9
            java.lang.String r1 = "ws"
            java.lang.String r0 = r0.getPropertyByType(r1)     // Catch: java.lang.Throwable -> La9
            r2.put(r13, r0)     // Catch: java.lang.Throwable -> La9
            java.lang.String r13 = "plc31"
            boolean r13 = a(r12, r13, r8)     // Catch: java.lang.Throwable -> La9
            if (r13 == 0) goto Lab
            java.lang.String r13 = "997"
            java.lang.String r0 = j(r12)     // Catch: java.lang.Throwable -> La9
            r2.put(r13, r0)     // Catch: java.lang.Throwable -> La9
            goto Lab
        La9:
            r12 = move-exception
            goto Lba
        Lab:
            java.lang.String r13 = "989"
            java.lang.String r12 = e(r12)     // Catch: java.lang.Throwable -> La9
            r2.put(r13, r12)     // Catch: java.lang.Throwable -> La9
            java.lang.String r12 = "module_section"
            r2.put(r12, r14)     // Catch: java.lang.Throwable -> La9
            goto Lbd
        Lba:
            a(r12)
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.b.d.a(android.content.Context, java.lang.String, org.json.JSONArray):org.json.JSONObject");
    }

    public static int b(Context context, String str) {
        try {
            Report.getInstance(context).s(str);
            return 0;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.d.a(str.getBytes(), com.baidu.mshield.b.f.a.a(16)), 0);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0107 A[Catch: all -> 0x0110, TryCatch #1 {all -> 0x0110, blocks: (B:13:0x0050, B:15:0x0057, B:17:0x006b, B:19:0x0074, B:21:0x0087, B:23:0x0090, B:25:0x0097, B:27:0x00a3, B:29:0x00ac, B:31:0x00c9, B:33:0x00d2, B:35:0x00db, B:37:0x00e4, B:39:0x00ed, B:41:0x00f6, B:43:0x00ff, B:45:0x0107, B:46:0x0113, B:48:0x01ad, B:51:0x01b5, B:55:0x01be, B:84:0x01aa, B:90:0x004d, B:57:0x011e, B:59:0x012b, B:61:0x0139, B:62:0x0152, B:65:0x015c, B:67:0x0165, B:69:0x0176, B:70:0x017f, B:72:0x0186, B:74:0x018f, B:76:0x0198, B:78:0x01a1, B:81:0x017b), top: B:89:0x004d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b5 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #1 {all -> 0x0110, blocks: (B:13:0x0050, B:15:0x0057, B:17:0x006b, B:19:0x0074, B:21:0x0087, B:23:0x0090, B:25:0x0097, B:27:0x00a3, B:29:0x00ac, B:31:0x00c9, B:33:0x00d2, B:35:0x00db, B:37:0x00e4, B:39:0x00ed, B:41:0x00f6, B:43:0x00ff, B:45:0x0107, B:46:0x0113, B:48:0x01ad, B:51:0x01b5, B:55:0x01be, B:84:0x01aa, B:90:0x004d, B:57:0x011e, B:59:0x012b, B:61:0x0139, B:62:0x0152, B:65:0x015c, B:67:0x0165, B:69:0x0176, B:70:0x017f, B:72:0x0186, B:74:0x018f, B:76:0x0198, B:78:0x01a1, B:81:0x017b), top: B:89:0x004d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01be A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #1 {all -> 0x0110, blocks: (B:13:0x0050, B:15:0x0057, B:17:0x006b, B:19:0x0074, B:21:0x0087, B:23:0x0090, B:25:0x0097, B:27:0x00a3, B:29:0x00ac, B:31:0x00c9, B:33:0x00d2, B:35:0x00db, B:37:0x00e4, B:39:0x00ed, B:41:0x00f6, B:43:0x00ff, B:45:0x0107, B:46:0x0113, B:48:0x01ad, B:51:0x01b5, B:55:0x01be, B:84:0x01aa, B:90:0x004d, B:57:0x011e, B:59:0x012b, B:61:0x0139, B:62:0x0152, B:65:0x015c, B:67:0x0165, B:69:0x0176, B:70:0x017f, B:72:0x0186, B:74:0x018f, B:76:0x0198, B:78:0x01a1, B:81:0x017b), top: B:89:0x004d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONArray a(android.content.Context r12, com.baidu.mshield.x0.j.b r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.b.d.a(android.content.Context, com.baidu.mshield.x0.j.b, java.lang.String):org.json.JSONArray");
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(context.getPackageName()) || str2.equals(com.baidu.mshield.x0.d.f6411a)) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str2.equals(jSONArray.get(i))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.j.b bVar) {
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
            String c2 = aVar.c(bVar.d);
            String d = d();
            if (c2.equals(d)) {
                return;
            }
            String d2 = aVar.d(bVar.d);
            if (!new com.baidu.mshield.x0.g.c(context, null).a(a(context, bVar, d2).toString())) {
                b(context, bVar, d2);
            }
            aVar.c(bVar.d, d);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.d.b(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, com.baidu.mshield.x0.j.a aVar, String str, String str2) {
        if (aVar == null) {
            try {
                aVar = new com.baidu.mshield.x0.j.a(context);
            } catch (Throwable th) {
                a(th);
            }
        }
        String a2 = aVar.a(str);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject(a2).getJSONObject("5");
            if (jSONObject.has(str2)) {
                return jSONObject.optString(str2, "");
            }
        }
        return "";
    }

    public static JSONArray a(JSONArray jSONArray, int i) {
        JSONArray jSONArray2 = new JSONArray();
        try {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != i) {
                    jSONArray2.put(jSONArray.get(i2));
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return jSONArray2;
    }
}
