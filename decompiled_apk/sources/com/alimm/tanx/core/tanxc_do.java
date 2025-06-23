package com.alimm.tanx.core;

import android.app.Application;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.config.TanxConfig;

/* loaded from: classes.dex */
public class tanxc_do {
    private Application tanxc_do;
    private TanxConfig tanxc_if;

    public void tanxc_do(Application application, TanxConfig tanxConfig, TanxCoreInstanceConfig tanxCoreInstanceConfig, TanxInitListener tanxInitListener) {
        this.tanxc_do = application;
        this.tanxc_if = tanxConfig;
        TanxCoreManager.getInstance().init(application, tanxConfig, tanxCoreInstanceConfig, tanxInitListener);
    }

    public ITanxCoreManager tanxc_if() {
        return TanxCoreManager.getInstance();
    }

    public TanxConfig tanxc_do() {
        return this.tanxc_if;
    }
}
