package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public class RGImageView extends ImageView {
    public RGImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
    }

    public RGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
