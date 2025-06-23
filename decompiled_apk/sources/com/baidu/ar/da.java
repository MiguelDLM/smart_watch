package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.content.ARResourceInfo;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class da extends gr<String, List<IARCaseInfo>> {
    private IHttpRequest eQ;
    private WeakReference<Context> of;

    public da(Context context) {
        this.of = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<IARCaseInfo> Y(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorNum", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optInt == 0 && optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    ARResourceInfo e = e(optJSONArray.optJSONObject(i));
                    if (e != null) {
                        arrayList.add(e);
                    }
                }
            }
        } catch (JSONException e2) {
            kf.b(getClass().getName(), "parse err: " + e2.getMessage());
        }
        return arrayList;
    }

    private JSONObject c(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            ks.k(jSONObject);
            ks.b(context, jSONObject);
            ks.a(context, jSONObject, str, "");
            ks.a(context, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private ARResourceInfo e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("ar_key");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        ARResourceInfo aRResourceInfo = new ARResourceInfo();
        aRResourceInfo.arKey = optString;
        aRResourceInfo.arType = jSONObject.optInt("ar_type");
        aRResourceInfo.thumbnailUrl = jSONObject.optString("image_url");
        aRResourceInfo.versionCode = jSONObject.optString("version_code");
        return aRResourceInfo;
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
    public void a(String str, final ICallbackWith<List<IARCaseInfo>> iCallbackWith, final IError iError) {
        Context context = this.of.get();
        if (context == null) {
            return;
        }
        String hm = kw.hm();
        JSONObject c = c(context, str);
        IHttpRequest newRequest = HttpFactory.newRequest();
        this.eQ = newRequest;
        if (newRequest == null) {
            return;
        }
        newRequest.setUrl(hm).setMethod("POST").setBody(c).enqueue(new fa() { // from class: com.baidu.ar.da.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                IError iError2 = iError;
                if (iError2 != null) {
                    iError2.onError(httpException.getCode(), httpException.getMessage(), httpException);
                }
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                String message;
                int i;
                IError iError2;
                if (iHttpResponse.isSuccess()) {
                    try {
                        String content = iHttpResponse.getContent();
                        if (iCallbackWith != null) {
                            iCallbackWith.run(da.this.Y(content));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        message = e.getMessage();
                        i = 101;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        message = e2.getMessage();
                        i = 103;
                    }
                }
                i = 0;
                message = null;
                if (TextUtils.isEmpty(message) || (iError2 = iError) == null) {
                    return;
                }
                iError2.onError(i, message, null);
            }
        });
    }
}
