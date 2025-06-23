package com.baidu.ar;

import com.baidu.ar.recg.IOnDeviceIR;
import com.baidu.ar.recg.IOnDeviceIRStateChangedListener;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class gw extends e implements IOnDeviceIR {
    private WeakReference<IOnDeviceIR> nz;
    private IOnDeviceIRStateChangedListener vA;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar instanceof IOnDeviceIR) {
            IOnDeviceIR iOnDeviceIR = (IOnDeviceIR) dVar;
            this.nz = new WeakReference<>(iOnDeviceIR);
            IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener = this.vA;
            if (iOnDeviceIRStateChangedListener != null) {
                iOnDeviceIR.setStateChangedListener(iOnDeviceIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<IOnDeviceIR> weakReference = this.nz;
        if (weakReference != null) {
            weakReference.clear();
            this.nz = null;
        }
        this.vA = null;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        WeakReference<IOnDeviceIR> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        WeakReference<IOnDeviceIR> weakReference;
        this.vA = iOnDeviceIRStateChangedListener;
        if (iOnDeviceIRStateChangedListener == null || (weakReference = this.nz) == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().setStateChangedListener(this.vA);
    }
}
