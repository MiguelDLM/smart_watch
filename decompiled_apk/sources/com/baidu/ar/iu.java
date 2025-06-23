package com.baidu.ar;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class iu extends AsyncTask<String, Void, List<String>> {
    private a zo;

    /* loaded from: classes7.dex */
    public interface a {
        void onPerformanceRequestFinished(List<String> list);
    }

    public iu(a aVar) {
        this.zo = aVar;
    }

    private List<String> bL(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            JSONObject jSONObject = optJSONObject != null ? optJSONObject.getJSONObject("statistic_swtich") : null;
            if (jSONObject != null && (length = jSONObject.length()) > 0) {
                ArrayList arrayList = new ArrayList(length);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("1".equals(jSONObject.opt(next))) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bM(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private String gc() {
        return String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", HttpConstants.HTTP_OS_TYPE, "android", HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(kg.getVersionCode()), "manufacture", bM(Build.MANUFACTURER), HttpConstants.HTTP_BOARD, bM(Build.BOARD), "hardware", bM(Build.HARDWARE));
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<String> doInBackground(String... strArr) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return null;
        }
        String hq = kw.hq();
        newRequest.setUrl(hq).setMethod("POST").setBody(gc()).addHeader("Content-Type: application/x-www-form-urlencoded");
        try {
            IHttpResponse execute = newRequest.execute();
            if (execute.isSuccess()) {
                return bL(execute.getContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<String> list) {
        super.onPostExecute(list);
        a aVar = this.zo;
        if (aVar != null) {
            aVar.onPerformanceRequestFinished(list);
        }
        this.zo = null;
    }
}
