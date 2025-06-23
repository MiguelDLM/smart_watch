package com.baidu.navisdk.ui.widget;

import XIXIX.OOXIXo;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.baidu.navisdk.embed.R;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class CircleProgressBar extends ProgressBar {
    private static final String COLOR_FFD3D3D5 = "#ffe3e3e5";
    private static final String COLOR_FFF2A670 = "#fff2a670";
    private static final int DEFAULT_LINE_COUNT = 45;
    private static final float DEFAULT_LINE_WIDTH = 4.0f;
    private static final String DEFAULT_PATTERN = "%d%%";
    private static final float DEFAULT_PROGRESS_STROKE_WIDTH = 1.0f;
    private static final float DEFAULT_PROGRESS_TEXT_SIZE = 11.0f;
    private static final float DEFAULT_START_DEGREE = -90.0f;
    private static final int LINE = 0;
    private static final int LINEAR = 0;
    private static final int RADIAL = 1;
    private static final int SOLID = 1;
    private static final int SOLID_LINE = 2;
    private static final int SWEEP = 2;
    private final Paint mBackgroundPaint;
    private Paint.Cap mCap;
    private float mCenterX;
    private float mCenterY;
    private boolean mDrawProgressText;
    private int mLineCount;
    private float mLineWidth;
    private int mProgressBackgroundColor;
    private int mProgressEndColor;
    private final Paint mProgressPaint;
    private final RectF mProgressRectF;
    private int mProgressStartColor;
    private float mProgressStrokeWidth;
    private int mProgressTextColor;
    private String mProgressTextFormatPattern;
    private final Paint mProgressTextPaint;
    private final Rect mProgressTextRect;
    private float mProgressTextSize;
    private float mRadius;
    private int mShader;
    private int mStyle;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    private void adjustIndeterminate() {
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mOnlyIndeterminate");
            declaredField.setAccessible(true);
            Boolean bool = Boolean.FALSE;
            declaredField.set(this, bool);
            Field declaredField2 = ProgressBar.class.getDeclaredField("mIndeterminate");
            declaredField2.setAccessible(true);
            declaredField2.set(this, bool);
            Field declaredField3 = ProgressBar.class.getDeclaredField("mCurrentDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(this, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawLineProgress(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.mLineCount);
        float f2 = this.mRadius;
        float f3 = f2 - this.mLineWidth;
        int progress = (int) ((getProgress() / getMax()) * this.mLineCount);
        for (int i = 0; i < this.mLineCount; i++) {
            double d = i * f;
            float sin = this.mCenterX + (((float) Math.sin(d)) * f3);
            float cos = this.mCenterX - (((float) Math.cos(d)) * f3);
            float sin2 = this.mCenterX + (((float) Math.sin(d)) * f2);
            float cos2 = this.mCenterX - (((float) Math.cos(d)) * f2);
            if (i < progress) {
                canvas.drawLine(sin, cos, sin2, cos2, this.mProgressPaint);
            } else {
                canvas.drawLine(sin, cos, sin2, cos2, this.mBackgroundPaint);
            }
        }
    }

    private void drawProgress(Canvas canvas) {
        int i = this.mStyle;
        if (i != 1) {
            if (i != 2) {
                drawLineProgress(canvas);
                return;
            } else {
                drawSolidLineProgress(canvas);
                return;
            }
        }
        drawSolidProgress(canvas);
    }

    private void drawProgressText(Canvas canvas) {
        if (!this.mDrawProgressText) {
            return;
        }
        String format = String.format(this.mProgressTextFormatPattern, Integer.valueOf(getProgress()));
        this.mProgressTextPaint.setTextSize(this.mProgressTextSize);
        this.mProgressTextPaint.setColor(this.mProgressTextColor);
        this.mProgressTextPaint.getTextBounds(format, 0, format.length(), this.mProgressTextRect);
        canvas.drawText(format, this.mCenterX, this.mCenterY + (this.mProgressTextRect.height() / 2), this.mProgressTextPaint);
    }

    private void drawSolidLineProgress(Canvas canvas) {
        canvas.drawArc(this.mProgressRectF, DEFAULT_START_DEGREE, 360.0f, false, this.mBackgroundPaint);
        canvas.drawArc(this.mProgressRectF, DEFAULT_START_DEGREE, (getProgress() * 360.0f) / getMax(), false, this.mProgressPaint);
    }

    private void drawSolidProgress(Canvas canvas) {
        canvas.drawArc(this.mProgressRectF, DEFAULT_START_DEGREE, 360.0f, false, this.mBackgroundPaint);
        canvas.drawArc(this.mProgressRectF, DEFAULT_START_DEGREE, (getProgress() * 360.0f) / getMax(), true, this.mProgressPaint);
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        String str;
        Paint.Cap cap;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNCircleProgressBar);
        this.mDrawProgressText = obtainStyledAttributes.getBoolean(R.styleable.BNCircleProgressBar_nsdk_bn_draw_progress_text, true);
        this.mLineCount = obtainStyledAttributes.getInt(R.styleable.BNCircleProgressBar_nsdk_bn_line_count, 45);
        int i = R.styleable.BNCircleProgressBar_nsdk_bn_progress_text_format_pattern;
        if (obtainStyledAttributes.hasValue(i)) {
            str = obtainStyledAttributes.getString(i);
        } else {
            str = DEFAULT_PATTERN;
        }
        this.mProgressTextFormatPattern = str;
        this.mStyle = obtainStyledAttributes.getInt(R.styleable.BNCircleProgressBar_nsdk_bn_style, 0);
        this.mShader = obtainStyledAttributes.getInt(R.styleable.BNCircleProgressBar_nsdk_bn_progress_shader, 0);
        int i2 = R.styleable.BNCircleProgressBar_nsdk_bn_progress_stroke_cap;
        if (obtainStyledAttributes.hasValue(i2)) {
            cap = Paint.Cap.values()[obtainStyledAttributes.getInt(i2, 0)];
        } else {
            cap = Paint.Cap.BUTT;
        }
        this.mCap = cap;
        this.mLineWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNCircleProgressBar_nsdk_bn_line_width, dip2px(getContext(), 4.0f));
        this.mProgressTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNCircleProgressBar_nsdk_bn_progress_text_size, dip2px(getContext(), DEFAULT_PROGRESS_TEXT_SIZE));
        this.mProgressStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNCircleProgressBar_nsdk_bn_progress_stroke_width, dip2px(getContext(), 1.0f));
        this.mProgressStartColor = obtainStyledAttributes.getColor(R.styleable.BNCircleProgressBar_nsdk_bn_progress_start_color, Color.parseColor(COLOR_FFF2A670));
        this.mProgressEndColor = obtainStyledAttributes.getColor(R.styleable.BNCircleProgressBar_nsdk_bn_progress_end_color, Color.parseColor(COLOR_FFF2A670));
        this.mProgressTextColor = obtainStyledAttributes.getColor(R.styleable.BNCircleProgressBar_nsdk_bn_progress_text_color, Color.parseColor(COLOR_FFF2A670));
        this.mProgressBackgroundColor = obtainStyledAttributes.getColor(R.styleable.BNCircleProgressBar_nsdk_bn_progress_background_color, Color.parseColor(COLOR_FFD3D3D5));
        obtainStyledAttributes.recycle();
    }

    private void initPaint() {
        Paint.Style style;
        Paint.Style style2;
        this.mProgressTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mProgressTextPaint.setTextSize(this.mProgressTextSize);
        Paint paint = this.mProgressPaint;
        if (this.mStyle == 1) {
            style = Paint.Style.FILL;
        } else {
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
        this.mProgressPaint.setStrokeWidth(this.mProgressStrokeWidth);
        this.mProgressPaint.setColor(this.mProgressStartColor);
        this.mProgressPaint.setStrokeCap(this.mCap);
        Paint paint2 = this.mBackgroundPaint;
        if (this.mStyle == 1) {
            style2 = Paint.Style.FILL;
        } else {
            style2 = Paint.Style.STROKE;
        }
        paint2.setStyle(style2);
        this.mBackgroundPaint.setStrokeWidth(this.mProgressStrokeWidth);
        this.mBackgroundPaint.setColor(this.mProgressBackgroundColor);
        this.mBackgroundPaint.setStrokeCap(this.mCap);
    }

    private void updateProgressShader() {
        double degrees;
        Shader shader = null;
        if (this.mProgressStartColor != this.mProgressEndColor) {
            int i = this.mShader;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        float f = (float) (((this.mProgressStrokeWidth / 3.141592653589793d) * 2.0d) / this.mRadius);
                        if (this.mCap == Paint.Cap.BUTT && this.mStyle == 2) {
                            degrees = OOXIXo.f3760XO;
                        } else {
                            degrees = Math.toDegrees(f);
                        }
                        shader = new SweepGradient(this.mCenterX, this.mCenterY, new int[]{this.mProgressStartColor, this.mProgressEndColor}, new float[]{0.0f, 1.0f});
                        Matrix matrix = new Matrix();
                        matrix.postRotate((float) ((-90.0d) - degrees), this.mCenterX, this.mCenterY);
                        shader.setLocalMatrix(matrix);
                    }
                } else {
                    shader = new RadialGradient(this.mCenterX, this.mCenterY, this.mRadius, this.mProgressStartColor, this.mProgressEndColor, Shader.TileMode.CLAMP);
                }
            } else {
                RectF rectF = this.mProgressRectF;
                float f2 = rectF.left;
                shader = new LinearGradient(f2, rectF.top, f2, rectF.bottom, this.mProgressStartColor, this.mProgressEndColor, Shader.TileMode.CLAMP);
            }
            this.mProgressPaint.setShader(shader);
            return;
        }
        this.mProgressPaint.setShader(null);
        this.mProgressPaint.setColor(this.mProgressStartColor);
    }

    public Paint.Cap getCap() {
        return this.mCap;
    }

    public int getLineCount() {
        return this.mLineCount;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getProgressBackgroundColor() {
        return this.mProgressBackgroundColor;
    }

    public int getProgressEndColor() {
        return this.mProgressEndColor;
    }

    public int getProgressStartColor() {
        return this.mProgressStartColor;
    }

    public float getProgressStrokeWidth() {
        return this.mProgressStrokeWidth;
    }

    public int getProgressTextColor() {
        return this.mProgressTextColor;
    }

    public String getProgressTextFormatPattern() {
        return this.mProgressTextFormatPattern;
    }

    public float getProgressTextSize() {
        return this.mProgressTextSize;
    }

    public int getShader() {
        return this.mShader;
    }

    public int getStyle() {
        return this.mStyle;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        drawProgress(canvas);
        drawProgressText(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2;
        this.mCenterX = f;
        float f2 = i2 / 2;
        this.mCenterY = f2;
        float min = Math.min(f, f2);
        this.mRadius = min;
        RectF rectF = this.mProgressRectF;
        float f3 = this.mCenterY;
        rectF.top = f3 - min;
        rectF.bottom = f3 + min;
        float f4 = this.mCenterX;
        rectF.left = f4 - min;
        rectF.right = f4 + min;
        updateProgressShader();
        RectF rectF2 = this.mProgressRectF;
        float f5 = this.mProgressStrokeWidth / 2.0f;
        rectF2.inset(f5, f5);
    }

    public void setCap(Paint.Cap cap) {
        this.mCap = cap;
        this.mProgressPaint.setStrokeCap(cap);
        this.mBackgroundPaint.setStrokeCap(cap);
        invalidate();
    }

    public void setLineCount(int i) {
        this.mLineCount = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.mProgressBackgroundColor = i;
        this.mBackgroundPaint.setColor(i);
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.mProgressEndColor = i;
        updateProgressShader();
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.mProgressStartColor = i;
        updateProgressShader();
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.mProgressStrokeWidth = f;
        float f2 = f / 2.0f;
        this.mProgressRectF.inset(f2, f2);
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.mProgressTextColor = i;
        invalidate();
    }

    public void setProgressTextFormatPattern(String str) {
        this.mProgressTextFormatPattern = str;
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.mProgressTextSize = f;
        invalidate();
    }

    public void setShader(int i) {
        this.mShader = i;
        updateProgressShader();
        invalidate();
    }

    public void setStyle(int i) {
        Paint.Style style;
        Paint.Style style2;
        this.mStyle = i;
        Paint paint = this.mProgressPaint;
        if (i == 1) {
            style = Paint.Style.FILL;
        } else {
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
        Paint paint2 = this.mBackgroundPaint;
        if (this.mStyle == 1) {
            style2 = Paint.Style.FILL;
        } else {
            style2 = Paint.Style.STROKE;
        }
        paint2.setStyle(style2);
        invalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressRectF = new RectF();
        this.mProgressTextRect = new Rect();
        this.mProgressPaint = new Paint(1);
        this.mBackgroundPaint = new Paint(1);
        this.mProgressTextPaint = new Paint(1);
        adjustIndeterminate();
        initFromAttributes(context, attributeSet);
        initPaint();
    }
}
