package com.jd.ad.sdk.jad_lu;

import android.graphics.Path;
import com.jd.ad.sdk.jad_mv.jad_an;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_qd implements jad_mz, jad_an.InterfaceC0697jad_an {
    public final String jad_bo;
    public final boolean jad_cp;
    public final com.jd.ad.sdk.jad_js.jad_mz jad_dq;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Path> jad_er;
    public boolean jad_fs;
    public final Path jad_an = new Path();
    public final jad_bo jad_jt = new jad_bo();

    public jad_qd(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_qd jad_qdVar) {
        this.jad_bo = jad_qdVar.jad_an();
        this.jad_cp = jad_qdVar.jad_cp();
        this.jad_dq = jad_mzVar;
        com.jd.ad.sdk.jad_mv.jad_an<com.jd.ad.sdk.jad_qz.jad_na, Path> jad_an = jad_qdVar.jad_bo().jad_an();
        this.jad_er = jad_an;
        jad_anVar.jad_an(jad_an);
        jad_an.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_fs = false;
        this.jad_dq.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_mz
    public Path jad_bo() {
        if (this.jad_fs) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (!this.jad_cp) {
            Path jad_fs = this.jad_er.jad_fs();
            if (jad_fs == null) {
                return this.jad_an;
            }
            this.jad_an.set(jad_fs);
            this.jad_an.setFillType(Path.FillType.EVEN_ODD);
            this.jad_jt.jad_an(this.jad_an);
        }
        this.jad_fs = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_jt.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
