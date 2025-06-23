package com.baidu.navisdk.ui.routeline;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class LaneLineView extends LinearLayout {
    public LaneLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        setBackground(getResources().getDrawable(R.drawable.bnav_rg_bg_lane_line));
    }

    private ColorDrawable getErrorColorDrawable() {
        return new ColorDrawable(5149694);
    }

    public LaneLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
