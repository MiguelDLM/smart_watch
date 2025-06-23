package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f8534a;

    private b() {
    }

    public static void i() {
        if (f8534a != null) {
            synchronized (b.class) {
                try {
                    if (f8534a != null) {
                        f8534a.j();
                    }
                } finally {
                }
            }
        }
    }

    private void j() {
    }

    public static b k() {
        if (f8534a == null) {
            synchronized (b.class) {
                try {
                    if (f8534a == null) {
                        f8534a = new b();
                    }
                } finally {
                }
            }
        }
        return f8534a;
    }

    public void a(com.baidu.navisdk.comapi.base.b bVar) {
        BNMapController.getInstance().addObserver(bVar);
    }

    public void b(com.baidu.navisdk.comapi.base.b bVar) {
        BNMapController.getInstance().deleteObserver(bVar);
    }

    public com.baidu.nplatform.comapi.basestruct.b c() {
        return BNMapController.getInstance().getMapStatus();
    }

    public int d() {
        return 21;
    }

    public int e() {
        return 4;
    }

    public int f() {
        return BNMapController.getInstance().getZoomLevel();
    }

    public boolean g() {
        return BNMapController.getInstance().zoomIn();
    }

    public boolean h() {
        return BNMapController.getInstance().zoomOut();
    }

    public void a(boolean z, boolean z2) {
        BNMapController.getInstance().setDrawHouse(z, z2);
    }

    public void b() {
        BNMapController.getInstance().deleteAllObserver();
    }

    public boolean a(int i) {
        return BNMapController.getInstance().updateLayer(i);
    }

    public boolean a() {
        return BNMapController.getInstance().UpdataBaseLayers();
    }

    public void a(boolean z) {
        BNMapController.getInstance().enableTouchEventLookover(z);
    }

    public boolean a(int i, boolean z) {
        return BNMapController.getInstance().showLayer(i, z);
    }
}
