package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class LimitSettingsLayout extends LinearLayout {
    public LimitSettingsLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LimitSettingsLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_limit_settings, (ViewGroup) this, true);
    }
}
