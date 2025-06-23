package com.baidu.mshield.x6.e;

import android.content.Context;
import android.nfc.NfcManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.MH;
import com.baidu.mshield.x6.EngineImpl;
import com.huawei.openalliance.ad.constant.x;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class f {
    public static String a() {
        String str = EngineImpl.sAppkey;
        return str != null ? str : "";
    }

    public static String b() {
        String str = EngineImpl.sSecKey;
        return str != null ? str : "";
    }

    public static String c() {
        try {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return MH.getVersion(context);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(l.d)) {
            return l.d;
        }
        g(context);
        return l.d;
    }

    public static String f(Context context) {
        try {
            if (a(context, false)) {
                return new com.baidu.mshield.x6.a.b(context).N();
            }
            return l.e;
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void g(Context context) {
        try {
            String b = l.b(context);
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            if (!TextUtils.isEmpty(b)) {
                JSONObject jSONObject = new JSONObject(b);
                try {
                    String optString = jSONObject.optString("sig");
                    if (!TextUtils.isEmpty(optString)) {
                        String a2 = com.baidu.mshield.b.f.e.a(optString);
                        l.c = a2;
                        bVar.n(a2);
                        String str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(optString.getBytes(), 0)), "utf-8");
                        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzSig : " + str);
                        l.f6448a = str;
                    } else {
                        com.baidu.mshield.b.c.a.a("sig sdata is empty ");
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("sgs");
                    if (optJSONObject != null) {
                        String optString2 = optJSONObject.optString("3", "");
                        l.b = optString2;
                        com.baidu.mshield.b.c.a.a("requestSgsPolicy : " + optString2);
                    }
                } catch (Throwable th) {
                    a(th);
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("drf");
                    if (optJSONObject2 != null) {
                        l.d = optJSONObject2.toString();
                        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzDrf : " + new String(com.baidu.mshield.b.a.c.b(Base64.decode(optJSONObject2.optString("1").getBytes(), 0)), "utf-8"));
                        bVar.m(optJSONObject2.optString("2"));
                    } else {
                        l.d = "";
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
                bVar.a(System.currentTimeMillis(), true);
                try {
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("rmf");
                    if (optJSONObject3 != null) {
                        if (a(context, false)) {
                            bVar.x(optJSONObject3.toString());
                            l.e = "";
                        } else {
                            l.e = optJSONObject3.toString();
                            bVar.O();
                        }
                        com.baidu.mshield.b.c.a.a("requestSigPolicy ungzRmf : " + new String(com.baidu.mshield.b.a.c.b(Base64.decode(optJSONObject3.optString("1").getBytes(), 0)), "utf-8"));
                        return;
                    }
                    l.e = "";
                    return;
                } catch (Throwable th3) {
                    a(th3);
                    return;
                }
            }
            bVar.a(System.currentTimeMillis(), false);
        } catch (Throwable th4) {
            a(th4);
        }
    }

    public static String h(Context context) {
        String str = "";
        try {
            com.baidu.mshield.x6.a.c cVar = new com.baidu.mshield.x6.a.c(context);
            str = cVar.b();
            if (TextUtils.isEmpty(str)) {
                com.baidu.mshield.b.c.a.a("cloud token is empty");
                str = cVar.a();
            }
            com.baidu.mshield.b.c.a.a("getUserHoldToken : " + str);
        } catch (Throwable th) {
            a(th);
        }
        return str;
    }

    public static boolean i(Context context) {
        try {
            if (((NfcManager) context.getSystemService("nfc")).getDefaultAdapter() != null) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static String j(Context context) {
        try {
        } catch (Throwable th) {
            a(th);
        }
        if (!TextUtils.isEmpty(l.f6448a)) {
            return l.f6448a;
        }
        g(context);
        return l.f6448a;
    }

    public static String a(Context context) {
        try {
            return new String(h.b(Base64.decode(g.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context) {
        try {
            String a2 = com.baidu.mshield.x6.b.a.a(context);
            String b = com.baidu.mshield.x6.b.a.b(context);
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            if (!TextUtils.isEmpty(a2)) {
                bVar.d(com.baidu.mshield.b.f.e.a(a2));
            }
            if (TextUtils.isEmpty(b)) {
                return;
            }
            bVar.e(com.baidu.mshield.b.f.e.a(b));
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String d() {
        return l.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0078 A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #2 {all -> 0x007f, blocks: (B:6:0x002f, B:8:0x0036, B:10:0x004a, B:12:0x0062, B:15:0x0078, B:16:0x00a8, B:18:0x00b9, B:21:0x00cb, B:23:0x00d4, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x0099, B:36:0x00a2, B:40:0x002b), top: B:39:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081 A[Catch: all -> 0x007f, TryCatch #2 {all -> 0x007f, blocks: (B:6:0x002f, B:8:0x0036, B:10:0x004a, B:12:0x0062, B:15:0x0078, B:16:0x00a8, B:18:0x00b9, B:21:0x00cb, B:23:0x00d4, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x0099, B:36:0x00a2, B:40:0x002b), top: B:39:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r8, org.json.JSONObject r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = r8.getPackageName()     // Catch: java.lang.Throwable -> L29
            android.content.pm.PackageInfo r4 = com.baidu.mshield.b.e.c.a(r8, r4, r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = r4.versionName     // Catch: java.lang.Throwable -> L29
            android.content.pm.ApplicationInfo r5 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L27
            android.content.pm.PackageManager r6 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L27
            java.lang.CharSequence r5 = r5.loadLabel(r6)     // Catch: java.lang.Throwable -> L27
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L27
            goto L2f
        L27:
            r5 = move-exception
            goto L2b
        L29:
            r5 = move-exception
            r4 = r2
        L2b:
            a(r5)     // Catch: java.lang.Throwable -> L7f
            r5 = r2
        L2f:
            java.lang.String r6 = "1"
            r12.put(r6, r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = "2"
            com.baidu.mshield.x6.EngineImpl r6 = com.baidu.mshield.x6.EngineImpl.getInstance(r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = "p"
            java.lang.String r6 = r6.getPropertyByType(r7)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = "3"
            r12.put(r5, r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "4"
            java.lang.String r5 = com.baidu.mshield.utility.c.a(r8)     // Catch: java.lang.Throwable -> L7f
            r12.put(r4, r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "5"
            r12.put(r4, r10)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "6"
            r12.put(r10, r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "7"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "8"
            java.lang.String r0 = a()     // Catch: java.lang.Throwable -> L7f
            r12.put(r10, r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = com.baidu.mshield.x6.EngineImpl.sLoadVersion     // Catch: java.lang.Throwable -> L7f
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = "0"
            r4 = 1
            java.lang.String r5 = "10"
            java.lang.String r6 = "9"
            if (r0 == 0) goto L81
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r1)     // Catch: java.lang.Throwable -> L7f
            goto La8
        L7f:
            r8 = move-exception
            goto Le1
        L81:
            java.lang.String r0 = "/"
            java.lang.String[] r10 = r10.split(r0)     // Catch: java.lang.Throwable -> L7f
            int r0 = r10.length     // Catch: java.lang.Throwable -> L7f
            r7 = 2
            if (r0 != r7) goto L96
            r11 = r10[r3]     // Catch: java.lang.Throwable -> L7f
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r10 = r10[r4]     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r10)     // Catch: java.lang.Throwable -> L7f
            goto La8
        L96:
            int r0 = r10.length     // Catch: java.lang.Throwable -> L7f
            if (r0 != r4) goto La2
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r10 = r10[r3]     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r10)     // Catch: java.lang.Throwable -> L7f
            goto La8
        La2:
            r12.put(r6, r11)     // Catch: java.lang.Throwable -> L7f
            r12.put(r5, r1)     // Catch: java.lang.Throwable -> L7f
        La8:
            java.lang.String r10 = "11"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "12"
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "13"
            r12.put(r10, r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r10 = "14"
            com.baidu.mshield.x6.EngineImpl r11 = com.baidu.mshield.x6.EngineImpl.getInstance(r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = "ws"
            java.lang.String r11 = r11.getPropertyByType(r0)     // Catch: java.lang.Throwable -> L7f
            r12.put(r10, r11)     // Catch: java.lang.Throwable -> L7f
            if (r9 == 0) goto Le4
            java.lang.String r10 = "989"
            java.lang.String r8 = d(r8)     // Catch: java.lang.Throwable -> L7f
            r9.put(r10, r8)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r8 = "module_section"
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7f
            r10.<init>()     // Catch: java.lang.Throwable -> L7f
            org.json.JSONArray r9 = r10.put(r9)     // Catch: java.lang.Throwable -> L7f
            r12.put(r8, r9)     // Catch: java.lang.Throwable -> L7f
            goto Le4
        Le1:
            a(r8)
        Le4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.e.f.a(android.content.Context, org.json.JSONObject, java.lang.String, java.lang.String, boolean):org.json.JSONObject");
    }

    public static String e() {
        return l.b;
    }

    public static void c(Context context) {
        try {
            b.b(context);
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            long currentTimeMillis = System.currentTimeMillis();
            long i = bVar.i() * 60000;
            long r = bVar.r();
            if (!bVar.h() || currentTimeMillis - r > i) {
                com.baidu.mshield.x6.d.i.a(context).a(3);
            }
            if (!bVar.g()) {
                b(context);
                bVar.c(true);
            }
            com.baidu.mshield.x6.d.i.a(context).a(1, false);
            if (bVar.o()) {
                return;
            }
            com.baidu.mshield.x6.d.i.a(context).b();
        } catch (Throwable th) {
            a(th);
        }
    }

    public static String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(com.baidu.mshield.b.f.a.a(str.getBytes(), com.baidu.mshield.b.f.a.a()), 0);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            try {
                if (th2 instanceof UnknownHostException) {
                    return "";
                }
            } catch (Throwable th3) {
                a(th3);
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2.replaceAll("\t", x.aL).replaceAll("\n", x.aL);
    }

    public static String c(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(com.baidu.mshield.b.f.a.b(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a()));
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static int a(String str) {
        int i = -1;
        if (str != null && str != "") {
            try {
                char[] charArray = str.trim().toCharArray();
                int i2 = 0;
                while (i2 < charArray.length - 1) {
                    if (i2 == 0) {
                        i = Character.getNumericValue(charArray[i2]);
                    } else {
                        char c = charArray[i2];
                        i2++;
                        int numericValue = Character.getNumericValue(charArray[i2]);
                        if (c == '%') {
                            i %= numericValue;
                        } else if (c != '&') {
                            if (c != '*') {
                                if (c == '+') {
                                    i += numericValue;
                                } else if (c == '-') {
                                    i -= numericValue;
                                } else if (c == '/') {
                                    i /= numericValue;
                                } else if (c == '^') {
                                    i ^= numericValue;
                                } else if (c != 'x') {
                                    i = c != '|' ? numericValue : i | numericValue;
                                }
                            }
                            i *= numericValue;
                        } else {
                            i &= numericValue;
                        }
                    }
                    i2++;
                }
                com.baidu.mshield.b.c.a.a("illegalArithmetic expr：" + str + "，res：" + i);
            } catch (Throwable th) {
                a(th);
            }
            return i;
        }
        com.baidu.mshield.b.c.a.a("illegalArithmetic expr is empty : " + str);
        return -1;
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str, boolean z) {
        return a(context, jSONObject, str, "mshield_x6", z);
    }

    public static String a(String str, String str2, long j) throws UnsupportedEncodingException {
        return com.baidu.mshield.b.f.e.a(str + j + str2);
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            String a2 = new com.baidu.mshield.x6.a.a(context).a(str);
            if (!TextUtils.isEmpty(a2)) {
                return new JSONObject(a2).optInt("1") == 1;
            }
        } catch (Throwable th) {
            a(th);
        }
        return z;
    }

    public static boolean a(Context context, boolean z) {
        try {
            String a2 = a(context, "plc104");
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2).getJSONObject("5");
                if (jSONObject.has("34")) {
                    return jSONObject.optInt("34") == 1;
                }
            }
        } catch (Throwable th) {
            a(th);
        }
        return z;
    }

    public static String a(Context context, String str) {
        try {
            return new com.baidu.mshield.x6.a.a(context).a(str);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }
}
