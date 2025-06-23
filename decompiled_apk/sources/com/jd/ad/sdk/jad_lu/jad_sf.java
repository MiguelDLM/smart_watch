package com.jd.ad.sdk.jad_lu;

import com.jd.ad.sdk.jad_mv.jad_an;
import com.jd.ad.sdk.jad_qz.jad_uh;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_sf implements jad_cp, jad_an.InterfaceC0697jad_an {
    public final String jad_an;
    public final boolean jad_bo;
    public final List<jad_an.InterfaceC0697jad_an> jad_cp = new ArrayList();
    public final int jad_dq;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_er;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_fs;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_jt;

    public jad_sf(com.jd.ad.sdk.jad_ra.jad_an jad_anVar, jad_uh jad_uhVar) {
        this.jad_an = jad_uhVar.jad_bo();
        this.jad_bo = jad_uhVar.jad_fs();
        this.jad_dq = jad_uhVar.jad_er();
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an = jad_uhVar.jad_dq().jad_an();
        this.jad_er = jad_an;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an2 = jad_uhVar.jad_an().jad_an();
        this.jad_fs = jad_an2;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an3 = jad_uhVar.jad_cp().jad_an();
        this.jad_jt = jad_an3;
        jad_anVar.jad_an(jad_an);
        jad_anVar.jad_an(jad_an2);
        jad_anVar.jad_an(jad_an3);
        jad_an.jad_an(this);
        jad_an2.jad_an(this);
        jad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        for (int i = 0; i < this.jad_cp.size(); i++) {
            this.jad_cp.get(i).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
    }
}
