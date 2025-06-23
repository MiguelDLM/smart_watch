package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class BNFlowLayout extends ViewGroup {
    public static final String SPLIT_LINE = "split_line";
    private int maxRows;

    public BNFlowLayout(Context context) {
        this(context, null);
    }

    private Map<String, Integer> compute(int i) {
        View childAt;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        boolean z = true;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < getChildCount()) {
            View childAt2 = getChildAt(i4);
            if (i4 == 0) {
                childAt = null;
            } else {
                childAt = getChildAt(i4 - 1);
            }
            if (i3 > this.maxRows) {
                childAt2.setVisibility(8);
            } else {
                childAt2.setVisibility(i2);
                int measuredWidth = childAt2.getMeasuredWidth();
                int measuredHeight = childAt2.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                int i6 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + measuredWidth;
                int i7 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + measuredHeight;
                i5 = Math.max(i5, i7);
                if (paddingLeft + i6 + getPaddingRight() > i) {
                    i3++;
                    paddingLeft = getPaddingLeft();
                    paddingTop += i5;
                    if (i3 > this.maxRows) {
                        childAt2.setVisibility(8);
                        if (isViewSplitLine(childAt)) {
                            childAt.setVisibility(8);
                        }
                    } else {
                        if (isViewSplitLine(childAt)) {
                            childAt.setVisibility(8);
                        }
                        if (isViewSplitLine(childAt2)) {
                            childAt2.setVisibility(8);
                        } else {
                            i5 = i7;
                            z = false;
                        }
                    }
                    i5 = i7;
                    z = false;
                }
                paddingLeft += i6;
                childAt2.setTag(R.id.id_flow_layout_child_rect, new Rect((paddingLeft - i6) + marginLayoutParams.leftMargin, marginLayoutParams.topMargin + paddingTop, paddingLeft - marginLayoutParams.rightMargin, (i7 + paddingTop) - marginLayoutParams.bottomMargin));
            }
            i4++;
            i2 = 0;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("allChildWidth", Integer.valueOf(paddingLeft));
        } else {
            hashMap.put("allChildWidth", Integer.valueOf(i));
        }
        hashMap.put("allChildHeight", Integer.valueOf(paddingTop + i5 + getPaddingBottom()));
        return hashMap;
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNFlowLayout);
        this.maxRows = obtainStyledAttributes.getInt(R.styleable.BNFlowLayout_maxRows, Integer.MAX_VALUE);
        obtainStyledAttributes.recycle();
    }

    private boolean isViewSplitLine(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(R.id.id_flow_layout_split_line);
        if (!(tag instanceof String)) {
            return false;
        }
        return TextUtils.equals((String) tag, SPLIT_LINE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            Object tag = childAt.getTag(R.id.id_flow_layout_child_rect);
            if (tag instanceof Rect) {
                Rect rect = (Rect) tag;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Map<String, Integer> compute = compute(size - getPaddingRight());
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = compute.get("allChildWidth").intValue();
            } else {
                size = 0;
            }
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                size2 = compute.get("allChildHeight").intValue();
            } else {
                size2 = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public BNFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxRows = Integer.MAX_VALUE;
        initAttrs(context, attributeSet);
    }
}
