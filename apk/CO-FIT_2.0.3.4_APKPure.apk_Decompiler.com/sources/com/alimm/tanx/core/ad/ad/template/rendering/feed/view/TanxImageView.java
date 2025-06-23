package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

public class TanxImageView extends ImageView implements NotConfused {
    float radio = 0.0f;

    public TanxImageView(Context context) {
        super(context);
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = (int) (((float) size) * this.radio);
        LogUtils.d("TanxImageView", "width - >" + size + "  height -> " + i3);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public void setViewSize(float f) {
        this.radio = f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
