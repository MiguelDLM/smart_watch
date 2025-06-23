package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f6390a;

    public static synchronized String a(Context context) {
        synchronized (c.class) {
            try {
                if (!TextUtils.isEmpty(f6390a)) {
                    return f6390a;
                }
                String a2 = a(context, false);
                if (!TextUtils.isEmpty(a2)) {
                    f6390a = a2;
                    return a2;
                }
                com.baidu.mshield.sharedpreferences.a a3 = com.baidu.mshield.sharedpreferences.a.a(context);
                String K = a3.K();
                if (!TextUtils.isEmpty(K)) {
                    try {
                        String a4 = a(K);
                        if (!TextUtils.isEmpty(a4)) {
                            f6390a = a4;
                            return a4;
                        }
                    } catch (Throwable th) {
                        com.baidu.mshield.b.c.a.a(th);
                    }
                }
                String m = a3.m();
                if (!TextUtils.isEmpty(m)) {
                    a3.o(new String(Base64.encode(com.baidu.mshield.b.f.a.a(m.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8"));
                    f6390a = m;
                    return m;
                }
                String e = e(context);
                String f = f(context);
                if (TextUtils.isEmpty(f)) {
                    f = "0";
                }
                String str = e + "|" + new StringBuffer(f).reverse().toString();
                String str2 = new String(Base64.encode(com.baidu.mshield.b.f.a.a(str.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");
                String m2 = a3.m();
                if (TextUtils.isEmpty(m2)) {
                    a3.c(str);
                    a3.o(str2);
                    f6390a = str;
                    return str;
                }
                f6390a = m2;
                return m2;
            } catch (Throwable th2) {
                com.baidu.mshield.b.c.a.a(th2);
                return "";
            }
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            String r = a2.r();
            if (!TextUtils.isEmpty(r)) {
                return r;
            }
            if (Build.VERSION.SDK_INT > 25) {
                return "";
            }
            String f = f(context);
            String g = g(context);
            if (TextUtils.isEmpty(f) && TextUtils.isEmpty(g)) {
                return "";
            }
            byte[] bytes = (f + ":" + g).getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 246);
            }
            String b = com.baidu.mshield.b.f.e.b(bytes);
            if (TextUtils.isEmpty(b)) {
                return "";
            }
            a2.h(b);
            return b;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[Catch: all -> 0x0089, TryCatch #0 {all -> 0x0089, blocks: (B:3:0x0002, B:12:0x0023, B:14:0x0033, B:18:0x005a, B:21:0x0066, B:25:0x0020), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #0 {all -> 0x0089, blocks: (B:3:0x0002, B:12:0x0023, B:14:0x0033, B:18:0x005a, B:21:0x0066, B:25:0x0020), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r6) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = g(r6)     // Catch: java.lang.Throwable -> L89
            r2 = 1
            com.baidu.sec.privacy.c.a r3 = com.baidu.sec.privacy.c.a.a(r6)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r4 = "bd_setting_i"
            java.lang.String r3 = r3.a(r4, r2)     // Catch: java.lang.Throwable -> L1e
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L23
            java.lang.String r3 = f(r6)     // Catch: java.lang.Throwable -> L1c
            goto L23
        L1c:
            r4 = move-exception
            goto L20
        L1e:
            r4 = move-exception
            r3 = r0
        L20:
            com.baidu.mshield.b.c.a.a(r4)     // Catch: java.lang.Throwable -> L89
        L23:
            com.baidu.sec.privacy.c.a r4 = com.baidu.sec.privacy.c.a.a(r6)     // Catch: java.lang.Throwable -> L89
            java.lang.String r5 = "com.baidu.deviceid"
            java.lang.String r4 = r4.a(r5, r2)     // Catch: java.lang.Throwable -> L89
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L89
            if (r5 == 0) goto L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            r4.<init>()     // Catch: java.lang.Throwable -> L89
            java.lang.String r5 = "com.baidu"
            r4.append(r5)     // Catch: java.lang.Throwable -> L89
            r4.append(r3)     // Catch: java.lang.Throwable -> L89
            r4.append(r1)     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L89
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = a(r1, r2)     // Catch: java.lang.Throwable -> L89
            com.baidu.sec.privacy.c.a r3 = com.baidu.sec.privacy.c.a.a(r6)     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = r3.a(r1, r2)     // Catch: java.lang.Throwable -> L89
        L57:
            if (r4 != 0) goto L5a
            return r0
        L5a:
            java.lang.String r6 = f(r6)     // Catch: java.lang.Throwable -> L89
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L66
            java.lang.String r6 = "0"
        L66:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L89
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L89
            java.lang.StringBuffer r6 = r1.reverse()     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L89
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            r1.<init>()     // Catch: java.lang.Throwable -> L89
            r1.append(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Throwable -> L89
            r1.append(r6)     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L89
            return r6
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.utility.c.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        try {
            if (TextUtils.isEmpty(com.baidu.mshield.b.e.a.d(context, "bd_setting_i"))) {
                f(context);
            }
            TextUtils.isEmpty(f(context));
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String e(Context context) {
        String str;
        String str2 = "";
        try {
            str = f(context);
            try {
                str2 = g(context);
            } catch (Throwable th) {
                th = th;
                com.baidu.mshield.b.c.a.a(th);
                return a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
    }

    @SuppressLint({"MissingPermission"})
    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        return com.baidu.mshield.core.a.a("arid");
    }

    public static String h(Context context) {
        try {
            try {
                if (TextUtils.isEmpty(com.baidu.sec.privacy.c.a.a(context).a("bd_setting_i", true))) {
                    f(context);
                }
                TextUtils.isEmpty(f(context));
                return "";
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
                return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String j(Context context) {
        return "";
    }

    public static String a(String str) {
        try {
            String str2 = new String(com.baidu.mshield.b.f.a.b(Base64.decode(str, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            com.baidu.mshield.b.c.a.a(e);
            return null;
        }
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a() {
        return Build.DISPLAY;
    }

    public static String a(Context context, boolean z) {
        try {
            Bundle a2 = g.a(context, "getRemoteZid", null, z, null, false);
            if (a2 == null) {
                return "";
            }
            String string = a2.getString("_zid");
            return !TextUtils.isEmpty(string) ? string : "";
        } catch (Throwable th) {
            a.a(th);
            return "";
        }
    }
}
