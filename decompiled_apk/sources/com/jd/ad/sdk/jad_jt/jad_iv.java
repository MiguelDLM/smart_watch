package com.jd.ad.sdk.jad_jt;

import java.math.BigDecimal;

/* loaded from: classes10.dex */
public class jad_iv {
    public static int jad_an(int i, int i2) {
        if (i != 0 && i2 != 0) {
            return (int) (new BigDecimal(String.valueOf(i)).divide(new BigDecimal(String.valueOf(i2)), 2, 4).floatValue() * 100.0f);
        }
        return 0;
    }
}
