package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cd {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18348a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String hij = Engine.getInstance(context).hij();
            if (!TextUtils.isEmpty(hij)) {
                try {
                    this.f18348a = new JSONObject(hij);
                } catch (Exception unused) {
                }
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18348a;
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
