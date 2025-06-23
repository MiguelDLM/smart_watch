package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.q2;
import com.baidu.tts.tools.ResourceTools;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ModelFileInfo {

    /* renamed from: a, reason: collision with root package name */
    public String f10061a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public void generateAbsPath(Context context) {
        this.e = ResourceTools.getModelFileAbsName(context, this.d);
    }

    public String getAbsPath() {
        return this.e;
    }

    public String getLength() {
        return this.b;
    }

    public String getMd5() {
        return this.c;
    }

    public String getName() {
        return this.d;
    }

    public String getServerid() {
        return this.f10061a;
    }

    public String getUrl() {
        return this.f;
    }

    public void parseJson(JSONObject jSONObject) {
        q2 q2Var = q2.ID;
        this.f10061a = jSONObject.optString("id");
        q2 q2Var2 = q2.LENGTH;
        this.b = jSONObject.optString("length");
        q2 q2Var3 = q2.MD5;
        this.c = jSONObject.optString("md5");
        q2 q2Var4 = q2.NAME;
        this.d = jSONObject.optString("name");
        q2 q2Var5 = q2.URL;
        this.f = jSONObject.optString("url");
    }

    public void setAbsPath(String str) {
        this.e = str;
    }

    public void setLength(String str) {
        this.b = str;
    }

    public void setMap(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            q2 q2Var = q2.ID;
            this.f10061a = map.get("id");
            q2 q2Var2 = q2.LENGTH;
            this.b = map.get("length");
            q2 q2Var3 = q2.MD5;
            this.c = map.get("md5");
            q2 q2Var4 = q2.NAME;
            this.d = map.get("name");
            q2 q2Var5 = q2.ABS_PATH;
            this.e = map.get("absPath");
            return;
        }
        LoggerProxy.d("ModelFileInfo", "map is null or isEmpty");
    }

    public void setMd5(String str) {
        this.c = str;
    }

    public void setName(String str) {
        this.d = str;
    }

    public void setServerid(String str) {
        this.f10061a = str;
    }

    public void setUrl(String str) {
        this.f = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            q2 q2Var = q2.ID;
            jSONObject.putOpt("id", this.f10061a);
            q2 q2Var2 = q2.LENGTH;
            jSONObject.putOpt("length", this.b);
            q2 q2Var3 = q2.MD5;
            jSONObject.putOpt("md5", this.c);
            q2 q2Var4 = q2.NAME;
            jSONObject.putOpt("name", this.d);
            q2 q2Var5 = q2.ABS_PATH;
            jSONObject.putOpt("absPath", this.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
