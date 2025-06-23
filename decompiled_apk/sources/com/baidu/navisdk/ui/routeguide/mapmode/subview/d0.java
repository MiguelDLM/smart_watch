package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class d0 extends com.baidu.navisdk.ui.routeguide.widget.g implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, com.baidu.navisdk.ui.routeguide.mapmode.iview.d, TextView.OnEditorActionListener {
    private RadioGroup A;
    private RadioButton B;
    private RadioButton C;
    private RadioGroup D;
    private RadioGroup E;
    private RadioGroup F;
    private RadioGroup G;
    private RadioGroup H;
    private BNCommonTitleBar I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private ImageView O;
    private TextView P;
    private TextView Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private final com.baidu.navisdk.ui.routeguide.mapmode.presenter.c V;
    private String W;
    private TextView X;
    private RadioButton Y;
    private RadioButton Z;
    private RadioButton a0;
    private RadioButton b0;
    private CheckBox c0;
    private CheckBox d0;
    private CheckBox e0;
    private View f0;
    private final ImageView[] g0;
    private boolean[] h0;
    private final int[] i0;
    private final int[] j0;
    private final int[] k0;
    private final int[] l0;
    private final int[] m0;
    private View n;
    private boolean n0;
    private ScrollView o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f8729o0;
    private View p;
    ViewTreeObserver.OnScrollChangedListener p0;
    private View q;
    private final a.InterfaceC0201a q0;
    private View r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private String w;
    private LinearLayout x;
    private View y;
    private RadioGroup z;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (d0.this.o.getScrollY() - d0.this.p.getHeight() >= 0) {
                if (d0.this.I != null) {
                    d0.this.I.setMiddleTextVisible(true);
                    d0.this.I.setMiddleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_menu_more_setting));
                    int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_16dp);
                    LogUtil.e("RouteGuide", "MoreSettingTitleSize = " + dimensionPixelSize);
                    d0.this.I.setMiddleTextSizePX(dimensionPixelSize);
                    d0.this.I.setRightTextVisible(false);
                    return;
                }
                return;
            }
            d0.this.I.setMiddleText("");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0201a {
        public b() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            LogUtil.e("TTS", "mMenuMoreEvent - onEvent : " + obj.getClass().getSimpleName());
            if ((obj instanceof com.baidu.navisdk.framework.message.bean.k) && ((com.baidu.navisdk.framework.message.bean.k) obj).a() == 0 && d0.this.V != null) {
                d0.this.V.a();
            }
        }
    }

    public d0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar, 1);
        this.w = "";
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.U = null;
        this.W = "";
        this.X = null;
        this.g0 = new ImageView[11];
        this.h0 = new boolean[11];
        this.i0 = new int[]{R.id.bnav_rg_menu_h_split_0, R.id.bnav_rg_menu_h_split_01, R.id.bnav_rg_menu_h_split_1, R.id.bnav_rg_menu_h_split_2, R.id.bnav_rg_menu_h_split_3, R.id.bnav_rg_menu_h_split_4, R.id.bnav_rg_menu_h_split_5, R.id.bnav_rg_menu_h_split_6, R.id.bnav_rg_menu_h_split_7, R.id.bnav_rg_menu_h_split_8, R.id.bnav_rg_menu_h_split_9, R.id.bnav_rg_menu_h_split_10, R.id.bnav_rg_menu_h_split_11, R.id.bnav_rg_menu_h_split_12, R.id.bnav_rg_menu_h_split_13, R.id.bnav_rg_menu_h_split_14, R.id.bnav_rg_menu_bluetooth_split_0, R.id.bnav_rg_menu_bluetooth_split_1};
        this.j0 = new int[]{R.id.car_plate, R.id.nav_license_plates_limit_title_tv, R.id.nav_license_passport_title_tv, R.id.bnav_rg_more_setting_default_mode_text, R.id.bnav_rg_more_setting_simple_mode_text, R.id.nav_logo_tv, R.id.bnav_rg_menu_broadcast_tv, R.id.bnav_rg_menu_nav_voice_tv, R.id.nav_guide_angle_text_tv, R.id.nav_day_night_mode_tv, R.id.nav_overview_text_tv, R.id.bnav_map_switch_text, R.id.bnav_road_condition_bar_text, R.id.nav_scale_tv, R.id.nav_real_enlarge_tv, R.id.nav_show_car_logo_to_end_tv, R.id.bluetooth_default_play_text, R.id.bluetooth_phone_play_text, R.id.bluetooth_speaker_play_text, R.id.nav_calling_play_title, R.id.nav_music_volume_tv, R.id.nav_park_tv, R.id.nav_float_setting_tv, R.id.nav_scenic_setting_tv, R.id.nav_power_saver_setting_tv, R.id.bnav_user_feedback_title};
        this.k0 = new int[]{R.id.nav_car_plate_tips_tv, R.id.nav_license_plates_limit_tips_tv, R.id.nav_license_passport_tips_tv, R.id.nav_logo_tips_tv, R.id.bnav_rg_menu_broadcast_tips_tv, R.id.bnav_rg_menu_nav_voice_tips_tv, R.id.nav_scale_tips_tv, R.id.nav_real_enlarge_tips_tv, R.id.nav_show_car_logo_to_end_tips_tv, R.id.bluetooth_default_play_sub_title, R.id.bluetooth_phone_play_sub_title, R.id.bluetooth_speaker_play_sub_title, R.id.nav_calling_play_tips, R.id.tv_music_volume_tips, R.id.nav_park_tips_tv, R.id.nav_float_setting_tips_tv, R.id.nav_scenic_setting_tips_tv, R.id.nav_power_saver_setting_tips_tv, R.id.nav_common_use_tv, R.id.nav_voice_text_tv, R.id.nav_during_tv, R.id.nav_bluetooth_choice_tv, R.id.nav_additional_right_tv, R.id.car_plate_guide, R.id.bnav_user_feedback_desc};
        this.l0 = new int[]{R.id.nsdk_common_setting_container, R.id.nsdk_navi_voice_container, R.id.nsdk_navi_display_content_container, R.id.nsdk_bluetooth_connection_setting_container, R.id.nsdk_additional_right_container};
        this.m0 = new int[]{R.id.nav_view_voice_selector_rg, R.id.nav_view_guide_angle_selector_rg, R.id.nav_view_night_mode_selector_rg, R.id.nav_view_music_volume_selector_rg, R.id.nav_float_setting_selector_rg};
        this.n0 = false;
        this.f8729o0 = false;
        this.p0 = new a();
        this.q0 = new b();
        this.V = new com.baidu.navisdk.ui.routeguide.mapmode.presenter.c(this);
    }

    private boolean B(boolean z) {
        boolean z2;
        View view = this.k;
        if (view != null) {
            int[] iArr = this.i0;
            if (iArr.length > 0 && view.findViewById(iArr[0]) != null) {
                int color = ((ColorDrawable) this.k.findViewById(this.i0[0]).getBackground()).getColor();
                if (JarUtils.getResources() != null) {
                    if (color == JarUtils.getResources().getColor(R.color.nsdk_cl_bg_b)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.e = z2;
                }
            }
        }
        if (z == this.e) {
            return true;
        }
        return false;
    }

    private void B0() {
        if (!com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a()) {
            this.H.setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_more_setting_guide_mode_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_1).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            this.k.findViewById(R.id.nav_license_plates_limit_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_0).setVisibility(8);
            this.k.findViewById(R.id.bnav_car_plate_info_container).setVisibility(8);
            this.k.findViewById(R.id.nav_license_passport_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_01).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            this.k.findViewById(R.id.bnav_rg_menu_nav_voice_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_3).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a()) {
            this.k.findViewById(R.id.nav_bluetooth_choice_tv).setVisibility(8);
            this.k.findViewById(R.id.nsdk_bluetooth_connection_setting_container).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_CAR_LOGO_SELECT.a()) {
            this.k.findViewById(R.id.nav_view_car_logo_select_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_1).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_PARK.a()) {
            this.k.findViewById(R.id.nav_park_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_10).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            this.k.findViewById(R.id.nav_scenic_setting_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_12).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a()) {
            this.k.findViewById(R.id.nav_float_setting_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_11).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            this.k.findViewById(R.id.nav_power_saver_setting_layout).setVisibility(8);
            this.k.findViewById(R.id.bnav_rg_menu_h_split_13).setVisibility(8);
        }
        ViewGroup viewGroup = (ViewGroup) this.k.findViewById(R.id.nsdk_common_setting_container);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i).getVisibility() == 0) {
                return;
            }
        }
        viewGroup.setVisibility(8);
        this.k.findViewById(R.id.nav_common_use_tv).setVisibility(8);
    }

    private void C(boolean z) {
        if (!z) {
            this.o.scrollTo(0, 0);
            if (!this.h0[0]) {
                w(0);
                this.V.a(this.h0, 0);
            }
        }
    }

    private void C0() {
        if (this.R != null) {
            String b2 = com.baidu.navisdk.ui.routeguide.module.diyspeak.j.b();
            if (!TextUtils.isEmpty(b2)) {
                this.S.setVisibility(0);
                this.S.setText(Html.fromHtml("<font color='#999999'>正在使用</font><font color='#3385ff'>" + b2 + "模式</font>"));
                return;
            }
            this.S.setVisibility(8);
        }
    }

    private void D0() {
        this.p = this.k.findViewById(R.id.bnav_car_plate_info_container);
        this.q = this.k.findViewById(R.id.nav_view_car_logo_select_layout);
        this.r = this.k.findViewById(R.id.bnav_rg_menu_h_split_1);
        this.J = (ImageView) this.k.findViewById(R.id.nav_license_passport_arrow);
        this.s = (TextView) this.k.findViewById(R.id.nav_limit_tips_tv);
        this.t = (TextView) this.k.findViewById(R.id.car_plate);
        this.u = (TextView) this.k.findViewById(R.id.car_plate_guide);
        this.v = (TextView) this.k.findViewById(R.id.nav_car_plate_tips_tv);
        this.K = (ImageView) this.k.findViewById(R.id.navi_set_arrow);
        this.x = (LinearLayout) this.k.findViewById(R.id.city_shortname);
        this.y = this.k.findViewById(R.id.mark);
        j(0);
        c(com.baidu.navisdk.h.a());
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.V.b(this.f9165a);
    }

    private void E0() {
        this.h0 = this.V.d();
        for (int i = 0; i < 11; i++) {
            j(i);
        }
        c(com.baidu.navisdk.h.a());
        F0();
    }

    private void F0() {
        this.z = (RadioGroup) this.k.findViewById(R.id.nav_view_voice_selector_rg);
        this.A = (RadioGroup) this.k.findViewById(R.id.nav_view_guide_angle_selector_rg);
        this.C = (RadioButton) this.k.findViewById(R.id.nav_guide_angle_follow_rb);
        this.B = (RadioButton) this.k.findViewById(R.id.nav_guide_angle_true_north_rb);
        this.D = (RadioGroup) this.k.findViewById(R.id.nav_view_night_mode_selector_rg);
        this.E = (RadioGroup) this.k.findViewById(R.id.nav_view_overview_selector_rg);
        this.F = (RadioGroup) this.k.findViewById(R.id.nav_view_music_volume_selector_rg);
        this.G = (RadioGroup) this.k.findViewById(R.id.nav_float_setting_selector_rg);
        this.H = (RadioGroup) this.k.findViewById(R.id.nav_simple_guide_mode_selector_rg);
        this.V.b();
        this.z.setOnCheckedChangeListener(this);
        this.A.setOnCheckedChangeListener(this);
        this.D.setOnCheckedChangeListener(this);
        this.E.setOnCheckedChangeListener(this);
        this.F.setOnCheckedChangeListener(this);
        this.G.setOnCheckedChangeListener(this);
        this.H.setOnCheckedChangeListener(this);
        B0();
    }

    private void G0() {
        RadioGroup radioGroup = this.z;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup2 = this.A;
        if (radioGroup2 != null) {
            radioGroup2.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup3 = this.D;
        if (radioGroup3 != null) {
            radioGroup3.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup4 = this.E;
        if (radioGroup4 != null) {
            radioGroup4.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup5 = this.F;
        if (radioGroup5 != null) {
            radioGroup5.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup6 = this.H;
        if (radioGroup6 != null) {
            radioGroup6.setOnCheckedChangeListener(null);
        }
        RadioGroup radioGroup7 = this.G;
        if (radioGroup7 != null) {
            radioGroup7.setOnCheckedChangeListener(null);
        }
    }

    private void H0() {
        ImageView imageView = this.J;
        Resources resources = JarUtils.getResources();
        int i = R.drawable.nsdk_drawable_common_ic_setting_right_arrow;
        imageView.setImageDrawable(resources.getDrawable(i));
        this.K.setImageDrawable(JarUtils.getResources().getDrawable(i));
        this.L.setImageDrawable(JarUtils.getResources().getDrawable(i));
        this.M.setImageDrawable(JarUtils.getResources().getDrawable(i));
        this.N.setImageDrawable(JarUtils.getResources().getDrawable(i));
        int i2 = 0;
        int i3 = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.j0;
            if (i3 >= iArr.length) {
                break;
            }
            TextView textView = (TextView) view.findViewById(iArr[i3]);
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#333333"));
            }
            i3++;
        }
        while (true) {
            View view2 = this.k;
            if (view2 == null) {
                break;
            }
            int[] iArr2 = this.k0;
            if (i2 >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i2]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_f));
            }
            i2++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.I;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_bg));
            this.I.setMiddleTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_middle_text));
            this.I.setLeftIconAlpha(1.0f);
            this.I.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_day));
            this.I.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_titlebar_ic_back_new));
        }
    }

    private void I0() {
        ImageView imageView = this.J;
        int i = R.drawable.nsdk_drawable_common_ic_setting_right_arrow;
        imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i, false));
        this.K.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i, false));
        this.L.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i, false));
        this.M.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i, false));
        this.N.setImageDrawable(com.baidu.navisdk.ui.util.b.c(i, false));
        int i2 = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.j0;
            if (i2 >= iArr.length) {
                break;
            }
            TextView textView = (TextView) view.findViewById(iArr[i2]);
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#ffffff"));
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            View view2 = this.k;
            if (view2 == null) {
                break;
            }
            int[] iArr2 = this.k0;
            if (i3 >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i3]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_b, false));
            }
            i3++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.I;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_d, false));
            this.I.setMiddleTextColor(Color.parseColor("#ffffff"));
            this.I.setLeftIconAlpha(0.3f);
            this.I.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_night));
            this.I.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_titlebar_ic_back_normal, false));
        }
    }

    private void w(int i) {
        try {
            this.h0[i] = !r0[i];
        } catch (Exception unused) {
        }
    }

    private void x(int i) {
        LinearLayout linearLayout = this.x;
        if (linearLayout != null) {
            linearLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A(boolean z) {
        LinearLayout linearLayout;
        if (!z && (linearLayout = this.x) != null) {
            linearLayout.isShown();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A0() {
        this.f8729o0 = true;
        int mapMode = BNCommSettingManager.getInstance().getMapMode();
        if (mapMode != 1 && mapMode != 3) {
            r(1);
        } else {
            r(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void H() {
        this.w = null;
        c((String) null);
        this.h0[0] = false;
        j(0);
        this.V.a(32, this.h0[0]);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void T() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void c0() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && (aVar = this.c) != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void f(int i) {
        RadioGroup radioGroup = this.D;
        if (radioGroup != null) {
            if (i == 0) {
                radioGroup.check(R.id.nav_night_mode_auto_rb);
            } else if (i == 1) {
                radioGroup.check(R.id.nav_day_mode_rb);
            } else {
                radioGroup.check(R.id.nav_night_mode_rb);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(this.o, this.I);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void getVoiceMode(int i) {
        if (i == 0) {
            this.z.check(R.id.nav_voice_play_rb);
        } else if (i == 1) {
            this.z.check(R.id.nav_voice_mute_rb);
        } else if (i == 2) {
            this.z.check(R.id.nav_voice_warning_rb);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void h(int i) {
        RadioGroup radioGroup = this.H;
        if (radioGroup != null) {
            if (i == 0) {
                radioGroup.check(R.id.nav_default_mode_rb);
            } else {
                radioGroup.check(R.id.nav_simple_mode_rb);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void i(int i) {
        if (i == 0) {
            this.c0.setChecked(true);
            this.d0.setChecked(false);
            this.e0.setChecked(false);
        } else if (i == 1) {
            this.c0.setChecked(false);
            this.d0.setChecked(true);
            this.e0.setChecked(false);
        } else if (i == 2) {
            this.c0.setChecked(false);
            this.d0.setChecked(false);
            this.e0.setChecked(true);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void j(int i) {
        try {
            if (this.h0[i]) {
                this.g0[i].setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkin_icon));
            } else {
                this.g0[i].setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkout_icon));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void n(int i) {
        RadioGroup radioGroup = this.F;
        if (radioGroup != null && this.P != null) {
            if (i == 0) {
                radioGroup.check(R.id.nav_music_volume_lower_rb);
                this.P.setText(JarUtils.getResources().getString(R.string.setting_val_lower));
            } else {
                radioGroup.check(R.id.nav_music_volume_stop_rb);
                this.P.setText(JarUtils.getResources().getString(R.string.setting_val_stop));
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void o(int i) {
        RadioGroup radioGroup = this.G;
        if (radioGroup != null && this.Q != null) {
            if (i == 0) {
                radioGroup.check(R.id.nav_float_setting_rb);
                this.Q.setText(JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_pip));
            } else {
                radioGroup.check(R.id.nav_float_setting_rb_2);
                this.Q.setText(JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_float));
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.nav_voice_play_rb) {
            BNSettingManager.getVoiceMode();
            this.V.g();
            c0();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_play_inset"));
            return;
        }
        if (i == R.id.nav_voice_warning_rb) {
            TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_voice_mode_switch_off_play_warning_text), 1);
            this.V.h();
            c0();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_justwarning_inset"));
            return;
        }
        if (i == R.id.nav_voice_mute_rb) {
            TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice), 1);
            this.V.i();
            c0();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_quiet_inset"));
            return;
        }
        if (i == R.id.nav_guide_angle_follow_rb) {
            this.V.e();
            if (!this.f8729o0) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_3d_inset"));
            }
            this.f8729o0 = false;
            return;
        }
        if (i == R.id.nav_guide_angle_true_north_rb) {
            this.V.f();
            if (!this.f8729o0) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_2d_inset"));
            }
            this.f8729o0 = false;
            return;
        }
        if (i == R.id.nav_night_mode_auto_rb) {
            this.V.b(1);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_auto_day_night_mode"));
            return;
        }
        if (i == R.id.nav_day_mode_rb) {
            this.V.b(2);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_day_mode"));
            return;
        }
        if (i == R.id.nav_night_mode_rb) {
            this.V.b(3);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_night_mode"));
            return;
        }
        if (i == R.id.nav_music_volume_lower_rb) {
            this.V.c(0);
            TextView textView = this.P;
            if (textView != null) {
                textView.setText(JarUtils.getResources().getString(R.string.setting_val_lower));
                return;
            }
            return;
        }
        if (i == R.id.nav_music_volume_stop_rb) {
            this.V.c(1);
            TextView textView2 = this.P;
            if (textView2 != null) {
                textView2.setText(JarUtils.getResources().getString(R.string.setting_val_stop));
                return;
            }
            return;
        }
        if (i == R.id.nav_overview_thumbnail_rb) {
            this.V.d(0);
            c0();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_roadconditon_mapmini"));
            return;
        }
        if (i == R.id.nav_overview_road_condition_rb) {
            this.V.d(1);
            c0();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_roadconditon_bar"));
            return;
        }
        if (i == R.id.nav_default_mode_rb) {
            if (com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a()) {
                this.V.e(0);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_standard_mode"));
                return;
            }
            return;
        }
        if (i == R.id.nav_simple_mode_rb) {
            if (com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a()) {
                this.V.e(1);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_simple_mode"));
                return;
            }
            return;
        }
        if (i == R.id.nav_float_setting_rb) {
            this.V.a(0);
            this.Q.setText(JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_pip));
            this.h0[6] = BNCommSettingManager.getInstance().getPrefFloatSwitch();
            j(6);
            return;
        }
        if (i == R.id.nav_float_setting_rb_2) {
            this.V.a(1);
            this.Q.setText(JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_float));
            this.h0[6] = BNCommSettingManager.getInstance().getPrefFloatSwitch();
            j(6);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        try {
            int id = view.getId();
            if (id == R.id.nav_guide_angle_hud_rb) {
                this.V.c(this.f9165a);
                return;
            }
            if (id == R.id.left_imageview) {
                com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
                if (aVar != null) {
                    aVar.j();
                    return;
                }
                return;
            }
            if (id == R.id.nav_view_car_logo_select_layout) {
                this.V.j();
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_carlogo"));
                com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.1", "3", null, null);
                return;
            }
            if (id == R.id.nav_scale_layout) {
                w(1);
                this.V.a(this.h0, 1);
                return;
            }
            if (id == R.id.nav_license_plates_limit_layout) {
                if (BNRoutePlaner.getInstance().B()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
                    return;
                }
                w(0);
                this.V.a(this.h0, 0);
                com.baidu.navisdk.module.routepreference.d.j().b(this.h0[0]);
                if (this.h0[0]) {
                    BNRoutePlaner.getInstance().b(this.w);
                    return;
                }
                return;
            }
            if (id == R.id.nav_license_passport_layout) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "点击通行证管理！");
                }
                if (TextUtils.isEmpty(com.baidu.navisdk.h.a())) {
                    TipTool.onCreateToastDialog(this.k.getContext(), "请添加车辆！");
                    return;
                } else {
                    com.baidu.navisdk.framework.b.a(1, com.baidu.navisdk.h.a(), true);
                    return;
                }
            }
            if (id == R.id.nav_real_enlarge_layout) {
                w(2);
                this.V.a(this.h0, 2);
                return;
            }
            if (id == R.id.nav_show_car_logo_to_end_layout) {
                w(4);
                this.V.a(this.h0, 4);
                return;
            }
            if (id == R.id.nav_park_layout) {
                if (!this.h0[5] && !com.baidu.navisdk.module.cloudconfig.f.c().c.A) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "当前地区暂不支持停车场推荐服务");
                    return;
                } else {
                    w(5);
                    this.V.a(this.h0, 5);
                    return;
                }
            }
            if (id == R.id.nav_float_setting_cb) {
                boolean z = this.h0[6];
                if (BNCommSettingManager.getInstance().getFloatMode() == 0) {
                    if (!z) {
                        com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.5", "1");
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.5", "2");
                    }
                } else if (!z) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.1", "", null, null);
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.1", null, "", null);
                }
                if (!z && !com.baidu.navisdk.module.newguide.settings.viewmodel.a.a(com.baidu.navisdk.framework.a.c().b())) {
                    return;
                }
                w(6);
                this.V.a(this.h0, 6);
                return;
            }
            if (id == R.id.nav_license_plates_limit_link_tv) {
                com.baidu.navisdk.framework.b.a(this.f9165a);
                return;
            }
            if (id == R.id.bnav_rg_menu_nav_voice_layout) {
                LogUtil.e("RouteGuide", "VoicePage-点击切换语音->");
                BNSettingManager.setFirstVoiceGuide(true);
                ImageView imageView = this.U;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (com.baidu.navisdk.function.b.FUNC_CUSTOM_VOICE.a()) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.6", "1", null, null);
                    com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.c;
                    if (aVar2 != null) {
                        aVar2.a(5, 3, 0, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (id == R.id.car_plate_guide) {
                if (BNRoutePlaner.getInstance().B()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
                    return;
                }
                if (!TextUtils.isEmpty(this.w)) {
                    if (com.baidu.navisdk.framework.b.e0()) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "3", null, "1");
                        com.baidu.navisdk.h.a(this.f9165a, true);
                        this.t.setText(com.baidu.navisdk.h.a());
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "2", null, "1");
                        com.baidu.navisdk.h.f(this.f9165a);
                        this.t.setText(com.baidu.navisdk.h.a());
                    }
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "1", null, "1");
                    com.baidu.navisdk.h.e(this.f9165a);
                    this.t.setText(com.baidu.navisdk.h.a());
                }
                this.V.a(32, this.h0[0]);
                this.y.setVisibility(8);
                x(8);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_modify_carplate"));
                return;
            }
            if (id == R.id.mark) {
                this.y.setVisibility(8);
                x(8);
                return;
            }
            if (id != R.id.nav_additional_right_tv && id != R.id.title_bar) {
                if (id == R.id.nav_power_saver_setting_layout) {
                    if (!this.h0[7] && !com.baidu.navisdk.util.common.l.c(this.f9165a)) {
                        com.baidu.navisdk.ui.routeguide.control.x.b().t4();
                        return;
                    } else {
                        w(7);
                        this.V.a(this.h0, 7);
                        return;
                    }
                }
                if (id == R.id.nav_calling_play_layout) {
                    w(8);
                    this.V.a(this.h0, 8);
                    return;
                }
                if (id == R.id.bluetooth_default_layout) {
                    this.V.a(this.f9165a, 0);
                    return;
                }
                if (id == R.id.bluetooth_phone_layout) {
                    CheckBox checkBox = (CheckBox) this.k.findViewById(R.id.bluetooth_phone_play_checkbox);
                    if (checkBox != null && !checkBox.isChecked()) {
                        this.V.a(this.f9165a, 1);
                        return;
                    }
                    return;
                }
                if (id == R.id.bluetooth_speaker_layout) {
                    this.V.a(this.f9165a, 2);
                    return;
                }
                if (id == R.id.nav_scenic_setting_layout) {
                    if (!com.baidu.navisdk.module.cloudconfig.f.c().c.H) {
                        TipTool.onCreateToastDialog(this.f9165a, "服务暂不可用，敬请期待");
                        return;
                    } else {
                        w(9);
                        this.V.a(this.h0, 9);
                        return;
                    }
                }
                if (id == R.id.bnav_rg_menu_broadcast_content_select_layout) {
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.m");
                    BNSettingManager.setIsEnteredBroadcastContentSettingPage(true);
                    C0();
                    com.baidu.navisdk.framework.b.a(14, (Object) 0);
                    return;
                }
                if (id == R.id.bnav_rg_user_feedback_layout) {
                    com.baidu.navisdk.skyeye.a.n().a(64, 255, "用户上报");
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.c cVar = this.V;
        if (cVar != null) {
            cVar.a(this.f9165a);
        }
        C0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_menu_more_setting_container;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void q(boolean z) {
        ImageView imageView = this.O;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.nsdk_layout_rg_mapmode_menu_more_setting;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void r(int i) {
        if (this.A != null) {
            if (i == 0) {
                this.C.setChecked(true);
            } else if (i == 1) {
                this.B.setChecked(true);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.nsdk_layout_rg_mapmode_menu_more_setting;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "RouteGuide";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
        BNCommonTitleBar bNCommonTitleBar = this.I;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.findViewById(R.id.left_imageview).setOnClickListener(this);
            this.I.setOnClickListener(this);
        }
        View view = this.k;
        if (view == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("MenuMoreView rootview is null");
                return;
            }
            return;
        }
        view.findViewById(R.id.nav_license_plates_limit_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_license_passport_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_real_enlarge_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_show_car_logo_to_end_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_scale_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_park_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_float_setting_cb).setOnClickListener(this);
        this.k.findViewById(R.id.nav_view_car_logo_select_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_guide_angle_hud_rb).setOnClickListener(this);
        this.k.findViewById(R.id.nav_power_saver_setting_layout).setOnClickListener(this);
        View findViewById = this.k.findViewById(R.id.bnav_rg_menu_h_split_2);
        View findViewById2 = this.k.findViewById(R.id.bnav_rg_menu_broadcast_content_select_layout);
        if (com.baidu.navisdk.function.b.FUNC_DIY_SPEAK.a()) {
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
        this.k.findViewById(R.id.bnav_rg_menu_nav_voice_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_additional_right_tv).setOnClickListener(this);
        this.k.findViewById(R.id.nav_calling_play_layout).setOnClickListener(this);
        this.k.findViewById(R.id.nav_scenic_setting_layout).setOnClickListener(this);
        this.k.findViewById(R.id.bluetooth_default_layout).setOnClickListener(this);
        this.k.findViewById(R.id.bluetooth_phone_layout).setOnClickListener(this);
        if (com.baidu.navisdk.bluetooth.a.a()) {
            this.k.findViewById(R.id.bluetooth_speaker_layout).setOnClickListener(this);
        } else {
            this.k.findViewById(R.id.bluetooth_speaker_layout).setVisibility(8);
        }
        View view2 = this.f0;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void u(boolean z) {
        if (this.U == null) {
            return;
        }
        if (!com.baidu.navisdk.function.b.FUNC_RED_PROMPT.a()) {
            this.U.setVisibility(8);
        } else if (z) {
            this.U.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        ImageView imageView;
        View view = this.k;
        if (view == null) {
            return;
        }
        this.I = (BNCommonTitleBar) view.findViewById(R.id.title_bar);
        this.n = this.k.findViewById(R.id.bnav_top_empty_view);
        this.o = (ScrollView) this.k.findViewById(R.id.bnav_rg_menu_more_scroll);
        this.Y = (RadioButton) this.k.findViewById(R.id.nav_default_mode_rb);
        this.Z = (RadioButton) this.k.findViewById(R.id.nav_simple_mode_rb);
        this.a0 = (RadioButton) this.k.findViewById(R.id.nav_overview_thumbnail_rb);
        this.b0 = (RadioButton) this.k.findViewById(R.id.nav_overview_road_condition_rb);
        this.g0[0] = (ImageView) this.k.findViewById(R.id.nav_license_plates_limit_condition_cb);
        this.g0[1] = (ImageView) this.k.findViewById(R.id.nav_scale_cb);
        this.g0[2] = (ImageView) this.k.findViewById(R.id.nav_real_enlarge_cb);
        this.g0[4] = (ImageView) this.k.findViewById(R.id.nav_show_car_logo_to_end_cb);
        this.g0[5] = (ImageView) this.k.findViewById(R.id.nav_park_cb);
        this.g0[6] = (ImageView) this.k.findViewById(R.id.nav_float_setting_cb);
        this.g0[7] = (ImageView) this.k.findViewById(R.id.nav_power_saver_setting_cb);
        this.g0[8] = (ImageView) this.k.findViewById(R.id.nav_calling_play_checkbox);
        this.g0[9] = (ImageView) this.k.findViewById(R.id.nav_scenic_setting_cb);
        this.O = (ImageView) this.k.findViewById(R.id.bnav_rg_menu_car_logo_red_guide);
        this.U = (ImageView) this.k.findViewById(R.id.bnav_rg_menu_voice_red_guide);
        this.L = (ImageView) this.k.findViewById(R.id.nav_logo_right_iv);
        this.X = (TextView) this.k.findViewById(R.id.nav_voice_language_text_tv);
        this.P = (TextView) this.k.findViewById(R.id.tv_music_volume_tips);
        this.Q = (TextView) this.k.findViewById(R.id.nav_float_setting_tips_tv);
        this.M = (ImageView) this.k.findViewById(R.id.nav_voice_arrow_iv);
        View view2 = this.k;
        int i = R.id.bnav_rg_menu_broadcast_right_iv;
        this.N = (ImageView) view2.findViewById(i);
        this.c0 = (CheckBox) this.k.findViewById(R.id.bluetooth_default_play_checkbox);
        this.d0 = (CheckBox) this.k.findViewById(R.id.bluetooth_phone_play_checkbox);
        this.e0 = (CheckBox) this.k.findViewById(R.id.bluetooth_speaker_play_checkbox);
        this.R = (ImageView) this.k.findViewById(i);
        this.S = (TextView) this.k.findViewById(R.id.bnav_rg_menu_broadcast_selected_tv);
        this.T = (TextView) this.k.findViewById(R.id.bnav_rg_menu_broadcast_tips_tv);
        if (com.baidu.navisdk.skyeye.a.n().g()) {
            View findViewById = this.k.findViewById(R.id.bnav_rg_user_feedback_layout);
            this.f0 = findViewById;
            findViewById.setVisibility(0);
        }
        this.V.c();
        E0();
        D0();
        C0();
        int d0 = com.baidu.navisdk.ui.routeguide.control.x.b().d0();
        b(d0, this.Y);
        b(d0, this.Z);
        a(d0, this.a0);
        a(d0, this.b0);
        View findViewById2 = this.I.findViewById(R.id.title_bar_divide_line);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        if (this.o.getViewTreeObserver().isAlive()) {
            this.o.getViewTreeObserver().addOnScrollChangedListener(this.p0);
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().s.d && (imageView = (ImageView) this.k.findViewById(R.id.nav_logo_tip_image)) != null) {
            imageView.setImageResource(R.drawable.nsdk_icon_3d_car_logo_tip);
            imageView.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public boolean y0() {
        if (!this.h0[0] || TextUtils.isEmpty(this.W) || TextUtils.isEmpty(this.w)) {
            return false;
        }
        return !TextUtils.equals(this.W, this.w);
    }

    private void b(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (i == 1) {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_77dp);
            if (view == this.Y) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_17dp);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_guide_panel_default_mode_setting_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_guide_panel_simple_mode_setting_selector));
            }
        } else {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_94dp);
            if (view == this.Y) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_44dp);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_guide_panel_default_mode_setting_land_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_guide_panel_simple_mode_setting_land_selector));
            }
        }
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        if (this.n0) {
            this.n0 = false;
            C(true);
        }
        b(i, this.Y);
        b(i, this.Z);
        a(i, this.a0);
        a(i, this.b0);
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.c cVar = this.V;
        if (cVar != null) {
            cVar.a();
        }
        f0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.framework.message.a.a().a(this.q0);
        if (a()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().b5();
            G0();
        }
        super.c();
        x(8);
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_back_to_navi"));
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void d(String str) {
        this.w = str;
        c(str);
        this.V.a(32, this.h0[0]);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void q(int i) {
        RadioGroup radioGroup = this.E;
        if (radioGroup != null) {
            if (i == 0) {
                radioGroup.check(R.id.nav_overview_thumbnail_rb);
            } else {
                radioGroup.check(R.id.nav_overview_road_condition_rb);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void c(int i, int i2) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.a(6, i, i2, null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        ScrollView scrollView = this.o;
        if (scrollView == null || !scrollView.getViewTreeObserver().isAlive()) {
            return;
        }
        this.o.getViewTreeObserver().removeOnScrollChangedListener(this.p0);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void c(String str) {
        if (this.t == null || this.v == null || this.u == null || this.s == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.t.setText(str);
            if (this.h0[0]) {
                this.v.setText("常用车辆，已开启限行避让");
            } else {
                this.v.setText("常用车辆，未开启限行避让");
            }
            this.u.setText("修改车牌");
            if (com.baidu.navisdk.framework.b.S()) {
                this.s.setText("(新能源车牌)");
                this.s.setTextColor(Color.parseColor("#45cc6a"));
                return;
            } else {
                this.s.setText("");
                return;
            }
        }
        this.t.setText("车牌信息");
        this.v.setText("请填写车牌信息，可避让限行路线");
        this.u.setText("添加车牌");
        this.s.setText("");
    }

    private void a(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i2;
        int i3;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (i == 1) {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_77dp);
            if (view == this.a0) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_17dp);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_selector));
            }
        } else {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_94dp);
            boolean A = com.baidu.navisdk.ui.routeguide.b.V().A();
            if (view == this.a0) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_44dp);
                if (A) {
                    i3 = R.drawable.bnav_hicar_moresetting_map_switch_land_selector;
                } else {
                    i3 = R.drawable.bnav_moresetting_map_switch_land_selector;
                }
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i3));
            } else {
                if (A) {
                    i2 = R.drawable.bnav_hicar_moresetting_road_condition_bar_land_selector;
                } else {
                    i2 = R.drawable.bnav_moresetting_road_condition_bar_land_selector;
                }
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i2));
            }
        }
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        if (this.k == null) {
            com.baidu.navisdk.util.common.g.PRO_NAV.a("Common: ", "menuMoreView mRootView is null");
            return false;
        }
        com.baidu.navisdk.asr.d.B().a(1);
        com.baidu.navisdk.framework.c.b().a(13, 16);
        f0();
        this.n.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        com.baidu.navisdk.module.routepreference.d.j().e(com.baidu.navisdk.module.routepreference.d.j().f());
        this.W = com.baidu.navisdk.h.a();
        com.baidu.navisdk.ui.routeguide.control.s.T().o();
        com.baidu.navisdk.ui.routeguide.control.s.T().p();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h1();
        this.V.a();
        E0();
        C0();
        this.V.a(this.f9165a);
        if (bundle != null) {
            boolean z = bundle.getBoolean("open_car_plate", false);
            LogUtil.e("RouteGuide", "openCarPlate: " + z);
            if (z) {
                C(false);
            }
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().a();
        com.baidu.navisdk.framework.message.a.a().a(this.q0, com.baidu.navisdk.framework.message.bean.k.class, new Class[0]);
        this.T.setText(com.baidu.navisdk.ui.routeguide.module.diyspeak.j.a());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fa, code lost:
    
        H0();
     */
    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.d0.a(boolean):void");
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void a(int i, int i2, Intent intent) {
        if (i == 3001) {
            if (com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
                w(6);
                this.V.a(this.h0, 6);
                return;
            }
            return;
        }
        if (i == 4101) {
            if (com.baidu.navisdk.util.common.l.c(com.baidu.navisdk.framework.a.c().a())) {
                w(7);
                this.V.a(this.h0, 7);
                return;
            }
            return;
        }
        if (i == 3006 && BNSettingManager.hasPipPermission()) {
            w(6);
            this.V.a(this.h0, 6);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.d
    public void a(String str) {
        if (this.X == null || com.baidu.navisdk.util.common.l0.c(str)) {
            return;
        }
        if (str.length() > 8) {
            str = str.substring(0, 8) + "...";
        }
        this.X.setText(str);
    }
}
