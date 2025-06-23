package com.jd.ad.sdk.banner.jad_b_an;

import android.graphics.drawable.Drawable;
import android.webkit.ValueCallback;
import android.widget.ImageView;

/* loaded from: classes10.dex */
public class jad_b_bo implements ValueCallback<Drawable> {
    public final /* synthetic */ ImageView jad_b_an;
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_an jad_b_bo;

    public jad_b_bo(com.jd.ad.sdk.banner.jad_b_an jad_b_anVar, ImageView imageView) {
        this.jad_b_bo = jad_b_anVar;
        this.jad_b_an = imageView;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Drawable drawable) {
        Drawable drawable2 = drawable;
        this.jad_b_bo.jad_b_hu = drawable2;
        ImageView imageView = this.jad_b_an;
        if (imageView != null) {
            imageView.setImageDrawable(drawable2);
        }
    }
}
