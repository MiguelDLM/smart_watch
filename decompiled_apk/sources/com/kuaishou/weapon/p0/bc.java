package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18323a;

    public bc(Context context, String str, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(i, 0, cu.a() ? 1 : 0, str);
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18323a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18323a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
