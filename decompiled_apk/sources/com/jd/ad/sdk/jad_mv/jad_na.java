package com.jd.ad.sdk.jad_mv;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* loaded from: classes10.dex */
public class jad_na extends jad_an<PointF, PointF> {
    public final PointF jad_iv;
    public final PointF jad_jw;
    public final jad_an<Float, Float> jad_kx;
    public final jad_an<Float, Float> jad_ly;

    @Nullable
    public com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_mz;

    @Nullable
    public com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_na;

    public jad_na(jad_an<Float, Float> jad_anVar, jad_an<Float, Float> jad_anVar2) {
        super(Collections.emptyList());
        this.jad_iv = new PointF();
        this.jad_jw = new PointF();
        this.jad_kx = jad_anVar;
        this.jad_ly = jad_anVar2;
        jad_an(jad_er());
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    /* renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public PointF jad_an(com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_anVar, float f) {
        Float f2;
        com.jd.ad.sdk.jad_wf.jad_an<Float> jad_an;
        com.jd.ad.sdk.jad_wf.jad_an<Float> jad_an2;
        Float f3 = null;
        if (this.jad_mz == null || (jad_an2 = this.jad_kx.jad_an()) == null) {
            f2 = null;
        } else {
            float jad_cp = this.jad_kx.jad_cp();
            Float f4 = jad_an2.jad_hu;
            com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_cpVar = this.jad_mz;
            float f5 = jad_an2.jad_jt;
            f2 = jad_cpVar.jad_an(f5, f4 == null ? f5 : f4.floatValue(), jad_an2.jad_bo, jad_an2.jad_cp, f, f, jad_cp);
        }
        if (this.jad_na != null && (jad_an = this.jad_ly.jad_an()) != null) {
            float jad_cp2 = this.jad_ly.jad_cp();
            Float f6 = jad_an.jad_hu;
            com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_cpVar2 = this.jad_na;
            float f7 = jad_an.jad_jt;
            f3 = jad_cpVar2.jad_an(f7, f6 == null ? f7 : f6.floatValue(), jad_an.jad_bo, jad_an.jad_cp, f, f, jad_cp2);
        }
        if (f2 == null) {
            this.jad_jw.set(this.jad_iv.x, 0.0f);
        } else {
            this.jad_jw.set(f2.floatValue(), 0.0f);
        }
        PointF pointF = this.jad_jw;
        pointF.set(pointF.x, f3 == null ? this.jad_iv.y : f3.floatValue());
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public PointF jad_fs() {
        return jad_an(null, 0.0f);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public void jad_an(float f) {
        this.jad_kx.jad_an(f);
        this.jad_ly.jad_an(f);
        this.jad_iv.set(this.jad_kx.jad_fs().floatValue(), this.jad_ly.jad_fs().floatValue());
        for (int i = 0; i < this.jad_an.size(); i++) {
            this.jad_an.get(i).jad_an();
        }
    }
}
