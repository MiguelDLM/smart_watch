package com.baidu.navisdk.comapi.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private List<g> f6736a = null;

    public e() {
        e();
    }

    private void e() {
        this.f6736a = Collections.synchronizedList(new ArrayList());
    }

    public void a() {
        if (this.f6736a == null) {
            this.f6736a = new ArrayList();
        }
        this.f6736a.clear();
    }

    public e b() {
        e eVar = new e();
        Iterator<g> it = this.f6736a.iterator();
        while (it.hasNext()) {
            eVar.a(it.next());
        }
        return eVar;
    }

    public List<g> c() {
        return this.f6736a;
    }

    public int d() {
        List<g> list = this.f6736a;
        if (list == null) {
            e();
            return 0;
        }
        return list.size();
    }

    public void a(List<g> list) {
        this.f6736a.addAll(list);
    }

    public void a(g gVar) {
        if (this.f6736a == null) {
            this.f6736a = new ArrayList();
        }
        this.f6736a.add(gVar);
    }
}
