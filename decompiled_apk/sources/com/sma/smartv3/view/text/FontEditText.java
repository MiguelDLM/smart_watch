package com.sma.smartv3.view.text;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatEditText;

/* loaded from: classes12.dex */
public final class FontEditText extends SkinCompatEditText {

    @oOoXoXO
    private AttributeSet attrs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontEditText(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @oOoXoXO
    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final void setAttrs(@oOoXoXO AttributeSet attributeSet) {
        this.attrs = attributeSet;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontEditText(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ FontEditText(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FontEditText(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.attrs = attributeSet;
        setTypeface(FontTextView.Companion.oIX0oI(context, attributeSet));
    }
}
