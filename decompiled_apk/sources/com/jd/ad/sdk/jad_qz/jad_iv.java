package com.jd.ad.sdk.jad_qz;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_zm;

/* loaded from: classes10.dex */
public class jad_iv implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final boolean jad_cp;

    public jad_iv(String str, int i, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = z;
    }

    public String jad_an() {
        return this.jad_an;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("MergePaths{mode=");
        jad_an.append(jad_hu.jad_an(this.jad_bo));
        jad_an.append('}');
        return jad_an.toString();
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    @Nullable
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        if (jad_mzVar.jad_na) {
            return new com.jd.ad.sdk.jad_lu.jad_ly(this);
        }
        com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Animation contains merge paths but they are disabled.");
        return null;
    }
}
