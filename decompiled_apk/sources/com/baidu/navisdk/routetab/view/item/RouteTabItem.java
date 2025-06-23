package com.baidu.navisdk.routetab.view.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.data.b;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.ui.widget.BNTabLabelTextView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class RouteTabItem extends BNLinearLayout {

    /* renamed from: a, reason: collision with root package name */
    protected final String f7982a;
    protected LinearLayout b;
    protected LinearLayout c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    protected TextView g;
    protected TextView h;
    protected ImageView i;
    protected View j;

    public RouteTabItem(Context context) {
        super(context);
        this.f7982a = getTAG();
        a(context, (AttributeSet) null);
    }

    private String b(int i) {
        return i != 0 ? i != 2 ? i != 4 ? i != 5 ? "#195C6373" : "#1937C7FF" : "#1E21D9D9" : "#19FF6E52" : "#19FF813E";
    }

    @LayoutRes
    public abstract int a();

    public String a(int i) {
        return i != 0 ? i != 2 ? i != 4 ? i != 5 ? "#5C6373" : "#377EFF" : "#12B3B0" : "#FF6E52" : "#FF813E";
    }

    public String c(@NonNull b.a aVar) {
        return String.valueOf(aVar.e());
    }

    public void d(@NonNull b.a aVar) {
        LinearLayout linearLayout = this.b;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ArrayList<b.a.C0362a> b = aVar.b();
            int size = b.size();
            if (!isSelected() && getUnSelectMaxLabels() > 0) {
                size = Math.min(getUnSelectMaxLabels(), size);
            }
            for (int i = 0; i < size; i++) {
                BNTabLabelTextView bNTabLabelTextView = new BNTabLabelTextView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (i != 0) {
                    layoutParams.leftMargin = ScreenUtil.getInstance().dip2px(2);
                }
                bNTabLabelTextView.setLayoutParams(layoutParams);
                this.b.addView(bNTabLabelTextView);
                if (b.size() == 1 && isSelected()) {
                    bNTabLabelTextView.setText(b.get(i).b, b.get(i).c);
                } else {
                    bNTabLabelTextView.setText(b.get(i).b);
                }
                if (isSelected()) {
                    bNTabLabelTextView.setLabelIcon(b.get(i).f7974a);
                    if (TextUtils.isEmpty(b.get(i).f7974a)) {
                        bNTabLabelTextView.setTextColor(Color.parseColor(a(b.get(i).d)));
                        bNTabLabelTextView.setBackgroundColor(b(b.get(i).d));
                    } else {
                        bNTabLabelTextView.setTextColor(Color.parseColor("#FFFFFF"));
                        bNTabLabelTextView.setBackground(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_shape_ne_tab_label_bg));
                    }
                } else {
                    bNTabLabelTextView.setLabelIcon("");
                    bNTabLabelTextView.setTextColor(Color.parseColor(a(3)));
                    bNTabLabelTextView.setBackgroundColor(b(3));
                }
            }
        }
    }

    public void e(@NonNull b.a aVar) {
        String b = b(aVar);
        if (this.g != null) {
            if (aVar.a() <= 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(b);
            }
        }
    }

    public abstract String getTAG();

    public int getTextBackgroundDrawable() {
        return R.drawable.nsdk_drawable_car_time_text_pressed;
    }

    public int getUnSelectMaxLabels() {
        return -1;
    }

    public void initView() {
        this.b = (LinearLayout) findViewById(R.id.route_tab_item_describe);
        this.d = (TextView) findViewById(R.id.route_tab_item_time);
        this.c = (LinearLayout) findViewById(R.id.route_tab_time_layout);
        this.e = (TextView) findViewById(R.id.route_tab_item_distance);
        this.f = (TextView) findViewById(R.id.route_tab_item_traffic_light);
        this.g = (TextView) findViewById(R.id.route_tab_item_tolls);
        this.h = (TextView) findViewById(R.id.route_tab_item_fuel_costs);
        this.j = findViewById(R.id.bottom_collection);
        this.i = (ImageView) findViewById(R.id.route_tab_item_tag);
    }

    public void setMidStatusScrollProgress(float f) {
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        a(context);
        LayoutInflater.from(context).inflate(a(), (ViewGroup) this, true);
        initView();
        b(context, attributeSet);
    }

    private void b(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        int resourceId4;
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RouteTabItem);
        int i = R.styleable.RouteTabItem_bn_routetab_time_color;
        if (obtainStyledAttributes.hasValue(i) && this.d != null && (resourceId4 = obtainStyledAttributes.getResourceId(i, -1)) != -1) {
            this.d.setTextColor(ContextCompat.getColorStateList(context, resourceId4));
        }
        int i2 = R.styleable.RouteTabItem_bn_routetab_distance_color;
        if (obtainStyledAttributes.hasValue(i2) && (resourceId3 = obtainStyledAttributes.getResourceId(i2, -1)) != -1) {
            ColorStateList colorStateList = ContextCompat.getColorStateList(context, resourceId3);
            TextView textView = this.e;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setTextColor(colorStateList);
            }
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setTextColor(colorStateList);
            }
        }
        if (this.f != null) {
            int i3 = R.styleable.RouteTabItem_bn_routetab_traffic_ic;
            if (obtainStyledAttributes.hasValue(i3) && (resourceId2 = obtainStyledAttributes.getResourceId(i3, -1)) != -1) {
                this.f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(context, resourceId2), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        if (this.g != null) {
            int i4 = R.styleable.RouteTabItem_bn_routetab_tolls_ic;
            if (obtainStyledAttributes.hasValue(i4) && (resourceId = obtainStyledAttributes.getResourceId(i4, -1)) != -1) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(context, resourceId), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public RouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7982a = getTAG();
        a(context, attributeSet);
    }

    public void a(Context context) {
        setOrientation(1);
    }

    public RouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7982a = getTAG();
        a(context, attributeSet);
    }

    public void a(@NonNull b.a aVar, boolean z) {
        String c = c(aVar);
        if (this.f != null) {
            if (aVar.e() > 0 && !z) {
                this.f.setVisibility(0);
                this.f.setText(c);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public String a(@NonNull b.a aVar) {
        return a(aVar.c());
    }

    public String b(@NonNull b.a aVar) {
        return String.valueOf(aVar.a());
    }
}
