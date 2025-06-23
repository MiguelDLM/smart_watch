package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.data.b;

/* loaded from: classes7.dex */
public class SpeedyMultiRouteTabItem extends MultiRouteTabItem {
    private TextView l;

    public SpeedyMultiRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_speedy_multi_route_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void d(@NonNull b.a aVar) {
        String a2 = a(aVar);
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(a2);
        }
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "SpeedyMultiRouteTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        this.l = (TextView) findViewById(R.id.route_tab_item_label);
    }

    public SpeedyMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void a(boolean z, float f) {
        super.setSelected(z);
    }

    public SpeedyMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
