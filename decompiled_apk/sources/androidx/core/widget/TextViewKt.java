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
/* loaded from: classes.dex */
public final class TextViewKt {
    @OOXIXo
    public static final TextWatcher addTextChangedListener(@OOXIXo TextView textView, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo, @OOXIXo Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo2, @OOXIXo oOoXoXO<? super Editable, oXIO0o0XI> oooxoxo) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(oooxoxo, oxx0xo, oxx0xo2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Oxx0xo oxx0xo, Oxx0xo oxx0xo2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oxx0xo = new Oxx0xo<CharSequence, Integer, Integer, Integer, oXIO0o0XI>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                public final void invoke(@OXOo.oOoXoXO CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 2) != 0) {
            oxx0xo2 = new Oxx0xo<CharSequence, Integer, Integer, Integer, oXIO0o0XI>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                public final void invoke(@OXOo.oOoXoXO CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 4) != 0) {
            oooxoxo = new oOoXoXO<Editable, oXIO0o0XI>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.oOoXoXO Editable editable) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Editable editable) {
                    invoke2(editable);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(oooxoxo, oxx0xo, oxx0xo2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @OOXIXo
    public static final TextWatcher doAfterTextChanged(@OOXIXo TextView textView, @OOXIXo final oOoXoXO<? super Editable, oXIO0o0XI> oooxoxo) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
                oOoXoXO.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @OOXIXo
    public static final TextWatcher doBeforeTextChanged(@OOXIXo TextView textView, @OOXIXo final Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
                Oxx0xo.this.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @OOXIXo
    public static final TextWatcher doOnTextChanged(@OOXIXo TextView textView, @OOXIXo final Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
                Oxx0xo.this.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
