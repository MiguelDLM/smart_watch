package com.jd.ad.sdk.jad_qz;

import com.jd.ad.sdk.jad_js.jad_zm;

/* loaded from: classes10.dex */
public class jad_qd implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_hu jad_cp;
    public final boolean jad_dq;

    public jad_qd(String str, int i, com.jd.ad.sdk.jad_py.jad_hu jad_huVar, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = jad_huVar;
        this.jad_dq = z;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_qd(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_py.jad_hu jad_bo() {
        return this.jad_cp;
    }

    public boolean jad_cp() {
        return this.jad_dq;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("ShapePath{name=");
        jad_an.append(this.jad_an);
        jad_an.append(", index=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }

    public String jad_an() {
        return this.jad_an;
    }
}
