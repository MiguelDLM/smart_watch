package com.baidu.tts;

import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class o3 implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public JSONArray f10146a;

    public o3(JSONArray jSONArray) {
        this.f10146a = jSONArray;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
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
            JSONObject jSONObject = new JSONObject();
            q2 q2Var = q2.FUNCTION;
            jSONObject.put("func", "checkUpdate");
            q2 q2Var2 = q2.MODELSINFO;
            jSONObject.put("modelsinfo", this.f10146a);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        String[] strArr = {""};
        a4Var.a(b, str, "POST", new n3(this, strArr, str2, b));
        return strArr[0];
    }
}
