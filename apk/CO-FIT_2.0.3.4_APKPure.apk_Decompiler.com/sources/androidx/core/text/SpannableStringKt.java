package androidx.core.text;

import OXOo.OOXIXo;
import X0.oOoXoXO;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,66:1\n31#2,4:67\n13579#3,2:71\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n32#1:67,4\n32#1:71,2\n*E\n"})
public final class SpannableStringKt {
    public static final void clearSpans(@OOXIXo Spannable spannable) {
        for (Object removeSpan : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(@OOXIXo Spannable spannable, int i, int i2, @OOXIXo Object obj) {
        spannable.setSpan(obj, i, i2, 17);
    }

    @OOXIXo
    public static final Spannable toSpannable(@OOXIXo CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(@OOXIXo Spannable spannable, @OOXIXo oOoXoXO oooxoxo, @OOXIXo Object obj) {
        spannable.setSpan(obj, oooxoxo.getStart().intValue(), oooxoxo.getEndInclusive().intValue(), 17);
    }
}
