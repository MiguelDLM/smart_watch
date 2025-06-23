package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.pronavi.data.vm.e;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewSimpleContinueComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private View p;
    private View q;
    private com.baidu.navisdk.pronavi.style.i.a r;
    private com.baidu.navisdk.ui.routeguide.subview.a s;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewSimpleContinueComponent.this).g, "getContinueViewVisibleModel visible = " + it);
            }
            RGNewSimpleContinueComponent rGNewSimpleContinueComponent = RGNewSimpleContinueComponent.this;
            IIX0o.oO(it, "it");
            rGNewSimpleContinueComponent.b(it.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<Integer> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 1) {
                if (RGNewSimpleContinueComponent.this.E()) {
                    RGNewSimpleContinueComponent.this.b(0);
                }
            } else if (num != null && num.intValue() == 0) {
                RGNewSimpleContinueComponent.this.b(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Bundle bundle;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewSimpleContinueComponent.this).g, "mContinueView onClick: ");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.6");
            RGNewSimpleContinueComponent rGNewSimpleContinueComponent = RGNewSimpleContinueComponent.this;
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) rGNewSimpleContinueComponent.n();
            IIX0o.oO(context, "context");
            rGNewSimpleContinueComponent.s = context.w();
            com.baidu.navisdk.ui.routeguide.subview.a aVar = RGNewSimpleContinueComponent.this.s;
            if (aVar != null) {
                k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null) {
                    k.A();
                }
                if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                    bundle = new Bundle();
                    bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_NEED_EXECUTE_GLASS_FMS, false);
                } else {
                    bundle = null;
                }
                aVar.a(3, 0, 0, bundle);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_continue_navi"));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.pronavi.style.c {
        public d(Integer[] numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGContinueNavi";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(RGNewSimpleContinueComponent.this.q);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewSimpleContinueComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        MutableLiveData<Integer> e;
        MutableLiveData<Integer> d2;
        e eVar = (e) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(e.class);
        if (eVar != null && (d2 = eVar.d()) != null) {
            d2.observe(this, new a());
        }
        if (eVar != null && (e = eVar.e()) != null) {
            e.observe(this, new b());
        }
    }

    private final void D() {
        View view;
        ViewGroup viewGroup = this.j;
        View view2 = null;
        if (viewGroup != null) {
            view = viewGroup.findViewById(R.id.bn_rg_bottombar_new_simple_continue_ly);
        } else {
            view = null;
        }
        this.p = view;
        ViewGroup viewGroup2 = this.j;
        if (viewGroup2 != null) {
            view2 = viewGroup2.findViewById(R.id.bnav_rg_bottombar_new_continue_nav);
        }
        this.q = view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        com.baidu.navisdk.poisearch.model.a k = com.baidu.navisdk.poisearch.model.a.k();
        IIX0o.oO(k, "BNNearbySearchModel.getInstance()");
        if (!k.h()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            if (!b2.A2()) {
                return true;
            }
        }
        return false;
    }

    private final void F() {
        View view = this.q;
        if (view != null) {
            view.setOnClickListener(new c());
        }
        G();
    }

    private final void G() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.r;
        if (aVar == null) {
            d dVar = new d(new Integer[0]);
            this.r = dVar;
            f.b.a("RGContinueNavi", dVar);
        } else {
            IIX0o.ooOOo0oXI(aVar);
            aVar.a(this.q);
            com.baidu.navisdk.pronavi.style.i.a aVar2 = this.r;
            IIX0o.ooOOo0oXI(aVar2);
            aVar2.a("RGContinueNavi");
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        D();
        F();
        C();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewSimpleContinueComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_simple_eta_ly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "updateContinueViewState visible = " + i);
        }
        if (i == 8) {
            View view = this.p;
            if (view != null) {
                view.setVisibility(8);
            }
            ((com.baidu.navisdk.pronavi.ui.base.b) n()).j().e("RGNewSimpleEtaComponent").a(1).a();
            return;
        }
        View view2 = this.p;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ((com.baidu.navisdk.pronavi.ui.base.b) n()).j().e("RGNewSimpleEtaComponent").a(2).a();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        int d2 = api.d();
        if (d2 == 1) {
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
            return null;
        }
        if (d2 != 2) {
            return super.a(api);
        }
        View view2 = this.p;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@OOXIXo Configuration newConfig) {
        IIX0o.x0xO0oo(newConfig, "newConfig");
        super.a(newConfig);
    }
}
