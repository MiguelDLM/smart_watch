package com.huawei.hms.ads.inter.listeners;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public interface IInterstitialAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i, int i2);

    void onAdShown();

    void onLeftApp();

    void onRewarded();
}
