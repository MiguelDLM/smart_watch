package com.jd.ad.sdk.jad_qz;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_fs implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_cp jad_cp;
    public final com.jd.ad.sdk.jad_py.jad_dq jad_dq;
    public final com.jd.ad.sdk.jad_py.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_py.jad_fs jad_fs;
    public final int jad_hu;
    public final int jad_iv;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_jt;
    public final float jad_jw;
    public final List<com.jd.ad.sdk.jad_py.jad_bo> jad_kx;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_bo jad_ly;
    public final boolean jad_mz;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_py/jad_cp;Lcom/jd/ad/sdk/jad_py/jad_dq;Lcom/jd/ad/sdk/jad_py/jad_fs;Lcom/jd/ad/sdk/jad_py/jad_fs;Lcom/jd/ad/sdk/jad_py/jad_bo;Ljava/lang/Object;Ljava/lang/Object;FLjava/util/List<Lcom/jd/ad/sdk/jad_py/jad_bo;>;Lcom/jd/ad/sdk/jad_py/jad_bo;Z)V */
    public jad_fs(String str, int i, com.jd.ad.sdk.jad_py.jad_cp jad_cpVar, com.jd.ad.sdk.jad_py.jad_dq jad_dqVar, com.jd.ad.sdk.jad_py.jad_fs jad_fsVar, com.jd.ad.sdk.jad_py.jad_fs jad_fsVar2, com.jd.ad.sdk.jad_py.jad_bo jad_boVar, int i2, int i3, float f, List list, @Nullable com.jd.ad.sdk.jad_py.jad_bo jad_boVar2, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = jad_cpVar;
        this.jad_dq = jad_dqVar;
        this.jad_er = jad_fsVar;
        this.jad_fs = jad_fsVar2;
        this.jad_jt = jad_boVar;
        this.jad_hu = i2;
        this.jad_iv = i3;
        this.jad_jw = f;
        this.jad_kx = list;
        this.jad_ly = jad_boVar2;
        this.jad_mz = z;
    }

    public int jad_an() {
        return this.jad_hu;
    }

    @Nullable
    public com.jd.ad.sdk.jad_py.jad_bo jad_bo() {
        return this.jad_ly;
    }

    public com.jd.ad.sdk.jad_py.jad_fs jad_cp() {
        return this.jad_fs;
    }

    public com.jd.ad.sdk.jad_py.jad_cp jad_dq() {
        return this.jad_cp;
    }

    public int jad_er() {
        return this.jad_bo;
    }

    public int jad_fs() {
        return this.jad_iv;
    }

    public float jad_hu() {
        return this.jad_jw;
    }

    public String jad_iv() {
        return this.jad_an;
    }

    public List<com.jd.ad.sdk.jad_py.jad_bo> jad_jt() {
        return this.jad_kx;
    }

    public com.jd.ad.sdk.jad_py.jad_dq jad_jw() {
        return this.jad_dq;
    }

    public com.jd.ad.sdk.jad_py.jad_fs jad_kx() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_ly() {
        return this.jad_jt;
    }

    public boolean jad_mz() {
        return this.jad_mz;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_iv(jad_mzVar, jad_anVar, this);
    }
}
