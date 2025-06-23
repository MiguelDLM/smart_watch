package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.xclient.gdid.e.d;
import com.baidu.xclient.gdid.f;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f10238a;
    public c b;
    public Context c;

    public b(Context context) {
        this.c = context;
        this.b = c.a(context);
    }

    public static b a(Context context) {
        if (f10238a == null) {
            synchronized (b.class) {
                try {
                    if (f10238a == null) {
                        f10238a = new b(context);
                    }
                } finally {
                }
            }
        }
        return f10238a;
    }

    public final void b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] split = this.b.e(Environment.getDataDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(split[0])) {
                    jSONObject.put(String.valueOf(12), 0);
                } else {
                    jSONObject.put(String.valueOf(12), Long.valueOf(split[0]));
                }
                if (!TextUtils.isEmpty(split[1])) {
                    jSONObject.put(String.valueOf(13), Long.valueOf(split[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(12), 0);
            }
            jSONObject.put(String.valueOf(13), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "s", 1, 1, jSONObject2.optInt("4", 0))) {
                String c = com.baidu.xclient.gdid.c.a().c("sl");
                if (TextUtils.isEmpty(c)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else if (TextUtils.isEmpty(c)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else {
                    jSONObject.put(String.valueOf(57), com.baidu.mshield.b.f.c.a(c));
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject(f.a().g());
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            a(jSONObject2, jSONObject);
            b(jSONObject2, jSONObject);
            a(this.c, jSONObject2, jSONObject);
            c(jSONObject2, jSONObject);
            a(this.c, jSONObject2, true);
            a(this.c, jSONObject2, false);
            a(jSONObject2, true);
            a(jSONObject2, false);
            byte[] a2 = this.b.a(jSONObject2.toString().getBytes());
            return a2 == null ? "" : Base64.encodeToString(a2, 10);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public final JSONObject a(Context context, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> keys = jSONObject.keys();
            int i3 = 1;
            while (keys.hasNext()) {
                String next = keys.next();
                if (i3 < i) {
                    i3++;
                } else {
                    if (i3 >= i + i2) {
                        break;
                    }
                    i3++;
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        PackageInfo a2 = com.baidu.mshield.b.e.c.a(context, optString, 0);
                        JSONObject jSONObject3 = new JSONObject();
                        if (a2 == null) {
                            jSONObject3.put("0", -1);
                            jSONObject3.put("1", "");
                            jSONObject3.put("2", 0);
                            jSONObject3.put("3", 0);
                        } else {
                            jSONObject3.put("0", 0);
                            jSONObject3.put("1", a2.versionName);
                            jSONObject3.put("2", a2.firstInstallTime);
                            jSONObject3.put("3", a2.lastUpdateTime);
                        }
                        jSONObject2.put(next, jSONObject3);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final JSONObject a(JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> keys = jSONObject.keys();
            int i3 = 1;
            while (keys.hasNext()) {
                String next = keys.next();
                if (i3 < i) {
                    i3++;
                } else {
                    if (i3 >= i + i2) {
                        break;
                    }
                    i3++;
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        jSONObject2.put(next, new JSONObject(this.b.a(optString)));
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        PackageInfo a2;
        try {
            if (!a.a(this.c, jSONObject2, "1", 0, 1, jSONObject2.optInt("4", 0)) || (a2 = com.baidu.mshield.b.e.c.a(context, com.baidu.xclient.gdid.c.a().a(context), 0)) == null) {
                jSONObject.put(String.valueOf(20), 0);
            } else {
                jSONObject.put(String.valueOf(20), a2.firstInstallTime);
            }
            a(jSONObject, 52, this.b.d());
            jSONObject.put(String.valueOf(54), this.b.c());
            a(jSONObject, 58, this.b.b());
            String[] a3 = a.a(this.b.b("/proc/cpuinfo"));
            a(jSONObject, 60, a3[0]);
            a(jSONObject, 61, a3[1]);
            jSONObject.put(String.valueOf(62), d.c());
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(Context context, JSONObject jSONObject, boolean z) {
        int optInt;
        String str;
        int v;
        int i;
        try {
            JSONObject jSONObject2 = new JSONObject(f.a().g());
            int i2 = 20;
            if (z) {
                String optString = jSONObject2.optString("9");
                optInt = jSONObject2.optInt("x", 20);
                str = optString;
                v = f.a().w();
                i = 22;
            } else {
                String n = f.a().n();
                optInt = jSONObject2.optInt("y", 20);
                str = n;
                v = f.a().v();
                i = 21;
            }
            if (optInt <= 20 && optInt != 0) {
                i2 = optInt;
            }
            if (a.a(this.c, jSONObject2, "", 0, 1, jSONObject2.optInt("4", 0))) {
                if (!TextUtils.isEmpty(str)) {
                    str = this.b.d(str);
                }
                if (TextUtils.isEmpty(str)) {
                    jSONObject.put(String.valueOf(i), new JSONObject());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(str);
                int length = jSONObject3.length();
                Pair<Integer, Integer> a2 = a.a(v, length, i2);
                int intValue = ((Integer) a2.first).intValue();
                int intValue2 = ((Integer) a2.second).intValue();
                jSONObject.put(String.valueOf(i), a(context, jSONObject3, intValue, intValue2));
                int i3 = intValue + intValue2;
                if (i3 <= length) {
                    length = i3;
                }
                if (z) {
                    f.a().h(length);
                } else {
                    f.a().g(length);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, 3, this.b.f());
            a(jSONObject, 4, com.baidu.xclient.gdid.c.a().c("mod"));
            a(jSONObject, 5, this.b.k());
            a(jSONObject, 6, this.b.j());
            a(jSONObject, 7, this.b.i());
            a(jSONObject, 8, this.b.h());
            a(jSONObject, 9, this.b.g());
            a(jSONObject, 50, this.b.c("ro.build.fingerprint"));
            a(jSONObject, 53, com.baidu.xclient.gdid.c.a().c("arv"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, int i, String str) {
        try {
            String valueOf = String.valueOf(i);
            if (str == null) {
                str = "";
            }
            jSONObject.put(valueOf, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] split = this.b.e(Environment.getExternalStorageDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(split[0])) {
                    jSONObject.put(String.valueOf(10), 0);
                } else {
                    jSONObject.put(String.valueOf(10), Long.valueOf(split[0]));
                }
                if (!TextUtils.isEmpty(split[1])) {
                    jSONObject.put(String.valueOf(11), Long.valueOf(split[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(10), 0);
            }
            jSONObject.put(String.valueOf(11), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(org.json.JSONObject r9, boolean r10) {
        /*
            r8 = this;
            com.baidu.xclient.gdid.f r0 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.g()     // Catch: java.lang.Throwable -> L3b
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = "4"
            r1 = 0
            int r6 = r7.optInt(r0, r1)     // Catch: java.lang.Throwable -> L3b
            r0 = 20
            if (r10 == 0) goto L3e
            android.content.Context r1 = r8.c     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = ""
            r4 = 0
            r5 = 1
            r2 = r7
            boolean r1 = com.baidu.xclient.gdid.jni.a.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "10"
            java.lang.String r2 = r7.optString(r2)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "u"
            int r3 = r7.optInt(r3, r0)     // Catch: java.lang.Throwable -> L3b
            com.baidu.xclient.gdid.f r4 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            int r4 = r4.y()     // Catch: java.lang.Throwable -> L3b
            r5 = 59
            goto L62
        L3b:
            r9 = move-exception
            goto Lc9
        L3e:
            android.content.Context r1 = r8.c     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = ""
            r4 = 0
            r5 = 1
            r2 = r7
            boolean r1 = com.baidu.xclient.gdid.jni.a.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3b
            com.baidu.xclient.gdid.f r2 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = r2.o()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "z"
            int r3 = r7.optInt(r3, r0)     // Catch: java.lang.Throwable -> L3b
            com.baidu.xclient.gdid.f r4 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            int r4 = r4.x()     // Catch: java.lang.Throwable -> L3b
            r5 = 56
        L62:
            if (r3 > r0) goto L68
            if (r3 != 0) goto L67
            goto L68
        L67:
            r0 = r3
        L68:
            if (r1 != 0) goto L6b
            return
        L6b:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L3b
            if (r1 != 0) goto L77
            com.baidu.xclient.gdid.jni.c r1 = r8.b     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = r1.d(r2)     // Catch: java.lang.Throwable -> L3b
        L77:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L8a
            java.lang.String r10 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r0.<init>()     // Catch: java.lang.Throwable -> L3b
            r9.put(r10, r0)     // Catch: java.lang.Throwable -> L3b
            goto Lcc
        L8a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3b
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L3b
            android.util.Pair r0 = com.baidu.xclient.gdid.jni.a.a(r4, r2, r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r3 = r0.first     // Catch: java.lang.Throwable -> L3b
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L3b
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r0 = r0.second     // Catch: java.lang.Throwable -> L3b
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L3b
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L3b
            org.json.JSONObject r1 = r8.a(r1, r3, r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3b
            r9.put(r4, r1)     // Catch: java.lang.Throwable -> L3b
            int r3 = r3 + r0
            if (r3 <= r2) goto Lb6
            goto Lb7
        Lb6:
            r2 = r3
        Lb7:
            if (r10 == 0) goto Lc1
            com.baidu.xclient.gdid.f r9 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            r9.j(r2)     // Catch: java.lang.Throwable -> L3b
            goto Lcc
        Lc1:
            com.baidu.xclient.gdid.f r9 = com.baidu.xclient.gdid.f.a()     // Catch: java.lang.Throwable -> L3b
            r9.i(r2)     // Catch: java.lang.Throwable -> L3b
            goto Lcc
        Lc9:
            com.baidu.xclient.gdid.e.d.a(r9)
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.xclient.gdid.jni.b.a(org.json.JSONObject, boolean):void");
    }
}
