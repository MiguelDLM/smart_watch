package com.baidu.navisdk.b4nav.func.bindroute;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.func.bindroute.a;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.data.b;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class BindRouteFunc<R extends com.baidu.navisdk.b4nav.func.bindroute.a> extends CoreFunc<R> {

    /* loaded from: classes7.dex */
    public class a implements Function<b, Boolean> {
        public a(BindRouteFunc bindRouteFunc) {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(b bVar) {
            boolean z;
            if (bVar != null && ((Boolean) bVar.a(Boolean.FALSE)).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    private void r() {
        a("is_page_started", ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).a("is_page_started"), new a(this));
        throw null;
    }

    private void s() {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e(this.g, "stopBindRoute --> isStartDriving : " + ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).c());
        }
        if (!((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).c()) {
            if (gVar.d()) {
                gVar.e(this.g, "stopBindRoute --> is not in driving mode!!!");
                return;
            }
            return;
        }
        ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).a(false);
        if (!com.baidu.navisdk.module.init.a.a() && gVar.d()) {
            gVar.e(this.g, "stopBindRoute --> 引擎没有初始化！");
        }
        if (BNRoutePlaner.getInstance().D()) {
            if (gVar.d()) {
                gVar.e(this.g, "stopBindRoute --> 成功 ");
            }
        } else if (gVar.d()) {
            gVar.e(this.g, "stopBindRoute --> 失败 ");
        }
    }

    public <I> void a(@NonNull String str, @NonNull LiveData<I> liveData, @NonNull Function<I, Boolean> function) {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e(this.g, "addOption --> tag = " + str + ", source = " + liveData + ", func = " + function);
        }
        ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).b().a(str, liveData, function);
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        s();
        ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).b("is_page_started", Boolean.FALSE);
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        r();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        ((com.baidu.navisdk.b4nav.func.bindroute.a) this.j).b().a();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "BindRouteFunc";
    }
}
