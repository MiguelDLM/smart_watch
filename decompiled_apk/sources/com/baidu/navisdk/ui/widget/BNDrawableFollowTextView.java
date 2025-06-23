package com.baidu.navisdk.ui.widget;

import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class BNDrawableFollowTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNDrawableFollowTextView(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@oOoXoXO Canvas canvas) {
        Drawable drawableLeft = getCompoundDrawables()[0];
        float measureText = getPaint().measureText(getText().toString());
        int compoundDrawablePadding = getCompoundDrawablePadding();
        IIX0o.oO(drawableLeft, "drawableLeft");
        float intrinsicWidth = measureText + compoundDrawablePadding + drawableLeft.getIntrinsicWidth();
        if (canvas != null) {
            canvas.translate((getWidth() - intrinsicWidth) / 2, 0.0f);
        }
        super.onDraw(canvas);
    }

    public BNDrawableFollowTextView(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNDrawableFollowTextView(@oOoXoXO Context context) {
        this(context, null, 0);
    }
}
