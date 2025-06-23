package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class i5 extends e4 {
    public int b = -1;

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        TtsError a2 = c3.a().a(x2.f10190I0);
        a2.setCode(i);
        a2.setMessage(jSONObject2);
        a2.setThrowable(th);
    }

    @Override // com.baidu.tts.e4
    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        q2 q2Var = q2.ERROR_NUMBER;
        int optInt = jSONObject.optInt("err_no");
        q2 q2Var2 = q2.ERROR_MESSAGE;
        String optString = jSONObject.optString("err_msg");
        if (optInt == 0) {
            this.b = optInt;
            return;
        }
        TtsError a2 = c3.a().a(x2.J0);
        a2.setCode(optInt);
        a2.setMessage(optString);
        a2.setThrowable(null);
    }
}
