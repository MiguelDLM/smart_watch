package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxFrameLayout extends FrameLayout implements NotConfused {
    float radio;

    public TanxFrameLayout(Context context) {
        super(context);
        this.radio = 0.56f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.radio), 1073741824));
    }

    public void setViewSize(float f) {
        this.radio = f;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.radio = 0.56f;
    }
}
