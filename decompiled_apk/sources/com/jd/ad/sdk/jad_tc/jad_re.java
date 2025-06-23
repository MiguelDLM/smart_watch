package com.jd.ad.sdk.jad_tc;

/* loaded from: classes10.dex */
public class jad_re implements jad_mx<Integer> {
    public static final jad_re jad_an = new jad_re();

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public Integer jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f) {
        return Integer.valueOf(Math.round(jad_sf.jad_bo(jad_cpVar) * f));
    }
}
