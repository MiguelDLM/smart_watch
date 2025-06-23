package com.ss.android.socialbase.downloader.i;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes13.dex */
public class d {
    public static boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_head_request") != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_save_path") != 1) {
            return false;
        }
        return true;
    }
}
