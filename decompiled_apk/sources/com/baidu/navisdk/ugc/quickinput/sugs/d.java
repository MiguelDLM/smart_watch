package com.baidu.navisdk.ugc.quickinput.sugs;

import com.baidu.navisdk.ugc.quickinput.sugs.c;
import com.baidu.navisdk.ugc.report.data.datarepository.i;
import com.baidu.navisdk.ugc.report.data.datarepository.j;

/* loaded from: classes8.dex */
class d implements c.InterfaceC0390c {

    /* renamed from: a, reason: collision with root package name */
    private b f8228a;
    private int c = 0;
    private c b = new c(this);

    public d(b bVar) {
        this.f8228a = bVar;
    }

    public void a(String str, int i) {
        c cVar = this.b;
        if (cVar != null) {
            int i2 = this.c + 1;
            this.c = i2;
            cVar.a(str, i2, i);
        }
    }

    public void b() {
        this.f8228a = null;
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
            this.b = null;
        }
    }

    public void a() {
        this.c = -1;
    }

    public void a(int i) {
        if (this.f8228a != null) {
            if (i.c().a()) {
                this.f8228a.a(null, i.c().b());
                return;
            }
            String[] a2 = i.c().a(i);
            if (a2 == null) {
                this.f8228a.a(null, i.c().b());
                return;
            }
            j jVar = new j();
            jVar.a(a2);
            this.f8228a.a(jVar, i.c().b());
        }
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.c.InterfaceC0390c
    public void a(j jVar) {
        if (this.f8228a != null) {
            if (jVar != null && jVar.b() == this.c) {
                this.f8228a.a(jVar);
            } else {
                this.f8228a.a(null);
            }
        }
    }
}
