package com.tenmeter.smlibrary.utils;

import XXO0.oIX0oI;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: classes13.dex */
public class GlideRoundTransform extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";
    private static final int VERSION = 1;
    private CornerType cornerType;
    private int diameter;
    private int margin;
    private int radius;

    /* renamed from: com.tenmeter.smlibrary.utils.GlideRoundTransform$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: classes13.dex */
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

    public GlideRoundTransform(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.margin, f2 - this.diameter, r1 + r3, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF(i2, i2, i2 + this.diameter, f2 - this.radius), paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f, f2), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        RectF rectF = new RectF(f - i, f2 - i, f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, f - this.radius, f2), paint);
        int i4 = this.radius;
        canvas.drawRect(new RectF(f - i4, this.margin, f, f2 - i4), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.margin, f2 - this.diameter, f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF(i2, i2, f, f2 - this.radius), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.diameter;
        RectF rectF2 = new RectF(f - i4, f2 - i4, f, f2);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        canvas.drawRect(new RectF(this.margin, r1 + this.radius, f - this.diameter, f2), paint);
        canvas.drawRect(new RectF(this.diameter + r1, this.margin, f, f2 - this.radius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        RectF rectF = new RectF(f - i, this.margin, f, r3 + i);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.margin, f2 - this.diameter, r1 + r3, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4, i4, f - i5, f2 - i5), paint);
        int i6 = this.margin;
        int i7 = this.radius;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, f, f2), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, i + this.diameter, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f, f2), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, f, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(f - this.diameter, this.margin, f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(this.margin, r1 + r3, f - this.radius, f2), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, f, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        RectF rectF2 = new RectF(i3, i3, i3 + this.diameter, f2);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF(i5 + i6, i5 + i6, f, f2), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.margin, f2 - this.diameter, f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = new RectF(f - this.diameter, this.margin, f, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF2, i2, i2, paint);
        int i3 = this.margin;
        int i4 = this.radius;
        canvas.drawRect(new RectF(i3, i3, f - i4, f2 - i4), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, i + this.diameter, f2);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.margin, f2 - this.diameter, f, f2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(r1 + r2, this.margin, f, f2 - this.radius), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - this.diameter, this.margin, f, f2);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF(i2, i2, f - this.radius, f2), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        float f3 = f - i;
        float f4 = f2 - i;
        switch (AnonymousClass1.$SwitchMap$com$tenmeter$smlibrary$utils$GlideRoundTransform$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i2 = this.margin;
                RectF rectF = new RectF(i2, i2, f3, f4);
                int i3 = this.radius;
                canvas.drawRoundRect(rectF, i3, i3, paint);
                return;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 3:
                drawTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 6:
                drawTopRoundRect(canvas, paint, f3, f4);
                return;
            case 7:
                drawBottomRoundRect(canvas, paint, f3, f4);
                return;
            case 8:
                drawLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 9:
                drawRightRoundRect(canvas, paint, f3, f4);
                return;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f3, f4);
                return;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f3, f4);
                return;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f3, f4);
                return;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f3, f4);
                return;
            default:
                int i4 = this.margin;
                RectF rectF2 = new RectF(i4, i4, f3, f4);
                int i5 = this.radius;
                canvas.drawRoundRect(rectF2, i5, i5, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4, i4 + i5, i4 + i5, f2), paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f, f2), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.diameter;
        RectF rectF = new RectF(f - i, this.margin, f, r3 + i);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, f - this.radius, f2), paint);
        canvas.drawRect(new RectF(f - this.radius, this.margin + r1, f, f2), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, f, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.margin, r1 + this.radius, f, f2), paint);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideRoundTransform) {
            GlideRoundTransform glideRoundTransform = (GlideRoundTransform) obj;
            if (glideRoundTransform.radius == this.radius && glideRoundTransform.diameter == this.diameter && glideRoundTransform.margin == this.margin && glideRoundTransform.cornerType == this.cornerType) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 425235636 + (this.radius * 10000) + (this.diameter * 1000) + (this.margin * 100) + (this.cornerType.ordinal() * 10);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + oIX0oI.I0Io.f4095I0Io;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, width, height);
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.diameter + this.margin + this.cornerType).getBytes(Key.CHARSET));
    }

    public GlideRoundTransform(int i, int i2, CornerType cornerType) {
        this.radius = i;
        this.diameter = i * 2;
        this.margin = i2;
        this.cornerType = cornerType;
    }
}
