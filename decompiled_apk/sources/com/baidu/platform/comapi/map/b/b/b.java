package com.baidu.platform.comapi.map.b.b;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.a.b;
import com.baidu.platform.comapi.map.b.f;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes8.dex */
public class b implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a.C0527a> f9649a = new LinkedList<>();
    private f b;
    private MapController c;
    private boolean d;
    private a e;
    private int f;

    public b(MapController mapController) {
        f fVar = new f();
        this.b = fVar;
        this.d = false;
        this.c = mapController;
        this.f = fVar.b / 3;
    }

    private void c(com.baidu.platform.comapi.map.b.a.b bVar) {
        if (this.f9649a.size() < 5) {
            this.f9649a.addLast(bVar.c);
            this.b.a(bVar.d);
        } else if (!this.d && this.f9649a.size() == 5 && a()) {
            d(bVar);
        }
    }

    private void d(com.baidu.platform.comapi.map.b.a.b bVar) {
        if (this.c.isOverlookGestureEnable()) {
            this.e.a(bVar, (Pair<a.d, a.d>) null);
            c cVar = new c(this.c);
            this.e = cVar;
            cVar.a(bVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean a(com.baidu.platform.comapi.map.b.a.b bVar) {
        this.f9649a.clear();
        this.b.a();
        this.e = new d(this.c);
        this.d = false;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean b(com.baidu.platform.comapi.map.b.a.b bVar) {
        Pair<a.d, a.d> c = this.b.c();
        this.b.b();
        this.e.a(bVar, c);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        c(bVar);
        if (this.f9649a.size() == 1) {
            this.e.a(bVar);
        }
        this.e.a(bVar, motionEvent);
        return true;
    }

    private boolean a() {
        int a2;
        double a3;
        this.d = true;
        Iterator<a.C0527a> it = this.f9649a.iterator();
        while (it.hasNext()) {
            double a4 = a.d.a(com.baidu.platform.comapi.map.b.a.f9640a.c(), it.next().c());
            if (Math.abs(a4) > 45.0d && Math.abs(a4) < 135.0d) {
                return false;
            }
        }
        Pair<a.d, a.d> c = this.b.c();
        a.d dVar = (a.d) c.first;
        a.d dVar2 = (a.d) c.second;
        boolean z = Math.abs(dVar.b) > ((double) this.f) && Math.abs(dVar2.b) > ((double) this.f);
        a.C0527a first = this.f9649a.getFirst();
        a.C0527a last = this.f9649a.getLast();
        a.C0527a c0527a = new a.C0527a(last.f9642a, first.f9642a);
        a.C0527a c0527a2 = new a.C0527a(last.b, first.b);
        if (dVar.b > OOXIXo.f3760XO && dVar2.b > OOXIXo.f3760XO) {
            a.d c2 = c0527a.c();
            a.C0527a c0527a3 = com.baidu.platform.comapi.map.b.a.c;
            a2 = (int) a.d.a(c2, c0527a3.c());
            a3 = a.d.a(c0527a2.c(), c0527a3.c());
        } else {
            a.d c3 = c0527a.c();
            a.C0527a c0527a4 = com.baidu.platform.comapi.map.b.a.b;
            a2 = (int) a.d.a(c3, c0527a4.c());
            a3 = a.d.a(c0527a2.c(), c0527a4.c());
        }
        return z && (Math.abs(a2) < 40 && Math.abs((int) a3) < 40);
    }
}
