package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.data.b;
import com.baidu.navisdk.routetab.view.item.RouteTabItem;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public abstract class SingleRouteTabItem extends RouteTabItem {
    protected ConstraintLayout k;
    protected ConstraintLayout l;

    public SingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    @LayoutRes
    public int a() {
        return R.layout.nsdk_layout_single_route_tab_item;
    }

    public void b() {
        boolean z;
        boolean z2;
        TextView textView = this.f;
        boolean z3 = true;
        if (textView != null && textView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        TextView textView2 = this.g;
        if (textView2 != null && textView2.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        TextView textView3 = this.h;
        if (textView3 == null || textView3.getVisibility() != 0) {
            z3 = false;
        }
        LinearLayout linearLayout = this.b;
        if (linearLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            if (!z && !z2 && !z3) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = ScreenUtil.getInstance().dip2px(7);
            }
        }
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void d(@NonNull b.a aVar) {
        super.d(aVar);
        b();
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public abstract String getTAG();

    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_bg_default;
    }

    public int getTextColor() {
        return Color.parseColor("#3377FF");
    }

    public float getTextSize() {
        return 15.0f;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        this.k = (ConstraintLayout) findViewById(R.id.first_row);
        this.l = (ConstraintLayout) findViewById(R.id.sec_row);
        TextView textView = this.d;
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.getPaint().setFakeBoldText(true);
        }
    }

    public SingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
