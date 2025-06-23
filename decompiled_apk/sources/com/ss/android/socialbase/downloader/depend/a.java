package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes13.dex */
public abstract class a extends AbsDownloadListener implements s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26245a = "a";

    public void a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            com.ss.android.socialbase.downloader.c.a.b(f26245a, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
        }
    }
}
