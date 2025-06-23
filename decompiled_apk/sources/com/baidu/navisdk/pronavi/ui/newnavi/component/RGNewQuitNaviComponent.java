package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.pronavi.data.vm.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewQuitNaviComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> implements com.baidu.navisdk.framework.interfaces.pronavi.hd.b {
    private com.baidu.navisdk.pronavi.ui.newnavi.bottom.b p;
    private View q;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            View a2 = RGNewQuitNaviComponent.a(RGNewQuitNaviComponent.this);
            IIX0o.oO(it, "it");
            a2.setVisibility(it.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<p> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(p pVar) {
            if (pVar != null) {
                if (pVar == p.BOTTOM) {
                    View a2 = RGNewQuitNaviComponent.a(RGNewQuitNaviComponent.this);
                    f D = RGNewQuitNaviComponent.this.D();
                    IIX0o.ooOOo0oXI(D);
                    Integer value = D.c().getValue();
                    IIX0o.ooOOo0oXI(value);
                    a2.setVisibility(value.intValue());
                    return;
                }
                RGNewQuitNaviComponent.a(RGNewQuitNaviComponent.this).setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewQuitNaviComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void C() {
        com.baidu.navisdk.framework.lifecycle.b<p> d;
        MutableLiveData<Integer> c;
        f D = D();
        if (D != null && (c = D.c()) != null) {
            c.observe(this, new a());
        }
        f D2 = D();
        if (D2 != null && (d = D2.d()) != null) {
            d.observe(this, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final f D() {
        return (f) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(f.class);
    }

    private final void E() {
        View findViewById = this.j.findViewById(R.id.bn_rg_bottombar_new_right_ly);
        IIX0o.oO(findViewById, "mContainerView.findViewB…g_bottombar_new_right_ly)");
        this.q = findViewById;
    }

    public static final /* synthetic */ View a(RGNewQuitNaviComponent rGNewQuitNaviComponent) {
        View view = rGNewQuitNaviComponent.q;
        if (view == null) {
            IIX0o.XOxIOxOx("exitBtn");
        }
        return view;
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, @oOoXoXO com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, @oOoXoXO com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, @oOoXoXO com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        E();
        C();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewQuitNaviComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_bottombar_new_ly;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        switch (api.d()) {
            case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                View view = this.q;
                if (view == null) {
                    IIX0o.XOxIOxOx("exitBtn");
                }
                view.setVisibility(0);
                return null;
            case 7002:
                View view2 = this.q;
                if (view2 == null) {
                    IIX0o.XOxIOxOx("exitBtn");
                }
                view2.setVisibility(4);
                return null;
            case 7003:
                h a2 = h.a();
                Object a3 = api.a("root_view_group");
                IIX0o.oO(a3, "api.get(RGUI.Component.N…Navi.Key.ROOT_VIEW_GROUP)");
                return a2.a(a((ViewGroup) a3, (ViewGroup) api.a("setting_root_view")));
            case 7004:
                return h.a().a(this);
            default:
                return super.a(api);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.baidu.navisdk.module.newguide.subviews.a a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (this.p == null) {
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
            IIX0o.oO(context, "context");
            this.p = new com.baidu.navisdk.pronavi.ui.newnavi.bottom.b(context.a(), viewGroup, viewGroup2);
        }
        com.baidu.navisdk.pronavi.ui.newnavi.bottom.b bVar = this.p;
        IIX0o.ooOOo0oXI(bVar);
        return bVar;
    }
}
