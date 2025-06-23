package com.baidu.navisdk.framework.interfaces.impl;

import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.o;

/* loaded from: classes7.dex */
public class c implements o {
    @Override // com.baidu.navisdk.framework.interfaces.o
    public boolean K() {
        return BNSettingManager.isUsingMapMode();
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public boolean Z() {
        return BNSettingManager.getQuitForExceptionInNaviMode();
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public void c(boolean z) {
        BNSettingManager.setLocationShareOpen(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public boolean f() {
        return BNSettingManager.isUseHttpsOfflineURL();
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public void l(boolean z) {
        BNSettingManager.setDynaPreload(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public void o(boolean z) {
        BNSettingManager.setQuitForExceptionInNaviMode(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.o
    public int c() {
        return BNCommSettingManager.getInstance().getVoiceMode();
    }
}
