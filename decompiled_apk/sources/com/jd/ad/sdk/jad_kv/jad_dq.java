package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_hs.jad_hu {
    public final com.jd.ad.sdk.jad_hs.jad_hu jad_bo;
    public final com.jd.ad.sdk.jad_hs.jad_hu jad_cp;

    public jad_dq(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar2) {
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_huVar2;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_dq)) {
            return false;
        }
        jad_dq jad_dqVar = (jad_dq) obj;
        return this.jad_bo.equals(jad_dqVar.jad_bo) && this.jad_cp.equals(jad_dqVar.jad_cp);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public int hashCode() {
        return this.jad_cp.hashCode() + (this.jad_bo.hashCode() * 31);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
        this.jad_cp.jad_an(messageDigest);
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("DataCacheKey{sourceKey=");
        jad_an.append(this.jad_bo);
        jad_an.append(", signature=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }
}
