package com.baidu.ar;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.remoteres.IDuMixResLoadTask;

/* loaded from: classes7.dex */
public interface ib {
    void downloadARRes(ARType aRType, ICallback iCallback);

    void setErrorCallback(ICallbackWith<IDuMixResLoadTask> iCallbackWith);
}
