package androidx.core.widget;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
public final class TextViewKt {
    @OOXIXo
    public static final TextWatcher addTextChangedListener(@OOXIXo TextView textView, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo2, @OOXIXo oOoXoXO<? super Editable, oXIO0o0XI> oooxoxo) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(oooxoxo, oxx0xo, oxx0xo2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Oxx0xo oxx0xo, Oxx0xo oxx0xo2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oxx0xo = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            oxx0xo2 = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            oooxoxo = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(oooxoxo, oxx0xo, oxx0xo2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @OOXIXo
    public static final TextWatcher doAfterTextChanged(@OOXIXo TextView textView, @OOXIXo oOoXoXO<? super Editable, oXIO0o0XI> oooxoxo) {
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(oooxoxo);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1;
    }

    @OOXIXo
    public static final TextWatcher doBeforeTextChanged(@OOXIXo TextView textView, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(oxx0xo);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1;
    }

    @OOXIXo
    public static final TextWatcher doOnTextChanged(@OOXIXo TextView textView, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(oxx0xo);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1;
    }
}
