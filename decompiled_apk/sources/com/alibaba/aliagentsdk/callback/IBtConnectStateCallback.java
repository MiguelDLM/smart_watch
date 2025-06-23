package com.alibaba.aliagentsdk.callback;

/* loaded from: classes.dex */
public interface IBtConnectStateCallback {
    void onConnectError(String str, int i);

    void onConnected();

    void onDisConnected();
}
