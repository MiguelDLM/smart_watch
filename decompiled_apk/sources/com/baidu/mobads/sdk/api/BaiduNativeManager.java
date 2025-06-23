package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.al;
import com.baidu.mobads.sdk.internal.dm;
import com.baidu.mobads.sdk.internal.f;
import java.util.List;

/* loaded from: classes7.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    /* loaded from: classes7.dex */
    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes7.dex */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes7.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        if (requestParameters != null) {
            String adPlacementId = requestParameters.getAdPlacementId();
            if (!TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        int bidFloor;
        if (requestParameters != null && (bidFloor = requestParameters.getBidFloor()) > 0) {
            return bidFloor;
        }
        return this.mBidFloor;
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.p = getBidFloor(requestParameters);
        dmVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            dmVar.a(new ad(feedAdListener));
        } else if (expressAdListener != null) {
            dmVar.a(expressAdListener);
            dmVar.a(1);
        }
        dmVar.a(new al());
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dmVar.a(requestParameters);
        dmVar.m();
        dmVar.c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        RequestParameters requestParameters2;
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        dmVar.a(1);
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        } else {
            requestParameters2 = requestParameters;
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.p = getBidFloor(requestParameters);
        dmVar.a(requestParameters2);
        this.mRequestParameters = requestParameters2;
        return dmVar.m();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        RequestParameters requestParameters2;
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        } else {
            requestParameters2 = requestParameters;
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.p = getBidFloor(requestParameters);
        dmVar.a(requestParameters2);
        this.mRequestParameters = requestParameters2;
        return dmVar.m();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        RequestParameters requestParameters2;
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        } else {
            requestParameters2 = requestParameters;
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.p = getBidFloor(requestParameters);
        dmVar.a(requestParameters2);
        this.mRequestParameters = requestParameters2;
        return dmVar.m();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, 8000, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        f fVar = new f(this.mContext, new ad(portraitVideoAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }
}
