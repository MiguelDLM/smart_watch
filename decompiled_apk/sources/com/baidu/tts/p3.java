package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelBags;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class p3 extends e4 {
    public TtsError b;
    public ModelBags c;

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        LoggerProxy.d("GetListHttpHandler", "onFailure2");
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        TtsError a2 = c3.a().a(x2.f10190I0);
        a2.setCode(i);
        a2.setMessage(jSONObject2);
        a2.setThrowable(th);
        this.b = a2;
    }

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        LoggerProxy.d("GetListHttpHandler", "onSuccess response=" + jSONObject);
        q2 q2Var = q2.ERROR_NUMBER;
        int optInt = jSONObject.optInt("err_no");
        q2 q2Var2 = q2.ERROR_MESSAGE;
        String optString = jSONObject.optString("err_msg");
        if (optInt != 0 && optInt != -1004) {
            TtsError a2 = c3.a().a(x2.J0);
            a2.setCode(optInt);
            a2.setMessage(optString);
            a2.setThrowable(null);
            this.b = a2;
            return;
        }
        q2 q2Var3 = q2.DATA_LIST;
        JSONArray optJSONArray = jSONObject.optJSONArray("data_list");
        ModelBags modelBags = new ModelBags();
        this.c = modelBags;
        modelBags.parseJson(optJSONArray);
    }
}
