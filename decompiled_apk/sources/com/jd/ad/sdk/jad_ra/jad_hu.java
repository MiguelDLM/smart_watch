package com.jd.ad.sdk.jad_ra;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_mv.jad_qd;

/* loaded from: classes10.dex */
public class jad_hu extends jad_an {
    public final RectF jad_do;
    public final Paint jad_ep;
    public final float[] jad_fq;
    public final Path jad_gr;
    public final jad_er jad_hs;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_it;

    public jad_hu(jad_mz jad_mzVar, jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_do = new RectF();
        com.jd.ad.sdk.jad_kt.jad_an jad_anVar = new com.jd.ad.sdk.jad_kt.jad_an();
        this.jad_ep = jad_anVar;
        this.jad_fq = new float[8];
        this.jad_gr = new Path();
        this.jad_hs = jad_erVar;
        jad_anVar.setAlpha(0);
        jad_anVar.setStyle(Paint.Style.FILL);
        jad_anVar.setColor(jad_erVar.jad_hu());
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == jad_re.jad_mx) {
            if (jad_cpVar == null) {
                this.jad_it = null;
            } else {
                this.jad_it = new jad_qd(jad_cpVar, null);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(Canvas canvas, Matrix matrix, int i) {
        int intValue;
        int alpha = Color.alpha(this.jad_hs.jad_ly);
        if (alpha == 0) {
            return;
        }
        com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_anVar = this.jad_vi.jad_jw;
        if (jad_anVar == null) {
            intValue = 100;
        } else {
            intValue = jad_anVar.jad_fs().intValue();
        }
        int i2 = (int) ((((alpha / 255.0f) * intValue) / 100.0f) * (i / 255.0f) * 255.0f);
        this.jad_ep.setAlpha(i2);
        com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar2 = this.jad_it;
        if (jad_anVar2 != null) {
            this.jad_ep.setColorFilter(jad_anVar2.jad_fs());
        }
        if (i2 > 0) {
            float[] fArr = this.jad_fq;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            jad_er jad_erVar = this.jad_hs;
            float f = jad_erVar.jad_jw;
            fArr[2] = f;
            fArr[3] = 0.0f;
            fArr[4] = f;
            float f2 = jad_erVar.jad_kx;
            fArr[5] = f2;
            fArr[6] = 0.0f;
            fArr[7] = f2;
            matrix.mapPoints(fArr);
            this.jad_gr.reset();
            Path path = this.jad_gr;
            float[] fArr2 = this.jad_fq;
            path.moveTo(fArr2[0], fArr2[1]);
            Path path2 = this.jad_gr;
            float[] fArr3 = this.jad_fq;
            path2.lineTo(fArr3[2], fArr3[3]);
            Path path3 = this.jad_gr;
            float[] fArr4 = this.jad_fq;
            path3.lineTo(fArr4[4], fArr4[5]);
            Path path4 = this.jad_gr;
            float[] fArr5 = this.jad_fq;
            path4.lineTo(fArr5[6], fArr5[7]);
            Path path5 = this.jad_gr;
            float[] fArr6 = this.jad_fq;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.jad_gr.close();
            canvas.drawPath(this.jad_gr, this.jad_ep);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        RectF rectF2 = this.jad_do;
        jad_er jad_erVar = this.jad_hs;
        rectF2.set(0.0f, 0.0f, jad_erVar.jad_jw, jad_erVar.jad_kx);
        this.jad_mz.mapRect(this.jad_do);
        rectF.set(this.jad_do);
    }
}
