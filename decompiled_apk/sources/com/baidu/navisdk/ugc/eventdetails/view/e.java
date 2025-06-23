package com.baidu.navisdk.ugc.eventdetails.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.control.e;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class e implements com.baidu.navisdk.ugc.eventdetails.interfaces.c, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ugc.eventdetails.control.a f8143a;
    private View c;
    private ViewGroup d;
    private ViewGroup e;
    private View f;
    private e.d g;
    private com.baidu.navisdk.ugc.eventdetails.interfaces.a i;
    private com.baidu.navisdk.ugc.eventdetails.model.a j;
    private ViewTreeObserver.OnGlobalLayoutListener k;
    private View b = null;
    private com.baidu.navisdk.ugc.eventdetails.control.e h = new com.baidu.navisdk.ugc.eventdetails.control.e();

    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this.d != null) {
                e.this.d.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements e.d {
        public b() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.e.d
        public void onAction(int i) {
            if (i == 1) {
                com.baidu.navisdk.util.common.g.UGC.e("UgcModule_FixedEventDetails", "mOutlineLoadingListener: --> ACTION_RETRY");
                e.this.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.j();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f8143a.x();
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.view.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC0378e implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0378e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.b(1);
            e eVar = e.this;
            eVar.a(eVar.d);
            e.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(e.this.k);
            e.this.k = null;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.k();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public e(Context context, com.baidu.navisdk.ugc.eventdetails.model.a aVar, com.baidu.navisdk.ugc.eventdetails.control.a aVar2) {
        this.f8143a = aVar2;
        this.j = aVar;
        a(context);
    }

    private void i() {
        if (this.g == null) {
            this.g = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8143a;
        if (aVar != null) {
            aVar.y();
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int d2 = this.j.d();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_FixedEventDetails", "startGetData getDataSource: " + d2);
        }
        if (d2 == 1) {
            if (!this.f8143a.c(this.j.j())) {
                a(1, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
            }
        } else {
            if (d2 == 3) {
                this.f8143a.l();
                return;
            }
            if (d2 == 2) {
                com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.j;
                if (aVar.k == 3) {
                    if (!this.f8143a.c(aVar.j())) {
                        a(1, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
                    }
                } else if (!this.f8143a.a()) {
                    this.f8143a.o();
                }
            }
        }
    }

    private void l() {
        if (this.i == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_FixedEventDetails", "updateFixedPanelData mFixedPanel == null");
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.model.b j = this.f8143a.j();
        if (j == null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_FixedEventDetails", "updateFixedPanelData ,dataModel is null");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar3.d()) {
            gVar3.e("UgcModule_FixedEventDetails", "updateFixedPanelData: " + j);
        }
        this.i.a(j, this.f8143a.f());
        if (j.g) {
            this.i.a(new d());
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean a(int i) {
        return false;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public int g() {
        int i;
        View view = this.f;
        if (view != null) {
            i = view.getMeasuredHeight();
        } else {
            i = 0;
        }
        if (i == 0) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_161dp);
        }
        return i;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean onBackPressed() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8143a;
        if (aVar != null) {
            aVar.y();
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ugc_rc_details_bg) {
            j();
            return;
        }
        if (id == R.id.view_avoid_congestion) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.3", "" + this.f8143a.m(), "2", null);
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8143a;
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onDestroy() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_FixedEventDetails", "BNUgcEventDetailsFixedView onDestroy");
        }
        View view = this.c;
        if (view != null && this.k != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.k);
            this.k = null;
        }
        com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.h;
        if (eVar != null) {
            eVar.a();
            this.h = null;
        }
        this.f = null;
        com.baidu.navisdk.ugc.eventdetails.interfaces.a aVar = this.i;
        if (aVar != null) {
            aVar.onDestroy();
            this.i = null;
        }
        this.j = null;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onPause() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_FixedEventDetails", "onPause: --> ");
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onResume() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_FixedEventDetails", "onResume: --> ");
        }
        if (this.j.l() && this.c != null) {
            if (this.k == null) {
                this.k = new ViewTreeObserverOnGlobalLayoutListenerC0378e();
            }
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        }
    }

    private void c() {
        if (this.e == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_FixedEventDetails", "initFixedPanelOutlineView: --> outlineViewContainerOuter = null");
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.model.b j = this.f8143a.j();
        if (j == null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_FixedEventDetails", "updateFixedPanelData ,dataModel is null");
                return;
            }
            return;
        }
        if (j.c == 4101) {
            this.i = new com.baidu.navisdk.ugc.eventdetails.view.c();
        } else {
            this.i = new g();
        }
        this.f = this.i.a(this.f8143a.f());
        this.i.b(new c());
        if (this.f == null) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar3.d()) {
                gVar3.e("UgcModule_FixedEventDetails", "initFixedPanelOutlineView: --> inflate fail");
            }
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8143a;
            if (aVar != null) {
                aVar.y();
            }
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.e.getChildCount() == 0) {
            this.e.addView(this.f, new ViewGroup.LayoutParams(-1, -2));
            this.e.setVisibility(0);
        }
    }

    private void d() {
        View view = this.c;
        if (view != null && this.j.g != 3) {
            view.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
        }
    }

    public void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_FixedEventDetails", "loadingStart: type --> " + i);
        }
        if (i != 1) {
            com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.h;
            if (eVar != null) {
                eVar.a(this.f8143a.d(), 1, null);
                return;
            }
            return;
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.h;
        if (eVar2 != null) {
            eVar2.a(this.f8143a.d(), 2, this.d);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public View e() {
        return this.b;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void f() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_FixedEventDetails", "onOutlineDataSetChanged: --> start: scrollViewInited = ");
        }
        c();
        l();
        if (gVar.d()) {
            gVar.e("UgcModule_FixedEventDetails", "onOutlineDataSetChanged: --> end");
        }
    }

    private void a(Context context) {
        if (context == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_FixedEventDetails", "BNUgcEventDetailsFixedView initViews context == null");
            }
            this.b = null;
            return;
        }
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_details_fixed_panel_view, null);
        this.b = inflate;
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.ugc_rc_details_bg);
            this.c = findViewById;
            if (this.j.g == 4) {
                findViewById.setBackgroundColor(Color.parseColor("#66000000"));
            } else {
                findViewById.setBackgroundColor(JarUtils.getResources().getColor(android.R.color.transparent));
            }
            this.d = (ViewGroup) this.b.findViewById(R.id.contents_loading_state_container);
            this.e = (ViewGroup) this.b.findViewById(R.id.outline_container_outer);
            d();
            if (this.j.l()) {
                return;
            }
            b(1);
            k();
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void b(Context context, int i) {
        View view = this.b;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.b);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void a(int i, String str, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_FixedEventDetails", "loadingEnd: --> type: " + i + ", suc: " + z + ", err: " + str);
        }
        if (i != 1) {
            com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.h;
            if (eVar != null) {
                eVar.a(1, z, null, null);
            }
            TipTool.onCreateToastDialog(this.f8143a.f(), str);
            return;
        }
        if (!z) {
            if (this.h != null) {
                i();
                this.h.a(2, z, this.d, this.g);
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.h;
        if (eVar2 != null) {
            eVar2.a(2, z, this.d, null);
        }
        com.baidu.navisdk.utils.a.a(this.d, 300, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setAnimationListener(new f());
        view.startAnimation(translateAnimation);
    }
}
