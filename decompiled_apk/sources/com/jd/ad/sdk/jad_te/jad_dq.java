package com.jd.ad.sdk.jad_te;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public final class jad_dq extends jad_cp<Drawable> {
    public jad_dq(Drawable drawable) {
        super(drawable);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public int jad_bo() {
        return Math.max(1, this.jad_an.getIntrinsicHeight() * this.jad_an.getIntrinsicWidth() * 4);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Class<Drawable> jad_cp() {
        return this.jad_an.getClass();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public void jad_dq() {
    }
}
