package com.baidu.navisdk.module.routepreference.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.module.routepreference.views.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class d implements com.baidu.navisdk.module.routepreference.interfaces.b, com.baidu.navisdk.module.routepreference.drivinghabit.a, View.OnClickListener, a.InterfaceC0282a {
    private static final String u = "d";
    private static final int[] v = {R.id.nsdk_route_sort_h1, R.id.nsdk_route_sort_h2, R.id.nsdk_route_sort_h3};

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f7494a;
    private View b;
    private ViewGroup c;
    protected com.baidu.navisdk.module.routepreference.interfaces.a j;
    public int k;
    private com.baidu.navisdk.module.routepreference.drivinghabit.b l;
    private ImageView m;
    private View n;
    private f<String, String> o;
    protected Context q;
    private boolean r;
    private boolean s;
    private View d = null;
    private RecyclerView e = null;
    private TextView f = null;
    private TextView g = null;
    private View h = null;
    private com.baidu.navisdk.module.routepreference.views.c i = null;
    public boolean p = false;
    private final f<String, String> t = new C0283d("BNBaseView-autoHideTask", null);

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.C();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (d.this.i != null) {
                d.this.i.notifyDataSetChanged();
            }
            d.this.D();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.d(true);
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.module.routepreference.views.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0283d extends f<String, String> {
        public C0283d(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.r();
            return null;
        }
    }

    public d(Context context, ViewGroup viewGroup, View view, ViewGroup viewGroup2, com.baidu.navisdk.module.routepreference.interfaces.a aVar, int i) {
        this.f7494a = null;
        this.b = null;
        this.c = null;
        this.k = 2;
        this.s = true;
        this.q = context;
        this.s = com.baidu.navisdk.ui.util.b.b();
        this.b = view;
        this.f7494a = viewGroup2;
        this.c = viewGroup;
        this.j = aVar;
        this.k = i;
    }

    private void A() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.t, false);
    }

    private void B() {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (this.h != null && d()) {
            this.h.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        h(this.k);
        com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.f7494a;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        View view2 = this.d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.baidu.navisdk.module.routepreference.drivinghabit.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
            this.l = null;
        }
    }

    private void E() {
        View view = this.d;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.nsdk_remember_prefer_bubble);
        this.n = findViewById;
        findViewById.setVisibility(0);
        f(-1);
        this.n.setOnClickListener(this);
        this.o = new c("RememberPreferBubbleAutoHide", null);
        com.baidu.navisdk.util.worker.c.a().a(this.o, new e(2, 0), 5000L);
        com.baidu.navisdk.util.statistic.userop.b.r().b("2.i.1.2");
    }

    private void F() {
        View view;
        if (d() && (view = this.h) != null && view.getVisibility() == 0) {
            this.h.setEnabled(true);
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(p());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (!z && this.o != null) {
            com.baidu.navisdk.util.worker.c.a().a((g) this.o, false);
            this.o = null;
        }
        View view = this.n;
        if (view != null) {
            view.setVisibility(8);
            this.n = null;
        }
    }

    private void e(boolean z) {
        if (this.l == null) {
            com.baidu.navisdk.module.routepreference.drivinghabit.b bVar = new com.baidu.navisdk.module.routepreference.drivinghabit.b(this.q, this);
            this.l = bVar;
            bVar.a(this.q, this.c, m(), n());
        }
        com.baidu.navisdk.module.routepreference.drivinghabit.b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.a(this.q, z);
        }
    }

    private Drawable j(int i) {
        if (c()) {
            return com.baidu.navisdk.ui.util.b.c(i, this.s);
        }
        return com.baidu.navisdk.ui.util.b.c(i, true);
    }

    private void k(int i) {
        com.baidu.navisdk.util.worker.c.a().a((g) this.t, false);
        com.baidu.navisdk.util.worker.c.a().a(this.t, new e(2, 0), i);
    }

    public abstract void a(boolean z);

    public abstract void c(int i);

    public abstract void d(int i);

    public abstract void e(int i);

    public abstract void f(int i);

    public abstract void g(int i);

    public void h() {
        View view;
        this.q = null;
        d(false);
        com.baidu.navisdk.module.routepreference.drivinghabit.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
            this.l = null;
        }
        D();
        ViewGroup viewGroup = this.f7494a;
        if (viewGroup != null && (view = this.d) != null) {
            viewGroup.removeView(view);
        }
        View view2 = this.n;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        View view3 = this.h;
        if (view3 != null) {
            view3.setOnClickListener(null);
        }
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.j = null;
        com.baidu.navisdk.module.routepreference.views.c cVar = this.i;
        if (cVar != null) {
            cVar.a();
            this.i = null;
        }
        this.c = null;
        this.b = null;
        this.f7494a = null;
    }

    public void i() {
    }

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> m() {
        return null;
    }

    public int n() {
        return -1;
    }

    public abstract ArrayList<j> o();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.nsdk_remember_route_prefer_switch) {
            boolean t = t();
            boolean z = !t;
            a(z);
            c(z);
            if (!t) {
                d(false);
                int k = k();
                int l = l();
                if ((k & l) != l) {
                    e(k);
                    com.baidu.navisdk.module.routepreference.views.c cVar = this.i;
                    if (cVar != null) {
                        cVar.a(k, k);
                        this.i.notifyDataSetChanged();
                    }
                }
                f(-1);
            }
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String str2 = "" + this.k;
            if (!t) {
                str = "1";
            } else {
                str = "2";
            }
            r.a("2.i.1.1", str2, str, "");
            return;
        }
        if (id == R.id.nsdk_driving_habit_select_enter) {
            e(e());
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.6", null, null, null);
        } else if (id == R.id.nsdk_remember_prefer_bubble) {
            d(false);
        }
    }

    public String p() {
        return null;
    }

    public void q() {
        this.r = false;
        A();
        d(false);
        com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f7494a != null && this.d != null) {
            View view = this.b;
            if (view != null) {
                view.setOnClickListener(null);
            }
            if (e()) {
                Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
                a2.setFillAfter(true);
                a2.setAnimationListener(new b());
                this.f7494a.startAnimation(a2);
            } else {
                com.baidu.navisdk.module.routepreference.views.c cVar = this.i;
                if (cVar != null) {
                    cVar.notifyDataSetChanged();
                }
                D();
            }
            this.p = false;
        }
    }

    public void r() {
        com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    public abstract void s();

    public abstract boolean t();

    public boolean u() {
        return false;
    }

    public abstract boolean v();

    public boolean w() {
        return this.r;
    }

    public boolean x() {
        boolean y = y();
        if (!y && this.r) {
            h(this.k);
            q();
            return true;
        }
        return y;
    }

    public boolean y() {
        com.baidu.navisdk.module.routepreference.drivinghabit.b bVar = this.l;
        if (bVar != null) {
            return bVar.b();
        }
        return false;
    }

    public boolean z() {
        this.r = true;
        if (this.f7494a == null || this.d == null) {
            return false;
        }
        if (g()) {
            k(10000);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
            this.b.setOnClickListener(new a());
        }
        this.d.setVisibility(0);
        a((Bundle) null);
        if (e()) {
            this.f7494a.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
        }
        this.f7494a.setVisibility(0);
        F();
        if (v()) {
            E();
        }
        com.baidu.navisdk.module.routepreference.views.c cVar = this.i;
        if (cVar != null) {
            cVar.a(k(), l());
            this.i.notifyDataSetChanged();
        }
        s();
        return true;
    }

    private boolean b(int i, int i2, int i3, int i4) {
        Context context = this.q;
        if (context == null || this.f7494a == null) {
            return false;
        }
        try {
            JarUtils.inflate(context, b(), this.f7494a);
            this.d = this.f7494a.findViewById(R.id.nsdk_route_sort_panel_layout);
        } catch (Exception unused) {
            this.d = null;
        }
        View view = this.d;
        if (view == null) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.d.setLayoutParams(marginLayoutParams);
        }
        this.e = (RecyclerView) this.d.findViewById(R.id.nsdk_route_sort_gv);
        this.f = (TextView) this.d.findViewById(R.id.nsdk_route_sort_title_tv);
        if (this.e != null) {
            int j = j();
            com.baidu.navisdk.module.routepreference.views.a.g = j;
            this.e.setLayoutManager(new GridLayoutManager(this.q, j));
            if (this.i == null) {
                com.baidu.navisdk.module.routepreference.views.c cVar = new com.baidu.navisdk.module.routepreference.views.c(this.q, this, o(), k(), l());
                this.i = cVar;
                cVar.a(this);
            }
            this.e.setAdapter(this.i);
            this.i.a(o());
        }
        View findViewById = this.d.findViewById(R.id.nsdk_remember_route_prefer_item);
        View findViewById2 = this.d.findViewById(R.id.nsdk_route_sort_h3);
        if (a()) {
            findViewById.setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            this.m = (ImageView) this.d.findViewById(R.id.nsdk_remember_route_prefer_switch);
            c(t());
        } else {
            findViewById.setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        }
        View findViewById3 = this.d.findViewById(R.id.nsdk_route_sort_h2);
        this.h = this.d.findViewById(R.id.nsdk_driving_habit_select_enter);
        this.g = (TextView) this.d.findViewById(R.id.nsdk_route_sort_select_prefer_sub_title);
        if (d() && u()) {
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            this.h.setVisibility(0);
        } else {
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            this.h.setVisibility(8);
        }
        if (!LogUtil.LOGGABLE) {
            return true;
        }
        LogUtil.e(u, "RouteSort getSinglePreferValue");
        return true;
    }

    private void c(boolean z) {
        ImageView imageView = this.m;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkin_icon));
            } else {
                imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_set_checkout_icon));
            }
        }
    }

    private int i(int i) {
        if (c()) {
            return com.baidu.navisdk.ui.util.b.a(i, this.s);
        }
        return com.baidu.navisdk.ui.util.b.a(i, true);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (b(i, i2, i3, i4)) {
            B();
            b(com.baidu.navisdk.ui.util.b.b());
        }
    }

    public void a(Bundle bundle) {
        TextView textView = this.f;
        if (textView != null) {
            try {
                textView.setText(JarUtils.getResources().getString(R.string.nsdk_string_route_sort_title));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.drivinghabit.a
    public void a(int i) {
        com.baidu.navisdk.module.routepreference.views.c cVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(u, "onDrivingHabitChange prefer: " + i);
        }
        g(i);
        boolean z = true;
        int i2 = (k() & 32) != 0 ? 33 : 1;
        d(i2);
        if ((l() & 1) != 1) {
            e(i2);
        } else {
            z = false;
        }
        if (f() && (cVar = this.i) != null) {
            cVar.a(i2, l());
            this.i.notifyDataSetChanged();
            F();
        }
        com.baidu.navisdk.module.routepreference.interfaces.a aVar = this.j;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    private void h(int i) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.1", "0", "" + i, null);
    }

    public void b(boolean z) {
        this.s = z;
        if (c()) {
            View view = this.d;
            if (view != null) {
                view.setBackgroundDrawable(j(R.drawable.nsdk_layout_route_sort_background));
                for (int i : v) {
                    View findViewById = this.d.findViewById(i);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(i(R.color.nsdk_cl_bg_d_mm));
                    }
                }
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setTextColor(i(R.color.nsdk_route_sort_title));
                this.f.setCompoundDrawablesWithIntrinsicBounds(j(R.drawable.nsdk_route_sort_setting_title_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.views.a.InterfaceC0282a
    public void b(int i) {
        com.baidu.navisdk.module.routepreference.views.c cVar;
        c(i);
        if (!f() || (cVar = this.i) == null) {
            return;
        }
        cVar.a(i, l());
        this.i.notifyDataSetChanged();
    }
}
