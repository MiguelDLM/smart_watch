package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.platform.comjni.bikenavi.JNINaviMap;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private JNINaviMap f9975a;

    public e() {
        this.f9975a = null;
        this.f9975a = new JNINaviMap();
    }

    private long f() {
        return com.baidu.platform.comapi.walknavi.b.a().I().c();
    }

    public void a() {
        this.f9975a = null;
    }

    public boolean b(int i) {
        return this.f9975a.showLayer(f(), i, false);
    }

    public boolean c() {
        return this.f9975a.resetBackgroundColor(f());
    }

    public boolean d() {
        return this.f9975a.resetMapStatusLimits(f());
    }

    public float e() {
        return this.f9975a.getRouteDirection(f());
    }

    public boolean a(int i) {
        return this.f9975a.showLayer(f(), i, true);
    }

    public boolean b() {
        return this.f9975a.updataBaseLayers(f());
    }

    public boolean a(boolean z) {
        return this.f9975a.showBaseLayers(f(), z);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        return this.f9975a.convertScrPt2GeoPoint(f(), iArr, iArr2);
    }
}
