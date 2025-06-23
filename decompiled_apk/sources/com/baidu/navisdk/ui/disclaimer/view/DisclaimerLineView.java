package com.baidu.navisdk.ui.disclaimer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class DisclaimerLineView extends RelativeLayout {
    public DisclaimerLineView(Context context) {
        this(context, null);
    }

    public DisclaimerLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DisclaimerLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_disclaimer_line, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DisclaimerLineView);
        String string = obtainStyledAttributes.getString(R.styleable.DisclaimerLineView_nsdk_content);
        obtainStyledAttributes.recycle();
        TextView textView = (TextView) inflate.findViewById(R.id.content);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        textView.setText(String.format("\u3000 %s", string));
    }
}
