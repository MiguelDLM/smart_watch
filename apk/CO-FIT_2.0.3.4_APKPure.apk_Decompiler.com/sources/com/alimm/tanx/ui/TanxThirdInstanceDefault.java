package com.alimm.tanx.ui;

import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel;
import com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.core.TanxPlayer;
import com.alimm.tanx.ui.image.GlideSourceCodeImageLoader;

public class TanxThirdInstanceDefault implements NotConfused {
    public TanxCoreInstanceConfig build() {
        TanxCoreInstanceConfig instance = TanxCoreInstanceConfig.getInstance();
        instance.setSplashModel(new SplashAdModel());
        instance.setNetWork(new OkHttpNetWorkImpl());
        instance.setTanxUserTracker(new tanxu_for(this));
        instance.setTanxPlayer(new TanxPlayer());
        instance.setImageLoader(new GlideSourceCodeImageLoader());
        return instance;
    }
}
