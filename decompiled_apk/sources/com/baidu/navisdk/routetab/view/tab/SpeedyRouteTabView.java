package com.baidu.navisdk.routetab.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.bar.AbsRRBottomBar;
import com.baidu.navisdk.routetab.view.bar.MotorRRBottomBar;
import com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem;

/* loaded from: classes7.dex */
public class SpeedyRouteTabView extends RouteTabView {
    private MotorRRBottomBar p;

    public SpeedyRouteTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void a(MultiRouteTabItem multiRouteTabItem, int i, boolean z) {
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public String getTAG() {
        return "SpeedyRouteTabView";
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void initView() {
        super.initView();
        MotorRRBottomBar motorRRBottomBar = (MotorRRBottomBar) findViewById(R.id.bottom_bar);
        this.p = motorRRBottomBar;
        motorRRBottomBar.a();
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public int layoutId() {
        return R.layout.nsdk_layout_speedy_route_tab_view;
    }

    public void setBarBtnClickListener(AbsRRBottomBar.b bVar) {
        MotorRRBottomBar motorRRBottomBar = this.p;
        if (motorRRBottomBar != null) {
            motorRRBottomBar.setBtnClickListener(bVar);
        }
    }

    public SpeedyRouteTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
