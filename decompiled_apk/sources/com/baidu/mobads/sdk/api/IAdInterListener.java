package com.baidu.mobads.sdk.api;

import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IAdInterListener {

    /* loaded from: classes7.dex */
    public interface AdClickActionInt {
        public static final int ACTION_TYPE_APO = 512;
        public static final int ACTION_TYPE_DL = 2;
        public static final int ACTION_TYPE_LP = 1;
    }

    /* loaded from: classes7.dex */
    public interface AdCommandType {
        public static final String AD_CLICK = "onAdClick";
        public static final String AD_IMPRESSION = "onAdImpression";
        public static final String AD_SCHEMA = "bdsdk";
        public static final String CHANGE_ACTIVITY = "onChangeActivity";
        public static final String HANDLE_EVENT = "onHandleEvent";
        public static final String NOVEL_EVENT = "onNovelEvent";
    }

    /* loaded from: classes7.dex */
    public interface AdCreativeType {
        public static final int AD_CREATIVE_IMAGE = 2;
        public static final int AD_CREATIVE_RICHMEDIA = 16;
        public static final int AD_CREATIVE_TEXT = 1;
        public static final int AD_CREATIVE_VIDEO = 8;
    }

    /* loaded from: classes7.dex */
    public interface AdProdType {
        public static final String PRODUCT_BANNER = "banner";
        public static final String PRODUCT_CONTENT = "content";
        public static final String PRODUCT_CPU = "cpu";
        public static final String PRODUCT_FEEDS = "feed";
        public static final String PRODUCT_FULLSCREENVIDEO = "fvideo";
        public static final String PRODUCT_INSITE = "insite";
        public static final String PRODUCT_INTERSTITIAL = "int";
        public static final String PRODUCT_JSSDK = "jssdk";
        public static final String PRODUCT_PORTRAITVIDEO = "pvideo";
        public static final String PRODUCT_PREROLL = "preroll";
        public static final String PRODUCT_REWARDVIDEO = "rvideo";
        public static final String PRODUCT_SONES = "sones";
        public static final String PRODUCT_SPLASH = "rsplash";
        public static final String PRODUCT_SUG = "sug";
        public static final String PRODUCT_VIDEO = "video";
    }

    /* loaded from: classes7.dex */
    public interface AdReqParam {
        public static final String AD_COUNT = "n";
        public static final String AD_TIME_OUT = "timeout";
        public static final String AD_TYPE = "at";
        public static final String AP = "ap";
        public static final String APID = "apid";
        public static final String APPID = "appid";
        public static final String FET = "fet";
        public static final String HEIGHT = "h";
        public static final String MIME_TYPE = "mimetype";
        public static final String MPT = "mpt";
        public static final String PROD = "prod";
        public static final String WIDTH = "w";
    }

    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void createProdHandler(JSONObject jSONObject);

    void destroyAd();

    View getAdContainerView();

    boolean isAdReady();

    void loadAd(JSONObject jSONObject, JSONObject jSONObject2);

    void onAdTaskProcess(View view, String str);

    void onAdTaskProcess(String str);

    void onAdTaskProcess(String str, Map<String, Object> map);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);

    void removeAllListeners();

    void setAdContainer(RelativeLayout relativeLayout);

    void showAd();
}
