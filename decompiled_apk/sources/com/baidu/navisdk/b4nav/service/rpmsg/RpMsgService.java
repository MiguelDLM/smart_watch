package com.baidu.navisdk.b4nav.service.rpmsg;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.b4nav.framework.service.CoreService;
import com.baidu.navisdk.b4nav.func.calcroute.CalcRouteFunc;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class RpMsgService extends CoreService {
    private com.baidu.navisdk.b4nav.b l;
    private final com.baidu.navisdk.model.c<Integer, com.baidu.navisdk.b4nav.service.rpmsg.a> m;
    private final com.baidu.navisdk.model.c<Integer, c> n;
    private final com.baidu.navisdk.model.c<Integer, b> o;
    private final com.baidu.navisdk.b4nav.func.calcroute.listener.a p;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6634a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, int i, int i2, int i3, Object obj) {
            super(str);
            this.f6634a = i;
            this.b = i2;
            this.c = i3;
            this.d = obj;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            RpMsgService.this.a(this.f6634a, this.b, this.c, this.d);
        }
    }

    private void b(String str, int i, int i2, int i3, Object obj) {
        a(str, i, i2, i3, obj);
        throw null;
    }

    private void c(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        b bVar = (b) aVar.a("paramB");
        if (bVar != null) {
            a(c, bVar, bVar.a(c));
        }
    }

    private void d(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        c cVar = (c) aVar.a("paramB");
        if (cVar != null) {
            a(c, cVar, cVar.a(c));
        }
    }

    private void e(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        com.baidu.navisdk.b4nav.service.rpmsg.a aVar2 = (com.baidu.navisdk.b4nav.service.rpmsg.a) aVar.a("paramB");
        if (aVar2 != null) {
            a(c, aVar2, aVar2.a(c));
        }
    }

    private void f(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        b bVar = (b) aVar.a("paramB");
        if (bVar != null) {
            a(c, bVar);
        }
    }

    public void a(int i, int i2, int i3, Object obj) {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g("RpMsgSupport", "handleRpMessage --> what = " + i + ", arg1 = " + i2 + ", arg2 = " + i3 + ", obj = " + obj);
        }
        if (((com.baidu.navisdk.b4nav.c) this.i).k().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            String a2 = com.baidu.navisdk.b4nav.utils.a.a(i);
            if (gVar.e()) {
                gVar.g("RpMsgSupport", "RpMsgSupport::handleRpMessage --> " + a2);
            }
            if (gVar.b()) {
                ((com.baidu.navisdk.b4nav.c) this.i).b("RpMsgSupport", "handleRpMessage", a2);
            }
            try {
                b(a2, i, i2, i3, obj);
                throw null;
            } catch (Exception e) {
                if (g.B4NAV.c()) {
                    g.B4NAV.a("RpMsgSupport handle " + a2 + " message exception!", e);
                }
                if (g.B4NAV.b()) {
                    ((com.baidu.navisdk.b4nav.c) this.i).a("RpMsgSupport", "handleRpMessage", a2);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        this.l = ((com.baidu.navisdk.b4nav.c) this.i).q();
        ((com.baidu.navisdk.b4nav.c) this.i).a("RpMsgService", this);
        CalcRouteFunc calcRouteFunc = (CalcRouteFunc) d("CalcRouteFunc");
        if (calcRouteFunc != null) {
            calcRouteFunc.a(this.p);
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        CalcRouteFunc calcRouteFunc = (CalcRouteFunc) d("CalcRouteFunc");
        if (calcRouteFunc != null) {
            calcRouteFunc.v();
        }
        ((com.baidu.navisdk.b4nav.c) this.i).a("RpMsgService");
        this.m.a();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        com.baidu.navisdk.b4nav.b bVar = this.l;
        if (bVar == null) {
            return;
        }
        bVar.e();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RpMsgService";
    }

    private void b(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new a("RpMsgSupport::handleRpMsg", aVar.c("paramA"), aVar.c("paramB"), aVar.c("paramC"), aVar.a("paramD")), 10002);
    }

    private void g(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        c cVar = (c) aVar.a("paramB");
        if (cVar != null) {
            a(c, cVar);
        }
    }

    private void h(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return;
        }
        int c = aVar.c("paramA");
        com.baidu.navisdk.b4nav.service.rpmsg.a aVar2 = (com.baidu.navisdk.b4nav.service.rpmsg.a) aVar.a("paramB");
        if (aVar2 != null) {
            a(c, aVar2);
        }
    }

    public boolean a(String str, int i, int i2, int i3, Object obj) {
        this.n.a(Integer.valueOf(i));
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        switch (aVar.d()) {
            case 1:
                e(aVar);
                return null;
            case 2:
                h(aVar);
                return null;
            case 3:
                d(aVar);
                return null;
            case 4:
                g(aVar);
                return null;
            case 5:
                c(aVar);
                return null;
            case 6:
                f(aVar);
                return null;
            case 7:
                b(aVar);
                return null;
            default:
                return null;
        }
    }

    public void a(int i, com.baidu.navisdk.b4nav.service.rpmsg.a aVar, int i2) {
        if (aVar == null) {
            return;
        }
        this.m.a(Integer.valueOf(i), aVar, i2);
        throw null;
    }

    public void a(int i, com.baidu.navisdk.b4nav.service.rpmsg.a aVar) {
        if (aVar == null) {
            return;
        }
        this.m.a(Integer.valueOf(i), aVar);
        throw null;
    }

    public void a(int i, c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        this.n.a(Integer.valueOf(i), cVar, i2);
        throw null;
    }

    public void a(int i, c cVar) {
        if (cVar == null) {
            return;
        }
        this.n.a(Integer.valueOf(i), cVar);
        throw null;
    }

    public void a(int i, b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        this.o.a(Integer.valueOf(i), bVar, i2);
        throw null;
    }

    public void a(int i, b bVar) {
        if (bVar == null) {
            return;
        }
        this.o.a(Integer.valueOf(i), bVar);
        throw null;
    }
}
