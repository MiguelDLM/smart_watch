package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.ads.gf;

/* loaded from: classes10.dex */
public class PPSDestView extends FrameLayout implements gf {
    public PPSDestView(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public PPSDestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSDestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
