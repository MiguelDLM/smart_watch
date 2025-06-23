package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.ISend2LpCallback;

public interface IAli2LpSender {
    void sendId2Data(String str, String str2, ISend2LpCallback iSend2LpCallback);
}
