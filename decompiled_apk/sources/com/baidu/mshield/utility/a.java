package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.baidu.mshield.MyProvider;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.rp.Report;
import com.google.android.exoplayer2.C;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.tencent.connect.common.II0xO0;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f6388a = null;
    public static String b = null;
    public static String c = "";
    public static String d = "";
    public static int e = -1;

    public static String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("host=");
            String str = f.f6392a;
            sb.append(str);
            com.baidu.mshield.b.c.a.b(sb.toString());
            return new String(F.getInstance().ad(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] b(Context context) {
        String str = f6388a;
        String str2 = b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by in memory!");
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String d2 = com.baidu.mshield.sharedpreferences.a.a(context).d();
            if (!TextUtils.isEmpty(d2)) {
                String[] split = d2.split(HelpFormatter.DEFAULT_OPT_PREFIX);
                if (split.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  from Info");
                    return split;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String e2 = com.baidu.mshield.sharedpreferences.a.a(context).e();
            if (!TextUtils.isEmpty(e2)) {
                String[] split2 = e2.split(HelpFormatter.DEFAULT_OPT_PREFIX);
                if (split2.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  in mark");
                    return split2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by by default");
            str = "985050001";
            str2 = "83162820e470e3b72501f0683504560e";
        }
        return new String[]{str, str2};
    }

    public static String[] c(Context context) {
        if (!TextUtils.isEmpty(f6388a) && !TextUtils.isEmpty(b)) {
            return new String[]{f6388a, b};
        }
        String d2 = com.baidu.mshield.sharedpreferences.a.a(context).d();
        if (!TextUtils.isEmpty(d2)) {
            String[] split = d2.split(HelpFormatter.DEFAULT_OPT_PREFIX);
            if (split != null && split.length == 2) {
                f6388a = split[0];
                b = split[1];
                return split;
            }
            return new String[2];
        }
        return new String[0];
    }

    public static void d(Context context) {
        com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
        if (System.currentTimeMillis() - a2.h() > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(a2.l() + 1));
            a2.e(0);
            a2.i();
            a(context, "1067119", hashMap);
            return;
        }
        a2.e(a2.l() + 1);
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String e2 = com.baidu.xclient.gdid.a.e(context);
            String str = "";
            if (e2 == null) {
                e2 = "";
            }
            jSONObject.put("0", e2);
            String d2 = com.baidu.xclient.gdid.a.d(context);
            if (d2 == null) {
                d2 = "";
            }
            jSONObject.put("1", d2);
            String g = com.baidu.xclient.gdid.a.g(context);
            if (g == null) {
                g = "";
            }
            jSONObject.put("2", g);
            String str2 = Build.HOST;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("3", str2);
            String a2 = c.a();
            if (a2 == null) {
                a2 = "";
            }
            jSONObject.put("4", a2);
            String f = com.baidu.xclient.gdid.a.f(context);
            if (f == null) {
                f = "";
            }
            jSONObject.put("5", f);
            String str3 = Build.VERSION.CODENAME;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("6", str3);
            String str4 = Build.VERSION.INCREMENTAL;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("7", str4);
            jSONObject.put("8", c.a(context));
            String c2 = com.baidu.xclient.gdid.a.c(context);
            if (c2 == null) {
                c2 = "";
            }
            jSONObject.put("9", c2);
            String a3 = com.baidu.mshield.core.a.a("mod");
            if (a3 == null) {
                a3 = "";
            }
            jSONObject.put("10", a3);
            jSONObject.put("11", c.i(context));
            String a4 = com.baidu.mshield.core.a.a("arv");
            if (a4 != null) {
                str = a4;
            }
            jSONObject.put(II0xO0.f26834o0IXXIx, str);
            jSONObject.put(II0xO0.f26825XoIxOXIXo, c.b(context));
            jSONObject.put("20", com.baidu.mshield.core.a.a("arl"));
        } catch (Throwable th) {
            a(th);
        }
        return jSONObject;
    }

    @SuppressLint({"MissingPermission"})
    public static int f(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = com.baidu.mshield.b.e.b.a(context);
        } catch (Throwable th) {
            a(th);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        networkInfo.getType();
        return 1;
    }

    public static int g(Context context) {
        int h;
        try {
            if (MyProvider.a() || TextUtils.isEmpty(i(context)) || (h = h(context)) == 1) {
                return 1;
            }
            if (h == 2) {
                return 0;
            }
            return MyProvider.a() ? 1 : 0;
        } catch (Throwable th) {
            a(th);
            return -1;
        }
    }

    public static int h(Context context) {
        try {
            String i = i(context);
            if (TextUtils.isEmpty(c)) {
                c = a(Process.myPid());
            }
            if (TextUtils.isEmpty(c)) {
                return 0;
            }
            if (!TextUtils.isEmpty(i)) {
                if (i.equals(c)) {
                    return 1;
                }
                return 2;
            }
            if (context.getPackageName().equals(c)) {
                return 3;
            }
            return 4;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    public static String i(Context context) {
        try {
        } catch (Throwable th) {
            a(th);
        }
        if (TextUtils.isEmpty(d) && e != 1) {
            try {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + FileUtils.FILE_EXTENSION_SEPARATOR + "mshield.ac.provider", 0);
                if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                    d = resolveContentProvider.processName;
                }
            } catch (Throwable th2) {
                a(th2);
            }
            e = 1;
            return d;
        }
        return d;
    }

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static void a(String str, String str2) {
        f6388a = str;
        b = str2;
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] b2 = b(context);
            jSONObject2.put("3", (b2 == null || b2.length != 2 || TextUtils.isEmpty(b2[0]) || TextUtils.isEmpty(b2[1])) ? "985050001" : b2[0]);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "mshield");
            jSONObject2.put("9", "4.2.2");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map != null && map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String jSONObject3 = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("sendEventUDC:" + jSONObject3);
            report.s(jSONObject3);
        } catch (Throwable th) {
            a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        if (r5 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r5.keys().hasNext() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r0 = java.lang.String.valueOf(r5.keys().next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        r4.d(r0, r5.optString(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            com.baidu.mshield.sharedpreferences.a r4 = com.baidu.mshield.sharedpreferences.a.a(r4)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La9
            r1.<init>(r5)     // Catch: java.lang.Throwable -> La9
            java.lang.String r5 = "0"
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L44
            r2 = r0
        L14:
            java.util.Iterator r3 = r5.keys()     // Catch: java.lang.Throwable -> L31
            boolean r3 = r3.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L33
            java.util.Iterator r2 = r5.keys()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = r2.next()     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L31
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L14
            goto L33
        L31:
            r5 = move-exception
            goto L41
        L33:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L44
            java.lang.String r5 = r5.optString(r2)     // Catch: java.lang.Throwable -> L31
            r4.c(r2, r5)     // Catch: java.lang.Throwable -> L31
            goto L44
        L41:
            a(r5)
        L44:
            java.lang.String r5 = "1"
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch: java.lang.Throwable -> L69
            if (r5 == 0) goto L7c
        L4c:
            java.util.Iterator r2 = r5.keys()     // Catch: java.lang.Throwable -> L69
            boolean r2 = r2.hasNext()     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            java.util.Iterator r0 = r5.keys()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L69
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L4c
            goto L6b
        L69:
            r5 = move-exception
            goto L79
        L6b:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L7c
            java.lang.String r5 = r5.optString(r0)     // Catch: java.lang.Throwable -> L69
            r4.d(r0, r5)     // Catch: java.lang.Throwable -> L69
            goto L7c
        L79:
            a(r5)
        L7c:
            java.lang.String r5 = "2"
            org.json.JSONArray r5 = r1.optJSONArray(r5)     // Catch: java.lang.Throwable -> La4
            if (r5 == 0) goto La8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r0.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "setAliveData rp= "
            r0.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> La4
            r0.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La4
            com.baidu.mshield.b.c.a.b(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> La4
            r4.n(r5)     // Catch: java.lang.Throwable -> La4
            goto La8
        La4:
            r4 = move-exception
            a(r4)
        La8:
            return
        La9:
            r4 = move-exception
            a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.utility.a.b(android.content.Context, java.lang.String):void");
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] b2 = b(context);
            if (b2.length == 2) {
                if (TextUtils.isEmpty(b2[0]) || TextUtils.isEmpty(b2[1]) || !"200080".equals(b2[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                    return;
                }
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 246);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt("11");
            String optString2 = optJSONObject.optString(II0xO0.f26834o0IXXIx, "");
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.mshield.rp.c.a aVar = new com.baidu.mshield.rp.c.a();
            aVar.d = str;
            aVar.b = optString;
            aVar.g = optInt;
            aVar.c = 3;
            aVar.e = optLong;
            aVar.f = optInt2;
            aVar.h = optInt3;
            aVar.i = optInt4;
            aVar.j = optString2;
            b.a(context).a(aVar);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static JSONObject a(Context context, com.baidu.mshield.rp.a.a aVar, String str, boolean z) {
        return a(context, aVar.f6378a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        b.a(context).a(false);
        b.a(context).c();
        com.baidu.mshield.rp.a.a aVar = new com.baidu.mshield.rp.a.a();
        aVar.f6378a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.d = str4;
        aVar.e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
        List<com.baidu.mshield.rp.a.a> u = a2.u();
        if (u == null) {
            a2.a(aVar);
        } else if (!u.contains(aVar)) {
            a2.a(aVar);
        } else {
            a2.a(u, aVar);
            b.a(context).a();
            return;
        }
        if (!a2.l(aVar.e)) {
            b.a(context).a(aVar);
        }
        b.a(context).a();
        b.a(context).b();
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] b2 = b(context);
            if (b2.length == 2) {
                jSONObject2.put("3", b2[0]);
            } else {
                jSONObject2.put("3", "985050001");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject3 = new JSONObject(str4);
                } catch (Throwable th) {
                    a(th);
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static void a(Context context, long j) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            int i = Build.VERSION.SDK_INT >= 23 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE;
            new Intent("com.b.r.p").setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), i);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                a(th);
            }
            try {
                alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
            } catch (Throwable th2) {
                a(th2);
            }
        } catch (Throwable th3) {
            a(th3);
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0157 A[Catch: all -> 0x015b, TRY_ENTER, TryCatch #4 {all -> 0x015b, blocks: (B:15:0x0087, B:17:0x008c, B:19:0x009a, B:21:0x00bf, B:23:0x00c8, B:25:0x00d7, B:27:0x00e3, B:29:0x00ec, B:31:0x00f5, B:33:0x0115, B:35:0x011c, B:37:0x0125, B:39:0x012e, B:41:0x0137, B:44:0x0157, B:52:0x015d, B:63:0x0080), top: B:62:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015d A[Catch: all -> 0x015b, TRY_LEAVE, TryCatch #4 {all -> 0x015b, blocks: (B:15:0x0087, B:17:0x008c, B:19:0x009a, B:21:0x00bf, B:23:0x00c8, B:25:0x00d7, B:27:0x00e3, B:29:0x00ec, B:31:0x00f5, B:33:0x0115, B:35:0x011c, B:37:0x0125, B:39:0x012e, B:41:0x0137, B:44:0x0157, B:52:0x015d, B:63:0x0080), top: B:62:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r18, org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.utility.a.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static String a(int i) {
        String str;
        String str2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.mshield.b.c.a.b("getProcessName return by P+:" + str);
                        return str.trim();
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str;
                    a(th);
                    return str2;
                }
            } else {
                str = null;
            }
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                if (invoke instanceof String) {
                    str = (String) invoke;
                }
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.mshield.b.c.a.b("getProcessName return by reflect:" + str);
                    return str.trim();
                }
            } catch (Throwable th2) {
                a(th2);
            }
            str2 = a(String.format("/proc/%d/cmdline", Integer.valueOf(i)));
            if (!TextUtils.isEmpty(str2)) {
                com.baidu.mshield.b.c.a.b("getProcessName return by cmdline:" + str2);
                return str2.trim();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return str2;
    }

    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String a2 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                    a(th);
                }
                return a2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            a(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }
}
