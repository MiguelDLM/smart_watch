package com.baidu.navisdk.ugc.external;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.a;
import com.baidu.navisdk.ugc.eventdetails.view.FeelChildEventView;
import com.baidu.navisdk.ugc.eventdetails.view.a;
import com.baidu.navisdk.ugc.eventdetails.view.h;
import com.baidu.navisdk.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c {
    private static boolean i = false;

    /* renamed from: a, reason: collision with root package name */
    private Context f8175a;
    private ViewGroup b;
    private boolean c = false;
    private View d = null;
    protected ViewGroup e = null;
    private com.baidu.navisdk.ugc.a f;
    private com.baidu.navisdk.ugc.external.b g;
    private Animation h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h {
        public b() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.h
        public boolean a(MotionEvent motionEvent) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "detail view count down time intercept ----- mCountDownTimer = " + c.this.g);
            }
            if (!c.this.g.b()) {
                c.this.g.a();
                c.this.g.d();
                return false;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.external.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0382c implements a.d0 {
        public C0382c() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.a.d0
        public void a(TwoStateScrollView.DragState dragState) {
            if (c.this.g != null) {
                g gVar = g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "detail view count down time slide curstate = " + dragState);
                }
                if (dragState == TwoStateScrollView.DragState.TOP && !c.this.g.b()) {
                    c.this.g.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.c0 {
        public d() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.a.c0
        public void a() {
            if (c.this.g != null) {
                g gVar = g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "detail view count down time stop cuz chat room show");
                }
                if (!c.this.g.b()) {
                    c.this.g.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.ugc.external.b {
        public e(long j, long j2) {
            super(j, j2);
        }

        @Override // com.baidu.navisdk.ugc.external.b
        public void a(long j) {
        }

        @Override // com.baidu.navisdk.ugc.external.b
        public void c() {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "detail view count down time finish mCountDownTimer = " + c.this.g + " outAnim = " + c.this.h);
            }
            if (c.this.f != null && c.this.f.C() && c.this.e != null) {
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "detail view count down time start anim");
                }
                c cVar = c.this;
                cVar.e.startAnimation(cVar.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "detail view count down time anim end");
            }
            c.this.f();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public c(Context context, ViewGroup viewGroup, a.b bVar) {
        this.b = viewGroup;
        this.f8175a = context;
        this.f = new com.baidu.navisdk.ugc.a(bVar);
    }

    private void j() {
        this.g = new e(10000, 1000);
        Animation loadAnimation = JarUtils.loadAnimation(this.f8175a, R.anim.ugc_anim_rg_slide_out_bottom);
        this.h = loadAnimation;
        loadAnimation.setAnimationListener(new f());
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "detail view count down time start");
        }
        this.g.d();
    }

    private void k() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "hideUgcDetailViePanel: ");
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.e.setVisibility(8);
        }
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(null);
            this.d.setVisibility(8);
        }
    }

    public static boolean l() {
        return i;
    }

    public void a(boolean z) {
    }

    public void b() {
        throw null;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onBackPress");
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar != null && aVar.n0()) {
            return true;
        }
        return false;
    }

    public void f() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onDestroy --> ");
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar != null) {
            aVar.onDestroy();
            this.f = null;
        }
        com.baidu.navisdk.ugc.external.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
        c();
    }

    public void g() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onPause: ");
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar != null) {
            aVar.b0();
        }
    }

    public void h() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onResume: ");
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar != null) {
            aVar.v0();
        }
    }

    public boolean i() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "show: ");
        }
        this.c = true;
        i = true;
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        com.baidu.navisdk.framework.b.a();
        return true;
    }

    public void c() {
        this.c = false;
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "hide: ");
        }
        i = false;
        k();
    }

    public void a(String str, Bundle bundle, int i2) {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_EventDetails", "mRootViewGroup == null");
                return;
            }
            return;
        }
        this.d = viewGroup.findViewById(R.id.bnav_rg_ugc_detail_menu_panel);
        this.e = (ViewGroup) this.b.findViewById(R.id.bnav_rg_ugc_detail_menu_container);
        a(str, i2, bundle);
    }

    public boolean b(int i2) {
        com.baidu.navisdk.ugc.a aVar = this.f;
        return aVar != null && aVar.a(i2);
    }

    public static void b(boolean z) {
        i = z;
    }

    private void a(String str, int i2, Bundle bundle) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "initView");
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        View a2 = this.f.a(this.f8175a, str, com.baidu.navisdk.framework.b.e(), bundle, i2);
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null && a2 != null) {
            viewGroup2.removeAllViews();
            this.e.addView(a2, new ViewGroup.LayoutParams(-1, -1));
            if ((bundle.containsKey("page") ? bundle.getInt("page") : 1) == 1) {
                if (i2 == 2) {
                    b();
                }
                j();
                a(a2);
            }
            a(com.baidu.navisdk.ui.util.b.b());
            return;
        }
        f();
    }

    private void a(View view) {
        if (view != null) {
            FeelChildEventView feelChildEventView = (FeelChildEventView) view.findViewById(R.id.ugc_rc_details_bg);
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "detail view count down time feelChildEventView = " + feelChildEventView);
            }
            if (feelChildEventView != null && this.g != null) {
                feelChildEventView.setOnInterceptCallback(new b());
            }
        }
        if (com.baidu.navisdk.ugc.eventdetails.control.a.I().i() == null || !(com.baidu.navisdk.ugc.eventdetails.control.a.I().i() instanceof com.baidu.navisdk.ugc.eventdetails.view.a)) {
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.view.a aVar = (com.baidu.navisdk.ugc.eventdetails.view.a) com.baidu.navisdk.ugc.eventdetails.control.a.I().i();
        aVar.a(new C0382c());
        aVar.a(new d());
    }

    public void a(int i2, int i3, Intent intent) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onActivityResult");
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar != null) {
            aVar.onActivityResult(i2, i3, intent);
        }
    }

    public void a() {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "dispose: isViewShow --> " + i);
        }
    }

    public void a(int i2) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "hideTrafficLightPanel lightId: " + i2 + ", isViewShow: " + i);
        }
        com.baidu.navisdk.ugc.a aVar = this.f;
        if (aVar == null || !i) {
            return;
        }
        aVar.o(i2);
    }

    public void a(com.baidu.navisdk.comapi.ugc.a aVar) {
        com.baidu.navisdk.ugc.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }
}
