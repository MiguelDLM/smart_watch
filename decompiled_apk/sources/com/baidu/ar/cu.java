package com.baidu.ar;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.content.IRequestCallback;

/* loaded from: classes7.dex */
public class cu<T> extends gr<T, T> {
    private IRequestCallback<T> nZ;

    public cu(IRequestCallback<T> iRequestCallback) {
        this.nZ = iRequestCallback;
    }

    @Override // com.baidu.ar.gr
    public void a(int i, String str, IError iError) {
        IRequestCallback<T> iRequestCallback = this.nZ;
        if (iRequestCallback != null) {
            iRequestCallback.onFail(i, str);
        }
    }

    @Override // com.baidu.ar.gr
    public void cK() {
    }

    @Override // com.baidu.ar.gr
    public void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        IRequestCallback<T> iRequestCallback = this.nZ;
        if (iRequestCallback != null) {
            iRequestCallback.onResponse(t);
        }
    }
}
