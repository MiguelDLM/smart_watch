package com.jd.ad.sdk.jad_xi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes10.dex */
public final class jad_vi implements jad_mz {
    public final Set<com.jd.ad.sdk.jad_bm.jad_er<?>> jad_an = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_an() {
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) it.next()).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_cp() {
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) it.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_dq() {
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) it.next()).jad_dq();
        }
    }
}
