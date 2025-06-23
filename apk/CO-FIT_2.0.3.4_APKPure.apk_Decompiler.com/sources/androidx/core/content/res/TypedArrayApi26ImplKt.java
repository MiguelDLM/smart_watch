package androidx.core.content.res;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(26)
final class TypedArrayApi26ImplKt {
    @OOXIXo
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @DoNotInline
    @x0XOIxOo
    @OOXIXo
    public static final Typeface getFont(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        Typeface font = typedArray.getFont(i);
        IIX0o.ooOOo0oXI(font);
        return font;
    }
}
