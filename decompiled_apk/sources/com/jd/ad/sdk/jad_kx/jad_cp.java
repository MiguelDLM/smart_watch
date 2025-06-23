package com.jd.ad.sdk.jad_kx;

/* loaded from: classes10.dex */
public class jad_cp {
    public final int jad_an;
    public final String jad_bo;
    public final String jad_cp;
    public String jad_dq;
    public String jad_er;

    public jad_cp(int i, String str, String str2, String str3, String str4) {
        this.jad_an = i;
        this.jad_bo = str2;
        this.jad_cp = str;
        this.jad_dq = str3;
        this.jad_er = str4;
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("PreloadAdData{id=");
        jad_an.append(this.jad_an);
        jad_an.append(", rId='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", appIdSlotId='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append(", preloadAdJson='");
        jad_an.append(this.jad_dq);
        jad_an.append('\'');
        jad_an.append(", preloadAdCacheTimeStamp='");
        jad_an.append(this.jad_er);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}
