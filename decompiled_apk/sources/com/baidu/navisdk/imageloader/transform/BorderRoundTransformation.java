package com.baidu.navisdk.imageloader.transform;

import XXO0.oIX0oI;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class BorderRoundTransformation extends BitmapTransformation {
    private int mBorderColor;
    private int mBorderWidth;
    private int mCornerPos;
    private int mMargin;
    private int mRadius;

    public BorderRoundTransformation(Context context, int i, int i2, int i3, int i4, int i5) {
        this.mRadius = i;
        this.mMargin = i2;
        this.mBorderColor = i4;
        this.mBorderWidth = i3;
        this.mCornerPos = i5;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2, Paint paint2) {
        float f3;
        float f4 = this.mMargin;
        float f5 = f - f4;
        float f6 = f2 - f4;
        float f7 = this.mBorderWidth / 2;
        Path path = new Path();
        float[] fArr = new float[8];
        int i = this.mCornerPos;
        for (int i2 = 3; i2 >= 0; i2--) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            int i5 = i & 1;
            float f8 = 0.0f;
            if (i5 > 0) {
                f3 = this.mRadius;
            } else {
                f3 = 0.0f;
            }
            fArr[i4] = f3;
            if (i5 > 0) {
                f8 = this.mRadius;
            }
            fArr[i3] = f8;
            i >>= 1;
        }
        float f9 = this.mMargin + f7;
        path.addRoundRect(new RectF(f9, f9, f5 - f7, f6 - f7), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    public String getId() {
        return "RoundedTransformation(radius=" + this.mRadius + ", margin=" + this.mMargin + ", mBorderWidth" + this.mBorderWidth + ", mBorderColor" + this.mBorderColor + "mCornerPos" + this.mCornerPos + oIX0oI.I0Io.f4095I0Io;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
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
        Paint paint2 = new Paint(1);
        paint2.setColor(this.mBorderColor);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.mBorderWidth);
        drawRoundRect(canvas, paint, width, height, paint2);
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(getId().getBytes());
    }
}
