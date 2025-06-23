package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class BNTextView extends TextView implements IVisibility {
    private static final String ANIM_VISIBLE = "anim_visible";
    private static final String DEFAULT_VISIBLE = "default_visible";
    private Map<String, Boolean> mVisibleMap;

    public BNTextView(Context context) {
        super(context);
    }

    private Map<String, Boolean> getVisibleMap() {
        if (this.mVisibleMap == null) {
            this.mVisibleMap = new HashMap();
        }
        return this.mVisibleMap;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        Map<String, Boolean> visibleMap = getVisibleMap();
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        visibleMap.put(DEFAULT_VISIBLE, Boolean.valueOf(z));
        super.setVisibility(i);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisible(boolean z) {
        setVisible(DEFAULT_VISIBLE, z);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisibleByAnim(boolean z) {
        setVisible(ANIM_VISIBLE, z);
    }

    public BNTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisible(String str, boolean z) {
        boolean z2;
        getVisibleMap().put(str, Boolean.valueOf(z));
        if (!getVisibleMap().containsKey(DEFAULT_VISIBLE)) {
            getVisibleMap().put(DEFAULT_VISIBLE, Boolean.valueOf(getVisibility() == 0));
        }
        Iterator<Boolean> it = getVisibleMap().values().iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z2 = z2 && it.next().booleanValue();
            }
        }
        super.setVisibility(z2 ? 0 : 8);
    }

    public BNTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
