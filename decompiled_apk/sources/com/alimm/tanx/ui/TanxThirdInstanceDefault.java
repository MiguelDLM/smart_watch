package com.alimm.tanx.ui;

import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel;
import com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.core.TanxPlayer;
import com.alimm.tanx.ui.image.GlideSourceCodeImageLoader;

/* loaded from: classes.dex */
public class TanxThirdInstanceDefault implements NotConfused {
    public TanxCoreInstanceConfig build() {
        TanxCoreInstanceConfig tanxCoreInstanceConfig = TanxCoreInstanceConfig.getInstance();
        tanxCoreInstanceConfig.setSplashModel(new SplashAdModel());
        tanxCoreInstanceConfig.setNetWork(new OkHttpNetWorkImpl());
        tanxCoreInstanceConfig.setTanxUserTracker(new tanxu_for(this));
        tanxCoreInstanceConfig.setTanxPlayer(new TanxPlayer());
        tanxCoreInstanceConfig.setImageLoader(new GlideSourceCodeImageLoader());
        return tanxCoreInstanceConfig;
    }
}
