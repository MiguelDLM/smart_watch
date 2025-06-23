package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_hq.jad_an;

/* loaded from: classes10.dex */
public final class jad_wj<Z> implements jad_xk<Z>, jad_an.jad_dq {
    public static final Pools.Pool<jad_wj<?>> jad_er = com.jd.ad.sdk.jad_hq.jad_an.jad_an(20, new jad_an());
    public final com.jd.ad.sdk.jad_hq.jad_dq jad_an = com.jd.ad.sdk.jad_hq.jad_dq.jad_an();
    public jad_xk<Z> jad_bo;
    public boolean jad_cp;
    public boolean jad_dq;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_an.jad_bo<jad_wj<?>> {
        @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_bo
        public jad_wj<?> jad_an() {
            return new jad_wj<>();
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Z get() {
        return this.jad_bo.get();
    }

    @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_dq
    @NonNull
    public com.jd.ad.sdk.jad_hq.jad_dq jad_an() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public int jad_bo() {
        return this.jad_bo.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Class<Z> jad_cp() {
        return this.jad_bo.jad_cp();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public synchronized void jad_dq() {
        this.jad_an.jad_bo();
        this.jad_dq = true;
        if (!this.jad_cp) {
            this.jad_bo.jad_dq();
            this.jad_bo = null;
            ((jad_an.jad_cp) jad_er).release(this);
        }
    }

    public synchronized void jad_er() {
        this.jad_an.jad_bo();
        if (!this.jad_cp) {
            throw new IllegalStateException("Already unlocked");
        }
        this.jad_cp = false;
        if (this.jad_dq) {
            jad_dq();
        }
    }

    @NonNull
    public static <Z> jad_wj<Z> jad_an(jad_xk<Z> jad_xkVar) {
        jad_wj<Z> jad_wjVar = (jad_wj) com.jd.ad.sdk.jad_gp.jad_kx.jad_an((jad_wj) ((jad_an.jad_cp) jad_er).acquire());
        jad_wjVar.jad_dq = false;
        jad_wjVar.jad_cp = true;
        jad_wjVar.jad_bo = jad_xkVar;
        return jad_wjVar;
    }
}
