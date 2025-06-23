package com.jd.ad.sdk.jad_ra;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_vi;
import com.jd.ad.sdk.jad_js.jad_zm;
import com.jd.ad.sdk.jad_mv.jad_an;
import com.jd.ad.sdk.jad_mv.jad_pc;
import com.jd.ad.sdk.jad_qz.jad_na;
import com.jd.ad.sdk.jad_tc.jad_jw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class jad_an implements com.jd.ad.sdk.jad_lu.jad_er, jad_an.InterfaceC0697jad_an, com.jd.ad.sdk.jad_ox.jad_fs {

    @Nullable
    public BlurMaskFilter jad_cn;
    public final Paint jad_dq;
    public final Paint jad_er;
    public final Paint jad_fs;
    public final RectF jad_hu;
    public final RectF jad_iv;
    public final Paint jad_jt;
    public final RectF jad_jw;
    public final RectF jad_kx;
    public final String jad_ly;
    public final Matrix jad_mz;
    public final jad_mz jad_na;
    public final jad_er jad_ob;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_hu jad_pc;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_dq jad_qd;

    @Nullable
    public jad_an jad_re;

    @Nullable
    public jad_an jad_sf;
    public List<jad_an> jad_tg;
    public final List<com.jd.ad.sdk.jad_mv.jad_an<?, ?>> jad_uh;
    public final jad_pc jad_vi;
    public boolean jad_wj;
    public boolean jad_xk;

    @Nullable
    public Paint jad_yl;
    public float jad_zm;
    public final Path jad_an = new Path();
    public final Matrix jad_bo = new Matrix();
    public final Paint jad_cp = new com.jd.ad.sdk.jad_kt.jad_an(1);

    public jad_an(jad_mz jad_mzVar, jad_er jad_erVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.jad_dq = new com.jd.ad.sdk.jad_kt.jad_an(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.jad_er = new com.jd.ad.sdk.jad_kt.jad_an(1, mode2);
        com.jd.ad.sdk.jad_kt.jad_an jad_anVar = new com.jd.ad.sdk.jad_kt.jad_an(1);
        this.jad_fs = jad_anVar;
        this.jad_jt = new com.jd.ad.sdk.jad_kt.jad_an(PorterDuff.Mode.CLEAR);
        this.jad_hu = new RectF();
        this.jad_iv = new RectF();
        this.jad_jw = new RectF();
        this.jad_kx = new RectF();
        this.jad_mz = new Matrix();
        this.jad_uh = new ArrayList();
        this.jad_wj = true;
        this.jad_zm = 0.0f;
        this.jad_na = jad_mzVar;
        this.jad_ob = jad_erVar;
        this.jad_ly = jad_erVar.jad_er() + "#draw";
        jad_anVar.setXfermode(jad_erVar.jad_dq() == 3 ? new PorterDuffXfermode(mode2) : new PorterDuffXfermode(mode));
        jad_pc jad_an = jad_erVar.jad_ly().jad_an();
        this.jad_vi = jad_an;
        jad_an.jad_an((jad_an.InterfaceC0697jad_an) this);
        if (jad_erVar.jad_cp() != null && !jad_erVar.jad_cp().isEmpty()) {
            com.jd.ad.sdk.jad_mv.jad_hu jad_huVar = new com.jd.ad.sdk.jad_mv.jad_hu(jad_erVar.jad_cp());
            this.jad_pc = jad_huVar;
            Iterator<com.jd.ad.sdk.jad_mv.jad_an<jad_na, Path>> it = jad_huVar.jad_an().iterator();
            while (it.hasNext()) {
                it.next().jad_an(this);
            }
            for (com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_anVar2 : this.jad_pc.jad_bo()) {
                jad_an(jad_anVar2);
                jad_anVar2.jad_an(this);
            }
        }
        jad_kx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jad_jw() {
        jad_bo(this.jad_qd.jad_hu() == 1.0f);
    }

    public BlurMaskFilter jad_an(float f) {
        if (this.jad_zm == f) {
            return this.jad_cn;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.jad_cn = blurMaskFilter;
        this.jad_zm = f;
        return blurMaskFilter;
    }

    public abstract void jad_bo(Canvas canvas, Matrix matrix, int i);

    public void jad_bo(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_ob.jad_cp;
    }

    public final void jad_dq() {
        if (this.jad_tg != null) {
            return;
        }
        if (this.jad_sf == null) {
            this.jad_tg = Collections.emptyList();
            return;
        }
        this.jad_tg = new ArrayList();
        for (jad_an jad_anVar = this.jad_sf; jad_anVar != null; jad_anVar = jad_anVar.jad_sf) {
            this.jad_tg.add(jad_anVar);
        }
    }

    @Nullable
    public com.jd.ad.sdk.jad_qz.jad_an jad_er() {
        return this.jad_ob.jad_wj;
    }

    @Nullable
    public jad_jw jad_fs() {
        return this.jad_ob.jad_xk;
    }

    public boolean jad_hu() {
        com.jd.ad.sdk.jad_mv.jad_hu jad_huVar = this.jad_pc;
        if (jad_huVar != null && !jad_huVar.jad_an.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean jad_iv() {
        return this.jad_re != null;
    }

    public jad_er jad_jt() {
        return this.jad_ob;
    }

    public final void jad_kx() {
        boolean z = true;
        if (!this.jad_ob.jad_tg.isEmpty()) {
            com.jd.ad.sdk.jad_mv.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_mv.jad_dq(this.jad_ob.jad_tg);
            this.jad_qd = jad_dqVar;
            jad_dqVar.jad_bo = true;
            jad_dqVar.jad_an.add(new jad_an.InterfaceC0697jad_an() { // from class: IoIOOxIIo.oIX0oI
                @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
                public final void jad_an() {
                    com.jd.ad.sdk.jad_ra.jad_an.this.jad_jw();
                }
            });
            if (this.jad_qd.jad_fs().floatValue() != 1.0f) {
                z = false;
            }
            jad_bo(z);
            jad_an(this.jad_qd);
            return;
        }
        jad_bo(true);
    }

    public final void jad_an(Canvas canvas) {
        RectF rectF = this.jad_hu;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.jad_jt);
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("Layer#clearLayer");
    }

    public void jad_bo(@Nullable jad_an jad_anVar) {
        this.jad_sf = jad_anVar;
    }

    public void jad_cp(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        jad_pc jad_pcVar = this.jad_vi;
        com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_anVar = jad_pcVar.jad_jw;
        if (jad_anVar != null) {
            jad_anVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar2 = jad_pcVar.jad_mz;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar3 = jad_pcVar.jad_na;
        if (jad_anVar3 != null) {
            jad_anVar3.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_anVar4 = jad_pcVar.jad_fs;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_anVar5 = jad_pcVar.jad_jt;
        if (jad_anVar5 != null) {
            jad_anVar5.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<com.jd.ad.sdk.jad_wf.jad_dq, com.jd.ad.sdk.jad_wf.jad_dq> jad_anVar6 = jad_pcVar.jad_hu;
        if (jad_anVar6 != null) {
            jad_anVar6.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar7 = jad_pcVar.jad_iv;
        if (jad_anVar7 != null) {
            jad_anVar7.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_dq jad_dqVar = jad_pcVar.jad_kx;
        if (jad_dqVar != null) {
            jad_dqVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_mv.jad_dq jad_dqVar2 = jad_pcVar.jad_ly;
        if (jad_dqVar2 != null) {
            jad_dqVar2.jad_an(f);
        }
        if (this.jad_pc != null) {
            for (int i = 0; i < this.jad_pc.jad_an.size(); i++) {
                this.jad_pc.jad_an.get(i).jad_an(f);
            }
        }
        com.jd.ad.sdk.jad_mv.jad_dq jad_dqVar3 = this.jad_qd;
        if (jad_dqVar3 != null) {
            jad_dqVar3.jad_an(f);
        }
        jad_an jad_anVar8 = this.jad_re;
        if (jad_anVar8 != null) {
            jad_anVar8.jad_cp(f);
        }
        for (int i2 = 0; i2 < this.jad_uh.size(); i2++) {
            this.jad_uh.get(i2).jad_an(f);
        }
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_er
    @CallSuper
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        this.jad_hu.set(0.0f, 0.0f, 0.0f, 0.0f);
        jad_dq();
        this.jad_mz.set(matrix);
        if (z) {
            List<jad_an> list = this.jad_tg;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.jad_mz.preConcat(this.jad_tg.get(size).jad_vi.jad_bo());
                }
            } else {
                jad_an jad_anVar = this.jad_sf;
                if (jad_anVar != null) {
                    this.jad_mz.preConcat(jad_anVar.jad_vi.jad_bo());
                }
            }
        }
        this.jad_mz.preConcat(this.jad_vi.jad_bo());
    }

    public final void jad_bo(float f) {
        jad_vi jad_viVar = this.jad_na.jad_bo.jad_an;
        String str = this.jad_ob.jad_cp;
        if (jad_viVar.jad_an) {
            com.jd.ad.sdk.jad_ve.jad_fs jad_fsVar = jad_viVar.jad_cp.get(str);
            if (jad_fsVar == null) {
                jad_fsVar = new com.jd.ad.sdk.jad_ve.jad_fs();
                jad_viVar.jad_cp.put(str, jad_fsVar);
            }
            float f2 = jad_fsVar.jad_an + f;
            jad_fsVar.jad_an = f2;
            int i = jad_fsVar.jad_bo + 1;
            jad_fsVar.jad_bo = i;
            if (i == Integer.MAX_VALUE) {
                jad_fsVar.jad_an = f2 / 2.0f;
                jad_fsVar.jad_bo = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<jad_vi.jad_an> it = jad_viVar.jad_bo.iterator();
                while (it.hasNext()) {
                    it.next().jad_an(f);
                }
            }
        }
    }

    public void jad_an(@Nullable com.jd.ad.sdk.jad_mv.jad_an<?, ?> jad_anVar) {
        if (jad_anVar == null) {
            return;
        }
        this.jad_uh.add(jad_anVar);
    }

    public void jad_an(@Nullable jad_an jad_anVar) {
        this.jad_re = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    @CallSuper
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<com.jd.ad.sdk.jad_lu.jad_cp> list, List<com.jd.ad.sdk.jad_lu.jad_cp> list2) {
    }

    public void jad_an(boolean z) {
        if (z && this.jad_yl == null) {
            this.jad_yl = new com.jd.ad.sdk.jad_kt.jad_an();
        }
        this.jad_xk = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013a  */
    @Override // com.jd.ad.sdk.jad_lu.jad_er
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void jad_an(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            Method dump skipped, instructions count: 1075
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ra.jad_an.jad_an(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void jad_bo(boolean z) {
        if (z != this.jad_wj) {
            this.jad_wj = z;
            this.jad_na.invalidateSelf();
        }
    }

    @Nullable
    public static jad_an jad_an(jad_bo jad_boVar, jad_er jad_erVar, jad_mz jad_mzVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        int jad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_erVar.jad_er);
        if (jad_an == 0) {
            return new jad_bo(jad_mzVar, jad_erVar, jad_jtVar.jad_cp.get(jad_erVar.jad_jt), jad_jtVar);
        }
        if (jad_an == 1) {
            return new jad_hu(jad_mzVar, jad_erVar);
        }
        if (jad_an == 2) {
            return new jad_cp(jad_mzVar, jad_erVar);
        }
        if (jad_an == 3) {
            return new jad_fs(jad_mzVar, jad_erVar);
        }
        if (jad_an == 4) {
            return new jad_jt(jad_mzVar, jad_erVar, jad_boVar);
        }
        if (jad_an != 5) {
            StringBuilder jad_an2 = jad_zm.jad_an("Unknown layer type ");
            jad_an2.append(jad_dq.jad_an(jad_erVar.jad_er));
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_an2.toString());
            return null;
        }
        return new jad_iv(jad_mzVar, jad_erVar);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_na.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        jad_an jad_anVar = this.jad_re;
        if (jad_anVar != null) {
            com.jd.ad.sdk.jad_ox.jad_er jad_an = jad_erVar2.jad_an(jad_anVar.jad_ob.jad_cp);
            if (jad_erVar.jad_an(this.jad_re.jad_ob.jad_cp, i)) {
                list.add(jad_an.jad_an(this.jad_re));
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                this.jad_re.jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_re.jad_ob.jad_cp, i) + i, list, jad_an);
            }
        }
        if (jad_erVar.jad_cp(this.jad_ob.jad_cp, i)) {
            if (!"__container".equals(this.jad_ob.jad_cp)) {
                jad_erVar2 = jad_erVar2.jad_an(this.jad_ob.jad_cp);
                if (jad_erVar.jad_an(this.jad_ob.jad_cp, i)) {
                    list.add(jad_erVar2.jad_an(this));
                }
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_ob.jad_cp, i) + i, list, jad_erVar2);
            }
        }
    }
}
