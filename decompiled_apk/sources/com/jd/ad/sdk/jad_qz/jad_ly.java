package com.jd.ad.sdk.jad_qz;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_js.jad_zm;

/* loaded from: classes10.dex */
public class jad_ly implements jad_cp {
    public final String jad_an;
    public final com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_cp;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_dq;
    public final boolean jad_er;

    public jad_ly(String str, com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_mzVar, com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_mzVar2, com.jd.ad.sdk.jad_py.jad_bo jad_boVar, boolean z) {
        this.jad_an = str;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_mzVar2;
        this.jad_dq = jad_boVar;
        this.jad_er = z;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_ob(jad_mzVar, jad_anVar, this);
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_cp() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_dq() {
        return this.jad_cp;
    }

    public boolean jad_er() {
        return this.jad_er;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("RectangleShape{position=");
        jad_an.append(this.jad_bo);
        jad_an.append(", size=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_an() {
        return this.jad_dq;
    }
}
