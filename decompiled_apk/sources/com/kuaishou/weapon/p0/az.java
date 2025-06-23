package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18319a;

    public az(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.c).intValue(), 2, i < 10 ? 10 : i, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18319a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f18319a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str) {
        try {
            String b = b(str);
            if (!TextUtils.isEmpty(b)) {
                return new JSONObject(b);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
