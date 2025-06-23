package com.baidu.navisdk.behavrules.condition;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.behavrules.condition.a {
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* loaded from: classes7.dex */
    public static class a implements k {
        @Override // com.baidu.navisdk.behavrules.condition.k
        public j a(String str, com.baidu.navisdk.behavrules.scene.c cVar) {
            d dVar = new d(cVar);
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optInt("timediff", -1);
                dVar.c = jSONObject.optInt("one_day", -1);
                dVar.g = jSONObject.optInt("week", -1);
                dVar.f = jSONObject.optInt("one_month", -1);
                dVar.d = jSONObject.optInt("once_navi", -1);
                dVar.e = jSONObject.optInt("lifetime", -1);
                return dVar;
            } catch (JSONException e) {
                com.baidu.navisdk.behavrules.util.b.b("BRuleFreqStratgy", "parse(), json = " + str + " e = " + e);
                return null;
            }
        }
    }

    public d(com.baidu.navisdk.behavrules.scene.c cVar) {
        super(cVar);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
    }

    public boolean b(int i) {
        return i >= 0;
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public com.baidu.navisdk.behavrules.d l() {
        if (this.f6639a == null) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (b(this.d) && this.b.f().j(this.f6639a.g()) >= this.d) {
            return com.baidu.navisdk.behavrules.d.FALSE_MATCH_ONCE;
        }
        if (b(this.c) && this.b.f().g(this.f6639a.g()) >= this.c) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (b(this.g) && this.b.f().l(this.f6639a.g()) >= this.g) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (b(this.f) && this.b.f().i(this.f6639a.g()) >= this.f) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (b(this.e) && this.b.f().h(this.f6639a.g()) >= this.e) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }
}
