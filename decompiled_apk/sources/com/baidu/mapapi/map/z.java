package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.z.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
class z<T extends a> {

    /* renamed from: a, reason: collision with root package name */
    private final o f5919a;
    private final int b;
    private List<T> c;
    private List<z<T>> d;

    /* loaded from: classes7.dex */
    public static abstract class a {
        public abstract Point getPoint();
    }

    public z(o oVar) {
        this(oVar, 0);
    }

    public void a(T t) {
        Point point = t.getPoint();
        if (this.f5919a.a(point.x, point.y)) {
            a(point.x, point.y, t);
        }
    }

    private z(double d, double d2, double d3, double d4, int i) {
        this(new o(d, d2, d3, d4), i);
    }

    private z(o oVar, int i) {
        this.d = null;
        this.f5919a = oVar;
        this.b = i;
    }

    private void a(double d, double d2, T t) {
        List<z<T>> list = this.d;
        if (list != null) {
            o oVar = this.f5919a;
            if (d2 < oVar.f) {
                if (d < oVar.e) {
                    list.get(0).a(d, d2, t);
                    return;
                } else {
                    list.get(1).a(d, d2, t);
                    return;
                }
            }
            if (d < oVar.e) {
                list.get(2).a(d, d2, t);
                return;
            } else {
                list.get(3).a(d, d2, t);
                return;
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(t);
        if (this.c.size() <= 40 || this.b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        o oVar = this.f5919a;
        arrayList.add(new z(oVar.f5906a, oVar.e, oVar.b, oVar.f, this.b + 1));
        List<z<T>> list = this.d;
        o oVar2 = this.f5919a;
        list.add(new z<>(oVar2.e, oVar2.c, oVar2.b, oVar2.f, this.b + 1));
        List<z<T>> list2 = this.d;
        o oVar3 = this.f5919a;
        list2.add(new z<>(oVar3.f5906a, oVar3.e, oVar3.f, oVar3.d, this.b + 1));
        List<z<T>> list3 = this.d;
        o oVar4 = this.f5919a;
        list3.add(new z<>(oVar4.e, oVar4.c, oVar4.f, oVar4.d, this.b + 1));
        List<T> list4 = this.c;
        this.c = null;
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            a(r7.getPoint().x, r7.getPoint().y, it.next());
        }
    }

    public Collection<T> a(o oVar) {
        ArrayList arrayList = new ArrayList();
        a(oVar, arrayList);
        return arrayList;
    }

    private void a(o oVar, Collection<T> collection) {
        if (this.f5919a.a(oVar)) {
            List<z<T>> list = this.d;
            if (list != null) {
                Iterator<z<T>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(oVar, collection);
                }
            } else if (this.c != null) {
                if (oVar.b(this.f5919a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (T t : this.c) {
                    if (oVar.a(t.getPoint())) {
                        collection.add(t);
                    }
                }
            }
        }
    }
}
