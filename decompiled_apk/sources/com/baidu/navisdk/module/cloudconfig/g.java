package com.baidu.navisdk.module.cloudconfig;

import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.m0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class g {
    private static final String c = "com.baidu.navisdk.module.cloudconfig.g";
    private static String d;
    private static String e;
    private static String f;

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f7146a = null;
    private JSONObject b = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(m0.j().b());
        String str = File.separator;
        sb.append(str);
        sb.append("initConfig9_7_5");
        d = sb.toString();
        e = m0.j().b() + str + "initConfig10_8_0";
        f = m0.j().b() + str + "ABTest10_14_0";
    }

    private boolean j() {
        return new File(f).exists();
    }

    private boolean k() {
        return new File(e).exists();
    }

    public void a() {
        b(f);
    }

    public void b() {
        b(e);
    }

    public String c() {
        JSONObject e2 = e();
        if (e2 == null) {
            a();
            return "";
        }
        try {
            String string = e2.getString("ab_test_etag");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("EncryptData", "abTestEtag = " + string);
            }
            if (string != null) {
                this.b = e2;
                return string;
            }
            a();
            return "";
        } catch (Exception unused) {
            a();
            return "";
        }
    }

    public File d() {
        File file = new File(f);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                LogUtil.e(c, e2.toString());
            }
        }
        return file;
    }

    public JSONObject e() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject;
        }
        if (!j()) {
            return null;
        }
        return a(d());
    }

    public JSONObject f() {
        String jSONObject;
        c(d);
        JSONObject jSONObject2 = this.f7146a;
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        if (!k()) {
            return null;
        }
        JSONObject a2 = a(g());
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCloudConfigJSonObjectFromFile->jsonObject=");
            if (a2 == null) {
                jSONObject = "null";
            } else {
                jSONObject = a2.toString();
            }
            sb.append(jSONObject);
            LogUtil.e("EncryptData", sb.toString());
        }
        return a2;
    }

    public File g() {
        File file = new File(e);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                LogUtil.e(c, e2.toString());
            }
        }
        return file;
    }

    public String h() {
        JSONObject f2 = f();
        if (f2 == null) {
            b();
            return "";
        }
        try {
            String string = f2.getJSONObject("data").getString("etag");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("EncryptData", "eTagStr = " + string);
            }
            if (string != null) {
                this.f7146a = f2;
                return string;
            }
            b();
            return "";
        } catch (Exception unused) {
            b();
            return "";
        }
    }

    public String i() {
        return (JNITrajectoryControl.sInstance.getUrlParamsSign(a0.e() + "") + "").substring(8, 24);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.lang.String r3) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L42
            r3 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.lang.String r3 = ""
            r1.write(r3)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r1.close()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r1.close()     // Catch: java.io.IOException -> L1d
            goto L42
        L1d:
            r3 = move-exception
            goto L31
        L1f:
            r3 = move-exception
            goto L35
        L21:
            r3 = move-exception
            goto L28
        L23:
            r0 = move-exception
            goto L37
        L25:
            r0 = move-exception
            r1 = r3
            r3 = r0
        L28:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.io.IOException -> L1d
            goto L42
        L31:
            r3.printStackTrace()
            goto L42
        L35:
            r0 = r3
            r3 = r1
        L37:
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r3 = move-exception
            r3.printStackTrace()
        L41:
            throw r0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.cloudconfig.g.b(java.lang.String):void");
    }

    public void a(JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveABTestDataToFile->mJSONObject=");
            sb.append(jSONObject == null ? "null" : jSONObject.toString());
            LogUtil.e("EncryptData", sb.toString());
        }
        a(jSONObject, d());
    }

    public void a(JSONObject jSONObject, File file) {
        String a2;
        FileWriter fileWriter;
        String jSONObject2 = jSONObject.toString();
        if (file == null || !file.exists()) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    a2 = a(jSONObject2);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("EncryptData", "encrypt content: " + a2);
                    }
                    fileWriter = new FileWriter(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(a2);
                fileWriter.close();
                fileWriter.close();
            } catch (Exception e3) {
                e = e3;
                fileWriter2 = fileWriter;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("EncryptData", e.toString());
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
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public void b(JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveCloudDataToFile->mJSONObject=");
            sb.append(jSONObject == null ? "null" : jSONObject.toString());
            LogUtil.e("EncryptData", sb.toString());
        }
        a(jSONObject, g());
    }

    public String a(String str) throws Exception {
        return com.baidu.navisdk.util.common.a.b(i(), str);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0023: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:36:0x0023 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject a(java.io.File r7) {
        /*
            r6 = this;
            java.lang.String r0 = "EncryptData"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r2]
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
        L16:
            int r7 = r4.read(r2)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r5 = -1
            if (r7 == r5) goto L27
            r5 = 0
            r1.append(r2, r5, r7)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            goto L16
        L22:
            r7 = move-exception
            r3 = r4
            goto L70
        L25:
            r7 = move-exception
            goto L5e
        L27:
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            java.lang.String r1 = r6.i()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            java.lang.String r7 = com.baidu.navisdk.util.common.a.a(r1, r7)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            boolean r1 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            if (r1 == 0) goto L4b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r1.<init>()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            java.lang.String r2 = "decrypt content: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r1.append(r7)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            com.baidu.navisdk.util.common.LogUtil.e(r0, r1)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
        L4b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r4.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r7 = move-exception
            r7.printStackTrace()
        L58:
            r3 = r1
            goto L6f
        L5a:
            r7 = move-exception
            goto L70
        L5c:
            r7 = move-exception
            r4 = r3
        L5e:
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L22
            com.baidu.navisdk.util.common.LogUtil.e(r0, r7)     // Catch: java.lang.Throwable -> L22
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r7 = move-exception
            r7.printStackTrace()
        L6f:
            return r3
        L70:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r0 = move-exception
            r0.printStackTrace()
        L7a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.cloudconfig.g.a(java.io.File):org.json.JSONObject");
    }
}
