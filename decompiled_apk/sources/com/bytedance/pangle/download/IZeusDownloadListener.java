package com.bytedance.pangle.download;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes8.dex */
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i, String str);

    void onProgress(long j, long j2);

    void onStart();

    void onSuccess(String str, String str2, long j);
}
