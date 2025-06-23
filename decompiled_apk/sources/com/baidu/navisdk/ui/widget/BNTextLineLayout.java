package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import java.util.List;

/* loaded from: classes8.dex */
public class BNTextLineLayout extends LinearLayout {
    private final LinearLayout mLinearLayout;

    public BNTextLineLayout(Context context) {
        this(context, null);
    }

    public void updateLayout(Context context, List<String> list) {
        updateLayout(context, list, 0, 0);
    }

    public BNTextLineLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void updateLayout(Context context, List<String> list, int i, int i2) {
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setOrientation(0);
        this.mLinearLayout.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(15);
        layoutParams.setMarginStart(20);
        for (int i3 = 0; i3 < list.size(); i3++) {
            TextView textView = new TextView(context);
            textView.setTextSize(13.0f);
            textView.setText(list.get(i3));
            textView.setGravity(16);
            textView.setIncludeFontPadding(false);
            if (i != 0) {
                textView.setTextColor(i);
            }
            if (i3 != 0) {
                textView.setLayoutParams(layoutParams);
            }
            this.mLinearLayout.addView(textView);
            if (i3 != list.size() - 1) {
                BNTextVerticalLine bNTextVerticalLine = new BNTextVerticalLine(context);
                if (i2 != 0) {
                    bNTextVerticalLine.updateViewBackground(i2);
                }
                bNTextVerticalLine.setGravity(16);
                bNTextVerticalLine.setLayoutParams(layoutParams);
                this.mLinearLayout.addView(bNTextVerticalLine);
            }
        }
    }

    public BNTextLineLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_vertical_line_layout, (ViewGroup) this, true);
        this.mLinearLayout = (LinearLayout) findViewById(R.id.text_vertical_container);
    }
}
