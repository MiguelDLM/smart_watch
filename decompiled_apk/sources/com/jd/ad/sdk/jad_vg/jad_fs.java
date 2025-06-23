package com.jd.ad.sdk.jad_vg;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_hs.jad_na;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public class jad_fs implements jad_na<jad_cp> {
    public final jad_na<Bitmap> jad_bo;

    public jad_fs(jad_na<Bitmap> jad_naVar) {
        this.jad_bo = (jad_na) jad_kx.jad_an(jad_naVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public boolean equals(Object obj) {
        if (obj instanceof jad_fs) {
            return this.jad_bo.equals(((jad_fs) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_na
    @NonNull
    public jad_xk<jad_cp> jad_an(@NonNull Context context, @NonNull jad_xk<jad_cp> jad_xkVar, int i, int i2) {
        jad_cp jad_cpVar = jad_xkVar.get();
        jad_xk<Bitmap> jad_erVar = new com.jd.ad.sdk.jad_rc.jad_er(jad_cpVar.jad_bo(), com.jd.ad.sdk.jad_ep.jad_cp.jad_an(context).jad_an);
        jad_xk<Bitmap> jad_an = this.jad_bo.jad_an(context, jad_erVar, i, i2);
        if (!jad_erVar.equals(jad_an)) {
            jad_erVar.jad_dq();
        }
        Bitmap bitmap = jad_an.get();
        jad_cpVar.jad_an.jad_an.jad_an(this.jad_bo, bitmap);
        return jad_xkVar;
    }
}
