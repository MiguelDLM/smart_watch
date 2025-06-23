package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_kv.jad_fs;
import com.jd.ad.sdk.jad_oz.jad_na;

/* loaded from: classes10.dex */
public class jad_do implements jad_dq.jad_an<Object> {
    public final /* synthetic */ jad_na.jad_an jad_an;
    public final /* synthetic */ jad_ep jad_bo;

    public jad_do(jad_ep jad_epVar, jad_na.jad_an jad_anVar) {
        this.jad_bo = jad_epVar;
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
    public void jad_an(@Nullable Object obj) {
        jad_ep jad_epVar = this.jad_bo;
        jad_na.jad_an<?> jad_anVar = this.jad_an;
        jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 == null || jad_anVar2 != jad_anVar) {
            return;
        }
        jad_ep jad_epVar2 = this.jad_bo;
        jad_na.jad_an jad_anVar3 = this.jad_an;
        jad_ly jad_lyVar = jad_epVar2.jad_an.jad_pc;
        if (obj != null && jad_lyVar.jad_an(jad_anVar3.jad_cp.jad_dq())) {
            jad_epVar2.jad_er = obj;
            jad_epVar2.jad_bo.jad_bo();
        } else {
            jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
            com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = jad_anVar3.jad_an;
            com.jd.ad.sdk.jad_it.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
            jad_anVar4.jad_an(jad_huVar, obj, jad_dqVar, jad_dqVar.jad_dq(), jad_epVar2.jad_jt);
        }
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
    public void jad_an(@NonNull Exception exc) {
        jad_ep jad_epVar = this.jad_bo;
        jad_na.jad_an<?> jad_anVar = this.jad_an;
        jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 == null || jad_anVar2 != jad_anVar) {
            return;
        }
        jad_ep jad_epVar2 = this.jad_bo;
        jad_na.jad_an jad_anVar3 = this.jad_an;
        jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
        com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = jad_epVar2.jad_jt;
        com.jd.ad.sdk.jad_it.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
        jad_anVar4.jad_an(jad_huVar, exc, jad_dqVar, jad_dqVar.jad_dq());
    }
}
