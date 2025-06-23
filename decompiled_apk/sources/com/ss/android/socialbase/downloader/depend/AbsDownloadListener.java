package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes13.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onCanceled -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        String str;
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str2 = TAG;
            String name = downloadInfo.getName();
            if (baseException != null) {
                str = baseException.getErrorMessage();
            } else {
                str = "unkown";
            }
            com.ss.android.socialbase.downloader.c.a.b(str2, String.format("onFailed on %s because of : %s", name, str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onFirstStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onFirstSuccess -- " + downloadInfo.getName());
        }
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onIntercept -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onPause -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onPrepare -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null && downloadInfo.getTotalBytes() != 0) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        String str;
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str2 = TAG;
            String name = downloadInfo.getName();
            if (baseException != null) {
                str = baseException.getErrorMessage();
            } else {
                str = "unkown";
            }
            com.ss.android.socialbase.downloader.c.a.b(str2, String.format("onRetry on %s because of : %s", name, str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        String str;
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str2 = TAG;
            String name = downloadInfo.getName();
            if (baseException != null) {
                str = baseException.getErrorMessage();
            } else {
                str = "unkown";
            }
            com.ss.android.socialbase.downloader.c.a.b(str2, String.format("onRetryDelay on %s because of : %s", name, str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
        }
    }
}
