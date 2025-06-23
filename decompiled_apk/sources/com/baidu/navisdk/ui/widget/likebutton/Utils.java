package com.baidu.navisdk.ui.widget.likebutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.TypedValue;

/* loaded from: classes8.dex */
public class Utils {
    public static double clamp(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    public static float dipToPixels(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static Bitmap getBitmap(Drawable drawable, int i, int i2) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof VectorDrawable) {
            return getBitmap((VectorDrawable) drawable, i, i2);
        }
        throw new IllegalArgumentException("Unsupported drawable type");
    }

    public static double mapValueFromRangeToRange(double d, double d2, double d3, double d4, double d5) {
        return d4 + (((d - d2) / (d3 - d2)) * (d5 - d4));
    }

    public static Drawable resizeDrawable(Context context, Drawable drawable, int i, int i2) {
        return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(getBitmap(drawable, i, i2), i, i2, true));
    }

    @TargetApi(21)
    private static Bitmap getBitmap(VectorDrawable vectorDrawable, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return createBitmap;
    }
}
