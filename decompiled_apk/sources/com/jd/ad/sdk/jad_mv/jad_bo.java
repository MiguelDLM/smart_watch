package com.jd.ad.sdk.jad_mv;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo extends jad_jt<Integer> {
    public jad_bo(List<com.jd.ad.sdk.jad_wf.jad_an<Integer>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_wf.jad_an jad_anVar, float f) {
        return Integer.valueOf(jad_bo(jad_anVar, f));
    }

    public int jad_bo(com.jd.ad.sdk.jad_wf.jad_an<Integer> jad_anVar, float f) {
        Integer num;
        if (jad_anVar.jad_bo != null && jad_anVar.jad_cp != null) {
            com.jd.ad.sdk.jad_wf.jad_cp<A> jad_cpVar = this.jad_er;
            if (jad_cpVar != 0 && (num = (Integer) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
                return num.intValue();
            }
            PointF pointF = com.jd.ad.sdk.jad_ve.jad_jt.jad_an;
            return com.jd.ad.sdk.jad_ve.jad_bo.jad_an(Math.max(0.0f, Math.min(1.0f, f)), jad_anVar.jad_bo.intValue(), jad_anVar.jad_cp.intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
