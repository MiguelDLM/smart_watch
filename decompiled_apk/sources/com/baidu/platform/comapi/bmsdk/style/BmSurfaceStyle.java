package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes8.dex */
public class BmSurfaceStyle extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f9586a;
    private int b;
    private BmBitmapResource c;

    public BmSurfaceStyle() {
        super(53, nativeCreate());
        this.f9586a = 0;
        this.b = 0;
        this.c = null;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j, long j2);

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    public boolean a(int i) {
        this.b = i;
        return nativeSetColor(this.g, a.a(i));
    }
}
