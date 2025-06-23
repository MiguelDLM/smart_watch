package com.baidu.platform.comapi.bmsdk.style;

/* loaded from: classes8.dex */
public class BmFrameResource extends BmDrawableResource {
    private BmFrameResource() {
        super(57, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResources(long j, long[] jArr, int i, int[] iArr, int i2, int i3);

    private static native boolean nativeSetResIds(long j, int[] iArr, int i, int[] iArr2, int i2, int i3);
}
