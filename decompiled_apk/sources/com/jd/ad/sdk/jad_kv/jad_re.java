package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public class jad_re<Z> implements jad_xk<Z> {
    public final boolean jad_an;
    public final boolean jad_bo;
    public final jad_xk<Z> jad_cp;
    public final jad_an jad_dq;
    public final com.jd.ad.sdk.jad_hs.jad_hu jad_er;
    public int jad_fs;
    public boolean jad_jt;

    /* loaded from: classes10.dex */
    public interface jad_an {
        void jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, jad_re<?> jad_reVar);
    }

    public jad_re(jad_xk<Z> jad_xkVar, boolean z, boolean z2, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, jad_an jad_anVar) {
        this.jad_cp = (jad_xk) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_xkVar);
        this.jad_an = z;
        this.jad_bo = z2;
        this.jad_er = jad_huVar;
        this.jad_dq = (jad_an) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_anVar);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Z get() {
        return this.jad_cp.get();
    }

    public synchronized void jad_an() {
        if (this.jad_jt) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.jad_fs++;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public int jad_bo() {
        return this.jad_cp.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Class<Z> jad_cp() {
        return this.jad_cp.jad_cp();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public synchronized void jad_dq() {
        if (this.jad_fs > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.jad_jt) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.jad_jt = true;
        if (this.jad_bo) {
            this.jad_cp.jad_dq();
        }
    }

    public jad_xk<Z> jad_er() {
        return this.jad_cp;
    }

    public boolean jad_fs() {
        return this.jad_an;
    }

    public void jad_jt() {
        boolean z;
        synchronized (this) {
            int i = this.jad_fs;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.jad_fs = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.jad_dq.jad_an(this.jad_er, this);
        }
    }

    public synchronized String toString() {
        StringBuilder jad_an2;
        jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("EngineResource{isMemoryCacheable=");
        jad_an2.append(this.jad_an);
        jad_an2.append(", listener=");
        jad_an2.append(this.jad_dq);
        jad_an2.append(", key=");
        jad_an2.append(this.jad_er);
        jad_an2.append(", acquired=");
        jad_an2.append(this.jad_fs);
        jad_an2.append(", isRecycled=");
        jad_an2.append(this.jad_jt);
        jad_an2.append(", resource=");
        jad_an2.append(this.jad_cp);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
