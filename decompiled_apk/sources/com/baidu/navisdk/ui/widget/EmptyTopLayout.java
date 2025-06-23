package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.pronavi.b;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class EmptyTopLayout extends FrameLayout {
    public EmptyTopLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        b h = c.p().h();
        if (h != null) {
            z = h.b0().g();
        } else {
            z = true;
        }
        if (z) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ScreenUtil.getInstance().getStatusBarHeightFullScreen(getContext()), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public EmptyTopLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyTopLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
