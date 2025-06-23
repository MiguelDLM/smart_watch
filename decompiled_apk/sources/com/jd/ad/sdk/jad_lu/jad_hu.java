package com.jd.ad.sdk.jad_lu;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.jd.ad.sdk.jad_mv.jad_an;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_hu implements jad_er, jad_an.InterfaceC0697jad_an, jad_kx {

    @NonNull
    public final String jad_an;
    public final boolean jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_an jad_cp;
    public final LongSparseArray<LinearGradient> jad_dq = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> jad_er = new LongSparseArray<>();
    public final Path jad_fs;
    public final RectF jad_hu;
    public final List<jad_mz> jad_iv;
    public final Paint jad_jt;
    public final int jad_jw;
    public final com.jd.ad.sdk.jad_mv.jad_an<com.jd.ad.sdk.jad_qz.jad_dq, com.jd.ad.sdk.jad_qz.jad_dq> jad_kx;
    public final com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_ly;
    public final com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_mz;
    public final com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_na;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_ob;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_qd jad_pc;
    public final com.jd.ad.sdk.jad_js.jad_mz jad_qd;
    public final int jad_re;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_sf;
    public float jad_tg;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_cp jad_uh;

    public jad_hu(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_er jad_erVar) {
        Path path = new Path();
        this.jad_fs = path;
        this.jad_jt = new com.jd.ad.sdk.jad_kt.jad_an(1);
        this.jad_hu = new RectF();
        this.jad_iv = new ArrayList();
        this.jad_tg = 0.0f;
        this.jad_cp = jad_anVar;
        this.jad_an = jad_erVar.jad_er();
        this.jad_bo = jad_erVar.jad_hu();
        this.jad_qd = jad_mzVar;
        this.jad_jw = jad_erVar.jad_dq();
        path.setFillType(jad_erVar.jad_bo());
        this.jad_re = (int) (jad_mzVar.jad_dq().jad_an() / 32.0f);
        com.jd.ad.sdk.jad_mv.jad_an<com.jd.ad.sdk.jad_qz.jad_dq, com.jd.ad.sdk.jad_qz.jad_dq> jad_an = jad_erVar.jad_cp().jad_an();
        this.jad_kx = jad_an;
        jad_an.jad_an(this);
        jad_anVar.jad_an(jad_an);
        com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_an2 = jad_erVar.jad_fs().jad_an();
        this.jad_ly = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an3 = jad_erVar.jad_jt().jad_an();
        this.jad_mz = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an4 = jad_erVar.jad_an().jad_an();
        this.jad_na = jad_an4;
        jad_an4.jad_an(this);
        jad_anVar.jad_an(jad_an4);
        if (jad_anVar.jad_er() != null) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an5 = jad_anVar.jad_er().jad_an().jad_an();
            this.jad_sf = jad_an5;
            jad_an5.jad_an(this);
            jad_anVar.jad_an(this.jad_sf);
        }
        if (jad_anVar.jad_fs() != null) {
            this.jad_uh = new com.jd.ad.sdk.jad_mv.jad_cp(this, jad_anVar, jad_anVar.jad_fs());
        }
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_qd.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_an;
    }

    public final int jad_dq() {
        int i;
        int round = Math.round(this.jad_mz.jad_dq * this.jad_re);
        int round2 = Math.round(this.jad_na.jad_dq * this.jad_re);
        int round3 = Math.round(this.jad_kx.jad_dq * this.jad_re);
        if (round != 0) {
            i = round * 527;
        } else {
            i = 17;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        this.jad_fs.reset();
        for (int i = 0; i < this.jad_iv.size(); i++) {
            this.jad_fs.addPath(this.jad_iv.get(i).jad_bo(), matrix);
        }
        this.jad_fs.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i = 0; i < list2.size(); i++) {
            jad_cp jad_cpVar = list2.get(i);
            if (jad_cpVar instanceof jad_mz) {
                this.jad_iv.add((jad_mz) jad_cpVar);
            }
        }
    }

    public final int[] jad_an(int[] iArr) {
        com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar = this.jad_pc;
        if (jad_qdVar != null) {
            Integer[] numArr = (Integer[]) jad_qdVar.jad_fs();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar2;
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar3;
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar4;
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar5;
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar6;
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_dq) {
            this.jad_ly.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_mx) {
            com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_ob;
            if (jad_anVar != null) {
                this.jad_cp.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == 0) {
                this.jad_ob = null;
                return;
            }
            com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_mv.jad_qd(jad_cpVar, null);
            this.jad_ob = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_ob);
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_ny) {
            com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar2 = this.jad_pc;
            if (jad_qdVar2 != null) {
                this.jad_cp.jad_uh.remove(jad_qdVar2);
            }
            if (jad_cpVar == 0) {
                this.jad_pc = null;
                return;
            }
            this.jad_dq.clear();
            this.jad_er.clear();
            com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar3 = new com.jd.ad.sdk.jad_mv.jad_qd(jad_cpVar, null);
            this.jad_pc = jad_qdVar3;
            jad_qdVar3.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_pc);
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_jw) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar2 = this.jad_sf;
            if (jad_anVar2 != null) {
                jad_anVar2.jad_er = jad_cpVar;
                return;
            }
            com.jd.ad.sdk.jad_mv.jad_qd jad_qdVar4 = new com.jd.ad.sdk.jad_mv.jad_qd(jad_cpVar, null);
            this.jad_sf = jad_qdVar4;
            jad_qdVar4.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_sf);
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_er && (jad_cpVar6 = this.jad_uh) != null) {
            jad_cpVar6.jad_bo.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_it && (jad_cpVar5 = this.jad_uh) != null) {
            jad_cpVar5.jad_an((com.jd.ad.sdk.jad_wf.jad_cp<Float>) jad_cpVar);
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_ju && (jad_cpVar4 = this.jad_uh) != null) {
            jad_cpVar4.jad_dq.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_js.jad_re.jad_kv && (jad_cpVar3 = this.jad_uh) != null) {
            jad_cpVar3.jad_er.jad_er = jad_cpVar;
        } else {
            if (t != com.jd.ad.sdk.jad_js.jad_re.jad_lw || (jad_cpVar2 = this.jad_uh) == null) {
                return;
            }
            jad_cpVar2.jad_fs.jad_er = jad_cpVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.jad_bo) {
            return;
        }
        this.jad_fs.reset();
        for (int i2 = 0; i2 < this.jad_iv.size(); i2++) {
            this.jad_fs.addPath(this.jad_iv.get(i2).jad_bo(), matrix);
        }
        this.jad_fs.computeBounds(this.jad_hu, false);
        if (this.jad_jw == 1) {
            long jad_dq = jad_dq();
            radialGradient = this.jad_dq.get(jad_dq);
            if (radialGradient == null) {
                PointF jad_fs = this.jad_mz.jad_fs();
                PointF jad_fs2 = this.jad_na.jad_fs();
                com.jd.ad.sdk.jad_qz.jad_dq jad_fs3 = this.jad_kx.jad_fs();
                LinearGradient linearGradient = new LinearGradient(jad_fs.x, jad_fs.y, jad_fs2.x, jad_fs2.y, jad_an(jad_fs3.jad_bo), jad_fs3.jad_an, Shader.TileMode.CLAMP);
                this.jad_dq.put(jad_dq, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jad_dq2 = jad_dq();
            radialGradient = this.jad_er.get(jad_dq2);
            if (radialGradient == null) {
                PointF jad_fs4 = this.jad_mz.jad_fs();
                PointF jad_fs5 = this.jad_na.jad_fs();
                com.jd.ad.sdk.jad_qz.jad_dq jad_fs6 = this.jad_kx.jad_fs();
                int[] jad_an = jad_an(jad_fs6.jad_bo);
                float[] fArr = jad_fs6.jad_an;
                float f = jad_fs4.x;
                float f2 = jad_fs4.y;
                float hypot = (float) Math.hypot(jad_fs5.x - f, jad_fs5.y - f2);
                radialGradient = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, jad_an, fArr, Shader.TileMode.CLAMP);
                this.jad_er.put(jad_dq2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.jad_jt.setShader(radialGradient);
        com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_ob;
        if (jad_anVar != null) {
            this.jad_jt.setColorFilter(jad_anVar.jad_fs());
        }
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar2 = this.jad_sf;
        if (jad_anVar2 != null) {
            float floatValue = jad_anVar2.jad_fs().floatValue();
            if (floatValue == 0.0f) {
                this.jad_jt.setMaskFilter(null);
            } else if (floatValue != this.jad_tg) {
                this.jad_jt.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.jad_tg = floatValue;
        }
        com.jd.ad.sdk.jad_mv.jad_cp jad_cpVar = this.jad_uh;
        if (jad_cpVar != null) {
            jad_cpVar.jad_an(this.jad_jt);
        }
        Paint paint = this.jad_jt;
        PointF pointF = com.jd.ad.sdk.jad_ve.jad_jt.jad_an;
        paint.setAlpha(Math.max(0, Math.min(255, (int) ((((i / 255.0f) * this.jad_ly.jad_fs().intValue()) / 100.0f) * 255.0f))));
        canvas.drawPath(this.jad_fs, this.jad_jt);
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("GradientFillContent#draw");
    }
}
