package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.destrec.e;
import com.baidu.navisdk.module.newguide.subviews.c;
import com.baidu.navisdk.pronavi.data.model.f;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.google.android.exoplayer2.PlaybackException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewEtaComponent extends RGUiComponent<b> {
    private com.baidu.navisdk.pronavi.ui.newnavi.bottom.a p;
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
                    View view = RGNewEtaComponent.this.q;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    View view2 = RGNewEtaComponent.this.t;
                    if (view2 != null) {
                        view2.setVisibility(0);
                        return;
                    }
                    return;
                }
                e b = aVar.b();
                if (b != null && (c = b.c()) != null && c.length() > 0) {
                    if (RGNewEtaComponent.this.u) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.24.1471", null, null, null);
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1472", null, null, null);
                    }
                    RGNewEtaComponent.this.u = false;
                    RGNewEtaComponent.this.d(c);
                    View view3 = RGNewEtaComponent.this.q;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    View view4 = RGNewEtaComponent.this.t;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewEtaComponent(@OOXIXo b context) {
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
        return "RGNewEtaComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_bottombar_new_eta_ly;
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
        switch (api.d()) {
            case 6001:
                ViewGroup r = r();
                if (r != null) {
                    r.setVisibility(0);
                }
                return null;
            case 6002:
                ViewGroup r2 = r();
                if (r2 != null) {
                    r2.setVisibility(4);
                }
                return null;
            case PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR /* 6003 */:
                h a2 = h.a();
                Object a3 = api.a("root_view_group");
                IIX0o.oO(a3, "api.get(RGUI.Component.NewEta.Key.ROOT_VIEW_GROUP)");
                return a2.b("resultA", a((ViewGroup) a3, (com.baidu.navisdk.ui.routeguide.subview.a) api.a("rg_subview_listener"), (ViewGroup) api.a("setting_root_view")));
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                String d = api.d("paramA");
                if (d != null) {
                    d(d);
                }
                View view = this.q;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = this.t;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                return null;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                View view3 = this.q;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                View view4 = this.t;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                return null;
            default:
                return super.a(api);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final c a(ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, ViewGroup viewGroup2) {
        if (this.p == null) {
            b context = (b) n();
            IIX0o.oO(context, "context");
            Context a2 = context.a();
            IIX0o.oO(a2, "context.applicationContext");
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            LifecycleOwner f = V.f();
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V2, "BNavigator.getInstance()");
            this.p = new com.baidu.navisdk.pronavi.ui.newnavi.bottom.a(a2, viewGroup, aVar, f, V2.v(), viewGroup2);
        }
        com.baidu.navisdk.pronavi.ui.newnavi.bottom.a aVar2 = this.p;
        IIX0o.ooOOo0oXI(aVar2);
        return aVar2;
    }
}
