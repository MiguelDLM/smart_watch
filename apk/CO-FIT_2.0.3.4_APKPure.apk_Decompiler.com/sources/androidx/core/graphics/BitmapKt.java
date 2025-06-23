package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.oXIO0o0XI;

public final class BitmapKt {
    @OOXIXo
    public static final Bitmap applyCanvas(@OOXIXo Bitmap bitmap, @OOXIXo oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        oooxoxo.invoke(new Canvas(bitmap));
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r3.y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean contains(@OXOo.OOXIXo android.graphics.Bitmap r2, @OXOo.OOXIXo android.graphics.Point r3) {
        /*
            int r0 = r2.getWidth()
            int r1 = r3.x
            if (r1 < 0) goto L_0x0016
            if (r1 >= r0) goto L_0x0016
            int r3 = r3.y
            if (r3 < 0) goto L_0x0016
            int r2 = r2.getHeight()
            if (r3 >= r2) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapKt.contains(android.graphics.Bitmap, android.graphics.Point):boolean");
    }

    @OOXIXo
    public static final Bitmap createBitmap(int i, int i2, @OOXIXo Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public static final int get(@OOXIXo Bitmap bitmap, int i, int i2) {
        return bitmap.getPixel(i, i2);
    }

    @OOXIXo
    public static final Bitmap scale(@OOXIXo Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    public static final void set(@OOXIXo Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(@OOXIXo Bitmap bitmap, @OOXIXo PointF pointF) {
        float f = pointF.x;
        if (f >= 0.0f && f < ((float) bitmap.getWidth())) {
            float f2 = pointF.y;
            return f2 >= 0.0f && f2 < ((float) bitmap.getHeight());
        }
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @OOXIXo
    public static final Bitmap createBitmap(int i, int i2, @OOXIXo Bitmap.Config config, boolean z, @OOXIXo ColorSpace colorSpace) {
        return Bitmap.createBitmap(i, i2, config, z, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i, i2, config, z, colorSpace);
    }
}
