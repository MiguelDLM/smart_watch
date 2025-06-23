package com.baidu.mobads.sdk.api;

/* loaded from: classes7.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdExposed();

    void onAdPresent();

    void onAdSkip();

    void onLpClosed();
}
