package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cc {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18347a;

    public cc(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String bcd = Engine.bcd();
            if (!TextUtils.isEmpty(bcd) && bcd.length() > 2) {
                try {
                    this.f18347a = new JSONObject(bcd);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18347a;
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
