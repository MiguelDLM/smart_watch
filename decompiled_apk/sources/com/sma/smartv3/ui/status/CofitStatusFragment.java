package com.sma.smartv3.ui.status;

import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class CofitStatusFragment extends MainStatusFragment {
    @Override // com.sma.smartv3.ui.status.MainStatusFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.addMarginTopEqualStatusBarHeight(getMView().findViewById(R.id.srf));
    }

    @Override // com.sma.smartv3.ui.status.MainStatusFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.cofit_fragment_srf_rv;
    }
}
