package com.baidu.navisdk.module.plate.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.plate.adapter.a;
import com.baidu.navisdk.module.plate.view.d;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingSwitchItem;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.utils.a;
import java.util.List;

/* loaded from: classes7.dex */
public class b<T extends com.baidu.navisdk.module.plate.view.d> extends com.baidu.navisdk.module.routeresult.ui.a<T> implements a.d {
    private com.baidu.navisdk.module.plate.adapter.a A;
    protected com.baidu.navisdk.module.plate.a B;
    protected TextView C;
    private boolean D;
    private boolean p;
    protected final int q;
    private int r;
    private int s;
    private RelativeLayout t;
    private View u;
    private RecyclerView v;
    private BNSettingSwitchItem w;
    private List<com.baidu.navisdk.module.plate.base.a> x;
    private f y;
    private com.baidu.navisdk.module.plate.b z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.baidu.navisdk.module.plate.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0279b implements BNSettingSwitchItem.b {
        public C0279b() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingSwitchItem.b
        public boolean onChecked(int i, boolean z) {
            if (!z.b(((com.baidu.navisdk.module.routeresult.ui.a) b.this).f7502a)) {
                LogUtil.e("BasePlateLimitSettingVi", "isNetworkAvailable = false!");
                TipTool.onCreateToastDialog(((com.baidu.navisdk.module.routeresult.ui.a) b.this).f7502a, R.string.nsdk_route_result_vehicle_limit_no_net_toast);
                b.this.w.setChecked(true);
                b.this.e(true);
            } else {
                b.this.w.setChecked(z);
                b.this.e(z);
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.c(true);
            if (b.this.y != null) {
                b.this.y.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateLimitSettingVi", "end nearby search panel view show anim!");
            }
            b.this.p = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateLimitSettingVi", "start nearby search panel view show anim!");
            }
            b.this.p = true;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateLimitSettingVi", "end nearby search panel view hide anim!");
            }
            b.this.p = false;
            ((com.baidu.navisdk.module.routeresult.ui.a) b.this).d.setVisibility(8);
            ((com.baidu.navisdk.module.routeresult.ui.a) b.this).d.clearAnimation();
            b.this.c(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BasePlateLimitSettingVi", "start nearby search panel view hide anim!");
            }
            b.this.p = true;
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();

        void b();
    }

    public b(Context context, T t) {
        super(context, t);
        this.D = false;
        this.q = t.i;
    }

    private void q() {
        View c2 = c(R.id.plate_limit_setting_container);
        this.u = c2;
        if (c2 != null) {
            c2.setOnClickListener(new a(this));
        }
        this.C = (TextView) c(R.id.base_plate_limit_setting_title);
        BNSettingSwitchItem bNSettingSwitchItem = (BNSettingSwitchItem) c(R.id.limit_setting_switch);
        this.w = bNSettingSwitchItem;
        if (bNSettingSwitchItem != null) {
            r();
            this.w.setOnCheckedListener(new C0279b());
        }
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.plate_btn_close_layout);
        this.t = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new c());
        }
        this.v = (RecyclerView) c(R.id.plate_limit_setting_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f7502a, 0, false);
        RecyclerView recyclerView = this.v;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            if (this.A == null) {
                a(new com.baidu.navisdk.module.plate.adapter.a(this.f7502a, this.r, this.s, this.q));
            }
            this.v.addItemDecoration(new com.baidu.navisdk.module.plate.view.e(null, false));
        }
    }

    private void r() {
        int i = this.s;
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    return;
                }
            } else {
                BNSettingSwitchItem bNSettingSwitchItem = this.w;
                if (bNSettingSwitchItem != null) {
                    bNSettingSwitchItem.setVisibility(8);
                    return;
                }
                return;
            }
        }
        BNSettingSwitchItem bNSettingSwitchItem2 = this.w;
        if (bNSettingSwitchItem2 != null && !this.D) {
            bNSettingSwitchItem2.setVisibility(0);
            this.w.setChecked(com.baidu.navisdk.module.routepreference.d.j().h());
        }
    }

    public void g(int i) {
        BNSettingSwitchItem bNSettingSwitchItem = this.w;
        if (bNSettingSwitchItem == null) {
            return;
        }
        if (i == 1) {
            bNSettingSwitchItem.setSwitchViewBackground(this.f7502a.getResources().getDrawable(R.drawable.bnav_setting_energy_item_switch_selector));
        } else {
            bNSettingSwitchItem.setSwitchViewBackground(this.f7502a.getResources().getDrawable(R.drawable.bnav_setting_item_switch_selector));
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void i() {
        super.i();
        com.baidu.navisdk.module.asr.a.b().a(true);
        this.D = false;
        com.baidu.navisdk.module.plate.b bVar = this.z;
        if (bVar != null) {
            bVar.c();
            this.z = null;
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void k() {
        super.k();
        com.baidu.navisdk.module.asr.a.b().a(false);
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.9.5", String.valueOf(this.q), null, null);
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void n() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
            a2.setFillAfter(true);
            a2.setAnimationListener(new e());
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
            a2.setAnimationListener(new d());
            this.d.startAnimation(a2);
        }
    }

    public void p() {
        this.z = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BasePlateLimitSettingVi", "updateCarLimitState: isOpen " + z);
        }
        int i = this.s;
        if (i == 1 || i == 4) {
            com.baidu.navisdk.module.routepreference.d.j().b(z);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.1", z ? "1" : "0", null, "2");
        if (this.y != null) {
            com.baidu.navisdk.module.asr.a.b().a(true);
            this.y.a();
        }
    }

    public void f(int i) {
        TextView textView = this.C;
        if (textView == null) {
            return;
        }
        if (i == 1) {
            textView.setText("车辆管理");
        } else {
            textView.setText("限行设置");
        }
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void a(Bundle bundle) {
        super.a(bundle);
        d(R.layout.bnav_plate_limit_setting_panel_layout);
        q();
    }

    public void a(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.navisdk.module.plate.adapter.a aVar) {
        if (aVar == null) {
            return;
        }
        this.A = aVar;
        List<com.baidu.navisdk.module.plate.base.a> list = this.x;
        if (list != null) {
            aVar.a(list);
        }
        RecyclerView recyclerView = this.v;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.A);
        }
    }

    public void e(int i) {
        this.s = i;
        r();
    }

    public void a(com.baidu.navisdk.module.plate.b bVar) {
        this.z = bVar;
    }

    public void a(boolean z, boolean z2) {
        BNSettingSwitchItem bNSettingSwitchItem = this.w;
        if (bNSettingSwitchItem != null) {
            this.D = z2;
            bNSettingSwitchItem.setVisibility(z ? 0 : 8);
        }
    }

    public void a(com.baidu.navisdk.module.plate.a aVar) {
        this.B = aVar;
    }
}
