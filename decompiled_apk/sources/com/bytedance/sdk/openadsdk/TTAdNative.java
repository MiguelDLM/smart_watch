package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: classes8.dex */
public interface TTAdNative {

    /* loaded from: classes8.dex */
    public interface CSJSplashAdListener {
        void onSplashLoadFail(CSJAdError cSJAdError);

        void onSplashLoadSuccess(CSJSplashAd cSJSplashAd);

        void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError);

        void onSplashRenderSuccess(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: classes8.dex */
    public interface DrawFeedAdListener {
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        void onError(int i, String str);
    }

    /* loaded from: classes8.dex */
    public interface FeedAdListener {
        void onError(int i, String str);

        void onFeedAdLoad(List<TTFeedAd> list);
    }

    /* loaded from: classes8.dex */
    public interface FullScreenVideoAdListener {
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        @Deprecated
        void onFullScreenVideoCached();

        void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd);
    }

    /* loaded from: classes8.dex */
    public interface NativeAdListener {
        void onError(int i, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    /* loaded from: classes8.dex */
    public interface NativeExpressAdListener {
        void onError(int i, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    /* loaded from: classes8.dex */
    public interface RewardVideoAdListener {
        void onError(int i, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        @Deprecated
        void onRewardVideoCached();

        void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd);
    }

    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    @Deprecated
    void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, CSJSplashAdListener cSJSplashAdListener, int i);

    void loadStream(AdSlot adSlot, FeedAdListener feedAdListener);
}
