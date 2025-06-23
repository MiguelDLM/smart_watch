package com.jd.ad.sdk.jad_hu;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes10.dex */
public class jad_hu {
    public static Bitmap jad_an(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return null;
    }
}
