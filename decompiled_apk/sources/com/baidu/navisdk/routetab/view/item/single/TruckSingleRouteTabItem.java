package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class TruckSingleRouteTabItem extends SingleRouteTabItem {
    public TruckSingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    @LayoutRes
    public int a() {
        return R.layout.nsdk_layout_truck_route_single_tab_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "TruckSingleRouteTabItem";
    }

    public TruckSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TruckSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
