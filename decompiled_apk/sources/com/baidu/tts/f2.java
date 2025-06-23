package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.Utility;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o0oIxXOx.oO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f2 {
    public static boolean a(Context context, String str) {
        boolean z;
        try {
            long j = SharedPreferencesUtils.getLong(context, "Success_Count", 0L);
            String str2 = j + FileUtils.FILE_EXTENSION_SEPARATOR + SharedPreferencesUtils.getLong(context, "Fail_Count", 0L);
            LoggerProxy.d("StatHelper", " postContent:" + str2);
            if (j < 1) {
                return false;
            }
            try {
                z = a(context, str, str2);
            } catch (Error e) {
                e.toString();
                z = false;
            }
            Utility.setLastUploadStatTime(context, System.currentTimeMillis());
            LoggerProxy.d("StatHelper", "update ret: " + z);
            if (!z) {
                return false;
            }
            SharedPreferencesUtils.putLong(context, "Success_Count", 0L);
            SharedPreferencesUtils.putLong(context, "Fail_Count", 0L);
            return true;
        } catch (Exception e2) {
            LoggerProxy.d("StatHelper", "exception:" + e2.toString());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean[] zArr = {false};
        y2 y2Var = y2.STATISTICS_SERVER;
        String str3 = y2Var.f10202a;
        String b = y2Var.b();
        String a2 = y2Var.a();
        Utility.getNetType(context);
        LoggerProxy.d("StatHelper", "statHelper url:" + b);
        JSONObject jSONObject = new JSONObject();
        String stringToMd5 = Utility.stringToMd5(str);
        String[] split = EmbeddedSynthesizerEngine.bdTTSGetAESKEY().split(":");
        String decryptBASE64 = Utility.decryptBASE64(split[0]);
        String decryptBASE642 = Utility.decryptBASE64(split[1]);
        try {
            String string = SharedPreferencesUtils.getString(context, "offline_speechDatInfo", "");
            jSONObject.put(TanxAdType.FEED_STRING, str2);
            jSONObject.put("cuid", e3.e().d());
            jSONObject.put(HttpConstants.SIGN, stringToMd5);
            jSONObject.put("app", Utility.getPackageName(context));
            jSONObject.put("selfDef", "android.etts");
            jSONObject.put("sdkversion", "3.2.7.163009b");
            jSONObject.put("platform", Utility.getPlatform(context));
            jSONObject.put("perinfo", string);
            jSONObject.put(oO.f31192XO, Utility.getOS());
            jSONObject.put("sdk_name", Utility.getSdkName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String AES_cbc_encrypt = CommonUtility.AES_cbc_encrypt(jSONObject.toString(), decryptBASE64, decryptBASE642);
        a4 a4Var = new a4();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", a2);
        a4Var.f = hashMap;
        a4Var.a(b, AES_cbc_encrypt, "POST", new a(context, zArr, str3, b));
        return zArr[0];
    }

    /* loaded from: classes8.dex */
    public static class a extends i4 {
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean[] c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(Context context, boolean[] zArr, String str, String str2) {
            this.b = context;
            this.c = zArr;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.tts.i4
        public void a(int i, Map<String, List<String>> map, String str, byte[] bArr) {
            String str2 = new String(bArr);
            LoggerProxy.d("StatHelper", " statusCode: " + i + " response=" + new String(bArr));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if ("0".equals(jSONObject.optString("err_no"))) {
                    long optLong = jSONObject.optLong(ClientCookie.EXPIRES_ATTR);
                    long optLong2 = jSONObject.optLong("time");
                    SharedPreferencesUtils.putLong(this.b, "statistics_expires", optLong);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - optLong2;
                    if (j < 60000 && j > 0) {
                        SharedPreferencesUtils.putLong(this.b, "statistics_time", optLong2);
                    } else {
                        SharedPreferencesUtils.putLong(this.b, "statistics_time", currentTimeMillis);
                    }
                    this.c[0] = true;
                    c4.a().a(this.d, this.e);
                    LoggerProxy.d("StatHelper", "ret=" + this.c[0]);
                }
            } catch (JSONException e) {
                LoggerProxy.d("StatHelper", "parse:" + e.toString());
            } catch (Exception e2) {
                LoggerProxy.d("StatHelper", "parse:" + e2.toString());
            }
        }

        @Override // com.baidu.tts.i4
        public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
            LoggerProxy.d("StatHelper", " statusCode: " + i + " responseBody: " + ((Object) null));
        }
    }
}
