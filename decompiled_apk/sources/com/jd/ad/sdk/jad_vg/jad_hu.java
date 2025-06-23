package com.jd.ad.sdk.jad_vg;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_hs.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_xk;

/* loaded from: classes10.dex */
public final class jad_hu implements jad_ly<com.jd.ad.sdk.jad_gr.jad_an, Bitmap> {
    public final com.jd.ad.sdk.jad_lw.jad_er jad_an;

    public jad_hu(com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        this.jad_an = jad_erVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_an jad_anVar, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public jad_xk<Bitmap> jad_an(@NonNull com.jd.ad.sdk.jad_gr.jad_an jad_anVar, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_rc.jad_er.jad_an(jad_anVar.jad_fs(), this.jad_an);
    }
}
