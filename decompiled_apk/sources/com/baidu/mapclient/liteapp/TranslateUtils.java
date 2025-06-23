package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.baidu.mapclient.liteapp.TranslateUtils;
import com.blankj.utilcode.util.LogUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class TranslateUtils {

    @OOXIXo
    public static final TranslateUtils INSTANCE = new TranslateUtils();

    @OOXIXo
    private static final String TAG = "TranslateUtils";

    /* loaded from: classes7.dex */
    public interface TransCallback {
        void onError(@OOXIXo String str);

        void onSuccess(@OOXIXo String str);
    }

    private TranslateUtils() {
    }

    @OOXIXo
    public final String getTAG() {
        return TAG;
    }

    public final void trans(@OOXIXo String text, @oOoXoXO final TransCallback transCallback) {
        IIX0o.x0xO0oo(text, "text");
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(" trans start -> ");
        sb.append(text);
        LogUtils.d(sb.toString());
        AndroidNetworking.cancel(str);
        AndroidNetworking.get("https://fanyi.youdao.com/translate?&doctype=json&type=ZH_CN2EN&i=" + text).setTag((Object) str).setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.baidu.mapclient.liteapp.TranslateUtils$trans$1
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                TranslateUtils.TransCallback transCallback2 = TranslateUtils.TransCallback.this;
                if (transCallback2 != null) {
                    transCallback2.onError(String.valueOf(aNError));
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:4:0x0025  */
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponse(@OXOo.oOoXoXO org.json.JSONObject r2) {
                /*
                    r1 = this;
                    if (r2 == 0) goto L22
                    java.lang.String r0 = "translateResult"
                    org.json.JSONArray r2 = r2.getJSONArray(r0)     // Catch: java.lang.Exception -> L20
                    if (r2 == 0) goto L22
                    r0 = 0
                    org.json.JSONArray r2 = r2.getJSONArray(r0)     // Catch: java.lang.Exception -> L20
                    if (r2 == 0) goto L22
                    org.json.JSONObject r2 = r2.getJSONObject(r0)     // Catch: java.lang.Exception -> L20
                    if (r2 == 0) goto L22
                    java.lang.String r0 = "tgt"
                    java.lang.String r2 = r2.getString(r0)     // Catch: java.lang.Exception -> L20
                    goto L23
                L20:
                    r2 = move-exception
                    goto L35
                L22:
                    r2 = 0
                L23:
                    if (r2 != 0) goto L27
                    java.lang.String r2 = ""
                L27:
                    boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L20
                    if (r0 != 0) goto L43
                    com.baidu.mapclient.liteapp.TranslateUtils$TransCallback r0 = com.baidu.mapclient.liteapp.TranslateUtils.TransCallback.this     // Catch: java.lang.Exception -> L20
                    if (r0 == 0) goto L43
                    r0.onSuccess(r2)     // Catch: java.lang.Exception -> L20
                    goto L43
                L35:
                    r2.printStackTrace()
                    com.baidu.mapclient.liteapp.TranslateUtils$TransCallback r0 = com.baidu.mapclient.liteapp.TranslateUtils.TransCallback.this
                    if (r0 == 0) goto L43
                    java.lang.String r2 = r2.toString()
                    r0.onError(r2)
                L43:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapclient.liteapp.TranslateUtils$trans$1.onResponse(org.json.JSONObject):void");
            }
        });
    }
}
