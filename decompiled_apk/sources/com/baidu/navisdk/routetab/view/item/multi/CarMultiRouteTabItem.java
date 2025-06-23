package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.routetab.data.b;
import com.baidu.navisdk.routetab.view.tab.CarRouteTabView;
import com.baidu.navisdk.ui.widget.BNMultiTabLabelTextView;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class CarMultiRouteTabItem extends MultiRouteTabItem {
    private View l;
    private CarRouteTabView m;
    private int n;

    public CarMultiRouteTabItem(Context context) {
        super(context);
        this.n = 0;
    }

    private void c(int i) {
        this.l.setVisibility(i);
    }

    private int getTabItemPadding() {
        ScreenUtil screenUtil;
        int i;
        if (isSelected()) {
            screenUtil = ScreenUtil.getInstance();
            i = 14;
        } else {
            screenUtil = ScreenUtil.getInstance();
            i = 9;
        }
        return screenUtil.dip2px(i);
    }

    private int getTagIconWidth() {
        ImageView imageView = this.i;
        if (imageView != null && imageView.getWidth() != 0) {
            return this.i.getWidth() + ScreenUtil.getInstance().dip2px(6);
        }
        return ScreenUtil.getInstance().dip2px(12);
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int a() {
        return R.layout.nsdk_layout_car_multi_route_tabs_item;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int b(String str) {
        float tabItemPadding;
        int dip2px;
        String eTAInCarPage = JNIGuidanceControl.getInstance().getETAInCarPage(Integer.parseInt(str));
        TextPaint paint = this.d.getPaint();
        if (TextUtils.isEmpty(eTAInCarPage)) {
            eTAInCarPage = "";
        }
        float measureText = paint.measureText(eTAInCarPage);
        if (this.d != null) {
            if (isSelected() && this.i != null) {
                tabItemPadding = measureText + getTabItemPadding();
                dip2px = getTagIconWidth();
            } else {
                tabItemPadding = measureText + getTabItemPadding();
                dip2px = ScreenUtil.getInstance().dip2px(2);
            }
            return (int) (tabItemPadding + dip2px);
        }
        return super.b(str);
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void d(@NonNull b.a aVar) {
        if (this.b != null) {
            d();
            ArrayList<b.a.C0362a> b = aVar.b();
            if (b == null || b.size() < 1) {
                return;
            }
            this.m = (CarRouteTabView) getRootView().findViewWithTag("CarRouteTabView");
            this.b.removeAllViews();
            c(8);
            int size = b.size();
            if (!isSelected() && getUnSelectMaxLabels() > 0) {
                size = Math.min(getUnSelectMaxLabels(), size);
            }
            int i = 0;
            int i2 = 0;
            while (i < size) {
                BNMultiTabLabelTextView bNMultiTabLabelTextView = new BNMultiTabLabelTextView(getContext());
                bNMultiTabLabelTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                bNMultiTabLabelTextView.setLabelLineVisible(i != 0);
                bNMultiTabLabelTextView.setText(b.get(i).b);
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
                i2 += bNMultiTabLabelTextView.getLabelWidth(b.get(i).b, b.get(i).c);
                i++;
            }
            if (getTabItemPadding() + i2 > b(Math.max(i2, this.n)) && isSelected()) {
                c(0);
            }
            this.k = b(Math.max(i2, this.n));
        }
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "CarRouteTabItem";
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_selected_bg;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_car_time_text_pressed;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public int getUnSelectMaxLabels() {
        return 2;
    }

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        this.l = findViewById(R.id.route_tab_item_describe_mask);
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

    @Override // com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem
    public void c() {
        if (isSelected()) {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5));
        } else {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(2), ScreenUtil.getInstance().dip2px(5));
        }
    }

    public CarMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0;
    }

    public CarMultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0;
    }

    private int b(int i) {
        CarRouteTabView carRouteTabView = this.m;
        if (carRouteTabView != null && carRouteTabView.getTotalRoutTabCount() > 3) {
            int tabItemPadding = i + getTabItemPadding();
            int maxTabWidth = this.m.getMaxTabWidth();
            if (!isSelected()) {
                maxTabWidth = this.m.getUnselectedMaxTabWidth();
            }
            int i2 = this.k;
            return tabItemPadding <= i2 ? i2 : tabItemPadding <= maxTabWidth ? tabItemPadding : maxTabWidth;
        }
        return this.k;
    }

    private void d() {
        this.n = 0;
        if (this.e.getVisibility() == 0) {
            this.n += ((int) this.e.getPaint().measureText(this.e.getText().toString())) + ScreenUtil.getInstance().dip2px(3);
        }
        if (this.f.getVisibility() == 0) {
            this.n += ((int) this.f.getPaint().measureText(this.f.getText().toString())) + ScreenUtil.getInstance().dip2px(15);
        }
        if (this.g.getVisibility() == 0) {
            this.n += ((int) this.g.getPaint().measureText(this.g.getText().toString())) + ScreenUtil.getInstance().dip2px(12);
        }
    }
}
