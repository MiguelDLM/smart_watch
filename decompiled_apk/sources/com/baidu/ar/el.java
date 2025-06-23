package com.baidu.ar;

import com.baidu.ar.ihttp.HttpException;

/* loaded from: classes7.dex */
class el implements ew {
    private fa rx;
    private HttpException ry;
    private Object mLock = new Object();
    private volatile boolean rz = false;

    public el(HttpException httpException, fa faVar) {
        this.ry = httpException;
        this.rx = faVar;
    }

    @Override // com.baidu.ar.ew
    public void cancel() {
        if (this.rz) {
            return;
        }
        synchronized (this.mLock) {
            this.rz = true;
        }
    }

    @Override // com.baidu.ar.ew
    public et dH() {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLock) {
            try {
                if (this.rz) {
                    return;
                }
                fa faVar = this.rx;
                if (faVar != null) {
                    faVar.a(this.ry);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
