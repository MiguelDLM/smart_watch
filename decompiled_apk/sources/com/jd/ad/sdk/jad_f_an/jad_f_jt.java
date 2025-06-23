package com.jd.ad.sdk.jad_f_an;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;

/* loaded from: classes10.dex */
public class jad_f_jt implements OnImageLoadListener {
    public final /* synthetic */ ImageView jad_f_an;

    public jad_f_jt(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar, ImageView imageView) {
        this.jad_f_an = imageView;
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadFailed(int i, String str, @Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadSuccess(@NonNull Drawable drawable) {
        ImageView imageView = this.jad_f_an;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
