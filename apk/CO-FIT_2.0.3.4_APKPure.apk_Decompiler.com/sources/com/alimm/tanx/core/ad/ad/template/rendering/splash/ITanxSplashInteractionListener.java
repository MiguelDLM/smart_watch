package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;

public interface ITanxSplashInteractionListener extends ITanxInteractionListener<ITanxSplashAd> {
    void onAdClose();

    void onAdShake();
}
