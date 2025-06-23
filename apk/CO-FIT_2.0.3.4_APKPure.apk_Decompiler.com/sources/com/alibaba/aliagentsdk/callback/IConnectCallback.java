package com.alibaba.aliagentsdk.callback;

public interface IConnectCallback {
    void onIotConnectFailure(String str, int i);

    void onIotConnected();

    void onIotDisconnected();
}
