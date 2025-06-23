package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SquareImageView extends AppCompatImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SquareImageView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SquareImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ SquareImageView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public SquareImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
    }
}
