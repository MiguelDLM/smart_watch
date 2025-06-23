package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class RGSettingPageShortcutFunItem extends RGShortcutFunCellView {
    public RGSettingPageShortcutFunItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.shortcut.views.RGShortcutFunCellView
    public int getLayoutId() {
        return R.layout.nsdk_layout_rg_setting_shortcut_cell;
    }

    public RGSettingPageShortcutFunItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RGSettingPageShortcutFunItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
