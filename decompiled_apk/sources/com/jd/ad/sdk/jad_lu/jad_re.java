package com.jd.ad.sdk.jad_lu;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_qz.jad_tg;

/* loaded from: classes10.dex */
public class jad_re extends jad_an {
    public final com.jd.ad.sdk.jad_ra.jad_an jad_re;
    public final String jad_sf;
    public final boolean jad_tg;
    public final com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_uh;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_vi;

    public jad_re(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_re jad_reVar) {
        super(jad_mzVar, jad_anVar, com.jd.ad.sdk.jad_qz.jad_sf.jad_an(jad_reVar.jad_an()), jad_tg.jad_an(jad_reVar.jad_dq()), jad_reVar.jad_fs(), jad_reVar.jad_hu(), jad_reVar.jad_iv(), jad_reVar.jad_er(), jad_reVar.jad_cp());
        this.jad_re = jad_anVar;
        this.jad_sf = jad_reVar.jad_jt();
        this.jad_tg = jad_reVar.jad_jw();
        com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_an = jad_reVar.jad_bo().jad_an();
        this.jad_uh = jad_an;
        jad_an.jad_an(this);
        jad_anVar.jad_an(jad_an);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_lu.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        super.jad_an((jad_re) t, (com.jd.ad.sdk.jad_wf.jad_cp<jad_re>) jad_cpVar);
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_bo) {
            this.jad_uh.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_mx) {
            com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_vi;
            if (jad_anVar != null) {
                this.jad_re.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == 0) {
                this.jad_vi = null;
                return;
            }
            com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_mv.jad_qd(jad_cpVar, null);
            this.jad_vi = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            this.jad_re.jad_an(this.jad_uh);
        }
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_sf;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        if (this.jad_tg) {
            return;
        }
        Paint paint = this.jad_iv;
        com.jd.ad.sdk.jad_mv.jad_bo jad_boVar = (com.jd.ad.sdk.jad_mv.jad_bo) this.jad_uh;
        paint.setColor(jad_boVar.jad_bo(jad_boVar.jad_an(), jad_boVar.jad_cp()));
        com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_vi;
        if (jad_anVar != null) {
            this.jad_iv.setColorFilter(jad_anVar.jad_fs());
        }
        super.jad_an(canvas, matrix, i);
    }
}
