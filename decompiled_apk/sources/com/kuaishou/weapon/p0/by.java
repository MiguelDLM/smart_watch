package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class by {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18341a;

    public by(Context context) {
        if (Engine.loadSuccess) {
            String cde = Engine.getInstance(context).cde();
            if (!TextUtils.isEmpty(cde)) {
                try {
                    this.f18341a = new JSONObject(cde);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18341a;
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
        JSONObject jSONObject = this.f18341a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    return new JSONArray(string);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
