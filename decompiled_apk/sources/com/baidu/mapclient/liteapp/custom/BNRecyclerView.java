package com.baidu.mapclient.liteapp.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mapclient.liteapp.BNUtils;

/* loaded from: classes7.dex */
public class BNRecyclerView extends RecyclerView {
    public BNRecyclerView(Context context) {
        this(context, null);
    }

    private void initEvent(final Context context) {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.mapclient.liteapp.custom.BNRecyclerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = BNRecyclerView.this.getLayoutParams();
                ViewParent parent = BNRecyclerView.this.getParent();
                ViewParent viewParent = parent;
                while (true) {
                    if (viewParent == null) {
                        break;
                    }
                    if (viewParent instanceof BNScrollLayout) {
                        int i = 0;
                        if (parent instanceof LinearLayout) {
                            i = ((LinearLayout) parent).getChildAt(0).getMeasuredHeight();
                        }
                        BNScrollLayout bNScrollLayout = (BNScrollLayout) viewParent;
                        int measuredHeight = ((bNScrollLayout.getMeasuredHeight() - bNScrollLayout.minOffset) - i) - BNUtils.dip2px(context, 15.0f);
                        if (layoutParams.height == measuredHeight) {
                            return;
                        } else {
                            layoutParams.height = measuredHeight;
                        }
                    } else {
                        viewParent = viewParent.getParent();
                    }
                }
                BNRecyclerView.this.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof BNScrollLayout) {
                ((BNScrollLayout) parent).setAssociatedRecyclerView(this);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public BNRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BNRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initEvent(context);
    }
}
