package com.baidu.ar.baidumap;

/* loaded from: classes7.dex */
public interface MapDuMixListener {
    void onCaseLoadEnd(String str);

    void onCaseLoadStart(String str);

    void onResDownloadFinish(boolean z, int i, String str);

    void onResDownloadStart(String str);

    void onSoDownloadFinish(boolean z, int i, String str);

    void onSoDownloadStart(String str);
}
