package com.alimm.tanx.ui.image.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: classes.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
    protected final T drawable;

    public DrawableResource(T t) {
        if (t != null) {
            this.drawable = t;
            return;
        }
        throw new NullPointerException("Drawable must not be null!");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return (T) this.drawable.getConstantState().newDrawable();
    }
}
