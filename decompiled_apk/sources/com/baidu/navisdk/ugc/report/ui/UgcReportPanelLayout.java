package com.baidu.navisdk.ugc.report.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcReportPanelLayout extends FrameLayout {
    public UgcReportPanelLayout(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setBackgroundResource(R.color.nsdk_ugc_menu_background);
        JarUtils.inflate(context, R.layout.nsdk_layout_ugc_navi_route_report_panel, this);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UgcReportPanelLayout);
        int i = R.styleable.UgcReportPanelLayout_nsdk_panel_margin_left;
        int dimensionPixelSize = obtainStyledAttributes.hasValue(i) ? obtainStyledAttributes.getDimensionPixelSize(i, 0) : 0;
        int i2 = R.styleable.UgcReportPanelLayout_nsdk_panel_margin_right;
        int dimensionPixelSize2 = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getDimensionPixelSize(i2, 0) : 0;
        obtainStyledAttributes.recycle();
        setPadding(dimensionPixelSize, 0, dimensionPixelSize2, 0);
    }

    public UgcReportPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UgcReportPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public UgcReportPanelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    public void a(int i, int i2) {
        setPadding(i, 0, i2, 0);
    }
}
