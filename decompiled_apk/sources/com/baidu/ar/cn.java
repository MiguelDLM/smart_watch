package com.baidu.ar;

import com.baidu.ar.cloud.ICloudIR;
import com.baidu.ar.cloud.ICloudIRStateChangedListener;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class cn extends e implements ICloudIR {
    private ICloudIRStateChangedListener nA;
    private WeakReference<ICloudIR> nz;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar instanceof ICloudIR) {
            ICloudIR iCloudIR = (ICloudIR) dVar;
            this.nz = new WeakReference<>(iCloudIR);
            ICloudIRStateChangedListener iCloudIRStateChangedListener = this.nA;
            if (iCloudIRStateChangedListener != null) {
                iCloudIR.setStateChangedListener(iCloudIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        WeakReference<ICloudIR> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().pause();
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<ICloudIR> weakReference = this.nz;
        if (weakReference != null) {
            weakReference.clear();
            this.nz = null;
        }
        this.nA = null;
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        WeakReference<ICloudIR> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        WeakReference<ICloudIR> weakReference;
        this.nA = iCloudIRStateChangedListener;
        if (iCloudIRStateChangedListener == null || (weakReference = this.nz) == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().setStateChangedListener(this.nA);
    }
}
