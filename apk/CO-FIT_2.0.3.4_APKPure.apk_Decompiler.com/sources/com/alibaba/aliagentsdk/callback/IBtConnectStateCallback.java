package com.alibaba.aliagentsdk.callback;

public interface IBtConnectStateCallback {
    void onConnectError(String str, int i);

    void onConnected();

    void onDisConnected();
}
