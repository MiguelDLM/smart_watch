package com.alimm.tanx.core.ad.listener;

import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import java.util.List;

/* loaded from: classes.dex */
public interface ITanxAdLoader extends ITanxRequestLoader {

    /* loaded from: classes.dex */
    public interface BaseAdLoadListener {
        void onError(TanxError tanxError);

        void onTimeOut();
    }

    /* loaded from: classes.dex */
    public interface OnAdLoadListener<T extends INewTanxExpressAd> extends BaseAdLoadListener {
        void onLoaded(List<T> list);
    }

    /* loaded from: classes.dex */
    public interface OnRewardAdLoadListener<T extends INewTanxExpressAd> extends BaseAdLoadListener {
        void onLoaded(List<T> list);

        void onRewardVideoCached(T t);
    }

    /* loaded from: classes.dex */
    public interface OnSplashAdLoadListener extends BaseAdLoadListener {
        void onLoaded(ITanxFeedExpressAd iTanxFeedExpressAd);
    }

    void destroy();

    void loadFeedAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxFeedExpressAd> onAdLoadListener);

    void loadRewardAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener);

    void loadRewardAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j);

    void loadRewardVideoAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener);

    @Deprecated
    void loadRewardVideoAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j);

    void loadSplashAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener);

    void loadSplashAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener, long j);

    void loadTableScreenAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener);

    void loadTableScreenAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener, long j);

    @Deprecated
    void preloadSplashAd(TanxAdSlot tanxAdSlot);
}
