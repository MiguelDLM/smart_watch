package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class WarmTipGuideFragment extends BaseGuideFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvPic().setImageResource(R.drawable.pic_guide_warn_tip);
        getTvTitle().setText(R.string.guide_warm_title);
        getTvTip().setText(ProductManager.f20544oIX0oI.X0IIOO());
        getBtnSet().setVisibility(4);
    }
}
