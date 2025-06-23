package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class RGShortcutAllFunItem extends RGShortcutFunCellView {
    public RGShortcutAllFunItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.shortcut.views.RGShortcutFunCellView
    public int getLayoutId() {
        return R.layout.nsdk_layout_rg_shortcut_all_func_item;
    }

    public RGShortcutAllFunItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RGShortcutAllFunItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
