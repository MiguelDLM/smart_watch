package com.huawei.hms.ads;

import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public interface IAppDownloadButton {
    void cancel();

    void continueDownload();

    AppDownloadStatus refreshAppStatus();

    void setAllowedNonWifiNetwork(boolean z);

    void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle);

    void setOnDownloadStatusChangedListener(AppDownloadButton.OnDownloadStatusChangedListener onDownloadStatusChangedListener);

    void setOnNonWifiDownloadListener(AppDownloadButton.OnNonWifiDownloadListener onNonWifiDownloadListener);

    void setShowPermissionDialog(boolean z);
}
