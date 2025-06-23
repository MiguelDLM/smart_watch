package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class g0 extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    protected ViewGroup i;
    private View j;
    protected View k;
    public Animation l;
    public Animation m;
    protected int n;
    protected int o;
    protected boolean p;
    protected c q;
    protected e r;
    protected d s;
    protected int t;
    private Animation.AnimationListener u;
    private Animation.AnimationListener v;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMNotificationBaseView", "notification show onAnimationEnd");
            }
            c cVar = g0.this.q;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMNotificationBaseView", "notification hide onAnimationEnd");
            }
            c cVar = g0.this.q;
            if (cVar != null) {
                cVar.d();
            }
            g0.this.i();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void a(boolean z);

        void b();

        void b(boolean z);

        void c();

        void d();
    }

    /* loaded from: classes8.dex */
    public static class f implements e {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
        }
    }

    public g0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0;
        this.u = new a();
        this.v = new b();
        q0();
    }

    private void V() {
        Animation animation;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notification hideWithAnim");
        }
        c cVar = this.q;
        if (cVar != null) {
            cVar.c();
        }
        e eVar = this.r;
        if (eVar != null) {
            eVar.b();
            this.r.b(true);
        }
        if (this.k != null && this.m != null && (animation = this.l) != null) {
            if (animation.hasStarted() && !this.l.hasEnded()) {
                if (gVar.d()) {
                    gVar.e("RGMMNotificationBaseView", "notification show anim running");
                }
                this.k.clearAnimation();
                c cVar2 = this.q;
                if (cVar2 != null) {
                    cVar2.b();
                }
                c cVar3 = this.q;
                if (cVar3 != null) {
                    cVar3.d();
                }
                i();
                return;
            }
            if (this.m.hasStarted() && !this.m.hasEnded()) {
                if (gVar.d()) {
                    gVar.e("RGMMNotificationBaseView", "notification hide anim running");
                }
            } else {
                this.m.setAnimationListener(this.v);
                this.k.startAnimation(this.m);
            }
        }
    }

    private void q0() {
        if (this.b != null && this.f9165a != null) {
            this.j = com.baidu.navisdk.ui.routeguide.control.x.b().b(R.id.bnav_rg_notification_panel);
            ViewGroup b2 = com.baidu.navisdk.ui.routeguide.control.x.b().b(R.id.bnav_rg_notification_container);
            this.i = b2;
            if (this.j != null && b2 != null) {
                f0();
                this.l = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_in_bottom);
                this.m = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_out_bottom);
            }
        }
    }

    private void r0() {
        boolean z;
        boolean z2;
        boolean z3;
        Animation animation;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notification showWithAnim");
        }
        boolean z4 = true;
        if (this.j != null && this.i != null && this.k != null && (animation = this.l) != null) {
            if (animation.hasStarted() && !this.l.hasEnded()) {
                if (gVar.d()) {
                    gVar.e("RGMMNotificationBaseView", "notification show anim running");
                    return;
                }
                return;
            }
            this.j.setVisibility(0);
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setAnimationListener(this.u);
            this.k.startAnimation(this.l);
            c cVar = this.q;
            if (cVar != null) {
                cVar.a();
            }
            e eVar = this.r;
            if (eVar != null) {
                eVar.a();
                this.r.a(true);
                return;
            }
            return;
        }
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("mNotificationViewPanel");
            if (this.j == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append("mViewContainer");
            if (this.i == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            sb.append("mNotificationView");
            if (this.k == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            sb.append(z3);
            sb.append(this.l);
            if (this.l != null) {
                z4 = false;
            }
            sb.append(z4);
            gVar.e("RGMMNotificationBaseView", sb.toString());
        }
    }

    private void s0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notification showWithoutAnim");
        }
        View view = this.j;
        if (view != null && this.i != null && this.k != null) {
            view.setVisibility(0);
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            c cVar = this.q;
            if (cVar != null) {
                cVar.a();
            }
            e eVar = this.r;
            if (eVar != null) {
                eVar.d();
                this.r.a(false);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            return new View[]{this.i};
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notificationBaseView hide");
        }
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.BrowseMap) && !a()) {
            o0();
        } else {
            V();
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.a();
        }
        super.c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(true, !com.baidu.navisdk.ui.routeguide.utils.b.o().b(), this.i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("notification dispose()， mNotificationView==null?");
            boolean z2 = false;
            if (this.k == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", mViewContainer==null?");
            if (this.i == null) {
                z2 = true;
            }
            sb.append(z2);
            gVar.e("RGMMNotificationBaseView", sb.toString());
        }
        View view = this.k;
        if (view != null) {
            view.clearAnimation();
            this.k.setVisibility(8);
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.removeView(this.k);
            if (gVar.d()) {
                gVar.e("caoyujieTodo", "removeView mNotificationView, mViewContainer.views = " + this.i.getChildCount());
            }
        }
        ArrayList<m> d2 = com.baidu.navisdk.ui.routeguide.control.s.T().d();
        ArrayList<i0> i = com.baidu.navisdk.ui.routeguide.control.s.T().i();
        ArrayList<l> b2 = com.baidu.navisdk.ui.routeguide.control.s.T().b();
        if ((d2 == null || d2.isEmpty()) && ((i == null || i.isEmpty()) && (b2 == null || b2.isEmpty()))) {
            ViewGroup viewGroup2 = this.i;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            View view2 = this.j;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.a();
        }
        this.s = null;
        this.k = null;
        this.i = null;
        this.j = null;
        this.b = null;
        this.c = null;
        this.f9165a = null;
        Animation animation = this.l;
        if (animation != null) {
            animation.reset();
        }
        this.l = null;
        Animation animation2 = this.m;
        if (animation2 != null) {
            animation2.reset();
        }
        this.m = null;
    }

    public View n0() {
        return this.k;
    }

    public void o0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notification hideWithoutAnim");
        }
        super.c();
        c cVar = this.q;
        if (cVar != null) {
            cVar.c();
        }
        e eVar = this.r;
        if (eVar != null) {
            eVar.c();
            this.r.b(false);
        }
        View view = this.k;
        if (view == null) {
            return;
        }
        view.clearAnimation();
        this.k.setVisibility(8);
    }

    public void p0() {
        super.y();
        s0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMNotificationBaseView", "notificationBaseView show");
        }
        super.y();
        r0();
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (z) {
            return null;
        }
        f0();
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (z) {
            return null;
        }
        f0();
        return null;
    }
}
