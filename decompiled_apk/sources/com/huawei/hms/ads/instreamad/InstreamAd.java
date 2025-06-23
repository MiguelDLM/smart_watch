package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;

@GlobalApi
/* loaded from: classes10.dex */
public abstract class InstreamAd {
    @GlobalApi
    public abstract String getAdSign();

    @GlobalApi
    public abstract String getAdSource();

    @GlobalApi
    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    @GlobalApi
    public abstract BiddingInfo getBiddingInfo();

    @GlobalApi
    public abstract String getCallToAction();

    @GlobalApi
    public abstract String getDspLogo();

    @GlobalApi
    public abstract String getDspName();

    @GlobalApi
    public abstract long getDuration();

    @GlobalApi
    public abstract String getTransparencyTplUrl();

    @GlobalApi
    public abstract String getWhyThisAd();

    @GlobalApi
    public abstract boolean hasAdvertiserInfo();

    @GlobalApi
    public abstract boolean isClicked();

    @GlobalApi
    public abstract boolean isExpired();

    @GlobalApi
    public abstract boolean isImageAd();

    @GlobalApi
    public abstract boolean isShown();

    @GlobalApi
    public abstract boolean isTransparencyOpen();

    @GlobalApi
    public abstract boolean isVideoAd();

    @GlobalApi
    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);
}
