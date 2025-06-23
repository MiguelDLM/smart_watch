package com.baidu.navisdk.module.plate.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.module.plate.controller.a;
import com.baidu.navisdk.module.plate.layout.CarEnergyLayout;
import com.baidu.navisdk.module.plate.layout.CarEtcLayout;
import com.baidu.navisdk.module.plate.layout.CarPlateLayout;
import com.baidu.navisdk.module.plate.layout.CarTypeLayout;
import com.baidu.navisdk.module.plate.layout.DisplacementLayout;
import com.baidu.navisdk.module.plate.layout.TruckInfoLayout;
import com.baidu.navisdk.module.plate.layout.TruckTypeLayout;
import com.baidu.navisdk.module.plate.view.PlateAttributionView;
import com.baidu.navisdk.module.routeresult.model.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;

/* loaded from: classes7.dex */
public class a<T extends com.baidu.navisdk.module.routeresult.model.a> extends com.baidu.navisdk.module.routeresult.ui.a<T> implements a.b {
    private CarEtcLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private CarTypeLayout D;
    private CarPlateLayout E;
    private CarEnergyLayout F;
    private DisplacementLayout G;
    private TruckTypeLayout H;
    private TruckInfoLayout I;
    private ScrollView J;
    private com.baidu.navisdk.module.trucknavi.logic.plate.b K;
    private com.baidu.navisdk.module.plate.c L;
    private CheckBox M;
    private View p;
    private TextView q;
    private PlateAttributionView r;
    private EditText s;
    private String t;
    private String u;
    private boolean v;
    private int w;
    private final Activity x;
    private final int y;
    private int z;

