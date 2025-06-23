package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class f {
    private static final String e = "f";

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.model.datastruct.g f9325a = null;
    private long b = 0;
    protected boolean c = false;
    private List<com.baidu.navisdk.comapi.geolocate.b> d = new ArrayList();

    private void j() {
        com.baidu.navisdk.model.a.g().a(this.f9325a);
    }

    public void a(com.baidu.navisdk.comapi.geolocate.b bVar) {
        if (bVar != null) {
            synchronized (this.d) {
                try {
                    if (!this.d.contains(bVar)) {
                        this.d.add(bVar);
                        bVar.onGpsStatusChange(g(), f());
                    }
                } finally {
                }
            }
        }
    }

    public void b(com.baidu.navisdk.comapi.geolocate.b bVar) {
        synchronized (this.d) {
            this.d.remove(bVar);
        }
    }

    public com.baidu.navisdk.model.datastruct.g c() {
        return this.f9325a;
    }

    public GeoPoint d() {
        if (this.f9325a != null) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLongitudeE6((int) (this.f9325a.b * 100000.0d));
            geoPoint.setLatitudeE6((int) (this.f9325a.f6926a * 100000.0d));
            return geoPoint;
        }
        return null;
    }

    public long e() {
        return this.b;
    }

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public synchronized void i() {
        LogUtil.e(e, "stopNaviLocate");
        this.c = false;
    }

    public RoutePlanNode b() {
        GeoPoint d = d();
        if (d != null) {
            return new RoutePlanNode(d, 3, null, null);
        }
        return null;
    }

    public com.baidu.navisdk.model.datastruct.g a() {
        return this.f9325a;
    }

    public synchronized boolean a(Context context) {
        LogUtil.e(e, "startNaviLocate");
        this.c = true;
        return true;
    }

    public void a(boolean z, boolean z2) {
        synchronized (this.d) {
            try {
                for (com.baidu.navisdk.comapi.geolocate.b bVar : this.d) {
                    if (bVar != null) {
                        bVar.onGpsStatusChange(z, z2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(com.baidu.navisdk.model.datastruct.g gVar) {
        if (gVar != null) {
            this.f9325a = gVar;
            this.b = System.currentTimeMillis();
            j();
            synchronized (this.d) {
                try {
                    for (com.baidu.navisdk.comapi.geolocate.b bVar : this.d) {
                        if (bVar != null) {
                            bVar.onLocationChange(this.f9325a);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void a(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        if (gVar == null && gVar2 == null) {
            return;
        }
        synchronized (this.d) {
            try {
                for (com.baidu.navisdk.comapi.geolocate.b bVar : this.d) {
                    if (bVar != null) {
                        bVar.onWGS84LocationChange(gVar, gVar2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
