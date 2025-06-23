package com.baidu.platform.comapi.bmsdk.ui;

/* loaded from: classes8.dex */
public class BmImageUI extends BmBaseUI {
    public BmImageUI() {
        super(34, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetDrawableResource(long j, long j2);

    private static native boolean nativeSetMaskResource(long j, long j2);
}
