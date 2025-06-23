package com.kwad.components.offline.api.tk;

/* loaded from: classes11.dex */
public interface IOfflineApkLoader {
    void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener);

    void cancelDownload();

    void clearFileCache();

    void installApp();

    void openApp();

    void pauseDownload();

    void resumeDownload();

    void setCustomReportParam(String str);

    void startDownload();

    void stopDownload();

    void uninstallApp();
}
