package com.baidu.navisdk.pronavi.ui.newnavi.bottom;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.subviews.a;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.module.newguide.subviews.a implements View.OnClickListener {

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.newnavi.bottom.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class ViewOnClickListenerC0356b implements View.OnClickListener {
        public ViewOnClickListenerC0356b(boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.A(true);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public c(boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (((com.baidu.navisdk.module.newguide.subviews.a) b.this).m != null) {
                a.InterfaceC0265a interfaceC0265a = ((com.baidu.navisdk.module.newguide.subviews.a) b.this).m;
                IIX0o.ooOOo0oXI(interfaceC0265a);
                interfaceC0265a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7931a = new d();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        new a(null);
    }

    public b(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO ViewGroup viewGroup2) {
        super(context, viewGroup, viewGroup2);
        a(viewGroup2);
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void A(boolean z) {
        int i;
        if (z) {
            e0();
            u(10000);
        }
        a.b bVar = this.l;
        if (bVar != null) {
            IIX0o.ooOOo0oXI(bVar);
            bVar.a();
        }
        this.k = true;
        if (this.j == null) {
            if (n0()) {
                i = R.layout.bnav_layout_rg_bottombar_new_quite_navi_land;
            } else {
                i = R.layout.bnav_layout_rg_bottombar_new_quite_navi;
            }
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, i, this.b, false);
            this.j = a2;
            a2.setOnTouchListener(d.f7931a);
            View findViewById = this.j.findViewById(R.id.bnav_rg_new_quite_navi_cancel_btn);
            this.j.findViewById(R.id.bnav_rg_new_toolbox_quit_navi).setOnClickListener(this);
            findViewById.setOnClickListener(this);
        }
        View view = this.j;
        IIX0o.ooOOo0oXI(view);
        ViewParent parent = view.getParent();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarQuitNaviView", "showQuiteNavView: " + parent);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.j);
        }
        this.b.addView(this.j);
        View view2 = this.j;
        IIX0o.ooOOo0oXI(view2);
        view2.setVisibility(0);
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.7.5");
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void b(boolean z, boolean z2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarQuitNaviView", "hideQuiteNaviView: " + z2 + ",isOrientationChange: " + z);
        }
        if (!z) {
            e0();
            this.k = false;
        }
        View view = this.j;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.j);
                a.b bVar = this.l;
                if (bVar != null) {
                    IIX0o.ooOOo0oXI(bVar);
                    bVar.a(z2);
                }
            }
        }
        this.j = null;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        z(false);
        TextView textView = this.i;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.setOnClickListener(null);
        }
        this.l = null;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a, com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        super.i0();
        z(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OOXIXo View v) {
        IIX0o.x0xO0oo(v, "v");
        int id = v.getId();
        if (id == R.id.bnav_rg_bottombar_new_right_btn) {
            A(true);
            return;
        }
        if (id == R.id.bnav_rg_new_toolbox_quit_navi) {
            a.InterfaceC0265a interfaceC0265a = this.m;
            if (interfaceC0265a != null) {
                IIX0o.ooOOo0oXI(interfaceC0265a);
                interfaceC0265a.b();
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_new_quite_navi_cancel_btn) {
            z(false);
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.7.5", "1");
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public boolean p0() {
        if (o0()) {
            z(true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void y(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarQuitNaviView", "changeQuiteViewChange: ");
        }
        TextView textView = this.i;
        if (textView != null) {
            if (z) {
                com.baidu.navisdk.ui.util.b.a(textView, 0, R.drawable.bnav_bottom_new_right_exit, 0, 0);
                textView.setText(R.string.nsdk_string_exit);
                textView.setOnClickListener(new ViewOnClickListenerC0356b(z));
            } else {
                com.baidu.navisdk.ui.util.b.a(textView, 0, R.drawable.bnav_bottom_new_right_pack, 0, 0);
                textView.setText(R.string.nsdk_string_close_detail);
                textView.setOnClickListener(new c(z));
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void z(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarQuitNaviView", "hideQuiteNaviView: " + z);
        }
        b(z, false);
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void a(@oOoXoXO ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.b;
        int i = R.id.bnav_rg_bottombar_new_right_btn;
        TextView textView = (TextView) viewGroup2.findViewById(i);
        this.i = textView;
        textView.setOnClickListener(this);
        if (this.f == 2) {
            this.i = viewGroup != null ? (TextView) viewGroup.findViewById(i) : null;
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void a(@oOoXoXO a.InterfaceC0265a interfaceC0265a) {
        this.m = interfaceC0265a;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void a(@oOoXoXO a.b bVar) {
        this.l = bVar;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.a
    public void a(@oOoXoXO ViewGroup viewGroup, int i, @OOXIXo ViewGroup settingRootView) {
        IIX0o.x0xO0oo(settingRootView, "settingRootView");
        super.a(viewGroup, i);
        z(true);
        TextView textView = this.i;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, 0, R.drawable.bnav_bottom_new_right_exit, 0, 0);
            this.i.setText(R.string.nsdk_string_exit);
            this.i.setOnClickListener(null);
        }
        a(settingRootView);
        if (this.k) {
            A(false);
        }
    }
}
