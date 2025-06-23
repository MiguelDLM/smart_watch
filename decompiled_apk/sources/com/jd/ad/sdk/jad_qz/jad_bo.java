package com.jd.ad.sdk.jad_qz;

import android.graphics.PointF;

/* loaded from: classes10.dex */
public class jad_bo implements jad_cp {
    public final String jad_an;
    public final com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_fs jad_cp;
    public final boolean jad_dq;
    public final boolean jad_er;

    public jad_bo(String str, com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_mzVar, com.jd.ad.sdk.jad_py.jad_fs jad_fsVar, boolean z, boolean z2) {
        this.jad_an = str;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_fsVar;
        this.jad_dq = z;
        this.jad_er = z2;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_fs(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_bo() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_py.jad_fs jad_cp() {
        return this.jad_cp;
    }

    public String jad_an() {
        return this.jad_an;
    }
}
