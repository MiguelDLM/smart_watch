package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.content.ARResourceInfo;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class cz extends gr<String[], ARResourceInfo> {
    private IHttpRequest eQ;
    private cx od;
    private WeakReference<Context> of;

    public cz(Context context, cx cxVar) {
        this.of = new WeakReference<>(context);
        this.od = cxVar;
    }

    private JSONObject a(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            cx cxVar = this.od;
            if (cxVar == null) {
                ks.k(jSONObject);
            } else {
                ks.a(jSONObject, cxVar.appId, cxVar.oc);
            }
            ks.b(context, jSONObject);
            ks.a(context, jSONObject, str, str2);
            ks.a(context, jSONObject);
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
    public void a(String[] strArr, final ICallbackWith<ARResourceInfo> iCallbackWith, final IError iError) {
        Context context = this.of.get();
        if (context == null) {
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String hl = kw.hl();
        JSONObject a2 = a(context, str, str2);
        IHttpRequest newRequest = HttpFactory.newRequest();
        this.eQ = newRequest;
        if (newRequest == null) {
            return;
        }
        StatisticApi.onEvent(StatisticConstants.FIRST_LOAD_START_QUERY);
        this.eQ.setUrl(hl).setMethod("POST").setBody(a2).enqueue(new fa() { // from class: com.baidu.ar.cz.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                StatisticApi.onEvent(StatisticConstants.FIRST_LOAD_QUERY_FAILURE);
                IError iError2 = iError;
                if (iError2 != null) {
                    iError2.onError(httpException.getCode(), httpException.getMessage(), httpException);
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                String message;
                int i;
                if (iHttpResponse.isSuccess()) {
                    try {
                        ARResourceInfo X = ct.X(iHttpResponse.getContent());
                        ICallbackWith iCallbackWith2 = iCallbackWith;
                        if (iCallbackWith2 != null) {
                            iCallbackWith2.run(X);
                        }
                    } catch (HttpException e) {
                        e.printStackTrace();
                        i = e.getCode();
                        message = e.getMessage();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        message = e2.getMessage();
                        i = 101;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        message = e3.getMessage();
                        i = 103;
                    }
                }
                i = 0;
                message = null;
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                StatisticApi.onEvent(StatisticConstants.FIRST_LOAD_QUERY_FAILURE);
                IError iError2 = iError;
                if (iError2 != null) {
                    iError2.onError(i, message, null);
                }
            }
        });
    }
}
