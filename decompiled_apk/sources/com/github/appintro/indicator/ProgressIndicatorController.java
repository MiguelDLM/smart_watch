package com.github.appintro.indicator;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.appintro.internal.LayoutUtil;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class ProgressIndicatorController extends ProgressBar implements IndicatorController {
    private int selectedIndicatorColor;
    private int unselectedIndicatorColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ProgressIndicatorController(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final boolean isRtl() {
        Context context = getContext();
        IIX0o.oO(context, "this.context");
        return LayoutUtil.isRtl(context);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void initialize(int i) {
        setMax(i);
        if (isRtl()) {
            setScaleX(-1.0f);
        }
        if (i == 1) {
            setVisibility(4);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    @OOXIXo
    public ProgressIndicatorController newInstance(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i) {
        int i2;
        if (isRtl()) {
            i2 = getMax() - i;
        } else {
            i2 = i + 1;
        }
        setProgress(i2);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i) {
        this.selectedIndicatorColor = i;
        getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i) {
        this.unselectedIndicatorColor = i;
        getIndeterminateDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ProgressIndicatorController(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ProgressIndicatorController(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.progressBarStyleHorizontal : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public ProgressIndicatorController(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.selectedIndicatorColor = 1;
        this.unselectedIndicatorColor = 1;
    }
}
