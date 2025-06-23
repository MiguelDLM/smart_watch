package com.baidu.navisdk.ugc.report.ui.inmap.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes8.dex */
public class UgcReportGridView extends GridView {
    public UgcReportGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public UgcReportGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UgcReportGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
