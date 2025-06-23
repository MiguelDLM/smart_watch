package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes8.dex */
public class BmIconMarker extends BmBaseMarker {

    /* renamed from: a, reason: collision with root package name */
    private int f9575a;

    public BmIconMarker() {
        super(4, nativeCreate());
        this.f9575a = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetDrawableResource(long j, long j2);
}
