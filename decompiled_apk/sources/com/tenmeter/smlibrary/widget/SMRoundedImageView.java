package com.tenmeter.smlibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.utils.DisplayUtil;

/* loaded from: classes13.dex */
public class SMRoundedImageView extends ImageView {
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private float radius;
    private float[] rids;
    private float topLeftRadius;
    private float topRightRadius;

    public SMRoundedImageView(@NonNull Context context) {
        super(context);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, null, 0);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SMRoundedImageView, i, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_riv_radius, DisplayUtil.dp2px(8.0f));
        this.radius = dimension;
        this.topLeftRadius = obtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_top_left_radius, dimension);
        this.topRightRadius = obtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_top_right_radius, this.radius);
        this.bottomLeftRadius = obtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_bottom_left_radius, this.radius);
        this.bottomRightRadius = obtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_bottom_right_radius, this.radius);
        obtainStyledAttributes.recycle();
        float f = this.topLeftRadius;
        float f2 = this.topRightRadius;
        float f3 = this.bottomRightRadius;
        float f4 = this.bottomLeftRadius;
        this.rids = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.rids, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public void setRids(float f) {
        this.radius = f;
    }

    public SMRoundedImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, 0);
    }

    public SMRoundedImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public SMRoundedImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, i);
    }
}
