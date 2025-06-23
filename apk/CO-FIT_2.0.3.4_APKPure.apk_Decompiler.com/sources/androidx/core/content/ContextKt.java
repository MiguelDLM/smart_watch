package androidx.core.content;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.oXIO0o0XI;

public final class ContextKt {
    public static final void withStyledAttributes(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, @OOXIXo int[] iArr, @AttrRes int i, @StyleRes int i2, @OOXIXo Oox.oOoXoXO<? super TypedArray, oXIO0o0XI> oooxoxo) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        oooxoxo.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        oooxoxo.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@OOXIXo Context context, @StyleRes int i, @OOXIXo int[] iArr, @OOXIXo Oox.oOoXoXO<? super TypedArray, oXIO0o0XI> oooxoxo) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        oooxoxo.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
