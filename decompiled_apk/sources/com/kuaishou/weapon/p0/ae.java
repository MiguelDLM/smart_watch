package com.kuaishou.weapon.p0;

import java.io.File;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ae {
    public boolean a(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("proc");
        sb.append(str2);
        sb.append(str);
        return new File(sb.toString()).canWrite();
    }

    public boolean b(String str) {
        return a(str, false);
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/sys", true) ? 1 : 0);
            jSONObject.put("1", a("/sbin", true) ? 1 : 0);
            jSONObject.put("2", a("/etc", true) ? 1 : 0);
            jSONObject.put("3", a("/dev", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r5 == 0) goto L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r0.<init>()     // Catch: java.lang.Throwable -> L53
            r0.append(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "/-"
            r0.append(r4)     // Catch: java.lang.Throwable -> L53
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L53
            r0.append(r1)     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r0.<init>()     // Catch: java.lang.Throwable -> L53
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L53
            r0.append(r1)     // Catch: java.lang.Throwable -> L53
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L53
        L2c:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L53
            r1.exists()     // Catch: java.lang.Throwable -> L53
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L53
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L53
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L4c
            r4.write(r0)     // Catch: java.lang.Throwable -> L4c
            r4.flush()     // Catch: java.lang.Throwable -> L4c
            r4.close()     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L4e
            r1.delete()     // Catch: java.lang.Throwable -> L4c
            goto L4e
        L4c:
            goto L54
        L4e:
            r4.close()     // Catch: java.lang.Exception -> L51
        L51:
            r4 = 1
            return r4
        L53:
            r4 = 0
        L54:
            if (r4 == 0) goto L59
            r4.close()     // Catch: java.lang.Exception -> L59
        L59:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ae.a(java.lang.String, boolean):boolean");
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/data", true) ? 1 : 0);
            jSONObject.put("1", a("/system/bin", true) ? 1 : 0);
            jSONObject.put("2", a("/system/lib", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
