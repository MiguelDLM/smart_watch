package com.jd.ad.sdk.jad_xi;

import com.jd.ad.sdk.jad_xi.jad_sf;

/* loaded from: classes10.dex */
public class jad_tg implements Runnable {
    public final /* synthetic */ boolean jad_an;
    public final /* synthetic */ jad_sf.jad_dq.jad_an jad_bo;

    public jad_tg(jad_sf.jad_dq.jad_an jad_anVar, boolean z) {
        this.jad_bo = jad_anVar;
        this.jad_an = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        jad_sf.jad_dq.jad_an jad_anVar = this.jad_bo;
        boolean z = this.jad_an;
        jad_anVar.getClass();
        com.jd.ad.sdk.jad_gp.jad_ly.jad_an();
        jad_sf.jad_dq jad_dqVar = jad_sf.jad_dq.this;
        boolean z2 = jad_dqVar.jad_an;
        jad_dqVar.jad_an = z;
        if (z2 != z) {
            jad_dqVar.jad_bo.jad_an(z);
        }
    }
}
