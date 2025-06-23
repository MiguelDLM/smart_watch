package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class o implements SurfaceRenderer {
    public static boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    public int f9668a;
    public int b;
    private aj g;
    private WeakReference<MapSurfaceView> h;
    private WeakReference<MapTextureView> i;
    private c j;
    private int l;
    private int m;
    private int n;
    private int o;
    private Bitmap.Config p;
    private e q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private AppBaseMap e = null;
    private boolean f = false;
    private volatile boolean k = false;
    private long v = 0;
    private boolean w = false;
    private volatile boolean x = false;
    public int c = 0;

    public o(WeakReference<MapSurfaceView> weakReference, aj ajVar) {
        this.g = ajVar;
        this.h = weakReference;
    }

    private boolean c() {
        if (this.e != null && this.f) {
            return true;
        }
        return false;
    }

    public void b() {
        this.x = true;
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onDrawFrame(Object obj) {
        e eVar;
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        if (!c()) {
            return;
        }
        boolean z = true;
        if (!this.w) {
            this.w = true;
            WeakReference<MapSurfaceView> weakReference = this.h;
            if (weakReference != null && (mapSurfaceView2 = weakReference.get()) != null) {
                try {
                    mapSurfaceView2.post(new p(this, mapSurfaceView2));
                } catch (Exception unused) {
                }
            }
        }
        if (d) {
            d = false;
            return;
        }
        if (this.x) {
            return;
        }
        int Draw = this.e.Draw();
        WeakReference<MapSurfaceView> weakReference2 = this.h;
        if (weakReference2 != null && (mapSurfaceView = weakReference2.get()) != null) {
            if (Draw == 1) {
                mapSurfaceView.requestRender();
            } else if (mapSurfaceView.getRenderMode() != 0) {
                mapSurfaceView.setRenderMode(0);
            }
        }
        WeakReference<MapTextureView> weakReference3 = this.i;
        if (weakReference3 != null && (mapTextureView = weakReference3.get()) != null) {
            if (Draw == 1) {
                mapTextureView.requestRender();
            } else if (mapTextureView.getRenderMode() != 0) {
                mapTextureView.setRenderMode(0);
            }
        }
        if (this.k) {
            this.k = false;
            if (this.j != null) {
                a(obj);
            }
        }
        if (!this.r) {
            int i = this.s + 1;
            this.s = i;
            if (i == 2 && (eVar = this.q) != null) {
                eVar.a();
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onDrawFirstFrame");
                }
            }
            if (this.s != 2) {
                z = false;
            }
            this.r = z;
        }
        WeakReference<MapSurfaceView> weakReference4 = this.h;
        if (weakReference4 != null && weakReference4.get() != null && this.h.get().getBaseMap() != null && this.h.get().getBaseMap().h != null) {
            for (ak akVar : this.h.get().getBaseMap().h) {
                if (this.h.get().getBaseMap() == null) {
                    return;
                }
                com.baidu.mapsdkplatform.comapi.map.w K = this.h.get().getBaseMap().K();
                if (akVar != null) {
                    akVar.a((GL10) null, K);
                }
            }
        }
        WeakReference<MapTextureView> weakReference5 = this.i;
        if (weakReference5 != null && weakReference5.get() != null && this.i.get().getBaseMap() != null && this.i.get().getBaseMap().h != null) {
            for (ak akVar2 : this.i.get().getBaseMap().h) {
                if (this.i.get().getBaseMap() == null) {
                    return;
                }
                com.baidu.mapsdkplatform.comapi.map.w K2 = this.i.get().getBaseMap().K();
                if (akVar2 != null) {
                    akVar2.a((GL10) null, K2);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceChanged(int i, int i2) {
        AppBaseMap appBaseMap = this.e;
        if (appBaseMap != null) {
            appBaseMap.renderResize(i, i2);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onSurfaceChanged width = " + i + "; height = " + i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceCreated(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Surface surface;
        this.r = false;
        this.s = 0;
        this.u = 0;
        this.t = 0;
        if (!c()) {
            return;
        }
        if (surfaceHolder != null) {
            surface = surfaceHolder.getSurface();
        } else {
            surface = null;
        }
        this.e.renderInit(i, i2, surface, i3);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onSurfaceCreated ok");
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (surfaceHolder != null) {
            surface = surfaceHolder.getSurface();
        } else {
            surface = null;
        }
        AppBaseMap appBaseMap = this.e;
        if (appBaseMap != null) {
            appBaseMap.surfaceDestroyed(surface);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onSurfaceDestroyed");
        }
    }

    public void a() {
        this.x = false;
    }

    public void a(AppBaseMap appBaseMap) {
        this.e = appBaseMap;
    }

    public void a(boolean z) {
        this.f = z;
    }

    private void a(Object obj) {
        MapTextureView mapTextureView;
        int i;
        int i2;
        MapSurfaceView mapSurfaceView;
        int i3;
        int i4;
        if (this.j == null) {
            return;
        }
        WeakReference<MapSurfaceView> weakReference = this.h;
        if (weakReference != null && (mapSurfaceView = weakReference.get()) != null && (i3 = this.l) > 0 && (i4 = this.m) > 0) {
            com.baidu.platform.comapi.util.j.a(new q(this, mapSurfaceView.captureImageFromSurface(this.n, this.o, i3, i4, obj, this.p)), 0L);
        }
        WeakReference<MapTextureView> weakReference2 = this.i;
        if (weakReference2 == null || (mapTextureView = weakReference2.get()) == null || (i = this.l) <= 0 || (i2 = this.m) <= 0) {
            return;
        }
        com.baidu.platform.comapi.util.j.a(new r(this, mapTextureView.captureImageFromSurface(this.n, this.o, i, i2, obj, this.p)), 0L);
    }

    public o(MapTextureView mapTextureView, aj ajVar) {
        this.i = new WeakReference<>(mapTextureView);
        this.g = ajVar;
    }

    public void a(c cVar, int i, int i2) {
        this.k = true;
        this.j = cVar;
        this.l = i;
        this.m = i2;
        this.p = null;
    }

    public void a(c cVar, int i, int i2, Bitmap.Config config) {
        this.k = true;
        this.j = cVar;
        this.l = i;
        this.m = i2;
        this.p = config;
    }

    public void a(c cVar, int i, int i2, int i3, int i4, Bitmap.Config config) {
        this.k = true;
        this.j = cVar;
        this.n = i;
        this.o = i2;
        this.l = i3;
        this.m = i4;
        this.p = config;
    }

    public void a(e eVar) {
        this.q = eVar;
    }
}
