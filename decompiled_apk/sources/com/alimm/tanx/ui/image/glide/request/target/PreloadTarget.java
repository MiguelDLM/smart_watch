package com.alimm.tanx.ui.image.glide.request.target;

import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private PreloadTarget(int i, int i2) {
        super(i, i2);
    }

    public static <Z> PreloadTarget<Z> obtain(int i, int i2) {
        return new PreloadTarget<>(i, i2);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onResourceReady(Z z, GlideAnimation<? super Z> glideAnimation) {
        Glide.clear(this);
    }
}
