package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class EarphonesGuideFragment extends BaseGuideFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseGuideFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvPic().setImageResource(R.drawable.icon_earphones_guide);
        getTvTitle().setText(R.string.earphone_connect_title);
        getTvTip().setText(R.string.earphone_connect_tip);
        getBtnSet().setVisibility(4);
    }
}
