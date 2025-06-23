package com.baidu.navisdk.ui.routeguide.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.abtest.model.h;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final com.baidu.navisdk.framework.interfaces.pronavi.hd.f f9152a = new com.baidu.navisdk.framework.interfaces.pronavi.hd.f();

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9153a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        public a(View view, String str, int i) {
            this.f9153a = view;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f9153a;
            if (view != null && view.getLayoutParams() != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9153a.getLayoutParams();
                if ("left".equals(this.b)) {
                    marginLayoutParams.leftMargin = this.c;
                } else if ("top".equals(this.b)) {
                    marginLayoutParams.topMargin = this.c;
                } else if ("right".equals(this.b)) {
                    marginLayoutParams.rightMargin = this.c;
                } else if ("bottom".equals(this.b)) {
                    marginLayoutParams.bottomMargin = this.c;
                }
                this.f9153a.setLayoutParams(marginLayoutParams);
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNProNaviInnerUtil", "moveLocation view = " + this.f9153a + ", margin = " + this.c + ", direction=" + this.b);
            }
        }
    }

    public static boolean A() {
        return com.baidu.navisdk.module.newguide.a.e().d();
    }

    public static void B() {
        d(false);
    }

    public static void C() {
        e(false);
    }

    public static void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "exitFullHDNavi: " + str);
        }
        if (A()) {
            com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j != null ? j.c(false) : null;
            if (c == null || c.j() != 3) {
                return;
            }
            c.a(0, str, true);
        }
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b(boolean z) {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.c(z);
        }
        return null;
    }

    public static boolean c(int i) {
        return i == 2 || i == 3;
    }

    public static int d() {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_bar_new_eta_height);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_panel_height);
    }

    public static long e() {
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c;
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        return (j == null || (c = j.c(false)) == null || c.j() != 3) ? 10000L : 3000L;
    }

    @Nullable
    public static com.baidu.navisdk.pronavi.carlogooffset.i.b f() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.d();
        }
        return null;
    }

    @Nullable
    public static com.baidu.navisdk.pronavi.style.i.b g() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.b(true);
        }
        return null;
    }

    public static int h() {
        if (!c(o().f6817a)) {
            return BNCommSettingManager.getInstance().getFloatMode();
        }
        return 1;
    }

    public static int i() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c;
        if (!A() || (j = com.baidu.navisdk.ui.routeguide.b.V().j()) == null || (c = j.c(false)) == null || !c.g()) {
            return 0;
        }
        return c.j();
    }

    public static int j() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width_new);
    }

    public static int k() {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_80dp);
    }

    public static int l() {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return j();
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_left_panel_width);
    }

    @Nullable
    public static com.baidu.navisdk.pronavi.mapshow.i.b m() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.h();
        }
        return null;
    }

    public static int n() {
        int i;
        com.baidu.navisdk.module.pronavi.model.f n = com.baidu.navisdk.ui.routeguide.b.V().n();
        if (n != null) {
            i = n.g();
        } else {
            i = 2;
        }
        if (i == 1) {
            return 15;
        }
        return 3;
    }

    @NonNull
    public static com.baidu.navisdk.framework.interfaces.pronavi.hd.f o() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j.c(false);
            if (c != null && c.g()) {
                return c.a();
            }
            com.baidu.navisdk.ui.routeguide.ar.a a2 = j.a(false);
            if (a2 != null && a2.k()) {
                return a2.a();
            }
            com.baidu.navisdk.pronavi.hd.normal.i.a d = j.d(false);
            if (d != null && d.e()) {
                return d.a();
            }
        }
        return f9152a;
    }

    public static int p() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_height_new);
    }

    public static int q() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_width);
    }

    public static int r() {
        return ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
    }

    public static boolean s() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        com.baidu.navisdk.ui.routeguide.ar.a a2;
        if (!z() || (j = com.baidu.navisdk.ui.routeguide.b.V().j()) == null || (a2 = j.a(false)) == null || !a2.k()) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c;
        if (!A() || (j = com.baidu.navisdk.ui.routeguide.b.V().j()) == null || (c = j.c(false)) == null || !c.g() || c.j() != 3) {
            return false;
        }
        return true;
    }

    public static boolean u() {
        com.baidu.navisdk.pronavi.hd.normal.i.a d;
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j == null || (d = j.d(false)) == null || !d.e()) {
            return false;
        }
        return true;
    }

    public static boolean v() {
        if (Build.VERSION.SDK_INT >= 26 && BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            if (BNCommSettingManager.getInstance().getFloatMode() != 0) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("kpkkikkpk", "isPipMode is not pip mode");
                }
                return false;
            }
            return com.baidu.navisdk.ui.routeguide.b.V().B();
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("BNProNaviInnerUtil", "isPipMode device not support");
        }
        return false;
    }

    public static boolean w() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j.c(false);
            if (c != null && c.g()) {
                return true;
            }
            com.baidu.navisdk.ui.routeguide.ar.a a2 = j.a(false);
            if (a2 != null && a2.k()) {
                return true;
            }
            com.baidu.navisdk.pronavi.hd.normal.i.a d = j.d(false);
            if (d != null) {
                return d.g();
            }
        }
        return false;
    }

    public static boolean x() {
        com.baidu.navisdk.pronavi.hd.normal.i.a d;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "isDefaultGuidePanelMode isIndoorParkNavi:" + com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j() + ",getSimpleGuideMode:" + BNCommSettingManager.getInstance().getSimpleGuideMode() + "isEnable:" + com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a());
        }
        boolean s2 = x.b().s2();
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j.c(false);
            if (c != null && c.g()) {
                if (gVar.d()) {
                    gVar.e("BNProNaviInnerUtil", "isDefaultGuidePanelMode: isLaneNaviState");
                }
                return false;
            }
            com.baidu.navisdk.ui.routeguide.ar.a a2 = j.a(false);
            if (a2 != null && a2.k()) {
                return false;
            }
            if (!s2 && (d = j.d(false)) != null && d.e()) {
                return false;
            }
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            return false;
        }
        if (s2 && BNCommSettingManager.getInstance().getSimpleGuideMode() != 0 && com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a()) {
            return false;
        }
        return true;
    }

    public static boolean y() {
        int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "isShowRoadBar:mapSwitch " + isShowMapSwitch);
        }
        if (isShowMapSwitch == 0 && !t()) {
            return false;
        }
        return true;
    }

    public static boolean z() {
        return com.baidu.navisdk.module.newguide.a.e().d();
    }

    public static int c() {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_bar_new_height);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_panel_height);
    }

    public static boolean b(String str, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "exitNormalAndHDNavi: " + str);
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j != null ? j.c(false) : null;
        if (c != null && c.g()) {
            c.a(0, str, z);
            return true;
        }
        com.baidu.navisdk.pronavi.hd.normal.i.a d = j != null ? j.d(false) : null;
        if (d == null || !d.e()) {
            return false;
        }
        d.a(str, z);
        return true;
    }

    public static void d(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "setInitHDMapModeToRGEngine: ");
        }
        boolean z2 = false;
        boolean z3 = BNCommSettingManager.getInstance().isHdNaviEnable() && A();
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "setInitHDMapModeToRGEngine: " + z3 + ",isMockGuide: " + com.baidu.navisdk.util.common.x.s() + "," + com.baidu.navisdk.module.cloudconfig.f.c().I.c);
        }
        boolean s = com.baidu.navisdk.util.common.x.s();
        if (s && gVar.d() && gVar.c()) {
            s = false;
        }
        if (!z && !s && !com.baidu.navisdk.module.cloudconfig.f.c().I.c) {
            z2 = z3;
        }
        BNRouteGuider.getInstance().setHdLaneMapMode(z2);
    }

    public static void e(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "setInitNormalHDMapModeToRGEngine: isArNavi = " + z);
        }
        boolean z2 = BNCommSettingManager.getInstance().isNormalHdNaviEnable() && A();
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "setInitNormalHDMapModeToRGEngine: isSupportHDHdLaneMapMode = " + z2 + ",isMockGuide: " + com.baidu.navisdk.util.common.x.s() + "," + com.baidu.navisdk.module.cloudconfig.f.c().U.b + "," + h.v());
        }
        boolean s = com.baidu.navisdk.util.common.x.s();
        if (s && gVar.d() && gVar.c()) {
            s = false;
        }
        if (s || com.baidu.navisdk.module.cloudconfig.f.c().U.b || !com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM.a() || !h.v()) {
            z2 = false;
        }
        BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(z ? false : z2);
    }

    public static com.baidu.navisdk.pronavi.hd.normal.i.a c(boolean z) {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.d(z);
        }
        return null;
    }

    public static boolean a(String str, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "exitHDNavi: " + str);
        }
        if (!A()) {
            return false;
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j != null ? j.c(false) : null;
        if (c == null || !c.g()) {
            return false;
        }
        c.a(0, str, z);
        return true;
    }

    public static void b(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNProNaviInnerUtil", "onExitHDNaviForRouteYawing: " + str);
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j != null ? j.c(false) : null;
        if (c != null) {
            c.b(str);
        }
    }

    public static int a(Activity activity) {
        int d = com.baidu.navisdk.pronavi.util.a.h.d();
        return com.baidu.navisdk.ui.routeguide.b.V().r().g() ? d + ScreenUtil.getInstance().getStatusBarHeight(activity) : d;
    }

    public static int b() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        com.baidu.navisdk.ui.routeguide.ar.a a2;
        if (!z() || (j = com.baidu.navisdk.ui.routeguide.b.V().j()) == null || (a2 = j.a(false)) == null) {
            return 0;
        }
        return a2.j();
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        if (z() && (j = com.baidu.navisdk.ui.routeguide.b.V().j()) != null) {
            return j.a(false);
        }
        return null;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "小度";
            case 2:
                return "码表";
            case 3:
                return "区间测速";
            case 4:
                return "主辅路";
            case 5:
                return "桥上桥下";
            case 6:
                return "导航保障";
            case 7:
                return "行程分享";
            case 8:
                return "UGC";
            case 9:
                return "moss";
            case 10:
                return "景区播报";
            case 11:
                return " 路况开关";
            case 12:
                return "播报模式";
            case 13:
            case 20:
            case 28:
            case 29:
            case 36:
            case 37:
            case 38:
            case 39:
            default:
                return "按钮:" + i;
            case 14:
                return "路线刷新";
            case 15:
                return "离转正";
            case 16:
                return "放大缩小";
            case 17:
                return "导航设置";
            case 18:
                return "天气面板";
            case 19:
                return "服务器面板";
            case 21:
                return "天气";
            case 22:
                return "全览";
            case 23:
                return "路况条";
            case 24:
                return "mini 小窗";
            case 25:
                return "车道级双图";
            case 26:
                return "退出车道级";
            case 27:
                return "voiceAid";
            case 30:
                return "新能源充电站";
            case 31:
                return "AR切到经典导航";
            case 32:
                return "AR横竖屏切换";
            case 33:
                return "AR全屏分屏切换";
            case 34:
                return "AR退出导航";
            case 35:
                return "充电站提示条";
            case 40:
                return "固定按钮集";
            case 41:
                return "动态按钮集";
            case 42:
                return "智能高速速度面板";
            case 43:
                return "智能高速区间测速面板";
        }
    }

    @NonNull
    public static com.baidu.navisdk.framework.interfaces.pronavi.hd.f b(int i) {
        com.baidu.navisdk.pronavi.hd.normal.i.a d;
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            if (i == 1) {
                com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j.c(false);
                if (c != null && c.g()) {
                    return c.a();
                }
            } else if (i == 2) {
                com.baidu.navisdk.ui.routeguide.ar.a a2 = j.a(false);
                if (a2 != null && a2.k()) {
                    return a2.a();
                }
            } else if (i == 3 && (d = j.d(false)) != null && d.e()) {
                return d.a();
            }
        }
        return f9152a;
    }

    public static int a(boolean z) {
        com.baidu.navisdk.ui.routeguide.ar.a a2;
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j == null || (a2 = j.a(false)) == null || !a2.k()) {
            return 0;
        }
        return a2.b(z);
    }

    public static int a(boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (fVar == null) {
            fVar = o();
        }
        if (fVar == null || fVar.f6817a != 2) {
            return 0;
        }
        return z ? fVar.b : fVar.c;
    }

    public static void a(View view, int i, String str) {
        a(view, i, str, true);
    }

    public static void a(View view, int i, String str, boolean z) {
        if ((com.baidu.navisdk.module.pronavi.a.j == 2 && ("top".equals(str) || "bottom".equals(str))) || view == null) {
            return;
        }
        a aVar = new a(view, str, i);
        if (z) {
            view.post(aVar);
        } else {
            aVar.run();
        }
    }
}
