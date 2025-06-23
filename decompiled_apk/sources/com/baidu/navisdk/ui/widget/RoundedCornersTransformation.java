package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

/* loaded from: classes8.dex */
public class RoundedCornersTransformation implements Transformation<Bitmap> {
    private BitmapPool mBitmapPool;
    private CornerType mCornerType;
    private int mDiameter;
    private int mMargin;
    private int mRadius;

    /* renamed from: com.baidu.navisdk.ui.widget.RoundedCornersTransformation$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType = iArr;
            try {
                iArr[CornerType.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(Context context, int i, int i2) {
        this(context, i, i2, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new RectF(f4, f4, r1 + this.mDiameter, f2 - this.mRadius), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mDiameter;
        RectF rectF = new RectF(f - f3, f2 - f3, f, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        float f5 = this.mMargin;
        canvas.drawRect(new RectF(f5, f5, f - this.mRadius, f2), paint);
        float f6 = this.mRadius;
        canvas.drawRect(new RectF(f - f6, this.mMargin, f, f2 - f6), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new RectF(f4, f4, f, f2 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        float f3 = i;
        float f4 = i + this.mDiameter;
        RectF rectF = new RectF(f3, f3, f4, f4);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        float f6 = this.mDiameter;
        RectF rectF2 = new RectF(f - f6, f2 - f6, f, f2);
        float f7 = this.mRadius;
        canvas.drawRoundRect(rectF2, f7, f7, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f - this.mDiameter, f2), paint);
        canvas.drawRect(new RectF(this.mDiameter + r1, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mDiameter;
        RectF rectF = new RectF(f - i, this.mMargin, f, r3 + i);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        RectF rectF2 = new RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF2, f4, f4, paint);
        float f5 = this.mMargin;
        float f6 = this.mRadius;
        canvas.drawRect(new RectF(f5, f5, f - f6, f2 - f6), paint);
        float f7 = this.mMargin + this.mRadius;
        canvas.drawRect(new RectF(f7, f7, f, f2), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        RectF rectF = new RectF(f3, f3, r1 + this.mDiameter, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        RectF rectF = new RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        RectF rectF2 = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF2, f5, f5, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + r3, f - this.mRadius, f2), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        RectF rectF = new RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        float f5 = this.mMargin;
        RectF rectF2 = new RectF(f5, f5, r1 + this.mDiameter, f2);
        float f6 = this.mRadius;
        canvas.drawRoundRect(rectF2, f6, f6, paint);
        float f7 = this.mMargin + this.mRadius;
        canvas.drawRect(new RectF(f7, f7, f, f2), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        RectF rectF2 = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF2, f4, f4, paint);
        float f5 = this.mMargin;
        float f6 = this.mRadius;
        canvas.drawRect(new RectF(f5, f5, f - f6, f2 - f6), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        RectF rectF = new RectF(f3, f3, r1 + this.mDiameter, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        RectF rectF2 = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF2, f5, f5, paint);
        canvas.drawRect(new RectF(r1 + r2, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new RectF(f4, f4, f - this.mRadius, f2), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        float f4 = f - f3;
        float f5 = f2 - f3;
        switch (AnonymousClass1.$SwitchMap$com$baidu$navisdk$ui$widget$RoundedCornersTransformation$CornerType[this.mCornerType.ordinal()]) {
            case 1:
                drawTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 2:
                drawTopRightRoundRect(canvas, paint, f4, f5);
                return;
            case 3:
                drawBottomLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 4:
                drawBottomRightRoundRect(canvas, paint, f4, f5);
                return;
            case 5:
                drawTopRoundRect(canvas, paint, f4, f5);
                return;
            case 6:
                drawBottomRoundRect(canvas, paint, f4, f5);
                return;
            case 7:
                drawLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 8:
                drawRightRoundRect(canvas, paint, f4, f5);
                return;
            case 9:
                drawOtherTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 10:
                drawOtherTopRightRoundRect(canvas, paint, f4, f5);
                return;
            case 11:
                drawOtherBottomLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 12:
                drawOtherBottomRightRoundRect(canvas, paint, f4, f5);
                return;
            case 13:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f4, f5);
                return;
            case 14:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f4, f5);
                return;
            default:
                float f6 = this.mMargin;
                RectF rectF = new RectF(f6, f6, f4, f5);
                float f7 = this.mRadius;
                canvas.drawRoundRect(rectF, f7, f7, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        float f3 = i;
        float f4 = i + this.mDiameter;
        RectF rectF = new RectF(f3, f3, f4, f4);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        int i2 = this.mMargin;
        float f6 = i2;
        float f7 = i2 + this.mRadius;
        canvas.drawRect(new RectF(f6, f7, f7, f2), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mDiameter;
        RectF rectF = new RectF(f - i, this.mMargin, f, r3 + i);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new RectF(f4, f4, f - this.mRadius, f2), paint);
        canvas.drawRect(new RectF(f - this.mRadius, this.mMargin + r1, f, f2), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        RectF rectF = new RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f, f2), paint);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i, int i2) {
        Bitmap bitmap = resource.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        BitmapPool bitmapPool = this.mBitmapPool;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = bitmapPool.get(width, height, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, config);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, width, height);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }

    public RoundedCornersTransformation(BitmapPool bitmapPool, int i, int i2) {
        this(bitmapPool, i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(Context context, int i, int i2, CornerType cornerType) {
        this(Glide.get(context).getBitmapPool(), i, i2, cornerType);
    }

    public RoundedCornersTransformation(BitmapPool bitmapPool, int i, int i2, CornerType cornerType) {
        this.mBitmapPool = bitmapPool;
        this.mRadius = i;
        this.mDiameter = i * 2;
        this.mMargin = i2;
        this.mCornerType = cornerType;
    }
}
