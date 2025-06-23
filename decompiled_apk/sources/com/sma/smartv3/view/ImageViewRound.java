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
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.DrawableKt;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ImageViewRound extends AppCompatImageView {
    private boolean antiAlias;

    @OXOo.OOXIXo
    private Matrix bitmapMatrix;
    private int borderColor;
    private Paint borderPaint;
    private int borderWidth;

    @OXOo.OOXIXo
    private Paint drawablePaint;
    private boolean isCustomizeDraw;
    private int radius;
    private RectF rectF;
    private int type;
    private float viewHeight;
    private float viewWidth;

    @OXOo.OOXIXo
    private final PorterDuffXfermode xfermode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ImageViewRound(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final float dp2px(int i) {
        return SizeUtils.dp2px(i);
    }

    private final void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageViewRound);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.antiAlias = obtainStyledAttributes.getBoolean(0, true);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(4, this.radius);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(2, this.borderWidth);
        this.borderColor = obtainStyledAttributes.getColor(1, this.borderColor);
        this.type = obtainStyledAttributes.getInteger(5, this.type);
        this.isCustomizeDraw = obtainStyledAttributes.getBoolean(3, this.isCustomizeDraw);
        obtainStyledAttributes.recycle();
    }

    private final float sp2px(int i) {
        return SizeUtils.sp2px(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        if (this.isCustomizeDraw) {
            canvas.save();
            this.drawablePaint.reset();
            this.drawablePaint.setColor(-1);
            this.drawablePaint.setAntiAlias(true);
            if (getDrawable() == null || this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
                return;
            }
            Drawable drawable = getDrawable();
            IIX0o.oO(drawable, "getDrawable(...)");
            Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
            canvas.saveLayer(0.0f, 0.0f, this.viewWidth, this.viewHeight, null);
            Paint paint = null;
            if (this.type == 0) {
                float f = this.viewWidth;
                float f2 = 2;
                canvas.drawCircle(f / f2, this.viewHeight / f2, (f / f2) - this.borderWidth, this.drawablePaint);
            } else {
                RectF rectF = this.rectF;
                if (rectF == null) {
                    IIX0o.XOxIOxOx("rectF");
                    rectF = null;
                }
                int i = this.radius;
                canvas.drawRoundRect(rectF, i, i, this.drawablePaint);
            }
            this.drawablePaint.setXfermode(this.xfermode);
            float width = (this.viewWidth - this.borderWidth) / bitmap$default.getWidth();
            float height = (this.viewHeight - this.borderWidth) / bitmap$default.getHeight();
            this.bitmapMatrix.reset();
            this.bitmapMatrix.postScale(width, height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap$default, 0, 0, bitmap$default.getWidth(), bitmap$default.getHeight(), this.bitmapMatrix, false);
            IIX0o.oO(createBitmap, "createBitmap(...)");
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.drawablePaint);
            canvas.restore();
            int i2 = this.borderWidth;
            if (i2 > 0) {
                if (this.type == 0) {
                    float f3 = this.viewWidth;
                    float f4 = 2;
                    float f5 = f3 / f4;
                    float f6 = this.viewHeight / f4;
                    float f7 = (f3 / f4) - i2;
                    Paint paint2 = this.borderPaint;
                    if (paint2 == null) {
                        IIX0o.XOxIOxOx("borderPaint");
                    } else {
                        paint = paint2;
                    }
                    canvas.drawCircle(f5, f6, f7, paint);
                    return;
                }
                RectF rectF2 = this.rectF;
                if (rectF2 == null) {
                    IIX0o.XOxIOxOx("rectF");
                    rectF2 = null;
                }
                int i3 = this.radius;
                float f8 = i3;
                float f9 = i3;
                Paint paint3 = this.borderPaint;
                if (paint3 == null) {
                    IIX0o.XOxIOxOx("borderPaint");
                } else {
                    paint = paint3;
                }
                canvas.drawRoundRect(rectF2, f8, f9, paint);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        this.viewHeight = i2;
        this.rectF = new RectF(0.0f, 0.0f, this.viewWidth, this.viewHeight);
    }

    public final void setRadius(int i) {
        this.radius = i;
        invalidate();
    }

    public final void setType(int i) {
        this.type = i;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ImageViewRound(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ImageViewRound(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ImageViewRound(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.drawablePaint = new Paint();
        this.bitmapMatrix = new Matrix();
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.antiAlias = true;
        this.radius = (int) dp2px(10);
        this.borderColor = getResources().getColor(com.sma.smartv3.co_fit.R.color.line_color);
        initAttrs(context, attributeSet);
        if (this.borderWidth > 0) {
            Paint paint = new Paint();
            this.borderPaint = paint;
            paint.setAntiAlias(this.antiAlias);
            Paint paint2 = this.borderPaint;
            Paint paint3 = null;
            if (paint2 == null) {
                IIX0o.XOxIOxOx("borderPaint");
                paint2 = null;
            }
            paint2.setStrokeWidth(this.borderWidth);
            Paint paint4 = this.borderPaint;
            if (paint4 == null) {
                IIX0o.XOxIOxOx("borderPaint");
                paint4 = null;
            }
            paint4.setStyle(Paint.Style.STROKE);
            Paint paint5 = this.borderPaint;
            if (paint5 == null) {
                IIX0o.XOxIOxOx("borderPaint");
            } else {
                paint3 = paint5;
            }
            paint3.setColor(this.borderColor);
        }
        setClickable(true);
    }
}
