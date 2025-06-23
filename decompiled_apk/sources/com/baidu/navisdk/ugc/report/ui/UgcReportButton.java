package com.baidu.navisdk.ugc.report.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcReportButton extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    protected ImageView f8266a;
    protected TextView b;
    private int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;

    public UgcReportButton(Context context) {
        super(context);
        this.c = 0;
        a(context, null);
    }

    public void a() {
    }

    public void b() {
        setBackgroundDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
    }

    public String getPageName() {
        int i = this.c;
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 8) {
                        return "unknownPage";
                    }
                    return "commuteNavi";
                }
                return "routeResult";
            }
            return "lightNavi";
        }
        return "proNavi";
    }

    private void a(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        setGravity(17);
        JarUtils.inflate(context, R.layout.nsdk_layout_ugc_report_btn, this);
        this.f8266a = (ImageView) findViewById(R.id.bnav_rg_ic_ugc_report_iv_innavi);
        this.b = (TextView) findViewById(R.id.bnav_rg_ic_ugc_report_tv_innavi);
        if (attributeSet == null) {
            int i = R.drawable.nsdk_rg_ic_ugc_report_in_route;
            this.d = i;
            this.e = i;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UgcReportButton);
        int i2 = R.styleable.UgcReportButton_nsdk_iv_height;
        if (obtainStyledAttributes.hasValue(i2)) {
            int i3 = R.styleable.UgcReportButton_nsdk_iv_width;
            if (obtainStyledAttributes.hasValue(i3)) {
                Resources resources = context.getResources();
                int i4 = R.dimen.ugc_rg_control_panel_icon_size;
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i3, resources.getDimensionPixelSize(i4));
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i2, context.getResources().getDimensionPixelSize(i4));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8266a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize2;
                }
            }
        }
        int i5 = R.styleable.UgcReportButton_nsdk_iv_text_padding;
        if (obtainStyledAttributes.hasValue(i5)) {
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(i5, context.getResources().getDimensionPixelSize(R.dimen.ugc_rg_control_button_text_margin_top));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin = dimensionPixelSize3;
            }
        }
        int i6 = R.styleable.UgcReportButton_nsdk_is_bold_report;
        if (obtainStyledAttributes.hasValue(i6)) {
            if (obtainStyledAttributes.getBoolean(i6, true)) {
                TextView textView = this.b;
                textView.setTypeface(textView.getTypeface(), 1);
            } else {
                this.b.setTypeface(null, 0);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.UgcReportButton_nsdk_iv_text_size)) {
            this.b.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(r0, context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_9dp)));
        }
        int i7 = R.styleable.UgcReportButton_nsdk_iv_text_color;
        if (obtainStyledAttributes.hasValue(i7)) {
            int color = obtainStyledAttributes.getColor(i7, Color.parseColor("#333333"));
            this.f = color;
            this.g = color;
            this.b.setTextColor(color);
        }
        int i8 = R.styleable.UgcReportButton_nsdk_iv_icon_src;
        if (obtainStyledAttributes.hasValue(i8)) {
            int resourceId = obtainStyledAttributes.getResourceId(i8, R.drawable.nsdk_rg_ic_ugc_report_in_route);
            this.d = resourceId;
            this.e = resourceId;
            if (resourceId > 0) {
                this.f8266a.setImageDrawable(com.baidu.navisdk.ui.util.b.f(resourceId));
            }
        }
        int i9 = R.styleable.UgcReportButton_nsdk_ugc_btn_page;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.c = obtainStyledAttributes.getInt(i9, 0);
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "init page: " + this.c);
        }
        obtainStyledAttributes.recycle();
    }

    public UgcReportButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        a(context, attributeSet);
    }

    public UgcReportButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        a(context, attributeSet);
    }
}
