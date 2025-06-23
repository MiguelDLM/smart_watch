package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.HeartRateDayFragment;
import com.sma.smartv3.ui.status.fragment.HeartRateMonthFragment;
import com.sma.smartv3.ui.status.fragment.HeartRateWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HeartRateActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new HeartRateDayFragment());
        setWeeFragment(new HeartRateWeekFragment());
        setMonthFragment(new HeartRateMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.heart_rate);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
