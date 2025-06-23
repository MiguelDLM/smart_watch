package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class MLImageView extends AppCompatImageView {
    private int mBorderColor;
    private int mBorderWidth;
    private int mHeight;
    private int mPressAlpha;
    private int mPressColor;
    private Paint mPressPaint;
    private int mRadius;
    private int mShapeType;
    private int mWidth;

    public MLImageView(Context context) {
        super(context);
        init(context, null);
    }

    private void drawBorder(Canvas canvas) {
        if (this.mBorderWidth > 0) {
            Paint paint = new Paint();
            paint.setStrokeWidth(this.mBorderWidth);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.mBorderColor);
            paint.setAntiAlias(true);
            if (this.mShapeType == 0) {
                int i = this.mWidth;
                canvas.drawCircle(i / 2, this.mHeight / 2, (i / 2) - this.mBorderWidth, paint);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
                int i2 = this.mRadius;
                canvas.drawRoundRect(rectF, i2, i2, paint);
            }
        }
    }

    private void drawDrawable(Canvas canvas, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        canvas.saveLayer(0.0f, 0.0f, this.mWidth, this.mHeight, null);
        if (this.mShapeType == 0) {
            int i = this.mWidth;
            canvas.drawCircle(i / 2, this.mHeight / 2, (i / 2) - this.mBorderWidth, paint);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            int i2 = this.mRadius;
            canvas.drawRoundRect(rectF, i2, i2, paint);
        }
        paint.setXfermode(porterDuffXfermode);
        Matrix matrix = new Matrix();
        matrix.postScale((getWidth() - this.mBorderWidth) / bitmap.getWidth(), (getHeight() - this.mBorderWidth) / bitmap.getHeight());
        canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), 0.0f, 0.0f, paint);
        canvas.restore();
    }

    private void drawPress(Canvas canvas) {
        int i = this.mShapeType;
        if (i == 0) {
            int i2 = this.mWidth;
            canvas.drawCircle(i2 / 2, this.mHeight / 2, i2 / 2, this.mPressPaint);
        } else if (i == 1) {
            RectF rectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
            int i3 = this.mRadius;
            canvas.drawRoundRect(rectF, i3, i3, this.mPressPaint);
        }
    }

    private void init(Context context, AttributeSet attrs) {
        this.mPressAlpha = 64;
        this.mPressColor = getResources().getColor(R.color.launcher_title_bar);
        this.mRadius = 16;
        this.mShapeType = 1;
        this.mBorderWidth = 0;
        this.mBorderColor = getResources().getColor(R.color.colorAccent_secondary);
        if (attrs != null) {
            LogUtils.d("test attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, com.sma.smartv3.R.styleable.MLImageView);
            this.mPressColor = obtainStyledAttributes.getColor(3, this.mPressColor);
            this.mPressAlpha = obtainStyledAttributes.getInteger(2, this.mPressAlpha);
            this.mRadius = obtainStyledAttributes.getDimensionPixelSize(4, this.mRadius);
            this.mShapeType = obtainStyledAttributes.getInteger(5, this.mShapeType);
            this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(1, this.mBorderWidth);
            this.mBorderColor = obtainStyledAttributes.getColor(0, this.mBorderColor);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.mPressPaint = paint;
        paint.setAntiAlias(true);
        this.mPressPaint.setStyle(Paint.Style.FILL);
        this.mPressPaint.setColor(this.mPressColor);
        this.mPressPaint.setAlpha(0);
        this.mPressPaint.setFlags(1);
        setClickable(true);
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            drawDrawable(canvas, ((BitmapDrawable) drawable).getBitmap());
            drawPress(canvas);
            drawBorder(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LogUtils.d("test onSizeChanged 1 " + w);
        this.mWidth = w;
        this.mHeight = h;
        LogUtils.d("test onSizeChanged 2 " + this.mWidth);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                invalidate();
            } else {
                this.mPressPaint.setAlpha(0);
                invalidate();
            }
        } else {
            this.mPressPaint.setAlpha(this.mPressAlpha);
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    public MLImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MLImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
}
