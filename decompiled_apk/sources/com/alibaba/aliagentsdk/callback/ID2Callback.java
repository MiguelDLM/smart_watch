package com.alibaba.aliagentsdk.callback;

/* loaded from: classes.dex */
public interface ID2Callback {
    void onError(String str, int i);

    void onSuccess();

    void onTimeOut();
}
