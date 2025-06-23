package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.pronavi.data.vm.g;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewMoreComponent extends RGUiComponent<b> implements com.baidu.navisdk.framework.interfaces.pronavi.hd.b {
    private View p;

    @oOoXoXO
    private g q;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<Integer> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            View a2 = RGNewMoreComponent.a(RGNewMoreComponent.this);
            IIX0o.oO(it, "it");
            a2.setVisibility(it.intValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewMoreComponent(@OOXIXo b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        MutableLiveData<Integer> c;
        g gVar = (g) ((b) n()).c(g.class);
        this.q = gVar;
        if (gVar != null && (c = gVar.c()) != null) {
            c.observe(this, new a());
        }
    }

    private final void D() {
        View findViewById = this.j.findViewById(R.id.bn_rg_bottombar_new_left_ly);
        IIX0o.oO(findViewById, "mContainerView.findViewB…rg_bottombar_new_left_ly)");
        this.p = findViewById;
    }

    public static final /* synthetic */ View a(RGNewMoreComponent rGNewMoreComponent) {
        View view = rGNewMoreComponent.p;
        if (view == null) {
            IIX0o.XOxIOxOx("moreBtn");
        }
        return view;
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, @oOoXoXO f fVar) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, @oOoXoXO f fVar) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, @oOoXoXO f fVar) {
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        D();
        C();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewMoreComponent";
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
            case 9001:
                View view = this.p;
                if (view == null) {
                    IIX0o.XOxIOxOx("moreBtn");
                }
                view.setVisibility(0);
                return null;
            case 9002:
                View view2 = this.p;
                if (view2 == null) {
                    IIX0o.XOxIOxOx("moreBtn");
                }
                view2.setVisibility(4);
                return null;
            case 9003:
                return h.a().a(this);
            default:
                return super.a(api);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        MutableLiveData<Integer> c;
        super.a(configuration);
        if (configuration != null && configuration.orientation == 2) {
            View view = this.p;
            if (view == null) {
                IIX0o.XOxIOxOx("moreBtn");
            }
            view.setVisibility(0);
            return;
        }
        if (configuration == null || configuration.orientation != 1) {
            return;
        }
        g gVar = this.q;
        Integer value = (gVar == null || (c = gVar.c()) == null) ? null : c.getValue();
        if (value != null) {
            int intValue = value.intValue();
            View view2 = this.p;
            if (view2 == null) {
                IIX0o.XOxIOxOx("moreBtn");
            }
            view2.setVisibility(intValue);
        }
    }
}
