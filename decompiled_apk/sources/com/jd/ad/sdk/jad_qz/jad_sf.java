package com.jd.ad.sdk.jad_qz;

import android.graphics.Paint;
import com.jd.ad.sdk.jad_qz.jad_re;

/* loaded from: classes10.dex */
public final /* synthetic */ class jad_sf {
    public static Paint.Cap jad_an(int i) {
        int[] iArr = jad_re.jad_an.jad_an;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }
}
