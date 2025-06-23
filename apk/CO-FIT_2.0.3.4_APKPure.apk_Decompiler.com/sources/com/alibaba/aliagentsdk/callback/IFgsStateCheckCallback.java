package com.alibaba.aliagentsdk.callback;

public interface IFgsStateCheckCallback {
    void onFgsCheckError(String str, int i);

    void onFgsCheckSuccess();
}
