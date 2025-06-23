package com.baidu.navisdk.ui.routeguide.brule.matchpage;

import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.ui.routeguide.brule.matchpage.e;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import java.util.List;

/* loaded from: classes8.dex */
public class c implements n {

    /* renamed from: a, reason: collision with root package name */
    private final e f8518a = new e.f().a();

    @Override // com.baidu.navisdk.behavrules.condition.n
    public com.baidu.navisdk.behavrules.d a(List<String> list) {
        if (list.contains("dialog") || list.contains("bubble")) {
            if (x.b().x0()) {
                g gVar = g.BRULE;
                if (gVar.d()) {
                    gVar.e("behavRulesBNRGAsrSceneOccurMatch", "isAllMatched(), 行中dialog展示中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (s.T().l() || s.T().j()) {
                g gVar2 = g.BRULE;
                if (gVar2.d()) {
                    gVar2.e("behavRulesBNRGAsrSceneOccurMatch", "isAllMatched(), 行中通知消息展示中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
        }
        return this.f8518a.a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.n
    public String e() {
        return "routeGuide";
    }
}
