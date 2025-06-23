package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class RGShortcutFunImgTipCell extends RGShortcutFunCellView {
    public RGShortcutFunImgTipCell(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.shortcut.views.RGShortcutFunCellView
    public int getLayoutId() {
        return R.layout.nsdk_layout_v_img_text_righttop_imgtip;
    }

    public RGShortcutFunImgTipCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RGShortcutFunImgTipCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
