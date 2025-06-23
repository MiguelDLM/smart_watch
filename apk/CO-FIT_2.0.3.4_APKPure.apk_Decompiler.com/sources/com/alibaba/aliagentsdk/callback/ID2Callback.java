package com.alibaba.aliagentsdk.callback;

public interface ID2Callback {
    void onError(String str, int i);

    void onSuccess();

    void onTimeOut();
}
