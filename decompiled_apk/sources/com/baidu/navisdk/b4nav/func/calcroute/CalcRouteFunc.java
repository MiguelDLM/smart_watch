package com.baidu.navisdk.b4nav.func.calcroute;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.func.calcroute.listener.c;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.i;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class CalcRouteFunc<R> extends CoreFunc<R> {
    private c m;
    private com.baidu.navisdk.b4nav.func.calcroute.listener.b n;
    private com.baidu.navisdk.module.routeresultbase.logic.calcroute.msgreceiver.a o;
    private a.InterfaceC0201a p;
    private com.baidu.navisdk.b4nav.func.calcroute.listener.a q;
    private final com.baidu.navisdk.module.offlinedownload.a r;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if ((iVar.a() == 3030 || iVar.a() == 3060) && CalcRouteFunc.this.q != null) {
                    CalcRouteFunc.this.q.a(iVar.a(), iVar.b(), iVar.c(), iVar.d());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            com.baidu.navisdk.framework.b.a(((com.baidu.navisdk.b4nav.c) ((Func) CalcRouteFunc.this).i).o(), ((com.baidu.navisdk.b4nav.c) ((Func) CalcRouteFunc.this).i).n(), "location_auto");
        }
    }

    private void w() {
        if (this.p != null) {
            return;
        }
        this.p = new a();
    }

    private void x() {
        if (this.o != null) {
            return;
        }
        this.o = new com.baidu.navisdk.module.routeresultbase.logic.calcroute.msgreceiver.a(((com.baidu.navisdk.b4nav.c) this.i).e(), this.r);
    }

    public boolean a(@NonNull com.baidu.navisdk.model.datastruct.c cVar) {
        return false;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        s();
        r();
        x();
        w();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        this.m = null;
        this.n = null;
        this.q = null;
        this.p = null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(this.q);
        }
        com.baidu.navisdk.b4nav.func.calcroute.listener.b bVar = this.n;
        if (bVar != null) {
            bVar.a(this.q);
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        c cVar = this.m;
        if (cVar != null) {
            cVar.a((com.baidu.navisdk.b4nav.func.calcroute.listener.a) null);
        }
        com.baidu.navisdk.b4nav.func.calcroute.listener.b bVar = this.n;
        if (bVar != null) {
            bVar.a(null);
        }
        com.baidu.navisdk.module.routeresultbase.logic.calcroute.msgreceiver.a aVar = this.o;
        if (aVar != null) {
            aVar.setJumpToDownloadListener(null);
        }
        BNRoutePlaner.getInstance().b(this.m);
        com.baidu.navisdk.vi.b.b(this.n);
        BNRoutePlaner.getInstance().deleteObserver(this.o);
        com.baidu.navisdk.framework.message.a.a().a(this.p);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "CalcRouteFunc";
    }

    public void r() {
        if (this.n != null) {
            return;
        }
        this.n = new com.baidu.navisdk.b4nav.func.calcroute.listener.b();
    }

    public void s() {
        if (this.m != null) {
            return;
        }
        this.m = new c(this.k);
    }

    public boolean t() {
        ((com.baidu.navisdk.b4nav.c) this.i).r();
        throw null;
    }

    public boolean u() {
        ((com.baidu.navisdk.b4nav.c) this.i).r();
        throw null;
    }

    public void v() {
        this.q = null;
    }

    public boolean b(@NonNull com.baidu.navisdk.model.datastruct.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "searchRoute --> param = " + cVar);
            LogUtil.printCallStack();
        }
        boolean z = false;
        if (a(cVar)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && !com.baidu.navisdk.b4nav.utils.a.a(((com.baidu.navisdk.b4nav.c) this.i).e())) {
            com.baidu.navisdk.util.worker.lite.a.c(new b("callLocatePermission"));
        }
        if (g.B4NAV.b()) {
            ((com.baidu.navisdk.b4nav.c) this.i).b(this.g, "searchRoute");
        }
        Bundle a2 = cVar.a();
        com.baidu.navisdk.b4nav.b bVar = this.k;
        if (a2 != null && a2.containsKey("dest_info")) {
            z = true;
        }
        bVar.a(z);
        throw null;
    }

    public void a(@NonNull com.baidu.navisdk.b4nav.func.calcroute.listener.a aVar) {
        this.q = aVar;
    }

    public boolean a(int i) {
        ((com.baidu.navisdk.b4nav.c) this.i).r();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        int d = aVar.d();
        if (d == 0) {
            h.a();
            t();
            throw null;
        }
        if (d == 1) {
            h.a();
            u();
            throw null;
        }
        if (d != 2) {
            return null;
        }
        Object a2 = aVar.a("paramA");
        if (a2 instanceof com.baidu.navisdk.model.datastruct.c) {
            return h.a().b("resultA", Boolean.valueOf(b((com.baidu.navisdk.model.datastruct.c) a2)));
        }
        if (a2 != null && !(a2 instanceof Integer)) {
            return null;
        }
        h.a();
        a(a2 != null ? ((Integer) a2).intValue() : 4);
        throw null;
    }
}
