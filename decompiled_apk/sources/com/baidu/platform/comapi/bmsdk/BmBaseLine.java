package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polyline;

/* loaded from: classes8.dex */
public class BmBaseLine extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    private Polyline f9571a;

    private BmBaseLine() {
        super(7, 0L);
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native boolean nativeSetBloomAlpha(long j, float f);

    private static native boolean nativeSetBloomBlurTimes(long j, int i);

    private static native boolean nativeSetBloomGradientASpeed(long j, float f);

    private static native boolean nativeSetBloomWidth(long j, float f);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionTagId(long j, int i);

    private static native boolean nativeSetEndCapType(long j, int i);

    private static native boolean nativeSetGeoElement(long j, long j2);

    private static native boolean nativeSetJointType(long j, int i);

    private static native boolean nativeSetLineBloomMode(long j, int i);

    private static native boolean nativeSetLineDirectionCrossType(long j, int i);

    private static native boolean nativeSetSmooth(long j, int i);

    private static native boolean nativeSetSmoothFactor(long j, float f);

    private static native boolean nativeSetStartCapType(long j, int i);

    private static native boolean nativeSetThin(long j, int i);

    private static native boolean nativeSetThinFactor(long j, float f);

    public Polyline a() {
        return this.f9571a;
    }

    public boolean b(int i) {
        return nativeSetThin(this.g, i);
    }

    public boolean c(int i) {
        return nativeSetStartCapType(this.g, i);
    }

    public boolean d(int i) {
        return nativeSetEndCapType(this.g, i);
    }

    public boolean e(int i) {
        return nativeSetJointType(this.g, i);
    }

    public boolean f(int i) {
        return nativeSetLineBloomMode(this.g, i);
    }

    public boolean g(int i) {
        return nativeSetBloomBlurTimes(this.g, i);
    }

    public boolean h(int i) {
        return nativeSetLineDirectionCrossType(this.g, i);
    }

    public BmBaseLine(int i, long j) {
        super(i, j);
    }

    public void a(Polyline polyline) {
        this.f9571a = polyline;
    }

    public boolean b(float f) {
        return nativeSetBloomAlpha(this.g, f);
    }

    public boolean c(float f) {
        return nativeSetBloomWidth(this.g, f);
    }

    public boolean d(float f) {
        return nativeSetBloomGradientASpeed(this.g, f);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.g, bmGeoElement.e());
    }

    public boolean a(int i) {
        return nativeSetSmooth(this.g, i);
    }

    public boolean a(float f) {
        return nativeSetThinFactor(this.g, f);
    }
}
