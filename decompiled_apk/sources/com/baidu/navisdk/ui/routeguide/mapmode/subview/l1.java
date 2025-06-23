package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class l1 extends com.baidu.navisdk.ui.routeguide.mapmode.iview.a implements com.baidu.navisdk.module.routepreference.interfaces.a {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.module.motorbike.view.support.module.routeprefer.a {
        public a(l1 l1Var, Context context, ViewGroup viewGroup, View view, ViewGroup viewGroup2, com.baidu.navisdk.module.routepreference.interfaces.a aVar, int i) {
            super(context, viewGroup, view, viewGroup2, aVar, i);
        }

        @Override // com.baidu.navisdk.module.motorbike.view.support.module.routeprefer.a
        public boolean A() {
            return false;
        }

        @Override // com.baidu.navisdk.module.motorbike.view.support.module.routeprefer.a
        public boolean C() {
            return false;
        }

        @Override // com.baidu.navisdk.module.motorbike.view.support.module.routeprefer.a, com.baidu.navisdk.module.routepreference.interfaces.b
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

    public l1() {
        super(2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.a
    public com.baidu.navisdk.module.routepreference.views.d a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        return new a(this, com.baidu.navisdk.ui.routeguide.b.V().c(), null, viewGroup.findViewById(R.id.bnav_rg_route_sort_panel), viewGroup2, this, 3);
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void b(boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMotorRoutePreferencePanel", "RGMMRoutePreferPanel onClickItemAction isChange: " + z + ",selectedPreferValue: " + i);
        }
        g();
        if (z) {
            com.baidu.navisdk.ui.routeguide.model.a0.G = 2;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(i), "1", null);
            com.baidu.navisdk.ui.routeguide.control.l.l().i();
        }
    }
}
