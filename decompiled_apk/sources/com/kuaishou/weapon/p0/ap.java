package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18309a;

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.g).intValue(), 0, 0, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18309a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f18309a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string) && string.length() > 3) {
                    return new JSONObject(string);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f18309a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("{}")) {
                        return null;
                    }
                    return string;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
