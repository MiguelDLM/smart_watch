package com.jd.ad.sdk.jad_ra;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_mv.jad_ob;
import com.jd.ad.sdk.jad_mv.jad_qd;
import com.jd.ad.sdk.jad_py.jad_kx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_iv extends com.jd.ad.sdk.jad_ra.jad_an {
    public final StringBuilder jad_do;
    public final RectF jad_ep;
    public final Matrix jad_fq;
    public final Paint jad_gr;
    public final Paint jad_hs;
    public final Map<com.jd.ad.sdk.jad_ox.jad_dq, List<com.jd.ad.sdk.jad_lu.jad_dq>> jad_it;
    public final LongSparseArray<String> jad_ju;
    public final jad_ob jad_kv;
    public final jad_mz jad_lw;
    public final com.jd.ad.sdk.jad_js.jad_jt jad_mx;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_ny;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_oz;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_pa;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_qb;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_rc;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_sd;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_te;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_uf;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_vg;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Typeface, Typeface> jad_wh;

    /* loaded from: classes10.dex */
    public class jad_an extends Paint {
        public jad_an(jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo extends Paint {
        public jad_bo(jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_cp {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public jad_iv(jad_mz jad_mzVar, jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_py.jad_an jad_anVar;
        com.jd.ad.sdk.jad_py.jad_an jad_anVar2;
        this.jad_do = new StringBuilder(2);
        this.jad_ep = new RectF();
        this.jad_fq = new Matrix();
        this.jad_gr = new jad_an(this, 1);
        this.jad_hs = new jad_bo(this, 1);
        this.jad_it = new HashMap();
        this.jad_ju = new LongSparseArray<>();
        this.jad_lw = jad_mzVar;
        this.jad_mx = jad_erVar.jad_an();
        jad_ob jad_dq = jad_erVar.jad_iv().jad_dq();
        this.jad_kv = jad_dq;
        jad_dq.jad_an(this);
        jad_an(jad_dq);
        jad_kx jad_jw = jad_erVar.jad_jw();
        if (jad_jw != null && (jad_anVar2 = jad_jw.jad_an) != null) {
            com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_an2 = jad_anVar2.jad_an();
            this.jad_ny = jad_an2;
            jad_an2.jad_an(this);
            jad_an(this.jad_ny);
        }
        if (jad_jw != null && (jad_anVar = jad_jw.jad_bo) != null) {
            com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_an3 = jad_anVar.jad_an();
            this.jad_pa = jad_an3;
            jad_an3.jad_an(this);
            jad_an(this.jad_pa);
        }
        if (jad_jw != null && (jad_boVar2 = jad_jw.jad_cp) != null) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an4 = jad_boVar2.jad_an();
            this.jad_rc = jad_an4;
            jad_an4.jad_an(this);
            jad_an(this.jad_rc);
        }
        if (jad_jw == null || (jad_boVar = jad_jw.jad_dq) == null) {
            return;
        }
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an5 = jad_boVar.jad_an();
        this.jad_te = jad_an5;
        jad_an5.jad_an(this);
        jad_an(this.jad_te);
    }

    public final void jad_an(int i, Canvas canvas, float f) {
        float f2;
        int[] iArr = jad_cp.jad_an;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        if (i2 == 2) {
            f2 = -f;
        } else if (i2 != 3) {
            return;
        } else {
            f2 = (-f) / 2.0f;
        }
        canvas.translate(f2, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0488  */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.jd.ad.sdk.jad_ra.jad_an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void jad_bo(android.graphics.Canvas r21, android.graphics.Matrix r22, int r23) {
        /*
            Method dump skipped, instructions count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ra.jad_iv.jad_bo(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void jad_an(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void jad_an(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == jad_re.jad_an) {
            com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_anVar = this.jad_oz;
            if (jad_anVar != null) {
                this.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == null) {
                this.jad_oz = null;
                return;
            }
            jad_qd jad_qdVar = new jad_qd(jad_cpVar, null);
            this.jad_oz = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            jad_an(this.jad_oz);
            return;
        }
        if (t == jad_re.jad_bo) {
            com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_anVar2 = this.jad_qb;
            if (jad_anVar2 != null) {
                this.jad_uh.remove(jad_anVar2);
            }
            if (jad_cpVar == null) {
                this.jad_qb = null;
                return;
            }
            jad_qd jad_qdVar2 = new jad_qd(jad_cpVar, null);
            this.jad_qb = jad_qdVar2;
            jad_qdVar2.jad_an.add(this);
            jad_an(this.jad_qb);
            return;
        }
        if (t == jad_re.jad_sf) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar3 = this.jad_sd;
            if (jad_anVar3 != null) {
                this.jad_uh.remove(jad_anVar3);
            }
            if (jad_cpVar == null) {
                this.jad_sd = null;
                return;
            }
            jad_qd jad_qdVar3 = new jad_qd(jad_cpVar, null);
            this.jad_sd = jad_qdVar3;
            jad_qdVar3.jad_an.add(this);
            jad_an(this.jad_sd);
            return;
        }
        if (t == jad_re.jad_tg) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar4 = this.jad_uf;
            if (jad_anVar4 != null) {
                this.jad_uh.remove(jad_anVar4);
            }
            if (jad_cpVar == null) {
                this.jad_uf = null;
                return;
            }
            jad_qd jad_qdVar4 = new jad_qd(jad_cpVar, null);
            this.jad_uf = jad_qdVar4;
            jad_qdVar4.jad_an.add(this);
            jad_an(this.jad_uf);
            return;
        }
        if (t == jad_re.jad_hs) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar5 = this.jad_vg;
            if (jad_anVar5 != null) {
                this.jad_uh.remove(jad_anVar5);
            }
            if (jad_cpVar == null) {
                this.jad_vg = null;
                return;
            }
            jad_qd jad_qdVar5 = new jad_qd(jad_cpVar, null);
            this.jad_vg = jad_qdVar5;
            jad_qdVar5.jad_an.add(this);
            jad_an(this.jad_vg);
            return;
        }
        if (t == jad_re.jad_oz) {
            com.jd.ad.sdk.jad_mv.jad_an<Typeface, Typeface> jad_anVar6 = this.jad_wh;
            if (jad_anVar6 != null) {
                this.jad_uh.remove(jad_anVar6);
            }
            if (jad_cpVar == null) {
                this.jad_wh = null;
                return;
            }
            jad_qd jad_qdVar6 = new jad_qd(jad_cpVar, null);
            this.jad_wh = jad_qdVar6;
            jad_qdVar6.jad_an.add(this);
            jad_an(this.jad_wh);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.jad_mx.jad_jw.width(), this.jad_mx.jad_jw.height());
    }
}
