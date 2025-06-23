package com.baidu.navisdk.module.routeresultbase.view.support.widgit;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class RouteResultButton extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f7552a;
    protected ImageView b;
    protected TextView c;
    protected TextView d;
    private RelativeLayout e;
    private Drawable f;
    private int g;

    public RouteResultButton(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_route_result_pack_up_toolbox_item, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.toolbox_iv);
        this.c = (TextView) findViewById(R.id.toolbox_label);
        this.d = (TextView) findViewById(R.id.toolbox_tv);
        this.e = (RelativeLayout) findViewById(R.id.toolbox_iv_collection);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RouteResultButton, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_rrb_icon_width, ScreenUtil.getInstance().dip2px(18));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_rrb_icon_height, ScreenUtil.getInstance().dip2px(18));
        obtainStyledAttributes.getDrawable(R.styleable.RouteResultButton_nsdk_icon_src_unusable);
        this.f = obtainStyledAttributes.getDrawable(R.styleable.RouteResultButton_nsdk_icon_src_normal);
        obtainStyledAttributes.getDrawable(R.styleable.RouteResultButton_nsdk_icon_src_selected);
        ImageView imageView = this.b;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = dimensionPixelSize2;
                layoutParams2.width = dimensionPixelSize;
                this.b.setLayoutParams(layoutParams2);
            }
            Drawable drawable = this.f;
            if (drawable != null) {
                this.b.setImageDrawable(drawable);
            }
        }
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null && (layoutParams = relativeLayout.getLayoutParams()) != null) {
            layoutParams.height = dimensionPixelSize2;
            layoutParams.width = dimensionPixelSize;
            this.e.setLayoutParams(layoutParams);
        }
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_label_size, ScreenUtil.getInstance().dip2px(6));
        int color = obtainStyledAttributes.getColor(R.styleable.RouteResultButton_nsdk_label_text_color, context.getResources().getColor(R.color.nsdk_route_yellow_banner_text_white));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.RouteResultButton_nsdk_label_background);
        TextView textView = this.c;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.height = dimensionPixelSize3;
                layoutParams3.width = dimensionPixelSize3;
                this.c.setLayoutParams(layoutParams3);
            }
            if (drawable2 != null) {
                this.c.setBackgroundDrawable(drawable2);
            }
            this.c.setTextColor(color);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RouteResultButton_nsdk_rrb_title_text);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_rrb_title_width, -1);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_title_height, -1);
        int i2 = R.styleable.RouteResultButton_nsdk_title_text_color_unusable;
        Resources resources = context.getResources();
        int i3 = R.color.nsdk_route_yellow_banner_text_black;
        obtainStyledAttributes.getColor(i2, resources.getColor(i3));
        this.g = obtainStyledAttributes.getColor(R.styleable.RouteResultButton_nsdk_title_text_color_normal, context.getResources().getColor(i3));
        obtainStyledAttributes.getColor(R.styleable.RouteResultButton_nsdk_title_text_color_selected, context.getResources().getColor(R.color.nsdk_end_remind_btn_bg_border_color));
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_title_text_size, ScreenUtil.getInstance().dip2px(5));
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RouteResultButton_nsdk_title_margin_icon, 0);
        TextView textView2 = this.d;
        if (textView2 != null) {
            if (textView2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                if (dimensionPixelSize5 <= 0) {
                    dimensionPixelSize5 = -2;
                }
                if (dimensionPixelSize4 <= 0) {
                    dimensionPixelSize4 = -2;
                }
                layoutParams4.height = dimensionPixelSize5;
                layoutParams4.width = dimensionPixelSize4;
                layoutParams4.topMargin = dimensionPixelSize7;
                this.d.setLayoutParams(layoutParams4);
            }
            this.d.setTextSize(0, dimensionPixelSize6);
            this.d.setTextColor(this.g);
            if (TextUtils.isEmpty(string)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(string);
                this.d.setVisibility(0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public int getStatus() {
        return this.f7552a;
    }

    public void setIconDrawable(Drawable drawable) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setIconVisibility(int i) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setLabelBackground(Drawable drawable) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setBackgroundDrawable(drawable);
        }
    }

    public void setLabelText(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setLabelVisibility(int i) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitleVisibility(int i) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public RouteResultButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RouteResultButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }
}
