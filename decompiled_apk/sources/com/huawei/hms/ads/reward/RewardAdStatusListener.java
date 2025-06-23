package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public abstract class RewardAdStatusListener {

    @GlobalApi
    /* loaded from: classes10.dex */
    public interface ErrorCode {
        public static final int BACKGROUND = 3;
        public static final int INTERNAL = 0;
        public static final int NOT_LOADED = 2;
        public static final int REUSED = 1;
    }

    @GlobalApi
    public void onRewardAdClosed() {
    }

    @GlobalApi
    public void onRewardAdFailedToShow(int i) {
    }

    @GlobalApi
    public void onRewardAdOpened() {
    }

    @GlobalApi
    public void onRewarded(Reward reward) {
    }
}
