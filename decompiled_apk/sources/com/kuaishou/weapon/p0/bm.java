package com.kuaishou.weapon.p0;

import android.content.Context;
import android.util.DisplayMetrics;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class bm {
    public static int a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String b() {
        return "0";
    }

    public static String c() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0071, code lost:
    
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject d() {
        /*
            java.lang.String r0 = ";"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "lsmod"
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L68
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L68
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L68
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L68
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L65
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L65
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L65
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L65
        L25:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L5c
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5a
            if (r5 != 0) goto L25
            java.lang.String r2 = com.kuaishou.weapon.p0.bo.a(r2)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "-"
            boolean r5 = r2.contains(r5)     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L25
            boolean r5 = r2.contains(r0)     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L25
            java.lang.String r5 = ";;;"
            java.lang.String r2 = r2.replace(r5, r0)     // Catch: java.lang.Throwable -> L5a
            java.lang.String[] r2 = r2.split(r0)     // Catch: java.lang.Throwable -> L5a
            int r5 = r2.length     // Catch: java.lang.Throwable -> L5a
            r6 = 1
            if (r5 <= r6) goto L25
            r5 = 0
            r5 = r2[r5]     // Catch: java.lang.Throwable -> L5a
            r2 = r2[r6]     // Catch: java.lang.Throwable -> L5a
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L5a
            goto L25
        L5a:
            goto L63
        L5c:
            r4.close()     // Catch: java.io.IOException -> L5f
        L5f:
            r3.close()     // Catch: java.io.IOException -> L74
            goto L74
        L63:
            r2 = r4
            goto L6a
        L65:
            r3 = r2
            goto L63
        L68:
            r3 = r2
        L6a:
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L70
            goto L71
        L70:
        L71:
            if (r3 == 0) goto L74
            goto L5f
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bm.d():org.json.JSONObject");
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            TimeZone timeZone = Calendar.getInstance().getTimeZone();
            if (timeZone == null) {
                return null;
            }
            jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
            jSONObject.put("1", timeZone.getID());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
