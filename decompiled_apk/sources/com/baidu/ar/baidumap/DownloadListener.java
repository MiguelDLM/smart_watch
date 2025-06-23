package com.baidu.ar.baidumap;

/* loaded from: classes7.dex */
public interface DownloadListener {
    void onDownloadComplete(boolean z);

    void onDownloadError(int i, String str);

    void onDownloadProcess(int i);

    void onDownloadStart(boolean z);
}
