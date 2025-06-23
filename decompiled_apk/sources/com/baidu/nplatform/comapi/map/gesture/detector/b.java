package com.baidu.nplatform.comapi.map.gesture.detector;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.nplatform.comapi.map.gesture.a;
import com.baidu.nplatform.comapi.map.gesture.c;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a.C0524a f9509a;
    public a.C0524a b;
    public a.C0524a c;
    public MotionEvent d;
    private a f;
    public c e = new c();
    private boolean g = false;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(b bVar);

        boolean b(b bVar);

        boolean c(b bVar);
    }

    public b(a aVar) {
        this.f = aVar;
    }

    private void b() {
        this.e.a();
        this.g = false;
        this.f.c(this);
    }

    private void c(MotionEvent motionEvent) {
        a.C0524a a2 = a.C0524a.a(motionEvent);
        a.C0524a c0524a = this.c;
        if (c0524a == null) {
            c0524a = a2;
        }
        this.b = c0524a;
        this.c = a2;
        if (this.f9509a == null) {
            this.f9509a = a2;
        }
    }

    public void a(MotionEvent motionEvent) {
        this.d = motionEvent;
        int action = motionEvent.getAction();
        if (action != 2) {
            if (action != 5) {
                if (action != 6) {
                    if (action != 261) {
                        if (action != 262) {
                            return;
                        }
                    }
                }
                if (this.g) {
                    b();
                    return;
                }
                return;
            }
            if (this.g) {
                return;
            }
            a();
            return;
        }
        if (this.g) {
            b(motionEvent);
        } else if (motionEvent.getPointerCount() == 2) {
            a();
        }
    }

    private void b(MotionEvent motionEvent) {
        this.e.a(motionEvent);
        Pair<a.d, a.d> c = this.e.c();
        if (motionEvent.getPointerCount() == 2) {
            if (Math.abs(((a.d) c.first).f9504a) > OOXIXo.f3760XO || Math.abs(((a.d) c.first).b) > OOXIXo.f3760XO || Math.abs(((a.d) c.second).f9504a) > OOXIXo.f3760XO || Math.abs(((a.d) c.second).b) > OOXIXo.f3760XO) {
                c(motionEvent);
                this.f.b(this);
            }
        }
    }

    private void a() {
        this.e.b();
        this.f9509a = null;
        this.b = null;
        this.c = null;
        this.g = true;
        this.f.a(this);
    }
}
