package com.baidu.mshield.x6.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.x6.EngineImpl;
import com.tencent.connect.common.II0xO0;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f6448a = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    public static int a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String j;
        String d2;
        String c2;
        String b2;
        String d3;
        String c3;
        synchronized (l.class) {
            try {
                com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
                if (System.currentTimeMillis() - bVar.t() < 300000) {
                    return -1;
                }
                String str5 = null;
                String a2 = new com.baidu.mshield.x6.c.a(context, null).a(str);
                bVar.b(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.c("ret: " + a2);
                if (TextUtils.isEmpty(a2)) {
                    return -1;
                }
                JSONObject jSONObject = new JSONObject(a2);
                try {
                    str2 = jSONObject.optString("status");
                } catch (Throwable th) {
                    f.a(th);
                    str2 = null;
                }
                try {
                    str3 = jSONObject.optString("xid");
                } catch (Throwable th2) {
                    f.a(th2);
                    str3 = null;
                }
                try {
                    str4 = jSONObject.optString("bs");
                } catch (Throwable th3) {
                    f.a(th3);
                    str4 = null;
                }
                if (str2 != null && str2.equals("99999999")) {
                    return -99;
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (com.baidu.mshield.x6.b.b.a()) {
                        b2 = new com.baidu.mshield.x6.a.b(context).c();
                        d3 = b.d(context, "x_o_b_d");
                        c3 = b.c(context, ".x_o_b_d");
                    } else {
                        b2 = new com.baidu.mshield.x6.a.b(context).b();
                        d3 = b.d(context, "x_b_d");
                        c3 = b.c(context, ".x_b_d");
                    }
                    if (!str3.equals(d3) || !str3.equals(c3) || !str3.equals(b2)) {
                        b.a(context, str3);
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (com.baidu.mshield.x6.b.b.a()) {
                        j = new com.baidu.mshield.x6.a.b(context).k();
                        d2 = b.d(context, "g_m_o_bs");
                        c2 = b.c(context, ".g_m_o_bs");
                    } else {
                        j = new com.baidu.mshield.x6.a.b(context).j();
                        d2 = b.d(context, "g_m_b_s");
                        c2 = b.c(context, ".g_m_b_s");
                    }
                    if (!str4.equals(d2) || !str4.equals(c2) || !str4.equals(j)) {
                        b.e(context, str4);
                    }
                }
                try {
                    str5 = jSONObject.optString("ver");
                    if (!TextUtils.isEmpty(str5)) {
                        b.b(context, str5);
                    }
                } catch (Throwable th4) {
                    com.baidu.mshield.b.c.a.c("1" + th4.toString());
                    f.a(th4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    b.b(context, str5);
                }
                return 0;
            } catch (Throwable th5) {
                com.baidu.mshield.b.c.a.c("2" + th5.toString());
                f.a(th5);
                return -1;
            }
        }
    }

    public static void b(Context context, String str) {
        int i;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.mshield.b.c.a.a("sdata:" + str);
            JSONObject optJSONObject = jSONObject.optJSONObject("1");
            if (optJSONObject != null) {
                bVar.a(com.baidu.mshield.x6.a.b.f6427a, optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("2");
            if (optJSONObject2 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.b, optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("3");
            if (optJSONObject3 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.c, optJSONObject3.toString());
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("4");
            if (optJSONObject4 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.d, optJSONObject4.toString());
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("5");
            if (optJSONObject5 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.e, optJSONObject5.toString());
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("6");
            if (optJSONObject6 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.f, optJSONObject6.toString());
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("7");
            if (optJSONObject7 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.g, optJSONObject7.toString());
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("8");
            if (optJSONObject8 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.h, optJSONObject8.toString());
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("9");
            if (optJSONObject9 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.i, optJSONObject9.toString());
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("10");
            if (optJSONObject10 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.j, optJSONObject10.toString());
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("11");
            if (optJSONObject11 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.k, optJSONObject11.toString());
            }
            JSONObject optJSONObject12 = jSONObject.optJSONObject(II0xO0.f26834o0IXXIx);
            if (optJSONObject12 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.l, optJSONObject12.toString());
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject(II0xO0.f26825XoIxOXIXo);
            if (optJSONObject13 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.m, optJSONObject13.toString());
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject(II0xO0.f26773OO0);
            if (optJSONObject14 != null) {
                try {
                    JSONObject optJSONObject15 = optJSONObject14.optJSONObject("2");
                    if (optJSONObject15 != null && optJSONObject15.has("1")) {
                        String optString = optJSONObject15.optString("1");
                        com.baidu.mshield.b.c.a.a("14 prv 1 origin : " + optString);
                        optJSONObject15.put("1", Base64.encodeToString(com.baidu.mshield.b.a.c.a(optString.getBytes()), 0));
                        optJSONObject14.put("2", optJSONObject15);
                    }
                } catch (Throwable th) {
                    f.a(th);
                }
                bVar.a(com.baidu.mshield.x6.a.b.n, optJSONObject14.toString());
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("15");
            if (optJSONObject16 != null) {
                try {
                    JSONObject jSONObject2 = optJSONObject16.getJSONObject("2");
                    if (jSONObject2 != null && (i = jSONObject2.getInt("1")) != bVar.i() && i > 0) {
                        bVar.b(i);
                    }
                } catch (Throwable th2) {
                    f.a(th2);
                }
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject(II0xO0.f26837o0oxo0oI);
            if (optJSONObject17 != null) {
                com.baidu.mshield.b.c.a.a("emulator retry policy:" + optJSONObject17.toString());
                JSONObject optJSONObject18 = optJSONObject17.optJSONObject("2");
                StringBuilder sb = new StringBuilder();
                sb.append("emulator 2 json:");
                sb.append(optJSONObject18);
                com.baidu.mshield.b.c.a.a(sb.toString() == null ? "null" : optJSONObject18.toString());
                if (optJSONObject18 != null) {
                    int optInt = optJSONObject18.optInt("1", 0);
                    com.baidu.mshield.b.c.a.a("emulator set totalCount:" + optInt);
                    bVar.c(optInt);
                }
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("20");
            if (optJSONObject19 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.o, optJSONObject19.toString());
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject(II0xO0.f26892xOOxIO);
            if (optJSONObject20 != null) {
                JSONObject optJSONObject21 = optJSONObject20.optJSONObject("2");
                com.baidu.mshield.b.c.a.b("intervalJson=" + optJSONObject21);
                if (optJSONObject21 != null) {
                    bVar.d(optJSONObject21.optInt("1", 180));
                    bVar.e(optJSONObject21.optInt("2", 360));
                    bVar.f(optJSONObject21.optInt("3", 360));
                    bVar.l(optJSONObject21.optInt("6", 10));
                    bVar.j(optJSONObject21.optInt("7", 10));
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject(II0xO0.f26768O0xxXxI);
            if (optJSONObject22 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.p, optJSONObject22.toString());
            }
            JSONObject optJSONObject23 = jSONObject.optJSONObject(II0xO0.f26868oxOXxoXII);
            if (optJSONObject23 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.q, optJSONObject23.toString());
            }
            JSONObject optJSONObject24 = jSONObject.optJSONObject(II0xO0.f26759IxX00);
            if (optJSONObject24 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.r, optJSONObject24.toString());
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject(II0xO0.f26813XO0o);
            if (optJSONObject25 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.s, optJSONObject25.toString());
            }
            JSONObject optJSONObject26 = jSONObject.optJSONObject("27");
            if (optJSONObject26 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.t, optJSONObject26.toString());
            }
            JSONObject optJSONObject27 = jSONObject.optJSONObject(II0xO0.f26789OxXXx0X);
            if (optJSONObject27 != null) {
                bVar.a(com.baidu.mshield.x6.a.b.u, optJSONObject27.toString());
            }
            bVar.j(f.c());
            com.baidu.mshield.b.c.a.a("pull static Policy for load success");
        } catch (Throwable th3) {
            f.a(th3);
        }
    }

    public static boolean a(Context context) {
        try {
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bVar.K() > 86400000) {
                bVar.k(1);
                bVar.d(currentTimeMillis);
                com.baidu.mshield.b.c.a.a("time limit , reset last time and count");
            }
            int J = bVar.J();
            if (J < bVar.I()) {
                int i = J + 1;
                bVar.k(i);
                com.baidu.mshield.b.c.a.a("count not limit return true , count : " + i);
                return true;
            }
            com.baidu.mshield.b.c.a.a("count limit return false ");
            return false;
        } catch (Throwable th) {
            f.a(th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r8, java.lang.String r9, int r10) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.e.l.a(android.content.Context, java.lang.String, int):int");
    }

    public static String b(Context context) {
        try {
            com.baidu.mshield.x6.c.a aVar = new com.baidu.mshield.x6.c.a(context, null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("4", com.baidu.mshield.b.b.a.a(context));
            JSONObject jSONObject2 = new JSONObject();
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1", bVar.u());
            String y = bVar.y();
            if (TextUtils.isEmpty(y)) {
                String a2 = com.baidu.mshield.b.a.g.a(context);
                com.baidu.mshield.b.c.a.a(" manufacturer: " + a2.toLowerCase());
                if (!TextUtils.isEmpty(a2)) {
                    y = com.baidu.mshield.b.f.e.a(a2.toLowerCase());
                    bVar.p(y);
                }
            }
            jSONObject3.put("2", y);
            String x = bVar.x();
            if (TextUtils.isEmpty(x)) {
                String propertyByType = EngineImpl.getInstance(context).getPropertyByType("mod");
                com.baidu.mshield.b.c.a.a(" model: " + propertyByType.toLowerCase());
                if (!TextUtils.isEmpty(propertyByType)) {
                    x = com.baidu.mshield.b.f.e.a(propertyByType.toLowerCase());
                    bVar.o(x);
                }
            }
            jSONObject3.put("3", x);
            String z = bVar.z();
            if (TextUtils.isEmpty(z)) {
                String lowerCase = Build.ID.toLowerCase();
                com.baidu.mshield.b.c.a.a(" buildId: " + lowerCase);
                z = com.baidu.mshield.b.f.e.a(lowerCase);
                bVar.q(z);
            }
            jSONObject3.put("4", z);
            String B = bVar.B();
            if (TextUtils.isEmpty(B)) {
                String b2 = com.baidu.mshield.b.a.g.b(context);
                com.baidu.mshield.b.c.a.a(" romName: " + b2.toLowerCase());
                if (!TextUtils.isEmpty(b2)) {
                    B = com.baidu.mshield.b.f.e.a(b2.toLowerCase());
                    bVar.s(B);
                }
            }
            jSONObject3.put("5", B);
            String C = bVar.C();
            if (TextUtils.isEmpty(C)) {
                String c2 = com.baidu.mshield.b.a.g.c(context);
                com.baidu.mshield.b.c.a.a(" romVersion: " + c2.toLowerCase());
                if (!TextUtils.isEmpty(c2)) {
                    C = com.baidu.mshield.b.f.e.a(c2.toLowerCase());
                    bVar.t(C);
                }
            }
            jSONObject3.put("6", C);
            String A = bVar.A();
            if (TextUtils.isEmpty(A)) {
                String propertyByType2 = EngineImpl.getInstance(context).getPropertyByType("arv");
                com.baidu.mshield.b.c.a.a(" romVersion: " + propertyByType2.toLowerCase());
                if (!TextUtils.isEmpty(propertyByType2)) {
                    A = com.baidu.mshield.b.f.e.a(propertyByType2.toLowerCase());
                    bVar.r(A);
                }
            }
            jSONObject3.put("7", A);
            String f = f.f(context);
            if (TextUtils.isEmpty(f)) {
                jSONObject3.put("9", "");
            } else {
                try {
                    jSONObject3.put("9", new JSONObject(f).optString("2", ""));
                } catch (Throwable th) {
                    f.a(th);
                }
            }
            jSONObject2.put(com.baidu.mapsdkplatform.comapi.f.f6163a, jSONObject3);
            jSONObject.put("module_section", new JSONArray().put(jSONObject2));
            com.baidu.mshield.b.c.a.a("f/2/sig post body : " + jSONObject.toString());
            return aVar.c(jSONObject.toString());
        } catch (Throwable unused) {
            return "";
        }
    }
}
