package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.tools.JsonTool;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class u3 implements Callable<ModelFileBags> {

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f10177a;

    public u3(Set<String> set) {
        this.f10177a = set;
    }

    @Override // java.util.concurrent.Callable
    public ModelFileBags call() throws Exception {
        String str;
        a4 a4Var = new a4();
        y2 y2Var = y2.MODEL_SERVER;
        String str2 = y2Var.f10202a;
        String str3 = y2Var.b() + "https=1";
        String a2 = y2Var.a();
        HashMap hashMap = new HashMap();
        hashMap.put("Host", a2);
        a4Var.f = hashMap;
        try {
            JSONObject jSONObject = new JSONObject();
            q2 q2Var = q2.FUNCTION;
            jSONObject.put("func", "getURL");
            q2 q2Var2 = q2.IVERSION;
            jSONObject.put("iversion", "2");
            JSONArray fromSetToJson = JsonTool.fromSetToJson(this.f10177a);
            q2 q2Var3 = q2.ID;
            jSONObject.put("id", fromSetToJson);
            LoggerProxy.d("GetServerModelFileInfosWork", "geturl params=" + jSONObject.toString());
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        s3 s3Var = new s3();
        a4Var.a(str3, str, "POST", s3Var);
        ModelFileBags modelFileBags = s3Var.c;
        if (s3Var.b != null) {
            c4.a().a(str2, str3);
        }
        return modelFileBags;
    }
}
