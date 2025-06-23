package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class s3 extends e4 {
    public TtsError b;
    public ModelFileBags c;

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        LoggerProxy.d("GetModelFileInfosHttpHandler", "onSuccess response=" + jSONObject);
        q2 q2Var = q2.ERROR_NUMBER;
        int optInt = jSONObject.optInt("err_no");
        q2 q2Var2 = q2.ERROR_MESSAGE;
        String optString = jSONObject.optString("err_msg");
        if (optInt != 0 && optInt != -4005) {
            TtsError a2 = c3.a().a(x2.J0);
            a2.setCode(optInt);
            a2.setMessage(optString);
            a2.setThrowable(null);
            this.b = a2;
            return;
        }
        q2 q2Var3 = q2.DATA;
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        ModelFileBags modelFileBags = new ModelFileBags();
        this.c = modelFileBags;
        modelFileBags.parseJson(optJSONArray);
    }

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        LoggerProxy.d("GetModelFileInfosHttpHandler", "onFailure2");
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        TtsError a2 = c3.a().a(x2.f10190I0);
        a2.setCode(i);
        a2.setMessage(jSONObject2);
        a2.setThrowable(th);
        this.b = a2;
    }
}
