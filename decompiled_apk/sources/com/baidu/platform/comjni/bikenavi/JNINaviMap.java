package com.baidu.platform.comjni.bikenavi;

/* loaded from: classes8.dex */
public class JNINaviMap {
    public native boolean convertGeoPoint2ScrPt(long j, int[] iArr, int[] iArr2);

    public native boolean convertGeoPoint2ScrPt4Ar(long j, int[] iArr, int[] iArr2);

    public native boolean convertScrPt2GeoPoint(long j, int[] iArr, int[] iArr2);

    public native void dragMap(long j, int i, int i2, int i3, int i4, long j2, long j3);

    public native float getRouteDirection(long j);

    public native boolean move2ScreenPoint(long j, int i, int i2, int i3);

    public native boolean resetBackgroundColor(long j);

    public native boolean resetMapStatusLimits(long j);

    public native boolean setArMapStatusLimits(long j);

    public native boolean setBackgroundTransparent(long j);

    public native boolean setLevel(long j, float f);

    public native boolean showBaseLayers(long j, boolean z);

    public native boolean showLayer(long j, int i, boolean z);

    public native boolean updataBaseLayers(long j);

    public native boolean updateLayer(long j, int i);
}
