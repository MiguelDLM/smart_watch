package com.baidu.ar;

import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class jz extends e implements jx {
    private jy BB;
    private WeakReference<jx> nz;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar instanceof jx) {
            jx jxVar = (jx) dVar;
            this.nz = new WeakReference<>(jxVar);
            jy jyVar = this.BB;
            if (jyVar != null) {
                jxVar.a(jyVar);
            }
        }
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<jx> weakReference = this.nz;
        if (weakReference != null) {
            weakReference.clear();
            this.nz = null;
        }
        this.BB = null;
    }

    @Override // com.baidu.ar.jx
    public void a(jy jyVar) {
        WeakReference<jx> weakReference;
        this.BB = jyVar;
        if (jyVar == null || (weakReference = this.nz) == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().a(this.BB);
    }
}
