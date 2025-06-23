package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.ID2Callback;
import com.alibaba.aliagentsdk.callback.IRegisterCallback;
import com.alibaba.aliagentsdk.callback.ISend2BtCallback;
import com.alibaba.aliagentsdk.callback.ISend2LpCallback;

/* loaded from: classes.dex */
public interface IAliAgentDev extends IAliAgent {
    void testId2DataSend(String str, long j, ID2Callback iD2Callback);

    void testRegister(String str, String str2, String str3, IRegisterCallback iRegisterCallback);

    void testRegister(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback);

    void testSendData2Bt(String str, String str2, ISend2BtCallback iSend2BtCallback);

    void testSendData2Bt(byte[] bArr, ISend2BtCallback iSend2BtCallback);

    void testSendTransCodeToLp(String str, String str2, ISend2LpCallback iSend2LpCallback);
}
