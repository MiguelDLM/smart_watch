package com.baidu.navisdk.ui.routeguide.truck.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.k;
import com.baidu.navisdk.module.trucknavi.view.widgets.TruckVehicleInfoView;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainImageItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSelectItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.widget.g implements com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b, BNSettingExplainSwitchItem.c, View.OnClickListener {
    private BNSettingExplainSwitchItem A;
    private BNCommonTitleBar B;
    private View C;
    private RadioButton D;
    private RadioButton E;
    private ScrollView F;
    private com.baidu.navisdk.ui.routeguide.truck.setting.b G;
    private Activity H;
    private String I;
    private int J;
    private a.InterfaceC0201a K;
    private int[] L;
    private int[] M;
    private int[] N;
    private int[] O;
    ViewTreeObserver.OnScrollChangedListener P;
    private TruckVehicleInfoView n;
    private BNSettingExplainSwitchItem o;
    private BNSettingExplainSwitchItem p;
    private ImageView q;
    private TextView r;
    private BNSettingTextRadioGroup s;
    private BNSettingTextRadioGroup t;
    private RadioGroup u;
    private BNSettingExplainSwitchItem v;
    private BNSettingTextRadioGroup w;
    private BNSettingTextRadioGroup x;
    private BNSettingExplainSelectItem y;
    private BNSettingExplainImageItem z;

    /* renamed from: com.baidu.navisdk.ui.routeguide.truck.setting.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0482a implements a.InterfaceC0201a {
        public C0482a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            LogUtil.e("TTS", "mMenuMoreEvent - onEvent : " + obj.getClass().getSimpleName());
            if ((obj instanceof k) && ((k) obj).a() == 0 && a.this.G != null) {
                a.this.G.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (a.this.F.getScrollY() - a.this.n.getHeight() >= 0) {
                if (a.this.B != null) {
                    a.this.B.setMiddleTextVisible(true);
                    a.this.B.setMiddleText("导航设置");
                    int dip2px = ScreenUtil.getInstance().dip2px(16);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("TruckNaviSettingPage", "TruckSettingTitleSize = " + dip2px);
                    }
                    a.this.B.setMiddleTextSizePX(dip2px);
                    a.this.B.setRightTextVisible(false);
                    return;
                }
                return;
            }
            a.this.B.setMiddleText("");
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
            a.this.G.d(i2);
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
            a.this.c0();
            a.this.p(i2);
            a.this.c(0, i2);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BNSettingTextRadioGroup.a {
        public e() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingTextRadioGroup.a
        public void a(CharSequence charSequence, int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckNaviSettingPage", "mGuideAngleRadioGroup initListener(), content = " + ((Object) charSequence) + " position = " + i);
            }
            if (a.this.G != null) {
                if (i == 0) {
                    a.this.G.c(1);
                    a.this.l(1);
                } else if (i == 1) {
                    a.this.G.c(2);
                    a.this.l(2);
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
                LogUtil.e("TruckNaviSettingPage", "mDayNightRadioGroup initListener(), content = " + ((Object) charSequence) + " position = " + i);
            }
            int i2 = 1;
            if (i != 0) {
                if (i == 1) {
                    i2 = 2;
                } else if (i == 2) {
                    i2 = 3;
                }
            }
            if (a.this.G != null) {
                a.this.G.b(i2);
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
            if (i == R.id.truck_overview_road_condition_rb) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (a.this.G != null) {
                a.this.G.a(i2);
            }
            a.this.k(i2);
        }
    }

    public a(Activity activity, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(activity, viewGroup, aVar, 3);
        this.B = null;
        this.K = new C0482a();
        this.L = new int[]{R.id.truck_menu_h_split_show_content_1, R.id.truck_menu_h_split_show_content_2, R.id.truck_menu_h_split_show_content_3, R.id.truck_menu_h_split_show_content_4, R.id.truck_menu_h_split_voice_1, R.id.truck_menu_h_split_nav_1, R.id.truck_menu_h_split_nav_4, R.id.truck_menu_h_split_nav_6};
        this.M = new int[]{R.id.truck_navi_show_content_group_ly, R.id.truck_navi_voice_group_ly, R.id.truck_navi_assist_group_ly};
        this.N = new int[]{R.id.truck_navi_more_setting_tv, R.id.truck_navi_voice_setting_tv, R.id.truck_navi_assist_setting_tv};
        this.O = new int[]{R.id.truck_map_switch_text, R.id.truck_road_condition_bar_text, R.id.truck_nav_guide_angle_tv, R.id.truck_nav_day_night_mode_tv, R.id.truck_nav_overview_tv, R.id.truck_nav_float_mode_tv};
        this.P = new b();
        this.H = activity;
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = new com.baidu.navisdk.ui.routeguide.truck.setting.b(activity);
        this.G = bVar;
        bVar.a((com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b) this);
    }

    private boolean B(boolean z) {
        boolean z2;
        View view = this.k;
        if (view != null) {
            int[] iArr = this.L;
            if (iArr.length > 0 && view.findViewById(iArr[0]) != null) {
                int color = ((ColorDrawable) this.k.findViewById(this.L[0]).getBackground()).getColor();
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

    private void C0() {
        if (!com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            this.k.findViewById(R.id.truck_setting_edit_plate).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a()) {
            this.k.findViewById(R.id.truck_star_voice_layout).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_CAR_LOGO_SELECT.a()) {
            this.z.setVisibility(8);
            this.k.findViewById(R.id.truck_menu_h_split_nav_1).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a()) {
            this.k.findViewById(R.id.truck_float_setting_layout).setVisibility(8);
            this.k.findViewById(R.id.truck_menu_h_split_nav_6).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            this.p.setVisibility(8);
            this.k.findViewById(R.id.truck_menu_h_split_nav_4).setVisibility(8);
        }
    }

    private void D0() {
        int i = 0;
        int i2 = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.O;
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
            int[] iArr2 = this.N;
            if (i >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_f));
            }
            i++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.B;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_bg));
            this.B.setMiddleTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_middle_text));
            this.B.setLeftIconAlpha(1.0f);
            this.B.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_day));
            this.B.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_titlebar_ic_back_new));
        }
    }

    private void E0() {
        int i = 0;
        while (true) {
            View view = this.k;
            if (view == null) {
                break;
            }
            int[] iArr = this.O;
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
            int[] iArr2 = this.N;
            if (i2 >= iArr2.length) {
                break;
            }
            TextView textView2 = (TextView) view2.findViewById(iArr2[i2]);
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_b, false));
            }
            i2++;
        }
        BNCommonTitleBar bNCommonTitleBar = this.B;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_d, false));
            this.B.setMiddleTextColor(Color.parseColor("#ffffff"));
            this.B.setLeftIconAlpha(0.3f);
            this.B.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_divide_line_color_night));
            this.B.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_titlebar_ic_back_normal, false));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void A0() {
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = this.G;
        if (bVar != null) {
            l(bVar.d());
        }
    }

    public boolean B0() {
        if (this.J != com.baidu.navisdk.module.trucknavi.logic.plate.c.g().d()) {
            return true;
        }
        return false;
    }

    public void c0() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && (aVar = this.c) != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void d(boolean z) {
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void e(String str) {
        BNSettingExplainSelectItem bNSettingExplainSelectItem = this.y;
        if (bNSettingExplainSelectItem != null) {
            bNSettingExplainSelectItem.a(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        x.b().a(this.F, this.B);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void g(int i) {
        if (i == 0) {
            this.x.a(0);
        } else if (i == 1) {
            this.x.a(1);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void i(boolean z) {
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void j(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.p;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void k(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.A;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void l(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.o;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void m(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem.c
    public boolean onChecked(int i, boolean z) {
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = this.G;
        if (bVar == null) {
            return false;
        }
        if (i == R.id.truck_power_saver_layout) {
            if (z && !l.c(this.H)) {
                com.baidu.navisdk.util.common.c.c(this.H);
                return false;
            }
            this.G.d(z);
            return true;
        }
        if (i == R.id.truck_calling_play_layout) {
            bVar.e(z);
            return true;
        }
        if (i == R.id.truck_scale_layout) {
            bVar.b(z);
            return true;
        }
        if (i == R.id.truck_show_enlarged_item) {
            bVar.c(z);
            return true;
        }
        if (i == R.id.truck_nav_plate_limit_item) {
            if (bVar != null) {
                bVar.f(z);
                return true;
            }
            return true;
        }
        if (i == R.id.truck_nav_weight_limit_item && bVar != null) {
            bVar.h(z);
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.G == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.truck_star_voice_layout) {
            this.G.h();
            return;
        }
        if (id == R.id.truck_nav_logo_item) {
            this.G.f();
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
        if (id == R.id.truck_rr_navi_passport_item) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckNaviSettingPage", "点击通行证管理！");
            }
            if (TextUtils.isEmpty(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b())) {
                TipTool.onCreateToastDialog(this.k.getContext(), "请添加车辆！");
                return;
            } else {
                com.baidu.navisdk.framework.b.a(3, com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b(), true);
                return;
            }
        }
        if (id == R.id.truck_nav_float_setting_cb) {
            boolean isSelected = view.isSelected();
            boolean z = !isSelected;
            if (!isSelected && !com.baidu.navisdk.util.common.c.a(this.H)) {
                return;
            }
            this.G.a(z);
            view.setSelected(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = this.G;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void p(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.w;
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
        return R.layout.bnav_layout_truck_navi_more_setting;
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void r(boolean z) {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.bnav_layout_truck_navi_more_setting;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "TruckNaviSettingPage";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
        this.o.setOnCheckedListener(this);
        this.q.setOnClickListener(this);
        this.p.setOnCheckedListener(this);
        this.A.setOnCheckedListener(this);
        this.n.setPassportItemClickListener(this);
        this.n.setLimitCheckedListener(this);
        this.n.setWeightLimitCheckedListener(this);
        this.v.setOnCheckedListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        BNCommonTitleBar bNCommonTitleBar = this.B;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.findViewById(R.id.left_imageview).setOnClickListener(this);
            this.B.setOnClickListener(this);
        }
        this.x.setOnCheckedChangeListener(new c());
        this.w.setOnCheckedChangeListener(new d());
        this.s.setOnCheckedChangeListener(new e());
        this.t.setOnCheckedChangeListener(new f());
        this.u.setOnCheckedChangeListener(new g());
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void v(boolean z) {
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.v;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.setChecked(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void w(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        this.n = (TruckVehicleInfoView) this.k.findViewById(R.id.truck_setting_edit_plate);
        this.o = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.truck_calling_play_layout);
        this.q = (ImageView) this.k.findViewById(R.id.truck_nav_float_setting_cb);
        this.r = (TextView) this.k.findViewById(R.id.truck_nav_float_tips);
        this.p = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.truck_power_saver_layout);
        this.s = (BNSettingTextRadioGroup) this.k.findViewById(R.id.truck_nav_guide_angle_radio_group);
        this.t = (BNSettingTextRadioGroup) this.k.findViewById(R.id.truck_nav_day_night_mode_radio_group);
        this.u = (RadioGroup) this.k.findViewById(R.id.truck_view_overview_selector_rg);
        this.v = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.truck_scale_layout);
        this.w = (BNSettingTextRadioGroup) this.k.findViewById(R.id.truck_nav_voice_play_mode_radio_group);
        this.x = (BNSettingTextRadioGroup) this.k.findViewById(R.id.truck_nav_float_mode_radio_group);
        if (!BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            this.x.setVisibility(8);
        }
        this.y = (BNSettingExplainSelectItem) this.k.findViewById(R.id.truck_star_voice_layout);
        this.z = (BNSettingExplainImageItem) this.k.findViewById(R.id.truck_nav_logo_item);
        this.A = (BNSettingExplainSwitchItem) this.k.findViewById(R.id.truck_show_enlarged_item);
        View view = this.k;
        int i = R.id.truck_navi_setting_top_empty_view;
        this.C = view.findViewById(i);
        this.D = (RadioButton) this.k.findViewById(R.id.truck_overview_thumbnail_rb);
        this.E = (RadioButton) this.k.findViewById(R.id.truck_overview_road_condition_rb);
        BNCommonTitleBar bNCommonTitleBar = (BNCommonTitleBar) this.k.findViewById(R.id.truck_title_bar);
        this.B = bNCommonTitleBar;
        View findViewById = bNCommonTitleBar.findViewById(R.id.title_bar_divide_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.F = (ScrollView) this.k.findViewById(R.id.truck_navi_setting_scroll);
        int d0 = x.b().d0();
        a(d0, this.D);
        a(d0, this.E);
        this.k.findViewById(i).setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        if (this.F.getViewTreeObserver().isAlive()) {
            this.F.getViewTreeObserver().addOnScrollChangedListener(this.P);
        }
        C0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public boolean y0() {
        TruckVehicleInfoView truckVehicleInfoView;
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = this.G;
        if ((bVar != null && !bVar.g()) || (truckVehicleInfoView = this.n) == null) {
            return false;
        }
        return !TextUtils.equals(this.I, truckVehicleInfoView.getCurrentPlateNum());
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
        this.r.setText(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        f0();
        com.baidu.navisdk.framework.message.a.a().a(this.K, k.class, new Class[0]);
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar = this.G;
        if (bVar != null) {
            bVar.c();
        }
        com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().e(com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().f());
        this.I = com.baidu.navisdk.module.trucknavi.c.a();
        this.J = com.baidu.navisdk.module.trucknavi.logic.plate.c.g().d();
        s.T().o();
        s.T().p();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h1();
        TruckVehicleInfoView truckVehicleInfoView = this.n;
        if (truckVehicleInfoView != null) {
            truckVehicleInfoView.setPlateLimitChecked(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().e());
            this.n.setPlateWeightLimitChecked(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().f());
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().a();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.framework.message.a.a().a(this.K);
        if (a()) {
            x.b().b5();
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        ScrollView scrollView = this.F;
        if (scrollView == null || !scrollView.getViewTreeObserver().isAlive()) {
            return;
        }
        this.F.getViewTreeObserver().removeOnScrollChangedListener(this.P);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void m(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.t;
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

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        if (B(z)) {
            return;
        }
        super.a(z);
        this.C.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        View view = this.k;
        if (view != null) {
            view.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_c));
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            View view2 = this.k;
            if (view2 == null) {
                break;
            }
            int[] iArr = this.L;
            if (i2 >= iArr.length) {
                break;
            }
            View findViewById = view2.findViewById(iArr[i2]);
            if (findViewById != null) {
                findViewById.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_b));
            }
            i2++;
        }
        while (true) {
            View view3 = this.k;
            if (view3 == null) {
                break;
            }
            int[] iArr2 = this.M;
            if (i >= iArr2.length) {
                break;
            }
            View findViewById2 = view3.findViewById(iArr2[i]);
            if (findViewById2 != null) {
                findViewById2.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_setting_page_card_bg));
            }
            i++;
        }
        if (z) {
            D0();
        } else {
            E0();
        }
        RadioButton radioButton = this.D;
        if (radioButton != null && this.E != null) {
            radioButton.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_selector));
            this.E.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_selector));
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_f, z));
        }
        TruckVehicleInfoView truckVehicleInfoView = this.n;
        if (truckVehicleInfoView != null) {
            truckVehicleInfoView.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.t;
        if (bNSettingTextRadioGroup != null) {
            bNSettingTextRadioGroup.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup2 = this.s;
        if (bNSettingTextRadioGroup2 != null) {
            bNSettingTextRadioGroup2.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup3 = this.x;
        if (bNSettingTextRadioGroup3 != null) {
            bNSettingTextRadioGroup3.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.p;
        if (bNSettingExplainSwitchItem != null) {
            bNSettingExplainSwitchItem.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem2 = this.o;
        if (bNSettingExplainSwitchItem2 != null) {
            bNSettingExplainSwitchItem2.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem3 = this.A;
        if (bNSettingExplainSwitchItem3 != null) {
            bNSettingExplainSwitchItem3.a(z);
        }
        BNSettingExplainImageItem bNSettingExplainImageItem = this.z;
        if (bNSettingExplainImageItem != null) {
            bNSettingExplainImageItem.a(z);
        }
        BNSettingExplainSelectItem bNSettingExplainSelectItem = this.y;
        if (bNSettingExplainSelectItem != null) {
            bNSettingExplainSelectItem.a(z);
        }
        BNSettingTextRadioGroup bNSettingTextRadioGroup4 = this.w;
        if (bNSettingTextRadioGroup4 != null) {
            bNSettingTextRadioGroup4.a(z);
        }
        BNSettingExplainSwitchItem bNSettingExplainSwitchItem4 = this.v;
        if (bNSettingExplainSwitchItem4 != null) {
            bNSettingExplainSwitchItem4.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void k(int i) {
        RadioGroup radioGroup = this.u;
        if (radioGroup != null) {
            if (i == 0) {
                radioGroup.check(R.id.truck_overview_thumbnail_rb);
            } else if (i == 1) {
                radioGroup.check(R.id.truck_overview_road_condition_rb);
            }
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.b
    public void l(int i) {
        BNSettingTextRadioGroup bNSettingTextRadioGroup = this.s;
        if (bNSettingTextRadioGroup != null) {
            if (i == 1 || i == 3) {
                bNSettingTextRadioGroup.a(0);
            } else if (i == 2) {
                bNSettingTextRadioGroup.a(1);
            }
        }
    }

    public void c(int i, int i2) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.a(6, i, i2, null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.g
    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar;
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar2;
        com.baidu.navisdk.ui.routeguide.truck.setting.b bVar3;
        if (i == 3001) {
            if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION") || (bVar3 = this.G) == null) {
                return;
            }
            bVar3.a(true);
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setSelected(true);
                return;
            }
            return;
        }
        if (i == 4101) {
            if (!l.c(com.baidu.navisdk.framework.a.c().a()) || (bVar2 = this.G) == null) {
                return;
            }
            bVar2.d(true);
            BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.p;
            if (bNSettingExplainSwitchItem != null) {
                bNSettingExplainSwitchItem.setChecked(true);
                return;
            }
            return;
        }
        if (i == 3006 && BNSettingManager.hasPipPermission() && (bVar = this.G) != null) {
            bVar.a(true);
            ImageView imageView2 = this.q;
            if (imageView2 != null) {
                imageView2.setSelected(true);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        a(i, this.D);
        a(i, this.E);
        f0();
    }

    private void a(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (i == 1) {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_77dp);
            if (view == this.D) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_17dp);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_selector));
            }
        } else {
            marginLayoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_94dp);
            if (view == this.D) {
                marginLayoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_44dp);
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_map_switch_land_selector));
            } else {
                view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_moresetting_road_condition_bar_land_selector));
            }
        }
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b
    public void a(com.baidu.navisdk.module.trucknavi.logic.plate.d dVar, boolean z) {
        TruckVehicleInfoView truckVehicleInfoView = this.n;
        if (truckVehicleInfoView != null) {
            truckVehicleInfoView.a(dVar, true);
        }
    }
}
