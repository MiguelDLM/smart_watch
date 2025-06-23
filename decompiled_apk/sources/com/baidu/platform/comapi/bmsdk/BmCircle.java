package com.baidu.platform.comapi.bmsdk;

import XIXIX.OOXIXo;
import com.baidu.mapapi.map.Circle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class BmCircle extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    long f9573a;
    private Circle i;

    public BmCircle() {
        super(11, nativeCreate());
        this.f9573a = -1L;
    }

    private static native boolean nativeAddHoleGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native boolean nativeClearGradientColors(long j);

    private static native long nativeCreate();

    private static native boolean nativeDelGradientColors(long j, int i);

    private static native boolean nativeSetCenter(long j, double d, double d2, double d3);

    private static native boolean nativeSetGradientColorWeight(long j, float f);

    private static native boolean nativeSetGradientColors(long j, int i, int[] iArr, int i2);

    private static native boolean nativeSetGradientRadiusWeight(long j, float f);

    private static native boolean nativeSetIsGradientCircle(long j, boolean z);

    private static native boolean nativeSetLineStyle(long j, long j2);

    private static native boolean nativeSetPixelRadius(long j, int i);

    private static native boolean nativeSetRadius(long j, double d);

    private static native boolean nativeSetSurfaceStyle(long j, long j2);

    private static native boolean nativeSetTrackBy(long j, int i);

    public Circle a() {
        return this.i;
    }

    public long b() {
        return this.f9573a;
    }

    public void a(Circle circle) {
        this.i = circle;
    }

    public boolean b(float f) {
        return nativeSetGradientColorWeight(this.g, f);
    }

    public void a(long j) {
        this.f9573a = j;
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.g, bVar.f9581a, bVar.b, OOXIXo.f3760XO);
    }

    public boolean a(double d) {
        return nativeSetRadius(this.g, d);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.g, bmLineStyle.g);
        } else {
            nativeSetLineStyle(this.g, 0L);
        }
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.g, bmSurfaceStyle.g);
        } else {
            nativeSetSurfaceStyle(this.g, 0L);
        }
    }

    public boolean a(int i, List<Integer> list) {
        int[] iArr;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            iArr = null;
        } else {
            iArr = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iArr[i2] = com.baidu.platform.comapi.bmsdk.style.a.a(it.next().intValue());
                i2++;
            }
        }
        return nativeSetGradientColors(this.g, i, iArr, i2);
    }

    public boolean a(boolean z) {
        return nativeSetIsGradientCircle(this.g, z);
    }

    public boolean a(float f) {
        return nativeSetGradientRadiusWeight(this.g, f);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.g, bmGeoElement.e());
    }
}
