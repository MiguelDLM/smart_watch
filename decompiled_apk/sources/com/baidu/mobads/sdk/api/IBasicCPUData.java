package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IBasicCPUData extends AbstractData {

    /* loaded from: classes7.dex */
    public interface CpuNativeStatusCB {
        void onAdDownloadWindowShow();

        void onAdStatusChanged(String str, int i);

        void onNotifyPerformance(String str);

        void onPermissionClose();

        void onPermissionShow();

        void onPrivacyClick();

        void onPrivacyLpClose();
    }

    void cancelAppDownload();

    void clickHotItem(View view);

    int getActionType();

    int getAdHeight();

    String getAdLogoUrl();

    int getAdWidth();

    String getAppPackageName();

    String getAppPermissionUrl();

    String getAppPrivacyUrl();

    String getAppPublisher();

    String getAppVersion();

    int getAttribute();

    String getAuthor();

    String getBaiduLogoUrl();

    String getBrandName();

    String getChannelId();

    String getChannelName();

    int getCommentCounts();

    List<Integer> getContentAttributesList();

    String getContentClickUrl();

    long getCtime();

    String getDesc();

    JSONArray getDislikeReasons();

    int getDownloadStatus();

    int getDuration();

    JSONObject getExtra();

    long getHotId();

    String getHotWord();

    String getIconUrl();

    String getImage();

    List<String> getImageUrls();

    String getLabel();

    int getPlayCounts();

    int getPresentationType();

    int getReadCounts();

    double getScore();

    List<String> getSmallImageUrls();

    int getStyleTypeCpu();

    int getThumbHeight();

    String getThumbUrl();

    int getThumbWidth();

    String getTitle();

    String getType();

    String getUpdateTime();

    String getVUrl();

    @Deprecated
    void handleClick(View view, Object... objArr);

    void handleCreativeView(View view);

    void handleDislikeClick(View view, int i);

    boolean isAutoplay();

    boolean isCanGoLp();

    boolean isNeedDownloadApp();

    boolean isTop();

    void markDislike(String[] strArr);

    @Deprecated
    void onImpression(View view);

    void pauseAppDownload();

    void registerViewForInteraction(View view, List<View> list, List<View> list2, CpuNativeStatusCB cpuNativeStatusCB);

    @Deprecated
    void setStatusListener(CpuNativeStatusCB cpuNativeStatusCB);
}
