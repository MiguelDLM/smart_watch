package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polygon;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* loaded from: classes8.dex */
public class BmPolygon extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    private Polygon f9578a;
    private long i;

    public BmPolygon() {
        super(10, nativeCreate());
        this.i = -1L;
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeAddHoleGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j, boolean z);

    private static native boolean nativeSetJointType(long j, int i);

    private static native boolean nativeSetSurfaceStyle(long j, long j2);

    private static native boolean nativeSetThin(long j, int i);

    private static native boolean nativeSetThinFactor(long j, float f);

    public Polygon a() {
        return this.f9578a;
    }

    public long b() {
        return this.i;
    }

    public void a(Polygon polygon) {
        this.f9578a = polygon;
    }

    public boolean b(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.g, bmGeoElement.e());
    }

    public void a(long j) {
        this.i = j;
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.g, bmGeoElement.e());
    }

    public boolean a(int i) {
        return nativeSetJointType(this.g, i);
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.g, bmSurfaceStyle.g);
        } else {
            nativeSetSurfaceStyle(this.g, 0L);
        }
    }
}
