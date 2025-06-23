package com.baidu.ar.baidumap;

/* loaded from: classes7.dex */
public interface CaseDownloadListener {
    void onDownloadFinish(boolean z, String str, String str2, int i, String str3);

    void onDownloadProgress(int i, String str);

    void onRefused();
}
