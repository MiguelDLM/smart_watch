package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18349a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String abc = Engine.abc();
            if (!TextUtils.isEmpty(abc)) {
                try {
                    this.f18349a = new JSONObject(abc);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18349a;
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
