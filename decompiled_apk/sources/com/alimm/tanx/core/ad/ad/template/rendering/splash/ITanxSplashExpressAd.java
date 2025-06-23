package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;
import com.alimm.tanx.core.request.TanxError;

/* loaded from: classes.dex */
public interface ITanxSplashExpressAd extends INewTanxExpressAd {

    /* loaded from: classes.dex */
    public interface OnSplashAdListener {
        void onAdClicked();

        void onAdClosed();

        void onAdFinish();

        void onAdRender(ITanxSplashExpressAd iTanxSplashExpressAd);

        void onAdShake();

        void onAdShow();

        void onShowError(TanxError tanxError);
    }

    int getFromType();

    OnSplashAdListener getOnSplashAdListener();

    void setOnSplashAdListener(OnSplashAdListener onSplashAdListener);
}
