package com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNFrameLayout;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class ScrollContentView extends BNLinearLayout {
    private BNFrameLayout mContentContainer;
    private BNFrameLayout mHeadContainer;
    private int mHeight;
    private BNFrameLayout mTailContainer;

    public ScrollContentView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.nsdk_layout_scroll_content, this);
        setOrientation(1);
        this.mHeadContainer = (BNFrameLayout) findViewById(R.id.head_container);
        this.mContentContainer = (BNFrameLayout) findViewById(R.id.content_container);
        this.mTailContainer = (BNFrameLayout) findViewById(R.id.tail_container);
    }

    public void addContent(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        this.mContentContainer.removeAllViews();
        this.mContentContainer.addView(view, layoutParams);
    }

    public void addHead(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        this.mHeadContainer.removeAllViews();
        this.mHeadContainer.addView(view, layoutParams);
    }

    public void addTail(View view, FrameLayout.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        this.mTailContainer.removeAllViews();
        this.mTailContainer.addView(view, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int heightPixels = ScreenUtil.getInstance().getHeightPixels();
        if (heightPixels != 0) {
            heightPixels = this.mHeight;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(heightPixels, 1073741824));
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public ScrollContentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScrollContentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
