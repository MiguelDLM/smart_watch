package com.jd.ad.sdk.jad_mv;

import XXO0.oIX0oI;
import com.jd.ad.sdk.jad_js.jad_zm;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_er extends jad_jt<com.jd.ad.sdk.jad_qz.jad_dq> {
    public final com.jd.ad.sdk.jad_qz.jad_dq jad_iv;

    public jad_er(List<com.jd.ad.sdk.jad_wf.jad_an<com.jd.ad.sdk.jad_qz.jad_dq>> list) {
        super(list);
        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = list.get(0).jad_bo;
        int jad_an = jad_dqVar != null ? jad_dqVar.jad_an() : 0;
        this.jad_iv = new com.jd.ad.sdk.jad_qz.jad_dq(new float[jad_an], new int[jad_an]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_wf.jad_an jad_anVar, float f) {
        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = this.jad_iv;
        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar2 = (com.jd.ad.sdk.jad_qz.jad_dq) jad_anVar.jad_bo;
        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar3 = (com.jd.ad.sdk.jad_qz.jad_dq) jad_anVar.jad_cp;
        jad_dqVar.getClass();
        if (jad_dqVar2.jad_bo.length == jad_dqVar3.jad_bo.length) {
            for (int i = 0; i < jad_dqVar2.jad_bo.length; i++) {
                jad_dqVar.jad_an[i] = com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_dqVar2.jad_an[i], jad_dqVar3.jad_an[i], f);
                jad_dqVar.jad_bo[i] = com.jd.ad.sdk.jad_ve.jad_bo.jad_an(f, jad_dqVar2.jad_bo[i], jad_dqVar3.jad_bo[i]);
            }
            return this.jad_iv;
        }
        StringBuilder jad_an = jad_zm.jad_an("Cannot interpolate between gradients. Lengths vary (");
        jad_an.append(jad_dqVar2.jad_bo.length);
        jad_an.append(" vs ");
        jad_an.append(jad_dqVar3.jad_bo.length);
        jad_an.append(oIX0oI.I0Io.f4095I0Io);
        throw new IllegalArgumentException(jad_an.toString());
    }
}
