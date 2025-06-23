package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class TruckMultiRouteTabItem extends MultiRouteTabItem {
    public TruckMultiRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    @LayoutRes
    public int a() {
        return R.layout.nsdk_layout_truck_multi_route_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "TruckRouteTabItem";
    }

    public TruckMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void a(boolean z, float f) {
        super.a(z, f);
        if (f <= 0.0f || this.d.getBackground() == null) {
            return;
        }
        if (z) {
            this.d.setBackgroundResource(getTextBackgroundDrawable());
        } else {
            this.d.setBackgroundResource(R.drawable.nsdk_drawable_time_text_normal);
        }
    }

    public TruckMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
