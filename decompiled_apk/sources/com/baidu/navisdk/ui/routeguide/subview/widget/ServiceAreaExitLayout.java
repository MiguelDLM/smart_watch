package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class ServiceAreaExitLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9106a;

    public ServiceAreaExitLayout(Context context) {
        super(context);
        this.f9106a = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        long j;
        super.onMeasure(i, i2);
        if (this.f9106a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof ViewGroup) {
                int i5 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (i5 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View childAt2 = viewGroup.getChildAt(i5);
                    if (childAt2 instanceof TextView) {
                        childAt2.getLayoutParams().width = -2;
                        measureChild(childAt2, i, i2);
                    }
                    i5++;
                }
            }
            childAt.getLayoutParams().width = -2;
            measureChild(childAt, i, i2);
            int measuredWidth = childAt.getMeasuredWidth();
            if (this.f9106a) {
                LogUtil.e("ServiceAreaExitLayout", "onMeasure-> view" + i4 + " width= " + measuredWidth);
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        if (this.f9106a) {
            LogUtil.e("ServiceAreaExitLayout", "onMeasure-> currentLineWidth= " + i3);
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i6).getLayoutParams();
            if (layoutParams.width < i3) {
                layoutParams.width = -1;
            }
        }
        super.onMeasure(i, i2);
        if (this.f9106a) {
            LogUtil.e("ServiceAreaExitLayout", "测量完毕，width= " + getMeasuredWidth() + ", height= " + getMeasuredHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("onMeasure-> time= ");
            sb.append(System.currentTimeMillis() - j);
            LogUtil.e("ServiceAreaExitLayout", sb.toString());
        }
    }

    public ServiceAreaExitLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9106a = false;
    }

    public ServiceAreaExitLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9106a = false;
    }
}
