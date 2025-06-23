package com.baidu.ar.marker;

/* loaded from: classes7.dex */
public interface IMarkerDataProvider {
    float[] getGPS();

    float[] getGravityDirection();

    String getSessionId();

    String getUserId();

    String getVersion();

    void queryFrameResult(int i, String str);

    void setLocationData(boolean z, Object obj);

    void setLocationPoints(int i, double[] dArr);

    void setLocationTransforms(float[] fArr);

    void setVpasState(int i, int i2, float f);

    void setVpsLocation(float f, float f2);

    void transDataFromJNI(byte[] bArr);
}
