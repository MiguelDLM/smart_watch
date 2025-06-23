package com.baidu.navisdk.module.newguide.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.q;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.module.newguide.settings.drag.a;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class f extends com.baidu.navisdk.module.newguide.widgets.b implements a.b, com.baidu.navisdk.module.newguide.settings.i.a {
    private g.a A;
    private BNSettingNewTextRadioGroup.a B;
    private i C;
    private boolean D;
    private boolean E;
    private a.InterfaceC0201a F;
    private boolean G;
    private com.baidu.navisdk.util.worker.lite.b H;
    private FrameLayout l;
    private com.baidu.navisdk.module.newguide.settings.viewmodel.a m;
    private RecyclerView n;
    private FrameLayout o;
    private com.baidu.navisdk.module.newguide.settings.g p;
    private ItemTouchHelper q;
    private com.baidu.navisdk.module.newguide.settings.drag.a r;
    private ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> s;
    private View t;
    private TextView u;
    private boolean v;
    private int w;
    private int x;
    private BNSettingExplainSwitchItem.c y;
    private View.OnClickListener z;

    /* loaded from: classes7.dex */
    public class a implements BNSettingExplainSwitchItem.c {
        public a() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem.c
        public boolean onChecked(int i, boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onChecked: " + i + ", isChecked:" + z);
            }
            if (f.this.m == null) {
                if (gVar.c()) {
                    gVar.c("RGSettingPageView", "onChecked viewmodel == null");
                    return false;
                }
                return false;
            }
            if (i == R.id.nav_license_plates_limit_layout) {
                return f.this.m.a(5, z);
            }
            if (i == R.id.nav_scale_layout) {
                return f.this.m.a(9, z);
            }
            if (i == R.id.nav_calling_play_layout) {
                return f.this.m.a(14, z);
            }
            if (i == R.id.nav_park_layout) {
                return f.this.m.a(15, z);
            }
            if (i == R.id.nav_scenic_setting_layout) {
                return f.this.m.a(16, z);
            }
            if (i == R.id.nav_power_saver_setting_layout) {
                return f.this.m.a(17, z);
            }
            if (i == R.id.nav_hd_navi_layout) {
                return f.this.m.a(27, z);
            }
            if (i == R.id.nav_normal_hd_layout) {
                return f.this.m.a(28, z);
            }
            if (i == R.id.nav_new_road_condition_item) {
                return f.this.m.a(29, z);
            }
            if (i == R.id.nav_save_parking_setting_layout) {
                return f.this.m.a(31, z);
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g.a {
        public b() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.g.a
        public void a(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onLongPressSort: " + view + ",isSortStatus: " + f.this.v);
            }
            f.this.E0();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BNSettingNewTextRadioGroup.a {
        public c() {
        }

        @Override // com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup.a
        public void a(RadioGroup radioGroup, int i, CharSequence charSequence, int i2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onCheckedChanged: " + i + ", content:" + ((Object) charSequence) + ",position: " + i2);
            }
            int id = radioGroup.getId();
            if (id == R.id.nsdk_rg_nav_guide_angle_radio_group) {
                f.this.m.a(6, i2);
                return;
            }
            if (id == R.id.nav_view_night_mode_selector_rg) {
                f.this.m.a(7, i2);
                return;
            }
            if (id == R.id.bn_rg_setting_screen_orientation_group) {
                f.this.m.a(8, i2);
                return;
            }
            if (id == R.id.nav_view_voice_selector_rg) {
                f.this.m.a(10, i2);
                return;
            }
            if (id == R.id.bn_rg_setting_bluetooth_setting_ly) {
                f.this.m.a(12, i2);
                return;
            }
            if (id == R.id.nav_view_music_volume_selector_rg) {
                f.this.m.a(13, i2);
            } else if (id == R.id.nav_bg_float_setting_selector_rg) {
                f.this.m.a(24, i2);
            } else if (id == R.id.nsdk_rg_hd_map_radio_group) {
                f.this.m.a(30, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onClick: " + view);
            }
            int id = view.getId();
            if (id == R.id.bnav_rg_setting_done_btn) {
                f.this.D0();
                return;
            }
            if (id == R.id.nav_license_passport_layout) {
                if (f.this.m != null) {
                    f.this.m.e(18);
                    return;
                }
                return;
            }
            if (id == R.id.car_plate_setting_view) {
                if (f.this.m != null) {
                    f.this.m.e(4);
                    return;
                }
                return;
            }
            if (id == R.id.bnav_rg_menu_broadcast_content_select_layout) {
                if (f.this.m != null) {
                    f.this.m.e(11);
                    return;
                }
                return;
            }
            if (id == R.id.nav_wechat_tips) {
                if (!com.baidu.navisdk.util.common.c.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", "https://opn.baidu.com/map/2020/WXTHSZ-help?tpltype=1");
                    bundle.putBoolean("h5share", true);
                    bundle.putBoolean("h5title", true);
                    com.baidu.navisdk.framework.b.a(15, bundle);
                    return;
                }
                return;
            }
            if (id == R.id.nav_wechat_support) {
                if (f.this.m != null) {
                    f.this.m.e(23);
                }
            } else if (id == R.id.nav_float_setting_cb) {
                if (f.this.m != null) {
                    f.this.m.a(22, !view.isSelected());
                }
            } else if (id == R.id.bn_rg_menu_cur_super_voice_layout && f.this.m != null) {
                f.this.m.e(25);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Observer<ArrayList<com.baidu.navisdk.module.newguide.settings.model.e>> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onChanged: " + arrayList);
            }
            if (f.this.s == null || !f.this.s.equals(arrayList)) {
                f.this.s = arrayList;
                if (f.this.p != null) {
                    f.this.p.a(arrayList);
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.f$f, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0255f implements Observer<Integer> {
        public C0255f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Integer num) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "onChanged: " + num);
            }
            if (num.intValue() == 100) {
                f.this.A0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.InterfaceC0201a {
        public g() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            f.this.F0();
            if ((obj instanceof q) && f.this.m != null) {
                f.this.m.f(((q) obj).a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends com.baidu.navisdk.util.worker.lite.b {
        public h(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            if (f.this.n != null) {
                f.this.n.setVisibility(8);
                f.this.G = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a();

        void b();

        void c();

        void d();
    }

    public f(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, FrameLayout frameLayout, int i2) {
        super(context, viewGroup, aVar);
        this.D = true;
        this.E = false;
        this.G = false;
        this.H = new h("BNHideSetting");
        a(i2, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "registerShortcutFunEvent: " + this.E);
        }
        if (!this.E) {
            this.E = true;
            if (this.F == null) {
                this.F = new g();
            }
            com.baidu.navisdk.framework.message.a.a().a(this.F, q.class, new Class[0]);
        }
    }

    private void B0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "removeSettingDoneBtn: ");
        }
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
                this.x = 0;
                v(this.w);
            }
        }
    }

    private void C0() {
        if (!this.D) {
            return;
        }
        u0();
        RecyclerView recyclerView = this.n;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "switch2NormalStatus: ");
        }
        B0();
        com.baidu.navisdk.module.newguide.settings.g gVar2 = this.p;
        if (gVar2 != null) {
            gVar2.a(false);
        }
        this.v = false;
        i iVar = this.C;
        if (iVar != null) {
            iVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "switch2SortStatus: ");
        }
        if (this.p != null) {
            i iVar = this.C;
            if (iVar != null) {
                iVar.b();
            }
            w0();
            this.p.a(true);
            t0();
            this.v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "unregisterShortcutFunEvent: " + this.E);
        }
        if (this.E) {
            this.E = false;
            if (this.F != null) {
                com.baidu.navisdk.framework.message.a.a().a(this.F);
            }
        }
    }

    private void s0() {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar = (com.baidu.navisdk.module.newguide.settings.viewmodel.a) n0().get(com.baidu.navisdk.module.newguide.settings.viewmodel.a.class);
        this.m = aVar;
        aVar.a(this.c);
        this.m.b().observe(this, new e());
        this.m.c(20).observe(this, new C0255f());
    }

    private void t0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "addSettingDoneBtn: ");
        }
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_setting_page_done_ly_height);
        if (this.t == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_new_setting_done_btn, this.l, false);
            this.t = a2;
            TextView textView = (TextView) a2.findViewById(R.id.bnav_rg_setting_done_btn);
            this.u = textView;
            textView.setOnClickListener(this.z);
        }
        B0();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.t.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
            this.t.setLayoutParams(layoutParams);
        }
        layoutParams.gravity = 80;
        this.l.addView(this.t);
        this.x = dimensionPixelSize;
        v(this.w);
    }

    private void u0() {
        if (!this.D) {
            return;
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.H);
    }

    private void w0() {
        if (this.r == null) {
            this.r = new com.baidu.navisdk.module.newguide.settings.drag.a(this.p).a(this);
        }
        if (this.q == null) {
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(this.r);
            this.q = itemTouchHelper;
            itemTouchHelper.attachToRecyclerView(this.n);
        }
    }

    private void x0() {
        this.y = new a();
        this.A = new b();
        this.B = new c();
        this.z = new d();
    }

    private void y0() {
        if (this.o == null) {
            this.o = (FrameLayout) this.l.findViewById(R.id.bn_rg_setting_page_recycle_container);
            v(this.w);
        }
        if (this.n == null) {
            RecyclerView recyclerView = (RecyclerView) this.l.findViewById(R.id.bn_rg_setting_page_recycle);
            this.n = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f9165a));
            this.n.setFocusableInTouchMode(false);
            boolean a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("setting_opt_perf", true);
            this.D = a2;
            if (a2) {
                this.n.setVisibility(8);
                this.n.setHasFixedSize(true);
            }
        }
    }

    private void z0() {
        if (!this.D) {
            return;
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.H, 3000L);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.b
    public void C() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "onFinishDrag: ");
        }
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar = this.m;
        if (aVar != null) {
            aVar.a(this.s);
        }
        i iVar = this.C;
        if (iVar != null) {
            iVar.a();
        }
        String b2 = this.p.b();
        String a2 = this.p.a();
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(a2)) {
            if (gVar.d()) {
                gVar.e("RGSettingPageView", "titleType : " + b2 + "finalPosition : " + a2);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.7.4", b2, a2);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.settings.i.a
    public com.baidu.navisdk.module.newguide.settings.viewmodel.a I() {
        return this.m;
    }

    @Override // com.baidu.navisdk.module.newguide.settings.i.a
    public LifecycleOwner J() {
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
    }

    public void o0() {
        if (this.v) {
            D0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar = this.m;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void p0() {
        RecyclerView recyclerView = this.n;
        if (recyclerView != null) {
            if (this.v) {
                D0();
            } else if (recyclerView.canScrollVertically(-1)) {
                this.n.scrollToPosition(0);
            }
        }
    }

    public boolean q0() {
        return false;
    }

    public void r0() {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar = this.m;
        if (aVar != null) {
            aVar.o();
            this.m.i();
            this.m.l();
            this.m.j();
        }
    }

    public void v(int i2) {
        ViewGroup.LayoutParams layoutParams;
        this.w = i2;
        int i3 = i2 - this.x;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "updateRecyclerViewHeight: " + i3 + ", mRecyclerViewMarginBottom:" + this.x);
        }
        FrameLayout frameLayout = this.o;
        if (frameLayout != null && (layoutParams = frameLayout.getLayoutParams()) != null) {
            layoutParams.width = -1;
            layoutParams.height = i3;
            this.o.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.b
    public void v0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "onStartDrag: ");
        }
        i iVar = this.C;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.b, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        y0();
        s0();
        if (this.p == null) {
            com.baidu.navisdk.module.newguide.settings.g gVar = new com.baidu.navisdk.module.newguide.settings.g(this.s, this);
            this.p = gVar;
            gVar.a(this.z, this.B, this.A, this.y);
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.p);
            }
        }
        this.m.b(false);
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.b, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        if (this.v) {
            D0();
        }
        F0();
    }

    private void a(int i2, FrameLayout frameLayout) {
        this.l = frameLayout;
        this.w = i2;
        x0();
    }

    public void a(i iVar) {
        this.C = iVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i2) {
        super.a(viewGroup, i2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingPageView", "orientationChanged: " + i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar = this.m;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void a(p pVar, p pVar2, boolean z) {
        if (pVar2 == p.BOTTOM) {
            z0();
        } else {
            C0();
        }
    }

    public void a(p pVar, int i2) {
        if (pVar != p.BOTTOM || this.G || i2 <= 100) {
            return;
        }
        C0();
    }

    public void a(int i2, int i3, Intent intent) {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar;
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar2;
        com.baidu.navisdk.module.newguide.settings.viewmodel.a aVar3;
        if (i2 == 4101) {
            if (!l.c(com.baidu.navisdk.framework.a.c().a()) || (aVar3 = this.m) == null) {
                return;
            }
            aVar3.e(true);
            return;
        }
        if (i2 == 3001) {
            if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION") || (aVar2 = this.m) == null) {
                return;
            }
            aVar2.c(true);
            return;
        }
        if (i2 == 3006 && BNSettingManager.hasPipPermission() && (aVar = this.m) != null) {
            aVar.c(true);
        }
    }
}
