package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_kv.jad_tg;
import com.jd.ad.sdk.jad_kv.jad_xk;

/* loaded from: classes10.dex */
public abstract class jad_cp<T extends Drawable> implements jad_xk<T>, jad_tg {
    public final T jad_an;

    public jad_cp(T t) {
        this.jad_an = (T) jad_kx.jad_an(t);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Object get() {
        Drawable.ConstantState constantState = this.jad_an.getConstantState();
        if (constantState == null) {
            return this.jad_an;
        }
        return constantState.newDrawable();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_tg
    public void jad_an() {
        Bitmap jad_bo;
        T t = this.jad_an;
        if (t instanceof BitmapDrawable) {
            jad_bo = ((BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof com.jd.ad.sdk.jad_vg.jad_cp)) {
            return;
        } else {
            jad_bo = ((com.jd.ad.sdk.jad_vg.jad_cp) t).jad_bo();
        }
        jad_bo.prepareToDraw();
    }
}
