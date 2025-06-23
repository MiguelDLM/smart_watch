package com.sma.smartv3.ui.ai;

import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.ai.fragment.AIFragment;

/* loaded from: classes12.dex */
public class CofitAIFragment extends AIFragment {
    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.addMarginTopEqualStatusBarHeight(getMView().findViewById(R.id.rv));
    }
}
