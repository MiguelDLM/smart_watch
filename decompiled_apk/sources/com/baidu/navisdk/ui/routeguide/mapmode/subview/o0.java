package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class o0 extends com.baidu.navisdk.ui.routeguide.mapmode.iview.a {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.module.routepreference.views.b {
        public a(o0 o0Var, Context context, ViewGroup viewGroup, View view, ViewGroup viewGroup2, com.baidu.navisdk.module.routepreference.interfaces.a aVar, int i) {
            super(context, viewGroup, view, viewGroup2, aVar, i);
        }

        @Override // com.baidu.navisdk.module.routepreference.views.b
        public boolean A() {
            return false;
        }

        @Override // com.baidu.navisdk.module.routepreference.views.b
        public boolean C() {
            return false;
        }

        @Override // com.baidu.navisdk.module.routepreference.views.b, com.baidu.navisdk.module.routepreference.interfaces.b
        public boolean a() {
            return false;
        }

        @Override // com.baidu.navisdk.module.routepreference.interfaces.b
        public boolean c() {
            return true;
        }

        @Override // com.baidu.navisdk.module.routepreference.interfaces.b
        public boolean d() {
            return false;
        }
    }

    public o0() {
        super(1);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.a
    public com.baidu.navisdk.module.routepreference.views.d a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        return new a(this, com.baidu.navisdk.ui.routeguide.b.V().c(), null, viewGroup.findViewById(R.id.bnav_rg_route_sort_panel), viewGroup2, this, 3);
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void b(boolean z, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMRoutePreferencePane", "RGMMRoutePreferPanel onClickItemAction isChange: " + z + ",selectedPreferValue: " + i);
        }
        g();
        if (z) {
            com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
            com.baidu.navisdk.ui.routeguide.model.a0.G = 2;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(i), "1", null);
            com.baidu.navisdk.ui.routeguide.control.l.l().i();
        }
    }
}
