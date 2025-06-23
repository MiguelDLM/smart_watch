package com.jd.ad.sdk.jad_py;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_iv implements jad_mz<PointF, PointF> {
    public final jad_bo jad_an;
    public final jad_bo jad_bo;

    public jad_iv(jad_bo jad_boVar, jad_bo jad_boVar2) {
        this.jad_an = jad_boVar;
        this.jad_bo = jad_boVar2;
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an() {
        return new com.jd.ad.sdk.jad_mv.jad_na(this.jad_an.jad_an(), this.jad_bo.jad_an());
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public List<com.jd.ad.sdk.jad_wf.jad_an<PointF>> jad_bo() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public boolean jad_cp() {
        return this.jad_an.jad_cp() && this.jad_bo.jad_cp();
    }
}
