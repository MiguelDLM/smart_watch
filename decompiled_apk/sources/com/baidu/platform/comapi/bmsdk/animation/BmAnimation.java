package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class BmAnimation extends BmObject {
    private static Object e = new Object();
    private static List<WeakReference<BmAnimation>> f = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    int f9580a;
    int b;
    int c;
    private String d;

    private BmAnimation() {
        super(80, 0L);
        this.f9580a = 0;
        this.b = 0;
        this.c = 1;
        this.d = "";
    }

    private static native boolean nativeCancel(long j);

    private static native boolean nativeReset(long j);

    private static native boolean nativeSetDuration(long j, long j2);

    private static native boolean nativeSetFillMode(long j, int i);

    private static native boolean nativeSetInterpolator(long j, long j2);

    private static native boolean nativeSetListener(long j, boolean z);

    private static native boolean nativeSetRepeatCount(long j, int i);

    private static native boolean nativeSetRepeatMode(long j, int i);

    private static native boolean nativeSetStartDelay(long j, long j2);

    private static native boolean nativeSetStartTime(long j, long j2);

    public BmAnimation(int i, long j) {
        super(i, j);
        this.f9580a = 0;
        this.b = 0;
        this.c = 1;
        this.d = "";
    }
}
