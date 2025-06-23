package com.jd.ad.sdk.jad_tc;

import android.graphics.Color;

/* loaded from: classes10.dex */
public class jad_jt implements jad_mx<Integer> {
    public static final jad_jt jad_an = new jad_jt();

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public Integer jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f) {
        double d;
        boolean z = true;
        if (jad_cpVar.jad_mz() != 1) {
            z = false;
        }
        if (z) {
            jad_cpVar.jad_bo();
        }
        double jad_iv = jad_cpVar.jad_iv();
        double jad_iv2 = jad_cpVar.jad_iv();
        double jad_iv3 = jad_cpVar.jad_iv();
        if (jad_cpVar.jad_mz() == 7) {
            d = jad_cpVar.jad_iv();
        } else {
            d = 1.0d;
        }
        if (z) {
            jad_cpVar.jad_dq();
        }
        if (jad_iv <= 1.0d && jad_iv2 <= 1.0d && jad_iv3 <= 1.0d) {
            jad_iv *= 255.0d;
            jad_iv2 *= 255.0d;
            jad_iv3 *= 255.0d;
            if (d <= 1.0d) {
                d *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d, (int) jad_iv, (int) jad_iv2, (int) jad_iv3));
    }
}
