package androidx.core.content.res;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i) {
        if (typedArray.hasValue(i)) {
        } else {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    @OOXIXo
    public static final ColorStateList getColorStateListOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        ColorStateList colorStateList = typedArray.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelSize(i, 0);
    }

    @OOXIXo
    public static final Drawable getDrawableOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        Drawable drawable = typedArray.getDrawable(i);
        IIX0o.ooOOo0oXI(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getFloat(i, 0.0f);
    }

    @OOXIXo
    @RequiresApi(26)
    public static final Typeface getFontOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return TypedArrayApi26ImplKt.getFont(typedArray, i);
    }

    public static final int getIntOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }

    @OOXIXo
    public static final String getStringOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        String string = typedArray.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    @OOXIXo
    public static final CharSequence[] getTextArrayOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getTextArray(i);
    }

    @OOXIXo
    public static final CharSequence getTextOrThrow(@OOXIXo TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        CharSequence text = typedArray.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(@OOXIXo TypedArray typedArray, @OOXIXo oOoXoXO<? super TypedArray, ? extends R> oooxoxo) {
        R invoke = oooxoxo.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
