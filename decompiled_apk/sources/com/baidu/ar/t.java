package com.baidu.ar;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class t {
    private static final String TAG = "t";
    private IHttpRequest eQ;
    private ICallbackWith<String> eR;

    private boolean d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || !jSONObject.has("common") || (optJSONObject = jSONObject.optJSONObject("common")) == null || !optJSONObject.has("cpu_score")) {
            return false;
        }
        Object opt = optJSONObject.opt("cpu_score");
        return opt instanceof String ? Integer.parseInt((String) opt) > 0 : (opt instanceof Number) && Integer.parseInt(opt.toString()) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o w(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.eR != null) {
                x("response is empty");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_num", -1);
            if (optInt == 0 && jSONObject.has("data")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("classification")) {
                    o oVar = new o();
                    oVar.eH = optJSONObject.getJSONObject("classification");
                    oVar.eG = optJSONObject.optString("classification_id", "default");
                    if (!d(oVar.eH) && this.eR != null) {
                        String str2 = TAG;
                        kf.b(str2, str);
                        x("config format is error. see Logcat filter: " + str2);
                    }
                    return oVar;
                }
            } else if (this.eR != null) {
                x("err_num: " + optInt + " " + (jSONObject.has("err_msg") ? jSONObject.getString("err_msg") : ""));
            }
        } catch (JSONException e) {
            if (this.eR != null) {
                x(e.getMessage());
            }
            e.printStackTrace();
        }
        return null;
    }

    private void x(String str) {
        this.eR.run("fetch ability scheme config fail. " + str);
    }

    public void c(ICallbackWith<String> iCallbackWith) {
        this.eR = iCallbackWith;
    }

    public void cancel() {
        this.eR = null;
        IHttpRequest iHttpRequest = this.eQ;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
            this.eQ = null;
        }
    }

    private JSONObject a(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            ks.k(jSONObject);
            ks.b(context, jSONObject);
            ks.a(context, jSONObject);
            jSONObject.put("device_platform", "");
            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", ks.v(context));
            jSONObject.put(HttpConstants.APP_VERSION, kg.getVersionCode());
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put("hardware", Build.HARDWARE);
            jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            jSONObject.put("classification_id", str);
            kf.c(TAG, "params: " + jSONObject.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void a(Context context, String str, final ICallbackWith<o> iCallbackWith) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(kw.ht()).setBody(a(context, str));
        newRequest.enqueue(new fa() { // from class: com.baidu.ar.t.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                kf.c(t.TAG, "" + httpException.getMessage());
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                if (!iHttpResponse.isSuccess() || iCallbackWith == null) {
                    return;
                }
                try {
                    String content = iHttpResponse.getContent();
                    kf.c(t.TAG, "response: " + content);
                    o w = t.this.w(content);
                    if (w != null) {
                        iCallbackWith.run(w);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.eQ = newRequest;
    }
}
