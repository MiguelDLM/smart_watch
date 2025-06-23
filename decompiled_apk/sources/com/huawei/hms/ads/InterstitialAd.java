package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;

@GlobalApi
/* loaded from: classes10.dex */
public class InterstitialAd {
    private final aa Code;

    @GlobalApi
    public InterstitialAd(Context context) {
        this.Code = new aa(context);
    }

    @GlobalApi
    public final String getAdId() {
        return this.Code.V();
    }

    @GlobalApi
    public final AdListener getAdListener() {
        return this.Code.Code();
    }

    @GlobalApi
    public final Bundle getAdMetadata() {
        return this.Code.S();
    }

    @GlobalApi
    public final BiddingInfo getBiddingInfo() {
        return this.Code.D();
    }

    @GlobalApi
    public final boolean isLoaded() {
        return this.Code.I();
    }

    @GlobalApi
    public final boolean isLoading() {
        return this.Code.Z();
    }

    @GlobalApi
    public final void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    @GlobalApi
    public final void setAdId(String str) {
        this.Code.Code(str);
    }

    @GlobalApi
    public final void setAdListener(AdListener adListener) {
        this.Code.Code(adListener);
    }

    @GlobalApi
    public final void setAdMetadataListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code.Code(onMetadataChangedListener);
    }

    @GlobalApi
    public final void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.Code.Code(rewardAdListener);
    }

    @GlobalApi
    public final void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.Code.Code(rewardVerifyConfig);
    }

    @GlobalApi
    public final void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.Code.Code(videoConfiguration);
    }

    @GlobalApi
    @Deprecated
    public final void show() {
        this.Code.F();
    }

    @GlobalApi
    public final void show(Activity activity) {
        this.Code.Code(activity);
    }
}
