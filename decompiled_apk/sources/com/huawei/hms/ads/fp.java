package com.huawei.hms.ads;

import android.view.View;

/* loaded from: classes10.dex */
public class fp extends fs {
    private static final String Code = "NativeViewMonitor";
    private boolean B;
    private long C;
    private long I;
    private int S;
    private fo V;
    private int Z;

    public fp(View view, fo foVar) {
        super(view);
        this.I = 500L;
        this.Z = 50;
        this.B = false;
        this.V = foVar;
        this.C = com.huawei.openalliance.ad.utils.w.Code();
    }

    private void B() {
        if (this.B) {
            return;
        }
        fb.V(Code, "viewShowStartRecord");
        this.B = true;
        this.C = System.currentTimeMillis();
        fo foVar = this.V;
        if (foVar != null) {
            foVar.a_();
        }
    }

    private void C() {
        if (this.B) {
            fb.V(Code, "viewShowEndRecord");
            this.B = false;
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (fb.Code()) {
                fb.Code(Code, "max visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(currentTimeMillis));
            }
            fo foVar = this.V;
            if (foVar != null) {
                foVar.Code(currentTimeMillis, this.S);
            }
            this.S = 0;
        }
    }

    @Override // com.huawei.hms.ads.fs
    public void Code() {
        fo foVar = this.V;
        if (foVar != null) {
            foVar.I();
        }
    }

    public int I() {
        return this.S;
    }

    public void V() {
        this.Z = 50;
        this.I = 500L;
    }

    public long Z() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.fs
    public void Code(int i) {
        if (i > this.S) {
            this.S = i;
        }
        if (i >= this.Z) {
            B();
        } else {
            C();
        }
    }

    public void V(long j, int i) {
        this.Z = i;
        this.I = j;
    }

    @Override // com.huawei.hms.ads.fs
    public void Code(long j, int i) {
        C();
        fo foVar = this.V;
        if (foVar != null) {
            foVar.V(j, i);
        }
    }

    public boolean Code(long j) {
        return j >= this.I && this.S >= this.Z;
    }
}
