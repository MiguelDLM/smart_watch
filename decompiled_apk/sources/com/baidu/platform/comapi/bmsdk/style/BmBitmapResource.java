package com.baidu.platform.comapi.bmsdk.style;

import android.graphics.Bitmap;
import android.graphics.NinePatch;

/* loaded from: classes8.dex */
public class BmBitmapResource extends BmDrawableResource {
    private BmBitmapResource() {
        super(56, nativeCreate());
    }

    private void a(Bitmap bitmap, boolean z) {
        b a2;
        if (bitmap != null) {
            nativeSetBitmap(this.g, bitmap, hashCode(), bitmap.hashCode(), z);
            if (bitmap.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) || (a2 = b.a(bitmap.getNinePatchChunk())) == null) {
                return;
            }
            int i = a2.f9588a[0];
            int width = bitmap.getWidth();
            int[] iArr = a2.f9588a;
            a(a2.b, a2.c, new int[]{i, width - iArr[1], iArr[2], bitmap.getHeight() - a2.f9588a[3]});
        }
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmap(long j, Bitmap bitmap, int i, int i2, boolean z);

    private static native boolean nativeSetFillArea(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetScaleX(long j, int[] iArr, int i);

    private static native boolean nativeSetScaleY(long j, int[] iArr, int i);

    public BmBitmapResource(Bitmap bitmap) {
        super(56, nativeCreate());
        a(bitmap, false);
    }

    private void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (iArr != null && iArr.length > 0) {
            nativeSetScaleX(this.g, iArr, iArr.length);
        }
        if (iArr2 != null && iArr2.length > 0) {
            nativeSetScaleY(this.g, iArr2, iArr2.length);
        }
        if (iArr3 == null || iArr3.length != 4) {
            return;
        }
        nativeSetFillArea(this.g, iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
    }
}
