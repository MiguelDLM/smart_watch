package com.baidu.navisdk.pronavi.logic.driving;

import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.pronavi.logic.service.a {
    private com.baidu.navisdk.listeners.a c;
    private c d;
    private com.baidu.navisdk.module.driving.a b = new com.baidu.navisdk.module.driving.a();
    private com.baidu.navisdk.pronavi.logic.driving.a e = new com.baidu.navisdk.pronavi.logic.driving.a();

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.listeners.a {
        public a() {
        }

        @Override // com.baidu.navisdk.listeners.a
        public void a(com.baidu.navisdk.model.datastruct.a aVar) {
            b.this.a(aVar);
            if (b.this.d != null) {
                b.this.d.a(b.this.e);
            }
        }
    }

    private void d() {
        if (this.c == null) {
            this.c = new a();
        }
    }

    public void c() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f7780a, "updateLatestData: ");
        }
        com.baidu.navisdk.module.driving.a aVar = this.b;
        if (aVar != null) {
            a(aVar.b());
            c cVar = this.d;
            if (cVar != null) {
                cVar.a(this.e);
            }
        }
    }

    public void b() {
        com.baidu.navisdk.module.driving.a aVar = this.b;
        if (aVar != null) {
            aVar.b(this.c);
            this.b.c();
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.model.datastruct.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f7780a, "handlerLatestData: " + aVar);
        }
        if (aVar != null && aVar.a()) {
            int i = aVar.f6902a;
            if (i <= 0) {
                this.e.b = "--米";
            } else {
                this.e.b = l0.c(i);
            }
            long j = aVar.b;
            if (j <= 0) {
                this.e.c = "--分钟";
            } else {
                this.e.c = l0.b(j);
            }
            if (gVar.d()) {
                gVar.e(this.f7780a, "handlerLatestData: " + this.e);
                return;
            }
            return;
        }
        if (gVar.c()) {
            gVar.c(this.f7780a, "handlerLatestData data not valid");
        }
    }

    public void a(long j) {
        if (this.b != null) {
            c();
            d();
            this.b.a(this.c);
            this.b.a(j);
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.service.a
    public void a() {
        super.a();
        com.baidu.navisdk.module.driving.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b.a((com.baidu.navisdk.listeners.a) null);
        }
        this.c = null;
        this.d = null;
    }
}
