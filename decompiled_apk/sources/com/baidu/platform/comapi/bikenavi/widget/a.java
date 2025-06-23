package com.baidu.platform.comapi.bikenavi.widget;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.bikenavi.model.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.wnplatform.p.g;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.walknavi.h.c.b implements View.OnClickListener {
    private static int H = 135;
    private static int I = 90;
    private static int l;
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private int G;

    /* renamed from: a, reason: collision with root package name */
    private Activity f9557a;
    private int e;
    private com.baidu.platform.comapi.bikenavi.c.b g;
    private ImageView h;
    private ImageView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private RelativeLayout m;
    private CustomScrollView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private View t;
    private View u;
    private ImageView v;
    private ImageView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private final int b = 1;
    private final int c = 2;
    private final int d = 3;
    private boolean f = false;
    private int J = 0;
    private boolean K = true;
    private a.b L = null;
    private boolean M = false;
    private a.C0132a N = null;
    private boolean O = false;
    private boolean P = true;

    /* renamed from: com.baidu.platform.comapi.bikenavi.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0526a implements View.OnClickListener {
        public ViewOnClickListenerC0526a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.r) {
                return;
            }
            if (a.this.f) {
                if (a.this.r != null) {
                    a.this.r.setText(RGFSMTable.FsmEvent.CONTINUE_NAVI);
                }
                a.this.f = !r8.f;
                com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.overview");
                com.baidu.platform.comapi.walknavi.b.a().M().run("[查看全览]按钮点击");
                a.this.s.setVisibility(8);
                a.this.g.m();
                a.this.i();
                a.this.g.a(a.this.f9557a, com.baidu.platform.comapi.walknavi.b.a().N().a(), 10, 0, 0, a.H + a.l + 10);
            } else {
                if (a.this.r != null) {
                    a.this.r.setText("查看全览");
                }
                a.this.f = !r8.f;
                com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.continue");
                com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
                a.this.s.setVisibility(0);
                com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
                com.baidu.platform.comapi.walknavi.b.a().K().j();
                a.this.h();
                a.this.g.a(a.this.f9557a, com.baidu.platform.comapi.walknavi.b.a().N().a(), 70, 0, 0, a.l + 60);
            }
            if (com.baidu.platform.comapi.walknavi.b.a().N().a() != null) {
                com.baidu.platform.comapi.walknavi.b.a().N().a().requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AsyncTask<Integer, Integer, String> {
        private ScrollView b;
        private boolean c;
        private int d = 15;

        public b(ScrollView scrollView, boolean z) {
            this.b = scrollView;
            this.c = z;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Integer... numArr) {
            try {
                int i = 153;
                if (this.c) {
                    int i2 = 0;
                    while (i2 < 153) {
                        i2 += this.d;
                        publishProgress(Integer.valueOf(i2));
                        Thread.sleep(10L);
                    }
                    return null;
                }
                while (i > 0) {
                    i -= this.d;
                    if (i < 0) {
                        i = 0;
                    }
                    publishProgress(Integer.valueOf(i));
                    Thread.sleep(10L);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            try {
                int intValue = numArr[0].intValue();
                String hexString = Integer.toHexString(intValue);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                String str = xoXoI.f2670oxoX + hexString + "000000";
                com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "onProgressUpdate:" + str + "alpha:" + intValue);
                this.b.setBackgroundColor(Color.parseColor(str));
                a.this.J = intValue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.f9557a = (Activity) context;
        this.g = bVar;
        a(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bikenavi_btn_location) {
            if (!this.f) {
                com.baidu.platform.comapi.wnplatform.m.a.a().a("status", "overview");
            }
            com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.turnDire");
            int i = this.e;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR);
                        return;
                    }
                    return;
                }
                com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D);
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
        }
    }

    private void f(View view) {
        this.n = (CustomScrollView) view.findViewById(R.id.vw_scroll);
        view.post(new c(this));
        View a2 = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.f9557a, R.layout.wsdk_layout_bikenavi_drawer, null);
        this.u = a2;
        this.n.addContentView(a2);
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.BOTTOM, false);
        this.v = (ImageView) this.u.findViewById(R.id.icon_arrow_up);
        this.w = (ImageView) this.u.findViewById(R.id.icon_arrow_down);
        this.x = (TextView) this.u.findViewById(R.id.drawer_curspeed);
        this.y = (TextView) this.u.findViewById(R.id.drawer_avgspeed);
        this.z = (TextView) this.u.findViewById(R.id.drawer_maxspeed);
        this.A = (TextView) this.u.findViewById(R.id.drawer_remain_dist);
        this.B = (TextView) this.u.findViewById(R.id.drawer_remain_time);
        this.C = (TextView) this.u.findViewById(R.id.drawer_calorie);
        this.D = (TextView) this.u.findViewById(R.id.drawer_altiDiff);
        this.E = (TextView) this.u.findViewById(R.id.drawer_altitude);
        this.F = (TextView) this.u.findViewById(R.id.drawer_progress_info_tv);
        View findViewById = this.u.findViewById(R.id.drawer_header);
        this.t = findViewById;
        findViewById.setOnClickListener(new d(this));
        this.n.setOnScrollChangeListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.n.setVisibility(8);
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && !q.getShowSpeedLayout()) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.n.setBackgroundColor(Color.parseColor("#00000000"));
        this.J = 0;
        d(false);
        this.n.setVisibility(0);
        this.q.setVisibility(8);
    }

    private void j() {
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q == null || q.getBikeNaviTypeface() == null) {
            return;
        }
        TextView textView = this.o;
        if (textView != null) {
            textView.setTypeface(q.getBikeNaviTypeface());
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setTypeface(q.getBikeNaviTypeface());
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setTypeface(q.getBikeNaviTypeface());
        }
        TextView textView4 = this.s;
        if (textView4 != null) {
            textView4.setTypeface(q.getBikeNaviTypeface());
        }
    }

    private void e(View view) {
        if (view != null) {
            this.q = (LinearLayout) view.findViewById(R.id.speed_layout);
            BNavigatorWrapper.getWNavigator();
            BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
            if (q != null && !q.getShowSpeedLayout()) {
                this.q.setVisibility(8);
            }
            if (q != null && q.isUseCustomSpeedLayout()) {
                if (b(q)) {
                    return;
                }
                this.o = (TextView) view.findViewById(R.id.speed_tv);
                this.p = (TextView) view.findViewById(R.id.tv_speed_unit);
                return;
            }
            this.o = (TextView) view.findViewById(R.id.speed_tv);
            this.p = (TextView) view.findViewById(R.id.tv_speed_unit);
        }
    }

    private void a(View view) {
        this.h = (ImageView) view.findViewById(R.id.bikenavi_btn_location);
        BNavigatorWrapper.getWNavigator();
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && !q.getShowImageToLocation()) {
            this.h.setVisibility(8);
        }
        e(view);
        b(view);
        f(view);
        this.h.setOnClickListener(this);
        this.r.setOnClickListener(new ViewOnClickListenerC0526a());
        this.i.setOnClickListener(new com.baidu.platform.comapi.bikenavi.widget.b(this));
        j();
    }

    private void b(View view) {
        if (view != null) {
            c(view);
            this.j = (RelativeLayout) view.findViewById(R.id.bikenav_bottom_bar_layout);
            BNavigatorWrapper.getWNavigator();
            BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
            if (q != null && q.isUseCustomBottomSetting()) {
                if (a(q)) {
                    return;
                }
                d(view);
                return;
            }
            d(view);
            if (q != null && !q.getIsShowBottomGuideLayout()) {
                this.j.setVisibility(8);
                this.P = false;
            } else {
                this.P = true;
            }
        }
    }

    private void c(View view) {
        this.k = (RelativeLayout) view.findViewById(R.id.sync_view);
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q == null || q.getCustomBottomView() == null) {
            return;
        }
        this.k.addView(q.getCustomBottomView());
        l = q.getBottomViewHeight();
        this.k.setVisibility(0);
    }

    private void d(View view) {
        if (view != null) {
            this.i = (ImageView) view.findViewById(R.id.bikenavi_btn_back);
            this.r = (TextView) view.findViewById(R.id.bikenavi_btn_lookover);
            this.s = (TextView) view.findViewById(R.id.bikenavi_overview_remain_info_tv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.BOTTOM, z);
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.smallDrawer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.n.updateStatus(com.baidu.platform.comapi.wnplatform.o.b.TOP, z);
        this.v.setVisibility(8);
        this.w.setVisibility(0);
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.bigDrawer");
    }

    private boolean a(BikeNaviDisplayOption bikeNaviDisplayOption) {
        if (bikeNaviDisplayOption == null) {
            Log.e("CustomWNaviView", "Load BottomSetting layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int bottomSettingLayout = bikeNaviDisplayOption.getBottomSettingLayout();
        if (bottomSettingLayout == 0) {
            Log.e("CustomWNaviView", "BottomSetting layout resource is empty.");
            return false;
        }
        if (this.j == null) {
            Log.e("CustomWNaviView", "BottomSetting layout add failed.");
            return false;
        }
        View inflate = LayoutInflater.from(this.f9557a).inflate(bottomSettingLayout, (ViewGroup) this.j, false);
        if (inflate == null) {
            Log.e("CustomWNaviView", "Load BottomSetting layout failed,please checking layout.");
            return false;
        }
        if (!com.baidu.platform.comapi.walknavi.h.d.b.a().a(this.f9557a, 6, bottomSettingLayout, this)) {
            Log.e("CustomWNaviView", "Parser BottomSetting layout failed,please checking layout.");
            return false;
        }
        a.C0132a c0132a = this.N;
        if (c0132a == null) {
            Log.e("CustomWNaviView", "Parser BottomSetting layout failed,missing other keywords like TAG attribute or ID attribute.");
            return false;
        }
        if (!TextUtils.isEmpty(c0132a.a()) && !TextUtils.isEmpty(this.N.b()) && !TextUtils.isEmpty(this.N.c())) {
            try {
                this.i = (ImageView) inflate.findViewById(Integer.parseInt(this.N.a().replace("@", "")));
                this.r = (TextView) inflate.findViewById(Integer.parseInt(this.N.b().replace("@", "")));
                TextView textView = (TextView) inflate.findViewById(Integer.parseInt(this.N.c().replace("@", "")));
                this.s = textView;
                if (this.i != null && this.r != null && textView != null) {
                    this.j.removeAllViews();
                    this.j.addView(inflate);
                    this.O = true;
                    this.j.setBackgroundColor(0);
                    return true;
                }
                Log.e("CustomWNaviView", "BottomSetting layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("CustomWNaviView", "BottomSetting layout control type error.");
                return false;
            }
        }
        Log.e("CustomWNaviView", "BottomSetting layout missing other keywords like TAG attribute or ID attribute.");
        return false;
    }

    private boolean b(BikeNaviDisplayOption bikeNaviDisplayOption) {
        if (bikeNaviDisplayOption == null) {
            Log.e("CustomWNaviView", "Load BikeSpeed layout failed,BikeNaviDisplayOption is null.");
            return false;
        }
        int speedLayout = bikeNaviDisplayOption.getSpeedLayout();
        if (speedLayout == 0) {
            Log.e("CustomWNaviView", "BikeSpeed layout resource is empty.");
            return false;
        }
        if (this.q == null) {
            Log.e("CustomWNaviView", "BikeSpeed layout add failed.");
            return false;
        }
        View inflate = LayoutInflater.from(this.f9557a).inflate(speedLayout, (ViewGroup) this.q, false);
        if (inflate == null) {
            Log.e("CustomWNaviView", "Load BikeSpeed layout failed,please checking layout.");
            return false;
        }
        if (!com.baidu.platform.comapi.walknavi.h.d.b.a().a(this.f9557a, 5, speedLayout, this)) {
            Log.e("CustomWNaviView", "Parser BikeSpeed layout failed,please checking layout.");
            return false;
        }
        a.b bVar = this.L;
        if (bVar == null) {
            Log.e("CustomWNaviView", "Parser BikeSpeed layout failed,missing other keywords like TAG attribute or ID attribute.");
            return false;
        }
        if (!TextUtils.isEmpty(bVar.a()) && !TextUtils.isEmpty(this.L.b())) {
            try {
                this.o = (TextView) inflate.findViewById(Integer.parseInt(this.L.a().replace("@", "")));
                TextView textView = (TextView) inflate.findViewById(Integer.parseInt(this.L.b().replace("@", "")));
                this.p = textView;
                if (this.o != null && textView != null) {
                    this.q.removeAllViews();
                    this.q.addView(inflate);
                    this.M = true;
                    this.q.setBackgroundColor(0);
                    return true;
                }
                Log.e("CustomWNaviView", "BikeSpeed layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("CustomWNaviView", "BikeSpeed layout control type error.");
                return false;
            }
        }
        Log.e("CustomWNaviView", "BikeSpeed layout missing other keywords like TAG attribute or ID attribute.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            new b(this.n, true).execute(new Integer[0]);
        } else if (this.J != 0) {
            new b(this.n, false).execute(new Integer[0]);
        }
    }

    public void a(double d, double d2, double d3) {
        this.o.setText(((int) d) + "");
        this.x.setText(d + "");
        this.z.setText(d3 + "");
        this.y.setText(d2 + "");
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.b
    public void b() {
        super.b();
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f9557a, R.anim.wsdk_anim_rg_down_out);
        if (this.j.isShown()) {
            this.j.setAnimation(c);
        }
        this.j.setVisibility(8);
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            if (relativeLayout.isShown()) {
                this.m.setAnimation(c);
            }
            this.m.setVisibility(8);
        }
    }

    public void a(double d, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        com.baidu.platform.comapi.wnplatform.p.g.a((int) d, g.b.ZH, stringBuffer);
        StringBuilder sb = new StringBuilder();
        sb.append("已骑行" + stringBuffer.toString() + " ");
        sb.append(com.baidu.platform.comapi.wnplatform.p.g.a((int) j, 2));
        this.F.setText(sb.toString());
    }

    public void a(float f, float f2, float f3) {
        this.C.setText(f + "");
        this.D.setText(f2 + "");
        this.E.setText(f3 + "");
    }

    public void a(String str, String str2) {
        this.A.setText(str);
        this.B.setText(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("全程剩余: ");
        sb.append(str + " ");
        sb.append(str2);
        this.s.setText(sb.toString());
    }

    public void a(int i) {
        int i2 = R.drawable.wsdk_drawable_rg_ic_walk_bike3d_new;
        if (i == i2) {
            this.h.setImageDrawable(this.f9557a.getResources().getDrawable(i2));
            this.e = 2;
            return;
        }
        int i3 = R.drawable.wsdk_drawable_rg_ic_north_walk_bike2d;
        if (i == i3) {
            this.h.setImageDrawable(this.f9557a.getResources().getDrawable(i3));
            this.e = 1;
            return;
        }
        int i4 = R.drawable.wsdk_drawable_rg_ic_locate_walk_bike_point;
        if (i == i4) {
            this.h.setImageDrawable(this.f9557a.getResources().getDrawable(i4));
            this.e = 3;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.b
    public void a() {
        super.a();
        if (this.P) {
            Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.f9557a, R.anim.wsdk_anim_rg_down_in);
            if (!this.j.isShown()) {
                this.j.setAnimation(c);
            }
            this.j.setVisibility(0);
            RelativeLayout relativeLayout = this.m;
            if (relativeLayout != null) {
                if (!relativeLayout.isShown()) {
                    this.m.setAnimation(c);
                }
                this.m.setVisibility(0);
            }
        }
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            TextView textView = this.r;
            if (textView != null) {
                textView.setText("查看全览");
            }
            this.s.setVisibility(0);
            return;
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setText(RGFSMTable.FsmEvent.CONTINUE_NAVI);
        }
        this.s.setVisibility(8);
    }

    public void a(a.b bVar) {
        this.L = bVar;
    }

    public void a(a.C0132a c0132a) {
        this.N = c0132a;
    }
}
