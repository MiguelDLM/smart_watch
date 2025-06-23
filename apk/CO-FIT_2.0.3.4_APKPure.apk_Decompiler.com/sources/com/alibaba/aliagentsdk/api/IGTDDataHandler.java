package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.domain.SendData;

public interface IGTDDataHandler {
    byte[] handleDispatchId2Data(String str, String str2);

    void handleGTD(SendData sendData, IAli2LpSender iAli2LpSender);
}
