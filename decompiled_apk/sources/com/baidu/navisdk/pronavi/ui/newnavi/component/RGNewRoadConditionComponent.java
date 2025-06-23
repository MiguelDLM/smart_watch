package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.pronavi.data.vm.h;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.bottom.RGNewRoadArcView;
import com.baidu.navisdk.util.common.g;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewRoadConditionComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private RGNewRoadArcView p;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<Double> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Double carProgress) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewRoadConditionComponent.this).g, "bindRoadConditionVM: carProgress = " + carProgress);
            }
            RGNewRoadArcView rGNewRoadArcView = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView != null) {
                IIX0o.oO(carProgress, "carProgress");
                rGNewRoadArcView.a(carProgress.doubleValue());
            }
            RGNewRoadArcView rGNewRoadArcView2 = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView2 != null) {
                rGNewRoadArcView2.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<List<? extends m>> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<? extends m> list) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewRoadConditionComponent.this).g, "bindRoadConditionVM: data = " + list);
            }
            RGNewRoadArcView rGNewRoadArcView = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView != null) {
                rGNewRoadArcView.a(list);
            }
            RGNewRoadArcView rGNewRoadArcView2 = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView2 != null) {
                rGNewRoadArcView2.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<Integer> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer type) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNewRoadConditionComponent.this).g, "bindRoadConditionVM: type = " + type);
            }
            RGNewRoadArcView rGNewRoadArcView = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView != null) {
                IIX0o.oO(type, "type");
                rGNewRoadArcView.a(type.intValue());
            }
            RGNewRoadArcView rGNewRoadArcView2 = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView2 != null) {
                rGNewRoadArcView2.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements Observer<Integer> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 3) {
                RGNewRoadArcView rGNewRoadArcView = RGNewRoadConditionComponent.this.p;
                if (rGNewRoadArcView != null) {
                    rGNewRoadArcView.setVisibility(0);
                    return;
                }
                return;
            }
            RGNewRoadArcView rGNewRoadArcView2 = RGNewRoadConditionComponent.this.p;
            if (rGNewRoadArcView2 != null) {
                rGNewRoadArcView2.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RGNewRoadArcView f7944a;
        final /* synthetic */ RGNewRoadConditionComponent b;

        public e(RGNewRoadArcView rGNewRoadArcView, RGNewRoadConditionComponent rGNewRoadConditionComponent) {
            this.f7944a = rGNewRoadArcView;
            this.b = rGNewRoadConditionComponent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<m> list;
            com.baidu.navisdk.framework.lifecycle.b<Double> d;
            Double it;
            com.baidu.navisdk.framework.lifecycle.b<List<m>> f;
            RGNewRoadArcView rGNewRoadArcView = this.f7944a;
            h D = this.b.D();
            if (D != null && (f = D.f()) != null) {
                list = f.getValue();
            } else {
                list = null;
            }
            rGNewRoadArcView.a(list);
            h D2 = this.b.D();
            if (D2 != null && (d = D2.d()) != null && (it = d.getValue()) != null) {
                RGNewRoadArcView rGNewRoadArcView2 = this.f7944a;
                IIX0o.oO(it, "it");
                rGNewRoadArcView2.a(it.doubleValue());
            }
            this.f7944a.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewRoadConditionComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void C() {
        com.baidu.navisdk.framework.lifecycle.b<Integer> e2;
        com.baidu.navisdk.framework.lifecycle.b<Integer> c2;
        com.baidu.navisdk.framework.lifecycle.b<List<m>> f;
        com.baidu.navisdk.framework.lifecycle.b<Double> d2;
        h D = D();
        if (D != null && (d2 = D.d()) != null) {
            d2.observe(this, new a());
        }
        h D2 = D();
        if (D2 != null && (f = D2.f()) != null) {
            f.observe(this, new b());
        }
        h D3 = D();
        if (D3 != null && (c2 = D3.c()) != null) {
            c2.observe(this, new c());
        }
        h D4 = D();
        if (D4 != null && (e2 = D4.e()) != null) {
            e2.observe(this, new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final h D() {
        return (h) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(h.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E() {
        if (this.p == null) {
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
            IIX0o.oO(context, "context");
            Context a2 = context.a();
            IIX0o.oO(a2, "context.applicationContext");
            this.p = new RGNewRoadArcView(a2);
            r().addView(this.p);
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
        E();
        C();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        RGNewRoadArcView rGNewRoadArcView = this.p;
        if (rGNewRoadArcView != null) {
            r().removeView(rGNewRoadArcView);
        }
        this.p = null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewRoadConditionComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_bottombar_new_road_ly;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public com.baidu.navisdk.apicenter.h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        switch (api.d()) {
            case 8001:
                RGNewRoadArcView rGNewRoadArcView = this.p;
                if (rGNewRoadArcView != null) {
                    rGNewRoadArcView.setVisibility(0);
                }
                return null;
            case 8002:
                RGNewRoadArcView rGNewRoadArcView2 = this.p;
                if (rGNewRoadArcView2 != null) {
                    rGNewRoadArcView2.setVisibility(8);
                }
                return null;
            case 8003:
                BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
                IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
                if (bNCommSettingManager.getIsShowMapSwitch() == 3) {
                    RGNewRoadArcView rGNewRoadArcView3 = this.p;
                    if (rGNewRoadArcView3 != null) {
                        rGNewRoadArcView3.setVisibility(0);
                    }
                } else {
                    RGNewRoadArcView rGNewRoadArcView4 = this.p;
                    if (rGNewRoadArcView4 != null) {
                        rGNewRoadArcView4.setVisibility(8);
                    }
                }
                return null;
            default:
                return super.a(api);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        super.a(configuration);
        RGNewRoadArcView rGNewRoadArcView = this.p;
        if (rGNewRoadArcView != null) {
            rGNewRoadArcView.post(new e(rGNewRoadArcView, this));
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void a(boolean z) {
        super.a(z);
        RGNewRoadArcView rGNewRoadArcView = this.p;
        if (rGNewRoadArcView != null) {
            rGNewRoadArcView.a(z);
            rGNewRoadArcView.invalidate();
        }
    }
}
