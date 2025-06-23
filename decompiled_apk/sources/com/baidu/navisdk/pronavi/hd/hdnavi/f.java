package com.baidu.navisdk.pronavi.hd.hdnavi;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.style.e;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class f implements com.baidu.navisdk.framework.interfaces.pronavi.hd.a {

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final void b() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDWidgetStyleManager", "changeWidget3DStyle");
        }
        com.baidu.navisdk.pronavi.style.i.b g = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g != null) {
            e.a aVar = com.baidu.navisdk.pronavi.style.e.b;
            com.baidu.navisdk.pronavi.style.e a2 = e.a.a(aVar, 0, 0.0f, 3, null);
            int i = R.color.bnav_ar_navi_btn_txt_color;
            com.baidu.navisdk.pronavi.style.e c = com.baidu.navisdk.pronavi.style.e.c(a2, i, null, 2, null);
            int i2 = R.drawable.bnav_ic_ar_btn_bg;
            g.a("RGCommonWidget", com.baidu.navisdk.pronavi.style.e.d(c, i2, null, 2, null).a(), 1);
            com.baidu.navisdk.pronavi.style.e a3 = e.a.a(aVar, 0, 0.0f, 3, null);
            int i3 = R.color.nsdk_white_color;
            com.baidu.navisdk.pronavi.style.e c2 = com.baidu.navisdk.pronavi.style.e.c(a3, i3, null, 2, null);
            int i4 = R.drawable.bnav_ic_hd_normal_speed;
            g.a("RGSpeedKey", "RGNormalSpeed", com.baidu.navisdk.pronavi.style.e.d(c2, i4, null, 2, null).a(), false, 1);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(600L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setFillAfter(false);
            com.baidu.navisdk.pronavi.style.e c3 = com.baidu.navisdk.pronavi.style.e.c(e.a.a(aVar, 0, 0.0f, 3, null), i3, null, 2, null);
            int i5 = R.drawable.bnav_ic_hd_over_speed;
            g.a("RGSpeedKey", "RGOverSpeed", com.baidu.navisdk.pronavi.style.e.d(c3, i5, null, 2, null).f(R.drawable.bnav_rg_hd_navi_overspeed_anim_bg, "RGOverSpeedAnimBg").a(rotateAnimation, "RGOverSpeedViewAnimator").a(), true, 1);
            com.baidu.navisdk.pronavi.style.e e = e.a.a(aVar, 0, 0.0f, 3, null).e(i3, "text_color");
            int i6 = R.drawable.bnav_ar_navi_interval_camera_bg;
            g.a("IntervalSpeed", e.f(i6, "portrait_bg").f(i6, "land_bg").c(i4, "average_speed_bg").c(i5, "over_speed_bg").b(R.color.bnav_ar_interval_line, "line_color").a(), 1);
            d.a.C0333a a4 = e.a.a(aVar, 0, 0.0f, 3, null).a("CurJustWarning");
            int i7 = R.drawable.bnav_rg_ic_white_voice_warning;
            d.a.C0333a a5 = a4.b(i7).d(R.string.nsdk_voice_mode_warning).a().a("CurVoiceQuiet");
            int i8 = R.drawable.bnav_rg_ic_white_voice_quiet;
            d.a.C0333a a6 = a5.b(i8).d(R.string.nsdk_voice_mode_quiet).a().a("CurVoicePlay");
            int i9 = R.drawable.bnav_rg_ic_white_voice_play;
            g.a("CurVoicePlayMode", a6.b(i9).d(R.string.nsdk_voice_mode_play).a().a(), 1);
            d.a.C0333a a7 = e.a.a(aVar, 0, 0.0f, 3, null).a("VoiceModePanelWarnOff");
            int i10 = R.drawable.nsdk_rg_cp_voice_left_btn_transparent_bg;
            d.a.C0333a b = a7.a(i10).b(i7);
            int i11 = R.color.bnav_hd_navi_btn_txt_color;
            d.a.C0333a a8 = b.c(i11).a().a("VoiceModePanelWarnOn").a(i10);
            int i12 = R.drawable.nsdk_drawable_rg_cp_voice_warning_on;
            d.a.C0333a b2 = a8.b(i12);
            int i13 = R.color.nsdk_cl_text_g;
            d.a.C0333a a9 = b2.c(i13).a().a("VoiceModePanelQuietOff");
            int i14 = R.drawable.nsdk_rg_cp_voice_middle_btn_transparent_bg;
            d.a.C0333a a10 = a9.a(i14).b(i8).c(i11).a().a("VoiceModePanelQuietOn").a(i14).b(R.drawable.nsdk_drawable_rg_cp_voice_quiet_on).c(i13).a().a("VoiceModePanelPlayOff");
            int i15 = R.drawable.nsdk_rg_cp_voice_right_btn_transparent_bg;
            d.a.C0333a a11 = a10.a(i15).b(i9).c(i11).a().a("VoiceModePanelPlayOn").a(i15);
            int i16 = R.drawable.nsdk_drawable_rg_cp_voice_open_on;
            g.a("VoicePlayModePanel", a11.b(i16).c(i13).a().a(), 1);
            d.a.C0333a a12 = com.baidu.navisdk.pronavi.style.e.a(e.a.a(aVar, 0, 0.0f, 3, null), null, 1, null).a(i2);
            int i17 = R.drawable.bnav_rg_ic_white_refresh;
            g.a("Refresh", a12.b(i17).c(i11).a().a(), 1);
            g.a("Setting", com.baidu.navisdk.pronavi.style.e.a(e.a.a(aVar, 0, 0.0f, 3, null), null, 1, null).a(i2).b(R.drawable.bnav_rg_ic_white_setting).c(i11).a().a(), 1);
            d.a.C0333a a13 = e.a.a(aVar, 0, 0.0f, 3, null).a("bridge_on");
            int i18 = R.drawable.bnav_ic_white_bridge_on;
            d.a.C0333a a14 = a13.b(i18).d(R.string.nsdk_string_rg_on_bridge).a().a("bridge_under");
            int i19 = R.drawable.bnav_ic_white_bridge_under;
            g.a("bridge", a14.b(i19).d(R.string.nsdk_string_rg_under_bridge).a().a(), 1);
            d.a.C0333a a15 = e.a.a(aVar, 0, 0.0f, 3, null).a("main_road");
            int i20 = R.drawable.bnav_ic_white_main_road;
            d.a.C0333a a16 = a15.b(i20).d(R.string.nsdk_string_rg_in_main_road).a().a("road_auxiliary");
            int i21 = R.drawable.bnav_ic_white_auxiliary_road;
            g.a("road", a16.b(i21).d(R.string.nsdk_string_rg_in_auxiliary_road).a().a(), 1);
            g.a("RGLaneLine", com.baidu.navisdk.pronavi.style.e.d(e.a.a(aVar, 0, 0.0f, 3, null), R.drawable.bnav_rg_hd_navi_lane_line_bg, null, 2, null).a(), 1);
            g.a("RGServiceArea", com.baidu.navisdk.pronavi.style.e.a(e.a.a(aVar, 0, 0.0f, 3, null), 230, null, 2, null).a(), 1);
            g.a("RGSimpleExitRoad", com.baidu.navisdk.pronavi.style.e.a(e.a.a(aVar, 0, 0.0f, 3, null), 230, null, 2, null).a(), 1);
            g.a("UgcReport", com.baidu.navisdk.pronavi.style.e.b(e.a.a(aVar, 0, 0.0f, 3, null), JarUtils.getResources().getColor(i3), null, 2, null).a(), 1);
            d.a.C0333a b3 = e.a.a(aVar, 0, 0.0f, 3, null).a("RGChargeStationBtn").a(i2).b("RGChargeStationBtnTxtBg", R.drawable.nsdk_rg_hd_ne_charge_station_btn_text_bg);
            int i22 = R.drawable.transparent;
            g.a("RGChargeStation", b3.b("RGChargeStationBtnIcBg", i22).c(i11).a().a("RGChargeStationTipGreen").a(i2).b(R.drawable.bnav_ic_ne_charge_station_green_tip).c(i11).b("RGCSTipCBg", R.drawable.nsdk_rg_ne_via_charge_count_bg).b("RGCSTipViewBg", i22).a("RGCSTipOtherTxtC", R.color.banv_ne_via_other_charge_color).a().a("RGChargeStationTipOrange").a(i2).b(R.drawable.bnav_ic_ne_charge_station_orange_tip).c(i11).b("RGCSTipCBg", R.drawable.nsdk_rg_ne_leave_highway_charge_count_bg).b("RGCSTipViewBg", i22).a("RGCSTipOtherTxtC", R.color.banv_ne_leave_highway_other_charge_color).a().a("RGChargeStationTipRed").a(i2).b("RGCSTipViewBg", i22).b(R.drawable.bnav_ic_ne_charge_station_red_tip).c(i11).a().a(), 1);
            com.baidu.navisdk.pronavi.style.e b4 = e.a.a(aVar, 0, 0.0f, 3, null).b(i, "RGFixedBtnTitleColor");
            int i23 = R.drawable.bnav_rg_btn_hd_new_transparency_bg;
            g.a("FixedBtnCollectView", b4.f(i23, "RGTopDynamicBg").f(R.drawable.bnav_rg_btn_hd_new_opaque_bg, "RGBottomFixedBg").c(i17, "RGFixedBtnRefreshIc").f(i23, "RGFixedNaviPlayBg").c(i9, "RGFixedBtnNPPlayIc").c(i7, "RGFixedBtnNPWarningIc").c(R.drawable.bnav_rg_hd_2_whippletree, "RGDynamicHeadViewIcon").b(i3, "RGFixedBtnUgcIcTintColor").a(), 1);
            g.a("FixedBtnCollectNaviPlayKey", e.a.a(aVar, 0, 0.0f, 3, null).a("VoiceModePanelWarnOff").b(i7).c(i11).a().a("VoiceModePanelWarnOn").b(i12).c(i13).a().a("VoiceModePanelQuietOff").b(i8).c(i11).a().a("VoiceModePanelQuietOn").b(R.drawable.nsdk_drawable_rg_cp_voice_quiet_red).c(R.color.bnav_rg_navi_play_quite_color).a().a("VoiceModePanelPlayOff").b(i9).c(i11).a().a("VoiceModePanelPlayOn").b(i16).c(i13).a().a(), 1);
            g.a("DynamicBtnCollectView", e.a.a(aVar, 0, 0.0f, 3, null).b(i, "RGDynamicBtnTitleColor").f(i2, "RGDynamicBg").c(i18, "dynamic_bridge_on").c(i19, "dynamic_bridge_under").c(i20, "dynamic_main_road").c(i21, "dynamic_road_auxiliary").b(i3, "RGDynamicBtnUgcIc").c(R.drawable.nsdk_drawable_common_ic_park, "RGDynamicBtnParkIc").c(R.drawable.nsdk_drawable_common_ic_save_park, "RGDynamicBtnSaveParkIc").a(), 1);
        }
    }

    private final void c() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDWidgetStyleManager", "restoreWidgetStyle");
        }
        com.baidu.navisdk.pronavi.style.i.b g = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g != null) {
            g.b();
        }
    }

    public final void a() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDWidgetStyleManager", "onDestroy ");
        }
        c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.a
    public void onHdStateSwitch(int i, int i2, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDWidgetStyleManager", "onHdStateSwitch: " + i + "->" + i2 + ", " + z);
        }
        if (i2 != 0 && i2 != 2) {
            if (i2 == 3) {
                b();
                return;
            }
            return;
        }
        c();
    }
}
