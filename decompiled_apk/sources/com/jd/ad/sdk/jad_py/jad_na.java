package com.jd.ad.sdk.jad_py;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class jad_na<V, O> implements jad_mz<V, O> {
    public final List<com.jd.ad.sdk.jad_wf.jad_an<V>> jad_an;

    public jad_na(List<com.jd.ad.sdk.jad_wf.jad_an<V>> list) {
        this.jad_an = list;
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public List<com.jd.ad.sdk.jad_wf.jad_an<V>> jad_bo() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_py.jad_mz
    public boolean jad_cp() {
        if (this.jad_an.isEmpty()) {
            return true;
        }
        return this.jad_an.size() == 1 && this.jad_an.get(0).jad_cp();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.jad_an.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.jad_an.toArray()));
        }
        return sb.toString();
    }
}
