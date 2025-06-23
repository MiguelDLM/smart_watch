package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class n0 {
    private static final String A = "n0";

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f8830a;
    private ViewGroup b;
    private WindowManager.LayoutParams c;
    private WindowManager d;
    private TextView l;
    private TextView m;
    private TextView p;
    private int r;
    private float s;
    private float t;
    private float u;
    private float v;
    private View e = null;
    private View f = null;
    private View g = null;
    private TextView h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private TextView n = null;
    private TextView o = null;
    private ImageView q = null;
    private boolean w = false;
    private float x = 0.0f;
    private float y = 0.0f;
    private boolean z = false;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.x.3");
            n0.this.a();
            com.baidu.navisdk.module.pronavi.model.h.d = true;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.ui.util.g.a()) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.x.4");
            com.baidu.navisdk.framework.b.X();
            n0.this.a();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return n0.this.a(motionEvent);
        }
    }

    public n0() {
        g();
        h();
        f();
    }

    private void f() {
        ViewGroup viewGroup = (ViewGroup) JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_layout_rg_mapmode_floatview_layout, null);
        this.f8830a = viewGroup;
        this.e = viewGroup.findViewById(R.id.bnav_rg_float_direction_mode);
        this.f = this.f8830a.findViewById(R.id.bnav_rg_float_along_mode);
        this.g = this.f8830a.findViewById(R.id.bnav_rg_float_fuzzy_mode);
        this.b = (ViewGroup) this.f8830a.findViewById(R.id.bnav_rg_floatview_content);
        this.q = (ImageView) this.f8830a.findViewById(R.id.bnav_rg_float_turn_icon);
        this.k = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_after_meters_multi_tv);
        this.m = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_go_where_multi_tv);
        this.l = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_after_label_info);
        this.n = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_ic_code);
        this.o = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_direction);
        this.h = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_cur_road_name_tv);
        this.i = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_cur_road_remain_dist_tv);
        this.j = (TextView) this.f8830a.findViewById(R.id.bnav_rg_float_cur_road_remain_dist_word);
        this.p = (TextView) this.g.findViewById(R.id.bnav_rg_float_fuzzy_tv);
        this.f8830a.findViewById(R.id.bnav_rg_float_control_panel_close).setOnClickListener(new a());
        this.f8830a.setOnClickListener(new b());
    }

    private void g() {
        this.c = new WindowManager.LayoutParams();
        this.d = (WindowManager) com.baidu.navisdk.framework.a.c().a().getSystemService("window");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.c.type = 2038;
        } else if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && i >= 24) {
            this.c.type = 2002;
        } else if (i >= 25) {
            this.c.type = 2002;
        } else {
            this.c.type = 2005;
        }
        WindowManager.LayoutParams layoutParams = this.c;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_25dp);
        WindowManager.LayoutParams layoutParams2 = this.c;
        layoutParams2.y = 0;
        layoutParams2.width = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_196dp);
        this.c.height = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_52dp);
    }

    private void h() {
        this.r = ScreenUtil.getInstance().dip2px(4);
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        aVar.e();
        aVar.d();
    }

    private void i() {
    }

    private int j() {
        String g;
        if (com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
            g = com.baidu.navisdk.ui.routeguide.holder.a.d().b();
        } else {
            g = com.baidu.navisdk.ui.routeguide.model.a0.I().g();
        }
        this.p.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, g));
        this.q.setImageResource(R.drawable.bnav_drawable_set_off);
        return 2;
    }

    private void k() {
        WindowManager.LayoutParams layoutParams = this.c;
        layoutParams.x = (int) (this.u - this.s);
        layoutParams.y = (int) (this.v - this.t);
        try {
            this.d.updateViewLayout(this.f8830a, layoutParams);
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.w;
    }

    public boolean c() {
        LogUtil.e(A, "show :" + b());
        if (b()) {
            return true;
        }
        try {
            if (!com.baidu.navisdk.module.pronavi.model.h.e) {
                com.baidu.navisdk.module.pronavi.model.h.e = true;
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.x.2");
            }
            d();
            this.f8830a.setOnTouchListener(new c());
            this.d.addView(this.f8830a, this.c);
            this.w = true;
            return true;
        } catch (Exception e) {
            LogUtil.e(A, "float excetion e:" + e.getMessage());
            this.w = false;
            return false;
        }
    }

    public void d() {
        if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            a((Bundle) null, true);
        } else {
            a(com.baidu.navisdk.ui.routeguide.model.a0.I().h(), false);
        }
    }

    public int e() {
        String j = com.baidu.navisdk.ui.routeguide.model.m.y().j();
        String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(j);
        String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(j);
        String a3 = com.baidu.navisdk.ui.routeguide.model.m.y().a();
        boolean y = com.baidu.navisdk.ui.routeguide.model.a0.I().y();
        try {
            this.q.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
        } catch (Throwable unused) {
        }
        if (a3 == null) {
            TextView textView = this.h;
            if (textView != null) {
                textView.setText(com.baidu.navisdk.ui.routeguide.model.m.y().b());
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setText(b2);
            }
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setText(a2);
            }
            TextView textView4 = this.o;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            i();
            return 1;
        }
        TextView textView5 = this.k;
        if (textView5 != null && this.l != null && b2 != null && a2 != null) {
            if (y) {
                textView5.setText("现在");
                this.l.setText("");
            } else {
                textView5.setText(b2);
                this.l.setText(a2 + "后");
            }
        }
        TextView textView6 = this.m;
        if (textView6 != null) {
            textView6.setText(a(ScreenUtil.getInstance().dip2px(72), a3));
            this.m.setVisibility(0);
        }
        TextView textView7 = this.o;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        i();
        return 0;
    }

    public void a(Bundle bundle, boolean z) {
        int a2;
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
            a2 = j();
        } else if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
            a2 = j();
        } else if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            if (!z) {
                return;
            } else {
                a2 = e();
            }
        } else {
            if (z) {
                return;
            }
            if (bundle == null) {
                bundle = com.baidu.navisdk.ui.routeguide.model.a0.I().h();
            }
            a2 = a(bundle);
        }
        if (a2 == 0 || 3 == a2) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        } else if (1 == a2) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
        } else if (2 == a2) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(0);
        }
        this.b.requestLayout();
        this.b.invalidate();
    }

    private String a(int i, String str) {
        int lastIndexOf;
        TextView textView = this.m;
        return (textView == null || com.baidu.navisdk.ui.util.j.a(textView, i, str, 1) || (lastIndexOf = str.lastIndexOf(" ")) < 0) ? str : a(i, str.substring(0, lastIndexOf));
    }

    public int a(Bundle bundle) {
        TextView textView;
        if (bundle.getInt("updatetype") != 1) {
            return -1;
        }
        boolean z = bundle.getBoolean("remain_dist_hide", false);
        int i = bundle.getInt("resid", 0);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
        String string = bundle.getString("road_name");
        if (string == null || string.length() == 0) {
            string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
        }
        if (i != 0) {
            try {
                this.q.setImageDrawable(JarUtils.getResources().getDrawable(i));
            } catch (OutOfMemoryError unused) {
            }
        }
        String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(i2);
        String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(a2);
        String a3 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(a2);
        if (this.k != null && this.l != null && b2 != null && a3 != null) {
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().q()) {
                try {
                    this.q.setImageDrawable(null);
                } catch (Throwable unused2) {
                }
                this.k.setText("");
                this.l.setText("当前行驶在");
                this.m.setText("无数据道路上");
                return 3;
            }
            if (z) {
                this.k.setText("现在");
                this.l.setText("");
            } else {
                this.k.setText(b2);
                this.l.setText(a3 + "后");
            }
        }
        String c2 = com.baidu.navisdk.ui.routeguide.model.a0.I().c(string);
        if (c2 != null && (textView = this.m) != null && !textView.getText().equals(c2)) {
            this.m.setText(c2);
        }
        String string2 = bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName);
        TextView textView2 = this.h;
        if (textView2 != null && string2 != null && !string2.equals(textView2.getText())) {
            this.h.setText(string2);
        }
        TextView textView3 = this.i;
        if (textView3 != null && b2 != null) {
            textView3.setText(b2);
        }
        TextView textView4 = this.j;
        if (textView4 != null && a3 != null) {
            textView4.setText(a3);
        }
        TextView textView5 = this.n;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.o;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.I().C()) {
            return 0;
        }
        try {
            this.q.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
        } catch (Throwable unused3) {
        }
        return 1;
    }

    public void a() {
        LogUtil.e(A, "hide");
        try {
            ViewGroup viewGroup = this.f8830a;
            if (viewGroup != null && viewGroup.getParent() != null) {
                this.d.removeView(this.f8830a);
            }
            this.w = false;
        } catch (Exception e) {
            LogUtil.e(A, "hide float excetion e:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.s = motionEvent.getX();
            this.t = motionEvent.getY();
            this.x = motionEvent.getRawX();
            this.y = motionEvent.getRawY();
            this.z = false;
            return false;
        }
        if (action == 1) {
            k();
            return this.z;
        }
        if (action != 2) {
            return false;
        }
        this.u = motionEvent.getRawX();
        this.v = motionEvent.getRawY() - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
        if (Math.abs(this.x - motionEvent.getRawX()) > this.r || Math.abs(this.y - motionEvent.getRawY()) > this.r) {
            this.z = true;
        }
        k();
        return false;
    }
}
