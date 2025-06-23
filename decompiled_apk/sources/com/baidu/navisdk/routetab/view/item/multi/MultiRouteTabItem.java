package com.baidu.navisdk.routetab.view.item.multi;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.item.RouteTabItem;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.utils.c;

/* loaded from: classes7.dex */
public abstract class MultiRouteTabItem extends RouteTabItem {
    protected int k;

    public MultiRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    @LayoutRes
    public int a() {
        return R.layout.nsdk_layout_multi_route_tabs_item;
    }

    public int b(String str) {
        return 0;
    }

    public void c() {
        if (isSelected()) {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5));
        } else {
            setPadding(ScreenUtil.getInstance().dip2px(7), ScreenUtil.getInstance().dip2px(5), ScreenUtil.getInstance().dip2px(0), ScreenUtil.getInstance().dip2px(5));
        }
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public abstract String getTAG();

    public int getTabBackgroundDrawable() {
        return R.drawable.nsdk_drawable_tab_bg_default;
    }

    public int getTabItemWidth() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7982a, "getTabItemWidth -- > tabItemWidth = " + this.k);
        }
        return this.k;
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public void initView() {
        super.initView();
        TextView textView = this.d;
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
    }

    public void setTabItemWidth(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7982a, "setTabItemWidth -- > tabItemWidth = " + i);
        }
        this.k = i;
    }

    public void setTrafficLightVisible(boolean z) {
        int i;
        TextView textView = this.f;
        if (textView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
        requestLayout();
        invalidate();
    }

    public MultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public void b() {
        LinearLayout linearLayout;
        TextView textView = this.f;
        if (textView != null && textView.getVisibility() == 0 && c.a(this.f)) {
            this.f.setVisibility(8);
        }
        TextView textView2 = this.g;
        if (textView2 != null && textView2.getVisibility() == 0 && c.a(this.g)) {
            TextView textView3 = this.f;
            if (textView3 != null) {
                textView3.setVisibility(8);
            } else {
                this.g.setVisibility(8);
            }
        }
        if (isSelected() || (linearLayout = this.b) == null) {
            return;
        }
        if (linearLayout.getChildCount() > 2) {
            for (int i = 2; i < this.b.getChildCount(); i++) {
                View childAt = this.b.getChildAt(i);
                Rect rect = new Rect();
                if (!childAt.getGlobalVisibleRect(rect) || rect.right - rect.left < childAt.getWidth()) {
                    this.b.removeViewAt(i);
                }
            }
        }
    }

    public MultiRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(boolean z, float f) {
        super.setSelected(z);
        if (f == 0.0f) {
            ImageView imageView = this.i;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            }
            if (z) {
                setBackgroundResource(getTabBackgroundDrawable());
            } else {
                setBackground(null);
            }
            c();
        }
    }
}
