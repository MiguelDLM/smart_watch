package com.jd.ad.sdk.jad_tc;

import android.graphics.PointF;
import com.jd.ad.sdk.a.a;

/* loaded from: classes10.dex */
public class jad_zm implements jad_mx<PointF> {
    public static final jad_zm jad_an = new jad_zm();

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public PointF jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f) {
        int jad_mz = jad_cpVar.jad_mz();
        if (jad_mz == 1 || jad_mz == 3) {
            return jad_sf.jad_an(jad_cpVar, f);
        }
        if (jad_mz == 7) {
            PointF pointF = new PointF(((float) jad_cpVar.jad_iv()) * f, ((float) jad_cpVar.jad_iv()) * f);
            while (jad_cpVar.jad_jt()) {
                jad_cpVar.jad_ob();
            }
            return pointF;
        }
        StringBuilder a2 = a.a("Cannot convert json to point. Next token is ");
        a2.append(com.jd.ad.sdk.jad_ud.jad_dq.jad_an(jad_mz));
        throw new IllegalArgumentException(a2.toString());
    }
}
