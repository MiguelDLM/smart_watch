package com.jd.ad.sdk.jad_ra;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_mv.jad_qd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo extends com.jd.ad.sdk.jad_ra.jad_an {

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_do;
    public final List<com.jd.ad.sdk.jad_ra.jad_an> jad_ep;
    public final RectF jad_fq;
    public final RectF jad_gr;
    public final Paint jad_hs;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length];
            jad_an = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public jad_bo(jad_mz jad_mzVar, jad_er jad_erVar, List<jad_er> list, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        super(jad_mzVar, jad_erVar);
        int i;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar;
        this.jad_ep = new ArrayList();
        this.jad_fq = new RectF();
        this.jad_gr = new RectF();
        this.jad_hs = new Paint();
        com.jd.ad.sdk.jad_py.jad_bo jad_kx = jad_erVar.jad_kx();
        if (jad_kx != null) {
            com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an2 = jad_kx.jad_an();
            this.jad_do = jad_an2;
            jad_an(jad_an2);
            this.jad_do.jad_an(this);
        } else {
            this.jad_do = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(jad_jtVar.jad_cp().size());
        int size = list.size() - 1;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            jad_er jad_erVar2 = list.get(size);
            com.jd.ad.sdk.jad_ra.jad_an jad_an3 = com.jd.ad.sdk.jad_ra.jad_an.jad_an(this, jad_erVar2, jad_mzVar, jad_jtVar);
            if (jad_an3 != null) {
                longSparseArray.put(jad_an3.jad_jt().jad_bo(), jad_an3);
                if (jad_anVar2 != null) {
                    jad_anVar2.jad_an(jad_an3);
                    jad_anVar2 = null;
                } else {
                    this.jad_ep.add(0, jad_an3);
                    int i2 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_erVar2.jad_dq())];
                    if (i2 == 1 || i2 == 2) {
                        jad_anVar2 = jad_an3;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            com.jd.ad.sdk.jad_ra.jad_an jad_anVar3 = (com.jd.ad.sdk.jad_ra.jad_an) longSparseArray.get(longSparseArray.keyAt(i));
            if (jad_anVar3 != null && (jad_anVar = (com.jd.ad.sdk.jad_ra.jad_an) longSparseArray.get(jad_anVar3.jad_jt().jad_fs())) != null) {
                jad_anVar3.jad_bo(jad_anVar);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        for (int size = this.jad_ep.size() - 1; size >= 0; size--) {
            this.jad_fq.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.jad_ep.get(size).jad_an(this.jad_fq, this.jad_mz, true);
            rectF.union(this.jad_fq);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        for (int i2 = 0; i2 < this.jad_ep.size(); i2++) {
            this.jad_ep.get(i2).jad_an(jad_erVar, i, list, jad_erVar2);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_cp(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.jad_cp(f);
        if (this.jad_do != null) {
            f = ((this.jad_ob.jad_bo.jad_mz * this.jad_do.jad_fs().floatValue()) - this.jad_ob.jad_bo.jad_kx) / (this.jad_na.jad_bo.jad_bo() + 0.01f);
        }
        if (this.jad_do == null) {
            jad_er jad_erVar = this.jad_ob;
            f -= jad_erVar.jad_na / jad_erVar.jad_bo.jad_bo();
        }
        jad_er jad_erVar2 = this.jad_ob;
        if (jad_erVar2.jad_mz != 0.0f && !"__container".equals(jad_erVar2.jad_cp)) {
            f /= this.jad_ob.jad_mz;
        }
        for (int size = this.jad_ep.size() - 1; size >= 0; size--) {
            this.jad_ep.get(size).jad_cp(f);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == jad_re.jad_gr) {
            if (jad_cpVar == null) {
                com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar = this.jad_do;
                if (jad_anVar != null) {
                    jad_anVar.jad_er = null;
                    return;
                }
                return;
            }
            jad_qd jad_qdVar = new jad_qd(jad_cpVar, null);
            this.jad_do = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            jad_an(this.jad_do);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.jad_gr;
        jad_er jad_erVar = this.jad_ob;
        rectF.set(0.0f, 0.0f, jad_erVar.jad_ob, jad_erVar.jad_pc);
        matrix.mapRect(this.jad_gr);
        boolean z = this.jad_na.jad_sf && this.jad_ep.size() > 1 && i != 255;
        if (z) {
            this.jad_hs.setAlpha(i);
            com.jd.ad.sdk.jad_ve.jad_hu.jad_an(canvas, this.jad_gr, this.jad_hs, 31);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.jad_ep.size() - 1; size >= 0; size--) {
            if (!this.jad_gr.isEmpty() ? canvas.clipRect(this.jad_gr) : true) {
                this.jad_ep.get(size).jad_an(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("CompositionLayer#draw");
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_an(boolean z) {
        if (z && this.jad_yl == null) {
            this.jad_yl = new com.jd.ad.sdk.jad_kt.jad_an();
        }
        this.jad_xk = z;
        Iterator<com.jd.ad.sdk.jad_ra.jad_an> it = this.jad_ep.iterator();
        while (it.hasNext()) {
            it.next().jad_an(z);
        }
    }
}
