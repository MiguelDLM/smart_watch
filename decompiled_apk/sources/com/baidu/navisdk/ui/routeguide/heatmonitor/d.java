package com.baidu.navisdk.ui.routeguide.heatmonitor;

import com.baidu.navisdk.ui.routeguide.heatmonitor.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final f f8619a;
    private final com.baidu.navisdk.ui.routeguide.heatmonitor.i.a b;
    private final c c;
    private final List<Integer> d;
    private long e;
    private final c.a f;
    private boolean g;
    private com.baidu.navisdk.util.worker.f h;

    /* loaded from: classes8.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.c.a
        public void a(int i) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.d()) {
                gVar.e("RGHMFPSControl", "onFPS(), fps = " + i);
            }
            d.this.d.add(Integer.valueOf(i));
            if (System.currentTimeMillis() - d.this.e >= d.this.f8619a.a().a() * 1000) {
                d.this.c();
                d.this.d();
                d dVar = d.this;
                dVar.a(dVar.f8619a.a().b() * 1000);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.e = System.currentTimeMillis();
            d.this.c.a();
            return null;
        }
    }

    public d(f fVar, com.baidu.navisdk.ui.routeguide.heatmonitor.i.a aVar) {
        c cVar = new c();
        this.c = cVar;
        this.d = new ArrayList();
        a aVar2 = new a();
        this.f = aVar2;
        this.g = false;
        this.h = new b("RGHMFPSControl", null);
        this.f8619a = fVar;
        this.b = aVar;
        cVar.a(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d.size() == 0) {
            return;
        }
        Iterator<Integer> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        if (i / this.d.size() < this.f8619a.a().c()) {
            this.b.a(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.b();
        this.d.clear();
    }

    public void b() {
        if (this.g) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.c()) {
                gVar.c("RGHMFPSControl", "stop()");
            }
            d();
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, false);
            this.g = false;
        }
    }

    public void a() {
        if (this.g) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.c()) {
            gVar.c("RGHMFPSControl", "start()");
        }
        a(0);
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.baidu.navisdk.util.worker.c.a().a(this.h, new com.baidu.navisdk.util.worker.e(2, 0), i);
    }
}
