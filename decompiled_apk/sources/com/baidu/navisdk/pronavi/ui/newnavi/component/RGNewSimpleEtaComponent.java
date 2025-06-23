package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.subviews.e;
import com.baidu.navisdk.pronavi.data.model.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewSimpleEtaComponent extends RGUiComponent<b> {
    private e p;
    private View q;
    private TextView r;
    private TextView s;
    private View t;
    private boolean u;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<com.baidu.navisdk.pronavi.logic.service.parkrec.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(@oOoXoXO com.baidu.navisdk.pronavi.logic.service.parkrec.a aVar) {
            String c;
            if (aVar != null) {
                if (!aVar.d()) {
                    View view = RGNewSimpleEtaComponent.this.q;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    View view2 = RGNewSimpleEtaComponent.this.t;
                    if (view2 != null) {
                        view2.setVisibility(0);
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.model.datastruct.destrec.e b = aVar.b();
                if (b != null && (c = b.c()) != null && c.length() > 0) {
                    if (RGNewSimpleEtaComponent.this.u) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.24.1471", null, null, null);
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1472", null, null, null);
                    }
                    RGNewSimpleEtaComponent.this.d(c);
                    View view3 = RGNewSimpleEtaComponent.this.q;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    View view4 = RGNewSimpleEtaComponent.this.t;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewSimpleEtaComponent(@OOXIXo b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.u = true;
    }

    private final void C() {
        ViewGroup r = r();
        if (r != null) {
            if (this.q == null) {
                this.q = r.findViewById(R.id.bnav_rg_new_rec_parking_ll);
                this.r = (TextView) r.findViewById(R.id.bnav_rg_new_rec_parking_tip);
                this.s = (TextView) r.findViewById(R.id.bnav_rg_new_rec_parking_location);
            }
            if (this.t == null) {
                this.t = r.findViewById(R.id.bnav_rg_new_eta_time_ll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void d(String str) {
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(str);
        }
        b context = (b) n();
        IIX0o.oO(context, "context");
        b(context.o());
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        C();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        this.u = true;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewSimpleEtaComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bnav_rg_simple_eta_ly;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void s() {
        super.s();
        f fVar = (f) ((b) this.i).b(f.class);
        if (fVar != null) {
            fVar.b().observe(this, new a());
        }
    }

    private final void b(int i) {
        if (i == 1) {
            TextView textView = this.r;
            if (textView != null) {
                textView.setTextSize(1, 20.0f);
            }
            TextView textView2 = this.s;
            if (textView2 != null) {
                textView2.setTextSize(1, 20.0f);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setTextSize(1, 17.0f);
        }
        TextView textView4 = this.s;
        if (textView4 != null) {
            textView4.setTextSize(1, 17.0f);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        super.a(configuration);
        if (configuration != null) {
            b(configuration.orientation);
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        int d = api.d();
        if (d == 1) {
            ViewGroup r = r();
            if (r != null) {
                r.setVisibility(0);
            }
            return null;
        }
        if (d == 2) {
            ViewGroup r2 = r();
            if (r2 != null) {
                r2.setVisibility(4);
            }
            return null;
        }
        if (d == 3) {
            h a2 = h.a();
            Object a3 = api.a("root_view_group");
            IIX0o.oO(a3, "api.get(RGUI.Component.NewEta.Key.ROOT_VIEW_GROUP)");
            return a2.b("resultA", a((ViewGroup) a3));
        }
        if (d != 4) {
            if (d != 5) {
                return super.a(api);
            }
            View view = this.q;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.t;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            return null;
        }
        String d2 = api.d("paramA");
        if (d2 != null) {
            d(d2);
        }
        View view3 = this.q;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.t;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final e a(ViewGroup viewGroup) {
        if (this.p == null) {
            b context = (b) n();
            IIX0o.oO(context, "context");
            this.p = new e(context.a(), viewGroup);
        }
        e eVar = this.p;
        IIX0o.ooOOo0oXI(eVar);
        return eVar;
    }
}
