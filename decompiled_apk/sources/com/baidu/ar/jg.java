package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class jg extends gr<String, String> {
    private IHttpRequest eQ;
    private WeakReference<Context> of;
    private ARCaseBundleInfo zW;
    private jc zY;

    public jg(Context context, ARCaseBundleInfo aRCaseBundleInfo, jc jcVar) {
        this.of = new WeakReference<>(context);
        this.zW = aRCaseBundleInfo;
        this.zY = jcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bO(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("errorNum") != 0) {
            throw new Exception(jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "query res failed"));
        }
        String string = jSONObject.getString("data");
        if (TextUtils.isEmpty(string)) {
            throw new Exception("query res failed");
        }
        return string;
    }

    private JSONObject c(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            ks.k(jSONObject);
            ks.b(context, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.ar.gr
    public void cK() {
        IHttpRequest iHttpRequest = this.eQ;
        if (iHttpRequest != null) {
            iHttpRequest.cancel();
            this.eQ = null;
        }
    }

    @Override // com.baidu.ar.gr
    public void a(String str, final ICallbackWith<String> iCallbackWith, final IError iError) {
        ARCaseBundleInfo aRCaseBundleInfo;
        Context context = this.of.get();
        if (context == null || (aRCaseBundleInfo = this.zW) == null) {
            return;
        }
        String str2 = aRCaseBundleInfo.arKey;
        jh bN = this.zY.bN(str);
        if (bN == null) {
            iError.onError(1, "资源不存在", null);
            return;
        }
        if (TextUtils.isEmpty(bN.Ai)) {
            iError.onError(1, "资源id不存在", null);
            return;
        }
        if ("local".equals(bN.Ai)) {
            iCallbackWith.run("local");
            return;
        }
        if (TextUtils.isEmpty(bN.Aj)) {
            iError.onError(1, "编码不正确", null);
            return;
        }
        StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
        String hs = kw.hs();
        IHttpRequest newRequest = HttpFactory.newRequest();
        this.eQ = newRequest;
        newRequest.setUrl(hs).setMethod("POST").addQueryField("id", bN.Ai).setBody(c(context, str2)).enqueue(new fa() { // from class: com.baidu.ar.jg.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                IError iError2 = iError;
                if (iError2 != null) {
                    iError2.onError(1, httpException.getMessage(), httpException);
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                String message;
                int i;
                if (iHttpResponse.isSuccess()) {
                    try {
                        String bO = jg.this.bO(iHttpResponse.getContent());
                        ICallbackWith iCallbackWith2 = iCallbackWith;
                        if (iCallbackWith2 != null) {
                            iCallbackWith2.run(bO);
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        message = e.getMessage();
                        i = 3;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        message = e.getMessage();
                        i = 1;
                    }
                }
                i = 0;
                e = null;
                message = null;
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                IError iError2 = iError;
                if (iError2 != null) {
                    iError2.onError(i, message, e);
                }
            }
        });
    }
}
