package com.jd.ad.sdk.jad_xk;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes10.dex */
public class jad_kx {
    public final int jad_an;
    public final jad_fs jad_bo;
    public final int jad_cp;
    public final int jad_dq;
    public final String jad_er;
    public final jad_er jad_fs;
    public final jad_an jad_hu;
    public final boolean jad_jt;

    /* loaded from: classes10.dex */
    public interface jad_an {
        void jad_an(int i, String str);

        void jad_an(jad_ly jad_lyVar);
    }

    /* loaded from: classes10.dex */
    public static class jad_bo {
        public int jad_an;
        public jad_fs jad_bo;
        public int jad_cp;
        public int jad_dq;
        public String jad_er;
        public jad_er jad_fs;
        public boolean jad_hu;
        public jad_an jad_jt;

        public void jad_an(ThreadPoolExecutor threadPoolExecutor) {
            jad_kx jad_kxVar = new jad_kx(this);
            jad_cp jad_cpVar = new jad_cp(jad_kxVar);
            jad_cpVar.jad_cp = new jad_iv(jad_kxVar);
            threadPoolExecutor.execute(jad_cpVar);
        }
    }

    public jad_kx(jad_bo jad_boVar) {
        this.jad_an = jad_boVar.jad_an;
        this.jad_bo = jad_boVar.jad_bo;
        this.jad_cp = jad_boVar.jad_cp;
        this.jad_dq = jad_boVar.jad_dq;
        this.jad_er = jad_boVar.jad_er;
        this.jad_fs = jad_boVar.jad_fs;
        this.jad_jt = jad_boVar.jad_hu;
        this.jad_hu = jad_boVar.jad_jt;
    }

    public String jad_an() {
        return this.jad_er;
    }
}
