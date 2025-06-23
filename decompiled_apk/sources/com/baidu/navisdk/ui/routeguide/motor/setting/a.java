package com.baidu.navisdk.ui.routeguide.motor.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.k;
import com.baidu.navisdk.module.motorbike.view.support.module.setting.widgets.MotorPlateView;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainImageItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSelectItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.widget.g implements com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b, BNSettingExplainSwitchItem.c, MotorPlateView.c, View.OnClickListener {
    private BNSettingExplainSelectItem A;
    private BNSettingExplainImageItem B;
    private BNSettingExplainSwitchItem C;
    private BNCommonTitleBar D;
    private View E;
    private View F;
    private RadioButton G;
    private RadioButton H;
    private ScrollView I;
    private com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a J;
    private Activity K;
    private com.baidu.navisdk.module.motorbike.logic.plate.c L;
    private a.InterfaceC0201a M;
    private int[] N;
    private int[] O;
    private int[] P;
    private int[] Q;
    ViewTreeObserver.OnScrollChangedListener R;
    private MotorPlateView n;
    private BNSettingExplainSwitchItem o;
    private BNSettingExplainSwitchItem p;
    private BNSettingExplainSwitchItem q;
    private BNSettingExplainSwitchItem r;
    private ImageView s;
    private TextView t;
    private BNSettingTextRadioGroup u;
    private BNSettingTextRadioGroup v;
    private RadioGroup w;
    private BNSettingExplainSwitchItem x;
    private BNSettingTextRadioGroup y;
    private BNSettingTextRadioGroup z;

    /* renamed from: com.baidu.navisdk.ui.routeguide.motor.setting.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0469a implements a.InterfaceC0201a {
        public C0469a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            LogUtil.e("TTS", "mMenuMoreEvent - onEvent : " + obj.getClass().getSimpleName());
            if ((obj instanceof k) && ((k) obj).a() == 0 && a.this.J != null) {
                a.this.J.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (a.this.I.getScrollY() - a.this.F.getHeight() >= 0) {
                if (a.this.D != null) {
                    a.this.D.setMiddleTextVisible(true);
                    a.this.D.setMiddleText("导航设置");
                    int dip2px = ScreenUtil.getInstance().dip2px(16);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("MotorNaviSettingPage", "MoreSettingTitleSize = " + dip2px);
                    }
                    a.this.D.setMiddleTextSizePX(dip2px);
                    a.this.D.setRightTextVisible(false);
                    return;
                }
                return;
            }
            a.this.D.setMiddleText("");
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BNSettingTextRadioGroup.a {
        public c() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup.a
        public void a(CharSequence charSequence, int i) {
            int i2;
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            a.this.J.d(i2);
            a.this.w(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BNSettingTextRadioGroup.a {
        public d() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup.a
        public void a(CharSequence charSequence, int i) {
            int i2 = 2;
            if (i == 1) {
                TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice), 1);
            } else if (i == 2) {
                TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_voice_mode_switch_off_play_warning_text), 1);
                i2 = 3;
            } else {
                i2 = 0;
            }
            a.this.p(i2);
            a.this.c(0, i2);
            a.this.c0();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BNSettingTextRadioGroup.a {
        public e() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup.a
        public void a(CharSequence charSequence, int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorNaviSettingPage", "mGuideAngleRadioGroup initListener(), content = " + ((Object) charSequence) + " position = " + i);
            }
            if (a.this.J != null) {
                if (i == 0) {
                    a.this.J.c(1);
                } else if (i == 1) {
                    a.this.J.c(2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements BNSettingTextRadioGroup.a {
        public f() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup.a
        public void a(CharSequence charSequence, int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorNaviSettingPage", "mDayNightRadioGroup initListener(), content = " + ((Object) charSequence) + " position = " + i);
            }
            int i2 = 1;
            if (i != 0) {
                if (i == 1) {
                    i2 = 2;
                } else if (i == 2) {
                    i2 = 3;
                }
            }
            if (a.this.J != null) {
                a.this.J.b(i2);
            }
            a.this.m(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements RadioGroup.OnCheckedChangeListener {
        public g() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int i2;
            if (i == R.id.motor_overview_road_condition_rb) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (a.this.J != null) {
                a.this.J.a(i2);
            }
            a.this.k(i2);
        }
    }

    public a(Activity activity, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(activity, viewGroup, aVar, 2);
        this.D = null;
        this.M = new C0469a();
        this.N = new int[]{R.id.motor_menu_h_split_plate_1, R.id.motor_menu_h_split_show_content_1, R.id.motor_menu_h_split_show_content_2, R.id.motor_menu_h_split_show_content_3, R.id.motor_menu_h_split_show_content_4, R.id.motor_menu_h_split_voice_1, R.id.motor_menu_h_split_nav_2, R.id.motor_menu_h_split_nav_4, R.id.motor_menu_h_split_nav_5, R.id.motor_menu_h_split_nav_6};
        this.O = new int[]{R.id.motor_navi_show_content_group_ly, R.id.motor_navi_voice_group_ly, R.id.motor_navi_assist_group_ly};
        this.P = new int[]{R.id.motor_navi_more_setting_tv, R.id.motor_navi_voice_setting_tv, R.id.motor_navi_assist_setting_tv};
        this.Q = new int[]{R.id.motor_nav_plate_info_tv, R.id.motor_map_switch_text, R.id.motor_road_condition_bar_text, R.id.motor_nav_guide_angle_tv, R.id.motor_nav_day_night_mode_tv, R.id.motor_nav_float_mode_tv};
        this.R = new b();
        this.K = activity;
        com.baidu.navisdk.ui.routeguide.motor.setting.b bVar = new com.baidu.navisdk.ui.routeguide.motor.setting.b(activity);
        this.J = bVar;
        bVar.a((com.baidu.navisdk.ui.routeguide.motor.setting.b) this);
    }

    private boolean B(boolean z) {
        boolean z2;
        View view = this.k;
        if (view != null) {
            int[] iArr = this.N;
            if (iArr.length > 0 && view.findViewById(iArr[0]) != null) {
                int color = ((ColorDrawable) this.k.findViewById(this.N[0]).getBackground()).getColor();
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
        if (!com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            this.k.findViewById(R.id.motor_setting_plate_container).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            this.A.setVisibility(8);
            this.k.findViewById(R.id.motor_menu_h_split_voice_1).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_CAR_LOGO_SELECT.a()) {
            this.B.setVisibility(8);
            this.k.findViewById(R.id.motor_menu_h_split_nav_2).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            this.q.setVisibility(8);
            this.k.findViewById(R.id.motor_menu_h_split_nav_6).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a()) {
            this.k.findViewById(R.id.motor_float_setting_layout).setVisibility(8);
            this.k.findViewById(R.id.motor_menu_h_split_nav_5).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            this.r.setVisibility(8);
            this.k.findViewById(R.id.motor_menu_h_split_nav_6).setVisibility(8);
        }
    }

    private void C0() {
        int i = 0;
        int i2 = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.Q;
            if (i2 >= iArr.length) {
                break;
            }
            TextView textView = (TextView) view.findViewById(iArr[i2]);
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#333333"));
            }
            i2++;
        }
        while (true) {
            View view2 = this.k;
            if (view2 == null) {
                break;
            }
            int[] iArr2 = this.P;
            if (i >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_f));
            }
            i++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.D;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_bg));
            this.D.setMiddleTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_middle_text));
            this.D.setLeftIconAlpha(1.0f);
            this.D.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_day));
            this.D.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_titlebar_ic_back_new));
        }
    }

    private void D0() {
        int i = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.Q;
            if (i >= iArr.length) {
                break;
            }
            TextView textView = (TextView) view.findViewById(iArr[i]);
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#ffffff"));
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            View view2 = this.k;
            if (view2 == null) {
                break;
            }
            int[] iArr2 = this.P;
            if (i2 >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i2]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_b, false));
            }
            i2++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.D;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_d, false));
            this.D.setMiddleTextColor(Color.parseColor("#ffffff"));
            this.D.setLeftIconAlpha(0.3f);
            this.D.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_night));
            this.D.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_titlebar_ic_back_normal, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        String str;
        if (i == 0) {
            str = JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_pip);
        } else if (i == 1) {
            str = JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_float);
        } else {
            str = "";
        }
        this.t.setText(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A0() {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar != null) {
            l(aVar.d());
        }
    }

    public void c0() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && (aVar = this.c) != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void e(String str) {
        BNSettingExplainSelectItem bNSettingExplainSelectItem = this.A;
        if (bNSettingExplainSelectItem != null) {
            bNSettingExplainSelectItem.a(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        x.b().a(this.I, this.D);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void g(int i) {
        if (i == 0) {
            this.z.a(0);
        } else if (i == 1) {
            this.z.a(1);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void i(boolean z) {
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void j(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.r;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void k(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.C;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void l(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.p;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void m(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.v;
        if (bNSettingTextRadioGroup != null) {
            if (i == 1) {
                bNSettingTextRadioGroup.a(0);
            } else if (i == 2) {
                bNSettingTextRadioGroup.a(1);
            } else if (i == 3) {
                bNSettingTextRadioGroup.a(2);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem.c
    public boolean onChecked(int i, boolean z) {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar == null) {
            return false;
        }
        if (i == R.id.motor_power_saver_layout) {
            if (z && !l.c(this.K)) {
                com.baidu.navisdk.util.common.c.c(this.K);
                return false;
            }
            this.J.d(z);
            return true;
        }
        if (i == R.id.motor_scenic_layout) {
            aVar.g(z);
            return true;
        }
        if (i == R.id.motor_calling_play_layout) {
            aVar.e(z);
            return true;
        }
        if (i == R.id.motor_plate_limit_setting_layout) {
            aVar.f(z);
            return true;
        }
        if (i == R.id.motor_scale_layout) {
            aVar.b(z);
            return true;
        }
        if (i == R.id.motor_show_enlarged_item) {
            aVar.c(z);
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.J == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.motor_star_voice_layout) {
            this.J.h();
            return;
        }
        if (id == R.id.motor_nav_logo_item) {
            this.J.f();
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.1", "3", null, null);
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
        if (id == R.id.motor_nav_float_setting_cb) {
            boolean isSelected = view.isSelected();
            boolean z = !isSelected;
            if (!isSelected && !com.baidu.navisdk.util.common.c.a(this.K)) {
                return;
            }
            this.J.a(!view.isSelected());
            view.setSelected(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void p(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.y;
        if (bNSettingTextRadioGroup != null) {
            int i2 = 2;
            if (i != 2) {
                if (i != 3) {
                    i2 = 0;
                }
            } else {
                i2 = 1;
            }
            bNSettingTextRadioGroup.a(i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_menu_more_setting_container;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.motor_layout_navi_more_setting;
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void r(boolean z) {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.motor_layout_navi_more_setting;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "MotorNaviSettingPage";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
        this.p.setOnCheckedListener(this);
        this.s.setOnClickListener(this);
        this.q.setOnCheckedListener(this);
        this.r.setOnCheckedListener(this);
        this.o.setOnCheckedListener(this);
        this.C.setOnCheckedListener(this);
        this.n.setPlateClickListener(this);
        this.x.setOnCheckedListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        BNCommonTitleBar bNCommonTitleBar = this.D;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.findViewById(R.id.left_imageview).setOnClickListener(this);
            this.D.setOnClickListener(this);
        }
        this.z.setOnCheckedChangeListener(new c());
        this.y.setOnCheckedChangeListener(new d());
        this.u.setOnCheckedChangeListener(new e());
        this.v.setOnCheckedChangeListener(new f());
        this.w.setOnCheckedChangeListener(new g());
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void v(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.x;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        this.n = (MotorPlateView) this.k.findViewById(R.id.motor_setting_edit_plate);
        this.o = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_plate_limit_setting_layout);
        this.p = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_calling_play_layout);
        this.s = (ImageView) this.k.findViewById(R.id.motor_nav_float_setting_cb);
        this.t = (TextView) this.k.findViewById(R.id.motor_nav_float_tips);
        this.q = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_scenic_layout);
        this.r = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_power_saver_layout);
        this.u = (BNSettingTextRadioGroup) this.k.findViewById(R.id.motor_nav_guide_angle_radio_group);
        this.v = (BNSettingTextRadioGroup) this.k.findViewById(R.id.motor_nav_day_night_mode_radio_group);
        this.w = (RadioGroup) this.k.findViewById(R.id.motor_view_overview_selector_rg);
        this.x = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_scale_layout);
        this.y = (BNSettingTextRadioGroup) this.k.findViewById(R.id.motor_nav_voice_play_mode_radio_group);
        this.z = (BNSettingTextRadioGroup) this.k.findViewById(R.id.motor_nav_float_mode_radio_group);
        if (!BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            this.z.setVisibility(8);
        }
        this.A = (BNSettingExplainSelectItem) this.k.findViewById(R.id.motor_star_voice_layout);
        this.B = (BNSettingExplainImageItem) this.k.findViewById(R.id.motor_nav_logo_item);
        this.C = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.motor_show_enlarged_item);
        View view = this.k;
        int i = R.id.motor_navi_setting_top_empty_view;
        this.E = view.findViewById(i);
        this.F = this.k.findViewById(R.id.motor_setting_plate_container);
        this.G = (RadioButton) this.k.findViewById(R.id.motor_overview_thumbnail_rb);
        this.H = (RadioButton) this.k.findViewById(R.id.motor_overview_road_condition_rb);
        BNCommonTitleBar bNCommonTitleBar = (BNCommonTitleBar) this.k.findViewById(R.id.motor_title_bar);
        this.D = bNCommonTitleBar;
        View findViewById = bNCommonTitleBar.findViewById(R.id.title_bar_divide_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.I = (ScrollView) this.k.findViewById(R.id.motor_navi_setting_scroll);
        int d0 = x.b().d0();
        a(d0, this.G);
        a(d0, this.H);
        this.k.findViewById(i).setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        if (this.I.getViewTreeObserver().isAlive()) {
            this.I.getViewTreeObserver().addOnScrollChangedListener(this.R);
        }
        B0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public boolean y0() {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar;
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar2 = this.J;
        if ((aVar2 != null && !aVar2.g()) || (aVar = this.J) == null) {
            return false;
        }
        return !this.L.equals(aVar.a());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        f0();
        com.baidu.navisdk.framework.message.a.a().a(this.M, k.class, new Class[0]);
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar != null) {
            aVar.c();
            this.L = this.J.a().m93clone();
        }
        com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().e(com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f());
        s.T().o();
        s.T().p();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h1();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.framework.message.a.a().a(this.M);
        if (a()) {
            x.b().b5();
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void d(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.o;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        ScrollView scrollView = this.I;
        if (scrollView == null || !scrollView.getViewTreeObserver().isAlive()) {
            return;
        }
        this.I.getViewTreeObserver().removeOnScrollChangedListener(this.R);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        if (B(z)) {
            return;
        }
        super.a(z);
        View view = this.E;
        int i = R.color.nsdk_cl_bg_d;
        view.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(i));
        this.F.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(i));
        View view2 = this.k;
        if (view2 != null) {
            view2.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_c));
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            View view3 = this.k;
            if (view3 == null) {
                break;
            }
            int[] iArr = this.N;
            if (i3 >= iArr.length) {
                break;
            }
            View findViewById = view3.findViewById(iArr[i3]);
            if (findViewById != null) {
                findViewById.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_b));
            }
            i3++;
        }
        while (true) {
            View view4 = this.k;
            if (view4 == null) {
                break;
            }
            int[] iArr2 = this.O;
            if (i2 >= iArr2.length) {
                break;
            }
            View findViewById2 = view4.findViewById(iArr2[i2]);
            if (findViewById2 != null) {
                findViewById2.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_setting_page_card_bg));
            }
            i2++;
        }
        if (z) {
            C0();
        } else {
            D0();
        }
        RadioButton radioButton = this.G;
        if (radioButton != null && this.H != null) {
            radioButton.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_selector));
            this.H.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_selector));
        }
        TextView textView = this.t;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_f, z));
        }
        MotorPlateView motorPlateView = this.n;
        if (motorPlateView != null) {
            motorPlateView.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.v;
        if (bNSettingTextRadioGroup != null) {
            bNSettingTextRadioGroup.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup2 = this.u;
        if (bNSettingTextRadioGroup2 != null) {
            bNSettingTextRadioGroup2.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup3 = this.z;
        if (bNSettingTextRadioGroup3 != null) {
            bNSettingTextRadioGroup3.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.r;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem2 = this.q;
        if (bNSettingExplainSwitchItem2 != null) {
            bNSettingExplainSwitchItem2.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem3 = this.p;
        if (bNSettingExplainSwitchItem3 != null) {
            bNSettingExplainSwitchItem3.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem4 = this.o;
        if (bNSettingExplainSwitchItem4 != null) {
            bNSettingExplainSwitchItem4.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem5 = this.C;
        if (bNSettingExplainSwitchItem5 != null) {
            bNSettingExplainSwitchItem5.a(z);
        }
        BNSettingExplainImageItem bNSettingExplainImageItem = this.B;
        if (bNSettingExplainImageItem != null) {
            bNSettingExplainImageItem.a(z);
        }
        BNSettingExplainSelectItem bNSettingExplainSelectItem = this.A;
        if (bNSettingExplainSelectItem != null) {
            bNSettingExplainSelectItem.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup4 = this.y;
        if (bNSettingTextRadioGroup4 != null) {
            bNSettingTextRadioGroup4.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem6 = this.x;
        if (bNSettingExplainSwitchItem6 != null) {
            bNSettingExplainSwitchItem6.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void k(int i) {
        RadioGroup radioGroup = this.w;
        if (radioGroup != null) {
            if (i == 0) {
                radioGroup.check(R.id.motor_overview_thumbnail_rb);
            } else if (i == 1) {
                radioGroup.check(R.id.motor_overview_road_condition_rb);
            }
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void l(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.u;
        if (bNSettingTextRadioGroup != null) {
            if (i == 1 || i == 3) {
                bNSettingTextRadioGroup.a(0);
            } else if (i == 2) {
                bNSettingTextRadioGroup.a(1);
            }
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void m(boolean z) {
        MotorPlateView motorPlateView = this.n;
        if (motorPlateView != null) {
            motorPlateView.b(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void w(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.q;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    public void c(int i, int i2) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.a(6, i, i2, null);
        }
    }

    @Override // com.baidu.navisdk.module.motorbike.view.support.module.setting.widgets.MotorPlateView.c
    public void b() {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.navisdk.module.motorbike.view.support.module.setting.widgets.MotorPlateView.c
    public void a(com.baidu.navisdk.module.motorbike.logic.plate.c cVar) {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar = this.J;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    @Override // com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b
    public void a(com.baidu.navisdk.module.motorbike.logic.plate.c cVar, boolean z) {
        MotorPlateView motorPlateView = this.n;
        if (motorPlateView != null) {
            motorPlateView.a(cVar, z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar;
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar2;
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a aVar3;
        if (i == 3001) {
            if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION") || (aVar3 = this.J) == null) {
                return;
            }
            aVar3.a(true);
            ImageView imageView = this.s;
            if (imageView != null) {
                imageView.setSelected(true);
                return;
            }
            return;
        }
        if (i == 4101) {
            if (!l.c(com.baidu.navisdk.framework.a.c().a()) || (aVar2 = this.J) == null) {
                return;
            }
            aVar2.d(true);
            BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.r;
            if (bNSettingExplainSwitchItem != null) {
                bNSettingExplainSwitchItem.setChecked(true);
                return;
            }
            return;
        }
        if (i == 3006 && BNCommSettingManager.getInstance().hasPipPermission() && (aVar = this.J) != null) {
            aVar.a(true);
            ImageView imageView2 = this.s;
            if (imageView2 != null) {
                imageView2.setSelected(true);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        a(i, this.G);
        a(i, this.H);
        f0();
    }

    private void a(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (i == 1) {
            marginLayoutParams.height = ScreenUtil.getInstance().dip2px(77);
            if (view == this.G) {
                marginLayoutParams.rightMargin = ScreenUtil.getInstance().dip2px(17);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_selector));
            }
        } else {
            marginLayoutParams.height = ScreenUtil.getInstance().dip2px(94);
            if (view == this.G) {
                marginLayoutParams.rightMargin = ScreenUtil.getInstance().dip2px(44);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_land_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_land_selector));
            }
        }
        view.setLayoutParams(marginLayoutParams);
    }
}
