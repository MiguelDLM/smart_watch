package com.baidu.platform.comapi.map.b.a;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.ak;
import com.baidu.platform.comapi.map.b.a;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f9641a = 0;
    private boolean b = false;
    private a.C0527a c;
    private MapController d;
    private InterfaceC0528a e;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0528a {
        boolean a(a aVar);
    }

    public a(InterfaceC0528a interfaceC0528a, MapController mapController) {
        this.e = interfaceC0528a;
        this.d = mapController;
    }

    private void b(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (motionEvent.getPointerCount() == 2 && this.c != null) {
            a.C0527a a2 = a.C0527a.a(motionEvent);
            a.C0527a c0527a = new a.C0527a(this.c.f9642a, a2.f9642a);
            a.C0527a c0527a2 = new a.C0527a(this.c.b, a2.b);
            if (Math.abs(c0527a.b()) < 20.0d && Math.abs(c0527a2.b()) < 20.0d) {
                z = true;
            } else {
                z = false;
            }
            if (System.currentTimeMillis() - this.f9641a < 200) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.d != null) {
                float x = motionEvent.getX(1) - motionEvent.getX(0);
                float y = motionEvent.getY(1) - motionEvent.getY();
                Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
                this.d.getMapView();
                if (z && z2 && this.b) {
                    List<ak> listeners = this.d.getListeners();
                    w mapStatusInner = this.d.getMapStatusInner();
                    if (listeners != null) {
                        for (int i = 0; i < listeners.size(); i++) {
                            ak akVar = listeners.get(i);
                            if (akVar != null && akVar.d(point, point2, mapStatusInner)) {
                                return;
                            }
                        }
                    }
                    this.e.a(this);
                }
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0527a.a(motionEvent);
        this.b = true;
    }

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 5) {
                if (action != 6) {
                    if (action != 261) {
                        if (action != 262) {
                            return;
                        }
                    }
                }
                b(motionEvent);
                a();
                return;
            }
            c(motionEvent);
            return;
        }
        this.f9641a = System.currentTimeMillis();
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.f9641a = 0L;
    }
}
