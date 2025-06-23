package com.baidu.platform.comapi.map.b.a;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.f;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a.C0527a f9643a;
    public a.C0527a b;
    public a.C0527a c;
    public MotionEvent d;
    private a f;
    public f e = new f();
    private boolean g = false;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(b bVar);

        boolean a(b bVar, MotionEvent motionEvent);

        boolean b(b bVar);
    }

    public b(a aVar) {
        this.f = aVar;
    }

    private void b() {
        this.e.b();
        this.g = false;
        this.f.b(this);
    }

    private void c(MotionEvent motionEvent) {
        a.C0527a a2 = a.C0527a.a(motionEvent);
        a.C0527a c0527a = this.c;
        if (c0527a == null) {
            c0527a = a2;
        }
        this.b = c0527a;
        this.c = a2;
        if (this.f9643a == null) {
            this.f9643a = a2;
        }
    }

    public void a(MotionEvent motionEvent) {
        this.d = motionEvent;
        int action = motionEvent.getAction();
        if (action != 2) {
            if (action != 6) {
                if (action == 261) {
                    if (this.g) {
                        return;
                    }
                    a();
                    return;
                } else if (action != 262) {
                    return;
                }
            }
            if (this.g) {
                b();
                return;
            }
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
            if (Math.abs(((a.d) c.first).f9646a) > OOXIXo.f3760XO || Math.abs(((a.d) c.first).b) > OOXIXo.f3760XO || Math.abs(((a.d) c.second).f9646a) > OOXIXo.f3760XO || Math.abs(((a.d) c.second).b) > OOXIXo.f3760XO) {
                c(motionEvent);
                this.f.a(this, motionEvent);
            }
        }
    }

    private void a() {
        this.e.a();
        this.f9643a = null;
        this.b = null;
        this.c = null;
        this.g = true;
        this.f.a(this);
    }
}
