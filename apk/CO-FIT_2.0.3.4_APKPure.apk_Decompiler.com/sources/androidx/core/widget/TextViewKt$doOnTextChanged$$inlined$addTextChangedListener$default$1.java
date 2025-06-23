package androidx.core.widget;

import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n*L\n1#1,97:1\n78#2:98\n71#3:99\n*E\n"})
public final class TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ Oxx0xo $onTextChanged;

    public TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(Oxx0xo oxx0xo) {
        this.$onTextChanged = oxx0xo;
    }

    public void afterTextChanged(@oOoXoXO Editable editable) {
    }

    public void beforeTextChanged(@oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
