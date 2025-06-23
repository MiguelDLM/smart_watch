package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes8.dex */
public class BmLineStyle extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f9585a;
    private int b;
    private int c;
    private BmBitmapResource d;
    private int e;
    private int f;
    private int i;
    private int j;
    private int k;

    public BmLineStyle() {
        super(51, nativeCreate());
        this.f9585a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j, long j2);

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetLineResId(long j, int i);

    private static native boolean nativeSetLineType(long j, int i);

    private static native boolean nativeSetStrokeColor(long j, int i);

    private static native boolean nativeSetStrokeWidth(long j, int i);

    private static native boolean nativeSetTextureOption(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    public boolean a(int i) {
        this.c = i;
        return nativeSetColor(this.g, a.a(i));
    }

    public boolean b(int i) {
        int i2 = i / 2;
        this.e = i2;
        return nativeSetWidth(this.g, i2);
    }

    public boolean c(int i) {
        this.j = i;
        return nativeSetTextureOption(this.g, i);
    }

    public boolean d(int i) {
        this.k = i;
        return nativeSetLineType(this.g, i);
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.d = bmBitmapResource;
        this.b = 0;
        this.f9585a = 0;
        return nativeSetBitmapResource(this.g, bmBitmapResource.e());
    }
}
