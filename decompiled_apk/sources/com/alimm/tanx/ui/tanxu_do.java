package com.alimm.tanx.ui;

import android.app.Application;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class tanxu_do implements TanxInitListener {
    final /* synthetic */ Application tanxu_do;
    final /* synthetic */ TanxInitListener tanxu_for;
    final /* synthetic */ TanxConfig tanxu_if;

    public tanxu_do(Application application, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        this.tanxu_do = application;
        this.tanxu_if = tanxConfig;
        this.tanxu_for = tanxInitListener;
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void error(int i, String str) {
        TanxSdk.mIsInit.set(-1);
        this.tanxu_for.error(i, str);
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void succ() {
        tanxu_if tanxu_ifVar;
        LogUtils.d("TanxSdk", "TanxCoreSdk Init succ");
        tanxu_ifVar = TanxSdk.mInitializer;
        tanxu_ifVar.tanxu_do(this.tanxu_do, this.tanxu_if);
        TanxSdk.mIsInit.set(2);
        this.tanxu_for.succ();
    }
}
