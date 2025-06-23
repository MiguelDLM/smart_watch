package com.baidu.nplatform.comapi.map.gesture.detector;

import android.view.MotionEvent;
import com.baidu.nplatform.comapi.map.gesture.a;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f9508a = 0;
    private boolean b = false;
    private a.C0524a c;
    private InterfaceC0525a d;

    /* renamed from: com.baidu.nplatform.comapi.map.gesture.detector.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0525a {
        boolean a(a aVar);
    }

    public a(InterfaceC0525a interfaceC0525a) {
        this.d = interfaceC0525a;
    }

    private void b(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getPointerCount() == 2 && this.c != null) {
            a.C0524a a2 = a.C0524a.a(motionEvent);
            a.C0524a c0524a = new a.C0524a(this.c.f9501a, a2.f9501a);
            a.C0524a c0524a2 = new a.C0524a(this.c.b, a2.b);
            boolean z2 = false;
            if (Math.abs(c0524a.b()) < 20.0d && Math.abs(c0524a2.b()) < 20.0d) {
                z = true;
            } else {
                z = false;
            }
            if (System.currentTimeMillis() - this.f9508a < 200) {
                z2 = true;
            }
            if (z && z2 && this.b) {
                this.d.a(this);
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0524a.a(motionEvent);
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
        this.f9508a = System.currentTimeMillis();
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.f9508a = 0L;
    }
}
