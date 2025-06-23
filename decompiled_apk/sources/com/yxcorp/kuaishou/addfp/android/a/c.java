package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class c {
    private static boolean d = true;
    private static int e;

    /* renamed from: a, reason: collision with root package name */
    private String f27634a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r2 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = "/sys/class/android_usb/android0/iSerial"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L31
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L33
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L31
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L31
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L31
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L34
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            return r0
        L2f:
            r1 = move-exception
            goto L3d
        L31:
            r1 = move-exception
            goto L3c
        L33:
            r2 = r0
        L34:
            if (r2 == 0) goto L46
        L36:
            r2.close()     // Catch: java.lang.Throwable -> L3a
            goto L46
        L3a:
            r1 = move-exception
            goto L43
        L3c:
            r2 = r0
        L3d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L46
            goto L36
        L43:
            r1.printStackTrace()
        L46:
            return r0
        L47:
            r0 = move-exception
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> L4e
            goto L52
        L4e:
            r1 = move-exception
            r1.printStackTrace()
        L52:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.f27633a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f27634a) ? this.f27634a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02ae A[Catch: all -> 0x02ce, TryCatch #8 {all -> 0x02ce, blocks: (B:99:0x02a4, B:102:0x02ae, B:104:0x02c2, B:106:0x02d0, B:109:0x02d3), top: B:98:0x02a4, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x034c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r21, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.f27634a = str;
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
                if ("64_level".equals(next)) {
                    e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000d, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: all -> 0x0051, TryCatch #1 {all -> 0x0051, blocks: (B:3:0x0002, B:11:0x0014, B:14:0x001f, B:17:0x0025, B:21:0x002f, B:23:0x0037, B:25:0x0043, B:28:0x0055, B:32:0x0065, B:34:0x0073, B:37:0x00ad, B:47:0x00ce, B:49:0x00d8, B:52:0x00df, B:54:0x00e7, B:71:0x00a0, B:73:0x00a6, B:78:0x009c, B:81:0x0011, B:8:0x0009, B:68:0x007c, B:70:0x0084), top: B:2:0x0002, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #1 {all -> 0x0051, blocks: (B:3:0x0002, B:11:0x0014, B:14:0x001f, B:17:0x0025, B:21:0x002f, B:23:0x0037, B:25:0x0043, B:28:0x0055, B:32:0x0065, B:34:0x0073, B:37:0x00ad, B:47:0x00ce, B:49:0x00d8, B:52:0x00df, B:54:0x00e7, B:71:0x00a0, B:73:0x00a6, B:78:0x009c, B:81:0x0011, B:8:0x0009, B:68:0x007c, B:70:0x0084), top: B:2:0x0002, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #1 {all -> 0x0051, blocks: (B:3:0x0002, B:11:0x0014, B:14:0x001f, B:17:0x0025, B:21:0x002f, B:23:0x0037, B:25:0x0043, B:28:0x0055, B:32:0x0065, B:34:0x0073, B:37:0x00ad, B:47:0x00ce, B:49:0x00d8, B:52:0x00df, B:54:0x00e7, B:71:0x00a0, B:73:0x00a6, B:78:0x009c, B:81:0x0011, B:8:0x0009, B:68:0x007c, B:70:0x0084), top: B:2:0x0002, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context):java.lang.String");
    }
}
