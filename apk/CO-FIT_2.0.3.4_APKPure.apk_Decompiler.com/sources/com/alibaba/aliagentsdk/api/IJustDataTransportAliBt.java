package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.IBtDataUploadCallback;
import com.alibaba.aliagentsdk.callback.ISend2BtCallback;

public abstract class IJustDataTransportAliBt implements IAliBt {
    private static final String TAG = "IJustDataTransportAliBt";

    public abstract void sendData(byte[] bArr, ISend2BtCallback iSend2BtCallback);

    public abstract void setBtDataUploadCallback(IBtDataUploadCallback iBtDataUploadCallback);
}
