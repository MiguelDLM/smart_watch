package com.baidu.navisdk.comapi.routeplan.v2;

import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    int f6728a = -1;
    boolean b = false;
    List<RoutePlanNode> c = null;
    int d = -1;
    int e = -1;
    public int f = -1;
    public int g = 0;
    private int h = 0;
    private b i;
    private c j;
    private int[] k;

    public d(b bVar) {
        this.i = bVar;
    }

    private void j() {
        this.d = -1;
        if (this.b) {
            this.d = b(this.c, this.i.m());
            return;
        }
        b bVar = this.i;
        if (bVar.f != 8 || bVar.h() != 1) {
            this.d = a(this.c, this.i.m());
        }
    }

    public void a(int i) {
        this.f6728a = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.f;
    }

    public b e() {
        return this.i;
    }

    public c f() {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    public int g() {
        return this.f6728a;
    }

    public int[] h() {
        return this.k;
    }

    public boolean i() {
        if (this.d == 3) {
            return true;
        }
        return false;
    }

    public void a(int[] iArr) {
        this.k = iArr;
    }

    public int b() {
        return this.e;
    }

    private static int b(List<RoutePlanNode> list, int i) {
        k k;
        int i2 = i == 1 ? 17 : 5;
        if (!j.d() && (k = com.baidu.navisdk.framework.interfaces.c.p().k()) != null) {
            i2 = k.E() + 2;
        }
        return (list == null || list.size() < 2 || list.size() > i2) ? 5000 : -1;
    }

    public void a() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.clear();
        this.c.add(this.i.f6726a);
        List<RoutePlanNode> list = this.i.c;
        if (list != null && list.size() > 0) {
            this.c.addAll(this.i.c);
        }
        this.c.add(this.i.b);
        Iterator<RoutePlanNode> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().mFrom == 2) {
                this.b = true;
                break;
            }
        }
        j();
    }

    private static int a(List<RoutePlanNode> list, int i) {
        k k;
        int i2 = i == 1 ? 17 : 5;
        if (!j.d() && (k = com.baidu.navisdk.framework.interfaces.c.p().k()) != null) {
            i2 = k.E() + 2;
        }
        if (list == null || list.size() < 2 || list.size() > i2) {
            return 5000;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            RoutePlanNode routePlanNode = list.get(i3);
            if (routePlanNode == null || !routePlanNode.isNodeSettedData()) {
                return 5001;
            }
        }
        return -1;
    }
}
