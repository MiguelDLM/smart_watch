package com.baidu.platform.comapi.walknavi.widget.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;

/* loaded from: classes8.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public static int f9882a;
    private TextView A;
    private ImageView B;
    a b;
    private Context c;
    private com.baidu.platform.comapi.walknavi.h.b d;
    private ViewGroup e;
    private RelativeLayout g;
    private View h;
    private View i;
    private RelativeLayout j;
    private LinearLayout k;
    private View l;
    private View m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private ViewGroup q;
    private TextView t;
    private LinearLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private TextView x;
    private RelativeLayout y;
    private ImageView z;
    private boolean f = true;
    private View r = null;
    private View s = null;
    private int C = -1;
    private int D = 0;
    private int E = 0;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.platform.comapi.wnplatform.p.q {
        private b() {
        }

        @Override // com.baidu.platform.comapi.wnplatform.p.q
        public void a(View view) {
            z.this.c();
            if (z.this.d instanceof com.baidu.platform.comapi.walknavi.h.b) {
                z.this.d.e(0);
            }
        }

        public /* synthetic */ b(z zVar, aa aaVar) {
            this();
        }
    }

    public z(Context context, ViewGroup viewGroup, com.baidu.platform.comapi.walknavi.h.b bVar) {
        this.c = context;
        this.e = viewGroup;
        this.d = bVar;
        i();
        d();
        f9882a = 0;
    }

    private void d() {
        ViewGroup viewGroup = (ViewGroup) this.e.findViewById(R.id.bnav_ar_bar_layout);
        this.q = viewGroup;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) (com.baidu.platform.comapi.wnplatform.p.h.c(this.c) * 0.55d);
        layoutParams.addRule(12);
        this.q.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.ar_search_poi);
        this.u = linearLayout;
        linearLayout.setOnClickListener(new aa(this));
        this.l = this.e.findViewById(R.id.small_map_open_bottom_bar);
        this.m = this.e.findViewById(R.id.small_map_close_bottom_bar);
        this.g = (RelativeLayout) this.e.findViewById(R.id.small_map_container);
        this.h = this.e.findViewById(R.id.small_map_arc_layout);
        this.i = this.e.findViewById(R.id.small_map_shadow);
        this.r = this.e.findViewById(R.id.ar_normal_nav_small_map_open);
        this.s = this.e.findViewById(R.id.ar_normal_nav_small_map_close);
        aa aaVar = null;
        this.r.setOnClickListener(new b(this, aaVar));
        this.s.setOnClickListener(new b(this, aaVar));
        e();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = (int) (com.baidu.platform.comapi.wnplatform.p.h.c(this.c) * 0.34d);
        layoutParams2.addRule(12);
        this.h.setLayoutParams(layoutParams2);
        this.j = (RelativeLayout) this.e.findViewById(R.id.small_map_down_arrow);
        this.k = (LinearLayout) this.e.findViewById(R.id.small_map_up_arrow);
        this.n = (TextView) this.e.findViewById(R.id.remain_time_small_map_open);
        this.o = (TextView) this.e.findViewById(R.id.remain_time_small_map_close);
        this.e.findViewById(R.id.ar_close_small_map_open).setOnClickListener(new ah(this));
        this.k.setOnTouchListener(new ai(this));
        this.j.setOnTouchListener(new aj(this));
        LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.ar_close);
        this.p = linearLayout2;
        linearLayout2.setOnClickListener(new ak(this));
        TextView textView = (TextView) this.e.findViewById(R.id.normal_nav_btn_tip);
        this.t = textView;
        textView.setVisibility(8);
    }

    private void e() {
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.ar_status_bar);
        this.w = relativeLayout;
        relativeLayout.setOnTouchListener(new al(this));
        TextView textView = (TextView) this.e.findViewById(R.id.clear_poi);
        this.x = textView;
        textView.setOnClickListener(new am(this));
        this.y = (RelativeLayout) this.e.findViewById(R.id.net_status_bar);
        this.z = (ImageView) this.e.findViewById(R.id.status_icon);
        this.A = (TextView) this.e.findViewById(R.id.status_text);
        ImageView imageView = (ImageView) this.e.findViewById(R.id.status_close);
        this.B = imageView;
        imageView.setOnClickListener(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.c == null) {
            return;
        }
        this.v.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.c, R.anim.wsdk_anim_rg_right_out);
        loadAnimation.setFillAfter(true);
        this.v.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a(true);
        Context context = this.c;
        int i = R.anim.wsdk_anim_small_map_in;
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        loadAnimation.setDuration(400L);
        this.h.setAnimation(loadAnimation);
        this.h.setVisibility(0);
        this.h.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new ad(this));
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.c, i);
        loadAnimation2.setDuration(400L);
        this.l.setVisibility(0);
        this.l.setAnimation(loadAnimation2);
        this.l.startAnimation(loadAnimation2);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.c, R.anim.wsdk_anim_fadeaway);
        this.m.setAnimation(loadAnimation3);
        this.m.startAnimation(loadAnimation3);
        loadAnimation3.setAnimationListener(new ae(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        f9882a++;
        a(false);
        this.i.setVisibility(8);
        Context context = this.c;
        int i = R.anim.wsdk_anim_small_map_out;
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        loadAnimation.setDuration(400L);
        this.h.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new af(this));
        this.h.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.c, R.anim.wsdk_anim_comeout);
        this.m.setVisibility(0);
        this.m.setAnimation(loadAnimation2);
        this.m.startAnimation(loadAnimation2);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.c, i);
        loadAnimation3.setDuration(400L);
        this.l.setAnimation(loadAnimation3);
        this.l.startAnimation(loadAnimation3);
        loadAnimation3.setAnimationListener(new ag(this));
    }

    private void i() {
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o == null || !o.getIsCustomWNaviRgBarLayout()) {
            if (o != null && !o.getIsShowBottomSmallMapUI()) {
                this.f = false;
            } else {
                this.f = true;
            }
        }
    }

    public TextView b() {
        return this.o;
    }

    public void c() {
        this.q.setVisibility(8);
        com.baidu.platform.comapi.walknavi.b.a().a((com.baidu.platform.comapi.wnplatform.f.a().e() & (-3)) | 1, false);
        com.baidu.platform.comapi.walknavi.b.a().O().b("normal_nav_btn_has_click", true);
    }

    private void a(boolean z) {
        if (z) {
            RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.user_npc);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.bottomMargin = (int) (com.baidu.platform.comapi.wnplatform.p.h.c(this.c) * 0.1d);
            layoutParams.topMargin = -((int) (com.baidu.platform.comapi.wnplatform.p.h.c(this.c) * 0.1d));
            relativeLayout.setLayoutParams(layoutParams);
            com.baidu.platform.comapi.walknavi.b.a().N().a(com.baidu.platform.comapi.walknavi.b.a().N().h());
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) this.e.findViewById(R.id.user_npc);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        relativeLayout2.setLayoutParams(layoutParams2);
        com.baidu.platform.comapi.walknavi.b.a().N().a(com.baidu.platform.comapi.walknavi.b.a().N().h());
    }

    public void b(int i) {
        if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            this.q.setVisibility(0);
            if (this.f) {
                g();
            } else {
                h();
            }
            if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
                return;
            }
            this.u.setVisibility(8);
            return;
        }
        h();
        a(false);
        View view = this.m;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public RelativeLayout a(a aVar) {
        this.b = aVar;
        return this.g;
    }

    public TextView a() {
        return this.n;
    }

    public void a(int i) {
        this.E = i;
    }
}
