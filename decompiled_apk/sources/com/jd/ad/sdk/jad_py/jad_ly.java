package com.jd.ad.sdk.jad_py;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_mv.jad_pc;

/* loaded from: classes10.dex */
public class jad_ly implements com.jd.ad.sdk.jad_qz.jad_cp {

    @Nullable
    public final jad_er jad_an;

    @Nullable
    public final jad_mz<PointF, PointF> jad_bo;

    @Nullable
    public final jad_jt jad_cp;

    @Nullable
    public final jad_bo jad_dq;

    @Nullable
    public final jad_dq jad_er;

    @Nullable
    public final jad_bo jad_fs;

    @Nullable
    public final jad_bo jad_hu;

    @Nullable
    public final jad_bo jad_iv;

    @Nullable
    public final jad_bo jad_jt;

    public jad_ly() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    @Nullable
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return null;
    }

    @Nullable
    public jad_er jad_bo() {
        return this.jad_an;
    }

    @Nullable
    public jad_bo jad_cp() {
        return this.jad_iv;
    }

    @Nullable
    public jad_dq jad_dq() {
        return this.jad_er;
    }

    @Nullable
    public jad_mz<PointF, PointF> jad_er() {
        return this.jad_bo;
    }

    @Nullable
    public jad_bo jad_fs() {
        return this.jad_dq;
    }

    @Nullable
    public jad_bo jad_hu() {
        return this.jad_fs;
    }

    @Nullable
    public jad_bo jad_iv() {
        return this.jad_jt;
    }

    @Nullable
    public jad_jt jad_jt() {
        return this.jad_cp;
    }

    @Nullable
    public jad_bo jad_jw() {
        return this.jad_hu;
    }

    public jad_ly(@Nullable jad_er jad_erVar, @Nullable jad_mz<PointF, PointF> jad_mzVar, @Nullable jad_jt jad_jtVar, @Nullable jad_bo jad_boVar, @Nullable jad_dq jad_dqVar, @Nullable jad_bo jad_boVar2, @Nullable jad_bo jad_boVar3, @Nullable jad_bo jad_boVar4, @Nullable jad_bo jad_boVar5) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_jtVar;
        this.jad_dq = jad_boVar;
        this.jad_er = jad_dqVar;
        this.jad_hu = jad_boVar2;
        this.jad_iv = jad_boVar3;
        this.jad_fs = jad_boVar4;
        this.jad_jt = jad_boVar5;
    }

    public jad_pc jad_an() {
        return new jad_pc(this);
    }
}
