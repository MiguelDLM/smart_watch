package com.sma.smartv3.ui.sport;

import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class CofitSportFragment extends SportFragment {
    @Override // com.sma.smartv3.ui.sport.SportFragment, com.bestmafen.androidbase.viewpager.BaseFragmentPagerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.addMarginTopEqualStatusBarHeight(getMView().findViewById(R.id.table));
    }

    @Override // com.sma.smartv3.ui.sport.SportFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.cofit_fragment_sport;
    }
}
