package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class BNTextVerticalLine extends LinearLayout {
    private final View mView;

    public BNTextVerticalLine(Context context) {
        this(context, null);
    }

    public void setViewAlpha(float f) {
        View view = this.mView;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public void updateViewBackground(int i) {
        View view = this.mView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public BNTextVerticalLine(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BNTextVerticalLine(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_vertical_line, (ViewGroup) this, true);
        this.mView = findViewById(R.id.text_vertical_line);
    }
}
