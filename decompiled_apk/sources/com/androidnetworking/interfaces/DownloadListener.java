package com.androidnetworking.interfaces;

import com.androidnetworking.error.ANError;

/* loaded from: classes.dex */
public interface DownloadListener {
    void onDownloadComplete();

    void onError(ANError aNError);
}
