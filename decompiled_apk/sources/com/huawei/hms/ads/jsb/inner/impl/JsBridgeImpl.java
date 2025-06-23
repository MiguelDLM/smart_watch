package com.huawei.hms.ads.jsb.inner.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ad;
import com.huawei.hms.ads.ag;
import com.huawei.hms.ads.ai;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bh;
import com.huawei.openalliance.ad.utils.h;
import org.json.JSONObject;

@AllApi
/* loaded from: classes10.dex */
public class JsBridgeImpl {
    private static final String Code = "JsBridgeImpl";

    /* loaded from: classes10.dex */
    public static class a<T> implements Runnable {
        private ad B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ad adVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsBridgeImpl.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ad adVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (adVar == null) {
            String str3 = "api for " + str + " is not found";
            fb.V(Code, "call " + str3);
            ag.Code(remoteCallResultCallback, str, 1011, str3, true);
            return;
        }
        fb.V(Code, "call method: " + str);
        if (fb.Code()) {
            fb.Code(Code, "param: %s", bh.Code(str2));
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("content");
            adVar.Code(jSONObject.optString("url"));
            adVar.V(jSONObject.optString("cid"));
            adVar.execute(context, optString, remoteCallResultCallback);
        } catch (Throwable th) {
            fb.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            ag.Code(remoteCallResultCallback, str, 1011, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
            fb.Code(3, th);
        }
    }

    @AllApi
    public static void initConfig(Context context, JsbConfig jsbConfig) {
        com.huawei.hms.ads.jsb.a.Code(context).Code(jsbConfig);
    }

    @AllApi
    public static String invoke(Context context, String str, String str2) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        int i = 1011;
        if (context != null) {
            try {
            } catch (Throwable th) {
                fb.I(Code, "call method : " + th.getClass().getSimpleName());
                obj = "call " + str + " " + th.getClass().getSimpleName() + ":" + th.getMessage();
            }
            if (!TextUtils.isEmpty(str2)) {
                ad Code2 = ai.Code().Code(str);
                if (Code2 != null) {
                    fb.V(Code, "call api: " + str);
                    obj = Code2.Code(context.getApplicationContext(), new JSONObject(str2).optString("content"));
                    i = 1000;
                } else {
                    obj = null;
                }
                try {
                    jSONObject.put("code", i);
                    jSONObject.put("data", obj);
                } catch (Throwable th2) {
                    fb.I(Code, "call method : " + th2.getClass().getSimpleName());
                }
                return jSONObject.toString();
            }
        }
        fb.Z(Code, "param is invalid, please check it!");
        jSONObject.put("msg", "invalid params");
        jSONObject.put("code", 1011);
        return jSONObject.toString();
    }

    @AllApi
    public static void invoke(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) {
        if (context == null || TextUtils.isEmpty(str2)) {
            fb.Z(Code, "param is invalid, please check it!");
            ag.Code(remoteCallResultCallback, str, 1001, null, true);
            return;
        }
        ad Code2 = ai.Code().Code(str);
        h.a aVar = h.a.IO;
        if (Code2 != null) {
            aVar = Code2.Code();
            if (ai.Code().Code(str, context)) {
                Code2.Code((Activity) context);
            }
        }
        h.Code(new a(context.getApplicationContext(), Code2, str, str2, remoteCallResultCallback), aVar, false);
    }
}
