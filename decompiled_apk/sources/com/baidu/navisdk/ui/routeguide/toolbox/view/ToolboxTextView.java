package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class ToolboxTextView extends TextView {
    public ToolboxTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ToolboxBug", "onLayout,changed=" + z + ", left=" + i + ", top=" + i2 + ", right=" + i3 + ", bottom=" + i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void requestLayout() {
        super.requestLayout();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ToolboxBug", "requestLayout");
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ToolboxBug", "setText, text=" + charSequence.toString());
        }
    }

    public ToolboxTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToolboxTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
