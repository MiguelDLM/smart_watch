package com.baidu.tts;

import android.content.Context;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.Utility;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class l implements Callable<Integer> {
    public static final String e = "l";

    /* renamed from: a, reason: collision with root package name */
    public String f10125a;
    public String b;
    public String c;
    public String d;

    public l(String str, String str2, String str3, String str4) {
        this.f10125a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        String str;
        String str2;
        String str3 = e;
        LoggerProxy.d(str3, "begins getLicense");
        a4 a4Var = new a4();
        y2 y2Var = y2.GETLICENSE_V2_SERVER;
        String str4 = y2Var.f10202a;
        String b = y2Var.b();
        String a2 = y2Var.a();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", a2);
        a4Var.f = hashMap;
        String str5 = this.d;
        String str6 = this.c;
        k kVar = new k(str5);
        kVar.e = str6;
        long currentTimeMillis = System.currentTimeMillis();
        LoggerProxy.d(str3, "time = " + currentTimeMillis);
        e3 e2 = e3.e();
        Context c = e2.c();
        boolean z = SharedPreferencesUtils.getBoolean(c, SharedPreferencesUtils.LICENSE_IS_REGISTER, false);
        String string = SharedPreferencesUtils.getString(c, SharedPreferencesUtils.LICENSE_LAST_SN, "");
        LoggerProxy.d(str3, "time = " + currentTimeMillis + " , isRegistered = " + z);
        if (string.equals(this.c) & z) {
            str = b + "/check?logid=" + currentTimeMillis;
        } else {
            str = b + "/register?logid=" + currentTimeMillis;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String d = e2.d();
            Context c2 = e2.c();
            String stringToMd5 = Utility.stringToMd5(this.b + d);
            int i = SharedPreferencesUtils.getInt(c2, SharedPreferencesUtils.LICENSE_LAST_ERROR_NO);
            q2 q2Var = q2.CUID;
            jSONObject.put("cuid", d);
            q2 q2Var2 = q2.SIGN;
            jSONObject.put(HttpConstants.SIGN, stringToMd5);
            q2 q2Var3 = q2.ID;
            jSONObject.put("id", this.b);
            q2 q2Var4 = q2.IS_PID;
            jSONObject.put("is_pid", 1);
            q2 q2Var5 = q2.APP_CODE;
            jSONObject.put("appid", this.f10125a);
            q2 q2Var6 = q2.SERIAL_NUMBER;
            jSONObject.put("sn", this.c);
            q2 q2Var7 = q2.APPNAME;
            jSONObject.put("app", Utility.getPackageName(c2));
            q2 q2Var8 = q2.SELFDEF;
            jSONObject.put("selfDef", "android.etts");
            q2 q2Var9 = q2.STA;
            jSONObject.put("sta", Utility.getPlatform(c2));
            q2 q2Var10 = q2.GETLICENSE_ERRNO;
            jSONObject.put("errno", i);
            q2 q2Var11 = q2.VERSION;
            jSONObject.put("sdkversion", "3.2.7.163009b");
            LoggerProxy.d(str3, "getLicense params: " + jSONObject.toString());
            str2 = jSONObject.toString();
        } catch (JSONException unused) {
            str2 = null;
        }
        a4Var.a(str, str2, "POST", kVar);
        int i2 = kVar.b;
        if (i2 == 0) {
            c4.a().a(str4, str);
        }
        return Integer.valueOf(i2);
    }
}
