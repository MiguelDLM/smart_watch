package com.baidu.navisdk.module.motorbike.preferences;

import android.os.Build;
import android.text.TextUtils;
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
    private final e0 f7199a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7200a = new a();
    }

    public static a u0() {
        return b.f7200a;
    }

    private void v0() {
        this.f7199a.b("motor_first_install_user", a0.g(com.baidu.navisdk.framework.a.c().a()));
    }

    public int A() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 3;
        }
        return e0Var.a(SettingParams.Key.NAVI_RP_NET_MODE_MOTOR, 1);
    }

    public int B() {
        return 1;
    }

    public int C() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_route_prefer_remember_prefer_bubble", 0);
    }

    public int D() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_charge_prefer", 1);
    }

    public int E() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_NAVI_SORT_DRIVING_HABIT_VALUE", 0);
    }

    public int F() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_service_area_tip_display_count", 0);
    }

    public boolean G() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_SHOW_CAR_LOGO_TO_END", true);
    }

    public int H() {
        return 0;
    }

    public String I() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a("motor_navi_vdr_low_notif_SHOW_DATE", (String) null);
    }

    public boolean J() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_sp_show_naving_vector_expand", true);
    }

    public int K() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_NAVI_VOICE_MODE", 0);
    }

    public boolean L() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_NAVI_AUTO_LEVEL", true);
    }

    public boolean M() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_navi_bt_guide_showed_2", false);
    }

    public boolean N() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_is_clicked_toolbox_setting_item", false);
    }

    public boolean O() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_day_night_guide_has_show", false);
    }

    public boolean P() {
        return false;
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_FIRST_ITS_ON", true);
    }

    public boolean S() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG", true);
    }

    public boolean T() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_SHOW_MORE_BTN_NEW_TAG", false);
    }

    public boolean U() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_NAVI_REAL_HISTORY_ITS", true);
    }

    public boolean V() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_plate_limit_open", false);
    }

    public boolean W() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_navi_remember_route_prefer_is_open", false);
    }

    public boolean X() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_ORITATION_BTN_NEW_TAG", true);
    }

    public boolean Y() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_NAVI_SHOW_PHONE_STATE_DECLARE", true);
    }

    public boolean Z() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_NAVI_PLAY_BACKGROUND_SPEAK", true);
    }

    public void a(long j) {
    }

    public boolean a0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_navi_p_v_w_c", false);
    }

    public void b(boolean z) {
    }

    public boolean b0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_rg_float_show_open_guide", false);
    }

    public void c(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_DIY_VOICE_MODE_OPEN", z);
    }

    public boolean c0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_ROADCOND_ON_OFF", false);
    }

    public long d() {
        return 0L;
    }

    public boolean d0() {
        if (!f.c().c.H) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorPreferenceManager", "scenic_broadcast cloud close");
                return false;
            }
            return false;
        }
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_bn_s_b_open", true);
    }

    public int e() {
        return 0;
    }

    public boolean e0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_nav_weather_btn_tips_has_show", false);
    }

    public int f() {
        return 0;
    }

    public boolean f0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_last_is_show_no_high_way_bubble", false);
    }

    @Deprecated
    public int g() {
        return j.c() ? 1 : 0;
    }

    public boolean g0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_VOICE_BTN_NEW_TAG", false);
    }

    public boolean h() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_DIY_VOICE_MODE_OPEN", false);
    }

    public boolean h0() {
        return true;
    }

    public void i(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        if (i == 2 || i == 3) {
            e0Var.b("motor_NAVI_LAST_QUIET_MODE", i);
        }
    }

    public boolean i0() {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean j0() {
        return true;
    }

    public void k(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        if (1 == i || 2 == i || 3 == i) {
            e0Var.b("motor_NAVI_MODE_DAY_AND_NIGHT", i);
            com.baidu.navisdk.comapi.commontool.a.getInstance().c(i);
        }
    }

    public void k0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_navi_bt_guide_showed_2", true);
    }

    public void l(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_SHOW_PHONE_STATE_DECLARE", z);
    }

    public void l0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_day_night_guide_has_show", true);
    }

    public int m() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("motor_NAVI_SHOW_MAP_SWITCH", 1);
    }

    public void m0() {
    }

    public void n(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_PLAY_BACKGROUND_SPEAK", z);
    }

    public void n0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_ORITATION_BTN_NEW_TAG", false);
    }

    public void o(int i) {
    }

    public void o0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_rg_float_show_open_guide", true);
    }

    public void p(boolean z) {
        c(SettingParams.Key.NAVI_PIP_SWITCH, z);
    }

    public boolean p0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return this.f7199a.b("motor_service_area_tip_display_count", e0Var.a("motor_service_area_tip_display_count", 0) + 1);
    }

    public int q() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("motor_NAVI_MODE_DAY_AND_NIGHT", 1);
    }

    public void q0() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_nav_weather_btn_tips_has_show", true);
    }

    public boolean r(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b("motor_sp_show_naving_real_enlargement", z);
    }

    public void r0() {
    }

    public void s(boolean z) {
        o(z ? 2 : 3);
    }

    public void s0() {
    }

    public void t(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            e0Var.b("motor_NAVI_VOICE_MODE", i);
        }
    }

    public void t0() {
    }

    public void u(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_bn_s_b_open", z);
    }

    public void v(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_SHOW_CAR_LOGO_TO_END", z);
    }

    public int w() {
        e0 e0Var;
        int a2;
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a() || (e0Var = this.f7199a) == null) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 23) {
            a2 = e0Var.a("motor_NAVI_POWER_SAVE_MODE", 0);
        } else {
            a2 = e0Var.a("motor_NAVI_POWER_SAVE_MODE", 2);
        }
        return a2 == 2 ? 2 : 0;
    }

    public boolean x() {
        if (this.f7199a == null) {
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

    public boolean y() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_PARK_SEARCH", false);
    }

    public void z(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_REAL_HISTORY_ITS", z);
    }

    private a() {
        this.f7199a = BNSettingManager.getPreferenceHelper();
        v0();
    }

    public void a(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_AUTO_LEVEL", z);
    }

    public void b(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_nav_b_c_t", 0);
    }

    public void d(int i) {
    }

    public void e(int i) {
    }

    public void f(int i) {
    }

    public void g(int i) {
        b(SettingParams.Key.RG_FLOAT_MODE, i);
    }

    public void j(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_navi_map_mode", i);
    }

    public int o() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("motor_navi_map_mode", 1);
    }

    public void p(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_route_prefer_remember_prefer_bubble", i);
    }

    public boolean s(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b("motor_SIMPLE_GUIDE_MODE", i);
    }

    public int c() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("motor_NAVI_DEFAULT_SORT_VALUE", 1);
    }

    public void d(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_FIRST_ITS_ON", z);
    }

    public void e(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_FIRST_VOICE_GUIDE", z);
    }

    public void f(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_FIRST_VOICE_NOTIFY_GUIDE", z);
    }

    public void g(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_VOICE_RECOMMEN_HAS_CLICKED", z);
    }

    public void h(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        if (i == 3) {
            i = 1;
        }
        e0Var.b("motor_NAVI_SHOW_MAP_SWITCH", i);
    }

    public boolean i() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_FIRST_VOICE_GUIDE", false);
    }

    public boolean l() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_NAVI_VOICE_RECOMMEN_HAS_CLICKED", false);
    }

    public boolean m(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        if (!e0Var.b("motor_NAVI_TTS_PLAY_MODE", i)) {
            return true;
        }
        b = i;
        return true;
    }

    public void n(int i) {
        if (this.f7199a == null) {
            return;
        }
        if (i == 0 || 1 == i || 2 == i) {
            if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
                this.f7199a.b("motor_NAVI_POWER_SAVE_MODE", 2);
            } else {
                this.f7199a.b("motor_NAVI_POWER_SAVE_MODE", i);
            }
            BNPowerSaver.getInstance().a(i);
            com.baidu.navisdk.module.powersavemode.f.o().a(i);
        }
    }

    public void q(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_PARK_SEARCH", z);
    }

    public void r(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_SORT_DRIVING_HABIT_VALUE", i);
    }

    public void t(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_ROADCOND_ON_OFF", z);
    }

    public int u() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_motor_plate_type", 0);
    }

    public int v() {
        int i = b;
        if (i > -1) {
            return i;
        }
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        int a2 = e0Var.a("motor_NAVI_TTS_PLAY_MODE", 0);
        b = a2;
        return a2;
    }

    public void y(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_VOICE_BTN_NEW_TAG", z);
    }

    public boolean z() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("motor_sp_show_naving_real_enlargement", true);
    }

    public boolean a(String str) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("motor_" + str);
    }

    public int b() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_nav_b_c_t", 0);
    }

    public void j(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG", z);
    }

    public void o(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_navi_p_v_w_c", z);
    }

    public int p() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a("motor_motor_type", 2);
    }

    public String s() {
        e0 e0Var = this.f7199a;
        return e0Var == null ? "" : e0Var.a("motor_motor_plate", "");
    }

    public void c(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_DEFAULT_SORT_VALUE", i);
    }

    public boolean d(String str, boolean z) {
        JSONObject jSONObject;
        LogUtil.e("MotorPreferenceManager", "saveFirstGuide-> key: " + str + ", value: " + z);
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            LogUtil.e("MotorPreferenceManager", "saveFirstGuide-> mPreferenceHelper == null, return false!");
            return false;
        }
        String trim = e0Var.a("motor_BN_FIRST_GUIDE", "").trim();
        try {
            if (l0.c(trim)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(trim);
            }
            jSONObject.put(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorPreferenceManager", "saveFirstGuide-> firstGuideStr= " + trim + ", mJsonObj= " + jSONObject);
            }
            this.f7199a.b("motor_BN_FIRST_GUIDE", jSONObject.toString());
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
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_navi_remember_route_prefer_is_open", z);
    }

    public boolean i(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        e0Var.b("motor_NAVI_IS_SHOW_DRIVING_HABIT", z);
        return true;
    }

    public int k() {
        if (BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            return a(SettingParams.Key.RG_FLOAT_MODE, 0);
        }
        return 1;
    }

    public void l(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var != null) {
            e0Var.b("motor_plate_guide_show_times", i);
        }
    }

    public void q(int i) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_charge_prefer", i);
    }

    public int r() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("motor_navi_orientation_changed_dialog_show_count", 0);
    }

    public String t() {
        e0 e0Var = this.f7199a;
        return e0Var == null ? "" : e0Var.a("motor_motor_displacement", "");
    }

    public boolean a(int i, String str) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        e0Var.b("motor_local.count.time", i);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f7199a.b("motor_local.count.title", str);
    }

    public boolean b(String str, boolean z) {
        LogUtil.e("MotorPreferenceManager", "getFirstGuide-> key: " + str + ", defaultValue: " + z);
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            LogUtil.e("MotorPreferenceManager", "getFirstGuide-> mPreferenceHelper == null, return false!");
            return z;
        }
        String trim = e0Var.a("motor_BN_FIRST_GUIDE", "").trim();
        if (l0.c(trim)) {
            return z;
        }
        try {
            boolean optBoolean = new JSONObject(trim).optBoolean(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorPreferenceManager", "getFirstGuide-> firstGuideStr= " + trim + ", value= " + optBoolean + ", defaultValue= " + z);
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

    public boolean m(boolean z) {
        if (this.f7199a == null) {
            return false;
        }
        if (!z) {
            a(0, "");
        }
        this.f7199a.b("motor_plate_limit_open", z);
        return true;
    }

    public void w(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_last_is_show_no_high_way_bubble", z);
    }

    public boolean c(String str, boolean z) {
        if (this.f7199a == null) {
            return false;
        }
        return this.f7199a.b("motor_" + str, z);
    }

    public void k(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return;
        }
        e0Var.b("motor_NAVI_SHOW_MORE_BTN_NEW_TAG", z);
    }

    public boolean x(boolean z) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b("motor_sp_show_naving_vector_expand", z);
    }

    public void c(String str) {
        if (this.f7199a == null) {
            return;
        }
        this.f7199a.c("motor_" + str);
    }

    public void a() {
        if (this.f7199a == null) {
            return;
        }
        this.f7199a.b("motor_navi_orientation_changed_dialog_show_count", r() + 1);
    }

    public int n() {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a("motor_NAVI_LAST_QUIET_MODE", 2);
    }

    public boolean a(String str, int i, int i2, String str2) {
        e0 e0Var = this.f7199a;
        if (e0Var == null) {
            return false;
        }
        e0Var.b("motor_motor_plate", str);
        this.f7199a.b("motor_motor_plate_type", i);
        this.f7199a.b("motor_motor_type", i2);
        this.f7199a.b("motor_motor_displacement", str2);
        return true;
    }

    public boolean b(String str, String str2) {
        if (this.f7199a == null) {
            return false;
        }
        return this.f7199a.b("motor_" + str, str2);
    }

    public int a(int i) {
        e0 e0Var = this.f7199a;
        return e0Var == null ? i : e0Var.a("motor_last_calc_preference", i);
    }

    public void d(String str) {
        e0 e0Var = this.f7199a;
        if (e0Var != null) {
            e0Var.b("motor_navi_vdr_low_notif_SHOW_DATE", str);
        }
    }

    public boolean b(String str, int i) {
        if (this.f7199a == null) {
            return false;
        }
        return this.f7199a.b("motor_" + str, i);
    }

    public String a(String str, String str2) {
        if (this.f7199a == null) {
            return str2;
        }
        return this.f7199a.a("motor_" + str, str2);
    }

    public String b(String str) {
        return "motor_" + str;
    }

    public int a(String str, int i) {
        if (this.f7199a == null) {
            return i;
        }
        return this.f7199a.a("motor_" + str, i);
    }

    public boolean a(String str, boolean z) {
        if (this.f7199a == null) {
            return z;
        }
        return this.f7199a.a("motor_" + str, z);
    }
}
