package com.kwad.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;

@KsAdSdkApi
@Keep
/* loaded from: classes11.dex */
public interface KsNativeAd extends BaseKSAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes11.dex */
    public interface AdInteractionListener {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @KsAdSdkApi
        @Keep
        void onAdClicked(View view, KsNativeAd ksNativeAd);

        @KsAdSdkApi
        @Keep
        void onAdShow(KsNativeAd ksNativeAd);

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes11.dex */
    public interface VideoPlayListener {
        @KsAdSdkApi
        @Keep
        void onVideoPlayComplete();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        @Keep
        void onVideoPlayPause();

        @KsAdSdkApi
        @Keep
        void onVideoPlayReady();

        @KsAdSdkApi
        @Keep
        void onVideoPlayResume();

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @Keep
    String getActionDescription();

    @KsAdSdkApi
    @Keep
    String getAdDescription();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAdSource();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAdSourceLogoUrl(int i);

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppDownloadCountDes();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppIconUrl();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppName();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppPackageName();

    @KsAdSdkApi
    @Keep
    long getAppPackageSize();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppPrivacyUrl();

    @KsAdSdkApi
    @Keep
    float getAppScore();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getAppVersion();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getCorporationName();

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Nullable
    @KsAdSdkApi
    @Keep
    List<KsImage> getImageList();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getIntroductionInfo();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getIntroductionInfoUrl();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getPermissionInfo();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getPermissionInfoUrl();

    @KsAdSdkApi
    @Keep
    String getProductName();

    @Nullable
    @KsAdSdkApi
    @Keep
    KsImage getVideoCoverImage();

    @KsAdSdkApi
    @Keep
    int getVideoDuration();

    @KsAdSdkApi
    @Keep
    int getVideoHeight();

    @Nullable
    @KsAdSdkApi
    @Keep
    String getVideoUrl();

    @Nullable
    @KsAdSdkApi
    @Keep
    View getVideoView(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Keep
    @Deprecated
    @Nullable
    View getVideoView(Context context, boolean z);

    @KsAdSdkApi
    @Keep
    int getVideoWidth();

    @KsAdSdkApi
    @Keep
    @Deprecated
    void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void reportAdVideoPlayEnd();

    @KsAdSdkApi
    @Keep
    void reportAdVideoPlayStart();

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    @Keep
    void setDownloadListener(KsAppDownloadListener ksAppDownloadListener);

    @KsAdSdkApi
    @Keep
    void setVideoPlayListener(VideoPlayListener videoPlayListener);
}
