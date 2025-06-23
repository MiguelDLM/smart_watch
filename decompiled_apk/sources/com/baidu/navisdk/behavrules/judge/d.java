package com.baidu.navisdk.behavrules.judge;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d implements g {
    @Override // com.baidu.navisdk.behavrules.judge.g
    public f a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("equals")) {
                return b.b(str);
            }
            if (!jSONObject.has("max") && !jSONObject.has("min")) {
                if (!jSONObject.has("in") && !jSONObject.has("no_in")) {
                    if (jSONObject.has("nocontains") || jSONObject.has("contains")) {
                        return a.b(str);
                    }
                    return null;
                }
                return c.b(str);
            }
            return e.b(str);
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueJudgeFactory", "parse(), json = " + str + " e = " + e);
            return null;
        }
    }
}
