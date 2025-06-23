package com.alibaba.aliagentsdk.callback;

public interface ISend2LpCallback {
    void onSendFailed(int i, String str, int i2);

    void onSendSuccess(int i);
}
