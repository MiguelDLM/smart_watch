package androidx.core.graphics.drawable;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public final class ColorDrawableKt {
    @OOXIXo
    public static final ColorDrawable toDrawable(@ColorInt int i) {
        return new ColorDrawable(i);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @OOXIXo
    public static final ColorDrawable toDrawable(@OOXIXo Color color) {
        return new ColorDrawable(color.toArgb());
    }
}
