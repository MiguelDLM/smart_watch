package com.baidu.navisdk.util.common;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: classes8.dex */
public final class e {
    @Nullable
    public static Drawable a(Drawable drawable, @ColorInt int i) {
        if (drawable == null) {
            return null;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(mutate, i);
        return mutate;
    }
}
