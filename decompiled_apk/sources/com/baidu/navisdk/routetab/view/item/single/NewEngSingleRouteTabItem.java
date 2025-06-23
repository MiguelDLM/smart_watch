package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class NewEngSingleRouteTabItem extends SingleRouteTabItem {
    public NewEngSingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_new_eng_route_single_tab_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "NewEngSingleRouteTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem
    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_bg_neweng;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_eng_time_text_pressed;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem
    public int getTextColor() {
        return ContextCompat.getColor(getContext(), R.color.nsdk_new_energy_text_green);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem
    public float getTextSize() {
        return 19.0f;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
    }

    public NewEngSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NewEngSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
