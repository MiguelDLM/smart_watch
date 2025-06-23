package com.baidu.nplatform.comapi.map.gesture.opt;

import XIXIX.OOXIXo;
import android.util.Pair;
import com.baidu.nplatform.comapi.map.gesture.a;
import com.baidu.nplatform.comapi.map.gesture.detector.b;
import com.baidu.nplatform.comapi.map.j;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes8.dex */
public class b implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a.C0524a> f9511a = new LinkedList<>();
    private com.baidu.nplatform.comapi.map.gesture.c b;
    private j c;
    private boolean d;
    private a e;
    private int f;

    public b(j jVar) {
        com.baidu.nplatform.comapi.map.gesture.c cVar = new com.baidu.nplatform.comapi.map.gesture.c();
        this.b = cVar;
        this.d = false;
        this.c = jVar;
        this.f = cVar.c / 3;
    }

    private void d(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        this.e.a(bVar);
        c cVar = new c(this.c);
        this.e = cVar;
        cVar.b(bVar);
    }

    private void e(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        if (this.f9511a.size() < 5) {
            this.f9511a.addLast(bVar.c);
            this.b.a(bVar.d);
        } else if (!this.d && this.f9511a.size() == 5 && a()) {
            d(bVar);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.detector.b.a
    public boolean a(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        this.f9511a.clear();
        this.b.b();
        this.e = new d(this.c);
        this.d = false;
        return true;
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.detector.b.a
    public boolean b(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        e(bVar);
        if (this.f9511a.size() == 1) {
            this.e.b(bVar);
        }
        this.e.c(bVar);
        return true;
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.detector.b.a
    public boolean c(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        this.b.a();
        this.e.a(bVar);
        return true;
    }

    private boolean a() {
        this.d = true;
        Iterator<a.C0524a> it = this.f9511a.iterator();
        while (it.hasNext()) {
            if (a.d.a(com.baidu.nplatform.comapi.map.gesture.a.f9500a.c(), it.next().c()) > 45.0d) {
                return false;
            }
        }
        Pair<a.d, a.d> c = this.b.c();
        a.d dVar = (a.d) c.first;
        a.d dVar2 = (a.d) c.second;
        boolean z = Math.abs(dVar.b) > ((double) this.f) && Math.abs(dVar2.b) > ((double) this.f);
        a.C0524a first = this.f9511a.getFirst();
        a.C0524a last = this.f9511a.getLast();
        a.C0524a c0524a = new a.C0524a(last.f9501a, first.f9501a);
        a.C0524a c0524a2 = new a.C0524a(last.b, first.b);
        a.d c2 = c0524a.c();
        a.C0524a c0524a3 = com.baidu.nplatform.comapi.map.gesture.a.b;
        int a2 = (int) a.d.a(c2, c0524a3.c());
        int a3 = (int) a.d.a(c0524a2.c(), c0524a3.c());
        if (dVar.b > OOXIXo.f3760XO && dVar2.b > OOXIXo.f3760XO) {
            a2 += 180;
            a3 += 180;
        }
        return z && (Math.abs(a2) < 40 && Math.abs(a3) < 40);
    }
}
