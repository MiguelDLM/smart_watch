package com.jd.ad.sdk.jad_mv;

import java.util.List;

/* loaded from: classes10.dex */
public class jad_ob extends jad_jt<com.jd.ad.sdk.jad_ox.jad_bo> {
    public jad_ob(List<com.jd.ad.sdk.jad_wf.jad_an<com.jd.ad.sdk.jad_ox.jad_bo>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_wf.jad_an jad_anVar, float f) {
        T t;
        if (f == 1.0f && (t = jad_anVar.jad_cp) != 0) {
            return (com.jd.ad.sdk.jad_ox.jad_bo) t;
        }
        return (com.jd.ad.sdk.jad_ox.jad_bo) jad_anVar.jad_bo;
    }
}
