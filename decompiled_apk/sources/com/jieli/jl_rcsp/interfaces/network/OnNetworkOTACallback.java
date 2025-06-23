package com.jieli.jl_rcsp.interfaces.network;

/* loaded from: classes8.dex */
public interface OnNetworkOTACallback {
    void onCancel();

    void onError(int i, String str);

    void onProgress(int i);

    void onStart();

    void onStop();
}
