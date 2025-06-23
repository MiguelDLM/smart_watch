package com.baidu.platform.comapi.wnplatform.arclayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.baidu.R;

/* loaded from: classes8.dex */
public class ArcLayout extends b {
    public static final int CROP_INSIDE = 1;
    public static final int CROP_OUTSIDE = 2;
    public static final int POSITION_BOTTOM = 1;
    public static final int POSITION_LEFT = 3;
    public static final int POSITION_RIGHT = 4;
    public static final int POSITION_TOP = 2;
    private int arcHeight;
    private int arcPosition;
    private int cropDirection;

    public ArcLayout(Context context) {
        super(context);
        this.arcPosition = 2;
        this.cropDirection = 1;
        this.arcHeight = 0;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcLayout);
            this.arcHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ArcLayout_arc_height, this.arcHeight);
            this.arcPosition = obtainStyledAttributes.getInteger(R.styleable.ArcLayout_arc_position, this.arcPosition);
            this.cropDirection = obtainStyledAttributes.getInteger(R.styleable.ArcLayout_arc_cropDirection, this.cropDirection);
            obtainStyledAttributes.recycle();
        }
        super.setClipPathCreator(new a(this));
    }

    public ArcLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arcPosition = 2;
        this.cropDirection = 1;
        this.arcHeight = 0;
        init(context, attributeSet);
    }

    public ArcLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arcPosition = 2;
        this.cropDirection = 1;
        this.arcHeight = 0;
        init(context, attributeSet);
    }
}
