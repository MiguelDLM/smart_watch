package com.baidu.ar;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;

/* loaded from: classes7.dex */
public abstract class gr<InT, OutT> implements gs<InT, OutT> {
    private int mErrCode;
    private String mErrMsg;
    private boolean rz;
    private gr<OutT, ?> vj;
    private OutT vk;
    private boolean vl;
    private boolean vm;
    private boolean vn;

    private void eP() {
        gr<OutT, ?> grVar;
        if (this.rz || !this.vl || (grVar = this.vj) == null) {
            return;
        }
        if (this.vn) {
            grVar.d(this.mErrCode, this.mErrMsg);
        } else {
            if (this.vm) {
                return;
            }
            grVar.d(this.vk);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> gs<OutT, T> a(gr<OutT, T> grVar) {
        this.vj = grVar;
        eP();
        return grVar;
    }

    public abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    public abstract void cK();

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        this.rz = true;
        cK();
    }

    public final void d(int i, String str) {
        this.vl = true;
        this.vm = true;
        a(i, str, new IError() { // from class: com.baidu.ar.gr.3
            @Override // com.baidu.ar.callback.IError
            public void onError(int i2, String str2, Exception exc) {
                gr.this.c(i2, str2);
                if (gr.this.rz || gr.this.vj == null) {
                    return;
                }
                gr.this.vj.d(i2, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        this.vn = true;
        this.mErrCode = i;
        this.mErrMsg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(InT r3) {
        if (this.rz) {
            return;
        }
        a((gr<InT, OutT>) r3, new ICallbackWith<Object>() { // from class: com.baidu.ar.gr.1
            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(Object obj) {
                gr.this.vl = true;
                gr.this.vk = obj;
                if (gr.this.rz || gr.this.vj == null) {
                    return;
                }
                gr.this.vj.d(obj);
            }
        }, new IError() { // from class: com.baidu.ar.gr.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str, Exception exc) {
                gr.this.d(i, str);
            }
        });
    }

    public void a(int i, String str, IError iError) {
        if (iError != null) {
            iError.onError(i, str, null);
        }
    }
}
