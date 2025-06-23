package androidx.core.widget;

import Oox.oOoXoXO;
import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ oOoXoXO $afterTextChanged;

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(oOoXoXO oooxoxo) {
        this.$afterTextChanged = oooxoxo;
    }

    public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }
}
