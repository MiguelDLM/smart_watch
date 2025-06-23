package com.sma.smartv3.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import java.security.MessageDigest;

/* loaded from: classes12.dex */
public class oI0IIXIo extends CenterCrop {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f24507I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static float f24508II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static float f24509oIX0oI;

    public oI0IIXIo(Context context) {
        this(context, 4);
    }

    public static void drawRoundRect(Canvas canvas, Paint paint, float width, float height, Paint borderPaint) {
        float f;
        float f2 = f24508II0xO0 / 2.0f;
        Path path = new Path();
        float[] fArr = new float[8];
        int i = 15;
        for (int i2 = 3; i2 >= 0; i2--) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            int i5 = i & 1;
            float f3 = 0.0f;
            if (i5 > 0) {
                f = f24509oIX0oI;
            } else {
                f = 0.0f;
            }
            fArr[i4] = f;
            if (i5 > 0) {
                f3 = f24509oIX0oI;
            }
            fArr[i3] = f3;
            i >>= 1;
        }
        path.addRoundRect(new RectF(f2, f2, width - f2, height - f2), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, borderPaint);
    }

    public static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) {
            return null;
        }
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = pool.get(width, height, config);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), config);
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(source, tileMode, tileMode));
        paint.setAntiAlias(true);
        if (f24507I0Io != 0) {
            Paint paint2 = new Paint(1);
            paint2.setColor(f24507I0Io);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f24508II0xO0);
            drawRoundRect(canvas, paint, source.getWidth(), source.getHeight(), paint2);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, source.getWidth(), source.getHeight());
            float f = f24509oIX0oI;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, super.transform(pool, toTransform, outWidth, outHeight));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@IXo.XO MessageDigest messageDigest) {
    }

    public oI0IIXIo(Context context, int radius) {
        f24509oIX0oI = Resources.getSystem().getDisplayMetrics().density * radius;
    }

    public oI0IIXIo(Context context, int radius, int borderColor, int borderWidth) {
        f24509oIX0oI = Resources.getSystem().getDisplayMetrics().density * radius;
        f24507I0Io = borderColor;
        f24508II0xO0 = Resources.getSystem().getDisplayMetrics().density * borderWidth;
    }
}
