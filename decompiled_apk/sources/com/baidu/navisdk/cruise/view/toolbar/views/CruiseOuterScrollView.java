package com.baidu.navisdk.cruise.view.toolbar.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ui.widget.nestedscroll.OuterScrollView;

/* loaded from: classes7.dex */
public class CruiseOuterScrollView extends OuterScrollView {
    public CruiseOuterScrollView(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.ui.widget.nestedscroll.OuterScrollView
    public boolean isNeedStopScroll(int i) {
        return false;
    }

    public CruiseOuterScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CruiseOuterScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
