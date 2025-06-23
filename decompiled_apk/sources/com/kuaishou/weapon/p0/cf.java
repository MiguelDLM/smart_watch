package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18350a;

    public cf(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (!TextUtils.isEmpty(nop)) {
                try {
                    this.f18350a = new JSONObject(nop);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18350a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f18350a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    try {
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                String a2 = f.a(jSONObject2.optString("1"));
                                String a3 = f.a(jSONObject2.optString("2"));
                                if (!TextUtils.isEmpty(a2)) {
                                    jSONObject2.put("1", a2);
                                }
                                if (!TextUtils.isEmpty(a3)) {
                                    jSONObject2.put("2", a3);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONArray;
                }
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }
}
