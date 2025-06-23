package com.baidu.navisdk.behavrules.judge;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f6649a;
    private boolean b;

    public static f b(String str) {
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("contains")) {
                aVar.b = true;
                aVar.f6649a = jSONObject.getString("contains");
                return aVar;
            }
            if (jSONObject.has("nocontains")) {
                aVar.b = false;
                aVar.f6649a = jSONObject.getString("nocontains");
                return aVar;
            }
            return null;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueContainsJudge", "parse(), json = " + str + " e = " + e);
            return null;
        }
    }

    @Override // com.baidu.navisdk.behavrules.judge.f
    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.b && str.contains(this.f6649a)) {
                return true;
            }
            if (!this.b && !str.contains(this.f6649a)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
