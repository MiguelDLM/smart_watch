package com.baidu.navisdk.ui.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* loaded from: classes8.dex */
public class BNBaseShadowDrawable extends Drawable {
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_ROUND = 1;
    private int[] mBgColor;
    private Paint mBgPaint;
    private int mOffsetBottom;
    private int mOffsetLeft;
    private int mOffsetRight;
    private int mOffsetTop;
    private int mOffsetX;
    private int mOffsetY;
    private RectF mRect;
    private int mShadowColor;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mShape;
    private int mShapeRadius;

    /* loaded from: classes8.dex */
    public static class Builder {
        private int[] mBgColor;
        private int mShape = 1;
        private int mShapeRadius = 12;
        private int mShadowColor = Color.parseColor("#4d000000");
        private int mShadowRadius = 18;
        private int mOffsetX = 0;
        private int mOffsetY = 0;
        private int mOffsetLeft = 0;
        private int mOffsetRight = 0;
        private int mOffsetTop = 0;
        private int mOffsetBottom = 0;

        public Builder() {
            this.mBgColor = r0;
            int[] iArr = {0};
        }

        public BNBaseShadowDrawable builder() {
            return new BNBaseShadowDrawable(this.mShape, this.mBgColor, this.mShapeRadius, this.mShadowColor, this.mShadowRadius, this.mOffsetX, this.mOffsetY);
        }

        public BNBaseShadowDrawable builderOffset() {
            return new BNBaseShadowDrawable(this.mShape, this.mBgColor, this.mShapeRadius, this.mShadowColor, this.mShadowRadius, this.mOffsetLeft, this.mOffsetRight, this.mOffsetTop, this.mOffsetBottom);
        }

        public Builder setBgColor(int i) {
            this.mBgColor[0] = i;
            return this;
        }

        public Builder setOffsetBottom(int i) {
            this.mOffsetBottom = i;
            return this;
        }

        public Builder setOffsetLeft(int i) {
            this.mOffsetLeft = i;
            return this;
        }

        public Builder setOffsetRight(int i) {
            this.mOffsetRight = i;
            return this;
        }

        public Builder setOffsetTop(int i) {
            this.mOffsetTop = i;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mOffsetX = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mOffsetY = i;
            return this;
        }

        public Builder setShadowColor(int i) {
            this.mShadowColor = i;
            return this;
        }

        public Builder setShadowRadius(int i) {
            this.mShadowRadius = i;
            return this;
        }

        public Builder setShape(int i) {
            this.mShape = i;
            return this;
        }

        public Builder setShapeRadius(int i) {
            this.mShapeRadius = i;
            return this;
        }

        public Builder setBgColor(int[] iArr) {
            this.mBgColor = iArr;
            return this;
        }
    }

    public BNBaseShadowDrawable(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.mShape = i;
        this.mBgColor = iArr;
        this.mShapeRadius = i2;
        this.mShadowRadius = i4;
        this.mShadowColor = i3;
        this.mOffsetX = i5;
        this.mOffsetY = i6;
        this.mOffsetLeft = i5;
        this.mOffsetRight = i5;
        this.mOffsetTop = i6;
        this.mOffsetBottom = i6;
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(i4, i5, i6, i3);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.mBgPaint = paint2;
        paint2.setAntiAlias(true);
    }

    public static void setShadowDrawable(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.mBgColor;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.mBgPaint.setColor(iArr[0]);
            } else {
                Paint paint = this.mBgPaint;
                RectF rectF = this.mRect;
                float f = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.mRect;
                paint.setShader(new LinearGradient(f, height, rectF2.right, rectF2.height() / 2.0f, this.mBgColor, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.mShape == 1) {
            RectF rectF3 = this.mRect;
            float f2 = this.mShapeRadius;
            canvas.drawRoundRect(rectF3, f2, f2, this.mShadowPaint);
            RectF rectF4 = this.mRect;
            float f3 = this.mShapeRadius;
            canvas.drawRoundRect(rectF4, f3, f3, this.mBgPaint);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mBgPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mShadowPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.mShadowRadius;
        this.mRect = new RectF((i + i5) - this.mOffsetLeft, (i2 + i5) - this.mOffsetTop, (i3 - i5) - this.mOffsetRight, (i4 - i5) - this.mOffsetBottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mShadowPaint.setColorFilter(colorFilter);
    }

    public static void setShadowDrawable(View view, int i, int i2, int i3, int i4, int i5) {
        BNBaseShadowDrawable builder = new Builder().setShapeRadius(i).setShadowColor(i2).setShadowRadius(i3).setOffsetX(i4).setOffsetY(i5).builder();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, builder);
    }

    public static void setShadowDrawable(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        BNBaseShadowDrawable builder = new Builder().setBgColor(i).setShapeRadius(i2).setShadowColor(i3).setShadowRadius(i4).setOffsetX(i5).setOffsetY(i6).builder();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, builder);
    }

    public BNBaseShadowDrawable(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mShape = i;
        this.mBgColor = iArr;
        this.mShapeRadius = i2;
        this.mShadowRadius = i4;
        this.mShadowColor = i3;
        this.mOffsetLeft = i5;
        this.mOffsetRight = i6;
        this.mOffsetTop = i7;
        this.mOffsetBottom = i8;
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(i4, this.mOffsetLeft, this.mOffsetTop, i3);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.mBgPaint = paint2;
        paint2.setAntiAlias(true);
    }

    public static void setShadowDrawable(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        BNBaseShadowDrawable builderOffset = new Builder().setShape(i).setBgColor(i2).setShapeRadius(i3).setShadowColor(i4).setShadowRadius(i5).setOffsetLeft(i6).setOffsetRight(i7).setOffsetTop(i8).setOffsetBottom(i9).builderOffset();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, builderOffset);
    }

    public static void setShadowDrawable(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        BNBaseShadowDrawable builder = new Builder().setShape(i).setBgColor(i2).setShapeRadius(i3).setShadowColor(i4).setShadowRadius(i5).setOffsetX(i6).setOffsetY(i7).builder();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, builder);
    }

    public static void setShadowDrawable(View view, int[] iArr, int i, int i2, int i3, int i4, int i5) {
        BNBaseShadowDrawable builder = new Builder().setBgColor(iArr).setShapeRadius(i).setShadowColor(i2).setShadowRadius(i3).setOffsetX(i4).setOffsetY(i5).builder();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, builder);
    }
}
