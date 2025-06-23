package com.baidu.navisdk.routetab.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class NewEngCarRouteTabView extends RouteTabView {
    public NewEngCarRouteTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "updateMultiItemSelectLine --> curRouteIndex = " + i);
        }
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public String getTAG() {
        return "NewEngCarRouteTabView";
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public int layoutId() {
        return R.layout.nsdk_layout_neweng_car_route_tab_view;
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void setCurRouteIndex(int i) {
        super.setCurRouteIndex(i);
        a(i);
    }

    public NewEngCarRouteTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
