package com.baidu.navisdk.lightnavi.controller;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6878a;

    private void h() {
        a.getInstance().e();
        BNRouteGuider.getInstance().setNaviMode(2);
        a.getInstance().f();
    }

    public View a(Activity activity) {
        return new FrameLayout(activity);
    }

    public void b() {
    }

    public void c() {
        com.baidu.navisdk.lightnavi.utils.c.a();
        a();
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        this.f6878a = false;
        h();
    }

    public boolean g() {
        return a.getInstance().a(0);
    }

    public void a(boolean z) {
        if (com.baidu.navisdk.j.d()) {
            b(z);
        }
    }

    public boolean b(boolean z) {
        LogUtil.e("LightNaviBasicLogicPresenter", "quitLightNavi switchToNavi --> " + z + ",mHasQuitLight=" + this.f6878a);
        if (this.f6878a) {
            return false;
        }
        this.f6878a = true;
        if (BNMapController.getInstance().getMapController() != null) {
            BNMapController.getInstance().getMapController().u(false);
        }
        BNMapController.getInstance().setRouteSearchStatus(false);
        a.getInstance().a(z);
        com.baidu.navisdk.lightnavi.asr.d.a();
        if (!z) {
            BNRouteGuider.getInstance().setBrowseStatus(false);
        }
        a.getInstance().m();
        BNRouteGuider.getInstance().setNaviMode(1);
        if (!z) {
            b.c().b();
            com.baidu.navisdk.util.statistic.userop.b.r().n();
        }
        if (BNMapController.getInstance().getMapController() != null) {
            BNMapController.getInstance().getMapController().k(true);
        }
        return true;
    }

    public void a() {
        int[] lightNaviRouteMargin = BNSettingManager.getLightNaviRouteMargin();
        if (lightNaviRouteMargin != null && lightNaviRouteMargin.length == 4) {
            com.baidu.navisdk.lightnavi.utils.c.a(lightNaviRouteMargin[0], lightNaviRouteMargin[1], lightNaviRouteMargin[2], lightNaviRouteMargin[3], BNMapController.getInstance().getScreenHeight(), BNMapController.getInstance().getScreenWidth());
        } else {
            com.baidu.navisdk.lightnavi.utils.c.b();
        }
    }
}
