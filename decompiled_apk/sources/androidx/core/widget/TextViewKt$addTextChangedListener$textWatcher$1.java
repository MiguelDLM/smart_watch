package androidx.core.widget;

import Oox.Oxx0xo;
import Oox.oOoXoXO;
import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
/* loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ oOoXoXO<Editable, oXIO0o0XI> $afterTextChanged;
    final /* synthetic */ Oxx0xo<CharSequence, Integer, Integer, Integer, oXIO0o0XI> $beforeTextChanged;
    final /* synthetic */ Oxx0xo<CharSequence, Integer, Integer, Integer, oXIO0o0XI> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(oOoXoXO<? super Editable, oXIO0o0XI> oooxoxo, Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo, Oxx0xo<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo2) {
        this.$afterTextChanged = oooxoxo;
        this.$beforeTextChanged = oxx0xo;
        this.$onTextChanged = oxx0xo2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
