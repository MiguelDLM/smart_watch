package com.jd.ad.sdk.jad_qz;

import android.graphics.PointF;

/* loaded from: classes10.dex */
public class jad_kx implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_cp;
    public final com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_dq;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_er;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_fs;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_hu;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_iv;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_jt;
    public final boolean jad_jw;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_py/jad_bo;Lcom/jd/ad/sdk/jad_py/jad_mz<Landroid/graphics/PointF;Landroid/graphics/PointF;>;Lcom/jd/ad/sdk/jad_py/jad_bo;Lcom/jd/ad/sdk/jad_py/jad_bo;Lcom/jd/ad/sdk/jad_py/jad_bo;Lcom/jd/ad/sdk/jad_py/jad_bo;Lcom/jd/ad/sdk/jad_py/jad_bo;Z)V */
    public jad_kx(String str, int i, com.jd.ad.sdk.jad_py.jad_bo jad_boVar, com.jd.ad.sdk.jad_py.jad_mz jad_mzVar, com.jd.ad.sdk.jad_py.jad_bo jad_boVar2, com.jd.ad.sdk.jad_py.jad_bo jad_boVar3, com.jd.ad.sdk.jad_py.jad_bo jad_boVar4, com.jd.ad.sdk.jad_py.jad_bo jad_boVar5, com.jd.ad.sdk.jad_py.jad_bo jad_boVar6, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = jad_boVar;
        this.jad_dq = jad_mzVar;
        this.jad_er = jad_boVar2;
        this.jad_fs = jad_boVar3;
        this.jad_jt = jad_boVar4;
        this.jad_hu = jad_boVar5;
        this.jad_iv = jad_boVar6;
        this.jad_jw = z;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_na(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_bo() {
        return this.jad_hu;
    }

    public String jad_cp() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_dq() {
        return this.jad_jt;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_er() {
        return this.jad_iv;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_fs() {
        return this.jad_cp;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_hu() {
        return this.jad_er;
    }

    public int jad_iv() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_jt() {
        return this.jad_dq;
    }

    public boolean jad_jw() {
        return this.jad_jw;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_an() {
        return this.jad_fs;
    }
}
