package com.baidu.navisdk.module.routepreference.drivinghabit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.drivinghabit.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b implements d.a {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f7477a;
    private View b;
    private ViewGroup c;
    private d[] e;
    private int f;
    private int g;
    private final com.baidu.navisdk.module.routepreference.drivinghabit.a i;
    private View d = null;
    private boolean h = false;
    private boolean j = true;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.d();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.baidu.navisdk.module.routepreference.drivinghabit.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0281b implements View.OnClickListener {
        public ViewOnClickListenerC0281b(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.b();
        }
    }

    public b(Context context, com.baidu.navisdk.module.routepreference.drivinghabit.a aVar) {
        b(context);
        this.i = aVar;
    }

    private boolean b(Context context) {
        try {
            this.b = JarUtils.inflate(context, R.layout.nsdk_layout_route_sort_driving_habit, null);
        } catch (Exception unused) {
            this.b = null;
        }
        View view = this.b;
        if (view == null) {
            return false;
        }
        view.setOnClickListener(new ViewOnClickListenerC0281b(this));
        this.c = (ViewGroup) this.b.findViewById(R.id.nsdk_driving_habit_parent_view);
        View findViewById = this.b.findViewById(R.id.nsdk_driving_habit_back_img);
        this.d = findViewById;
        findViewById.setOnClickListener(new c());
        return true;
    }

    private void c() {
        if (!x.t()) {
            com.baidu.navisdk.framework.b.f(true);
        }
        if (this.j) {
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
            a2.setFillAfter(true);
            a2.setAnimationListener(new a());
            this.b.startAnimation(a2);
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h = false;
        ViewGroup viewGroup = this.f7477a;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void a(Context context, ViewGroup viewGroup, ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList, int i) {
        if (context == null || arrayList == null || arrayList.isEmpty() || viewGroup == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMRouteSortView", "initDataAndLoadView preferValue: " + i);
        }
        this.f = i;
        this.g = i;
        int size = arrayList.size();
        this.e = new d[size];
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.navisdk.module.routepreference.drivinghabit.c cVar = arrayList.get(i2);
            a(context);
            a(context, cVar);
            d dVar = new d(cVar.c);
            dVar.a(this);
            dVar.a(context, this.c, cVar.d, this.f);
            this.e[i2] = dVar;
        }
        this.f7477a = viewGroup;
        viewGroup.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean b() {
        if (!this.h) {
            return false;
        }
        if (this.i != null && this.g != this.f) {
            this.j = false;
            c();
            this.i.a(this.g);
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.8", "" + this.g, null, null);
            return true;
        }
        c();
        return true;
    }

    public void a(Context context, boolean z) {
        if (context == null || this.f7477a == null || this.b == null) {
            return;
        }
        this.j = z;
        if (!x.t()) {
            com.baidu.navisdk.framework.b.a();
            com.baidu.navisdk.framework.b.f(false);
        }
        this.h = true;
        this.f7477a.setVisibility(0);
        if (z) {
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L);
            a2.setAnimationListener(null);
            this.b.startAnimation(a2);
        }
        this.b.setVisibility(0);
    }

    private void a(Context context, com.baidu.navisdk.module.routepreference.drivinghabit.c cVar) {
        View inflate;
        if (context == null || cVar == null || (inflate = JarUtils.inflate(context, R.layout.nsdk_layout_route_sort_habit_title_item, null)) == null) {
            return;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.nsdk_driving_habit_item_title_tv);
        TextView textView2 = (TextView) inflate.findViewById(R.id.nsdk_driving_habit_item_title_summary_tv);
        textView.setText(cVar.f7480a);
        textView2.setText(cVar.b);
        this.c.addView(inflate, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_60dp)));
    }

    private void a(Context context) {
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_route_sort_habit_page_split_line, null);
        if (inflate == null) {
            return;
        }
        this.c.addView(inflate, new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp)));
    }

    public void a() {
        View view;
        if (!x.t()) {
            com.baidu.navisdk.framework.b.f(true);
        }
        d();
        ViewGroup viewGroup = this.f7477a;
        if (viewGroup != null && (view = this.b) != null) {
            viewGroup.removeView(view);
            this.f7477a = null;
        }
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            this.c = null;
        }
        d[] dVarArr = this.e;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.a();
                }
            }
            this.e = null;
        }
        this.h = false;
    }

    @Override // com.baidu.navisdk.module.routepreference.drivinghabit.d.a
    public void a(boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMRouteSortView", "onSelectedChange start isSelected: " + z + ", preferValue:" + i + "mCurrentSelectedPreferValue:" + this.g);
        }
        if (z) {
            this.g |= i;
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.7", "" + i, null, null);
        } else {
            this.g ^= i;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMRouteSortView", "onSelectedChange end mCurrentSelectedPreferValue: " + this.g);
        }
    }
}
