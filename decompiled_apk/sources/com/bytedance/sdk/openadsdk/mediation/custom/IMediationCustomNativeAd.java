package com.bytedance.sdk.openadsdk.mediation.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public interface IMediationCustomNativeAd {
    void callAdClick();

    void callAdShow();

    void callDislikeCancel();

    void callDislikeSelected(int i, String str);

    void callDislikeShow();

    void callOnDownloadActive(long j, long j2);

    void callOnDownloadFailed(long j, long j2, String str, String str2);

    void callOnDownloadFinished(long j, String str, String str2);

    void callOnDownloadPaused(long j, long j2, String str, String str2);

    void callOnIdle();

    void callOnInstalled(String str, String str2);

    void callRenderFail(View view, int i, String str);

    void callRenderSuccess(float f, float f2);

    void callVideoCompleted();

    void callVideoError(int i, String str);

    void callVideoPause();

    void callVideoProgressUpdate(long j, long j2);

    void callVideoResume();

    void callVideoStart();

    int getBiddingType();

    View getExpressView();

    TTFeedAd.CustomizeVideo getNativeCustomVideoReporter();

    String getVideoUrl();

    boolean hasDislike();

    boolean isClientBidding();

    MediationConstant.AdIsReadyStatus isReadyCondition();

    boolean isServerBidding();

    boolean isUseCustomVideo();

    void onDestroy();

    void onPause();

    void onResume();

    void receiveBidResult(boolean z, double d, int i, Map<String, Object> map);

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder);

    void render();

    void setActionText(String str);

    void setAdImageMode(int i);

    void setBiddingPrice(double d);

    void setDescription(String str);

    void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog);

    void setExpressAd(boolean z);

    void setIconUrl(String str);

    void setImageHeight(int i);

    void setImageList(List<String> list);

    void setImageUrl(String str);

    void setImageWidth(int i);

    void setInteractionType(int i);

    void setMediaExtraInfo(Map<String, Object> map);

    void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo);

    void setPackageName(String str);

    void setSource(String str);

    void setStarRating(double d);

    void setTitle(String str);

    void setVideoHeight(int i);

    void setVideoWidth(int i);
}
