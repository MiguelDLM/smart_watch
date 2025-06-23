package com.baidu.navisdk.module.brule.matchpage;

import com.baidu.navisdk.asr.f;
import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.util.common.g;
import java.util.List;

/* loaded from: classes7.dex */
public class a implements n {
    @Override // com.baidu.navisdk.behavrules.condition.n
    public com.baidu.navisdk.behavrules.d a(List<String> list) {
        if (!com.baidu.navisdk.asr.d.B().q()) {
            g gVar = g.BRULE;
            if (gVar.d()) {
                gVar.e("BNBRuleMatchPageAsr", "isAllMatched(), 小度不可唤醒");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (com.baidu.navisdk.module.dynamicui.a.f.a().c()) {
            g gVar2 = g.BRULE;
            if (gVar2.d()) {
                gVar2.e("BNBRuleMatchPageAsr", "isAllMatched(), dialog 开启中");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (!f.a()) {
            g gVar3 = g.BRULE;
            if (gVar3.d()) {
                gVar3.e("BNBRuleMatchPageAsr", "isAllMatched(), 小度没有麦克风权限等");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (com.baidu.navisdk.asr.d.B().r()) {
            g gVar4 = g.BRULE;
            if (gVar4.d()) {
                gVar4.e("BNBRuleMatchPageAsr", "isAllMatched(), 小度唤醒中");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (list.contains("routeResult") && com.baidu.navisdk.asr.d.B().s()) {
            g gVar5 = g.BRULE;
            if (gVar5.d()) {
                gVar5.e("BNBRuleMatchPageAsr", "isAllMatched(), 小度基线监听唤醒中");
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public String e() {
        return "xd";
    }
}
