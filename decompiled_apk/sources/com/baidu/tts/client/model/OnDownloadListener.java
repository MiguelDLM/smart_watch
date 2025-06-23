package com.baidu.tts.client.model;

/* loaded from: classes8.dex */
public interface OnDownloadListener {
    void onFinish(String str, int i);

    void onProgress(String str, long j, long j2);

    void onStart(String str);
}
