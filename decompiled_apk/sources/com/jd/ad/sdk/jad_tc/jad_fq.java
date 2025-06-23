package com.jd.ad.sdk.jad_tc;

/* loaded from: classes10.dex */
public class jad_fq implements jad_mx<com.jd.ad.sdk.jad_wf.jad_dq> {
    public static final jad_fq jad_an = new jad_fq();

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public com.jd.ad.sdk.jad_wf.jad_dq jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f) {
        boolean z = true;
        if (jad_cpVar.jad_mz() != 1) {
            z = false;
        }
        if (z) {
            jad_cpVar.jad_bo();
        }
        float jad_iv = (float) jad_cpVar.jad_iv();
        float jad_iv2 = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        if (z) {
            jad_cpVar.jad_dq();
        }
        return new com.jd.ad.sdk.jad_wf.jad_dq((jad_iv / 100.0f) * f, (jad_iv2 / 100.0f) * f);
    }
}
