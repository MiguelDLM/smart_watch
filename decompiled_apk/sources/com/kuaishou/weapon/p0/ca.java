package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18345a;

    public ca(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (!TextUtils.isEmpty(efg)) {
                try {
                    this.f18345a = new JSONObject(efg);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18345a;
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
