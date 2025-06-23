package com.baidu.nplatform.comjni.tools;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class JNITools {
    public static native Bundle Bd09llToGcj02(double d, double d2);

    public static native Bundle Bd09mcToGcj02(int i, int i2);

    public static native Bundle Gcj02ToBd09mc(double d, double d2);

    public static native Bundle Gcj02ToWgs84(double d, double d2);

    public static native void GetDistanceByMC(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native Bundle Wgs84ToGcj02(double d, double d2);
}
