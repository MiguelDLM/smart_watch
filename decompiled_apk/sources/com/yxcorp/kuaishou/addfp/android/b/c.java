package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    boolean f27637a;
    int b;
    boolean c;
    String d;

    public c(String str) {
        this.f27637a = true;
        if (TextUtils.isEmpty(str)) {
            this.f27637a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("errorCode", 2);
            this.c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e) {
            this.f27637a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (!this.f27637a) {
            return "KWE_OTHER";
        }
        if (z != this.c) {
            return "KWE_NPN";
        }
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return "KWE_OTHER";
                        }
                        return "KWE_NS";
                    }
                    return "KWE_N";
                }
                return "KWE_PE";
            }
            return "KWE_PN";
        }
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        return "KWE_N";
    }
}
