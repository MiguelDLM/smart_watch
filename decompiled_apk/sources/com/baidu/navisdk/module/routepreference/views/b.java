package com.baidu.navisdk.module.routepreference.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.i;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b extends d {
    public b(Context context, ViewGroup viewGroup, View view, ViewGroup viewGroup2, com.baidu.navisdk.module.routepreference.interfaces.a aVar, int i) {
        super(context, viewGroup, view, viewGroup2, aVar, i);
    }

    private void h(int i) {
        if (!A()) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNCarRoutePreferPanel", "calcClickNoDefaultPrefer 1: " + BNSettingManager.isOpenRememberRoutePrefer() + ", " + BNSettingManager.getRememberPreferBubble() + ", clickPrefer:" + i);
        }
        if (BNSettingManager.getRememberPreferBubble() == -1) {
            return;
        }
        if (BNSettingManager.isOpenRememberRoutePrefer()) {
            BNSettingManager.setRememberPreferBubble(0);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNCarRoutePreferPanel", "calcClickNoDefaultPrefer 2: " + l());
        }
        int l = l();
        if ((i & l) == l) {
            BNSettingManager.setRememberPreferBubble(0);
        } else {
            BNSettingManager.setRememberPreferBubble(1);
        }
    }

    public boolean A() {
        throw null;
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        throw null;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean a() {
        throw null;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public int b() {
        return R.layout.nsdk_layout_route_sort_main_view;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void c(int i) {
        int i2;
        boolean z;
        int k = k();
        if ((k & 32) != 0) {
            i2 = i | 32;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if (i2 != k) {
            z = true;
        } else {
            z = false;
        }
        d(i2);
        if (B() || BNSettingManager.isOpenRememberRoutePrefer()) {
            z2 = true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNCarRoutePreferPanel", "handlerOnClickPrefer-> clickedPrefer=" + i + ", isRememberPrefer=" + z2 + ", isForceRememberPrefer=" + B());
        }
        if (C() && z2) {
            e(i2);
            com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
            if (aVar != null) {
                aVar.a(z, i);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.3", i + "", null, null);
        } else {
            com.baidu.navisdk.module.routepreference.interfaces.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.b(z, i);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.1", i + "", "" + this.k, null);
        }
        if (!z2 && C()) {
            h(i);
        }
        if (this.p && (i & 4) == 4) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("2.i.1.4");
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void d(int i) {
        com.baidu.navisdk.module.routepreference.d.j().f(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean e() {
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean f() {
        return false;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.b
    public boolean g() {
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int j() {
        return 3;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int k() {
        return com.baidu.navisdk.module.routepreference.d.j().f();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int l() {
        return BNSettingManager.getLastRouteSearchMCarPrefer();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> m() {
        return i.j().d;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public int n() {
        return BNSettingManager.getRouteSortDrivingHabitValue();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public ArrayList<j> o() {
        return i.j().c();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public String p() {
        return i.j().a(this.q, BNSettingManager.getRouteSortDrivingHabitValue());
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void s() {
        boolean isShowNoHighWayBubbleLast = BNSettingManager.isShowNoHighWayBubbleLast();
        this.p = isShowNoHighWayBubbleLast;
        if (isShowNoHighWayBubbleLast) {
            BNSettingManager.setShowNoHighWayBubble(false);
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean t() {
        return BNSettingManager.isOpenRememberRoutePrefer();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean u() {
        return i.j().e();
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public boolean v() {
        if (BNSettingManager.isOpenRememberRoutePrefer() || !a()) {
            return false;
        }
        int rememberPreferBubble = BNSettingManager.getRememberPreferBubble();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNCarRoutePreferPanel", "isShowRememberPreferBubble showRememberPreferBubble: " + rememberPreferBubble);
        }
        if (rememberPreferBubble == -1 || rememberPreferBubble < 1) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void a(boolean z) {
        BNSettingManager.setIsOpenRememberRoutePrefer(z);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void e(int i) {
        BNSettingManager.setLastRouteSearchMCarPrefer(i);
        BNSettingManager.setDefaultRouteSort(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void f(int i) {
        BNSettingManager.setRememberPreferBubble(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.views.d
    public void g(int i) {
        BNSettingManager.setRouteSortDrivingHabitValue(i);
    }
}
