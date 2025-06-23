package com.baidu.mapsdkplatform.comjni.tools;

/* loaded from: classes7.dex */
public class JNITools {
    public static native boolean CoordinateEncryptEx(float f, float f2, String str, Object obj);

    public static native boolean CoordinateEncryptMc(float f, float f2, Object obj);

    public static native void GetDistanceByMC(Object obj);

    public static native String GetToken();

    public static native boolean TransGeoStr2ComplexPt(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native void TransNodeStr2Pt(Object obj);

    public static native double[] baiduToGcj(double d, double d2);

    public static native double[] gcjToBaidu(double d, double d2);

    public static native String getAESSaltKey(String str);

    public static native String getAESViKey(String str);

    public static native String getProjectionPt(String str);

    public static native int initClass(Object obj, int i);

    public static native void openLogEnable(boolean z, int i);

    public static native double[] wgsToBaidu(double d, double d2);
}
