package com.sma.smartv3.ui.sport;

import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public abstract class BaseNoGpsSportFragment extends BaseSportFragment {
    @Override // com.sma.smartv3.ui.sport.BaseSportFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getGpsLl().setVisibility(4);
        getIvBg().setImageResource(R.drawable.pic_indoor);
    }
}
