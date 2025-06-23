package com.baidu.navisdk.module.plate.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.plate.base.a;
import com.baidu.navisdk.module.plate.layout.NewEnergyPlateLayout;
import com.baidu.navisdk.module.plate.view.PlateAttributionView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.z;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.module.plate.view.a<com.baidu.navisdk.module.plate.view.d> implements View.OnFocusChangeListener, View.OnClickListener, NewEnergyPlateLayout.d {
    private PlateAttributionView N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private int U;
    private int V;
    private int W;
    private int X;
    private String Y;
    private String Z;
    public ArrayList<Integer> a0;
    private String b0;
    private NewEnergyPlateLayout c0;
    private EnergyMileageLayout d0;
    private EnergyTypeInfoLayout e0;
    private RelativeLayout f0;
    private TextView g0;
    private TextView h0;
    private TextView i0;
    private EditText j0;
    private View k0;
    private View l0;
    private TextView m0;
    private boolean n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f7423o0;
    private boolean p0;
    private final Activity q0;
    private com.baidu.navisdk.module.routepreference.g r0;
    private final int s0;
    private final Context t0;
    private com.baidu.navisdk.module.plate.c u0;
    private com.baidu.navisdk.module.plate.c v0;
    private com.baidu.navisdk.module.plate.c w0;

    /* renamed from: x0, reason: collision with root package name */
    private com.baidu.navisdk.module.plate.c f7424x0;
    private com.baidu.navisdk.module.plate.b y0;
    private com.baidu.navisdk.module.plate.a z0;

    /* renamed from: com.baidu.navisdk.module.plate.layout.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0277a implements View.OnClickListener {
        public ViewOnClickListenerC0277a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b("点击面板非交互区域");
            a.this.a("点击面板非交互区域");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PlateAttributionView.b {
        public c() {
        }

        @Override // com.baidu.navisdk.module.plate.view.PlateAttributionView.b
        public void a(CharSequence charSequence) {
            if (TextUtils.isEmpty(charSequence)) {
                a.this.O = "京";
            } else {
                a.this.O = charSequence.toString();
            }
            a.this.c0.a(a.this.O);
            a.this.b("点击选择了归属地");
            a.this.j0.requestFocus();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.z();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7429a;
        final /* synthetic */ View b;

        public e(boolean z, View view) {
            this.f7429a = z;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7429a) {
                a.this.b("弹出软键盘");
                a.this.a(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements com.baidu.navisdk.module.plate.c {
        public f(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class g implements com.baidu.navisdk.module.plate.c {
        public g(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class h implements com.baidu.navisdk.module.plate.c {
        public h(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class i implements com.baidu.navisdk.module.plate.c {
        public i(a aVar) {
        }
    }

    public a(Activity activity, com.baidu.navisdk.module.plate.view.d dVar) {
        super(activity, dVar, 1);
        this.V = -1;
        this.X = -1;
        this.Y = "0.2";
        this.Z = "0.9";
        this.a0 = new ArrayList<>();
        this.b0 = null;
        this.t0 = activity.getApplicationContext();
        this.q0 = activity;
        this.s0 = dVar.i;
    }

    private void B() {
        this.U = 0;
        this.V = -1;
        this.T = "";
        this.S = "";
        this.R = "";
        this.Q = "";
        this.n0 = false;
        this.f7423o0 = false;
    }

    private String C() {
        return com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(1).getPlate(1);
    }

    private void D() {
        PlateAttributionView plateAttributionView = (PlateAttributionView) c(R.id.energy_attribution_layout);
        this.N = plateAttributionView;
        if (plateAttributionView != null) {
            plateAttributionView.setOnAttributionSelectListener(new c());
        }
    }

    private void E() {
        NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
        if (newEnergyPlateLayout != null) {
            newEnergyPlateLayout.a(this);
        }
        EnergyTypeInfoLayout energyTypeInfoLayout = this.e0;
        if (energyTypeInfoLayout != null) {
            energyTypeInfoLayout.setCarTypeInfoListener(this);
        }
        this.u0 = new f(this);
        this.v0 = new g(this);
        this.w0 = new h(this);
        this.f7424x0 = new i(this);
    }

    private void F() {
        this.g0 = (TextView) c(R.id.plate_input_main_panel_title);
        View c2 = c(R.id.new_energy_plate_input_container);
        this.l0 = c2;
        if (c2 != null) {
            c2.setOnClickListener(new ViewOnClickListenerC0277a());
        }
        NewEnergyPlateLayout newEnergyPlateLayout = (NewEnergyPlateLayout) c(R.id.nsdk_car_plate_layout);
        this.c0 = newEnergyPlateLayout;
        if (newEnergyPlateLayout != null) {
            newEnergyPlateLayout.setAttributionSelectListener(this);
            this.j0 = this.c0.getPlateEditView();
        }
        this.j0.requestFocus();
        this.c0.setAttributionListener(new b());
        D();
        View c3 = c(R.id.plate_btn_close_layout);
        this.k0 = c3;
        if (c3 != null) {
            c3.setOnClickListener(this);
        }
        TextView textView = (TextView) c(R.id.complete_btn);
        this.m0 = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
            this.m0.setBackground(this.t0.getResources().getDrawable(R.drawable.bnav_plate_new_energy_complete_btn_bg));
        }
        this.e0 = (EnergyTypeInfoLayout) c(R.id.energy_type_info_layout);
        EnergyMileageLayout energyMileageLayout = (EnergyMileageLayout) c(R.id.energy_mileage_layout);
        this.d0 = energyMileageLayout;
        if (energyMileageLayout != null) {
            energyMileageLayout.setAttributionSelectListener(this);
        }
        this.f0 = (RelativeLayout) c(R.id.energy_mileage_delete_layout);
        this.h0 = (TextView) c(R.id.energy_mileage_delete_plate);
        this.i0 = (TextView) c(R.id.energy_mileage_delete_confirm);
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
    }

    public void A() {
        this.y0 = null;
    }

    public void e(int i2) {
        this.f7423o0 = true;
        this.X = i2;
    }

    @Override // com.baidu.navisdk.module.plate.view.a, com.baidu.navisdk.module.routeresult.ui.a
    public void i() {
        super.i();
        this.u0 = null;
        this.v0 = null;
        this.w0 = null;
        this.f7424x0 = null;
        a(new String[0]);
        com.baidu.navisdk.module.plate.b bVar = this.y0;
        if (bVar != null) {
            bVar.c();
            this.y0 = null;
        }
        com.baidu.navisdk.module.plate.a aVar = this.z0;
        if (aVar != null && (this.n0 || this.f7423o0)) {
            int i2 = this.X;
            if (i2 == 2) {
                aVar.a(0, 2, null);
            } else if (i2 == 1) {
                aVar.a(0, 1, null);
            }
            this.n0 = false;
            this.f7423o0 = false;
        }
        if (q() != null && q().getWindow() != null) {
            q().getWindow().setSoftInputMode(this.W);
        }
        com.baidu.navisdk.framework.b.f(true);
        NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
        if (newEnergyPlateLayout != null) {
            newEnergyPlateLayout.e();
        }
    }

    @Override // com.baidu.navisdk.module.plate.view.a, com.baidu.navisdk.module.routeresult.ui.a
    public void k() {
        super.k();
        this.W = q().getWindow().getAttributes().softInputMode;
        com.baidu.navisdk.framework.b.f(false);
        com.baidu.navisdk.framework.b.a();
        E();
        NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
        if (newEnergyPlateLayout != null) {
            newEnergyPlateLayout.d();
        }
        RelativeLayout relativeLayout = this.f0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        EnergyMileageLayout energyMileageLayout = this.d0;
        if (energyMileageLayout != null) {
            energyMileageLayout.setEnergyMileageText("");
        }
        EnergyTypeInfoLayout energyTypeInfoLayout = this.e0;
        if (energyTypeInfoLayout != null) {
            energyTypeInfoLayout.setEnergyInfoText("");
        }
        B();
        C();
        if (q() != null && q().getWindow() != null) {
            q().getWindow().setSoftInputMode(16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.energy_mileage_delete_plate) {
            this.h0.setText("确定要删除这辆车吗？");
            this.h0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.i0.setVisibility(0);
            return;
        }
        if (id == R.id.energy_mileage_delete_confirm) {
            Bundle bundle = new Bundle();
            bundle.putString("plate", this.P);
            bundle.putInt("vehicle_type", 1);
            bundle.putInt("electric_plate_type", 1);
            com.baidu.navisdk.framework.b.b(bundle, this.u0);
            return;
        }
        if (id == R.id.plate_btn_close_layout) {
            c(true);
            return;
        }
        if (id == R.id.energy_type_info_layout) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.9.2", "1", null, null);
            if (this.p0) {
                com.baidu.navisdk.framework.b.a(com.baidu.navisdk.framework.b.a((Bundle) null, 1), 1, this.f7424x0);
                return;
            } else {
                com.baidu.navisdk.framework.b.b(this.f7424x0);
                return;
            }
        }
        if (id != R.id.complete_btn || !this.m0.isSelected()) {
            return;
        }
        if (z.b(this.t0)) {
            if (p()) {
                a.c cVar = new a.c();
                if (this.n0) {
                    a.b bVar = new a.b();
                    bVar.b(String.valueOf(this.Y));
                    bVar.a(String.valueOf(this.Z));
                    cVar.a(this.d0.getEnergyMileage());
                    cVar.a(this.a0);
                    cVar.a(this.b0);
                    cVar.a(bVar);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("vehicle_type", 1);
                    bundle2.putInt("electric_plate_type", 1);
                    bundle2.putString("old_plate", this.P);
                    bundle2.putString("plate", this.c0.getFullPlate());
                    bundle2.putString("newenergy_ext", cVar.e());
                    bundle2.putInt("brandId", this.U);
                    bundle2.putString("brandModel", this.T);
                    bundle2.putString("brandName", this.S);
                    bundle2.putString("brand", this.R);
                    bundle2.putString(x.cD, this.Q);
                    b(bundle2);
                    com.baidu.navisdk.framework.b.d(bundle2, this.v0);
                } else {
                    cVar.a(this.d0.getEnergyMileage());
                    cVar.a(new a.b("0.2", "0.9"));
                    cVar.a(new ArrayList<>());
                    cVar.a((String) null);
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("vehicle_type", 1);
                    bundle3.putInt("car_type", 1);
                    bundle3.putInt("electric_plate_type", 1);
                    bundle3.putString("plate", this.c0.getFullPlate());
                    bundle3.putInt("brandId", this.U);
                    bundle3.putString("brandModel", this.T);
                    bundle3.putString("brandName", this.S);
                    bundle3.putString("brand", this.R);
                    bundle3.putString(x.cD, this.Q);
                    bundle3.putString("newenergy_ext", cVar.e());
                    b(bundle3);
                    com.baidu.navisdk.framework.b.a(bundle3, this.w0);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().d("11.9.4", String.valueOf(this.s0));
                return;
            }
            return;
        }
        TipTool.onCreateToastDialog(this.t0, "网络异常，请稍后再试");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        view.post(new e(z, view));
    }

    @Override // com.baidu.navisdk.module.plate.view.a
    public boolean p() {
        if (!com.baidu.navisdk.module.plate.checker.a.a(t())) {
            TipTool.onCreateToastDialog(this.t0, "至少有1位数字");
            return false;
        }
        EnergyMileageLayout energyMileageLayout = this.d0;
        if (energyMileageLayout != null && energyMileageLayout.getEnergyMileage() == 0) {
            TipTool.onCreateToastDialog(this.t0, "不能设置为0");
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.module.plate.view.a
    public Activity q() {
        return this.q0;
    }

    @Override // com.baidu.navisdk.module.plate.view.a
    public String t() {
        NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
        if (newEnergyPlateLayout != null) {
            return newEnergyPlateLayout.getRightHalfPlate();
        }
        return "";
    }

    public boolean y() {
        return ((InputMethodManager) this.t0.getSystemService("input_method")).isActive();
    }

    public void z() {
        a(new String[0]);
        PlateAttributionView plateAttributionView = this.N;
        if (plateAttributionView != null) {
            plateAttributionView.setVisibility(0);
        }
        EditText editText = this.j0;
        if (editText != null) {
            editText.clearFocus();
        }
        EnergyMileageLayout energyMileageLayout = this.d0;
        if (energyMileageLayout != null) {
            energyMileageLayout.clearFocus();
        }
    }

    @Override // com.baidu.navisdk.module.plate.view.a, com.baidu.navisdk.module.plate.controller.a.b
    public void b(String str) {
        PlateAttributionView plateAttributionView = this.N;
        if (plateAttributionView != null) {
            plateAttributionView.setVisibility(8);
        }
    }

    public void c(Bundle bundle) {
        RelativeLayout relativeLayout;
        EnergyMileageLayout energyMileageLayout;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("CarPlateNewEnergyView", "updateViewState: bundle " + bundle);
        }
        if (bundle == null) {
            EnergyMileageLayout energyMileageLayout2 = this.d0;
            if (energyMileageLayout2 != null) {
                energyMileageLayout2.setEnergyMileageText("");
            }
            EnergyTypeInfoLayout energyTypeInfoLayout = this.e0;
            if (energyTypeInfoLayout != null) {
                energyTypeInfoLayout.setEnergyInfoText("");
                return;
            }
            return;
        }
        if (bundle.getParcelable("limit_plate_info") != null) {
            com.baidu.navisdk.module.plate.base.a aVar = (com.baidu.navisdk.module.plate.base.a) bundle.getParcelable("limit_plate_info");
            if (aVar.f() != null) {
                if (aVar.f().b() != null) {
                    this.Y = aVar.f().b().b();
                    this.Z = aVar.f().b().a();
                }
                this.a0 = aVar.f().d();
                this.V = aVar.f().c();
                this.b0 = aVar.f().a();
            }
            this.P = aVar.g();
            this.R = aVar.a();
            this.Q = aVar.e();
            if (aVar.b() != 0) {
                this.U = aVar.b();
            }
            this.T = aVar.c();
            this.S = aVar.d();
            NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
            if (newEnergyPlateLayout != null) {
                newEnergyPlateLayout.b(this.P);
            }
            EnergyTypeInfoLayout energyTypeInfoLayout2 = this.e0;
            if (energyTypeInfoLayout2 != null) {
                energyTypeInfoLayout2.setEnergyInfoText(this.R + this.T + this.S);
            }
            if (this.V != -1 && (energyMileageLayout = this.d0) != null) {
                energyMileageLayout.setEnergyMileageText(this.V + "");
            }
        } else {
            if (bundle.getParcelable("car_plate_info") == null) {
                return;
            }
            com.baidu.navisdk.module.routepreference.g gVar2 = (com.baidu.navisdk.module.routepreference.g) bundle.getParcelable("car_plate_info");
            this.r0 = gVar2;
            this.P = gVar2.getPlate(1);
            com.baidu.navisdk.module.routepreference.g gVar3 = this.r0;
            this.R = gVar3.l;
            this.Q = gVar3.k;
            int i2 = gVar3.i;
            if (i2 != 0) {
                this.U = i2;
            }
            this.T = gVar3.m;
            this.S = gVar3.n;
            this.a0 = gVar3.a().d;
            this.b0 = this.r0.a().e;
            this.V = this.r0.a().f7484a;
            this.Y = String.valueOf(this.r0.a().b / 100.0f);
            this.Z = String.valueOf(this.r0.a().c / 100.0f);
            NewEnergyPlateLayout newEnergyPlateLayout2 = this.c0;
            if (newEnergyPlateLayout2 != null) {
                newEnergyPlateLayout2.b(this.P);
            }
            EnergyTypeInfoLayout energyTypeInfoLayout3 = this.e0;
            if (energyTypeInfoLayout3 != null) {
                energyTypeInfoLayout3.setEnergyInfoText(this.r0.l + this.r0.m + this.r0.n);
            }
            if (this.d0 != null && this.r0.a().f7484a != 0) {
                this.d0.setEnergyMileageText(this.r0.a().f7484a + "");
            }
        }
        if (!TextUtils.isEmpty(this.P)) {
            this.n0 = true;
            this.g0.setText("编辑车辆信息");
            if (!com.baidu.navisdk.framework.b.e0() || (relativeLayout = this.f0) == null) {
                return;
            }
            relativeLayout.setVisibility(0);
            this.i0.setVisibility(8);
            this.h0.setText("删除此车辆");
            this.h0.setCompoundDrawablesWithIntrinsicBounds(this.t0.getResources().getDrawable(R.drawable.nsdk_drawable_mileage_plate_delete), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.n0 = false;
    }

    @Override // com.baidu.navisdk.module.plate.view.a, com.baidu.navisdk.module.routeresult.ui.a
    public void a(Bundle bundle) {
        super.a(bundle);
        d(R.layout.bnav_plate_new_energy_panel_layout);
        F();
    }

    public void e(boolean z) {
        this.p0 = z;
    }

    public void b(com.baidu.navisdk.module.plate.e eVar) {
        NewEnergyPlateLayout newEnergyPlateLayout = this.c0;
        if (newEnergyPlateLayout != null) {
            newEnergyPlateLayout.setTextChangedListener(eVar);
        }
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void a(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.t0.getSystemService("input_method");
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        if (b2 != null) {
            b2.getWindow().setSoftInputMode(16);
        }
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b
    public void a() {
        PlateAttributionView plateAttributionView = this.N;
        if (plateAttributionView == null || plateAttributionView.isShown()) {
            return;
        }
        this.N.post(new d());
    }

    @Override // com.baidu.navisdk.module.plate.view.a
    public void a(String... strArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarPlateNewEnergyView", "hideSoftInputPanel,actionSource:" + strArr);
        }
        if (y() && this.j0 != null) {
            ((InputMethodManager) this.t0.getSystemService("input_method")).hideSoftInputFromWindow(this.j0.getWindowToken(), 2);
        }
    }

    public void a(com.baidu.navisdk.module.plate.b bVar) {
        this.y0 = bVar;
    }

    public void a(com.baidu.navisdk.module.plate.a aVar) {
        this.z0 = aVar;
    }

    @Override // com.baidu.navisdk.module.plate.controller.a.b, com.baidu.navisdk.module.plate.layout.NewEnergyPlateLayout.d
    public void a(boolean z) {
        TextView textView = this.m0;
        if (textView != null) {
            textView.setSelected(this.c0.a() && z);
        }
    }

    public void a(com.baidu.navisdk.module.plate.e eVar) {
        EnergyMileageLayout energyMileageLayout = this.d0;
        if (energyMileageLayout != null) {
            energyMileageLayout.setTextChangedListener(eVar);
        }
    }
}
