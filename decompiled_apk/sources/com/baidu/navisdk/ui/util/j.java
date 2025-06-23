package com.baidu.navisdk.ui.util;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class j {
    public static void a(ImageView imageView) {
        if (imageView != null) {
            try {
                imageView.setImageBitmap(null);
                imageView.setBackgroundResource(R.color.transparent);
                imageView.setBackgroundDrawable(null);
            } catch (Exception e) {
                LogUtil.e("UIUtils", "releaseImageView Exception :" + e.getMessage());
            }
        }
    }

    public static void b(ImageView imageView) {
        if (imageView != null) {
            try {
                imageView.setImageBitmap(null);
                imageView.setBackgroundResource(R.color.transparent);
                imageView.setBackgroundDrawable(null);
            } catch (Exception e) {
                LogUtil.e("UIUtils", "releaseImageView Exception :" + e.getMessage());
            }
        }
    }

    public static boolean a(TextView textView, int i, String str, int i2) {
        if (i >= 0) {
            return new DynamicLayout(str, textView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding()).getLineCount() <= i2;
        }
        LogUtil.e("UiUtil", "isTextFullDisplay viewWidth < 0");
        LogUtil.printCallStack();
        return true;
    }

    public static boolean a(TextView textView, int i, String str) {
        return ((float) i) >= textView.getPaint().measureText(str);
    }

    public static int a(TextView textView, String str) {
        TextPaint paint = textView.getPaint();
        if (paint == null) {
            return -1;
        }
        return (int) paint.measureText(str);
    }

    public static Drawable a(Drawable drawable, float f) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap a2 = a(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return new BitmapDrawable((Resources) null, Bitmap.createBitmap(a2, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }
}
