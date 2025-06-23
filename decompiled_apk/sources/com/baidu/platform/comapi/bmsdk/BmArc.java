package com.baidu.platform.comapi.bmsdk;

import XIXIX.OOXIXo;
import com.baidu.mapapi.map.Arc;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* loaded from: classes8.dex */
public class BmArc extends BmDrawItem {

    /* renamed from: a, reason: collision with root package name */
    private Arc f9570a;

    public BmArc() {
        super(12, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetCenter(long j, double d, double d2, double d3);

    private static native boolean nativeSetClockwise(long j, boolean z);

    private static native boolean nativeSetEndRadian(long j, double d);

    private static native boolean nativeSetLineStyle(long j, long j2);

    private static native boolean nativeSetPixelRadius(long j, int i);

    private static native boolean nativeSetRadius(long j, double d);

    private static native boolean nativeSetStartRadian(long j, double d);

    private static native boolean nativeSetTrackBy(long j, int i);

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.g, bVar.f9581a, bVar.b, OOXIXo.f3760XO);
    }

    public boolean b(double d) {
        return nativeSetStartRadian(this.g, d);
    }

    public boolean c(double d) {
        return nativeSetEndRadian(this.g, d);
    }

    public Arc a() {
        return this.f9570a;
    }

    public void a(Arc arc) {
        this.f9570a = arc;
    }

    public boolean a(double d) {
        return nativeSetRadius(this.g, d);
    }

    public boolean a(boolean z) {
        return nativeSetClockwise(this.g, z);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.g, bmLineStyle.g);
        } else {
            nativeSetLineStyle(this.g, 0L);
        }
    }
}
