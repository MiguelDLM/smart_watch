package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class v3 implements Callable<ModelBags> {

    /* renamed from: a, reason: collision with root package name */
    public Conditions f10182a;

    public v3(Conditions conditions) {
        this.f10182a = conditions;
    }

    @Override // java.util.concurrent.Callable
    public ModelBags call() throws Exception {
        a4 a4Var = new a4();
        y2 y2Var = y2.MODEL_SERVER;
        String str = y2Var.f10202a;
        String b = y2Var.b();
        String a2 = y2Var.a();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", a2);
        a4Var.f = hashMap;
        JSONObject jSONConditions = this.f10182a.getJSONConditions();
        try {
            q2 q2Var = q2.IVERSION;
            jSONConditions.put("iversion", "2");
            q2 q2Var2 = q2.FUNCTION;
            jSONConditions.put("func", "getList");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject = jSONConditions.toString();
        LoggerProxy.d("GetServerModelsWork", "getlist params=" + jSONObject);
        p3 p3Var = new p3();
        a4Var.a(b, jSONObject, "POST", p3Var);
        ModelBags modelBags = p3Var.c;
        if (p3Var.b != null) {
            c4.a().a(str, b);
        }
        return modelBags;
    }
}
