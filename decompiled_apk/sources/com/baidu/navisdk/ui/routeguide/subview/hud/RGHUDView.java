package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.l;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class RGHUDView extends LinearLayout {
    private RelativeLayout A;
    private int B;
    private int C;
    private View D;
    private View E;
    private int F;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9090a;
    private ViewGroup b;
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private RelativeLayout h;
    private TextView i;
    private TextView j;
    private RelativeLayout k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private CircleProgressImageView r;
    private CircleProgressImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private RelativeLayout x;
    private RelativeLayout y;
    private RelativeLayout z;

    public RGHUDView(Context context) {
        super(context);
        this.B = 42;
        this.C = 38;
        this.F = -1;
        e();
    }

    private void e() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (1 == x.b().d0()) {
            this.b = (ViewGroup) JarUtils.inflate(getContext(), R.layout.nsdk_layout_rg_hud_view, null);
        } else {
            this.b = (ViewGroup) JarUtils.inflate(getContext(), R.layout.nsdk_layout_rg_hud_view_land, null);
        }
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 == null) {
            return;
        }
        addView(viewGroup2, new LinearLayout.LayoutParams(-1, -1));
        a();
    }

    private int getCurrentOrientation() {
        return x.b().d0();
    }

    public void a() {
        ViewGroup viewGroup = this.b;
        int i = R.id.nav_hud_ui;
        this.x = (RelativeLayout) viewGroup.findViewById(i);
        this.c = (RelativeLayout) this.b.findViewById(R.id.rl_bnav_simle_not_along);
        this.d = (ImageView) this.b.findViewById(R.id.bnav_rg_sg_turn_icon);
        this.e = (TextView) this.b.findViewById(R.id.bnav_rg_sg_after_meters_info);
        this.g = (TextView) this.b.findViewById(R.id.bnav_rg_sg_after_label_info);
        this.f = (TextView) this.b.findViewById(R.id.bnav_rg_sg_go_where_info);
        this.h = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_sg_along_road);
        this.i = (TextView) this.b.findViewById(R.id.bnav_rg_sg_cur_road_remain_dist_tv);
        this.j = (TextView) this.b.findViewById(R.id.bnav_rg_sg_cur_road_name_tv);
        this.k = (RelativeLayout) this.b.findViewById(R.id.ll_bnav_hw);
        this.l = (ImageView) this.b.findViewById(R.id.bnav_rg_hw_turn_icon);
        this.m = (TextView) this.b.findViewById(R.id.bnav_rg_hw_after_meters_info);
        this.n = (TextView) this.b.findViewById(R.id.bnav_rg_hw_ic_code);
        this.o = (TextView) this.b.findViewById(R.id.bnav_rg_hw_go_to_word);
        this.p = (TextView) this.b.findViewById(R.id.bnav_rg_hw_enter_word);
        this.q = (TextView) this.b.findViewById(R.id.bnav_rg_hw_go_where_multi_tv);
        this.w = (TextView) this.b.findViewById(R.id.bnav_rg_hw_after_meters_lable);
        this.r = (CircleProgressImageView) this.b.findViewById(R.id.bnav_rg_cur_car_speed_progress);
        this.s = (CircleProgressImageView) this.b.findViewById(R.id.bnav_rg_left_distance_progress);
        this.t = (TextView) this.b.findViewById(R.id.bnav_rg_current_speed);
        this.u = (TextView) this.b.findViewById(R.id.bnav_rg_left_distance);
        this.v = (TextView) this.b.findViewById(R.id.bnav_rg_about_reach_time);
        if (getCurrentOrientation() == 2) {
            this.y = (RelativeLayout) this.b.findViewById(R.id.rl_bnav_rg_hud_speed);
            this.z = (RelativeLayout) this.b.findViewById(R.id.rl_nsdk_rg_hud_left_distance);
        }
        this.A = (RelativeLayout) this.b.findViewById(R.id.rl_bnav_rg_hud_yaw);
        this.D = this.b.findViewById(R.id.nav_hud_gps_status);
        this.E = this.b.findViewById(i);
    }

    public void b(boolean z) {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.q.setVisibility(0);
        if (z) {
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.p.setVisibility(0);
        } else {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public void c(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
    }

    public void d(boolean z) {
        int i = !z ? 0 : 8;
        if (getCurrentOrientation() == 2) {
            this.y.setVisibility(i);
            this.z.setVisibility(i);
        }
        this.x.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f9090a) {
            canvas.translate(0.0f, getMeasuredHeight());
            canvas.scale(1.0f, -1.0f);
        }
        super.dispatchDraw(canvas);
    }

    public void f(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        this.c.setVisibility(i);
    }

    public void setDirectCurrentRoad(String str) {
        if (!str.equals(this.j.getText().toString())) {
            this.j.setText(str);
        }
    }

    public void setDirectDistance(String str) {
        if (!str.equals(this.i.getText().toString())) {
            this.i.setText(str);
        }
    }

    public void setDirection(String str) {
    }

    public void setHighWayExitCode(String str) {
        if (!str.equals(this.n.getText().toString())) {
            this.n.setText(str);
        }
    }

    public void setHighWayExitRoad(String str) {
        if (!str.equals(this.q.getText().toString())) {
            this.q.setText(str);
        }
    }

    public void setHighWayRemainDistance(String str) {
        if (!str.equals(this.m)) {
            if ("0米".equals(str)) {
                this.m.setText("现在");
                this.w.setText("");
            } else {
                this.m.setText(str);
                this.w.setText("后");
            }
        }
    }

    public void setHighWayTurnIcon(int i) {
        if (i != this.F) {
            this.F = i;
            this.l.setImageDrawable(m.y().a(i, true));
        }
    }

    public void setMirror(boolean z) {
        this.f9090a = z;
    }

    public void setNormalCurrentRoad(String str) {
        if (!str.equals(this.f.getText().toString())) {
            this.f.setText(str);
        }
    }

    public void setNormalGoMeters(String str) {
        if ("0米".equals(str)) {
            this.e.setText("现在");
            this.g.setText("");
        } else {
            this.e.setText(str);
            this.g.setText("后");
        }
    }

    public void setNormalTurnIcon(int i) {
        if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
            this.d.setImageDrawable(JarUtils.getResources().getDrawable(i));
        } else {
            this.d.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i));
        }
    }

    public void c() {
        if (this.t != null) {
            this.r.setMainProgress(l.a(g.o().c(), 240));
            this.r.setSubProgress(240);
            this.t.setText(g.o().b());
        }
    }

    public void d() {
        if (this.v != null) {
            this.v.setText(String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_hud_arrive_time), a0.I().b()));
        }
        if (this.u != null) {
            int l = a0.I().l();
            if (l / 1000 >= 1000) {
                this.u.setTextSize(this.C);
            } else {
                this.u.setTextSize(this.B);
            }
            int a2 = l.a(l, l.e);
            if (l < 50) {
                this.s.setMainProgress(0);
            } else {
                this.s.setMainProgress(a2);
            }
            this.s.setSubProgress(100);
            this.u.setText(l.a(l));
        }
    }

    public RGHUDView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = 42;
        this.C = 38;
        this.F = -1;
        e();
    }

    public void e(boolean z) {
        LogUtil.e(RGFSMTable.FsmState.HUD, "updateHudYaw-> isYaw= " + z);
        if (z) {
            d(z);
            this.A.setVisibility(0);
        } else {
            d(z);
            this.A.setVisibility(8);
        }
    }

    public void b() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (getCurrentOrientation() == 1) {
            JarUtils.inflate(getContext(), R.layout.nsdk_layout_rg_hud_view, this.b);
            a();
        } else {
            JarUtils.inflate(getContext(), R.layout.nsdk_layout_rg_hud_view_land, this.b);
            a();
        }
    }

    public void a(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }
}
