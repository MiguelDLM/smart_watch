package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_tg implements com.jd.ad.sdk.jad_hs.jad_ly<Uri, Bitmap> {
    public final com.jd.ad.sdk.jad_te.jad_er jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_bo;

    public jad_tg(com.jd.ad.sdk.jad_te.jad_er jad_erVar, com.jd.ad.sdk.jad_lw.jad_er jad_erVar2) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_erVar2;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    @Nullable
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull Uri uri, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_kv.jad_xk jad_an = this.jad_an.jad_an(uri);
        if (jad_an == null) {
            return null;
        }
        return jad_kx.jad_an(this.jad_bo, (Drawable) ((com.jd.ad.sdk.jad_te.jad_cp) jad_an).get(), i, i2);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public boolean jad_an(@NonNull Uri uri, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
