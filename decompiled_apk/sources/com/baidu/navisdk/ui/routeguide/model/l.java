package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Locale;

/* loaded from: classes8.dex */
public class l {
    private static boolean d = false;
    public static int e;
    private static final int[] f = {R.string.nsdk_string_rg_nav_direction_north, R.string.nsdk_string_rg_nav_direction_northeast, R.string.nsdk_string_rg_nav_direction_east, R.string.nsdk_string_rg_nav_direction_southeast, R.string.nsdk_string_rg_nav_direction_south, R.string.nsdk_string_rg_nav_direction_southwest, R.string.nsdk_string_rg_nav_direction_west, R.string.nsdk_string_rg_nav_direction_northwest};
    private static l g = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8950a = false;
    private boolean b = false;
    private boolean c = false;

    public static l f() {
        if (g == null) {
            g = new l();
        }
        return g;
    }

    public static boolean g() {
        return d;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.f8950a;
    }

    public void e() {
        this.f8950a = false;
        d = false;
        this.c = false;
        e = 0;
    }

    public static int a(int i, int i2) {
        if (i2 <= 0) {
            return 100;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= i2) {
            return 100;
        }
        int i3 = (i * 100) / i2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public static void d(boolean z) {
        d = z;
    }

    public void b(boolean z) {
        this.f8950a = z;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public static String a(int i) {
        if (i >= 1000) {
            return String.valueOf(i / 1000);
        }
        if (i < 50) {
            return String.valueOf(0);
        }
        if (i >= 950) {
            return String.valueOf(1);
        }
        if ((i + 100) % 100 >= 50) {
            i += 50;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(i / 1000.0f));
    }

    public Bundle b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHUDDataModel", "simpleGuideToHUD");
        }
        Bundle bundle2 = new Bundle();
        int i = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        if (i >= 0) {
            if (gVar.d()) {
                gVar.e("hud", "containKey RemainDist");
            }
            bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.RemainDist, i);
        }
        if (bundle.containsKey("resid")) {
            if (gVar.d()) {
                gVar.e("hud", "containKey ResId");
            }
            bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.ResId, b(bundle.getInt("resid")));
        }
        if (bundle.containsKey("road_name")) {
            if (gVar.d()) {
                gVar.e("hud", "containKey RoadName");
            }
            bundle2.putString(RouteGuideParams.RGKey.HUDInfo.NextRoad, bundle.getString("road_name"));
        }
        bundle2.putString(RouteGuideParams.RGKey.HUDInfo.Direction, f().a().getString(RouteGuideParams.RGKey.HUDInfo.Direction));
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName)) {
            if (gVar.d()) {
                gVar.e("hud", "containKey CurRoadName");
            }
            bundle2.putString(RouteGuideParams.RGKey.HUDInfo.CurrentRoad, bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.Straight)) {
            if (gVar.d()) {
                gVar.e("hud", "containKey Straight");
            }
            bundle2.putBoolean(RouteGuideParams.RGKey.HUDInfo.Straight, bundle.getBoolean(RouteGuideParams.RGKey.SimpleGuideInfo.Straight));
        }
        bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.UpdateType, 1);
        return bundle2;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getHUDData(bundle);
        Bundle bundle2 = new Bundle();
        int i = bundle.getInt(RouteGuideParams.RGKey.HUDInfo.Direction);
        if (i > -1) {
            int[] iArr = f;
            if (i < iArr.length) {
                bundle2.putString(RouteGuideParams.RGKey.HUDInfo.Direction, JarUtils.getResources().getString(iArr[i]));
            }
        }
        return bundle2;
    }

    public Bundle a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHUDDataModel", "highWayDataToHUD");
        }
        Bundle bundle2 = new Bundle();
        int i = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitDirection, -1);
        if (i != -1) {
            bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.ExitDirection, i);
        }
        int i2 = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist);
        if (i2 >= 0) {
            if (gVar.d()) {
                gVar.e("hud", "containKey ExitRemainDist");
            }
            bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.EixtRemainDistance, i2);
        }
        String string = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitNextRoadName);
        if (string != null) {
            if (gVar.d()) {
                gVar.e("hud", "containKey ExitNextRoad");
            }
            bundle2.putString(RouteGuideParams.RGKey.HUDInfo.ExitNextRoad, string);
        }
        String string2 = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitICCode);
        if (!l0.c(string2)) {
            bundle2.putString(RouteGuideParams.RGKey.HUDInfo.ExitICode, string2);
        }
        String string3 = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitDirectionName);
        if (!l0.c(string3)) {
            if (gVar.d()) {
                gVar.e("hud", "containKey ExitDirectionName");
            }
            bundle2.putString(RouteGuideParams.RGKey.HUDInfo.ExitDirectionName, string3);
        }
        bundle2.putBoolean(RouteGuideParams.RGKey.HUDInfo.HighAlong, bundle.getBoolean(RouteGuideParams.RGKey.HighWayInfo.HideInfo));
        bundle2.putInt(RouteGuideParams.RGKey.HUDInfo.UpdateType, 2);
        return bundle2;
    }

    private int b(int i) {
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_back) {
            return R.drawable.nsdk_drawable_rg_hud_turn_back;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_branch_center) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_center;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_dest) {
            return R.drawable.nsdk_drawable_rg_hud_turn_dest;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front) {
            return R.drawable.nsdk_drawable_rg_hud_turn_front;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_back) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_back;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_front) {
            return R.drawable.nsdk_drawable_rg_hud_turn_front;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_side) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_side;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_side_ic) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_side_ic;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_side_main) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_side_main;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_side) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_side;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_back) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_back;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_front) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_front;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_side_ic) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_side_ic;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_side_main) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_side_main;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_branch_left_straight) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_left_straight;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_branch_right_straight) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_right_straight;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_tollgate) {
            return R.drawable.nsdk_drawable_rg_hud_turn_tollgate;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_2branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_2branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_2branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_2branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_middle) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_middle;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_left_3branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_3branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_2branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_2branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_2branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_2branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_middle) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_middle;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_right_3branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_3branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front_2branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_left_side;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front_2branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_right_side;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_middle) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_center;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_front_3branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_lf_2branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_lf_2branch_left;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_lf_2branch_right) {
            return R.drawable.nsdk_drawable_rg_hud_turn_lf_2branch_right;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_rf_2branch_left) {
            return R.drawable.nsdk_drawable_rg_hud_turn_rf_2branch_left;
        }
        return i == R.drawable.nsdk_drawable_rg_ic_turn_rf_2branch_right ? R.drawable.nsdk_drawable_rg_hud_turn_rf_2branch_right : i;
    }
}
