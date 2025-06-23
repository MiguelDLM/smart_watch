package com.jd.ad.sdk.jad_mv;

import java.util.List;

/* loaded from: classes10.dex */
public class jad_dq extends jad_jt<Float> {
    public jad_dq(List<com.jd.ad.sdk.jad_wf.jad_an<Float>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_wf.jad_an jad_anVar, float f) {
        return Float.valueOf(jad_bo(jad_anVar, f));
    }

    public float jad_bo(com.jd.ad.sdk.jad_wf.jad_an<Float> jad_anVar, float f) {
        Float f2;
        if (jad_anVar.jad_bo != null && jad_anVar.jad_cp != null) {
            com.jd.ad.sdk.jad_wf.jad_cp<A> jad_cpVar = this.jad_er;
            if (jad_cpVar != 0 && (f2 = (Float) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
                return f2.floatValue();
            }
            if (jad_anVar.jad_iv == -3987645.8f) {
                jad_anVar.jad_iv = jad_anVar.jad_bo.floatValue();
            }
            float f3 = jad_anVar.jad_iv;
            if (jad_anVar.jad_jw == -3987645.8f) {
                jad_anVar.jad_jw = jad_anVar.jad_cp.floatValue();
            }
            return com.jd.ad.sdk.jad_ve.jad_jt.jad_an(f3, jad_anVar.jad_jw, f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public float jad_hu() {
        return jad_bo(jad_an(), jad_cp());
    }
}
