package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class h extends g implements View.OnClickListener {
    private final RoutePlanNode e;
    private View f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private Button l;
    private Button m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private LinearLayout u;
    private String v;
    private boolean w;

    public h(RoutePlanNode routePlanNode) {
        com.baidu.navisdk.module.nearbysearch.model.a a2;
        this.f8808a = 1001;
        this.e = routePlanNode;
        if (s() != null && (a2 = s().a().a(routePlanNode)) != null) {
            this.v = a2.b();
        }
        t();
    }

    private void a(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (com.baidu.navisdk.util.common.l0.c(textView.getText().toString())) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
    }

    private com.baidu.navisdk.ui.routeguide.control.g s() {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() == null) {
            return null;
        }
        return com.baidu.navisdk.ui.routeguide.b.V().j().b();
    }

    private void t() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_via_arrive_card);
        this.f = a2;
        a2.setOnClickListener(this);
        this.g = (ImageView) this.f.findViewById(R.id.iv_icon);
        this.k = (ImageView) this.f.findViewById(R.id.iv_dest_street_image);
        this.h = (TextView) this.f.findViewById(R.id.tv_main_title);
        this.i = (TextView) this.f.findViewById(R.id.tv_sub_title);
        this.j = (TextView) this.f.findViewById(R.id.tv_arrive_label);
        this.l = (Button) this.f.findViewById(R.id.nsdk_continue_navi_btn);
        this.m = (Button) this.f.findViewById(R.id.nsdk_finish_navi_btn);
        this.n = this.f.findViewById(R.id.nsdk_divider);
        this.o = (TextView) this.f.findViewById(R.id.tv_already_time_value);
        this.p = (TextView) this.f.findViewById(R.id.tv_already_time_label);
        this.q = (TextView) this.f.findViewById(R.id.tv_already_travel_value);
        this.u = (LinearLayout) this.f.findViewById(R.id.nsdk_travel_detail_Layout);
        this.r = (TextView) this.f.findViewById(R.id.tv_already_travel_label);
        this.s = (TextView) this.f.findViewById(R.id.tv_average_speed_value);
        this.t = (TextView) this.f.findViewById(R.id.tv_average_speed_label);
        this.m.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    private boolean u() {
        RoutePlanNode routePlanNode = this.e;
        if (routePlanNode != null && routePlanNode.getPoiType() == 986112) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v() {
        /*
            r3 = this;
            java.lang.String r0 = r3.v
            boolean r0 = com.baidu.navisdk.util.common.l0.c(r0)
            if (r0 != 0) goto L71
            java.lang.String r0 = r3.v
            java.lang.String r1 = "加油站"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L17
            java.lang.String r0 = "加个油吧"
            goto L74
        L17:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "充电站"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L26
            java.lang.String r0 = "充充电吧"
            goto L74
        L26:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "厕所"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L35
            java.lang.String r0 = "放松一下"
            goto L74
        L35:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "银行"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L44
            java.lang.String r0 = "注意安全"
            goto L74
        L44:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "酒店"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
            java.lang.String r0 = "住宿愉快"
            goto L74
        L53:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "景点"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L62
            java.lang.String r0 = "欢迎来到"
            goto L74
        L62:
            java.lang.String r0 = r3.v
            java.lang.String r1 = "餐饮"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L71
            java.lang.String r0 = "用餐愉快"
            goto L74
        L71:
            java.lang.String r0 = "已到达"
        L74:
            boolean r1 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r1 == 0) goto L90
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "switchDisplayArriveText -> mViaType = "
            r1.append(r2)
            java.lang.String r2 = r3.v
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RGMMArriveViaRemindCard - DestRemind"
            com.baidu.navisdk.util.common.LogUtil.e(r2, r1)
        L90:
            android.widget.TextView r1 = r3.j
            r1.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.h.v():void");
    }

    private int w() {
        int i = R.drawable.nsdk_ic_via_arrive_reminder;
        if (!com.baidu.navisdk.util.common.l0.c(this.v)) {
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Gas_Station)) {
                return R.drawable.nsdk_ic_via_arrive_gas_station;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
                return R.drawable.nsdk_ic_via_arrive_charging_station;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Toilet)) {
                return R.drawable.nsdk_ic_via_arrive_toilet;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Bank)) {
                return R.drawable.nsdk_ic_via_arrive_bank;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Hotel)) {
                return R.drawable.nsdk_ic_via_arrive_hotel;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Spots)) {
                return R.drawable.nsdk_ic_via_arrive_spots;
            }
            if (this.v.equals(IBNRouteResultManager.NearbySearchKeyword.Restaurant)) {
                return R.drawable.nsdk_drawable_rg_arrive_remind_restaurant;
            }
            return i;
        }
        return i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        } else {
            layoutParams.setMargins(com.baidu.navisdk.ui.routeguide.control.x.b().V(), dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.f;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        if (s() != null) {
            s().b(false);
        }
        super.j();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "onHide!");
        }
        if (!this.w) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.1", null, null, "");
        }
        if (u()) {
            com.baidu.navisdk.ui.routeguide.b.V().r().m();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        if (s() != null) {
            s().b(true);
        }
        super.k();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "onShow!");
        }
        r();
        if (u()) {
            this.u.setVisibility(8);
            this.n.setVisibility(8);
            this.j.setVisibility(8);
            this.l.setText(RGFSMTable.FsmEvent.CONTINUE_NAVI);
            this.i.setText("已到达");
            a(this.i);
            com.baidu.navisdk.ui.routeguide.b.V().r().c(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void n() {
        super.n();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "onAutoHideCard!");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.nsdk_finish_navi_btn) {
            this.w = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.1", null, "1", null);
            com.baidu.navisdk.ui.routeguide.b.V().Q();
        } else if (id == R.id.nsdk_continue_navi_btn) {
            this.w = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.1", null, "2", null);
            if (s() != null) {
                s().e();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public boolean q() {
        return true;
    }

    public void r() {
        RoutePlanNode routePlanNode = this.e;
        if (routePlanNode == null) {
            LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "refreshData, mRoutePlanNode == null");
            return;
        }
        String name = routePlanNode.getName();
        if (com.baidu.navisdk.util.common.l0.c(name)) {
            name = JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive_default_poi_name);
        }
        this.h.setText(name);
        this.i.setText(this.e.getDescription());
        a(this.i);
        this.g.setImageResource(w());
        v();
        if (s() != null) {
            com.baidu.navisdk.ui.routeguide.model.b a2 = s().a();
            this.q.setText(a2.a());
            this.o.setText(a2.d());
            this.s.setText(a2.b() + "");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "getAleadyTravelDistanceText = " + a2.a() + ", getConsumptionTimeString = " + a2.d() + ", getAverageSpeed = " + a2.b());
                return;
            }
            return;
        }
        LogUtil.e("RGMMArriveViaRemindCard - DestRemind", "refreshData, getController() == null");
    }
}
