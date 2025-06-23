package com.baidu.navisdk.behavrules.judge;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public int f6652a;
    public int b;

    public static f b(String str) {
        try {
            e eVar = new e();
            JSONObject jSONObject = new JSONObject(str);
            eVar.f6652a = jSONObject.optInt("min", Integer.MIN_VALUE);
            eVar.b = jSONObject.optInt("max", Integer.MAX_VALUE);
            return eVar;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueMinMaxJudge", "parse(), json = " + str + " e = " + e);
            return null;
        }
    }

    @Override // com.baidu.navisdk.behavrules.judge.f
    public boolean a(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= this.f6652a) {
                if (parseInt <= this.b) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (NumberFormatException unused) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueMinMaxJudge", "isTrue(), value = " + str);
            return false;
        }
    }
}
