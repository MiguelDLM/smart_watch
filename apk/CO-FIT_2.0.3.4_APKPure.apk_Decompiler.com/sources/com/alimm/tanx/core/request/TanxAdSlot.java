package com.alimm.tanx.core.request;

import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.bean.RewardParam;
import com.alimm.tanx.core.constant.TanxAdTemplateId;
import com.alimm.tanx.core.utils.NotConfused;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.Serializable;
import java.util.UUID;

public class TanxAdSlot implements NotConfused, Serializable {
    private int adCount;
    private int adType;
    private boolean cacheUnderWifi;
    private boolean clickAdClose;
    private int expressViewWidth;
    private String ext;
    private boolean feedBackDialog;
    private int height;
    private boolean isExpressRender;
    private TanxAdLoadType loadType;
    private String mediaExtra;
    private String mediaUid;
    private String[] nativeTemplateId;
    private boolean notAutoPlay;
    private int orientation;
    private String pid;
    private boolean playUnderWifi;
    private String reqId;
    private RewardParam rewardParam;
    private String userId;
    private VideoParam videoParam;
    private int width;

    public static class Builder implements NotConfused {
        /* access modifiers changed from: private */
        public int adCount;
        /* access modifiers changed from: private */
        public int adType;
        /* access modifiers changed from: private */
        public boolean cacheUnderWifi;
        /* access modifiers changed from: private */
        public boolean clickAdClose;
        /* access modifiers changed from: private */
        public int expressViewWidth;
        /* access modifiers changed from: private */
        public boolean feedBackDialog;
        /* access modifiers changed from: private */
        public int height;
        private boolean isExpressRender;
        /* access modifiers changed from: private */
        public TanxAdLoadType loadType;
        private String mediaExtra;
        /* access modifiers changed from: private */
        public String mediaUid;
        /* access modifiers changed from: private */
        public String[] nativeTemplateId;
        /* access modifiers changed from: private */
        public boolean notAutoPlay;
        private int orientation;
        /* access modifiers changed from: private */
        public String pid;
        /* access modifiers changed from: private */
        public boolean playUnderWifi;
        /* access modifiers changed from: private */
        public RewardParam rewardParam;
        private String userId;
        /* access modifiers changed from: private */
        public VideoParam videoParam;
        /* access modifiers changed from: private */
        public int width;

        public Builder() {
            this.adCount = 1;
            this.feedBackDialog = true;
            this.videoParam = new VideoParam();
            this.userId = "defaultUser";
            this.mediaExtra = "";
            this.orientation = 1;
            this.clickAdClose = false;
            this.loadType = TanxAdLoadType.PRELOAD;
            this.adCount = 1;
        }

        public Builder adCount(int i) {
            this.adCount = i;
            return this;
        }

