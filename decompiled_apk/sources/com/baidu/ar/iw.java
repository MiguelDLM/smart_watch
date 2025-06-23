package com.baidu.ar;

import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class iw extends is implements in {
    @Override // com.baidu.ar.is
    public JSONObject a(JSONObject jSONObject, ij ijVar) {
        return jSONObject;
    }

    @Override // com.baidu.ar.is
    public Map<String, Object> i(List<ij> list) {
        return null;
    }

    @Override // com.baidu.ar.is
    public void k(JSONObject jSONObject) {
    }

    @Override // com.baidu.ar.is
    public void l(JSONObject jSONObject) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setUrl(kw.hp()).setMethod("POST").setBody("info=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).addHeader("Content-Type: application/x-www-form-urlencoded");
        newRequest.execute();
    }
}
