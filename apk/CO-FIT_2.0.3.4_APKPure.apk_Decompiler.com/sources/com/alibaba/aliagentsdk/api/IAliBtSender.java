package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.ISend2BtCallback;

public interface IAliBtSender {
    void sendData(byte[] bArr, ISend2BtCallback iSend2BtCallback);
}
