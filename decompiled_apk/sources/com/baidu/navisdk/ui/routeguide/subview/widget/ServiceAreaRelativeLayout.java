package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.module.newguide.widgets.ServiceAreaBaseRelativeLayout;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class ServiceAreaRelativeLayout extends ServiceAreaBaseRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f9107a;
    private int b;
    private boolean c;

    public ServiceAreaRelativeLayout(Context context) {
        super(context);
        this.c = false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        long currentTimeMillis = System.currentTimeMillis();
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                childAt.getLayoutParams().width = -2;
                measureChild(childAt, i, i2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (LogUtil.LOGGABLE && this.c) {
                    Log.e("ServiceAreaRelativeLayout", "onMeasure-> view" + i4 + " width= " + measuredWidth);
                }
                if (measuredWidth > i3) {
                    i3 = measuredWidth;
                }
            }
        }
        int i5 = this.b;
        if (i3 < i5 || i3 > (i5 = this.f9107a)) {
            i3 = i5;
        }
        if (LogUtil.LOGGABLE && this.c) {
            Log.e("ServiceAreaRelativeLayout", "onMeasure-> currentLineWidth= " + i3);
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                if (layoutParams.width != i3) {
                    layoutParams.width = i3;
                }
            }
        }
        super.onMeasure(i, i2);
        if (LogUtil.LOGGABLE && this.c) {
            Log.e("ServiceAreaRelativeLayout", "测量完毕，width= " + getMeasuredWidth() + ", height= " + getMeasuredHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("onMeasure-> time= ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            Log.e("ServiceAreaRelativeLayout", sb.toString());
        }
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.ServiceAreaBaseRelativeLayout
    public void setMaxWidth(int i) {
        this.f9107a = i;
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.ServiceAreaBaseRelativeLayout
    public void setMinWidth(int i) {
        this.b = i;
    }

    public ServiceAreaRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
    }

    public ServiceAreaRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
    }
}
