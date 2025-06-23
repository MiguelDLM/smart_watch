package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class y extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(y yVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ui.routeguide.control.x.b().T3();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.1", null, null, null);
        }
    }

    public y(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    private void w() {
        h.c cVar;
        com.baidu.navisdk.model.datastruct.h c = com.baidu.navisdk.ui.routeguide.model.t.s().c();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("WeatherPanel", "updatePanelData: " + c);
        }
        if (c != null && c.f()) {
            if (this.g != null && (cVar = c.e) != null && (!TextUtils.isEmpty(cVar.d) || !TextUtils.isEmpty(c.e.e))) {
                if (!TextUtils.isEmpty(c.e.d)) {
                    this.g.setText(c.e.d);
                } else {
                    this.g.setText(c.e.e);
                }
            }
            TextView textView = this.h;
            if (textView != null) {
                textView.setText(c.c());
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setText(c.d());
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_route_weather_panel, viewGroup, false);
        this.f = a2;
        this.g = (TextView) a2.findViewById(R.id.bnav_rg_weather_panel_traffic);
        this.h = (TextView) this.f.findViewById(R.id.bnav_rg_weather_panel_dis);
        this.i = (TextView) this.f.findViewById(R.id.bnav_rg_weather_panel_dis_unit);
        return this.f;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (l() || !com.baidu.navisdk.ui.routeguide.model.t.s().k()) {
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("WeatherPanel", "getVisibility: isYawing");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("WeatherPanel", "getVisibility: isRoused");
            }
            return 8;
        }
        com.baidu.navisdk.model.datastruct.h c = com.baidu.navisdk.ui.routeguide.model.t.s().c();
        if (c == null || !c.h()) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new a(this);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("WeatherPanel", "onVisibleChange: " + i);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = com.baidu.navisdk.ui.routeguide.control.x.b().m0();
        if (i == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.5", null, null, null);
            w();
            if (m0 != null) {
                m0.d();
                return;
            }
            return;
        }
        if (m0 != null) {
            m0.i();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public void v() {
        refreshVisible();
        if (isVisible()) {
            w();
        }
    }
}
