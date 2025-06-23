package com.jd.ad.sdk.jad_mx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_xk;
import com.jd.ad.sdk.jad_mx.jad_hu;

/* loaded from: classes10.dex */
public class jad_jt extends com.jd.ad.sdk.jad_gp.jad_hu<com.jd.ad.sdk.jad_hs.jad_hu, jad_xk<?>> implements jad_hu {
    public jad_hu.jad_an jad_dq;

    public jad_jt(long j) {
        super(j);
    }

    public void jad_an(@NonNull jad_hu.jad_an jad_anVar) {
        this.jad_dq = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_gp.jad_hu
    public int jad_bo(@Nullable jad_xk<?> jad_xkVar) {
        jad_xk<?> jad_xkVar2 = jad_xkVar;
        if (jad_xkVar2 == null) {
            return 1;
        }
        return jad_xkVar2.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_gp.jad_hu
    public void jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, @Nullable jad_xk<?> jad_xkVar) {
        jad_xk<?> jad_xkVar2 = jad_xkVar;
        jad_hu.jad_an jad_anVar = this.jad_dq;
        if (jad_anVar == null || jad_xkVar2 == null) {
            return;
        }
        ((jad_mz) jad_anVar).jad_er.jad_an(jad_xkVar2, true);
    }
}
