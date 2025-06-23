package com.huawei.openalliance.ad.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class FlowLayoutView extends ViewGroup {
    private c B;
    private int D;
    private int F;
    private int L;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f17392a;

    public FlowLayoutView(Context context) {
        this(context, null);
    }

    private void Code() {
        if (this.B == null) {
            this.B = new c();
        }
    }

    private void I() {
        int i = this.L;
        if (i > 0) {
            this.B.Code(i - this.S);
        }
        c cVar = this.B;
        if (cVar != null) {
            this.f17392a.add(cVar);
        }
        this.L = 0;
        this.B = new c();
    }

    private void V() {
        this.f17392a.clear();
        this.B = new c();
        this.L = 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = (getMeasuredWidth() - paddingLeft) - paddingTop;
        for (c cVar : this.f17392a) {
            cVar.Code(this.D, getLeft(), paddingLeft, paddingTop, measuredWidth, this.S);
            paddingTop = this.F + cVar.Code() + paddingTop;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        V();
        Code();
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? Integer.MIN_VALUE : mode), View.MeasureSpec.makeMeasureSpec(size2, mode2 != 1073741824 ? mode2 : Integer.MIN_VALUE));
            int measuredWidth = childAt.getMeasuredWidth();
            if (this.L + measuredWidth > size) {
                I();
            }
            int i5 = this.L + this.S + measuredWidth;
            this.L = i5;
            this.B.Code(i5);
            this.B.Code(childAt);
        }
        c cVar = this.B;
        if (cVar != null && !this.f17392a.contains(cVar)) {
            I();
        }
        Iterator<c> it = this.f17392a.iterator();
        while (it.hasNext()) {
            i3 += it.next().Code();
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSize(i3 + (this.F * (this.f17392a.size() - 1)) + getPaddingBottom() + getPaddingTop(), i2));
    }

    public void setDefaultDisplayMode(int i) {
        this.D = i;
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = 1;
        this.S = w.V(context, 8.0f);
        this.F = w.V(context, 8.0f);
        this.f17392a = new ArrayList();
        this.L = 0;
    }
}
