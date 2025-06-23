package com.baidu.navisdk.ui.routeguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.interfaces.pronavi.f;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.framework.interfaces.pronavi.j;
import com.baidu.navisdk.framework.interfaces.pronavi.m;
import com.baidu.navisdk.framework.interfaces.pronavi.o;
import com.baidu.navisdk.framework.interfaces.y;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.routeguide.navicenter.impl.d;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b {
    private static volatile b c;
    private FrameLayout b = null;

    /* renamed from: a, reason: collision with root package name */
    private BNavigatorLogic f8506a = new BNavigatorLogic();

    private void U() {
        g.PRO_NAV.a("Bnavigator reset");
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.b = null;
        }
        this.f8506a.onDestroy();
        this.f8506a = null;
    }

    public static b V() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static boolean W() {
        return BNavigatorLogic.z0;
    }

    public boolean A() {
        return this.f8506a.W();
    }

    public boolean B() {
        return this.f8506a.a0();
    }

    public boolean C() {
        return this.f8506a.c0();
    }

    public boolean D() {
        if (q() == 7) {
            return true;
        }
        return false;
    }

    public boolean E() {
        if (q() == 3) {
            return true;
        }
        return false;
    }

    public boolean F() {
        m m;
        if (j() == null || (m = j().m()) == null) {
            return false;
        }
        return m.a();
    }

    public boolean G() {
        return this.f8506a.f0();
    }

    public void H() {
        this.f8506a.h0();
    }

    public void I() {
        this.f8506a.i0();
    }

    public void J() {
        this.f8506a.h();
    }

    public void K() {
        if (c != null) {
            synchronized (b.class) {
                try {
                    if (c != null) {
                        c.U();
                        c = null;
                    }
                } finally {
                }
            }
        }
    }

    public void L() {
        this.f8506a.k0();
    }

    public void M() {
        this.f8506a.onPause();
    }

    public void N() {
        this.f8506a.onResume();
    }

    public void O() {
        this.f8506a.onStart();
    }

    public void P() {
        this.f8506a.onStop();
    }

    public void Q() {
        a(false);
    }

    public void R() {
        this.f8506a.t0();
    }

    public void S() {
        this.f8506a.u0();
    }

    public void T() {
        this.f8506a.D0();
    }

    public void a(ViewModelStore viewModelStore, LifecycleOwner lifecycleOwner) {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            bNavigatorLogic.a(viewModelStore, lifecycleOwner);
        }
    }

    public Activity b() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic == null) {
            return null;
        }
        return bNavigatorLogic.c();
    }

    public Context c() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic == null) {
            return null;
        }
        return bNavigatorLogic.r();
    }

    public void d(boolean z) {
        this.f8506a.g(z);
    }

    public Handler e() {
        return this.f8506a.t();
    }

    @Nullable
    public LifecycleOwner f() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic == null) {
            return null;
        }
        return bNavigatorLogic.u();
    }

    public o g() {
        return this.f8506a.v();
    }

    public com.baidu.navisdk.logicframe.b h() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            return bNavigatorLogic.d();
        }
        return null;
    }

    public com.baidu.navisdk.ui.routeguide.navicenter.a i() {
        return this.f8506a.w();
    }

    @Nullable
    public com.baidu.navisdk.ui.routeguide.navicenter.c j() {
        return this.f8506a.x();
    }

    public j k() {
        return this.f8506a.y();
    }

    public i l() {
        return this.f8506a.z();
    }

    public f m() {
        return this.f8506a.A();
    }

    public com.baidu.navisdk.module.pronavi.model.f n() {
        return this.f8506a.B();
    }

    public com.baidu.navisdk.ui.routeguide.pip.b o() {
        return this.f8506a.C();
    }

    public boolean p() {
        return this.f8506a.g;
    }

    public int q() {
        return this.f8506a.E();
    }

    public d r() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            return bNavigatorLogic.G();
        }
        return null;
    }

    public com.baidu.navisdk.pronavi.ui.base.b s() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            return (com.baidu.navisdk.pronavi.ui.base.b) bNavigatorLogic.f();
        }
        return null;
    }

    public RGBaseUiFrame t() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            return bNavigatorLogic.g();
        }
        return null;
    }

    @Nullable
    public y[] u() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            return bNavigatorLogic.H();
        }
        return null;
    }

    @Nullable
    public ViewModelStore v() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic == null) {
            return null;
        }
        return bNavigatorLogic.J();
    }

    public void w() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            bNavigatorLogic.K();
        }
    }

    public boolean x() {
        return this.f8506a.L();
    }

    public void y() {
        this.f8506a.N();
    }

    public boolean z() {
        return this.f8506a.U();
    }

    public com.baidu.navisdk.ui.routeguide.navidiff.c d() {
        return this.f8506a.s();
    }

    public void e(boolean z) {
        this.f8506a.g = z;
    }

    public View a(Activity activity, Bundle bundle, View view) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onCreateView START");
        }
        if (activity == null) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "onCreateView START , activity == null!!!!, return!");
            }
            throw new RuntimeException("activity is a null object reference!");
        }
        return this.f8506a.a(activity, bundle, view);
    }

    public boolean b(Bundle bundle) {
        return this.f8506a.c(bundle);
    }

    public void c(boolean z) {
        this.f8506a.e(z);
    }

    public void b(int i, boolean z) {
        a(i, z, (Bundle) null);
    }

    public void b(boolean z) {
        this.f8506a.c(z);
    }

    public void b(String str, boolean z, Bundle bundle) {
        this.f8506a.a(str, z, bundle);
    }

    public void b(int i) {
        h().j().e("BNRoadConditionService").a(2).a(Integer.valueOf(i)).a();
    }

    public void a(o oVar) {
        this.f8506a.a(oVar);
    }

    public void a() {
        BNavigatorLogic bNavigatorLogic = this.f8506a;
        if (bNavigatorLogic != null) {
            bNavigatorLogic.l();
        }
    }

    public void a(boolean z) {
        b(3, z);
    }

    public void a(int i, boolean z, Bundle bundle) {
        this.f8506a.a(i, z, bundle);
    }

    public void a(Bundle bundle) {
        this.f8506a.a(bundle);
    }

    public void a(Configuration configuration) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onConfigurationChanged onStart");
        }
        this.f8506a.onConfigurationChanged(configuration);
        if (gVar.d()) {
            gVar.e("RouteGuide", "onConfigurationChanged end");
        }
    }

    public void a(int i, boolean z) {
        this.f8506a.a(i, z);
    }

    public void a(int i, int i2, Intent intent) {
        this.f8506a.onActivityResult(i, i2, intent);
    }

    public void a(String str, boolean z, Bundle bundle) {
        if (!com.baidu.navisdk.function.b.FUNC_UGC_DETAILS.a()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("showUgcDetailView: FUNC_UGC_DETAILS not enable");
                return;
            }
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.containsKey("source")) {
            bundle.putInt("source", 1);
        }
        if (!bundle.containsKey("page")) {
            bundle.putInt("page", 1);
        }
        this.f8506a.a(str, z, bundle);
    }

    public boolean a(String str, ArrayList<String> arrayList) {
        return l().a(str, arrayList);
    }

    public void a(@NonNull com.baidu.navisdk.comapi.routeplan.v2.b bVar, boolean z) {
        if (x.b().m2()) {
            g.PRO_NAV.a("calcRoute isInterceptRecalRouteOnVdrGuide ");
            BNRoutePlaner.getInstance().a(new com.baidu.navisdk.comapi.routeplan.v2.d(bVar), 3, 5300);
            return;
        }
        if (a0.I().w()) {
            g.PRO_NAV.a("calcRoute isInterceptRecalRouteOnPreYawing ");
            BNRoutePlaner.getInstance().a(new com.baidu.navisdk.comapi.routeplan.v2.d(bVar), 3, 5301);
            return;
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        RoutePlanNode g = fVar.g();
        RoutePlanNode routePlanNode = bVar.b;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "calcRoute(), oldEndNode=" + g + ", newEndNode=" + routePlanNode);
        }
        if (g != null && routePlanNode != null && (g.mUID != routePlanNode.mUID || g.getLatitudeE6() != routePlanNode.getLatitudeE6() || g.getLongitudeE6() != routePlanNode.getLongitudeE6() || g.mName != routePlanNode.mName)) {
            fVar.a((String) null);
        }
        if (bVar.r == null) {
            bVar.r = new Bundle();
        }
        if (j() != null) {
            m m = j().m();
            m.a(bVar.r, bVar.f);
            bVar.f = m.a(bVar.f);
        } else if (gVar.c()) {
            gVar.c("RouteGuide", "calcRouteV2 getModuleControlManager == null");
        }
        bVar.r.putInt(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE, com.baidu.navisdk.module.vehiclemanager.b.i().b());
        com.baidu.navisdk.module.pronavi.model.f n = V().n();
        if (n != null) {
            bVar.r.putInt("calc_route_sub_vehicle_type", n.f());
        }
        String i = fVar.i();
        if (!TextUtils.isEmpty(i)) {
            bVar.r.putString("permit_info_id", i);
        }
        BNRoutePlaner.getInstance().a(bVar, z);
    }

    public void a(Context context, Bundle bundle) {
        this.f8506a.a(context, bundle);
    }

    public void a(int i) {
        this.f8506a.a(i);
    }
}
