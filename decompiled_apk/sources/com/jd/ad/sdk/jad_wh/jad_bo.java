package com.jd.ad.sdk.jad_wh;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_kv.jad_xk;
import com.jd.ad.sdk.jad_rc.jad_qd;

/* loaded from: classes10.dex */
public class jad_bo implements jad_er<Bitmap, BitmapDrawable> {
    public final Resources jad_an;

    public jad_bo(@NonNull Resources resources) {
        this.jad_an = (Resources) jad_kx.jad_an(resources);
    }

    @Override // com.jd.ad.sdk.jad_wh.jad_er
    @Nullable
    public jad_xk<BitmapDrawable> jad_an(@NonNull jad_xk<Bitmap> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        return jad_qd.jad_an(this.jad_an, jad_xkVar);
    }
}
