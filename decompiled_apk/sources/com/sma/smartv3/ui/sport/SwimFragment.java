package com.sma.smartv3.ui.sport;

import android.os.Bundle;

/* loaded from: classes12.dex */
public final class SwimFragment extends BaseNoGpsSportFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setMSportMode(11);
    }

    @Override // com.sma.smartv3.ui.sport.BaseNoGpsSportFragment, com.sma.smartv3.ui.sport.BaseSportFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvBg().setVisibility(4);
    }
}
