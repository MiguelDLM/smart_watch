package com.jd.ad.sdk.jad_qz;

import android.graphics.Path;

/* loaded from: classes10.dex */
public class jad_er implements jad_cp {
    public final int jad_an;
    public final Path.FillType jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_cp jad_cp;
    public final com.jd.ad.sdk.jad_py.jad_dq jad_dq;
    public final com.jd.ad.sdk.jad_py.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_py.jad_fs jad_fs;
    public final boolean jad_hu;
    public final String jad_jt;

    public jad_er(String str, int i, Path.FillType fillType, com.jd.ad.sdk.jad_py.jad_cp jad_cpVar, com.jd.ad.sdk.jad_py.jad_dq jad_dqVar, com.jd.ad.sdk.jad_py.jad_fs jad_fsVar, com.jd.ad.sdk.jad_py.jad_fs jad_fsVar2, com.jd.ad.sdk.jad_py.jad_bo jad_boVar, com.jd.ad.sdk.jad_py.jad_bo jad_boVar2, boolean z) {
        this.jad_an = i;
        this.jad_bo = fillType;
        this.jad_cp = jad_cpVar;
        this.jad_dq = jad_dqVar;
        this.jad_er = jad_fsVar;
        this.jad_fs = jad_fsVar2;
        this.jad_jt = str;
        this.jad_hu = z;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_hu(jad_mzVar, jad_anVar, this);
    }

    public Path.FillType jad_bo() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_py.jad_cp jad_cp() {
        return this.jad_cp;
    }

    public int jad_dq() {
        return this.jad_an;
    }

    public String jad_er() {
        return this.jad_jt;
    }

    public com.jd.ad.sdk.jad_py.jad_dq jad_fs() {
        return this.jad_dq;
    }

    public boolean jad_hu() {
        return this.jad_hu;
    }

    public com.jd.ad.sdk.jad_py.jad_fs jad_jt() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_py.jad_fs jad_an() {
        return this.jad_fs;
    }
}
