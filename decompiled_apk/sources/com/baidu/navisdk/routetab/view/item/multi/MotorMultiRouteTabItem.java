package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class MotorMultiRouteTabItem extends MultiRouteTabItem {
    public MotorMultiRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_motor_multi_route_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "MotorRouteTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_selected_bg;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_car_time_text_pressed;
    }

    public MotorMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
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

    public MotorMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
