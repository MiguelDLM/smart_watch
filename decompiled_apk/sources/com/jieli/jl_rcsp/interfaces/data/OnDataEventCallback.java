package com.jieli.jl_rcsp.interfaces.data;

import com.jieli.jl_rcsp.model.base.BaseError;

/* loaded from: classes8.dex */
public interface OnDataEventCallback {
    void onBegin(int i);

    void onError(BaseError baseError);

    void onProgress(float f);

    void onStop(int i, byte[] bArr);
}
