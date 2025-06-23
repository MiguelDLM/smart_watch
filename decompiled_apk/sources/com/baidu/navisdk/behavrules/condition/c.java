package com.baidu.navisdk.behavrules.condition;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f6642a;
    public com.baidu.navisdk.behavrules.judge.f b;
    public com.baidu.navisdk.behavrules.judge.g c = new com.baidu.navisdk.behavrules.judge.d();
    private com.baidu.navisdk.behavrules.a d;

    public c(com.baidu.navisdk.behavrules.a aVar) {
        this.d = aVar;
    }

    public boolean a() {
        List<com.baidu.navisdk.behavrules.data.c> a2 = this.d.a();
        String str = null;
        for (int i = 0; i < a2.size(); i++) {
            str = a2.get(i).a(this.f6642a);
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.navisdk.behavrules.util.b.b("behavRulesBRuleDataJudge", "isTrue(), value = " + str);
        }
        boolean a3 = this.b.a(str);
        if (!a3) {
            com.baidu.navisdk.behavrules.util.b.a("behavRulesBRuleDataJudge", "isTrue() fail, value = " + str + " mKey = " + this.f6642a);
        }
        return a3;
    }

    public static c a(String str, String str2, com.baidu.navisdk.behavrules.a aVar) {
        c cVar = new c(aVar);
        cVar.f6642a = str;
        com.baidu.navisdk.behavrules.judge.f a2 = cVar.c.a(str2);
        if (a2 == null) {
            return null;
        }
        cVar.b = a2;
        return cVar;
    }
}
