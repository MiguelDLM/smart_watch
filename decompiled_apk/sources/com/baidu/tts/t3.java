package com.baidu.tts;

import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class t3 implements Callable<ModelBags> {
    @Override // java.util.concurrent.Callable
    public ModelBags call() throws Exception {
        String str;
        a4 a4Var = new a4();
        y2 y2Var = y2.MODEL_SERVER;
        String str2 = y2Var.f10202a;
        String b = y2Var.b();
        String a2 = y2Var.a();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", a2);
        a4Var.f = hashMap;
        try {
            JSONObject jSONObject = new JSONObject(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
            q2 q2Var = q2.FUNCTION;
            jSONObject.put("func", "getDefaultList");
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        p3 p3Var = new p3();
        a4Var.a(b, str, "POST", p3Var);
        ModelBags modelBags = p3Var.c;
        if (p3Var.b != null) {
            c4.a().a(str2, b);
        }
        return modelBags;
    }
}
