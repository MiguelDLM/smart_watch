package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewContinueComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private ViewGroup p;
    private TextView q;
    private com.baidu.navisdk.pronavi.style.i.a r;
    private com.baidu.navisdk.ui.routeguide.subview.a s;
    private com.baidu.navisdk.pronavi.ui.driving.a t;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<p> {
        final /* synthetic */ com.baidu.navisdk.pronavi.data.vm.e b;

        public a(com.baidu.navisdk.pronavi.data.vm.e eVar) {
            this.b = eVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(p pVar) {
            if (pVar != null) {
                if (pVar != p.BOTTOM || !this.b.f()) {
                    RGNewContinueComponent.this.c(8);
                } else {
                    RGNewContinueComponent.this.c(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<Integer> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            RGNewContinueComponent rGNewContinueComponent = RGNewContinueComponent.this;
            IIX0o.oO(it, "it");
            rGNewContinueComponent.c(it.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<Integer> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 1) {
                com.baidu.navisdk.poisearch.model.a k = com.baidu.navisdk.poisearch.model.a.k();
                IIX0o.oO(k, "BNNearbySearchModel.getInstance()");
                if (!k.h()) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
                    IIX0o.oO(b, "RGViewController.getInstance()");
                    if (!b.A2()) {
                        RGNewContinueComponent.this.c(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (num != null && num.intValue() == 0) {
                RGNewContinueComponent.this.c(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Bundle bundle;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewContinueComponent.this).g, "mContinueView onClick: ");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.6");
            RGNewContinueComponent rGNewContinueComponent = RGNewContinueComponent.this;
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) rGNewContinueComponent.n();
            IIX0o.oO(context, "context");
            rGNewContinueComponent.s = context.w();
            com.baidu.navisdk.ui.routeguide.subview.a aVar = RGNewContinueComponent.this.s;
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
    public static final class e extends com.baidu.navisdk.pronavi.style.c {
        public e(Integer[] numArr) {
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
            a((View) RGNewContinueComponent.a(RGNewContinueComponent.this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewContinueComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        MutableLiveData<Integer> e2;
        MutableLiveData<Integer> d2;
        com.baidu.navisdk.framework.lifecycle.b<p> c2;
        com.baidu.navisdk.pronavi.data.vm.e eVar = (com.baidu.navisdk.pronavi.data.vm.e) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.data.vm.e.class);
        if (eVar != null && (c2 = eVar.c()) != null) {
            c2.observe(this, new a(eVar));
        }
        if (eVar != null && (d2 = eVar.d()) != null) {
            d2.observe(this, new b());
        }
        if (eVar != null && (e2 = eVar.e()) != null) {
            e2.observe(this, new c());
        }
    }

    private final void D() {
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.t;
        if (aVar != null) {
            aVar.c();
        }
    }

    private final void E() {
        View findViewById = this.j.findViewById(R.id.bn_rg_bottombar_new_continue_ly);
        IIX0o.oO(findViewById, "mContainerView.findViewB…ottombar_new_continue_ly)");
        this.p = (ViewGroup) findViewById;
        View findViewById2 = this.j.findViewById(R.id.bnav_rg_bottombar_new_continue_nav);
        IIX0o.oO(findViewById2, "mContainerView.findViewB…ttombar_new_continue_nav)");
        this.q = (TextView) findViewById2;
        I();
    }

    private final void F() {
        ViewGroup viewGroup = this.p;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("continueViewLayout");
        }
        viewGroup.setOnClickListener(new d());
        G();
    }

    private final void G() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.r;
        if (aVar == null) {
            e eVar = new e(new Integer[0]);
            this.r = eVar;
            f.b.a("RGContinueNavi", eVar);
            return;
        }
        IIX0o.ooOOo0oXI(aVar);
        TextView textView = this.q;
        if (textView == null) {
            IIX0o.XOxIOxOx("mContinueView");
        }
        aVar.a((View) textView);
        com.baidu.navisdk.pronavi.style.i.a aVar2 = this.r;
        IIX0o.ooOOo0oXI(aVar2);
        aVar2.a("RGContinueNavi");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        if (this.t == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                IIX0o.XOxIOxOx("continueViewLayout");
            }
            if (viewGroup != null) {
                com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
                IIX0o.oO(context, "context");
                Context a2 = context.a();
                ViewGroup viewGroup2 = this.p;
                if (viewGroup2 == null) {
                    IIX0o.XOxIOxOx("continueViewLayout");
                }
                this.t = new com.baidu.navisdk.pronavi.ui.driving.a(a2, viewGroup2);
            }
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.t;
        if (aVar != null) {
            aVar.y();
        }
    }

    private final void I() {
        try {
            if (this.o == 1) {
                TextView textView = this.q;
                if (textView == null) {
                    IIX0o.XOxIOxOx("mContinueView");
                }
                textView.setTextSize(1, 21.0f);
                return;
            }
            TextView textView2 = this.q;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("mContinueView");
            }
            textView2.setTextSize(1, 17.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final /* synthetic */ TextView a(RGNewContinueComponent rGNewContinueComponent) {
        TextView textView = rGNewContinueComponent.q;
        if (textView == null) {
            IIX0o.XOxIOxOx("mContinueView");
        }
        return textView;
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        E();
        F();
        C();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.t;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewContinueComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_bottombar_new_ly;
    }

    private final void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "setContinueViewVisible: " + i);
        }
        ViewGroup viewGroup = this.p;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("continueViewLayout");
        }
        viewGroup.setVisibility(i);
        if (i == 0) {
            H();
        } else {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c(int i) {
        if (i == 8) {
            b(8);
            ((com.baidu.navisdk.pronavi.ui.base.b) n()).j().e("RGNewEtaComponent").a(6001).a();
        } else {
            b(0);
            I();
            ((com.baidu.navisdk.pronavi.ui.base.b) n()).j().e("RGNewEtaComponent").a(6002).a();
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        int d2 = api.d();
        if (d2 == 1) {
            b(0);
            return null;
        }
        if (d2 != 2) {
            return super.a(api);
        }
        b(8);
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@OOXIXo Configuration newConfig) {
        IIX0o.x0xO0oo(newConfig, "newConfig");
        super.a(newConfig);
        I();
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.t;
        if (aVar != null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                IIX0o.XOxIOxOx("continueViewLayout");
            }
            aVar.a(viewGroup, newConfig.orientation);
        }
    }
}
