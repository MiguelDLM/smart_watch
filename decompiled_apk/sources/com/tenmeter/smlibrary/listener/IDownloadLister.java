package com.tenmeter.smlibrary.listener;

/* loaded from: classes13.dex */
public interface IDownloadLister {
    void onError(String str);

    void onFinish(String str);

    void onProgress(long j, int i);

    void onStart();
}
