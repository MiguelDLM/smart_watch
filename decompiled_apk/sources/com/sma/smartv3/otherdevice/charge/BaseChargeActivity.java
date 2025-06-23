package com.sma.smartv3.otherdevice.charge;

import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public abstract class BaseChargeActivity extends BaseActivity {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        setStatusBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.charge_status_bar_color));
        setNavBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.charge_nav_bar_color));
    }
}
