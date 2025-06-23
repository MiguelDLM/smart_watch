package com.baidu.navisdk.routetab.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.bar.AbsRRBottomBar;
import com.baidu.navisdk.routetab.view.bar.TruckRRBottomBar;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class TruckRouteTabView extends RouteTabView {
    private TruckRRBottomBar p;

    public TruckRouteTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "updateMultiItemSelectLine --> curRouteIndex = " + i);
        }
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public String getTAG() {
        return "TruckRouteTabView";
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void initView() {
        super.initView();
        TruckRRBottomBar truckRRBottomBar = (TruckRRBottomBar) findViewById(R.id.bottom_bar);
        this.p = truckRRBottomBar;
        truckRRBottomBar.a();
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public int layoutId() {
        return R.layout.nsdk_layout_truck_route_tab_view;
    }

    public void setBarBtnClickListener(AbsRRBottomBar.b bVar) {
        TruckRRBottomBar truckRRBottomBar = this.p;
        if (truckRRBottomBar != null) {
            truckRRBottomBar.setBtnClickListener(bVar);
        }
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void setCurRouteIndex(int i) {
        super.setCurRouteIndex(i);
        a(i);
    }

    public void setStartChallengeModeBtnContainerVisibility(int i) {
        TruckRRBottomBar truckRRBottomBar = this.p;
        if (truckRRBottomBar != null) {
            truckRRBottomBar.setStartChallengeModeBtnContainerVisibility(i);
        }
    }

    public TruckRouteTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
