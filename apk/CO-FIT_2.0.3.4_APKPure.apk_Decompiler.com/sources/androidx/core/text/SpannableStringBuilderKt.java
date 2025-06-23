package androidx.core.text;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class SpannableStringBuilderKt {
    @OOXIXo
    public static final SpannableStringBuilder backgroundColor(@OOXIXo SpannableStringBuilder spannableStringBuilder, @ColorInt int i, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i);
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder bold(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannedString buildSpannedString(@OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        oooxoxo.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @OOXIXo
    public static final SpannableStringBuilder color(@OOXIXo SpannableStringBuilder spannableStringBuilder, @ColorInt int i, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder inSpans(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo Object[] objArr, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        for (Object span : objArr) {
            spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder italic(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder scale(@OOXIXo SpannableStringBuilder spannableStringBuilder, float f, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f);
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder strikeThrough(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder subscript(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder superscript(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder underline(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @OOXIXo
    public static final SpannableStringBuilder inSpans(@OOXIXo SpannableStringBuilder spannableStringBuilder, @OOXIXo Object obj, @OOXIXo oOoXoXO<? super SpannableStringBuilder, oXIO0o0XI> oooxoxo) {
        int length = spannableStringBuilder.length();
        oooxoxo.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
