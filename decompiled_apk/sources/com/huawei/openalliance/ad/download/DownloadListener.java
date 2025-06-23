package com.huawei.openalliance.ad.download;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.download.DownloadTask;

@AllApi
/* loaded from: classes10.dex */
public interface DownloadListener<T extends DownloadTask> {
    void onAppInstalled(T t);

    void onAppUnInstalled(T t);

    void onDownloadDeleted(T t);

    void onDownloadFail(T t);

    void onDownloadPaused(T t);

    void onDownloadProgress(T t);

    void onDownloadResumed(T t);

    void onDownloadStart(T t);

    void onDownloadSuccess(T t);

    void onDownloadWaiting(T t);

    void onSilentInstallFailed(T t);

    void onSilentInstallStart(T t);

    void onSilentInstallSuccess(T t);

    void onSystemInstallStart(T t);
}
