package com.baidu.navisdk.adapter.struct;

import android.graphics.drawable.Drawable;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;

/* loaded from: classes7.dex */
public class BNavLineItem {
    private final Drawable drawable;
    private final String resName;

    public BNavLineItem(RGLineItem rGLineItem) {
        this.resName = rGLineItem.getResName();
        this.drawable = rGLineItem.getDrawable(a.c().a());
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getResName() {
        return this.resName;
    }
}
