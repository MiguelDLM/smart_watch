package com.alibaba.aliagentsdk.callback;

public interface ISend2BtCallback {
    void onSendFailed(String str, int i);

    void onSendSuccess();
}
