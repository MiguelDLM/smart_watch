package com.baidu.navisdk.module.brule.matchpage;

import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.util.common.g;
import java.util.List;

/* loaded from: classes7.dex */
public class b implements n {
    @Override // com.baidu.navisdk.behavrules.condition.n
    public com.baidu.navisdk.behavrules.d a(List<String> list) {
        if (com.baidu.navisdk.asr.d.B().r()) {
            g gVar = g.BRULE;
            if (gVar.d()) {
                gVar.e("BNBRuleMatchPageBubble", "isAllMatched(), 小度唤醒中");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (com.baidu.navisdk.module.dynamicui.a.f.a().b()) {
            g gVar2 = g.BRULE;
            if (gVar2.d()) {
                gVar2.e("BNBRuleMatchPageBubble", "isAllMatched(), bubble 开启中");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public String e() {
        return "bubble";
    }
}
