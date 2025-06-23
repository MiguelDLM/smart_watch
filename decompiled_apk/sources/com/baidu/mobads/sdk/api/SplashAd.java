package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.bb;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.dj;
import com.baidu.mobads.sdk.internal.dw;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dw mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private ViewGroup mViewParent;

    /* loaded from: classes7.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: classes7.dex */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* loaded from: classes7.dex */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* loaded from: classes7.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e) {
            bv.a().a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dw.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            dw dwVar = this.mAdProd;
            if (dwVar != null) {
                dwVar.a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        boolean z;
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z2 = false;
            if (viewGroup == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (this.mIsAdaptiveSplashAd && view == null) {
                z2 = true;
            }
            sb2.append(z2);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e) {
                    bv.a().a(e);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i) {
        setAppLogo(Integer.valueOf(i));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        if (!this.mFetchNotShow) {
            dw dwVar = this.mAdProd;
            if (dwVar != null) {
                dwVar.r();
            }
            callAdFailed("展现失败，请重新load");
            return;
        }
        this.mFetchNotShow = false;
        dw dwVar2 = this.mAdProd;
        if (dwVar2 != null) {
            final ct ctVar = new ct(this.mContext);
            ctVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                view.setId(4097);
                ctVar.addView(view, layoutParams);
            }
            ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                private boolean mIsFirstOnLayout = true;

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public boolean onKeyDown(int i, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onLayoutComplete(int i, int i2) {
                    if (!this.mIsFirstOnLayout) {
                        return;
                    }
                    if (SplashAd.this.mAdProd == null) {
                        SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                        return;
                    }
                    SplashAd.this.mAdProd.r = false;
                    SplashAd.this.mFetchNotShow = false;
                    this.mIsFirstOnLayout = false;
                    SplashAd.this.mAdProd.a(ctVar);
                    SplashAd.this.mAdProd.f();
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onWindowFocusChanged(boolean z) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ct.a
                public void onWindowVisibilityChanged(int i) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i);
                    }
                }
            });
            this.mViewParent.addView(ctVar);
            return;
        }
        if (dwVar2 != null) {
            dwVar2.r();
        }
        callAdFailed("展现失败，请检查splashAd参数是否正确");
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    public void destroy() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public Object getAdDataForKey(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            return dwVar.j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.r();
            this.mAdProd = null;
        }
        float e = bb.e(this.mContext);
        Rect a2 = bb.a(this.mContext);
        int width = a2.width();
        int height = a2.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 >= 200.0f * e && i >= e * 150.0f) {
            dw dwVar2 = new dw(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dwVar2;
            dwVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dw dwVar3 = this.mAdProd;
            dwVar3.p = this.mBidFloor;
            dwVar3.r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dwVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            return this.mAdProd.m();
        }
        bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        return null;
    }

    public String getECPMLevel() {
        a h;
        dw dwVar = this.mAdProd;
        if (dwVar != null && (h = dwVar.h()) != null) {
            return h.z();
        }
        return "";
    }

    public final boolean hasSplashCardView() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            return dwVar.g();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dw dwVar = this.mAdProd;
        if (dwVar != null && (iAdInterListener = dwVar.k) != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    public final void load() {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.r();
            this.mAdProd = null;
        }
        float e = bb.e(this.mContext);
        Rect a2 = bb.a(this.mContext);
        int width = a2.width();
        int height = a2.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 >= 200.0f * e && i >= e * 150.0f) {
            dw dwVar2 = new dw(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dwVar2;
            dwVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dw dwVar3 = this.mAdProd;
            dwVar3.p = this.mBidFloor;
            dwVar3.r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dwVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            this.mAdProd.a();
            return;
        }
        bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
        final ct ctVar = new ct(this.mContext);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onDetachedFromWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return false;
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i, int i2) {
                if (SplashAd.this.mAdProd != null) {
                    return;
                }
                float e = bb.e(SplashAd.this.mContext);
                if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                    if (SplashAd.this.mParameter.getWidth() > 0) {
                        i = (int) (SplashAd.this.mParameter.getWidth() * e);
                    }
                    if (SplashAd.this.mParameter.getHeight() > 0) {
                        i2 = (int) (SplashAd.this.mParameter.getHeight() * e);
                    }
                }
                int i3 = i;
                int i4 = i2;
                if (i3 >= 200.0f * e && i4 >= e * 150.0f) {
                    SplashAd.this.mAdProd = new dw(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i3, i4, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                    SplashAd.this.mAdProd.a(ctVar);
                    SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
                    SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
                    SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
                    SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
                    SplashAd.this.mAdProd.p = SplashAd.this.mBidFloor;
                    SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                    if (SplashAd.this.mParameter != null) {
                        SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                    }
                    SplashAd.this.mAdProd.r = false;
                    SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                    SplashAd.this.mAdProd.a();
                    return;
                }
                bv.a().c(dj.a().a(br.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                if (SplashAd.this.mListener != null && (SplashAd.this.mListener instanceof SplashInteractionListener)) {
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(z);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.b(i);
                }
            }
        });
        ctVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(ctVar);
    }

    public void loadBiddingAd(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(splashCardAdListener);
            return this.mAdProd.b(activity);
        }
        return false;
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = ViewCompat.MEASURED_STATE_MASK;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dw.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(false, str, linkedHashMap);
        }
    }

    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(true, str, linkedHashMap);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dw dwVar = this.mAdProd;
        if (dwVar != null) {
            dwVar.a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i, int i2, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        dw.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
            jSONObject.put("anim_offset_y", i3);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        dw.a(activity, jSONObject, splashFocusAdListener);
    }
}
