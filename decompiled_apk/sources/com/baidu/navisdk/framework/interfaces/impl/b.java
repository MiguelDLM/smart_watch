package com.baidu.navisdk.framework.interfaces.impl;

import com.baidu.navisdk.comapi.setting.BNSettingManager;

/* loaded from: classes7.dex */
public class b implements com.baidu.navisdk.framework.interfaces.g {
    @Override // com.baidu.navisdk.framework.interfaces.g
    public boolean O() {
        return BNSettingManager.isShowJavaLog();
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public String Q() {
        return com.baidu.navisdk.model.a.g().b();
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public int b() {
        return com.baidu.navisdk.module.vehiclemanager.b.i().b();
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public boolean e() {
        return com.baidu.navisdk.module.init.b.g().d();
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public boolean g0() {
        return com.baidu.navisdk.module.init.b.g().e();
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public int h() {
        return com.baidu.navisdk.model.a.g().d().b;
    }

    @Override // com.baidu.navisdk.framework.interfaces.g
    public boolean i() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null || fVar.f() == 0) {
            return false;
        }
        return true;
    }
}
