package com.baidu.platform.comapi.wnplatform.walkmap;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private e b;
    private a c = null;
    private MapView d = null;

    /* renamed from: a, reason: collision with root package name */
    public boolean f9974a = false;
    private boolean e = true;
    private Bitmap f = null;
    private BitmapDescriptor g = null;

    public d() {
        this.b = null;
        this.b = new e();
    }

    public MapView a() {
        MapView mapView = this.d;
        if (mapView == null) {
            return null;
        }
        return mapView;
    }

    public void b(boolean z) {
    }

    public boolean c() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public boolean d() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public boolean e() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.d();
        }
        return false;
    }

    public void f() {
        GeoPoint e = com.baidu.platform.comapi.walknavi.b.a().K().e();
        MapStatus h = com.baidu.platform.comapi.walknavi.b.a().N().h();
        if (h != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h);
            builder.overlook(0.0f);
            if (e.getLongitudeE6() != OOXIXo.f3760XO && e.getLatitudeE6() != OOXIXo.f3760XO) {
                builder.target(com.baidu.platform.comapi.wnplatform.p.f.a(e));
                a(builder.build());
            }
        }
    }

    public float g() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.e();
        }
        return -1.0f;
    }

    public MapStatus h() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public MapStatus i() {
        MapStatus h = com.baidu.platform.comapi.walknavi.b.a().N().h();
        if (h != null) {
            WinRound winRound = h.winRound;
            int i = winRound.left;
            int i2 = winRound.right;
            Math.abs(winRound.bottom + winRound.top);
            WinRound winRound2 = h.winRound;
            int i3 = (winRound2.right + winRound2.left) / 2;
            int abs = (int) (OOXIXo.f3760XO - ((Math.abs(winRound2.bottom - winRound2.top) * 1.5d) / 10.0d));
            WinRound winRound3 = h.winRound;
            return new MapStatus.Builder(h).targetScreen(new Point(i3, ((winRound3.top + winRound3.bottom) / 2) - abs)).build();
        }
        return h;
    }

    public float j() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.d();
        }
        return 3.0f;
    }

    public void k() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e();
        }
    }

    public boolean l() {
        return this.e;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        a(0);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(0);
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
            this.b = null;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
            this.c = null;
        }
    }

    public void a(Context context, MapView mapView) {
        this.d = mapView;
        a aVar = this.c;
        if (aVar == null) {
            this.c = new a(mapView);
        } else {
            aVar.a(mapView);
        }
        this.c.a(false);
    }

    public void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    public boolean a(boolean z) {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.a(z);
        }
        return false;
    }

    public void a(int i) {
        e eVar = this.b;
        if (eVar == null) {
            return;
        }
        if (i == 0) {
            eVar.b(0);
            this.b.b(1);
            this.b.b(2);
            this.b.b(5);
            this.b.b(6);
            this.b.b(9);
            this.b.b(10);
            return;
        }
        if (i != 1) {
            return;
        }
        if (com.baidu.platform.comapi.walknavi.b.a().N().f9974a) {
            this.b.a(0);
            return;
        }
        this.b.a(0);
        this.b.a(1);
        this.b.a(2);
        if (com.baidu.platform.comapi.wnplatform.f.a().g()) {
            this.b.b(5);
        } else if (com.baidu.platform.comapi.wnplatform.f.a().h()) {
            this.b.a(5);
        }
        this.b.a(6);
    }

    public boolean a(int[] iArr, int[] iArr2) {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.a(iArr, iArr2);
        }
        return false;
    }

    public void a(MapStatus mapStatus) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(com.baidu.platform.comapi.wnplatform.p.f.a(mapStatus));
        }
    }

    public void a(MapStatus mapStatus, int i) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(mapStatus, i);
        }
    }

    public void a(int i, int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }

    public float a(MapBound mapBound, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.ptLB.getIntX());
        bundle.putInt("bottom", mapBound.ptLB.getIntY());
        bundle.putInt("right", mapBound.ptRT.getIntX());
        bundle.putInt("top", mapBound.ptRT.getIntY());
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(bundle, i, i2);
        }
        return 15.0f;
    }

    public void a(f fVar) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(fVar);
        }
    }
}
