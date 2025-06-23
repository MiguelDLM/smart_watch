package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.AppInfo;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.Video;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.utils.NativeListener;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import java.util.List;
import java.util.Map;

@GlobalApi
/* loaded from: classes10.dex */
public abstract class NativeAd {

    @GlobalApi
    /* loaded from: classes10.dex */
    public static abstract class ChoicesInfo {
        @GlobalApi
        public ChoicesInfo() {
        }

        @GlobalApi
        public abstract String getContent();

        @GlobalApi
        public abstract List<Image> getIcons();
    }

    @GlobalApi
    /* loaded from: classes10.dex */
    public interface NativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    @GlobalApi
    public abstract void destroy();

    @GlobalApi
    public abstract void dislikeAd(DislikeAdReason dislikeAdReason);

    @GlobalApi
    public abstract String getAbilityDetailInfo();

    @GlobalApi
    public abstract String getAdSign();

    @GlobalApi
    public abstract String getAdSource();

    @GlobalApi
    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    @GlobalApi
    public abstract AppInfo getAppInfo();

    @GlobalApi
    public abstract BiddingInfo getBiddingInfo();

    @GlobalApi
    public abstract String getCallToAction();

    @GlobalApi
    public abstract ChoicesInfo getChoicesInfo();

    @GlobalApi
    public abstract int getCreativeType();

    @GlobalApi
    public abstract String getDescription();

    @GlobalApi
    public abstract List<DislikeAdReason> getDislikeAdReasons();

    @GlobalApi
    public abstract String getDspLogo();

    @GlobalApi
    public abstract String getDspName();

    @GlobalApi
    public abstract Map<String, String> getExt();

    @GlobalApi
    public abstract Bundle getExtraBundle();

    @GlobalApi
    public abstract String getHwChannelId();

    @GlobalApi
    public abstract Image getIcon();

    @GlobalApi
    public abstract List<Image> getImages();

    @GlobalApi
    public abstract int getInteractionType();

    @GlobalApi
    public abstract String getMarket();

    @GlobalApi
    public abstract MediaContent getMediaContent();

    @GlobalApi
    public abstract String getPrice();

    @GlobalApi
    public abstract PromoteInfo getPromoteInfo();

    @GlobalApi
    public abstract Double getRating();

    @GlobalApi
    public abstract String getTitle();

    @GlobalApi
    public abstract String getTransparencyTplUrl();

    @GlobalApi
    public abstract String getUniqueId();

    @GlobalApi
    public abstract Video getVideo();

    @GlobalApi
    public abstract VideoOperator getVideoOperator();

    @GlobalApi
    public abstract String getWhyThisAd();

    @GlobalApi
    public abstract void gotoWhyThisAdPage(Context context);

    @GlobalApi
    public abstract boolean hasAdvertiserInfo();

    @GlobalApi
    public abstract boolean isAutoDownloadApp();

    @GlobalApi
    public abstract boolean isCustomClickAllowed();

    @GlobalApi
    public abstract boolean isCustomDislikeThisAdEnabled();

    @GlobalApi
    public abstract boolean isShowAppElement();

    @GlobalApi
    public abstract boolean isTransparencyOpen();

    @GlobalApi
    public abstract void onAdClose(Context context, List<String> list);

    @GlobalApi
    public abstract void recordClickEvent();

    @GlobalApi
    public abstract boolean recordClickEvent(Bundle bundle);

    @GlobalApi
    public abstract boolean recordImpressionEvent(Bundle bundle);

    @GlobalApi
    public abstract boolean recordShowStartEvent(Bundle bundle);

    @GlobalApi
    public abstract void recordTouchEvent(Bundle bundle);

    @GlobalApi
    public abstract void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener);

    @GlobalApi
    public abstract void setAdFeedbackListener(AdFeedbackListener adFeedbackListener);

    @GlobalApi
    public abstract void setAllowCustomClick();

    @GlobalApi
    public abstract void setAutoDownloadApp(boolean z);

    @GlobalApi
    public abstract void setDislikeAdListener(DislikeAdListener dislikeAdListener);

    @GlobalApi
    public abstract void setNativeListener(NativeListener nativeListener);

    @GlobalApi
    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);

    @GlobalApi
    public abstract void setVideoConfiguration(VideoConfiguration videoConfiguration);

    @GlobalApi
    public abstract void showAppDetailPage(Context context);

    @GlobalApi
    public abstract void triggerClick(Bundle bundle);
}
