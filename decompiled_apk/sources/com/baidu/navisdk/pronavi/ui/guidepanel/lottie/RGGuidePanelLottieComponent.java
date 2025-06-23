package com.baidu.navisdk.pronavi.ui.guidepanel.lottie;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.data.vm.b;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGGuidePanelLottieComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a p;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<b.C0313b> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(@oOoXoXO b.C0313b c0313b) {
            RGGuidePanelLottieComponent.this.a(c0313b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<Integer> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer guideMode) {
            RGGuidePanelLottieComponent rGGuidePanelLottieComponent = RGGuidePanelLottieComponent.this;
            IIX0o.oO(guideMode, "guideMode");
            rGGuidePanelLottieComponent.b(guideMode.intValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGGuidePanelLottieComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        int i2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onGuidePanelModeChange: " + i);
        }
        if (i == 1) {
            i2 = R.id.bnav_rg_simple_guide_lottie_anim_view;
        } else {
            i2 = R.id.bnav_rg_default_guide_panel_lottie_anim_view;
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a aVar = this.p;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        ViewGroup mContainerView = this.j;
        IIX0o.oO(mContainerView, "mContainerView");
        this.p = new com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a(mContainerView, R.id.bnav_rg_default_guide_panel_lottie_anim_view);
        com.baidu.navisdk.pronavi.data.vm.b bVar = (com.baidu.navisdk.pronavi.data.vm.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.data.vm.b.class);
        if (bVar != null) {
            bVar.d().observe(this, new a());
            bVar.c().observe(this, new b());
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGGuidePanelLottieComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bnav_rg_mapmode_main_layout_new;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        com.baidu.navisdk.framework.lifecycle.a<b.C0313b> d;
        super.a(configuration);
        com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a aVar = this.p;
        if (aVar != null) {
            ViewGroup mContainerView = this.j;
            IIX0o.oO(mContainerView, "mContainerView");
            aVar.a(mContainerView, configuration != null ? configuration.orientation : 1);
        }
        com.baidu.navisdk.pronavi.data.vm.b bVar = (com.baidu.navisdk.pronavi.data.vm.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.data.vm.b.class);
        a((bVar == null || (d = bVar.d()) == null) ? null : d.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b.C0313b c0313b) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleLottieAnimator: " + c0313b);
        }
        if (c0313b == null) {
            com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a aVar = this.p;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a(c0313b);
        }
    }
}
