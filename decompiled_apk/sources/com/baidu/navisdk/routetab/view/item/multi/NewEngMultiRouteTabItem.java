package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class NewEngMultiRouteTabItem extends MultiRouteTabItem {
    public NewEngMultiRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_new_eng_multi_route_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "NewEngTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_bg_neweng;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_eng_time_text_pressed;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getUnSelectMaxLabels() {
        return 2;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        this.i.setImageResource(R.drawable.nsdk_drawable_tab_right_top_eng);
    }

    public NewEngMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void a(boolean z, float f) {
        super.a(z, f);
        if (f > 0.0f) {
            if (z) {
                this.d.setBackgroundResource(getTextBackgroundDrawable());
            } else {
                this.d.setBackgroundResource(R.drawable.nsdk_drawable_time_text_normal);
            }
        }
    }

    public NewEngMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
