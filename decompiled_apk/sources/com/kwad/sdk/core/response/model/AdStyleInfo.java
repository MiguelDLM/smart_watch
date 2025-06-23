package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.List;

@KsJson
/* loaded from: classes11.dex */
public class AdStyleInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 8719785586052076737L;
    public String playableExtraData;
    public boolean slideClick;
    public PlayDetailInfo playDetailInfo = new PlayDetailInfo();
    public PlayEndInfo playEndInfo = new PlayEndInfo();
    public FeedAdInfo feedAdInfo = new FeedAdInfo();
    public AdBrowseInfo adBrowseInfo = new AdBrowseInfo();
    public ExtraDisplayInfo extraDisplayInfo = new ExtraDisplayInfo();

    @KsJson
    /* loaded from: classes11.dex */
    public static class AdBrowseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 124904139820344132L;
        public int adBrowseDuration;
        public int enableAdBrowse;
        public String rewardDescription;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class ExposeTagInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public String text;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class ExtraDisplayInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public List<ExposeTagInfo> exposeTagInfoList;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class FeedAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7200581738130214277L;
        public double heightRatio;
        public String templateConfig;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class PlayDetailInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -1341583579732471663L;
        public int type;
        public DetailWebCardInfo detailWebCardInfo = new DetailWebCardInfo();
        public DetailTopToolBarInfo detailTopToolBarInfo = new DetailTopToolBarInfo();
        public ActionBarInfo actionBarInfo = new ActionBarInfo();
        public PatchAdInfo patchAdInfo = new PatchAdInfo();
        public DetailCommonInfo detailCommonInfo = new DetailCommonInfo();
        public DrawAdInfo drawAdInfo = new DrawAdInfo();

        @KsJson
        /* loaded from: classes11.dex */
        public static class ActionBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -5427865686247250271L;
            public long cardShowTime;
            public long lightBtnShowTime;
            public long translateBtnShowTime;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class DetailCommonInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 7929119539282758308L;
            public int middleEndcardShowTime;
            public int rewardFullClickSwitch;
            public int rewardInteractionType;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class DetailTopToolBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 7018855616083214769L;
            public String callButtonDescription;
            public long callButtonShowTime;
            public long maxTimeOut;
            public String rewardCallDescription;
            public String rewardIconUrl;
            public int style;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class DetailWebCardInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -3413444348973947395L;
            public String cardData;
            public long cardShowTime;
            public int cardType;
            public String cardUrl;
            public long maxTimeOut;
            public int style;
            public long typeLandscape;
            public long typePortrait;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class DrawAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -793446066208523006L;
            public boolean forcedWatch;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class PatchAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 2983090319692390903L;
            public String strongStyleAdMark;
            public long strongStyleAppearTime;
            public String strongStyleCardUrl;
            public boolean strongStyleEnableClose;
            public long strongStyleShowTime;
            public String strongStyleSubTitle;
            public String strongStyleTitle;
            public int typePortrait;
            public String weakStyleAdMark;
            public long weakStyleAppearTime;
            public String weakStyleDownloadingTitle;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public long weakStyleShowTime;
            public String weakStyleTitle;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class PatchEcInfo extends PatchAdInfo implements Serializable {
            public static final int PLATFORM_TYPE_JD = 2;
            public static final int PLATFORM_TYPE_KWAI = 0;
            public static final int PLATFORM_TYPE_TAOBAO = 1;
            private static final long serialVersionUID = -2026969232988644879L;
            public String linkCode;
            public String nebulaKwaiLink;
            public int platformTypeCode;
            public String strongStyleItemId;
            public String strongStyleItemPrice;
            public String strongStyleItemUrl;
            public String strongStylePicUrl;
            public String strongStylePriceAfterComm;
            public String strongStyleUserCommAmountBuying;
            public String strongStyleUserCommAmountSharing;

            public String getLinkCode() {
                return this.linkCode;
            }

            public String getNebulaKwaiLink() {
                return this.nebulaKwaiLink;
            }

            public String getStrongStyleItemId() {
                return this.strongStyleItemId;
            }

            public String getStrongStyleItemPrice() {
                return this.strongStyleItemPrice;
            }

            public String getStrongStyleItemUrl() {
                return this.strongStyleItemUrl;
            }

            public String getStrongStylePicUrl() {
                return this.strongStylePicUrl;
            }

            public String getStrongStylePriceAfterComm() {
                return this.strongStylePriceAfterComm;
            }

            public String getStrongStyleUserCommAmountBuying() {
                return this.strongStyleUserCommAmountBuying;
            }

            public String getStrongStyleUserCommAmountSharing() {
                return this.strongStyleUserCommAmountSharing;
            }
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class WidgetAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -7098364163341152274L;
            public String downloadOngoingLabel;
            public String downloadResumeLabel;
            public String downloadStartLabel;
            public String installAppLabel;
            public String openAppLabel;
            public int type;
            public String widgetAdIcon;
        }
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class PlayEndInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 4733855071604625289L;

        @NonNull
        public AdWebCardInfo adWebCardInfo = new AdWebCardInfo();

        @NonNull
        public EndTopToolBarInfo endTopToolBarInfo = new EndTopToolBarInfo();
        public int showLandingPage3;
        public int type;

        @KsJson
        /* loaded from: classes11.dex */
        public static class AdWebCardInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 5629721137592788675L;
            public String cardData;
            public long cardDelayTime;
            public int cardShowPlayCount;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;
        }

        @KsJson
        /* loaded from: classes11.dex */
        public static class EndTopToolBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -3850938239125130621L;
            public String callButtonDescription;
            public String rewardIconUrl;
        }
    }
}
