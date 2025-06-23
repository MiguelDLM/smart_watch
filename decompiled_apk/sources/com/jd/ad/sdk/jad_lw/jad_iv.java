package com.jd.ad.sdk.jad_lw;

/* loaded from: classes10.dex */
public final class jad_iv implements jad_an<int[]> {
    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public String jad_an() {
        return "IntegerArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_bo() {
        return 4;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int[] newArray(int i) {
        return new int[i];
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_an(int[] iArr) {
        return iArr.length;
    }
}
