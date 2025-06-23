package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.IConnectCallback;
import com.alibaba.aliagentsdk.callback.IID2DispatchCallback;
import com.alibaba.aliagentsdk.callback.IRegisterCallback;
import com.alibaba.aliagentsdk.callback.ISend2LpCallback;
import com.alibaba.aliagentsdk.callback.ITransCodeDispatchCallback;

/* loaded from: classes.dex */
public interface IAliLp {
    void addId2DispatchCallback(IID2DispatchCallback iID2DispatchCallback);

    void addLpConnectStateCallback(IConnectCallback iConnectCallback);

    void addTransDispatchCallback(ITransCodeDispatchCallback iTransCodeDispatchCallback);

    void disconnect();

    void doConnect(String str, String str2, String str3);

    void doRegister(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback);

    String getThingTopicSegment();

    void sendTransData(String str, String str2, ISend2LpCallback iSend2LpCallback);
}
