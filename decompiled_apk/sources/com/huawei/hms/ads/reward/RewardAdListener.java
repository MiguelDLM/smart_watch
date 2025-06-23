package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public interface RewardAdListener {
    void onRewardAdClosed();

    void onRewardAdCompleted();

    void onRewardAdFailedToLoad(int i);

    void onRewardAdLeftApp();

    void onRewardAdLoaded();

    void onRewardAdOpened();

    void onRewardAdStarted();

    void onRewarded(Reward reward);
}
