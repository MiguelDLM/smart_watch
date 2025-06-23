package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_er implements com.jd.ad.sdk.jad_kv.jad_xk<Bitmap>, com.jd.ad.sdk.jad_kv.jad_tg {
    public final Bitmap jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_bo;

    public jad_er(@NonNull Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        this.jad_an = (Bitmap) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(bitmap, "Bitmap must not be null");
        this.jad_bo = (com.jd.ad.sdk.jad_lw.jad_er) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_erVar, "BitmapPool must not be null");
    }

    @Nullable
    public static jad_er jad_an(@Nullable Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        if (bitmap == null) {
            return null;
        }
        return new jad_er(bitmap, jad_erVar);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Bitmap get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public int jad_bo() {
        return com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Class<Bitmap> jad_cp() {
        return Bitmap.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public void jad_dq() {
        this.jad_bo.jad_an(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_tg
    public void jad_an() {
        this.jad_an.prepareToDraw();
    }
}
