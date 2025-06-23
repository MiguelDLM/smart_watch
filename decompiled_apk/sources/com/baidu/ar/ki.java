package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class ki {
    public static Bitmap i(Context context, String str) {
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream open = context.getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        float f;
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        matrix.setRotate(i, f2, f3);
        float f4 = 0.0f;
        if (i != 90 && i != 270) {
            f = 0.0f;
        } else if (width > height) {
            float f5 = f3 - f2;
            f = 0.0f - f5;
            f4 = f5;
        } else {
            f = f2 - f3;
            f4 = 0.0f - f;
        }
        matrix.postTranslate(f4, f);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        } catch (Exception e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint());
        return bitmap2;
    }
}
