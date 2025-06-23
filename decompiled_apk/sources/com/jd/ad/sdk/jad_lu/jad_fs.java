package com.jd.ad.sdk.jad_lu;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_mv.jad_an;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_fs implements jad_mz, jad_an.InterfaceC0697jad_an, jad_kx {
    public final String jad_bo;
    public final com.jd.ad.sdk.jad_js.jad_mz jad_cp;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_dq;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_er;
    public final com.jd.ad.sdk.jad_qz.jad_bo jad_fs;
    public boolean jad_hu;
    public final Path jad_an = new Path();
    public final jad_bo jad_jt = new jad_bo();

    public jad_fs(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_bo jad_boVar) {
        this.jad_bo = jad_boVar.jad_an();
        this.jad_cp = jad_mzVar;
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an = jad_boVar.jad_cp().jad_an();
        this.jad_dq = jad_an;
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an2 = jad_boVar.jad_bo().jad_an();
        this.jad_er = jad_an2;
        this.jad_fs = jad_boVar;
        jad_anVar.jad_an(jad_an);
        jad_anVar.jad_an(jad_an2);
        jad_an.jad_an(this);
        jad_an2.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_mz
    public Path jad_bo() {
        if (this.jad_hu) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (this.jad_fs.jad_er) {
            this.jad_hu = true;
            return this.jad_an;
        }
        PointF jad_fs = this.jad_dq.jad_fs();
        float f = jad_fs.x / 2.0f;
        float f2 = jad_fs.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.jad_an.reset();
        if (this.jad_fs.jad_dq) {
            float f5 = -f2;
            this.jad_an.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.jad_an.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.jad_an.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.jad_an.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.jad_an.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.jad_an.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.jad_an.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.jad_an.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.jad_an.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.jad_an.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF jad_fs2 = this.jad_er.jad_fs();
        this.jad_an.offset(jad_fs2.x, jad_fs2.y);
        this.jad_an.close();
        this.jad_jt.jad_an(this.jad_an);
        this.jad_hu = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_bo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_anVar;
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_kx) {
            jad_anVar = this.jad_dq;
        } else if (t != com.jd.ad.sdk.jad_js.jad_re.jad_na) {
            return;
        } else {
            jad_anVar = this.jad_er;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_hu = false;
        this.jad_cp.invalidateSelf();
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
