package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.IConnectCallback;
import com.alibaba.aliagentsdk.callback.IFgsStateCheckCallback;

/* loaded from: classes.dex */
public interface IAliAgent {
    void checkFgsState(IFgsStateCheckCallback iFgsStateCheckCallback);

    void connectLp();

    void customBtImpl(IAliBt iAliBt);

    void customGTDDataHandler(IGTDDataHandler iGTDDataHandler);

    void disconnectLp();

    void setLpConnectedCallback(IConnectCallback iConnectCallback);
}
