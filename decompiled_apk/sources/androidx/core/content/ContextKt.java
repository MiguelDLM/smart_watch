package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, @OXOo.OOXIXo int[] iArr, @AttrRes int i, @StyleRes int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super TypedArray, oXIO0o0XI> oooxoxo) {
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

    public static final void withStyledAttributes(@OXOo.OOXIXo Context context, @StyleRes int i, @OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super TypedArray, oXIO0o0XI> oooxoxo) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        oooxoxo.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
