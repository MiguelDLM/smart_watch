package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes8.dex */
public class BmCoordChainHandle extends BmObject {
    public BmCoordChainHandle() {
        super(71, nativeCreate());
    }

    private static native long nativeCreate();

    private static native int[] nativeGetIndexs(long j);

    private static native double[] nativeGetP0Points(long j);

    private static native boolean nativeHandle(long j, double[] dArr, int i, int i2);

    private static native boolean nativeSetCoordAlgorithm(long j, int i);

    private static native boolean nativeSetCoordChainType(long j, int i);

    private static native boolean nativeSetThreshold(long j, double d);
}
