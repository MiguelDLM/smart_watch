package com.baidu.navisdk.module.newguide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.abs.c;
import com.baidu.navisdk.module.newguide.abs.d;
import com.baidu.navisdk.module.newguide.abs.e;
import com.baidu.navisdk.module.newguide.subviews.guides.h;
import com.baidu.navisdk.module.newguide.subviews.guides.i;
import com.baidu.navisdk.module.newguide.subviews.guides.j;
import com.baidu.navisdk.ui.routeguide.control.m;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.f0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.t;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.x0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.y;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f7212a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7213a = new a();
    }

    public static a e() {
        return b.f7213a;
    }

    public boolean a(int i) {
        return (i != 1 || !this.f7212a || com.baidu.navisdk.ui.routeguide.b.V().q() == 3 || com.baidu.navisdk.ui.routeguide.b.V().A() || BNSettingManager.isUseOldSetting()) ? false : true;
    }

    public t b(boolean z, Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (z) {
            return new h(context, viewGroup, aVar);
        }
        return new t(context, viewGroup, aVar);
    }

    public d c(boolean z, Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (z) {
            return new i(context, viewGroup, aVar);
        }
        return new y(context, viewGroup, aVar);
    }

    public boolean d() {
        return a(com.baidu.navisdk.module.vehiclemanager.b.i().b());
    }

    private a() {
        this.f7212a = true;
        this.f7212a = com.baidu.navisdk.module.cloudconfig.a.b().a("rg_is_switch_new_guide", true);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNewOldFuncController", "RGNewOldFuncController: " + this.f7212a);
        }
    }

    public com.baidu.navisdk.module.newguide.interfaces.a d(boolean z, Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (z) {
            return new com.baidu.navisdk.module.newguide.subviews.guides.d(context, viewGroup, aVar);
        }
        return new f0(context, viewGroup, aVar);
    }

    public e e(boolean z, Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (z) {
            return new j(context, viewGroup, aVar);
        }
        return new x0(context, viewGroup, aVar);
    }

    public String b() {
        return d() ? "定位信号弱" : "弱";
    }

    public int c() {
        if (d()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_height) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_route_detail_exposed_indicate_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_panel_height);
    }

    public void a(View view) {
        if (d()) {
            ViewCompat.setBackground(view, com.baidu.navisdk.ui.util.b.f(R.drawable.bn_bg_rg_default_guide_view));
        } else {
            ViewCompat.setBackground(view, com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
        }
    }

    public void a(View view, @DrawableRes int i) {
        ViewCompat.setBackground(view, com.baidu.navisdk.ui.util.b.f(i));
    }

    public c a(boolean z, View view) {
        if (z) {
            return new com.baidu.navisdk.module.newguide.controllers.b(view);
        }
        return new m(view);
    }

    public com.baidu.navisdk.module.newguide.abs.b a(Context context, ViewGroup viewGroup, int i) {
        return new com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.c(context, viewGroup, null, i);
    }

    public com.baidu.navisdk.module.newguide.subviews.d a(boolean z, Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (z) {
            return null;
        }
        return new com.baidu.navisdk.module.newguide.subviews.d(context, viewGroup, aVar);
    }

    public int a() {
        if (d()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_bottom_margin);
    }

    public int a(boolean z, boolean z2) {
        if (z2 && d()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
        }
        if (z) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_9dp);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_11dp);
    }

    public boolean a(int i, boolean z) {
        if (!z || !d()) {
            return true;
        }
        if (!BNSettingManager.containsIsShowRGZoomInBtnKey()) {
            BNSettingManager.setIsShowRGZoomInBtn(i > ((((JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_zoom_layout_height_new) * 2) + (JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new) * 4)) + (JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin) + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_bottom))) + ((JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_follow_guide_height) + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_default_top_guide_panel_height)) + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_panel_margin_top))) + ScreenUtil.getInstance().getStatusBarHeightFullScreen(com.baidu.navisdk.framework.a.c().a()));
        }
        return BNSettingManager.isShowRGZoomInBtn();
    }
}
