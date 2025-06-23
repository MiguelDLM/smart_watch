package androidx.core.graphics.drawable;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class ColorDrawableKt {
    @OOXIXo
    public static final ColorDrawable toDrawable(@ColorInt int i) {
        return new ColorDrawable(i);
    }

    @OOXIXo
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorDrawable toDrawable(@OOXIXo Color color) {
        int argb;
        argb = color.toArgb();
        return new ColorDrawable(argb);
    }
}
