package com.jd.ad.sdk.jad_qz;

import android.graphics.Paint;
import com.jd.ad.sdk.jad_qz.jad_re;

/* loaded from: classes10.dex */
public final /* synthetic */ class jad_tg {
    public static Paint.Join jad_an(int i) {
        int[] iArr = jad_re.jad_an.jad_bo;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            return Paint.Join.BEVEL;
        }
        if (i2 == 2) {
            return Paint.Join.MITER;
        }
        if (i2 != 3) {
            return null;
        }
        return Paint.Join.ROUND;
    }
}
