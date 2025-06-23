package oI00o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* loaded from: classes6.dex */
public class oxoX {
    public static Bitmap I0Io(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                int pixel = (-16777216) & copy.getPixel(i, i2);
                int i3 = 255;
                if (((int) ((((16711680 & r5) >> 16) * 0.3d) + (((65280 & r5) >> 8) * 0.59d) + ((r5 & 255) * 0.11d))) <= 95) {
                    i3 = 0;
                }
                copy.setPixel(i, i2, (i3 << 16) | pixel | (i3 << 8) | i3);
            }
        }
        return copy;
    }

    public static Bitmap II0XooXoX(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(2.5f, 2.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap II0xO0(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = (width * i) + i2;
                int i4 = iArr[i3];
                int i5 = (int) ((((16711680 & i4) >> 16) * 0.3d) + (((65280 & i4) >> 8) * 0.59d) + ((i4 & 255) * 0.11d));
                iArr[i3] = i5 | (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i5 << 8);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap Oxx0IOOO(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap X0o0xo(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int min = Math.min(options.outHeight, options.outWidth) / 500;
            if (min > 0) {
                i = min;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap XO(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap oIX0oI(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            if (width2 > width) {
                width2 = width / 4;
                height2 = height / 4;
                bitmap2 = XO(bitmap2, width2, height2);
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.drawBitmap(bitmap2, (width - width2) >> 1, (height - height2) >> 1, (Paint) null);
                canvas.save();
                canvas.restore();
                return createBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap oxoX(Context context, int i) {
        Drawable drawable = context.getDrawable(i);
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
