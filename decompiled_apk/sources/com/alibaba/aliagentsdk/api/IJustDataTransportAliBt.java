package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.IBtDataUploadCallback;
import com.alibaba.aliagentsdk.callback.ISend2BtCallback;

/* loaded from: classes.dex */
public abstract class IJustDataTransportAliBt implements IAliBt {
    private static final String TAG = "IJustDataTransportAliBt";

    @Override // com.alibaba.aliagentsdk.api.IAliBtSender
    public abstract void sendData(byte[] bArr, ISend2BtCallback iSend2BtCallback);

    @Override // com.alibaba.aliagentsdk.api.IAliBt
    public abstract void setBtDataUploadCallback(IBtDataUploadCallback iBtDataUploadCallback);
}
