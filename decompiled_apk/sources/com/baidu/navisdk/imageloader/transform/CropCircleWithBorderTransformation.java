package com.baidu.navisdk.imageloader.transform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private static final String ID = "CropCircleWithBorderTransformation1";
    private static final int VERSION = 1;
    private int borderColor;
    private Paint mBorderPaint;
    private float mBorderWidth;

    public CropCircleWithBorderTransformation(Context context, int i, int i2) {
        this.mBorderWidth = Resources.getSystem().getDisplayMetrics().density * i;
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setDither(true);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(i2);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.borderColor = i2;
    }

    private Bitmap circleCrop(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) - (this.mBorderWidth / 2.0f));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = bitmapPool.get(min, min, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, config);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f = min / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        Paint paint2 = this.mBorderPaint;
        if (paint2 != null) {
            canvas.drawCircle(f, f, f - (this.mBorderWidth / 2.0f), paint2);
        }
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            if (cropCircleWithBorderTransformation.mBorderWidth == this.mBorderWidth && cropCircleWithBorderTransformation.borderColor == this.borderColor) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (int) (230345622 + (this.mBorderWidth * 100.0f) + this.borderColor + 10.0f);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return circleCrop(bitmapPool, bitmap);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes());
    }
}
