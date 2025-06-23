package com.sma.smartv3.view.text;

import OOxOI.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes12.dex */
public class DINCondBold extends SkinCompatTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DINCondBold(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public void applyCustomFont(@oOoXoXO Context context) {
        if (context != null) {
            setTypeface(oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.DIN_COND_BOLD, context));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DINCondBold(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ DINCondBold(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DINCondBold(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        applyCustomFont(context);
    }
}
