package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class BitmapKt {
    @OXOo.OOXIXo
    public static final Bitmap applyCanvas(@OXOo.OOXIXo Bitmap bitmap, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        oooxoxo.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@OXOo.OOXIXo Bitmap bitmap, @OXOo.OOXIXo Point point) {
        int i;
        int width = bitmap.getWidth();
        int i2 = point.x;
        return i2 >= 0 && i2 < width && (i = point.y) >= 0 && i < bitmap.getHeight();
    }

    @OXOo.OOXIXo
    public static final Bitmap createBitmap(int i, int i2, @OXOo.OOXIXo Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public static final int get(@OXOo.OOXIXo Bitmap bitmap, int i, int i2) {
        return bitmap.getPixel(i, i2);
    }

    @OXOo.OOXIXo
    public static final Bitmap scale(@OXOo.OOXIXo Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    public static final void set(@OXOo.OOXIXo Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(@OXOo.OOXIXo Bitmap bitmap, @OXOo.OOXIXo PointF pointF) {
        float f = pointF.x;
        if (f >= 0.0f && f < bitmap.getWidth()) {
            float f2 = pointF.y;
            if (f2 >= 0.0f && f2 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i, int i2, @OXOo.OOXIXo Bitmap.Config config, boolean z, @OXOo.OOXIXo ColorSpace colorSpace) {
        Bitmap createBitmap;
        createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        Bitmap createBitmap;
        ColorSpace.Named named;
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
        }
        createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        return createBitmap;
    }
}
