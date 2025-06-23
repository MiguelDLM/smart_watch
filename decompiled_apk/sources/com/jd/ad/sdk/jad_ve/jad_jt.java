package com.jd.ad.sdk.jad_ve;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.jd.ad.sdk.jad_lu.jad_kx;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_jt {
    public static final PointF jad_an = new PointF();

    public static float jad_an(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static PointF jad_an(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2, jad_kx jad_kxVar) {
        if (jad_erVar.jad_an(jad_kxVar.jad_cp(), i)) {
            list.add(jad_erVar2.jad_an(jad_kxVar.jad_cp()).jad_an(jad_kxVar));
        }
    }

    public static int jad_an(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }
}
