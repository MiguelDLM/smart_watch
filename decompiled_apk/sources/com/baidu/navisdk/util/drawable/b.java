package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.m0;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9262a = false;
    public static com.baidu.navisdk.util.cache.a b;
    private static final String c = m0.j().b() + "/ImageCache/ugcurliview";

    private static synchronized void a() {
        synchronized (b.class) {
            try {
                if (!f9262a) {
                    b = new com.baidu.navisdk.util.cache.a(c, 80);
                }
                f9262a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Drawable a(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        float width = i / bitmap.getWidth();
        float height = i2 / bitmap.getHeight();
        if (z) {
            if (height < width) {
                width = height;
            } else {
                height = width;
            }
        }
        matrix.postScale(width, height);
        try {
            return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
        } catch (Throwable th) {
            th.printStackTrace();
            return new BitmapDrawable(bitmap);
        }
    }

    public static void a(String str, ImageView imageView, boolean z) {
        if (imageView == null || str == null) {
            return;
        }
        a();
        Bitmap c2 = b.c(str);
        if (z) {
            imageView.setImageDrawable(a(c2, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), true));
        } else {
            imageView.setBackgroundDrawable(new BitmapDrawable(c2));
        }
    }
}
