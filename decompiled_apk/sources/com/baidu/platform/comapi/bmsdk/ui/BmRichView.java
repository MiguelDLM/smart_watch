package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* loaded from: classes8.dex */
public class BmRichView extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f9592a;
    private int b;
    private BmAnimation c;
    private float d;
    private float e;
    private float f;
    private String i;
    private BmBaseUI j;

    public BmRichView() {
        super(30, nativeCreate());
        this.f9592a = 1;
        this.b = 2;
        this.c = null;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 1.0f;
        this.i = "";
        this.j = null;
    }

    private static native boolean nativeAddRichUIOption(long j, long j2);

    private static native boolean nativeBuildRichViewByString(String str);

    private static native boolean nativeBuildRichViewByTemplete(String str);

    private static native long nativeCreate();

    private static native boolean nativeDelRichUIOption(long j, long j2);

    private static native boolean nativeSetAnimation(long j, long j2);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionBorder(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetCollisionLineTagId(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, short s);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j, boolean z);

    private static native boolean nativeSetLocated(long j, int i);

    private static native boolean nativeSetOffsetX(long j, int i, int i2);

    private static native boolean nativeSetOffsetY(long j, int i, int i2);

    private static native boolean nativeSetOpacity(long j, float f);

    private static native boolean nativeSetScale(long j, float f);

    private static native boolean nativeSetScaleX(long j, float f);

    private static native boolean nativeSetScaleY(long j, float f);

    private static native boolean nativeSetShowLevel(long j, int i, int i2);

    private static native boolean nativeSetView(long j, long j2);

    private static native boolean nativeSetVisibility(long j, int i);

    public BmBaseUI a(long j) {
        BmBaseUI bmBaseUI = this.j;
        if (bmBaseUI != null) {
            return bmBaseUI.a(j);
        }
        return null;
    }
}
