package com.alibaba.aliagentsdk.callback;

public interface IHandlerCallback {
    void onFgsCheckFailed(String str, int i);

    void onFgsCheckSuccess();
}
