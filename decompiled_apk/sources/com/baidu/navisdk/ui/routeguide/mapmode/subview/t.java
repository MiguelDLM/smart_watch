package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNDrawableTextView;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class t extends com.baidu.navisdk.ui.routeguide.widget.c {
    private View m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private View q;
    private TextView r;
    protected BNDrawableTextView s;
    private boolean t;
    private boolean u;
    private com.baidu.navisdk.pronavi.data.vm.devicestate.b v;

    /* loaded from: classes8.dex */
    public class a implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
            t.this.a(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.c> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.c cVar) {
            t.this.a(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.e> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.e eVar) {
            t.this.a(eVar);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.f> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.f fVar) {
            t.this.a(fVar);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.d> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.d dVar) {
            t.this.a(dVar);
        }
    }

    public t(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = false;
        this.v = null;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.t = k.S();
        }
        u0();
        if (this.t) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    private void y0() {
        if (!this.u) {
            this.v = (com.baidu.navisdk.pronavi.data.vm.devicestate.b) com.baidu.navisdk.ui.routeguide.b.V().s().c(com.baidu.navisdk.pronavi.data.vm.devicestate.b.class);
            LifecycleOwner f = com.baidu.navisdk.ui.routeguide.b.V().f();
            com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar = this.v;
            if (bVar != null && f != null) {
                this.u = true;
                bVar.c().observe(f, new a());
                this.v.d().observe(f, new b());
                this.v.f().observe(f, new c());
                this.v.g().observe(f, new d());
                this.v.e().observe(f, new e());
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        if (!this.t) {
            y0();
        }
        return super.b(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.ui.util.j.a(this.o);
        com.baidu.navisdk.ui.util.j.a(this.p);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        if (2 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_device_state_icon_margin_top);
            return layoutParams;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.rightMargin = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_device_state_margin_right);
        return layoutParams2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_device_status_container;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.nsdk_layout_rg_device_state_land;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.nsdk_layout_rg_device_state;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "RGMMDeviceStateView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void v(int i) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        View view = this.k;
        if (view == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDeviceStateView", "initViewById-> mRootView == null!!!!!");
                return;
            }
            return;
        }
        this.m = view.findViewById(R.id.bnav_rg_sg_satelite_panel);
        this.o = (ImageView) this.k.findViewById(R.id.bnav_rg_sg_satelite_icon);
        this.n = (TextView) this.k.findViewById(R.id.bnav_rg_sg_satelite_num);
        this.o.setVisibility(0);
        this.p = (ImageView) this.k.findViewById(R.id.bnav_rg_sg_volume_icon);
        this.q = this.k.findViewById(R.id.bnav_rg_service_area_panel);
        this.r = (TextView) this.k.findViewById(R.id.bnav_rg_service_area_subscribed_num);
        this.s = (BNDrawableTextView) this.k.findViewById(R.id.bnav_rg_vdr_signal_view);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar;
        super.a(viewGroup, i);
        if (r0() == q0() || (bVar = this.v) == null) {
            return;
        }
        a(bVar.d().getValue());
        a(this.v.f().getValue());
        a(this.v.g().getValue());
        a(this.v.e().getValue());
    }

    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDeviceStateView", "onChangeCurAreaState: " + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.c cVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDeviceStateView", "onChangeSatelliteSignal: " + cVar);
        }
        if (this.o == null || this.n == null || this.m == null) {
            return;
        }
        if (cVar != null && cVar.f()) {
            this.m.setVisibility(0);
            this.o.setImageResource(cVar.a());
            this.n.setTextColor(cVar.d());
            this.n.setText(cVar.c());
            return;
        }
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.e eVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDeviceStateView", "onChangeVdrState: " + eVar);
        }
        if (eVar != null && eVar.c()) {
            this.s.setVisibility(0);
            this.s.setText(eVar.a());
        } else {
            this.s.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDeviceStateView", "onChangeVolume: " + fVar);
        }
        if (this.p != null) {
            if (fVar != null && fVar.b()) {
                com.baidu.navisdk.ui.routeguide.model.a0.I().s = true;
                this.p.setVisibility(0);
                this.p.setImageResource(fVar.a());
            } else {
                com.baidu.navisdk.ui.routeguide.model.a0.I().s = false;
                this.p.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDeviceStateView", "onChangeServiceSubscribe: " + dVar);
        }
        if (this.q == null || this.r == null) {
            return;
        }
        if (dVar != null && dVar.b()) {
            this.q.setVisibility(0);
            this.r.setText(dVar.a() + "");
            return;
        }
        this.q.setVisibility(8);
    }
}
