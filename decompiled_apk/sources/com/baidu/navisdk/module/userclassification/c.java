package com.baidu.navisdk.module.userclassification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.m0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7595a;
    private static final String b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(m0.j().b());
        String str = File.separator;
        sb.append(str);
        sb.append("classificationConfig15.1.0");
        f7595a = sb.toString();
        b = m0.j().b() + str + "userGroup15.1.0";
    }

    public static void a() {
        a(f7595a);
    }

    public static void b() {
        a(b);
    }

    public static JSONObject c() {
        if (!g()) {
            return null;
        }
        JSONObject a2 = a(e());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LocalDataCacheUtils", "getCacheConfigFromFile --> config = " + a2);
        }
        return a2;
    }

    public static JSONObject d() {
        if (!g()) {
            return null;
        }
        JSONObject a2 = a(f());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LocalDataCacheUtils", "getCacheGroupFromFile --> userGroup = " + a2);
        }
        return a2;
    }

    private static File e() {
        File file = new File(f7595a);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                LogUtil.e("LocalDataCacheUtils", e.toString());
            }
        }
        return file;
    }

    private static File f() {
        File file = new File(b);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                LogUtil.e("LocalDataCacheUtils", e.toString());
            }
        }
        return file;
    }

    private static boolean g() {
        return new File(f7595a).exists();
    }

    private static String h() {
        return (JNITrajectoryControl.sInstance.getUrlParamsSign(a0.e() + "") + "").substring(8, 24);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r2) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L43
            r2 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.lang.String r2 = ""
            r1.write(r2)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r1.close()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r1.close()     // Catch: java.io.IOException -> L1d
            goto L43
        L1d:
            r2 = move-exception
            goto L34
        L1f:
            r2 = move-exception
            goto L23
        L21:
            r2 = move-exception
            goto L2b
        L23:
            r0 = r2
            r2 = r1
            goto L38
        L26:
            r0 = move-exception
            goto L38
        L28:
            r0 = move-exception
            r1 = r2
            r2 = r0
        L2b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L1d
            goto L43
        L34:
            r2.printStackTrace()
            goto L43
        L38:
            if (r2 == 0) goto L42
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r2 = move-exception
            r2.printStackTrace()
        L42:
            throw r0
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.userclassification.c.a(java.lang.String):void");
    }

    public static void b(@Nullable JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LocalDataCacheUtils", "saveUserGroupToFile --> userGroup = " + jSONObject);
        }
        if (jSONObject == null) {
            b();
        } else {
            a(jSONObject, f());
        }
    }

    private static String b(String str) throws Exception {
        return com.baidu.navisdk.util.common.a.b(h(), str);
    }

    public static void a(@NonNull JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LocalDataCacheUtils", "saveCloudDataToFile --> config = " + jSONObject);
        }
        a(jSONObject, e());
    }

    private static void a(@Nullable JSONObject jSONObject, File file) {
        String b2;
        FileWriter fileWriter;
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        if (file == null || !file.exists()) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    b2 = b(jSONObject2);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("LocalDataCacheUtils", "encrypt content: " + b2);
                    }
                    fileWriter = new FileWriter(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileWriter.write(b2);
                fileWriter.close();
                fileWriter.close();
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("LocalDataCacheUtils", e.toString());
                    e.printStackTrace();
                }
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0025: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:36:0x0025 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.json.JSONObject a(java.io.File r7) {
        /*
            java.lang.String r0 = "getJsonFromFile --> close e = "
            java.lang.String r1 = "LocalDataCacheUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 1024(0x400, float:1.435E-42)
            char[] r3 = new char[r3]
            r4 = 0
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
        L18:
            int r7 = r5.read(r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            r6 = -1
            if (r7 == r6) goto L2a
            r6 = 0
            r2.append(r3, r6, r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            goto L18
        L24:
            r7 = move-exception
            r4 = r5
            goto L9e
        L28:
            r7 = move-exception
            goto L70
        L2a:
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            java.lang.String r2 = h()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            java.lang.String r7 = com.baidu.navisdk.util.common.a.a(r2, r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            if (r2 == 0) goto L4e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            r2.<init>()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            java.lang.String r3 = "getJsonFromFile --> decrypt content: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            r2.append(r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            com.baidu.navisdk.util.common.LogUtil.e(r1, r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
        L4e:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            r5.close()     // Catch: java.io.IOException -> L57
            goto L6a
        L57:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r1, r7)
        L6a:
            r4 = r2
            goto L9d
        L6c:
            r7 = move-exception
            goto L9e
        L6e:
            r7 = move-exception
            r5 = r4
        L70:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "getJsonFromFile --> e = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L24
            r2.append(r7)     // Catch: java.lang.Throwable -> L24
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L24
            com.baidu.navisdk.util.common.LogUtil.e(r1, r7)     // Catch: java.lang.Throwable -> L24
            if (r5 == 0) goto L9d
            r5.close()     // Catch: java.io.IOException -> L8a
            goto L9d
        L8a:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r1, r7)
        L9d:
            return r4
        L9e:
            if (r4 == 0) goto Lb7
            r4.close()     // Catch: java.io.IOException -> La4
            goto Lb7
        La4:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r1, r0)
        Lb7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.userclassification.c.a(java.io.File):org.json.JSONObject");
    }
}
