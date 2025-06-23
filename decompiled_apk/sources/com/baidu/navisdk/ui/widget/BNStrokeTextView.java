package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class BNStrokeTextView extends TextView {
    private static final String TAG = "BNStrokeTextView";
    private boolean isDrawing;
    private boolean isSupportStroke;
    private TextPaint paint;
    private int strokeColor;
    private float strokeWidth;
    private ColorStateList textColor;

    public BNStrokeTextView(Context context) {
        this(context, null);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        this.isSupportStroke = false;
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNStrokeTextView);
            int i = R.styleable.BNStrokeTextView_bn_stroke_color;
            if (obtainStyledAttributes.hasValue(i)) {
                this.strokeColor = obtainStyledAttributes.getColor(i, getCurrentTextColor());
                this.paint = getPaint();
                this.isSupportStroke = true;
            }
            int i2 = R.styleable.BNStrokeTextView_bn_stroke_width;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.strokeWidth = obtainStyledAttributes.getDimension(i2, 0.5f);
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.isDrawing) {
            return;
        }
        super.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.isSupportStroke && this.paint != null) {
            g gVar = g.COMMON_UI;
            if (gVar.d()) {
                gVar.e(TAG, "onDraw: ");
            }
            this.isDrawing = true;
            this.textColor = getTextColors();
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
            setTextColor(this.strokeColor);
            this.paint.setStrokeWidth(this.strokeWidth);
            super.onDraw(canvas);
            this.paint.setStyle(Paint.Style.FILL);
            setTextColor(this.textColor);
            super.onDraw(canvas);
            this.isDrawing = false;
            return;
        }
        super.onDraw(canvas);
    }

    public void setStrokeColor(@ColorInt int i) {
        this.strokeColor = i;
    }

    public BNStrokeTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNStrokeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSupportStroke = false;
        this.isDrawing = false;
        init(context, attributeSet);
    }

    public BNStrokeTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSupportStroke = false;
        this.isDrawing = false;
        init(context, attributeSet);
    }
}
