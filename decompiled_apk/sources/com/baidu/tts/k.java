package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class k extends e4 {
    public int b;
    public String c;
    public Context d;
    public String e;

    public k() {
        this.b = -2;
        this.d = e3.e().c();
    }

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        q2 q2Var = q2.ERROR_NUMBER;
        int optInt = jSONObject.optInt("err_no");
        this.b = optInt;
        LoggerProxy.d("GetLicenseHandler", " onSuccess statusCode: " + i + " errNo: " + optInt);
        q2 q2Var2 = q2.ERROR_MESSAGE;
        String optString = jSONObject.optString("err_msg");
        long optLong = jSONObject.optLong(ClientCookie.EXPIRES_ATTR);
        long optLong2 = jSONObject.optLong("time");
        SharedPreferencesUtils.putLong(this.d, SharedPreferencesUtils.LICENSE_EXPIRES, optLong);
        SharedPreferencesUtils.putInt(this.d, SharedPreferencesUtils.LICENSE_LAST_ERROR_NO, optInt);
        if (!TextUtils.isEmpty(this.e)) {
            SharedPreferencesUtils.putString(this.d, SharedPreferencesUtils.LICENSE_LAST_SN, this.e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - optLong2;
        if (j < 60000 && j > 0) {
            SharedPreferencesUtils.putLong(this.d, SharedPreferencesUtils.LICENSE_TIME, optLong2);
        } else {
            SharedPreferencesUtils.putLong(this.d, SharedPreferencesUtils.LICENSE_TIME, currentTimeMillis);
        }
        String replaceAll = jSONObject.optString("license").replaceAll("license_begin|license_end", "");
        if (optInt == 0 && !replaceAll.isEmpty()) {
            File file = new File(this.c);
            if (file.exists()) {
                File file2 = new File(this.c + "_new");
                LoggerProxy.d("GetLicenseHandler", "isSave=" + a(this.c + "_new", replaceAll));
                LoggerProxy.d("GetLicenseHandler", "isDelete=" + file.delete());
                LoggerProxy.d("GetLicenseHandler", "isRename=" + file2.renameTo(file));
            } else {
                LoggerProxy.d("GetLicenseHandler", "isSave=" + a(this.c, replaceAll));
            }
            SharedPreferencesUtils.putBoolean(this.d, SharedPreferencesUtils.LICENSE_IS_REGISTER, true);
        }
        LoggerProxy.d("GetLicenseHandler", "getLicense statusCode: " + i + " err_msg: " + optString + " err_no: " + optInt);
    }

    public k(String str) {
        this();
        this.c = str;
    }

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        LoggerProxy.d("GetLicenseHandler", "getLicense statusCode: " + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r4 != 0) goto L20
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r2 = r1.getParent()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r4.mkdirs()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.createNewFile()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L20
        L1c:
            r4 = move-exception
            goto L5c
        L1e:
            r4 = move-exception
            goto L3f
        L20:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r0 = "utf-8"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
            r4.write(r5)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
            r4.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r4 = move-exception
            r4.printStackTrace()
        L37:
            r4 = 1
            return r4
        L39:
            r5 = move-exception
            r0 = r4
            goto L5b
        L3c:
            r5 = move-exception
            r0 = r4
            goto L40
        L3f:
            r5 = r4
        L40:
            java.lang.String r4 = "GetLicenseHandler"
            java.lang.String r1 = "download license success, write file failed"
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r4, r1)     // Catch: java.lang.Throwable -> L5a
            r4 = -1010(0xfffffffffffffc0e, float:NaN)
            r3.b = r4     // Catch: java.lang.Throwable -> L5a
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L58
            r0.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r4 = move-exception
            r4.printStackTrace()
        L58:
            r4 = 0
            return r4
        L5a:
            r5 = move-exception
        L5b:
            r4 = r5
        L5c:
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r5 = move-exception
            r5.printStackTrace()
        L66:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.k.a(java.lang.String, java.lang.String):boolean");
    }
}
