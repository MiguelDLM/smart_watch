package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,66:1\n31#2,4:67\n13579#3,2:71\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n32#1:67,4\n32#1:71,2\n*E\n"})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(@OXOo.OOXIXo Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@OXOo.OOXIXo Spannable spannable, int i, int i2, @OXOo.OOXIXo Object obj) {
        spannable.setSpan(obj, i, i2, 17);
    }

    @OXOo.OOXIXo
    public static final Spannable toSpannable(@OXOo.OOXIXo CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(@OXOo.OOXIXo Spannable spannable, @OXOo.OOXIXo X0.oOoXoXO oooxoxo, @OXOo.OOXIXo Object obj) {
        spannable.setSpan(obj, oooxoxo.getStart().intValue(), oooxoxo.getEndInclusive().intValue(), 17);
    }
}
