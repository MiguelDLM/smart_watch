package com.baidu.tts;

import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.tools.CommonUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class y4 extends a5<y4> {

    /* renamed from: a, reason: collision with root package name */
    public String f10206a;
    public String b;
    public String c;
    public s2 d;
    public String e;
    public JSONObject f;
    public JSONArray g;
    public JSONObject h;
    public String i;
    public volatile int j;

    public y4() {
        this.c = "0";
        this.i = null;
        this.j = 0;
        this.i = CommonUtility.generateSerialNumber();
        this.f = new JSONObject();
        this.g = new JSONArray();
    }

    public synchronized void a(String str, Object obj) {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("online");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    this.f.put("online", optJSONObject);
                    try {
                        optJSONObject.put(TtsStatsUploadBag.KEY_PACKAGE_INFOS, this.g);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                optJSONObject.put(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized void b(String str, Object obj) {
        try {
            JSONObject jSONObject = this.f;
            if (jSONObject != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("offline");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        this.f.put("offline", optJSONObject);
                    }
                    optJSONObject.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String c() {
        return this.i;
    }

    public void b(String str) {
        if (str == null) {
            str = "0";
        }
        this.c = str;
    }

    public y4(String str, String str2) {
        this();
        a(str);
        b(str2);
    }

    public int b() {
        return this.j;
    }

    public void a(String str) {
        this.f10206a = str;
    }
}
