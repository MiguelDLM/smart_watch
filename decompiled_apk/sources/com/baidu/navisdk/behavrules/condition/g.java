package com.baidu.navisdk.behavrules.condition;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class g implements l {

    /* renamed from: a, reason: collision with root package name */
    private String f6643a;
    private com.baidu.navisdk.behavrules.a b;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;

    public g(String str, com.baidu.navisdk.behavrules.a aVar) {
        this.f6643a = str;
        this.b = aVar;
    }

    public boolean a(int i) {
        return i >= 0;
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public void d() {
    }

    @Override // com.baidu.navisdk.behavrules.condition.l
    public String e() {
        return this.f6643a;
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public com.baidu.navisdk.behavrules.d l() {
        if (!a()) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleTypeFreqCondition", "isAllMatched(), 不满足Type时间间隔");
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (a(this.d) && this.b.f().g(this.f6643a) >= this.d) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (a(this.h) && this.b.f().l(this.f6643a) >= this.h) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (a(this.g) && this.b.f().i(this.f6643a) >= this.g) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        if (a(this.e) && this.b.f().j(this.f6643a) >= this.e) {
            return com.baidu.navisdk.behavrules.d.FALSE_MATCH_ONCE;
        }
        if (a(this.f) && this.b.f().h(this.f6643a) >= this.f) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.condition.l
    public int n() {
        return this.c;
    }

    public boolean a() {
        return !a(this.c) || System.currentTimeMillis() - this.b.f().k(this.f6643a) >= ((long) this.c);
    }

    public static g a(String str, String str2, com.baidu.navisdk.behavrules.a aVar) {
        try {
            g gVar = new g(str, aVar);
            JSONObject jSONObject = new JSONObject(str2);
            gVar.c = jSONObject.optInt("timediff", -1) * 1000;
            gVar.d = jSONObject.optInt("one_day", -1);
            gVar.h = jSONObject.optInt("week", -1);
            gVar.g = jSONObject.optInt("one_month", -1);
            gVar.e = jSONObject.optInt("once_navi", -1);
            gVar.f = jSONObject.optInt("lifetime", -1);
            return gVar;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleTypeFreqCondition", "updateItem(), json = " + str2 + " e = " + e);
            return null;
        }
    }
}
