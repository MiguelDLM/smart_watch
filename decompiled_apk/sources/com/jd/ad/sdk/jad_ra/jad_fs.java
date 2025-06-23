package com.jd.ad.sdk.jad_ra;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.jd.ad.sdk.jad_js.jad_mz;

/* loaded from: classes10.dex */
public class jad_fs extends jad_an {
    public jad_fs(jad_mz jad_mzVar, jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(Canvas canvas, Matrix matrix, int i) {
    }
}
