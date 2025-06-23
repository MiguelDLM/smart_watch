package com.baidu.ar;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;

/* loaded from: classes7.dex */
class jd<T> extends gr<T, T> {
    private ICallback zU;
    private IError zV;

    public jd(ICallback iCallback, IError iError) {
        this.zU = iCallback;
        this.zV = iError;
    }

    @Override // com.baidu.ar.gr
    public void a(int i, String str, IError iError) {
        IError iError2 = this.zV;
        if (iError2 != null) {
            iError2.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.gr
    public void cK() {
    }

    @Override // com.baidu.ar.gr
    public void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        ICallback iCallback = this.zU;
        if (iCallback != null) {
            iCallback.run();
        }
    }
}
