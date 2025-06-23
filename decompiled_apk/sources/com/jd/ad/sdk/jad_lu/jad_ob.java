package com.jd.ad.sdk.jad_lu;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_mv.jad_an;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_ob implements jad_an.InterfaceC0697jad_an, jad_kx, jad_mz {
    public final String jad_cp;
    public final boolean jad_dq;
    public final com.jd.ad.sdk.jad_js.jad_mz jad_er;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_fs;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_hu;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_jt;
    public boolean jad_jw;
    public final Path jad_an = new Path();
    public final RectF jad_bo = new RectF();
    public final jad_bo jad_iv = new jad_bo();

    public jad_ob(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_ly jad_lyVar) {
        this.jad_cp = jad_lyVar.jad_bo();
        this.jad_dq = jad_lyVar.jad_er();
        this.jad_er = jad_mzVar;
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an = jad_lyVar.jad_cp().jad_an();
        this.jad_fs = jad_an;
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an2 = jad_lyVar.jad_dq().jad_an();
        this.jad_jt = jad_an2;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an3 = jad_lyVar.jad_an().jad_an();
        this.jad_hu = jad_an3;
        jad_anVar.jad_an(jad_an);
        jad_anVar.jad_an(jad_an2);
        jad_anVar.jad_an(jad_an3);
        jad_an.jad_an(this);
        jad_an2.jad_an(this);
        jad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_mz
    public Path jad_bo() {
        if (this.jad_jw) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (!this.jad_dq) {
            PointF jad_fs = this.jad_jt.jad_fs();
            float f = jad_fs.x / 2.0f;
            float f2 = jad_fs.y / 2.0f;
            com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar = this.jad_hu;
            float jad_hu = jad_anVar == null ? 0.0f : ((com.jd.ad.sdk.jad_mv.jad_dq) jad_anVar).jad_hu();
            float min = Math.min(f, f2);
            if (jad_hu > min) {
                jad_hu = min;
            }
            PointF jad_fs2 = this.jad_fs.jad_fs();
            this.jad_an.moveTo(jad_fs2.x + f, (jad_fs2.y - f2) + jad_hu);
            this.jad_an.lineTo(jad_fs2.x + f, (jad_fs2.y + f2) - jad_hu);
            if (jad_hu > 0.0f) {
                RectF rectF = this.jad_bo;
                float f3 = jad_fs2.x + f;
                float f4 = jad_hu * 2.0f;
                float f5 = jad_fs2.y + f2;
                rectF.set(f3 - f4, f5 - f4, f3, f5);
                this.jad_an.arcTo(this.jad_bo, 0.0f, 90.0f, false);
            }
            this.jad_an.lineTo((jad_fs2.x - f) + jad_hu, jad_fs2.y + f2);
            if (jad_hu > 0.0f) {
                RectF rectF2 = this.jad_bo;
                float f6 = jad_fs2.x - f;
                float f7 = jad_fs2.y + f2;
                float f8 = jad_hu * 2.0f;
                rectF2.set(f6, f7 - f8, f8 + f6, f7);
                this.jad_an.arcTo(this.jad_bo, 90.0f, 90.0f, false);
            }
            this.jad_an.lineTo(jad_fs2.x - f, (jad_fs2.y - f2) + jad_hu);
            if (jad_hu > 0.0f) {
                RectF rectF3 = this.jad_bo;
                float f9 = jad_fs2.x - f;
                float f10 = jad_fs2.y - f2;
                float f11 = jad_hu * 2.0f;
                rectF3.set(f9, f10, f9 + f11, f11 + f10);
                this.jad_an.arcTo(this.jad_bo, 180.0f, 90.0f, false);
            }
            this.jad_an.lineTo((jad_fs2.x + f) - jad_hu, jad_fs2.y - f2);
            if (jad_hu > 0.0f) {
                RectF rectF4 = this.jad_bo;
                float f12 = jad_fs2.x + f;
                float f13 = jad_hu * 2.0f;
                float f14 = jad_fs2.y - f2;
                rectF4.set(f12 - f13, f14, f12, f13 + f14);
                this.jad_an.arcTo(this.jad_bo, 270.0f, 90.0f, false);
            }
            this.jad_an.close();
            this.jad_iv.jad_an(this.jad_an);
        }
        this.jad_jw = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_cp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar;
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_ly) {
            jad_anVar = this.jad_jt;
        } else if (t == com.jd.ad.sdk.jad_js.jad_re.jad_na) {
            jad_anVar = this.jad_fs;
        } else if (t != com.jd.ad.sdk.jad_js.jad_re.jad_mz) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_jw = false;
        this.jad_er.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_iv.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
