package com.baidu.navisdk.module.trucknavi.preferences;

import android.os.Build;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.l0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static int b = -1;

    /* renamed from: a, reason: collision with root package name */
    private final e0 f7583a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7584a = new a();
    }

    public static a r0() {
        return b.f7584a;
    }

    private void s0() {
        this.f7583a.b("truck_first_install_user", a0.g(com.baidu.navisdk.framework.a.c().a()));
    }

    public int A() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_service_area_tip_display_count", 0);
    }

    public boolean B() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_SHOW_CAR_LOGO_TO_END", true);
    }

    public int C() {
        return 0;
    }

    public int D() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_truck_func_on", 0);
    }

    public int E() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_truck_type", 0);
    }

    public String F() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a("truck_navi_vdr_low_notif_SHOW_DATE", (String) null);
    }

    public boolean G() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_sp_show_naving_vector_expand", true);
    }

    public int H() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_NAVI_VOICE_MODE", 0);
    }

    public boolean I() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_AUTO_LEVEL", true);
    }

    public boolean J() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_navi_bt_guide_showed_2", false);
    }

    public boolean K() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_is_clicked_toolbox_setting_item", false);
    }

    public boolean L() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_day_night_guide_has_show", false);
    }

    public boolean M() {
        return false;
    }

    public boolean N() {
        return true;
    }

    public boolean O() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_FIRST_ITS_ON", true);
    }

    public boolean P() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG", true);
    }

    public boolean Q() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_SHOW_MORE_BTN_NEW_TAG", false);
    }

    public boolean R() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_NAVI_REAL_HISTORY_ITS", true);
    }

    public boolean S() {
        return true;
    }

    public boolean T() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_navi_remember_route_prefer_is_open", false);
    }

    public boolean U() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_ORITATION_BTN_NEW_TAG", true);
    }

    public boolean V() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_NAVI_SHOW_PHONE_STATE_DECLARE", true);
    }

    public boolean W() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_NAVI_PLAY_BACKGROUND_SPEAK", true);
    }

    public boolean X() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_navi_p_v_w_c", false);
    }

    public boolean Y() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_rg_float_show_open_guide", false);
    }

    public boolean Z() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_ROADCOND_ON_OFF", false);
    }

    public void a(long j) {
    }

    public boolean a0() {
        if (this.f7583a == null) {
            return false;
        }
        if (!f.c().c.H) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckPreferenceManager", "scenic_broadcast cloud close");
            }
            return false;
        }
        return this.f7583a.a("truck_bn_s_b_open", true);
    }

    public void b(boolean z) {
    }

    public boolean b0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_nav_weather_btn_tips_has_show", false);
    }

    public void c(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_DIY_VOICE_MODE_OPEN", z);
    }

    public boolean c0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_last_is_show_no_high_way_bubble", false);
    }

    public long d() {
        return 0L;
    }

    public boolean d0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_VOICE_BTN_NEW_TAG", false);
    }

    public int e() {
        return 0;
    }

    public boolean e0() {
        return true;
    }

    public int f() {
        return 0;
    }

    public boolean f0() {
        return true;
    }

    @Deprecated
    public int g() {
        return j.c() ? 1 : 0;
    }

    public boolean g0() {
        return true;
    }

    public boolean h() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_DIY_VOICE_MODE_OPEN", false);
    }

    public void h0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_navi_bt_guide_showed_2", true);
    }

    public void i(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        if (i == 2 || i == 3) {
            e0Var.b("truck_NAVI_LAST_QUIET_MODE", i);
        }
    }

    public void i0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_day_night_guide_has_show", true);
    }

    public boolean j() {
        return false;
    }

    public void j0() {
    }

    public boolean k(boolean z) {
        return true;
    }

    public void k0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_ORITATION_BTN_NEW_TAG", false);
    }

    public void l(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_PLAY_BACKGROUND_SPEAK", z);
    }

    public void l0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_rg_float_show_open_guide", true);
    }

    public void m(int i) {
        if (this.f7583a == null) {
            return;
        }
        if (i == 0 || 1 == i || 2 == i) {
            if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
                this.f7583a.b("truck_NAVI_POWER_SAVE_MODE", 2);
            } else {
                this.f7583a.b("truck_NAVI_POWER_SAVE_MODE", i);
            }
            BNPowerSaver.getInstance().a(i);
            com.baidu.navisdk.module.powersavemode.f.o().a(i);
        }
    }

    public boolean m0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return this.f7583a.b("truck_service_area_tip_display_count", e0Var.a("truck_service_area_tip_display_count", 0) + 1);
    }

    public void n(int i) {
    }

    public void n0() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_nav_weather_btn_tips_has_show", true);
    }

    public void o(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_PARK_SEARCH", z);
    }

    public void o0() {
    }

    public int p() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return j.d() ? 2 : 1;
        }
        return e0Var.a("truck_NAVI_MODE_DAY_AND_NIGHT", j.d() ? 2 : 1);
    }

    public void p0() {
    }

    public void q(boolean z) {
        n(z ? 2 : 3);
    }

    public void q0() {
    }

    public void r(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_ROADCOND_ON_OFF", z);
    }

    public int s() {
        e0 e0Var;
        int a2;
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a() || (e0Var = this.f7583a) == null) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 23) {
            a2 = e0Var.a("truck_NAVI_POWER_SAVE_MODE", 0);
        } else {
            a2 = e0Var.a("truck_NAVI_POWER_SAVE_MODE", 2);
        }
        return a2 == 2 ? 2 : 0;
    }

    public void t(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_SHOW_CAR_LOGO_TO_END", z);
    }

    public void u(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            e0Var.b("truck_NAVI_VOICE_MODE", i);
        }
    }

    public boolean v() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("truck_sp_show_naving_real_enlargement", true);
    }

    public int w() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 3;
        }
        return e0Var.a(SettingParams.Key.NAVI_RP_NET_MODE_TRUCK, 1);
    }

    public int x() {
        return 3;
    }

    public int y() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_route_prefer_remember_prefer_bubble", 0);
    }

    public int z() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_charge_prefer", 1);
    }

    private a() {
        this.f7583a = BNSettingManager.getPreferenceHelper();
        s0();
    }

    public void a(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_AUTO_LEVEL", z);
    }

    public void b(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_nav_b_c_t", i);
    }

    public void d(int i) {
    }

    public void e(int i) {
    }

    public void f(int i) {
    }

    public void g(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_navi_remember_route_prefer_is_open", z);
    }

    public void j(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_SHOW_PHONE_STATE_DECLARE", z);
    }

    public void k(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        if (1 == i || 2 == i || 3 == i) {
            e0Var.b("truck_NAVI_MODE_DAY_AND_NIGHT", i);
            com.baidu.navisdk.comapi.commontool.a.getInstance().c(i);
        }
    }

    public int n() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a("truck_NAVI_LAST_QUIET_MODE", 2);
    }

    public void q(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_SORT_DRIVING_HABIT_VALUE", i);
    }

    public void x(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_REAL_HISTORY_ITS", z);
    }

    public int c() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("truck_NAVI_DEFAULT_SORT_VALUE", 1);
    }

    public void d(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_FIRST_ITS_ON", z);
    }

    public void e(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_FIRST_VOICE_GUIDE", z);
    }

    public void f(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_FIRST_VOICE_NOTIFY_GUIDE", z);
    }

    public void h(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        if (i == 3) {
            i = 1;
        }
        e0Var.b("truck_NAVI_SHOW_MAP_SWITCH", i);
    }

    public boolean i() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_FIRST_VOICE_GUIDE", false);
    }

    public boolean l() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_VOICE_RECOMMEN_HAS_CLICKED", false);
    }

    public int o() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("truck_navi_map_mode", 1);
    }

    public int r() {
        int i = b;
        if (i > -1) {
            return i;
        }
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        int a2 = e0Var.a("truck_NAVI_TTS_PLAY_MODE", 0);
        b = a2;
        return a2;
    }

    public void t(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_truck_type", i);
    }

    public boolean u() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_NAVI_PARK_SEARCH", false);
    }

    public boolean v(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b("truck_sp_show_naving_vector_expand", z);
    }

    public void w(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_VOICE_BTN_NEW_TAG", z);
    }

    public boolean a(String str) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("truck_" + str);
    }

    public int b() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_nav_b_c_t", 0);
    }

    public void g(int i) {
        b(SettingParams.Key.RG_FLOAT_MODE, i);
    }

    public void j(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_navi_map_mode", i);
    }

    public void n(boolean z) {
        if (this.f7583a == null) {
            return;
        }
        c(SettingParams.Key.NAVI_PIP_SWITCH, z);
    }

    public int q() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_navi_orientation_changed_dialog_show_count", 0);
    }

    public void c(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_DEFAULT_SORT_VALUE", i);
    }

    public boolean d(String str, boolean z) {
        JSONObject jSONObject;
        LogUtil.e("TruckPreferenceManager", "saveFirstGuide-> key: " + str + ", value: " + z);
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            LogUtil.e("TruckPreferenceManager", "saveFirstGuide-> mPreferenceHelper == null, return false!");
            return false;
        }
        String trim = e0Var.a("truck_BN_FIRST_GUIDE", "").trim();
        try {
            if (l0.c(trim)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(trim);
            }
            jSONObject.put(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckPreferenceManager", "saveFirstGuide-> firstGuideStr= " + trim + ", mJsonObj= " + jSONObject);
            }
            this.f7583a.b("truck_BN_FIRST_GUIDE", jSONObject.toString());
            return true;
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("saveFirstGuide", e);
            }
            return false;
        }
    }

    public void h(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG", z);
    }

    public void i(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_NAVI_SHOW_MORE_BTN_NEW_TAG", z);
    }

    public boolean l(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        if (!e0Var.b("truck_NAVI_TTS_PLAY_MODE", i)) {
            return true;
        }
        b = i;
        return true;
    }

    public void o(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_route_prefer_remember_prefer_bubble", i);
    }

    public boolean p(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b("truck_sp_show_naving_real_enlargement", z);
    }

    public boolean t() {
        if (this.f7583a == null) {
            return false;
        }
        if (k() == 0) {
            if (!BNCommSettingManager.getInstance().hasPipPermission()) {
                return false;
            }
        } else if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return a(SettingParams.Key.NAVI_PIP_SWITCH, false);
        }
        return a(SettingParams.Key.NAVI_PIP_SWITCH, true);
    }

    public void u(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_last_is_show_no_high_way_bubble", z);
    }

    public void a() {
        if (this.f7583a == null) {
            return;
        }
        this.f7583a.b("truck_navi_orientation_changed_dialog_show_count", q() + 1);
    }

    public boolean b(String str, boolean z) {
        LogUtil.e("TruckPreferenceManager", "getFirstGuide-> key: " + str + ", defaultValue: " + z);
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            LogUtil.e("TruckPreferenceManager", "getFirstGuide-> mPreferenceHelper == null, return false!");
            return z;
        }
        String trim = e0Var.a("truck_BN_FIRST_GUIDE", "").trim();
        if (l0.c(trim)) {
            return z;
        }
        try {
            boolean optBoolean = new JSONObject(trim).optBoolean(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckPreferenceManager", "getFirstGuide-> firstGuideStr= " + trim + ", value= " + optBoolean + ", defaultValue= " + z);
            }
            return optBoolean;
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("getFirstGuide", e);
            }
            return z;
        }
    }

    public int k() {
        if (BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            return a(SettingParams.Key.RG_FLOAT_MODE, 0);
        }
        return 1;
    }

    public boolean r(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b("truck_SIMPLE_GUIDE_MODE", i);
    }

    public void s(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_bn_s_b_open", z);
    }

    public boolean c(String str, boolean z) {
        if (this.f7583a == null) {
            return false;
        }
        return this.f7583a.b("truck_" + str, z);
    }

    public void p(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_charge_prefer", i);
    }

    public void s(int i) {
        e0 e0Var = this.f7583a;
        if (e0Var != null) {
            e0Var.b("truck_truck_func_on", i);
        }
    }

    public int m() {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("truck_NAVI_SHOW_MAP_SWITCH", 0);
    }

    public int a(int i) {
        e0 e0Var = this.f7583a;
        return e0Var == null ? i : e0Var.a("truck_last_calc_preference", i);
    }

    public void c(String str) {
        if (this.f7583a == null) {
            return;
        }
        this.f7583a.c("truck_" + str);
    }

    public void m(boolean z) {
        e0 e0Var = this.f7583a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("truck_navi_p_v_w_c", z);
    }

    public String a(String str, String str2) {
        if (this.f7583a == null) {
            return str2;
        }
        return this.f7583a.a("truck_" + str, str2);
    }

    public int a(String str, int i) {
        if (this.f7583a == null) {
            return i;
        }
        return this.f7583a.a("truck_" + str, i);
    }

    public boolean a(String str, boolean z) {
        if (this.f7583a == null) {
            return z;
        }
        return this.f7583a.a("truck_" + str, z);
    }

    public boolean b(String str, String str2) {
        if (this.f7583a == null) {
            return false;
        }
        return this.f7583a.b("truck_" + str, str2);
    }

    public void d(String str) {
        e0 e0Var = this.f7583a;
        if (e0Var != null) {
            e0Var.b("truck_navi_vdr_low_notif_SHOW_DATE", str);
        }
    }

    public boolean b(String str, int i) {
        if (this.f7583a == null) {
            return false;
        }
        return this.f7583a.b("truck_" + str, i);
    }

    public String b(String str) {
        return "truck_" + str;
    }
}
