package com.jd.ad.sdk.jad_qz;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_zm;

/* loaded from: classes10.dex */
public class jad_ob implements jad_cp {
    public final boolean jad_an;
    public final Path.FillType jad_bo;
    public final String jad_cp;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_an jad_dq;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_dq jad_er;
    public final boolean jad_fs;

    public jad_ob(String str, boolean z, Path.FillType fillType, @Nullable com.jd.ad.sdk.jad_py.jad_an jad_anVar, @Nullable com.jd.ad.sdk.jad_py.jad_dq jad_dqVar, boolean z2) {
        this.jad_cp = str;
        this.jad_an = z;
        this.jad_bo = fillType;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_dqVar;
        this.jad_fs = z2;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_jt(jad_mzVar, jad_anVar, this);
    }

    public Path.FillType jad_bo() {
        return this.jad_bo;
    }

    public String jad_cp() {
        return this.jad_cp;
    }

    @Nullable
    public com.jd.ad.sdk.jad_py.jad_dq jad_dq() {
        return this.jad_er;
    }

    public boolean jad_er() {
        return this.jad_fs;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("ShapeFill{color=, fillEnabled=");
        jad_an.append(this.jad_an);
        jad_an.append('}');
        return jad_an.toString();
    }

    @Nullable
    public com.jd.ad.sdk.jad_py.jad_an jad_an() {
        return this.jad_dq;
    }
}
