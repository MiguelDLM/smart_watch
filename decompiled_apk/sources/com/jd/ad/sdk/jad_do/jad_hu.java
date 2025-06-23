package com.jd.ad.sdk.jad_do;

import java.text.DecimalFormat;

/* loaded from: classes10.dex */
public class jad_hu {
    public static String jad_an(double d) {
        float log;
        double random = (float) Math.random();
        if (random <= 0.5d) {
            log = (float) (Math.log(1.0f - r0) * (-0.001f));
        } else {
            log = (float) (Math.log(random) * 0.001f);
        }
        try {
            return new DecimalFormat("0.000000").format(log + d);
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }
}
