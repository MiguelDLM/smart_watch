package com.jieli.jl_rcsp.interfaces.watch;

/* loaded from: classes8.dex */
public interface OnUpdateResourceCallback {
    void onError(int i, String str);

    void onProgress(int i, String str, float f);

    void onStart(String str, int i);

    void onStop(String str);
}
