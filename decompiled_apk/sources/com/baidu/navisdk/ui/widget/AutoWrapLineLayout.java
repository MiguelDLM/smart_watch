package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class AutoWrapLineLayout extends ViewGroup {
    private int mHorizontalSpace;
    private int mMaxLineNum;
    private int mVerticalSpace;

    public AutoWrapLineLayout(Context context) {
        super(context);
        this.mVerticalSpace = 0;
        this.mHorizontalSpace = 0;
        this.mMaxLineNum = 2;
        initParams();
    }

    private int getDesiredHeight(int i) {
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i2 = 1;
        int i3 = paddingLeft;
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i3 < measuredWidth) {
                    i2++;
                    if (i2 > this.mMaxLineNum) {
                        return paddingTop;
                    }
                    paddingTop = paddingTop + i4 + this.mVerticalSpace;
                    i3 = paddingLeft;
                    i4 = 0;
                }
                i3 = (i3 - measuredWidth) - this.mHorizontalSpace;
                i4 = Math.max(measuredHeight, i4);
            }
        }
        return paddingTop + i4;
    }

    private void initParams() {
        this.mVerticalSpace = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
        this.mHorizontalSpace = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
    }

    private void layoutHorizontal() {
        int i;
        int i2;
        int i3;
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i4 = 1;
        int i5 = measuredWidth;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if ((i5 == measuredWidth && i5 < measuredWidth2) || (i5 != measuredWidth && i5 < this.mHorizontalSpace + measuredWidth2)) {
                    int i8 = i4 + 1;
                    if (i8 > this.mMaxLineNum) {
                        return;
                    }
                    int i9 = paddingTop + i6 + this.mVerticalSpace;
                    paddingLeft = getPaddingLeft();
                    i = i9;
                    i2 = i8;
                    i3 = measuredWidth;
                    i6 = 0;
                } else {
                    i = paddingTop;
                    i2 = i4;
                    i3 = i5;
                }
                if (i3 != measuredWidth) {
                    paddingLeft += this.mHorizontalSpace;
                }
                int i10 = paddingLeft;
                setChildFrame(childAt, i10, i, measuredWidth2, measuredHeight);
                i5 = (i3 - measuredWidth2) - this.mHorizontalSpace;
                i6 = Math.max(i6, measuredHeight);
                paddingTop = i;
                i4 = i2;
                paddingLeft = i10 + measuredWidth2;
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutHorizontal();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3), i, i2);
        }
        if (mode != Integer.MIN_VALUE && mode != 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getDesiredHeight(View.MeasureSpec.getSize(i)), 1073741824));
        }
    }

    public void setHorizontalSpace(int i) {
        this.mHorizontalSpace = i;
    }

    public void setMaxLineNum(int i) {
        this.mMaxLineNum = i;
    }

    public void setVerticalSpace(int i) {
        this.mVerticalSpace = i;
    }

    public AutoWrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVerticalSpace = 0;
        this.mHorizontalSpace = 0;
        this.mMaxLineNum = 2;
        initParams();
    }

    public AutoWrapLineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVerticalSpace = 0;
        this.mHorizontalSpace = 0;
        this.mMaxLineNum = 2;
        initParams();
    }
}
