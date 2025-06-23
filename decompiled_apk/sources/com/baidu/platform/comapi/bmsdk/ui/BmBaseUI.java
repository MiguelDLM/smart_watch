package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes8.dex */
public abstract class BmBaseUI extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f9589a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;

    private BmBaseUI() {
        super(31, 0L);
        this.f9589a = 1;
        this.b = "";
        this.c = "";
        this.d = false;
        this.e = false;
    }

    private static native boolean nativeSetAlignParent(long j, int i);

    private static native boolean nativeSetBackground(long j, long j2);

    private static native boolean nativeSetBackgroundColor(long j, int i);

    private static native boolean nativeSetBackgroundResId(long j, int i);

    private static native boolean nativeSetBkColorOfLeft(long j, int i);

    private static native boolean nativeSetBkColorOfRight(long j, int i);

    private static native boolean nativeSetClickable(long j, boolean z);

    private static native boolean nativeSetGravity(long j, int i);

    private static native boolean nativeSetHeight(long j, int i);

    private static native boolean nativeSetLayoutWeight(long j, int i);

    private static native boolean nativeSetMargin(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetPadding(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetVisibility(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    public BmBaseUI a(long j) {
        if (this.g == j) {
            return this;
        }
        return null;
    }

    public BmBaseUI(int i, long j) {
        super(i, j);
        this.f9589a = 1;
        this.b = "";
        this.c = "";
        this.d = false;
        this.e = false;
    }
}