        public Builder adSize(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        @Deprecated
        public Builder adType(int i) {
            this.adType = i;
            return this;
        }

        public TanxAdSlot build() {
            return new TanxAdSlot(this);
        }

        public String getMediaUid() {
            return this.mediaUid;
        }

        public RewardParam getRewardParam() {
            return this.rewardParam;
        }

        public Builder isExpressRender(boolean z) {
            this.isExpressRender = z;
            return this;
        }

        @Deprecated
        public Builder nativeTemplateId(String[] strArr) {
            this.nativeTemplateId = strArr;
            return this;
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public Builder setCacheUnderWifi(boolean z) {
            this.cacheUnderWifi = z;
            return this;
        }

        public Builder setClickAdClose(boolean z) {
            this.clickAdClose = z;
            return this;
        }

        public Builder setExpressViewAcceptedSize(int i) {
            this.expressViewWidth = i;
            return this;
        }

        public Builder setFeedBackDialog(boolean z) {
            this.feedBackDialog = z;
            return this;
        }

        public Builder setLoadType(TanxAdLoadType tanxAdLoadType) {
            this.loadType = tanxAdLoadType;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.mediaExtra = str;
            return this;
        }

        public Builder setMediaUid(String str) {
            this.mediaUid = str;
            return this;
        }

        public Builder setNotAutoPlay(boolean z) {
            this.notAutoPlay = z;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setPlayUnderWifi(boolean z) {
            this.playUnderWifi = z;
            return this;
        }

        public Builder setRewardParam(RewardParam rewardParam2) {
            this.rewardParam = rewardParam2;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setVideoParam(VideoParam videoParam2) {
            this.videoParam = videoParam2;
            return this;
        }
    }

    public TanxAdSlot() {
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.adCount = 1;
    }

    private void setAdSlot(int i) {
        setAdType(i);
        if (i == 1) {
            setNativeTemplateId(TanxAdTemplateId.SPLASH_TEMPLATE);
        } else if (i == 2) {
            setNativeTemplateId(TanxAdTemplateId.FEED_TEMPLATE);
        } else if (i == 3) {
            setNativeTemplateId(TanxAdTemplateId.REWARD_VIDEO_TEMPLATE);
        } else if (i == 4) {
            setNativeTemplateId(TanxAdTemplateId.REWARD_TEMPLATE);
        } else if (i == 5) {
            setNativeTemplateId(TanxAdTemplateId.TABLE_SCREEN_TEMPLATE);
        }
    }

    private String uuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace(HelpFormatter.DEFAULT_OPT_PREFIX, "") + HelpFormatter.DEFAULT_OPT_PREFIX + (System.currentTimeMillis() / 1000);
    }

    public void addAdSlot(int i) {
        setAdSlot(i);
        setExpressRender(false);
    }

    public void addTemplateAdSlot(int i) {
        setAdSlot(i);
        setExpressRender(true);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getExpressViewWidth() {
        return this.expressViewWidth;
    }

    public String getExt() {
        return this.ext;
    }

    public int getHeight() {
        return this.height;
    }

    public TanxAdLoadType getLoadType() {
        return this.loadType;
    }

    public String getMediaExtra() {
        return this.mediaExtra;
    }

    public String getMediaUid() {
        return this.mediaUid;
    }

    public String[] getNativeTemplateId() {
        return this.nativeTemplateId;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getPid() {
        return this.pid;
    }

    public String getReqId() {
        return this.reqId;
    }

    public RewardParam getRewardParam() {
        return this.rewardParam;
    }

    public String getUserId() {
        return this.userId;
    }

    public VideoParam getVideoParam() {
        return this.videoParam;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isCacheUnderWifi() {
        return this.cacheUnderWifi;
    }

    public boolean isClickAdClose() {
        return this.clickAdClose;
    }

    public boolean isExpressRender() {
        return this.isExpressRender;
    }

    public boolean isFeedBackDialog() {
        return this.feedBackDialog;
    }

    public boolean isNotAutoPlay() {
        return this.notAutoPlay;
    }

    public boolean isPlayUnderWifi() {
        return this.playUnderWifi;
    }

    public void setAdCount(int i) {
        this.adCount = i;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setCacheUnderWifi(boolean z) {
        this.cacheUnderWifi = z;
    }

    public void setClickAdClose(boolean z) {
        this.clickAdClose = z;
    }

    public void setExpressRender(boolean z) {
        this.isExpressRender = z;
    }

    public void setExpressViewWidth(int i) {
        this.expressViewWidth = i;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setFeedBackDialog(boolean z) {
        this.feedBackDialog = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLoadType(TanxAdLoadType tanxAdLoadType) {
        this.loadType = tanxAdLoadType;
    }

    public void setMediaExtra(String str) {
        this.mediaExtra = str;
    }

    public void setMediaUid(String str) {
        this.mediaUid = str;
    }

    public void setNativeTemplateId(String[] strArr) {
        this.nativeTemplateId = strArr;
    }

    public void setNotAutoPlay(boolean z) {
        this.notAutoPlay = z;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPlayUnderWifi(boolean z) {
        this.playUnderWifi = z;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setRewardParam(RewardParam rewardParam2) {
        this.rewardParam = rewardParam2;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVideoParam(VideoParam videoParam2) {
        this.videoParam = videoParam2;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public TanxAdSlot(Builder builder) {
        this.adCount = 1;
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.adType = builder.adType;
        this.pid = builder.pid;
        this.nativeTemplateId = builder.nativeTemplateId;
        this.adCount = Math.max(builder.adCount, 1);
        this.width = builder.width;
        this.height = builder.height;
        this.reqId = uuid();
        this.expressViewWidth = builder.expressViewWidth;
        this.cacheUnderWifi = builder.cacheUnderWifi;
        this.playUnderWifi = builder.playUnderWifi;
        this.notAutoPlay = builder.notAutoPlay;
        this.videoParam = builder.videoParam;
        this.feedBackDialog = builder.feedBackDialog;
        this.clickAdClose = builder.clickAdClose;
        this.mediaUid = builder.mediaUid;
        this.loadType = builder.loadType;
        this.rewardParam = builder.rewardParam;
    }
}
