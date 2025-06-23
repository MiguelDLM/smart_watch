package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.dm;
import com.baidu.mobads.sdk.internal.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private NativeResponse.AdShakeViewListener mCouponFloatViewListener;
    private NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private Context mCxt;
    private dm mFeedsProd;
    private cs mUriUtils;

    /* loaded from: classes7.dex */
    public static class DislikeInfo implements DislikeEvent {
        private String dislikeName;
        private int dislikeType;

        private DislikeInfo() {
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }
    }

    public XAdNativeResponse(Context context, dm dmVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = dmVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cs.a();
    }

    private int getActionType() {
        return this.mAdInstanceInfo.p();
    }

    private IAdInterListener getAdInterListener() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            return dmVar.k;
        }
        return null;
    }

    private String getProd() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            return dmVar.f();
        }
        return "";
    }

    private View renderNativeView(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap hashMap = new HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            Object obj = hashMap.get(str);
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str) {
        biddingSuccess(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt != null && this.isDownloadApp && this.mFeedsProd != null) {
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("pk", getAppPackage());
                T.put("msg", "cancelDownload");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            dmVar.p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null && this.mFeedsProd != null && (dislikeEvent instanceof DislikeInfo)) {
            JSONObject T = aVar.T();
            try {
                T.put("dislike_type", dislikeEvent.getDislikeType());
                T.put("msg", "dislike_click");
            } catch (Exception unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null && this.mFeedsProd != null) {
            String D = aVar.D();
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("function_link", D);
                T.put("msg", "functionClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            JSONObject T = aVar.T();
            try {
                T.put("msg", "creative_call");
                T.put("creative_type", "cta_get");
            } catch (Exception unused) {
            }
            this.mFeedsProd.a(T);
            return this.mAdInstanceInfo.M();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Object getAdDataForKey(String str) {
        if (this.mAdInstanceInfo != null) {
            if ("request_id".equals(str)) {
                return this.mAdInstanceInfo.U();
            }
            if ("dp_id".equals(str)) {
                return this.mAdInstanceInfo.V();
            }
            return this.mAdInstanceInfo.a(str);
        }
        return null;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.h();
        }
        return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if (a.f.equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.D();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.m();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.E();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.C();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.A();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.i();
        }
        return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.g();
        }
        return "";
    }

    public List<String> getBtnStyleColors() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.O();
        }
        return null;
    }

    public int getBtnStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.N();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        a aVar;
        if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.S() == 1) {
            this.mCustomizeMediaPlayer = new p(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.b();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject T = this.mAdInstanceInfo.T();
                T.put("msg", "dislike_mapping");
                this.mFeedsProd.a(T, hashMap);
                Object obj = hashMap.get("dislike_data");
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str : map.keySet()) {
                        DislikeInfo dislikeInfo = new DislikeInfo();
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((Integer) map.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        Context context;
        if (this.isDownloadApp && (context = this.mCxt) != null) {
            return at.a(context.getApplicationContext()).a(this.mCxt.getApplicationContext(), getAppPackage());
        }
        return -1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.z();
        }
        return "";
    }

    public JSONObject getExtraParams() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.I();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap hashMap = new HashMap();
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            hashMap.put("appsid", dmVar.o);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.o();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            String c = aVar.c();
            if (TextUtils.isEmpty(c)) {
                return this.mAdInstanceInfo.d();
            }
            return c;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public String getMarketingDesc() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.K();
        }
        return "";
    }

    public String getMarketingICONUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.J();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.L();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL;
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (a.f.equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.G();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.B();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject P = this.mAdInstanceInfo.P();
            if (P != null) {
                Iterator<String> keys = P.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals(str)) {
                        JSONArray optJSONArray = P.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public String getUniqueId() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.H();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.n();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        dm dmVar = this.mFeedsProd;
        if (dmVar != null) {
            return (WebView) dmVar.w();
        }
        return null;
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        if (this.mAdInstanceInfo == null || System.currentTimeMillis() - this.mAdInstanceInfo.y() > this.mAdInstanceInfo.F()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || aVar.k() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || aVar.l() == 1) {
            return true;
        }
        return false;
    }

    public int isRegionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.Q();
        }
        return 2;
    }

    public int isShowDialog() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.R();
        }
        return 2;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i);
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPermissionShow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdDownloadWindow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null && (adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            if (z) {
                ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
            } else {
                ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
            }
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public void onCouponFloatDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mCouponFloatViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onShakeViewDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mAdShakeViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt != null && this.isDownloadApp && this.mFeedsProd != null) {
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("pk", getAppPackage());
                T.put("msg", "pauseDownload");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null && this.mFeedsProd != null) {
            String E = aVar.E();
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("permissionUrl", E);
                T.put("msg", "permissionClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    public void preloadVideoMaterial() {
        a aVar;
        if (this.mFeedsProd != null && (aVar = this.mAdInstanceInfo) != null) {
            JSONObject T = aVar.T();
            try {
                T.put("msg", "preloadVideoMaterial");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null && this.mFeedsProd != null) {
            String C = aVar.C();
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("privacy_link", C);
                T.put("msg", "privacyClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        a aVar;
        dm dmVar = this.mFeedsProd;
        if (dmVar != null && (aVar = this.mAdInstanceInfo) != null) {
            dmVar.a(view, aVar.T());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv.a().c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderCouponFloatView(NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mCouponFloatViewListener = adShakeViewListener;
                return renderNativeView("native_coupon_float_icon", new JSONObject());
            } catch (Throwable th) {
                bv.a().c(TAG, "renderCouponFloatView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderFlipPageView() {
        if (this.mFeedsProd != null) {
            try {
                return renderNativeView("native_coupon_flip_page", new JSONObject());
            } catch (Throwable th) {
                bv.a().c(TAG, "renderFlipPageView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "renderShakeView");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
                jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                HashMap hashMap = new HashMap();
                this.mFeedsProd.a(jSONObject, hashMap);
                Object obj = hashMap.get("shake_view");
                if (obj instanceof View) {
                    return (View) obj;
                }
                return null;
            } catch (Throwable th) {
                bv.a().c(TAG, "renderShakeView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i, int i2, int i3, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd != null) {
            try {
                this.mAdShakeViewListener = adShakeViewListener;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
                jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
                jSONObject.put("repeat", i3);
                return renderNativeView("native_slide_view", jSONObject);
            } catch (Throwable th) {
                bv.a().c(TAG, "renderSlideView failed: " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        if (this.isDownloadApp && this.mFeedsProd != null && (aVar = this.mAdInstanceInfo) != null) {
            JSONObject T = aVar.T();
            try {
                T.put("msg", "resumeDownload");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    public void setAdActionType(int i) {
        this.mAdActionType = i;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.isDownloadApp = z;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(View view) {
        if (this.mFeedsProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                HashMap hashMap = new HashMap();
                hashMap.put("native_view", view);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bv.a().c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        cs csVar;
        if (this.mFeedsProd != null && (csVar = this.mUriUtils) != null) {
            String c = csVar.c("http://union.baidu.com/");
            JSONObject T = this.mAdInstanceInfo.T();
            try {
                T.put("unionUrl", c);
                T.put("msg", "unionLogoClick");
            } catch (Throwable unused) {
            }
            this.mFeedsProd.a(T);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dmVar = this.mFeedsProd) == null) {
            return;
        }
        dmVar.a(aVar.H(), false, str, linkedHashMap);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str, LinkedHashMap<String, Object> linkedHashMap) {
        dm dmVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dmVar = this.mFeedsProd) == null) {
            return;
        }
        dmVar.a(aVar.H(), true, str, linkedHashMap);
    }

    public void handleClick(View view, int i) {
        handleClick(view, i, false);
    }

    public void handleClick(View view, boolean z) {
        handleClick(view, -1, z);
    }

    public void handleClick(View view, int i, boolean z) {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject T = aVar.T();
        try {
            T.put("progress", i);
            T.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
            T.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.b(view, T);
    }
}
