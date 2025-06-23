package com.alibaba.aliagentsdk.api;

import com.alibaba.aliagentsdk.callback.IBtDataUploadCallback;

public interface IAliBt extends IAliBtSender {
    void setBtDataUploadCallback(IBtDataUploadCallback iBtDataUploadCallback);
}
