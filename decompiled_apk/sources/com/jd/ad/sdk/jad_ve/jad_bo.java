package com.jd.ad.sdk.jad_ve;

/* loaded from: classes10.dex */
public class jad_bo {
    public static float jad_an(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float jad_bo(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int jad_an(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float jad_an = jad_an(((i >> 16) & 255) / 255.0f);
        float jad_an2 = jad_an(((i >> 8) & 255) / 255.0f);
        float jad_an3 = jad_an((i & 255) / 255.0f);
        float jad_an4 = jad_an(((i2 >> 16) & 255) / 255.0f);
        float jad_an5 = ((jad_an(((i2 >> 8) & 255) / 255.0f) - jad_an2) * f) + jad_an2;
        float jad_an6 = ((jad_an((i2 & 255) / 255.0f) - jad_an3) * f) + jad_an3;
        float f4 = (((f3 - f2) * f) + f2) * 255.0f;
        return (Math.round(jad_bo(((jad_an4 - jad_an) * f) + jad_an) * 255.0f) << 16) | (Math.round(f4) << 24) | (Math.round(jad_bo(jad_an5) * 255.0f) << 8) | Math.round(jad_bo(jad_an6) * 255.0f);
    }
}
