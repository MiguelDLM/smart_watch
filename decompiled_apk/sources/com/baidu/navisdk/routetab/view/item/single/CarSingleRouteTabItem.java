package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.data.b;
import com.baidu.navisdk.ui.widget.BNMultiTabLabelTextView;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class CarSingleRouteTabItem extends SingleRouteTabItem {
    public CarSingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_car_route_single_tab_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void d(@NonNull b.a aVar) {
        boolean z;
        super.d(aVar);
        if (this.b != null) {
            ArrayList<b.a.C0362a> b = aVar.b();
            if (b != null && b.size() >= 1) {
                this.b.removeAllViews();
                for (int i = 0; i < b.size(); i++) {
                    BNMultiTabLabelTextView bNMultiTabLabelTextView = new BNMultiTabLabelTextView(getContext());
                    bNMultiTabLabelTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                    if (i != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bNMultiTabLabelTextView.setLabelLineVisible(z);
                    if (b.size() == 1 && isSelected()) {
                        bNMultiTabLabelTextView.setText(b.get(i).b, b.get(i).c);
                    } else {
                        bNMultiTabLabelTextView.setText(b.get(i).b);
                    }
                    if (isSelected()) {
                        bNMultiTabLabelTextView.setLabelIcon(b.get(i).f7974a);
                        if (TextUtils.isEmpty(b.get(i).f7974a)) {
                            bNMultiTabLabelTextView.setTextColor(Color.parseColor(a(b.get(i).d)));
                        } else {
                            bNMultiTabLabelTextView.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                    } else {
                        bNMultiTabLabelTextView.setLabelIcon("");
                        bNMultiTabLabelTextView.setTextColor(Color.parseColor(a(3)));
                    }
                    this.b.addView(bNMultiTabLabelTextView);
                }
            } else {
                return;
            }
        }
        b();
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "CarSingleRouteTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_selected_bg;
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
    }

    public CarSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CarSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
