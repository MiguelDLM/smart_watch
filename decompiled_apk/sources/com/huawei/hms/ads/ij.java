package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public abstract class ij {
    private final String B = "min_show_time_task" + hashCode();
    private final String C = "max_show_time_task" + hashCode();
    protected ed Code;
    private ky Z;

    public ij(ed edVar, ky kyVar) {
        this.Code = edVar;
        this.Z = kyVar;
    }

    public void B() {
        com.huawei.openalliance.ad.utils.bf.Code(this.B);
    }

    public void Code() {
    }

    public void I() {
        ky kyVar = this.Z;
        if (kyVar != null) {
            kyVar.Code();
        }
    }

    public void V() {
    }

    public void Z() {
        ky kyVar = this.Z;
        if (kyVar != null) {
            kyVar.V();
        }
    }

    public void Code(long j) {
        fb.V(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ij.1
            @Override // java.lang.Runnable
            public void run() {
                ij.this.B();
                ij.this.Z();
            }
        }, this.C, j);
    }

    public void V(long j) {
        fb.V(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ij.2
            @Override // java.lang.Runnable
            public void run() {
                ij.this.I();
            }
        }, this.B, j);
    }
}
