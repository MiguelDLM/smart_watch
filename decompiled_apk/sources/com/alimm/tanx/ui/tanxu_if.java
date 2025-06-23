package com.alimm.tanx.ui;

import android.app.Application;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.ui.ad.ITanxSdkManager;
import com.alimm.tanx.ui.image.GlideSourceCodeImageLoader;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class tanxu_if {
    private TanxConfig tanxu_do;

    public void tanxu_do(Application application, TanxConfig tanxConfig) {
        this.tanxu_do = tanxConfig;
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("initImageLoader");
        oIX0oI2.append(OrangeManager.getInstance().getOrangeBean().imageSwitch.toString());
        LogUtils.d("ImageManager init", oIX0oI2.toString());
        if (OrangeManager.getInstance().getAllAppImageSwitch() || OrangeManager.getInstance().getImageSwitch(this.tanxu_do.getAppKey())) {
            LogUtils.d("ImageManager init", "命中appkey重新设置GlideSourceCodeImageLoader");
            ImageManager.setLoader(new GlideSourceCodeImageLoader());
        }
    }

    public ITanxSdkManager tanxu_if() {
        return TanxSdkManager.getInstance();
    }

    public TanxConfig tanxu_do() {
        return this.tanxu_do;
    }
}
