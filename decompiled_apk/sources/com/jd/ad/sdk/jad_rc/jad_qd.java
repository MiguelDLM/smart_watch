package com.jd.ad.sdk.jad_rc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public final class jad_qd implements com.jd.ad.sdk.jad_kv.jad_xk<BitmapDrawable>, com.jd.ad.sdk.jad_kv.jad_tg {
    public final Resources jad_an;
    public final com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_bo;

    public jad_qd(@NonNull Resources resources, @NonNull com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_xkVar) {
        this.jad_an = (Resources) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(resources);
        this.jad_bo = (com.jd.ad.sdk.jad_kv.jad_xk) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_xkVar);
    }

    @Nullable
    public static com.jd.ad.sdk.jad_kv.jad_xk<BitmapDrawable> jad_an(@NonNull Resources resources, @Nullable com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_xkVar) {
        if (jad_xkVar == null) {
            return null;
        }
        return new jad_qd(resources, jad_xkVar);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.jad_an, this.jad_bo.get());
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public int jad_bo() {
        return this.jad_bo.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Class<BitmapDrawable> jad_cp() {
        return BitmapDrawable.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public void jad_dq() {
        this.jad_bo.jad_dq();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_tg
    public void jad_an() {
        com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_xkVar = this.jad_bo;
        if (jad_xkVar instanceof com.jd.ad.sdk.jad_kv.jad_tg) {
            ((com.jd.ad.sdk.jad_kv.jad_tg) jad_xkVar).jad_an();
        }
    }
}
