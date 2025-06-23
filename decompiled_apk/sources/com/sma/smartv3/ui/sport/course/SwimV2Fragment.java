package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;

/* loaded from: classes12.dex */
public final class SwimV2Fragment extends BaseNoGpsSportV2Fragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setMSportMode(11);
    }

    @Override // com.sma.smartv3.ui.sport.course.BaseNoGpsSportV2Fragment, com.sma.smartv3.ui.sport.course.BaseSportV2Fragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getIvBg().setVisibility(4);
    }
}
