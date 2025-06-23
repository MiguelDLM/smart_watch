package com.baidu.navisdk.ui.routeguide.heatmonitor;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final b f8640a;
    private final RGHMHeatStrategy b;
    private final d c;
    private final RGHMStatistics d;
    private int e = -1;
    private final i f;
    private final boolean g;
    private boolean h;
    private final com.baidu.navisdk.ui.routeguide.heatmonitor.i.a i;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.a {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.a
        public void a(int i) {
            j.this.a(i);
        }
    }

    public j() {
        a aVar = new a();
        this.i = aVar;
        b bVar = new b();
        this.f8640a = bVar;
        this.f = new i(this);
        this.b = new RGHMHeatStrategy(bVar.b(), aVar);
        this.c = new d(bVar.c(), aVar);
        this.d = new RGHMStatistics(com.baidu.navisdk.framework.a.c().a(), bVar.c());
        this.g = bVar.a();
        com.baidu.navisdk.framework.message.a.a().a(h.class);
    }

    public void b() {
        if (!this.g) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.c()) {
                gVar.c("RGHeatMonitor", "start() initFail");
                return;
            }
            return;
        }
        if (this.h) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar2.c()) {
                gVar2.c("RGHeatMonitor", "start() isRunning");
                return;
            }
            return;
        }
        this.h = true;
        this.b.a(com.baidu.navisdk.framework.a.c().a());
        this.d.a();
    }

    public void c() {
        if (!this.g) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar.c()) {
                gVar.c("RGHeatMonitor", "stop() initFail");
                return;
            }
            return;
        }
        if (!this.h) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (gVar2.c()) {
                gVar2.c("RGHeatMonitor", "stop() !isRunning");
                return;
            }
            return;
        }
        this.h = false;
        this.b.b(com.baidu.navisdk.framework.a.c().a());
        this.c.b();
        this.d.b();
        this.f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.d()) {
            gVar.e("RGHeatMonitor", "moveToState(), destState = " + i);
        }
        if (this.e == i) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1", "" + i, null, "" + this.e);
        com.baidu.navisdk.framework.message.a.a().c(new h(this.e, i));
        int i2 = this.e;
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                this.f.a(this.f8640a.c().c().get(Integer.valueOf(i3)));
                b(i3);
            }
            return;
        }
        while (true) {
            i2++;
            if (i2 > i) {
                return;
            }
            this.f.a(this.f8640a.c().c().get(Integer.valueOf(i2)));
            b(i2);
        }
    }

    private void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
        if (gVar.d()) {
            com.baidu.navisdk.ui.routeguide.utils.c.e(i);
            gVar.e("RGHeatMonitor", "stateChanged(), destState = " + i);
        }
        this.e = i;
        this.d.a(i);
        if (i == 2) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public int a() {
        return this.e;
    }
}
