package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import android.widget.ImageView;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class WelcomeGuideFragment extends BaseGuideFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        ImageView ivPic = getIvPic();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!ProductManager.xOOxIO(productManager, null, 1, null) && !productManager.Xo()) {
            i = R.drawable.pic_guide_welcome;
        } else {
            i = R.drawable.pic_guide_welcome_ring;
        }
        ivPic.setImageResource(i);
        getTvTitle().setText(R.string.use_reminder);
        getTvTip().setText(R.string.guide_welcome_tip);
        getBtnSet().setVisibility(4);
    }
}
