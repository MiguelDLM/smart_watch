package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxImageView extends ImageView implements NotConfused {
    float radio;

    public TanxImageView(Context context) {
        super(context);
        this.radio = 0.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = (int) (size * this.radio);
        LogUtils.d("TanxImageView", "width - >" + size + "  height -> " + i3);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public void setViewSize(float f) {
        this.radio = f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.0f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radio = 0.0f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.radio = 0.0f;
    }
}
