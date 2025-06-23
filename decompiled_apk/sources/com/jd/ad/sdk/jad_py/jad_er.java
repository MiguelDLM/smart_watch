package com.jd.ad.sdk.jad_py;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_er implements jad_mz<PointF, PointF> {
    public final List<com.jd.ad.sdk.jad_wf.jad_an<PointF>> jad_an;

    public jad_er(List<com.jd.ad.sdk.jad_wf.jad_an<PointF>> list) {
        this.jad_an = list;
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an() {
        return this.jad_an.get(0).jad_cp() ? new com.jd.ad.sdk.jad_mv.jad_kx(this.jad_an) : new com.jd.ad.sdk.jad_mv.jad_jw(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public List<com.jd.ad.sdk.jad_wf.jad_an<PointF>> jad_bo() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public boolean jad_cp() {
        return this.jad_an.size() == 1 && this.jad_an.get(0).jad_cp();
    }
}
