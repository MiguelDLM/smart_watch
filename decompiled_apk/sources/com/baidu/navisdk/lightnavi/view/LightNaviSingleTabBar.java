package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes7.dex */
public class LightNaviSingleTabBar extends LightNaviTabBar {
    public LightNaviSingleTabBar(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setTabClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public LightNaviSingleTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LightNaviSingleTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
