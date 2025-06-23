package com.baidu.ar;

import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class lu {
    public static void a(String str, JSONObject jSONObject, fa faVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest != null) {
            newRequest.setMethod("POST").setUrl(str).setBody(jSONObject);
            newRequest.enqueue(faVar);
        }
    }

    public static void b(fa faVar, byte[] bArr) {
        try {
            HttpFactory.newRequest().setUrl(kw.hw()).addHeader("Content-Type:application/protobuf").setMethod("POST").setBody(bArr).enqueue(faVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
