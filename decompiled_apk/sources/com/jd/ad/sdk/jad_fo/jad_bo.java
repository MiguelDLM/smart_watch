package com.jd.ad.sdk.jad_fo;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_ep.jad_ly;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_hs.jad_hu;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public final class jad_bo implements jad_hu {
    public final Object jad_bo;

    public jad_bo(@NonNull Object obj) {
        this.jad_bo = jad_kx.jad_an(obj);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_bo) {
            return this.jad_bo.equals(((jad_bo) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.jad_bo.toString().getBytes(jad_hu.jad_an));
    }

    public String toString() {
        StringBuilder jad_an = jad_ly.jad_an("ObjectKey{object=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }
}
