package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* loaded from: classes8.dex */
public abstract class BmDrawItem extends BmObject {
    protected int b;
    protected float c;
    protected String d;
    short e;
    protected BmAnimation f;

    private BmDrawItem() {
        super(2, 0L);
        this.b = 1;
        this.c = 1.0f;
        this.d = "";
        this.f = null;
    }

    private static native boolean nativeSetAnimation(long j, long j2);

    private static native boolean nativeSetClickable(long j, boolean z);

    private static native boolean nativeSetHoleClickable(long j, boolean z);

    private static native boolean nativeSetOpacity(long j, float f);

    private static native boolean nativeSetShowLevel(long j, int i, int i2);

    private static native boolean nativeSetVisibility(long j, int i);

    public void a(short s) {
        this.e = s;
    }

    public boolean b(boolean z) {
        return nativeSetClickable(this.g, z);
    }

    public short c() {
        return this.e;
    }

    public boolean i(int i) {
        this.b = i;
        return nativeSetVisibility(this.g, i);
    }

    public boolean c(boolean z) {
        return nativeSetHoleClickable(this.g, z);
    }

    public BmDrawItem(int i, long j) {
        super(i, j);
        this.b = 1;
        this.c = 1.0f;
        this.d = "";
        this.f = null;
    }
}
