package com.sma.smartv3.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.view.View;

/* loaded from: classes12.dex */
public class OxxIIOOXO {
    public static Bitmap oIX0oI(View view, int width, int height) {
        view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        view.draw(canvas);
        return createBitmap;
    }
}