    /* renamed from: com.baidu.navisdk.module.plate.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class AnimationAnimationListenerC0278a implements Animation.AnimationListener {
        public AnimationAnimationListenerC0278a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateInputView", "end nearby search panel view hide anim!");
            }
            a.this.v = false;
            ((com.baidu.navisdk.module.routeresult.ui.a) a.this).d.setVisibility(8);
            ((com.baidu.navisdk.module.routeresult.ui.a) a.this).d.clearAnimation();
            a.this.a("onHideAnimationEnd");
            a.this.c(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateInputView", "start nearby search panel view hide anim!");
            }
            a.this.v = true;
            a.this.a("开始执行隐藏面板动画");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.q.isSelected() && a.this.p()) {
                a.this.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements CarPlateLayout.e {
        public d() {
        }

        @Override // com.baidu.navisdk.module.plate.layout.CarPlateLayout.e
        public void a(String str) {
            a.this.u();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.c(true);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (a.this.M != null) {
                if (z) {
                    a.this.M.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_blue_color));
                } else {
                    a.this.M.setTextColor(Color.parseColor("#222222"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements com.baidu.navisdk.module.plate.c {
        public g(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class h implements PlateAttributionView.b {
        public h() {
        }

        @Override // com.baidu.navisdk.module.plate.view.PlateAttributionView.b
        public void a(CharSequence charSequence) {
            if (TextUtils.isEmpty(charSequence)) {
                a.this.t = "京";
            } else {
                a.this.t = charSequence.toString();
            }
            a.this.E.a(a.this.t);
            a.this.b("点击选择了归属地");
            a.this.s.requestFocus();
            a.this.v();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements com.baidu.navisdk.framework.interfaces.account.a {
        public i(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Animation.AnimationListener {
        public j() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateInputView", "end nearby search panel view show anim!");
            }
            a.this.v = false;
            a.this.s.requestFocus();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateInputView", "start nearby search panel view show anim!");
            }
            a.this.v = true;
        }
    }

    public a(Activity activity, T t, int i2) {
        super(activity.getApplicationContext(), t);
        this.t = "京";
        this.x = activity;
        this.y = i2;
    }

    private void A() {
        if (this.s != null && this.G.getDisplacementVal() > 10000) {
            TipTool.onCreateToastDialog(this.f7502a, "超规排量，请重新填写");
            return;
        }
        if (this.s != null && !com.baidu.navisdk.module.plate.checker.a.a(t())) {
            TipTool.onCreateToastDialog(this.f7502a, "至少有1位数字");
            return;
        }
        if (c(com.baidu.navisdk.module.motorbike.logic.plate.b.d().b()) && this.s != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("vehicle_type", 2);
            bundle.putString("plate", s());
            bundle.putInt("isEtc", this.A.getCurrentEtcType());
            bundle.putString("displacement", this.G.getDisplacementVal() + "");
            if (com.baidu.navisdk.util.common.g.CAR_PLATE.d()) {
                TipTool.onCreateToastDialog(this.f7502a, "设置新车牌bundle " + bundle);
            }
            com.baidu.navisdk.framework.b.a(bundle, this.L);
        }
    }

    private void B() {
        int r;
        if (this.s != null) {
            if (!TextUtils.isEmpty(s()) && s().length() == 8 && (r = r()) != 2 && r != 1) {
                TipTool.onCreateToastDialog(this.f7502a, "新能源车，请选择动力类型");
                return;
            }
            if (c(com.baidu.navisdk.module.routeresult.logic.plate.a.b().a().getPlate())) {
                Bundle bundle = new Bundle();
                bundle.putInt("car_type", r());
                bundle.putInt("vehicle_type", 1);
                bundle.putInt("isEtc", this.A.getCurrentEtcType());
                bundle.putString("ext_tag", "1");
                bundle.putString("plate", s());
                b(bundle);
                if (com.baidu.navisdk.util.common.g.CAR_PLATE.d()) {
                    TipTool.onCreateToastDialog(this.f7502a, "设置新车牌bundle " + bundle);
                }
                com.baidu.navisdk.framework.b.a(bundle, this.L);
            }
        }
    }

    private void C() {
        if (c(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b()) && this.s != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("vehicle_type", 3);
            bundle.putString("plate", s());
            bundle.putInt("isEtc", this.A.getCurrentEtcType());
            if (this.K == null) {
                this.K = new com.baidu.navisdk.module.trucknavi.logic.plate.b();
            }
            this.K.a(s());
            this.K.d((int) (this.I.getTruckLength() * 1000.0f));
            this.K.h((int) (this.I.getTruckWidth() * 1000.0f));
            this.K.c((int) (this.I.getTruckHeight() * 1000.0f));
            this.K.g((int) (this.I.getTruckTotalWeight() * 1000.0f));
            this.K.e((int) (this.I.getTruckApprovedLoad() * 1000.0f));
            this.K.a(this.I.getTruckAxleNum());
            this.K.f(this.H.getTruckType());
            this.K.b(this.I.getTruckEmission());
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
            if (gVar.d()) {
                gVar.e("BasePlateInputView", "completeTruckBtn: mTruckPlateInfo " + this.K.toString());
            }
            bundle.putString("truck_plate_info", this.K.a());
            if (gVar.d()) {
                TipTool.onCreateToastDialog(this.f7502a, "设置新车牌bundle " + bundle);
            }
            com.baidu.navisdk.framework.b.a(bundle, this.L);
        }
    }

    private String D() {
        String t = t();
        if (!TextUtils.isEmpty(t) && t.length() >= 1) {
            return String.valueOf(t.charAt(0));
        }
        return "";
    }

    private void E() {
        int i2;
        if (this.M == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BasePlateInputView", "initAreaPlateOptionState == null");
                return;
            }
            return;
        }
        if (a(this.t, D(), this.z)) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        a(i2, true);
    }

    private void F() {
        PlateAttributionView plateAttributionView = (PlateAttributionView) c(R.id.attribution_layout);
        this.r = plateAttributionView;
        if (plateAttributionView != null) {
            plateAttributionView.setOnAttributionSelectListener(new h());
        }
    }

    private void G() {
        this.C = (RelativeLayout) c(R.id.plate_input_main_panel);
        CarPlateLayout carPlateLayout = (CarPlateLayout) c(R.id.nsdk_car_plate_layout);
        this.E = carPlateLayout;
        if (carPlateLayout != null) {
            this.s = carPlateLayout.getPlateEditView();
        }
        this.D = (CarTypeLayout) c(R.id.nsdk_car_type);
        this.A = (CarEtcLayout) c(R.id.nsdk_car_etc_layout);
        this.F = (CarEnergyLayout) c(R.id.nsdk_car_energy);
        this.G = (DisplacementLayout) c(R.id.nsdk_car_displacement);
        this.H = (TruckTypeLayout) c(R.id.nsdk_truck_type);
        this.I = (TruckInfoLayout) c(R.id.nsdk_truck_info);
        this.J = (ScrollView) c(R.id.scroll_plate_view);
        this.M = (CheckBox) c(R.id.bn_area_plate_select_item);
    }

    private void H() {
        this.L = new g(this);
    }

    private void I() {
        G();
        this.f.setOnClickListener(new b(this));
        TextView textView = (TextView) c(R.id.complete_btn);
        this.q = textView;
        if (textView != null) {
            textView.setOnClickListener(new c());
        }
        CarPlateLayout carPlateLayout = this.E;
        if (carPlateLayout != null) {
            carPlateLayout.setPlateCharChangListener(new d());
        }
        this.p = c(R.id.plate_divider);
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.plate_btn_close_layout);
        this.B = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new e());
        }
        if (this.M != null) {
            Drawable drawable = JarUtils.getResources().getDrawable(R.drawable.nsdk_rg_circle_checkbox_selector_big);
            drawable.setBounds(0, 0, 40, 40);
            this.M.setCompoundDrawables(drawable, null, null, null);
            this.M.setOnCheckedChangeListener(new f());
        }
        a(this.y);
        this.D.a(this.z);
    }

    private void J() {
        float dimension;
        ScrollView scrollView = this.J;
        if (scrollView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (this.z == 2) {
            dimension = this.f7502a.getResources().getDimension(R.dimen.navi_dimens_215dp);
        } else {
            dimension = this.f7502a.getResources().getDimension(R.dimen.navi_dimens_228dp);
        }
        layoutParams.height = (int) dimension;
        layoutParams.width = -1;
        this.J.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "completeBtnClick: mCurrentCarType " + this.z);
        }
        if (this.z == 0) {
            this.z = this.y;
        }
        if (!z.b(this.f7502a)) {
            TipTool.onCreateToastDialog(this.x.getApplicationContext(), "网络连接失败，请重试");
            return;
        }
        int i2 = this.z;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        B();
                        return;
                    }
                    return;
                } else if (!this.I.b()) {
                    TipTool.onCreateToastDialog(this.f7502a, "总重量需大于核定载重");
                    return;
                } else {
                    C();
                    return;
                }
            }
            A();
            return;
        }
        z();
    }

    private void z() {
        int r;
        if (this.s != null) {
            if (!TextUtils.isEmpty(s()) && s().length() == 8 && (r = r()) != 2 && r != 1) {
                TipTool.onCreateToastDialog(this.f7502a, "新能源车，请选择动力类型");
                return;
            }
            if (c(com.baidu.navisdk.module.routeresult.logic.plate.a.b().a().getPlate())) {
                Bundle bundle = new Bundle();
                bundle.putString("ext_tag", "0");
                bundle.putInt("car_type", r());
                bundle.putInt("vehicle_type", 1);
                bundle.putInt("isEtc", this.A.getCurrentEtcType());
                bundle.putString("plate", s());
                b(bundle);
                if (com.baidu.navisdk.util.common.g.CAR_PLATE.d()) {
                    TipTool.onCreateToastDialog(this.f7502a, "设置新车牌bundle " + bundle);
                }
                com.baidu.navisdk.framework.b.a(bundle, this.L);
            }
        }
    }

    public void a(String... strArr) {
        throw null;
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void b(int i2) {
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void i() {
        super.i();
        com.baidu.navisdk.module.asr.a.b().a(true);
        this.L = null;
        if (q() != null && q().getWindow() != null) {
            q().getWindow().setSoftInputMode(this.w);
            com.baidu.navisdk.module.plate.controller.a.e().c();
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void k() {
        super.k();
        this.w = q().getWindow().getAttributes().softInputMode;
        com.baidu.navisdk.module.asr.a.b().a(false);
        H();
        if (q() != null && q().getWindow() != null) {
            q().getWindow().setSoftInputMode(16);
            com.baidu.navisdk.module.plate.controller.a.e().a(this);
            ScrollView scrollView = this.J;
            if (scrollView != null) {
                scrollView.fullScroll(33);
                J();
            }
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void n() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
            a2.setFillAfter(true);
            a2.setAnimationListener(new AnimationAnimationListenerC0278a());
            ViewGroup viewGroup2 = this.d;
            if (viewGroup2 != null) {
                viewGroup2.startAnimation(a2);
            }
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void o() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
            this.d.setVisibility(0);
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L);
            a2.setAnimationListener(new j());
            this.d.startAnimation(a2);
        }
    }

    public boolean p() {
        throw null;
    }

    public Activity q() {
        throw null;
    }

    public int r() {
        return this.F.getEnergyType();
    }

    public String s() {
        return this.E.getFullPlate();
    }

    public String t() {
        throw null;
    }

    public void u() {
        int i2;
        if (this.M == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BasePlateInputView", "mAreaPlateItem == null");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar2.d()) {
            gVar2.e("BasePlateInputView", "handleCityCodeChange: ");
        }
        String D = D();
        if (!TextUtils.equals(D, this.u)) {
            this.u = D;
            if (a(this.t, D, this.z)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            a(i2, true);
        }
    }

    public void v() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "handleProvinceCodeChange: ");
        }
        E();
    }

    public void w() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "handleVehicleTypeChange: ");
        }
        E();
    }

    public void x() {
    }

    private boolean c(String str) {
        if (!TextUtils.isEmpty(com.baidu.navisdk.framework.b.e()) || TextUtils.isEmpty(str)) {
            return true;
        }
        com.baidu.navisdk.framework.b.a((com.baidu.navisdk.framework.interfaces.account.a) new i(this));
        return false;
    }

    public void b(String str) {
        throw null;
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void d() {
        this.E.a();
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "gotoTruckAxleSettingPage: ");
        }
        a("货车车轴页面加载隐藏");
        this.d.setVisibility(8);
        x();
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void a(Bundle bundle) {
        super.a(bundle);
        d(R.layout.bnav_plate_input_panel_layout);
        I();
        F();
        E();
    }

    public void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        CheckBox checkBox = this.M;
        String a2 = com.baidu.navisdk.module.plate.d.a(null, 0, (checkBox != null && checkBox.getVisibility() == 0 && this.M.isChecked()) ? '1' : '0');
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "addAreaPlateParam: " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        bundle.putString("multiFlag", a2);
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void a(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "updateCarTypeLayout: carType " + i2);
        }
        this.z = i2;
        this.D.a(i2);
        this.E.setCurrentPlateChecker(this.z);
        this.J.fullScroll(33);
        this.E.c();
        this.A.a();
        this.q.setText("完成");
        this.q.setSelected(false);
        J();
        if (i2 == 1) {
            this.F.a();
            this.F.setVisibility(0);
            this.p.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
        } else if (i2 == 2) {
            this.F.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.a();
            this.G.setVisibility(0);
            this.p.setVisibility(8);
        } else if (i2 == 3) {
            this.F.setVisibility(8);
            this.H.a();
            this.H.setVisibility(0);
            this.I.a();
            this.I.setVisibility(0);
            this.p.setVisibility(0);
            this.G.setVisibility(8);
        } else if (i2 == 4) {
            this.F.a();
            this.F.setVisibility(0);
            this.p.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
        }
        w();
    }

    private boolean a(String str, String str2, int i2) {
        String[] strArr;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "isNeedShowAreaPlateOption: " + str + ", " + str2 + ", " + i2);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f.c cVar = com.baidu.navisdk.module.cloudconfig.f.c().C;
        if (cVar == null) {
            if (gVar.d()) {
                gVar.e("BasePlateInputView", "isNeedShowAreaPlateOption: areaPlateConfig == null");
            }
            return false;
        }
        if (i2 == 2) {
            strArr = cVar.b;
        } else if (i2 != 3 && i2 != 4) {
            strArr = cVar.f7106a;
        } else {
            strArr = cVar.c;
        }
        if (strArr != null && strArr.length > 0) {
            String str3 = str + str2;
            for (String str4 : strArr) {
                if (!TextUtils.isEmpty(str4) && (str4.equalsIgnoreCase(str) || str4.equalsIgnoreCase(str3))) {
                    return true;
                }
            }
            return false;
        }
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "isNeedShowAreaPlateOption: cloudConfigAreaPlate is empty");
        }
        return false;
    }

    private void a(int i2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "setAreaPlateOptionVisibility: " + i2 + "," + z);
        }
        if (this.M == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("BasePlateInputView", "setAreaPlateOptionVisibility1: " + this.M.getVisibility());
        }
        if (z) {
            this.M.setChecked(false);
        }
        if (this.M.getVisibility() == i2) {
            return;
        }
        this.M.setChecked(false);
        this.M.setVisibility(i2);
    }
}
