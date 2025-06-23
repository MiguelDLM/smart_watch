package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class SpeedySingleRouteTabItem extends SingleRouteTabItem {
    public SpeedySingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_speedy_single_route_tab_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "SpeedySingleRouteTabItem";
    }

    public SpeedySingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpeedySingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
