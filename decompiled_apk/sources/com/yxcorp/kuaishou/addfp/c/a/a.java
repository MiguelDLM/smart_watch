package com.yxcorp.kuaishou.addfp.c.a;

import OI0.oxoX;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import oOoIIO0.oIX0oI;

/* loaded from: classes6.dex */
public final class a {
    public static String a(int i, String str) {
        String a2;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        if (i == 0) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str2, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str3, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str4, str);
            if (TextUtils.isEmpty(a2)) {
                a2 = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            a2 = "";
        }
        return a2 == null ? "" : a2;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0160, code lost:
    
        if (r11 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x013c, code lost:
    
        r10 = r2;
        r1 = r3;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013a, code lost:
    
        if (r11 == null) goto L112;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0154 A[Catch: IOException -> 0x0150, TryCatch #8 {IOException -> 0x0150, blocks: (B:39:0x014c, B:25:0x0154, B:27:0x0159), top: B:38:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0159 A[Catch: IOException -> 0x0150, TRY_LEAVE, TryCatch #8 {IOException -> 0x0150, blocks: (B:39:0x014c, B:25:0x0154, B:27:0x0159), top: B:38:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012e A[Catch: IOException -> 0x012a, TryCatch #13 {IOException -> 0x012a, blocks: (B:56:0x0126, B:47:0x012e, B:49:0x0133), top: B:55:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0133 A[Catch: IOException -> 0x012a, TRY_LEAVE, TryCatch #13 {IOException -> 0x012a, blocks: (B:56:0x0126, B:47:0x012e, B:49:0x0133), top: B:55:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0178 A[Catch: IOException -> 0x0174, TryCatch #5 {IOException -> 0x0174, blocks: (B:75:0x0170, B:63:0x0178, B:65:0x017d), top: B:74:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d A[Catch: IOException -> 0x0174, TRY_LEAVE, TryCatch #5 {IOException -> 0x0174, blocks: (B:75:0x0170, B:63:0x0178, B:65:0x017d), top: B:74:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r10v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.yxcorp.kuaishou.addfp.android.b.e a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        if (!str.equalsIgnoreCase(oIX0oI.f32057oO)) {
            String str2 = Build.BRAND;
            if (!str2.equalsIgnoreCase(oIX0oI.f32057oO) && !str2.equalsIgnoreCase("REDMI") && !str2.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(a("ro.miui.ui.version.name", "")) && !str.equalsIgnoreCase("BLACKSHARK") && !str2.equalsIgnoreCase("BLACKSHARK")) {
                if (!str.equalsIgnoreCase("SAMSUNG") && !str2.equalsIgnoreCase("SAMSUNG")) {
                    if (!str.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI) && !str2.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI) && !str2.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(a("ro.vivo.os.version", ""))) {
                        if (str.equalsIgnoreCase("HUAWEI") || str2.equalsIgnoreCase("HUAWEI")) {
                            return "1";
                        }
                        return (str.equalsIgnoreCase("OPPO") || str2.equalsIgnoreCase("OPPO") || str2.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a(oxoX.f1511OOXIXo, "")) || str.equalsIgnoreCase("ONEPLUS") || str2.equalsIgnoreCase("ONEPLUS")) ? "5" : str2.equalsIgnoreCase("HONOR") ? "7" : "0";
                    }
                    return "2";
                }
                return "3";
            }
        }
        return "4";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:37:0x00bb, B:41:0x00c3), top: B:36:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #1 {all -> 0x0041, blocks: (B:3:0x0002, B:6:0x0016, B:8:0x0020, B:10:0x002a, B:17:0x006d, B:19:0x0073, B:24:0x007a, B:26:0x0084, B:29:0x0094, B:31:0x009a, B:32:0x00b1, B:47:0x00d3, B:49:0x00d9, B:55:0x008a, B:57:0x0047, B:59:0x0051, B:61:0x005b, B:63:0x0069), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = a(r8, r0)     // Catch: java.lang.Throwable -> L41
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "Lm91a2R0ZnQ="
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r5 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String r6 = "KWE_N"
            java.lang.String r7 = ""
            if (r2 == 0) goto L47
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            boolean r2 = r2.b()     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L3f
            java.lang.String[] r2 = new java.lang.String[]{r5, r4}     // Catch: java.lang.Throwable -> L41
            boolean r2 = com.yxcorp.kuaishou.addfp.android.b.g.a(r8, r2)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L44
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            java.lang.String r7 = r2.a(r3)     // Catch: java.lang.Throwable -> L41
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L3f
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3f
            android.provider.Settings.System.putString(r2, r0, r7)     // Catch: java.lang.Throwable -> L3f
        L3f:
            r0 = r6
            goto L6d
        L41:
            r8 = move-exception
            goto Le0
        L44:
            java.lang.String r0 = "KWE_PN"
            goto L6d
        L47:
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L3f
            java.lang.String[] r0 = new java.lang.String[]{r5, r4}     // Catch: java.lang.Throwable -> L41
            boolean r0 = com.yxcorp.kuaishou.addfp.android.b.g.a(r8, r0)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L3f
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            java.lang.String r7 = r0.a(r3)     // Catch: java.lang.Throwable -> L41
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L3f
            com.yxcorp.kuaishou.addfp.android.a.d.a(r8, r1)     // Catch: java.lang.Throwable -> L41
            goto L3f
        L6d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L7a
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L7a
            goto Le5
        L7a:
            com.yxcorp.kuaishou.addfp.android.a.d r2 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            java.util.LinkedHashMap r1 = r2.b(r1)     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L8a
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L92
        L8a:
            com.yxcorp.kuaishou.addfp.android.a.d r8 = com.yxcorp.kuaishou.addfp.android.a.d.a(r8)     // Catch: java.lang.Throwable -> L41
            java.util.LinkedHashMap r1 = r8.b(r7)     // Catch: java.lang.Throwable -> L41
        L92:
            if (r1 == 0) goto Lde
            int r8 = r1.size()     // Catch: java.lang.Throwable -> L41
            if (r8 <= 0) goto Lde
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L41
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Throwable -> L41
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L41
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L41
            java.util.ListIterator r8 = r8.listIterator(r1)     // Catch: java.lang.Throwable -> L41
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r2 = 0
        Lb1:
            boolean r3 = r8.hasPrevious()     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto Ld3
            r3 = 10
            if (r2 >= r3) goto Ld3
            java.lang.Object r3 = r8.previous()     // Catch: java.lang.Throwable -> Lb1
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Lb1
            if (r3 == 0) goto Ld0
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lb1
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lb1
            r1.put(r4, r3)     // Catch: java.lang.Throwable -> Lb1
        Ld0:
            int r2 = r2 + 1
            goto Lb1
        Ld3:
            int r8 = r1.length()     // Catch: java.lang.Throwable -> L41
            if (r8 <= 0) goto Lde
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L41
            return r8
        Lde:
            r6 = r0
            goto Le5
        Le0:
            r8.printStackTrace()
            java.lang.String r6 = "KWE_PE"
        Le5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }
}
