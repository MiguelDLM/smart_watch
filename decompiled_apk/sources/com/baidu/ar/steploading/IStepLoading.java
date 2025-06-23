package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallbackWith;

/* loaded from: classes7.dex */
public interface IStepLoading {
    void cancel();

    void retry();

    void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith);
}
