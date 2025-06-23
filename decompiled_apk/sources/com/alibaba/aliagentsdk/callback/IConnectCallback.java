package com.alibaba.aliagentsdk.callback;

/* loaded from: classes.dex */
public interface IConnectCallback {
    void onIotConnectFailure(String str, int i);

    void onIotConnected();

    void onIotDisconnected();
}
