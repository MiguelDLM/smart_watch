package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes8.dex */
public class Bm3DModelGroup extends BmDrawItem {
    private Bm3DModelGroup() {
        super(21, nativeCreate());
    }

    private static native boolean nativeAddNode3D(long j, double[] dArr, int i);

    private static native boolean nativeClear3DNode(long j);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long j, String str, int i);

    private static native boolean nativeSetLightBreathLevel(long j, int i, int i2);

    private static native boolean nativeSetLightEnable(long j, int i);

    private static native boolean nativeSetScaleByLevel(long j, boolean z);
}
