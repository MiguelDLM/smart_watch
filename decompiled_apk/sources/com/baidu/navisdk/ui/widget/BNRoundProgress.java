package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public final class BNRoundProgress extends View {
    private static final String TAG = "BNRoundProgress";
    private int mCenter;
    private RectF mOval;
    private Paint mPaint;
    private int mProgress;

    @ColorInt
    private int mProgressColor;
    private int mRadius;

    @ColorInt
    private int mRoundColor;
    private int mRoundWidth;
    private int mStartAngle;
    private String mText;
    private int mTextColor;
    private int mTextSize;
    private int max;
    private int style;

    /* loaded from: classes8.dex */
    public interface Stype {
        public static final int FILL = 1;
        public static final int STROKE = 0;
    }

    public BNRoundProgress(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        if (attributeSet == null) {
            this.mRoundColor = 9934743;
            this.mProgressColor = 16777215;
            this.mTextColor = 16777215;
            this.mTextSize = 15;
            this.mRoundWidth = 5;
            this.max = 100;
            this.style = 0;
            this.mStartAngle = -90;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNRoundProgress);
        this.mRoundColor = obtainStyledAttributes.getColor(R.styleable.BNRoundProgress_nsdk_bn_round_color, 9934743);
        this.mProgressColor = obtainStyledAttributes.getColor(R.styleable.BNRoundProgress_nsdk_bn_progress_color, 16777215);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.BNRoundProgress_nsdk_round_text_color, 16777215);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNRoundProgress_nsdk_round_text_size, 15);
        this.mRoundWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BNRoundProgress_nsdk_bn_round_width, 5);
        this.max = obtainStyledAttributes.getInteger(R.styleable.BNRoundProgress_nsdk_round_max_value, 100);
        this.style = obtainStyledAttributes.getInt(R.styleable.BNRoundProgress_nsdk_bn_round_style, 0);
        this.mStartAngle = obtainStyledAttributes.getInt(R.styleable.BNRoundProgress_nsdk_round_start_angle, -90);
        obtainStyledAttributes.recycle();
    }

    public void onDestroy() {
        this.mPaint = null;
        this.mOval = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCenter <= 0) {
            this.mCenter = getWidth() / 2;
        }
        if (this.mRadius <= 0) {
            this.mRadius = (int) (this.mCenter - (this.mRoundWidth / 2.0f));
        }
        Paint paint = this.mPaint;
        if (paint == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "mPaint == null");
                return;
            }
            return;
        }
        paint.setColor(this.mRoundColor);
        Paint paint2 = this.mPaint;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.mPaint.setStrokeWidth(this.mRoundWidth);
        float f = this.mCenter;
        canvas.drawCircle(f, f, this.mRadius, this.mPaint);
        this.mPaint.setStrokeWidth(this.mRoundWidth);
        this.mPaint.setColor(this.mProgressColor);
        if (this.mOval == null) {
            int i = this.mCenter;
            int i2 = this.mRadius;
            float f2 = i - i2;
            float f3 = i + i2;
            this.mOval = new RectF(f2, f2, f3, f3);
        }
        int i3 = this.style;
        if (i3 != 0) {
            if (i3 == 1) {
                this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.mProgress != 0) {
                    canvas.drawArc(this.mOval, this.mStartAngle, (r0 * 360) / this.max, true, this.mPaint);
                }
            }
        } else {
            this.mPaint.setStyle(style);
            canvas.drawArc(this.mOval, this.mStartAngle, (this.mProgress * 360) / this.max, false, this.mPaint);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setTextSize(this.mTextSize);
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            float measureText = this.mPaint.measureText(this.mText);
            canvas.drawText(this.mText, this.mCenter - (measureText / 2.0f), r3 + (this.mTextSize / 2), this.mPaint);
        }
    }

    public synchronized void setProgress(int i) {
        if (i >= 0) {
            int i2 = this.max;
            if (i > i2) {
                i = i2;
            }
            this.mProgress = i;
            postInvalidate();
        } else {
            throw new IllegalArgumentException("progress not < 0");
        }
    }

    public synchronized void setProgressAndText(int i, String str) {
        if (i >= 0) {
            int i2 = this.max;
            if (i > i2) {
                i = i2;
            }
            this.mProgress = i;
            this.mText = str;
            postInvalidate();
        } else {
            throw new IllegalArgumentException("progress not < 0");
        }
    }

    public BNRoundProgress(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNRoundProgress(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCenter = 0;
        this.mRadius = 0;
        init(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public BNRoundProgress(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCenter = 0;
        this.mRadius = 0;
        init(context, attributeSet);
    }
}
