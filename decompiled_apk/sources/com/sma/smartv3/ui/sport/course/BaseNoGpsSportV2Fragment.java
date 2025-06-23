package com.sma.smartv3.ui.sport.course;

import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public abstract class BaseNoGpsSportV2Fragment extends BaseSportV2Fragment {
    @Override // com.sma.smartv3.ui.sport.course.BaseSportV2Fragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getGpsLl().setVisibility(4);
        getIvBg().setImageResource(R.drawable.pic_indoor);
    }
}
