package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class BNDrawableTextView extends TextView {
    private static final int BOTTOM = 4;
    private static final int LEFT = 1;
    private static final int RIGHT = 3;
    private static final int TOP = 2;

    public BNDrawableTextView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null && context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNDrawableTextView);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BNDrawableTextView_nsdk_bn_text_drawable_src);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BNDrawableTextView_nsdk_bn_text_drawable_width, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BNDrawableTextView_nsdk_bn_text_drawable_height, 0);
            int i = obtainStyledAttributes.getInt(R.styleable.BNDrawableTextView_nsdk_bn_text_drawable_location, 0);
            obtainStyledAttributes.recycle();
            setDrawable(drawable, dimensionPixelOffset, dimensionPixelOffset2, i);
        }
    }

    private void setDrawable(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null) {
            if (i > 0 && i2 > 0) {
                drawable.setBounds(0, 0, i, i2);
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            setCompoundDrawables(null, null, null, drawable);
                            return;
                        }
                        return;
                    }
                    setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                setCompoundDrawables(null, drawable, null, null);
                return;
            }
            setCompoundDrawables(drawable, null, null, null);
        }
    }

    public BNDrawableTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BNDrawableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
